package com.bigroad.ttb.android.logging;

import android.net.TrafficStats;
import android.os.Handler;
import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;

public class C2133d {
    private final Runnable f7448a;
    private final Handler f7449b;
    private final int f7450c;
    private boolean f7451d;
    private long f7452e;
    private long f7453f;
    private long f7454g;

    class C21301 implements Runnable {
        final /* synthetic */ C2133d f7445a;

        C21301(C2133d c2133d) {
            this.f7445a = c2133d;
        }

        public void run() {
            this.f7445a.m10663d();
        }
    }

    class C21312 extends C1183b {
        final /* synthetic */ C2133d f7446a;

        C21312(C2133d c2133d) {
            this.f7446a = c2133d;
        }

        public void mo865b(C2474y c2474y) {
            this.f7446a.m10660a(c2474y.m12236z());
        }
    }

    private static final class C2132a {
        private static final C2133d f7447a = new C2133d();
    }

    public static C2133d m10656a() {
        return C2132a.f7447a;
    }

    private C2133d() {
        this.f7448a = new C21301(this);
        this.f7449b = new Handler();
        this.f7450c = OurApplication.m6279b().getApplicationInfo().uid;
        C2474y g = OurApplication.m6285g();
        this.f7451d = false;
        m10661b();
        m10660a(g.m12236z());
        g.m12184a(new C21312(this));
    }

    private void m10661b() {
        this.f7452e = OurApplication.m6269Z().mo915c();
        this.f7453f = TrafficStats.getUidTxBytes(this.f7450c);
        this.f7454g = TrafficStats.getUidRxBytes(this.f7450c);
    }

    private void m10660a(boolean z) {
        if (z != this.f7451d) {
            this.f7451d = z;
            if (!this.f7451d) {
                C2134e.m10678c("TT-DataUseLogger", "Stopped data use logging");
                m10665f();
            } else if (m10662c()) {
                C2134e.m10678c("TT-DataUseLogger", "Starting data use logging");
                m10663d();
            } else {
                C2134e.m10680d("TT-DataUseLogger", "TrafficStats is unsupported on this device.");
            }
        }
    }

    private boolean m10662c() {
        return (this.f7453f == -1 && this.f7454g == -1) ? false : true;
    }

    private void m10663d() {
        long j = this.f7452e;
        long j2 = this.f7453f;
        long j3 = this.f7454g;
        m10661b();
        C2134e.m10670a(MobileAppDiagnosticFlags.LOG_DATA_USE, 4, "TT-DataUseLogger", "delta: {ms=" + (this.f7452e - j) + ", tx=" + m10657a(this.f7453f, j2) + ", rx=" + m10657a(this.f7454g, j3) + "}, boot: {ms=" + this.f7452e + ", tx=" + m10657a(this.f7453f, 0) + ", rx=" + m10657a(this.f7454g, 0) + "}");
        m10664e();
    }

    private String m10657a(long j, long j2) {
        if (j == -1) {
            return "UNSUPPORTED";
        }
        return Long.toString(j - j2);
    }

    private void m10664e() {
        m10665f();
        if (this.f7451d && m10662c()) {
            this.f7449b.postDelayed(this.f7448a, 60000);
        }
    }

    private void m10665f() {
        this.f7449b.removeCallbacks(this.f7448a);
    }
}
