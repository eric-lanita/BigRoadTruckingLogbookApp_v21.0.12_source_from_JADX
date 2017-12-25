package io.fabric.sdk.android.services.concurrency;

import android.annotation.TargetApi;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class C4036h extends ThreadPoolExecutor {
    private static final int f14225a = Runtime.getRuntime().availableProcessors();
    private static final int f14226b = (f14225a + 1);
    private static final int f14227c = ((f14225a * 2) + 1);

    protected static final class C4035a implements ThreadFactory {
        private final int f14224a;

        public C4035a(int i) {
            this.f14224a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f14224a);
            thread.setName("Queue");
            return thread;
        }
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return m20851b();
    }

    <T extends Runnable & C2927a & C2929i & C2928f> C4036h(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & C2927a & C2929i & C2928f> C4036h m20850a(int i, int i2) {
        return new C4036h(i, i2, 1, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new C4035a(10));
    }

    public static C4036h m20849a() {
        return C4036h.m20850a(f14226b, f14227c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C4032e(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C4032e(callable);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (C2930g.m16369a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        C2929i c2929i = (C2929i) runnable;
        c2929i.mo1476b(true);
        c2929i.mo1474a(th);
        m20851b().m20830d();
        super.afterExecute(runnable, th);
    }

    public DependencyPriorityBlockingQueue m20851b() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }
}
