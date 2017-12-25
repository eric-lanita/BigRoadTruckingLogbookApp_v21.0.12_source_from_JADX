package com.urbanairship.p055b;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.p055b.C3760c.C3759a;
import com.urbanairship.util.C3954i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class C3756a {
    protected URL f13482a;
    protected String f13483b;
    protected String f13484c;
    protected String f13485d;
    protected String f13486e;
    protected String f13487f;
    protected final Map<String, String> f13488g;
    private long f13489h = 0;
    private boolean f13490i = false;

    public C3756a(String str, URL url) {
        this.f13485d = str;
        this.f13482a = url;
        this.f13488g = new HashMap();
        this.f13488g.put("User-Agent", C3756a.m19641b());
    }

    public C3756a m19643a(String str, String str2) {
        this.f13483b = str;
        this.f13484c = str2;
        return this;
    }

    public C3756a m19646b(String str, String str2) {
        this.f13486e = str;
        this.f13487f = str2;
        return this;
    }

    public C3756a m19642a(long j) {
        this.f13489h = j;
        return this;
    }

    public C3756a m19647c(String str, String str2) {
        if (str2 == null) {
            this.f13488g.remove(str);
        } else {
            this.f13488g.put(str, str2);
        }
        return this;
    }

    public C3756a m19644a(boolean z) {
        this.f13490i = z;
        return this;
    }

    public C3760c m19645a() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.f13482a.openConnection();
            try {
                httpURLConnection2.setRequestMethod(this.f13485d);
                if (this.f13486e != null) {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestProperty("Content-Type", this.f13487f);
                }
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setAllowUserInteraction(false);
                if (this.f13489h > 0) {
                    httpURLConnection2.setIfModifiedSince(this.f13489h);
                }
                for (String str : this.f13488g.keySet()) {
                    httpURLConnection2.setRequestProperty(str, (String) this.f13488g.get(str));
                }
                if (!(C3954i.m20512a(this.f13483b) || C3954i.m20512a(this.f13484c))) {
                    httpURLConnection2.setRequestProperty("Authorization", "Basic " + Base64.encodeToString((this.f13483b + ":" + this.f13484c).getBytes(), 2));
                }
                if (this.f13486e != null) {
                    OutputStream outputStream;
                    if (this.f13490i) {
                        httpURLConnection2.setRequestProperty("Content-Encoding", "gzip");
                        outputStream = httpURLConnection2.getOutputStream();
                        OutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                        Writer outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, "UTF-8");
                        outputStreamWriter.write(this.f13486e);
                        outputStreamWriter.close();
                        gZIPOutputStream.close();
                        outputStream.close();
                    } else {
                        outputStream = httpURLConnection2.getOutputStream();
                        Writer outputStreamWriter2 = new OutputStreamWriter(outputStream, "UTF-8");
                        outputStreamWriter2.write(this.f13486e);
                        outputStreamWriter2.close();
                        outputStream.close();
                    }
                }
                C3759a a = new C3759a(httpURLConnection2.getResponseCode()).m19650a(httpURLConnection2.getResponseMessage()).m19651a(httpURLConnection2.getHeaderFields()).m19649a(httpURLConnection2.getLastModified());
                try {
                    a.m19653b(m19640a(httpURLConnection2.getInputStream()));
                } catch (IOException e) {
                    a.m19653b(m19640a(httpURLConnection2.getErrorStream()));
                }
                C3760c a2 = a.m19652a();
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                return a2;
            } catch (Throwable e2) {
                th = e2;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                try {
                    C3783j.m19724b("Request - Request failed URL: " + this.f13482a + " method: " + this.f13485d, th2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th2;
                }
            } catch (Throwable e22) {
                th = e22;
                httpURLConnection = httpURLConnection2;
                th2 = th;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Exception e3) {
            th2 = e3;
            httpURLConnection = null;
            C3783j.m19724b("Request - Request failed URL: " + this.f13482a + " method: " + this.f13485d, th2);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th4) {
            th2 = th4;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th2;
        }
    }

    public static String m19641b() {
        String str = C3929q.m20372a().m20399w() == 1 ? "amazon" : "android";
        return String.format(Locale.US, "%s (%s; %s; UrbanAirshipLib-%s/%s; %s; %s)", new Object[]{C3929q.m20374b(), Build.MODEL, VERSION.RELEASE, str, C3929q.m20385k(), C3929q.m20372a().m20388l().m19664a(), Locale.getDefault()});
    }

    private String m19640a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine).append("\n");
            } finally {
                try {
                    inputStream.close();
                    bufferedReader.close();
                } catch (Throwable e) {
                    stringBuilder = "Failed to close streams";
                    C3783j.m19726c(stringBuilder, e);
                }
            }
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}
