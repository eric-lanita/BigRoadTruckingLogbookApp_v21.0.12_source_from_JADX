package com.bigroad.ttb.android.status.p031a;

import android.content.Context;
import com.bigroad.shared.C1098j;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.ClockMonitor;
import com.bigroad.ttb.android.ClockMonitor.C1196a;
import com.bigroad.ttb.android.ConnectivityTracker;
import com.bigroad.ttb.android.ConnectivityTracker.C1198a;
import com.bigroad.ttb.android.ConnectivityTracker.Connectivity;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener;
import com.bigroad.ttb.android.status.C2264e;
import com.bigroad.ttb.android.status.messages.AppStatusMessages;
import com.bigroad.ttb.android.status.messages.SystemStatusMessages;
import com.bigroad.ttb.android.status.p031a.C2241e.C1441a;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.List;

public class C2256c extends C2241e {
    private static C2256c f7825m;
    private final C2242a f7826a = OurApplication.m6253J();
    private final C2260d f7827b = OurApplication.m6254K();
    private final ClockMonitor f7828c = OurApplication.m6262S();
    private final C2474y f7829d = OurApplication.m6285g();
    private final TruckManager f7830e = OurApplication.m6294p();
    private final ConnectivityTracker f7831f = OurApplication.m6244A();
    private Context f7832g;
    private final C1441a f7833h = new C22511(this);
    private final C1196a f7834i = new C22522(this);
    private final C1182a f7835j = new C22533(this);
    private final ChangeListener f7836k = new C22544(this);
    private final C1198a f7837l = new C22555(this);

    class C22511 implements C1441a {
        final /* synthetic */ C2256c f7820a;

        C22511(C2256c c2256c) {
            this.f7820a = c2256c;
        }

        public void mo996a(C2241e c2241e) {
            this.f7820a.m11052f();
        }
    }

    class C22522 implements C1196a {
        final /* synthetic */ C2256c f7821a;

        C22522(C2256c c2256c) {
            this.f7821a = c2256c;
        }

        public void mo1260a(ClockMonitor clockMonitor) {
            this.f7821a.m11052f();
        }
    }

    class C22533 extends C1183b {
        final /* synthetic */ C2256c f7822a;

        C22533(C2256c c2256c) {
            this.f7822a = c2256c;
        }

        public void mo870g(C2474y c2474y) {
            this.f7822a.m11052f();
        }
    }

    class C22544 extends C1203b {
        final /* synthetic */ C2256c f7823a;

        C22544(C2256c c2256c) {
            this.f7823a = c2256c;
        }

        public void mo894a(Truck truck) {
            this.f7823a.m11052f();
        }
    }

    class C22555 implements C1198a {
        final /* synthetic */ C2256c f7824a;

        C22555(C2256c c2256c) {
            this.f7824a = c2256c;
        }

        public void mo1005a(ConnectivityTracker connectivityTracker) {
            this.f7824a.m11052f();
        }
    }

    public static C2256c m11089a(Context context) {
        if (f7825m == null) {
            f7825m = new C2256c(context);
        }
        return f7825m;
    }

    private C2256c(Context context) {
        this.f7832g = context;
        this.f7826a.m11048a(this.f7833h);
        this.f7827b.m11048a(this.f7833h);
        this.f7828c.m6099a(this.f7834i);
        this.f7829d.m12184a(this.f7835j);
        this.f7830e.m6559a(this.f7836k);
        this.f7831f.m6110a(this.f7837l);
        m11052f();
    }

    protected boolean mo1262c() {
        return true;
    }

    protected List<C2264e> mo1263d() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f7827b.m11053g());
        arrayList.addAll(this.f7826a.m11053g());
        if (this.f7830e.m6570b() && this.f7831f.m6111b() != Connectivity.CONNECTED) {
            arrayList.add(new C2264e(AppStatusMessages.TRUCK_NOT_CREATED));
        }
        if (this.f7828c.m6104d()) {
            arrayList.add(new C2264e(SystemStatusMessages.CLOCK_SKEW));
        }
        if (C2291k.m11221b(this.f7832g).m5443a(new C1098j(this.f7829d.m12170O())) < 0) {
            arrayList.add(new C2264e(AppStatusMessages.OUT_OF_DATE));
        }
        return arrayList;
    }
}
