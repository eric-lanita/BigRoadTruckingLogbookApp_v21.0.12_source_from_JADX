package com.bigroad.ttb.android;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.DrivingModeManager.C1209a;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.eobr.EobrEntryManager.C1869a;
import com.bigroad.ttb.android.eobr.EobrEntryManager.C1870b;
import com.bigroad.ttb.android.eobr.turbo.C1976f;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.event.EventSource;
import com.bigroad.ttb.android.location.C2122b;
import com.bigroad.ttb.android.location.C2122b.C2121a;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.notification.C2208c;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.vehicle.task.DrivingTask;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.Arrays;
import java.util.Calendar;

public class C2222o {
    private static C2222o f7679f;
    private final C1216a f7680A = new C22186(this);
    private final C1182a f7681B = new C22197(this);
    private final C1209a f7682C = new C22208(this);
    private final Runnable f7683D = new Runnable(this) {
        final /* synthetic */ C2222o f7668a;

        {
            this.f7668a = r1;
        }

        public void run() {
            this.f7668a.f7696n.m10900a(this.f7668a.f7705w);
        }
    };
    protected Event f7684a;
    protected final ChangeListener f7685b = new C22175(this);
    protected final TruckManager.ChangeListener f7686c = new C22219(this);
    protected final C1869a f7687d = new C1870b(this) {
        final /* synthetic */ C2222o f7667a;

        {
            this.f7667a = r1;
        }

        public void mo1078a(String str) {
            if (this.f7667a.f7684a != null) {
                this.f7667a.m10930a("Use Device");
            }
        }
    };
    protected final Runnable f7688e = new C22142(this);
    private final Handler f7689g = new Handler();
    private C2474y f7690h;
    private LocationTracker f7691i;
    private C2122b f7692j;
    private C2081g f7693k;
    private EventManager f7694l;
    private AuthMonitor f7695m;
    private C2208c f7696n;
    private PowerStatus f7697o;
    private TruckManager f7698p;
    private ap f7699q;
    private C1976f f7700r;
    private DrivingModeManager f7701s;
    private final C2032f f7702t;
    private final ag<C1702a> f7703u = new ag();
    private long f7704v;
    private DutyStatus f7705w;
    private long f7706x = 0;
    private final C2121a f7707y = new C22131(this);
    private final C1230a f7708z = new C22164(this);

    public interface C1702a {
        void mo1049a(DutyStatus dutyStatus);
    }

    public static class C1703b implements C1702a {
        public void mo1049a(DutyStatus dutyStatus) {
        }
    }

    class C22131 implements C2121a {
        final /* synthetic */ C2222o f7669a;

        C22131(C2222o c2222o) {
            this.f7669a = c2222o;
        }

        public void mo1261a() {
            this.f7669a.m10945e();
        }
    }

    class C22142 implements Runnable {
        final /* synthetic */ C2222o f7670a;

        C22142(C2222o c2222o) {
            this.f7670a = c2222o;
        }

        public void run() {
            this.f7670a.m10935b("Pending Timeout");
        }
    }

    class C22164 extends C1231b {
        final /* synthetic */ C2222o f7673a;

        C22164(C2222o c2222o) {
            this.f7673a = c2222o;
        }

        public void mo906a(C2081g c2081g) {
            this.f7673a.m10947f();
            this.f7673a.m10953i();
        }
    }

    class C22175 extends C1199e {
        final /* synthetic */ C2222o f7674a;

        C22175(C2222o c2222o) {
            this.f7674a = c2222o;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f7674a.m10949g();
            this.f7674a.m10953i();
        }
    }

    class C22186 implements C1216a {
        final /* synthetic */ C2222o f7675a;

        C22186(C2222o c2222o) {
            this.f7675a = c2222o;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f7675a.m10953i();
        }
    }

    class C22197 extends C1183b {
        final /* synthetic */ C2222o f7676a;

        C22197(C2222o c2222o) {
            this.f7676a = c2222o;
        }

        public void mo864a(C2474y c2474y, String str) {
            if (am.m4189a("autoDutyStatus", str)) {
                this.f7676a.m10953i();
            }
        }
    }

    class C22208 implements C1209a {
        final /* synthetic */ C2222o f7677a;

        C22208(C2222o c2222o) {
            this.f7677a = c2222o;
        }

        public void mo981a() {
            this.f7677a.f7706x = this.f7677a.f7699q.mo913a();
        }
    }

    class C22219 extends C1203b {
        final /* synthetic */ C2222o f7678a;

        C22219(C2222o c2222o) {
            this.f7678a = c2222o;
        }

