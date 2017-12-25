package com.bigroad.ttb.android.util;

import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class C2283e {
    private static C2282a f7928a;

    static class C2282a {
        private static SSLContext f7927a;

        public C2282a() {
            InputStream bufferedInputStream;
            Throwable e;
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                bufferedInputStream = new BufferedInputStream(OurApplication.m6281c().getAssets().open("certs/addtrustexternalcaroot.crt"));
                Certificate generateCertificate = instance.generateCertificate(bufferedInputStream);
                bufferedInputStream.close();
                ((X509Certificate) generateCertificate).getNotAfter();
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load(null, null);
                instance2.setCertificateEntry("ca", generateCertificate);
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                f7927a = SSLContext.getInstance("TLS");
                f7927a.init(null, instance3.getTrustManagers(), null);
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                C2134e.m10681d("TT-ConnectionUtils", "Couldn't initialize SSL context", e);
                f7927a = null;
            } catch (CertificateException e3) {
                e = e3;
                C2134e.m10681d("TT-ConnectionUtils", "Couldn't initialize SSL context", e);
                f7927a = null;
            } catch (IOException e4) {
                e = e4;
                C2134e.m10681d("TT-ConnectionUtils", "Couldn't initialize SSL context", e);
                f7927a = null;
            } catch (KeyManagementException e5) {
                e = e5;
                C2134e.m10681d("TT-ConnectionUtils", "Couldn't initialize SSL context", e);
                f7927a = null;
            } catch (KeyStoreException e6) {
                e = e6;
                C2134e.m10681d("TT-ConnectionUtils", "Couldn't initialize SSL context", e);
                f7927a = null;
            } catch (Throwable th) {
                bufferedInputStream.close();
            }
        }

        public void m11195a(HttpsURLConnection httpsURLConnection) {
            if (f7927a != null) {
                httpsURLConnection.setSSLSocketFactory(f7927a.getSocketFactory());
            }
        }
    }

    private static synchronized C2282a m11196a() {
        C2282a c2282a;
        synchronized (C2283e.class) {
            if (f7928a == null) {
                f7928a = new C2282a();
            }
            c2282a = f7928a;
        }
        return c2282a;
    }

    public static HttpURLConnection m11197a(URL url) {
        HttpURLConnection b = C2283e.m11198b(url);
        b.setConnectTimeout(60000);
        b.setReadTimeout(300000);
        b.setDoInput(true);
        b.setDoOutput(false);
        return b;
    }

    public static HttpURLConnection m11198b(URL url) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        C2283e.m11196a().m11195a(httpsURLConnection);
        httpsURLConnection.setAllowUserInteraction(false);
        httpsURLConnection.setInstanceFollowRedirects(true);
        return httpsURLConnection;
    }
}
