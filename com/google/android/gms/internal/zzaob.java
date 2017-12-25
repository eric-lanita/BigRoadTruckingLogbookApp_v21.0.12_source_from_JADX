package com.google.android.gms.internal;

public final class zzaob implements zzani {
    private final zzanp f11263a;

    public zzaob(zzanp com_google_android_gms_internal_zzanp) {
        this.f11263a = com_google_android_gms_internal_zzanp;
    }

    static zzanh<?> m17231a(zzanp com_google_android_gms_internal_zzanp, zzamp com_google_android_gms_internal_zzamp, zzaol<?> com_google_android_gms_internal_zzaol_, zzanj com_google_android_gms_internal_zzanj) {
        Class value = com_google_android_gms_internal_zzanj.value();
        if (zzanh.class.isAssignableFrom(value)) {
            return (zzanh) com_google_android_gms_internal_zzanp.zzb(zzaol.zzr(value)).zzczu();
        }
        if (zzani.class.isAssignableFrom(value)) {
            return ((zzani) com_google_android_gms_internal_zzanp.zzb(zzaol.zzr(value)).zzczu()).zza(com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzaol_);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
        zzanj com_google_android_gms_internal_zzanj = (zzanj) com_google_android_gms_internal_zzaol_T.m17303m().getAnnotation(zzanj.class);
        return com_google_android_gms_internal_zzanj == null ? null : m17231a(this.f11263a, com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzaol_T, com_google_android_gms_internal_zzanj);
    }
}
