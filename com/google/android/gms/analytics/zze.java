package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zze {
    private final zzh f10423a;
    private final com.google.android.gms.common.util.zze f10424b;
    private boolean f10425c;
    private long f10426d;
    private long f10427e;
    private long f10428f;
    private long f10429g;
    private long f10430h;
    private boolean f10431i;
    private final Map<Class<? extends zzg>, zzg> f10432j;
    private final List<zzk> f10433k;

    zze(zze com_google_android_gms_analytics_zze) {
        this.f10423a = com_google_android_gms_analytics_zze.f10423a;
        this.f10424b = com_google_android_gms_analytics_zze.f10424b;
        this.f10426d = com_google_android_gms_analytics_zze.f10426d;
        this.f10427e = com_google_android_gms_analytics_zze.f10427e;
        this.f10428f = com_google_android_gms_analytics_zze.f10428f;
        this.f10429g = com_google_android_gms_analytics_zze.f10429g;
        this.f10430h = com_google_android_gms_analytics_zze.f10430h;
        this.f10433k = new ArrayList(com_google_android_gms_analytics_zze.f10433k);
        this.f10432j = new HashMap(com_google_android_gms_analytics_zze.f10432j.size());
        for (Entry entry : com_google_android_gms_analytics_zze.f10432j.entrySet()) {
            zzg a = m16742a((Class) entry.getKey());
            ((zzg) entry.getValue()).zzb(a);
            this.f10432j.put((Class) entry.getKey(), a);
        }
    }

    zze(zzh com_google_android_gms_analytics_zzh, com.google.android.gms.common.util.zze com_google_android_gms_common_util_zze) {
        zzab.zzy(com_google_android_gms_analytics_zzh);
        zzab.zzy(com_google_android_gms_common_util_zze);
        this.f10423a = com_google_android_gms_analytics_zzh;
        this.f10424b = com_google_android_gms_common_util_zze;
        this.f10429g = 1800000;
        this.f10430h = 3024000000L;
        this.f10432j = new HashMap();
        this.f10433k = new ArrayList();
    }

    private static <T extends zzg> T m16742a(Class<T> cls) {
        try {
            return (zzg) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    void m16743a() {
        this.f10428f = this.f10424b.elapsedRealtime();
        if (this.f10427e != 0) {
            this.f10426d = this.f10427e;
        } else {
            this.f10426d = this.f10424b.currentTimeMillis();
        }
        this.f10425c = true;
    }

    zzh m16744b() {
        return this.f10423a;
    }

    zzi m16745c() {
        return this.f10423a.m16519d();
    }

    boolean m16746d() {
        return this.f10431i;
    }

    void m16747e() {
        this.f10431i = true;
    }

    public <T extends zzg> T zza(Class<T> cls) {
        return (zzg) this.f10432j.get(cls);
    }

    public void zza(zzg com_google_android_gms_analytics_zzg) {
        zzab.zzy(com_google_android_gms_analytics_zzg);
        Class cls = com_google_android_gms_analytics_zzg.getClass();
        if (cls.getSuperclass() != zzg.class) {
            throw new IllegalArgumentException();
        }
        com_google_android_gms_analytics_zzg.zzb(zzb(cls));
    }

    public <T extends zzg> T zzb(Class<T> cls) {
        zzg com_google_android_gms_analytics_zzg = (zzg) this.f10432j.get(cls);
        if (com_google_android_gms_analytics_zzg != null) {
            return com_google_android_gms_analytics_zzg;
        }
        T a = m16742a(cls);
        this.f10432j.put(cls, a);
        return a;
    }

    public void zzn(long j) {
        this.f10427e = j;
    }

    public zze zzwf() {
        return new zze(this);
    }

    public Collection<zzg> zzwg() {
        return this.f10432j.values();
    }

    public List<zzk> zzwh() {
        return this.f10433k;
    }

    public long zzwi() {
        return this.f10426d;
    }

    public void zzwj() {
        m16745c().m16753a(this);
    }

    public boolean zzwk() {
        return this.f10425c;
    }
}
