package android.support.v4.p008d;

public class C0281i<E> implements Cloneable {
    private static final Object f828a = new Object();
    private boolean f829b;
    private int[] f830c;
    private Object[] f831d;
    private int f832e;

    public /* synthetic */ Object clone() {
        return m1178a();
    }

    public C0281i() {
        this(10);
    }

    public C0281i(int i) {
        this.f829b = false;
        if (i == 0) {
            this.f830c = C0271b.f798a;
            this.f831d = C0271b.f800c;
        } else {
            int a = C0271b.m1154a(i);
            this.f830c = new int[a];
            this.f831d = new Object[a];
        }
        this.f832e = 0;
    }

    public C0281i<E> m1178a() {
        try {
            C0281i<E> c0281i = (C0281i) super.clone();
            try {
                c0281i.f830c = (int[]) this.f830c.clone();
                c0281i.f831d = (Object[]) this.f831d.clone();
                return c0281i;
            } catch (CloneNotSupportedException e) {
                return c0281i;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1179a(int i) {
        return m1180a(i, null);
    }

    public E m1180a(int i, E e) {
        int a = C0271b.m1155a(this.f830c, this.f832e, i);
        return (a < 0 || this.f831d[a] == f828a) ? e : this.f831d[a];
    }

    public void m1182b(int i) {
        int a = C0271b.m1155a(this.f830c, this.f832e, i);
        if (a >= 0 && this.f831d[a] != f828a) {
            this.f831d[a] = f828a;
            this.f829b = true;
        }
    }

    public void m1185c(int i) {
        m1182b(i);
    }

    private void m1177d() {
        int i = this.f832e;
        int[] iArr = this.f830c;
        Object[] objArr = this.f831d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f828a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f829b = false;
        this.f832e = i2;
    }

    public void m1183b(int i, E e) {
        int a = C0271b.m1155a(this.f830c, this.f832e, i);
        if (a >= 0) {
            this.f831d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f832e || this.f831d[a] != f828a) {
            if (this.f829b && this.f832e >= this.f830c.length) {
                m1177d();
                a = C0271b.m1155a(this.f830c, this.f832e, i) ^ -1;
            }
            if (this.f832e >= this.f830c.length) {
                int a2 = C0271b.m1154a(this.f832e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f830c, 0, obj, 0, this.f830c.length);
                System.arraycopy(this.f831d, 0, obj2, 0, this.f831d.length);
                this.f830c = obj;
                this.f831d = obj2;
            }
            if (this.f832e - a != 0) {
                System.arraycopy(this.f830c, a, this.f830c, a + 1, this.f832e - a);
                System.arraycopy(this.f831d, a, this.f831d, a + 1, this.f832e - a);
            }
            this.f830c[a] = i;
            this.f831d[a] = e;
            this.f832e++;
            return;
        }
        this.f830c[a] = i;
        this.f831d[a] = e;
    }

    public int m1181b() {
        if (this.f829b) {
            m1177d();
        }
        return this.f832e;
    }

    public int m1186d(int i) {
        if (this.f829b) {
            m1177d();
        }
        return this.f830c[i];
    }

    public E m1187e(int i) {
        if (this.f829b) {
            m1177d();
        }
        return this.f831d[i];
    }

    public int m1188f(int i) {
        if (this.f829b) {
            m1177d();
        }
        return C0271b.m1155a(this.f830c, this.f832e, i);
    }

    public void m1184c() {
        int i = this.f832e;
        Object[] objArr = this.f831d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f832e = 0;
        this.f829b = false;
    }

    public String toString() {
        if (m1181b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f832e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f832e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1186d(i));
            stringBuilder.append('=');
            C0281i e = m1187e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
