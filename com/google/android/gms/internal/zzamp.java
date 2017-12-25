package com.google.android.gms.internal;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzamp {
    final zzamt f11158a;
    final zzanc f11159b;
    private final ThreadLocal<Map<zzaol<?>, zza<?>>> f11160c;
    private final Map<zzaol<?>, zzanh<?>> f11161d;
    private final List<zzani> f11162e;
    private final zzanp f11163f;
    private final boolean f11164g;
    private final boolean f11165h;
    private final boolean f11166i;
    private final boolean f11167j;

    class C32631 implements zzamt {
        final /* synthetic */ zzamp f11152a;

        C32631(zzamp com_google_android_gms_internal_zzamp) {
            this.f11152a = com_google_android_gms_internal_zzamp;
        }
    }

    class C32642 implements zzanc {
        final /* synthetic */ zzamp f11153a;

        C32642(zzamp com_google_android_gms_internal_zzamp) {
            this.f11153a = com_google_android_gms_internal_zzamp;
        }
    }

    class C32653 extends zzanh<Number> {
        final /* synthetic */ zzamp f11154a;

        C32653(zzamp com_google_android_gms_internal_zzamp) {
            this.f11154a = com_google_android_gms_internal_zzamp;
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            if (number == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
                return;
            }
            this.f11154a.m17185a(number.doubleValue());
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zze(com_google_android_gms_internal_zzaom);
        }

        public Double zze(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return Double.valueOf(com_google_android_gms_internal_zzaom.nextDouble());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    }

    class C32664 extends zzanh<Number> {
        final /* synthetic */ zzamp f11155a;

        C32664(zzamp com_google_android_gms_internal_zzamp) {
            this.f11155a = com_google_android_gms_internal_zzamp;
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            if (number == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
                return;
            }
            this.f11155a.m17185a((double) number.floatValue());
            com_google_android_gms_internal_zzaoo.zza(number);
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzf(com_google_android_gms_internal_zzaom);
        }

        public Float zzf(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return Float.valueOf((float) com_google_android_gms_internal_zzaom.nextDouble());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    }

    class C32675 extends zzanh<Number> {
        final /* synthetic */ zzamp f11156a;

        C32675(zzamp com_google_android_gms_internal_zzamp) {
            this.f11156a = com_google_android_gms_internal_zzamp;
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, Number number) {
            if (number == null) {
                com_google_android_gms_internal_zzaoo.mo1858l();
            } else {
                com_google_android_gms_internal_zzaoo.zzts(number.toString());
            }
        }

        public /* synthetic */ Object zzb(zzaom com_google_android_gms_internal_zzaom) {
            return zzg(com_google_android_gms_internal_zzaom);
        }

        public Number zzg(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.NULL) {
                return Long.valueOf(com_google_android_gms_internal_zzaom.nextLong());
            }
            com_google_android_gms_internal_zzaom.nextNull();
            return null;
        }
    }

    static class zza<T> extends zzanh<T> {
        private zzanh<T> f11157a;

        zza() {
        }

        public void zza(zzanh<T> com_google_android_gms_internal_zzanh_T) {
            if (this.f11157a != null) {
                throw new AssertionError();
            }
            this.f11157a = com_google_android_gms_internal_zzanh_T;
        }

        public void zza(zzaoo com_google_android_gms_internal_zzaoo, T t) {
            if (this.f11157a == null) {
                throw new IllegalStateException();
            }
            this.f11157a.zza(com_google_android_gms_internal_zzaoo, t);
        }

        public T zzb(zzaom com_google_android_gms_internal_zzaom) {
            if (this.f11157a != null) {
                return this.f11157a.zzb(com_google_android_gms_internal_zzaom);
            }
            throw new IllegalStateException();
        }
    }

    public zzamp() {
        this(zzanq.beK, zzamn.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, zzanf.DEFAULT, Collections.emptyList());
    }

    zzamp(zzanq com_google_android_gms_internal_zzanq, zzamo com_google_android_gms_internal_zzamo, Map<Type, zzamr<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzanf com_google_android_gms_internal_zzanf, List<zzani> list) {
        this.f11160c = new ThreadLocal();
        this.f11161d = Collections.synchronizedMap(new HashMap());
        this.f11158a = new C32631(this);
        this.f11159b = new C32642(this);
        this.f11163f = new zzanp(map);
        this.f11164g = z;
        this.f11166i = z3;
        this.f11165h = z4;
        this.f11167j = z5;
        List arrayList = new ArrayList();
        arrayList.add(zzaok.bgN);
        arrayList.add(zzaof.bfu);
        arrayList.add(com_google_android_gms_internal_zzanq);
        arrayList.addAll(list);
        arrayList.add(zzaok.bgu);
        arrayList.add(zzaok.bgj);
        arrayList.add(zzaok.bgd);
        arrayList.add(zzaok.bgf);
        arrayList.add(zzaok.bgh);
        arrayList.add(zzaok.zza(Long.TYPE, Long.class, m17183a(com_google_android_gms_internal_zzanf)));
        arrayList.add(zzaok.zza(Double.TYPE, Double.class, m17184a(z6)));
        arrayList.add(zzaok.zza(Float.TYPE, Float.class, m17188b(z6)));
        arrayList.add(zzaok.bgo);
        arrayList.add(zzaok.bgq);
        arrayList.add(zzaok.bgw);
        arrayList.add(zzaok.bgy);
        arrayList.add(zzaok.zza(BigDecimal.class, zzaok.bgs));
        arrayList.add(zzaok.zza(BigInteger.class, zzaok.bgt));
        arrayList.add(zzaok.bgA);
        arrayList.add(zzaok.bgC);
        arrayList.add(zzaok.bgG);
        arrayList.add(zzaok.bgL);
        arrayList.add(zzaok.bgE);
        arrayList.add(zzaok.bga);
        arrayList.add(zzaoa.bfu);
        arrayList.add(zzaok.bgJ);
        arrayList.add(zzaoi.bfu);
        arrayList.add(zzaoh.bfu);
        arrayList.add(zzaok.bgH);
        arrayList.add(zzany.bfu);
        arrayList.add(zzaok.bfY);
        arrayList.add(new zzanz(this.f11163f));
        arrayList.add(new zzaoe(this.f11163f, z2));
        arrayList.add(new zzaob(this.f11163f));
        arrayList.add(zzaok.bgO);
        arrayList.add(new zzaog(this.f11163f, com_google_android_gms_internal_zzamo, com_google_android_gms_internal_zzanq));
        this.f11162e = Collections.unmodifiableList(arrayList);
    }

    private zzanh<Number> m17183a(zzanf com_google_android_gms_internal_zzanf) {
        return com_google_android_gms_internal_zzanf == zzanf.DEFAULT ? zzaok.bgk : new C32675(this);
    }

    private zzanh<Number> m17184a(boolean z) {
        return z ? zzaok.bgm : new C32653(this);
    }

    private void m17185a(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(d + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void m17187a(Object obj, zzaom com_google_android_gms_internal_zzaom) {
        if (obj != null) {
            try {
                if (com_google_android_gms_internal_zzaom.mo1835b() != zzaon.END_DOCUMENT) {
                    throw new zzamw("JSON document was not fully consumed.");
                }
            } catch (Throwable e) {
                throw new zzane(e);
            } catch (Throwable e2) {
                throw new zzamw(e2);
            }
        }
    }

    private zzanh<Number> m17188b(boolean z) {
        return z ? zzaok.bgl : new C32664(this);
    }

    public String toString() {
        return "{serializeNulls:" + this.f11164g + "factories:" + this.f11162e + ",instanceCreators:" + this.f11163f + "}";
    }

    public <T> zzanh<T> zza(zzani com_google_android_gms_internal_zzani, zzaol<T> com_google_android_gms_internal_zzaol_T) {
        Object obj = null;
        if (!this.f11162e.contains(com_google_android_gms_internal_zzani)) {
            obj = 1;
        }
        Object obj2 = obj;
        for (zzani com_google_android_gms_internal_zzani2 : this.f11162e) {
            if (obj2 != null) {
                zzanh<T> zza = com_google_android_gms_internal_zzani2.zza(this, com_google_android_gms_internal_zzaol_T);
                if (zza != null) {
                    return zza;
                }
            } else if (com_google_android_gms_internal_zzani2 == com_google_android_gms_internal_zzani) {
                obj2 = 1;
            }
        }
        String valueOf = String.valueOf(com_google_android_gms_internal_zzaol_T);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("GSON cannot serialize ").append(valueOf).toString());
    }

    public <T> zzanh<T> zza(zzaol<T> com_google_android_gms_internal_zzaol_T) {
        zzanh<T> com_google_android_gms_internal_zzanh_T = (zzanh) this.f11161d.get(com_google_android_gms_internal_zzaol_T);
        if (com_google_android_gms_internal_zzanh_T == null) {
            Map map;
            Map map2 = (Map) this.f11160c.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.f11160c.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            zza com_google_android_gms_internal_zzamp_zza = (zza) map.get(com_google_android_gms_internal_zzaol_T);
            if (com_google_android_gms_internal_zzamp_zza == null) {
                try {
                    zza com_google_android_gms_internal_zzamp_zza2 = new zza();
                    map.put(com_google_android_gms_internal_zzaol_T, com_google_android_gms_internal_zzamp_zza2);
                    for (zzani zza : this.f11162e) {
                        com_google_android_gms_internal_zzanh_T = zza.zza(this, com_google_android_gms_internal_zzaol_T);
                        if (com_google_android_gms_internal_zzanh_T != null) {
                            com_google_android_gms_internal_zzamp_zza2.zza(com_google_android_gms_internal_zzanh_T);
                            this.f11161d.put(com_google_android_gms_internal_zzaol_T, com_google_android_gms_internal_zzanh_T);
                            map.remove(com_google_android_gms_internal_zzaol_T);
                            if (obj != null) {
                                this.f11160c.remove();
                            }
                        }
                    }
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzaol_T);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("GSON cannot handle ").append(valueOf).toString());
                } catch (Throwable th) {
                    map.remove(com_google_android_gms_internal_zzaol_T);
                    if (obj != null) {
                        this.f11160c.remove();
                    }
                }
            }
        }
        return com_google_android_gms_internal_zzanh_T;
    }

    public zzaoo zza(Writer writer) {
        if (this.f11166i) {
            writer.write(")]}'\n");
        }
        zzaoo com_google_android_gms_internal_zzaoo = new zzaoo(writer);
        if (this.f11167j) {
            com_google_android_gms_internal_zzaoo.setIndent("  ");
        }
        com_google_android_gms_internal_zzaoo.zzdd(this.f11164g);
        return com_google_android_gms_internal_zzaoo;
    }

    public <T> T zza(zzamv com_google_android_gms_internal_zzamv, Class<T> cls) {
        return zzanv.zzp(cls).cast(zza(com_google_android_gms_internal_zzamv, (Type) cls));
    }

    public <T> T zza(zzamv com_google_android_gms_internal_zzamv, Type type) {
        return com_google_android_gms_internal_zzamv == null ? null : zza(new zzaoc(com_google_android_gms_internal_zzamv), type);
    }

    public <T> T zza(zzaom com_google_android_gms_internal_zzaom, Type type) {
        boolean z = true;
        boolean isLenient = com_google_android_gms_internal_zzaom.isLenient();
        com_google_android_gms_internal_zzaom.setLenient(true);
        try {
            com_google_android_gms_internal_zzaom.mo1835b();
            z = false;
            T zzb = zza(zzaol.zzl(type)).zzb(com_google_android_gms_internal_zzaom);
            com_google_android_gms_internal_zzaom.setLenient(isLenient);
            return zzb;
        } catch (Throwable e) {
            if (z) {
                com_google_android_gms_internal_zzaom.setLenient(isLenient);
                return null;
            }
            throw new zzane(e);
        } catch (Throwable e2) {
            throw new zzane(e2);
        } catch (Throwable e22) {
            throw new zzane(e22);
        } catch (Throwable th) {
            com_google_android_gms_internal_zzaom.setLenient(isLenient);
        }
    }

    public <T> T zza(Reader reader, Type type) {
        zzaom com_google_android_gms_internal_zzaom = new zzaom(reader);
        Object zza = zza(com_google_android_gms_internal_zzaom, type);
        m17187a(zza, com_google_android_gms_internal_zzaom);
        return zza;
    }

    public <T> T zza(String str, Type type) {
        return str == null ? null : zza(new StringReader(str), type);
    }

    public void zza(zzamv com_google_android_gms_internal_zzamv, zzaoo com_google_android_gms_internal_zzaoo) {
        boolean isLenient = com_google_android_gms_internal_zzaoo.isLenient();
        com_google_android_gms_internal_zzaoo.setLenient(true);
        boolean x = com_google_android_gms_internal_zzaoo.m17277x();
        com_google_android_gms_internal_zzaoo.zzdc(this.f11165h);
        boolean y = com_google_android_gms_internal_zzaoo.m17278y();
        com_google_android_gms_internal_zzaoo.zzdd(this.f11164g);
        try {
            zzanw.zzb(com_google_android_gms_internal_zzamv, com_google_android_gms_internal_zzaoo);
            com_google_android_gms_internal_zzaoo.setLenient(isLenient);
            com_google_android_gms_internal_zzaoo.zzdc(x);
            com_google_android_gms_internal_zzaoo.zzdd(y);
        } catch (Throwable e) {
            throw new zzamw(e);
        } catch (Throwable th) {
            com_google_android_gms_internal_zzaoo.setLenient(isLenient);
            com_google_android_gms_internal_zzaoo.zzdc(x);
            com_google_android_gms_internal_zzaoo.zzdd(y);
        }
    }

    public void zza(zzamv com_google_android_gms_internal_zzamv, Appendable appendable) {
        try {
            zza(com_google_android_gms_internal_zzamv, zza(zzanw.zza(appendable)));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(Object obj, Type type, zzaoo com_google_android_gms_internal_zzaoo) {
        zzanh zza = zza(zzaol.zzl(type));
        boolean isLenient = com_google_android_gms_internal_zzaoo.isLenient();
        com_google_android_gms_internal_zzaoo.setLenient(true);
        boolean x = com_google_android_gms_internal_zzaoo.m17277x();
        com_google_android_gms_internal_zzaoo.zzdc(this.f11165h);
        boolean y = com_google_android_gms_internal_zzaoo.m17278y();
        com_google_android_gms_internal_zzaoo.zzdd(this.f11164g);
        try {
            zza.zza(com_google_android_gms_internal_zzaoo, obj);
            com_google_android_gms_internal_zzaoo.setLenient(isLenient);
            com_google_android_gms_internal_zzaoo.zzdc(x);
            com_google_android_gms_internal_zzaoo.zzdd(y);
        } catch (Throwable e) {
            throw new zzamw(e);
        } catch (Throwable th) {
            com_google_android_gms_internal_zzaoo.setLenient(isLenient);
            com_google_android_gms_internal_zzaoo.zzdc(x);
            com_google_android_gms_internal_zzaoo.zzdd(y);
        }
    }

    public void zza(Object obj, Type type, Appendable appendable) {
        try {
            zza(obj, type, zza(zzanw.zza(appendable)));
        } catch (Throwable e) {
            throw new zzamw(e);
        }
    }

    public String zzb(zzamv com_google_android_gms_internal_zzamv) {
        Appendable stringWriter = new StringWriter();
        zza(com_google_android_gms_internal_zzamv, stringWriter);
        return stringWriter.toString();
    }

    public String zzc(Object obj, Type type) {
        Appendable stringWriter = new StringWriter();
        zza(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String zzch(Object obj) {
        return obj == null ? zzb(zzamx.bei) : zzc(obj, obj.getClass());
    }

    public <T> T zzf(String str, Class<T> cls) {
        return zzanv.zzp(cls).cast(zza(str, (Type) cls));
    }

    public <T> zzanh<T> zzk(Class<T> cls) {
        return zza(zzaol.zzr(cls));
    }
}
