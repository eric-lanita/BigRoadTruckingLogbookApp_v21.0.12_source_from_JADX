package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzaq extends zzal {
    private static final String f12535a = zzaf.HASH.toString();
    private static final String f12536b = zzag.ARG0.toString();
    private static final String f12537c = zzag.ALGORITHM.toString();
    private static final String f12538d = zzag.INPUT_FORMAT.toString();

    public zzaq() {
        super(f12535a, f12536b);
    }

    private byte[] m18086a(String str, byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public zza zzav(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(f12536b);
        if (com_google_android_gms_internal_zzai_zza == null || com_google_android_gms_internal_zzai_zza == zzdl.zzcdu()) {
            return zzdl.zzcdu();
        }
        byte[] bytes;
        String zzg = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        com_google_android_gms_internal_zzai_zza = (zza) map.get(f12537c);
        String zzg2 = com_google_android_gms_internal_zzai_zza == null ? "MD5" : zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        com_google_android_gms_internal_zzai_zza = (zza) map.get(f12538d);
        Object zzg3 = com_google_android_gms_internal_zzai_zza == null ? "text" : zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        if ("text".equals(zzg3)) {
            bytes = zzg.getBytes();
        } else if ("base16".equals(zzg3)) {
            bytes = zzk.zzod(zzg);
        } else {
            zzg2 = "Hash: unknown input format: ";
            String valueOf = String.valueOf(zzg3);
            zzbn.m18105e(valueOf.length() != 0 ? zzg2.concat(valueOf) : new String(zzg2));
            return zzdl.zzcdu();
        }
        try {
            return zzdl.zzap(zzk.zzp(m18086a(zzg2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            zzg = "Hash: unknown algorithm: ";
            valueOf = String.valueOf(zzg2);
            zzbn.m18105e(valueOf.length() != 0 ? zzg.concat(valueOf) : new String(zzg));
            return zzdl.zzcdu();
        }
    }

    public boolean zzcag() {
        return true;
    }
}
