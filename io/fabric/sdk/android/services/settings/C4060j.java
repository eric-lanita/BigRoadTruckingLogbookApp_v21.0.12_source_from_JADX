package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4004j;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.p057c.C3989c;
import io.fabric.sdk.android.services.p057c.C3990d;
import org.json.JSONObject;

class C4060j implements C4059r {
    private final C4074v f14301a;
    private final C4061u f14302b;
    private final C4004j f14303c;
    private final C4056g f14304d;
    private final C4063w f14305e;
    private final C2822h f14306f;
    private final C3989c f14307g = new C3990d(this.f14306f);

    public C4060j(C2822h c2822h, C4074v c4074v, C4004j c4004j, C4061u c4061u, C4056g c4056g, C4063w c4063w) {
        this.f14306f = c2822h;
        this.f14301a = c4074v;
        this.f14303c = c4004j;
        this.f14302b = c4061u;
        this.f14304d = c4056g;
        this.f14305e = c4063w;
    }

    public C4072s mo2893a() {
        return mo2894a(SettingsCacheBehavior.USE_CACHE);
    }

    public C4072s mo2894a(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        C4072s c4072s;
        Throwable th2;
        C4072s c4072s2 = null;
        try {
            if (!(C3969c.m20577i() || m20956d())) {
                c4072s2 = m20950b(settingsCacheBehavior);
            }
            if (c4072s2 == null) {
                try {
                    JSONObject a = this.f14305e.mo2896a(this.f14301a);
                    if (a != null) {
                        c4072s2 = this.f14302b.mo2895a(this.f14303c, a);
                        this.f14304d.mo2892a(c4072s2.f14341g, a);
                        m20949a(a, "Loaded settings: ");
                        m20953a(m20954b());
                    }
                } catch (Throwable e) {
                    th = e;
                    c4072s = c4072s2;
                    th2 = th;
                    C3969c.m20576h().mo2857e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c4072s;
                }
            }
            c4072s = c4072s2;
            if (c4072s == null) {
                try {
                    c4072s = m20950b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
                } catch (Exception e2) {
                    th2 = e2;
                    C3969c.m20576h().mo2857e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
                    return c4072s;
                }
            }
        } catch (Throwable e3) {
            th = e3;
            c4072s = null;
            th2 = th;
            C3969c.m20576h().mo2857e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", th2);
            return c4072s;
        }
        return c4072s;
    }

    private C4072s m20950b(SettingsCacheBehavior settingsCacheBehavior) {
        Throwable th;
        C4072s c4072s = null;
        try {
            if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                return null;
            }
            JSONObject a = this.f14304d.mo2891a();
            if (a != null) {
                C4072s a2 = this.f14302b.mo2895a(this.f14303c, a);
                if (a2 != null) {
                    m20949a(a, "Loaded cached settings: ");
                    long a3 = this.f14303c.mo2882a();
                    if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) || !a2.m20983a(a3)) {
                        try {
                            C3969c.m20576h().mo2849a("Fabric", "Returning cached settings.");
                            return a2;
                        } catch (Throwable e) {
                            Throwable th2 = e;
                            c4072s = a2;
                            th = th2;
                            C3969c.m20576h().mo2857e("Fabric", "Failed to get cached settings", th);
                            return c4072s;
                        }
                    }
                    C3969c.m20576h().mo2849a("Fabric", "Cached settings have expired.");
                    return null;
                }
                C3969c.m20576h().mo2857e("Fabric", "Failed to transform cached settings data.", null);
                return null;
            }
            C3969c.m20576h().mo2849a("Fabric", "No cached settings data found.");
            return null;
        } catch (Exception e2) {
            th = e2;
            C3969c.m20576h().mo2857e("Fabric", "Failed to get cached settings", th);
            return c4072s;
        }
    }

    private void m20949a(JSONObject jSONObject, String str) {
        C3969c.m20576h().mo2849a("Fabric", str + jSONObject.toString());
    }

    String m20954b() {
        return CommonUtils.m20699a(CommonUtils.m20726m(this.f14306f.m15970r()));
    }

    String m20955c() {
        return this.f14307g.mo2878a().getString("existing_instance_identifier", "");
    }

    @SuppressLint({"CommitPrefEdits"})
    boolean m20953a(String str) {
        Editor b = this.f14307g.mo2880b();
        b.putString("existing_instance_identifier", str);
        return this.f14307g.mo2879a(b);
    }

    boolean m20956d() {
        return !m20955c().equals(m20954b());
    }
}
