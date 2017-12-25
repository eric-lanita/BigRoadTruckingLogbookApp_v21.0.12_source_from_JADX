package android.support.v7.widget;

class aq {
    private int f2123a = 0;
    private int f2124b = 0;
    private int f2125c = Integer.MIN_VALUE;
    private int f2126d = Integer.MIN_VALUE;
    private int f2127e = 0;
    private int f2128f = 0;
    private boolean f2129g = false;
    private boolean f2130h = false;

    aq() {
    }

    public int m3681a() {
        return this.f2123a;
    }

    public int m3684b() {
        return this.f2124b;
    }

    public int m3686c() {
        return this.f2129g ? this.f2124b : this.f2123a;
    }

    public int m3687d() {
        return this.f2129g ? this.f2123a : this.f2124b;
    }

    public void m3682a(int i, int i2) {
        this.f2125c = i;
        this.f2126d = i2;
        this.f2130h = true;
        if (this.f2129g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2123a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2124b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2123a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2124b = i2;
        }
    }

    public void m3685b(int i, int i2) {
        this.f2130h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2127e = i;
            this.f2123a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2128f = i2;
            this.f2124b = i2;
        }
    }

    public void m3683a(boolean z) {
        if (z != this.f2129g) {
            this.f2129g = z;
            if (!this.f2130h) {
                this.f2123a = this.f2127e;
                this.f2124b = this.f2128f;
            } else if (z) {
                this.f2123a = this.f2126d != Integer.MIN_VALUE ? this.f2126d : this.f2127e;
                this.f2124b = this.f2125c != Integer.MIN_VALUE ? this.f2125c : this.f2128f;
            } else {
                this.f2123a = this.f2125c != Integer.MIN_VALUE ? this.f2125c : this.f2127e;
                this.f2124b = this.f2126d != Integer.MIN_VALUE ? this.f2126d : this.f2128f;
            }
        }
    }
}
