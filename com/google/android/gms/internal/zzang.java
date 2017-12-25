package com.google.android.gms.internal;

final class zzang<T> extends zzanh<T> {
    private final zzand<T> f11187a;
    private final zzamu<T> f11188b;
    private final zzamp f11189c;
    private final zzaol<T> f11190d;
    private final zzani f11191e;
    private zzanh<T> f11192f;

    private static class zza implements zzani {
        private final zzaol<?> f11182a;
        private final boolean f11183b;
        private final Class<?> f11184c;
        private final zzand<?> f11185d;
        private final zzamu<?> f11186e;

        private zza(Object obj, zzaol<?> com_google_android_gms_internal_zzaol_, boolean z, Class<?> cls) {
            this.f11185d = obj instanceof zzand ? (zzand) obj : null;
            this.f11186e = obj instanceof zzamu ? (zzamu) obj : null;
            boolean z2 = (this.f11185d == null && this.f11186e == null) ? false : true;
            zzann.zzbo(z2);
            this.f11182a = com_google_android_gms_internal_zzaol_;
            this.f11183b = z;
            this.f11184c = cls;
        }

        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            boolean isAssignableFrom = this.f11182a != null ? this.f11182a.equals(com_google_android_gms_internal_zzaol_T) || (this.f11183b && this.f11182a.m17304n() == com_google_android_gms_internal_zzaol_T.m17303m()) : this.f11184c.isAssignableFrom(com_google_android_gms_internal_zzaol_T.m17303m());
            return isAssignableFrom ? new zzang(this.f11185d, this.f11186e, com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzaol_T, this) : null;
        }
    }

    private zzang(zzand<T> com_google_android_gms_internal_zzand_T, zzamu<T> com_google_android_gms_internal_zzamu_T, zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T, zzani com_google_android_gms_internal_zzani) {
        this.f11187a = com_google_android_gms_internal_zzand_T;
        this.f11188b = com_google_android_gms_internal_zzamu_T;
        this.f11189c = com_google_android_gms_internal_zzamp;
        this.f11190d = com_google_android_gms_internal_zzaol_T;
        this.f11191e = com_google_android_gms_internal_zzani;
    }

    private zzanh<T> m17195a() {
        zzanh<T> com_google_android_gms_internal_zzanh_T = this.f11192f;
        if (com_google_android_gms_internal_zzanh_T != null) {
            return com_google_android_gms_internal_zzanh_T;
        }
        com_google_android_gms_internal_zzanh_T = this.f11189c.zza(this.f11191e, this.f11190d);
        this.f11192f = com_google_android_gms_internal_zzanh_T;
        return com_google_android_gms_internal_zzanh_T;
    }

    public static zzani zza(zzaol<?> com_google_android_gms_internal_zzaol_, Object obj) {
        return new zza(obj, com_google_android_gms_internal_zzaol_, false, null);
    }

    public static zzani zzb(zzaol<?> com_google_android_gms_internal_zzaol_, Object obj) {
        return new zza(obj, com_google_android_gms_internal_zzaol_, com_google_android_gms_internal_zzaol_.m17304n() == com_google_android_gms_internal_zzaol_.m17303m(), null);
    }

    public void zza(zzaoo com_google_android_gms_internal_zzaoo, T t) {
        if (this.f11187a == null) {
            m17195a().zza(com_google_android_gms_internal_zzaoo, t);
        } else if (t == null) {
            com_google_android_gms_internal_zzaoo.mo1858l();
        } else {
            zzanw.zzb(this.f11187a.zza(t, this.f11190d.m17304n(), this.f11189c.f11159b), com_google_android_gms_internal_zzaoo);
        }
    }

    public T zzb(zzaom com_google_android_gms_internal_zzaom) {
        if (this.f11188b == null) {
            return m17195a().zzb(com_google_android_gms_internal_zzaom);
        }
        zzamv zzh = zzanw.zzh(com_google_android_gms_internal_zzaom);
        if (zzh.zzczj()) {
            return null;
        }
        try {
            return this.f11188b.zzb(zzh, this.f11190d.m17304n(), this.f11189c.f11158a);
        } catch (zzamz e) {
            throw e;
        } catch (Throwable e2) {
            throw new zzamz(e2);
        }
    }
}
