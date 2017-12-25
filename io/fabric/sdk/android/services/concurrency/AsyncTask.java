package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final int f14058a = Runtime.getRuntime().availableProcessors();
    public static final Executor f14059b = new ThreadPoolExecutor(f14061d, f14062e, 1, TimeUnit.SECONDS, f14064g, f14063f);
    public static final Executor f14060c = new C4026c();
    private static final int f14061d = (f14058a + 1);
    private static final int f14062e = ((f14058a * 2) + 1);
    private static final ThreadFactory f14063f = new C40181();
    private static final BlockingQueue<Runnable> f14064g = new LinkedBlockingQueue(128);
    private static final C4024b f14065h = new C4024b();
    private static volatile Executor f14066i = f14060c;
    private final C4019d<Params, Result> f14067j = new C40202(this);
    private final FutureTask<Result> f14068k = new FutureTask<Result>(this, this.f14067j) {
        final /* synthetic */ AsyncTask f14197a;

        protected void done() {
            try {
                this.f14197a.m20601d(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f14197a.m20601d(null);
            }
        }
    };
    private volatile Status f14069l = Status.PENDING;
    private final AtomicBoolean f14070m = new AtomicBoolean();
    private final AtomicBoolean f14071n = new AtomicBoolean();

    static class C40181 implements ThreadFactory {
        private final AtomicInteger f14194a = new AtomicInteger(1);

        C40181() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f14194a.getAndIncrement());
        }
    }

    private static abstract class C4019d<Params, Result> implements Callable<Result> {
        Params[] f14195b;

        private C4019d() {
        }
    }

    class C40202 extends C4019d<Params, Result> {
        final /* synthetic */ AsyncTask f14196a;

        C40202(AsyncTask asyncTask) {
            this.f14196a = asyncTask;
            super();
        }

        public Result call() {
            this.f14196a.f14071n.set(true);
            Process.setThreadPriority(10);
            return this.f14196a.m20602e(this.f14196a.mo2860a(this.b));
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static class C4023a<Data> {
        final AsyncTask f14203a;
        final Data[] f14204b;

        C4023a(AsyncTask asyncTask, Data... dataArr) {
            this.f14203a = asyncTask;
            this.f14204b = dataArr;
        }
    }

    private static class C4024b extends Handler {
        public C4024b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C4023a c4023a = (C4023a) message.obj;
            switch (message.what) {
                case 1:
                    c4023a.f14203a.m20603f(c4023a.f14204b[0]);
                    return;
                case 2:
                    c4023a.f14203a.m20610b(c4023a.f14204b);
                    return;
                default:
                    return;
            }
        }
    }

    private static class C4026c implements Executor {
        final LinkedList<Runnable> f14207a;
        Runnable f14208b;

        private C4026c() {
            this.f14207a = new LinkedList();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f14207a.offer(new Runnable(this) {
                final /* synthetic */ C4026c f14206b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f14206b.m20820a();
                    }
                }
            });
            if (this.f14208b == null) {
                m20820a();
            }
        }

        protected synchronized void m20820a() {
            Runnable runnable = (Runnable) this.f14207a.poll();
            this.f14208b = runnable;
            if (runnable != null) {
                AsyncTask.f14059b.execute(this.f14208b);
            }
        }
    }

    protected abstract Result mo2860a(Params... paramsArr);

    private void m20601d(Result result) {
        if (!this.f14071n.get()) {
            m20602e(result);
        }
    }

    private Result m20602e(Result result) {
        f14065h.obtainMessage(1, new C4023a(this, result)).sendToTarget();
        return result;
    }

    public final Status i_() {
        return this.f14069l;
    }

    protected void mo2861a() {
    }

    protected void mo2862a(Result result) {
    }

    protected void m20610b(Progress... progressArr) {
    }

    protected void mo2863b(Result result) {
        j_();
    }

    protected void j_() {
    }

    public final boolean m20611e() {
        return this.f14070m.get();
    }

    public final boolean m20608a(boolean z) {
        this.f14070m.set(true);
        return this.f14068k.cancel(z);
    }

    public final AsyncTask<Params, Progress, Result> m20604a(Executor executor, Params... paramsArr) {
        if (this.f14069l != Status.PENDING) {
            switch (this.f14069l) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f14069l = Status.RUNNING;
        mo2861a();
        this.f14067j.f14195b = paramsArr;
        executor.execute(this.f14068k);
        return this;
    }

    private void m20603f(Result result) {
        if (m20611e()) {
            mo2863b((Object) result);
        } else {
            mo2862a((Object) result);
        }
        this.f14069l = Status.FINISHED;
    }
}
