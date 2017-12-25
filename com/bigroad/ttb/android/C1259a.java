package com.bigroad.ttb.android;

import android.os.Handler;
import android.os.SystemClock;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;

public class C1259a extends ap {
    private static C1259a f4289e;
    private final C2032f f4290a = OurApplication.ac();
    private final C1255a f4291b = new C1255a();
    private final Handler f4292c = new Handler();
    private final ChangeListener f4293d = new C12531(this);

    class C12531 extends C1201a {
        final /* synthetic */ C1259a f4283a;

        C12531(C1259a c1259a) {
            this.f4283a = c1259a;
        }

        public void mo888a(C2338a c2338a) {
            if (!c2338a.m11451a(ConnectionSetupFlag.REQUIRED) && this.f4283a.f4291b.m6600a()) {
                this.f4283a.m4205d();
            }
        }

        public void mo886a(long j) {
            if (this.f4283a.f4290a.mo1311s().m11411i() && this.f4283a.f4291b.m6601a(j, this.f4283a.mo915c())) {
                this.f4283a.m4205d();
            }
        }
    }

    class C12542 implements Runnable {
        final /* synthetic */ C1259a f4284a;

        C12542(C1259a c1259a) {
            this.f4284a = c1259a;
        }

        public void run() {
            VehicleConnectionManager s = this.f4284a.f4290a.mo1311s();
            if (s != null) {
                s.m11399a(this.f4284a.f4293d);
            }
        }
    }

    private static class C1255a {
        private long f4285a;
        private Long f4286b;

        private C1255a() {
            this.f4285a = 0;
            this.f4286b = null;
        }

        public boolean m6601a(long j, long j2) {
            boolean z;
            if (m6597b()) {
                long b = m6602b(m6598c(j2));
                z = j > b ? true : b - j > 10000;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            this.f4285a = 1000 + j;
            this.f4286b = Long.valueOf(j2);
            return true;
        }

        boolean m6600a() {
            if (!m6597b()) {
                return false;
            }
            this.f4285a = 0;
            this.f4286b = null;
            return true;
        }

        Long m6599a(long j) {
            if (m6597b()) {
                return Long.valueOf(m6602b(m6598c(j)));
            }
            return null;
        }

        private boolean m6597b() {
            return this.f4286b != null;
        }

        private long m6598c(long j) {
            if (this.f4286b != null) {
                return j - this.f4286b.longValue();
            }
            return 0;
        }

        long m6602b(long j) {
            return this.f4285a + j;
        }
    }

    public static C1259a m6621e() {
        if (f4289e == null) {
            f4289e = new C1259a();
        }
        return f4289e;
    }

    private C1259a() {
        this.f4292c.post(new C12542(this));
    }

    public long mo913a() {
        return System.currentTimeMillis();
    }

    public long mo914b() {
        Long a = this.f4291b.m6599a(mo915c());
        if (a != null) {
            return a.longValue();
        }
        return mo913a();
    }

    public long mo915c() {
        return SystemClock.elapsedRealtime();
    }
}
