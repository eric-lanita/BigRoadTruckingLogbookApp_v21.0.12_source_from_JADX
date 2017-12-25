package com.google.android.gms.internal;

import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class zzw implements zzy {
    protected final HttpClient f11807a;

    public static final class zza extends HttpEntityEnclosingRequestBase {
        public zza(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public zzw(HttpClient httpClient) {
        this.f11807a = httpClient;
    }

    static HttpUriRequest m17604a(zzk<?> com_google_android_gms_internal_zzk_, Map<String, String> map) {
        HttpEntityEnclosingRequestBase httpPost;
        switch (com_google_android_gms_internal_zzk_.getMethod()) {
            case -1:
                byte[] zzl = com_google_android_gms_internal_zzk_.zzl();
                if (zzl == null) {
                    return new HttpGet(com_google_android_gms_internal_zzk_.getUrl());
                }
                HttpUriRequest httpPost2 = new HttpPost(com_google_android_gms_internal_zzk_.getUrl());
                httpPost2.addHeader("Content-Type", com_google_android_gms_internal_zzk_.zzk());
                httpPost2.setEntity(new ByteArrayEntity(zzl));
                return httpPost2;
            case 0:
                return new HttpGet(com_google_android_gms_internal_zzk_.getUrl());
            case 1:
                httpPost = new HttpPost(com_google_android_gms_internal_zzk_.getUrl());
                httpPost.addHeader("Content-Type", com_google_android_gms_internal_zzk_.zzo());
                m17605a(httpPost, (zzk) com_google_android_gms_internal_zzk_);
                return httpPost;
            case 2:
                httpPost = new HttpPut(com_google_android_gms_internal_zzk_.getUrl());
                httpPost.addHeader("Content-Type", com_google_android_gms_internal_zzk_.zzo());
                m17605a(httpPost, (zzk) com_google_android_gms_internal_zzk_);
                return httpPost;
            case 3:
                return new HttpDelete(com_google_android_gms_internal_zzk_.getUrl());
            case 4:
                return new HttpHead(com_google_android_gms_internal_zzk_.getUrl());
            case 5:
                return new HttpOptions(com_google_android_gms_internal_zzk_.getUrl());
            case 6:
                return new HttpTrace(com_google_android_gms_internal_zzk_.getUrl());
            case 7:
                httpPost = new zza(com_google_android_gms_internal_zzk_.getUrl());
                httpPost.addHeader("Content-Type", com_google_android_gms_internal_zzk_.zzo());
                m17605a(httpPost, (zzk) com_google_android_gms_internal_zzk_);
                return httpPost;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void m17605a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, zzk<?> com_google_android_gms_internal_zzk_) {
        byte[] zzp = com_google_android_gms_internal_zzk_.zzp();
        if (zzp != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(zzp));
        }
    }

    private static void m17606a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    protected void m17607a(HttpUriRequest httpUriRequest) {
    }

    public HttpResponse zza(zzk<?> com_google_android_gms_internal_zzk_, Map<String, String> map) {
        HttpUriRequest a = m17604a((zzk) com_google_android_gms_internal_zzk_, (Map) map);
        m17606a(a, (Map) map);
        m17606a(a, com_google_android_gms_internal_zzk_.getHeaders());
        m17607a(a);
        HttpParams params = a.getParams();
        int zzs = com_google_android_gms_internal_zzk_.zzs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, zzs);
        return this.f11807a.execute(a);
    }
}
