package com.bigroad.shared.gaps;

import com.bigroad.shared.gaps.model.C1086b;
import com.bigroad.shared.gaps.model.C1091d;
import com.bigroad.shared.gaps.model.OdometerSegmentType;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C1085f {
    private final int f3526a;
    private final List<C1091d> f3527b;
    private final List<C1091d> f3528c;
    private final List<C1086b> f3529d;
    private final LogDayCalculationError f3530e;

    public static class C1084a {
        private int f3521a;
        private final List<C1091d> f3522b = new ArrayList();
        private final Set<C1091d> f3523c = new HashSet();
        private final List<C1086b> f3524d = new ArrayList();
        private LogDayCalculationError f3525e;

        public C1084a(int i) {
            this.f3521a = i;
        }

        public C1084a m5377a(Collection<C1091d> collection) {
            for (C1091d a : collection) {
                m5376a(a);
            }
            return this;
        }

        public C1084a m5376a(C1091d c1091d) {
            if (c1091d.m5417a() == OdometerSegmentType.TRUCK_LOG) {
                this.f3523c.add(c1091d);
            }
            return this;
        }

        public C1084a m5380b(Collection<C1091d> collection) {
            for (C1091d b : collection) {
                m5379b(b);
            }
            return this;
        }

        public C1084a m5379b(C1091d c1091d) {
            if (c1091d.m5417a() == OdometerSegmentType.TRUCK_LOG) {
                this.f3522b.add(c1091d);
            }
            return this;
        }

        public C1084a m5381c(Collection<C1086b> collection) {
            this.f3524d.addAll(collection);
            return this;
        }

        public C1085f m5378a() {
            Collection hashSet = new HashSet(this.f3523c);
            hashSet.removeAll(this.f3522b);
            return new C1085f(this.f3521a, ImmutableList.m18511a(this.f3522b), new ArrayList(hashSet), ImmutableList.m18511a(this.f3524d), this.f3525e);
        }
    }

    public C1085f(int i, List<C1091d> list, List<C1091d> list2, List<C1086b> list3, LogDayCalculationError logDayCalculationError) {
        this.f3526a = i;
        this.f3527b = Collections.unmodifiableList(list);
        this.f3529d = Collections.unmodifiableList(list3);
        this.f3528c = Collections.unmodifiableList(list2);
        this.f3530e = logDayCalculationError;
    }

    public static C1085f m5382a(int i) {
        return new C1085f(i, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null);
    }

    public int m5383a() {
        return this.f3526a;
    }

    public List<C1086b> m5384b() {
        return this.f3529d;
    }

    public List<C1091d> m5385c() {
        return this.f3528c;
    }

    public LogDayCalculationError m5386d() {
        return this.f3530e;
    }
}
