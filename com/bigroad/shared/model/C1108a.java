package com.bigroad.shared.model;

import com.bigroad.shared.C1134q;
import com.bigroad.shared.C1134q.C1132a;
import com.bigroad.shared.aa;
import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

public class C1108a extends C1107b {
    public static final Comparator<C1108a> f3622a = new C11041();
    public static final Function<AutoDailyLogTruck, C1108a> f3623b = new C11052();
    private final String f3624c;
    private final byte[] f3625d;
    private final long f3626e;
    private final long f3627f;
    private final Long f3628g;
    private final long f3629h;
    private final long f3630i;
    private final Long f3631j;
    private final long f3632k = ((long) m5503x().m5469a((long) (mo780g().intValue() - mo779f().intValue())));
    private final CanonicalOdometerSource f3633l;
    private final CanonicalOdometerSource f3634m;
    private final Long f3635n;
    private final Long f3636o;

    static class C11041 implements Comparator<C1108a> {
        C11041() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m5477a((C1108a) obj, (C1108a) obj2);
        }

        public int m5477a(C1108a c1108a, C1108a c1108a2) {
            return aa.m4141c(c1108a.m5505b(), c1108a2.m5505b());
        }
    }

    static class C11052 implements Function<AutoDailyLogTruck, C1108a> {
        C11052() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m5478a((AutoDailyLogTruck) obj);
        }

        public C1108a m5478a(AutoDailyLogTruck autoDailyLogTruck) {
            return C1108a.m5496a(autoDailyLogTruck);
        }
    }

    public C1108a(TruckLogType truckLogType, String str, byte[] bArr, String str2, String str3, long j, long j2, Long l, long j3, long j4, Long l2, CanonicalOdometerUnit canonicalOdometerUnit, CanonicalOdometerSource canonicalOdometerSource, CanonicalOdometerSource canonicalOdometerSource2, Long l3, Long l4) {
        super(truckLogType, str2, str3, canonicalOdometerUnit);
        this.f3624c = str;
        this.f3625d = bArr;
        this.f3626e = j;
        this.f3627f = j2;
        this.f3629h = j3;
        this.f3630i = j4;
        this.f3633l = canonicalOdometerSource;
        this.f3634m = canonicalOdometerSource2;
        this.f3628g = l;
        this.f3631j = l2;
        this.f3635n = l3;
        this.f3636o = l4;
    }

    public String m5504a() {
        return this.f3624c;
    }

    public long m5505b() {
        return this.f3626e;
    }

    public long m5506c() {
        return this.f3627f;
    }

    public long m5507d() {
        return this.f3630i;
    }

    public long m5508e() {
        return this.f3632k;
    }

    private double m5501v() {
        return m5503x().m5471b(m5506c());
    }

    private double m5502w() {
        return m5503x().m5471b(m5507d());
    }

    public Integer mo779f() {
        return Integer.valueOf((int) Math.round(m5501v()));
    }

    public Integer mo780g() {
        return Integer.valueOf((int) Math.round(m5502w()));
    }

    public double m5511h() {
        return m5503x().m5471b(m5508e());
    }

    public Integer mo781i() {
        return Integer.valueOf((int) Math.round(m5511h()));
    }

    public Long m5513j() {
        return this.f3635n;
    }

    public String m5514k() {
        return DailyLogUtils.m4296a(this.f3636o);
    }

    public Long m5515l() {
        return this.f3636o;
    }

    public static C1108a m5496a(AutoDailyLogTruck autoDailyLogTruck) {
        CanonicalOdometerSource a;
        TruckLogType truckLogType = TruckLogType.UNKNOWN_LOG_TYPE;
        String truckVin = !am.m4188a(autoDailyLogTruck.getTruckVin()) ? autoDailyLogTruck.getTruckVin() : null;
        byte[] d = autoDailyLogTruck.hasTruckDashLink() ? autoDailyLogTruck.getTruckDashLink().m19091d() : null;
        String truckNumber = autoDailyLogTruck.getTruckNumber();
        String truckLicense = autoDailyLogTruck.hasTruckLicense() ? autoDailyLogTruck.getTruckLicense() : null;
        long startTime = autoDailyLogTruck.getStartTime();
        long startDistance = autoDailyLogTruck.getStartDistance();
        Long valueOf = Long.valueOf(autoDailyLogTruck.getRawStartDistance());
        long endTime = autoDailyLogTruck.getEndTime();
        long endDistance = autoDailyLogTruck.getEndDistance();
        Long valueOf2 = Long.valueOf(autoDailyLogTruck.getRawEndDistance());
        CanonicalOdometerUnit a2 = autoDailyLogTruck.hasOdometerUnit() ? CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(autoDailyLogTruck.getOdometerUnit())) : null;
        CanonicalOdometerSource a3 = autoDailyLogTruck.hasStartOdometerSource() ? CanonicalOdometerSource.m5459a(autoDailyLogTruck.getStartOdometerSource()) : null;
        if (autoDailyLogTruck.hasEndOdometerSource()) {
            a = CanonicalOdometerSource.m5459a(autoDailyLogTruck.getEndOdometerSource());
        } else {
            a = null;
        }
        return new C1108a(truckLogType, truckVin, d, truckNumber, truckLicense, startTime, startDistance, valueOf, endTime, endDistance, valueOf2, a2, a3, a, null, null);
    }

    public static List<C1108a> m5498a(List<AutoDailyLogTruck> list) {
        return Lists.m18641a((List) list, f3623b);
    }

    private static List<C1108a> m5500b(int i, String str, boolean z, C0864i c0864i, long j) {
        TimeZone timeZone = TimeZone.getTimeZone(str);
        long timeInMillis = DailyLogUtils.m4298a(i, timeZone).getTimeInMillis();
        long timeInMillis2 = DailyLogUtils.m4304b(i, timeZone).getTimeInMillis();
        List<C1112c> a = C1112c.m5578a(str, i, z, c0864i.mo699a(), j);
        Map hashMap = new HashMap();
        for (C1112c c1112c : a) {
            Long c = c1112c.m5583c();
            if (c != null) {
                if (!hashMap.containsKey(c)) {
                    hashMap.put(c, new ArrayList());
                }
                ((List) hashMap.get(c)).add(c1112c);
            }
        }
        List<C1108a> arrayList = new ArrayList(hashMap.size());
        for (Entry entry : hashMap.entrySet()) {
            Collections.sort((List) entry.getValue(), C1112c.f3666a);
            Truck truck = null;
            if (entry.getKey() != null) {
                truck = (Truck) c0864i.mo700b().get(entry.getKey());
            }
            arrayList.addAll(C1108a.m5499a((List) entry.getValue(), truck, timeInMillis, timeInMillis2));
        }
        return arrayList;
    }

    public static List<C1108a> m5497a(int i, String str, boolean z, C0864i c0864i, long j) {
        return C1108a.m5500b(i, str, z, c0864i, j);
    }

    public static List<C1108a> m5499a(List<C1112c> list, Truck truck, long j, long j2) {
        List<C1108a> arrayList = new ArrayList();
        CanonicalOdometerUnit canonicalOdometerUnit = null;
        if (truck != null && truck.hasOdometerUnit()) {
            canonicalOdometerUnit = CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(truck.getOdometerUnit()));
        }
        if (canonicalOdometerUnit == null) {
            canonicalOdometerUnit = CanonicalOdometerUnit.MILES;
        }
        C1112c c1112c = null;
        TruckLogType truckLogType = TruckLogType.ELECTRONIC;
        if (truck == null || !truck.hasTruckLogType()) {
            truckLogType = TruckLogType.UNKNOWN_LOG_TYPE;
        }
        Long valueOf = Long.valueOf(0);
        Long valueOf2 = Long.valueOf(0);
        TruckLogType truckLogType2 = truckLogType;
        C1112c c1112c2 = null;
        for (C1112c c1112c3 : list) {
            if (c1112c3.m5594n() != null && (valueOf == null || c1112c3.m5594n().longValue() > valueOf.longValue())) {
                valueOf = c1112c3.m5594n();
            }
            if (c1112c3.m5595o() != null && (valueOf2 == null || c1112c3.m5595o().longValue() > valueOf2.longValue())) {
                valueOf2 = c1112c3.m5595o();
            }
            if (C1134q.m5725a(c1112c3) && c1112c3.m5596p() && c1112c3.mo702m().m4397e()) {
                if (!truckLogType2.equals(TruckLogType.ELD)) {
                    truckLogType2 = TruckLogType.AOBRD;
                }
                if (c1112c3.m5586f()) {
                    truckLogType2 = TruckLogType.ELD;
                }
                if (c1112c2 == null || c1112c == null) {
                    c1112c = c1112c3;
                    c1112c2 = c1112c3;
                } else {
                    if (Math.abs(CanonicalOdometerUnit.MILES.m5468a(canonicalOdometerUnit.m5469a((long) c1112c3.m5589i().intValue()) - (canonicalOdometerUnit.m5469a((long) c1112c.m5589i().intValue()) + ((double) c1112c.m5588h().longValue())))) > 10.0d) {
                        arrayList.add(C1108a.m5495a(c1112c2, c1112c, truck, canonicalOdometerUnit, j, j2, truckLogType2, valueOf, valueOf2));
                        valueOf = Long.valueOf(0);
                        valueOf2 = Long.valueOf(0);
                        c1112c2 = c1112c3;
                    }
                    c1112c = c1112c3;
                }
            }
        }
        if (c1112c2 != null) {
            arrayList.add(C1108a.m5495a(c1112c2, c1112c, truck, canonicalOdometerUnit, j, j2, truckLogType2, valueOf, valueOf2));
        }
        return arrayList;
    }

    private static C1108a m5495a(C1112c c1112c, C1112c c1112c2, Truck truck, CanonicalOdometerUnit canonicalOdometerUnit, long j, long j2, TruckLogType truckLogType, Long l, Long l2) {
        long j3;
        long j4;
        long j5;
        byte[] bArr;
        if (c1112c.mo721a() < j) {
            j3 = C1134q.m5723a(c1112c, canonicalOdometerUnit, j, true).f3787a;
        } else {
            j3 = Math.round(canonicalOdometerUnit.m5469a((long) c1112c.m5589i().intValue()));
        }
        long j6;
        if (c1112c2.m5585e() > j2) {
            C1132a a = C1134q.m5723a(c1112c2, canonicalOdometerUnit, j2, false);
            j6 = a.f3787a;
            j4 = a.f3788b;
            j5 = j6;
        } else {
            j6 = Math.round(canonicalOdometerUnit.m5469a((long) c1112c2.m5589i().intValue()));
            j4 = c1112c2.m5588h().longValue();
            j5 = j6;
        }
        String vin = (truck == null || !truck.hasVin()) ? null : truck.getVin();
        if (truck == null || !truck.hasAssociatedDashLink()) {
            bArr = null;
        } else {
            bArr = truck.getAssociatedDashLink().m19091d();
        }
        String truckNumber = (truck == null || !truck.hasTruckNumber()) ? null : truck.getTruckNumber();
        String truckLicense = (truck == null || !truck.hasTruckLicense()) ? null : truck.getTruckLicense();
        return new C1108a(truckLogType, vin, bArr, truckNumber, truckLicense, c1112c.m5584d(), j3, null, Math.min(c1112c2.mo721a() + c1112c2.m5587g().longValue(), j2), j5 + j4, null, canonicalOdometerUnit, null, null, l, l2);
    }

    private CanonicalOdometerUnit m5503x() {
        return m5494u() ? m5492s() : CanonicalOdometerUnit.MILES;
    }
}
