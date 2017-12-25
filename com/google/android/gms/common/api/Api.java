package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {
    private final zza<?, O> f10497a;
    private final zzh<?, O> f10498b = null;
    private final zzf<?> f10499c;
    private final zzi<?> f10500d;
    private final String f10501e;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }
    }

    public static abstract class zzd<T extends zzb, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> zzp(O o) {
            return Collections.emptyList();
        }
    }

    public static abstract class zza<T extends zze, O> extends zzd<T, O> {
        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzg com_google_android_gms_common_internal_zzg, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface zzb {
    }

    public static class zzc<C extends zzb> {
    }

    public interface zze extends zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        boolean isConnecting();

        void zza(com.google.android.gms.common.internal.zzd.zzf com_google_android_gms_common_internal_zzd_zzf);

        void zza(zzq com_google_android_gms_common_internal_zzq, Set<Scope> set);

        boolean zzafk();

        boolean zzafz();

        Intent zzaga();

        boolean zzanu();

        IBinder zzanv();
    }

    public static final class zzf<C extends zze> extends zzc<C> {
    }

    public interface zzg<T extends IInterface> extends zzb {
        void zza(int i, T t);

        T zzbb(IBinder iBinder);

        String zzqz();

        String zzra();
    }

    public static abstract class zzh<T extends zzg, O> extends zzd<T, O> {
        public abstract int zzanw();

        public abstract T zzr(O o);
    }

    public static final class zzi<C extends zzg> extends zzc<C> {
    }

    public <C extends zze> Api(String str, zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, zzf<C> com_google_android_gms_common_api_Api_zzf_C) {
        zzab.zzb((Object) com_google_android_gms_common_api_Api_zza_C__O, (Object) "Cannot construct an Api with a null ClientBuilder");
        zzab.zzb((Object) com_google_android_gms_common_api_Api_zzf_C, (Object) "Cannot construct an Api with a null ClientKey");
        this.f10501e = str;
        this.f10497a = com_google_android_gms_common_api_Api_zza_C__O;
        this.f10499c = com_google_android_gms_common_api_Api_zzf_C;
        this.f10500d = null;
    }

    public String getName() {
        return this.f10501e;
    }

    public zzd<?, O> zzanp() {
        return zzant() ? null : this.f10497a;
    }

    public zza<?, O> zzanq() {
        zzab.zza(this.f10497a != null, (Object) "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f10497a;
    }

    public zzh<?, O> zzanr() {
        zzab.zza(false, (Object) "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return null;
    }

    public zzc<?> zzans() {
        if (this.f10499c != null) {
            return this.f10499c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public boolean zzant() {
        return false;
    }
}
