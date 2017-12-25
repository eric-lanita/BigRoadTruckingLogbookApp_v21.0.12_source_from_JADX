package com.bigroad.ttb.android.eobr.turbo;

import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.turbo.C1002b;
import com.bigroad.shared.eobr.turbo.C1009h;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1017o;
import com.bigroad.shared.eobr.turbo.logs.C1021r;
import com.bigroad.shared.eobr.turbo.logs.C1022b;
import com.bigroad.shared.eobr.turbo.logs.C1023c;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.eobr.turbo.logs.C1025e;
import com.bigroad.shared.eobr.turbo.logs.C1031k;
import com.bigroad.shared.eobr.turbo.logs.C1034n;
import com.bigroad.shared.eobr.turbo.logs.C1035q;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2295o;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.primitives.UnsignedInteger;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class VarPage {
    private final byte[] f6756a;
    private final long f6757b;
    private final byte[] f6758c;
    private final boolean f6759d;
    private final boolean f6760e;
    private final boolean f6761f;
    private final Long f6762g;
    private final Integer f6763h;
    private final Long f6764i;
    private final C1015l f6765j;
    private final C1015l f6766k;
    private final Integer f6767l;
    private final Integer f6768m;
    private final Long f6769n;
    private long f6770o = -1;

    public enum TimestampingResult {
        COMPLETE,
        MORE_EXPECTED,
        ERROR
    }

    public VarPage(byte[] bArr, long j, byte[] bArr2, boolean z, boolean z2, boolean z3, Long l, Integer num, Long l2, C1015l c1015l, C1015l c1015l2, Integer num2, Integer num3) {
        Long l3;
        this.f6756a = bArr;
        this.f6757b = j;
        this.f6758c = bArr2;
        this.f6759d = z;
        this.f6760e = z2;
        this.f6761f = z3;
        this.f6762g = l;
        this.f6763h = num;
        this.f6764i = l2;
        this.f6765j = c1015l;
        this.f6766k = c1015l2;
        this.f6767l = num2;
        this.f6768m = num3;
        C1035q a = m9597a(this.f6758c);
        if (a == null) {
            l3 = null;
        } else {
            l3 = Long.valueOf(UnsignedInteger.m18836a(a.f3282c).longValue());
        }
        this.f6769n = l3;
    }

    private VarPage(byte[] bArr, long j, byte[] bArr2, boolean z, boolean z2, boolean z3, Long l, Integer num, Long l2, C1015l c1015l, C1015l c1015l2, Integer num2, Integer num3, Long l3) {
        this.f6756a = bArr;
        this.f6757b = j;
        this.f6758c = bArr2;
        this.f6759d = z;
        this.f6760e = z2;
        this.f6761f = z3;
        this.f6762g = l;
        this.f6763h = num;
        this.f6764i = l2;
        this.f6765j = c1015l;
        this.f6769n = l3;
        this.f6766k = c1015l2;
        this.f6767l = num2;
        this.f6768m = num3;
    }

    public byte[] m9606a() {
        return this.f6756a;
    }

    public long m9607b() {
        return this.f6757b;
    }

    public byte[] m9610c() {
        return this.f6758c;
    }

    public boolean m9611d() {
        return this.f6759d;
    }

    public boolean m9612e() {
        return this.f6760e;
    }

    public void m9605a(long j) {
        this.f6770o = j;
    }

    public C1015l m9613f() {
        return this.f6765j;
    }

    public Long m9614g() {
        return this.f6769n;
    }

    public C1015l m9615h() {
        return this.f6766k;
    }

    public Integer m9616i() {
        return this.f6767l;
    }

    public Integer m9617j() {
        return this.f6768m;
    }

    public long m9618k() {
        if (this.f6758c == null) {
            return 0;
        }
        if (this.f6770o >= 0) {
            return this.f6770o;
        }
        byte[] a = C1009h.m5183a(this.f6758c);
        if (a == null) {
            return 0;
        }
        this.f6770o = (long) a.length;
        return this.f6770o;
    }

    public boolean m9619l() {
        return this.f6767l != null;
    }

    public Long m9620m() {
        return this.f6762g;
    }

    private boolean m9599t() {
        return this.f6762g != null;
    }

    public boolean m9621n() {
        return m9625r() || (m9599t() && m9611d());
    }

    public Integer m9622o() {
        return this.f6763h;
    }

    public Long m9623p() {
        return this.f6764i;
    }

    public boolean m9624q() {
        return this.f6761f;
    }

    public boolean m9625r() {
        return m9624q() && m9611d();
    }

    public boolean m9626s() {
        return this.f6757b == 1;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("dashLinkId", C1180y.m5996c(m9606a())).add("pageNumber", m9607b()).add("isComplete", m9611d()).add("wasSynced", m9612e()).add("isCarryOverComplete", m9624q()).add("hasReset", m9619l()).add("startUtcTimestamp", m9620m()).add("firstTimestampedEntryIndex", m9622o()).add("lastUptimeToUtcOffset", m9623p()).add("lastCursorResetPosition", m9615h()).toString();
    }

    public C1016p m9608b(long j) {
        C1009h c1009h = new C1009h(new ByteArrayInputStream(this.f6758c));
        int i = 0;
        while (((long) i) <= j) {
            C1016p a = c1009h.m5192a();
            if (a == null) {
                break;
            } else if (((long) i) == j) {
                return a;
            } else {
                i++;
            }
        }
        return null;
    }

    public <T extends C1016p> C2295o<T, C1015l> m9602a(final Class<T> cls) {
        return m9609b(new Predicate<C1016p>(this) {
            final /* synthetic */ VarPage f6751b;

            public /* synthetic */ boolean apply(Object obj) {
                return m9596a((C1016p) obj);
            }

            public boolean m9596a(C1016p c1016p) {
                return cls.isInstance(c1016p);
            }
        }, Integer.MAX_VALUE);
    }

    public List<C2295o<C1016p, C1015l>> m9604a(Predicate<C1016p> predicate, int i) {
        List<C2295o<C1016p, C1015l>> arrayList = new ArrayList();
        C1009h c1009h = new C1009h(new ByteArrayInputStream(this.f6758c));
        for (int i2 = 0; i2 <= i; i2++) {
            C1016p a = c1009h.m5192a();
            if (a == null) {
                break;
            }
            if (predicate.apply(a)) {
                arrayList.add(new C2295o(a, new C1015l(this.f6757b, i2)));
            }
        }
        return arrayList;
    }

    public C2295o<C1016p, C1015l> m9609b(Predicate<C1016p> predicate, int i) {
        C1009h c1009h = new C1009h(new ByteArrayInputStream(this.f6758c));
        C2295o<C1016p, C1015l> c2295o = null;
        for (int i2 = 0; i2 <= i; i2++) {
            C1016p a = c1009h.m5192a();
            if (a == null) {
                break;
            }
            if (predicate.apply(a)) {
                c2295o = new C2295o(a, new C1015l(this.f6757b, i2));
            }
        }
        return c2295o;
    }

    public C2295o<C1016p, C1015l> m9603a(Long l, int i) {
        C1009h c1009h = new C1009h(new ByteArrayInputStream(this.f6758c));
        C2295o<C1016p, C1015l> c2295o = null;
        int i2 = 0;
        while (i2 <= i) {
            C1016p a = c1009h.m5192a();
            if (a == null) {
                return c2295o;
            }
            C2295o<C1016p, C1015l> c2295o2;
            if (!(a instanceof C1017o)) {
                c2295o2 = c2295o;
            } else if (m9619l()) {
                return new C2295o(a, new C1015l(this.f6757b, i2));
            } else {
                long j;
                C1017o c1017o = (C1017o) a;
                if (this.f6769n == null) {
                    j = 0;
                } else {
                    j = this.f6769n.longValue() + ((long) c1017o.f3193g);
                }
                if (Long.valueOf(j).longValue() > l.longValue()) {
                    return c2295o;
                }
                c2295o2 = new C2295o(a, new C1015l(this.f6757b, i2));
            }
            i2++;
            c2295o = c2295o2;
        }
        return c2295o;
    }

    static VarPage m9598a(byte[] bArr, Long l, VarPage varPage, byte[] bArr2, boolean z) {
        if (bArr2 == null) {
            return null;
        }
        Object obj;
        long j = 0;
        Long l2 = null;
        Long l3 = null;
        Integer num = null;
        if (varPage != null && varPage.m9624q()) {
            l3 = varPage.m9620m();
            num = varPage.m9622o();
            l2 = varPage.m9623p();
        }
        C1009h c1009h = new C1009h(new ByteArrayInputStream(bArr2));
        C1015l c1015l = null;
        Integer num2 = null;
        Integer num3 = null;
        Object obj2 = null;
        Long l4 = null;
        C1015l c1015l2 = null;
        Integer num4 = num;
        Long l5 = l3;
        Long l6 = l2;
        for (int i = 0; i < 253; i++) {
            C1016p a = c1009h.m5192a();
            if (a == null) {
                j = (long) c1009h.m5193b();
                obj = null;
                break;
            }
            if (i == 0) {
                if (a instanceof C1035q) {
                    l4 = Long.valueOf(UnsignedInteger.m18836a(((C1035q) a).f3282c).longValue());
                } else {
                    if (a instanceof C1022b) {
                        C2134e.m10680d("TT-VarPage", "unable to parse VAR page header (" + l + "); First item is corrupt");
                        obj = 1;
                    } else {
                        C2134e.m10680d("TT-VarPage", "Unable to parse VAR page (" + l + "); First item is not a TurboLogPageHeader");
                        obj = null;
                    }
                    obj2 = obj;
                    obj = 1;
                }
            } else if (a instanceof C1031k) {
                C1031k c1031k = (C1031k) a;
                num2 = Integer.valueOf(c1031k.f3274e);
                num3 = Integer.valueOf(c1031k.f3275f);
                if (num4 != null && num4.intValue() == 0) {
                    l5 = null;
                    num4 = null;
                    l6 = null;
                }
            } else if (a instanceof C1034n) {
                C1034n c1034n = (C1034n) a;
                l6 = Long.valueOf(((c1034n.f3279a - (l4 == null ? 0 : l4.longValue())) - ((long) c1034n.g)) * 1000);
                if (l5 == null) {
                    l5 = Long.valueOf(c1034n.f3279a * 1000);
                    num4 = Integer.valueOf(i);
                }
            } else if (a instanceof C1023c) {
                c1015l = new C1015l(l.longValue(), i);
            } else if (a instanceof C1025e) {
                C1024d b = ((C1025e) a).m5271b();
                if (b != null && b.m5266f()) {
                    c1015l2 = new C1015l(l.longValue(), i);
                }
            }
        }
        obj = null;
        if (obj != null && r5 == null) {
            C2134e.m10680d("TT-VarPage", "Unhandled timestamp error");
        }
        boolean z2 = varPage != null && varPage.m9624q();
        VarPage varPage2 = new VarPage(bArr, l.longValue(), bArr2, z, false, z2, l5, num4, l6, c1015l, c1015l2, num2, num3, l4);
        varPage2.m9605a(j);
        return varPage2;
    }

    TimestampingResult m9600a(long j, List<C0971c> list) {
        if (this.f6758c == null) {
            return TimestampingResult.MORE_EXPECTED;
        }
        C1009h c1009h = new C1009h(new ByteArrayInputStream(this.f6758c));
        long j2 = 0;
        Long m = m9620m();
        int i = 0;
        Integer o = m9622o();
        Long l = m;
        while (i < 253) {
            C1016p a = c1009h.m5192a();
            if (a == null) {
                this.f6770o = (long) c1009h.m5193b();
                break;
            }
            long j3;
            C1015l c1015l = new C1015l(m9607b(), i);
            if (i != 0) {
                Long valueOf;
                if (a instanceof C1034n) {
                    C1034n c1034n = (C1034n) a;
                    valueOf = Long.valueOf((c1034n.f3279a - UnsignedInteger.m18836a(c1034n.g).longValue()) * 1000);
                    o = Integer.valueOf(i);
                } else {
                    valueOf = l;
                }
                if (((long) i) < j) {
                    l = valueOf;
                    j3 = j2;
                } else {
                    if (a instanceof C1021r) {
                        list.add(new C1002b(c1015l, a, -1, 0));
                    } else if (a instanceof C1017o) {
                        C1017o c1017o = (C1017o) a;
                        long longValue = UnsignedInteger.m18836a(c1017o.f3193g).longValue();
                        Object obj = (valueOf == null || o == null || i < o.intValue()) ? null : 1;
                        long j4 = 0;
                        if (obj != null) {
                            j4 = valueOf.longValue() + (1000 * longValue);
                        }
                        list.add(new C1002b(c1015l, c1017o, longValue + j2, j4));
                    }
                    l = valueOf;
                    j3 = j2;
                }
            } else if (a instanceof C1035q) {
                j3 = UnsignedInteger.m18836a(((C1035q) a).f3282c).longValue();
            } else if (a instanceof C1022b) {
                C2134e.m10680d("TT-VarPage", "Unable to timestamp VAR page (" + this.f6757b + "); First entry is corrupt");
                list.add(new C1002b(c1015l, a, -1, 0));
                return TimestampingResult.ERROR;
            } else {
                C2134e.m10680d("TT-VarPage", "Unable to timestamp VAR page (" + this.f6757b + "); First entry is not a TurboLogPageHeader: " + toString());
                return TimestampingResult.ERROR;
            }
            i++;
            j2 = j3;
        }
        return m9625r() ? TimestampingResult.COMPLETE : TimestampingResult.MORE_EXPECTED;
    }

    private static C1035q m9597a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        C1016p a = new C1009h(new ByteArrayInputStream(bArr)).m5192a();
        return (a == null || !(a instanceof C1035q)) ? null : (C1035q) a;
    }

    VarPage m9601a(VarPage varPage) {
        if (m9625r()) {
            return this;
        }
        if (varPage != null && !varPage.m9621n()) {
            return this;
        }
        Long l;
        Long l2 = this.f6762g;
        Integer num = this.f6763h;
        Long l3 = this.f6764i;
        C1035q a = m9597a(this.f6758c);
        if (a == null) {
            l = null;
        } else {
            l = Long.valueOf(UnsignedInteger.m18836a(a.f3282c).longValue());
        }
        if (!(m9619l() || a == null || varPage == null || varPage.m9623p() == null)) {
            l2 = Long.valueOf(varPage.m9623p().longValue() + (l.longValue() * 1000));
            num = Integer.valueOf(0);
            if (m9623p() == null) {
                l3 = varPage.m9623p();
            }
        }
        if (this.f6761f && Objects.equal(l2, this.f6762g) && Objects.equal(num, this.f6763h) && Objects.equal(l3, this.f6764i)) {
            return this;
        }
        return new VarPage(this.f6756a, this.f6757b, this.f6758c, this.f6759d, this.f6760e, true, l2, num, l3, this.f6765j, this.f6766k, this.f6767l, this.f6768m, l);
    }
}
