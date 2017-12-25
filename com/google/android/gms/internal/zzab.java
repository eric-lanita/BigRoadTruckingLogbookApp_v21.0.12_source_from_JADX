package com.google.android.gms.internal;

import com.google.android.gms.internal.zzm.zza;
import com.google.android.gms.internal.zzm.zzb;
import java.io.UnsupportedEncodingException;

public class zzab extends zzk<String> {
    private final zzb<String> f11084a;

    public zzab(int i, String str, zzb<String> com_google_android_gms_internal_zzm_zzb_java_lang_String, zza com_google_android_gms_internal_zzm_zza) {
        super(i, str, com_google_android_gms_internal_zzm_zza);
        this.f11084a = com_google_android_gms_internal_zzm_zzb_java_lang_String;
    }

    protected zzm<String> mo1810a(zzi com_google_android_gms_internal_zzi) {
        Object str;
        try {
            str = new String(com_google_android_gms_internal_zzi.data, zzx.zza(com_google_android_gms_internal_zzi.zzz));
        } catch (UnsupportedEncodingException e) {
            str = new String(com_google_android_gms_internal_zzi.data);
        }
        return zzm.zza(str, zzx.zzb(com_google_android_gms_internal_zzi));
    }

    protected /* synthetic */ void mo1811a(Object obj) {
        mo1812a((String) obj);
    }

    protected void mo1812a(String str) {
        this.f11084a.zzb(str);
    }
}
