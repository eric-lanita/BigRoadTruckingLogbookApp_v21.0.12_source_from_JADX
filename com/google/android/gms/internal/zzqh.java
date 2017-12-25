package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface zzqh {

    public interface zza {
        void zzc(int i, boolean z);

        void zzd(ConnectionResult connectionResult);

        void zzm(Bundle bundle);
    }

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    ConnectionResult getConnectionResult(Api<?> api);

    boolean isConnected();

    boolean isConnecting();

    boolean zza(zzqt com_google_android_gms_internal_zzqt);

    void zzaof();

    void zzapb();

    <A extends zzb, R extends Result, T extends com.google.android.gms.internal.zzpm.zza<R, A>> T zzc(T t);

    <A extends zzb, T extends com.google.android.gms.internal.zzpm.zza<? extends Result, A>> T zzd(T t);
}
