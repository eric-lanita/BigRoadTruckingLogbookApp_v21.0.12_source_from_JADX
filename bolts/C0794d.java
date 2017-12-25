package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class C0794d {
    private static final C0794d f2383a = new C0794d();
    private final ExecutorService f2384b;
    private final ScheduledExecutorService f2385c;
    private final Executor f2386d;

    private static class C0793a implements Executor {
        private ThreadLocal<Integer> f2382a;

        private C0793a() {
            this.f2382a = new ThreadLocal();
        }

        private int m3970a() {
            Integer num = (Integer) this.f2382a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() + 1;
            this.f2382a.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int m3971b() {
            Integer num = (Integer) this.f2382a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f2382a.remove();
            } else {
                this.f2382a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (m3970a() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    m3971b();
                }
            } else {
                C0794d.m3972a().execute(runnable);
            }
            m3971b();
        }
    }

    private static boolean m3974c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private C0794d() {
        this.f2384b = !C0794d.m3974c() ? Executors.newCachedThreadPool() : C0788a.m3965a();
        this.f2385c = Executors.newSingleThreadScheduledExecutor();
        this.f2386d = new C0793a();
    }

    public static ExecutorService m3972a() {
        return f2383a.f2384b;
    }

    static Executor m3973b() {
        return f2383a.f2386d;
    }
}
