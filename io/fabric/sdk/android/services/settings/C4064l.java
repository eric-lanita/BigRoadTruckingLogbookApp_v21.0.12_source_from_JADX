package io.fabric.sdk.android.services.settings;

import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C2826a;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class C4064l extends C2826a implements C4063w {
    public C4064l(C2822h c2822h, String str, String str2, C4045c c4045c) {
        this(c2822h, str, str2, c4045c, HttpMethod.GET);
    }

    C4064l(C2822h c2822h, String str, String str2, C4045c c4045c, HttpMethod httpMethod) {
        super(c2822h, str, str2, c4045c, httpMethod);
    }

    public JSONObject mo2896a(C4074v c4074v) {
        HttpRequest a;
        Throwable e;
        Throwable th;
        JSONObject jSONObject = null;
        try {
            Map b = m20971b(c4074v);
            try {
                a = m20968a(m15990a(b), c4074v);
                C3969c.m20576h().mo2849a("Fabric", "Requesting settings from " + m15991a());
                C3969c.m20576h().mo2849a("Fabric", "Settings query params were: " + b);
                jSONObject = m20972a(a);
                if (a != null) {
                    C3969c.m20576h().mo2849a("Fabric", "Settings request ID: " + a.m20894b("X-REQUEST-ID"));
                }
            } catch (HttpRequestException e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("Fabric", "Settings request failed.", e);
                    if (a != null) {
                        C3969c.m20576h().mo2849a("Fabric", "Settings request ID: " + a.m20894b("X-REQUEST-ID"));
                    }
                    return jSONObject;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        C3969c.m20576h().mo2849a("Fabric", "Settings request ID: " + a.m20894b("X-REQUEST-ID"));
                    }
                    throw th;
                }
            }
        } catch (HttpRequestException e3) {
            e = e3;
            a = jSONObject;
            C3969c.m20576h().mo2857e("Fabric", "Settings request failed.", e);
            if (a != null) {
                C3969c.m20576h().mo2849a("Fabric", "Settings request ID: " + a.m20894b("X-REQUEST-ID"));
            }
            return jSONObject;
        } catch (Throwable e4) {
            a = jSONObject;
            th = e4;
            if (a != null) {
                C3969c.m20576h().mo2849a("Fabric", "Settings request ID: " + a.m20894b("X-REQUEST-ID"));
            }
            throw th;
        }
        return jSONObject;
    }

    JSONObject m20972a(HttpRequest httpRequest) {
        int b = httpRequest.m20892b();
        C3969c.m20576h().mo2849a("Fabric", "Settings result was: " + b);
        if (m20974a(b)) {
            return m20969a(httpRequest.m20903e());
        }
        C3969c.m20576h().mo2856e("Fabric", "Failed to retrieve settings from " + m15991a());
        return null;
    }

    boolean m20974a(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }

    private JSONObject m20969a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            C3969c.m20576h().mo2850a("Fabric", "Failed to parse settings JSON from " + m15991a(), e);
            C3969c.m20576h().mo2849a("Fabric", "Settings response " + str);
            return null;
        }
    }

    private Map<String, String> m20971b(C4074v c4074v) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c4074v.f14354j);
        hashMap.put("display_version", c4074v.f14353i);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(c4074v.f14355k));
        if (c4074v.f14356l != null) {
            hashMap.put("icon_hash", c4074v.f14356l);
        }
        String str = c4074v.f14352h;
        if (!CommonUtils.m20716c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    private HttpRequest m20968a(HttpRequest httpRequest, C4074v c4074v) {
        m20970a(httpRequest, "X-CRASHLYTICS-API-KEY", c4074v.f14345a);
        m20970a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m20970a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo1426a());
        m20970a(httpRequest, "Accept", "application/json");
        m20970a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", c4074v.f14346b);
        m20970a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", c4074v.f14347c);
        m20970a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", c4074v.f14348d);
        m20970a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", c4074v.f14349e);
        m20970a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", c4074v.f14350f);
        m20970a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", c4074v.f14351g);
        return httpRequest;
    }

    private void m20970a(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.m20882a(str, str2);
        }
    }
}
