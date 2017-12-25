package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzae;

public final class zzc {
    private static String m16741a(String str, int i) {
        if (i >= 1) {
            return new StringBuilder(String.valueOf(str).length() + 11).append(str).append(i).toString();
        }
        zzae.zzf("index out of range for prefix", str);
        return "";
    }

    public static String zzbc(int i) {
        return m16741a("&cd", i);
    }

    public static String zzbd(int i) {
        return m16741a("cd", i);
    }

    public static String zzbe(int i) {
        return m16741a("&cm", i);
    }

    public static String zzbf(int i) {
        return m16741a("cm", i);
    }

    public static String zzbg(int i) {
        return m16741a("&pr", i);
    }

    public static String zzbh(int i) {
        return m16741a("pr", i);
    }

    public static String zzbi(int i) {
        return m16741a("&promo", i);
    }

    public static String zzbj(int i) {
        return m16741a("promo", i);
    }

    public static String zzbk(int i) {
        return m16741a("pi", i);
    }

    public static String zzbl(int i) {
        return m16741a("&il", i);
    }

    public static String zzbm(int i) {
        return m16741a("il", i);
    }

    public static String zzbn(int i) {
        return m16741a("cd", i);
    }

    public static String zzbo(int i) {
        return m16741a("cm", i);
    }
}
