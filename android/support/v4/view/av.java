package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class av {
    static final C0408b f1014a;

    interface C0408b {
        void mo309a(ViewParent viewParent, View view);

        void mo310a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void mo311a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean mo312a(ViewParent viewParent, View view, float f, float f2);

        boolean mo313a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean mo314a(ViewParent viewParent, View view, View view2, int i);

        void mo315b(ViewParent viewParent, View view, View view2, int i);
    }

    static class C0409e implements C0408b {
        C0409e() {
        }

        public boolean mo314a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0480y) {
                return ((C0480y) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        public void mo315b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0480y) {
                ((C0480y) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void mo309a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0480y) {
                ((C0480y) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo310a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0480y) {
                ((C0480y) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo311a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0480y) {
                ((C0480y) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo313a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof C0480y) {
                return ((C0480y) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        public boolean mo312a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof C0480y) {
                return ((C0480y) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    static class C0410a extends C0409e {
        C0410a() {
        }
    }

    static class C0411c extends C0410a {
        C0411c() {
        }
    }

    static class C0412d extends C0411c {
        C0412d() {
        }

        public boolean mo314a(ViewParent viewParent, View view, View view2, int i) {
            return aw.m1931a(viewParent, view, view2, i);
        }

        public void mo315b(ViewParent viewParent, View view, View view2, int i) {
            aw.m1932b(viewParent, view, view2, i);
        }

        public void mo309a(ViewParent viewParent, View view) {
            aw.m1926a(viewParent, view);
        }

        public void mo310a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            aw.m1927a(viewParent, view, i, i2, i3, i4);
        }

        public void mo311a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            aw.m1928a(viewParent, view, i, i2, iArr);
        }

        public boolean mo313a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return aw.m1930a(viewParent, view, f, f2, z);
        }

        public boolean mo312a(ViewParent viewParent, View view, float f, float f2) {
            return aw.m1929a(viewParent, view, f, f2);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1014a = new C0412d();
        } else if (i >= 19) {
            f1014a = new C0411c();
        } else if (i >= 14) {
            f1014a = new C0410a();
        } else {
            f1014a = new C0409e();
        }
    }

    public static boolean m1924a(ViewParent viewParent, View view, View view2, int i) {
        return f1014a.mo314a(viewParent, view, view2, i);
    }

    public static void m1925b(ViewParent viewParent, View view, View view2, int i) {
        f1014a.mo315b(viewParent, view, view2, i);
    }

    public static void m1919a(ViewParent viewParent, View view) {
        f1014a.mo309a(viewParent, view);
    }

    public static void m1920a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f1014a.mo310a(viewParent, view, i, i2, i3, i4);
    }

    public static void m1921a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f1014a.mo311a(viewParent, view, i, i2, iArr);
    }

    public static boolean m1923a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1014a.mo313a(viewParent, view, f, f2, z);
    }

    public static boolean m1922a(ViewParent viewParent, View view, float f, float f2) {
        return f1014a.mo312a(viewParent, view, f, f2);
    }
}
