package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class zzaps implements Cloneable {
    private zzapq<?, ?> f11366a;
    private Object f11367b;
    private List<zzapx> f11368c = new ArrayList();

    zzaps() {
    }

    private byte[] m17331b() {
        byte[] bArr = new byte[m17332a()];
        m17334a(zzapo.zzbe(bArr));
        return bArr;
    }

    int m17332a() {
        if (this.f11367b != null) {
            return this.f11366a.m17313a(this.f11367b);
        }
        int i = 0;
        for (zzapx a : this.f11368c) {
            i = a.m17348a() + i;
        }
        return i;
    }

    <T> T m17333a(zzapq<?, T> com_google_android_gms_internal_zzapq___T) {
        if (this.f11367b == null) {
            this.f11366a = com_google_android_gms_internal_zzapq___T;
            this.f11367b = com_google_android_gms_internal_zzapq___T.m17315a(this.f11368c);
            this.f11368c = null;
        } else if (!this.f11366a.equals(com_google_android_gms_internal_zzapq___T)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.f11367b;
    }

    void m17334a(zzapo com_google_android_gms_internal_zzapo) {
        if (this.f11367b != null) {
            this.f11366a.m17317a(this.f11367b, com_google_android_gms_internal_zzapo);
            return;
        }
        for (zzapx a : this.f11368c) {
            a.m17349a(com_google_android_gms_internal_zzapo);
        }
    }

    void m17335a(zzapx com_google_android_gms_internal_zzapx) {
        this.f11368c.add(com_google_android_gms_internal_zzapx);
    }

    public final zzaps aD() {
        zzaps com_google_android_gms_internal_zzaps = new zzaps();
        try {
            com_google_android_gms_internal_zzaps.f11366a = this.f11366a;
            if (this.f11368c == null) {
                com_google_android_gms_internal_zzaps.f11368c = null;
            } else {
                com_google_android_gms_internal_zzaps.f11368c.addAll(this.f11368c);
            }
            if (this.f11367b != null) {
                if (this.f11367b instanceof zzapv) {
                    com_google_android_gms_internal_zzaps.f11367b = (zzapv) ((zzapv) this.f11367b).clone();
                } else if (this.f11367b instanceof byte[]) {
                    com_google_android_gms_internal_zzaps.f11367b = ((byte[]) this.f11367b).clone();
                } else if (this.f11367b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f11367b;
                    r4 = new byte[bArr.length][];
                    com_google_android_gms_internal_zzaps.f11367b = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.f11367b instanceof boolean[]) {
                    com_google_android_gms_internal_zzaps.f11367b = ((boolean[]) this.f11367b).clone();
                } else if (this.f11367b instanceof int[]) {
                    com_google_android_gms_internal_zzaps.f11367b = ((int[]) this.f11367b).clone();
                } else if (this.f11367b instanceof long[]) {
                    com_google_android_gms_internal_zzaps.f11367b = ((long[]) this.f11367b).clone();
                } else if (this.f11367b instanceof float[]) {
                    com_google_android_gms_internal_zzaps.f11367b = ((float[]) this.f11367b).clone();
                } else if (this.f11367b instanceof double[]) {
                    com_google_android_gms_internal_zzaps.f11367b = ((double[]) this.f11367b).clone();
                } else if (this.f11367b instanceof zzapv[]) {
                    zzapv[] com_google_android_gms_internal_zzapvArr = (zzapv[]) this.f11367b;
                    r4 = new zzapv[com_google_android_gms_internal_zzapvArr.length];
                    com_google_android_gms_internal_zzaps.f11367b = r4;
                    for (r2 = 0; r2 < com_google_android_gms_internal_zzapvArr.length; r2++) {
                        r4[r2] = (zzapv) com_google_android_gms_internal_zzapvArr[r2].clone();
                    }
                }
            }
            return com_google_android_gms_internal_zzaps;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return aD();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaps)) {
            return false;
        }
        zzaps com_google_android_gms_internal_zzaps = (zzaps) obj;
        if (this.f11367b != null && com_google_android_gms_internal_zzaps.f11367b != null) {
            return this.f11366a == com_google_android_gms_internal_zzaps.f11366a ? !this.f11366a.f11359b.isArray() ? this.f11367b.equals(com_google_android_gms_internal_zzaps.f11367b) : this.f11367b instanceof byte[] ? Arrays.equals((byte[]) this.f11367b, (byte[]) com_google_android_gms_internal_zzaps.f11367b) : this.f11367b instanceof int[] ? Arrays.equals((int[]) this.f11367b, (int[]) com_google_android_gms_internal_zzaps.f11367b) : this.f11367b instanceof long[] ? Arrays.equals((long[]) this.f11367b, (long[]) com_google_android_gms_internal_zzaps.f11367b) : this.f11367b instanceof float[] ? Arrays.equals((float[]) this.f11367b, (float[]) com_google_android_gms_internal_zzaps.f11367b) : this.f11367b instanceof double[] ? Arrays.equals((double[]) this.f11367b, (double[]) com_google_android_gms_internal_zzaps.f11367b) : this.f11367b instanceof boolean[] ? Arrays.equals((boolean[]) this.f11367b, (boolean[]) com_google_android_gms_internal_zzaps.f11367b) : Arrays.deepEquals((Object[]) this.f11367b, (Object[]) com_google_android_gms_internal_zzaps.f11367b) : false;
        } else {
            if (this.f11368c != null && com_google_android_gms_internal_zzaps.f11368c != null) {
                return this.f11368c.equals(com_google_android_gms_internal_zzaps.f11368c);
            }
            try {
                return Arrays.equals(m17331b(), com_google_android_gms_internal_zzaps.m17331b());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m17331b()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
