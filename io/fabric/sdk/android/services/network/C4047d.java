package io.fabric.sdk.android.services.network;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class C4047d {
    public static final SSLSocketFactory m20927a(C2941e c2941e) {
        SSLContext instance = SSLContext.getInstance("TLS");
        C4048f c4048f = new C4048f(new C4049g(c2941e.mo1482a(), c2941e.mo1483b()), c2941e);
        instance.init(null, new TrustManager[]{c4048f}, null);
        return instance.getSocketFactory();
    }
}
