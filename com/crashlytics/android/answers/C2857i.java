package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent.C2836a;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4001g;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.p046b.C2849f;
import io.fabric.sdk.android.services.p046b.C3986i;
import io.fabric.sdk.android.services.settings.C4051b;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class C2857i implements C2855r {
    final C2868s f9843a;
    C2849f f9844b;
    C4001g f9845c = new C4001g();
    C2858j f9846d = new C2859k();
    boolean f9847e = true;
    boolean f9848f = true;
    volatile int f9849g = -1;
    private final C2822h f9850h;
    private final C4045c f9851i;
    private final Context f9852j;
    private final C2865o f9853k;
    private final ScheduledExecutorService f9854l;
    private final AtomicReference<ScheduledFuture<?>> f9855m = new AtomicReference();

    public C2857i(C2822h c2822h, Context context, ScheduledExecutorService scheduledExecutorService, C2865o c2865o, C4045c c4045c, C2868s c2868s) {
        this.f9850h = c2822h;
        this.f9852j = context;
        this.f9854l = scheduledExecutorService;
        this.f9853k = c2865o;
        this.f9851i = c4045c;
        this.f9843a = c2868s;
    }

    public void mo1443a(C4051b c4051b, String str) {
        this.f9844b = C2850f.m16052a(new C2866p(this.f9850h, str, c4051b.f14269a, this.f9851i, this.f9845c.m20770a(this.f9852j)));
        this.f9853k.m16104a(c4051b);
        this.f9847e = c4051b.f14274f;
        C3969c.m20576h().mo2849a("Answers", "Custom event tracking " + (this.f9847e ? "enabled" : "disabled"));
        this.f9848f = c4051b.f14275g;
        C3969c.m20576h().mo2849a("Answers", "Predefined event tracking " + (this.f9848f ? "enabled" : "disabled"));
        if (c4051b.f14277i > 1) {
            C3969c.m20576h().mo2849a("Answers", "Event sampling enabled");
            this.f9846d = new C2863n(c4051b.f14277i);
        }
        this.f9849g = c4051b.f14270b;
        m16074a(0, (long) this.f9849g);
    }

    public void mo1442a(C2836a c2836a) {
        SessionEvent a = c2836a.m16011a(this.f9843a);
        if (!this.f9847e && Type.CUSTOM.equals(a.f9805c)) {
            C3969c.m20576h().mo2849a("Answers", "Custom events tracking disabled - skipping event: " + a);
        } else if (!this.f9848f && Type.PREDEFINED.equals(a.f9805c)) {
            C3969c.m20576h().mo2849a("Answers", "Predefined events tracking disabled - skipping event: " + a);
        } else if (this.f9846d.mo1447a(a)) {
            C3969c.m20576h().mo2849a("Answers", "Skipping filtered event: " + a);
        } else {
            try {
                this.f9853k.m16095a((Object) a);
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Answers", "Failed to write event: " + a, e);
            }
            m16080e();
        }
    }

    public void m16080e() {
        if ((this.f9849g != -1 ? 1 : null) != null) {
            m16074a((long) this.f9849g, (long) this.f9849g);
        }
    }

    public void mo1441a() {
        int size;
        if (this.f9844b == null) {
            CommonUtils.m20701a(this.f9852j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        CommonUtils.m20701a(this.f9852j, "Sending all files");
        List e = this.f9853k.m16100e();
        int i = 0;
        while (e.size() > 0) {
            CommonUtils.m20701a(this.f9852j, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e.size())}));
            boolean a = this.f9844b.mo1440a(e);
            if (a) {
                size = e.size() + i;
                try {
                    this.f9853k.m16096a(e);
                    i = size;
                } catch (Exception e2) {
                    Throwable e3 = e2;
                }
            }
            if (!a) {
                break;
            }
            try {
                e = this.f9853k.m16100e();
            } catch (Throwable e4) {
                Throwable th = e4;
                size = i;
                e3 = th;
            }
        }
        if (i == 0) {
            this.f9853k.m16102g();
        }
        CommonUtils.m20702a(this.f9852j, "Failed to send batch of analytics files to server: " + e3.getMessage(), e3);
        i = size;
        if (i == 0) {
            this.f9853k.m16102g();
        }
    }

    public void mo1446d() {
        if (this.f9855m.get() != null) {
            CommonUtils.m20701a(this.f9852j, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f9855m.get()).cancel(false);
            this.f9855m.set(null);
        }
    }

    public void mo1444b() {
        this.f9853k.m16101f();
    }

    public boolean mo1445c() {
        try {
            return this.f9853k.m16099d();
        } catch (Throwable e) {
            CommonUtils.m20702a(this.f9852j, "Failed to roll file over.", e);
            return false;
        }
    }

    void m16074a(long j, long j2) {
        if ((this.f9855m.get() == null ? 1 : null) != null) {
            Runnable c3986i = new C3986i(this.f9852j, this);
            CommonUtils.m20701a(this.f9852j, "Scheduling time based file roll over every " + j2 + " seconds");
            try {
                this.f9855m.set(this.f9854l.scheduleAtFixedRate(c3986i, j, j2, TimeUnit.SECONDS));
            } catch (Throwable e) {
                CommonUtils.m20702a(this.f9852j, "Failed to schedule time based file roll over", e);
            }
        }
    }
}
