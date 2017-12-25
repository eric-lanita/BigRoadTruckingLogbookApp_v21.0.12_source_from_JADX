package com.bigroad.shared.model;

import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.dailylog.DailyLogUtils.C0859a;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0875a;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.model.C1125g.C1124a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.RecapType;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.google.common.collect.C3600n;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class C1116d extends C0875a {
    private final String f3725a;
    private final String f3726b;
    private final C1115b f3727c;
    private final ImmutableList<C1108a> f3728d;
    private final ImmutableList<C1108a> f3729e;
    private final ImmutableList<C1118e> f3730f;
    private final ImmutableList<String> f3731g;
    private final ImmutableList<String> f3732h;
    private final Integer f3733i;
    private final CanonicalOdometerUnit f3734j;
    private final String f3735k;
    private final String f3736l;
    private final String f3737m;
    private final String f3738n;
    private final String f3739o;
    private final String f3740p;
    private final Date f3741q;
    private final byte[] f3742r;
    private final byte[] f3743s;
    private final CanonicalRecapType f3744t;
    private final Date f3745u;
    private final Long f3746v;
    private final C1125g f3747w;
    private final Date f3748x;
    private final C1125g f3749y;

    public static class C1114a {
        private C0874m f3696a;
        private String f3697b;
        private String f3698c;
        private C1115b f3699d;
        private ImmutableList<C1108a> f3700e = ImmutableList.m18516d();
        private ImmutableList<C1108a> f3701f = ImmutableList.m18516d();
        private ImmutableList<C1118e> f3702g = ImmutableList.m18516d();
        private ImmutableList<String> f3703h = ImmutableList.m18516d();
        private ImmutableList<String> f3704i = ImmutableList.m18516d();
        private String f3705j;
        private Integer f3706k;
        private CanonicalOdometerUnit f3707l;
        private String f3708m;
        private String f3709n;
        private String f3710o;
        private String f3711p;
        private String f3712q;
        private Date f3713r;
        private byte[] f3714s;
        private byte[] f3715t;
        private CanonicalRecapType f3716u;
        private Date f3717v;
        private Long f3718w;
        private C1125g f3719x;
        private Date f3720y;
        private C1125g f3721z;

        public C1114a(C0874m c0874m) {
            this.f3696a = c0874m;
        }

        public static C1114a m5598a(DailyLog dailyLog, C0864i c0864i, long j) {
            Integer num = null;
            Object c0956v = new C0956v((al) dailyLog);
            C1114a c1114a = new C1114a(c0956v);
            if (dailyLog.hasDriverName()) {
                c1114a.m5631a(dailyLog.getDriverName());
            }
            if (dailyLog.hasCodriversDeprecated()) {
                c1114a.m5636b(dailyLog.getCodriversDeprecated());
            }
            if (dailyLog.hasTrucksDeprecated() || dailyLog.hasStartOdometerDeprecated() || dailyLog.hasEndOdometerDeprecated()) {
                Integer valueOf;
                String trucksDeprecated = dailyLog.hasTrucksDeprecated() ? dailyLog.getTrucksDeprecated() : null;
                if (dailyLog.hasStartOdometerDeprecated()) {
                    valueOf = Integer.valueOf(dailyLog.getStartOdometerDeprecated());
                } else {
                    valueOf = null;
                }
                if (dailyLog.hasEndOdometerDeprecated()) {
                    num = Integer.valueOf(dailyLog.getEndOdometerDeprecated());
                }
                c1114a.m5627a(new C1115b(trucksDeprecated, valueOf, num));
            }
            List arrayList = new ArrayList();
            if (dailyLog.getAutoDailyLogTruckCount() > 0) {
                arrayList.addAll(C1108a.m5498a(dailyLog.getAutoDailyLogTruckList()));
            }
            Collection a = C1108a.m5497a(dailyLog.getLogDay(), c0956v.mo703a(), dailyLog.hasDriverApproval(), c0864i, j);
            if (a.size() > 0) {
                arrayList.addAll(a);
            }
            if (arrayList.size() > 0) {
                c1114a.m5633a(arrayList);
            }
            if (dailyLog.hasDailyLogTruckList() && dailyLog.getDailyLogTruckList().getDailyLogTruckCount() > 0) {
                c1114a.m5637b(C1118e.m5677a(dailyLog.getDailyLogTruckList().getDailyLogTruckList()));
            }
            if (dailyLog.hasTrailersDeprecated()) {
                c1114a.m5638c(dailyLog.getTrailersDeprecated());
            }
            if (dailyLog.hasTotalDistance()) {
                c1114a.m5630a(Integer.valueOf(dailyLog.getTotalDistance()));
            }
            if (dailyLog.hasTotalDistanceUnit()) {
                c1114a.m5625a(CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(dailyLog.getTotalDistanceUnit())));
            }
            if (dailyLog.hasCarrierName()) {
                c1114a.m5640d(dailyLog.getCarrierName());
            }
            if (dailyLog.hasCarrierAddress()) {
                c1114a.m5642e(dailyLog.getCarrierAddress());
            }
            if (dailyLog.hasHomeTerminalAddress()) {
                c1114a.m5643f(dailyLog.getHomeTerminalAddress());
            }
            if (dailyLog.hasShipmentsDeprecated()) {
                c1114a.m5644g(dailyLog.getShipmentsDeprecated());
            }
            if (dailyLog.hasRemarks()) {
                c1114a.m5645h(dailyLog.getRemarks());
            }
            c1114a.m5626a(CanonicalRecapType.m5475a(RecapType.m14775a(dailyLog.getRecapType())));
            if (dailyLog.hasDriverApproval()) {
                c1114a.m5632a(new Date(dailyLog.getDriverApproval()));
            }
            if (dailyLog.hasSignatureId()) {
                c1114a.m5634a(dailyLog.getSignatureId().m19091d());
            }
            if (dailyLog.hasAmendedBy() && dailyLog.hasAmendedAt()) {
                c1114a.m5629a(C1125g.m5704a(dailyLog.getAmendedBy()), new Date(dailyLog.getAmendedAt()));
            }
            if (dailyLog.hasCodriverId()) {
                c1114a.m5628a(new C1124a(dailyLog.getCodriverId()).m5703a());
            }
            if (dailyLog.getTrailersCount() > 0) {
                c1114a.m5639c(dailyLog.getTrailersList());
            }
            if (dailyLog.getShipmentsCount() > 0) {
                c1114a.m5641d(dailyLog.getShipmentsList());
            }
            return c1114a;
        }

        public C1114a m5631a(String str) {
            this.f3697b = str;
            return this;
        }

        public C1114a m5636b(String str) {
            this.f3698c = str;
            return this;
        }

        public C1114a m5627a(C1115b c1115b) {
            this.f3699d = c1115b;
            return this;
        }

        public C1114a m5633a(List<C1108a> list) {
            this.f3700e = ImmutableList.m18511a((Collection) list);
            return this;
        }

        public C1114a m5637b(List<C1118e> list) {
            this.f3702g = ImmutableList.m18511a((Collection) list);
            return this;
        }

        public C1114a m5638c(String str) {
            this.f3705j = str;
            return this;
        }

        public C1114a m5630a(Integer num) {
            this.f3706k = num;
            return this;
        }

        public C1114a m5625a(CanonicalOdometerUnit canonicalOdometerUnit) {
            this.f3707l = canonicalOdometerUnit;
            return this;
        }

        public C1114a m5640d(String str) {
            this.f3708m = str;
            return this;
        }

        public C1114a m5642e(String str) {
            this.f3709n = str;
            return this;
        }

        public C1114a m5643f(String str) {
            this.f3710o = str;
            return this;
        }

        public C1114a m5644g(String str) {
            this.f3711p = str;
            return this;
        }

        public C1114a m5645h(String str) {
            this.f3712q = str;
            return this;
        }

        public C1114a m5632a(Date date) {
            this.f3713r = date;
            return this;
        }

        public C1114a m5634a(byte[] bArr) {
            this.f3715t = bArr;
            return this;
        }

        public C1114a m5626a(CanonicalRecapType canonicalRecapType) {
            this.f3716u = canonicalRecapType;
            return this;
        }

        public C1114a m5629a(C1125g c1125g, Date date) {
            this.f3719x = c1125g;
            this.f3720y = date;
            return this;
        }

        public C1114a m5628a(C1125g c1125g) {
            this.f3721z = c1125g;
            return this;
        }

        public C1114a m5639c(List<String> list) {
            this.f3703h = ImmutableList.m18511a((Collection) list);
            return this;
        }

        public C1114a m5641d(List<String> list) {
            this.f3704i = ImmutableList.m18511a((Collection) list);
            return this;
        }

        public C1116d m5635a() {
            Object obj = 1;
            if (this.f3696a == null) {
                throw new IllegalStateException("Cannot create daily log header without HOS settings.");
            }
            if (this.f3716u == null) {
                this.f3716u = CanonicalRecapType.NO_RECAP;
            }
            if (this.f3718w == null || this.f3717v != null) {
                Object obj2;
                if (this.f3719x == null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (this.f3720y != null) {
                    obj = null;
                }
                if (obj2 != obj) {
                    throw new IllegalStateException("Cannot create amended daily log without specifying both amending person ID and timestamp.");
                }
                m5600b();
                return new C1116d();
            }
            throw new IllegalStateException("Cannot create daily log header with modified seq but no last modified at timestamp.");
        }

        private void m5600b() {
            CanonicalOdometerUnit canonicalOdometerUnit = null;
            if (!this.f3700e.isEmpty() || !this.f3701f.isEmpty()) {
                C0859a a = DailyLogUtils.m4290a(this.f3707l != null ? this.f3707l.m5472b() : null, this.f3702g, this.f3700e, this.f3701f);
                if (a.m4282f()) {
                    this.f3706k = a.m4279c();
                    if (a.m4278b()) {
                        canonicalOdometerUnit = CanonicalOdometerUnit.m5466a(a.m4280d());
                    }
                    this.f3707l = canonicalOdometerUnit;
                }
            }
        }
    }

    public static class C1115b {
        private final String f3722a;
        private final Integer f3723b;
        private final Integer f3724c;

        public C1115b(String str, Integer num, Integer num2) {
            this.f3722a = str;
            this.f3723b = num;
            this.f3724c = num2;
        }

        public String m5646a() {
            return this.f3722a;
        }

        public Integer m5647b() {
            return this.f3723b;
        }

        public boolean m5648c() {
            return this.f3723b != null;
        }

        public Integer m5649d() {
            return this.f3724c;
        }

        public boolean m5650e() {
            return this.f3724c != null;
        }
    }

    private C1116d(C1114a c1114a) {
        super(c1114a.f3696a);
        this.f3725a = c1114a.f3697b;
        this.f3726b = c1114a.f3698c;
        this.f3727c = c1114a.f3699d;
        this.f3728d = c1114a.f3700e;
        this.f3729e = c1114a.f3701f;
        this.f3730f = c1114a.f3702g;
        this.f3733i = c1114a.f3706k;
        this.f3734j = c1114a.f3707l;
        this.f3735k = c1114a.f3705j;
        this.f3736l = c1114a.f3708m;
        this.f3737m = c1114a.f3709n;
        this.f3738n = c1114a.f3710o;
        this.f3739o = c1114a.f3711p;
        this.f3740p = c1114a.f3712q;
        this.f3741q = c1114a.f3713r;
        this.f3742r = c1114a.f3714s;
        this.f3743s = c1114a.f3715t;
        this.f3744t = c1114a.f3716u;
        this.f3745u = c1114a.f3717v;
        this.f3746v = c1114a.f3718w;
        this.f3747w = c1114a.f3719x;
        this.f3748x = c1114a.f3720y;
        this.f3749y = c1114a.f3721z;
        this.f3731g = c1114a.f3703h;
        this.f3732h = c1114a.f3704i;
    }

    public String m5660l() {
        return this.f3725a;
    }

    public C1115b m5661m() {
        return this.f3727c;
    }

    public boolean m5662n() {
        return this.f3727c != null;
    }

    public ImmutableList<C1108a> m5663o() {
        return this.f3728d;
    }

    public ImmutableList<C1108a> m5664p() {
        return this.f3729e;
    }

    public boolean m5665q() {
        Iterator a = m5668t().mo2684a();
        while (a.hasNext()) {
            if (((C1108a) a.next()).m5486m().equals(TruckLogType.ELD)) {
                return true;
            }
        }
        return false;
    }

    public ImmutableList<C1118e> m5666r() {
        return this.f3730f;
    }

    public Iterable<C1107b> m5667s() {
        return C3600n.m18809a(m5663o(), m5664p(), m5666r());
    }

    public ImmutableList<C1108a> m5668t() {
        Collection arrayList = new ArrayList(this.f3728d.size() + this.f3729e.size());
        arrayList.addAll(this.f3728d);
        arrayList.addAll(this.f3729e);
        Collections.sort(arrayList, C1108a.f3622a);
        return ImmutableList.m18511a(arrayList);
    }

    public ImmutableList<C1107b> m5669u() {
        return ImmutableList.m18517g().m18538b(m5663o()).m18538b(m5666r()).m18536a();
    }

    public Integer m5670v() {
        return this.f3733i;
    }

    public boolean m5671w() {
        return this.f3733i != null;
    }

    public CanonicalOdometerUnit m5672x() {
        return this.f3734j;
    }

    public boolean m5673y() {
        return this.f3734j != null;
    }

    public String m5674z() {
        return this.f3735k;
    }

    public String m5651A() {
        return this.f3736l;
    }

    public String m5652B() {
        return this.f3737m;
    }

    public String m5653C() {
        return this.f3738n;
    }

    public String m5654D() {
        return this.f3739o;
    }

    public String m5655E() {
        return this.f3740p;
    }

    public CanonicalRecapType m5656F() {
        return this.f3744t;
    }

    public ImmutableList<String> m5657G() {
        return this.f3731g;
    }

    public ImmutableList<String> m5658H() {
        return this.f3732h;
    }

    public Long m5659I() {
        Long valueOf = Long.valueOf(0);
        if (this.f3729e == null) {
            return valueOf;
        }
        Iterator a = m5668t().mo2684a();
        Long l = valueOf;
        while (a.hasNext()) {
            valueOf = ((C1108a) a.next()).m5515l();
            if (valueOf != null) {
                valueOf = Long.valueOf(valueOf.longValue() + l.longValue());
            } else {
                valueOf = l;
            }
            l = valueOf;
        }
        return l;
    }
}
