package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.zzg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzma extends zzg<zzma> {
    private final List<Product> f11431a = new ArrayList();
    private final List<Promotion> f11432b = new ArrayList();
    private final Map<String, List<Product>> f11433c = new HashMap();
    private ProductAction f11434d;

    public String toString() {
        Map hashMap = new HashMap();
        if (!this.f11431a.isEmpty()) {
            hashMap.put("products", this.f11431a);
        }
        if (!this.f11432b.isEmpty()) {
            hashMap.put("promotions", this.f11432b);
        }
        if (!this.f11433c.isEmpty()) {
            hashMap.put("impressions", this.f11433c);
        }
        hashMap.put("productAction", this.f11434d);
        return zzg.zzj(hashMap);
    }

    public void zza(Product product, String str) {
        if (product != null) {
            Object obj;
            if (str == null) {
                obj = "";
            }
            if (!this.f11433c.containsKey(obj)) {
                this.f11433c.put(obj, new ArrayList());
            }
            ((List) this.f11433c.get(obj)).add(product);
        }
    }

    public void zza(zzma com_google_android_gms_internal_zzma) {
        com_google_android_gms_internal_zzma.f11431a.addAll(this.f11431a);
        com_google_android_gms_internal_zzma.f11432b.addAll(this.f11432b);
        for (Entry entry : this.f11433c.entrySet()) {
            String str = (String) entry.getKey();
            for (Product zza : (List) entry.getValue()) {
                com_google_android_gms_internal_zzma.zza(zza, str);
            }
        }
        if (this.f11434d != null) {
            com_google_android_gms_internal_zzma.f11434d = this.f11434d;
        }
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzma) com_google_android_gms_analytics_zzg);
    }

    public ProductAction zzxs() {
        return this.f11434d;
    }

    public List<Product> zzxt() {
        return Collections.unmodifiableList(this.f11431a);
    }

    public Map<String, List<Product>> zzxu() {
        return this.f11433c;
    }

    public List<Promotion> zzxv() {
        return Collections.unmodifiableList(this.f11432b);
    }
}
