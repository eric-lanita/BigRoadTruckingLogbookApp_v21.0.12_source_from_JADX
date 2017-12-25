package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collection;

public final class zzanz implements zzani {
    private final zzanp f11259a;

    private static final class zza<E> extends zzanh<Collection<E>> {
        private final zzanh<E> f11257a;
        private final zzanu<? extends Collection<E>> f11258b;

        public zza(zzamp com_google_android_gms_internal_zzamp, Type type, zzanh<E> com_google_android_gms_internal_zzanh_E, zzanu<? extends Collection<E>> com_google_android_gms_internal_zzanu__extends_java_util_Collection_E) {
            this.f11257a = new zzaoj(com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzanh_E, type);
            this.f11258b = com_google_android_gms_internal_zzanu__extends_java_util_Collection_E;
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Collection<E> collection) {
            if (collection == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
                return;
            }
            com_google_android_gms_internal_zzaoo.mo1854h();
            for (E zza : collection) {
                this.f11257a.zza(com_google_android_gms_internal_zzaoo, zza);
            }
            com_google_android_gms_internal_zzaoo.mo1855i();
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzj(com_google_android_gms_internal_zzaom);
        }

        public Collection<E> zzj(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.f11258b.zzczu();
            com_google_android_gms_internal_zzaom.beginArray();
            while (com_google_android_gms_internal_zzaom.hasNext()) {
                collection.add(this.f11257a.zzb(com_google_android_gms_internal_zzaom));
            }
            com_google_android_gms_internal_zzaom.endArray();
            return collection;
        }
    }

    public zzanz(zzanp com_google_android_gms_internal_zzanp) {
        this.f11259a = com_google_android_gms_internal_zzanp;
    }

    public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
        Type n = com_google_android_gms_internal_zzaol_T.m17304n();
        Class m = com_google_android_gms_internal_zzaol_T.m17303m();
        if (!Collection.class.isAssignableFrom(m)) {
            return null;
        }
        Type zza = zzano.zza(n, m);
        return new zza(com_google_android_gms_internal_zzamp, zza, com_google_android_gms_internal_zzamp.zza(zzaol.zzl(zza)), this.f11259a.zzb(com_google_android_gms_internal_zzaol_T));
    }
}
