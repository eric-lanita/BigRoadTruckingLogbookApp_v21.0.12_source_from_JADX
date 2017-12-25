package io.fabric.sdk.android.services.common;

import android.os.Process;

public abstract class C2888h implements Runnable {
    protected abstract void mo1461a();

    public final void run() {
        Process.setThreadPriority(10);
        mo1461a();
    }
}
