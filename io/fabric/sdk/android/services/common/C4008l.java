package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.C3969c;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class C4008l {
    public static ExecutorService m20779a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C4008l.m20783c(str));
        C4008l.m20780a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService m20782b(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(C4008l.m20783c(str));
        C4008l.m20780a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory m20783c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new C2888h(this) {
                    final /* synthetic */ C40061 f14163b;

                    public void mo1461a() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    private static final void m20780a(String str, ExecutorService executorService) {
        C4008l.m20781a(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void m20781a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        Runtime.getRuntime().addShutdownHook(new Thread(new C2888h() {
            public void mo1461a() {
                try {
                    C3969c.m20576h().mo2849a("Fabric", "Executing shutdown hook for " + str2);
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        C3969c.m20576h().mo2849a("Fabric", str2 + " did not shut down in the allocated time. Requesting immediate shutdown.");
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    C3969c.m20576h().mo2849a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        }, "Crashlytics Shutdown Hook for " + str));
    }
}
