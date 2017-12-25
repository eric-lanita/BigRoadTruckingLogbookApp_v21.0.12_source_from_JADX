package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzg extends zzal {
    private static final String f12761a = zzaf.APP_NAME.toString();
    private final Context f12762b;

    public zzg(Context context) {
        super(f12761a, new String[0]);
        this.f12762b = context;
    }

    public zza zzav(Map<String, zza> map) {
        try {
            PackageManager packageManager = this.f12762b.getPackageManager();
            return zzdl.zzap(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f12762b.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            zzbn.zzb("App name is not found.", e);
            return zzdl.zzcdu();
        }
    }

    public boolean zzcag() {
        return true;
    }
}
