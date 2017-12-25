package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new zza();
    static final Executor f12852a = new C34551();

    class C34551 implements Executor {
        C34551() {
        }

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private static final class zza implements Executor {
        private final Handler f12851a = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f12851a.post(runnable);
        }
    }

    private TaskExecutors() {
    }
}
