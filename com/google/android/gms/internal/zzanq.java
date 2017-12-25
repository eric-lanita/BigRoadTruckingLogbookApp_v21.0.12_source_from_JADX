package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzanq implements zzani, Cloneable {
    public static final zzanq beK = new zzanq();
    private double f11222a = -1.0d;
    private int f11223b = 136;
    private boolean f11224c = true;
    private List<zzaml> f11225d = Collections.emptyList();
    private List<zzaml> f11226e = Collections.emptyList();

    private boolean m17210a(zzanl com_google_android_gms_internal_zzanl) {
        return com_google_android_gms_internal_zzanl == null || com_google_android_gms_internal_zzanl.zzczt() <= this.f11222a;
    }

    private boolean m17211a(zzanl com_google_android_gms_internal_zzanl, zzanm com_google_android_gms_internal_zzanm) {
        return m17210a(com_google_android_gms_internal_zzanl) && m17212a(com_google_android_gms_internal_zzanm);
    }

    private boolean m17212a(zzanm com_google_android_gms_internal_zzanm) {
        return com_google_android_gms_internal_zzanm == null || com_google_android_gms_internal_zzanm.zzczt() > this.f11222a;
    }

    private boolean m17213a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean m17214b(Class<?> cls) {
        return cls.isMemberClass() && !m17215c(cls);
    }

    private boolean m17215c(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    protected zzanq m17216a() {
        try {
            return (zzanq) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    protected /* synthetic */ Object clone() {
        return m17216a();
    }

    public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
        Class m = com_google_android_gms_internal_zzaol_T.m17303m();
        final boolean zza = zza(m, true);
        final boolean zza2 = zza(m, false);
        if (!zza && !zza2) {
            return null;
        }
        final zzamp com_google_android_gms_internal_zzamp2 = com_google_android_gms_internal_zzamp;
        final zzaol<T> com_google_android_gms_internal_zzaol_T2 = com_google_android_gms_internal_zzaol_T;
        return new zzanh<T>(this) {
            final /* synthetic */ zzanq f11220e;
            private zzanh<T> f11221f;

            private zzanh<T> m17209a() {
                zzanh<T> com_google_android_gms_internal_zzanh_T = this.f11221f;
                if (com_google_android_gms_internal_zzanh_T != null) {
                    return com_google_android_gms_internal_zzanh_T;
                }
                com_google_android_gms_internal_zzanh_T = com_google_android_gms_internal_zzamp2.zza(this.f11220e, com_google_android_gms_internal_zzaol_T2);
                this.f11221f = com_google_android_gms_internal_zzanh_T;
                return com_google_android_gms_internal_zzanh_T;
            }

            public void zza(zzaoo com_google_android_gms_internal_zzaoo, T t) {
                if (zza) {
                    com_google_android_gms_internal_zzaoo.mo1858l();
                } else {
                    m17209a().zza(com_google_android_gms_internal_zzaoo, t);
                }
            }

            public T zzb(zzaom com_google_android_gms_internal_zzaom) {
                if (!zza2) {
                    return m17209a().zzb(com_google_android_gms_internal_zzaom);
                }
                com_google_android_gms_internal_zzaom.skipValue();
                return null;
            }
        };
    }

    public zzanq zza(zzaml com_google_android_gms_internal_zzaml, boolean z, boolean z2) {
        zzanq a = m17216a();
        if (z) {
            a.f11225d = new ArrayList(this.f11225d);
            a.f11225d.add(com_google_android_gms_internal_zzaml);
        }
        if (z2) {
            a.f11226e = new ArrayList(this.f11226e);
            a.f11226e.add(com_google_android_gms_internal_zzaml);
        }
        return a;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.f11222a != -1.0d && !m17211a((zzanl) cls.getAnnotation(zzanl.class), (zzanm) cls.getAnnotation(zzanm.class))) {
            return true;
        }
        if (!this.f11224c && m17214b(cls)) {
            return true;
        }
        if (m17213a((Class) cls)) {
            return true;
        }
        for (zzaml zzh : z ? this.f11225d : this.f11226e) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.f11223b & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f11222a != -1.0d && !m17211a((zzanl) field.getAnnotation(zzanl.class), (zzanm) field.getAnnotation(zzanm.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (!this.f11224c && m17214b(field.getType())) {
            return true;
        }
        if (m17213a(field.getType())) {
            return true;
        }
        List<zzaml> list = z ? this.f11225d : this.f11226e;
        if (!list.isEmpty()) {
            zzamm com_google_android_gms_internal_zzamm = new zzamm(field);
            for (zzaml zza : list) {
                if (zza.zza(com_google_android_gms_internal_zzamm)) {
                    return true;
                }
            }
        }
        return false;
    }

    public zzanq zzg(int... iArr) {
        int i = 0;
        zzanq a = m17216a();
        a.f11223b = 0;
        int length = iArr.length;
        while (i < length) {
            a.f11223b = iArr[i] | a.f11223b;
            i++;
        }
        return a;
    }
}
