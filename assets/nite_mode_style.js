var bigroad = {};

bigroad.map = {
    NIGHT_MODE_MAP_TYPE_ID : "nitemap"
};

var g_nightModeStyle = [
    {
        stylers: [
            { invert_lightness: true }
        ]
    },{
        featureType: "road",
        elementType: "geometry",
        stylers: [
            { hue: "#00b2ff" },
            { lightness: 6 }
        ]
    },{
        featureType: "road.local",
        elementType: "geometry",
        stylers: [
            { hue: "#004cff" },
            { saturation: -100 },
            { lightness: 36 }
        ]
    },{
        featureType: "water",
        stylers: [
            { lightness: 19 },
            { hue: "#00d4ff" }
        ]
    },{
        featureType: "poi",
        stylers: [
            { hue: "#00ff19" },
            { lightness: -11 }
        ]
    },{
        featureType: "poi",
        elementType: "labels",
        stylers: [
            { gamma: 2.91 },
            { hue: "#00ff19" },
            { saturation: -11 },
            { lightness: -10 }
        ]
    },{
        featureType: "road",
        elementType: "labels",
        stylers: [
            { hue: "#0091ff" },
            { gamma: 0.65 },
            { saturation: -60 },
            { lightness: 23 }
        ]
    },{
        featureType: "transit",
        elementType: "geometry",
        stylers: [
            { hue: "#11ff00" },
            { lightness: 30 },
            { saturation: 36 }
        ]
    },{
        featureType: "transit",
        elementType: "labels",
        stylers: [
            { hue: "#00ff19" },
            { lightness: -5 },
            { gamma: 0.89 }
        ]
    },{
        featureType: "landscape",
        elementType: "geometry",
        stylers: [
            { hue: "#00ff19" }
        ]
    },{
        featureType: "administrative.land_parcel",
        elementType: "geometry",
        stylers: [
            { visibility: "off" }
        ]
    }
];

