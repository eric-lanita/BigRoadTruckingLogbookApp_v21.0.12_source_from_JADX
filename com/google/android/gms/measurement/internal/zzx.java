package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.v4.p008d.C0270a;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzapo;
import com.google.android.gms.internal.zzug;
import com.google.android.gms.internal.zzuh;
import com.google.android.gms.internal.zzuh.zzb;
import com.google.android.gms.internal.zzuh.zzc;
import com.google.android.gms.internal.zzuh.zzd;
import com.google.android.gms.internal.zzuh.zzg;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.p052a.C3610a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class zzx {
    private static volatile zzx f12385a;
    private int f12386A;
    private int f12387B;
    public final C3610a alh = new C3610a(this);
    private final Context f12388b;
    private final zzd f12389c;
    private final zzt f12390d;
    private final zzp f12391e;
    private final zzw f12392f;
    private final zzaf f12393g;
    private final zzv f12394h;
    private final AppMeasurement f12395i;
    private final zzal f12396j;
    private final zze f12397k;
    private final zzq f12398l;
    private final zze f12399m;
    private final zzad f12400n;
    private final zzg f12401o;
    private final zzac f12402p;
    private final zzn f12403q;
    private final zzr f12404r;
    private final zzai f12405s;
    private final zzc f12406t;
    private final boolean f12407u;
    private boolean f12408v;
    private Boolean f12409w;
    private FileLock f12410x;
    private FileChannel f12411y;
    private List<Long> f12412z;

    class C34081 implements Runnable {
        final /* synthetic */ zzx f12377a;

        C34081(zzx com_google_android_gms_measurement_internal_zzx) {
            this.f12377a = com_google_android_gms_measurement_internal_zzx;
        }

        public void run() {
            this.f12377a.m17991c();
        }
    }

    class C34092 implements zza {
        final /* synthetic */ zzx f12378a;

        C34092(zzx com_google_android_gms_measurement_internal_zzx) {
            this.f12378a = com_google_android_gms_measurement_internal_zzx;
        }

        public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.f12378a.m17963a(i, th, bArr);
        }
    }

    class C34103 implements zza {
        final /* synthetic */ zzx f12379a;

        C34103(zzx com_google_android_gms_measurement_internal_zzx) {
            this.f12379a = com_google_android_gms_measurement_internal_zzx;
        }

        public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            this.f12379a.m17984a(str, i, th, bArr, map);
        }
    }

    private class zza implements zzb {
        zzuh.zze f12380a;
        List<Long> f12381b;
        List<zzb> f12382c;
        long f12383d;
        final /* synthetic */ zzx f12384e;

        private zza(zzx com_google_android_gms_measurement_internal_zzx) {
            this.f12384e = com_google_android_gms_measurement_internal_zzx;
        }

        private long m17961a(zzb com_google_android_gms_internal_zzuh_zzb) {
            return ((com_google_android_gms_internal_zzuh_zzb.ano.longValue() / 1000) / 60) / 60;
        }

        boolean m17962a() {
            return this.f12382c == null || this.f12382c.isEmpty();
        }

        public boolean zza(long j, zzb com_google_android_gms_internal_zzuh_zzb) {
            zzab.zzy(com_google_android_gms_internal_zzuh_zzb);
            if (this.f12382c == null) {
                this.f12382c = new ArrayList();
            }
            if (this.f12381b == null) {
                this.f12381b = new ArrayList();
            }
            if (this.f12382c.size() > 0 && m17961a((zzb) this.f12382c.get(0)) != m17961a(com_google_android_gms_internal_zzuh_zzb)) {
                return false;
            }
            long aM = this.f12383d + ((long) com_google_android_gms_internal_zzuh_zzb.aM());
            if (aM >= ((long) this.f12384e.zzbsf().zzbri())) {
                return false;
            }
            this.f12383d = aM;
            this.f12382c.add(com_google_android_gms_internal_zzuh_zzb);
            this.f12381b.add(Long.valueOf(j));
            return this.f12382c.size() < this.f12384e.zzbsf().zzbrj();
        }

        public void zzc(zzuh.zze com_google_android_gms_internal_zzuh_zze) {
            zzab.zzy(com_google_android_gms_internal_zzuh_zze);
            this.f12380a = com_google_android_gms_internal_zzuh_zze;
        }
    }

    zzx(zzab com_google_android_gms_measurement_internal_zzab) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzab);
        this.f12388b = com_google_android_gms_measurement_internal_zzab.f12148a;
        this.f12399m = com_google_android_gms_measurement_internal_zzab.m17728l(this);
        this.f12389c = com_google_android_gms_measurement_internal_zzab.m17717a(this);
        zzt b = com_google_android_gms_measurement_internal_zzab.m17718b(this);
        b.initialize();
        this.f12390d = b;
        zzp c = com_google_android_gms_measurement_internal_zzab.m17719c(this);
        c.initialize();
        this.f12391e = c;
        zzbsd().zzbta().zzj("App measurement is starting up, version", Long.valueOf(zzbsf().zzbpz()));
        zzbsd().zzbta().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzbsd().zzbtb().log("Debug logging enabled");
        zzbsd().zzbtb().zzj("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.f12396j = com_google_android_gms_measurement_internal_zzab.m17725i(this);
        zzg n = com_google_android_gms_measurement_internal_zzab.m17730n(this);
        n.initialize();
        this.f12401o = n;
        zzn o = com_google_android_gms_measurement_internal_zzab.m17731o(this);
        o.initialize();
        this.f12403q = o;
        zze j = com_google_android_gms_measurement_internal_zzab.m17726j(this);
        j.initialize();
        this.f12397k = j;
        zzc r = com_google_android_gms_measurement_internal_zzab.m17734r(this);
        r.initialize();
        this.f12406t = r;
        zzq k = com_google_android_gms_measurement_internal_zzab.m17727k(this);
        k.initialize();
        this.f12398l = k;
        zzad m = com_google_android_gms_measurement_internal_zzab.m17729m(this);
        m.initialize();
        this.f12400n = m;
        zzac h = com_google_android_gms_measurement_internal_zzab.m17724h(this);
        h.initialize();
        this.f12402p = h;
        zzai q = com_google_android_gms_measurement_internal_zzab.m17733q(this);
        q.initialize();
        this.f12405s = q;
        this.f12404r = com_google_android_gms_measurement_internal_zzab.m17732p(this);
        this.f12395i = com_google_android_gms_measurement_internal_zzab.m17723g(this);
        zzaf e = com_google_android_gms_measurement_internal_zzab.m17721e(this);
        e.initialize();
        this.f12393g = e;
        zzv f = com_google_android_gms_measurement_internal_zzab.m17722f(this);
        f.initialize();
        this.f12394h = f;
        zzw d = com_google_android_gms_measurement_internal_zzab.m17720d(this);
        d.initialize();
        this.f12392f = d;
        if (this.f12386A != this.f12387B) {
            zzbsd().zzbsv().zze("Not all components initialized", Integer.valueOf(this.f12386A), Integer.valueOf(this.f12387B));
        }
        this.f12407u = true;
        if (!(this.f12389c.zzabc() || m17998h())) {
            if (!(this.f12388b.getApplicationContext() instanceof Application)) {
                zzbsd().zzbsx().log("Application context is not an Application");
            } else if (VERSION.SDK_INT >= 14) {
                zzbru().zzbun();
            } else {
                zzbsd().zzbtb().log("Not tracking deep linking pre-ICS");
            }
        }
        this.f12392f.zzm(new C34081(this));
    }

    private void m17963a(int i, Throwable th, byte[] bArr) {
        int i2 = 0;
        zzwu();
        m17976a();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.f12412z;
        this.f12412z = null;
        if ((i == 200 || i == 204) && th == null) {
            zzbse().ajY.set(zzyw().currentTimeMillis());
            zzbse().ajZ.set(0);
            m17973q();
            zzbsd().zzbtc().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            zzbry().beginTransaction();
            try {
                for (Long longValue : list) {
                    zzbry().zzbh(longValue.longValue());
                }
                zzbry().setTransactionSuccessful();
                if (zzbts().zzadj() && m17972p()) {
                    zzbuc();
                } else {
                    m17973q();
                }
            } finally {
                zzbry().endTransaction();
            }
        } else {
            zzbsd().zzbtc().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzbse().ajZ.set(zzyw().currentTimeMillis());
            if (i == 503 || i == 429) {
                i2 = 1;
            }
            if (i2 != 0) {
                zzbse().aka.set(zzyw().currentTimeMillis());
            }
            m17973q();
        }
    }

    private void m17965a(zzz com_google_android_gms_measurement_internal_zzz) {
        if (com_google_android_gms_measurement_internal_zzz == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private void m17966a(List<Long> list) {
        zzab.zzbo(!list.isEmpty());
        if (this.f12412z != null) {
            zzbsd().zzbsv().log("Set uploading progress before finishing the previous upload");
        } else {
            this.f12412z = new ArrayList(list);
        }
    }

    private boolean m17967a(String str, long j) {
        zzbry().beginTransaction();
        try {
            zzx com_google_android_gms_measurement_internal_zzx = this;
            zza com_google_android_gms_measurement_internal_zzx_zza = new zza();
            zzbry().zza(str, j, com_google_android_gms_measurement_internal_zzx_zza);
            if (com_google_android_gms_measurement_internal_zzx_zza.m17962a()) {
                zzbry().setTransactionSuccessful();
                zzbry().endTransaction();
                return false;
            }
            int i;
            zzuh.zze com_google_android_gms_internal_zzuh_zze = com_google_android_gms_measurement_internal_zzx_zza.f12380a;
            com_google_android_gms_internal_zzuh_zze.anv = new zzb[com_google_android_gms_measurement_internal_zzx_zza.f12382c.size()];
            int i2 = 0;
            int i3 = 0;
            while (i3 < com_google_android_gms_measurement_internal_zzx_zza.f12382c.size()) {
                if (zzbsa().m17945b(com_google_android_gms_measurement_internal_zzx_zza.f12380a.zzck, ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).name)) {
                    zzbsd().zzbsx().zzj("Dropping blacklisted raw event", ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).name);
                    zzbrz().zze(11, "_ev", ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).name);
                    i = i2;
                } else {
                    int i4;
                    if (zzbsa().m17947c(com_google_android_gms_measurement_internal_zzx_zza.f12380a.zzck, ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).name)) {
                        int i5;
                        Object obj;
                        zzc com_google_android_gms_internal_zzuh_zzc;
                        if (((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann == null) {
                            ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann = new zzc[0];
                        }
                        for (zzc com_google_android_gms_internal_zzuh_zzc2 : ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann) {
                            if ("_c".equals(com_google_android_gms_internal_zzuh_zzc2.name)) {
                                com_google_android_gms_internal_zzuh_zzc2.anr = Long.valueOf(1);
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            zzbsd().zzbtc().zzj("Marking event as conversion", ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).name);
                            zzc[] com_google_android_gms_internal_zzuh_zzcArr = (zzc[]) Arrays.copyOf(((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann, ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann.length + 1);
                            com_google_android_gms_internal_zzuh_zzc = new zzc();
                            com_google_android_gms_internal_zzuh_zzc.name = "_c";
                            com_google_android_gms_internal_zzuh_zzc.anr = Long.valueOf(1);
                            com_google_android_gms_internal_zzuh_zzcArr[com_google_android_gms_internal_zzuh_zzcArr.length - 1] = com_google_android_gms_internal_zzuh_zzc;
                            ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann = com_google_android_gms_internal_zzuh_zzcArr;
                        }
                        boolean a = zzal.m17810a(((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).name);
                        if (a && zzbry().zza(m17999i(), com_google_android_gms_measurement_internal_zzx_zza.f12380a.zzck, false, a, false).f12251c - ((long) zzbsf().zzlf(com_google_android_gms_measurement_internal_zzx_zza.f12380a.zzck)) > 0) {
                            zzbsd().zzbsx().log("Too many conversions. Not logging as conversion.");
                            zzb com_google_android_gms_internal_zzuh_zzb = (zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3);
                            Object obj2 = null;
                            zzc com_google_android_gms_internal_zzuh_zzc3 = null;
                            zzc[] com_google_android_gms_internal_zzuh_zzcArr2 = ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann;
                            int length = com_google_android_gms_internal_zzuh_zzcArr2.length;
                            int i6 = 0;
                            while (i6 < length) {
                                Object obj3;
                                com_google_android_gms_internal_zzuh_zzc = com_google_android_gms_internal_zzuh_zzcArr2[i6];
                                if ("_c".equals(com_google_android_gms_internal_zzuh_zzc.name)) {
                                    obj3 = obj2;
                                } else if ("_err".equals(com_google_android_gms_internal_zzuh_zzc.name)) {
                                    zzc com_google_android_gms_internal_zzuh_zzc4 = com_google_android_gms_internal_zzuh_zzc3;
                                    int i7 = 1;
                                    com_google_android_gms_internal_zzuh_zzc = com_google_android_gms_internal_zzuh_zzc4;
                                } else {
                                    com_google_android_gms_internal_zzuh_zzc = com_google_android_gms_internal_zzuh_zzc3;
                                    obj3 = obj2;
                                }
                                i6++;
                                obj2 = obj3;
                                com_google_android_gms_internal_zzuh_zzc3 = com_google_android_gms_internal_zzuh_zzc;
                            }
                            if (obj2 != null && com_google_android_gms_internal_zzuh_zzc3 != null) {
                                zzc[] com_google_android_gms_internal_zzuh_zzcArr3 = new zzc[(com_google_android_gms_internal_zzuh_zzb.ann.length - 1)];
                                i4 = 0;
                                com_google_android_gms_internal_zzuh_zzcArr2 = com_google_android_gms_internal_zzuh_zzb.ann;
                                length = com_google_android_gms_internal_zzuh_zzcArr2.length;
                                i5 = 0;
                                while (i5 < length) {
                                    zzc com_google_android_gms_internal_zzuh_zzc5 = com_google_android_gms_internal_zzuh_zzcArr2[i5];
                                    if (com_google_android_gms_internal_zzuh_zzc5 != com_google_android_gms_internal_zzuh_zzc3) {
                                        i = i4 + 1;
                                        com_google_android_gms_internal_zzuh_zzcArr3[i4] = com_google_android_gms_internal_zzuh_zzc5;
                                    } else {
                                        i = i4;
                                    }
                                    i5++;
                                    i4 = i;
                                }
                                ((zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3)).ann = com_google_android_gms_internal_zzuh_zzcArr3;
                            } else if (com_google_android_gms_internal_zzuh_zzc3 != null) {
                                com_google_android_gms_internal_zzuh_zzc3.name = "_err";
                                com_google_android_gms_internal_zzuh_zzc3.anr = Long.valueOf(10);
                            } else {
                                zzbsd().zzbsv().log("Did not find conversion parameter. Error not tracked");
                            }
                        }
                    }
                    i4 = i2 + 1;
                    com_google_android_gms_internal_zzuh_zze.anv[i2] = (zzb) com_google_android_gms_measurement_internal_zzx_zza.f12382c.get(i3);
                    i = i4;
                }
                i3++;
                i2 = i;
            }
            if (i2 < com_google_android_gms_measurement_internal_zzx_zza.f12382c.size()) {
                com_google_android_gms_internal_zzuh_zze.anv = (zzb[]) Arrays.copyOf(com_google_android_gms_internal_zzuh_zze.anv, i2);
            }
            com_google_android_gms_internal_zzuh_zze.anO = m17968a(com_google_android_gms_measurement_internal_zzx_zza.f12380a.zzck, com_google_android_gms_measurement_internal_zzx_zza.f12380a.anw, com_google_android_gms_internal_zzuh_zze.anv);
            com_google_android_gms_internal_zzuh_zze.any = com_google_android_gms_internal_zzuh_zze.anv[0].ano;
            com_google_android_gms_internal_zzuh_zze.anz = com_google_android_gms_internal_zzuh_zze.anv[0].ano;
            for (i = 1; i < com_google_android_gms_internal_zzuh_zze.anv.length; i++) {
                zzb com_google_android_gms_internal_zzuh_zzb2 = com_google_android_gms_internal_zzuh_zze.anv[i];
                if (com_google_android_gms_internal_zzuh_zzb2.ano.longValue() < com_google_android_gms_internal_zzuh_zze.any.longValue()) {
                    com_google_android_gms_internal_zzuh_zze.any = com_google_android_gms_internal_zzuh_zzb2.ano;
                }
                if (com_google_android_gms_internal_zzuh_zzb2.ano.longValue() > com_google_android_gms_internal_zzuh_zze.anz.longValue()) {
                    com_google_android_gms_internal_zzuh_zze.anz = com_google_android_gms_internal_zzuh_zzb2.ano;
                }
            }
            String str2 = com_google_android_gms_measurement_internal_zzx_zza.f12380a.zzck;
            zza zzln = zzbry().zzln(str2);
            if (zzln == null) {
                zzbsd().zzbsv().log("Bundling raw events w/o app info");
            } else {
                long zzbpw = zzln.zzbpw();
                com_google_android_gms_internal_zzuh_zze.anB = zzbpw != 0 ? Long.valueOf(zzbpw) : null;
                long zzbpv = zzln.zzbpv();
                if (zzbpv != 0) {
                    zzbpw = zzbpv;
                }
                com_google_android_gms_internal_zzuh_zze.anA = zzbpw != 0 ? Long.valueOf(zzbpw) : null;
                zzln.zzbqf();
                com_google_android_gms_internal_zzuh_zze.anM = Integer.valueOf((int) zzln.zzbqc());
                zzln.zzau(com_google_android_gms_internal_zzuh_zze.any.longValue());
                zzln.zzav(com_google_android_gms_internal_zzuh_zze.anz.longValue());
                zzbry().zza(zzln);
            }
            com_google_android_gms_internal_zzuh_zze.aig = zzbsd().zzbtd();
            zzbry().zza(com_google_android_gms_internal_zzuh_zze);
            zzbry().zzac(com_google_android_gms_measurement_internal_zzx_zza.f12381b);
            zzbry().zzlt(str2);
            zzbry().setTransactionSuccessful();
            return true;
        } finally {
            zzbry().endTransaction();
        }
    }

    private com.google.android.gms.internal.zzuh.zza[] m17968a(String str, zzg[] com_google_android_gms_internal_zzuh_zzgArr, zzb[] com_google_android_gms_internal_zzuh_zzbArr) {
        zzab.zzhr(str);
        return zzbrt().m17825a(str, com_google_android_gms_internal_zzuh_zzbArr, com_google_android_gms_internal_zzuh_zzgArr);
    }

    private void m17969b(AppMetadata appMetadata) {
        Object obj = 1;
        zzwu();
        m17976a();
        zzab.zzy(appMetadata);
        zzab.zzhr(appMetadata.packageName);
        zza zzln = zzbry().zzln(appMetadata.packageName);
        String b = zzbse().m17925b(appMetadata.packageName);
        Object obj2 = null;
        if (zzln == null) {
            zza com_google_android_gms_measurement_internal_zza = new zza(this, appMetadata.packageName);
            com_google_android_gms_measurement_internal_zza.zzky(zzbse().m17930e());
            com_google_android_gms_measurement_internal_zza.zzla(b);
            zzln = com_google_android_gms_measurement_internal_zza;
            obj2 = 1;
        } else if (!b.equals(zzln.zzbpt())) {
            zzln.zzla(b);
            zzln.zzky(zzbse().m17930e());
            int i = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.aic) || appMetadata.aic.equals(zzln.zzbps()))) {
            zzln.zzkz(appMetadata.aic);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.aik) || appMetadata.aik.equals(zzln.zzbpu()))) {
            zzln.zzlb(appMetadata.aik);
            obj2 = 1;
        }
        if (!(appMetadata.aie == 0 || appMetadata.aie == zzln.zzbpz())) {
            zzln.zzax(appMetadata.aie);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.aav) || appMetadata.aav.equals(zzln.zzxc()))) {
            zzln.setAppVersion(appMetadata.aav);
            obj2 = 1;
        }
        if (appMetadata.aij != zzln.zzbpx()) {
            zzln.zzaw(appMetadata.aij);
            obj2 = 1;
        }
        if (!(TextUtils.isEmpty(appMetadata.aid) || appMetadata.aid.equals(zzln.zzbpy()))) {
            zzln.zzlc(appMetadata.aid);
            obj2 = 1;
        }
        if (appMetadata.aif != zzln.zzbqa()) {
            zzln.zzay(appMetadata.aif);
            obj2 = 1;
        }
        if (appMetadata.aih != zzln.zzbqb()) {
            zzln.setMeasurementEnabled(appMetadata.aih);
        } else {
            obj = obj2;
        }
        if (obj != null) {
            zzbry().zza(zzln);
        }
    }

    private void m17970b(zzaa com_google_android_gms_measurement_internal_zzaa) {
        if (com_google_android_gms_measurement_internal_zzaa == null) {
            throw new IllegalStateException("Component not created");
        } else if (!com_google_android_gms_measurement_internal_zzaa.m17713a()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private boolean m17971o() {
        zzwu();
        return this.f12412z != null;
    }

    private boolean m17972p() {
        zzwu();
        m17976a();
        return zzbry().zzbsl() || !TextUtils.isEmpty(zzbry().zzbsg());
    }

    private void m17973q() {
        zzwu();
        m17976a();
        if (!m18004n()) {
            return;
        }
        if (m17990b() && m17972p()) {
            long r = m17974r();
            if (r == 0) {
                zzbtt().unregister();
                zzbtu().cancel();
                return;
            } else if (zzbts().zzadj()) {
                long j = zzbse().aka.get();
                long zzbrm = zzbsf().zzbrm();
                if (!zzbrz().zzg(j, zzbrm)) {
                    r = Math.max(r, j + zzbrm);
                }
                zzbtt().unregister();
                r -= zzyw().currentTimeMillis();
                if (r <= 0) {
                    zzbtu().zzv(1);
                    return;
                }
                zzbsd().zzbtc().zzj("Upload scheduled in approximately ms", Long.valueOf(r));
                zzbtu().zzv(r);
                return;
            } else {
                zzbtt().zzadg();
                zzbtu().cancel();
                return;
            }
        }
        zzbtt().unregister();
        zzbtu().cancel();
    }

    private long m17974r() {
        long currentTimeMillis = zzyw().currentTimeMillis();
        long zzbrp = zzbsf().zzbrp();
        long zzbrn = zzbsf().zzbrn();
        long j = zzbse().ajY.get();
        long j2 = zzbse().ajZ.get();
        long max = Math.max(zzbry().zzbsj(), zzbry().zzbsk());
        if (max == 0) {
            return 0;
        }
        max = currentTimeMillis - Math.abs(max - currentTimeMillis);
        j2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
        currentTimeMillis = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), j2);
        zzbrp += max;
        if (!zzbrz().zzg(currentTimeMillis, zzbrn)) {
            zzbrp = currentTimeMillis + zzbrn;
        }
        if (j2 == 0 || j2 < max) {
            return zzbrp;
        }
        for (int i = 0; i < zzbsf().zzbrr(); i++) {
            zzbrp += ((long) (1 << i)) * zzbsf().zzbrq();
            if (zzbrp > j2) {
                return zzbrp;
            }
        }
        return 0;
    }

    public static zzx zzdo(Context context) {
        zzab.zzy(context);
        zzab.zzy(context.getApplicationContext());
        if (f12385a == null) {
            synchronized (zzx.class) {
                if (f12385a == null) {
                    f12385a = new zzab(context).zzbum();
                }
            }
        }
        return f12385a;
    }

    int m17975a(FileChannel fileChannel) {
        int i = 0;
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsd().zzbsv().log("Bad chanel to read from");
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0);
                int read = fileChannel.read(allocate);
                if (read != 4) {
                    zzbsd().zzbsx().zzj("Unexpected data length or empty data in channel. Bytes read", Integer.valueOf(read));
                } else {
                    allocate.flip();
                    i = allocate.getInt();
                }
            } catch (IOException e) {
                zzbsd().zzbsv().zzj("Failed to read from channel", e);
            }
        }
        return i;
    }

    void m17976a() {
        if (!this.f12407u) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    void m17977a(AppMetadata appMetadata) {
        zzwu();
        m17976a();
        zzab.zzhr(appMetadata.packageName);
        m17969b(appMetadata);
    }

    void m17978a(AppMetadata appMetadata, long j) {
        zza zzln = zzbry().zzln(appMetadata.packageName);
        if (!(zzln == null || zzln.zzbps() == null || zzln.zzbps().equals(appMetadata.aic))) {
            zzbsd().zzbsx().log("New GMP App Id passed in. Removing cached database data.");
            zzbry().m17864c(zzln.zzsh());
            zzln = null;
        }
        if (zzln != null && zzln.zzxc() != null && !zzln.zzxc().equals(appMetadata.aav)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", zzln.zzxc());
            m17979a(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    void m17979a(EventParcel eventParcel, AppMetadata appMetadata) {
        long nanoTime = System.nanoTime();
        zzwu();
        m17976a();
        String str = appMetadata.packageName;
        zzab.zzhr(str);
        if (!TextUtils.isEmpty(appMetadata.aic)) {
            if (!appMetadata.aih) {
                m17969b(appMetadata);
            } else if (zzbsa().m17945b(str, eventParcel.name)) {
                zzbsd().zzbsx().zzj("Dropping blacklisted event", eventParcel.name);
                zzbrz().zze(11, "_ev", eventParcel.name);
            } else {
                if (zzbsd().m17902a(2)) {
                    zzbsd().zzbtc().zzj("Logging event", eventParcel);
                }
                zzbry().beginTransaction();
                try {
                    Bundle zzbss = eventParcel.aiI.zzbss();
                    m17969b(appMetadata);
                    if ("_iap".equals(eventParcel.name) || "ecommerce_purchase".equals(eventParcel.name)) {
                        long round;
                        Object string = zzbss.getString("currency");
                        if ("ecommerce_purchase".equals(eventParcel.name)) {
                            double d = zzbss.getDouble("value") * 1000000.0d;
                            if (d == 0.0d) {
                                d = ((double) zzbss.getLong("value")) * 1000000.0d;
                            }
                            if (d > 9.223372036854776E18d || d < -9.223372036854776E18d) {
                                zzbsd().zzbsx().zzj("Data lost. Currency value is too big", Double.valueOf(d));
                                zzbry().setTransactionSuccessful();
                                zzbry().endTransaction();
                                return;
                            }
                            round = Math.round(d);
                        } else {
                            round = zzbss.getLong("value");
                        }
                        if (!TextUtils.isEmpty(string)) {
                            String toUpperCase = string.toUpperCase(Locale.US);
                            if (toUpperCase.matches("[A-Z]{3}")) {
                                zzak com_google_android_gms_measurement_internal_zzak;
                                String valueOf = String.valueOf("_ltv_");
                                toUpperCase = String.valueOf(toUpperCase);
                                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                                zzak zzas = zzbry().zzas(str, concat);
                                if (zzas == null || !(zzas.f12246d instanceof Long)) {
                                    zzbry().zzy(str, zzbsf().m17832b(str) - 1);
                                    com_google_android_gms_measurement_internal_zzak = new zzak(str, concat, zzyw().currentTimeMillis(), Long.valueOf(round));
                                } else {
                                    com_google_android_gms_measurement_internal_zzak = new zzak(str, concat, zzyw().currentTimeMillis(), Long.valueOf(round + ((Long) zzas.f12246d).longValue()));
                                }
                                if (!zzbry().zza(com_google_android_gms_measurement_internal_zzak)) {
                                    zzbsd().zzbsv().zze("Too many unique user properties are set. Ignoring user property.", com_google_android_gms_measurement_internal_zzak.f12244b, com_google_android_gms_measurement_internal_zzak.f12246d);
                                    zzbrz().zze(9, null, null);
                                }
                            }
                        }
                    }
                    boolean a = zzal.m17810a(eventParcel.name);
                    zzal.zzam(zzbss);
                    boolean equals = "_err".equals(eventParcel.name);
                    com.google.android.gms.measurement.internal.zze.zza zza = zzbry().zza(m17999i(), str, a, false, equals);
                    long zzbqv = zza.f12250b - zzbsf().zzbqv();
                    if (zzbqv > 0) {
                        if (zzbqv % 1000 == 1) {
                            zzbsd().zzbsv().zzj("Data loss. Too many events logged. count", Long.valueOf(zza.f12250b));
                        }
                        zzbrz().zze(16, "_ev", eventParcel.name);
                        zzbry().setTransactionSuccessful();
                        return;
                    }
                    zzi a2;
                    if (a) {
                        zzbqv = zza.f12249a - zzbsf().zzbqw();
                        if (zzbqv > 0) {
                            if (zzbqv % 1000 == 1) {
                                zzbsd().zzbsv().zzj("Data loss. Too many public events logged. count", Long.valueOf(zza.f12249a));
                            }
                            zzbrz().zze(16, "_ev", eventParcel.name);
                            zzbry().setTransactionSuccessful();
                            zzbry().endTransaction();
                            return;
                        }
                    }
                    if (equals) {
                        zzbqv = zza.f12252d - zzbsf().zzbqx();
                        if (zzbqv > 0) {
                            if (zzbqv == 1) {
                                zzbsd().zzbsv().zzj("Too many error events logged. count", Long.valueOf(zza.f12252d));
                            }
                            zzbry().setTransactionSuccessful();
                            zzbry().endTransaction();
                            return;
                        }
                    }
                    zzbrz().zza(zzbss, "_o", eventParcel.aiJ);
                    long zzlo = zzbry().zzlo(str);
                    if (zzlo > 0) {
                        zzbsd().zzbsx().zzj("Data lost. Too many events stored on disk, deleted", Long.valueOf(zzlo));
                    }
                    zzh com_google_android_gms_measurement_internal_zzh = new zzh(this, eventParcel.aiJ, str, eventParcel.name, eventParcel.aiK, 0, zzbss);
                    zzi zzaq = zzbry().zzaq(str, com_google_android_gms_measurement_internal_zzh.f12262b);
                    if (zzaq != null) {
                        com_google_android_gms_measurement_internal_zzh = com_google_android_gms_measurement_internal_zzh.m17872a(this, zzaq.f12271e);
                        a2 = zzaq.m17874a(com_google_android_gms_measurement_internal_zzh.f12264d);
                    } else if (zzbry().zzlu(str) >= ((long) zzbsf().m17835e())) {
                        zzbsd().zzbsv().zze("Too many event names used, ignoring event. name, supported count", com_google_android_gms_measurement_internal_zzh.f12262b, Integer.valueOf(zzbsf().m17835e()));
                        zzbrz().zze(8, null, null);
                        zzbry().endTransaction();
                        return;
                    } else {
                        a2 = new zzi(str, com_google_android_gms_measurement_internal_zzh.f12262b, 0, 0, com_google_android_gms_measurement_internal_zzh.f12264d);
                    }
                    zzbry().zza(a2);
                    m17983a(com_google_android_gms_measurement_internal_zzh, appMetadata);
                    zzbry().setTransactionSuccessful();
                    if (zzbsd().m17902a(2)) {
                        zzbsd().zzbtc().zzj("Event recorded", com_google_android_gms_measurement_internal_zzh);
                    }
                    zzbry().endTransaction();
                    m17973q();
                    zzbsd().zzbtc().zzj("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } finally {
                    zzbry().endTransaction();
                }
            }
        }
    }

    void m17980a(EventParcel eventParcel, String str) {
        zza zzln = zzbry().zzln(str);
        if (zzln == null || TextUtils.isEmpty(zzln.zzxc())) {
            zzbsd().zzbtb().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = getContext().getPackageManager().getPackageInfo(str, 0).versionName;
            if (!(zzln.zzxc() == null || zzln.zzxc().equals(str2))) {
                zzbsd().zzbsx().zzj("App version does not match; dropping event", str);
                return;
            }
        } catch (NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.name)) {
                zzbsd().zzbsx().zzj("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        m17979a(eventParcel2, new AppMetadata(str, zzln.zzbps(), zzln.zzxc(), zzln.zzbpx(), zzln.zzbpy(), zzln.zzbpz(), zzln.zzbqa(), null, zzln.zzbqb(), false, zzln.zzbpu()));
    }

    void m17981a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        m17976a();
        if (!TextUtils.isEmpty(appMetadata.aic)) {
            if (appMetadata.aih) {
                int zzmn = zzbrz().zzmn(userAttributeParcel.name);
                if (zzmn != 0) {
                    zzbrz().zze(zzmn, "_ev", zzbrz().zza(userAttributeParcel.name, zzbsf().zzbqo(), true));
                    return;
                }
                zzmn = zzbrz().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
                if (zzmn != 0) {
                    zzbrz().zze(zzmn, "_ev", zzbrz().zza(userAttributeParcel.name, zzbsf().zzbqo(), true));
                    return;
                }
                Object zzn = zzbrz().zzn(userAttributeParcel.name, userAttributeParcel.getValue());
                if (zzn != null) {
                    zzak com_google_android_gms_measurement_internal_zzak = new zzak(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.amt, zzn);
                    zzbsd().zzbtb().zze("Setting user property", com_google_android_gms_measurement_internal_zzak.f12244b, zzn);
                    zzbry().beginTransaction();
                    try {
                        m17969b(appMetadata);
                        boolean zza = zzbry().zza(com_google_android_gms_measurement_internal_zzak);
                        zzbry().setTransactionSuccessful();
                        if (zza) {
                            zzbsd().zzbtb().zze("User property set", com_google_android_gms_measurement_internal_zzak.f12244b, com_google_android_gms_measurement_internal_zzak.f12246d);
                        } else {
                            zzbsd().zzbsv().zze("Too many unique user properties are set. Ignoring user property.", com_google_android_gms_measurement_internal_zzak.f12244b, com_google_android_gms_measurement_internal_zzak.f12246d);
                            zzbrz().zze(9, null, null);
                        }
                        zzbry().endTransaction();
                        return;
                    } catch (Throwable th) {
                        zzbry().endTransaction();
                    }
                } else {
                    return;
                }
            }
            m17969b(appMetadata);
        }
    }

    void m17982a(zzaa com_google_android_gms_measurement_internal_zzaa) {
        this.f12386A++;
    }

    void m17983a(zzh com_google_android_gms_measurement_internal_zzh, AppMetadata appMetadata) {
        zzwu();
        m17976a();
        zzab.zzy(com_google_android_gms_measurement_internal_zzh);
        zzab.zzy(appMetadata);
        zzab.zzhr(com_google_android_gms_measurement_internal_zzh.f12261a);
        zzab.zzbo(com_google_android_gms_measurement_internal_zzh.f12261a.equals(appMetadata.packageName));
        zzuh.zze com_google_android_gms_internal_zzuh_zze = new zzuh.zze();
        com_google_android_gms_internal_zzuh_zze.anu = Integer.valueOf(1);
        com_google_android_gms_internal_zzuh_zze.anC = "android";
        com_google_android_gms_internal_zzuh_zze.zzck = appMetadata.packageName;
        com_google_android_gms_internal_zzuh_zze.aid = appMetadata.aid;
        com_google_android_gms_internal_zzuh_zze.aav = appMetadata.aav;
        com_google_android_gms_internal_zzuh_zze.anP = Integer.valueOf((int) appMetadata.aij);
        com_google_android_gms_internal_zzuh_zze.anG = Long.valueOf(appMetadata.aie);
        com_google_android_gms_internal_zzuh_zze.aic = appMetadata.aic;
        com_google_android_gms_internal_zzuh_zze.anL = appMetadata.aif == 0 ? null : Long.valueOf(appMetadata.aif);
        Pair a = zzbse().m17923a(appMetadata.packageName);
        if (a != null && !TextUtils.isEmpty((CharSequence) a.first)) {
            com_google_android_gms_internal_zzuh_zze.anI = (String) a.first;
            com_google_android_gms_internal_zzuh_zze.anJ = (Boolean) a.second;
        } else if (!zzbrw().zzdn(this.f12388b)) {
            String string = Secure.getString(this.f12388b.getContentResolver(), "android_id");
            if (string == null) {
                zzbsd().zzbsx().log("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                zzbsd().zzbsx().log("empty secure ID");
            }
            com_google_android_gms_internal_zzuh_zze.anS = string;
        }
        com_google_android_gms_internal_zzuh_zze.anD = zzbrw().zztg();
        com_google_android_gms_internal_zzuh_zze.zzct = zzbrw().zzbso();
        com_google_android_gms_internal_zzuh_zze.anF = Integer.valueOf((int) zzbrw().zzbsp());
        com_google_android_gms_internal_zzuh_zze.anE = zzbrw().zzbsq();
        com_google_android_gms_internal_zzuh_zze.anH = null;
        com_google_android_gms_internal_zzuh_zze.anx = null;
        com_google_android_gms_internal_zzuh_zze.any = null;
        com_google_android_gms_internal_zzuh_zze.anz = null;
        zza zzln = zzbry().zzln(appMetadata.packageName);
        if (zzln == null) {
            zzln = new zza(this, appMetadata.packageName);
            zzln.zzky(zzbse().m17930e());
            zzln.zzlb(appMetadata.aik);
            zzln.zzkz(appMetadata.aic);
            zzln.zzla(zzbse().m17925b(appMetadata.packageName));
            zzln.zzaz(0);
            zzln.zzau(0);
            zzln.zzav(0);
            zzln.setAppVersion(appMetadata.aav);
            zzln.zzaw(appMetadata.aij);
            zzln.zzlc(appMetadata.aid);
            zzln.zzax(appMetadata.aie);
            zzln.zzay(appMetadata.aif);
            zzln.setMeasurementEnabled(appMetadata.aih);
            zzbry().zza(zzln);
        }
        com_google_android_gms_internal_zzuh_zze.anK = zzln.zzawo();
        com_google_android_gms_internal_zzuh_zze.aik = zzln.zzbpu();
        List zzlm = zzbry().zzlm(appMetadata.packageName);
        com_google_android_gms_internal_zzuh_zze.anw = new zzg[zzlm.size()];
        for (int i = 0; i < zzlm.size(); i++) {
            zzg com_google_android_gms_internal_zzuh_zzg = new zzg();
            com_google_android_gms_internal_zzuh_zze.anw[i] = com_google_android_gms_internal_zzuh_zzg;
            com_google_android_gms_internal_zzuh_zzg.name = ((zzak) zzlm.get(i)).f12244b;
            com_google_android_gms_internal_zzuh_zzg.anW = Long.valueOf(((zzak) zzlm.get(i)).f12245c);
            zzbrz().zza(com_google_android_gms_internal_zzuh_zzg, ((zzak) zzlm.get(i)).f12246d);
        }
        try {
            zzbry().zza(com_google_android_gms_measurement_internal_zzh, zzbry().zzb(com_google_android_gms_internal_zzuh_zze));
        } catch (IOException e) {
            zzbsd().zzbsv().zzj("Data loss. Failed to insert raw event metadata", e);
        }
    }

    void m17984a(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        int i2 = 0;
        zzwu();
        m17976a();
        zzab.zzhr(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        zzbry().beginTransaction();
        try {
            zza zzln = zzbry().zzln(str);
            int i3 = ((i == 200 || i == 204 || i == 304) && th == null) ? 1 : 0;
            if (zzln == null) {
                zzbsd().zzbsx().zzj("App does not exist in onConfigFetched", str);
            } else if (i3 != 0 || i == 404) {
                List list = map != null ? (List) map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (zzbsa().m17941a(str) == null && !zzbsa().m17943a(str, null, null)) {
                        zzbry().endTransaction();
                        return;
                    }
                } else if (!zzbsa().m17943a(str, bArr, str2)) {
                    zzbry().endTransaction();
                    return;
                }
                zzln.zzba(zzyw().currentTimeMillis());
                zzbry().zza(zzln);
                if (i == 404) {
                    zzbsd().zzbsx().log("Config not found. Using empty config");
                } else {
                    zzbsd().zzbtc().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (zzbts().zzadj() && m17972p()) {
                    zzbuc();
                } else {
                    m17973q();
                }
            } else {
                zzln.zzbb(zzyw().currentTimeMillis());
                zzbry().zza(zzln);
                zzbsd().zzbtc().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzbsa().m17946c(str);
                zzbse().ajZ.set(zzyw().currentTimeMillis());
                if (i == 503 || i == 429) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    zzbse().aka.set(zzyw().currentTimeMillis());
                }
                m17973q();
            }
            zzbry().setTransactionSuccessful();
        } finally {
            zzbry().endTransaction();
        }
    }

    boolean m17985a(int i, int i2) {
        zzwu();
        if (i > i2) {
            zzbsd().zzbsv().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (m17986a(i2, m17995e())) {
                zzbsd().zzbtc().zze("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                zzbsd().zzbsv().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    boolean m17986a(int i, FileChannel fileChannel) {
        zzwu();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbsd().zzbsv().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzbsd().zzbsv().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzbsd().zzbsv().zzj("Failed to write to channel", e);
            return false;
        }
    }

    boolean m17987a(long j) {
        return m17967a(null, j);
    }

    void m17988b(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        m17979a(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    void m17989b(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzwu();
        m17976a();
        if (!TextUtils.isEmpty(appMetadata.aic)) {
            if (appMetadata.aih) {
                zzbsd().zzbtb().zzj("Removing user property", userAttributeParcel.name);
                zzbry().beginTransaction();
                try {
                    m17969b(appMetadata);
                    zzbry().zzar(appMetadata.packageName, userAttributeParcel.name);
                    zzbry().setTransactionSuccessful();
                    zzbsd().zzbtb().zzj("User property removed", userAttributeParcel.name);
                } finally {
                    zzbry().endTransaction();
                }
            } else {
                m17969b(appMetadata);
            }
        }
    }

    protected boolean m17990b() {
        m17976a();
        zzwu();
        if (this.f12409w == null) {
            boolean z = zzbrz().zzeo("android.permission.INTERNET") && zzbrz().zzeo("android.permission.ACCESS_NETWORK_STATE") && zzu.zzav(getContext()) && zzae.zzaw(getContext());
            this.f12409w = Boolean.valueOf(z);
            if (this.f12409w.booleanValue() && !zzbsf().zzabc()) {
                this.f12409w = Boolean.valueOf(zzbrz().zzmq(zzbrv().m17889f()));
            }
        }
        return this.f12409w.booleanValue();
    }

    protected void m17991c() {
        zzwu();
        if (!m17998h() || (this.f12392f.m17713a() && !this.f12392f.m17714b())) {
            zzbry().m17868g();
            if (m17990b()) {
                if (!(zzbsf().zzabc() || TextUtils.isEmpty(zzbrv().m17889f()))) {
                    String h = zzbse().m17933h();
                    if (h == null) {
                        zzbse().m17927c(zzbrv().m17889f());
                    } else if (!h.equals(zzbrv().m17889f())) {
                        zzbsd().zzbta().log("Rechecking which service to use due to a GMP App Id change");
                        zzbse().m17935j();
                        this.f12400n.disconnect();
                        this.f12400n.m17775g();
                        zzbse().m17927c(zzbrv().m17889f());
                    }
                }
                if (!(zzbsf().zzabc() || m17998h() || TextUtils.isEmpty(zzbrv().m17889f()))) {
                    zzbru().zzbuo();
                }
            } else if (isEnabled()) {
                if (!zzbrz().zzeo("android.permission.INTERNET")) {
                    zzbsd().zzbsv().log("App is missing INTERNET permission");
                }
                if (!zzbrz().zzeo("android.permission.ACCESS_NETWORK_STATE")) {
                    zzbsd().zzbsv().log("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!zzu.zzav(getContext())) {
                    zzbsd().zzbsv().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzae.zzaw(getContext())) {
                    zzbsd().zzbsv().log("AppMeasurementService not registered/enabled");
                }
                zzbsd().zzbsv().log("Uploading is not possible. App measurement disabled");
            }
            m17973q();
            return;
        }
        zzbsd().zzbsv().log("Scheduler shutting down before Scion.start() called");
    }

    void m17992c(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        m17979a(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    zzw m17993d() {
        return this.f12392f;
    }

    void m17994d(AppMetadata appMetadata, long j) {
        m17979a(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    FileChannel m17995e() {
        return this.f12411y;
    }

    void m17996f() {
        zzwu();
        m17976a();
        if (m18004n() && m17997g()) {
            m17985a(m17975a(m17995e()), zzbrv().m17891h());
        }
    }

    boolean m17997g() {
        zzwu();
        try {
            this.f12411y = new RandomAccessFile(new File(getContext().getFilesDir(), this.f12397k.m17867f()), "rw").getChannel();
            this.f12410x = this.f12411y.tryLock();
            if (this.f12410x != null) {
                zzbsd().zzbtc().log("Storage concurrent access okay");
                return true;
            }
            zzbsd().zzbsv().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzbsd().zzbsv().zzj("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Failed to access storage lock file", e2);
        }
    }

    public Context getContext() {
        return this.f12388b;
    }

    protected boolean m17998h() {
        return false;
    }

    long m17999i() {
        return ((((zzyw().currentTimeMillis() + zzbse().m17932g()) / 1000) / 60) / 60) / 24;
    }

    public boolean isEnabled() {
        boolean z = false;
        zzwu();
        m17976a();
        if (zzbsf().zzbrd()) {
            return false;
        }
        Boolean zzbre = zzbsf().zzbre();
        if (zzbre != null) {
            z = zzbre.booleanValue();
        } else if (!zzbsf().zzaqp()) {
            z = true;
        }
        return zzbse().m17928c(z);
    }

    void m18000j() {
        if (zzbsf().zzabc()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    void m18001k() {
        if (!zzbsf().zzabc()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    void m18002l() {
        this.f12387B++;
    }

    void m18003m() {
        zzwu();
        m17976a();
        if (!this.f12408v) {
            zzbsd().zzbta().log("This instance being marked as an uploader");
            m17996f();
        }
        this.f12408v = true;
    }

    boolean m18004n() {
        zzwu();
        m17976a();
        return this.f12408v || m17998h();
    }

    public byte[] zza(EventParcel eventParcel, String str) {
        m17976a();
        zzwu();
        m18001k();
        zzab.zzy(eventParcel);
        zzab.zzhr(str);
        zzd com_google_android_gms_internal_zzuh_zzd = new zzd();
        zzbry().beginTransaction();
        try {
            zza zzln = zzbry().zzln(str);
            byte[] bArr;
            if (zzln == null) {
                zzbsd().zzbtb().zzj("Log and bundle not available. package_name", str);
                bArr = new byte[0];
                return bArr;
            } else if (zzln.zzbqb()) {
                long j;
                zzuh.zze com_google_android_gms_internal_zzuh_zze = new zzuh.zze();
                com_google_android_gms_internal_zzuh_zzd.ans = new zzuh.zze[]{com_google_android_gms_internal_zzuh_zze};
                com_google_android_gms_internal_zzuh_zze.anu = Integer.valueOf(1);
                com_google_android_gms_internal_zzuh_zze.anC = "android";
                com_google_android_gms_internal_zzuh_zze.zzck = zzln.zzsh();
                com_google_android_gms_internal_zzuh_zze.aid = zzln.zzbpy();
                com_google_android_gms_internal_zzuh_zze.aav = zzln.zzxc();
                com_google_android_gms_internal_zzuh_zze.anP = Integer.valueOf((int) zzln.zzbpx());
                com_google_android_gms_internal_zzuh_zze.anG = Long.valueOf(zzln.zzbpz());
                com_google_android_gms_internal_zzuh_zze.aic = zzln.zzbps();
                com_google_android_gms_internal_zzuh_zze.anL = Long.valueOf(zzln.zzbqa());
                Pair a = zzbse().m17923a(zzln.zzsh());
                if (!(a == null || TextUtils.isEmpty((CharSequence) a.first))) {
                    com_google_android_gms_internal_zzuh_zze.anI = (String) a.first;
                    com_google_android_gms_internal_zzuh_zze.anJ = (Boolean) a.second;
                }
                com_google_android_gms_internal_zzuh_zze.anD = zzbrw().zztg();
                com_google_android_gms_internal_zzuh_zze.zzct = zzbrw().zzbso();
                com_google_android_gms_internal_zzuh_zze.anF = Integer.valueOf((int) zzbrw().zzbsp());
                com_google_android_gms_internal_zzuh_zze.anE = zzbrw().zzbsq();
                com_google_android_gms_internal_zzuh_zze.anK = zzln.zzawo();
                com_google_android_gms_internal_zzuh_zze.aik = zzln.zzbpu();
                List zzlm = zzbry().zzlm(zzln.zzsh());
                com_google_android_gms_internal_zzuh_zze.anw = new zzg[zzlm.size()];
                for (int i = 0; i < zzlm.size(); i++) {
                    zzg com_google_android_gms_internal_zzuh_zzg = new zzg();
                    com_google_android_gms_internal_zzuh_zze.anw[i] = com_google_android_gms_internal_zzuh_zzg;
                    com_google_android_gms_internal_zzuh_zzg.name = ((zzak) zzlm.get(i)).f12244b;
                    com_google_android_gms_internal_zzuh_zzg.anW = Long.valueOf(((zzak) zzlm.get(i)).f12245c);
                    zzbrz().zza(com_google_android_gms_internal_zzuh_zzg, ((zzak) zzlm.get(i)).f12246d);
                }
                Bundle zzbss = eventParcel.aiI.zzbss();
                if ("_iap".equals(eventParcel.name)) {
                    zzbss.putLong("_c", 1);
                }
                zzbss.putString("_o", eventParcel.aiJ);
                zzi zzaq = zzbry().zzaq(str, eventParcel.name);
                if (zzaq == null) {
                    zzbry().zza(new zzi(str, eventParcel.name, 1, 0, eventParcel.aiK));
                    j = 0;
                } else {
                    j = zzaq.f12271e;
                    zzbry().zza(zzaq.m17874a(eventParcel.aiK).m17873a());
                }
                zzh com_google_android_gms_measurement_internal_zzh = new zzh(this, eventParcel.aiJ, str, eventParcel.name, eventParcel.aiK, j, zzbss);
                zzb com_google_android_gms_internal_zzuh_zzb = new zzb();
                com_google_android_gms_internal_zzuh_zze.anv = new zzb[]{com_google_android_gms_internal_zzuh_zzb};
                com_google_android_gms_internal_zzuh_zzb.ano = Long.valueOf(com_google_android_gms_measurement_internal_zzh.f12264d);
                com_google_android_gms_internal_zzuh_zzb.name = com_google_android_gms_measurement_internal_zzh.f12262b;
                com_google_android_gms_internal_zzuh_zzb.anp = Long.valueOf(com_google_android_gms_measurement_internal_zzh.f12265e);
                com_google_android_gms_internal_zzuh_zzb.ann = new zzc[com_google_android_gms_measurement_internal_zzh.f12266f.size()];
                Iterator it = com_google_android_gms_measurement_internal_zzh.f12266f.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    zzc com_google_android_gms_internal_zzuh_zzc = new zzc();
                    int i3 = i2 + 1;
                    com_google_android_gms_internal_zzuh_zzb.ann[i2] = com_google_android_gms_internal_zzuh_zzc;
                    com_google_android_gms_internal_zzuh_zzc.name = str2;
                    zzbrz().zza(com_google_android_gms_internal_zzuh_zzc, com_google_android_gms_measurement_internal_zzh.f12266f.m17712a(str2));
                    i2 = i3;
                }
                com_google_android_gms_internal_zzuh_zze.anO = m17968a(zzln.zzsh(), com_google_android_gms_internal_zzuh_zze.anw, com_google_android_gms_internal_zzuh_zze.anv);
                com_google_android_gms_internal_zzuh_zze.any = com_google_android_gms_internal_zzuh_zzb.ano;
                com_google_android_gms_internal_zzuh_zze.anz = com_google_android_gms_internal_zzuh_zzb.ano;
                long zzbpw = zzln.zzbpw();
                com_google_android_gms_internal_zzuh_zze.anB = zzbpw != 0 ? Long.valueOf(zzbpw) : null;
                long zzbpv = zzln.zzbpv();
                if (zzbpv != 0) {
                    zzbpw = zzbpv;
                }
                com_google_android_gms_internal_zzuh_zze.anA = zzbpw != 0 ? Long.valueOf(zzbpw) : null;
                zzln.zzbqf();
                com_google_android_gms_internal_zzuh_zze.anM = Integer.valueOf((int) zzln.zzbqc());
                com_google_android_gms_internal_zzuh_zze.anH = Long.valueOf(zzbsf().zzbpz());
                com_google_android_gms_internal_zzuh_zze.anx = Long.valueOf(zzyw().currentTimeMillis());
                com_google_android_gms_internal_zzuh_zze.anN = Boolean.TRUE;
                zzln.zzau(com_google_android_gms_internal_zzuh_zze.any.longValue());
                zzln.zzav(com_google_android_gms_internal_zzuh_zze.anz.longValue());
                zzbry().zza(zzln);
                zzbry().setTransactionSuccessful();
                zzbry().endTransaction();
                try {
                    bArr = new byte[com_google_android_gms_internal_zzuh_zzd.aM()];
                    zzapo zzbe = zzapo.zzbe(bArr);
                    com_google_android_gms_internal_zzuh_zzd.zza(zzbe);
                    zzbe.az();
                    return zzbrz().zzj(bArr);
                } catch (IOException e) {
                    zzbsd().zzbsv().zzj("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            } else {
                zzbsd().zzbtb().zzj("Log and bundle disabled. package_name", str);
                bArr = new byte[0];
                zzbry().endTransaction();
                return bArr;
            }
        } finally {
            zzbry().endTransaction();
        }
    }

    public void zzas(boolean z) {
        m17973q();
    }

    public zzc zzbrt() {
        m17970b(this.f12406t);
        return this.f12406t;
    }

    public zzac zzbru() {
        m17970b(this.f12402p);
        return this.f12402p;
    }

    public zzn zzbrv() {
        m17970b(this.f12403q);
        return this.f12403q;
    }

    public zzg zzbrw() {
        m17970b(this.f12401o);
        return this.f12401o;
    }

    public zzad zzbrx() {
        m17970b(this.f12400n);
        return this.f12400n;
    }

    public zze zzbry() {
        m17970b(this.f12397k);
        return this.f12397k;
    }

    public zzal zzbrz() {
        m17965a(this.f12396j);
        return this.f12396j;
    }

    public zzv zzbsa() {
        m17970b(this.f12394h);
        return this.f12394h;
    }

    public zzaf zzbsb() {
        m17970b(this.f12393g);
        return this.f12393g;
    }

    public zzw zzbsc() {
        m17970b(this.f12392f);
        return this.f12392f;
    }

    public zzp zzbsd() {
        m17970b(this.f12391e);
        return this.f12391e;
    }

    public zzt zzbse() {
        m17965a(this.f12390d);
        return this.f12390d;
    }

    public zzd zzbsf() {
        return this.f12389c;
    }

    public zzp zzbtp() {
        return (this.f12391e == null || !this.f12391e.m17713a()) ? null : this.f12391e;
    }

    public AppMeasurement zzbtr() {
        return this.f12395i;
    }

    public zzq zzbts() {
        m17970b(this.f12398l);
        return this.f12398l;
    }

    public zzr zzbtt() {
        if (this.f12404r != null) {
            return this.f12404r;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public zzai zzbtu() {
        m17970b(this.f12405s);
        return this.f12405s;
    }

    public void zzbuc() {
        Map map = null;
        int i = 0;
        zzwu();
        m17976a();
        if (!zzbsf().zzabc()) {
            Boolean i2 = zzbse().m17934i();
            if (i2 == null) {
                zzbsd().zzbsx().log("Upload data called on the client side before use of service was decided");
                return;
            } else if (i2.booleanValue()) {
                zzbsd().zzbsv().log("Upload called in the client side when service should be used");
                return;
            }
        }
        if (m17971o()) {
            zzbsd().zzbsx().log("Uploading requested multiple times");
        } else if (zzbts().zzadj()) {
            long currentTimeMillis = zzyw().currentTimeMillis();
            m17987a(currentTimeMillis - zzbsf().zzbrl());
            long j = zzbse().ajY.get();
            if (j != 0) {
                zzbsd().zzbtb().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
            }
            String zzbsg = zzbry().zzbsg();
            if (TextUtils.isEmpty(zzbsg)) {
                String zzbi = zzbry().zzbi(currentTimeMillis - zzbsf().zzbrl());
                if (!TextUtils.isEmpty(zzbi)) {
                    zza zzln = zzbry().zzln(zzbi);
                    if (zzln != null) {
                        String zzap = zzbsf().zzap(zzln.zzbps(), zzln.zzawo());
                        try {
                            URL url = new URL(zzap);
                            zzbsd().zzbtc().zzj("Fetching remote configuration", zzln.zzsh());
                            zzug.zzb a = zzbsa().m17941a(zzln.zzsh());
                            CharSequence b = zzbsa().m17944b(zzln.zzsh());
                            if (!(a == null || TextUtils.isEmpty(b))) {
                                map = new C0270a();
                                map.put("If-Modified-Since", b);
                            }
                            zzbts().zza(zzbi, url, map, new C34103(this));
                            return;
                        } catch (MalformedURLException e) {
                            zzbsd().zzbsv().zzj("Failed to parse config URL. Not fetching", zzap);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            List<Pair> zzn = zzbry().zzn(zzbsg, zzbsf().zzlj(zzbsg), zzbsf().zzlk(zzbsg));
            if (!zzn.isEmpty()) {
                zzuh.zze com_google_android_gms_internal_zzuh_zze;
                Object obj;
                List subList;
                for (Pair pair : zzn) {
                    com_google_android_gms_internal_zzuh_zze = (zzuh.zze) pair.first;
                    if (!TextUtils.isEmpty(com_google_android_gms_internal_zzuh_zze.anI)) {
                        obj = com_google_android_gms_internal_zzuh_zze.anI;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    for (int i3 = 0; i3 < zzn.size(); i3++) {
                        com_google_android_gms_internal_zzuh_zze = (zzuh.zze) ((Pair) zzn.get(i3)).first;
                        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzuh_zze.anI) && !com_google_android_gms_internal_zzuh_zze.anI.equals(obj)) {
                            subList = zzn.subList(0, i3);
                            break;
                        }
                    }
                }
                subList = zzn;
                zzd com_google_android_gms_internal_zzuh_zzd = new zzd();
                com_google_android_gms_internal_zzuh_zzd.ans = new zzuh.zze[subList.size()];
                List arrayList = new ArrayList(subList.size());
                while (i < com_google_android_gms_internal_zzuh_zzd.ans.length) {
                    com_google_android_gms_internal_zzuh_zzd.ans[i] = (zzuh.zze) ((Pair) subList.get(i)).first;
                    arrayList.add((Long) ((Pair) subList.get(i)).second);
                    com_google_android_gms_internal_zzuh_zzd.ans[i].anH = Long.valueOf(zzbsf().zzbpz());
                    com_google_android_gms_internal_zzuh_zzd.ans[i].anx = Long.valueOf(currentTimeMillis);
                    com_google_android_gms_internal_zzuh_zzd.ans[i].anN = Boolean.valueOf(zzbsf().zzabc());
                    i++;
                }
                Object zzb = zzbsd().m17902a(2) ? zzal.zzb(com_google_android_gms_internal_zzuh_zzd) : null;
                byte[] zza = zzbrz().zza(com_google_android_gms_internal_zzuh_zzd);
                String zzbrk = zzbsf().zzbrk();
                try {
                    URL url2 = new URL(zzbrk);
                    m17966a(arrayList);
                    zzbse().ajZ.set(currentTimeMillis);
                    Object obj2 = "?";
                    if (com_google_android_gms_internal_zzuh_zzd.ans.length > 0) {
                        obj2 = com_google_android_gms_internal_zzuh_zzd.ans[0].zzck;
                    }
                    zzbsd().zzbtc().zzd("Uploading data. app, uncompressed size, data", obj2, Integer.valueOf(zza.length), zzb);
                    zzbts().zza(zzbsg, url2, zza, null, new C34092(this));
                } catch (MalformedURLException e2) {
                    zzbsd().zzbsv().zzj("Failed to parse upload URL. Not uploading", zzbrk);
                }
            }
        } else {
            zzbsd().zzbsx().log("Network not connected, ignoring upload request");
            m17973q();
        }
    }

    public void zzd(AppMetadata appMetadata) {
        zzwu();
        m17976a();
        zzab.zzy(appMetadata);
        zzab.zzhr(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.aic)) {
            if (appMetadata.aih) {
                long currentTimeMillis = zzyw().currentTimeMillis();
                zzbry().beginTransaction();
                try {
                    m17978a(appMetadata, currentTimeMillis);
                    m17969b(appMetadata);
                    if (zzbry().zzaq(appMetadata.packageName, "_f") == null) {
                        m17981a(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf((1 + (currentTimeMillis / 3600000)) * 3600000), "auto"), appMetadata);
                        m17988b(appMetadata, currentTimeMillis);
                        m17992c(appMetadata, currentTimeMillis);
                    } else if (appMetadata.aii) {
                        m17994d(appMetadata, currentTimeMillis);
                    }
                    zzbry().setTransactionSuccessful();
                } finally {
                    zzbry().endTransaction();
                }
            } else {
                m17969b(appMetadata);
            }
        }
    }

    public void zzwu() {
        zzbsc().zzwu();
    }

    public zze zzyw() {
        return this.f12399m;
    }
}
