package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzaog implements zzani {
    private final zzanp f11318a;
    private final zzamo f11319b;
    private final zzanq f11320c;

    static abstract class zzb {
        final String f11307g;
        final boolean f11308h;
        final boolean f11309i;

        protected zzb(String str, boolean z, boolean z2) {
            this.f11307g = str;
            this.f11308h = z;
            this.f11309i = z2;
        }

        abstract void mo1864a(zzaom com_google_android_gms_internal_zzaom, Object obj);

        abstract void mo1865a(zzaoo com_google_android_gms_internal_zzaoo, Object obj);

        abstract boolean zzco(Object obj);
    }

    public static final class zza<T> extends zzanh<T> {
        private final zzanu<T> f11316a;
        private final Map<String, zzb> f11317b;

        private zza(zzanu<T> com_google_android_gms_internal_zzanu_T, Map<String, zzb> map) {
            this.f11316a = com_google_android_gms_internal_zzanu_T;
            this.f11317b = map;
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, T t) {
            if (t == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
                return;
            }
            com_google_android_gms_internal_zzaoo.mo1856j();
            try {
                for (zzb com_google_android_gms_internal_zzaog_zzb : this.f11317b.values()) {
                    if (com_google_android_gms_internal_zzaog_zzb.zzco(t)) {
                        com_google_android_gms_internal_zzaoo.zztr(com_google_android_gms_internal_zzaog_zzb.f11307g);
                        com_google_android_gms_internal_zzaog_zzb.mo1865a(com_google_android_gms_internal_zzaoo, (Object) t);
                    }
                }
                com_google_android_gms_internal_zzaoo.mo1857k();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public T zzb(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() == zzaon.NULL) {
                com_google_android_gms_internal_zzaom.nextNull();
                return null;
            }
            T zzczu = this.f11316a.zzczu();
            try {
                com_google_android_gms_internal_zzaom.beginObject();
                while (com_google_android_gms_internal_zzaom.hasNext()) {
                    zzb com_google_android_gms_internal_zzaog_zzb = (zzb) this.f11317b.get(com_google_android_gms_internal_zzaom.nextName());
                    if (com_google_android_gms_internal_zzaog_zzb == null || !com_google_android_gms_internal_zzaog_zzb.f11309i) {
                        com_google_android_gms_internal_zzaom.skipValue();
                    } else {
                        com_google_android_gms_internal_zzaog_zzb.mo1864a(com_google_android_gms_internal_zzaom, (Object) zzczu);
                    }
                }
                com_google_android_gms_internal_zzaom.endObject();
                return zzczu;
            } catch (Throwable e) {
                throw new zzane(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public zzaog(zzanp com_google_android_gms_internal_zzanp, zzamo com_google_android_gms_internal_zzamo, zzanq com_google_android_gms_internal_zzanq) {
        this.f11318a = com_google_android_gms_internal_zzanp;
        this.f11319b = com_google_android_gms_internal_zzamo;
        this.f11320c = com_google_android_gms_internal_zzanq;
    }

    private zzanh<?> m17294a(zzamp com_google_android_gms_internal_zzamp, Field field, zzaol<?> com_google_android_gms_internal_zzaol_) {
        zzanj com_google_android_gms_internal_zzanj = (zzanj) field.getAnnotation(zzanj.class);
        if (com_google_android_gms_internal_zzanj != null) {
            zzanh<?> a = zzaob.m17231a(this.f11318a, com_google_android_gms_internal_zzamp, com_google_android_gms_internal_zzaol_, com_google_android_gms_internal_zzanj);
            if (a != null) {
                return a;
            }
        }
        return com_google_android_gms_internal_zzamp.zza((zzaol) com_google_android_gms_internal_zzaol_);
    }

    private zzb m17296a(zzamp com_google_android_gms_internal_zzamp, Field field, String str, zzaol<?> com_google_android_gms_internal_zzaol_, boolean z, boolean z2) {
        final boolean zzk = zzanv.zzk(com_google_android_gms_internal_zzaol_.m17303m());
        final zzamp com_google_android_gms_internal_zzamp2 = com_google_android_gms_internal_zzamp;
        final Field field2 = field;
        final zzaol<?> com_google_android_gms_internal_zzaol_2 = com_google_android_gms_internal_zzaol_;
        return new zzb(this, str, z, z2) {
            final zzanh<?> f11310a = this.f11315f.m17294a(com_google_android_gms_internal_zzamp2, field2, com_google_android_gms_internal_zzaol_2);
            final /* synthetic */ zzaog f11315f;

            void mo1864a(zzaom com_google_android_gms_internal_zzaom, Object obj) {
                Object zzb = this.f11310a.zzb(com_google_android_gms_internal_zzaom);
                if (zzb != null || !zzk) {
                    field2.set(obj, zzb);
                }
            }

            void mo1865a(zzaoo com_google_android_gms_internal_zzaoo, Object obj) {
                new zzaoj(com_google_android_gms_internal_zzamp2, this.f11310a, com_google_android_gms_internal_zzaol_2.m17304n()).zza(com_google_android_gms_internal_zzaoo, field2.get(obj));
            }

            public boolean zzco(Object obj) {
                return this.h && field2.get(obj) != obj;
            }
        };
    }

    static List<String> m17297a(zzamo com_google_android_gms_internal_zzamo, Field field) {
        zzank com_google_android_gms_internal_zzank = (zzank) field.getAnnotation(zzank.class);
        List<String> linkedList = new LinkedList();
        if (com_google_android_gms_internal_zzank == null) {
            linkedList.add(com_google_android_gms_internal_zzamo.zzc(field));
        } else {
            linkedList.add(com_google_android_gms_internal_zzank.value());
            for (Object add : com_google_android_gms_internal_zzank.zzczs()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    private List<String> m17298a(Field field) {
        return m17297a(this.f11319b, field);
    }

    private Map<String, zzb> m17299a(zzamp com_google_android_gms_internal_zzamp, zzaol<?> com_google_android_gms_internal_zzaol_, Class<?> cls) {
        Map<String, zzb> linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type n = com_google_android_gms_internal_zzaol_.m17304n();
        Class m;
        while (m != Object.class) {
            for (Field field : m.getDeclaredFields()) {
                boolean zza = zza(field, true);
                boolean zza2 = zza(field, false);
                if (zza || zza2) {
                    field.setAccessible(true);
                    Type zza3 = zzano.zza(r19.m17304n(), m, field.getGenericType());
                    List a = m17298a(field);
                    zzb com_google_android_gms_internal_zzaog_zzb = null;
                    int i = 0;
                    while (i < a.size()) {
                        String str = (String) a.get(i);
                        if (i != 0) {
                            zza = false;
                        }
                        zzb com_google_android_gms_internal_zzaog_zzb2 = (zzb) linkedHashMap.put(str, m17296a(com_google_android_gms_internal_zzamp, field, str, zzaol.zzl(zza3), zza, zza2));
                        if (com_google_android_gms_internal_zzaog_zzb != null) {
                            com_google_android_gms_internal_zzaog_zzb2 = com_google_android_gms_internal_zzaog_zzb;
                        }
                        i++;
                        com_google_android_gms_internal_zzaog_zzb = com_google_android_gms_internal_zzaog_zzb2;
                    }
                    if (com_google_android_gms_internal_zzaog_zzb != null) {
                        String valueOf = String.valueOf(n);
                        String str2 = com_google_android_gms_internal_zzaog_zzb.f11307g;
                        throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(str2).length()).append(valueOf).append(" declares multiple JSON fields named ").append(str2).toString());
                    }
                }
            }
            zzaol zzl = zzaol.zzl(zzano.zza(zzl.m17304n(), m, m.getGenericSuperclass()));
            m = zzl.m17303m();
        }
        return linkedHashMap;
    }

    static boolean m17300a(Field field, boolean z, zzanq com_google_android_gms_internal_zzanq) {
        return (com_google_android_gms_internal_zzanq.zza(field.getType(), z) || com_google_android_gms_internal_zzanq.zza(field, z)) ? false : true;
    }

    public <T> zzanh<T> zza(zzamp com_google_android_gms_internal_zzamp, zzaol<T> com_google_android_gms_internal_zzaol_T) {
        Class m = com_google_android_gms_internal_zzaol_T.m17303m();
        return !Object.class.isAssignableFrom(m) ? null : new zza(this.f11318a.zzb(com_google_android_gms_internal_zzaol_T), m17299a(com_google_android_gms_internal_zzamp, (zzaol) com_google_android_gms_internal_zzaol_T, m));
    }

    public boolean zza(Field field, boolean z) {
        return m17300a(field, z, this.f11320c);
    }
}
