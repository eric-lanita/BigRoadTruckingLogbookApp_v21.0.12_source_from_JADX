package android.support.v4.app;

import android.app.Activity;

class C0181c {

    public interface C0118a {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void m793a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0118a) {
            ((C0118a) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static boolean m794a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
