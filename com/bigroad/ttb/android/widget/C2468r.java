package com.bigroad.ttb.android.widget;

import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class C2468r {
    private Handler f8797a;
    private C1303a f8798b;
    private ProgressBar f8799c;
    private int f8800d;
    private int f8801e;
    private final Runnable f8802f;

    public interface C1303a {
        void mo947a();
    }

    class C24671 implements Runnable {
        final /* synthetic */ C2468r f8796a;

        C24671(C2468r c2468r) {
            this.f8796a = c2468r;
        }

        public void run() {
            this.f8796a.f8799c.setProgress(C2468r.m12120a(this.f8796a));
            if (this.f8796a.f8801e < this.f8796a.f8800d) {
                this.f8796a.m12126e();
            } else if (this.f8796a.f8798b != null) {
                this.f8796a.f8798b.mo947a();
            }
        }
    }

    static /* synthetic */ int m12120a(C2468r c2468r) {
        int i = c2468r.f8801e + 1;
        c2468r.f8801e = i;
        return i;
    }

    public C2468r(ProgressBar progressBar) {
        this.f8797a = new Handler();
        this.f8800d = 20;
        this.f8801e = 0;
        this.f8802f = new C24671(this);
        this.f8799c = progressBar;
        m12129a(20, 0);
        m12124d();
    }

    public C2468r(View view) {
        this(view, 20, 0);
    }

    public C2468r(View view, int i, int i2) {
        this.f8797a = new Handler();
        this.f8800d = 20;
        this.f8801e = 0;
        this.f8802f = new C24671(this);
        this.f8799c = (ProgressBar) view.findViewById(16908301);
        m12129a(i, i2);
    }

    public void m12128a() {
        m12124d();
        m12126e();
    }

    public void m12131b() {
        this.f8797a.removeCallbacks(this.f8802f);
    }

    public void m12132c() {
        m12131b();
        m12128a();
    }

    private void m12124d() {
        this.f8799c.setProgress(0);
        this.f8799c.setMax(this.f8800d);
        this.f8801e = 0;
    }

    private void m12126e() {
        this.f8797a.postDelayed(this.f8802f, 1000);
    }

    public void m12130a(C1303a c1303a) {
        this.f8798b = c1303a;
    }

    public void m12129a(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("timeout=" + i + " (must be > 0)");
        }
        this.f8800d = i;
        this.f8801e = i2;
        if (this.f8799c != null) {
            this.f8799c.setMax(i);
            this.f8799c.setProgress(this.f8801e);
        }
    }
}
