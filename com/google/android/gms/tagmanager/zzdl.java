package com.google.android.gms.tagmanager;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzai.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzdl {
    private static final Object f12726a = null;
    private static Long f12727b = new Long(0);
    private static Double f12728c = new Double(0.0d);
    private static zzdk f12729d = zzdk.zzbu(0);
    private static String f12730e = new String("");
    private static Boolean f12731f = new Boolean(false);
    private static List<Object> f12732g = new ArrayList(0);
    private static Map<Object, Object> f12733h = new HashMap();
    private static zza f12734i = zzap(f12730e);

    private static zzdk m18194a(String str) {
        try {
            return zzdk.zzph(str);
        } catch (NumberFormatException e) {
            zzbn.m18105e(new StringBuilder(String.valueOf(str).length() + 33).append("Failed to convert '").append(str).append("' to a number.").toString());
            return f12729d;
        }
    }

    private static boolean m18195a(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzdk) && ((zzdk) obj).zzcdj());
    }

    private static double m18196b(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzbn.m18105e("getDouble received non-Number");
        return 0.0d;
    }

    private static Long m18197b(String str) {
        zzdk a = m18194a(str);
        return a == f12729d ? f12727b : Long.valueOf(a.longValue());
    }

    private static Double m18198c(String str) {
        zzdk a = m18194a(str);
        return a == f12729d ? f12728c : Double.valueOf(a.doubleValue());
    }

    private static boolean m18199c(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzdk) && ((zzdk) obj).zzcdk());
    }

    private static long m18200d(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbn.m18105e("getInt64 received non-Number");
        return 0;
    }

    private static Boolean m18201d(String str) {
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : f12731f;
    }

    public static String zzak(Object obj) {
        return obj == null ? f12730e : obj.toString();
    }

    public static zzdk zzal(Object obj) {
        return obj instanceof zzdk ? (zzdk) obj : m18199c(obj) ? zzdk.zzbu(m18200d(obj)) : m18195a(obj) ? zzdk.zza(Double.valueOf(m18196b(obj))) : m18194a(zzak(obj));
    }

    public static Long zzam(Object obj) {
        return m18199c(obj) ? Long.valueOf(m18200d(obj)) : m18197b(zzak(obj));
    }

    public static Double zzan(Object obj) {
        return m18195a(obj) ? Double.valueOf(m18196b(obj)) : m18198c(zzak(obj));
    }

    public static Boolean zzao(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : m18201d(zzak(obj));
    }

    public static zza zzap(Object obj) {
        boolean z = false;
        zza com_google_android_gms_internal_zzai_zza = new zza();
        if (obj instanceof zza) {
            return (zza) obj;
        }
        if (obj instanceof String) {
            com_google_android_gms_internal_zzai_zza.type = 1;
            com_google_android_gms_internal_zzai_zza.string = (String) obj;
        } else if (obj instanceof List) {
            com_google_android_gms_internal_zzai_zza.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object zzap : list) {
                zza zzap2 = zzap(zzap);
                if (zzap2 == f12734i) {
                    return f12734i;
                }
                r0 = r1 || zzap2.zzxd;
                r5.add(zzap2);
                r1 = r0;
            }
            com_google_android_gms_internal_zzai_zza.zzwu = (zza[]) r5.toArray(new zza[0]);
            z = r1;
        } else if (obj instanceof Map) {
            com_google_android_gms_internal_zzai_zza.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                zza zzap3 = zzap(entry.getKey());
                zza zzap4 = zzap(entry.getValue());
                if (zzap3 == f12734i || zzap4 == f12734i) {
                    return f12734i;
                }
                r0 = r1 || zzap3.zzxd || zzap4.zzxd;
                r5.add(zzap3);
                arrayList.add(zzap4);
                r1 = r0;
            }
            com_google_android_gms_internal_zzai_zza.zzwv = (zza[]) r5.toArray(new zza[0]);
            com_google_android_gms_internal_zzai_zza.zzww = (zza[]) arrayList.toArray(new zza[0]);
            z = r1;
        } else if (m18195a(obj)) {
            com_google_android_gms_internal_zzai_zza.type = 1;
            com_google_android_gms_internal_zzai_zza.string = obj.toString();
        } else if (m18199c(obj)) {
            com_google_android_gms_internal_zzai_zza.type = 6;
            com_google_android_gms_internal_zzai_zza.zzwz = m18200d(obj);
        } else if (obj instanceof Boolean) {
            com_google_android_gms_internal_zzai_zza.type = 8;
            com_google_android_gms_internal_zzai_zza.zzxa = ((Boolean) obj).booleanValue();
        } else {
            String str = "Converting to Value from unknown object type: ";
            String valueOf = String.valueOf(obj == null ? "null" : obj.getClass().toString());
            zzbn.m18105e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return f12734i;
        }
        com_google_android_gms_internal_zzai_zza.zzxd = z;
        return com_google_android_gms_internal_zzai_zza;
    }

    public static Object zzcdo() {
        return null;
    }

    public static Long zzcdp() {
        return f12727b;
    }

    public static Double zzcdq() {
        return f12728c;
    }

    public static Boolean zzcdr() {
        return f12731f;
    }

    public static zzdk zzcds() {
        return f12729d;
    }

    public static String zzcdt() {
        return f12730e;
    }

    public static zza zzcdu() {
        return f12734i;
    }

    public static String zzg(zza com_google_android_gms_internal_zzai_zza) {
        return zzak(zzl(com_google_android_gms_internal_zzai_zza));
    }

    public static zzdk zzh(zza com_google_android_gms_internal_zzai_zza) {
        return zzal(zzl(com_google_android_gms_internal_zzai_zza));
    }

    public static Long zzi(zza com_google_android_gms_internal_zzai_zza) {
        return zzam(zzl(com_google_android_gms_internal_zzai_zza));
    }

    public static Double zzj(zza com_google_android_gms_internal_zzai_zza) {
        return zzan(zzl(com_google_android_gms_internal_zzai_zza));
    }

    public static Boolean zzk(zza com_google_android_gms_internal_zzai_zza) {
        return zzao(zzl(com_google_android_gms_internal_zzai_zza));
    }

    public static Object zzl(zza com_google_android_gms_internal_zzai_zza) {
        int i = 0;
        if (com_google_android_gms_internal_zzai_zza == null) {
            return null;
        }
        zza[] com_google_android_gms_internal_zzai_zzaArr;
        int length;
        switch (com_google_android_gms_internal_zzai_zza.type) {
            case 1:
                return com_google_android_gms_internal_zzai_zza.string;
            case 2:
                ArrayList arrayList = new ArrayList(com_google_android_gms_internal_zzai_zza.zzwu.length);
                com_google_android_gms_internal_zzai_zzaArr = com_google_android_gms_internal_zzai_zza.zzwu;
                length = com_google_android_gms_internal_zzai_zzaArr.length;
                while (i < length) {
                    Object zzl = zzl(com_google_android_gms_internal_zzai_zzaArr[i]);
                    if (zzl == null) {
                        return null;
                    }
                    arrayList.add(zzl);
                    i++;
                }
                return arrayList;
            case 3:
                if (com_google_android_gms_internal_zzai_zza.zzwv.length != com_google_android_gms_internal_zzai_zza.zzww.length) {
                    String str = "Converting an invalid value to object: ";
                    String valueOf = String.valueOf(com_google_android_gms_internal_zzai_zza.toString());
                    zzbn.m18105e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return null;
                }
                Map hashMap = new HashMap(com_google_android_gms_internal_zzai_zza.zzww.length);
                while (i < com_google_android_gms_internal_zzai_zza.zzwv.length) {
                    Object zzl2 = zzl(com_google_android_gms_internal_zzai_zza.zzwv[i]);
                    Object zzl3 = zzl(com_google_android_gms_internal_zzai_zza.zzww[i]);
                    if (zzl2 == null || zzl3 == null) {
                        return null;
                    }
                    hashMap.put(zzl2, zzl3);
                    i++;
                }
                return hashMap;
            case 4:
                zzbn.m18105e("Trying to convert a macro reference to object");
                return null;
            case 5:
                zzbn.m18105e("Trying to convert a function id to object");
                return null;
            case 6:
                return Long.valueOf(com_google_android_gms_internal_zzai_zza.zzwz);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                com_google_android_gms_internal_zzai_zzaArr = com_google_android_gms_internal_zzai_zza.zzxb;
                length = com_google_android_gms_internal_zzai_zzaArr.length;
                while (i < length) {
                    String zzg = zzg(com_google_android_gms_internal_zzai_zzaArr[i]);
                    if (zzg == f12730e) {
                        return null;
                    }
                    stringBuffer.append(zzg);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(com_google_android_gms_internal_zzai_zza.zzxa);
            default:
                zzbn.m18105e("Failed to convert a value of type: " + com_google_android_gms_internal_zzai_zza.type);
                return null;
        }
    }

    public static zza zzpi(String str) {
        zza com_google_android_gms_internal_zzai_zza = new zza();
        com_google_android_gms_internal_zzai_zza.type = 5;
        com_google_android_gms_internal_zzai_zza.zzwy = str;
        return com_google_android_gms_internal_zzai_zza;
    }
}
