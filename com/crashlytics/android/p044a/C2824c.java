package com.crashlytics.android.p044a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C2823k;
import io.fabric.sdk.android.services.common.C4016p;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.network.C4046b;
import io.fabric.sdk.android.services.p045a.C3980b;
import io.fabric.sdk.android.services.p057c.C3990d;
import io.fabric.sdk.android.services.settings.C4055f;
import io.fabric.sdk.android.services.settings.C4071q;
import io.fabric.sdk.android.services.settings.C4072s;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class C2824c extends C2822h<Boolean> implements C2823k {
    private final C3980b<String> f9763a = new C3980b();
    private final C2831h f9764b = new C2831h();
    private C2816j f9765c;

    protected /* synthetic */ Object mo1429f() {
        return m15983d();
    }

    @TargetApi(14)
    protected boolean h_() {
        this.f9765c = m15979a(VERSION.SDK_INT, (Application) m15970r().getApplicationContext());
        return true;
    }

    protected Boolean m15983d() {
        C3969c.m20576h().mo2849a("Beta", "Beta kit initializing...");
        Context r = m15970r();
        IdManager q = m15969q();
        if (TextUtils.isEmpty(m15977a(r, q.m20743j()))) {
            C3969c.m20576h().mo2849a("Beta", "A Beta device token was not found for this app");
            return Boolean.valueOf(false);
        }
        C3969c.m20576h().mo2849a("Beta", "Beta device token is present, checking for app updates.");
        C4055f h = m15978h();
        C2825d a = m15976a(r);
        if (m15981a(h, a)) {
            this.f9765c.mo1424a(r, this, q, h, a, new C3990d(this), new C4016p(), new C4046b(C3969c.m20576h()));
        }
        return Boolean.valueOf(true);
    }

    @TargetApi(14)
    C2816j m15979a(int i, Application application) {
        if (i >= 14) {
            return new C2821b(m15971s().m20587e(), m15971s().m20588f());
        }
        return new C2832i();
    }

    public Map<DeviceIdentifierType, String> mo1428e() {
        CharSequence a = m15977a(m15970r(), m15969q().m20743j());
        Map<DeviceIdentifierType, String> hashMap = new HashMap();
        if (!TextUtils.isEmpty(a)) {
            hashMap.put(DeviceIdentifierType.FONT_TOKEN, a);
        }
        return hashMap;
    }

    public String mo1427b() {
        return "com.crashlytics.sdk.android:beta";
    }

    public String mo1426a() {
        return "1.2.5.dev";
    }

    boolean m15981a(C4055f c4055f, C2825d c2825d) {
        return (c4055f == null || TextUtils.isEmpty(c4055f.f14298a) || c2825d == null) ? false : true;
    }

    private String m15977a(Context context, String str) {
        Object obj;
        try {
            obj = (String) this.f9763a.mo2864a(context, this.f9764b);
            if ("".equals(obj)) {
                obj = null;
            }
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Beta", "Failed to load the Beta device token", e);
            obj = null;
        }
        C3969c.m20576h().mo2849a("Beta", "Beta device token present: " + (!TextUtils.isEmpty(obj)));
        return obj;
    }

    private C4055f m15978h() {
        C4072s b = C4071q.m20977a().m20980b();
        if (b != null) {
            return b.f14340f;
        }
        return null;
    }

    private C2825d m15976a(Context context) {
        C2825d a;
        Throwable th;
        Throwable e;
        Throwable th2;
        C2825d c2825d;
        InputStream inputStream = null;
        InputStream open;
        try {
            open = context.getAssets().open("crashlytics-build.properties");
            Object obj;
            if (open != null) {
                try {
                    a = C2825d.m15987a(open);
                } catch (Throwable e2) {
                    th = e2;
                    obj = inputStream;
                    th2 = th;
                    try {
                        C3969c.m20576h().mo2857e("Beta", "Error reading Beta build properties", th2);
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th22) {
                                C3969c.m20576h().mo2857e("Beta", "Error closing Beta build properties asset", th22);
                            }
                        }
                        return c2825d;
                    } catch (Throwable th3) {
                        e2 = th3;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable th222) {
                                C3969c.m20576h().mo2857e("Beta", "Error closing Beta build properties asset", th222);
                            }
                        }
                        throw e2;
                    }
                }
                try {
                    C3969c.m20576h().mo2849a("Beta", a.f9769d + " build properties: " + a.f9767b + " (" + a.f9766a + ") - " + a.f9768c);
                    c2825d = a;
                } catch (Throwable e22) {
                    th = e22;
                    c2825d = a;
                    th222 = th;
                    C3969c.m20576h().mo2857e("Beta", "Error reading Beta build properties", th222);
                    if (open != null) {
                        open.close();
                    }
                    return c2825d;
                }
            }
            obj = inputStream;
            if (open != null) {
                try {
                    open.close();
                } catch (Throwable th2222) {
                    C3969c.m20576h().mo2857e("Beta", "Error closing Beta build properties asset", th2222);
                }
            }
        } catch (Throwable e222) {
            open = inputStream;
            InputStream inputStream2 = inputStream;
            th2222 = e222;
            c2825d = inputStream2;
            C3969c.m20576h().mo2857e("Beta", "Error reading Beta build properties", th2222);
            if (open != null) {
                open.close();
            }
            return c2825d;
        } catch (Throwable th4) {
            e222 = th4;
            open = inputStream;
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        return c2825d;
    }

    String m15986g() {
        return CommonUtils.m20711b(m15970r(), "com.crashlytics.ApiEndpoint");
    }
}
