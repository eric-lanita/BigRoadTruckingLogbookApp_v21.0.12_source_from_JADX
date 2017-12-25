package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzaof extends zzanh<Object> {
    public static final zzani bfu = new C32931();
    private final zzamp f11306a;

    static class C32931 implements zzani {
        C32931() {
        }

        public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
            return com_google_android_gms_internal_zzaol_T.m17303m() == Object.class ? new zzaof(com_google_android_gms_internal_zzamp) : null;
        }
    }

    private zzaof(zzamp com_google_android_gms_internal_zzamp) {
        this.f11306a = com_google_android_gms_internal_zzamp;
    }

    public void zza(zzaoo com_google_android_gms_internal_zzaoo, Object obj) {
        if (obj == null) {
            com_google_android_gms_internal_zzaoo.mo1858l();
            return;
        }
        zzanh zzk = this.f11306a.zzk(obj.getClass());
        if (zzk instanceof zzaof) {
            com_google_android_gms_internal_zzaoo.mo1856j();
            com_google_android_gms_internal_zzaoo.mo1857k();
            return;
        }
        zzk.zza(com_google_android_gms_internal_zzaoo, obj);
    }

    public Object zzb(zzaom com_google_android_gms_internal_zzaom) {
        switch (com_google_android_gms_internal_zzaom.mo1835b()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                com_google_android_gms_internal_zzaom.beginArray();
                while (com_google_android_gms_internal_zzaom.hasNext()) {
                    arrayList.add(zzb(com_google_android_gms_internal_zzaom));
                }
                com_google_android_gms_internal_zzaom.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                Map com_google_android_gms_internal_zzant = new zzant();
                com_google_android_gms_internal_zzaom.beginObject();
                while (com_google_android_gms_internal_zzaom.hasNext()) {
                    com_google_android_gms_internal_zzant.put(com_google_android_gms_internal_zzaom.nextName(), zzb(com_google_android_gms_internal_zzaom));
                }
                com_google_android_gms_internal_zzaom.endObject();
                return com_google_android_gms_internal_zzant;
            case STRING:
                return com_google_android_gms_internal_zzaom.nextString();
            case NUMBER:
                return Double.valueOf(com_google_android_gms_internal_zzaom.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(com_google_android_gms_internal_zzaom.nextBoolean());
            case NULL:
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
