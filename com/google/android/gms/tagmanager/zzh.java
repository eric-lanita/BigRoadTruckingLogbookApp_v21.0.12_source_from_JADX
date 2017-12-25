package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzh extends zzal {
    private static final String f12763a = zzaf.APP_VERSION.toString();
    private final Context f12764b;

    public zzh(Context context) {
        super(f12763a, new String[0]);
        this.f12764b = context;
    }

    public zza zzav(Map<String, zza> map) {
        try {
            return zzdl.zzap(Integer.valueOf(this.f12764b.getPackageManager().getPackageInfo(this.f12764b.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(this.f12764b.getPackageName());
            String valueOf2 = String.valueOf(e.getMessage());
            zzbn.m18105e(new StringBuilder((String.valueOf(valueOf).length() + 25) + String.valueOf(valueOf2).length()).append("Package name ").append(valueOf).append(" not found. ").append(valueOf2).toString());
            return zzdl.zzcdu();
        }
    }

    public boolean zzcag() {
        return true;
    }
}
