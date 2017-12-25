package com.crashlytics.android.core;

class C2959x implements ah {
    private final int f10110a;

    public C2959x(int i) {
        this.f10110a = i;
    }

    public StackTraceElement[] mo1459a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f10110a) {
            return stackTraceElementArr;
        }
        int i = this.f10110a / 2;
        int i2 = this.f10110a - i;
        Object obj = new StackTraceElement[this.f10110a];
        System.arraycopy(stackTraceElementArr, 0, obj, 0, i2);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i, obj, i2, i);
        return obj;
    }
}
