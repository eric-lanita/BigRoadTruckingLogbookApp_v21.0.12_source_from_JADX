package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.common.util.zze;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class zzad extends zzaa {
    private final zza f12204a;
    private zzm f12205c;
    private Boolean f12206d;
    private final zzf f12207e;
    private final zzah f12208f;
    private final List<Runnable> f12209g = new ArrayList();
    private final zzf f12210h;

    class C33863 implements Runnable {
        final /* synthetic */ zzad f12184a;

        C33863(zzad com_google_android_gms_measurement_internal_zzad) {
            this.f12184a = com_google_android_gms_measurement_internal_zzad;
        }

        public void run() {
            zzm c = this.f12184a.f12205c;
            if (c == null) {
                this.f12184a.zzbsd().zzbsv().log("Failed to send measurementEnabled to service");
                return;
            }
            try {
                c.zzb(this.f12184a.zzbrv().m17885a(this.f12184a.zzbsd().zzbtd()));
                this.f12184a.m17764i();
            } catch (RemoteException e) {
                this.f12184a.zzbsd().zzbsv().zzj("Failed to send measurementEnabled to AppMeasurementService", e);
            }
        }
    }

    class C33907 implements Runnable {
        final /* synthetic */ zzad f12193a;

        C33907(zzad com_google_android_gms_measurement_internal_zzad) {
            this.f12193a = com_google_android_gms_measurement_internal_zzad;
        }

        public void run() {
            zzm c = this.f12193a.f12205c;
            if (c == null) {
                this.f12193a.zzbsd().zzbsv().log("Discarding data. Failed to send app launch");
                return;
            }
            try {
                c.zza(this.f12193a.zzbrv().m17885a(this.f12193a.zzbsd().zzbtd()));
                this.f12193a.m17764i();
            } catch (RemoteException e) {
                this.f12193a.zzbsd().zzbsv().zzj("Failed to send app launch to AppMeasurementService", e);
            }
        }
    }

    protected class zza implements ServiceConnection, zzb, zzc {
        final /* synthetic */ zzad f12201a;
        private volatile boolean f12202b;
        private volatile zzo f12203c;

        class C33944 implements Runnable {
            final /* synthetic */ zza f12200a;

            C33944(zza com_google_android_gms_measurement_internal_zzad_zza) {
                this.f12200a = com_google_android_gms_measurement_internal_zzad_zza;
            }

            public void run() {
                this.f12200a.f12201a.m17756a(new ComponentName(this.f12200a.f12201a.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
            }
        }

        protected zza(zzad com_google_android_gms_measurement_internal_zzad) {
            this.f12201a = com_google_android_gms_measurement_internal_zzad;
        }

        public void onConnected(Bundle bundle) {
            zzab.zzhi("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final zzm com_google_android_gms_measurement_internal_zzm = (zzm) this.f12203c.zzasa();
                    this.f12203c = null;
                    this.f12201a.zzbsc().zzm(new Runnable(this) {
                        final /* synthetic */ zza f12199b;

                        public void run() {
                            synchronized (this.f12199b) {
                                this.f12199b.f12202b = false;
                                if (!this.f12199b.f12201a.isConnected()) {
                                    this.f12199b.f12201a.zzbsd().zzbtb().log("Connected to remote service");
                                    this.f12199b.f12201a.m17759a(com_google_android_gms_measurement_internal_zzm);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException e) {
                    this.f12203c = null;
                    this.f12202b = false;
                } catch (IllegalStateException e2) {
                    this.f12203c = null;
                    this.f12202b = false;
                }
            }
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            zzab.zzhi("MeasurementServiceConnection.onConnectionFailed");
            zzp zzbtp = this.f12201a.b.zzbtp();
            if (zzbtp != null) {
                zzbtp.zzbsx().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.f12202b = false;
                this.f12203c = null;
            }
        }

        public void onConnectionSuspended(int i) {
            zzab.zzhi("MeasurementServiceConnection.onConnectionSuspended");
            this.f12201a.zzbsd().zzbtb().log("Service connection suspended");
            this.f12201a.zzbsc().zzm(new C33944(this));
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzab.zzhi("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.f12202b = false;
                    this.f12201a.zzbsd().zzbsv().log("Service connected with null binder");
                    return;
                }
                zzm com_google_android_gms_measurement_internal_zzm = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        com_google_android_gms_measurement_internal_zzm = com.google.android.gms.measurement.internal.zzm.zza.zzjf(iBinder);
                        this.f12201a.zzbsd().zzbtc().log("Bound to IMeasurementService interface");
                    } else {
                        this.f12201a.zzbsd().zzbsv().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    this.f12201a.zzbsd().zzbsv().log("Service connect failed to get IMeasurementService");
                }
                if (com_google_android_gms_measurement_internal_zzm == null) {
                    this.f12202b = false;
                    try {
                        com.google.android.gms.common.stats.zzb.zzaux().zza(this.f12201a.getContext(), this.f12201a.f12204a);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    this.f12201a.zzbsc().zzm(new Runnable(this) {
                        final /* synthetic */ zza f12195b;

                        public void run() {
                            synchronized (this.f12195b) {
                                this.f12195b.f12202b = false;
                                if (!this.f12195b.f12201a.isConnected()) {
                                    this.f12195b.f12201a.zzbsd().zzbtc().log("Connected to service");
                                    this.f12195b.f12201a.m17759a(com_google_android_gms_measurement_internal_zzm);
                                }
                            }
                        }
                    });
                }
            }
        }

        public void onServiceDisconnected(final ComponentName componentName) {
            zzab.zzhi("MeasurementServiceConnection.onServiceDisconnected");
            this.f12201a.zzbsd().zzbtb().log("Service disconnected");
            this.f12201a.zzbsc().zzm(new Runnable(this) {
                final /* synthetic */ zza f12197b;

                public void run() {
                    this.f12197b.f12201a.m17756a(componentName);
                }
            });
        }

        public void zzbuw() {
            this.f12201a.zzwu();
            Context context = this.f12201a.getContext();
            synchronized (this) {
                if (this.f12202b) {
                    this.f12201a.zzbsd().zzbtc().log("Connection attempt already in progress");
                } else if (this.f12203c != null) {
                    this.f12201a.zzbsd().zzbtc().log("Already awaiting connection attempt");
                } else {
                    this.f12203c = new zzo(context, Looper.getMainLooper(), this, this);
                    this.f12201a.zzbsd().zzbtc().log("Connecting to remote service");
                    this.f12202b = true;
                    this.f12203c.zzarx();
                }
            }
        }

        public void zzy(Intent intent) {
            this.f12201a.zzwu();
            Context context = this.f12201a.getContext();
            com.google.android.gms.common.stats.zzb zzaux = com.google.android.gms.common.stats.zzb.zzaux();
            synchronized (this) {
                if (this.f12202b) {
                    this.f12201a.zzbsd().zzbtc().log("Connection attempt already in progress");
                    return;
                }
                this.f12202b = true;
                zzaux.zza(context, intent, this.f12201a.f12204a, 129);
            }
        }
    }

    protected zzad(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.f12208f = new zzah(com_google_android_gms_measurement_internal_zzx.zzyw());
        this.f12204a = new zza(this);
        this.f12207e = new zzf(this, com_google_android_gms_measurement_internal_zzx) {
            final /* synthetic */ zzad f12182a;

            public void run() {
                this.f12182a.m17766k();
            }
        };
        this.f12210h = new zzf(this, com_google_android_gms_measurement_internal_zzx) {
            final /* synthetic */ zzad f12183a;

            public void run() {
                this.f12183a.zzbsd().zzbsx().log("Tasks have been queued for a long time");
            }
        };
    }

    private void m17756a(ComponentName componentName) {
        zzwu();
        if (this.f12205c != null) {
            this.f12205c = null;
            zzbsd().zzbtc().zzj("Disconnected from device MeasurementService", componentName);
            m17767l();
        }
    }

    private void m17759a(zzm com_google_android_gms_measurement_internal_zzm) {
        zzwu();
        zzab.zzy(com_google_android_gms_measurement_internal_zzm);
        this.f12205c = com_google_android_gms_measurement_internal_zzm;
        m17764i();
        m17768m();
    }

    private void m17760a(Runnable runnable) {
        zzwu();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.f12209g.size()) >= zzbsf().zzbrh()) {
            zzbsd().zzbsv().log("Discarding data. Max runnable queue size reached");
        } else {
            this.f12209g.add(runnable);
            if (!this.b.m17998h()) {
                this.f12210h.zzv(60000);
            }
            m17775g();
        }
    }

    private void m17764i() {
        zzwu();
        this.f12208f.start();
        if (!this.b.m17998h()) {
            this.f12207e.zzv(zzbsf().m17841k());
        }
    }

    private boolean m17765j() {
        List queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private void m17766k() {
        zzwu();
        if (isConnected()) {
            zzbsd().zzbtc().log("Inactivity, disconnecting from AppMeasurementService");
            disconnect();
        }
    }

    private void m17767l() {
        zzwu();
        m17775g();
    }

    private void m17768m() {
        zzwu();
        zzbsd().zzbtc().zzj("Processing queued up service tasks", Integer.valueOf(this.f12209g.size()));
        for (Runnable zzm : this.f12209g) {
            zzbsc().zzm(zzm);
        }
        this.f12209g.clear();
        this.f12210h.cancel();
    }

    protected void m17769a(final EventParcel eventParcel, final String str) {
        zzab.zzy(eventParcel);
        zzwu();
        m17715c();
        m17760a(new Runnable(this) {
            final /* synthetic */ zzad f12187c;

            public void run() {
                zzm c = this.f12187c.f12205c;
                if (c == null) {
                    this.f12187c.zzbsd().zzbsv().log("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        c.zza(eventParcel, this.f12187c.zzbrv().m17885a(this.f12187c.zzbsd().zzbtd()));
                    } else {
                        c.zza(eventParcel, str, this.f12187c.zzbsd().zzbtd());
                    }
                    this.f12187c.m17764i();
                } catch (RemoteException e) {
                    this.f12187c.zzbsd().zzbsv().zzj("Failed to send event to AppMeasurementService", e);
                }
            }
        });
    }

    protected void m17770a(final UserAttributeParcel userAttributeParcel) {
        zzwu();
        m17715c();
        m17760a(new Runnable(this) {
            final /* synthetic */ zzad f12189b;

            public void run() {
                zzm c = this.f12189b.f12205c;
                if (c == null) {
                    this.f12189b.zzbsd().zzbsv().log("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    c.zza(userAttributeParcel, this.f12189b.zzbrv().m17885a(this.f12189b.zzbsd().zzbtd()));
                    this.f12189b.m17764i();
                } catch (RemoteException e) {
                    this.f12189b.zzbsd().zzbsv().zzj("Failed to send attribute to AppMeasurementService", e);
                }
            }
        });
    }

    protected void m17771a(final AtomicReference<List<UserAttributeParcel>> atomicReference, final boolean z) {
        zzwu();
        m17715c();
        m17760a(new Runnable(this) {
            final /* synthetic */ zzad f12192c;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                r5 = this;
                r1 = r2;
                monitor-enter(r1);
                r0 = r5.f12192c;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.f12205c;	 Catch:{ RemoteException -> 0x0046 }
                if (r0 != 0) goto L_0x0021;
            L_0x000b:
                r0 = r5.f12192c;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.zzbsd();	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.zzbsv();	 Catch:{ RemoteException -> 0x0046 }
                r2 = "Failed to get user properties";
                r0.log(r2);	 Catch:{ RemoteException -> 0x0046 }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
            L_0x0020:
                return;
            L_0x0021:
                r2 = r2;	 Catch:{ RemoteException -> 0x0046 }
                r3 = r5.f12192c;	 Catch:{ RemoteException -> 0x0046 }
                r3 = r3.zzbrv();	 Catch:{ RemoteException -> 0x0046 }
                r4 = 0;
                r3 = r3.m17885a(r4);	 Catch:{ RemoteException -> 0x0046 }
                r4 = r3;	 Catch:{ RemoteException -> 0x0046 }
                r0 = r0.zza(r3, r4);	 Catch:{ RemoteException -> 0x0046 }
                r2.set(r0);	 Catch:{ RemoteException -> 0x0046 }
                r0 = r5.f12192c;	 Catch:{ RemoteException -> 0x0046 }
                r0.m17764i();	 Catch:{ RemoteException -> 0x0046 }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
            L_0x0041:
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                goto L_0x0020;
            L_0x0043:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x0043 }
                throw r0;
            L_0x0046:
                r0 = move-exception;
                r2 = r5.f12192c;	 Catch:{ all -> 0x005c }
                r2 = r2.zzbsd();	 Catch:{ all -> 0x005c }
                r2 = r2.zzbsv();	 Catch:{ all -> 0x005c }
                r3 = "Failed to get user properties";
                r2.zzj(r3, r0);	 Catch:{ all -> 0x005c }
                r0 = r2;	 Catch:{ all -> 0x0043 }
                r0.notify();	 Catch:{ all -> 0x0043 }
                goto L_0x0041;
            L_0x005c:
                r0 = move-exception;
                r2 = r2;	 Catch:{ all -> 0x0043 }
                r2.notify();	 Catch:{ all -> 0x0043 }
                throw r0;	 Catch:{ all -> 0x0043 }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.6.run():void");
            }
        });
    }

    protected void mo2375d() {
    }

    public void disconnect() {
        zzwu();
        m17715c();
        try {
            com.google.android.gms.common.stats.zzb.zzaux().zza(getContext(), this.f12204a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.f12205c = null;
    }

    protected void m17773e() {
        zzwu();
        m17715c();
        m17760a(new C33863(this));
    }

    protected void m17774f() {
        zzwu();
        m17715c();
        m17760a(new C33907(this));
    }

    void m17775g() {
        zzwu();
        m17715c();
        if (!isConnected()) {
            if (this.f12206d == null) {
                this.f12206d = zzbse().m17934i();
                if (this.f12206d == null) {
                    zzbsd().zzbtc().log("State of service unknown");
                    this.f12206d = Boolean.valueOf(m17776h());
                    zzbse().m17924a(this.f12206d.booleanValue());
                }
            }
            if (this.f12206d.booleanValue()) {
                zzbsd().zzbtc().log("Using measurement service");
                this.f12204a.zzbuw();
            } else if (!this.b.m17998h() && m17765j()) {
                zzbsd().zzbtc().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.f12204a.zzy(intent);
            } else if (zzbsf().zzabd()) {
                zzbsd().zzbtc().log("Using direct local measurement implementation");
                m17759a(new zzy(this.b, true));
            } else {
                zzbsd().zzbsv().log("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    protected boolean m17776h() {
        zzwu();
        m17715c();
        if (zzbsf().zzabc()) {
            return true;
        }
        zzbsd().zzbtc().log("Checking service availability");
        switch (com.google.android.gms.common.zzc.zzang().isGooglePlayServicesAvailable(getContext())) {
            case 0:
                zzbsd().zzbtc().log("Service available");
                return true;
            case 1:
                zzbsd().zzbtc().log("Service missing");
                return false;
            case 2:
                zzbsd().zzbtb().log("Service container out of date");
                return true;
            case 3:
                zzbsd().zzbsx().log("Service disabled");
                return false;
            case 9:
                zzbsd().zzbsx().log("Service invalid");
                return false;
            case 18:
                zzbsd().zzbsx().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    public boolean isConnected() {
        zzwu();
        m17715c();
        return this.f12205c != null;
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ zzc zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
