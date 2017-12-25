package com.crashlytics.android.p044a;

import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C2826a;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class C2827e extends C2826a {
    private final C2829g f9776b;

    static String m15994a(String str) {
        return "3:" + str;
    }

    public C2827e(C2822h c2822h, String str, String str2, C4045c c4045c, C2829g c2829g) {
        super(c2822h, str, str2, c4045c, HttpMethod.GET);
        this.f9776b = c2829g;
    }

    public C2828f m15996a(String str, String str2, C2825d c2825d) {
        HttpRequest a;
        Throwable e;
        Throwable th;
        C2828f c2828f = null;
        try {
            Map a2 = m15995a(c2825d);
            try {
                a = m15993a(m15990a(a2), str, str2);
                C3969c.m20576h().mo2849a("Beta", "Checking for updates from " + m15991a());
                C3969c.m20576h().mo2849a("Beta", "Checking for updates query params are: " + a2);
                if (a.m20898c()) {
                    C3969c.m20576h().mo2849a("Beta", "Checking for updates was successful");
                    c2828f = this.f9776b.m15997a(new JSONObject(a.m20903e()));
                    if (a != null) {
                        C3969c.m20576h().mo2849a("Fabric", "Checking for updates request ID: " + a.m20894b("X-REQUEST-ID"));
                    }
                } else {
                    C3969c.m20576h().mo2856e("Beta", "Checking for updates failed. Response code: " + a.m20892b());
                    if (a != null) {
                        C3969c.m20576h().mo2849a("Fabric", "Checking for updates request ID: " + a.m20894b("X-REQUEST-ID"));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("Beta", "Error while checking for updates from " + m15991a(), e);
                    if (a != null) {
                        C3969c.m20576h().mo2849a("Fabric", "Checking for updates request ID: " + a.m20894b("X-REQUEST-ID"));
                    }
                    return c2828f;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        C3969c.m20576h().mo2849a("Fabric", "Checking for updates request ID: " + a.m20894b("X-REQUEST-ID"));
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            C3969c.m20576h().mo2857e("Beta", "Error while checking for updates from " + m15991a(), e);
            if (a != null) {
                C3969c.m20576h().mo2849a("Fabric", "Checking for updates request ID: " + a.m20894b("X-REQUEST-ID"));
            }
            return c2828f;
        } catch (Throwable e4) {
            a = null;
            th = e4;
            if (a != null) {
                C3969c.m20576h().mo2849a("Fabric", "Checking for updates request ID: " + a.m20894b("X-REQUEST-ID"));
            }
            throw th;
        }
        return c2828f;
    }

    private HttpRequest m15993a(HttpRequest httpRequest, String str, String str2) {
        return httpRequest.m20882a("Accept", "application/json").m20882a("User-Agent", "Crashlytics Android SDK/" + this.a.mo1426a()).m20882a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").m20882a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m20882a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo1426a()).m20882a("X-CRASHLYTICS-API-KEY", str).m20882a("X-CRASHLYTICS-BETA-TOKEN", C2827e.m15994a(str2));
    }

    private Map<String, String> m15995a(C2825d c2825d) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c2825d.f9766a);
        hashMap.put("display_version", c2825d.f9767b);
        hashMap.put("instance", c2825d.f9768c);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, "3");
        return hashMap;
    }
}
