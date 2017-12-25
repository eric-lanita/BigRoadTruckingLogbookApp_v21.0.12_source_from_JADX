package com.bigroad.ttb.android.maps;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.logging.C2138i;
import com.bigroad.ttb.android.maps.C2165f.C2163a;
import com.bigroad.ttb.android.maps.C2170e.C2169a;
import com.google.android.gms.maps.model.LatLng;

public class C2166a extends C2165f implements C2158c {
    private C2164a f7538b = new C2164a(this);
    private C2167b f7539c;

    private class C2164a extends C2163a {
        final /* synthetic */ C2166a f7534a;
        private final C2474y f7535c = OurApplication.m6285g();
        private volatile C2169a f7536d;

        class C21612 implements Runnable {
            final /* synthetic */ C2164a f7532a;

            C21612(C2164a c2164a) {
                this.f7532a = c2164a;
            }

            public void run() {
                this.f7532a.f7534a.f7539c.mo1333b();
            }
        }

        public C2164a(C2166a c2166a) {
            this.f7534a = c2166a;
            super(c2166a);
        }

        @JavascriptInterface
        public String getLastMapType() {
            return this.f7535c.m12233w();
        }

        @JavascriptInterface
        public void setViewTarget(double d, double d2, float f) {
            this.f7536d = new C2169a(d, d2, f);
            C2134e.m10673a("TT-JsMapView", "Updated map " + C2138i.m10692a(this.f7534a) + " target: " + C2138i.m10691a(this.f7536d.m10779a()) + ", zoom: " + f);
        }

        @JavascriptInterface
        public void setHomeButtonVisible(final boolean z) {
            Handler handler = this.f7534a.getHandler();
            if (handler != null) {
                handler.post(new Runnable(this) {
                    final /* synthetic */ C2164a f7531b;

                    public void run() {
                        this.f7531b.f7534a.f7539c.mo1332a(z);
                    }
                });
            }
        }

        @JavascriptInterface
        public void mapLoaded() {
            if (this.f7534a.f7539c != null) {
                Handler handler = this.f7534a.getHandler();
                if (handler != null) {
                    handler.post(new C21612(this));
                }
            }
        }

        public C2169a getViewTarget() {
            return this.f7536d;
        }
    }

    public C2166a(Context context) {
        super(context);
    }

    protected String getMapURL() {
        return "file:///android_asset/map.html";
    }

    public void setMapReadyCallback(C2167b c2167b) {
        this.f7539c = c2167b;
    }

    protected void mo1256a(WebView webView, String str) {
        super.mo1256a(webView, str);
        this.f7539c.mo1331a();
    }

    protected C2164a getJavascriptInterface() {
        return this.f7538b;
    }

    public void mo1251a(Location location, float f) {
        m10767a("onLocationChanged", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Float.valueOf(location.getAccuracy()), Float.valueOf(f), Float.valueOf(location.getSpeed()));
    }

    public void mo1250a(Location location) {
        m10767a("externalRecenter", new Object[0]);
    }

    public void mo1252a(MapType mapType) {
        C2134e.m10676b("TT-JsMapView", "Switching to map type: " + mapType + " in JavascriptMapView.");
        switch (mapType) {
            case MAP:
                m10767a("externalSwitchToMap", new Object[0]);
                return;
            case SATELLITE:
                m10767a("externalSwitchToSatellite", new Object[0]);
                return;
            case NIGHT:
                m10767a("externalSwitchToNight", new Object[0]);
                return;
            default:
                return;
        }
    }

    public void mo1249a() {
        m10767a("externalZoomIn", new Object[0]);
    }

    public void mo1253b() {
        m10767a("externalZoomOut", new Object[0]);
    }

    public void setViewTarget(C2169a c2169a) {
        if (c2169a != null && this.a) {
            LatLng a = c2169a.m10779a();
            int round = Math.round(c2169a.m10780b());
            m10767a("externalSetViewTarget", Double.valueOf(a.latitude), Double.valueOf(a.longitude), Integer.valueOf(round));
        }
    }

    public C2169a getViewTarget() {
        return this.f7538b.getViewTarget();
    }

    private void m10767a(String str, Object... objArr) {
        if (this.a) {
            StringBuilder append = new StringBuilder().append("javascript:").append(str).append("(");
            for (int i = 0; i < objArr.length; i++) {
                if (i > 0) {
                    append.append(",");
                }
                append.append(objArr[i]);
            }
            append.append(")");
            loadUrl(append.toString());
        }
    }
}
