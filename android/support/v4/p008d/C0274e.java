package android.support.v4.p008d;

public class C0274e<E> implements Cloneable {
    private static final Object f803a = new Object();
    private boolean f804b;
    private long[] f805c;
    private Object[] f806d;
    private int f807e;

    public /* synthetic */ Object clone() {
        return m1164a();
    }

    public C0274e() {
        this(10);
    }

    public C0274e(int i) {
        this.f804b = false;
        if (i == 0) {
            this.f805c = C0271b.f799b;
            this.f806d = C0271b.f800c;
        } else {
            int b = C0271b.m1158b(i);
            this.f805c = new long[b];
            this.f806d = new Object[b];
        }
        this.f807e = 0;
    }

    public C0274e<E> m1164a() {
        try {
            C0274e<E> c0274e = (C0274e) super.clone();
            try {
                c0274e.f805c = (long[]) this.f805c.clone();
                c0274e.f806d = (Object[]) this.f806d.clone();
                return c0274e;
            } catch (CloneNotSupportedException e) {
                return c0274e;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1165a(long j) {
        return m1166a(j, null);
    }

    public E m1166a(long j, E e) {
        int a = C0271b.m1156a(this.f805c, this.f807e, j);
        return (a < 0 || this.f806d[a] == f803a) ? e : this.f806d[a];
    }

    public void m1169b(long j) {
        int a = C0271b.m1156a(this.f805c, this.f807e, j);
        if (a >= 0 && this.f806d[a] != f803a) {
            this.f806d[a] = f803a;
            this.f804b = true;
        }
    }

    private void m1162c() {
        int i = this.f807e;
        long[] jArr = this.f805c;
        Object[] objArr = this.f806d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f803a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f804b = false;
        this.f807e = i2;
    }

    public void m1170b(long j, E e) {
        int a = C0271b.m1156a(this.f805c, this.f807e, j);
        if (a >= 0) {
            this.f806d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f807e || this.f806d[a] != f803a) {
            if (this.f804b && this.f807e >= this.f805c.length) {
                m1162c();
                a = C0271b.m1156a(this.f805c, this.f807e, j) ^ -1;
            }
            if (this.f807e >= this.f805c.length) {
                int b = C0271b.m1158b(this.f807e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f805c, 0, obj, 0, this.f805c.length);
                System.arraycopy(this.f806d, 0, obj2, 0, this.f806d.length);
                this.f805c = obj;
                this.f806d = obj2;
            }
            if (this.f807e - a != 0) {
                System.arraycopy(this.f805c, a, this.f805c, a + 1, this.f807e - a);
                System.arraycopy(this.f806d, a, this.f806d, a + 1, this.f807e - a);
            }
            this.f805c[a] = j;
            this.f806d[a] = e;
            this.f807e++;
            return;
        }
        this.f805c[a] = j;
        this.f806d[a] = e;
    }

    public int m1167b() {
        if (this.f804b) {
            m1162c();
        }
        return this.f807e;
    }

    public long m1163a(int i) {
        if (this.f804b) {
            m1162c();
        }
        return this.f805c[i];
    }

    public E m1168b(int i) {
        if (this.f804b) {
            m1162c();
        }
        return this.f806d[i];
    }

    public String toString() {
        if (m1167b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f807e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f807e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1163a(i));
            stringBuilder.append('=');
            C0274e b = m1168b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
