package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class C0479x {
    private final View f1051a;
    private ViewParent f1052b;
    private boolean f1053c;
    private int[] f1054d;

    public C0479x(View view) {
        this.f1051a = view;
    }

    public void m2157a(boolean z) {
        if (this.f1053c) {
            ag.m1820t(this.f1051a);
        }
        this.f1053c = z;
    }

    public boolean m2158a() {
        return this.f1053c;
    }

    public boolean m2164b() {
        return this.f1052b != null;
    }

    public boolean m2161a(int i) {
        if (m2164b()) {
            return true;
        }
        if (m2158a()) {
            View view = this.f1051a;
            for (ViewParent parent = this.f1051a.getParent(); parent != null; parent = parent.getParent()) {
                if (av.m1924a(parent, view, this.f1051a, i)) {
                    this.f1052b = parent;
                    av.m1925b(parent, view, this.f1051a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void m2165c() {
        if (this.f1052b != null) {
            av.m1919a(this.f1052b, this.f1051a);
            this.f1052b = null;
        }
    }

    public boolean m2162a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m2158a() || this.f1052b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f1051a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            av.m1920a(this.f1052b, this.f1051a, i, i2, i3, i4);
            if (iArr != null) {
                this.f1051a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m2163a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m2158a() || this.f1052b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f1051a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f1054d == null) {
                    this.f1054d = new int[2];
                }
                iArr = this.f1054d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            av.m1921a(this.f1052b, this.f1051a, i, i2, iArr);
            if (iArr2 != null) {
                this.f1051a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            if (iArr[0] == 0 && iArr[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m2160a(float f, float f2, boolean z) {
        if (!m2158a() || this.f1052b == null) {
            return false;
        }
        return av.m1923a(this.f1052b, this.f1051a, f, f2, z);
    }

    public boolean m2159a(float f, float f2) {
        if (!m2158a() || this.f1052b == null) {
            return false;
        }
        return av.m1922a(this.f1052b, this.f1051a, f, f2);
    }
}
