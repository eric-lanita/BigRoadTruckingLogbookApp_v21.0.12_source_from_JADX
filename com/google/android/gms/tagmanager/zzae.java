package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzae extends zzal {
    private static final String f12521a = zzaf.ENCODE.toString();
    private static final String f12522b = zzag.ARG0.toString();
    private static final String f12523c = zzag.NO_PADDING.toString();
    private static final String f12524d = zzag.INPUT_FORMAT.toString();
    private static final String f12525e = zzag.OUTPUT_FORMAT.toString();

    public zzae() {
        super(f12521a, f12522b);
    }

    public zza zzav(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(f12522b);
        if (com_google_android_gms_internal_zzai_zza == null || com_google_android_gms_internal_zzai_zza == zzdl.zzcdu()) {
            return zzdl.zzcdu();
        }
        String zzg = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        com_google_android_gms_internal_zzai_zza = (zza) map.get(f12524d);
        if (com_google_android_gms_internal_zzai_zza == null) {
            Object obj = "text";
        } else {
            String zzg2 = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        }
        com_google_android_gms_internal_zzai_zza = (zza) map.get(f12525e);
        if (com_google_android_gms_internal_zzai_zza == null) {
            Object obj2 = "base16";
        } else {
            String zzg3 = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        }
        com_google_android_gms_internal_zzai_zza = (zza) map.get(f12523c);
        int i = (com_google_android_gms_internal_zzai_zza == null || !zzdl.zzk(com_google_android_gms_internal_zzai_zza).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            String valueOf;
            Object zzp;
            if ("text".equals(obj)) {
                bytes = zzg.getBytes();
            } else if ("base16".equals(obj)) {
                bytes = zzk.zzod(zzg);
            } else if ("base64".equals(obj)) {
                bytes = Base64.decode(zzg, i);
            } else if ("base64url".equals(obj)) {
                bytes = Base64.decode(zzg, i | 8);
            } else {
                zzg3 = "Encode: unknown input format: ";
                valueOf = String.valueOf(obj);
                zzbn.m18105e(valueOf.length() != 0 ? zzg3.concat(valueOf) : new String(zzg3));
                return zzdl.zzcdu();
            }
            if ("base16".equals(obj2)) {
                zzp = zzk.zzp(bytes);
            } else if ("base64".equals(obj2)) {
                zzp = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(obj2)) {
                zzp = Base64.encodeToString(bytes, i | 8);
            } else {
                zzg2 = "Encode: unknown output format: ";
                valueOf = String.valueOf(obj2);
                zzbn.m18105e(valueOf.length() != 0 ? zzg2.concat(valueOf) : new String(zzg2));
                return zzdl.zzcdu();
            }
            return zzdl.zzap(zzp);
        } catch (IllegalArgumentException e) {
            zzbn.m18105e("Encode: invalid input:");
            return zzdl.zzcdu();
        }
    }

    public boolean zzcag() {
        return true;
    }
}
