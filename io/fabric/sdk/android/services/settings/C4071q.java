package io.fabric.sdk.android.services.settings;

import android.content.Context;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4001g;
import io.fabric.sdk.android.services.common.C4016p;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.C4045c;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class C4071q {
    private final AtomicReference<C4072s> f14331a;
    private final CountDownLatch f14332b;
    private C4059r f14333c;
    private boolean f14334d;

    static class C4070a {
        private static final C4071q f14330a = new C4071q();
    }

    public static C4071q m20977a() {
        return C4070a.f14330a;
    }

    private C4071q() {
        this.f14331a = new AtomicReference();
        this.f14332b = new CountDownLatch(1);
        this.f14334d = false;
    }

    public synchronized C4071q m20979a(C2822h c2822h, IdManager idManager, C4045c c4045c, String str, String str2, String str3) {
        C4071q c4071q;
        if (this.f14334d) {
            c4071q = this;
        } else {
            if (this.f14333c == null) {
                Context r = c2822h.m15970r();
                String c = idManager.m20736c();
                String a = new C4001g().m20770a(r);
                String j = idManager.m20743j();
                C4016p c4016p = new C4016p();
                C4062k c4062k = new C4062k();
                C4058i c4058i = new C4058i(c2822h);
                String k = CommonUtils.m20724k(r);
                C2822h c2822h2 = c2822h;
                String str4 = str3;
                C4064l c4064l = new C4064l(c2822h2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), c4045c);
                j = str2;
                String str5 = str;
                this.f14333c = new C4060j(c2822h, new C4074v(a, idManager.m20740g(), idManager.m20739f(), idManager.m20738e(), idManager.m20746m(), idManager.m20735b(), idManager.m20747n(), CommonUtils.m20699a(CommonUtils.m20726m(r)), j, str5, DeliveryMechanism.m20728a(j).m20729a(), k), c4016p, c4062k, c4058i, c4064l);
            }
            this.f14334d = true;
            c4071q = this;
        }
        return c4071q;
    }

    public C4072s m20980b() {
        try {
            this.f14332b.await();
            return (C4072s) this.f14331a.get();
        } catch (InterruptedException e) {
            C3969c.m20576h().mo2856e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean m20981c() {
        C4072s a;
        a = this.f14333c.mo2893a();
        m20978a(a);
        return a != null;
    }

    public synchronized boolean m20982d() {
        C4072s a;
        a = this.f14333c.mo2894a(SettingsCacheBehavior.SKIP_CACHE_LOOKUP);
        m20978a(a);
        if (a == null) {
            C3969c.m20576h().mo2857e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    private void m20978a(C4072s c4072s) {
        this.f14331a.set(c4072s);
        this.f14332b.countDown();
    }
}
