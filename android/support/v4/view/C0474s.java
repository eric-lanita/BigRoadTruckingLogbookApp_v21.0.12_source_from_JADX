package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class C0474s {
    static final C0469e f1050a;

    interface C0469e {
        int mo350a(MotionEvent motionEvent);

        int mo351a(MotionEvent motionEvent, int i);

        int mo352b(MotionEvent motionEvent);

        int mo353b(MotionEvent motionEvent, int i);

        float mo354c(MotionEvent motionEvent, int i);

        float mo355d(MotionEvent motionEvent, int i);

        float mo356e(MotionEvent motionEvent, int i);
    }

    static class C0470a implements C0469e {
        C0470a() {
        }

        public int mo351a(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        public int mo353b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo354c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo355d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int mo350a(MotionEvent motionEvent) {
            return 1;
        }

        public int mo352b(MotionEvent motionEvent) {
            return 0;
        }

        public float mo356e(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    static class C0471b extends C0470a {
        C0471b() {
        }

        public int mo351a(MotionEvent motionEvent, int i) {
            return C0475t.m2151a(motionEvent, i);
        }

        public int mo353b(MotionEvent motionEvent, int i) {
            return C0475t.m2152b(motionEvent, i);
        }

        public float mo354c(MotionEvent motionEvent, int i) {
            return C0475t.m2153c(motionEvent, i);
        }

        public float mo355d(MotionEvent motionEvent, int i) {
            return C0475t.m2154d(motionEvent, i);
        }

        public int mo350a(MotionEvent motionEvent) {
            return C0475t.m2150a(motionEvent);
        }
    }

    static class C0472c extends C0471b {
        C0472c() {
        }

        public int mo352b(MotionEvent motionEvent) {
            return C0476u.m2155a(motionEvent);
        }
    }

    static class C0473d extends C0472c {
        C0473d() {
        }

        public float mo356e(MotionEvent motionEvent, int i) {
            return C0477v.m2156a(motionEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 12) {
            f1050a = new C0473d();
        } else if (VERSION.SDK_INT >= 9) {
            f1050a = new C0472c();
        } else if (VERSION.SDK_INT >= 5) {
            f1050a = new C0471b();
        } else {
            f1050a = new C0470a();
        }
    }

    public static int m2141a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m2143b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m2142a(MotionEvent motionEvent, int i) {
        return f1050a.mo351a(motionEvent, i);
    }

    public static int m2144b(MotionEvent motionEvent, int i) {
        return f1050a.mo353b(motionEvent, i);
    }

    public static float m2145c(MotionEvent motionEvent, int i) {
        return f1050a.mo354c(motionEvent, i);
    }

    public static float m2147d(MotionEvent motionEvent, int i) {
        return f1050a.mo355d(motionEvent, i);
    }

    public static int m2146c(MotionEvent motionEvent) {
        return f1050a.mo350a(motionEvent);
    }

    public static int m2148d(MotionEvent motionEvent) {
        return f1050a.mo352b(motionEvent);
    }

    public static float m2149e(MotionEvent motionEvent, int i) {
        return f1050a.mo356e(motionEvent, i);
    }
}
