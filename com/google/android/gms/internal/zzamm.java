package com.google.android.gms.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public final class zzamm {
    private final Field f11150a;

    public zzamm(Field field) {
        zzann.zzy(field);
        this.f11150a = field;
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.f11150a.getAnnotation(cls);
    }
}
