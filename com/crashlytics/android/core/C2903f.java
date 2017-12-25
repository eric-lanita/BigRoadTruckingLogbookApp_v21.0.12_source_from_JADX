package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.C3969c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class C2903f {
    private final ExecutorService f9994a;

    public C2903f(ExecutorService executorService) {
        this.f9994a = executorService;
    }

    <T> T m16273a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f9994a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f9994a.submit(callable).get();
        } catch (RejectedExecutionException e) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> m16274a(final Runnable runnable) {
        try {
            return this.f9994a.submit(new Runnable(this) {
                final /* synthetic */ C2903f f9991b;

                public void run() {
                    try {
                        runnable.run();
                    } catch (Throwable e) {
                        C3969c.m20576h().mo2857e("CrashlyticsCore", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> m16275b(final Callable<T> callable) {
        try {
            return this.f9994a.submit(new Callable<T>(this) {
                final /* synthetic */ C2903f f9993b;

                public T call() {
                    try {
                        return callable.call();
                    } catch (Throwable e) {
                        C3969c.m20576h().mo2857e("CrashlyticsCore", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
