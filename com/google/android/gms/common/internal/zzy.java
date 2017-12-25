package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzy {
    private final String f10807a;

    private zzy(String str) {
        this.f10807a = str;
    }

    public static zzy zzhq(String str) {
        return new zzy(str);
    }

    CharSequence m16946a(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final String zza(Iterable<?> iterable) {
        return zza(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder zza(StringBuilder stringBuilder, Iterable<?> iterable) {
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            stringBuilder.append(m16946a(it.next()));
            while (it.hasNext()) {
                stringBuilder.append(this.f10807a);
                stringBuilder.append(m16946a(it.next()));
            }
        }
        return stringBuilder;
    }
}
