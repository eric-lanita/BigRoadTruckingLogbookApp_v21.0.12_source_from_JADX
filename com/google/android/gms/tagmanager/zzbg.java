package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzadw;
import com.google.android.gms.internal.zzadw.zzc;
import com.google.android.gms.internal.zzadw.zzd;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class zzbg {
    static Object m18101a(Object obj) {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m18101a(jSONObject.get(str)));
            }
            return hashMap;
        }
    }

    private static zza m18102b(Object obj) {
        return zzdl.zzap(m18101a(obj));
    }

    public static zzc zzox(String str) {
        zza b = m18102b(new JSONObject(str));
        zzd zzcha = zzc.zzcha();
        for (int i = 0; i < b.zzwv.length; i++) {
            zzcha.zzc(zzadw.zza.zzcgy().zzb(zzag.INSTANCE_NAME.toString(), b.zzwv[i]).zzb(zzag.FUNCTION.toString(), zzdl.zzpi(zzn.zzcaj())).zzb(zzn.zzcak(), b.zzww[i]).zzcgz());
        }
        return zzcha.zzchc();
    }
}
