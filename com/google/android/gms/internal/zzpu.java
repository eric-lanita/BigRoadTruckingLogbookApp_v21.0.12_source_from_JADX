package com.google.android.gms.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzpu extends GoogleApiClient {
    private final UnsupportedOperationException f11499a;

    public zzpu(String str) {
        this.f11499a = new UnsupportedOperationException(str);
    }

    public ConnectionResult blockingConnect() {
        throw this.f11499a;
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw this.f11499a;
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw this.f11499a;
    }

    public void connect() {
        throw this.f11499a;
    }

    public void disconnect() {
        throw this.f11499a;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw this.f11499a;
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        throw this.f11499a;
    }

    public boolean hasConnectedApi(Api<?> api) {
        throw this.f11499a;
    }

    public boolean isConnected() {
        throw this.f11499a;
    }

    public boolean isConnecting() {
        throw this.f11499a;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        throw this.f11499a;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        throw this.f11499a;
    }

    public void reconnect() {
        throw this.f11499a;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        throw this.f11499a;
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        throw this.f11499a;
    }

    public void stopAutoManage(FragmentActivity fragmentActivity) {
        throw this.f11499a;
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        throw this.f11499a;
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        throw this.f11499a;
    }
}
