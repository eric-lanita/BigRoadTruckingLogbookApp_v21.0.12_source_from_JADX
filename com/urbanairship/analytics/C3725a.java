package com.urbanairship.analytics;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.C3783j;
import java.util.HashSet;
import java.util.Set;

class C3725a {
    private final Set<Integer> f13376a = new HashSet();
    private final Handler f13377b = new Handler(Looper.getMainLooper());
    private C3724a f13378c;
    private long f13379d;
    private final Runnable f13380e = new C37231(this);

    class C37231 implements Runnable {
        final /* synthetic */ C3725a f13375a;

        C37231(C3725a c3725a) {
            this.f13375a = c3725a;
        }

        public void run() {
            if (this.f13375a.f13376a.isEmpty()) {
                synchronized (this) {
                    if (this.f13375a.f13378c != null) {
                        this.f13375a.f13378c.mo2773b(this.f13375a.f13379d);
                    }
                }
            }
        }
    }

    static abstract class C3724a {
        abstract void mo2772a(long j);

        abstract void mo2773b(long j);

        C3724a() {
        }
    }

    C3725a() {
    }

    void m19423a(C3724a c3724a) {
        synchronized (this) {
            this.f13378c = c3724a;
        }
    }

    void m19422a(Activity activity, long j) {
        if (this.f13376a.contains(Integer.valueOf(activity.hashCode()))) {
            C3783j.m19721a("Analytics.startActivity was already called for activity: " + activity);
            return;
        }
        this.f13377b.removeCallbacks(this.f13380e);
        this.f13376a.add(Integer.valueOf(activity.hashCode()));
        if (this.f13376a.size() == 1) {
            synchronized (this) {
                if (this.f13378c != null) {
                    this.f13378c.mo2772a(j);
                }
            }
        }
    }

    void m19424b(Activity activity, long j) {
        if (this.f13376a.contains(Integer.valueOf(activity.hashCode()))) {
            this.f13377b.removeCallbacks(this.f13380e);
            this.f13376a.remove(Integer.valueOf(activity.hashCode()));
            this.f13379d = j;
            if (this.f13376a.isEmpty()) {
                this.f13377b.postDelayed(this.f13380e, 2000);
                return;
            }
            return;
        }
        C3783j.m19721a("Analytics.stopActivity called for an activity that was not started: " + activity);
    }
}
