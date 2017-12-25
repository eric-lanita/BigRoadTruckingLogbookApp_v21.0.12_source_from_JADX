package com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzdm extends zzdj {
    private static final String f12735a = zzaf.UNIVERSAL_ANALYTICS.toString();
    private static final String f12736b = zzag.ACCOUNT.toString();
    private static final String f12737c = zzag.ANALYTICS_PASS_THROUGH.toString();
    private static final String f12738d = zzag.ENABLE_ECOMMERCE.toString();
    private static final String f12739e = zzag.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String f12740f = zzag.ECOMMERCE_MACRO_DATA.toString();
    private static final String f12741g = zzag.ANALYTICS_FIELDS.toString();
    private static final String f12742h = zzag.TRACK_TRANSACTION.toString();
    private static final String f12743i = zzag.TRANSACTION_DATALAYER_MAP.toString();
    private static final String f12744j = zzag.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> f12745k = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND});
    private static final Pattern f12746l = Pattern.compile("dimension(\\d+)");
    private static final Pattern f12747m = Pattern.compile("metric(\\d+)");
    private static Map<String, String> f12748n;
    private static Map<String, String> f12749o;
    private final Set<String> f12750p;
    private final zzdi f12751q;
    private final DataLayer f12752r;

    public zzdm(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzdi(context));
    }

    zzdm(Context context, DataLayer dataLayer, zzdi com_google_android_gms_tagmanager_zzdi) {
        super(f12735a, new String[0]);
        this.f12752r = dataLayer;
        this.f12751q = com_google_android_gms_tagmanager_zzdi;
        this.f12750p = new HashSet();
        this.f12750p.add("");
        this.f12750p.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f12750p.add("false");
    }

    private ProductAction m18202a(String str, Map<String, Object> map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (obj != null) {
            productAction.setTransactionId(String.valueOf(obj));
        }
        obj = map.get("affiliation");
        if (obj != null) {
            productAction.setTransactionAffiliation(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            productAction.setTransactionCouponCode(String.valueOf(obj));
        }
        obj = map.get("list");
        if (obj != null) {
            productAction.setProductActionList(String.valueOf(obj));
        }
        obj = map.get("option");
        if (obj != null) {
            productAction.setCheckoutOptions(String.valueOf(obj));
        }
        obj = map.get("revenue");
        if (obj != null) {
            productAction.setTransactionRevenue(m18204a(obj).doubleValue());
        }
        obj = map.get("tax");
        if (obj != null) {
            productAction.setTransactionTax(m18204a(obj).doubleValue());
        }
        obj = map.get("shipping");
        if (obj != null) {
            productAction.setTransactionShipping(m18204a(obj).doubleValue());
        }
        obj = map.get("step");
        if (obj != null) {
            productAction.setCheckoutStep(m18211b(obj).intValue());
        }
        return productAction;
    }

    private Promotion m18203a(Map<String, String> map) {
        Promotion promotion = new Promotion();
        String str = (String) map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (str != null) {
            promotion.setId(String.valueOf(str));
        }
        str = (String) map.get("name");
        if (str != null) {
            promotion.setName(String.valueOf(str));
        }
        str = (String) map.get("creative");
        if (str != null) {
            promotion.setCreative(String.valueOf(str));
        }
        str = (String) map.get("position");
        if (str != null) {
            promotion.setPosition(String.valueOf(str));
        }
        return promotion;
    }

    private Double m18204a(Object obj) {
        String str;
        String valueOf;
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                str = "Cannot convert the object to Double: ";
                valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            str = "Cannot convert the object to Double: ";
            valueOf = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private String m18205a(String str) {
        Object obj = this.f12752r.get(str);
        return obj == null ? null : obj.toString();
    }

    private Map<String, String> m18206a(zza com_google_android_gms_internal_zzai_zza) {
        Object zzl = zzdl.zzl(com_google_android_gms_internal_zzai_zza);
        if (!(zzl instanceof Map)) {
            return null;
        }
        Map map = (Map) zzl;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private void m18207a(Tracker tracker, Map<String, zza> map) {
        String a = m18205a("transactionId");
        if (a == null) {
            zzbn.m18105e("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map b = m18213b((zza) map.get(f12741g));
            b.put("&t", "transaction");
            for (Entry entry : m18215c(map).entrySet()) {
                m18208a(b, (String) entry.getValue(), m18205a((String) entry.getKey()));
            }
            linkedList.add(b);
            List<Map> b2 = m18212b("transactionProducts");
            if (b2 != null) {
                for (Map map2 : b2) {
                    if (map2.get("name") == null) {
                        zzbn.m18105e("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map b3 = m18213b((zza) map.get(f12741g));
                    b3.put("&t", "item");
                    b3.put("&ti", a);
                    for (Entry entry2 : m18216d(map).entrySet()) {
                        m18208a(b3, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(b3);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            zzbn.zzb("Unable to send transaction", e);
        }
    }

    private void m18208a(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private boolean m18209a(Map<String, zza> map, String str) {
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(str);
        return com_google_android_gms_internal_zzai_zza == null ? false : zzdl.zzk(com_google_android_gms_internal_zzai_zza).booleanValue();
    }

    private Product m18210b(Map<String, Object> map) {
        String str;
        Product product = new Product();
        Object obj = map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null) {
            product.setName(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null) {
            product.setBrand(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null) {
            product.setCategory(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null) {
            product.setVariant(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null) {
            product.setCouponCode(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null) {
            product.setPosition(m18211b(obj).intValue());
        }
        obj = map.get("price");
        if (obj != null) {
            product.setPrice(m18204a(obj).doubleValue());
        }
        obj = map.get("quantity");
        if (obj != null) {
            product.setQuantity(m18211b(obj).intValue());
        }
        for (String str2 : map.keySet()) {
            String str22;
            Matcher matcher = f12746l.matcher(str22);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str22)));
                } catch (NumberFormatException e) {
                    str = "illegal number in custom dimension value: ";
                    str22 = String.valueOf(str22);
                    zzbn.zzcx(str22.length() != 0 ? str.concat(str22) : new String(str));
                }
            } else {
                matcher = f12747m.matcher(str22);
                if (matcher.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher.group(1)), m18211b(map.get(str22)).intValue());
                    } catch (NumberFormatException e2) {
                        str = "illegal number in custom metric value: ";
                        str22 = String.valueOf(str22);
                        zzbn.zzcx(str22.length() != 0 ? str.concat(str22) : new String(str));
                    }
                }
            }
        }
        return product;
    }

    private Integer m18211b(Object obj) {
        String str;
        String valueOf;
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                str = "Cannot convert the object to Integer: ";
                valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            str = "Cannot convert the object to Integer: ";
            valueOf = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    private List<Map<String, String>> m18212b(String str) {
        Object obj = this.f12752r.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private Map<String, String> m18213b(zza com_google_android_gms_internal_zzai_zza) {
        if (com_google_android_gms_internal_zzai_zza == null) {
            return new HashMap();
        }
        Map<String, String> a = m18206a(com_google_android_gms_internal_zzai_zza);
        if (a == null) {
            return new HashMap();
        }
        String str = (String) a.get("&aip");
        if (str != null && this.f12750p.contains(str.toLowerCase())) {
            a.remove("&aip");
        }
        return a;
    }

    private void m18214b(Tracker tracker, Map<String, zza> map) {
        Object obj;
        Map map2;
        String str;
        ScreenViewBuilder screenViewBuilder = new ScreenViewBuilder();
        Map b = m18213b((zza) map.get(f12741g));
        screenViewBuilder.setAll(b);
        if (m18209a((Map) map, f12739e)) {
            obj = this.f12752r.get("ecommerce");
            map2 = obj instanceof Map ? (Map) obj : null;
        } else {
            obj = zzdl.zzl((zza) map.get(f12740f));
            map2 = obj instanceof Map ? (Map) obj : null;
        }
        if (map2 != null) {
            Map map3;
            List<Map> list;
            String str2 = (String) b.get("&cu");
            if (str2 == null) {
                str2 = (String) map2.get("currencyCode");
            }
            if (str2 != null) {
                screenViewBuilder.set("&cu", str2);
            }
            obj = map2.get("impressions");
            if (obj instanceof List) {
                for (Map map4 : (List) obj) {
                    try {
                        screenViewBuilder.addImpression(m18210b(map4), (String) map4.get("list"));
                    } catch (RuntimeException e) {
                        str = "Failed to extract a product from DataLayer. ";
                        str2 = String.valueOf(e.getMessage());
                        zzbn.m18105e(str2.length() != 0 ? str.concat(str2) : new String(str));
                    }
                }
            }
            List list2 = map2.containsKey("promoClick") ? (List) ((Map) map2.get("promoClick")).get("promotions") : map2.containsKey("promoView") ? (List) ((Map) map2.get("promoView")).get("promotions") : null;
            if (r0 != null) {
                for (Map map42 : r0) {
                    try {
                        screenViewBuilder.addPromotion(m18203a(map42));
                    } catch (RuntimeException e2) {
                        str = "Failed to extract a promotion from DataLayer. ";
                        str2 = String.valueOf(e2.getMessage());
                        zzbn.m18105e(str2.length() != 0 ? str.concat(str2) : new String(str));
                    }
                }
                if (map2.containsKey("promoClick")) {
                    screenViewBuilder.set("&promoa", "click");
                    obj = null;
                    if (obj != null) {
                        for (String str22 : f12745k) {
                            if (map2.containsKey(str22)) {
                                map3 = (Map) map2.get(str22);
                                list = (List) map3.get("products");
                                if (list != null) {
                                    for (Map map22 : list) {
                                        try {
                                            screenViewBuilder.addProduct(m18210b(map22));
                                        } catch (RuntimeException e3) {
                                            str = "Failed to extract a product from DataLayer. ";
                                            String valueOf = String.valueOf(e3.getMessage());
                                            zzbn.m18105e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                                        }
                                    }
                                }
                                try {
                                    screenViewBuilder.setProductAction(map3.containsKey("actionField") ? m18202a(str22, (Map) map3.get("actionField")) : new ProductAction(str22));
                                } catch (RuntimeException e22) {
                                    String str3 = "Failed to extract a product action from DataLayer. ";
                                    str22 = String.valueOf(e22.getMessage());
                                    zzbn.m18105e(str22.length() != 0 ? str3.concat(str22) : new String(str3));
                                }
                            }
                        }
                    }
                } else {
                    screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                }
            }
            int i = 1;
            if (obj != null) {
                for (String str222 : f12745k) {
                    if (map22.containsKey(str222)) {
                        map3 = (Map) map22.get(str222);
                        list = (List) map3.get("products");
                        if (list != null) {
                            while (r4.hasNext()) {
                                screenViewBuilder.addProduct(m18210b(map22));
                            }
                        }
                        if (map3.containsKey("actionField")) {
                        }
                        screenViewBuilder.setProductAction(map3.containsKey("actionField") ? m18202a(str222, (Map) map3.get("actionField")) : new ProductAction(str222));
                    }
                }
            }
        }
        tracker.send(screenViewBuilder.build());
    }

    private Map<String, String> m18215c(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(f12743i);
        if (com_google_android_gms_internal_zzai_zza != null) {
            return m18206a(com_google_android_gms_internal_zzai_zza);
        }
        if (f12748n == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            f12748n = hashMap;
        }
        return f12748n;
    }

    private Map<String, String> m18216d(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(f12744j);
        if (com_google_android_gms_internal_zzai_zza != null) {
            return m18206a(com_google_android_gms_internal_zzai_zza);
        }
        if (f12749o == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            f12749o = hashMap;
        }
        return f12749o;
    }

    public /* bridge */ /* synthetic */ zza zzav(Map map) {
        return super.zzav(map);
    }

    public void zzax(Map<String, zza> map) {
        Tracker zzpf = this.f12751q.zzpf("_GTM_DEFAULT_TRACKER_");
        zzpf.enableAdvertisingIdCollection(m18209a((Map) map, "collect_adid"));
        if (m18209a((Map) map, f12738d)) {
            m18214b(zzpf, map);
        } else if (m18209a((Map) map, f12737c)) {
            zzpf.send(m18213b((zza) map.get(f12741g)));
        } else if (m18209a((Map) map, f12742h)) {
            m18207a(zzpf, (Map) map);
        } else {
            zzbn.zzcx("Ignoring unknown tag.");
        }
    }

    public /* bridge */ /* synthetic */ boolean zzcag() {
        return super.zzcag();
    }

    public /* bridge */ /* synthetic */ String zzcbp() {
        return super.zzcbp();
    }

    public /* bridge */ /* synthetic */ Set zzcbq() {
        return super.zzcbq();
    }
}
