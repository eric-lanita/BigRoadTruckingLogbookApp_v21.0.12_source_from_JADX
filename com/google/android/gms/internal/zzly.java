package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzab;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzly extends zzg<zzly> {
    private final Map<String, Object> f11429a = new HashMap();

    private String m17356a(String str) {
        zzab.zzhr(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        zzab.zzh(str, "Name can not be empty or \"&\"");
        return str;
    }

    public void set(String str, String str2) {
        this.f11429a.put(m17356a(str), str2);
    }

    public String toString() {
        return zzg.zzj(this.f11429a);
    }

    public void zza(zzly com_google_android_gms_internal_zzly) {
        zzab.zzy(com_google_android_gms_internal_zzly);
        com_google_android_gms_internal_zzly.f11429a.putAll(this.f11429a);
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzly) com_google_android_gms_analytics_zzg);
    }

    public Map<String, Object> zzxm() {
        return Collections.unmodifiableMap(this.f11429a);
    }
}
