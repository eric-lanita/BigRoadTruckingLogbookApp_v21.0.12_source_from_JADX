package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        ProductAction f10183a;
        Map<String, List<Product>> f10184b = new HashMap();
        List<Promotion> f10185c = new ArrayList();
        List<Product> f10186d = new ArrayList();
        private Map<String, String> f10187e = new HashMap();

        protected HitBuilder() {
        }

        private T m16530a(String str, String str2) {
            if (str == null) {
                zzae.zzcx("HitBuilder.setIfNonNull() called with a null paramName.");
            } else if (str2 != null) {
                this.f10187e.put(str, str2);
            }
            return this;
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzae.zzcx("product should be non-null");
            } else {
                Object obj;
                if (str == null) {
                    obj = "";
                }
                if (!this.f10184b.containsKey(obj)) {
                    this.f10184b.put(obj, new ArrayList());
                }
                ((List) this.f10184b.get(obj)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzae.zzcx("product should be non-null");
            } else {
                this.f10186d.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzae.zzcx("promotion should be non-null");
            } else {
                this.f10185c.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.f10187e);
            if (this.f10183a != null) {
                hashMap.putAll(this.f10183a.build());
            }
            int i = 1;
            for (Promotion zzee : this.f10185c) {
                hashMap.putAll(zzee.zzee(zzc.zzbi(i)));
                i++;
            }
            i = 1;
            for (Product zzee2 : this.f10186d) {
                hashMap.putAll(zzee2.zzee(zzc.zzbg(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.f10184b.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzbl = zzc.zzbl(i2);
                int i3 = 1;
                for (Product product : list) {
                    String valueOf = String.valueOf(zzbl);
                    String valueOf2 = String.valueOf(zzc.zzbk(i3));
                    hashMap.putAll(product.zzee(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    String valueOf3 = String.valueOf(zzbl);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.f10187e.put(str, str2);
            } else {
                zzae.zzcx("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map != null) {
                this.f10187e.putAll(new HashMap(map));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            Object zzez = zzao.zzez(str);
            if (!TextUtils.isEmpty(zzez)) {
                Map zzex = zzao.zzex(zzez);
                m16530a("&cc", (String) zzex.get("utm_content"));
                m16530a("&cm", (String) zzex.get("utm_medium"));
                m16530a("&cn", (String) zzex.get("utm_campaign"));
                m16530a("&cs", (String) zzex.get("utm_source"));
                m16530a("&ck", (String) zzex.get("utm_term"));
                m16530a("&ci", (String) zzex.get("utm_id"));
                m16530a("&anid", (String) zzex.get("anid"));
                m16530a("&gclid", (String) zzex.get("gclid"));
                m16530a("&dclid", (String) zzex.get("dclid"));
                m16530a("&aclid", (String) zzex.get("aclid"));
                m16530a("&gmob_t", (String) zzex.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzc.zzbc(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzc.zzbe(i), Float.toString(f));
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zzao.zzat(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.f10183a = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.f10187e.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zzao.zzat(z));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
