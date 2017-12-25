package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public final class C0539q {
    static final C0533f f1258a;

    interface C0533f {
        void mo391a(PopupWindow popupWindow, int i);

        void mo392a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void mo393a(PopupWindow popupWindow, boolean z);
    }

    static class C0534c implements C0533f {
        C0534c() {
        }

        public void mo392a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo393a(PopupWindow popupWindow, boolean z) {
        }

        public void mo391a(PopupWindow popupWindow, int i) {
        }
    }

    static class C0535d extends C0534c {
        C0535d() {
        }

        public void mo391a(PopupWindow popupWindow, int i) {
            C0542t.m2495a(popupWindow, i);
        }
    }

    static class C0536e extends C0535d {
        C0536e() {
        }

        public void mo392a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            C0543u.m2496a(popupWindow, view, i, i2, i3);
        }
    }

    static class C0537a extends C0536e {
        C0537a() {
        }

        public void mo393a(PopupWindow popupWindow, boolean z) {
            C0540r.m2492a(popupWindow, z);
        }
    }

    static class C0538b extends C0537a {
        C0538b() {
        }

        public void mo393a(PopupWindow popupWindow, boolean z) {
            C0541s.m2494a(popupWindow, z);
        }

        public void mo391a(PopupWindow popupWindow, int i) {
            C0541s.m2493a(popupWindow, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1258a = new C0538b();
        } else if (i >= 21) {
            f1258a = new C0537a();
        } else if (i >= 19) {
            f1258a = new C0536e();
        } else if (i >= 9) {
            f1258a = new C0535d();
        } else {
            f1258a = new C0534c();
        }
    }

    public static void m2490a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1258a.mo392a(popupWindow, view, i, i2, i3);
    }

    public static void m2491a(PopupWindow popupWindow, boolean z) {
        f1258a.mo393a(popupWindow, z);
    }

    public static void m2489a(PopupWindow popupWindow, int i) {
        f1258a.mo391a(popupWindow, i);
    }
}
