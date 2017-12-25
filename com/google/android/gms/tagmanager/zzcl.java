package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcl extends zzal {
    private static final String f12620a = zzaf.REGEX_GROUP.toString();
    private static final String f12621b = zzag.ARG0.toString();
    private static final String f12622c = zzag.ARG1.toString();
    private static final String f12623d = zzag.IGNORE_CASE.toString();
    private static final String f12624e = zzag.GROUP.toString();

    public zzcl() {
        super(f12620a, f12621b, f12622c);
    }

    public zza zzav(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(f12621b);
        zza com_google_android_gms_internal_zzai_zza2 = (zza) map.get(f12622c);
        if (com_google_android_gms_internal_zzai_zza == null || com_google_android_gms_internal_zzai_zza == zzdl.zzcdu() || com_google_android_gms_internal_zzai_zza2 == null || com_google_android_gms_internal_zzai_zza2 == zzdl.zzcdu()) {
            return zzdl.zzcdu();
        }
        int i = 64;
        if (zzdl.zzk((zza) map.get(f12623d)).booleanValue()) {
            i = 66;
        }
        zza com_google_android_gms_internal_zzai_zza3 = (zza) map.get(f12624e);
        int intValue;
        if (com_google_android_gms_internal_zzai_zza3 != null) {
            Long zzi = zzdl.zzi(com_google_android_gms_internal_zzai_zza3);
            if (zzi == zzdl.zzcdp()) {
                return zzdl.zzcdu();
            }
            intValue = zzi.intValue();
            if (intValue < 0) {
                return zzdl.zzcdu();
            }
        }
        intValue = 1;
        try {
            CharSequence zzg = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
            Object obj = null;
            Matcher matcher = Pattern.compile(zzdl.zzg(com_google_android_gms_internal_zzai_zza2), i).matcher(zzg);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? zzdl.zzcdu() : zzdl.zzap(obj);
        } catch (PatternSyntaxException e) {
            return zzdl.zzcdu();
        }
    }

    public boolean zzcag() {
        return true;
    }
}
