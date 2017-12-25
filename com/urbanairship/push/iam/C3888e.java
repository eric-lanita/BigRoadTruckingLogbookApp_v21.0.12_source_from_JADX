package com.urbanairship.push.iam;

import android.os.Handler;
import android.os.SystemClock;

abstract class C3888e {
    private boolean f13827a;
    private long f13828b;
    private long f13829c;
    private long f13830d;
    private final Handler f13831e = new Handler();
    private final Runnable f13832f = new C39111(this);

    class C39111 implements Runnable {
        final /* synthetic */ C3888e f13874a;

        C39111(C3888e c3888e) {
            this.f13874a = c3888e;
        }

        public void run() {
            if (this.f13874a.f13827a) {
                this.f13874a.m20199c();
                this.f13874a.mo2821a();
            }
        }
    }

    protected abstract void mo2821a();

    C3888e(long j) {
        this.f13829c = j;
    }

    void m20198b() {
        if (!this.f13827a) {
            this.f13827a = true;
            this.f13828b = SystemClock.elapsedRealtime();
            if (this.f13829c > 0) {
                this.f13831e.postDelayed(this.f13832f, this.f13829c);
            } else {
                this.f13831e.post(this.f13832f);
            }
        }
    }

    void m20199c() {
        if (this.f13827a) {
            this.f13830d = SystemClock.elapsedRealtime() - this.f13828b;
            this.f13827a = false;
            this.f13831e.removeCallbacks(this.f13832f);
            this.f13829c = Math.max(0, this.f13829c - (SystemClock.elapsedRealtime() - this.f13828b));
        }
    }

    long m20200d() {
        if (this.f13827a) {
            return (this.f13830d + SystemClock.elapsedRealtime()) - this.f13828b;
        }
        return this.f13830d;
    }
}
