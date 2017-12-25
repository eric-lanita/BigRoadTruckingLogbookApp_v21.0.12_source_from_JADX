if (g_usingStubs) {
    // Not running on android (testing in a local browser, for example)
    // so add some testing stubs
    android.getLastMapType = function() { return "roadmap"; };
    android.setViewTarget = function() {};
    android.setHomeButtonVisible = function() {};
    android.mapLoaded = function() {};
}

/** @const */
var g_trafficLayer = new google.maps.TrafficLayer();
/** @type {google.maps.Circle} */
var g_accuracyCircle = null;
/** @const */
var NUM_BEARING_IMAGES = 36;
/**
 * @const
 * @type {Array.<google.maps.Icon>}
 */
var g_currentPositionIcons = new Array(NUM_BEARING_IMAGES + 1);
/** @const */
var MIN_ANIMATION_PIXELS = 3;
/**
 * Period in milliseconds between cycling the circle object's visibility to clear any lingering
 * afterimages (horrible kludge for Android 4.1+ WebView).
 * @const
 */
var CIRCLE_REDRAW_INTERVAL = 1000;
/** @const */
var ANIMATION_FPS = 20;
/** @type {Animator} */
var g_animator = null;
/** @type {boolean} */
var g_isNightMode = false;

/**
 * @param {string} url the URL of the image or sprite sheet
 * @param {google.maps.Size} size the display size of the image
 * @param {google.maps.Point} anchor the position at which to anchor the image to its position on
 *                            the map
 * @implements {google.maps.Icon}
 * @constructor
 */
var OurIcon = function(url, size, anchor) {
    this.url = url;
    this.size = size;
    this.anchor = anchor;
    this.origin = undefined;
    this.scaledSize = undefined;
    this.labelOrigin = undefined;
};

/**
 * @constructor
 */
var Animator = function(map, latlng) {
    var that = this;
    this.animationCallback = function() {
        that.step();
    };

    this.map = map;

    this.overlayView = new google.maps.OverlayView();
    this.overlayView.draw = function() {};
    this.overlayView.setMap(map);

    this.position = latlng;
    this.destination = latlng;
    this.completedFrames = 0;
    this.totalFrames = ANIMATION_FPS;
    this.wait = 1000 / ANIMATION_FPS;
    this.timeoutId = -1;

    // Kludge for circle redraw glitches.
    this.lastCircleRedraw = 0;
};

Animator.prototype.getProjection = function() {
    return this.overlayView.getProjection();
};

/**
 * Move accuracy circle and current position marker in lockstep.
 */
Animator.prototype.setMarkerPosition = function(latlng) {
    var wasVisible = markerIsVisible();

    g_currentPositionMarker.setPosition(latlng);

    // Kludge for circle redraw glitches on Android 4.1+
    var circleVisible = g_accuracyCircle.getVisible();
    var now = new Date().getTime();
    var needCircleRedraw = now - this.lastCircleRedraw >= CIRCLE_REDRAW_INTERVAL;
    if (needCircleRedraw) {
        this.lastCircleRedraw = now;
        g_accuracyCircle.setVisible(false);
    }
    g_accuracyCircle.setCenter(latlng);
    if (needCircleRedraw) {
        g_accuracyCircle.setVisible(circleVisible);
    }

    if (wasVisible && !markerIsNearMiddle(0.7)) {
        this.map.panTo(latlng);
    }
};

// Starts the animation if not already running.
Animator.prototype.update = function(latlng) {
    this.cancelAnimation();

    if (!markerIsVisible()) {
        // No need to animate the marker's path if it's off-screen.
        this.setMarkerPosition(latlng);
        return;
    }

    var currentLatlng = g_currentPositionMarker.getPosition();
    var projection = this.getProjection();
    if (projection != null) {
        var currentCoords = projection.fromLatLngToContainerPixel(currentLatlng);
        var newCoords = projection.fromLatLngToContainerPixel(latlng);
        var dx = newCoords.x - currentCoords.x;
        var dy = newCoords.y - currentCoords.y;
        if (dx * dx + dy * dy < MIN_ANIMATION_PIXELS * MIN_ANIMATION_PIXELS) {
            // Don't animate marker if it is moving a tiny amount.
            this.setMarkerPosition(latlng);
            return;
        }
    }

    this.position = currentLatlng;
    this.destination = latlng;
    this.completedFrames = 0;

    this.timeoutId = setTimeout(this.animationCallback, this.wait);
};

// Returns (true/false) if there is a pending timeout on an Animation.
Animator.prototype.isAnimating = function() {
    return this.timeoutId !== -1;
};

// Cancels the current animation.
Animator.prototype.cancelAnimation = function() {
    if (this.isAnimating()) {
        clearTimeout(this.timeoutId);
        this.timeoutId = -1;
    }
};

// Moves the marker for the next frame.
Animator.prototype.step = function() {
    this.completedFrames += 1;

    var newPosition = google.maps.geometry.spherical.interpolate(
            this.position,
            this.destination,
            this.completedFrames / this.totalFrames);
    this.setMarkerPosition(newPosition);

    if (this.completedFrames < this.totalFrames) {
        this.timeoutId = setTimeout(this.animationCallback, this.wait);
    } else {
        this.timeoutId = -1;
    }
};

