package com.bigroad.shared.gaps;

import com.bigroad.shared.gaps.C1075a.C1071a;
import com.bigroad.shared.gaps.model.C1072a;
import com.bigroad.shared.gaps.model.C1087c;
import com.bigroad.shared.gaps.model.C1091d;
import com.google.common.collect.Iterators;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class C1079b implements Iterable<C1075a> {
    private final String f3516a;
    private final List<C1075a> f3517b;
    private final Range<Integer> f3518c;

    public static class C1077a {
        private final String f3511a;
        private final TreeMap<Integer, C1071a> f3512b;

        private C1077a(String str) {
            this.f3512b = new TreeMap();
            this.f3511a = str;
        }

        public C1077a m5357a(List<C1091d> list) {
            Set hashSet = new HashSet();
            List<C1091d> arrayList = new ArrayList(list.size());
            for (C1091d c1091d : list) {
                C1071a c1071a = (C1071a) this.f3512b.get(Integer.valueOf(c1091d.m5418b()));
                if (c1071a != null) {
                    C1091d a = c1071a.m5328a(c1091d, hashSet);
                    if (a != null) {
                        hashSet.add(a);
                    }
                }
                arrayList.add(c1091d);
            }
            for (C1091d c1091d2 : arrayList) {
                m5356a(c1091d2);
            }
            return this;
        }

        private C1071a m5353a(int i) {
            C1071a c1071a = (C1071a) this.f3512b.get(Integer.valueOf(i));
            if (c1071a != null) {
                return c1071a;
            }
            c1071a = C1075a.m5350a(i);
            this.f3512b.put(Integer.valueOf(i), c1071a);
            return c1071a;
        }

        public C1077a m5355a(C1072a c1072a) {
            m5353a(c1072a.mo770a()).m5324a(c1072a);
            return this;
        }

        public C1077a m5354a(int i, C1087c c1087c) {
            m5353a(i).m5325a(c1087c);
            return this;
        }

        public C1077a m5356a(C1091d c1091d) {
            m5353a(c1091d.m5418b()).m5326a(c1091d);
            return this;
        }

        public Integer m5358a() {
            return this.f3512b.isEmpty() ? null : (Integer) this.f3512b.firstKey();
        }

        public Integer m5359b() {
            return this.f3512b.isEmpty() ? null : (Integer) this.f3512b.lastKey();
        }

        public C1079b m5360c() {
            List arrayList = new ArrayList(this.f3512b.size());
            for (C1071a a : this.f3512b.values()) {
                arrayList.add(a.m5327a());
            }
            return new C1079b(this.f3511a, arrayList);
        }
    }

    public static C1077a m5368a(String str) {
        return new C1077a(str);
    }

    private C1079b(String str, List<C1075a> list) {
        Comparable comparable = null;
        this.f3516a = str;
        this.f3517b = Collections.unmodifiableList(list);
        Comparable comparable2 = null;
        for (C1075a c1075a : this.f3517b) {
            Integer valueOf;
            if (comparable2 == null || c1075a.m5351a() < comparable2.intValue()) {
                comparable2 = Integer.valueOf(c1075a.m5351a());
            }
            if (comparable == null || c1075a.m5351a() > comparable.intValue()) {
                valueOf = Integer.valueOf(c1075a.m5351a());
            } else {
                Comparable comparable3 = comparable;
            }
            Object obj = valueOf;
        }
        if (comparable2 == null || comparable == null) {
            this.f3518c = Range.m18689a();
        } else {
            this.f3518c = Range.m18692a(comparable2, comparable);
        }
    }

    public Iterator<C1075a> iterator() {
        return Iterators.m18615a(this.f3517b.iterator());
    }

    public String m5369a() {
        return this.f3516a;
    }

    public Range<Integer> m5370b() {
        return this.f3518c;
    }
}
