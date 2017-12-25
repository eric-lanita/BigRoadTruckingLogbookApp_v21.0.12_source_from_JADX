package com.urbanairship;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.urbanairship.C3761b.C3755a;
import com.urbanairship.actions.C3700d;
import com.urbanairship.analytics.C3735b;
import com.urbanairship.google.C3778a;
import com.urbanairship.google.C3780c;
import com.urbanairship.location.C3820f;
import com.urbanairship.messagecenter.C3846d;
import com.urbanairship.p053a.C3678a;
import com.urbanairship.p056c.C3765b;
import com.urbanairship.push.C3883g;
import com.urbanairship.push.C3919j;
import com.urbanairship.push.iam.C3909c;
import com.urbanairship.richpush.C3941b;
import com.urbanairship.util.C3949d;
import java.util.ArrayList;
import java.util.List;

public class C3929q {
    static volatile boolean f13935a = false;
    static volatile boolean f13936b = false;
    static Application f13937c;
    static C3929q f13938d;
    public static boolean f13939e = false;
    private static final Object f13940s = new Object();
    private static List<C3770f> f13941t;
    C3700d f13942f;
    C3761b f13943g;
    C3735b f13944h;
    C3766c f13945i;
    C3796l f13946j;
    C3919j f13947k;
    C3941b f13948l;
    C3820f f13949m;
    C3765b f13950n;
    C3909c f13951o;
    C3777g f13952p;
    C3846d f13953q;
    C3883g f13954r;

    public interface C1186a {
        void mo872a(C3929q c3929q);
    }

    C3929q(C3761b c3761b) {
        this.f13943g = c3761b;
    }

