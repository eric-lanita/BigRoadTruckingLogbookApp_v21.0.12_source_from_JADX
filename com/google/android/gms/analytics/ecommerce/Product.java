package com.google.android.gms.analytics.ecommerce;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.zzc;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzab;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Product {
    Map<String, String> f10212a = new HashMap();

    void m16577a(String str, String str2) {
        zzab.zzb((Object) str, (Object) "Name should be non-null");
        this.f10212a.put(str, str2);
    }

    public Product setBrand(String str) {
        m16577a("br", str);
        return this;
    }

    public Product setCategory(String str) {
        m16577a("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        m16577a("cc", str);
        return this;
    }

    public Product setCustomDimension(int i, String str) {
        m16577a(zzc.zzbn(i), str);
        return this;
    }

    public Product setCustomMetric(int i, int i2) {
        m16577a(zzc.zzbo(i), Integer.toString(i2));
        return this;
    }

    public Product setId(String str) {
        m16577a(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        return this;
    }

    public Product setName(String str) {
        m16577a("nm", str);
        return this;
    }

    public Product setPosition(int i) {
        m16577a("ps", Integer.toString(i));
        return this;
    }

    public Product setPrice(double d) {
        m16577a("pr", Double.toString(d));
        return this;
    }

    public Product setQuantity(int i) {
        m16577a("qt", Integer.toString(i));
        return this;
    }

    public Product setVariant(String str) {
        m16577a("va", str);
        return this;
    }

    public String toString() {
        return zzg.zzao(this.f10212a);
    }

    public Map<String, String> zzee(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f10212a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }
}
