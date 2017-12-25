package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent.C2836a;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.p046b.C2844d;
import io.fabric.sdk.android.services.settings.C4051b;
import java.util.concurrent.ScheduledExecutorService;

class C2845b implements C2844d {
    final ScheduledExecutorService f9823a;
    C2855r f9824b = new C2856h();
    private final C2822h f9825c;
    private final Context f9826d;
    private final C2846c f9827e;
    private final C2871u f9828f;
    private final C4045c f9829g;

    class C28392 implements Runnable {
        final /* synthetic */ C2845b f9816a;

        C28392(C2845b c2845b) {
            this.f9816a = c2845b;
        }

        public void run() {
            try {
                C2855r c2855r = this.f9816a.f9824b;
                this.f9816a.f9824b = new C2856h();
                c2855r.mo1444b();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Answers", "Failed to disable events", e);
            }
        }
    }

    class C28403 implements Runnable {
        final /* synthetic */ C2845b f9817a;

        C28403(C2845b c2845b) {
            this.f9817a = c2845b;
        }

        public void run() {
            try {
                this.f9817a.f9824b.mo1441a();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Answers", "Failed to send events files", e);
            }
        }
    }

    class C28414 implements Runnable {
        final /* synthetic */ C2845b f9818a;

        C28414(C2845b c2845b) {
            this.f9818a = c2845b;
        }

        public void run() {
            try {
                C2868s a = this.f9818a.f9828f.m16121a();
                C2865o a2 = this.f9818a.f9827e.m16040a();
                a2.m16094a(this.f9818a);
                this.f9818a.f9824b = new C2857i(this.f9818a.f9825c, this.f9818a.f9826d, this.f9818a.f9823a, a2, this.f9818a.f9829g, a);
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Answers", "Failed to enable events", e);
            }
        }
    }

    class C28425 implements Runnable {
        final /* synthetic */ C2845b f9819a;

        C28425(C2845b c2845b) {
            this.f9819a = c2845b;
        }

        public void run() {
            try {
                this.f9819a.f9824b.mo1445c();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Answers", "Failed to flush events", e);
            }
        }
    }

    public C2845b(C2822h c2822h, Context context, C2846c c2846c, C2871u c2871u, C4045c c4045c, ScheduledExecutorService scheduledExecutorService) {
        this.f9825c = c2822h;
        this.f9826d = context;
        this.f9827e = c2846c;
        this.f9828f = c2871u;
        this.f9829g = c4045c;
        this.f9823a = scheduledExecutorService;
    }

    public void m16032a(C2836a c2836a) {
        m16033a(c2836a, false, false);
    }

    public void m16037b(C2836a c2836a) {
        m16033a(c2836a, false, true);
    }

    public void m16039c(C2836a c2836a) {
        m16033a(c2836a, true, false);
    }

    public void m16034a(final C4051b c4051b, final String str) {
        m16027b(new Runnable(this) {
            final /* synthetic */ C2845b f9815c;

            public void run() {
                try {
                    this.f9815c.f9824b.mo1443a(c4051b, str);
                } catch (Throwable e) {
                    C3969c.m20576h().mo2857e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    public void m16031a() {
        m16027b(new C28392(this));
    }

    public void mo1433a(String str) {
        m16027b(new C28403(this));
    }

    public void m16036b() {
        m16027b(new C28414(this));
    }

    public void m16038c() {
        m16027b(new C28425(this));
    }

    void m16033a(final C2836a c2836a, boolean z, final boolean z2) {
        Runnable c28436 = new Runnable(this) {
            final /* synthetic */ C2845b f9822c;

            public void run() {
                try {
                    this.f9822c.f9824b.mo1442a(c2836a);
                    if (z2) {
                        this.f9822c.f9824b.mo1445c();
                    }
                } catch (Throwable e) {
                    C3969c.m20576h().mo2857e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            m16025a(c28436);
        } else {
            m16027b(c28436);
        }
    }

    private void m16025a(Runnable runnable) {
        try {
            this.f9823a.submit(runnable).get();
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Answers", "Failed to run events task", e);
        }
    }

    private void m16027b(Runnable runnable) {
        try {
            this.f9823a.submit(runnable);
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Answers", "Failed to submit events task", e);
        }
    }
}
