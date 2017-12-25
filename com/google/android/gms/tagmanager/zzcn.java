package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzcn extends zzal {
    private static final String f12627a = zzaf.RESOLUTION.toString();
    private final Context f12628b;

    public zzcn(Context context) {
        super(f12627a, new String[0]);
        this.f12628b = context;
    }

    public zza zzav(Map<String, zza> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f12628b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return zzdl.zzap(i + "x" + displayMetrics.heightPixels);
    }

    public boolean zzcag() {
        return true;
    }
}
