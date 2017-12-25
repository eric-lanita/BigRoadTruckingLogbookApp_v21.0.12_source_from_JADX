package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.core.p048a.C2879a;
import com.crashlytics.android.core.p048a.p049a.C2875d;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4001g;
import io.fabric.sdk.android.services.common.C4008l;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.C2929i;
import io.fabric.sdk.android.services.concurrency.C2931d;
import io.fabric.sdk.android.services.concurrency.C4031b;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.C2941e;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.C4046b;
import io.fabric.sdk.android.services.p057c.C3987a;
import io.fabric.sdk.android.services.p057c.C3988b;
import io.fabric.sdk.android.services.p057c.C3990d;
import io.fabric.sdk.android.services.settings.C4071q;
import io.fabric.sdk.android.services.settings.C4072s;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@C4031b(a = {C2879a.class})
public class C2939h extends C2822h<Void> {
    private final long f10060a;
    private final ConcurrentHashMap<String, String> f10061b;
    private C2940i f10062c;
    private C2940i f10063d;
    private C2937j f10064k;
    private C2926g f10065l;
    private String f10066m;
    private String f10067n;
    private String f10068o;
    private float f10069p;
    private boolean f10070q;
    private final C2974z f10071r;
    private C4045c f10072s;
    private C2903f f10073t;
    private C2879a f10074u;

    class C29321 extends C2931d<Void> {
        final /* synthetic */ C2939h f10055a;

        C29321(C2939h c2939h) {
            this.f10055a = c2939h;
        }

        public /* synthetic */ Object call() {
            return m16378a();
        }

        public Void m16378a() {
            return this.f10055a.m16401d();
        }

        public Priority mo1475b() {
            return Priority.IMMEDIATE;
        }
    }

    class C29332 implements Callable<Void> {
        final /* synthetic */ C2939h f10056a;

        C29332(C2939h c2939h) {
            this.f10056a = c2939h;
        }

        public /* synthetic */ Object call() {
            return m16380a();
        }

        public Void m16380a() {
            this.f10056a.f10062c.m16413a();
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }
    }

    class C29343 implements Callable<Boolean> {
        final /* synthetic */ C2939h f10057a;

        C29343(C2939h c2939h) {
            this.f10057a = c2939h;
        }

        public /* synthetic */ Object call() {
            return m16381a();
        }