        public void mo894a(Truck truck) {
            long j;
            if (truck == null) {
                j = -2;
            } else {
                j = truck.getTruckId();
            }
            if (!(this.f7678a.f7684a == null || j == this.f7678a.f7684a.getTruckId())) {
                this.f7678a.f7689g.removeCallbacks(this.f7678a.f7688e);
                this.f7678a.m10935b("Truck Change");
            }
            if (j != this.f7678a.f7704v) {
                this.f7678a.f7704v = j;
                this.f7678a.f7706x = this.f7678a.f7699q.mo913a();
                if (truck != null && truck.getHasAobrd()) {
                    Event h = this.f7678a.f7694l.m10056h();
                    if (!(h == null || h.getImmutableDutySegment())) {
                        DutyStatus a = DutyStatus.m4384a(h);
                        if (a != null && a.m4397e()) {
                            this.f7678a.f7694l.m10019a(a.m4398f(), EventSource.USER, DutyStatusChangeBits.m4033a(Reason.TRUCK_PICKED_WHILE_DRIVING));
                        }
                    }
                }
            }
            this.f7678a.m10953i();
        }
    }

    public static C2222o m10926a(Context context, C2032f c2032f) {
        if (f7679f == null) {
            f7679f = new C2222o(context, c2032f);
        }
        return f7679f;
    }

    protected void m10956a() {
        this.f7690h = this.f7702t.mo1295c();
        this.f7691i = this.f7702t.mo1304l();
        this.f7692j = this.f7702t.mo1305m();
        this.f7693k = this.f7702t.mo1294b();
        this.f7694l = this.f7702t.mo1301i();
        this.f7695m = this.f7702t.mo1308p();
        this.f7696n = this.f7702t.mo1303k();
        this.f7697o = this.f7702t.mo1296d();
        this.f7698p = this.f7702t.mo1300h();
        this.f7699q = this.f7702t.mo1314v();
        this.f7700r = this.f7702t.mo1313u();
        this.f7701s = this.f7702t.mo1317y();
        this.f7704v = this.f7698p.m6580g();
        this.f7705w = this.f7694l.m10060j();
        this.f7692j.m10627a(this.f7707y);
        this.f7693k.m10446a(this.f7708z);
        this.f7694l.m10012a(this.f7685b);
        this.f7697o.m6311a(this.f7680A);
        this.f7690h.m12184a(this.f7681B);
        this.f7698p.m6560a(this.f7686c, Priority.DUTY_MONITOR);
        this.f7700r.m9048a(this.f7687d);
        this.f7701s.m6190a(this.f7682C);
        m10953i();
        m10955j();
    }

    private C2222o(Context context, C2032f c2032f) {
        this.f7702t = c2032f;
        m10956a();
    }

    private boolean m10936b() {
        Truck f = this.f7698p.m6578f();
        return f != null && f.getHasAobrd();
    }

    private void m10938c() {
        long a = this.f7699q.mo913a();
        long K = this.f7690h.m12166K();
        if (K > a) {
            this.f7690h.m12214g(a);
            K = a;
        }
        if (K <= 0 || a - K >= 1800000) {
            Activity c = this.f7693k.m10451c();
            if (c instanceof OurActivity) {
                OurActivity ourActivity = (OurActivity) c;
                if (this.f7701s.m6196b()) {
                    ourActivity.m6694M();
                } else {
                    ourActivity.m6693L();
                }
            }
        }
    }

    private void m10941d() {
        long a = this.f7699q.mo913a();
        long L = this.f7690h.m12167L();
        if (L > a) {
            this.f7690h.m12217h(a);
            L = a;
        }
        if (L <= 0 || a - L >= 1800000) {
            Activity c = this.f7693k.m10451c();
            if (c instanceof OurActivity) {
                OurActivity ourActivity = (OurActivity) c;
                if (this.f7701s.m6196b()) {
                    ourActivity.m6696O();
                } else {
                    ourActivity.m6695N();
                }
            }
        }
    }

    private boolean m10931a(DutyStatus dutyStatus) {
        if (dutyStatus.m4397e()) {
            return false;
        }
        return this.f7692j.m10628a();
    }

    private boolean m10937b(DutyStatus dutyStatus) {
        if (dutyStatus.m4397e()) {
            return this.f7692j.m10629b();
        }
        return false;
    }

    private void m10927a(DutyStatus dutyStatus, Reason reason) {
        this.f7705w = dutyStatus;
        this.f7696n.m10900a(dutyStatus);
        this.f7694l.m10031b(dutyStatus, EventSource.GPS, DutyStatusChangeBits.m4033a(reason));
    }

