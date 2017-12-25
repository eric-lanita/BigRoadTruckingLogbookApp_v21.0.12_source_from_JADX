package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;

public class C0126a {
    public static boolean m583a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0254e.m1087a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0253d.m1086a(context, intentArr);
            return true;
        }
    }

    public static final Drawable m582a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return C0251b.m1084a(context, i);
        }
        return context.getResources().getDrawable(i);
    }

    public static final int m584b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return C0252c.m1085a(context, i);
        }
        return context.getResources().getColor(i);
    }

    public static int m581a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }
}
