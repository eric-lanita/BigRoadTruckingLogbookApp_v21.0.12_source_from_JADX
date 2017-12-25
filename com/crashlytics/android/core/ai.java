package com.crashlytics.android.core;

class ai {
    public final String f9959a;
    public final String f9960b;
    public final StackTraceElement[] f9961c;
    public final ai f9962d;

    public ai(Throwable th, ah ahVar) {
        this.f9959a = th.getLocalizedMessage();
        this.f9960b = th.getClass().getName();
        this.f9961c = ahVar.mo1459a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f9962d = cause != null ? new ai(cause, ahVar) : null;
    }
}