    public static C3929q m20372a() {
        C3929q c3929q;
        synchronized (f13940s) {
            if (f13935a) {
                c3929q = f13938d;
            } else if (f13936b) {
                Object obj = null;
                while (!f13935a) {
                    try {
                        try {
                            f13940s.wait();
                        } catch (InterruptedException e) {
                            obj = 1;
                        }
                    } catch (Throwable th) {
                        if (obj != null) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                c3929q = f13938d;
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            } else {
                throw new IllegalStateException("Take off must be called before shared()");
            }
        }
        return c3929q;
    }

    public static C3767e m20370a(C1186a c1186a) {
        return C3929q.m20371a(c1186a, null);
    }

    public static C3767e m20371a(final C1186a c1186a, Looper looper) {
        C3767e c39271 = new C3770f(looper) {
            public void mo2845d() {
                if (c1186a != null) {
                    c1186a.mo872a(C3929q.m20372a());
                }
            }
        };
        synchronized (f13940s) {
            if (f13935a) {
                c39271.run();
            } else {
                if (f13941t == null) {
                    f13941t = new ArrayList();
                }
                f13941t.add(c39271);
            }
        }
        return c39271;
    }

    public static void m20373a(final Application application, final C3761b c3761b, final C1186a c1186a) {
        if (application == null) {
            throw new IllegalArgumentException("Application argument must not be null");
        }
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            C3783j.m19728e("takeOff() must be called on the main thread!");
        } else if (VERSION.SDK_INT < 16) {
            try {
                Class.forName("android.os.AsyncTask");
            } catch (Throwable e) {
                C3783j.m19726c("AsyncTask workaround failed.", e);
            }
        }
        if (f13939e) {
            StringBuilder stringBuilder = new StringBuilder();
            for (StackTraceElement stackTraceElement : new Exception().getStackTrace()) {
                stringBuilder.append("\n\tat ");
                stringBuilder.append(stackTraceElement.toString());
            }
            Log.d(C3783j.f13564b, "Takeoff stack trace: " + stringBuilder.toString());
        }
        synchronized (f13940s) {
            if (f13935a || f13936b) {
                C3783j.m19728e("You can only call takeOff() once.");
                return;
            }
            C3783j.m19727d("Airship taking off!");
            f13936b = true;
            f13937c = application;
            if (VERSION.SDK_INT >= 14) {
                C3735b.m19445a(application);
                C3909c.m20241a(application);
            }
            new Thread(new Runnable() {
                public void run() {
                    C3929q.m20377c(application, c3761b, c1186a);
                }
            }).start();
        }
    }

    private static void m20377c(Application application, C3761b c3761b, C1186a c1186a) {
        if (c3761b == null) {
            c3761b = new C3755a().m19617a(application.getApplicationContext()).m19622a();
        }
        C3783j.f13563a = c3761b.m19667c();
        C3783j.f13564b = C3929q.m20381g() + " - UALib";
        C3783j.m19727d("Airship taking off!");
        C3783j.m19727d("Airship log level: " + C3783j.f13563a);
        C3783j.m19727d("UA Version: " + C3929q.m20385k() + " / App key = " + c3761b.m19664a() + " Production = " + c3761b.f13511k);
        f13938d = new C3929q(c3761b);
        synchronized (f13940s) {
            f13935a = true;
            f13936b = false;
            f13938d.m20386x();
            if (!c3761b.f13511k) {
                f13938d.m20387y();
            }
            C3783j.m19727d("Airship ready!");
            if (c1186a != null) {
                c1186a.mo872a(f13938d);
            }
            if (f13941t != null) {
                for (Runnable run : new ArrayList(f13941t)) {
                    run.run();
                }
                f13941t = null;
            }
            f13940s.notifyAll();
        }
    }

    public static String m20374b() {
        return C3929q.m20382h().getPackageName();
    }

    public static String m20376c() {
        return C3929q.m20382h().getPackageName() + ".permission.UA_DATA";
    }

    public static PackageManager m20378d() {
        return C3929q.m20382h().getPackageManager();
    }

    public static PackageInfo m20379e() {
        try {
            return C3929q.m20378d().getPackageInfo(C3929q.m20374b(), 0);
        } catch (Throwable e) {
            C3783j.m19722a("UAirship - Unable to get package info.", e);
            return null;
        }
    }

    public static ApplicationInfo m20380f() {
        return C3929q.m20382h().getApplicationInfo();
    }

    public static String m20381g() {
        if (C3929q.m20380f() != null) {
            return C3929q.m20378d().getApplicationLabel(C3929q.m20380f()).toString();
        }
        return null;
    }

    public static Context m20382h() {
        if (f13937c != null) {
            return f13937c.getApplicationContext();
        }
        throw new IllegalStateException("TakeOff must be called first.");
    }

    public static boolean m20383i() {
        return f13935a;
    }

    public static boolean m20384j() {
        return f13936b;
    }

    public static String m20385k() {
        return "7.2.1";
    }

    private void m20386x() {
        this.f13946j = new C3796l(f13937c);
        this.f13946j.mo2777a();
        this.f13944h = new C3735b(f13937c, this.f13946j, this.f13943g);
        this.f13945i = new C3766c(f13937c, this.f13946j);
        this.f13948l = new C3941b(f13937c, this.f13946j);
        this.f13949m = new C3820f(f13937c, this.f13946j);
        this.f13951o = new C3909c(this.f13946j);
        this.f13947k = new C3919j(f13937c, this.f13946j, this.f13943g);
        this.f13954r = new C3883g(f13937c, this.f13946j);
        this.f13952p = new C3777g(f13937c, this.f13943g, this.f13947k);
        this.f13950n = C3765b.m19670a(this.f13943g);
        this.f13942f = new C3700d();
        this.f13942f.m19371a();
        this.f13953q = new C3846d();
        this.f13948l.mo2777a();
        this.f13947k.mo2777a();
        this.f13949m.mo2777a();
        this.f13951o.mo2777a();
        this.f13952p.mo2777a();
        this.f13945i.mo2777a();
        this.f13944h.mo2777a();
        this.f13953q.mo2777a();
        this.f13954r.mo2777a();
        String k = C3929q.m20385k();
        String a = this.f13946j.m19810a("com.urbanairship.application.device.LIBRARY_VERSION", null);
        if (!(a == null || a.equals(k))) {
            C3783j.m19727d("Urban Airship library changed from " + a + " to " + k + ".");
        }
        this.f13946j.m19819b("com.urbanairship.application.device.LIBRARY_VERSION", C3929q.m20385k());
    }

    public C3761b m20388l() {
        return this.f13943g;
    }

    public C3883g m20389m() {
        return this.f13954r;
    }

    public C3919j m20390n() {
        return this.f13947k;
    }

    public C3941b m20391o() {
        return this.f13948l;
    }

    public C3820f m20392p() {
        return this.f13949m;
    }

    public C3909c m20393q() {
        return this.f13951o;
    }

    public C3735b m20394r() {
        return this.f13944h;
    }

    public C3766c m20395s() {
        return this.f13945i;
    }

    public C3765b m20396t() {
        return this.f13950n;
    }

    public C3700d m20397u() {
        return this.f13942f;
    }

    public C3846d m20398v() {
        return this.f13953q;
    }

    public int m20399w() {
        int i = 1;
        switch (this.f13946j.m19807a("com.urbanairship.application.device.PLATFORM", -1)) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                if (C3678a.m19291a()) {
                    C3783j.m19727d("ADM available. Setting platform to Amazon.");
                } else if (C3780c.m19709b(C3929q.m20382h())) {
                    C3783j.m19727d("Google Play Store available. Setting platform to Android.");
                    i = 2;
                } else if ("amazon".equalsIgnoreCase(Build.MANUFACTURER)) {
                    C3783j.m19727d("Build.MANUFACTURER is AMAZON. Setting platform to Amazon.");
                } else {
                    C3783j.m19727d("Defaulting platform to Android.");
                    i = 2;
                }
                this.f13946j.m19817b("com.urbanairship.application.device.PLATFORM", i);
                return i;
        }
    }

    private void m20387y() {
        C3949d.m20496a(this.f13943g);
        switch (f13938d.m20399w()) {
            case 1:
                if (this.f13943g.m19665a("ADM")) {
                    C3678a.m19294c();
                    return;
                } else {
                    C3783j.m19728e("Amazon platform detected but ADM transport is disabled. The device will not be able to receive push notifications.");
                    return;
                }
            case 2:
                if (this.f13943g.m19665a(GoogleCloudMessaging.INSTANCE_ID_SCOPE)) {
                    C3778a.m19703a(this.f13943g);
                    return;
                } else {
                    C3783j.m19728e("Android platform detected but GCM transport is disabled. The device will not be able to receive push notifications.");
                    return;
                }
            default:
                return;
        }
    }
}
