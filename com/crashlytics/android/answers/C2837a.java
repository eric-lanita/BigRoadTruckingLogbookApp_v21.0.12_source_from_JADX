package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4002i.C4003a;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.C4071q;
import io.fabric.sdk.android.services.settings.C4072s;
import java.io.File;

public class C2837a extends C2822h<Boolean> {
    C2867q f9812a;

    protected /* synthetic */ Object mo1429f() {
        return m16020d();
    }

    public void m16018a(C4003a c4003a) {
        if (this.f9812a != null) {
            this.f9812a.m16113a(c4003a.m20774a(), c4003a.m20775b());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean h_() {
        try {
            long j;
            Context r = m15970r();
            PackageManager packageManager = r.getPackageManager();
            String packageName = r.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                j = packageInfo.firstInstallTime;
            } else {
                j = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f9812a = C2867q.m16108a(this, r, m15969q(), num, str, j);
            this.f9812a.m16114b();
            return true;
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    protected Boolean m16020d() {
        try {
            C4072s b = C4071q.m20977a().m20980b();
            if (b == null) {
                C3969c.m20576h().mo2856e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f14338d.f14311d) {
                C3969c.m20576h().mo2849a("Answers", "Analytics collection enabled");
                this.f9812a.m16112a(b.f14339e, m16021e());
                return Boolean.valueOf(true);
            } else {
                C3969c.m20576h().mo2849a("Answers", "Analytics collection disabled");
                this.f9812a.m16115c();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    public String mo1427b() {
        return "com.crashlytics.sdk.android:answers";
    }

    public String mo1426a() {
        return "1.3.13.dev";
    }

    String m16021e() {
        return CommonUtils.m20711b(m15970r(), "com.crashlytics.ApiEndpoint");
    }
}
