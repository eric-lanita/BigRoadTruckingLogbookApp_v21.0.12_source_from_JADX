package com.bigroad.ttb.android.status.p031a;

import com.bigroad.shared.ap;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.aobrd.MalfunctionReason;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.status.C2264e;
import com.bigroad.ttb.android.status.C2266c;
import com.bigroad.ttb.android.status.C2267d;
import com.bigroad.ttb.android.status.messages.MalfunctionMessages;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener.Priority;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class C2260d extends C2241e {
    private static C2260d f7841l;
    private final VehicleConnectionManager f7842a = OurApplication.m6252I();
    private final TruckManager f7843b = OurApplication.m6294p();
    private final ap f7844c = OurApplication.m6269Z();
    private final EventManager f7845d = OurApplication.m6295q();
    private List<C2267d> f7846e = Collections.emptyList();
    private long f7847f = -2;
    private Map<MalfunctionReason, Long> f7848g = Collections.emptyMap();
    private boolean f7849h = false;
    private final ChangeListener f7850i = new C22571(this);
    private final TruckManager.ChangeListener f7851j = new C22582(this);
    private final EventManager.ChangeListener f7852k = new C22593(this);

    class C22571 extends C1201a {
        final /* synthetic */ C2260d f7838a;

        C22571(C2260d c2260d) {
            this.f7838a = c2260d;
        }

        public void mo890a(C2369i c2369i) {
            this.f7838a.m11052f();
        }

        public void mo887a(ProcessingState processingState) {
            this.f7838a.m11052f();
        }
    }

    class C22582 extends C1203b {
        final /* synthetic */ C2260d f7839a;

        C22582(C2260d c2260d) {
            this.f7839a = c2260d;
        }

        public void mo894a(Truck truck) {
            this.f7839a.m11052f();
        }
    }

    class C22593 extends C1199e {
        final /* synthetic */ C2260d f7840a;

        C22593(C2260d c2260d) {
            this.f7840a = c2260d;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f7840a.m11052f();
        }
    }

    public static C2260d m11096a() {
        if (f7841l == null) {
            f7841l = new C2260d();
        }
        return f7841l;
    }

    private C2260d() {
        this.f7842a.m11400a(this.f7850i, Priority.MALFUNCTION_MONITOR);
        this.f7843b.m6560a(this.f7851j, TruckManager.ChangeListener.Priority.MALFUNCTION_MONITOR);
        this.f7845d.m10013a(this.f7852k, EventManager.ChangeListener.Priority.MALFUNCTION_MONITOR);
        m11052f();
    }

    private void m11098a(MalfunctionReason malfunctionReason, long j, ArrayList<C2267d> arrayList) {
        if (j > 0) {
            C2266c a = MalfunctionMessages.m11124a(malfunctionReason);
            if (a != null) {
                arrayList.add(new C2267d(a, this.f7844c.mo915c(), Long.valueOf(j)));
            }
        }
    }

    public C2267d m11099b() {
        C2267d c2267d;
        synchronized (this) {
            long c = this.f7844c.mo915c();
            for (C2267d c2267d2 : this.f7846e) {
                if (c2267d2.m11108a(c)) {
                    break;
                }
            }
            c2267d2 = null;
        }
        return c2267d2;
    }

    public boolean m11102e() {
        return m11099b() != null;
    }

    private Map<MalfunctionReason, Long> m11097a(Long l) {
        Truck truck = null;
        if (l != null) {
            truck = this.f7843b.m6552a(l.longValue());
        }
        if (truck == null || !truck.getHasAobrd()) {
            return Collections.emptyMap();
        }
        return this.f7845d.m10049e(truck.getTruckId());
    }

    protected boolean mo1262c() {
        boolean i = this.f7842a.m11411i();
        long g = this.f7843b.m6580g();
        if (i) {
            if (m11097a(Long.valueOf(g)) == this.f7848g && i == this.f7849h && g == this.f7847f) {
                return false;
            }
            return true;
        } else if (!this.f7849h && this.f7848g.isEmpty() && g == this.f7847f) {
            return false;
        } else {
            return true;
        }
    }

    protected List<C2264e> mo1263d() {
        this.f7847f = this.f7843b.m6580g();
        this.f7849h = this.f7842a.m11411i();
        this.f7848g = m11097a(Long.valueOf(this.f7847f));
        Collection arrayList = new ArrayList();
        long b = this.f7844c.mo914b();
        for (MalfunctionReason malfunctionReason : MalfunctionReason.values()) {
            Long l = (Long) this.f7848g.get(malfunctionReason);
            if (l != null) {
                m11098a(malfunctionReason, l.longValue() - b, arrayList);
            }
        }
        this.f7846e = arrayList;
        return new ArrayList(arrayList);
    }
}
