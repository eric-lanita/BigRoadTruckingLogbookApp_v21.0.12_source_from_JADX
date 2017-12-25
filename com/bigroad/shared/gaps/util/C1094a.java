package com.bigroad.shared.gaps.util;

import com.bigroad.shared.as;
import com.bigroad.shared.gaps.C1075a;
import com.bigroad.shared.gaps.C1079b;
import com.bigroad.shared.gaps.model.C1086b;
import com.bigroad.shared.gaps.model.C1091d;
import com.bigroad.shared.gaps.model.OdometerSegmentType;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class C1094a {
    public static final long f3566a = as.m4242a(6);
    public static final long f3567b = Math.max(11000, f3566a);

    static /* synthetic */ class C10931 {
        static final /* synthetic */ int[] f3564a = new int[OdometerUnit.values().length];

        static {
            f3565b = new int[CanonicalOdometerUnit.values().length];
            try {
                f3565b[CanonicalOdometerUnit.KM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3565b[CanonicalOdometerUnit.MILES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3564a[OdometerUnit.MILES.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3564a[OdometerUnit.KM.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static boolean m5431a(C1091d c1091d, C1091d c1091d2) {
        if (c1091d.m5424h() == c1091d2.m5422f()) {
            CanonicalOdometerUnit h = c1091d.m5424h();
            if (h == null) {
                h = CanonicalOdometerUnit.MILES;
            }
            int round = ((int) Math.round(h.m5471b(c1091d2.m5421e()))) - ((int) Math.round(h.m5471b(c1091d.m5423g())));
            switch (h) {
                case KM:
                    return round > 10;
                case MILES:
                    if (round <= 5) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        } else if (c1091d2.m5421e() - c1091d.m5423g() < f3567b) {
            return false;
        } else {
            return true;
        }
    }

    public static C1079b m5428a(C1079b c1079b, List<C1086b> list) {
        List linkedList = new LinkedList();
        Iterator it = c1079b.iterator();
        while (it.hasNext()) {
            linkedList.addAll(((C1075a) it.next()).m5352b());
        }
        return C1079b.m5368a(c1079b.m5369a()).m5357a(C1094a.m5429a(linkedList, (List) list)).m5360c();
    }

    public static List<C1091d> m5429a(List<C1091d> list, List<C1086b> list2) {
        List<C1091d> arrayList = new ArrayList(list);
        List<C1091d> arrayList2 = new ArrayList();
        C1094a.m5430a(arrayList);
        Collections.sort(arrayList, C1091d.f3537b);
        C1091d c1091d = null;
        Collection linkedList = new LinkedList();
        for (C1091d c1091d2 : arrayList) {
            C1091d c1091d22;
            if (c1091d22.m5425i()) {
                linkedList.add(c1091d22);
                c1091d22 = c1091d;
            } else if (c1091d != null) {
                if (C1091d.m5408b(c1091d, c1091d22)) {
                    c1091d22 = C1091d.m5405a(c1091d, c1091d22);
                } else {
                    arrayList2.add(c1091d);
                    if (list2 != null && C1094a.m5431a(c1091d, c1091d22)) {
                        list2.add(new C1086b(c1091d, c1091d22));
                    }
                }
            }
            c1091d = c1091d22;
        }
        if (c1091d != null) {
            arrayList2.add(c1091d);
        }
        arrayList2.addAll(linkedList);
        return arrayList2;
    }

    private static void m5430a(List<C1091d> list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((C1091d) it.next()).m5417a() == OdometerSegmentType.ODOMETER_ADJUSTMENT) {
                it.remove();
            }
        }
    }
}
