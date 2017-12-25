package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public abstract class zzk<T> implements Comparable<zzk<T>> {
    private final zza f11071a;
    private final int f11072b;
    private final String f11073c;
    private final int f11074d;
    private final com.google.android.gms.internal.zzm.zza f11075e;
    private Integer f11076f;
    private zzl f11077g;
    private boolean f11078h;
    private boolean f11079i;
    private boolean f11080j;
    private long f11081k;
    private zzo f11082l;
    private com.google.android.gms.internal.zzb.zza f11083m;

    public enum zza {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public zzk(int i, String str, com.google.android.gms.internal.zzm.zza com_google_android_gms_internal_zzm_zza) {
        this.f11071a = zza.zzbj ? new zza() : null;
        this.f11078h = true;
        this.f11079i = false;
        this.f11080j = false;
        this.f11081k = 0;
        this.f11083m = null;
        this.f11072b = i;
        this.f11073c = str;
        this.f11075e = com_google_android_gms_internal_zzm_zza;
        zza(new zzd());
        this.f11074d = mo1812a(str);
    }

    private static int mo1812a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String host = parse.getHost();
                if (host != null) {
                    return host.hashCode();
                }
            }
        }
        return 0;
    }

    private byte[] m17131a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Encoding not supported: ";
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    protected abstract zzm<T> mo1810a(zzi com_google_android_gms_internal_zzi);

    protected zzr m17133a(zzr com_google_android_gms_internal_zzr) {
        return com_google_android_gms_internal_zzr;
    }

    @Deprecated
    protected Map<String, String> m17134a() {
        return m17138c();
    }

    protected abstract void mo1811a(T t);

    @Deprecated
    protected String m17136b() {
        return m17139d();
    }

    void m17137b(final String str) {
        if (this.f11077g != null) {
            this.f11077g.m17355a(this);
        }
        if (zza.zzbj) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ zzk f11400c;

                    public void run() {
                        this.f11400c.f11071a.zza(str, id);
                        this.f11400c.f11071a.zzd(toString());
                    }
                });
                return;
            }
            this.f11071a.zza(str, id);
            this.f11071a.zzd(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f11081k >= 3000) {
            zzs.zzb("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f11081k), toString());
        }
    }

    protected Map<String, String> m17138c() {
        return null;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzc((zzk) obj);
    }

    protected String m17139d() {
        return "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.f11072b;
    }

    public String getUrl() {
        return this.f11073c;
    }

    public boolean isCanceled() {
        return false;
    }

    public String toString() {
        String str = "0x";
        String valueOf = String.valueOf(Integer.toHexString(zzf()));
        valueOf = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        str = "[ ] ";
        String valueOf2 = String.valueOf(getUrl());
        String valueOf3 = String.valueOf(zzr());
        String valueOf4 = String.valueOf(this.f11076f);
        return new StringBuilder(((((String.valueOf(str).length() + 3) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append(str).append(valueOf2).append(" ").append(valueOf).append(" ").append(valueOf3).append(" ").append(valueOf4).toString();
    }

    public final zzk<?> zza(int i) {
        this.f11076f = Integer.valueOf(i);
        return this;
    }

    public zzk<?> zza(com.google.android.gms.internal.zzb.zza com_google_android_gms_internal_zzb_zza) {
        this.f11083m = com_google_android_gms_internal_zzb_zza;
        return this;
    }

    public zzk<?> zza(zzl com_google_android_gms_internal_zzl) {
        this.f11077g = com_google_android_gms_internal_zzl;
        return this;
    }

    public zzk<?> zza(zzo com_google_android_gms_internal_zzo) {
        this.f11082l = com_google_android_gms_internal_zzo;
        return this;
    }

    public int zzc(zzk<T> com_google_android_gms_internal_zzk_T) {
        zza zzr = zzr();
        zza zzr2 = com_google_android_gms_internal_zzk_T.zzr();
        return zzr == zzr2 ? this.f11076f.intValue() - com_google_android_gms_internal_zzk_T.f11076f.intValue() : zzr2.ordinal() - zzr.ordinal();
    }

    public void zzc(zzr com_google_android_gms_internal_zzr) {
        if (this.f11075e != null) {
            this.f11075e.zze(com_google_android_gms_internal_zzr);
        }
    }

    public void zzc(String str) {
        if (zza.zzbj) {
            this.f11071a.zza(str, Thread.currentThread().getId());
        } else if (this.f11081k == 0) {
            this.f11081k = SystemClock.elapsedRealtime();
        }
    }

    public int zzf() {
        return this.f11074d;
    }

    public String zzg() {
        return getUrl();
    }

    public com.google.android.gms.internal.zzb.zza zzh() {
        return this.f11083m;
    }

    @Deprecated
    public String zzk() {
        return zzo();
    }

    @Deprecated
    public byte[] zzl() {
        Map a = m17134a();
        return (a == null || a.size() <= 0) ? null : m17131a(a, m17136b());
    }

    public String zzo() {
        String str = "application/x-www-form-urlencoded; charset=";
        String valueOf = String.valueOf(m17139d());
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }

    public byte[] zzp() {
        Map c = m17138c();
        return (c == null || c.size() <= 0) ? null : m17131a(c, m17139d());
    }

    public final boolean zzq() {
        return this.f11078h;
    }

    public zza zzr() {
        return zza.NORMAL;
    }

    public final int zzs() {
        return this.f11082l.zzc();
    }

    public zzo zzt() {
        return this.f11082l;
    }

    public void zzu() {
        this.f11080j = true;
    }

    public boolean zzv() {
        return this.f11080j;
    }
}
