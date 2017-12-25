package com.bigroad.ttb.android.maps;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class C2170e {

    public static class C2169a {
        private final LatLng f7541a;
        private final float f7542b;

        public C2169a(double d, double d2, float f) {
            this(new LatLng(d, d2), f);
        }

        public C2169a(LatLng latLng, float f) {
            this.f7541a = latLng;
            this.f7542b = f;
        }

        public LatLng m10779a() {
            return this.f7541a;
        }

        public float m10780b() {
            return this.f7542b;
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append("Center={ ");
            if (this.f7541a == null) {
                append.append("null");
            } else {
                append.append(this.f7541a.latitude).append(", ").append(this.f7541a.longitude);
            }
            append.append(" }; Zoom={ ").append(this.f7542b).append(" }");
            return append.toString();
        }
    }

    public static boolean m10788a(LatLng latLng, LatLngBounds latLngBounds, double d) {
        return C2170e.m10787a(latLngBounds, d).contains(latLng);
    }

    public static LatLngBounds m10787a(LatLngBounds latLngBounds, double d) {
        LatLng center = latLngBounds.getCenter();
        return new LatLngBounds(C2170e.m10786a(center, latLngBounds.southwest, d), C2170e.m10786a(center, latLngBounds.northeast, d));
    }

    public static LatLng m10785a(Location location) {
        return new LatLng(location.getLatitude(), location.getLongitude());
    }

    public static LatLng m10786a(LatLng latLng, LatLng latLng2, double d) {
        double toRadians = Math.toRadians(latLng.latitude);
        double toRadians2 = Math.toRadians(latLng.longitude);
        double toRadians3 = Math.toRadians(latLng2.latitude);
        double toRadians4 = Math.toRadians(latLng2.longitude);
        double cos = Math.cos(toRadians);
        double cos2 = Math.cos(toRadians3);
        double a = C2170e.m10784a(latLng, latLng2);
        double sin = Math.sin(a);
        if (sin < 1.0E-6d) {
            return latLng;
        }
        double sin2 = Math.sin((1.0d - d) * a) / sin;
        a = Math.sin(a * d) / sin;
        sin = ((sin2 * cos) * Math.cos(toRadians2)) + ((a * cos2) * Math.cos(toRadians4));
        toRadians2 = (Math.sin(toRadians2) * (cos * sin2)) + (Math.sin(toRadians4) * (a * cos2));
        return new LatLng(Math.toDegrees(Math.atan2((Math.sin(toRadians) * sin2) + (Math.sin(toRadians3) * a), Math.sqrt((sin * sin) + (toRadians2 * toRadians2)))), Math.toDegrees(Math.atan2(toRadians2, sin)));
    }

    private static double m10783a(double d, double d2, double d3, double d4) {
        return C2170e.m10781a(C2170e.m10782a(d, d3, d2 - d4));
    }

    static double m10781a(double d) {
        return 2.0d * Math.asin(Math.sqrt(d));
    }

    static double m10784a(LatLng latLng, LatLng latLng2) {
        return C2170e.m10783a(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
    }

    static double m10782a(double d, double d2, double d3) {
        return C2170e.m10789b(d - d2) + ((C2170e.m10789b(d3) * Math.cos(d)) * Math.cos(d2));
    }

    static double m10789b(double d) {
        double sin = Math.sin(0.5d * d);
        return sin * sin;
    }
}
