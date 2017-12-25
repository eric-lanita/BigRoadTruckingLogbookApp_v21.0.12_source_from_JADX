function getMapOptions(latlngBounds) {
    return {
        zoom : 13,
        center : latlngBounds.getCenter(),
        mapTypeId : google.maps.MapTypeId.ROADMAP,
        zoomControl : true,
        backgroundColor : "#444444",
        streetViewControl : false,
        disableDefaultUI : true
    };
}

function initMap(map, mapElement, latlng, bearing) {
    g_currentPositionMarker = new google.maps.Marker({
        position : latlng,
        map : map
    });
}

function setLocation(latitude, longitude) {
    if (!checkGoogleMapsLoaded()) return;

    var latlng = new google.maps.LatLng(latitude, longitude);
    if (g_map == null) {
        loadMap(latlng, 0);
    } else {
        g_map.setCenter(latlng);
        if (g_currentPositionMarker != null) {
            g_currentPositionMarker.setPosition(latlng);
        }
    }
}

function onLocationChanged(lat, lng, accuracy, bearing, speed) {
    setLocation(lat, lng);
}

google.maps.event.addDomListener(window, "resize", function() {
    //console.log("Resize (" + window.innerWidth + "," + window.innerHeight + ")");
    /*
     * Ensure the bounds & center of the map remain correct.  In particular, sometimes the
     * WebView starts out with a 0 width or height and resizes itself to the final height.
     */
    if (g_map != null && g_currentPositionMarker != null) {
        google.maps.event.trigger(g_map, 'resize');
        var latlng = g_currentPositionMarker.getPosition();
        var latlngBounds = new google.maps.LatLngBounds(latlng);
        extendBounds(latlngBounds);
        g_map.fitBounds(latlngBounds);
        g_map.setCenter(g_currentPositionMarker.getPosition());
    }
});
