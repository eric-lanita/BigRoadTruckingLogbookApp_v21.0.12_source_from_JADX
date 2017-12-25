package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p011a.C0564a.C0562j;
import android.view.LayoutInflater;

public class C0642d extends ContextWrapper {
    private int f1551a;
    private Theme f1552b;
    private LayoutInflater f1553c;

    public C0642d(Context context, int i) {
        super(context);
        this.f1551a = i;
    }

    public C0642d(Context context, Theme theme) {
        super(context);
        this.f1552b = theme;
    }

    public void setTheme(int i) {
        if (this.f1551a != i) {
            this.f1551a = i;
            m2992b();
        }
    }

    public int m2993a() {
        return this.f1551a;
    }

    public Theme getTheme() {
        if (this.f1552b != null) {
            return this.f1552b;
        }
        if (this.f1551a == 0) {
            this.f1551a = C0562j.Theme_AppCompat_Light;
        }
        m2992b();
        return this.f1552b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1553c == null) {
            this.f1553c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1553c;
    }

    protected void m2994a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void m2992b() {
        boolean z = this.f1552b == null;
        if (z) {
            this.f1552b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1552b.setTo(theme);
            }
        }
        m2994a(this.f1552b, this.f1551a, z);
    }
}
