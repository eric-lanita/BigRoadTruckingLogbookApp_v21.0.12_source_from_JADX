package io.fabric.sdk.android.services.settings;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.CommonUtils;

public class C4066n {
    public final String f14312a;
    public final int f14313b;
    public final int f14314c;
    public final int f14315d;

    public C4066n(String str, int i, int i2, int i3) {
        this.f14312a = str;
        this.f14313b = i;
        this.f14314c = i2;
        this.f14315d = i3;
    }

    public static C4066n m20975a(Context context, String str) {
        if (str != null) {
            try {
                int l = CommonUtils.m20725l(context);
                C3969c.m20576h().mo2849a("Fabric", "App icon resource ID is " + l);
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(context.getResources(), l, options);
                return new C4066n(str, l, options.outWidth, options.outHeight);
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Fabric", "Failed to load icon", e);
            }
        }
        return null;
    }
}
