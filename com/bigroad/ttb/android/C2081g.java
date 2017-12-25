package com.bigroad.ttb.android;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.HashSet;
import java.util.Set;

public class C2081g {
    private static C2081g f7278a;
    private final Handler f7279b = new Handler();
    private final Set<C1230a> f7280c = new HashSet();
    private final Set<Activity> f7281d = new HashSet();
    private boolean f7282e = false;
    private final Runnable f7283f = new C20761(this);

    public interface C1230a {
        void mo906a(C2081g c2081g);

        void mo907a(boolean z);
    }

    public static class C1231b implements C1230a {
        public void mo907a(boolean z) {
        }

        public void mo906a(C2081g c2081g) {
        }
    }

    class C20761 implements Runnable {
        final /* synthetic */ C2081g f7275a;

        C20761(C2081g c2081g) {
            this.f7275a = c2081g;
        }

        public void run() {
            this.f7275a.m10444g();
        }
    }

    public static C2081g m10438a(Context context) {
        if (f7278a == null) {
            f7278a = new C2081g();
        }
        return f7278a;
    }

    private C2081g() {
        m10444g();
    }

    public void m10446a(C1230a c1230a) {
        this.f7280c.add(c1230a);
    }

    public void m10449b(C1230a c1230a) {
        this.f7280c.remove(c1230a);
    }

    private void m10441d() {
        for (C1230a a : (C1230a[]) this.f7280c.toArray(new C1230a[this.f7280c.size()])) {
            a.mo906a(this);
        }
    }

    private void m10440a(boolean z) {
        for (C1230a a : (C1230a[]) this.f7280c.toArray(new C1230a[this.f7280c.size()])) {
            a.mo907a(z);
        }
    }

    private void m10442e() {
        this.f7279b.removeCallbacks(this.f7283f);
    }

    private void m10443f() {
        m10442e();
        this.f7279b.postDelayed(this.f7283f, 500);
    }

    private void m10444g() {
        boolean z = !this.f7281d.isEmpty();
        if (z != this.f7282e) {
            this.f7282e = z;
            if (this.f7282e) {
                C2134e.m10676b("TT-AppStatus", "Entering foreground");
            } else {
                C2134e.m10676b("TT-AppStatus", "Entering background");
            }
            m10440a(z);
        }
        m10441d();
    }

    public void m10445a(Activity activity) {
        this.f7281d.remove(activity);
        m10443f();
    }

    public void m10448b(Activity activity) {
        this.f7281d.add(activity);
        m10443f();
    }

    public boolean m10447a() {
        return this.f7282e;
    }

    public boolean m10450b() {
        return !this.f7282e;
    }

    public Activity m10451c() {
        if (m10447a() && this.f7281d.size() == 1) {
            return (Activity) this.f7281d.iterator().next();
        }
        return null;
    }
}
