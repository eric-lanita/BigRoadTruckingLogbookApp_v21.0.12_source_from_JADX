package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class C2826a {
    private static final Pattern f9770b = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final C2822h f9771a;
    private final String f9772c;
    private final C4045c f9773d;
    private final HttpMethod f9774e;
    private final String f9775f;

    public C2826a(C2822h c2822h, String str, String str2, C4045c c4045c, HttpMethod httpMethod) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (c4045c == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.f9771a = c2822h;
            this.f9775f = str;
            this.f9772c = m15989a(str2);
            this.f9773d = c4045c;
            this.f9774e = httpMethod;
        }
    }

    protected String m15991a() {
        return this.f9772c;
    }

    protected HttpRequest m15992b() {
        return m15990a(Collections.emptyMap());
    }

    protected HttpRequest m15990a(Map<String, String> map) {
        return this.f9773d.mo2888a(this.f9774e, m15991a(), map).m20889a(false).m20879a(10000).m20882a("User-Agent", "Crashlytics Android SDK/" + this.f9771a.mo1426a()).m20882a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String m15989a(String str) {
        if (CommonUtils.m20716c(this.f9775f)) {
            return str;
        }
        return f9770b.matcher(str).replaceFirst(this.f9775f);
    }
}
