package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

class zzah extends zzd {
    private static final byte[] f10252c = "\n".getBytes();
    private final String f10253a = m16602a("GoogleAnalytics", zze.VERSION, VERSION.RELEASE, zzao.zza(Locale.getDefault()), Build.MODEL, Build.ID);
    private final zzal f10254b;

    private class zza {
        final /* synthetic */ zzah f10249a;
        private int f10250b;
        private ByteArrayOutputStream f10251c = new ByteArrayOutputStream();

        public zza(zzah com_google_android_gms_analytics_internal_zzah) {
            this.f10249a = com_google_android_gms_analytics_internal_zzah;
        }

        public byte[] getPayload() {
            return this.f10251c.toByteArray();
        }

        public int zzadm() {
            return this.f10250b;
        }

        public boolean zzj(zzab com_google_android_gms_analytics_internal_zzab) {
            zzab.zzy(com_google_android_gms_analytics_internal_zzab);
            if (this.f10250b + 1 > this.f10249a.m16542i().zzabo()) {
                return false;
            }
            String a = this.f10249a.m16614a(com_google_android_gms_analytics_internal_zzab, false);
            if (a == null) {
                this.f10249a.m16541h().zza(com_google_android_gms_analytics_internal_zzab, "Error formatting hit");
                return true;
            }
            byte[] bytes = a.getBytes();
            int length = bytes.length;
            if (length > this.f10249a.m16542i().zzabg()) {
                this.f10249a.m16541h().zza(com_google_android_gms_analytics_internal_zzab, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.f10251c.size() > 0) {
                length++;
            }
            if (length + this.f10251c.size() > this.f10249a.m16542i().zzabi()) {
                return false;
            }
            try {
                if (this.f10251c.size() > 0) {
                    this.f10251c.write(zzah.f10252c);
                }
                this.f10251c.write(bytes);
                this.f10250b++;
                return true;
            } catch (IOException e) {
                this.f10249a.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }
    }

    zzah(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.f10254b = new zzal(com_google_android_gms_analytics_internal_zzf.zzyw());
    }

    private int m16601a(URL url, byte[] bArr) {
        HttpURLConnection a;
        Object e;
        Throwable th;
        OutputStream outputStream = null;
        zzab.zzy(url);
        zzab.zzy(bArr);
        zzb("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (zztb()) {
            zza("Post payload\n", new String(bArr));
        }
        try {
            m16619a(m16540g().getPackageName());
            a = m16615a(url);
            try {
                a.setDoOutput(true);
                a.setFixedLengthStreamingMode(bArr.length);
                a.connect();
                outputStream = a.getOutputStream();
                outputStream.write(bArr);
                m16605a(a);
                int responseCode = a.getResponseCode();
                if (responseCode == 200) {
                    m16544k().m16640c();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        zze("Error closing http post connection output stream", e2);
                    }
                }
                if (a != null) {
                    a.disconnect();
                }
                m16620b();
                return responseCode;
            } catch (IOException e3) {
                e = e3;
                try {
                    zzd("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            zze("Error closing http post connection output stream", e4);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    m16620b();
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            zze("Error closing http post connection output stream", e22);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    m16620b();
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            a = outputStream;
            zzd("Network POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            m16620b();
            return 0;
        } catch (Throwable th3) {
            th = th3;
            a = outputStream;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            m16620b();
            throw th;
        }
    }

    private static String m16602a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    private URL m16603a(zzab com_google_android_gms_analytics_internal_zzab, String str) {
        String valueOf;
        String valueOf2;
        if (com_google_android_gms_analytics_internal_zzab.zzadb()) {
            valueOf2 = String.valueOf(m16542i().zzabq());
            valueOf = String.valueOf(m16542i().zzabs());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        } else {
            valueOf2 = String.valueOf(m16542i().zzabr());
            valueOf = String.valueOf(m16542i().zzabs());
            valueOf = new StringBuilder(((String.valueOf(valueOf2).length() + 1) + String.valueOf(valueOf).length()) + String.valueOf(str).length()).append(valueOf2).append(valueOf).append("?").append(str).toString();
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void m16604a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private void m16605a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private boolean m16606a(zzab com_google_android_gms_analytics_internal_zzab) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzab);
        String a = m16614a(com_google_android_gms_analytics_internal_zzab, !com_google_android_gms_analytics_internal_zzab.zzadb());
        if (a == null) {
            m16541h().zza(com_google_android_gms_analytics_internal_zzab, "Error formatting hit for upload");
            return true;
        } else if (a.length() <= m16542i().zzabf()) {
            URL a2 = m16603a(com_google_android_gms_analytics_internal_zzab, a);
            if (a2 != null) {
                return m16608b(a2) == 200;
            } else {
                zzel("Failed to build collect GET endpoint url");
                return false;
            }
        } else {
            a = m16614a(com_google_android_gms_analytics_internal_zzab, false);
            if (a == null) {
                m16541h().zza(com_google_android_gms_analytics_internal_zzab, "Error formatting hit for POST upload");
                return true;
            }
            byte[] bytes = a.getBytes();
            if (bytes.length > m16542i().zzabh()) {
                m16541h().zza(com_google_android_gms_analytics_internal_zzab, "Hit payload exceeds size limit");
                return true;
            }
            URL b = m16610b(com_google_android_gms_analytics_internal_zzab);
            if (b != null) {
                return m16601a(b, bytes) == 200;
            } else {
                zzel("Failed to build collect POST endpoint url");
                return false;
            }
        }
    }

    private static byte[] m16607a(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private int m16608b(java.net.URL r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:7:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        com.google.android.gms.common.internal.zzab.zzy(r5);
        r0 = "GET request";
        r4.zzb(r0, r5);
        r1 = 0;
        r1 = r4.m16615a(r5);	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r1.connect();	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r4.m16605a(r1);	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r0 = r1.getResponseCode();	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        if (r0 != r2) goto L_0x0022;	 Catch:{ IOException -> 0x0031, all -> 0x003e }
    L_0x001b:
        r2 = r4.m16544k();	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r2.m16640c();	 Catch:{ IOException -> 0x0031, all -> 0x003e }
    L_0x0022:
        r2 = "GET status";	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r3 = java.lang.Integer.valueOf(r0);	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r4.zzb(r2, r3);	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        if (r1 == 0) goto L_0x0030;
    L_0x002d:
        r1.disconnect();
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = move-exception;
        r2 = "Network GET connection error";	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        r4.zzd(r2, r0);	 Catch:{ IOException -> 0x0031, all -> 0x003e }
        if (r1 == 0) goto L_0x003c;
    L_0x0039:
        r1.disconnect();
    L_0x003c:
        r0 = 0;
        goto L_0x0030;
    L_0x003e:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0044;
    L_0x0041:
        r1.disconnect();
    L_0x0044:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzah.b(java.net.URL):int");
    }

    private int m16609b(URL url, byte[] bArr) {
        Object e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        OutputStream outputStream = null;
        zzab.zzy(url);
        zzab.zzy(bArr);
        HttpURLConnection a;
        try {
            OutputStream outputStream2;
            m16619a(m16540g().getPackageName());
            byte[] a2 = m16607a(bArr);
            zza("POST compressed size, ratio %, url", Integer.valueOf(a2.length), Long.valueOf((100 * ((long) a2.length)) / ((long) bArr.length)), url);
            if (a2.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(a2.length), Integer.valueOf(bArr.length));
            }
            if (zztb()) {
                String str = "Post payload";
                String str2 = "\n";
                String valueOf = String.valueOf(new String(bArr));
                zza(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            }
            a = m16615a(url);
            try {
                a.setDoOutput(true);
                a.addRequestProperty("Content-Encoding", "gzip");
                a.setFixedLengthStreamingMode(a2.length);
                a.connect();
                outputStream2 = a.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = a;
                try {
                    zzd("Network compressed POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            zze("Error closing http compressed post connection output stream", e3);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    m16620b();
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    a = httpURLConnection;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            zze("Error closing http compressed post connection output stream", e4);
                        }
                    }
                    if (a != null) {
                        a.disconnect();
                    }
                    m16620b();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                m16620b();
                throw th;
            }
            try {
                outputStream2.write(a2);
                outputStream2.close();
                m16605a(a);
                int responseCode = a.getResponseCode();
                if (responseCode == 200) {
                    m16544k().m16640c();
                }
                zzb("POST status", Integer.valueOf(responseCode));
                if (a != null) {
                    a.disconnect();
                }
                m16620b();
                return responseCode;
            } catch (IOException e5) {
                e = e5;
                outputStream = outputStream2;
                httpURLConnection = a;
                zzd("Network compressed POST connection error", e);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                m16620b();
                return 0;
            } catch (Throwable th4) {
                th = th4;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                m16620b();
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnection = null;
            zzd("Network compressed POST connection error", e);
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            m16620b();
            return 0;
        } catch (Throwable th5) {
            th = th5;
            a = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            m16620b();
            throw th;
        }
    }

    private URL m16610b(zzab com_google_android_gms_analytics_internal_zzab) {
        String valueOf;
        String valueOf2;
        if (com_google_android_gms_analytics_internal_zzab.zzadb()) {
            valueOf = String.valueOf(m16542i().zzabq());
            valueOf2 = String.valueOf(m16542i().zzabs());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            valueOf = String.valueOf(m16542i().zzabr());
            valueOf2 = String.valueOf(m16542i().zzabs());
            valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        try {
            return new URL(valueOf);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String m16611c(zzab com_google_android_gms_analytics_internal_zzab) {
        return String.valueOf(com_google_android_gms_analytics_internal_zzab.zzacy());
    }

    private URL m16613t() {
        String valueOf = String.valueOf(m16542i().zzabq());
        String valueOf2 = String.valueOf(m16542i().zzabt());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String m16614a(zzab com_google_android_gms_analytics_internal_zzab, boolean z) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzab);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : com_google_android_gms_analytics_internal_zzab.zzm().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    m16604a(stringBuilder, str, (String) entry.getValue());
                }
            }
            m16604a(stringBuilder, "ht", String.valueOf(com_google_android_gms_analytics_internal_zzab.zzacz()));
            m16604a(stringBuilder, "qt", String.valueOf(m16539f().currentTimeMillis() - com_google_android_gms_analytics_internal_zzab.zzacz()));
            if (m16542i().zzabc()) {
                m16604a(stringBuilder, "_gmsv", zze.VERSION);
            }
            if (z) {
                long zzadc = com_google_android_gms_analytics_internal_zzab.zzadc();
                m16604a(stringBuilder, "z", zzadc != 0 ? String.valueOf(zzadc) : m16611c(com_google_android_gms_analytics_internal_zzab));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    HttpURLConnection m16615a(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(m16542i().zzacf());
            httpURLConnection.setReadTimeout(m16542i().zzacg());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.f10253a);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    List<Long> m16616a(List<zzab> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (zzab com_google_android_gms_analytics_internal_zzab : list) {
            if (!m16606a(com_google_android_gms_analytics_internal_zzab)) {
                break;
            }
            arrayList.add(Long.valueOf(com_google_android_gms_analytics_internal_zzab.zzacy()));
            if (arrayList.size() >= m16542i().zzabn()) {
                break;
            }
        }
        return arrayList;
    }

    List<Long> m16617a(List<zzab> list, boolean z) {
        zzab.zzbo(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza com_google_android_gms_analytics_internal_zzah_zza = new zza(this);
        List<Long> arrayList = new ArrayList();
        for (zzab com_google_android_gms_analytics_internal_zzab : list) {
            if (!com_google_android_gms_analytics_internal_zzah_zza.zzj(com_google_android_gms_analytics_internal_zzab)) {
                break;
            }
            arrayList.add(Long.valueOf(com_google_android_gms_analytics_internal_zzab.zzacy()));
        }
        if (com_google_android_gms_analytics_internal_zzah_zza.zzadm() == 0) {
            return arrayList;
        }
        URL t = m16613t();
        if (t == null) {
            zzel("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int b = z ? m16609b(t, com_google_android_gms_analytics_internal_zzah_zza.getPayload()) : m16601a(t, com_google_android_gms_analytics_internal_zzah_zza.getPayload());
        if (200 == b) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(com_google_android_gms_analytics_internal_zzah_zza.zzadm()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(b));
        if (m16542i().zzabw().contains(Integer.valueOf(b))) {
            zzek("Server instructed the client to stop batching");
            this.f10254b.start();
        }
        return Collections.emptyList();
    }

    protected void mo1605a() {
        zza("Network initialized. User agent", this.f10253a);
    }

    protected void m16619a(String str) {
    }

    protected void m16620b() {
    }

    public boolean zzadj() {
        NetworkInfo activeNetworkInfo;
        m16538e();
        m16553s();
        try {
            activeNetworkInfo = ((ConnectivityManager) m16540g().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzeh("No network connectivity");
        return false;
    }

    public List<Long> zzs(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        m16538e();
        m16553s();
        zzab.zzy(list);
        if (m16542i().zzabw().isEmpty() || !this.f10254b.zzx(m16542i().zzabp() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = m16542i().zzabu() != zzm.zzcyn;
            if (m16542i().zzabv() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? m16617a((List) list, z2) : m16616a((List) list);
    }
}
