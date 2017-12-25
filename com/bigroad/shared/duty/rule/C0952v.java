package com.bigroad.shared.duty.rule;

import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0910r;
import com.bigroad.shared.duty.C0953s;
import java.util.ArrayList;
import java.util.List;

public class C0952v extends C0882q {
    private boolean f2916b = false;
    private long f2917c = 0;
    private int f2918d = -1;

    public C0952v(C0882q c0882q) {
        super(c0882q);
        m4840n();
    }

    public C0952v(List<C0896g> list, int i, int i2) {
        super(list, i, i2);
        m4840n();
    }

    private void m4840n() {
        int i = -1;
        int i2 = -1;
        long j = 0;
        for (int j2 = m4463j(); j2 < m4464k(); j2++) {
            C0896g a = m4449a(j2);
            if (a.m4542e()) {
                j += a.mo689a();
                i2 = j2;
            } else if (m4839i(j)) {
                this.f2916b = true;
                this.f2917c = j;
                if (i2 != -1) {
                    i = i2 + 1;
                }
                this.f2918d = i;
                return;
            } else {
                i2 = -1;
                j = 0;
            }
        }
        this.f2916b = m4839i(j);
        if (!this.f2916b) {
            j = 0;
        }
        this.f2917c = j;
        if (this.f2916b && i2 != -1) {
            i = Math.min(m4464k(), i2 + 1);
        }
        this.f2918d = i;
    }

    private boolean m4839i(long j) {
        return j >= 28800000 && j < 36000000;
    }

    public boolean m4841b() {
        return mo689a() >= 7200000;
    }

    public boolean m4842c() {
        return this.f2916b;
    }

    public int m4843l() {
        if (!this.f2916b || this.f2918d == -1) {
            return m4464k();
        }
        return this.f2918d;
    }

    public long m4844m() {
        return this.f2917c;
    }

    public static List<C0953s<C0952v>> m4834a(List<C0952v> list) {
        int size = list.size();
        List<C0953s<C0952v>> arrayList = new ArrayList();
        for (int i = 0; i < size - 1; i++) {
            C0952v c0952v = (C0952v) list.get(i);
            for (int i2 = i + 1; i2 < size; i2++) {
                C0952v c0952v2 = (C0952v) list.get(i2);
                if (C0952v.m4835a(c0952v, c0952v2)) {
                    arrayList.add(new C0953s(c0952v, c0952v2));
                    break;
                }
            }
        }
        return arrayList;
    }

    public static List<C0952v> m4836b(C0882q c0882q) {
        return ((C09511) c0882q.m4450a(C0896g.f2771d, new C0910r<C0952v>(7200000) {
            protected /* synthetic */ C0882q mo730b(List list, int i, int i2) {
                return m4833c(list, i, i2);
            }

            protected C0952v m4833c(List<C0896g> list, int i, int i2) {
                return new C0952v(list, i, i2);
            }
        })).m4593a();
    }

    public static List<C0953s<C0952v>> m4837c(C0882q c0882q) {
        return C0952v.m4834a(C0952v.m4836b(c0882q));
    }

    public static long m4838d(C0882q c0882q) {
        return new C0952v(c0882q).m4844m();
    }

    public static boolean m4835a(C0952v c0952v, C0952v c0952v2) {
        return (c0952v.m4842c() && c0952v2.m4841b()) || (c0952v.m4841b() && c0952v2.m4842c());
    }
}
