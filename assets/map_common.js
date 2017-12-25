/**
 * This file contains the common code used by OurMapView to render google maps
 * in WebView containers.
 *
 * Specific instances of maps must implement the following functions used
 * in this file:
 *
 * getMapOptions(latlngBounds)
 * initMap(map, mapElement, latlng, bearing)
 * onLocationChanged(latitude, longitude, accuracy, bearing, speed)
 *
 */

/** @type {boolean} test if we're running on a device or not */
var g_usingStubs = false;
if (typeof android === "undefined") {
    // Not running on android (testing in a local browser, for example)
    // so add some testing stubs
    android = {};
    g_usingStubs = true;
    console.log("Using android stubs");
}

var g_reloadTimeout = null;
/** @type {google.maps.Map} */
var g_map = null;
/** @type {google.maps.Marker} */
var g_currentPositionMarker = null;

function extendBounds(latlngBounds) {
    var radius = 1500;
    var center = latlngBounds.getCenter();
    for (var heading = 0; heading < 360; heading += 90) {
        var latlng = google.maps.geometry.spherical.computeOffset(center, radius, heading);
        latlngBounds.extend(latlng);
    }
}

/*
 * Returns a LatLngBounds object centered on the same point as the specified one, but with
 * width and height the specified fraction of the original.  Fraction must be between 0 and 1.
 */
function getSubBounds(latlngBounds, fraction) {
    var center = latlngBounds.getCenter();
    var oldSW = latlngBounds.getSouthWest();
    var oldNE = latlngBounds.getNorthEast();
    var newSW = google.maps.geometry.spherical.interpolate(center, oldSW, fraction);
    var newNE = google.maps.geometry.spherical.interpolate(center, oldNE, fraction);
    return new google.maps.LatLngBounds(newSW, newNE);
}

function markerIsVisible() {
    if (g_map == null || g_currentPositionMarker == null || g_map.getBounds() == null) {
        return false;
    }
    return g_map.getBounds().contains(
            g_currentPositionMarker.getPosition());
}

function markerIsNearMiddle(fraction) {
    if (g_map == null || g_currentPositionMarker == null || g_map.getBounds() == null) {
        return false;
    }
    return getSubBounds(g_map.getBounds(), fraction).contains(
            g_currentPositionMarker.getPosition());
}


function loadMap(latlng, bearing) {
    var mapElement = document.getElementById("map");
    var latlngBounds = new google.maps.LatLngBounds(latlng);
    extendBounds(latlngBounds);

    g_map = new google.maps.Map(mapElement, getMapOptions(latlngBounds));

    initMap(g_map, mapElement, latlng, bearing);
    g_map.fitBounds(latlngBounds);
    g_map.setCenter(latlng);
}

function reloadWindow() {
    console.log("reloading!");
    window.location.reload();
}

function checkGoogleMapsLoaded() {
    if (typeof google === "undefined") {
        // Google maps didn't load.
        if (g_reloadTimeout == null) {
            console.log("setting reload timer");
            g_reloadTimeout = setTimeout(reloadWindow, 10000);
        }
        return false;
    }
    return true;
}

function onLoad() {
    //console.log("Initial Size (" + window.innerWidth + "," + window.innerHeight + ")");
    checkGoogleMapsLoaded();
    if (g_usingStubs) {
        // Fake a position
        onLocationChanged(43.46426, -80.52041, 10, 0, 0);
    }
}
