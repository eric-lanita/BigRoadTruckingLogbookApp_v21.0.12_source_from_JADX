package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;

public final class C0197l {
    public static void m862a(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            C0199n.m864a(bundle, str, iBinder);
        } else {
            C0198m.m863a(bundle, str, iBinder);
        }
    }
}
