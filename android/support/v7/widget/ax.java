package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class ax extends an {
    private final WeakReference<Context> f2188a;

    public ax(Context context, Resources resources) {
        super(resources);
        this.f2188a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f2188a.get();
        if (!(drawable == null || context == null)) {
            C0765l.m3902a();
            C0765l.m3908a(context, i, drawable);
        }
        return drawable;
    }
}
