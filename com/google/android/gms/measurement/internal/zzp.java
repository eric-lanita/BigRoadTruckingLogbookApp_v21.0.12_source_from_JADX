package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.measurement.AppMeasurement;

public class zzp extends zzaa {
    private final String f12290a = zzbsf().m17830a();
    private final char f12291c;
    private final long f12292d = zzbsf().zzbpz();
    private final zza f12293e;
    private final zza f12294f;
    private final zza f12295g;
    private final zza f12296h;
    private final zza f12297i;
    private final zza f12298j;
    private final zza f12299k;
    private final zza f12300l;
    private final zza f12301m;

    public class zza {
        final /* synthetic */ zzp f12286a;
        private final int f12287b;
        private final boolean f12288c;
        private final boolean f12289d;

        zza(zzp com_google_android_gms_measurement_internal_zzp, int i, boolean z, boolean z2) {
            this.f12286a = com_google_android_gms_measurement_internal_zzp;
            this.f12287b = i;
            this.f12288c = z;
            this.f12289d = z2;
        }

        public void log(String str) {
            this.f12286a.m17901a(this.f12287b, this.f12288c, this.f12289d, str, null, null, null);
        }

        public void zzd(String str, Object obj, Object obj2, Object obj3) {
            this.f12286a.m17901a(this.f12287b, this.f12288c, this.f12289d, str, obj, obj2, obj3);
        }

        public void zze(String str, Object obj, Object obj2) {
            this.f12286a.m17901a(this.f12287b, this.f12288c, this.f12289d, str, obj, obj2, null);
        }

        public void zzj(String str, Object obj) {
            this.f12286a.m17901a(this.f12287b, this.f12288c, this.f12289d, str, obj, null, null);
        }
    }

    zzp(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        if (zzbsf().zzabd()) {
            this.f12291c = zzbsf().zzabc() ? 'P' : 'C';
        } else {
            this.f12291c = zzbsf().zzabc() ? 'p' : 'c';
        }
        this.f12293e = new zza(this, 6, false, false);
        this.f12294f = new zza(this, 6, true, false);
        this.f12295g = new zza(this, 6, false, true);
        this.f12296h = new zza(this, 5, false, false);
        this.f12297i = new zza(this, 5, true, false);
        this.f12298j = new zza(this, 5, false, true);
        this.f12299k = new zza(this, 4, false, false);
        this.f12300l = new zza(this, 3, false, false);
        this.f12301m = new zza(this, 2, false, false);
    }

    private static String m17897a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    static String m17898a(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return z ? "-" : String.valueOf(valueOf);
            } else {
                Throwable th = (Throwable) valueOf;
                StringBuilder stringBuilder = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String a = m17897a(AppMeasurement.class.getCanonicalName());
                String a2 = m17897a(zzx.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = m17897a(className);
                            if (className.equals(a) || className.equals(a2)) {
                                stringBuilder.append(": ");
                                stringBuilder.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return stringBuilder.toString();
            }
        }
    }

    static String m17899a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object a = m17898a(z, obj);
        Object a2 = m17898a(z, obj2);
        Object a3 = m17898a(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a)) {
            stringBuilder.append(str2);
            stringBuilder.append(a);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a2)) {
            stringBuilder.append(str2);
            stringBuilder.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            stringBuilder.append(str2);
            stringBuilder.append(a3);
        }
        return stringBuilder.toString();
    }

    protected void m17900a(int i, String str) {
        Log.println(i, this.f12290a, str);
    }

    protected void m17901a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m17902a(i)) {
            m17900a(i, m17899a(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    protected boolean m17902a(int i) {
        return Log.isLoggable(this.f12290a, i);
    }

    protected void mo2375d() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        zzab.zzy(str);
        zzw d = this.b.m17993d();
        if (d == null) {
            m17900a(6, "Scheduler not set. Not logging error/warn.");
        } else if (!d.m17713a()) {
            m17900a(6, "Scheduler not initialized. Not logging error/warn.");
        } else if (d.m17714b()) {
            m17900a(6, "Scheduler shutdown. Not logging error/warn.");
        } else {
            if (i < 0) {
                i = 0;
            }
            if (i >= "01VDIWEA?".length()) {
                i = "01VDIWEA?".length() - 1;
            }
            String valueOf = String.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            char charAt = "01VDIWEA?".charAt(i);
            char c = this.f12291c;
            long j = this.f12292d;
            String valueOf2 = String.valueOf(m17899a(true, str, obj, obj2, obj3));
            valueOf = new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append(valueOf).append(charAt).append(c).append(j).append(":").append(valueOf2).toString();
            if (valueOf.length() > 1024) {
                valueOf = str.substring(0, 1024);
            }
            d.zzm(new Runnable(this) {
                final /* synthetic */ zzp f12285b;

                public void run() {
                    zzt zzbse = this.f12285b.b.zzbse();
                    if (!zzbse.m17713a() || zzbse.m17714b()) {
                        this.f12285b.m17900a(6, "Persisted config not initialized . Not logging error/warn.");
                    } else {
                        zzbse.ajX.zzev(valueOf);
                    }
                }
            });
        }
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

    public zza zzbsv() {
        return this.f12293e;
    }

    public zza zzbsw() {
        return this.f12294f;
    }

    public zza zzbsx() {
        return this.f12296h;
    }

    public zza zzbsy() {
        return this.f12297i;
    }

    public zza zzbsz() {
        return this.f12298j;
    }

    public zza zzbta() {
        return this.f12299k;
    }

    public zza zzbtb() {
        return this.f12300l;
    }

    public zza zzbtc() {
        return this.f12301m;
    }

    public String zzbtd() {
        Pair zzadv = zzbse().ajX.zzadv();
        if (zzadv == null || zzadv == zzt.f12344a) {
            return null;
        }
        String valueOf = String.valueOf(String.valueOf(zzadv.second));
        String str = (String) zzadv.first;
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
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
