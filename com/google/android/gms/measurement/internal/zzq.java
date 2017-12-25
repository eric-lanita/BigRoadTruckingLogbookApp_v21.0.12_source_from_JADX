package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzq extends zzaa {

    interface zza {
        void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map);
    }

    private static class zzb implements Runnable {
        private final zza f12302a;
        private final int f12303b;
        private final Throwable f12304c;
        private final byte[] f12305d;
        private final String f12306e;
        private final Map<String, List<String>> f12307f;

        private zzb(String str, zza com_google_android_gms_measurement_internal_zzq_zza, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
            zzab.zzy(com_google_android_gms_measurement_internal_zzq_zza);
            this.f12302a = com_google_android_gms_measurement_internal_zzq_zza;
            this.f12303b = i;
            this.f12304c = th;
            this.f12305d = bArr;
            this.f12306e = str;
            this.f12307f = map;
        }

        public void run() {
            this.f12302a.zza(this.f12306e, this.f12303b, this.f12304c, this.f12305d, this.f12307f);
        }
    }

    private class zzc implements Runnable {
        final /* synthetic */ zzq f12308a;
        private final URL f12309b;
        private final byte[] f12310c;
        private final zza f12311d;
        private final String f12312e;
        private final Map<String, String> f12313f;

        public zzc(zzq com_google_android_gms_measurement_internal_zzq, String str, URL url, byte[] bArr, Map<String, String> map, zza com_google_android_gms_measurement_internal_zzq_zza) {
            this.f12308a = com_google_android_gms_measurement_internal_zzq;
            zzab.zzhr(str);
            zzab.zzy(url);
            zzab.zzy(com_google_android_gms_measurement_internal_zzq_zza);
            this.f12309b = url;
            this.f12310c = bArr;
            this.f12311d = com_google_android_gms_measurement_internal_zzq_zza;
            this.f12312e = str;
            this.f12313f = map;
        }

        public void run() {
            HttpURLConnection a;
            OutputStream outputStream;
            Throwable e;
            Map map;
            int i;
            HttpURLConnection httpURLConnection;
            Throwable th;
            Map map2;
            this.f12308a.zzbrs();
            int i2 = 0;
            try {
                this.f12308a.m17907a(this.f12312e);
                a = this.f12308a.m17906a(this.f12309b);
                try {
                    if (this.f12313f != null) {
                        for (Entry entry : this.f12313f.entrySet()) {
                            a.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.f12310c != null) {
                        byte[] zzj = this.f12308a.zzbrz().zzj(this.f12310c);
                        this.f12308a.zzbsd().zzbtc().zzj("Uploading data. size", Integer.valueOf(zzj.length));
                        a.setDoOutput(true);
                        a.addRequestProperty("Content-Encoding", "gzip");
                        a.setFixedLengthStreamingMode(zzj.length);
                        a.connect();
                        outputStream = a.getOutputStream();
                        try {
                            outputStream.write(zzj);
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            map = null;
                            i = 0;
                            httpURLConnection = a;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    this.f12308a.zzbsd().zzbsv().zzj("Error closing HTTP compressed POST connection output stream", e3);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f12308a.m17909e();
                            this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i, e, null, map));
                        } catch (Throwable th2) {
                            th = th2;
                            map2 = null;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    this.f12308a.zzbsd().zzbsv().zzj("Error closing HTTP compressed POST connection output stream", e32);
                                }
                            }
                            if (a != null) {
                                a.disconnect();
                            }
                            this.f12308a.m17909e();
                            this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i2, null, null, map2));
                            throw th;
                        }
                    }
                    i2 = a.getResponseCode();
                    map2 = a.getHeaderFields();
                } catch (IOException e4) {
                    e = e4;
                    map = null;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = a;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f12308a.m17909e();
                    this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i, e, null, map));
                } catch (Throwable th3) {
                    th = th3;
                    map2 = null;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f12308a.m17909e();
                    this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i2, null, null, map2));
                    throw th;
                }
                try {
                    byte[] a2 = this.f12308a.m17905a(a);
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f12308a.m17909e();
                    this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i2, null, a2, map2));
                } catch (IOException e5) {
                    e = e5;
                    map = map2;
                    i = i2;
                    outputStream = null;
                    httpURLConnection = a;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f12308a.m17909e();
                    this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i, e, null, map));
                } catch (Throwable th32) {
                    th = th32;
                    outputStream = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    this.f12308a.m17909e();
                    this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i2, null, null, map2));
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                map = null;
                i = 0;
                outputStream = null;
                httpURLConnection = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f12308a.m17909e();
                this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i, e, null, map));
            } catch (Throwable th322) {
                th = th322;
                map2 = null;
                a = null;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                this.f12308a.m17909e();
                this.f12308a.zzbsc().zzm(new zzb(this.f12312e, this.f12311d, i2, null, null, map2));
                throw th;
            }
        }
    }

    public zzq(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private byte[] m17905a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            return toByteArray;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    protected HttpURLConnection m17906a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout((int) zzbsf().m17839i());
            httpURLConnection.setReadTimeout((int) zzbsf().m17840j());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain HTTP connection");
    }

    protected void m17907a(String str) {
    }

    protected void mo2375d() {
    }

    protected void m17909e() {
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zza(String str, URL url, Map<String, String> map, zza com_google_android_gms_measurement_internal_zzq_zza) {
        zzwu();
        m17715c();
        zzab.zzy(url);
        zzab.zzy(com_google_android_gms_measurement_internal_zzq_zza);
        zzbsc().zzn(new zzc(this, str, url, null, map, com_google_android_gms_measurement_internal_zzq_zza));
    }

    public void zza(String str, URL url, byte[] bArr, Map<String, String> map, zza com_google_android_gms_measurement_internal_zzq_zza) {
        zzwu();
        m17715c();
        zzab.zzy(url);
        zzab.zzy(bArr);
        zzab.zzy(com_google_android_gms_measurement_internal_zzq_zza);
        zzbsc().zzn(new zzc(this, str, url, bArr, map, com_google_android_gms_measurement_internal_zzq_zza));
    }

    public boolean zzadj() {
        NetworkInfo activeNetworkInfo;
        m17715c();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