    private void m10945e() {
        if (!this.f7690h.m12171P() || !this.f7695m.m6031d() || m10936b() || this.f7694l.m10059i()) {
            return;
        }
        if (this.f7705w == DutyStatus.ON_DUTY_NOT_DRIVING || this.f7705w == DutyStatus.DRIVING || this.f7705w == DutyStatus.OFF_DUTY_DRIVING || (this.f7705w == DutyStatus.OFF_DUTY && this.f7701s.m6196b())) {
            Event h = this.f7694l.m10056h();
            if (h == null || this.f7705w != DutyStatus.m4383a(h.getEventType()) || h.getClientId() == null || Arrays.equals(h.getClientId().m19091d(), this.f7690h.m12191a())) {
                Calendar m = this.f7690h.m12228r().m4879m();
                if (!C2292l.m11230a(DailyLogUtils.m4284a(m))) {
                    long timeInMillis = m.getTimeInMillis();
                    if (this.f7706x > timeInMillis) {
                        this.f7706x = timeInMillis;
                    }
                    if (timeInMillis - this.f7706x < 180000) {
                        return;
                    }
                    if (this.f7693k.m10450b()) {
                        if (m10931a(this.f7705w)) {
                            m10927a(this.f7701s.m6196b() ? DutyStatus.OFF_DUTY_DRIVING : DutyStatus.DRIVING, Reason.GPS_AUTO);
                        } else if (m10937b(this.f7705w)) {
                            m10927a(this.f7701s.m6196b() ? DutyStatus.OFF_DUTY : DutyStatus.ON_DUTY_NOT_DRIVING, Reason.GPS_AUTO);
                        }
                    } else if (m10931a(this.f7705w)) {
                        m10938c();
                    } else if (m10937b(this.f7705w)) {
                        m10941d();
                    }
                }
            }
        }
    }

    private void m10947f() {
        if (this.f7693k.m10447a()) {
            this.f7689g.removeCallbacks(this.f7683D);
            this.f7696n.m10899a();
        }
        m10945e();
    }

    private void m10949g() {
        DutyStatus dutyStatus;
        Event h = this.f7694l.m10056h();
        if (h == null) {
            dutyStatus = DutyStatus.OFF_DUTY;
        } else {
            dutyStatus = DutyStatus.m4383a(h.getEventType());
        }
        if (!(this.f7684a == null || C1144s.m5760a(this.f7684a, this.f7694l.m10054g()))) {
            m10930a("Duty Status Event Change");
        }
        if (this.f7705w != dutyStatus) {
            this.f7706x = this.f7699q.mo913a();
            m10939c(dutyStatus);
        }
    }

    private void m10939c(DutyStatus dutyStatus) {
        if (dutyStatus != this.f7705w) {
            this.f7705w = dutyStatus;
            m10951h();
        }
    }

    private void m10951h() {
        C2134e.m10676b("TT-DutyMonitor", "Duty status changed to: " + this.f7705w);
        if (this.f7693k.m10450b()) {
            this.f7689g.removeCallbacks(this.f7683D);
            this.f7689g.postDelayed(this.f7683D, 1000);
        }
        m10942d(this.f7705w);
    }

    private void m10953i() {
        boolean z = false;
        boolean b = m10936b();
        boolean z2 = !b && this.f7690h.m12171P() && this.f7705w.m4395c();
        if ((this.f7693k.m10447a() || this.f7697o.m6312a()) && (z2 || b)) {
            z = true;
        }
        this.f7691i.m10600a((Object) this, z);
    }

    private void m10955j() {
        Event g = this.f7694l.m10054g();
        if (g == null) {
            this.f7684a = null;
        } else if (DutyStatus.m4391c(g) && g.getImmutableDutySegment() && g.hasClientId() && Arrays.equals(g.getClientId().m19091d(), this.f7690h.m12191a())) {
            this.f7684a = g;
            C2134e.m10678c("TT-DutyMonitor", "Tracking pending ODND for Driving event.");
            this.f7689g.postDelayed(this.f7688e, 60000);
        }
    }

    private void m10930a(String str) {
        if (this.f7684a != null) {
            C2134e.m10678c("TT-DutyMonitor", "Cancelling pending ODND for event.  Reason: " + str);
            this.f7689g.removeCallbacks(this.f7688e);
            this.f7684a = null;
        }
    }

    private void m10935b(String str) {
        if (this.f7684a != null) {
            C2134e.m10678c("TT-DutyMonitor", "Ending Driving Segment.  Reason:  " + str);
            Event event = this.f7684a;
            this.f7684a = null;
            DrivingTask.m11659a(this.f7702t, event, null);
        }
    }

    public void m10957a(C1702a c1702a) {
        this.f7703u.m4159a(c1702a, 0);
    }

    private void m10942d(final DutyStatus dutyStatus) {
        this.f7703u.m4157a(new C0837a<C1702a>(this) {
            final /* synthetic */ C2222o f7672b;

            public void m10917a(C1702a c1702a) {
                c1702a.mo1049a(dutyStatus);
            }
        });
    }
}
