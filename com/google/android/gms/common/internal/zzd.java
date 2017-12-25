package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    public static final String[] xE = new String[]{"service_esmobile", "service_googleme"};
    final Handler f10696a;
    protected AtomicInteger f10697b;
    private int f10698c;
    private long f10699d;
    private long f10700e;
    private int f10701f;
    private long f10702g;
    private final Context f10703h;
    private final Looper f10704i;
    private final zzm f10705j;
    private final com.google.android.gms.common.zzc f10706k;
    private final Object f10707l;
    private final Object f10708m;
    private zzu f10709n;
    private zzf f10710o;
    private T f10711p;
    private final ArrayList<zze<?>> f10712q;
    private zzh f10713r;
    private int f10714s;
    private final zzb f10715t;
    private final zzc f10716u;
    private final int f10717v;
    private final String f10718w;

    protected abstract class zze<TListener> {
        private TListener f10725a;
        final /* synthetic */ zzd f10726b;
        private boolean f10727c = false;

        public zze(zzd com_google_android_gms_common_internal_zzd, TListener tListener) {
            this.f10726b = com_google_android_gms_common_internal_zzd;
            this.f10725a = tListener;
        }

        protected abstract void mo1676a(TListener tListener);

        protected abstract void mo1677b();

        public void unregister() {
            zzasg();
            synchronized (this.f10726b.f10712q) {
                this.f10726b.f10712q.remove(this);
            }
        }

        public void zzasf() {
            synchronized (this) {
                Object obj = this.f10725a;
                if (this.f10727c) {
                    String valueOf = String.valueOf(this);
                    Log.w("GmsClient", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.").toString());
                }
            }
            if (obj != null) {
                try {
                    mo1676a(obj);
                } catch (RuntimeException e) {
                    mo1677b();
                    throw e;
                }
            }
            mo1677b();
            synchronized (this) {
                this.f10727c = true;
            }
            unregister();
        }

        public void zzasg() {
            synchronized (this) {
                this.f10725a = null;
            }
        }
    }

    private abstract class zza extends zze<Boolean> {
        final /* synthetic */ zzd f10728a;
        public final int statusCode;
        public final Bundle xF;

        protected zza(zzd com_google_android_gms_common_internal_zzd, int i, Bundle bundle) {
            this.f10728a = com_google_android_gms_common_internal_zzd;
            super(com_google_android_gms_common_internal_zzd, Boolean.valueOf(true));
            this.statusCode = i;
            this.xF = bundle;
        }

        protected abstract void mo1681a(ConnectionResult connectionResult);

        protected void m16920a(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                this.f10728a.m16890b(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!mo1682a()) {
                        this.f10728a.m16890b(1, null);
                        mo1681a(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    this.f10728a.m16890b(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    this.f10728a.m16890b(1, null);
                    if (this.xF != null) {
                        pendingIntent = (PendingIntent) this.xF.getParcelable("pendingIntent");
                    }
                    mo1681a(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void mo1676a(Object obj) {
            m16920a((Boolean) obj);
        }

        protected abstract boolean mo1682a();

        protected void mo1677b() {
        }
    }

    public interface zzb {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface zzc {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    final class zzd extends Handler {
        final /* synthetic */ zzd f10729a;

        public zzd(zzd com_google_android_gms_common_internal_zzd, Looper looper) {
            this.f10729a = com_google_android_gms_common_internal_zzd;
            super(looper);
        }

        private void m16924a(Message message) {
            zze com_google_android_gms_common_internal_zzd_zze = (zze) message.obj;
            com_google_android_gms_common_internal_zzd_zze.mo1677b();
            com_google_android_gms_common_internal_zzd_zze.unregister();
        }

        private boolean m16925b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        public void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            if (this.f10729a.f10697b.get() != message.arg1) {
                if (m16925b(message)) {
                    m16924a(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !this.f10729a.isConnecting()) {
                m16924a(message);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.f10729a.f10710o.zzh(connectionResult);
                this.f10729a.m16902a(connectionResult);
            } else if (message.what == 4) {
                this.f10729a.m16890b(4, null);
                if (this.f10729a.f10715t != null) {
                    this.f10729a.f10715t.onConnectionSuspended(message.arg2);
                }
                this.f10729a.m16897a(message.arg2);
                this.f10729a.m16887a(4, 1, null);
            } else if (message.what == 2 && !this.f10729a.isConnected()) {
                m16924a(message);
            } else if (m16925b(message)) {
                ((zze) message.obj).zzasf();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    public interface zzf {
        void zzh(ConnectionResult connectionResult);
    }

    public static final class zzg extends com.google.android.gms.common.internal.zzt.zza {
        private zzd f10730a;
        private final int f10731b;

        public zzg(zzd com_google_android_gms_common_internal_zzd, int i) {
            this.f10730a = com_google_android_gms_common_internal_zzd;
            this.f10731b = i;
        }

        private void m16926a() {
            this.f10730a = null;
        }

        public void zza(int i, IBinder iBinder, Bundle bundle) {
            zzab.zzb(this.f10730a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f10730a.m16899a(i, iBinder, bundle, this.f10731b);
            m16926a();
        }

        public void zzb(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zzh implements ServiceConnection {
        final /* synthetic */ zzd f10732a;
        private final int f10733b;

        public zzh(zzd com_google_android_gms_common_internal_zzd, int i) {
            this.f10732a = com_google_android_gms_common_internal_zzd;
            this.f10733b = i;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzb((Object) iBinder, (Object) "Expecting a valid IBinder");
            synchronized (this.f10732a.f10708m) {
                this.f10732a.f10709n = com.google.android.gms.common.internal.zzu.zza.zzdt(iBinder);
            }
            this.f10732a.m16898a(0, null, this.f10733b);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (this.f10732a.f10708m) {
                this.f10732a.f10709n = null;
            }
            this.f10732a.f10696a.sendMessage(this.f10732a.f10696a.obtainMessage(4, this.f10733b, 1));
        }
    }

    protected class zzi implements zzf {
        final /* synthetic */ zzd f10734a;

        public zzi(zzd com_google_android_gms_common_internal_zzd) {
            this.f10734a = com_google_android_gms_common_internal_zzd;
        }

        public void zzh(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.f10734a.zza(null, this.f10734a.mo1670f());
            } else if (this.f10734a.f10716u != null) {
                this.f10734a.f10716u.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzj extends zza {
        final /* synthetic */ zzd f10735c;
        public final IBinder xK;

        public zzj(zzd com_google_android_gms_common_internal_zzd, int i, IBinder iBinder, Bundle bundle) {
            this.f10735c = com_google_android_gms_common_internal_zzd;
            super(com_google_android_gms_common_internal_zzd, i, bundle);
            this.xK = iBinder;
        }

        protected void mo1681a(ConnectionResult connectionResult) {
            if (this.f10735c.f10716u != null) {
                this.f10735c.f10716u.onConnectionFailed(connectionResult);
            }
            this.f10735c.m16902a(connectionResult);
        }

        protected boolean mo1682a() {
            try {
                String interfaceDescriptor = this.xK.getInterfaceDescriptor();
                if (this.f10735c.mo1672a().equals(interfaceDescriptor)) {
                    IInterface zzbb = this.f10735c.zzbb(this.xK);
                    if (zzbb == null || !this.f10735c.m16887a(2, 3, zzbb)) {
                        return false;
                    }
                    Bundle zzamh = this.f10735c.zzamh();
                    if (this.f10735c.f10715t != null) {
                        this.f10735c.f10715t.onConnected(zzamh);
                    }
                    return true;
                }
                String valueOf = String.valueOf(this.f10735c.mo1672a());
                Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(valueOf).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzk extends zza {
        final /* synthetic */ zzd f10736c;

        public zzk(zzd com_google_android_gms_common_internal_zzd, int i, Bundle bundle) {
            this.f10736c = com_google_android_gms_common_internal_zzd;
            super(com_google_android_gms_common_internal_zzd, i, bundle);
        }

        protected void mo1681a(ConnectionResult connectionResult) {
            this.f10736c.f10710o.zzh(connectionResult);
            this.f10736c.m16902a(connectionResult);
        }

        protected boolean mo1682a() {
            this.f10736c.f10710o.zzh(ConnectionResult.rb);
            return true;
        }
    }

    protected zzd(Context context, Looper looper, int i, zzb com_google_android_gms_common_internal_zzd_zzb, zzc com_google_android_gms_common_internal_zzd_zzc, String str) {
        this(context, looper, zzm.zzce(context), com.google.android.gms.common.zzc.zzang(), i, (zzb) zzab.zzy(com_google_android_gms_common_internal_zzd_zzb), (zzc) zzab.zzy(com_google_android_gms_common_internal_zzd_zzc), str);
    }

    protected zzd(Context context, Looper looper, zzm com_google_android_gms_common_internal_zzm, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, int i, zzb com_google_android_gms_common_internal_zzd_zzb, zzc com_google_android_gms_common_internal_zzd_zzc, String str) {
        this.f10707l = new Object();
        this.f10708m = new Object();
        this.f10712q = new ArrayList();
        this.f10714s = 1;
        this.f10697b = new AtomicInteger(0);
        this.f10703h = (Context) zzab.zzb((Object) context, (Object) "Context must not be null");
        this.f10704i = (Looper) zzab.zzb((Object) looper, (Object) "Looper must not be null");
        this.f10705j = (zzm) zzab.zzb((Object) com_google_android_gms_common_internal_zzm, (Object) "Supervisor must not be null");
        this.f10706k = (com.google.android.gms.common.zzc) zzab.zzb((Object) com_google_android_gms_common_zzc, (Object) "API availability must not be null");
        this.f10696a = new zzd(this, looper);
        this.f10717v = i;
        this.f10715t = com_google_android_gms_common_internal_zzd_zzb;
        this.f10716u = com_google_android_gms_common_internal_zzd_zzc;
        this.f10718w = str;
    }

    private boolean m16887a(int i, int i2, T t) {
        boolean z;
        synchronized (this.f10707l) {
            if (this.f10714s != i) {
                z = false;
            } else {
                m16890b(i2, t);
                z = true;
            }
        }
        return z;
    }

    private void m16890b(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzab.zzbo(z);
        synchronized (this.f10707l) {
            this.f10714s = i;
            this.f10711p = t;
            mo1673a(i, (IInterface) t);
            switch (i) {
                case 1:
                    m16895h();
                    break;
                case 2:
                    m16894g();
                    break;
                case 3:
                    m16901a((IInterface) t);
                    break;
            }
        }
    }

    private void m16894g() {
        if (this.f10713r != null) {
            String valueOf = String.valueOf(zzqz());
            String valueOf2 = String.valueOf(m16903b());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("Calling connect() while still connected, missing disconnect() for ").append(valueOf).append(" on ").append(valueOf2).toString());
            this.f10705j.zzb(zzqz(), m16903b(), this.f10713r, m16904c());
            this.f10697b.incrementAndGet();
        }
        this.f10713r = new zzh(this, this.f10697b.get());
        if (!this.f10705j.zza(zzqz(), m16903b(), this.f10713r, m16904c())) {
            valueOf = String.valueOf(zzqz());
            valueOf2 = String.valueOf(m16903b());
            Log.e("GmsClient", new StringBuilder((String.valueOf(valueOf).length() + 34) + String.valueOf(valueOf2).length()).append("unable to connect to service: ").append(valueOf).append(" on ").append(valueOf2).toString());
            m16898a(16, null, this.f10697b.get());
        }
    }

    private void m16895h() {
        if (this.f10713r != null) {
            this.f10705j.zzb(zzqz(), m16903b(), this.f10713r, m16904c());
            this.f10713r = null;
        }
    }

    protected abstract String mo1672a();

    protected void m16897a(int i) {
        this.f10698c = i;
        this.f10699d = System.currentTimeMillis();
    }

    protected void m16898a(int i, Bundle bundle, int i2) {
        this.f10696a.sendMessage(this.f10696a.obtainMessage(5, i2, -1, new zzk(this, i, bundle)));
    }

    protected void m16899a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f10696a.sendMessage(this.f10696a.obtainMessage(1, i2, -1, new zzj(this, i, iBinder, bundle)));
    }

    void mo1673a(int i, T t) {
    }

    protected void m16901a(T t) {
        this.f10700e = System.currentTimeMillis();
    }

    protected void m16902a(ConnectionResult connectionResult) {
        this.f10701f = connectionResult.getErrorCode();
        this.f10702g = System.currentTimeMillis();
    }

    protected String m16903b() {
        return "com.google.android.gms";
    }

    protected final String m16904c() {
        return this.f10718w == null ? this.f10703h.getClass().getName() : this.f10718w;
    }

    protected Bundle mo2416d() {
        return new Bundle();
    }

    public void disconnect() {
        this.f10697b.incrementAndGet();
        synchronized (this.f10712q) {
            int size = this.f10712q.size();
            for (int i = 0; i < size; i++) {
                ((zze) this.f10712q.get(i)).zzasg();
            }
            this.f10712q.clear();
        }
        synchronized (this.f10708m) {
            this.f10709n = null;
        }
        m16890b(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this.f10707l) {
            int i = this.f10714s;
            IInterface iInterface = this.f10711p;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(mo1672a()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f10700e > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f10700e;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f10700e)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f10699d > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.f10698c) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.f10698c));
                    break;
            }
            append = printWriter.append(" lastSuspendedTime=");
            j = this.f10699d;
            valueOf = String.valueOf(simpleDateFormat.format(new Date(this.f10699d)));
            append.println(new StringBuilder(String.valueOf(valueOf).length() + 21).append(j).append(" ").append(valueOf).toString());
        }
        if (this.f10702g > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.f10701f));
            append = printWriter.append(" lastFailedTime=");
            j = this.f10702g;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(this.f10702g)));
            append.println(new StringBuilder(String.valueOf(valueOf2).length() + 21).append(j).append(" ").append(valueOf2).toString());
        }
    }

    protected final void m16906e() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected Set<Scope> mo1670f() {
        return Collections.EMPTY_SET;
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.f10703h;
    }

    public final Looper getLooper() {
        return this.f10704i;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.f10707l) {
            z = this.f10714s == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.f10707l) {
            z = this.f10714s == 2;
        }
        return z;
    }

    public void zza(zzf com_google_android_gms_common_internal_zzd_zzf) {
        this.f10710o = (zzf) zzab.zzb((Object) com_google_android_gms_common_internal_zzd_zzf, (Object) "Connection progress callbacks cannot be null.");
        m16890b(2, null);
    }

    public void zza(zzf com_google_android_gms_common_internal_zzd_zzf, ConnectionResult connectionResult) {
        this.f10710o = (zzf) zzab.zzb((Object) com_google_android_gms_common_internal_zzd_zzf, (Object) "Connection progress callbacks cannot be null.");
        this.f10696a.sendMessage(this.f10696a.obtainMessage(3, this.f10697b.get(), connectionResult.getErrorCode(), connectionResult.getResolution()));
    }

    public void zza(zzq com_google_android_gms_common_internal_zzq, Set<Scope> set) {
        try {
            GetServiceRequest zzn = new GetServiceRequest(this.f10717v).zzhl(this.f10703h.getPackageName()).zzn(mo2416d());
            if (set != null) {
                zzn.zzf(set);
            }
            if (zzafk()) {
                zzn.zzd(zzary()).zzb(com_google_android_gms_common_internal_zzq);
            } else if (zzasb()) {
                zzn.zzd(getAccount());
            }
            synchronized (this.f10708m) {
                if (this.f10709n != null) {
                    this.f10709n.zza(new zzg(this, this.f10697b.get()), zzn);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzgc(1);
        } catch (Throwable e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public boolean zzafk() {
        return false;
    }

    public boolean zzafz() {
        return false;
    }

    public Intent zzaga() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzamh() {
        return null;
    }

    public boolean zzanu() {
        return true;
    }

    public IBinder zzanv() {
        IBinder iBinder;
        synchronized (this.f10708m) {
            if (this.f10709n == null) {
                iBinder = null;
            } else {
                iBinder = this.f10709n.asBinder();
            }
        }
        return iBinder;
    }

    public void zzarx() {
        int isGooglePlayServicesAvailable = this.f10706k.isGooglePlayServicesAvailable(this.f10703h);
        if (isGooglePlayServicesAvailable != 0) {
            m16890b(1, null);
            this.f10710o = new zzi(this);
            this.f10696a.sendMessage(this.f10696a.obtainMessage(3, this.f10697b.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza(new zzi(this));
    }

    public final Account zzary() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    public final T zzasa() {
        T t;
        synchronized (this.f10707l) {
            if (this.f10714s == 4) {
                throw new DeadObjectException();
            }
            m16906e();
            zzab.zza(this.f10711p != null, (Object) "Client is connected but service is null");
            t = this.f10711p;
        }
        return t;
    }

    public boolean zzasb() {
        return false;
    }

    protected abstract T zzbb(IBinder iBinder);

    public void zzgc(int i) {
        this.f10696a.sendMessage(this.f10696a.obtainMessage(4, this.f10697b.get(), i));
    }

    protected abstract String zzqz();
}
