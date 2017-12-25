package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import java.util.Map;
import java.util.Map.Entry;

public class zzaf extends zzd {
    private static String f10242a = "3";
    private static String f10243b = "01VDIWEA?";
    private static zzaf f10244c;

    public zzaf(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    public static zzaf zzadf() {
        return f10244c;
    }

    protected String mo1611a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) l).longValue()) < 100) {
                return String.valueOf(l);
            }
            String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }

    protected void mo1605a() {
        synchronized (zzaf.class) {
            f10244c = this;
        }
    }

    public void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) zzy.zzczn.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc.m16535a(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public void zza(zzab com_google_android_gms_analytics_internal_zzab, String str) {
        Object obj;
        if (str == null) {
            obj = "no reason provided";
        }
        Object com_google_android_gms_analytics_internal_zzab2 = com_google_android_gms_analytics_internal_zzab != null ? com_google_android_gms_analytics_internal_zzab.toString() : "no hit data";
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), com_google_android_gms_analytics_internal_zzab2);
    }

    public synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            zzab.zzy(str);
            if (i >= 0) {
                i2 = i;
            }
            int length = i2 >= f10243b.length() ? f10243b.length() - 1 : i2;
            char c = m16542i().zzabd() ? m16542i().zzabc() ? 'P' : 'C' : m16542i().zzabc() ? 'p' : 'c';
            String str2 = f10242a;
            char charAt = f10243b.charAt(length);
            String str3 = zze.VERSION;
            String valueOf = String.valueOf(zzc.m16535a(str, mo1611a(obj), mo1611a(obj2), mo1611a(obj3)));
            String stringBuilder = new StringBuilder(((String.valueOf(str2).length() + 3) + String.valueOf(str3).length()) + String.valueOf(valueOf).length()).append(str2).append(charAt).append(c).append(str3).append(":").append(valueOf).toString();
            if (stringBuilder.length() > 1024) {
                stringBuilder = stringBuilder.substring(0, 1024);
            }
            zzai zzzl = zzyu().zzzl();
            if (zzzl != null) {
                zzzl.zzads().zzev(stringBuilder);
            }
        }
    }

    public void zzh(Map<String, String> map, String str) {
        Object obj;
        Object stringBuilder;
        if (str == null) {
            obj = "no reason provided";
        }
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        String str2 = "Discarding hit. ";
        String valueOf = String.valueOf(obj);
        zzd(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), stringBuilder);
    }
}
