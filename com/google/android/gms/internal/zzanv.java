package com.google.android.gms.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzanv {
    private static final Map<Class<?>, Class<?>> f11245a;
    private static final Map<Class<?>, Class<?>> f11246b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        m17228a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        m17228a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        m17228a(hashMap, hashMap2, Character.TYPE, Character.class);
        m17228a(hashMap, hashMap2, Double.TYPE, Double.class);
        m17228a(hashMap, hashMap2, Float.TYPE, Float.class);
        m17228a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        m17228a(hashMap, hashMap2, Long.TYPE, Long.class);
        m17228a(hashMap, hashMap2, Short.TYPE, Short.class);
        m17228a(hashMap, hashMap2, Void.TYPE, Void.class);
        f11245a = Collections.unmodifiableMap(hashMap);
        f11246b = Collections.unmodifiableMap(hashMap2);
    }

    private static void m17228a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static boolean zzk(Type type) {
        return f11245a.containsKey(type);
    }

    public static <T> Class<T> zzp(Class<T> cls) {
        Class<T> cls2 = (Class) f11245a.get(zzann.zzy(cls));
        return cls2 == null ? cls : cls2;
    }
}
