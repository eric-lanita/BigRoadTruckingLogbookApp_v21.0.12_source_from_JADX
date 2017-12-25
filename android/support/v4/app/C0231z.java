package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class C0231z {
    public static Intent m1047a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean m1049a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m1050b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static String m1048a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }
}
