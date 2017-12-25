package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzadv;
import com.google.android.gms.internal.zzah.zzj;
import com.google.android.gms.internal.zzpo;

public class zzp extends zzpo<ContainerHolder> {
    private final com.google.android.gms.common.util.zze f12796d;
    private final zzd f12797e;
    private final Looper f12798f;
    private final zzck f12799g;
    private final int f12800h;
    private final Context f12801i;
    private final TagManager f12802j;
    private final String f12803k;
    private zzf f12804l;
    private zzadv f12805m;
    private volatile zzo f12806n;
    private volatile boolean f12807o;
    private zzj f12808p;
    private long f12809q;
    private String f12810r;
    private zze f12811s;
    private zza f12812t;

    interface zze extends Releasable {
        void zza(zzbm<zzj> com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzah_zzj);

        void zzf(long j, String str);

        void zzol(String str);
    }

    interface zzf extends Releasable {
        void zza(zzbm<com.google.android.gms.internal.zzadu.zza> com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzadu_zza);

        void zzb(com.google.android.gms.internal.zzadu.zza com_google_android_gms_internal_zzadu_zza);

        void zzcav();

        com.google.android.gms.internal.zzadw.zzc zzze(int i);
    }

    class C34481 {
    }

    class C34492 implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp f12790a;

        C34492(zzp com_google_android_gms_tagmanager_zzp) {
            this.f12790a = com_google_android_gms_tagmanager_zzp;
        }

        public String zzcan() {
            return this.f12790a.mo2509c();
        }

        public void zzcap() {
            zzbn.zzcx("Refresh ignored: container loaded as default only.");
        }

