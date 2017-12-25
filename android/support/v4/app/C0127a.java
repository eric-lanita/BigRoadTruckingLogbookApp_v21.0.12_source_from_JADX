package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.C0180b.C0124a;
import android.support.v4.content.C0126a;
import android.view.View;
import java.util.List;
import java.util.Map;

public class C0127a extends C0126a {

    public interface C0117a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    private static class C0125b extends C0124a {
        private as f481a;

        public C0125b(as asVar) {
            this.f481a = asVar;
        }

        public void mo110a(List<String> list, List<View> list2, List<View> list3) {
            this.f481a.m776a((List) list, (List) list2, (List) list3);
        }

        public void mo112b(List<String> list, List<View> list2, List<View> list3) {
            this.f481a.m778b(list, list2, list3);
        }

        public void mo109a(List<View> list) {
            this.f481a.m775a((List) list);
        }

        public void mo111a(List<String> list, Map<String, View> map) {
            this.f481a.m777a((List) list, (Map) map);
        }

        public Parcelable mo107a(View view, Matrix matrix, RectF rectF) {
            return this.f481a.m773a(view, matrix, rectF);
        }

        public View mo108a(Context context, Parcelable parcelable) {
            return this.f481a.m774a(context, parcelable);
        }
    }

    public static void m588a(Activity activity, Intent intent, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0183e.m798a(activity, intent, bundle);
        } else {
            activity.startActivity(intent);
        }
    }

    public static void m587a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0183e.m797a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m586a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0183e.m796a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m592b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0180b.m787a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m589a(Activity activity, as asVar) {
        if (VERSION.SDK_INT >= 21) {
            C0180b.m788a(activity, C0127a.m585a(asVar));
        }
    }

    public static void m593b(Activity activity, as asVar) {
        if (VERSION.SDK_INT >= 21) {
            C0180b.m791b(activity, C0127a.m585a(asVar));
        }
    }

    public static void m594c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0180b.m790b(activity);
        }
    }

    public static void m595d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0180b.m792c(activity);
        }
    }

    public static void m590a(final Activity activity, final String[] strArr, final int i) {
        if (VERSION.SDK_INT >= 23) {
            C0181c.m793a(activity, strArr, i);
        } else if (activity instanceof C0117a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0117a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }

    public static boolean m591a(Activity activity, String str) {
        if (VERSION.SDK_INT >= 23) {
            return C0181c.m794a(activity, str);
        }
        return false;
    }

    private static C0124a m585a(as asVar) {
        if (asVar != null) {
            return new C0125b(asVar);
        }
        return null;
    }
}
