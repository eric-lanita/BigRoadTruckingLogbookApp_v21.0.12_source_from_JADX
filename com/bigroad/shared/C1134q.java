package com.bigroad.shared;

import com.bigroad.shared.model.C1112c;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.google.common.collect.C3589f;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C1134q {

    public static class C1132a {
        public long f3787a;
        public long f3788b;

        public C1132a(long j, long j2) {
            this.f3787a = j;
            this.f3788b = j2;
        }
    }

    private static class C1133b implements Comparable<C1133b> {
        long f3789a;
        long f3790b;

        public /* synthetic */ int compareTo(Object obj) {
            return m5721a((C1133b) obj);
        }

        C1133b(long j, long j2) {
            this.f3789a = j;
            this.f3790b = j2;
        }

        public int m5721a(C1133b c1133b) {
            return C3589f.m18773a().mo2736a(this.f3790b, c1133b.f3790b).mo2736a(this.f3789a, c1133b.f3789a).mo2740b();
        }
    }

    public static boolean m5726a(Long l, Integer num, Long l2) {
        return (l == null || num == null || l2 == null) ? false : true;
    }

    public static boolean m5725a(C1112c c1112c) {
        return C1134q.m5726a(c1112c.m5587g(), c1112c.m5589i(), c1112c.m5588h());
    }

    private static Range<C1133b> m5724a(List<C1133b> list, long j) {
        Comparable comparable = null;
        if (list.size() == 0 || ((C1133b) list.get(0)).f3790b > j || ((C1133b) list.get(list.size() - 1)).f3790b < j) {
            return null;
        }
        Comparable comparable2;
        Comparable comparable3 = null;
        for (Comparable comparable32 : list) {
            if (comparable32.f3790b == j) {
                return Range.m18692a(comparable32, comparable32);
            }
            if (comparable32.f3790b > j) {
                break;
            }
            comparable2 = comparable32;
            comparable32 = comparable;
            comparable = comparable2;
        }
        comparable2 = comparable;
        comparable = comparable32;
        comparable32 = comparable2;
        return Range.m18692a(comparable, comparable32);
    }

    public static C1132a m5723a(C1112c c1112c, CanonicalOdometerUnit canonicalOdometerUnit, long j, boolean z) {
        long a = C1134q.m5722a(canonicalOdometerUnit, (long) c1112c.m5589i().intValue());
        long longValue = a + c1112c.m5588h().longValue();
        if (j < c1112c.mo721a() || j > c1112c.m5585e()) {
            return new C1132a(a, c1112c.m5588h().longValue());
        }
        List arrayList = new ArrayList(c1112c.m5590j().size() + 2);
        arrayList.add(new C1133b((long) c1112c.m5589i().intValue(), c1112c.mo721a()));
        for (Event event : c1112c.m5590j()) {
            arrayList.add(new C1133b((long) event.getOdometer(), event.getOccurredAt()));
        }
        arrayList.add(new C1133b(C1134q.m5727b(canonicalOdometerUnit, longValue), c1112c.m5585e()));
        Collections.sort(arrayList);
        Range a2 = C1134q.m5724a(arrayList, j);
        if (a2 == null) {
            return new C1132a(a, c1112c.m5588h().longValue());
        }
        long j2;
        if (((C1133b) a2.m18700e()).f3790b - ((C1133b) a2.m18698c()).f3790b == 0) {
            j2 = ((C1133b) a2.m18698c()).f3789a;
        } else {
            C1133b c1133b = (C1133b) a2.m18698c();
            C1133b c1133b2 = (C1133b) a2.m18700e();
            j2 = c1133b.f3789a + Math.round((((double) (c1133b2.f3789a - c1133b.f3789a)) / ((double) (c1133b2.f3790b - c1133b.f3790b))) * ((double) (j - c1133b.f3790b)));
        }
        if (z) {
            return new C1132a(C1134q.m5722a(canonicalOdometerUnit, j2), longValue - C1134q.m5722a(canonicalOdometerUnit, j2));
        }
        return new C1132a(a, C1134q.m5722a(canonicalOdometerUnit, j2) - a);
    }

    private static long m5722a(CanonicalOdometerUnit canonicalOdometerUnit, long j) {
        return Math.round(canonicalOdometerUnit.m5469a(j));
    }

    private static long m5727b(CanonicalOdometerUnit canonicalOdometerUnit, long j) {
        return Math.round(canonicalOdometerUnit.m5471b(j));
    }
}
