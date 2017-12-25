package com.bigroad.shared.duty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C0883p extends C0882q {
    private final long f2751b;

    public /* synthetic */ int compareTo(Object obj) {
        return mo714a((C0882q) obj);
    }

    public static C0883p m4468a(List<C0896g> list, long j, long j2) {
        int a = C0883p.m4466a(list, j);
        if (a < 0) {
            throw new ArrayIndexOutOfBoundsException("Unable to locate start of offset period: " + j);
        } else if (j2 < j) {
            throw new IllegalArgumentException("Offset period startTs: " + j + " must be <= endTs: " + j2);
        } else {
            return new C0883p(list, a, j, C0883p.m4465a((List) list, a, j2), j2);
        }
    }

    public static C0883p m4467a(C0882q c0882q, long j, long j2) {
        return C0883p.m4468a(c0882q.f2748a, j, j2);
    }

    protected C0883p(List<C0896g> list, int i, long j, int i2, long j2) {
        super(C0883p.m4469a(list, i, j, i2, j2), i, i2);
        this.f2751b = j2 - ((C0896g) this.a.get(m4464k() - 1)).mo698g();
    }

    private static List<C0896g> m4469a(List<C0896g> list, int i, long j, int i2, long j2) {
        C0896g c0896g = (C0896g) list.get(i);
        List arrayList = new ArrayList(list);
        arrayList.set(i, new C0896g(j, Math.min(j2, c0896g.mo698g()), c0896g.mo702m()));
        if (i != i2 - 1) {
            c0896g = (C0896g) list.get(i2 - 1);
            if (c0896g.mo698g() != j2) {
                arrayList.set(i2 - 1, new C0896g(c0896g.mo697f(), Math.min(j2, c0896g.mo698g()), c0896g.mo702m()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    protected static int m4466a(List<C0896g> list, long j) {
        for (int i = 0; i < list.size(); i++) {
            C0896g c0896g = (C0896g) list.get(i);
            if (c0896g.mo690a(j)) {
                return i;
            }
            if (c0896g.mo689a() == 0 && c0896g.mo697f() == j) {
                return i;
            }
        }
        return -1;
    }

    protected static int m4465a(List<C0896g> list, int i, long j) {
        while (i < list.size()) {
            if (((C0896g) list.get(i)).mo697f() >= j) {
                return i;
            }
            i++;
        }
        return list.size();
    }

    public int mo714a(C0882q c0882q) {
        return Long.signum(mo697f() - c0882q.mo697f());
    }

    public long m4471c() {
        return this.f2751b;
    }
}
