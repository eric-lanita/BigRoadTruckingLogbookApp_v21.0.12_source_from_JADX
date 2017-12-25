package com.google.android.gms.common.util;

import android.support.v4.p008d.C0270a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzf {
    private static <K, V> void m17003a(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + vArr.length);
        }
    }

    public static <K, V> Map<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map c0270a = new C0270a(6);
        c0270a.put(k, v);
        c0270a.put(k2, v2);
        c0270a.put(k3, v3);
        c0270a.put(k4, v4);
        c0270a.put(k5, v5);
        c0270a.put(k6, v6);
        return Collections.unmodifiableMap(c0270a);
    }

    public static <T> Set<T> zza(T t, T t2, T t3) {
        Set com_google_android_gms_common_util_zza = new zza(3);
        com_google_android_gms_common_util_zza.add(t);
        com_google_android_gms_common_util_zza.add(t2);
        com_google_android_gms_common_util_zza.add(t3);
        return Collections.unmodifiableSet(com_google_android_gms_common_util_zza);
    }

    public static <T> Set<T> zza(T t, T t2, T t3, T t4) {
        Set com_google_android_gms_common_util_zza = new zza(4);
        com_google_android_gms_common_util_zza.add(t);
        com_google_android_gms_common_util_zza.add(t2);
        com_google_android_gms_common_util_zza.add(t3);
        com_google_android_gms_common_util_zza.add(t4);
        return Collections.unmodifiableSet(com_google_android_gms_common_util_zza);
    }

    public static <T> Set<T> zzaa(T t) {
        return Collections.singleton(t);
    }

    public static <T> Set<T> zzavk() {
        return Collections.emptySet();
    }

    public static <K, V> Map<K, V> zzavl() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> zzb(K[] kArr, V[] vArr) {
        int i = 0;
        m17003a(kArr, vArr);
        int length = kArr.length;
        switch (length) {
            case 0:
                return zzavl();
            case 1:
                return zze(kArr[0], vArr[0]);
            default:
                Map c0270a = length <= 32 ? new C0270a(length) : new HashMap(length, 1.0f);
                while (i < length) {
                    c0270a.put(kArr[i], vArr[i]);
                    i++;
                }
                return Collections.unmodifiableMap(c0270a);
        }
    }

    public static <T> List<T> zzc(T t, T t2) {
        List arrayList = new ArrayList(2);
        arrayList.add(t);
        arrayList.add(t2);
        return Collections.unmodifiableList(arrayList);
    }

    public static <T> Set<T> zzc(T... tArr) {
        switch (tArr.length) {
            case 0:
                return zzavk();
            case 1:
                return zzaa(tArr[0]);
            case 2:
                return zzd(tArr[0], tArr[1]);
            case 3:
                return zza(tArr[0], tArr[1], tArr[2]);
            case 4:
                return zza(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new zza(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }

    public static <T> Set<T> zzd(T t, T t2) {
        Set com_google_android_gms_common_util_zza = new zza(2);
        com_google_android_gms_common_util_zza.add(t);
        com_google_android_gms_common_util_zza.add(t2);
        return Collections.unmodifiableSet(com_google_android_gms_common_util_zza);
    }

    public static <K, V> Map<K, V> zze(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <T> List<T> zzz(T t) {
        return Collections.singletonList(t);
    }
}
