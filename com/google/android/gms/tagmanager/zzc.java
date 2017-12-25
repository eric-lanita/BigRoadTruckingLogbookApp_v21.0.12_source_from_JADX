package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzc extends zzal {
    private static final String f12591a = zzaf.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza f12592b;

    public zzc(Context context) {
        this(zza.zzdu(context));
    }

    zzc(zza com_google_android_gms_tagmanager_zza) {
        super(f12591a, new String[0]);
        this.f12592b = com_google_android_gms_tagmanager_zza;
    }

    public zza zzav(Map<String, zza> map) {
        return zzdl.zzap(Boolean.valueOf(!this.f12592b.isLimitAdTrackingEnabled()));
    }

    public boolean zzcag() {
        return false;
    }
}
