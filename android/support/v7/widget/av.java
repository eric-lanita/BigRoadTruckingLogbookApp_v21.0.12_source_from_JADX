package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.app.C0587e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class av extends ContextWrapper {
    private static final ArrayList<WeakReference<av>> f2181a = new ArrayList();
    private Resources f2182b;
    private final Theme f2183c;

    public static Context m3729a(Context context) {
        if (!m3730b(context)) {
            return context;
        }
        Context context2;
        int size = f2181a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f2181a.get(i);
            context2 = weakReference != null ? (av) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new av(context);
        f2181a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean m3730b(Context context) {
        if ((context instanceof av) || (context.getResources() instanceof ax) || (context.getResources() instanceof ba)) {
            return false;
        }
        if (!C0587e.m2699j() || VERSION.SDK_INT <= 20) {
            return true;
        }
        return false;
    }

    private av(Context context) {
        super(context);
        if (ba.m3801a()) {
            this.f2183c = getResources().newTheme();
            this.f2183c.setTo(context.getTheme());
            return;
        }
        this.f2183c = null;
    }

    public Theme getTheme() {
        return this.f2183c == null ? super.getTheme() : this.f2183c;
    }

    public void setTheme(int i) {
        if (this.f2183c == null) {
            super.setTheme(i);
        } else {
            this.f2183c.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        if (this.f2182b == null) {
            this.f2182b = this.f2183c == null ? new ax(this, super.getResources()) : new ba(this, super.getResources());
        }
        return this.f2182b;
    }
}
