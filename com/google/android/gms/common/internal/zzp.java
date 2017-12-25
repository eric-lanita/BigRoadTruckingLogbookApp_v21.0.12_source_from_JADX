package com.google.android.gms.common.internal;

import android.util.Log;

public final class zzp {
    private static final String f10796a = null;
    public static final int za = (23 - " PII_LOG".length());
    private final String f10797b;
    private final String f10798c;

    public zzp(String str) {
        this(str, null);
    }

    public zzp(String str, String str2) {
        zzab.zzb((Object) str, (Object) "log tag cannot be null");
        zzab.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.f10797b = str;
        if (str2 == null || str2.length() <= 0) {
            this.f10798c = null;
        } else {
            this.f10798c = str2;
        }
    }

    private String m16945a(String str) {
        return this.f10798c == null ? str : this.f10798c.concat(str);
    }

    public void zzae(String str, String str2) {
        if (zzgg(3)) {
            Log.d(str, m16945a(str2));
        }
    }

    public void zzaf(String str, String str2) {
        if (zzgg(5)) {
            Log.w(str, m16945a(str2));
        }
    }

    public void zzag(String str, String str2) {
        if (zzgg(6)) {
            Log.e(str, m16945a(str2));
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzgg(4)) {
            Log.i(str, m16945a(str2), th);
        }
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzgg(5)) {
            Log.w(str, m16945a(str2), th);
        }
    }

    public void zzd(String str, String str2, Throwable th) {
        if (zzgg(6)) {
            Log.e(str, m16945a(str2), th);
        }
    }

    public void zze(String str, String str2, Throwable th) {
        if (zzgg(7)) {
            Log.e(str, m16945a(str2), th);
            Log.wtf(str, m16945a(str2), th);
        }
    }

    public boolean zzgg(int i) {
        return Log.isLoggable(this.f10797b, i);
    }
}
