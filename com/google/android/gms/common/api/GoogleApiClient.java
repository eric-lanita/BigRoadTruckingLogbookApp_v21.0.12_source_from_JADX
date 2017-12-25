package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.p008d.C0270a;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzh;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzg.zza;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzvt;
import com.google.android.gms.internal.zzvu;
import com.google.android.gms.internal.zzvv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> f10549a = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private Account f10531a;
        private final Set<Scope> f10532b;
        private final Set<Scope> f10533c;
        private int f10534d;
        private View f10535e;
        private String f10536f;
        private String f10537g;
        private final Map<Api<?>, zza> f10538h;
        private final Context f10539i;
        private final Map<Api<?>, ApiOptions> f10540j;
        private zzqi f10541k;
        private int f10542l;
        private OnConnectionFailedListener f10543m;
        private Looper f10544n;
        private GoogleApiAvailability f10545o;
        private Api.zza<? extends zzvu, zzvv> f10546p;
        private final ArrayList<ConnectionCallbacks> f10547q;
        private final ArrayList<OnConnectionFailedListener> f10548r;

        public Builder(Context context) {
            this.f10532b = new HashSet();
            this.f10533c = new HashSet();
            this.f10538h = new C0270a();
            this.f10540j = new C0270a();
            this.f10542l = -1;
            this.f10545o = GoogleApiAvailability.getInstance();
            this.f10546p = zzvt.bK;
            this.f10547q = new ArrayList();
            this.f10548r = new ArrayList();
            this.f10539i = context;
            this.f10544n = context.getMainLooper();
            this.f10536f = context.getPackageName();
            this.f10537g = context.getClass().getName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzab.zzb((Object) connectionCallbacks, (Object) "Must provide a connected listener");
            this.f10547q.add(connectionCallbacks);
            zzab.zzb((Object) onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.f10548r.add(onConnectionFailedListener);
        }

        private static <C extends zze, O> C m16798a(Api.zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, Object obj, Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return com_google_android_gms_common_api_Api_zza_C__O.zza(context, looper, com_google_android_gms_common_internal_zzg, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private Builder m16799a(zzqi com_google_android_gms_internal_zzqi, int i, OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb(i >= 0, (Object) "clientId must be non-negative");
            this.f10542l = i;
            this.f10543m = onConnectionFailedListener;
            this.f10541k = com_google_android_gms_internal_zzqi;
            return this;
        }

        private GoogleApiClient m16800a() {
            zzg zzaoh = zzaoh();
            Api api = null;
            Map zzasl = zzaoh.zzasl();
            Map c0270a = new C0270a();
            Map c0270a2 = new C0270a();
            ArrayList arrayList = new ArrayList();
            Api api2 = null;
            for (Api api3 : this.f10540j.keySet()) {
                Api api32;
                zze a;
                Api api4;
                Object obj = this.f10540j.get(api32);
                int i = 0;
                if (zzasl.get(api32) != null) {
                    i = ((zza) zzasl.get(api32)).yn ? 1 : 2;
                }
                c0270a.put(api32, Integer.valueOf(i));
                ConnectionCallbacks com_google_android_gms_internal_zzpp = new zzpp(api32, i);
                arrayList.add(com_google_android_gms_internal_zzpp);
                Api api5;
                if (api32.zzant()) {
                    zzh zzanr = api32.zzanr();
                    api5 = zzanr.getPriority() == 1 ? api32 : api2;
                    a = m16801a(zzanr, obj, this.f10539i, this.f10544n, zzaoh, com_google_android_gms_internal_zzpp, (OnConnectionFailedListener) com_google_android_gms_internal_zzpp);
                    api4 = api5;
                } else {
                    Api.zza zzanq = api32.zzanq();
                    api5 = zzanq.getPriority() == 1 ? api32 : api2;
                    a = m16798a(zzanq, obj, this.f10539i, this.f10544n, zzaoh, com_google_android_gms_internal_zzpp, (OnConnectionFailedListener) com_google_android_gms_internal_zzpp);
                    api4 = api5;
                }
                c0270a2.put(api32.zzans(), a);
                if (!a.zzafz()) {
                    api32 = api;
                } else if (api != null) {
                    String valueOf = String.valueOf(api32.getName());
                    String valueOf2 = String.valueOf(api.getName());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                api2 = api4;
                api = api32;
            }
            if (api != null) {
                if (api2 != null) {
                    valueOf = String.valueOf(api.getName());
                    valueOf2 = String.valueOf(api2.getName());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                zzab.zza(this.f10531a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.getName());
                zzab.zza(this.f10532b.equals(this.f10533c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.getName());
            }
            return new zzpy(this.f10539i, new ReentrantLock(), this.f10544n, zzaoh, this.f10545o, this.f10546p, c0270a, this.f10547q, this.f10548r, c0270a2, this.f10542l, zzpy.zza(c0270a2.values(), true), arrayList);
        }

        private static <C extends Api.zzg, O> zzah m16801a(zzh<C, O> com_google_android_gms_common_api_Api_zzh_C__O, Object obj, Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzah(context, looper, com_google_android_gms_common_api_Api_zzh_C__O.zzanw(), connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg, com_google_android_gms_common_api_Api_zzh_C__O.zzr(obj));
        }

        private <O extends ApiOptions> void m16802a(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
            }
            Set hashSet = new HashSet(api.zzanp().zzp(o));
            int length = scopeArr.length;
            while (i2 < length) {
                hashSet.add(scopeArr[i2]);
                i2++;
            }
            this.f10538h.put(api, new zza(hashSet, z));
        }

        private void m16803a(GoogleApiClient googleApiClient) {
            zzpk.zza(this.f10541k).zza(this.f10542l, googleApiClient, this.f10543m);
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            this.f10540j.put(api, null);
            Collection zzp = api.zzanp().zzp(null);
            this.f10533c.addAll(zzp);
            this.f10532b.addAll(zzp);
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O o) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            zzab.zzb((Object) o, (Object) "Null options are not permitted for this Api");
            this.f10540j.put(api, o);
            Collection zzp = api.zzanp().zzp(o);
            this.f10533c.addAll(zzp);
            this.f10532b.addAll(zzp);
            return this;
        }

        public <O extends HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            zzab.zzb((Object) o, (Object) "Null options are not permitted for this Api");
            this.f10540j.put(api, o);
            m16802a(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(Api<? extends NotRequiredOptions> api, Scope... scopeArr) {
            zzab.zzb((Object) api, (Object) "Api must not be null");
            this.f10540j.put(api, null);
            m16802a(api, null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            zzab.zzb((Object) connectionCallbacks, (Object) "Listener must not be null");
            this.f10547q.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            zzab.zzb((Object) onConnectionFailedListener, (Object) "Listener must not be null");
            this.f10548r.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            zzab.zzb((Object) scope, (Object) "Scope must not be null");
            this.f10532b.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzab.zzb(!this.f10540j.isEmpty(), (Object) "must call addApi() to add at least one API");
            GoogleApiClient a = m16800a();
            synchronized (GoogleApiClient.f10549a) {
                GoogleApiClient.f10549a.add(a);
            }
            if (this.f10542l >= 0) {
                m16803a(a);
            }
            return a;
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            return m16799a(new zzqi(fragmentActivity), i, onConnectionFailedListener);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.f10531a = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.f10534d = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzab.zzb((Object) handler, (Object) "Handler must not be null");
            this.f10544n = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view) {
            zzab.zzb((Object) view, (Object) "View must not be null");
            this.f10535e = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzg zzaoh() {
            zzvv com_google_android_gms_internal_zzvv = zzvv.atR;
            if (this.f10540j.containsKey(zzvt.API)) {
                com_google_android_gms_internal_zzvv = (zzvv) this.f10540j.get(zzvt.API);
            }
            return new zzg(this.f10531a, this.f10532b, this.f10538h, this.f10534d, this.f10535e, this.f10536f, this.f10537g, com_google_android_gms_internal_zzvv);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (f10549a) {
            String concat = String.valueOf(str).concat("  ");
            int i = 0;
            for (GoogleApiClient googleApiClient : f10549a) {
                int i2 = i + 1;
                printWriter.append(str).append("GoogleApiClient#").println(i);
                googleApiClient.dump(concat, fileDescriptor, printWriter, strArr);
                i = i2;
            }
        }
    }

    public static Set<GoogleApiClient> zzaoe() {
        Set<GoogleApiClient> set;
        synchronized (f10549a) {
            set = f10549a;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public <C extends zze> C zza(zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzqx com_google_android_gms_internal_zzqx) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzqt com_google_android_gms_internal_zzqt) {
        throw new UnsupportedOperationException();
    }

    public void zzaof() {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzqx com_google_android_gms_internal_zzqx) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, R extends Result, T extends zzpm.zza<R, A>> T zzc(T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends zzb, T extends zzpm.zza<? extends Result, A>> T zzd(T t) {
        throw new UnsupportedOperationException();
    }

    public <L> zzqn<L> zzs(L l) {
        throw new UnsupportedOperationException();
    }
}
