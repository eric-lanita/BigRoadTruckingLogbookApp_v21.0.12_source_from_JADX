package com.bigroad.shared.gaps.model;

import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.OdometerSegment;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.google.common.collect.C3540t;
import com.google.common.collect.C3589f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C1091d {
    public static final Comparator<C1091d> f3536a = new C10881();
    public static final Comparator<C1091d> f3537b = new C10892();
    public static final Comparator<C1091d> f3538c = new C10903();
    private final OdometerSegmentType f3539d;
    private final int f3540e;
    private final long f3541f;
    private final String f3542g;
    private final boolean f3543h;
    private final CanonicalOdometerUnit f3544i;
    private final long f3545j;
    private final CanonicalOdometerUnit f3546k;
    private final long f3547l;
    private final long f3548m;

    static class C10881 implements Comparator<C1091d> {
        C10881() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5401a((C1091d) obj, (C1091d) obj2);
        }

        public int m5401a(C1091d c1091d, C1091d c1091d2) {
            return C3589f.m18773a().mo2737a(c1091d.f3539d, c1091d2.f3539d).mo2735a(c1091d.f3540e, c1091d2.f3540e).mo2736a(c1091d.f3541f, c1091d2.f3541f).mo2738a(c1091d.f3542g, c1091d2.f3542g, C3540t.m18450c().mo2709b()).m18779a(Boolean.valueOf(c1091d.f3543h), Boolean.valueOf(c1091d2.f3543h)).mo2737a(c1091d.f3544i, c1091d2.f3544i).mo2736a(c1091d.f3545j, c1091d2.f3545j).mo2737a(c1091d.f3546k, c1091d2.f3546k).mo2736a(c1091d.f3547l, c1091d2.f3547l).mo2736a(c1091d.f3548m, c1091d2.f3548m).mo2740b();
        }
    }

    static class C10892 implements Comparator<C1091d> {
        C10892() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5402a((C1091d) obj, (C1091d) obj2);
        }

        public int m5402a(C1091d c1091d, C1091d c1091d2) {
            return C3589f.m18773a().mo2737a(c1091d.f3539d, c1091d2.f3539d).mo2735a(c1091d.f3540e, c1091d2.f3540e).mo2736a(c1091d.f3541f, c1091d2.f3541f).mo2738a(c1091d.f3542g, c1091d2.f3542g, C3540t.m18450c().mo2709b()).mo2736a(c1091d.f3545j, c1091d2.f3545j).mo2736a(c1091d.f3547l, c1091d2.f3547l).mo2736a(c1091d.f3548m, c1091d2.f3548m).mo2740b();
        }
    }

    static class C10903 implements Comparator<C1091d> {
        C10903() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5403a((C1091d) obj, (C1091d) obj2);
        }

        public int m5403a(C1091d c1091d, C1091d c1091d2) {
            return Long.signum(c1091d2.m5426j() - c1091d.m5426j());
        }
    }

    public C1091d(C1072a c1072a) {
        long j = 0;
        this.f3539d = OdometerSegmentType.TRUCK_LOG;
        this.f3540e = c1072a.mo770a();
        this.f3541f = c1072a.mo771b();
        this.f3542g = c1072a.mo772c();
        this.f3544i = c1072a.mo776g();
        this.f3546k = this.f3544i;
        long f = c1072a.mo775f();
        Long d = c1072a.mo773d();
        Long e = c1072a.mo774e();
        boolean z = false;
        if (e == null) {
            if (d == null) {
                z = true;
            } else {
                e = Long.valueOf(d.longValue() + f);
            }
        } else if (d == null) {
            d = Long.valueOf(e.longValue() - f);
        } else {
            f = e.longValue() - d.longValue();
        }
        this.f3543h = z;
        this.f3545j = d == null ? 0 : d.longValue();
        if (e != null) {
            j = e.longValue();
        }
        this.f3547l = j;
        this.f3548m = f;
    }

    public C1091d(C1087c c1087c, int i) {
        this.f3539d = OdometerSegmentType.ODOMETER_ADJUSTMENT;
        this.f3540e = i;
        this.f3541f = c1087c.mo1229e();
        this.f3542g = c1087c.mo1230f();
        this.f3543h = false;
        this.f3544i = c1087c.mo1226b();
        this.f3545j = c1087c.mo1225a();
        this.f3546k = c1087c.mo1228d();
        this.f3547l = c1087c.mo1227c();
        this.f3548m = this.f3547l - this.f3545j;
    }

    public C1091d(long j, CanonicalOdometerUnit canonicalOdometerUnit, long j2, CanonicalOdometerUnit canonicalOdometerUnit2, int i, long j3, String str) {
        this.f3539d = OdometerSegmentType.TRUCK_LOG;
        this.f3540e = i;
        this.f3541f = j3;
        this.f3542g = str;
        this.f3543h = false;
        this.f3545j = j;
        this.f3544i = canonicalOdometerUnit;
        this.f3547l = j2;
        this.f3546k = canonicalOdometerUnit2;
        this.f3548m = this.f3547l - this.f3545j;
    }

    public C1091d(OdometerSegment odometerSegment) {
        this.f3539d = OdometerSegmentType.m5387a(odometerSegment.getSegmentType());
        this.f3540e = odometerSegment.getLogDay();
        this.f3541f = odometerSegment.getOwnerPersonId();
        this.f3542g = odometerSegment.getTruckNumber();
        this.f3543h = odometerSegment.getAmbiguousStartAndEnd();
        if (odometerSegment.hasStartOdometerUnit()) {
            this.f3544i = CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(odometerSegment.getStartOdometerUnit()));
        } else {
            this.f3544i = null;
        }
        this.f3545j = odometerSegment.getStartMeters();
        if (odometerSegment.hasEndOdometerUnit()) {
            this.f3546k = CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(odometerSegment.getEndOdometerUnit()));
        } else {
            this.f3546k = null;
        }
        this.f3547l = odometerSegment.getEndMeters();
        this.f3548m = odometerSegment.getDistanceMeters();
    }

    public OdometerSegmentType m5417a() {
        return this.f3539d;
    }

    public int m5418b() {
        return this.f3540e;
    }

    public long m5419c() {
        return this.f3541f;
    }

    public String m5420d() {
        return this.f3542g;
    }

    public long m5421e() {
        return this.f3545j;
    }

    public CanonicalOdometerUnit m5422f() {
        return this.f3544i;
    }

    public long m5423g() {
        return this.f3547l;
    }

    public CanonicalOdometerUnit m5424h() {
        return this.f3546k;
    }

    public boolean m5425i() {
        return this.f3543h;
    }

    public long m5426j() {
        return this.f3548m;
    }

    public static List<C1091d> m5406a(List<OdometerSegment> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        List<C1091d> arrayList = new ArrayList(list.size());
        for (OdometerSegment c1091d : list) {
            arrayList.add(new C1091d(c1091d));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f3539d.m5388a());
        stringBuilder.append("(");
        if (m5425i()) {
            stringBuilder.append(Math.round(this.f3544i.m5471b(this.f3548m)));
            stringBuilder.append(this.f3544i.m5470a());
        } else {
            stringBuilder.append("day " + this.f3540e + ", ");
            stringBuilder.append(Math.round(this.f3544i.m5471b(this.f3545j)));
            stringBuilder.append(this.f3544i.m5470a());
            stringBuilder.append("-");
            stringBuilder.append(Math.round(this.f3546k.m5471b(this.f3547l)));
            stringBuilder.append(this.f3546k.m5470a());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static C1091d m5405a(C1091d c1091d, C1091d c1091d2) {
        return new C1091d(Math.min(c1091d.m5421e(), c1091d2.m5421e()), c1091d.m5422f(), Math.max(c1091d.m5423g(), c1091d2.m5423g()), c1091d.m5424h(), c1091d.m5418b(), c1091d.m5419c(), c1091d.m5420d());
    }

    public static boolean m5408b(C1091d c1091d, C1091d c1091d2) {
        if (c1091d == null || c1091d2 == null || c1091d.m5418b() != c1091d2.m5418b() || c1091d.m5421e() > c1091d2.m5421e() || c1091d2.m5421e() > c1091d.m5423g() || c1091d.m5420d() == null || !c1091d.m5420d().equals(c1091d2.m5420d())) {
            return false;
        }
        return true;
    }
}
