package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.C3963k;
import io.fabric.sdk.android.C3964b;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class C4046b implements C4045c {
    private final C3963k f14253a;
    private C2941e f14254b;
    private SSLSocketFactory f14255c;
    private boolean f14256d;

    public C4046b() {
        this(new C3964b());
    }

    public C4046b(C3963k c3963k) {
        this.f14253a = c3963k;
    }

    public void mo2889a(C2941e c2941e) {
        if (this.f14254b != c2941e) {
            this.f14254b = c2941e;
            m20921a();
        }
    }

    private synchronized void m20921a() {
        this.f14256d = false;
        this.f14255c = null;
    }

    public HttpRequest mo2888a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest a;
        switch (httpMethod) {
            case GET:
                a = HttpRequest.m20864a((CharSequence) str, (Map) map, true);
                break;
            case POST:
                a = HttpRequest.m20869b((CharSequence) str, (Map) map, true);
                break;
            case PUT:
                a = HttpRequest.m20872d((CharSequence) str);
                break;
            case DELETE:
                a = HttpRequest.m20873e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m20922a(str) && this.f14254b != null) {
            SSLSocketFactory b = m20923b();
            if (b != null) {
                ((HttpsURLConnection) a.m20891a()).setSSLSocketFactory(b);
            }
        }
        return a;
    }

    private boolean m20922a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory m20923b() {
        if (this.f14255c == null && !this.f14256d) {
            this.f14255c = m20924c();
        }
        return this.f14255c;
    }

    private synchronized SSLSocketFactory m20924c() {
        SSLSocketFactory a;
        this.f14256d = true;
        try {
            a = C4047d.m20927a(this.f14254b);
            this.f14253a.mo2849a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f14253a.mo2857e("Fabric", "Exception while validating pinned certs", e);
            a = null;
        }
        return a;
    }
}
