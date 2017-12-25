package com.bigroad.ttb.android.status.p031a;

import android.os.Handler;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2081g;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.PowerStatus;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.status.C2263a;
import com.bigroad.ttb.android.status.C2264e;
import com.bigroad.ttb.android.status.C2265b;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2363e;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C2242a extends C2241e {
    private static C2242a f7766z;
    private final C2081g f7767a = OurApplication.m6284f();
    private final VehicleConnectionManager f7768b = OurApplication.m6252I();
    private final TruckManager f7769c = OurApplication.m6294p();
    private final PowerStatus f7770d = OurApplication.m6286h();
    private final AuthMonitor f7771e = OurApplication.m6249F();
    private final C1790a f7772f = OurApplication.m6287i();
    private final ap f7773g = OurApplication.m6269Z();
    private List<C2265b> f7774h = Collections.emptyList();
    private C2338a f7775i;
    private C2338a f7776j;
    private boolean f7777k = false;
    private Truck f7778l = null;
    private EobrDevice f7779m = null;
    private boolean f7780n = false;
    private final Handler f7781o = new Handler();
    private long f7782p = 0;
    private long f7783q = 0;
    private long f7784r = 0;
    private long f7785s = 0;
    private final C1230a f7786t = new C22331(this);
    private final ChangeListener f7787u = new C22342(this);
    private final C1185a f7788v = new C22353(this);
    private final TruckManager.ChangeListener f7789w = new C22364(this);
    private final C1216a f7790x = new C22375(this);
    private final Runnable f7791y = new C22386(this);

    class C22331 extends C1231b {
        final /* synthetic */ C2242a f7752a;

        C22331(C2242a c2242a) {
            this.f7752a = c2242a;
        }

        public void mo906a(C2081g c2081g) {
            this.f7752a.m11052f();
        }
    }

    class C22342 extends C1201a {
        final /* synthetic */ C2242a f7753a;

        C22342(C2242a c2242a) {
            this.f7753a = c2242a;
        }

        public void mo889a(C2363e c2363e) {
            this.f7753a.m11052f();
            this.f7753a.m11062a(false);
        }

        public void mo892b(C2363e c2363e) {
            this.f7753a.m11052f();
            this.f7753a.m11062a(false);
        }

        public void mo888a(C2338a c2338a) {
            this.f7753a.m11052f();
            this.f7753a.m11062a(false);
        }
    }

    class C22353 implements C1185a {
        final /* synthetic */ C2242a f7754a;

        C22353(C2242a c2242a) {
            this.f7754a = c2242a;
        }

        public void mo912a(AuthStatus authStatus) {
            switch (authStatus) {
                case SIGNED_IN:
                    this.f7754a.m11062a(false);
                    return;
                case SIGNED_OUT:
                    this.f7754a.f7785s = 0;
                    this.f7754a.f7772f.m8756b("eobr.lastDashLinkStatusSent");
                    return;
                default:
                    return;
            }
        }
    }

    class C22364 extends C1203b {
        final /* synthetic */ C2242a f7755a;

        C22364(C2242a c2242a) {
            this.f7755a = c2242a;
        }

        public void mo894a(Truck truck) {
            this.f7755a.m11052f();
        }
    }

    class C22375 implements C1216a {
        final /* synthetic */ C2242a f7756a;

        C22375(C2242a c2242a) {
            this.f7756a = c2242a;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f7756a.m11052f();
        }
    }

    class C22386 implements Runnable {
        final /* synthetic */ C2242a f7757a;

        C22386(C2242a c2242a) {
            this.f7757a = c2242a;
        }

        public void run() {
            this.f7757a.m11062a(true);
        }
    }

    class C22397 implements Runnable {
        final /* synthetic */ C2242a f7758a;

        C22397(C2242a c2242a) {
            this.f7758a = c2242a;
        }

        public void run() {
            this.f7758a.m11062a(false);
        }
    }

    public static C2242a m11058a() {
        if (f7766z == null) {
            f7766z = new C2242a();
        }
        return f7766z;
    }

    private C2242a() {
        this.f7767a.m10446a(this.f7786t);
        this.f7768b.m11399a(this.f7787u);
        this.f7769c.m6559a(this.f7789w);
        this.f7770d.m6311a(this.f7790x);
        this.f7771e.m6027a(this.f7788v);
        this.f7776j = C2338a.m11444a(this.f7773g);
        this.f7775i = this.f7776j;
        if (this.f7771e.m6031d()) {
            Long d = this.f7772f.m8769d("eobr.lastDashLinkStatusSent");
            if (d != null) {
                this.f7785s = d.longValue();
                this.f7784r = this.f7773g.mo915c();
            }
        }
        m11052f();
        this.f7781o.post(new C22397(this));
    }

    public C2265b m11064b() {
        C2265b c2265b;
        synchronized (this) {
            long c = this.f7773g.mo915c();
            for (C2265b c2265b2 : this.f7774h) {
                if (c2265b2.m11108a(c)) {
                    break;
                }
            }
            c2265b2 = null;
        }
        return c2265b2;
    }

    protected boolean mo1262c() {
        Truck f = this.f7769c.m6578f();
        Truck e = this.f7768b.m11407e();
        if (e != null && f != null && !e.equals(f)) {
            return false;
        }
        boolean b = this.f7767a.m10450b();
        C2338a d = this.f7768b.m11406d();
        EobrDevice j = this.f7768b.m11412j();
        boolean a = this.f7770d.m6312a();
        if (b == this.f7777k && j == this.f7779m && f == this.f7778l && a == this.f7780n && d.equals(this.f7776j)) {
            return false;
        }
        return true;
    }

    private void m11060a(C2263a c2263a, long j, ArrayList<C2265b> arrayList) {
        if (c2263a != null) {
            arrayList.add(new C2265b(c2263a, j));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m11061a(com.bigroad.ttb.android.vehicle.C2338a r7, long r8, java.util.ArrayList<com.bigroad.ttb.android.status.C2265b> r10) {
        /*
        r6 = this;
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r7 == 0) goto L_0x000c;
    L_0x0004:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.REQUIRED;
        r0 = r7.m11451a(r0);
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.CORRUPTED;
        r0 = r7.m11451a(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x0015:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.CORRUPTED;
        r0 = r7.m11454b(r0);
        if (r0 == 0) goto L_0x0124;
    L_0x001d:
        r0 = r0.longValue();
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0 = r0 + r2;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x0124;
    L_0x0028:
        r2 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.VAR_DATA_CORRUPTED;
        r6.m11060a(r2, r0, r10);
    L_0x002d:
        r0 = com.bigroad.shared.eobr.ConnectionFlag.CONNECTED;
        r0 = r7.m11450a(r0);
        if (r0 == 0) goto L_0x00e5;
    L_0x0035:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.TURBO_FIRMWARE_UPDATING;
        r0 = r7.m11451a(r0);
        if (r0 == 0) goto L_0x0042;
    L_0x003d:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.TURBO_FIRMWARE_UPDATING;
        r6.m11060a(r0, r8, r10);
    L_0x0042:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.FIRMWARE_INCOMPATIBLE;
        r0 = r7.m11451a(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x004a:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.FIRMWARE_NOT_COMPATIBLE;
        r6.m11060a(r0, r8, r10);
    L_0x004f:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.FIRMWARE_DETECTING;
        r0 = r7.m11451a(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x0057:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.FIRMWARE_DETECTING;
        r0 = r7.m11454b(r0);
        if (r0 == 0) goto L_0x0121;
    L_0x005f:
        r0 = r0.longValue();
        r0 = r0 + r4;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x0121;
    L_0x0068:
        r2 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.FIRMWARE_DETECTING;
        r6.m11060a(r2, r0, r10);
    L_0x006d:
        r0 = com.bigroad.shared.eobr.ConnectionFlag.CURRENT;
        r0 = r7.m11450a(r0);
        if (r0 == 0) goto L_0x00d2;
    L_0x0075:
        r0 = com.bigroad.shared.eobr.ConnectionFlag.EOBR_TYPE_MATCH;
        r0 = r7.m11450a(r0);
        if (r0 != 0) goto L_0x0082;
    L_0x007d:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.WRONG_EOBR_TYPE;
        r6.m11060a(r0, r8, r10);
    L_0x0082:
        r0 = com.bigroad.shared.eobr.ConnectionFlag.ODOMETER_READINGS_VALID;
        r0 = r7.m11450a(r0);
        if (r0 != 0) goto L_0x008f;
    L_0x008a:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.NO_ODOMETER;
        r6.m11060a(r0, r8, r10);
    L_0x008f:
        r0 = com.bigroad.shared.eobr.ConnectionFlag.ODOMETER_CALIBRATED;
        r0 = r7.m11450a(r0);
        if (r0 != 0) goto L_0x009c;
    L_0x0097:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.UNCALIBRATED_ODOMETER;
        r6.m11060a(r0, r8, r10);
    L_0x009c:
        r0 = com.bigroad.shared.eobr.ConnectionFlag.ABSOLUTE_TIMESTAMP;
        r0 = r7.m11450a(r0);
        if (r0 != 0) goto L_0x00b7;
    L_0x00a4:
        r0 = r6.f7779m;
        if (r0 == 0) goto L_0x00b7;
    L_0x00a8:
        r0 = r6.f7779m;
        r0 = r0.mo1121o();
        r1 = com.bigroad.shared.eobr.EobrType.TURBO;
        if (r0 != r1) goto L_0x00b7;
    L_0x00b2:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.WAITING_FOR_TURBO_GPS;
        r6.m11060a(r0, r8, r10);
    L_0x00b7:
        r0 = r7.m11449a();
        if (r0 == 0) goto L_0x00c2;
    L_0x00bd:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.RECONNECTING;
        r6.m11060a(r0, r8, r10);
    L_0x00c2:
        r0 = r6.f7780n;
        if (r0 != 0) goto L_0x00cb;
    L_0x00c6:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.CONNECTED_NOT_PLUGGED_IN;
        r6.m11060a(r0, r8, r10);
    L_0x00cb:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.CONNECTED;
        r6.m11060a(r0, r8, r10);
        goto L_0x000c;
    L_0x00d2:
        r0 = com.bigroad.shared.eobr.ConnectionFlag.CONNECTED;
        r0 = r7.m11453b(r0);
        if (r0 == 0) goto L_0x00b7;
    L_0x00da:
        r0 = r0.longValue();
        r0 = r0 + r4;
        r2 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.NOT_CURRENT;
        r6.m11060a(r2, r0, r10);
        goto L_0x00b7;
    L_0x00e5:
        r0 = com.bigroad.shared.eobr.ConnectionSetupFlag.SEARCHING;
        r0 = r7.m11451a(r0);
        if (r0 == 0) goto L_0x00f2;
    L_0x00ed:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.SEARCHING;
        r6.m11060a(r0, r8, r10);
    L_0x00f2:
        r0 = com.bigroad.ttb.android.status.p031a.C2242a.C22408.f7760b;
        r1 = r7.m11455c();
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x0103;
            case 2: goto L_0x010a;
            case 3: goto L_0x0113;
            case 4: goto L_0x011a;
            default: goto L_0x0101;
        };
    L_0x0101:
        goto L_0x000c;
    L_0x0103:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.NO_VIN_SPECIFIED;
        r6.m11060a(r0, r8, r10);
        goto L_0x000c;
    L_0x010a:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.BLUETOOTH_DISABLED;
        r2 = 0;
        r6.m11060a(r0, r2, r10);
        goto L_0x000c;
    L_0x0113:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.BLUETOOTH_UNSUPPORTED;
        r6.m11060a(r0, r8, r10);
        goto L_0x000c;
    L_0x011a:
        r0 = com.bigroad.ttb.android.status.messages.DashLinkStatusMessages.DISCONNECTED;
        r6.m11060a(r0, r8, r10);
        goto L_0x000c;
    L_0x0121:
        r0 = r8;
        goto L_0x0068;
    L_0x0124:
        r0 = r8;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.status.a.a.a(com.bigroad.ttb.android.vehicle.a, long, java.util.ArrayList):void");
    }

    protected List<C2264e> mo1263d() {
        this.f7777k = this.f7767a.m10450b();
        this.f7776j = this.f7768b.m11406d();
        this.f7778l = this.f7769c.m6578f();
        this.f7779m = this.f7768b.m11412j();
        this.f7780n = this.f7770d.m6312a();
        ArrayList arrayList = new ArrayList();
        if (!this.f7776j.m11451a(ConnectionSetupFlag.RECONNECTING) || this.f7775i == null) {
            this.f7775i = this.f7776j;
        }
        Long b = this.f7776j.m11452b();
        if (!(b == null || this.f7775i.equals(this.f7776j))) {
            m11061a(this.f7776j, b.longValue(), arrayList);
        }
        m11061a(this.f7775i, 0, arrayList);
        this.f7774h = arrayList;
        return new ArrayList(this.f7774h);
    }

    private void m11063e() {
        this.f7781o.removeCallbacks(this.f7791y);
        this.f7782p = 0;
        this.f7783q = 0;
    }

    private void m11062a(boolean z) {
        if (!this.f7771e.m6030c()) {
            EobrDevice j = this.f7768b.m11412j();
            C2338a d = this.f7768b.m11406d();
            long j2 = 0;
            if (d.m11451a(ConnectionSetupFlag.REQUIRED)) {
                if (j != null) {
                    j2 = j.m9002n();
                }
                j2 = d.m11448a(j2);
            }
            if (this.f7784r <= 0 || j2 != this.f7785s) {
                long c = this.f7773g.mo915c();
                if (!z && c < this.f7782p) {
                    return;
                }
                if (z || this.f7782p > 0 || (this.f7785s & 1) != 0 || (1 & j2) != 1) {
                    long a;
                    Object obj = this.f7784r <= 0 ? 1 : null;
                    Object obj2 = (obj == null || d.m11451a(ConnectionSetupFlag.REQUIRED)) ? null : 1;
                    if (!z || this.f7783q <= 0) {
                        a = this.f7773g.mo913a();
                    } else {
                        a = this.f7783q;
                    }
                    m11063e();
                    this.f7784r = this.f7773g.mo915c();
                    this.f7785s = j2;
                    if (obj2 == null) {
                        OurApplication.m6295q().m10050e(C2022a.m10076a(OurApplication.ac(), a, (obj != null ? 32768 : 65536) | j2, j));
                        this.f7772f.m8740a("eobr.lastDashLinkStatusSent", Long.valueOf(this.f7785s));
                        return;
                    }
                    return;
                }
                this.f7782p = 10000 + c;
                this.f7783q = this.f7773g.mo913a();
                this.f7781o.removeCallbacks(this.f7791y);
                this.f7781o.postDelayed(this.f7791y, 10000);
            }
        }
    }
}
