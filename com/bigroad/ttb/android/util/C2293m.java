package com.bigroad.ttb.android.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

public class C2293m {
    public static int f7933a = 380;
    public static int f7934b = 380;

    public static Display m11239a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public static int m11240b(Context context) {
        return (int) (((float) C2293m.m11239a(context).getWidth()) / context.getResources().getDisplayMetrics().density);
    }

    public static int m11241c(Context context) {
        return (int) (((float) C2293m.m11239a(context).getHeight()) / context.getResources().getDisplayMetrics().density);
    }

    public static int m11238a(Context context, int i) {
        return Math.round(TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics()));
    }
}
