package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzqk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult> extends Task<TResult> {
    private final Object f12891a = new Object();
    private final zzg<TResult> f12892b = new zzg();
    private boolean f12893c;
    private TResult f12894d;
    private Exception f12895e;

    private static class zza extends zzqj {
        private final List<WeakReference<zzf<?>>> f12890a = new ArrayList();

        private zza(zzqk com_google_android_gms_internal_zzqk) {
            super(com_google_android_gms_internal_zzqk);
            this.d.zza("TaskOnStopCallback", (zzqj) this);
        }

        public static zza zzv(Activity activity) {
            zzqk a = zzqj.m17359a(activity);
            zza com_google_android_gms_tasks_zzh_zza = (zza) a.zza("TaskOnStopCallback", zza.class);
            return com_google_android_gms_tasks_zzh_zza == null ? new zza(a) : com_google_android_gms_tasks_zzh_zza;
        }

        public void onStop() {
            synchronized (this.f12890a) {
                for (WeakReference weakReference : this.f12890a) {
                    zzf com_google_android_gms_tasks_zzf = (zzf) weakReference.get();
                    if (com_google_android_gms_tasks_zzf != null) {
                        com_google_android_gms_tasks_zzf.cancel();
                    }
                }
                this.f12890a.clear();
            }
        }

        public <T> void zzb(zzf<T> com_google_android_gms_tasks_zzf_T) {
            synchronized (this.f12890a) {
                this.f12890a.add(new WeakReference(com_google_android_gms_tasks_zzf_T));
            }
        }
    }

    zzh() {
    }

    private void m18290a() {
        zzab.zza(this.f12893c, (Object) "Task is not yet complete");
    }

    private void m18291b() {
        zzab.zza(!this.f12893c, (Object) "Task is already complete");
    }

    private void m18292c() {
        synchronized (this.f12891a) {
            if (this.f12893c) {
                this.f12892b.zza((Task) this);
                return;
            }
        }
    }

    public Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        zzf com_google_android_gms_tasks_zzc = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.f12892b.zza(com_google_android_gms_tasks_zzc);
        zza.zzv(activity).zzb(com_google_android_gms_tasks_zzc);
        m18292c();
        return this;
    }

    public Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, (OnCompleteListener) onCompleteListener);
    }

    public Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f12892b.zza(new zzc(executor, onCompleteListener));
        m18292c();
        return this;
    }

    public Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        zzf com_google_android_gms_tasks_zzd = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.f12892b.zza(com_google_android_gms_tasks_zzd);
        zza.zzv(activity).zzb(com_google_android_gms_tasks_zzd);
        m18292c();
        return this;
    }

    public Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    public Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.f12892b.zza(new zzd(executor, onFailureListener));
        m18292c();
        return this;
    }

    public Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        zzf com_google_android_gms_tasks_zze = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.f12892b.zza(com_google_android_gms_tasks_zze);
        zza.zzv(activity).zzb(com_google_android_gms_tasks_zze);
        m18292c();
        return this;
    }

    public Task<TResult> addOnSuccessListener(OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener) onSuccessListener);
    }

    public Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f12892b.zza(new zze(executor, onSuccessListener));
        m18292c();
        return this;
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        Task com_google_android_gms_tasks_zzh = new zzh();
        this.f12892b.zza(new zza(executor, continuation, com_google_android_gms_tasks_zzh));
        m18292c();
        return com_google_android_gms_tasks_zzh;
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        Task com_google_android_gms_tasks_zzh = new zzh();
        this.f12892b.zza(new zzb(executor, continuation, com_google_android_gms_tasks_zzh));
        m18292c();
        return com_google_android_gms_tasks_zzh;
    }

    public Exception getException() {
        Exception exception;
        synchronized (this.f12891a) {
            exception = this.f12895e;
        }
        return exception;
    }

    public TResult getResult() {
        TResult tResult;
        synchronized (this.f12891a) {
            m18290a();
            if (this.f12895e != null) {
                throw new RuntimeExecutionException(this.f12895e);
            }
            tResult = this.f12894d;
        }
        return tResult;
    }

    public <X extends Throwable> TResult getResult(Class<X> cls) {
        TResult tResult;
        synchronized (this.f12891a) {
            m18290a();
            if (cls.isInstance(this.f12895e)) {
                throw ((Throwable) cls.cast(this.f12895e));
            } else if (this.f12895e != null) {
                throw new RuntimeExecutionException(this.f12895e);
            } else {
                tResult = this.f12894d;
            }
        }
        return tResult;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.f12891a) {
            z = this.f12893c;
        }
        return z;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.f12891a) {
            z = this.f12893c && this.f12895e == null;
        }
        return z;
    }

    public void setException(Exception exception) {
        zzab.zzb((Object) exception, (Object) "Exception must not be null");
        synchronized (this.f12891a) {
            m18291b();
            this.f12893c = true;
            this.f12895e = exception;
        }
        this.f12892b.zza((Task) this);
    }

    public void setResult(TResult tResult) {
        synchronized (this.f12891a) {
            m18291b();
            this.f12893c = true;
            this.f12894d = tResult;
        }
        this.f12892b.zza((Task) this);
    }
}
