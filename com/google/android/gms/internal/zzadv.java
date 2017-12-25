package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.util.HashMap;
import java.util.Map;

public class zzadv {
    Map<String, Object> f11087a;
    private final Context f11088b;
    private final zzadx f11089c;
    private final zze f11090d;
    private String f11091e;
    private final Map<String, Object> f11092f;

    public zzadv(Context context) {
        this(context, new HashMap(), new zzadx(context), zzh.zzavm());
    }

    zzadv(Context context, Map<String, Object> map, zzadx com_google_android_gms_internal_zzadx, zze com_google_android_gms_common_util_zze) {
        this.f11091e = null;
        this.f11087a = new HashMap();
        this.f11088b = context;
        this.f11090d = com_google_android_gms_common_util_zze;
        this.f11089c = com_google_android_gms_internal_zzadx;
        this.f11092f = map;
    }

    public void zzqi(String str) {
        this.f11091e = str;
    }
}
