package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import com.google.android.gms.analytics.internal.zzae;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler f10165a;
    private final Tracker f10166b;
    private final Context f10167c;
    private ExceptionParser f10168d;
    private GoogleAnalytics f10169e;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.f10165a = uncaughtExceptionHandler;
            this.f10166b = tracker;
            this.f10168d = new StandardExceptionParser(context, new ArrayList());
            this.f10167c = context.getApplicationContext();
            String str = "ExceptionReporter created, original handler is ";
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            zzae.m16593v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    GoogleAnalytics m16515a() {
        if (this.f10169e == null) {
            this.f10169e = GoogleAnalytics.getInstance(this.f10167c);
        }
        return this.f10169e;
    }

    UncaughtExceptionHandler m16516b() {
        return this.f10165a;
    }

    public ExceptionParser getExceptionParser() {
        return this.f10168d;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.f10168d = exceptionParser;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.f10168d != null) {
            str = this.f10168d.getDescription(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        zzae.m16593v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f10166b.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics a = m16515a();
        a.dispatchLocalHits();
        a.m16527b();
        if (this.f10165a != null) {
            zzae.m16593v("Passing exception to the original handler");
            this.f10165a.uncaughtException(thread, th);
        }
    }
}
