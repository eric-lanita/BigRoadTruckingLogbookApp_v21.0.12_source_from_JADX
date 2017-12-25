package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class C0259f {
    private static final C0255a f764a;

    interface C0255a {
        Intent mo168a(ComponentName componentName);
    }

    static class C0256b implements C0255a {
        C0256b() {
        }

        public Intent mo168a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    static class C0257c extends C0256b {
        C0257c() {
        }

        public Intent mo168a(ComponentName componentName) {
            return C0260g.m1092a(componentName);
        }
    }

    static class C0258d extends C0257c {
        C0258d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f764a = new C0258d();
        } else if (i >= 11) {
            f764a = new C0257c();
        } else {
            f764a = new C0256b();
        }
    }

    public static Intent m1091a(ComponentName componentName) {
        return f764a.mo168a(componentName);
    }
}
