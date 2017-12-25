package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzcm extends zzdg {
    private static final String f12625a = zzaf.REGEX.toString();
    private static final String f12626b = zzag.IGNORE_CASE.toString();

    public zzcm() {
        super(f12625a);
    }

    protected boolean mo2436a(String str, String str2, Map<String, zza> map) {
        try {
            return Pattern.compile(str2, zzdl.zzk((zza) map.get(f12626b)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
