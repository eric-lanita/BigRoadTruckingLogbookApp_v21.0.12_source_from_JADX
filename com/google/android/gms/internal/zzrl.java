package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzp;

public class zzrl {
    private final String f11727a;
    private final String f11728b;
    private final zzp f11729c;
    private final int f11730d;

    private zzrl(String str, String str2) {
        this.f11728b = str2;
        this.f11727a = str;
        this.f11729c = new zzp(str);
        this.f11730d = m17552a();
    }

    public zzrl(String str, String... strArr) {
        this(str, m17553a(strArr));
    }

    private int m17552a() {
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.f11727a, i)) {
            i++;
        }
        return i;
    }

    private static String m17553a(String... strArr) {
        if (strArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (String str : strArr) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(",");
            }
            stringBuilder.append(str);
        }
        stringBuilder.append(']').append(' ');
        return stringBuilder.toString();
    }

    protected String m17554a(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(str, objArr);
        }
        return this.f11728b.concat(str);
    }

    public void zza(String str, Object... objArr) {
        if (zzaz(2)) {
            Log.v(this.f11727a, m17554a(str, objArr));
        }
    }

    public boolean zzaz(int i) {
        return this.f11730d <= i;
    }
}
