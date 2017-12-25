package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzt;
import java.util.HashSet;
import java.util.Set;

public class zzr {
    private final zzf f10372a;
    private volatile Boolean f10373b;
    private String f10374c;
    private Set<Integer> f10375d;

    protected zzr(zzf com_google_android_gms_analytics_internal_zzf) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzf);
        this.f10372a = com_google_android_gms_analytics_internal_zzf;
    }

    public boolean zzabc() {
        return false;
    }

    public boolean zzabd() {
        if (this.f10373b == null) {
            synchronized (this) {
                if (this.f10373b == null) {
                    ApplicationInfo applicationInfo = this.f10372a.getContext().getApplicationInfo();
                    String zzawa = zzt.zzawa();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzawa);
                        this.f10373b = Boolean.valueOf(z);
                    }
                    if ((this.f10373b == null || !this.f10373b.booleanValue()) && "com.google.android.gms.analytics".equals(zzawa)) {
                        this.f10373b = Boolean.TRUE;
                    }
                    if (this.f10373b == null) {
                        this.f10373b = Boolean.TRUE;
                        this.f10372a.zzyx().zzel("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f10373b.booleanValue();
    }

    public boolean zzabe() {
        return ((Boolean) zzy.zzczm.get()).booleanValue();
    }

    public int zzabf() {
        return ((Integer) zzy.f10393f.get()).intValue();
    }

    public int zzabg() {
        return ((Integer) zzy.f10397j.get()).intValue();
    }

    public int zzabh() {
        return ((Integer) zzy.f10398k.get()).intValue();
    }

    public int zzabi() {
        return ((Integer) zzy.f10399l.get()).intValue();
    }

    public long zzabj() {
        return ((Long) zzy.zzczu.get()).longValue();
    }

    public long zzabk() {
        return ((Long) zzy.zzczt.get()).longValue();
    }

    public long zzabl() {
        return ((Long) zzy.zzczx.get()).longValue();
    }

    public long zzabm() {
        return ((Long) zzy.zzczy.get()).longValue();
    }

    public int zzabn() {
        return ((Integer) zzy.zzczz.get()).intValue();
    }

    public int zzabo() {
        return ((Integer) zzy.f10388a.get()).intValue();
    }

    public long zzabp() {
        return (long) ((Integer) zzy.f10401n.get()).intValue();
    }

    public String zzabq() {
        return (String) zzy.f10390c.get();
    }

    public String zzabr() {
        return (String) zzy.f10389b.get();
    }

    public String zzabs() {
        return (String) zzy.f10391d.get();
    }

    public String zzabt() {
        return (String) zzy.f10392e.get();
    }

    public zzm zzabu() {
        return zzm.zzeq((String) zzy.f10394g.get());
    }

    public zzo zzabv() {
        return zzo.zzer((String) zzy.f10395h.get());
    }

    public Set<Integer> zzabw() {
        String str = (String) zzy.f10400m.get();
        if (this.f10375d == null || this.f10374c == null || !this.f10374c.equals(str)) {
            String[] split = TextUtils.split(str, ",");
            Set hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.f10374c = str;
            this.f10375d = hashSet;
        }
        return this.f10375d;
    }

    public long zzabx() {
        return ((Long) zzy.f10409v.get()).longValue();
    }

    public long zzaby() {
        return ((Long) zzy.f10410w.get()).longValue();
    }

    public long zzabz() {
        return ((Long) zzy.f10385B.get()).longValue();
    }

    public int zzaca() {
        return ((Integer) zzy.zzczq.get()).intValue();
    }

    public int zzacb() {
        return ((Integer) zzy.zzczs.get()).intValue();
    }

    public String zzacc() {
        return "google_analytics_v4.db";
    }

    public String zzacd() {
        return "google_analytics2_v4.db";
    }

    public long zzace() {
        return 86400000;
    }

    public int zzacf() {
        return ((Integer) zzy.f10403p.get()).intValue();
    }

    public int zzacg() {
        return ((Integer) zzy.f10404q.get()).intValue();
    }

    public long zzach() {
        return ((Long) zzy.f10405r.get()).longValue();
    }

    public long zzaci() {
        return ((Long) zzy.f10386C.get()).longValue();
    }
}
