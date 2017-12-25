package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.stats.zzb;
import java.util.Collections;

public class zzi extends zzd {
    private final zza f10337a = new zza(this);
    private zzac f10338b;
    private final zzt f10339c;
    private zzal f10340d;

    protected class zza implements ServiceConnection {
        final /* synthetic */ zzi f10334a;
        private volatile zzac f10335b;
        private volatile boolean f10336c;

        protected zza(zzi com_google_android_gms_analytics_internal_zzi) {
            this.f10334a = com_google_android_gms_analytics_internal_zzi;
        }

        public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.analytics.internal.zzi.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0008, B:9:0x0015]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = "AnalyticsServiceConnection.onServiceConnected";
            com.google.android.gms.common.internal.zzab.zzhi(r0);
            monitor-enter(r4);
            if (r6 != 0) goto L_0x0014;
        L_0x0008:
            r0 = r4.f10334a;	 Catch:{ all -> 0x005a }
            r1 = "Service connected with null binder";	 Catch:{ all -> 0x005a }
            r0.zzel(r1);	 Catch:{ all -> 0x005a }
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        L_0x0013:
            return;
        L_0x0014:
            r0 = 0;
            r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0051 }
            r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0051 }
            r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0051 }
            if (r2 == 0) goto L_0x0049;	 Catch:{ RemoteException -> 0x0051 }
        L_0x0021:
            r0 = com.google.android.gms.analytics.internal.zzac.zza.zzbk(r6);	 Catch:{ RemoteException -> 0x0051 }
            r1 = r4.f10334a;	 Catch:{ RemoteException -> 0x0051 }
            r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0051 }
            r1.zzeh(r2);	 Catch:{ RemoteException -> 0x0051 }
        L_0x002c:
            if (r0 != 0) goto L_0x005f;
        L_0x002e:
            r0 = com.google.android.gms.common.stats.zzb.zzaux();	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r4.f10334a;	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r1.m16540g();	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r4.f10334a;	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r2.f10337a;	 Catch:{ IllegalArgumentException -> 0x007c }
            r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x007c }
        L_0x0041:
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            goto L_0x0013;	 Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception;	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            throw r0;
        L_0x0049:
            r2 = r4.f10334a;	 Catch:{ RemoteException -> 0x0051 }
            r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0051 }
            r2.zze(r3, r1);	 Catch:{ RemoteException -> 0x0051 }
            goto L_0x002c;
        L_0x0051:
            r1 = move-exception;
            r1 = r4.f10334a;	 Catch:{ all -> 0x005a }
            r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005a }
            r1.zzel(r2);	 Catch:{ all -> 0x005a }
            goto L_0x002c;
        L_0x005a:
            r0 = move-exception;
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            throw r0;	 Catch:{ all -> 0x0046 }
        L_0x005f:
            r1 = r4.f10336c;	 Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0079;	 Catch:{ all -> 0x005a }
        L_0x0063:
            r1 = r4.f10334a;	 Catch:{ all -> 0x005a }
            r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005a }
            r1.zzek(r2);	 Catch:{ all -> 0x005a }
            r1 = r4.f10334a;	 Catch:{ all -> 0x005a }
            r1 = r1.m16543j();	 Catch:{ all -> 0x005a }
            r2 = new com.google.android.gms.analytics.internal.zzi$zza$1;	 Catch:{ all -> 0x005a }
            r2.<init>(r4, r0);	 Catch:{ all -> 0x005a }
            r1.zzg(r2);	 Catch:{ all -> 0x005a }
            goto L_0x0041;	 Catch:{ all -> 0x005a }
        L_0x0079:
            r4.f10335b = r0;	 Catch:{ all -> 0x005a }
            goto L_0x0041;
        L_0x007c:
            r0 = move-exception;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzi.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(final ComponentName componentName) {
            zzab.zzhi("AnalyticsServiceConnection.onServiceDisconnected");
            this.f10334a.m16543j().zzg(new Runnable(this) {
                final /* synthetic */ zza f10333b;

                public void run() {
                    this.f10333b.f10334a.m16661a(componentName);
                }
            });
        }

        public zzac zzzv() {
            zzac com_google_android_gms_analytics_internal_zzac = null;
            this.f10334a.m16538e();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context g = this.f10334a.m16540g();
            intent.putExtra("app_package_name", g.getPackageName());
            zzb zzaux = zzb.zzaux();
            synchronized (this) {
                this.f10335b = null;
                this.f10336c = true;
                boolean zza = zzaux.zza(g, intent, this.f10334a.f10337a, 129);
                this.f10334a.zza("Bind to service requested", Boolean.valueOf(zza));
                if (zza) {
                    try {
                        wait(this.f10334a.m16542i().zzaby());
                    } catch (InterruptedException e) {
                        this.f10334a.zzek("Wait for service connect was interrupted");
                    }
                    this.f10336c = false;
                    com_google_android_gms_analytics_internal_zzac = this.f10335b;
                    this.f10335b = null;
                    if (com_google_android_gms_analytics_internal_zzac == null) {
                        this.f10334a.zzel("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.f10336c = false;
                }
            }
            return com_google_android_gms_analytics_internal_zzac;
        }
    }

    protected zzi(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.f10340d = new zzal(com_google_android_gms_analytics_internal_zzf.zzyw());
        this.f10339c = new zzt(this, com_google_android_gms_analytics_internal_zzf) {
            final /* synthetic */ zzi f10329a;

            public void run() {
                this.f10329a.m16667c();
            }
        };
    }

    private void m16661a(ComponentName componentName) {
        m16538e();
        if (this.f10338b != null) {
            this.f10338b = null;
            zza("Disconnected from device AnalyticsService", componentName);
            m16668t();
        }
    }

    private void m16662a(zzac com_google_android_gms_analytics_internal_zzac) {
        m16538e();
        this.f10338b = com_google_android_gms_analytics_internal_zzac;
        m16665b();
        m16544k().m16639b();
    }

    private void m16665b() {
        this.f10340d.start();
        this.f10339c.zzv(m16542i().zzabx());
    }

    private void m16667c() {
        m16538e();
        if (isConnected()) {
            zzeh("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    private void m16668t() {
        m16544k().zzyr();
    }

    protected void mo1605a() {
    }

    public boolean connect() {
        m16538e();
        m16553s();
        if (this.f10338b != null) {
            return true;
        }
        zzac zzzv = this.f10337a.zzzv();
        if (zzzv == null) {
            return false;
        }
        this.f10338b = zzzv;
        m16665b();
        return true;
    }

    public void disconnect() {
        m16538e();
        m16553s();
        try {
            zzb.zzaux().zza(m16540g(), this.f10337a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.f10338b != null) {
            this.f10338b = null;
            m16668t();
        }
    }

    public boolean isConnected() {
        m16538e();
        m16553s();
        return this.f10338b != null;
    }

    public boolean zzb(zzab com_google_android_gms_analytics_internal_zzab) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzab);
        m16538e();
        m16553s();
        zzac com_google_android_gms_analytics_internal_zzac = this.f10338b;
        if (com_google_android_gms_analytics_internal_zzac == null) {
            return false;
        }
        try {
            com_google_android_gms_analytics_internal_zzac.zza(com_google_android_gms_analytics_internal_zzab.zzm(), com_google_android_gms_analytics_internal_zzab.zzacz(), com_google_android_gms_analytics_internal_zzab.zzadb() ? m16542i().zzabq() : m16542i().zzabr(), Collections.emptyList());
            m16665b();
            return true;
        } catch (RemoteException e) {
            zzeh("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public boolean zzzs() {
        m16538e();
        m16553s();
        zzac com_google_android_gms_analytics_internal_zzac = this.f10338b;
        if (com_google_android_gms_analytics_internal_zzac == null) {
            return false;
        }
        try {
            com_google_android_gms_analytics_internal_zzac.zzyo();
            m16665b();
            return true;
        } catch (RemoteException e) {
            zzeh("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
