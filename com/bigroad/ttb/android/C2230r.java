package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1775n;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.FleetList;
import com.bigroad.ttb.protocol.TTProtocol.FleetMembership;
import com.bigroad.ttb.protocol.TTProtocol.YardMoveType;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class C2230r {
    private static C2230r f7721a;
    private final C2474y f7722b = OurApplication.m6285g();
    private final C1790a f7723c = OurApplication.m6287i();
    private C3642c f7724d;
    private final ArrayList<Fleet> f7725e = new ArrayList();
    private final ag<C1331a> f7726f = new ag();
    private final C1182a f7727g = new C22271(this);

    public interface C1331a {
        void mo954a(C2230r c2230r);

        void mo955b(C2230r c2230r);
    }

    public static class C1332b implements C1331a {
        public void mo954a(C2230r c2230r) {
        }

        public void mo955b(C2230r c2230r) {
        }
    }

    class C22271 extends C1183b {
        final /* synthetic */ C2230r f7718a;

        C22271(C2230r c2230r) {
            this.f7718a = c2230r;
        }

        public void mo863a(C2474y c2474y) {
            this.f7718a.m11003i();
        }

        public void mo866c(C2474y c2474y) {
            this.f7718a.m11005k();
        }

        public void mo867d(C2474y c2474y) {
            this.f7718a.m11004j();
        }
    }

    class C22282 implements C0837a<C1331a> {
        final /* synthetic */ C2230r f7719a;

        C22282(C2230r c2230r) {
            this.f7719a = c2230r;
        }

        public void m10994a(C1331a c1331a) {
            c1331a.mo954a(this.f7719a);
        }
    }

    class C22293 implements C0837a<C1331a> {
        final /* synthetic */ C2230r f7720a;

        C22293(C2230r c2230r) {
            this.f7720a = c2230r;
        }

        public void m10996a(C1331a c1331a) {
            c1331a.mo955b(this.f7720a);
        }
    }

    public static C2230r m10998a(Context context) {
        if (f7721a == null) {
            f7721a = new C2230r();
        }
        return f7721a;
    }

    private C2230r() {
        this.f7722b.m12184a(this.f7727g);
        m11002h();
        m11004j();
    }

    private void m11002h() {
        this.f7725e.clear();
        for (C1775n d : this.f7723c.m8708C()) {
            Fleet d2 = d.m8616d();
            if (d2 != null) {
                this.f7725e.add(d2);
            }
        }
    }

    private void m11003i() {
        this.f7724d = null;
        this.f7725e.clear();
        this.f7723c.m8709D();
        m11005k();
    }

    private void m11004j() {
        long g = this.f7722b.m12213g();
        if (g >= 0) {
            FleetMembership u = this.f7722b.m12231u();
            if (u != null && u.getFleetId() == g && u.getPersonId() == this.f7722b.m12202d()) {
                Object obj = (u.getIsAdmin() || u.getIsDispatcher() || u.getIsDriver() || u.getIsSafetyManager()) ? 1 : null;
                if (obj == null) {
                    m11014b(-1);
                }
            }
        }
    }

    public void m11009a(C1331a c1331a) {
        this.f7726f.m4159a(c1331a, 0);
    }

    public void m11015b(C1331a c1331a) {
        this.f7726f.m4158a((Object) c1331a);
    }

    private void m11005k() {
        this.f7726f.m4157a(new C22282(this));
    }

    private void m11006l() {
        this.f7726f.m4157a(new C22293(this));
    }

    public C3642c m11008a() {
        return this.f7724d;
    }

    public void m11011a(Collection<Fleet> collection) {
        this.f7724d = null;
        this.f7725e.clear();
        this.f7725e.addAll(collection);
        this.f7723c.m8796k(this.f7725e);
        m11005k();
    }

    public void m11010a(C3642c c3642c, C3642c c3642c2) {
        if (!c3642c.equals(this.f7724d)) {
            try {
                FleetList parseFrom = FleetList.parseFrom(c3642c2);
                this.f7724d = c3642c;
                this.f7725e.clear();
                this.f7725e.addAll(parseFrom.getFleetList());
                this.f7723c.m8796k(this.f7725e);
                m11005k();
            } catch (Throwable e) {
                C2134e.m10681d("TT-FleetMgr", "Can't parse fleet list.", e);
            }
        }
    }

    public Fleet m11007a(long j) {
        Iterator it = this.f7725e.iterator();
        while (it.hasNext()) {
            Fleet fleet = (Fleet) it.next();
            if (fleet.getFleetId() == j) {
                return fleet;
            }
        }
        return null;
    }

    public Fleet m11013b() {
        return m11007a(this.f7722b.m12213g());
    }

    public String m11016c() {
        Fleet b = m11013b();
        if (b == null || !b.hasName()) {
            return null;
        }
        return b.getName();
    }

    public void m11014b(long j) {
        this.f7722b.m12183a(j);
        this.f7722b.m12187a(null);
    }

    public boolean m11018d() {
        return this.f7722b.m12219i() || m11013b() == null;
    }

    public boolean m11019e() {
        Fleet b = m11013b();
        return b != null && b.hasYardMoveConfig() && b.getYardMoveConfig().getType() == YardMoveType.YARD_MOVE_ALLOWED;
    }

    public Long m11020f() {
        Fleet b = m11013b();
        if (b != null) {
            return Long.valueOf(b.getUnidentifiedDriverId());
        }
        return null;
    }

    public boolean m11017c(long j) {
        return m11020f() != null && m11020f().longValue() == j;
    }

    public void m11012a(boolean z) {
        if (z != this.f7722b.m12219i()) {
            this.f7722b.m12190a(z);
            m11006l();
        }
    }

    public boolean m11021g() {
        Fleet b = m11013b();
        if (b == null) {
            return true;
        }
        if (b.getEldCompliant()) {
            return false;
        }
        return b.getAllowDriverTruckCreation();
    }
}
