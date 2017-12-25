package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaog.zza;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class zzaoj<T> extends zzanh<T> {
    private final zzamp f11323a;
    private final zzanh<T> f11324b;
    private final Type f11325c;

    zzaoj(zzamp com_google_android_gms_internal_zzamp, zzanh<T> com_google_android_gms_internal_zzanh_T, Type type) {
        this.f11323a = com_google_android_gms_internal_zzamp;
        this.f11324b = com_google_android_gms_internal_zzanh_T;
        this.f11325c = type;
    }

    private Type m17301a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    public void zza(zzaoo com_google_android_gms_internal_zzaoo, T t) {
        zzanh com_google_android_gms_internal_zzanh = this.f11324b;
        Type a = m17301a(this.f11325c, t);
        if (a != this.f11325c) {
            com_google_android_gms_internal_zzanh = this.f11323a.zza(zzaol.zzl(a));
            if ((com_google_android_gms_internal_zzanh instanceof zza) && !(this.f11324b instanceof zza)) {
                com_google_android_gms_internal_zzanh = this.f11324b;
            }
        }
        com_google_android_gms_internal_zzanh.zza(com_google_android_gms_internal_zzaoo, t);
    }

    public T zzb(zzaom com_google_android_gms_internal_zzaom) {
        return this.f11324b.zzb(com_google_android_gms_internal_zzaom);
    }
}
