package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class zzw extends zzaa {
    private static final AtomicLong f12367k = new AtomicLong(Long.MIN_VALUE);
    private zzd f12368a;
    private zzd f12369c;
    private final PriorityBlockingQueue<FutureTask<?>> f12370d = new PriorityBlockingQueue();
    private final BlockingQueue<FutureTask<?>> f12371e = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler f12372f = new zzb(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler f12373g = new zzb(this, "Thread death: Uncaught exception on network thread");
    private final Object f12374h = new Object();
    private final Semaphore f12375i = new Semaphore(2);
    private volatile boolean f12376j;

    static class zza extends RuntimeException {
    }

    private final class zzb implements UncaughtExceptionHandler {
        final /* synthetic */ zzw f12358a;
        private final String f12359b;

        public zzb(zzw com_google_android_gms_measurement_internal_zzw, String str) {
            this.f12358a = com_google_android_gms_measurement_internal_zzw;
            zzab.zzy(str);
            this.f12359b = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            this.f12358a.zzbsd().zzbsv().zzj(this.f12359b, th);
        }
    }

    private final class zzc<V> extends FutureTask<V> implements Comparable<zzc> {
        final /* synthetic */ zzw f12360a;
        private final long f12361b = zzw.f12367k.getAndIncrement();
        private final boolean f12362c;
        private final String f12363d;

        zzc(zzw com_google_android_gms_measurement_internal_zzw, Runnable runnable, boolean z, String str) {
            this.f12360a = com_google_android_gms_measurement_internal_zzw;
            super(runnable, null);
            zzab.zzy(str);
            this.f12363d = str;
            this.f12362c = z;
            if (this.f12361b == Long.MAX_VALUE) {
                com_google_android_gms_measurement_internal_zzw.zzbsd().zzbsv().log("Tasks index overflow");
            }
        }

        zzc(zzw com_google_android_gms_measurement_internal_zzw, Callable<V> callable, boolean z, String str) {
            this.f12360a = com_google_android_gms_measurement_internal_zzw;
            super(callable);
            zzab.zzy(str);
            this.f12363d = str;
            this.f12362c = z;
            if (this.f12361b == Long.MAX_VALUE) {
                com_google_android_gms_measurement_internal_zzw.zzbsd().zzbsv().log("Tasks index overflow");
            }
        }

        public /* synthetic */ int compareTo(Object obj) {
            return zzb((zzc) obj);
        }

        protected void setException(Throwable th) {
            this.f12360a.zzbsd().zzbsv().zzj(this.f12363d, th);
            if (th instanceof zza) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }

        public int zzb(zzc com_google_android_gms_measurement_internal_zzw_zzc) {
            if (this.f12362c != com_google_android_gms_measurement_internal_zzw_zzc.f12362c) {
                return this.f12362c ? -1 : 1;
            } else {
                if (this.f12361b < com_google_android_gms_measurement_internal_zzw_zzc.f12361b) {
                    return -1;
                }
                if (this.f12361b > com_google_android_gms_measurement_internal_zzw_zzc.f12361b) {
                    return 1;
                }
                this.f12360a.zzbsd().zzbsw().zzj("Two tasks share the same index. index", Long.valueOf(this.f12361b));
                return 0;
            }
        }
    }

    private final class zzd extends Thread {
        final /* synthetic */ zzw f12364a;
        private final Object f12365b = new Object();
        private final BlockingQueue<FutureTask<?>> f12366c;

        public zzd(zzw com_google_android_gms_measurement_internal_zzw, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.f12364a = com_google_android_gms_measurement_internal_zzw;
            zzab.zzy(str);
            zzab.zzy(blockingQueue);
            this.f12366c = blockingQueue;
            setName(str);
        }

        private void m17949a(InterruptedException interruptedException) {
            this.f12364a.zzbsd().zzbsx().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        public void run() {
            Object obj = null;
            while (obj == null) {
                try {
                    this.f12364a.f12375i.acquire();
                    obj = 1;
                } catch (InterruptedException e) {
                    m17949a(e);
                }
            }
            while (true) {
                try {
                    FutureTask futureTask = (FutureTask) this.f12366c.poll();
                    if (futureTask != null) {
                        futureTask.run();
                    } else {
                        synchronized (this.f12365b) {
                            if (this.f12366c.peek() == null && !this.f12364a.f12376j) {
                                try {
                                    this.f12365b.wait(30000);
                                } catch (InterruptedException e2) {
                                    m17949a(e2);
                                }
                            }
                        }
                        synchronized (this.f12364a.f12374h) {
                            if (this.f12366c.peek() == null) {
                                break;
                            }
                        }
                    }
                } catch (Throwable th) {
                    synchronized (this.f12364a.f12374h) {
                        this.f12364a.f12375i.release();
                        this.f12364a.f12374h.notifyAll();
                        if (this == this.f12364a.f12368a) {
                            this.f12364a.f12368a = null;
                        } else if (this == this.f12364a.f12369c) {
                            this.f12364a.f12369c = null;
                        } else {
                            this.f12364a.zzbsd().zzbsv().log("Current scheduler thread is neither worker nor network");
                        }
                    }
                }
            }
            synchronized (this.f12364a.f12374h) {
                this.f12364a.f12375i.release();
                this.f12364a.f12374h.notifyAll();
                if (this == this.f12364a.f12368a) {
                    this.f12364a.f12368a = null;
                } else if (this == this.f12364a.f12369c) {
                    this.f12364a.f12369c = null;
                } else {
                    this.f12364a.zzbsd().zzbsv().log("Current scheduler thread is neither worker nor network");
                }
            }
        }

        public void zznk() {
            synchronized (this.f12365b) {
                this.f12365b.notifyAll();
            }
        }
    }

    zzw(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private void m17952a(zzc<?> com_google_android_gms_measurement_internal_zzw_zzc_) {
        synchronized (this.f12374h) {
            this.f12370d.add(com_google_android_gms_measurement_internal_zzw_zzc_);
            if (this.f12368a == null) {
                this.f12368a = new zzd(this, "Measurement Worker", this.f12370d);
                this.f12368a.setUncaughtExceptionHandler(this.f12372f);
                this.f12368a.start();
            } else {
                this.f12368a.zznk();
            }
        }
    }

    private void m17953a(FutureTask<?> futureTask) {
        synchronized (this.f12374h) {
            this.f12371e.add(futureTask);
            if (this.f12369c == null) {
                this.f12369c = new zzd(this, "Measurement Network", this.f12371e);
                this.f12369c.setUncaughtExceptionHandler(this.f12373g);
                this.f12369c.start();
            } else {
                this.f12369c.zznk();
            }
        }
    }

    protected void mo2375d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzbrs() {
        if (Thread.currentThread() != this.f12369c) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ zzc zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public <V> Future<V> zzd(Callable<V> callable) {
        m17715c();
        zzab.zzy(callable);
        zzc com_google_android_gms_measurement_internal_zzw_zzc = new zzc(this, (Callable) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f12368a) {
            com_google_android_gms_measurement_internal_zzw_zzc.run();
        } else {
            m17952a(com_google_android_gms_measurement_internal_zzw_zzc);
        }
        return com_google_android_gms_measurement_internal_zzw_zzc;
    }

    public <V> Future<V> zze(Callable<V> callable) {
        m17715c();
        zzab.zzy(callable);
        zzc com_google_android_gms_measurement_internal_zzw_zzc = new zzc(this, (Callable) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f12368a) {
            com_google_android_gms_measurement_internal_zzw_zzc.run();
        } else {
            m17952a(com_google_android_gms_measurement_internal_zzw_zzc);
        }
        return com_google_android_gms_measurement_internal_zzw_zzc;
    }

    public void zzm(Runnable runnable) {
        m17715c();
        zzab.zzy(runnable);
        m17952a(new zzc(this, runnable, false, "Task exception on worker thread"));
    }

    public void zzn(Runnable runnable) {
        m17715c();
        zzab.zzy(runnable);
        m17953a(new zzc(this, runnable, false, "Task exception on network thread"));
    }

    public void zzwu() {
        if (Thread.currentThread() != this.f12368a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
