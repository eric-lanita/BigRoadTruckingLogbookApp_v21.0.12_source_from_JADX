package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.C3976j;
import io.fabric.sdk.android.services.common.C2826a;
import io.fabric.sdk.android.services.common.C4015o;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

abstract class C4050a extends C2826a {
    public C4050a(C2822h c2822h, String str, String str2, C4045c c4045c, HttpMethod httpMethod) {
        super(c2822h, str, str2, c4045c, httpMethod);
    }

    public boolean mo2890a(C4053d c4053d) {
        HttpRequest b = m20938b(m20937a(m15992b(), c4053d), c4053d);
        C3969c.m20576h().mo2849a("Fabric", "Sending app info to " + m15991a());
        if (c4053d.f14290j != null) {
            C3969c.m20576h().mo2849a("Fabric", "App icon hash is " + c4053d.f14290j.f14312a);
            C3969c.m20576h().mo2849a("Fabric", "App icon size is " + c4053d.f14290j.f14314c + "x" + c4053d.f14290j.f14315d);
        }
        int b2 = b.m20892b();
        C3969c.m20576h().mo2849a("Fabric", ("POST".equals(b.m20916p()) ? "Create" : "Update") + " app request ID: " + b.m20894b("X-REQUEST-ID"));
        C3969c.m20576h().mo2849a("Fabric", "Result was " + b2);
        if (C4015o.m20815a(b2) == 0) {
            return true;
        }
        return false;
    }

    private HttpRequest m20937a(HttpRequest httpRequest, C4053d c4053d) {
        return httpRequest.m20882a("X-CRASHLYTICS-API-KEY", c4053d.f14281a).m20882a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m20882a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo1426a());
    }

    private HttpRequest m20938b(HttpRequest httpRequest, C4053d c4053d) {
        HttpRequest e = httpRequest.m20902e("app[identifier]", c4053d.f14282b).m20902e("app[name]", c4053d.f14286f).m20902e("app[display_version]", c4053d.f14283c).m20902e("app[build_version]", c4053d.f14284d).m20881a("app[source]", Integer.valueOf(c4053d.f14287g)).m20902e("app[minimum_sdk_version]", c4053d.f14288h).m20902e("app[built_sdk_version]", c4053d.f14289i);
        if (!CommonUtils.m20716c(c4053d.f14285e)) {
            e.m20902e("app[instance_identifier]", c4053d.f14285e);
        }
        if (c4053d.f14290j != null) {
            Closeable closeable = null;
            try {
                closeable = this.a.m15970r().getResources().openRawResource(c4053d.f14290j.f14313b);
                e.m20902e("app[icon][hash]", c4053d.f14290j.f14312a).m20886a("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) closeable).m20881a("app[icon][width]", Integer.valueOf(c4053d.f14290j.f14314c)).m20881a("app[icon][height]", Integer.valueOf(c4053d.f14290j.f14315d));
            } catch (Throwable e2) {
                C3969c.m20576h().mo2857e("Fabric", "Failed to find app icon with resource ID: " + c4053d.f14290j.f14313b, e2);
            } finally {
                String str = "Failed to close app icon InputStream.";
                CommonUtils.m20704a(closeable, str);
            }
        }
        if (c4053d.f14291k != null) {
            for (C3976j c3976j : c4053d.f14291k) {
                e.m20902e(m20939a(c3976j), c3976j.m20630b());
                e.m20902e(m20941b(c3976j), c3976j.m20631c());
            }
        }
        return e;
    }

    String m20939a(C3976j c3976j) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{c3976j.m20629a()});
    }

    String m20941b(C3976j c3976j) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{c3976j.m20629a()});
    }
}
