package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.C3969c;

class C3996d implements C3995f {
    private final Context f14155a;

    public C3996d(Context context) {
        this.f14155a = context.getApplicationContext();
    }

    boolean m20764a(Context context) {
        try {
            if (((Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke(null, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public C3992b mo2881a() {
        if (m20764a(this.f14155a)) {
            return new C3992b(m20760b(), m20761c());
        }
        return null;
    }

    private String m20760b() {
        try {
            return (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(m20762d(), new Object[0]);
        } catch (Exception e) {
            C3969c.m20576h().mo2854d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean m20761c() {
        try {
            return ((Boolean) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(m20762d(), new Object[0])).booleanValue();
        } catch (Exception e) {
            C3969c.m20576h().mo2854d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object m20762d() {
        Object obj = null;
        try {
            obj = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(null, new Object[]{this.f14155a});
        } catch (Exception e) {
            C3969c.m20576h().mo2854d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
        }
        return obj;
    }
}
