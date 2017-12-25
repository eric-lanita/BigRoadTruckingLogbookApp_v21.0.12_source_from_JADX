package com.crashlytics.android.answers;

import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C2826a;
import io.fabric.sdk.android.services.common.C4015o;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.p046b.C2849f;
import java.io.File;
import java.util.List;

class C2866p extends C2826a implements C2849f {
    private final String f9871b;

    public C2866p(C2822h c2822h, String str, String str2, C4045c c4045c, String str3) {
        super(c2822h, str, str2, c4045c, HttpMethod.POST);
        this.f9871b = str3;
    }

    public boolean mo1440a(List<File> list) {
        HttpRequest a = m15992b().m20882a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m20882a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo1426a()).m20882a("X-CRASHLYTICS-API-KEY", this.f9871b);
        int i = 0;
        for (File file : list) {
            a.m20885a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        C3969c.m20576h().mo2849a("Answers", "Sending " + list.size() + " analytics files to " + m15991a());
        int b = a.m20892b();
        C3969c.m20576h().mo2849a("Answers", "Response code for analytics file send is " + b);
        if (C4015o.m20815a(b) == 0) {
            return true;
        }
        return false;
    }
}
