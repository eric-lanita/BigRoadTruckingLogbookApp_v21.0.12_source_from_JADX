package com.crashlytics.android.core;

class C2958w implements ah {
    private final int f10107a;
    private final ah[] f10108b;
    private final C2959x f10109c;

    public C2958w(int i, ah... ahVarArr) {
        this.f10107a = i;
        this.f10108b = ahVarArr;
        this.f10109c = new C2959x(i);
    }

    public StackTraceElement[] mo1459a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f10107a) {
            return stackTraceElementArr;
        }
        ah[] ahVarArr = this.f10108b;
        int length = ahVarArr.length;
        int i = 0;
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        while (i < length) {
            ah ahVar = ahVarArr[i];
            if (stackTraceElementArr2.length <= this.f10107a) {
                break;
            }
            i++;
            stackTraceElementArr2 = ahVar.mo1459a(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.f10107a) {
            stackTraceElementArr2 = this.f10109c.mo1459a(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
