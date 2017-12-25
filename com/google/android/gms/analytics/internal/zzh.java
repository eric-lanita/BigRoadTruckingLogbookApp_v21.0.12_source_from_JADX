package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh {
    private final long f10319a;
    private final String f10320b;
    private final String f10321c;
    private final boolean f10322d;
    private long f10323e;
    private final Map<String, String> f10324f;

    public zzh(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        zzab.zzhr(str);
        zzab.zzhr(str2);
        this.f10319a = j;
        this.f10320b = str;
        this.f10321c = str2;
        this.f10322d = z;
        this.f10323e = j2;
        if (map != null) {
            this.f10324f = new HashMap(map);
        } else {
            this.f10324f = Collections.emptyMap();
        }
    }

    public Map<String, String> zzm() {
        return this.f10324f;
    }

    public void zzp(long j) {
        this.f10323e = j;
    }

    public String zzwb() {
        return this.f10320b;
    }

    public long zzzo() {
        return this.f10319a;
    }

    public String zzzp() {
        return this.f10321c;
    }

    public boolean zzzq() {
        return this.f10322d;
    }

    public long zzzr() {
        return this.f10323e;
    }
}
