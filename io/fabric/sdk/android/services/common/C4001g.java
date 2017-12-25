package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import io.fabric.sdk.android.C3969c;

public class C4001g {
    public String m20770a(Context context) {
        Object b = m20771b(context);
        if (TextUtils.isEmpty(b)) {
            b = m20772c(context);
        }
        if (TextUtils.isEmpty(b)) {
            m20773d(context);
        }
        return b;
    }

    protected String m20771b(Context context) {
        String str = null;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.ApiKey");
                if (str == null) {
                    C3969c.m20576h().mo2849a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                    str = bundle.getString("com.crashlytics.ApiKey");
                }
            }
        } catch (Exception e) {
            C3969c.m20576h().mo2849a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + e);
        }
        return str;
    }

    protected String m20772c(Context context) {
        int a = CommonUtils.m20686a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C3969c.m20576h().mo2849a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = CommonUtils.m20686a(context, "com.crashlytics.ApiKey", "string");
        }
        if (a != 0) {
            return context.getResources().getString(a);
        }
        return null;
    }

    protected void m20773d(Context context) {
        if (C3969c.m20577i() || CommonUtils.m20722i(context)) {
            throw new IllegalArgumentException(m20769a());
        }
        C3969c.m20576h().mo2856e("Fabric", m20769a());
    }

    protected String m20769a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }
}
