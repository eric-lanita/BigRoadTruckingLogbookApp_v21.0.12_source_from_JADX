package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzw;
import com.google.android.gms.common.util.zzz;

public class zzvw {
    private static String f11794a = "WakeLock";
    private static String f11795b = "*gcore*:";
    private static boolean f11796c = false;
    private final WakeLock f11797d;
    private WorkSource f11798e;
    private final int f11799f;
    private final String f11800g;
    private final String f11801h;
    private final String f11802i;
    private final Context f11803j;
    private boolean f11804k;
    private int f11805l;
    private int f11806m;

    public zzvw(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvw(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzvw(Context context, int i, String str, String str2, String str3, String str4) {
        this.f11804k = true;
        zzab.zzh(str, "Wake lock name can NOT be empty");
        this.f11799f = i;
        this.f11801h = str2;
        this.f11802i = str4;
        this.f11803j = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f11800g = str;
        } else {
            String valueOf = String.valueOf(f11795b);
            String valueOf2 = String.valueOf(str);
            this.f11800g = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.f11797d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzz.zzco(this.f11803j)) {
            if (zzw.zzib(str3)) {
                str3 = context.getPackageName();
            }
            this.f11798e = zzz.zzr(context, str3);
            zzc(this.f11798e);
        }
    }

    private String m17599a(String str, boolean z) {
        return this.f11804k ? z ? str : this.f11801h : this.f11801h;
    }

    private void m17600a(WorkSource workSource) {
        try {
            this.f11797d.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(f11794a, e.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17601a(java.lang.String r10) {
        /*
        r9 = this;
        r0 = r9.m17603b(r10);
        r5 = r9.m17599a(r10, r0);
        monitor-enter(r9);
        r1 = r9.f11804k;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r9.f11805l;	 Catch:{ all -> 0x0045 }
        r1 = r1 + -1;
        r9.f11805l = r1;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0020;
    L_0x0015:
        if (r0 != 0) goto L_0x0020;
    L_0x0017:
        r0 = r9.f11804k;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0043;
    L_0x001b:
        r0 = r9.f11806m;	 Catch:{ all -> 0x0045 }
        r1 = 1;
        if (r0 != r1) goto L_0x0043;
    L_0x0020:
        r0 = com.google.android.gms.common.stats.zzh.zzavi();	 Catch:{ all -> 0x0045 }
        r1 = r9.f11803j;	 Catch:{ all -> 0x0045 }
        r2 = r9.f11797d;	 Catch:{ all -> 0x0045 }
        r2 = com.google.android.gms.common.stats.zzf.zza(r2, r5);	 Catch:{ all -> 0x0045 }
        r3 = 8;
        r4 = r9.f11800g;	 Catch:{ all -> 0x0045 }
        r6 = r9.f11802i;	 Catch:{ all -> 0x0045 }
        r7 = r9.f11799f;	 Catch:{ all -> 0x0045 }
        r8 = r9.f11798e;	 Catch:{ all -> 0x0045 }
        r8 = com.google.android.gms.common.util.zzz.zzb(r8);	 Catch:{ all -> 0x0045 }
        r0.zza(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0045 }
        r0 = r9.f11806m;	 Catch:{ all -> 0x0045 }
        r0 = r0 + -1;
        r9.f11806m = r0;	 Catch:{ all -> 0x0045 }
    L_0x0043:
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        return;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzvw.a(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17602a(java.lang.String r13, long r14) {
        /*
        r12 = this;
        r0 = r12.m17603b(r13);
        r6 = r12.m17599a(r13, r0);
        monitor-enter(r12);
        r1 = r12.f11804k;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r12.f11805l;	 Catch:{ all -> 0x0044 }
        r2 = r1 + 1;
        r12.f11805l = r2;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x001f;
    L_0x0015:
        if (r0 != 0) goto L_0x001f;
    L_0x0017:
        r0 = r12.f11804k;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001b:
        r0 = r12.f11806m;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001f:
        r1 = com.google.android.gms.common.stats.zzh.zzavi();	 Catch:{ all -> 0x0044 }
        r2 = r12.f11803j;	 Catch:{ all -> 0x0044 }
        r0 = r12.f11797d;	 Catch:{ all -> 0x0044 }
        r3 = com.google.android.gms.common.stats.zzf.zza(r0, r6);	 Catch:{ all -> 0x0044 }
        r4 = 7;
        r5 = r12.f11800g;	 Catch:{ all -> 0x0044 }
        r7 = r12.f11802i;	 Catch:{ all -> 0x0044 }
        r8 = r12.f11799f;	 Catch:{ all -> 0x0044 }
        r0 = r12.f11798e;	 Catch:{ all -> 0x0044 }
        r9 = com.google.android.gms.common.util.zzz.zzb(r0);	 Catch:{ all -> 0x0044 }
        r10 = r14;
        r1.zza(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0044 }
        r0 = r12.f11806m;	 Catch:{ all -> 0x0044 }
        r0 = r0 + 1;
        r12.f11806m = r0;	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzvw.a(java.lang.String, long):void");
    }

    private boolean m17603b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.f11801h)) ? false : true;
    }

    public void acquire(long j) {
        if (!zzs.zzavq() && this.f11804k) {
            String str = f11794a;
            String str2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
            String valueOf = String.valueOf(this.f11800g);
            Log.wtf(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        m17602a(null, j);
        this.f11797d.acquire(j);
    }

    public boolean isHeld() {
        return this.f11797d.isHeld();
    }

    public void release() {
        m17601a(null);
        this.f11797d.release();
    }

    public void setReferenceCounted(boolean z) {
        this.f11797d.setReferenceCounted(z);
        this.f11804k = z;
    }

    public void zzc(WorkSource workSource) {
        if (workSource != null && zzz.zzco(this.f11803j)) {
            if (this.f11798e != null) {
                this.f11798e.add(workSource);
            } else {
                this.f11798e = workSource;
            }
            m17600a(this.f11798e);
        }
    }
}
