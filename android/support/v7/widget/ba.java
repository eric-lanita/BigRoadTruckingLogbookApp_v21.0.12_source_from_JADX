package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.C0587e;
import java.lang.ref.WeakReference;

public class ba extends Resources {
    private final WeakReference<Context> f2215a;

    public static boolean m3801a() {
        return C0587e.m2699j() && VERSION.SDK_INT <= 20;
    }

    public ba(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2215a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2215a.get();
        if (context != null) {
            return C0765l.m3902a().m3927a(context, this, i);
        }
        return super.getDrawable(i);
    }

    final Drawable m3802a(int i) {
        return super.getDrawable(i);
    }
}
