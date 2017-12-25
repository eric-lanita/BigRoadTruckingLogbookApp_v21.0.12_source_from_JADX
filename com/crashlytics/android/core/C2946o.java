package com.crashlytics.android.core;

import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C2826a;
import io.fabric.sdk.android.services.common.C4015o;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.Map.Entry;

class C2946o extends C2826a implements C2945n {
    public C2946o(C2822h c2822h, String str, String str2, C4045c c4045c) {
        super(c2822h, str, str2, c4045c, HttpMethod.POST);
    }

    public boolean mo1486a(C2944m c2944m) {
        HttpRequest a = m16426a(m16427a(m15992b(), c2944m), c2944m.f10082b);
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Sending report to: " + m15991a());
        int b = a.m20892b();
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Create report request ID: " + a.m20894b("X-REQUEST-ID"));
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Result was: " + b);
        return C4015o.m20815a(b) == 0;
    }

    private HttpRequest m16427a(HttpRequest httpRequest, C2944m c2944m) {
        HttpRequest a = httpRequest.m20882a("X-CRASHLYTICS-API-KEY", c2944m.f10081a).m20882a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m20882a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo1426a());
        HttpRequest httpRequest2 = a;
        for (Entry a2 : c2944m.f10082b.mo1466e().entrySet()) {
            httpRequest2 = httpRequest2.m20888a(a2);
        }
        return httpRequest2;
    }

    private HttpRequest m16426a(HttpRequest httpRequest, ad adVar) {
        int i = 0;
        httpRequest.m20902e("report[identifier]", adVar.mo1463b());
        if (adVar.mo1465d().length == 1) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Adding single file " + adVar.mo1462a() + " to report " + adVar.mo1463b());
            return httpRequest.m20885a("report[file]", adVar.mo1462a(), "application/octet-stream", adVar.mo1464c());
        }
        File[] d = adVar.mo1465d();
        int length = d.length;
        int i2 = 0;
        while (i < length) {
            File file = d[i];
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Adding file " + file.getName() + " to report " + adVar.mo1463b());
            httpRequest.m20885a("report[file" + i2 + "]", file.getName(), "application/octet-stream", file);
            i2++;
            i++;
        }
        return httpRequest;
    }
}
