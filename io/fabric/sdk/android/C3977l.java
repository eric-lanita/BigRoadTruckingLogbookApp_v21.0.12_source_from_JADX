package io.fabric.sdk.android;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.services.common.C4001g;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.C4046b;
import io.fabric.sdk.android.services.settings.C4053d;
import io.fabric.sdk.android.services.settings.C4054e;
import io.fabric.sdk.android.services.settings.C4057h;
import io.fabric.sdk.android.services.settings.C4066n;
import io.fabric.sdk.android.services.settings.C4071q;
import io.fabric.sdk.android.services.settings.C4072s;
import io.fabric.sdk.android.services.settings.C4075x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class C3977l extends C2822h<Boolean> {
    private final C4045c f14077a = new C4046b();
    private PackageManager f14078b;
    private String f14079c;
    private PackageInfo f14080d;
    private String f14081k;
    private String f14082l;
    private String f14083m;
    private String f14084n;
    private String f14085o;
    private final Future<Map<String, C3976j>> f14086p;
    private final Collection<C2822h> f14087q;

    protected /* synthetic */ Object mo1429f() {
        return m20641d();
    }

    public C3977l(Future<Map<String, C3976j>> future, Collection<C2822h> collection) {
        this.f14086p = future;
        this.f14087q = collection;
    }

    public String mo1426a() {
        return "1.3.17.dev";
    }

    protected boolean h_() {
        try {
            this.f14083m = m15969q().m20743j();
            this.f14078b = m15970r().getPackageManager();
            this.f14079c = m15970r().getPackageName();
            this.f14080d = this.f14078b.getPackageInfo(this.f14079c, 0);
            this.f14081k = Integer.toString(this.f14080d.versionCode);
            this.f14082l = this.f14080d.versionName == null ? "0.0" : this.f14080d.versionName;
            this.f14084n = this.f14078b.getApplicationLabel(m15970r().getApplicationInfo()).toString();
            this.f14085o = Integer.toString(m15970r().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean m20641d() {
        boolean a;
        String k = CommonUtils.m20724k(m15970r());
        C4072s g = m20637g();
        if (g != null) {
            try {
                Map map;
                if (this.f14086p != null) {
                    map = (Map) this.f14086p.get();
                } else {
                    map = new HashMap();
                }
                a = m20634a(k, g.f14335a, m20639a(map, this.f14087q).values());
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Fabric", "Error performing auto configuration.", e);
            }
            return Boolean.valueOf(a);
        }
        a = false;
        return Boolean.valueOf(a);
    }

    private C4072s m20637g() {
        try {
            C4071q.m20977a().m20979a(this, this.i, this.f14077a, this.f14081k, this.f14082l, m20642e()).m20981c();
            return C4071q.m20977a().m20980b();
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, C3976j> m20639a(Map<String, C3976j> map, Collection<C2822h> collection) {
        for (C2822h c2822h : collection) {
            if (!map.containsKey(c2822h.mo1427b())) {
                map.put(c2822h.mo1427b(), new C3976j(c2822h.mo1427b(), c2822h.mo1426a(), "binary"));
            }
        }
        return map;
    }

    public String mo1427b() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean m20634a(String str, C4054e c4054e, Collection<C3976j> collection) {
        if ("new".equals(c4054e.f14293b)) {
            if (m20635b(str, c4054e, collection)) {
                return C4071q.m20977a().m20982d();
            }
            C3969c.m20576h().mo2857e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(c4054e.f14293b)) {
            return C4071q.m20977a().m20982d();
        } else {
            if (!c4054e.f14296e) {
                return true;
            }
            C3969c.m20576h().mo2849a("Fabric", "Server says an update is required - forcing a full App update.");
            m20636c(str, c4054e, collection);
            return true;
        }
    }

    private boolean m20635b(String str, C4054e c4054e, Collection<C3976j> collection) {
        return new C4057h(this, m20642e(), c4054e.f14294c, this.f14077a).mo2890a(m20632a(C4066n.m20975a(m15970r(), str), (Collection) collection));
    }

    private boolean m20636c(String str, C4054e c4054e, Collection<C3976j> collection) {
        return m20633a(c4054e, C4066n.m20975a(m15970r(), str), (Collection) collection);
    }

    private boolean m20633a(C4054e c4054e, C4066n c4066n, Collection<C3976j> collection) {
        return new C4075x(this, m20642e(), c4054e.f14294c, this.f14077a).mo2890a(m20632a(c4066n, (Collection) collection));
    }

    private C4053d m20632a(C4066n c4066n, Collection<C3976j> collection) {
        return new C4053d(new C4001g().m20770a(m15970r()), m15969q().m20736c(), this.f14082l, this.f14081k, CommonUtils.m20699a(CommonUtils.m20726m(r0)), this.f14084n, DeliveryMechanism.m20728a(this.f14083m).m20729a(), this.f14085o, AppEventsConstants.EVENT_PARAM_VALUE_NO, c4066n, collection);
    }

    String m20642e() {
        return CommonUtils.m20711b(m15970r(), "com.crashlytics.ApiEndpoint");
    }
}
