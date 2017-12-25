package android.support.v4.view;

import android.view.WindowInsets;

class bf extends be {
    private final WindowInsets f1037a;

    bf(WindowInsets windowInsets) {
        this.f1037a = windowInsets;
    }

    public int mo330a() {
        return this.f1037a.getSystemWindowInsetLeft();
    }

    public int mo332b() {
        return this.f1037a.getSystemWindowInsetTop();
    }

    public int mo333c() {
        return this.f1037a.getSystemWindowInsetRight();
    }

    public int mo334d() {
        return this.f1037a.getSystemWindowInsetBottom();
    }

    public boolean mo335e() {
        return this.f1037a.isConsumed();
    }

    public be mo331a(int i, int i2, int i3, int i4) {
        return new bf(this.f1037a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    WindowInsets m2026f() {
        return this.f1037a;
    }
}
