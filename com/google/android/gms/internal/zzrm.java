package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzrm implements ThreadFactory {
    private final String f11731a;
    private final int f11732b;
    private final AtomicInteger f11733c;
    private final ThreadFactory f11734d;

    public zzrm(String str) {
        this(str, 0);
    }

    public zzrm(String str, int i) {
        this.f11733c = new AtomicInteger();
        this.f11734d = Executors.defaultThreadFactory();
        this.f11731a = (String) zzab.zzb((Object) str, (Object) "Name must not be null");
        this.f11732b = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f11734d.newThread(new zzrn(runnable, this.f11732b));
        String str = this.f11731a;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f11733c.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
