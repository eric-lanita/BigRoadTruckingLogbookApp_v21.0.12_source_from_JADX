package com.bigroad.ttb.android.p029c;

import android.os.Handler;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1768g;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.List;

class C1748g {
    private final Handler f6046a = new Handler();
    private final C2474y f6047b = OurApplication.m6285g();
    private final TruckManager f6048c = OurApplication.m6294p();
    private final VehicleConnectionManager f6049d = OurApplication.m6252I();
    private final EventManager f6050e = OurApplication.m6295q();
    private final C1790a f6051f = OurApplication.m6287i();
    private C1747a f6052g;
    private final Runnable f6053h = new C17421(this);
    private final C1182a f6054i = new C17432(this);
    private final ChangeListener f6055j = new C17443(this);
    private final VehicleConnectionManager.ChangeListener f6056k = new C17454(this);
    private final EventManager.ChangeListener f6057l = new C17465(this);

    class C17421 implements Runnable {
        final /* synthetic */ C1748g f6038a;

        C17421(C1748g c1748g) {
            this.f6038a = c1748g;
        }

        public void run() {
            this.f6038a.m8548a();
        }
    }

    class C17432 extends C1183b {
        final /* synthetic */ C1748g f6039a;

        C17432(C1748g c1748g) {
            this.f6039a = c1748g;
        }

        public void mo863a(C2474y c2474y) {
            this.f6039a.m8548a();
        }
    }

    class C17443 extends C1203b {
        final /* synthetic */ C1748g f6040a;

        C17443(C1748g c1748g) {
            this.f6040a = c1748g;
        }

        public void mo894a(Truck truck) {
            this.f6040a.m8548a();
        }
    }

    class C17454 extends C1201a {
        final /* synthetic */ C1748g f6041a;

        C17454(C1748g c1748g) {
            this.f6041a = c1748g;
        }

        public void mo888a(C2338a c2338a) {
            if (!c2338a.m11450a(ConnectionFlag.CONNECTED)) {
                this.f6041a.m8548a();
            }
        }

        public void mo891a(MotionType motionType) {
            if (motionType == MotionType.STOPPED) {
                this.f6041a.m8548a();
            }
        }
    }

    class C17465 extends C1199e {
        final /* synthetic */ C1748g f6042a;

        C17465(C1748g c1748g) {
            this.f6042a = c1748g;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            if (!eventManager.m10060j().m4397e()) {
                this.f6042a.m8548a();
            }
        }
    }

    private static class C1747a {
        private final long f6043a;
        private final int f6044b;
        private final AutoDailyLogTruck f6045c;

        public C1747a(long j, int i, AutoDailyLogTruck autoDailyLogTruck) {
            this.f6043a = j;
            this.f6044b = i;
            this.f6045c = autoDailyLogTruck;
        }

        public static C1747a m8542a(C1768g c1768g) {
            if (c1768g == null) {
                return null;
            }
            AutoDailyLogTruck f = c1768g.m8595f();
            if (f != null) {
                return new C1747a(c1768g.m8592b(), c1768g.m8593d(), f);
            }
            return null;
        }

        public long m8543a() {
            return this.f6043a;
        }

        public int m8544b() {
            return this.f6044b;
        }

        public AutoDailyLogTruck m8545c() {
            return this.f6045c;
        }
    }

    public C1748g() {
        m8546a(C1747a.m8542a(this.f6051f.m8706A()));
        this.f6047b.m12184a(this.f6054i);
        this.f6048c.m6560a(this.f6055j, Priority.DEFAULT);
        this.f6049d.m11399a(this.f6056k);
        this.f6050e.m10012a(this.f6057l);
    }

    private void m8546a(C1747a c1747a) {
        if (this.f6052g == null && c1747a != null) {
            this.f6046a.postDelayed(this.f6053h, 600000);
        }
        this.f6052g = c1747a;
    }

    public void m8548a() {
        if (this.f6052g != null) {
            if (this.f6047b.m12202d() == this.f6052g.m8543a()) {
                OurApplication.m6289k().m6452a(this.f6052g.m8544b(), this.f6052g.m8545c());
            } else {
                C2134e.m10682e("TT-DailyLogSync", "Discarding pending update for personId=" + this.f6052g.m8543a());
            }
            m8546a(null);
            this.f6051f.m8814z();
            this.f6046a.removeCallbacks(this.f6053h);
        }
    }

    public List<DailyLog> m8547a(List<DailyLog> list) {
        if (this.f6052g == null) {
            return list;
        }
        if (this.f6052g.m8543a() != this.f6047b.m12202d()) {
            return list;
        }
        int i;
        DailyLog dailyLog;
        int b = this.f6052g.m8544b();
        for (int i2 = 0; i2 < list.size(); i2++) {
            DailyLog dailyLog2 = (DailyLog) list.get(i2);
            if (dailyLog2.getLogDay() == b) {
                i = i2;
                dailyLog = dailyLog2;
                break;
            }
        }
        dailyLog = null;
        i = -1;
        if (dailyLog == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        arrayList.set(i, C1738c.m8501a(dailyLog, this.f6052g.m8545c()));
        return arrayList;
    }
}
