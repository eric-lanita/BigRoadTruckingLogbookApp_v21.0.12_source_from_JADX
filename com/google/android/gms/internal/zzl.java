package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl {
    private AtomicInteger f11402a;
    private final Map<String, Queue<zzk<?>>> f11403b;
    private final Set<zzk<?>> f11404c;
    private final PriorityBlockingQueue<zzk<?>> f11405d;
    private final PriorityBlockingQueue<zzk<?>> f11406e;
    private final zzb f11407f;
    private final zzf f11408g;
    private final zzn f11409h;
    private zzg[] f11410i;
    private zzc f11411j;
    private List<zza> f11412k;

    public interface zza<T> {
        void zzg(zzk<T> com_google_android_gms_internal_zzk_T);
    }

    public zzl(zzb com_google_android_gms_internal_zzb, zzf com_google_android_gms_internal_zzf) {
        this(com_google_android_gms_internal_zzb, com_google_android_gms_internal_zzf, 4);
    }

    public zzl(zzb com_google_android_gms_internal_zzb, zzf com_google_android_gms_internal_zzf, int i) {
        this(com_google_android_gms_internal_zzb, com_google_android_gms_internal_zzf, i, new zze(new Handler(Looper.getMainLooper())));
    }

    public zzl(zzb com_google_android_gms_internal_zzb, zzf com_google_android_gms_internal_zzf, int i, zzn com_google_android_gms_internal_zzn) {
        this.f11402a = new AtomicInteger();
        this.f11403b = new HashMap();
        this.f11404c = new HashSet();
        this.f11405d = new PriorityBlockingQueue();
        this.f11406e = new PriorityBlockingQueue();
        this.f11412k = new ArrayList();
        this.f11407f = com_google_android_gms_internal_zzb;
        this.f11408g = com_google_android_gms_internal_zzf;
        this.f11410i = new zzg[i];
        this.f11409h = com_google_android_gms_internal_zzn;
    }

    <T> void m17355a(zzk<T> com_google_android_gms_internal_zzk_T) {
        synchronized (this.f11404c) {
            this.f11404c.remove(com_google_android_gms_internal_zzk_T);
        }
        synchronized (this.f11412k) {
            for (zza zzg : this.f11412k) {
                zzg.zzg(com_google_android_gms_internal_zzk_T);
            }
        }
        if (com_google_android_gms_internal_zzk_T.zzq()) {
            synchronized (this.f11403b) {
                Queue queue = (Queue) this.f11403b.remove(com_google_android_gms_internal_zzk_T.zzg());
                if (queue != null) {
                    if (zzs.DEBUG) {
                        zzs.zza("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f11405d.addAll(queue);
                }
            }
        }
    }

    public int getSequenceNumber() {
        return this.f11402a.incrementAndGet();
    }

    public void start() {
        stop();
        this.f11411j = new zzc(this.f11405d, this.f11406e, this.f11407f, this.f11409h);
        this.f11411j.start();
        for (int i = 0; i < this.f11410i.length; i++) {
            zzg com_google_android_gms_internal_zzg = new zzg(this.f11406e, this.f11408g, this.f11407f, this.f11409h);
            this.f11410i[i] = com_google_android_gms_internal_zzg;
            com_google_android_gms_internal_zzg.start();
        }
    }

    public void stop() {
        if (this.f11411j != null) {
            this.f11411j.quit();
        }
        for (int i = 0; i < this.f11410i.length; i++) {
            if (this.f11410i[i] != null) {
                this.f11410i[i].quit();
            }
        }
    }

    public <T> zzk<T> zze(zzk<T> com_google_android_gms_internal_zzk_T) {
        com_google_android_gms_internal_zzk_T.zza(this);
        synchronized (this.f11404c) {
            this.f11404c.add(com_google_android_gms_internal_zzk_T);
        }
        com_google_android_gms_internal_zzk_T.zza(getSequenceNumber());
        com_google_android_gms_internal_zzk_T.zzc("add-to-queue");
        if (com_google_android_gms_internal_zzk_T.zzq()) {
            synchronized (this.f11403b) {
                String zzg = com_google_android_gms_internal_zzk_T.zzg();
                if (this.f11403b.containsKey(zzg)) {
                    Queue queue = (Queue) this.f11403b.get(zzg);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(com_google_android_gms_internal_zzk_T);
                    this.f11403b.put(zzg, queue);
                    if (zzs.DEBUG) {
                        zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", zzg);
                    }
                } else {
                    this.f11403b.put(zzg, null);
                    this.f11405d.add(com_google_android_gms_internal_zzk_T);
                }
            }
        } else {
            this.f11406e.add(com_google_android_gms_internal_zzk_T);
        }
        return com_google_android_gms_internal_zzk_T;
    }
}
