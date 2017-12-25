package io.fabric.sdk.android.services.common;

import android.content.Context;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.p045a.C2830d;
import io.fabric.sdk.android.services.p045a.C3980b;

public class C4010m {
    private final C2830d<String> f14171a = new C40091(this);
    private final C3980b<String> f14172b = new C3980b();

    class C40091 implements C2830d<String> {
        final /* synthetic */ C4010m f14170a;

        C40091(C4010m c4010m) {
            this.f14170a = c4010m;
        }

        public /* synthetic */ Object mo1431b(Context context) {
            return m20784a(context);
        }

        public String m20784a(Context context) {
            String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return installerPackageName == null ? "" : installerPackageName;
        }
    }

    public String m20786a(Context context) {
        try {
            String str = (String) this.f14172b.mo2864a(context, this.f14171a);
            if ("".equals(str)) {
                return null;
            }
            return str;
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Fabric", "Failed to determine installer package name", e);
            return null;
        }
    }
}
