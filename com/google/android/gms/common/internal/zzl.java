package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzl implements Callback {
    final ArrayList<ConnectionCallbacks> f10766a = new ArrayList();
    private final zza f10767b;
    private final ArrayList<ConnectionCallbacks> f10768c = new ArrayList();
    private final ArrayList<OnConnectionFailedListener> f10769d = new ArrayList();
    private volatile boolean f10770e = false;
    private final AtomicInteger f10771f = new AtomicInteger(0);
    private boolean f10772g = false;
    private final Handler f10773h;
    private final Object f10774i = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzamh();
    }

    public zzl(Looper looper, zza com_google_android_gms_common_internal_zzl_zza) {
        this.f10767b = com_google_android_gms_common_internal_zzl_zza;
        this.f10773h = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.f10774i) {
                if (this.f10770e && this.f10767b.isConnected() && this.f10768c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.f10767b.zzamh());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + message.what, new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzab.zzy(connectionCallbacks);
        synchronized (this.f10774i) {
            contains = this.f10768c.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzab.zzy(onConnectionFailedListener);
        synchronized (this.f10774i) {
            contains = this.f10769d.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzab.zzy(connectionCallbacks);
        synchronized (this.f10774i) {
            if (this.f10768c.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f10768c.add(connectionCallbacks);
            }
        }
        if (this.f10767b.isConnected()) {
            this.f10773h.sendMessage(this.f10773h.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzy(onConnectionFailedListener);
        synchronized (this.f10774i) {
            if (this.f10769d.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f10769d.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        zzab.zzy(connectionCallbacks);
        synchronized (this.f10774i) {
            if (!this.f10768c.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found").toString());
            } else if (this.f10772g) {
                this.f10766a.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzy(onConnectionFailedListener);
        synchronized (this.f10774i) {
            if (!this.f10769d.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public void zzasw() {
        this.f10770e = false;
        this.f10771f.incrementAndGet();
    }

    public void zzasx() {
        this.f10770e = true;
    }

    public void zzgf(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.f10773h.getLooper()) {
            z = true;
        }
        zzab.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.f10773h.removeMessages(1);
        synchronized (this.f10774i) {
            this.f10772g = true;
            ArrayList arrayList = new ArrayList(this.f10768c);
            int i2 = this.f10771f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.f10770e || this.f10771f.get() != i2) {
                    break;
                } else if (this.f10768c.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f10766a.clear();
            this.f10772g = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzm(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r1 = 1;
        r0 = android.os.Looper.myLooper();
        r2 = r5.f10773h;
        r2 = r2.getLooper();
        if (r0 != r2) goto L_0x0046;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r2 = "onConnectionFailure must only be called on the Handler thread";
        com.google.android.gms.common.internal.zzab.zza(r0, r2);
        r0 = r5.f10773h;
        r0.removeMessages(r1);
        r1 = r5.f10774i;
        monitor-enter(r1);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0054 }
        r2 = r5.f10769d;	 Catch:{ all -> 0x0054 }
        r0.<init>(r2);	 Catch:{ all -> 0x0054 }
        r2 = r5.f10771f;	 Catch:{ all -> 0x0054 }
        r2 = r2.get();	 Catch:{ all -> 0x0054 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0054 }
    L_0x002c:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0032:
        r0 = r3.next();	 Catch:{ all -> 0x0054 }
        r0 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r0;	 Catch:{ all -> 0x0054 }
        r4 = r5.f10770e;	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x0044;
    L_0x003c:
        r4 = r5.f10771f;	 Catch:{ all -> 0x0054 }
        r4 = r4.get();	 Catch:{ all -> 0x0054 }
        if (r4 == r2) goto L_0x0048;
    L_0x0044:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = 0;
        goto L_0x000e;
    L_0x0048:
        r4 = r5.f10769d;	 Catch:{ all -> 0x0054 }
        r4 = r4.contains(r0);	 Catch:{ all -> 0x0054 }
        if (r4 == 0) goto L_0x002c;
    L_0x0050:
        r0.onConnectionFailed(r6);	 Catch:{ all -> 0x0054 }
        goto L_0x002c;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0054 }
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzl.zzm(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zzo(Bundle bundle) {
        boolean z = true;
        zzab.zza(Looper.myLooper() == this.f10773h.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.f10774i) {
            zzab.zzbn(!this.f10772g);
            this.f10773h.removeMessages(1);
            this.f10772g = true;
            if (this.f10766a.size() != 0) {
                z = false;
            }
            zzab.zzbn(z);
            ArrayList arrayList = new ArrayList(this.f10768c);
            int i = this.f10771f.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.f10770e || !this.f10767b.isConnected() || this.f10771f.get() != i) {
                    break;
                } else if (!this.f10766a.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f10766a.clear();
            this.f10772g = false;
        }
    }
}
