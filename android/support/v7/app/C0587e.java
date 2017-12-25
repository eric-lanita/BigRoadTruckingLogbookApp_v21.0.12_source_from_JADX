package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class C0587e {
    private static int f1381a = -1;
    private static boolean f1382b = false;

    public abstract C0569a mo434a();

    public abstract View mo441a(int i);

    public abstract void mo443a(Configuration configuration);

    public abstract void mo444a(Bundle bundle);

    public abstract void mo446a(View view);

    public abstract void mo447a(View view, LayoutParams layoutParams);

    public abstract void mo435a(CharSequence charSequence);

    public abstract MenuInflater mo436b();

    public abstract void mo451b(int i);

    public abstract void mo452b(Bundle bundle);

    public abstract void mo453b(View view, LayoutParams layoutParams);

    public abstract void mo456c();

    public abstract void mo437c(Bundle bundle);

    public abstract boolean mo457c(int i);

    public abstract void mo458d();

    public abstract void mo459e();

    public abstract void mo438f();

    public abstract void mo460g();

    public abstract boolean mo439h();

    public static C0587e m2695a(Activity activity, C0565d c0565d) {
        return C0587e.m2697a(activity, activity.getWindow(), c0565d);
    }

    public static C0587e m2696a(Dialog dialog, C0565d c0565d) {
        return C0587e.m2697a(dialog.getContext(), dialog.getWindow(), c0565d);
    }

    private static C0587e m2697a(Context context, Window window, C0565d c0565d) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return new C0597i(context, window, c0565d);
        }
        if (i >= 14) {
            return new C0595h(context, window, c0565d);
        }
        if (i >= 11) {
            return new C0593g(context, window, c0565d);
        }
        return new C0592j(context, window, c0565d);
    }

    C0587e() {
    }

    public static int m2698i() {
        return f1381a;
    }

    public static boolean m2699j() {
        return f1382b;
    }
}
