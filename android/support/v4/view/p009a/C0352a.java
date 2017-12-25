package android.support.v4.view.p009a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class C0352a {
    private static final C0348d f989a;

    interface C0348d {
    }

    static class C0349c implements C0348d {
        C0349c() {
        }
    }

    static class C0350a extends C0349c {
        C0350a() {
        }
    }

    static class C0351b extends C0350a {
        C0351b() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f989a = new C0351b();
        } else if (VERSION.SDK_INT >= 14) {
            f989a = new C0350a();
        } else {
            f989a = new C0349c();
        }
    }

    public static C0383h m1425a(AccessibilityEvent accessibilityEvent) {
        return new C0383h(accessibilityEvent);
    }
}
