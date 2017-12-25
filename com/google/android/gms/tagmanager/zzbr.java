package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzbr extends zzal {
    private static final String f12586a = zzaf.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context f12587b;

    public zzbr(Context context) {
        super(f12586a, new String[0]);
        this.f12587b = context;
    }

    protected String m18109a(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public zza zzav(Map<String, zza> map) {
        String a = m18109a(this.f12587b);
        return a == null ? zzdl.zzcdu() : zzdl.zzap(a);
    }

    public boolean zzcag() {
        return true;
    }
}
