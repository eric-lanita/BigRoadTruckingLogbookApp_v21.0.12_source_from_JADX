package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;

public final class C3588e {
    static boolean m18772a(Collection<?> collection, Object obj) {
        boolean z = false;
        Preconditions.checkNotNull(collection);
        try {
            z = collection.contains(obj);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static StringBuilder m18770a(int i) {
        C3587d.m18767a(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    static <T> Collection<T> m18771a(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
