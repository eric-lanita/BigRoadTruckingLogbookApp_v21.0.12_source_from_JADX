package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.p008d.C0269h;
import android.util.Log;

public class zze {
    private final long f10886a;
    private final int f10887b;
    private final C0269h<String, Long> f10888c;

    public zze() {
        this.f10886a = 60000;
        this.f10887b = 10;
        this.f10888c = new C0269h(10);
    }

    public zze(int i, long j) {
        this.f10886a = j;
        this.f10887b = i;
        this.f10888c = new C0269h();
    }

    private void m16997a(long j, long j2) {
        for (int size = this.f10888c.size() - 1; size >= 0; size--) {
            if (j2 - ((Long) this.f10888c.m1150c(size)).longValue() > j) {
                this.f10888c.m1151d(size);
            }
        }
    }

    public Long zzhx(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f10886a;
        synchronized (this) {
            while (this.f10888c.size() >= this.f10887b) {
                m16997a(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", "The max capacity " + this.f10887b + " is not enough. Current durationThreshold is: " + j);
            }
            l = (Long) this.f10888c.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public boolean zzhy(String str) {
        boolean z;
        synchronized (this) {
            z = this.f10888c.remove(str) != null;
        }
        return z;
    }
}
