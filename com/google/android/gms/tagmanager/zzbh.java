package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm.zza;

@TargetApi(12)
class zzbh<K, V> implements zzl<K, V> {
    private LruCache<K, V> f12569a;

    zzbh(int i, final zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        this.f12569a = new LruCache<K, V>(this, i) {
            final /* synthetic */ zzbh f12568b;

            protected int sizeOf(K k, V v) {
                return com_google_android_gms_tagmanager_zzm_zza_K__V.sizeOf(k, v);
            }
        };
    }

    public V get(K k) {
        return this.f12569a.get(k);
    }

    public void zzi(K k, V v) {
        this.f12569a.put(k, v);
    }
}
