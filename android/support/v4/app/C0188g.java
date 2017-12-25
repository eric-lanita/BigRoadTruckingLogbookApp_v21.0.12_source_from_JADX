package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

class C0188g {
    public static String m806a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    public static int m805a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }
}
