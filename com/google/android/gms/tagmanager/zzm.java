package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzm<K, V> {
    final zza<K, V> f12777a = new C34471(this);

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    class C34471 implements zza<K, V> {
        final /* synthetic */ zzm f12776a;

        C34471(zzm com_google_android_gms_tagmanager_zzm) {
            this.f12776a = com_google_android_gms_tagmanager_zzm;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    int m18225a() {
        return VERSION.SDK_INT;
    }

    public zzl<K, V> zza(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        if (i > 0) {
            return m18225a() < 12 ? new zzdd(i, com_google_android_gms_tagmanager_zzm_zza_K__V) : new zzbh(i, com_google_android_gms_tagmanager_zzm_zza_K__V);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }
}
