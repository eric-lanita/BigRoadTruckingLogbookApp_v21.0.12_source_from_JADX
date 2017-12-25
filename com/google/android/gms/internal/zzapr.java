package com.google.android.gms.internal;

public final class zzapr implements Cloneable {
    private static final zzaps f11361a = new zzaps();
    private boolean f11362b;
    private int[] f11363c;
    private zzaps[] f11364d;
    private int f11365e;

    zzapr() {
        this(10);
    }

    zzapr(int i) {
        this.f11362b = false;
        int c = m17324c(i);
        this.f11363c = new int[c];
        this.f11364d = new zzaps[c];
        this.f11365e = 0;
    }

    private boolean m17322a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean m17323a(zzaps[] com_google_android_gms_internal_zzapsArr, zzaps[] com_google_android_gms_internal_zzapsArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!com_google_android_gms_internal_zzapsArr[i2].equals(com_google_android_gms_internal_zzapsArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int m17324c(int i) {
        return m17325d(i * 4) / 4;
    }

    private int m17325d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int m17326e(int i) {
        int i2 = 0;
        int i3 = this.f11365e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f11363c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    int m17327a() {
        return this.f11365e;
    }

    zzaps m17328a(int i) {
        int e = m17326e(i);
        return (e < 0 || this.f11364d[e] == f11361a) ? null : this.f11364d[e];
    }

    void m17329a(int i, zzaps com_google_android_gms_internal_zzaps) {
        int e = m17326e(i);
        if (e >= 0) {
            this.f11364d[e] = com_google_android_gms_internal_zzaps;
            return;
        }
        e ^= -1;
        if (e >= this.f11365e || this.f11364d[e] != f11361a) {
            if (this.f11365e >= this.f11363c.length) {
                int c = m17324c(this.f11365e + 1);
                Object obj = new int[c];
                Object obj2 = new zzaps[c];
                System.arraycopy(this.f11363c, 0, obj, 0, this.f11363c.length);
                System.arraycopy(this.f11364d, 0, obj2, 0, this.f11364d.length);
                this.f11363c = obj;
                this.f11364d = obj2;
            }
            if (this.f11365e - e != 0) {
                System.arraycopy(this.f11363c, e, this.f11363c, e + 1, this.f11365e - e);
                System.arraycopy(this.f11364d, e, this.f11364d, e + 1, this.f11365e - e);
            }
            this.f11363c[e] = i;
            this.f11364d[e] = com_google_android_gms_internal_zzaps;
            this.f11365e++;
            return;
        }
        this.f11363c[e] = i;
        this.f11364d[e] = com_google_android_gms_internal_zzaps;
    }

    public final zzapr aC() {
        int a = m17327a();
        zzapr com_google_android_gms_internal_zzapr = new zzapr(a);
        System.arraycopy(this.f11363c, 0, com_google_android_gms_internal_zzapr.f11363c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f11364d[i] != null) {
                com_google_android_gms_internal_zzapr.f11364d[i] = (zzaps) this.f11364d[i].clone();
            }
        }
        com_google_android_gms_internal_zzapr.f11365e = a;
        return com_google_android_gms_internal_zzapr;
    }

    zzaps m17330b(int i) {
        return this.f11364d[i];
    }

    public /* synthetic */ Object clone() {
        return aC();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzapr)) {
            return false;
        }
        zzapr com_google_android_gms_internal_zzapr = (zzapr) obj;
        return m17327a() != com_google_android_gms_internal_zzapr.m17327a() ? false : m17322a(this.f11363c, com_google_android_gms_internal_zzapr.f11363c, this.f11365e) && m17323a(this.f11364d, com_google_android_gms_internal_zzapr.f11364d, this.f11365e);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f11365e; i2++) {
            i = (((i * 31) + this.f11363c[i2]) * 31) + this.f11364d[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return m17327a() == 0;
    }
}
