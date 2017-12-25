package com.bigroad.ttb.android;

import android.os.Handler;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.BluetoothMonitor.BluetoothStatus;
import com.bigroad.ttb.android.BluetoothMonitor.C1188a;
import com.bigroad.ttb.android.BluetoothMonitor.C1189b;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.location.LocationTracker.ProviderStatus;
import com.bigroad.ttb.android.logging.C2134e;

public class C2154m {
    private static C2154m f7490a;
    private final Handler f7491b;
    private final C2474y f7492c;
    private final AuthMonitor f7493d;
    private final EventManager f7494e;
    private final LocationTracker f7495f;
    private final BluetoothMonitor f7496g;
    private final PowerStatus f7497h;
    private final ap f7498i;
    private long f7499j;
    private long f7500k;
    private long f7501l;
    private long f7502m;
    private final C1185a f7503n;
    private final C1191c f7504o;
    private final C1188a f7505p;
    private final C1216a f7506q;
    private final Runnable f7507r;

    class C21481 implements C1185a {
        final /* synthetic */ C2154m f7482a;

        C21481(C2154m c2154m) {
            this.f7482a = c2154m;
        }

        public void mo912a(AuthStatus authStatus) {
            switch (authStatus) {
                case SIGNED_IN:
                    this.f7482a.f7501l = this.f7482a.f7492c.m12168M();
                    this.f7482a.m10735b();
                    return;
                case SIGNED_OUT:
                    this.f7482a.f7499j = 0;
                    this.f7482a.f7500k = 0;
                    this.f7482a.f7501l = 0;
                    return;
                default:
                    return;
            }
        }
    }

    class C21492 extends C1192d {
        final /* synthetic */ C2154m f7483a;

        C21492(C2154m c2154m) {
            this.f7483a = c2154m;
        }

        public void mo879a() {
            this.f7483a.m10735b();
        }
    }

    class C21503 extends C1189b {
        final /* synthetic */ C2154m f7484a;

        C21503(C2154m c2154m) {
            this.f7484a = c2154m;
        }

        public void mo875a() {
            this.f7484a.m10735b();
        }
    }

    class C21514 implements C1216a {
        final /* synthetic */ C2154m f7485a;

        C21514(C2154m c2154m) {
            this.f7485a = c2154m;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f7485a.m10735b();
        }
    }

    class C21525 implements Runnable {
        final /* synthetic */ C2154m f7486a;

        C21525(C2154m c2154m) {
            this.f7486a = c2154m;
        }

        public void run() {
            this.f7486a.m10735b();
        }
    }

    public static C2154m m10732a() {
        if (f7490a == null) {
            f7490a = new C2154m();
        }
        return f7490a;
    }

    private C2154m() {
        this.f7491b = new Handler();
        this.f7492c = OurApplication.m6285g();
        this.f7493d = OurApplication.m6249F();
        this.f7494e = OurApplication.m6295q();
        this.f7495f = OurApplication.m6302x();
        this.f7496g = OurApplication.m6250G();
        this.f7497h = OurApplication.m6286h();
        this.f7498i = OurApplication.m6269Z();
        this.f7499j = 0;
        this.f7500k = 0;
        this.f7501l = 0;
        this.f7502m = 0;
        this.f7503n = new C21481(this);
        this.f7504o = new C21492(this);
        this.f7505p = new C21503(this);
        this.f7506q = new C21514(this);
        this.f7507r = new C21525(this);
        this.f7501l = this.f7492c.m12168M();
        this.f7502m = this.f7498i.mo915c() + 10000;
        this.f7493d.m6027a(this.f7503n);
        this.f7495f.m10599a(this.f7504o);
        this.f7496g.m6060a(this.f7505p);
        this.f7497h.m6311a(this.f7506q);
        m10735b();
    }

    private void m10735b() {
        if (!this.f7493d.m6030c()) {
            long c = this.f7498i.mo915c();
            long max = Math.max(this.f7500k + 60000, this.f7502m);
            if (c < max) {
                max -= c;
                this.f7491b.removeCallbacks(this.f7507r);
                this.f7491b.postDelayed(this.f7507r, max);
                return;
            }
            long j;
            ProviderStatus f = this.f7495f.m10606f();
            BluetoothStatus d = this.f7496g.m6063d();
            boolean a = this.f7497h.m6312a();
            switch (f) {
                case DISABLED:
                    max = 2 | 0;
                    break;
                case ENABLED:
                    max = 1 | 0;
                    break;
                case NOT_FOUND:
                    max = 3 | 0;
                    break;
                default:
                    max = 0 | 0;
                    break;
            }
            switch (d) {
                case DISABLED:
                    j = max | 8;
                    break;
                case ENABLED:
                    j = max | 4;
                    break;
                case UNSUPPORTED:
                    j = max | 12;
                    break;
                default:
                    j = max | 0;
                    break;
            }
            if (a) {
                max = 16;
            } else {
                max = 0;
            }
            max = (max | j) | 0;
            if (max != this.f7501l) {
                this.f7500k = c;
                this.f7501l = max;
                this.f7494e.m10050e(C2022a.m10093b(OurApplication.ac(), max));
                this.f7492c.m12218i(this.f7501l);
            }
        }
    }

    public boolean m10738a(long j) {
        if (Math.abs(j) < 600000) {
            return false;
        }
        C2134e.m10680d("TT-DevMonitor", "Clock skew from UTC is " + (j / 1000) + "s");
        long c = this.f7498i.mo915c();
        if (this.f7499j <= 0 || c - this.f7499j >= 3600000) {
            this.f7499j = c;
            this.f7494e.m10050e(C2022a.m10074a(OurApplication.ac(), j));
        }
        return true;
    }
}
