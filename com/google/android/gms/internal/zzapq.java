package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzapq<M extends zzapp<M>, T> {
    protected final int f11358a;
    protected final Class<T> f11359b;
    protected final boolean f11360c;
    public final int tag;

    private zzapq(int i, Class<T> cls, int i2, boolean z) {
        this.f11358a = i;
        this.f11359b = cls;
        this.tag = i2;
        this.f11360c = z;
    }

    private T m17311b(List<zzapx> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            zzapx com_google_android_gms_internal_zzapx = (zzapx) list.get(i);
            if (com_google_android_gms_internal_zzapx.f11372b.length != 0) {
                m17316a(com_google_android_gms_internal_zzapx, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.f11359b.cast(Array.newInstance(this.f11359b.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T m17312c(List<zzapx> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.f11359b.cast(m17314a(zzapn.zzbd(((zzapx) list.get(list.size() - 1)).f11372b)));
    }

    public static <M extends zzapp<M>, T extends zzapv> zzapq<M, T> zza(int i, Class<T> cls, long j) {
        return new zzapq(i, cls, (int) j, false);
    }

    int m17313a(Object obj) {
        return this.f11360c ? m17318b(obj) : m17320c(obj);
    }

    protected Object m17314a(zzapn com_google_android_gms_internal_zzapn) {
        String valueOf;
        Class componentType = this.f11360c ? this.f11359b.getComponentType() : this.f11359b;
        try {
            zzapv com_google_android_gms_internal_zzapv;
            switch (this.f11358a) {
                case 10:
                    com_google_android_gms_internal_zzapv = (zzapv) componentType.newInstance();
                    com_google_android_gms_internal_zzapn.zza(com_google_android_gms_internal_zzapv, zzapy.zzagj(this.tag));
                    return com_google_android_gms_internal_zzapv;
                case 11:
                    com_google_android_gms_internal_zzapv = (zzapv) componentType.newInstance();
                    com_google_android_gms_internal_zzapn.zza(com_google_android_gms_internal_zzapv);
                    return com_google_android_gms_internal_zzapv;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f11358a);
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    final T m17315a(List<zzapx> list) {
        return list == null ? null : this.f11360c ? m17311b((List) list) : m17312c((List) list);
    }

    protected void m17316a(zzapx com_google_android_gms_internal_zzapx, List<Object> list) {
        list.add(m17314a(zzapn.zzbd(com_google_android_gms_internal_zzapx.f11372b)));
    }

    void m17317a(Object obj, zzapo com_google_android_gms_internal_zzapo) {
        if (this.f11360c) {
            m17321c(obj, com_google_android_gms_internal_zzapo);
        } else {
            m17319b(obj, com_google_android_gms_internal_zzapo);
        }
    }

    protected int m17318b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m17320c(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void m17319b(Object obj, zzapo com_google_android_gms_internal_zzapo) {
        try {
            com_google_android_gms_internal_zzapo.zzagb(this.tag);
            switch (this.f11358a) {
                case 10:
                    zzapv com_google_android_gms_internal_zzapv = (zzapv) obj;
                    int zzagj = zzapy.zzagj(this.tag);
                    com_google_android_gms_internal_zzapo.zzb(com_google_android_gms_internal_zzapv);
                    com_google_android_gms_internal_zzapo.zzai(zzagj, 4);
                    return;
                case 11:
                    com_google_android_gms_internal_zzapo.zzc((zzapv) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f11358a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int m17320c(Object obj) {
        int zzagj = zzapy.zzagj(this.tag);
        switch (this.f11358a) {
            case 10:
                return zzapo.zzb(zzagj, (zzapv) obj);
            case 11:
                return zzapo.zzc(zzagj, (zzapv) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f11358a);
        }
    }

    protected void m17321c(Object obj, zzapo com_google_android_gms_internal_zzapo) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m17319b(obj2, com_google_android_gms_internal_zzapo);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzapq)) {
            return false;
        }
        zzapq com_google_android_gms_internal_zzapq = (zzapq) obj;
        return this.f11358a == com_google_android_gms_internal_zzapq.f11358a && this.f11359b == com_google_android_gms_internal_zzapq.f11359b && this.tag == com_google_android_gms_internal_zzapq.tag && this.f11360c == com_google_android_gms_internal_zzapq.f11360c;
    }

    public int hashCode() {
        return (this.f11360c ? 1 : 0) + ((((((this.f11358a + 1147) * 31) + this.f11359b.hashCode()) * 31) + this.tag) * 31);
    }
}
