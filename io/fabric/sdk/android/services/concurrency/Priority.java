package io.fabric.sdk.android.services.concurrency;

public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int m20831a(C2928f c2928f, Y y) {
        Priority b;
        if (y instanceof C2928f) {
            b = ((C2928f) y).mo1475b();
        } else {
            b = NORMAL;
        }
        return b.ordinal() - c2928f.mo1475b().ordinal();
    }
}
