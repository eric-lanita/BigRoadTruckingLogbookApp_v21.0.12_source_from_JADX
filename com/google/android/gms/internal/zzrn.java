package com.google.android.gms.internal;

import android.os.Process;

class zzrn implements Runnable {
    private final Runnable f11735a;
    private final int f11736b;

    public zzrn(Runnable runnable, int i) {
        this.f11735a = runnable;
        this.f11736b = i;
    }

    public void run() {
        Process.setThreadPriority(this.f11736b);
        this.f11735a.run();
    }
}
