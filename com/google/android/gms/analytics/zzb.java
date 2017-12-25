package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzao;
import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlw;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzma;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzmg;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzb extends zzc implements zzk {
    private static DecimalFormat f10414a;
    private final zzf f10415b;
    private final String f10416c;
    private final Uri f10417d;
    private final boolean f10418e;
    private final boolean f10419f;

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, String str) {
        this(com_google_android_gms_analytics_internal_zzf, str, true, false);
    }

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, String str, boolean z, boolean z2) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzab.zzhr(str);
        this.f10415b = com_google_android_gms_analytics_internal_zzf;
        this.f10416c = str;
        this.f10418e = z;
        this.f10419f = z2;
        this.f10417d = m16733a(this.f10416c);
    }

    static Uri m16733a(String str) {
        zzab.zzhr(str);
        Builder builder = new Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String m16734a(double d) {
        if (f10414a == null) {
            f10414a = new DecimalFormat("0.######");
        }
        return f10414a.format(d);
    }

    private static String m16735a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return TextUtils.isEmpty(str) ? null : str;
        } else if (!(obj instanceof Double)) {
            return obj instanceof Boolean ? obj != Boolean.FALSE ? AppEventsConstants.EVENT_PARAM_VALUE_YES : null : String.valueOf(obj);
        } else {
            Double d = (Double) obj;
            return d.doubleValue() != 0.0d ? m16734a(d.doubleValue()) : null;
        }
    }

    private static String m16736a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static void m16737a(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, m16734a(d));
        }
    }

    private static void m16738a(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void m16739a(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static void m16740a(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    public static Map<String, String> zzc(zze com_google_android_gms_analytics_zze) {
        CharSequence zzbd;
        Map hashMap = new HashMap();
        zzly com_google_android_gms_internal_zzly = (zzly) com_google_android_gms_analytics_zze.zza(zzly.class);
        if (com_google_android_gms_internal_zzly != null) {
            for (Entry entry : com_google_android_gms_internal_zzly.zzxm().entrySet()) {
                String a = m16735a(entry.getValue());
                if (a != null) {
                    hashMap.put((String) entry.getKey(), a);
                }
            }
        }
        zzmd com_google_android_gms_internal_zzmd = (zzmd) com_google_android_gms_analytics_zze.zza(zzmd.class);
        if (com_google_android_gms_internal_zzmd != null) {
            m16739a(hashMap, "t", com_google_android_gms_internal_zzmd.zzxx());
            m16739a(hashMap, "cid", com_google_android_gms_internal_zzmd.zzwb());
            m16739a(hashMap, "uid", com_google_android_gms_internal_zzmd.getUserId());
            m16739a(hashMap, "sc", com_google_android_gms_internal_zzmd.zzya());
            m16737a(hashMap, "sf", com_google_android_gms_internal_zzmd.zzyc());
            m16740a(hashMap, "ni", com_google_android_gms_internal_zzmd.zzyb());
            m16739a(hashMap, "adid", com_google_android_gms_internal_zzmd.zzxy());
            m16740a(hashMap, "ate", com_google_android_gms_internal_zzmd.zzxz());
        }
        zzme com_google_android_gms_internal_zzme = (zzme) com_google_android_gms_analytics_zze.zza(zzme.class);
        if (com_google_android_gms_internal_zzme != null) {
            m16739a(hashMap, "cd", com_google_android_gms_internal_zzme.zzye());
            m16737a(hashMap, "a", (double) com_google_android_gms_internal_zzme.zzyf());
            m16739a(hashMap, "dr", com_google_android_gms_internal_zzme.zzyg());
        }
        zzmb com_google_android_gms_internal_zzmb = (zzmb) com_google_android_gms_analytics_zze.zza(zzmb.class);
        if (com_google_android_gms_internal_zzmb != null) {
            m16739a(hashMap, "ec", com_google_android_gms_internal_zzmb.getCategory());
            m16739a(hashMap, "ea", com_google_android_gms_internal_zzmb.getAction());
            m16739a(hashMap, "el", com_google_android_gms_internal_zzmb.getLabel());
            m16737a(hashMap, "ev", (double) com_google_android_gms_internal_zzmb.getValue());
        }
        zzlv com_google_android_gms_internal_zzlv = (zzlv) com_google_android_gms_analytics_zze.zza(zzlv.class);
        if (com_google_android_gms_internal_zzlv != null) {
            m16739a(hashMap, "cn", com_google_android_gms_internal_zzlv.getName());
            m16739a(hashMap, "cs", com_google_android_gms_internal_zzlv.getSource());
            m16739a(hashMap, "cm", com_google_android_gms_internal_zzlv.zzxe());
            m16739a(hashMap, "ck", com_google_android_gms_internal_zzlv.zzxf());
            m16739a(hashMap, "cc", com_google_android_gms_internal_zzlv.getContent());
            m16739a(hashMap, "ci", com_google_android_gms_internal_zzlv.getId());
            m16739a(hashMap, "anid", com_google_android_gms_internal_zzlv.zzxg());
            m16739a(hashMap, "gclid", com_google_android_gms_internal_zzlv.zzxh());
            m16739a(hashMap, "dclid", com_google_android_gms_internal_zzlv.zzxi());
            m16739a(hashMap, "aclid", com_google_android_gms_internal_zzlv.zzxj());
        }
        zzmc com_google_android_gms_internal_zzmc = (zzmc) com_google_android_gms_analytics_zze.zza(zzmc.class);
        if (com_google_android_gms_internal_zzmc != null) {
            m16739a(hashMap, "exd", com_google_android_gms_internal_zzmc.getDescription());
            m16740a(hashMap, "exf", com_google_android_gms_internal_zzmc.zzxw());
        }
        zzmf com_google_android_gms_internal_zzmf = (zzmf) com_google_android_gms_analytics_zze.zza(zzmf.class);
        if (com_google_android_gms_internal_zzmf != null) {
            m16739a(hashMap, "sn", com_google_android_gms_internal_zzmf.zzyi());
            m16739a(hashMap, "sa", com_google_android_gms_internal_zzmf.getAction());
            m16739a(hashMap, "st", com_google_android_gms_internal_zzmf.getTarget());
        }
        zzmg com_google_android_gms_internal_zzmg = (zzmg) com_google_android_gms_analytics_zze.zza(zzmg.class);
        if (com_google_android_gms_internal_zzmg != null) {
            m16739a(hashMap, "utv", com_google_android_gms_internal_zzmg.zzyj());
            m16737a(hashMap, "utt", (double) com_google_android_gms_internal_zzmg.getTimeInMillis());
            m16739a(hashMap, "utc", com_google_android_gms_internal_zzmg.getCategory());
            m16739a(hashMap, "utl", com_google_android_gms_internal_zzmg.getLabel());
        }
        zzlw com_google_android_gms_internal_zzlw = (zzlw) com_google_android_gms_analytics_zze.zza(zzlw.class);
        if (com_google_android_gms_internal_zzlw != null) {
            for (Entry entry2 : com_google_android_gms_internal_zzlw.zzxk().entrySet()) {
                zzbd = zzc.zzbd(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(zzbd)) {
                    hashMap.put(zzbd, (String) entry2.getValue());
                }
            }
        }
        zzlx com_google_android_gms_internal_zzlx = (zzlx) com_google_android_gms_analytics_zze.zza(zzlx.class);
        if (com_google_android_gms_internal_zzlx != null) {
            for (Entry entry22 : com_google_android_gms_internal_zzlx.zzxl().entrySet()) {
                zzbd = zzc.zzbf(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(zzbd)) {
                    hashMap.put(zzbd, m16734a(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        zzma com_google_android_gms_internal_zzma = (zzma) com_google_android_gms_analytics_zze.zza(zzma.class);
        if (com_google_android_gms_internal_zzma != null) {
            ProductAction zzxs = com_google_android_gms_internal_zzma.zzxs();
            if (zzxs != null) {
                for (Entry entry3 : zzxs.build().entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), (String) entry3.getValue());
                    } else {
                        hashMap.put((String) entry3.getKey(), (String) entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (Promotion zzee : com_google_android_gms_internal_zzma.zzxv()) {
                hashMap.putAll(zzee.zzee(zzc.zzbj(i)));
                i++;
            }
            i = 1;
            for (Product zzee2 : com_google_android_gms_internal_zzma.zzxt()) {
                hashMap.putAll(zzee2.zzee(zzc.zzbh(i)));
                i++;
            }
            i = 1;
            for (Entry entry222 : com_google_android_gms_internal_zzma.zzxu().entrySet()) {
                List<Product> list = (List) entry222.getValue();
                String zzbm = zzc.zzbm(i);
                int i2 = 1;
                for (Product zzee22 : list) {
                    String valueOf = String.valueOf(zzbm);
                    String valueOf2 = String.valueOf(zzc.zzbk(i2));
                    hashMap.putAll(zzee22.zzee(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i2++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry222.getKey())) {
                    String valueOf3 = String.valueOf(zzbm);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry222.getKey());
                }
                i++;
            }
        }
        zzlz com_google_android_gms_internal_zzlz = (zzlz) com_google_android_gms_analytics_zze.zza(zzlz.class);
        if (com_google_android_gms_internal_zzlz != null) {
            m16739a(hashMap, "ul", com_google_android_gms_internal_zzlz.getLanguage());
            m16737a(hashMap, "sd", (double) com_google_android_gms_internal_zzlz.zzxn());
            m16738a(hashMap, "sr", com_google_android_gms_internal_zzlz.zzxo(), com_google_android_gms_internal_zzlz.zzxp());
            m16738a(hashMap, "vp", com_google_android_gms_internal_zzlz.zzxq(), com_google_android_gms_internal_zzlz.zzxr());
        }
        zzlu com_google_android_gms_internal_zzlu = (zzlu) com_google_android_gms_analytics_zze.zza(zzlu.class);
        if (com_google_android_gms_internal_zzlu != null) {
            m16739a(hashMap, "an", com_google_android_gms_internal_zzlu.zzxb());
            m16739a(hashMap, "aid", com_google_android_gms_internal_zzlu.zzsh());
            m16739a(hashMap, "aiid", com_google_android_gms_internal_zzlu.zzxd());
            m16739a(hashMap, "av", com_google_android_gms_internal_zzlu.zzxc());
        }
        return hashMap;
    }

    public void zzb(zze com_google_android_gms_analytics_zze) {
        zzab.zzy(com_google_android_gms_analytics_zze);
        zzab.zzb(com_google_android_gms_analytics_zze.zzwk(), (Object) "Can't deliver not submitted measurement");
        zzab.zzhj("deliver should be called on worker thread");
        zze zzwf = com_google_android_gms_analytics_zze.zzwf();
        zzmd com_google_android_gms_internal_zzmd = (zzmd) zzwf.zzb(zzmd.class);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzmd.zzxx())) {
            m16541h().zzh(zzc(zzwf), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(com_google_android_gms_internal_zzmd.zzwb())) {
            m16541h().zzh(zzc(zzwf), "Ignoring measurement without client id");
        } else if (!this.f10415b.zzzk().getAppOptOut()) {
            double zzyc = com_google_android_gms_internal_zzmd.zzyc();
            if (zzao.zza(zzyc, com_google_android_gms_internal_zzmd.zzwb())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzyc));
                return;
            }
            Map zzc = zzc(zzwf);
            zzc.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            zzc.put("_v", zze.zzcwr);
            zzc.put("tid", this.f10416c);
            if (this.f10415b.zzzk().isDryRunEnabled()) {
                zzc("Dry run is enabled. GoogleAnalytics would have sent", m16736a(zzc));
                return;
            }
            Map hashMap = new HashMap();
            zzao.zzc(hashMap, "uid", com_google_android_gms_internal_zzmd.getUserId());
            zzlu com_google_android_gms_internal_zzlu = (zzlu) com_google_android_gms_analytics_zze.zza(zzlu.class);
            if (com_google_android_gms_internal_zzlu != null) {
                zzao.zzc(hashMap, "an", com_google_android_gms_internal_zzlu.zzxb());
                zzao.zzc(hashMap, "aid", com_google_android_gms_internal_zzlu.zzsh());
                zzao.zzc(hashMap, "av", com_google_android_gms_internal_zzlu.zzxc());
                zzao.zzc(hashMap, "aiid", com_google_android_gms_internal_zzlu.zzxd());
            }
            zzc.put("_s", String.valueOf(m16544k().zza(new zzh(0, com_google_android_gms_internal_zzmd.zzwb(), this.f10416c, !TextUtils.isEmpty(com_google_android_gms_internal_zzmd.zzxy()), 0, hashMap))));
            m16544k().zza(new com.google.android.gms.analytics.internal.zzab(m16541h(), zzc, com_google_android_gms_analytics_zze.zzwi(), true));
        }
    }

    public Uri zzvu() {
        return this.f10417d;
    }
}
