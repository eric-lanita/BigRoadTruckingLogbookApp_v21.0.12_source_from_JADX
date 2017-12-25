package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpm.zza;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqd;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzc<O extends ApiOptions> {
    private final Context f10563a;
    private final zzqo f10564b;
    private final Api<O> f10565c;
    private final O f10566d;
    private final zzpj<O> f10567e;
    private final Looper f10568f;
    private final int f10569g;
    private final zzqc f10570h;
    private final GoogleApiClient f10571i;
    private final AtomicBoolean f10572j;
    private final AtomicInteger f10573k;

    public zzc(Context context, Api<O> api, O o) {
        this(context, api, o, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    public zzc(Context context, Api<O> api, O o, Looper looper) {
        this.f10572j = new AtomicBoolean(false);
        this.f10573k = new AtomicInteger(0);
        zzab.zzb((Object) context, (Object) "Null context is not permitted.");
        zzab.zzb((Object) api, (Object) "Api must not be null.");
        zzab.zzb((Object) looper, (Object) "Looper must not be null.");
        this.f10563a = context.getApplicationContext();
        this.f10565c = api;
        this.f10566d = o;
        this.f10568f = looper;
        this.f10564b = new zzqo();
        this.f10567e = new zzpj(this.f10565c, this.f10566d);
        this.f10571i = new zzqd(this);
        Pair zza = zzqc.zza(this.f10563a, this);
        this.f10570h = (zzqc) zza.first;
        this.f10569g = ((Integer) zza.second).intValue();
    }

    private <A extends zzb, T extends zza<? extends Result, A>> T m16808a(int i, T t) {
        t.zzaow();
        this.f10570h.zza(this, i, t);
        return t;
    }

    private <TResult, A extends zzb> Task<TResult> m16809a(int i, zzqw<A, TResult> com_google_android_gms_internal_zzqw_A__TResult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f10570h.zza(this, i, com_google_android_gms_internal_zzqw_A__TResult, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public Context getApplicationContext() {
        return this.f10563a;
    }

    public int getInstanceId() {
        return this.f10569g;
    }

    public Looper getLooper() {
        return this.f10568f;
    }

    public void release() {
        boolean z = true;
        if (!this.f10572j.getAndSet(true)) {
            this.f10564b.release();
            zzqc com_google_android_gms_internal_zzqc = this.f10570h;
            int i = this.f10569g;
            if (this.f10573k.get() <= 0) {
                z = false;
            }
            com_google_android_gms_internal_zzqc.zzd(i, z);
        }
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zza(T t) {
        return m16808a(0, (zza) t);
    }

    public <TResult, A extends zzb> Task<TResult> zza(zzqw<A, TResult> com_google_android_gms_internal_zzqw_A__TResult) {
        return m16809a(0, (zzqw) com_google_android_gms_internal_zzqw_A__TResult);
    }

    public void zzanx() {
        this.f10573k.incrementAndGet();
    }

    public void zzany() {
        if (this.f10573k.decrementAndGet() == 0 && this.f10572j.get()) {
            this.f10570h.zzd(this.f10569g, false);
        }
    }

    public Api<O> zzanz() {
        return this.f10565c;
    }

    public O zzaoa() {
        return this.f10566d;
    }

    public zzpj<O> zzaob() {
        return this.f10567e;
    }

    public GoogleApiClient zzaoc() {
        return this.f10571i;
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzb(T t) {
        return m16808a(1, (zza) t);
    }

    public <TResult, A extends zzb> Task<TResult> zzb(zzqw<A, TResult> com_google_android_gms_internal_zzqw_A__TResult) {
        return m16809a(1, (zzqw) com_google_android_gms_internal_zzqw_A__TResult);
    }
}
