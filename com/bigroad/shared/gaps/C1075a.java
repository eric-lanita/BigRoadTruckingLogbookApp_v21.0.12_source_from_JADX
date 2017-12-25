package com.bigroad.shared.gaps;

import com.bigroad.shared.gaps.model.C1072a;
import com.bigroad.shared.gaps.model.C1087c;
import com.bigroad.shared.gaps.model.C1091d;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C1075a implements Iterable<C1091d> {
    private final int f3509a;
    private final List<C1091d> f3510b;

    public static class C1071a {
        private final int f3501a;
        private List<C1091d> f3502b;

        private C1071a(int i) {
            this.f3501a = i;
            this.f3502b = new ArrayList();
        }

        public C1071a m5324a(C1072a c1072a) {
            this.f3502b.add(new C1091d(c1072a));
            return this;
        }

        public C1071a m5325a(C1087c c1087c) {
            this.f3502b.add(new C1091d(c1087c, this.f3501a));
            return this;
        }

        public C1071a m5326a(C1091d c1091d) {
            this.f3502b.add(c1091d);
            return this;
        }

        public C1091d m5328a(C1091d c1091d, Set<C1091d> set) {
            for (C1091d c1091d2 : this.f3502b) {
                if (!set.contains(c1091d2) && C1091d.f3536a.compare(c1091d, c1091d2) == 0) {
                    return c1091d2;
                }
            }
            return null;
        }

        public C1075a m5327a() {
            return new C1075a(this.f3501a, new ArrayList(this.f3502b));
        }
    }

    public static C1071a m5350a(int i) {
        return new C1071a(i);
    }

    private C1075a(int i, List<C1091d> list) {
        this.f3509a = i;
        this.f3510b = Collections.unmodifiableList(list);
    }

    public int m5351a() {
        return this.f3509a;
    }

    public List<C1091d> m5352b() {
        return this.f3510b;
    }

    public Iterator<C1091d> iterator() {
        return Iterators.m18615a(this.f3510b.iterator());
    }
}
