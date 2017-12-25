package android.support.v4.view;

import android.view.KeyEvent;

class C0445h {
    public static int m2059a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m2060a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m2061b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
