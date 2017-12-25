package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzab;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {

    class C34561 implements Runnable {
        final /* synthetic */ zzh f12853a;
        final /* synthetic */ Callable f12854b;

        C34561(zzh com_google_android_gms_tasks_zzh, Callable callable) {
            this.f12853a = com_google_android_gms_tasks_zzh;
            this.f12854b = callable;
        }

        public void run() {
            try {
                this.f12853a.setResult(this.f12854b.call());
            } catch (Exception e) {
                this.f12853a.setException(e);
            }
        }
    }

    interface zzb extends OnFailureListener, OnSuccessListener<Object> {
    }

    private static final class zza implements zzb {
        private final CountDownLatch f12855a;

        private zza() {
            this.f12855a = new CountDownLatch(1);
        }

        public void await() {
            this.f12855a.await();
        }

        public boolean await(long j, TimeUnit timeUnit) {
            return this.f12855a.await(j, timeUnit);
        }

        public void onFailure(Exception exception) {
            this.f12855a.countDown();
        }

        public void onSuccess(Object obj) {
            this.f12855a.countDown();
        }
    }

    private static final class zzc implements zzb {
        private final Object f12856a = new Object();
        private final int f12857b;
        private final zzh<Void> f12858c;
        private int f12859d;
        private int f12860e;
        private Exception f12861f;

        public zzc(int i, zzh<Void> com_google_android_gms_tasks_zzh_java_lang_Void) {
            this.f12857b = i;
            this.f12858c = com_google_android_gms_tasks_zzh_java_lang_Void;
        }

        private void m18277a() {
            if (this.f12859d + this.f12860e != this.f12857b) {
                return;
            }
            if (this.f12861f == null) {
                this.f12858c.setResult(null);
                return;
            }
            zzh com_google_android_gms_tasks_zzh = this.f12858c;
            int i = this.f12860e;
            com_google_android_gms_tasks_zzh.setException(new ExecutionException(i + " out of " + this.f12857b + " underlying tasks failed", this.f12861f));
        }

        public void onFailure(Exception exception) {
            synchronized (this.f12856a) {
                this.f12860e++;
                this.f12861f = exception;
                m18277a();
            }
        }

        public void onSuccess(Object obj) {
            synchronized (this.f12856a) {
                this.f12859d++;
                m18277a();
            }
        }
    }

    private Tasks() {
    }

    private static <TResult> TResult m18278a(Task<TResult> task) {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    private static void m18279a(Task<?> task, zzb com_google_android_gms_tasks_Tasks_zzb) {
        task.addOnSuccessListener(TaskExecutors.f12852a, (OnSuccessListener) com_google_android_gms_tasks_Tasks_zzb);
        task.addOnFailureListener(TaskExecutors.f12852a, (OnFailureListener) com_google_android_gms_tasks_Tasks_zzb);
    }

    public static <TResult> TResult await(Task<TResult> task) {
        zzab.zzate();
        zzab.zzb((Object) task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return m18278a(task);
        }
        Object com_google_android_gms_tasks_Tasks_zza = new zza();
        m18279a(task, com_google_android_gms_tasks_Tasks_zza);
        com_google_android_gms_tasks_Tasks_zza.await();
        return m18278a(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) {
        zzab.zzate();
        zzab.zzb((Object) task, (Object) "Task must not be null");
        zzab.zzb((Object) timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return m18278a(task);
        }
        Object com_google_android_gms_tasks_Tasks_zza = new zza();
        m18279a(task, com_google_android_gms_tasks_Tasks_zza);
        if (com_google_android_gms_tasks_Tasks_zza.await(j, timeUnit)) {
            return m18278a(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(Executor executor, Callable<TResult> callable) {
        zzab.zzb((Object) executor, (Object) "Executor must not be null");
        zzab.zzb((Object) callable, (Object) "Callback must not be null");
        Task com_google_android_gms_tasks_zzh = new zzh();
        executor.execute(new C34561(com_google_android_gms_tasks_zzh, callable));
        return com_google_android_gms_tasks_zzh;
    }

    public static <TResult> Task<TResult> forException(Exception exception) {
        Task com_google_android_gms_tasks_zzh = new zzh();
        com_google_android_gms_tasks_zzh.setException(exception);
        return com_google_android_gms_tasks_zzh;
    }

    public static <TResult> Task<TResult> forResult(TResult tResult) {
        Task com_google_android_gms_tasks_zzh = new zzh();
        com_google_android_gms_tasks_zzh.setResult(tResult);
        return com_google_android_gms_tasks_zzh;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult(null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        Task com_google_android_gms_tasks_zzh = new zzh();
        zzb com_google_android_gms_tasks_Tasks_zzc = new zzc(collection.size(), com_google_android_gms_tasks_zzh);
        for (Task task2 : collection) {
            m18279a(task2, com_google_android_gms_tasks_Tasks_zzc);
        }
        return com_google_android_gms_tasks_zzh;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        return taskArr.length == 0 ? forResult(null) : whenAll(Arrays.asList(taskArr));
    }
}
