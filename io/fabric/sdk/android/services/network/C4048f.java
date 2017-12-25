package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.C3969c;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class C4048f implements X509TrustManager {
    private static final X509Certificate[] f14257a = new X509Certificate[0];
    private final TrustManager[] f14258b;
    private final C4049g f14259c;
    private final long f14260d;
    private final List<byte[]> f14261e = new LinkedList();
    private final Set<X509Certificate> f14262f = Collections.synchronizedSet(new HashSet());

    public C4048f(C4049g c4049g, C2941e c2941e) {
        this.f14258b = m20932a(c4049g);
        this.f14259c = c4049g;
        this.f14260d = c2941e.mo1485d();
        for (String a : c2941e.mo1484c()) {
            this.f14261e.add(m20931a(a));
        }
    }

    private TrustManager[] m20932a(C4049g c4049g) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(c4049g.f14263a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    private boolean m20930a(X509Certificate x509Certificate) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f14261e) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            throw new CertificateException(e);
        }
    }

    private void m20929a(X509Certificate[] x509CertificateArr, String str) {
        for (TrustManager trustManager : this.f14258b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void m20928a(X509Certificate[] x509CertificateArr) {
        if (this.f14260d == -1 || System.currentTimeMillis() - this.f14260d <= 15552000000L) {
            X509Certificate[] a = C4043a.m20918a(x509CertificateArr, this.f14259c);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m20930a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        C3969c.m20576h().mo2854d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.f14260d) + " millis vs " + 15552000000L + " millis) falling back to system trust.");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        if (!this.f14262f.contains(x509CertificateArr[0])) {
            m20929a(x509CertificateArr, str);
            m20928a(x509CertificateArr);
            this.f14262f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f14257a;
    }

    private byte[] m20931a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
