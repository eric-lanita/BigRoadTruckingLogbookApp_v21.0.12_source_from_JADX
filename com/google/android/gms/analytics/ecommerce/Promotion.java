package com.google.android.gms.analytics.ecommerce;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzab;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> f10214a = new HashMap();

    void m16579a(String str, String str2) {
        zzab.zzb((Object) str, (Object) "Name should be non-null");
        this.f10214a.put(str, str2);
    }

    public Promotion setCreative(String str) {
        m16579a("cr", str);
        return this;
    }

    public Promotion setId(String str) {
        m16579a(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        return this;
    }

    public Promotion setName(String str) {
        m16579a("nm", str);
        return this;
    }

    public Promotion setPosition(String str) {
        m16579a("ps", str);
        return this;
    }

    public String toString() {
        return zzg.zzao(this.f10214a);
    }

    public Map<String, String> zzee(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f10214a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }
}
