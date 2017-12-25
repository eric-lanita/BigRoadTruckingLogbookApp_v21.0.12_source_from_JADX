package com.bigroad.ttb.android.util;

public class C2295o<F, S> {
    public final F f7935a;
    public final S f7936b;

    public C2295o(F f, S s) {
        this.f7935a = f;
        this.f7936b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2295o)) {
            return false;
        }
        C2295o c2295o = (C2295o) obj;
        if (C2295o.m11243a(c2295o.f7935a, this.f7935a) && C2295o.m11243a(c2295o.f7936b, this.f7936b)) {
            return true;
        }
        return false;
    }

    private static boolean m11243a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f7935a == null ? 0 : this.f7935a.hashCode();
        if (this.f7936b != null) {
            i = this.f7936b.hashCode();
        }
        return hashCode ^ i;
    }
}
