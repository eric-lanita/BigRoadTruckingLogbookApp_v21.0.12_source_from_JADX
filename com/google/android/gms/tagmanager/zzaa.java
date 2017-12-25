package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzaa extends zzal {
    private static final String f12518a = zzaf.DEVICE_ID.toString();
    private final Context f12519b;

    public zzaa(Context context) {
        super(f12518a, new String[0]);
        this.f12519b = context;
    }

    protected String m18071a(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public zza zzav(Map<String, zza> map) {
        String a = m18071a(this.f12519b);
        return a == null ? zzdl.zzcdu() : zzdl.zzap(a);
    }

    public boolean zzcag() {
        return true;
    }
}
