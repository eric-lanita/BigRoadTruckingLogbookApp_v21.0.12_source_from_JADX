package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.analytics.zze;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzmd;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class zzl extends zzd {
    private boolean f10355a;
    private final zzj f10356b;
    private final zzah f10357c;
    private final zzag f10358d;
    private final zzi f10359e;
    private long f10360f = Long.MIN_VALUE;
    private final zzt f10361g;
    private final zzt f10362h;
    private final zzal f10363i;
    private long f10364j;
    private boolean f10365k;

    class C31993 implements Runnable {
        final /* synthetic */ zzl f10350a;

        C31993(zzl com_google_android_gms_analytics_internal_zzl) {
            this.f10350a = com_google_android_gms_analytics_internal_zzl;
        }

        public void run() {
            this.f10350a.m16707c();
        }
    }

    class C32004 implements zzw {
        final /* synthetic */ zzl f10351a;

        C32004(zzl com_google_android_gms_analytics_internal_zzl) {
            this.f10351a = com_google_android_gms_analytics_internal_zzl;
        }

        public void zzd(Throwable th) {
            this.f10351a.zzaam();
        }
    }

    protected zzl(zzf com_google_android_gms_analytics_internal_zzf, zzg com_google_android_gms_analytics_internal_zzg) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzab.zzy(com_google_android_gms_analytics_internal_zzg);
        this.f10358d = com_google_android_gms_analytics_internal_zzg.m16654k(com_google_android_gms_analytics_internal_zzf);
        this.f10356b = com_google_android_gms_analytics_internal_zzg.zzm(com_google_android_gms_analytics_internal_zzf);
        this.f10357c = com_google_android_gms_analytics_internal_zzg.zzn(com_google_android_gms_analytics_internal_zzf);
        this.f10359e = com_google_android_gms_analytics_internal_zzg.zzo(com_google_android_gms_analytics_internal_zzf);
        this.f10363i = new zzal(m16539f());
        this.f10361g = new zzt(this, com_google_android_gms_analytics_internal_zzf) {
            final /* synthetic */ zzl f10348a;

            public void run() {
                this.f10348a.m16701y();
            }
        };
        this.f10362h = new zzt(this, com_google_android_gms_analytics_internal_zzf) {
            final /* synthetic */ zzl f10349a;

            public void run() {
                this.f10349a.m16702z();
            }
        };
    }

    private boolean m16690A() {
        return this.f10365k ? false : (!m16542i().zzabc() || m16542i().zzabd()) && zzaat() > 0;
    }

    private void m16691B() {
        zzv l = m16545l();
        if (l.zzacm() && !l.zzfc()) {
            long zzzz = zzzz();
            if (zzzz != 0 && Math.abs(m16539f().currentTimeMillis() - zzzz) <= m16542i().zzabm()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(m16542i().zzabl()));
                l.schedule();
            }
        }
    }

    private void m16692C() {
        m16691B();
        long zzaat = zzaat();
        long zzadp = m16547n().zzadp();
        if (zzadp != 0) {
            zzadp = zzaat - Math.abs(m16539f().currentTimeMillis() - zzadp);
            if (zzadp <= 0) {
                zzadp = Math.min(m16542i().zzabj(), zzaat);
            }
        } else {
            zzadp = Math.min(m16542i().zzabj(), zzaat);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(zzadp));
        if (this.f10361g.zzfc()) {
            this.f10361g.zzw(Math.max(1, zzadp + this.f10361g.zzacj()));
            return;
        }
        this.f10361g.zzv(zzadp);
    }

    private void m16693D() {
        m16694E();
        m16695F();
    }

    private void m16694E() {
        if (this.f10361g.zzfc()) {
            zzeh("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f10361g.cancel();
    }

    private void m16695F() {
        zzv l = m16545l();
        if (l.zzfc()) {
            l.cancel();
        }
    }

    private void m16696a(zzh com_google_android_gms_analytics_internal_zzh, zzlv com_google_android_gms_internal_zzlv) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzh);
        zzab.zzy(com_google_android_gms_internal_zzlv);
        zza com_google_android_gms_analytics_zza = new zza(zzyu());
        com_google_android_gms_analytics_zza.zzdg(com_google_android_gms_analytics_internal_zzh.zzzp());
        com_google_android_gms_analytics_zza.enableAdvertisingIdCollection(com_google_android_gms_analytics_internal_zzh.zzzq());
        zze zzvr = com_google_android_gms_analytics_zza.zzvr();
        zzmd com_google_android_gms_internal_zzmd = (zzmd) zzvr.zzb(zzmd.class);
        com_google_android_gms_internal_zzmd.zzdw(ShareConstants.WEB_DIALOG_PARAM_DATA);
        com_google_android_gms_internal_zzmd.zzap(true);
        zzvr.zza((zzg) com_google_android_gms_internal_zzlv);
        zzly com_google_android_gms_internal_zzly = (zzly) zzvr.zzb(zzly.class);
        zzlu com_google_android_gms_internal_zzlu = (zzlu) zzvr.zzb(zzlu.class);
        for (Entry entry : com_google_android_gms_analytics_internal_zzh.zzm().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                com_google_android_gms_internal_zzlu.setAppName(str2);
            } else if ("av".equals(str)) {
                com_google_android_gms_internal_zzlu.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                com_google_android_gms_internal_zzlu.setAppId(str2);
            } else if ("aiid".equals(str)) {
                com_google_android_gms_internal_zzlu.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                com_google_android_gms_internal_zzmd.setUserId(str2);
            } else {
                com_google_android_gms_internal_zzly.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", com_google_android_gms_analytics_internal_zzh.zzzp(), com_google_android_gms_internal_zzlv);
        zzvr.zzn(m16547n().zzadn());
        zzvr.zzwj();
    }

    private boolean m16698a(String str) {
        return m16540g().checkCallingOrSelfPermission(str) == 0;
    }

    private void m16700x() {
        m16538e();
        Context context = zzyu().getContext();
        if (!zzaj.zzav(context)) {
            zzek("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!zzak.zzaw(context)) {
            zzel("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzav(context)) {
            zzek("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.zzaw(context)) {
            zzek("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    private void m16701y() {
        zzb(new C32004(this));
    }

    private void m16702z() {
        try {
            this.f10356b.zzzy();
            zzaam();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.f10362h.zzv(m16542i().zzace());
    }

    zzab m16703a(zzab com_google_android_gms_analytics_internal_zzab) {
        if (!TextUtils.isEmpty(com_google_android_gms_analytics_internal_zzab.zzadd())) {
            return com_google_android_gms_analytics_internal_zzab;
        }
        Pair zzadv = m16547n().zzads().zzadv();
        if (zzadv == null) {
            return com_google_android_gms_analytics_internal_zzab;
        }
        Long l = (Long) zzadv.second;
        String str = (String) zzadv.first;
        String valueOf = String.valueOf(l);
        valueOf = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
        Map hashMap = new HashMap(com_google_android_gms_analytics_internal_zzab.zzm());
        hashMap.put("_m", valueOf);
        return zzab.zza(this, com_google_android_gms_analytics_internal_zzab, hashMap);
    }

    protected void mo1605a() {
        this.f10356b.initialize();
        this.f10357c.initialize();
        this.f10359e.initialize();
    }

    protected void m16705a(zzh com_google_android_gms_analytics_internal_zzh) {
        m16538e();
        zzb("Sending first hit to property", com_google_android_gms_analytics_internal_zzh.zzzp());
        if (!m16547n().zzado().zzx(m16542i().zzach())) {
            String zzadr = m16547n().zzadr();
            if (!TextUtils.isEmpty(zzadr)) {
                zzlv zza = zzao.zza(m16541h(), zzadr);
                zzb("Found relevant installation campaign", zza);
                m16696a(com_google_android_gms_analytics_internal_zzh, zza);
            }
        }
    }

    void m16706b() {
        m16553s();
        zzab.zza(!this.f10355a, (Object) "Analytics backend already started");
        this.f10355a = true;
        m16543j().zzg(new C31993(this));
    }

    protected void m16707c() {
        m16553s();
        if (!m16542i().zzabc()) {
            m16700x();
        }
        m16547n().zzadn();
        if (!m16698a("android.permission.ACCESS_NETWORK_STATE")) {
            zzel("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzaau();
        }
        if (!m16698a("android.permission.INTERNET")) {
            zzel("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzaau();
        }
        if (zzak.zzaw(m16540g())) {
            zzeh("AnalyticsService registered in the app manifest and enabled");
        } else if (m16542i().zzabc()) {
            zzel("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzek("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.f10365k || m16542i().zzabc() || this.f10356b.m16687b())) {
            m16710v();
        }
        zzaam();
    }

    void m16708t() {
        m16538e();
        this.f10364j = m16539f().currentTimeMillis();
    }

    protected void m16709u() {
        m16538e();
        if (!m16542i().zzabc()) {
            zzaaj();
        }
    }

    protected void m16710v() {
        if (!this.f10365k && m16542i().zzabe() && !this.f10359e.isConnected()) {
            if (this.f10363i.zzx(m16542i().zzabz())) {
                this.f10363i.start();
                zzeh("Connecting to service");
                if (this.f10359e.connect()) {
                    zzeh("Connected to service");
                    this.f10363i.clear();
                    m16709u();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean m16711w() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.analytics.zzi.zzwu();
        r12.m16553s();
        r0 = "Dispatching a batch of local hits";
        r12.zzeh(r0);
        r0 = r12.f10359e;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0032;
    L_0x0015:
        r0 = r12.m16542i();
        r0 = r0.zzabc();
        if (r0 != 0) goto L_0x0032;
    L_0x001f:
        r0 = r1;
    L_0x0020:
        r3 = r12.f10357c;
        r3 = r3.zzadj();
        if (r3 != 0) goto L_0x0034;
    L_0x0028:
        if (r0 == 0) goto L_0x0036;
    L_0x002a:
        if (r1 == 0) goto L_0x0036;
    L_0x002c:
        r0 = "No network or service available. Will retry later";
        r12.zzeh(r0);
    L_0x0031:
        return r2;
    L_0x0032:
        r0 = r2;
        goto L_0x0020;
    L_0x0034:
        r1 = r2;
        goto L_0x0028;
    L_0x0036:
        r0 = r12.m16542i();
        r0 = r0.zzabn();
        r1 = r12.m16542i();
        r1 = r1.zzabo();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x0052:
        r0 = r12.f10356b;	 Catch:{ all -> 0x01eb }
        r0.beginTransaction();	 Catch:{ all -> 0x01eb }
        r3.clear();	 Catch:{ all -> 0x01eb }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x00d3 }
        r8 = r0.zzr(r6);	 Catch:{ SQLiteException -> 0x00d3 }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00d3 }
        if (r0 == 0) goto L_0x0083;
    L_0x0066:
        r0 = "Store is empty, nothing to dispatch";
        r12.zzeh(r0);	 Catch:{ SQLiteException -> 0x00d3 }
        r12.m16693D();	 Catch:{ SQLiteException -> 0x00d3 }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x0079 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0079 }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x0079 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0079 }
        goto L_0x0031;
    L_0x0079:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x0083:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00d3 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00d3 }
        r12.zza(r0, r1);	 Catch:{ SQLiteException -> 0x00d3 }
        r1 = r8.iterator();	 Catch:{ all -> 0x01eb }
    L_0x0094:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01eb }
        if (r0 == 0) goto L_0x00f3;
    L_0x009a:
        r0 = r1.next();	 Catch:{ all -> 0x01eb }
        r0 = (com.google.android.gms.analytics.internal.zzab) r0;	 Catch:{ all -> 0x01eb }
        r10 = r0.zzacy();	 Catch:{ all -> 0x01eb }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0094;
    L_0x00a8:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01eb }
        r3 = r8.size();	 Catch:{ all -> 0x01eb }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01eb }
        r12.zzd(r0, r1, r3);	 Catch:{ all -> 0x01eb }
        r12.m16693D();	 Catch:{ all -> 0x01eb }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x00c8 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00c8 }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x00c8 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00c8 }
        goto L_0x0031;
    L_0x00c8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x00d3:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.zzd(r1, r0);	 Catch:{ all -> 0x01eb }
        r12.m16693D();	 Catch:{ all -> 0x01eb }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x00e8 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00e8 }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x00e8 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00e8 }
        goto L_0x0031;
    L_0x00e8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x00f3:
        r0 = r12.f10359e;	 Catch:{ all -> 0x01eb }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01eb }
        if (r0 == 0) goto L_0x0202;
    L_0x00fb:
        r0 = r12.m16542i();	 Catch:{ all -> 0x01eb }
        r0 = r0.zzabc();	 Catch:{ all -> 0x01eb }
        if (r0 != 0) goto L_0x0202;
    L_0x0105:
        r0 = "Service connected, sending hits to the service";
        r12.zzeh(r0);	 Catch:{ all -> 0x01eb }
    L_0x010a:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01eb }
        if (r0 != 0) goto L_0x0202;
    L_0x0110:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01eb }
        r0 = (com.google.android.gms.analytics.internal.zzab) r0;	 Catch:{ all -> 0x01eb }
        r1 = r12.f10359e;	 Catch:{ all -> 0x01eb }
        r1 = r1.zzb(r0);	 Catch:{ all -> 0x01eb }
        if (r1 != 0) goto L_0x0148;
    L_0x011f:
        r0 = r4;
    L_0x0120:
        r4 = r12.f10357c;	 Catch:{ all -> 0x01eb }
        r4 = r4.zzadj();	 Catch:{ all -> 0x01eb }
        if (r4 == 0) goto L_0x0196;
    L_0x0128:
        r4 = r12.f10357c;	 Catch:{ all -> 0x01eb }
        r8 = r4.zzs(r8);	 Catch:{ all -> 0x01eb }
        r9 = r8.iterator();	 Catch:{ all -> 0x01eb }
        r4 = r0;
    L_0x0133:
        r0 = r9.hasNext();	 Catch:{ all -> 0x01eb }
        if (r0 == 0) goto L_0x018d;
    L_0x0139:
        r0 = r9.next();	 Catch:{ all -> 0x01eb }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01eb }
        r0 = r0.longValue();	 Catch:{ all -> 0x01eb }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01eb }
        goto L_0x0133;
    L_0x0148:
        r10 = r0.zzacy();	 Catch:{ all -> 0x01eb }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01eb }
        r8.remove(r0);	 Catch:{ all -> 0x01eb }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.zzb(r1, r0);	 Catch:{ all -> 0x01eb }
        r1 = r12.f10356b;	 Catch:{ SQLiteException -> 0x016d }
        r10 = r0.zzacy();	 Catch:{ SQLiteException -> 0x016d }
        r1.zzs(r10);	 Catch:{ SQLiteException -> 0x016d }
        r0 = r0.zzacy();	 Catch:{ SQLiteException -> 0x016d }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x016d }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x016d }
        goto L_0x010a;
    L_0x016d:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01eb }
        r12.m16693D();	 Catch:{ all -> 0x01eb }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x0182 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0182 }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x0182 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0182 }
        goto L_0x0031;
    L_0x0182:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x018d:
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01b3 }
        r0.zzq(r8);	 Catch:{ SQLiteException -> 0x01b3 }
        r3.addAll(r8);	 Catch:{ SQLiteException -> 0x01b3 }
        r0 = r4;
    L_0x0196:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01eb }
        if (r4 == 0) goto L_0x01d3;
    L_0x019c:
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01a8 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01a8 }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01a8 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01a8 }
        goto L_0x0031;
    L_0x01a8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x01b3:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01eb }
        r12.m16693D();	 Catch:{ all -> 0x01eb }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01c8 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01c8 }
        r0 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01c8 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01c8 }
        goto L_0x0031;
    L_0x01c8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x01d3:
        r4 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01e0 }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01e0 }
        r4 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01e0 }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01e0 }
        r4 = r0;
        goto L_0x0052;
    L_0x01e0:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x01eb:
        r0 = move-exception;
        r1 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01f7 }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01f7 }
        r1 = r12.f10356b;	 Catch:{ SQLiteException -> 0x01f7 }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01f7 }
        throw r0;
    L_0x01f7:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.m16693D();
        goto L_0x0031;
    L_0x0202:
        r0 = r4;
        goto L_0x0120;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.w():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long zza(com.google.android.gms.analytics.internal.zzh r6, boolean r7) {
        /*
        r5 = this;
        com.google.android.gms.common.internal.zzab.zzy(r6);
        r5.m16553s();
        r5.m16538e();
        r0 = r5.f10356b;	 Catch:{ SQLiteException -> 0x0049 }
        r0.beginTransaction();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.f10356b;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.zzzo();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.zzwb();	 Catch:{ SQLiteException -> 0x0049 }
        r0.zza(r2, r1);	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.f10356b;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.zzzo();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.zzwb();	 Catch:{ SQLiteException -> 0x0049 }
        r4 = r6.zzzp();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r0.zza(r2, r1, r4);	 Catch:{ SQLiteException -> 0x0049 }
        if (r7 != 0) goto L_0x0042;
    L_0x002f:
        r6.zzp(r0);	 Catch:{ SQLiteException -> 0x0049 }
    L_0x0032:
        r2 = r5.f10356b;	 Catch:{ SQLiteException -> 0x0049 }
        r2.zzb(r6);	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.f10356b;	 Catch:{ SQLiteException -> 0x0049 }
        r2.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.f10356b;	 Catch:{ SQLiteException -> 0x0057 }
        r2.endTransaction();	 Catch:{ SQLiteException -> 0x0057 }
    L_0x0041:
        return r0;
    L_0x0042:
        r2 = 1;
        r2 = r2 + r0;
        r6.zzp(r2);	 Catch:{ SQLiteException -> 0x0049 }
        goto L_0x0032;
    L_0x0049:
        r0 = move-exception;
        r1 = "Failed to update Analytics property";
        r5.zze(r1, r0);	 Catch:{ all -> 0x0065 }
        r0 = r5.f10356b;	 Catch:{ SQLiteException -> 0x005e }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x005e }
    L_0x0054:
        r0 = -1;
        goto L_0x0041;
    L_0x0057:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.zze(r3, r2);
        goto L_0x0041;
    L_0x005e:
        r0 = move-exception;
        r1 = "Failed to end transaction";
        r5.zze(r1, r0);
        goto L_0x0054;
    L_0x0065:
        r0 = move-exception;
        r1 = r5.f10356b;	 Catch:{ SQLiteException -> 0x006c }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x006c }
    L_0x006b:
        throw r0;
    L_0x006c:
        r1 = move-exception;
        r2 = "Failed to end transaction";
        r5.zze(r2, r1);
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zza(com.google.android.gms.analytics.internal.zzh, boolean):long");
    }

    public void zza(zzab com_google_android_gms_analytics_internal_zzab) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzab);
        zzi.zzwu();
        m16553s();
        if (this.f10365k) {
            zzei("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", com_google_android_gms_analytics_internal_zzab);
        }
        zzab a = m16703a(com_google_android_gms_analytics_internal_zzab);
        m16710v();
        if (this.f10359e.zzb(a)) {
            zzei("Hit sent to the device AnalyticsService for delivery");
        } else if (m16542i().zzabc()) {
            m16541h().zza(a, "Service unavailable on package side");
        } else {
            try {
                this.f10356b.zzc(a);
                zzaam();
            } catch (SQLiteException e) {
                zze("Delivery failed to save hit to a database", e);
                m16541h().zza(a, "deliver: failed to insert hit to database");
            }
        }
    }

    public void zza(final zzw com_google_android_gms_analytics_internal_zzw, final long j) {
        zzi.zzwu();
        m16553s();
        long j2 = -1;
        long zzadp = m16547n().zzadp();
        if (zzadp != 0) {
            j2 = Math.abs(m16539f().currentTimeMillis() - zzadp);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!m16542i().zzabc()) {
            m16710v();
        }
        try {
            if (m16711w()) {
                m16543j().zzg(new Runnable(this) {
                    final /* synthetic */ zzl f10354c;

                    public void run() {
                        this.f10354c.zza(com_google_android_gms_analytics_internal_zzw, j);
                    }
                });
                return;
            }
            m16547n().zzadq();
            zzaam();
            if (com_google_android_gms_analytics_internal_zzw != null) {
                com_google_android_gms_analytics_internal_zzw.zzd(null);
            }
            if (this.f10364j != j) {
                this.f10358d.zzadi();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            m16547n().zzadq();
            zzaam();
            if (com_google_android_gms_analytics_internal_zzw != null) {
                com_google_android_gms_analytics_internal_zzw.zzd(th);
            }
        }
    }

    public void zzaaj() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        com.google.android.gms.analytics.zzi.zzwu();
        r6.m16553s();
        r6.m16537d();
        r0 = r6.m16542i();
        r0 = r0.zzabe();
        if (r0 != 0) goto L_0x0018;
    L_0x0013:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.zzek(r0);
    L_0x0018:
        r0 = r6.f10359e;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0026;
    L_0x0020:
        r0 = "Service not connected";
        r6.zzeh(r0);
    L_0x0025:
        return;
    L_0x0026:
        r0 = r6.f10356b;
        r0 = r0.m16687b();
        if (r0 != 0) goto L_0x0025;
    L_0x002e:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.zzeh(r0);
    L_0x0033:
        r0 = r6.f10356b;	 Catch:{ SQLiteException -> 0x004c }
        r1 = r6.m16542i();	 Catch:{ SQLiteException -> 0x004c }
        r1 = r1.zzabn();	 Catch:{ SQLiteException -> 0x004c }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x004c }
        r1 = r0.zzr(r2);	 Catch:{ SQLiteException -> 0x004c }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x004c }
        if (r0 == 0) goto L_0x0062;	 Catch:{ SQLiteException -> 0x004c }
    L_0x0048:
        r6.zzaam();	 Catch:{ SQLiteException -> 0x004c }
        goto L_0x0025;
    L_0x004c:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.zze(r1, r0);
        r6.m16693D();
        goto L_0x0025;
    L_0x0056:
        r1.remove(r0);
        r2 = r6.f10356b;	 Catch:{ SQLiteException -> 0x007b }
        r4 = r0.zzacy();	 Catch:{ SQLiteException -> 0x007b }
        r2.zzs(r4);	 Catch:{ SQLiteException -> 0x007b }
    L_0x0062:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x0033;
    L_0x0068:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.analytics.internal.zzab) r0;
        r2 = r6.f10359e;
        r2 = r2.zzb(r0);
        if (r2 != 0) goto L_0x0056;
    L_0x0077:
        r6.zzaam();
        goto L_0x0025;
    L_0x007b:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.zze(r1, r0);
        r6.m16693D();
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zzaaj():void");
    }

    public void zzaal() {
        zzi.zzwu();
        m16553s();
        zzei("Sync dispatching local hits");
        long j = this.f10364j;
        if (!m16542i().zzabc()) {
            m16710v();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zzaam();
                return;
            }
        } while (m16711w());
        m16547n().zzadq();
        zzaam();
        if (this.f10364j != j) {
            this.f10358d.zzadi();
        }
    }

    public void zzaam() {
        zzyu().zzwu();
        m16553s();
        if (!m16690A()) {
            this.f10358d.unregister();
            m16693D();
        } else if (this.f10356b.m16687b()) {
            this.f10358d.unregister();
            m16693D();
        } else {
            boolean z;
            if (((Boolean) zzy.f10408u.get()).booleanValue()) {
                z = true;
            } else {
                this.f10358d.zzadg();
                z = this.f10358d.isConnected();
            }
            if (z) {
                m16692C();
                return;
            }
            m16693D();
            m16691B();
        }
    }

    public long zzaat() {
        if (this.f10360f != Long.MIN_VALUE) {
            return this.f10360f;
        }
        return m16546m().zzact() ? ((long) m16546m().zzaek()) * 1000 : m16542i().zzabk();
    }

    public void zzaau() {
        m16553s();
        m16538e();
        this.f10365k = true;
        this.f10359e.disconnect();
        zzaam();
    }

    public void zzas(boolean z) {
        zzaam();
    }

    public void zzb(zzw com_google_android_gms_analytics_internal_zzw) {
        zza(com_google_android_gms_analytics_internal_zzw, this.f10364j);
    }

    public void zzep(String str) {
        zzab.zzhr(str);
        m16538e();
        m16537d();
        zzlv zza = zzao.zza(m16541h(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence zzadr = m16547n().zzadr();
        if (str.equals(zzadr)) {
            zzek("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(zzadr)) {
            m16547n().zzeu(str);
            if (m16547n().zzado().zzx(m16542i().zzach())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzh a : this.f10356b.zzt(0)) {
                m16696a(a, zza);
            }
        } else {
            zzd("Ignoring multiple install campaigns. original, new", zzadr, str);
        }
    }

    public void zzu(long j) {
        zzi.zzwu();
        m16553s();
        if (j < 0) {
            j = 0;
        }
        this.f10360f = j;
        zzaam();
    }

    public void zzyo() {
        zzi.zzwu();
        m16553s();
        if (!m16542i().zzabc()) {
            zzeh("Delete all hits from local store");
            try {
                this.f10356b.zzzw();
                this.f10356b.zzzx();
                zzaam();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        m16710v();
        if (this.f10359e.zzzs()) {
            zzeh("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zzyr() {
        zzi.zzwu();
        m16553s();
        zzeh("Service disconnected");
    }

    public long zzzz() {
        zzi.zzwu();
        m16553s();
        try {
            return this.f10356b.zzzz();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }
}