        public void zzoi(String str) {
            this.f12790a.m18247a(str);
        }
    }

    interface zza {
        boolean zzb(Container container);
    }

    private class zzb implements zzbm<com.google.android.gms.internal.zzadu.zza> {
        final /* synthetic */ zzp f12793a;

        private zzb(zzp com_google_android_gms_tagmanager_zzp) {
            this.f12793a = com_google_android_gms_tagmanager_zzp;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            zza((com.google.android.gms.internal.zzadu.zza) obj);
        }

        public void zza(com.google.android.gms.internal.zzadu.zza com_google_android_gms_internal_zzadu_zza) {
            zzj com_google_android_gms_internal_zzah_zzj;
            if (com_google_android_gms_internal_zzadu_zza.aCW != null) {
                com_google_android_gms_internal_zzah_zzj = com_google_android_gms_internal_zzadu_zza.aCW;
            } else {
                com.google.android.gms.internal.zzah.zzf com_google_android_gms_internal_zzah_zzf = com_google_android_gms_internal_zzadu_zza.zzwr;
                com_google_android_gms_internal_zzah_zzj = new zzj();
                com_google_android_gms_internal_zzah_zzj.zzwr = com_google_android_gms_internal_zzah_zzf;
                com_google_android_gms_internal_zzah_zzj.zzwq = null;
                com_google_android_gms_internal_zzah_zzj.zzws = com_google_android_gms_internal_zzah_zzf.version;
            }
            this.f12793a.m18234a(com_google_android_gms_internal_zzah_zzj, com_google_android_gms_internal_zzadu_zza.aCV, true);
        }

        public void zza(com.google.android.gms.tagmanager.zzbm.zza com_google_android_gms_tagmanager_zzbm_zza) {
            if (!this.f12793a.f12807o) {
                this.f12793a.m18232a(0);
            }
        }

        public void zzcau() {
        }
    }

    private class zzc implements zzbm<zzj> {
        final /* synthetic */ zzp f12794a;

        private zzc(zzp com_google_android_gms_tagmanager_zzp) {
            this.f12794a = com_google_android_gms_tagmanager_zzp;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            zzb((zzj) obj);
        }

        public void zza(com.google.android.gms.tagmanager.zzbm.zza com_google_android_gms_tagmanager_zzbm_zza) {
            synchronized (this.f12794a) {
                if (!this.f12794a.isReady()) {
                    if (this.f12794a.f12806n != null) {
                        this.f12794a.zzc(this.f12794a.f12806n);
                    } else {
                        this.f12794a.zzc(this.f12794a.m18246a(Status.st));
                    }
                }
            }
            this.f12794a.m18232a(3600000);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzb(com.google.android.gms.internal.zzah.zzj r6) {
            /*
            r5 = this;
            r1 = r5.f12794a;
            monitor-enter(r1);
            r0 = r6.zzwr;	 Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x002a;
        L_0x0007:
            r0 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r0 = r0.f12808p;	 Catch:{ all -> 0x0067 }
            r0 = r0.zzwr;	 Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x0020;
        L_0x0011:
            r0 = "Current resource is null; network resource is also null";
            com.google.android.gms.tagmanager.zzbn.m18105e(r0);	 Catch:{ all -> 0x0067 }
            r0 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r0.m18232a(r2);	 Catch:{ all -> 0x0067 }
            monitor-exit(r1);	 Catch:{ all -> 0x0067 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r0 = r0.f12808p;	 Catch:{ all -> 0x0067 }
            r0 = r0.zzwr;	 Catch:{ all -> 0x0067 }
            r6.zzwr = r0;	 Catch:{ all -> 0x0067 }
        L_0x002a:
            r0 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r2 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r2 = r2.f12796d;	 Catch:{ all -> 0x0067 }
            r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0067 }
            r4 = 0;
            r0.m18234a(r6, r2, r4);	 Catch:{ all -> 0x0067 }
            r0 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r2 = r0.f12809q;	 Catch:{ all -> 0x0067 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0067 }
            r4 = 58;
            r0.<init>(r4);	 Catch:{ all -> 0x0067 }
            r4 = "setting refresh time to current time: ";
            r0 = r0.append(r4);	 Catch:{ all -> 0x0067 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0067 }
            r0 = r0.toString();	 Catch:{ all -> 0x0067 }
            com.google.android.gms.tagmanager.zzbn.m18106v(r0);	 Catch:{ all -> 0x0067 }
            r0 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r0 = r0.m18241d();	 Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x0065;
        L_0x0060:
            r0 = r5.f12794a;	 Catch:{ all -> 0x0067 }
            r0.m18233a(r6);	 Catch:{ all -> 0x0067 }
        L_0x0065:
            monitor-exit(r1);	 Catch:{ all -> 0x0067 }
            goto L_0x001f;
        L_0x0067:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0067 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zzc.zzb(com.google.android.gms.internal.zzah$zzj):void");
        }

        public void zzcau() {
        }
    }

    private class zzd implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp f12795a;

        private zzd(zzp com_google_android_gms_tagmanager_zzp) {
            this.f12795a = com_google_android_gms_tagmanager_zzp;
        }

        public String zzcan() {
            return this.f12795a.mo2509c();
        }

        public void zzcap() {
            if (this.f12795a.f12799g.zzade()) {
                this.f12795a.m18232a(0);
            }
        }

        public void zzoi(String str) {
            this.f12795a.m18247a(str);
        }
    }

    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf com_google_android_gms_tagmanager_zzp_zzf, zze com_google_android_gms_tagmanager_zzp_zze, zzadv com_google_android_gms_internal_zzadv, com.google.android.gms.common.util.zze com_google_android_gms_common_util_zze, zzck com_google_android_gms_tagmanager_zzck) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.f12801i = context;
        this.f12802j = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.f12798f = looper;
        this.f12803k = str;
        this.f12800h = i;
        this.f12804l = com_google_android_gms_tagmanager_zzp_zzf;
        this.f12811s = com_google_android_gms_tagmanager_zzp_zze;
        this.f12805m = com_google_android_gms_internal_zzadv;
        this.f12797e = new zzd();
        this.f12808p = new zzj();
        this.f12796d = com_google_android_gms_common_util_zze;
        this.f12799g = com_google_android_gms_tagmanager_zzck;
        if (m18241d()) {
            m18247a(zzci.m18128a().m18133c());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, tagManager, looper, str, i, new zzcu(context, str), new zzct(context, str, com_google_android_gms_tagmanager_zzs), new zzadv(context), zzh.zzavm(), new zzbl(30, 900000, 5000, "refreshing", zzh.zzavm()));
        this.f12805m.zzqi(com_google_android_gms_tagmanager_zzs.zzcaw());
    }

    private synchronized void m18232a(long j) {
        if (this.f12811s == null) {
            zzbn.zzcx("Refresh requested, but no network load scheduler.");
        } else {
            this.f12811s.zzf(j, this.f12808p.zzws);
        }
    }

    private synchronized void m18233a(zzj com_google_android_gms_internal_zzah_zzj) {
        if (this.f12804l != null) {
            com.google.android.gms.internal.zzadu.zza com_google_android_gms_internal_zzadu_zza = new com.google.android.gms.internal.zzadu.zza();
            com_google_android_gms_internal_zzadu_zza.aCV = this.f12809q;
            com_google_android_gms_internal_zzadu_zza.zzwr = new com.google.android.gms.internal.zzah.zzf();
            com_google_android_gms_internal_zzadu_zza.aCW = com_google_android_gms_internal_zzah_zzj;
            this.f12804l.zzb(com_google_android_gms_internal_zzadu_zza);
        }
    }

    private synchronized void m18234a(zzj com_google_android_gms_internal_zzah_zzj, long j, boolean z) {
        Container container;
        if (z) {
            boolean z2 = this.f12807o;
        }
        if (!isReady() || this.f12806n == null) {
            this.f12808p = com_google_android_gms_internal_zzah_zzj;
            this.f12809q = j;
            m18232a(Math.max(0, Math.min(43200000, (this.f12809q + 43200000) - this.f12796d.currentTimeMillis())));
            container = new Container(this.f12801i, this.f12802j.getDataLayer(), this.f12803k, j, com_google_android_gms_internal_zzah_zzj);
        } else {
            this.f12808p = com_google_android_gms_internal_zzah_zzj;
            this.f12809q = j;
            m18232a(Math.max(0, Math.min(43200000, (this.f12809q + 43200000) - this.f12796d.currentTimeMillis())));
            container = new Container(this.f12801i, this.f12802j.getDataLayer(), this.f12803k, j, com_google_android_gms_internal_zzah_zzj);
        }
        if (this.f12806n == null) {
            this.f12806n = new zzo(this.f12802j, this.f12798f, container, this.f12797e);
        } else {
            this.f12806n.zza(container);
        }
        if (!isReady() && this.f12812t.zzb(container)) {
            zzc(this.f12806n);
        }
    }

    private void m18238a(final boolean z) {
        this.f12804l.zza(new zzb());
        this.f12811s.zza(new zzc());
        com.google.android.gms.internal.zzadw.zzc zzze = this.f12804l.zzze(this.f12800h);
        if (zzze != null) {
            this.f12806n = new zzo(this.f12802j, this.f12798f, new Container(this.f12801i, this.f12802j.getDataLayer(), this.f12803k, 0, zzze), this.f12797e);
        }
        this.f12812t = new zza(this) {
            final /* synthetic */ zzp f12792b;

            public boolean zzb(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= this.f12792b.f12796d.currentTimeMillis() : !container.isDefault();
            }
        };
        if (m18241d()) {
            this.f12811s.zzf(0, "");
        } else {
            this.f12804l.zzcav();
        }
    }

    private boolean m18241d() {
        zzci a = zzci.m18128a();
        return (a.m18132b() == zza.CONTAINER || a.m18132b() == zza.CONTAINER_DEBUG) && this.f12803k.equals(a.m18134d());
    }

    protected ContainerHolder m18246a(Status status) {
        if (this.f12806n != null) {
            return this.f12806n;
        }
        if (status == Status.st) {
            zzbn.m18105e("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    synchronized void m18247a(String str) {
        this.f12810r = str;
        if (this.f12811s != null) {
            this.f12811s.zzol(str);
        }
    }

    synchronized String mo2509c() {
        return this.f12810r;
    }

    protected /* synthetic */ Result zzc(Status status) {
        return m18246a(status);
    }

    public void zzcaq() {
        com.google.android.gms.internal.zzadw.zzc zzze = this.f12804l.zzze(this.f12800h);
        if (zzze != null) {
            zzc(new zzo(this.f12802j, this.f12798f, new Container(this.f12801i, this.f12802j.getDataLayer(), this.f12803k, 0, zzze), new C34492(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            zzbn.m18105e(str);
            zzc(m18246a(new Status(10, str, null)));
        }
        this.f12811s = null;
        this.f12804l = null;
    }

    public void zzcar() {
        m18238a(false);
    }

    public void zzcas() {
        m18238a(true);
    }
}
