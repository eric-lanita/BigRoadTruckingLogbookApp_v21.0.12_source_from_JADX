package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzaoe implements zzani {
    private final zzanp f11303a;
    private final boolean f11304b;

    private final class zza<K, V> extends zzanh<Map<K, V>> {
        final /* synthetic */ zzaoe f11299a;
        private final zzanh<K> f11300b;
        private final zzanh<V> f11301c;
        private final zzanu<? extends Map<K, V>> f11302d;

        public zza(zzaoe com_google_android_gms_internal_zzaoe, zzamp com_google_android_gms_internal_zzamp, Type type, zzanh<K> com_google_android_gms_internal_zzanh_K, Type type2, zzanh<V> com_google_android_gms_internal_zzanh_V, zzanu<? extends Map<K, V>> com_google_android_gms_internal_zzanu__extends_java_util_Map_K__V) {
            this.f11299a = com_google_android_gms_internal_zzaoe;
            this.f11300b = new zzaoj(com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzanh_K, type);
            this.f11301c = new zzaoj(com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzanh_V, type2);
            this.f11302d = com_google_android_gms_internal_zzanu__extends_java_util_Map_K__V;
        }

        private String m17287a(zzamv com_google_android_gms_internal_zzamv) {
            if (com_google_android_gms_internal_zzamv.zzczi()) {
                zzanb zzczm = com_google_android_gms_internal_zzamv.zzczm();
                if (zzczm.zzczp()) {
                    return String.valueOf(zzczm.zzcze());
                }
                if (zzczm.zzczo()) {
                    return Boolean.toString(zzczm.getAsBoolean());
                }
                if (zzczm.zzczq()) {
                    return zzczm.zzczf();
                }
                throw new AssertionError();
            } else if (com_google_android_gms_internal_zzamv.zzczj()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Map<K, V> map) {
            int i = 0;
            if (map == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
            } else if (this.f11299a.f11304b) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    zzamv zzcj = this.f11300b.zzcj(entry.getKey());
                    arrayList.add(zzcj);
                    arrayList2.add(entry.getValue());
                    int i3 = (zzcj.zzczg() || zzcj.zzczh()) ? 1 : 0;
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    com_google_android_gms_internal_zzaoo.mo1854h();
                    while (i < arrayList.size()) {
                        com_google_android_gms_internal_zzaoo.mo1854h();
                        zzanw.zzb((zzamv) arrayList.get(i), com_google_android_gms_internal_zzaoo);
                        this.f11301c.zza(com_google_android_gms_internal_zzaoo, arrayList2.get(i));
                        com_google_android_gms_internal_zzaoo.mo1855i();
                        i++;
                    }
                    com_google_android_gms_internal_zzaoo.mo1855i();
                    return;
                }
                com_google_android_gms_internal_zzaoo.mo1856j();
                while (i < arrayList.size()) {
                    com_google_android_gms_internal_zzaoo.zztr(m17287a((zzamv) arrayList.get(i)));
                    this.f11301c.zza(com_google_android_gms_internal_zzaoo, arrayList2.get(i));
                    i++;
                }
                com_google_android_gms_internal_zzaoo.mo1857k();
            } else {
                com_google_android_gms_internal_zzaoo.mo1856j();
                for (Entry entry2 : map.entrySet()) {
                    com_google_android_gms_internal_zzaoo.zztr(String.valueOf(entry2.getKey()));
                    this.f11301c.zza(com_google_android_gms_internal_zzaoo, entry2.getValue());
                }
                com_google_android_gms_internal_zzaoo.mo1857k();
            }
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzl(com_google_android_gms_internal_zzaom);
        }

        public Map<K, V> zzl(zzaom com_google_android_gms_internal_zzaom) {
            zzaon b = com_google_android_gms_internal_zzaom.mo1835b();
            if (b == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.f11302d.zzczu();
            Object zzb;
            if (b == zzaon.BEGIN_ARRAY) {
                com_google_android_gms_internal_zzaom.beginArray();
                while (com_google_android_gms_internal_zzaom.hasNext()) {
                    com_google_android_gms_internal_zzaom.beginArray();
                    zzb = this.f11300b.zzb(com_google_android_gms_internal_zzaom);
                    if (map.put(zzb, this.f11301c.zzb(com_google_android_gms_internal_zzaom)) != null) {
                        String valueOf = String.valueOf(zzb);
                        throw new zzane(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                    }
                    com_google_android_gms_internal_zzaom.endArray();
                }
                com_google_android_gms_internal_zzaom.endArray();
                return map;
            }
            com_google_android_gms_internal_zzaom.beginObject();
            while (com_google_android_gms_internal_zzaom.hasNext()) {
                zzanr.beV.zzi(com_google_android_gms_internal_zzaom);
                zzb = this.f11300b.zzb(com_google_android_gms_internal_zzaom);
                if (map.put(zzb, this.f11301c.zzb(com_google_android_gms_internal_zzaom)) != null) {
                    valueOf = String.valueOf(zzb);
                    throw new zzane(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                }
            }
            com_google_android_gms_internal_zzaom.endObject();
            return map;
        }
    }

    public zzaoe(zzanp com_google_android_gms_internal_zzanp, boolean z) {
        this.f11303a = com_google_android_gms_internal_zzanp;
        this.f11304b = z;
    }

    private zzanh<?> m17288a(zzamp com_google_android_gms_internal_zzamp, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzaok.bgc : com_google_android_gms_internal_zzamp.zza(zzaol.zzl(type));
    }

    public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
        Type n = com_google_android_gms_internal_zzaol_T.m17304n();
        if (!Map.class.isAssignableFrom(com_google_android_gms_internal_zzaol_T.m17303m())) {
            return null;
        }
        Type[] zzb = zzano.zzb(n, zzano.zzf(n));
        zzanh a = m17288a(com_google_android_gms_internal_zzamp, zzb[0]);
        zzanh zza = com_google_android_gms_internal_zzamp.zza(zzaol.zzl(zzb[1]));
        zzanu zzb2 = this.f11303a.zzb(com_google_android_gms_internal_zzaol_T);
        return new zza(this, com_google_android_gms_internal_zzamp, zzb[0], a, zzb[1], zza, zzb2);
    }
}
