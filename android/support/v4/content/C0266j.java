package android.support.v4.content;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.C0187f;

public final class C0266j {
    public static int m1112a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0187f.m804a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0187f.m803a(context, a, str2) != 0 ? -2 : 0;
    }

    public static int m1111a(Context context, String str) {
        return C0266j.m1112a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
