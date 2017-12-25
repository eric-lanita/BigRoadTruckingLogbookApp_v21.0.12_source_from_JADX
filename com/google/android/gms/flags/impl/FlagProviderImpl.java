package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza.zzb;
import com.google.android.gms.flags.impl.zza.zzc;
import com.google.android.gms.flags.impl.zza.zzd;
import com.google.android.gms.internal.zzty.zza;

@DynamiteApi
public class FlagProviderImpl extends zza {
    private boolean f10952a = false;
    private SharedPreferences f10953b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f10952a ? z : zza.zza.zza(this.f10953b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f10952a ? i : zzb.zza(this.f10953b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.f10952a ? j : zzc.zza(this.f10953b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f10952a ? str2 : zzd.zza(this.f10953b, str, str2);
    }

    public void init(com.google.android.gms.dynamic.zzd com_google_android_gms_dynamic_zzd) {
        Context context = (Context) zze.zzad(com_google_android_gms_dynamic_zzd);
        if (!this.f10952a) {
            try {
                this.f10953b = zzb.zzn(context.createPackageContext("com.google.android.gms", 0));
                this.f10952a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
