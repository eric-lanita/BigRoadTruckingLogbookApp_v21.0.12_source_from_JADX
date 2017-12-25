package com.bigroad.ttb.android.widget;

import android.os.Handler;

public class C2457g {
    private final Handler f8778a;
    private final Runnable f8779b;
    private final long f8780c;

    public C2457g(Handler handler, Runnable runnable, long j) {
        this.f8778a = handler;
        this.f8779b = runnable;
        this.f8780c = j;
    }

    public void m12101a() {
        this.f8778a.removeCallbacks(this.f8779b);
    }

    public void m12102b() {
        m12101a();
        this.f8778a.postDelayed(this.f8779b, this.f8780c);
    }
}
