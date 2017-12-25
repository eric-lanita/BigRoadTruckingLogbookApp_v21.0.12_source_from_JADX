package com.bigroad.shared.gaps;

import com.bigroad.shared.gaps.C1085f.C1084a;
import com.bigroad.shared.gaps.model.C1086b;
import com.bigroad.shared.gaps.model.C1091d;
import com.bigroad.shared.gaps.util.C1094a;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C1082d implements C1081g {
    private final Range<Integer> f3519a;
    private final Map<Integer, C1085f> f3520b;

    public C1082d(C1079b c1079b, Range<Integer> range) {
        List<C1086b> arrayList = new ArrayList();
        C1079b a = C1094a.m5428a(c1079b, (List) arrayList);
        if (range == null) {
            range = a.m5370b();
        }
        this.f3519a = range;
        if (range.m18696b() && range.m18699d()) {
            Map hashMap = new HashMap();
            for (C1086b c1086b : arrayList) {
                int b = c1086b.m5391a().m5418b();
                if (!hashMap.containsKey(Integer.valueOf(b))) {
                    hashMap.put(Integer.valueOf(b), new ArrayList());
                }
                ((List) hashMap.get(Integer.valueOf(b))).add(c1086b);
            }
            List<C1084a> arrayList2 = new ArrayList();
            Iterator it = a.iterator();
            while (it.hasNext()) {
                C1075a c1075a = (C1075a) it.next();
                int a2 = c1075a.m5351a();
                Collection arrayList3 = new ArrayList();
                Iterator it2 = c1075a.iterator();
                while (it2.hasNext()) {
                    C1091d c1091d = (C1091d) it2.next();
                    if (!c1091d.m5425i()) {
                        arrayList3.add(c1091d);
                    }
                }
                C1084a b2 = new C1084a(a2).m5377a(c1075a.m5352b()).m5380b(arrayList3);
                arrayList2.add(b2);
                if (hashMap.containsKey(Integer.valueOf(a2))) {
                    b2.m5381c((Collection) hashMap.get(Integer.valueOf(a2)));
                }
            }
            Map hashMap2 = new HashMap();
            for (C1084a a3 : arrayList2) {
                C1085f a4 = a3.m5378a();
                hashMap2.put(Integer.valueOf(a4.m5383a()), a4);
            }
            this.f3520b = hashMap2;
            return;
        }
        this.f3520b = null;
    }

    public C1085f mo777a(int i) {
        C1085f c1085f = null;
        if (this.f3520b != null && this.f3519a.m18695a(Integer.valueOf(i))) {
            c1085f = (C1085f) this.f3520b.get(Integer.valueOf(i));
        }
        if (c1085f == null) {
            return C1085f.m5382a(i);
        }
        return c1085f;
    }
}
