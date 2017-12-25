package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzi extends zzal {
    private static final String f12765a = zzaf.APP_VERSION_NAME.toString();
    private final Context f12766b;

    public zzi(Context context) {
        super(f12765a, new String[0]);
        this.f12766b = context;
    }

    public zza zzav(Map<String, zza> map) {
        try {
            return zzdl.zzap(this.f12766b.getPackageManager().getPackageInfo(this.f12766b.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(this.f12766b.getPackageName());
            String valueOf2 = String.valueOf(e.getMessage());
            zzbn.m18105e(new StringBuilder((String.valueOf(valueOf).length() + 25) + String.valueOf(valueOf2).length()).append("Package name ").append(valueOf).append(" not found. ").append(valueOf2).toString());
            return zzdl.zzcdu();
        }
    }

    public boolean zzcag() {
        return true;
    }
}
