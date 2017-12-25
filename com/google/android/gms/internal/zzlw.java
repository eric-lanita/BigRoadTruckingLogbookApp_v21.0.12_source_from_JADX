package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzlw extends zzg<zzlw> {
    private Map<Integer, String> f11427a = new HashMap(4);

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f11427a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(valueOf).length() + 9).append("dimension").append(valueOf).toString(), entry.getValue());
        }
        return zzg.zzj(hashMap);
    }

    public void zza(zzlw com_google_android_gms_internal_zzlw) {
        com_google_android_gms_internal_zzlw.f11427a.putAll(this.f11427a);
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzlw) com_google_android_gms_analytics_zzg);
    }

    public Map<Integer, String> zzxk() {
        return Collections.unmodifiableMap(this.f11427a);
    }
}
