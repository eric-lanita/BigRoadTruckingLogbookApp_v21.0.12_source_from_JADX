package bolts;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class C0788a {
    static final int f2370a = (f2373e + 1);
    static final int f2371b = ((f2373e * 2) + 1);
    private static final C0788a f2372c = new C0788a();
    private static final int f2373e = Runtime.getRuntime().availableProcessors();
    private final Executor f2374d = new C0787a();

    private static class C0787a implements Executor {
        private C0787a() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private C0788a() {
    }

    public static ExecutorService m3965a() {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(f2370a, f2371b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        C0788a.m3966a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    public static void m3966a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static Executor m3967b() {
        return f2372c.f2374d;
    }
}
