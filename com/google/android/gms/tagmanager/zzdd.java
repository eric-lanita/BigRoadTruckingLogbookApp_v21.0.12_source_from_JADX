package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzm.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class zzdd<K, V> implements zzl<K, V> {
    private final Map<K, V> f12713a = new HashMap();
    private final int f12714b;
    private final zza<K, V> f12715c;
    private int f12716d;

    zzdd(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        this.f12714b = i;
        this.f12715c = com_google_android_gms_tagmanager_zzm_zza_K__V;
    }

    public synchronized V get(K k) {
        return this.f12713a.get(k);
    }

    public synchronized void zzi(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.f12716d += this.f12715c.sizeOf(k, v);
        if (this.f12716d > this.f12714b) {
            Iterator it = this.f12713a.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.f12716d -= this.f12715c.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.f12716d <= this.f12714b) {
                    break;
                }
            }
        }
        this.f12713a.put(k, v);
    }
}
