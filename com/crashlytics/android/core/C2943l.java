package com.crashlytics.android.core;

import io.fabric.sdk.android.C3969c;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class C2943l implements UncaughtExceptionHandler {
    private final C2904a f10078a;
    private final UncaughtExceptionHandler f10079b;
    private final AtomicBoolean f10080c = new AtomicBoolean(false);

    interface C2904a {
        void mo1468a(Thread thread, Throwable th);
    }

    public C2943l(C2904a c2904a, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f10078a = c2904a;
        this.f10079b = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f10080c.set(true);
        try {
            this.f10078a.mo1468a(thread, th);
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
        } finally {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f10079b.uncaughtException(thread, th);
            this.f10080c.set(false);
        }
    }

    boolean m16424a() {
        return this.f10080c.get();
    }
}
