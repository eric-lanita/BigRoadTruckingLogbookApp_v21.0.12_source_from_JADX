package com.bigroad.ttb.android.util;

import android.os.Handler;

public class C2279b {
    private final long f7919a;
    private final long f7920b;
    private final float f7921c;
    private final Handler f7922d;
    private final Runnable f7923e = new C22781(this);
    private Runnable f7924f;
    private long f7925g;
    private boolean f7926h;

    class C22781 implements Runnable {
        final /* synthetic */ C2279b f7918a;

        C22781(C2279b c2279b) {
            this.f7918a = c2279b;
        }

        public void run() {
            this.f7918a.f7926h = false;
            if (this.f7918a.f7924f != null) {
                this.f7918a.f7924f.run();
            }
        }
    }

    public C2279b(Runnable runnable, long j, long j2, float f) {
        this.f7919a = j;
        this.f7920b = j2;
        this.f7921c = f;
        this.f7922d = new Handler();
        this.f7924f = runnable;
        this.f7925g = this.f7919a;
        this.f7926h = false;
    }

    public void m11187a() {
        this.f7922d.removeCallbacks(this.f7923e);
        this.f7926h = false;
    }

    public void m11188b() {
        m11187a();
        this.f7922d.postDelayed(this.f7923e, this.f7925g);
        this.f7925g = Math.min((long) ((int) (this.f7921c * ((float) this.f7925g))), this.f7920b);
        this.f7926h = true;
    }

    public boolean m11189c() {
        return this.f7926h;
    }

    public void m11190d() {
        this.f7925g = this.f7919a;
    }
}
