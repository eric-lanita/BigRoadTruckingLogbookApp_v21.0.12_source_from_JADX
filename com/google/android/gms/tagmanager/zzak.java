package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah.zzc;
import com.google.android.gms.internal.zzah.zzd;
import com.google.android.gms.internal.zzah.zzi;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzak {
    private static Map<String, Object> m18077a(zza com_google_android_gms_internal_zzai_zza) {
        Object zzl = zzdl.zzl(com_google_android_gms_internal_zzai_zza);
        if (zzl instanceof Map) {
            return (Map) zzl;
        }
        String valueOf = String.valueOf(zzl);
        zzbn.zzcx(new StringBuilder(String.valueOf(valueOf).length() + 36).append("value: ").append(valueOf).append(" is not a map value, ignored.").toString());
        return null;
    }

    private static void m18078a(DataLayer dataLayer, zzd com_google_android_gms_internal_zzah_zzd) {
        for (zza zzg : com_google_android_gms_internal_zzah_zzd.zzva) {
            dataLayer.m18054a(zzdl.zzg(zzg));
        }
    }

    private static void m18079b(DataLayer dataLayer, zzd com_google_android_gms_internal_zzah_zzd) {
        for (zza a : com_google_android_gms_internal_zzah_zzd.zzuz) {
            Map a2 = m18077a(a);
            if (a2 != null) {
                dataLayer.push(a2);
            }
        }
    }

    private static void m18080c(DataLayer dataLayer, zzd com_google_android_gms_internal_zzah_zzd) {
        for (zzc com_google_android_gms_internal_zzah_zzc : com_google_android_gms_internal_zzah_zzd.zzvb) {
            if (com_google_android_gms_internal_zzah_zzc.zzcb == null) {
                zzbn.zzcx("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(com_google_android_gms_internal_zzah_zzc.zzcb);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = com_google_android_gms_internal_zzah_zzc.zzuv;
                long j2 = com_google_android_gms_internal_zzah_zzc.zzuw;
                if (!com_google_android_gms_internal_zzah_zzc.zzux || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbn.zzcx("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.m18054a(com_google_android_gms_internal_zzah_zzc.zzcb);
                Map a = dataLayer.m18052a(com_google_android_gms_internal_zzah_zzc.zzcb, obj);
                if (com_google_android_gms_internal_zzah_zzc.zzuy > 0) {
                    if (a.containsKey("gtm")) {
                        Object obj2 = a.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(com_google_android_gms_internal_zzah_zzc.zzuy));
                        } else {
                            zzbn.zzcx("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        a.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(com_google_android_gms_internal_zzah_zzc.zzuy)));
                    }
                }
                dataLayer.push(a);
            }
        }
    }

    public static void zza(DataLayer dataLayer, zzi com_google_android_gms_internal_zzah_zzi) {
        if (com_google_android_gms_internal_zzah_zzi.zzwp == null) {
            zzbn.zzcx("supplemental missing experimentSupplemental");
            return;
        }
        m18078a(dataLayer, com_google_android_gms_internal_zzah_zzi.zzwp);
        m18079b(dataLayer, com_google_android_gms_internal_zzah_zzi.zzwp);
        m18080c(dataLayer, com_google_android_gms_internal_zzah_zzi.zzwp);
    }
}
