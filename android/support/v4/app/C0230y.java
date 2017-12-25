package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.content.C0259f;
import android.util.Log;

public final class C0230y {
    private static final C0227a f747a;

    interface C0227a {
        Intent mo160a(Activity activity);

        String mo161a(Context context, ActivityInfo activityInfo);

        boolean mo162a(Activity activity, Intent intent);

        void mo163b(Activity activity, Intent intent);
    }

    static class C0228b implements C0227a {
        C0228b() {
        }

        public Intent mo160a(Activity activity) {
            String b = C0230y.m1044b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                return C0230y.m1045b((Context) activity, componentName) == null ? C0259f.m1091a(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b + "' in manifest");
                return null;
            }
        }

        public boolean mo162a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void mo163b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String mo161a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    static class C0229c extends C0228b {
        C0229c() {
        }

        public Intent mo160a(Activity activity) {
            Intent a = C0231z.m1047a(activity);
            if (a == null) {
                return m1039b(activity);
            }
            return a;
        }

        Intent m1039b(Activity activity) {
            return super.mo160a(activity);
        }

        public boolean mo162a(Activity activity, Intent intent) {
            return C0231z.m1049a(activity, intent);
        }

        public void mo163b(Activity activity, Intent intent) {
            C0231z.m1050b(activity, intent);
        }

        public String mo161a(Context context, ActivityInfo activityInfo) {
            String a = C0231z.m1048a(activityInfo);
            if (a == null) {
                return super.mo161a(context, activityInfo);
            }
            return a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f747a = new C0229c();
        } else {
            f747a = new C0228b();
        }
    }

    public static boolean m1043a(Activity activity, Intent intent) {
        return f747a.mo162a(activity, intent);
    }

    public static void m1046b(Activity activity, Intent intent) {
        f747a.mo163b(activity, intent);
    }

    public static Intent m1041a(Activity activity) {
        return f747a.mo160a(activity);
    }

    public static Intent m1042a(Context context, ComponentName componentName) {
        String b = C0230y.m1045b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return C0230y.m1045b(context, componentName2) == null ? C0259f.m1091a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String m1044b(Activity activity) {
        try {
            return C0230y.m1045b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m1045b(Context context, ComponentName componentName) {
        return f747a.mo161a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }
}
