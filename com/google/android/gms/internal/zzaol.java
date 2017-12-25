package com.google.android.gms.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class zzaol<T> {
    final Class<? super T> f11343a;
    final Type f11344b;
    final int f11345c;

    protected zzaol() {
        this.f11344b = m17302a(getClass());
        this.f11343a = zzano.zzf(this.f11344b);
        this.f11345c = this.f11344b.hashCode();
    }

    zzaol(Type type) {
        this.f11344b = zzano.zze((Type) zzann.zzy(type));
        this.f11343a = zzano.zzf(this.f11344b);
        this.f11345c = this.f11344b.hashCode();
    }

    static Type m17302a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return zzano.zze(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public static zzaol<?> zzl(Type type) {
        return new zzaol(type);
    }

    public static <T> zzaol<T> zzr(Class<T> cls) {
        return new zzaol(cls);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzaol) && zzano.zza(this.f11344b, ((zzaol) obj).f11344b);
    }

    public final int hashCode() {
        return this.f11345c;
    }

    public final Class<? super T> m17303m() {
        return this.f11343a;
    }

    public final Type m17304n() {
        return this.f11344b;
    }

    public final String toString() {
        return zzano.zzg(this.f11344b);
    }
}
