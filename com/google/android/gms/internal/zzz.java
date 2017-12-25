package com.google.android.gms.internal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class zzz implements zzy {
    private final zza f11808a;
    private final SSLSocketFactory f11809b;

    public interface zza {
        String zzh(String str);
    }

    public zzz() {
        this(null);
    }

    public zzz(zza com_google_android_gms_internal_zzz_zza) {
        this(com_google_android_gms_internal_zzz_zza, null);
    }

    public zzz(zza com_google_android_gms_internal_zzz_zza, SSLSocketFactory sSLSocketFactory) {
        this.f11808a = com_google_android_gms_internal_zzz_zza;
        this.f11809b = sSLSocketFactory;
    }

    private HttpURLConnection m17608a(URL url, zzk<?> com_google_android_gms_internal_zzk_) {
        HttpURLConnection a = m17612a(url);
        int zzs = com_google_android_gms_internal_zzk_.zzs();
        a.setConnectTimeout(zzs);
        a.setReadTimeout(zzs);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f11809b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f11809b);
        }
        return a;
    }

    private static HttpEntity m17609a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    static void m17610a(HttpURLConnection httpURLConnection, zzk<?> com_google_android_gms_internal_zzk_) {
        switch (com_google_android_gms_internal_zzk_.getMethod()) {
            case -1:
                byte[] zzl = com_google_android_gms_internal_zzk_.zzl();
                if (zzl != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", com_google_android_gms_internal_zzk_.zzk());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(zzl);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                m17611b(httpURLConnection, com_google_android_gms_internal_zzk_);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                m17611b(httpURLConnection, com_google_android_gms_internal_zzk_);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                m17611b(httpURLConnection, com_google_android_gms_internal_zzk_);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m17611b(HttpURLConnection httpURLConnection, zzk<?> com_google_android_gms_internal_zzk_) {
        byte[] zzp = com_google_android_gms_internal_zzk_.zzp();
        if (zzp != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", com_google_android_gms_internal_zzk_.zzo());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzp);
            dataOutputStream.close();
        }
    }

    protected HttpURLConnection m17612a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public HttpResponse zza(zzk<?> com_google_android_gms_internal_zzk_, Map<String, String> map) {
        String zzh;
        String url = com_google_android_gms_internal_zzk_.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(com_google_android_gms_internal_zzk_.getHeaders());
        hashMap.putAll(map);
        if (this.f11808a != null) {
            zzh = this.f11808a.zzh(url);
            if (zzh == null) {
                String str = "URL blocked by rewriter: ";
                zzh = String.valueOf(url);
                throw new IOException(zzh.length() != 0 ? str.concat(zzh) : new String(str));
            }
        }
        zzh = url;
        HttpURLConnection a = m17608a(new URL(zzh), (zzk) com_google_android_gms_internal_zzk_);
        for (String zzh2 : hashMap.keySet()) {
            a.addRequestProperty(zzh2, (String) hashMap.get(zzh2));
        }
        m17610a(a, (zzk) com_google_android_gms_internal_zzk_);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (a.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a.getResponseCode(), a.getResponseMessage()));
        basicHttpResponse.setEntity(m17609a(a));
        for (Entry entry : a.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }
}
