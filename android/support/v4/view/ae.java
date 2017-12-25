package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class ae {
    static final C0386c f1004a;

    interface C0386c {
        float mo257a(VelocityTracker velocityTracker, int i);

        float mo258b(VelocityTracker velocityTracker, int i);
    }

    static class C0387a implements C0386c {
        C0387a() {
        }

        public float mo257a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float mo258b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class C0388b implements C0386c {
        C0388b() {
        }

        public float mo257a(VelocityTracker velocityTracker, int i) {
            return af.m1624a(velocityTracker, i);
        }

        public float mo258b(VelocityTracker velocityTracker, int i) {
            return af.m1625b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1004a = new C0388b();
        } else {
            f1004a = new C0387a();
        }
    }

    public static float m1622a(VelocityTracker velocityTracker, int i) {
        return f1004a.mo257a(velocityTracker, i);
    }

    public static float m1623b(VelocityTracker velocityTracker, int i) {
        return f1004a.mo258b(velocityTracker, i);
    }
}
