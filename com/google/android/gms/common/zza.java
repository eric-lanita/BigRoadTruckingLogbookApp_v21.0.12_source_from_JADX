package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zza implements ServiceConnection {
    boolean f10914a = false;
    private final BlockingQueue<IBinder> f10915b = new LinkedBlockingQueue();

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f10915b.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public IBinder zza(long j, TimeUnit timeUnit) {
        zzab.zzhj("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f10914a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f10914a = true;
        IBinder iBinder = (IBinder) this.f10915b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public IBinder zzanf() {
        zzab.zzhj("BlockingServiceConnection.getService() called on main thread");
        if (this.f10914a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f10914a = true;
        return (IBinder) this.f10915b.take();
    }
}