        public Boolean m16381a() {
            try {
                boolean c = this.f10057a.f10062c.m16415c();
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Initialization marker file removed: " + c);
                return Boolean.valueOf(c);
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    class C29354 implements Callable<Boolean> {
        final /* synthetic */ C2939h f10058a;

        C29354(C2939h c2939h) {
            this.f10058a = c2939h;
        }

        public /* synthetic */ Object call() {
            return m16382a();
        }

        public Boolean m16382a() {
            return Boolean.valueOf(this.f10058a.f10062c.m16414b());
        }
    }

    private static final class C2936a implements Callable<Boolean> {
        private final C2940i f10059a;

        public /* synthetic */ Object call() {
            return m16383a();
        }

        public C2936a(C2940i c2940i) {
            this.f10059a = c2940i;
        }

        public Boolean m16383a() {
            if (!this.f10059a.m16414b()) {
                return Boolean.FALSE;
            }
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Found previous crash marker.");
            this.f10059a.m16415c();
            return Boolean.TRUE;
        }
    }

    private static final class C2938b implements C2937j {
        private C2938b() {
        }

        public void mo1481a() {
        }
    }

    protected /* synthetic */ Object mo1429f() {
        return m16401d();
    }

    public C2939h() {
        this(1.0f, null, null, false);
    }

    C2939h(float f, C2937j c2937j, C2974z c2974z, boolean z) {
        this(f, c2937j, c2974z, z, C4008l.m20779a("Crashlytics Exception Handler"));
    }

    C2939h(float f, C2937j c2937j, C2974z c2974z, boolean z, ExecutorService executorService) {
        this.f10066m = null;
        this.f10067n = null;
        this.f10068o = null;
        this.f10069p = f;
        if (c2937j == null) {
            c2937j = new C2938b();
        }
        this.f10064k = c2937j;
        this.f10071r = c2974z;
        this.f10070q = z;
        this.f10073t = new C2903f(executorService);
        this.f10061b = new ConcurrentHashMap();
        this.f10060a = System.currentTimeMillis();
    }

    protected boolean h_() {
        return m16397a(super.m15970r());
    }

    boolean m16397a(Context context) {
        if (this.f10070q) {
            return false;
        }
        String a = new C4001g().m20770a(context);
        if (a == null) {
            return false;
        }
        String m = CommonUtils.m20726m(context);
        if (C2939h.m16388a(m, CommonUtils.m20707a(context, "com.crashlytics.RequireBuildId", true))) {
            try {
                C3969c.m20576h().mo2853c("CrashlyticsCore", "Initializing Crashlytics " + mo1426a());
                C3987a c3988b = new C3988b(this);
                this.f10063d = new C2940i("crash_marker", c3988b);
                this.f10062c = new C2940i("initialization_marker", c3988b);
                aa a2 = aa.m16171a(new C3990d(m15970r(), "com.crashlytics.android.core.CrashlyticsCore"), this);
                C2941e c2942k = this.f10071r != null ? new C2942k(this.f10071r) : null;
                this.f10072s = new C4046b(C3969c.m20576h());
                this.f10072s.mo2889a(c2942k);
                IdManager q = m15969q();
                C2880a a3 = C2880a.m16170a(context, q, a, m);
                aj c2955u = new C2955u(context, a3.f9932d);
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Installer package name is: " + a3.f9931c);
                this.f10065l = new C2926g(this, this.f10073t, this.f10072s, q, a2, c3988b, a3, c2955u);
                boolean m2 = m16409m();
                m16394x();
                this.f10065l.m16349a(Thread.getDefaultUncaughtExceptionHandler());
                if (m2 && CommonUtils.m20727n(context)) {
                    C3969c.m20576h().mo2849a("CrashlyticsCore", "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    m16393w();
                    return false;
                }
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Exception handling initialization successful");
                return true;
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", e);
                this.f10065l = null;
                return false;
            }
        }
        throw new UnmetDependencyException("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
    }

    protected Void m16401d() {
        m16407k();
        C2875d n = m16410n();
        if (n != null) {
            this.f10065l.m16347a(n);
        }
        this.f10065l.m16356d();
        try {
            C4072s b = C4071q.m20977a().m20980b();
            if (b == null) {
                C3969c.m20576h().mo2854d("CrashlyticsCore", "Received null settings, skipping report submission!");
            } else if (b.f14338d.f14310c) {
                if (!this.f10065l.m16352a(b.f14336b)) {
                    C3969c.m20576h().mo2849a("CrashlyticsCore", "Could not finalize previous sessions.");
                }
                this.f10065l.m16344a(this.f10069p, b);
                m16408l();
            } else {
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
                m16408l();
            }
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", e);
        } finally {
            m16408l();
        }
        return null;
    }

    public String mo1427b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String mo1426a() {
        return "2.3.17.dev";
    }

    public static C2939h m16391e() {
        return (C2939h) C3969c.m20567a(C2939h.class);
    }

    public void m16396a(String str) {
        m16387a(3, "CrashlyticsCore", str);
    }

    private void m16387a(int i, String str, String str2) {
        if (!this.f10070q && C2939h.m16390d("prior to logging messages.")) {
            this.f10065l.m16346a(System.currentTimeMillis() - this.f10060a, C2939h.m16389b(i, str, str2));
        }
    }

    public void m16399b(String str) {
        if (!this.f10070q && C2939h.m16390d("prior to setting user data.")) {
            this.f10066m = C2939h.m16392e(str);
            this.f10065l.m16348a(this.f10066m, this.f10068o, this.f10067n);
        }
    }

    public void m16400c(String str) {
        if (!this.f10070q && C2939h.m16390d("prior to setting user data.")) {
            this.f10067n = C2939h.m16392e(str);
            this.f10065l.m16348a(this.f10066m, this.f10068o, this.f10067n);
        }
    }

    Map<String, String> m16403g() {
        return Collections.unmodifiableMap(this.f10061b);
    }

    String m16404h() {
        return m15969q().m20734a() ? this.f10066m : null;
    }

    String m16405i() {
        return m15969q().m20734a() ? this.f10067n : null;
    }

    String m16406j() {
        return m15969q().m20734a() ? this.f10068o : null;
    }

    private void m16393w() {
        Callable c29321 = new C29321(this);
        for (C2929i a : m15974v()) {
            c29321.m16370a(a);
        }
        Future submit = m15971s().m20588f().submit(c29321);
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    void m16407k() {
        this.f10073t.m16273a(new C29332(this));
    }

    void m16408l() {
        this.f10073t.m16275b(new C29343(this));
    }

    boolean m16409m() {
        return ((Boolean) this.f10073t.m16273a(new C29354(this))).booleanValue();
    }

    C2875d m16410n() {
        if (this.f10074u != null) {
            return this.f10074u.m16169a();
        }
        return null;
    }

    private void m16394x() {
        if (Boolean.TRUE.equals((Boolean) this.f10073t.m16273a(new C2936a(this.f10063d)))) {
            try {
                this.f10064k.mo1481a();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void m16411o() {
        this.f10063d.m16413a();
    }

    private static String m16389b(int i, String str, String str2) {
        return CommonUtils.m20691a(i) + "/" + str + " " + str2;
    }

    private static boolean m16390d(String str) {
        C2939h e = C2939h.m16391e();
        if (e != null && e.f10065l != null) {
            return true;
        }
        C3969c.m20576h().mo2857e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private static String m16392e(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.length() > 1024) {
            return str.substring(0, 1024);
        }
        return str;
    }

    static boolean m16388a(String str, boolean z) {
        if (!z) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Configured not to require a build ID.");
            return true;
        } else if (!CommonUtils.m20716c(str)) {
            return true;
        } else {
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".     |  | ");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".   \\ |  | /");
            Log.e("CrashlyticsCore", ".    \\    /");
            Log.e("CrashlyticsCore", ".     \\  /");
            Log.e("CrashlyticsCore", ".      \\/");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
            Log.e("CrashlyticsCore", ".");
            Log.e("CrashlyticsCore", ".      /\\");
            Log.e("CrashlyticsCore", ".     /  \\");
            Log.e("CrashlyticsCore", ".    /    \\");
            Log.e("CrashlyticsCore", ".   / |  | \\");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".     |  |");
            Log.e("CrashlyticsCore", ".");
            return false;
        }
    }
}
