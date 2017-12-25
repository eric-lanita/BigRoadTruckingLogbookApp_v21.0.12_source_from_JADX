package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzab {
    private final Map<String, String> f10226a;
    private final List<Command> f10227b;
    private final long f10228c;
    private final long f10229d;
    private final int f10230e;
    private final boolean f10231f;
    private final String f10232g;

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z) {
        this(com_google_android_gms_analytics_internal_zzc, map, j, z, 0, 0, null);
    }

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(com_google_android_gms_analytics_internal_zzc, map, j, z, j2, i, null);
    }

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String a;
        com.google.android.gms.common.internal.zzab.zzy(com_google_android_gms_analytics_internal_zzc);
        com.google.android.gms.common.internal.zzab.zzy(map);
        this.f10229d = j;
        this.f10231f = z;
        this.f10228c = j2;
        this.f10230e = i;
        this.f10227b = list != null ? list : Collections.emptyList();
        this.f10232g = m16590a((List) list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (m16591a(entry.getKey())) {
                a = m16588a(com_google_android_gms_analytics_internal_zzc, entry.getKey());
                if (a != null) {
                    hashMap.put(a, m16592b(com_google_android_gms_analytics_internal_zzc, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!m16591a(entry2.getKey())) {
                a = m16588a(com_google_android_gms_analytics_internal_zzc, entry2.getKey());
                if (a != null) {
                    hashMap.put(a, m16592b(com_google_android_gms_analytics_internal_zzc, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.f10232g)) {
            zzao.zzc(hashMap, "_v", this.f10232g);
            if (this.f10232g.equals("ma4.0.0") || this.f10232g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.f10226a = Collections.unmodifiableMap(hashMap);
    }

    private static String m16588a(zzc com_google_android_gms_analytics_internal_zzc, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            com_google_android_gms_analytics_internal_zzc.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private String m16589a(String str, String str2) {
        com.google.android.gms.common.internal.zzab.zzhr(str);
        com.google.android.gms.common.internal.zzab.zzb(!str.startsWith("&"), (Object) "Short param name required");
        String str3 = (String) this.f10226a.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String m16590a(List<Command> list) {
        CharSequence value;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.getId())) {
                    value = command.getValue();
                    break;
                }
            }
        }
        value = null;
        return TextUtils.isEmpty(value) ? null : value;
    }

    private static boolean m16591a(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private static String m16592b(zzc com_google_android_gms_analytics_internal_zzc, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            return obj2;
        }
        obj2 = obj2.substring(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        com_google_android_gms_analytics_internal_zzc.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    public static zzab zza(zzc com_google_android_gms_analytics_internal_zzc, zzab com_google_android_gms_analytics_internal_zzab, Map<String, String> map) {
        return new zzab(com_google_android_gms_analytics_internal_zzc, map, com_google_android_gms_analytics_internal_zzab.zzacz(), com_google_android_gms_analytics_internal_zzab.zzadb(), com_google_android_gms_analytics_internal_zzab.zzacy(), com_google_android_gms_analytics_internal_zzab.zzacx(), com_google_android_gms_analytics_internal_zzab.zzada());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.f10229d);
        if (this.f10228c != 0) {
            stringBuffer.append(", dbId=").append(this.f10228c);
        }
        if (this.f10230e != 0) {
            stringBuffer.append(", appUID=").append(this.f10230e);
        }
        List<String> arrayList = new ArrayList(this.f10226a.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.f10226a.get(str));
        }
        return stringBuffer.toString();
    }

    public int zzacx() {
        return this.f10230e;
    }

    public long zzacy() {
        return this.f10228c;
    }

    public long zzacz() {
        return this.f10229d;
    }

    public List<Command> zzada() {
        return this.f10227b;
    }

    public boolean zzadb() {
        return this.f10231f;
    }

    public long zzadc() {
        return zzao.zzey(m16589a("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public String zzadd() {
        return m16589a("_m", "");
    }

    public Map<String, String> zzm() {
        return this.f10226a;
    }
}
