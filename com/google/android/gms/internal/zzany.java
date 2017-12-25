package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class zzany<E> extends zzanh<Object> {
    public static final zzani bfu = new C32891();
    private final Class<E> f11255a;
    private final zzanh<E> f11256b;

    static class C32891 implements zzani {
        C32891() {
        }

        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            Type n = com_google_android_gms_internal_zzaol_T.m17304n();
            if (!(n instanceof GenericArrayType) && (!(n instanceof Class) || !((Class) n).isArray())) {
                return null;
            }
            n = zzano.zzh(n);
            return new zzany(com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzamp.zza(zzaol.zzl(n)), zzano.zzf(n));
        }
    }

    public zzany(zzamp com_google_android_gms_internal_zzamp, zzanh<E> com_google_android_gms_internal_zzanh_E, Class<E> cls) {
        this.f11256b = new zzaoj(com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzanh_E, cls);
        this.f11255a = cls;
    }

    public void zza(zzaoo com_google_android_gms_internal_zzaoo, Object obj) {
        if (obj == null) {
            com_google_android_gms_internal_zzaoo.mo1858l();
            return;
        }
        com_google_android_gms_internal_zzaoo.mo1854h();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f11256b.zza(com_google_android_gms_internal_zzaoo, Array.get(obj, i));
        }
        com_google_android_gms_internal_zzaoo.mo1855i();
    }

    public Object zzb(zzaom com_google_android_gms_internal_zzaom) {
        if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
        List arrayList = new ArrayList();
        com_google_android_gms_internal_zzaom.beginArray();
        while (com_google_android_gms_internal_zzaom.hasNext()) {
            arrayList.add(this.f11256b.zzb(com_google_android_gms_internal_zzaom));
        }
        com_google_android_gms_internal_zzaom.endArray();
        Object newInstance = Array.newInstance(this.f11255a, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
