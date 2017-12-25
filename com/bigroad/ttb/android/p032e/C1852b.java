package com.bigroad.ttb.android.p032e;

import com.bigroad.shared.C1180y;
import com.bigroad.shared.C1181z;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.C1764c;
import com.bigroad.ttb.android.util.C2283e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class C1852b implements Runnable {
    private final C1851a f6304a;
    private final String f6305b;
    private final File f6306c;
    private final String f6307d;
    private boolean f6308e = false;

    public C1852b(C1764c c1764c, C1851a c1851a) {
        this.f6304a = c1851a;
        this.f6305b = c1764c.m8573b();
        this.f6306c = c1851a.m8932a(this.f6305b);
        if (!this.f6306c.exists()) {
            C2134e.m10682e("TT-FileUpldReq", "The file for hash " + this.f6305b + " could not be found");
        }
        this.f6307d = c1764c.m8574d();
    }

    private String m8938d() {
        byte[] a = OurApplication.m6285g().m12191a();
        long lastModified = this.f6306c.lastModified();
        String str = "https://" + OurApplication.m6245B().m10547b() + "/" + "upload/v1";
        C2134e.m10678c("TT-FileUpldReq", "Using request URL: '" + str + "'");
        return str + "?fh=" + this.f6305b + "&cid=" + C1180y.m5990a(a) + "&ct=" + lastModified;
    }

    public String m8940a() {
        return this.f6305b;
    }

    public boolean m8941b() {
        return this.f6306c.exists();
    }

    public boolean m8942c() {
        return this.f6308e;
    }

    private void m8939e() {
        Closeable fileInputStream;
        HttpURLConnection b;
        IOException e;
        Closeable closeable;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        C2134e.m10678c("TT-FileUpldReq", "Uploading file " + this.f6305b);
        this.f6308e = false;
        try {
            URL url = new URL(m8938d());
            long length = this.f6306c.length();
            fileInputStream = new FileInputStream(this.f6306c);
            try {
                b = C2283e.m11198b(url);
            } catch (IOException e2) {
                e = e2;
                closeable = fileInputStream;
                try {
                    C2134e.m10680d("TT-FileUpldReq", e.toString());
                    C1181z.m5999a(closeable);
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = closeable;
                    b = httpURLConnection;
                    C1181z.m5999a(fileInputStream);
                    if (b != null) {
                        b.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                b = null;
                C1181z.m5999a(fileInputStream);
                if (b != null) {
                    b.disconnect();
                }
                throw th;
            }
            try {
                b.setUseCaches(false);
                b.setConnectTimeout(60000);
                b.setReadTimeout(300000);
                b.setRequestMethod("POST");
                if (this.f6307d != null) {
                    b.setRequestProperty("Content-Type", this.f6307d);
                }
                b.setRequestProperty("Content-Length", Long.toString(length));
                b.setFixedLengthStreamingMode((int) length);
                b.setDoInput(true);
                b.setDoOutput(true);
                Closeable outputStream = b.getOutputStream();
                if (C1181z.m5998a(fileInputStream, outputStream) != length) {
                    throw new IOException("copied less than expected number of bytes");
                }
                C1181z.m5999a(outputStream);
                if (b.getResponseCode() == 200) {
                    this.f6308e = true;
                } else {
                    C2134e.m10680d("TT-FileUpldReq", "HTTP post failed, response code " + b.getResponseCode() + ": " + b.getResponseMessage());
                }
                C1181z.m5999a(fileInputStream);
                if (b != null) {
                    b.disconnect();
                }
            } catch (IOException e3) {
                e = e3;
                httpURLConnection = b;
                closeable = fileInputStream;
                C2134e.m10680d("TT-FileUpldReq", e.toString());
                C1181z.m5999a(closeable);
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th4) {
                th = th4;
                C1181z.m5999a(fileInputStream);
                if (b != null) {
                    b.disconnect();
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            closeable = null;
            C2134e.m10680d("TT-FileUpldReq", e.toString());
            C1181z.m5999a(closeable);
            if (httpURLConnection == null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th5) {
            th = th5;
            b = null;
            fileInputStream = null;
            C1181z.m5999a(fileInputStream);
            if (b != null) {
                b.disconnect();
            }
            throw th;
        }
    }

    public void run() {
        try {
            m8939e();
        } catch (Throwable e) {
            C2134e.m10681d("TT-FileUpldReq", "Error transferring file", e);
        }
        this.f6304a.m8934a(this);
    }
}
