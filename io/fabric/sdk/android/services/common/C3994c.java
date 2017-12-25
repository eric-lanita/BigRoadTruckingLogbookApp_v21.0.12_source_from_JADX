package io.fabric.sdk.android.services.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.p057c.C3989c;
import io.fabric.sdk.android.services.p057c.C3990d;

class C3994c {
    private final Context f14153a;
    private final C3989c f14154b;

    public C3994c(Context context) {
        this.f14153a = context.getApplicationContext();
        this.f14154b = new C3990d(context, "TwitterAdvertisingInfoPreferences");
    }

    public C3992b m20755a() {
        C3992b b = m20756b();
        if (m20753c(b)) {
            C3969c.m20576h().mo2849a("Fabric", "Using AdvertisingInfo from Preference Store");
            m20750a(b);
            return b;
        }
        b = m20754e();
        m20752b(b);
        return b;
    }

    private void m20750a(final C3992b c3992b) {
        new Thread(new C2888h(this) {
            final /* synthetic */ C3994c f14152b;

            public void mo1461a() {
                C3992b a = this.f14152b.m20754e();
                if (!c3992b.equals(a)) {
                    C3969c.m20576h().mo2849a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    this.f14152b.m20752b(a);
                }
            }
        }).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    private void m20752b(C3992b c3992b) {
        if (m20753c(c3992b)) {
            this.f14154b.mo2879a(this.f14154b.mo2880b().putString("advertising_id", c3992b.f14149a).putBoolean("limit_ad_tracking_enabled", c3992b.f14150b));
        } else {
            this.f14154b.mo2879a(this.f14154b.mo2880b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    protected C3992b m20756b() {
        return new C3992b(this.f14154b.mo2878a().getString("advertising_id", ""), this.f14154b.mo2878a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public C3995f m20757c() {
        return new C3996d(this.f14153a);
    }

    public C3995f m20758d() {
        return new C4000e(this.f14153a);
    }

    private boolean m20753c(C3992b c3992b) {
        return (c3992b == null || TextUtils.isEmpty(c3992b.f14149a)) ? false : true;
    }

    private C3992b m20754e() {
        C3992b a = m20757c().mo2881a();
        if (m20753c(a)) {
            C3969c.m20576h().mo2849a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = m20758d().mo2881a();
            if (m20753c(a)) {
                C3969c.m20576h().mo2849a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                C3969c.m20576h().mo2849a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