// Centers the map on when resuming (From settings, logs, ...).
Animator.prototype.center = function() {
    this.cancelAnimation();
    this.setMarkerPosition(this.destination);
    g_map.setCenter(this.destination);
};

function externalRecenter() {
    if (g_animator != null) {
        g_animator.center();
    }
}

function updateNightModeStatus(mapTypeName) {
    var isNightMode = (mapTypeName === bigroad.map.NIGHT_MODE_MAP_TYPE_ID);
    if (g_isNightMode !== isNightMode) {
        document.getElementById("map").className = g_isNightMode ? "map" : "map nightMode";
        g_isNightMode = isNightMode;
    }
}

/**
 * Update the google map to start using the given type.
 */
function updateGoogleMapTypeId(mapTypeName) {
    if (g_map != null) {
        g_map.setMapTypeId(mapTypeName);
    }

    // Disable traffic for night mode since it doesn't render properly
    if (g_isNightMode) {
        g_trafficLayer.setMap(null);
    } else {
        g_trafficLayer.setMap(g_map);
    }
}

function externalSwitchToMap() {
    setMapType(google.maps.MapTypeId.ROADMAP);
}

function externalSwitchToSatellite() {
    setMapType(google.maps.MapTypeId.HYBRID);
}

function externalSwitchToNight() {
    setMapType(bigroad.map.NIGHT_MODE_MAP_TYPE_ID);
}

function externalZoomIn() {
    if (g_map != null) {
        g_map.setZoom(g_map.getZoom() + 1);
    }
}

function externalZoomOut() {
    if (g_map != null) {
        g_map.setZoom(g_map.getZoom() - 1);
    }
}

function setMapType(mapTypeName) {
    updateNightModeStatus(mapTypeName);
    updateGoogleMapTypeId(mapTypeName);
}

function externalSetViewTarget(lat, lng, zoom) {
    if (g_map != null) {
        g_map.setCenter(new google.maps.LatLng(lat, lng));
        g_map.setZoom(zoom);
    }
}

function storeViewTarget() {
    var center = g_map.getCenter();
    android.setViewTarget(center.lat(), center.lng(), g_map.getZoom());
}

function checkMarkerVisibility() {
    android.setHomeButtonVisible(!markerIsVisible());
}

function getMapOptions(latlngBounds) {
    return {
        zoom : 12,
        center : latlngBounds.getCenter(),
        mapTypeId : google.maps.MapTypeId.ROADMAP,
        zoomControl : false,
        backgroundColor : "#444444",
        streetViewControl : false,
        disableDefaultUI : true
    };
}

function initMap(map, mapElement, latlng, bearingImageIndex) {
    var nightModeMapType = new google.maps.StyledMapType(g_nightModeStyle,
            { name: "BGNite" });
    map.mapTypes.set(bigroad.map.NIGHT_MODE_MAP_TYPE_ID, nightModeMapType);

    setMapType(android.getLastMapType());

    var iconSize = new google.maps.Size(40, 40);
    var iconAnchor = new google.maps.Point(20, 20);
    for (var i = 0; i < NUM_BEARING_IMAGES; ++i) {
        g_currentPositionIcons[i] = new OurIcon("file:///android_asset/arrow/" + i + ".png",
                iconSize, iconAnchor);
    }
    g_currentPositionIcons[NUM_BEARING_IMAGES] =
            new OurIcon("file:///android_asset/current-position-mdpi.png", iconSize, iconAnchor);

    g_currentPositionMarker = new google.maps.Marker({
        position : latlng,
        icon : g_currentPositionIcons[bearingImageIndex],
        optimized : false,
        map : map
    });

    // NOTE: Use "idle" here to check after all animation is done, since
    // scrolling includes velocity which keeps going after the dragging ends
    google.maps.event.addListener(map, "idle", checkMarkerVisibility);
    google.maps.event.addListener(map, "idle", storeViewTarget);

    g_accuracyCircle = new google.maps.Circle({
        map : map,
        clickable : false,
        visible : false,
        fillColor : "#3BB9FF",
        fillOpacity : 0.18,
        strokeColor : "#3BB9FF",
        strokeOpacity : 1.0,
        strokeWeight : 1
    });

    g_animator = new Animator(map, latlng);
}

function updatePosition(latlng, accuracy, bearingImageIndex) {
    g_animator.update(latlng);

    if (accuracy > 10) {
        g_accuracyCircle.setRadius(accuracy);
        g_accuracyCircle.setVisible(true);
    } else {
        g_accuracyCircle.setVisible(false);
    }

    g_currentPositionMarker.setIcon(g_currentPositionIcons[bearingImageIndex]);
}

function onLocationChanged(latitude, longitude, accuracy, bearing, speed) {
    if (!checkGoogleMapsLoaded()) return;

    var latlng = new google.maps.LatLng(latitude, longitude);

    // When we have unknown bearing or low speed, use a dot.
    var bearingImageIndex = NUM_BEARING_IMAGES;
    if (bearing != null && speed >= 5) {
        bearingImageIndex = Math.round((bearing + 360) / 10) % NUM_BEARING_IMAGES;
    }

    if (g_map == null) {
        loadMap(latlng, bearingImageIndex);
        android.mapLoaded();
    } else {
        updatePosition(latlng, accuracy, bearingImageIndex);
    }
}

google.maps.event.addDomListener(window, "resize", function() {
    google.maps.event.trigger(g_map, 'resize');
    android.mapLoaded();
});
