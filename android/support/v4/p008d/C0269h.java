package android.support.v4.p008d;

import java.util.Map;

public class C0269h<K, V> {
    static Object[] f790b;
    static int f791c;
    static Object[] f792d;
    static int f793e;
    int[] f794f;
    Object[] f795g;
    int f796h;

    int m1144a(Object obj, int i) {
        int i2 = this.f796h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0271b.m1155a(this.f794f, i2, i);
        if (a < 0 || obj.equals(this.f795g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f794f[i3] == i) {
            if (obj.equals(this.f795g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f794f[a] == i) {
            if (obj.equals(this.f795g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    int m1142a() {
        int i = this.f796h;
        if (i == 0) {
            return -1;
        }
        int a = C0271b.m1155a(this.f794f, i, 0);
        if (a < 0 || this.f795g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f794f[i2] == 0) {
            if (this.f795g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f794f[a] == 0) {
            if (this.f795g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void m1141e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0270a.class) {
                if (f792d != null) {
                    objArr = f792d;
                    this.f795g = objArr;
                    f792d = (Object[]) objArr[0];
                    this.f794f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f793e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0270a.class) {
                if (f790b != null) {
                    objArr = f790b;
                    this.f795g = objArr;
                    f790b = (Object[]) objArr[0];
                    this.f794f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f791c--;
                    return;
                }
            }
        }
        this.f794f = new int[i];
        this.f795g = new Object[(i << 1)];
    }

    private static void m1140a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0270a.class) {
                if (f793e < 10) {
                    objArr[0] = f792d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f792d = objArr;
                    f793e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0270a.class) {
                if (f791c < 10) {
                    objArr[0] = f790b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f790b = objArr;
                    f791c++;
                }
            }
        }
    }

    public C0269h() {
        this.f794f = C0271b.f798a;
        this.f795g = C0271b.f800c;
        this.f796h = 0;
    }

    public C0269h(int i) {
        if (i == 0) {
            this.f794f = C0271b.f798a;
            this.f795g = C0271b.f800c;
        } else {
            m1141e(i);
        }
        this.f796h = 0;
    }

    public void clear() {
        if (this.f796h != 0) {
            C0269h.m1140a(this.f794f, this.f795g, this.f796h);
            this.f794f = C0271b.f798a;
            this.f795g = C0271b.f800c;
            this.f796h = 0;
        }
    }

    public void m1146a(int i) {
        if (this.f794f.length < i) {
            Object obj = this.f794f;
            Object obj2 = this.f795g;
            m1141e(i);
            if (this.f796h > 0) {
                System.arraycopy(obj, 0, this.f794f, 0, this.f796h);
                System.arraycopy(obj2, 0, this.f795g, 0, this.f796h << 1);
            }
            C0269h.m1140a(obj, obj2, this.f796h);
        }
    }

    public boolean containsKey(Object obj) {
        return m1143a(obj) >= 0;
    }

    public int m1143a(Object obj) {
        return obj == null ? m1142a() : m1144a(obj, obj.hashCode());
    }

    int m1148b(Object obj) {
        int i = 1;
        int i2 = this.f796h * 2;
        Object[] objArr = this.f795g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m1148b(obj) >= 0;
    }

    public V get(Object obj) {
        int a = m1143a(obj);
        return a >= 0 ? this.f795g[(a << 1) + 1] : null;
    }

    public K m1149b(int i) {
        return this.f795g[i << 1];
    }

    public V m1150c(int i) {
        return this.f795g[(i << 1) + 1];
    }

    public V m1145a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f795g[i2];
        this.f795g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f796h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m1142a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m1144a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f795g[i3];
            this.f795g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f796h >= this.f794f.length) {
            if (this.f796h >= 8) {
                i2 = this.f796h + (this.f796h >> 1);
            } else if (this.f796h < 4) {
                i2 = 4;
            }
            Object obj = this.f794f;
            Object obj2 = this.f795g;
            m1141e(i2);
            if (this.f794f.length > 0) {
                System.arraycopy(obj, 0, this.f794f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f795g, 0, obj2.length);
            }
            C0269h.m1140a(obj, obj2, this.f796h);
        }
        if (a < this.f796h) {
            System.arraycopy(this.f794f, a, this.f794f, a + 1, this.f796h - a);
            System.arraycopy(this.f795g, a << 1, this.f795g, (a + 1) << 1, (this.f796h - a) << 1);
        }
        this.f794f[a] = i;
        this.f795g[a << 1] = k;
        this.f795g[(a << 1) + 1] = v;
        this.f796h++;
        return null;
    }

    public void m1147a(C0269h<? extends K, ? extends V> c0269h) {
        int i = 0;
        int i2 = c0269h.f796h;
        m1146a(this.f796h + i2);
        if (this.f796h != 0) {
            while (i < i2) {
                put(c0269h.m1149b(i), c0269h.m1150c(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(c0269h.f794f, 0, this.f794f, 0, i2);
            System.arraycopy(c0269h.f795g, 0, this.f795g, 0, i2 << 1);
            this.f796h = i2;
        }
    }

    public V remove(Object obj) {
        int a = m1143a(obj);
        if (a >= 0) {
            return m1151d(a);
        }
        return null;
    }

    public V m1151d(int i) {
        int i2 = 8;
        V v = this.f795g[(i << 1) + 1];
        if (this.f796h <= 1) {
            C0269h.m1140a(this.f794f, this.f795g, this.f796h);
            this.f794f = C0271b.f798a;
            this.f795g = C0271b.f800c;
            this.f796h = 0;
        } else if (this.f794f.length <= 8 || this.f796h >= this.f794f.length / 3) {
            this.f796h--;
            if (i < this.f796h) {
                System.arraycopy(this.f794f, i + 1, this.f794f, i, this.f796h - i);
                System.arraycopy(this.f795g, (i + 1) << 1, this.f795g, i << 1, (this.f796h - i) << 1);
            }
            this.f795g[this.f796h << 1] = null;
            this.f795g[(this.f796h << 1) + 1] = null;
        } else {
            if (this.f796h > 8) {
                i2 = this.f796h + (this.f796h >> 1);
            }
            Object obj = this.f794f;
            Object obj2 = this.f795g;
            m1141e(i2);
            this.f796h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f794f, 0, i);
                System.arraycopy(obj2, 0, this.f795g, 0, i << 1);
            }
            if (i < this.f796h) {
                System.arraycopy(obj, i + 1, this.f794f, i, this.f796h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f795g, i << 1, (this.f796h - i) << 1);
            }
        }
        return v;
    }

    public int size() {
        return this.f796h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f796h) {
            try {
                Object b = m1149b(i);
                Object c = m1150c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f794f;
        Object[] objArr = this.f795g;
        int i = this.f796h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f796h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f796h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0269h b = m1149b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1150c(i);
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
