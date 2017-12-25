package android.support.v4.view;

import android.view.MotionEvent;

class C0475t {
    public static int m2151a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m2152b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m2153c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m2154d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m2150a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
