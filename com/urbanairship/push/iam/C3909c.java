package com.urbanairship.push.iam;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.C3680a;
import com.urbanairship.C3731i;
import com.urbanairship.C3767e;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3860o.C3848a;
import com.urbanairship.C3929q;
import com.urbanairship.C3929q.C1186a;
import com.urbanairship.push.iam.InAppMessageFragment.C3898a;
import com.urbanairship.util.C3949d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class C3909c extends C3680a {
    private static C3731i f13855a;
    private static C3767e f13856b;
    private static int f13857c = 0;
    private static boolean f13858d = false;
    private final C3796l f13859e;
    private final Handler f13860f;
    private WeakReference<Activity> f13861g;
    private InAppMessageFragment f13862h;
    private boolean f13863i;
    private boolean f13864j;
    private InAppMessage f13865k;
    private final List<C1707a> f13866l = new ArrayList();
    private final Object f13867m = new Object();
    private C3900b f13868n;
    private long f13869o;
    private final Runnable f13870p = new C39011(this);
    private final C3898a f13871q = new C39044(this);

    public interface C1707a {
        void mo1050a(InAppMessage inAppMessage);

        void mo1051a(InAppMessageFragment inAppMessageFragment, InAppMessage inAppMessage);
    }

    class C39011 implements Runnable {
        final /* synthetic */ C3909c f13846a;

        C39011(C3909c c3909c) {
            this.f13846a = c3909c;
        }

        public void run() {
            if ((this.f13846a.f13863i || this.f13846a.m20267b()) && this.f13846a.m20269c()) {
                Activity b = this.f13846a.m20258m();
                if (b != null && this.f13846a.m20263a(b)) {
                    this.f13846a.f13863i = false;
                }
            }
        }
    }

    class C39022 extends C3900b {
        final /* synthetic */ C3909c f13847a;

        C39022(C3909c c3909c) {
            this.f13847a = c3909c;
        }

        public InAppMessageFragment mo2826a(InAppMessage inAppMessage) {
            return new InAppMessageFragment();
        }
    }

    class C39044 implements C3898a {
        final /* synthetic */ C3909c f13850a;

        C39044(C3909c c3909c) {
            this.f13850a = c3909c;
        }

        public void mo2827a(InAppMessageFragment inAppMessageFragment) {
            C3783j.m19723b("InAppMessageManager - InAppMessageFragment resumed: " + inAppMessageFragment);
            if (this.f13850a.f13862h != null && this.f13850a.f13862h != inAppMessageFragment) {
                C3783j.m19725c("InAppMessageManager - Dismissing " + inAppMessageFragment + " because it is no longer the current fragment.");
                inAppMessageFragment.m20220a(false);
            } else if (this.f13850a.f13865k == null || !this.f13850a.f13865k.equals(inAppMessageFragment.m20222b())) {
                C3783j.m19725c("InAppMessageManager - Dismissing " + inAppMessageFragment + " because its message is no longer current.");
                inAppMessageFragment.m20220a(false);
            } else {
                this.f13850a.f13862h = inAppMessageFragment;
            }
        }

        @TargetApi(11)
        public void mo2828b(InAppMessageFragment inAppMessageFragment) {
            C3783j.m19723b("InAppMessageManager - InAppMessageFragment paused: " + inAppMessageFragment);
            if (inAppMessageFragment == this.f13850a.f13862h) {
                this.f13850a.f13862h = null;
                if (!inAppMessageFragment.m20221a() && inAppMessageFragment.getActivity().isFinishing()) {
                    C3783j.m19723b("InAppMessageManager - InAppMessageFragment's activity is finishing: " + inAppMessageFragment);
                    this.f13850a.f13863i = true;
                }
            }
        }

        public void mo2829c(InAppMessageFragment inAppMessageFragment) {
            C3783j.m19723b("InAppMessageManager - InAppMessageFragment finished: " + inAppMessageFragment);
            InAppMessage b = inAppMessageFragment.m20222b();
            synchronized (this.f13850a.f13867m) {
                if (b != null) {
                    if (b.equals(this.f13850a.m20270d())) {
                        this.f13850a.m20260a(null);
                    }
                }
            }
            if (b != null && b.equals(this.f13850a.f13865k)) {
                this.f13850a.f13865k = null;
                if (this.f13850a.m20267b() && this.f13850a.m20258m() != null) {
                    this.f13850a.f13863i = true;
                    this.f13850a.f13860f.removeCallbacks(this.f13850a.f13870p);
                    this.f13850a.f13860f.postDelayed(this.f13850a.f13870p, this.f13850a.f13869o);
                }
            }
        }
    }

    static /* synthetic */ int m20251h() {
        int i = f13857c;
        f13857c = i + 1;
        return i;
    }

    static /* synthetic */ int m20255j() {
        int i = f13857c;
        f13857c = i - 1;
        return i;
    }

    public C3909c(C3796l c3796l) {
        this.f13859e = c3796l;
        this.f13869o = 3000;
        this.f13860f = new Handler(Looper.getMainLooper());
        this.f13863i = m20267b();
        if (VERSION.SDK_INT >= 11) {
            this.f13868n = new C39022(this);
        }
    }

    protected void mo2777a() {
        InAppMessage d = m20270d();
        if (d != null && d.m20186b()) {
            C3783j.m19725c("InAppMessageManager - pending in-app message expired.");
            C3929q.m20372a().m20394r().m19455a(C3910d.m20278b(d));
            m20260a(null);
        }
    }

    public boolean m20267b() {
        return this.f13864j;
    }

    public void m20262a(boolean z) {
        this.f13859e.m19820b("com.urbanairship.push.iam.AUTO_DISPLAY_ENABLED", z);
    }

    public boolean m20269c() {
        return this.f13859e.m19815a("com.urbanairship.push.iam.AUTO_DISPLAY_ENABLED", true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m20260a(final com.urbanairship.push.iam.InAppMessage r5) {
        /*
        r4 = this;
        r1 = r4.f13867m;
        monitor-enter(r1);
        if (r5 != 0) goto L_0x000e;
    L_0x0005:
        r0 = r4.f13859e;	 Catch:{ all -> 0x001a }
        r2 = "com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE";
        r0.m19816b(r2);	 Catch:{ all -> 0x001a }
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
    L_0x000d:
        return;
    L_0x000e:
        r0 = r4.m20270d();	 Catch:{ all -> 0x001a }
        r2 = r5.equals(r0);	 Catch:{ all -> 0x001a }
        if (r2 == 0) goto L_0x001d;
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x000d;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r2 = r4.f13860f;	 Catch:{ all -> 0x001a }
        r3 = new com.urbanairship.push.iam.c$3;	 Catch:{ all -> 0x001a }
        r3.<init>(r4, r5);	 Catch:{ all -> 0x001a }
        r2.post(r3);	 Catch:{ all -> 0x001a }
        r2 = r4.f13859e;	 Catch:{ all -> 0x001a }
        r3 = "com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE";
        r2.m19814a(r3, r5);	 Catch:{ all -> 0x001a }
        r2 = r4.f13865k;	 Catch:{ all -> 0x001a }
        if (r2 != 0) goto L_0x0048;
    L_0x0032:
        if (r0 == 0) goto L_0x0048;
    L_0x0034:
        r2 = "InAppMessageManager - pending in-app message replaced.";
        com.urbanairship.C3783j.m19725c(r2);	 Catch:{ all -> 0x001a }
        r0 = com.urbanairship.push.iam.C3910d.m20277a(r0, r5);	 Catch:{ all -> 0x001a }
        r2 = com.urbanairship.C3929q.m20372a();	 Catch:{ all -> 0x001a }
        r2 = r2.m20394r();	 Catch:{ all -> 0x001a }
        r2.m19455a(r0);	 Catch:{ all -> 0x001a }
    L_0x0048:
        r0 = r4.m20267b();	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x000c;
    L_0x004e:
        r0 = r4.m20258m();	 Catch:{ all -> 0x001a }
        if (r0 == 0) goto L_0x000c;
    L_0x0054:
        r0 = 1;
        r4.f13863i = r0;	 Catch:{ all -> 0x001a }
        r0 = r4.f13860f;	 Catch:{ all -> 0x001a }
        r2 = r4.f13870p;	 Catch:{ all -> 0x001a }
        r0.removeCallbacks(r2);	 Catch:{ all -> 0x001a }
        r0 = r4.f13860f;	 Catch:{ all -> 0x001a }
        r2 = r4.f13870p;	 Catch:{ all -> 0x001a }
        r0.post(r2);	 Catch:{ all -> 0x001a }
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.iam.c.a(com.urbanairship.push.iam.InAppMessage):void");
    }

    public InAppMessage m20270d() {
        InAppMessage inAppMessage = null;
        synchronized (this.f13867m) {
            String a = this.f13859e.m19810a("com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE", null);
            if (a != null) {
                try {
                    inAppMessage = InAppMessage.m20172b(a);
                } catch (Throwable e) {
                    C3783j.m19726c("InAppMessageManager - Failed to read pending in-app message: " + a, e);
                    m20260a(null);
                }
            }
        }
        return inAppMessage;
    }

    public InAppMessage m20271e() {
        return this.f13865k;
    }

    @TargetApi(14)
    public boolean m20263a(Activity activity) {
        return m20264a(activity, 16908290);
    }

    @TargetApi(14)
    public boolean m20264a(Activity activity, int i) {
        boolean z;
        synchronized (this.f13867m) {
            InAppMessage d = m20270d();
            if (activity == null || d == null) {
                z = false;
            } else {
                int i2;
                int i3;
                if (d.m20193i() == 1) {
                    i2 = C3848a.ua_iam_slide_in_top;
                    i3 = C3848a.ua_iam_slide_out_top;
                } else {
                    i2 = C3848a.ua_iam_slide_in_bottom;
                    i3 = C3848a.ua_iam_slide_out_bottom;
                }
                z = m20265a(activity, i, i2, i3);
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(14)
    public boolean m20265a(android.app.Activity r8, int r9, int r10, int r11) {
        /*
        r7 = this;
        r6 = 0;
        r2 = 1;
        r1 = 0;
        r3 = r7.f13867m;
        monitor-enter(r3);
        r4 = r7.m20270d();	 Catch:{ all -> 0x0034 }
        if (r4 == 0) goto L_0x002d;
    L_0x000c:
        r0 = r4.m20186b();	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x002d;
    L_0x0012:
        r0 = "InAppMessageManager - Unable to display pending in-app message. Message has expired.";
        com.urbanairship.C3783j.m19725c(r0);	 Catch:{ all -> 0x0034 }
        r0 = com.urbanairship.push.iam.C3910d.m20278b(r4);	 Catch:{ all -> 0x0034 }
        r2 = com.urbanairship.C3929q.m20372a();	 Catch:{ all -> 0x0034 }
        r2 = r2.m20394r();	 Catch:{ all -> 0x0034 }
        r2.m19455a(r0);	 Catch:{ all -> 0x0034 }
        r0 = 0;
        r7.m20260a(r0);	 Catch:{ all -> 0x0034 }
        monitor-exit(r3);	 Catch:{ all -> 0x0034 }
        r0 = r1;
    L_0x002c:
        return r0;
    L_0x002d:
        monitor-exit(r3);	 Catch:{ all -> 0x0034 }
        if (r8 == 0) goto L_0x0032;
    L_0x0030:
        if (r4 != 0) goto L_0x0037;
    L_0x0032:
        r0 = r1;
        goto L_0x002c;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0034 }
        throw r0;
    L_0x0037:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 14;
        if (r0 >= r3) goto L_0x0044;
    L_0x003d:
        r0 = "InAppMessageManager - Unable to show in-app messages on Android versions older than API 14 (Ice Cream Sandwich).";
        com.urbanairship.C3783j.m19728e(r0);
        r0 = r1;
        goto L_0x002c;
    L_0x0044:
        r0 = r8.isFinishing();
        if (r0 == 0) goto L_0x0051;
    L_0x004a:
        r0 = "InAppMessageManager - Unable to display in-app messages for an activity that is finishing.";
        com.urbanairship.C3783j.m19728e(r0);
        r0 = r1;
        goto L_0x002c;
    L_0x0051:
        r0 = android.os.Looper.getMainLooper();
        r3 = android.os.Looper.myLooper();
        if (r0 == r3) goto L_0x0062;
    L_0x005b:
        r0 = "InAppMessageManager - Show message must be called on the main thread.";
        com.urbanairship.C3783j.m19728e(r0);
        r0 = r1;
        goto L_0x002c;
    L_0x0062:
        r0 = r7.f13862h;
        if (r0 == 0) goto L_0x006d;
    L_0x0066:
        r0 = "InAppMessageManager - An in-app message is already displayed.";
        com.urbanairship.C3783j.m19725c(r0);
        r0 = r1;
        goto L_0x002c;
    L_0x006d:
        r0 = r8.findViewById(r9);
        if (r0 != 0) goto L_0x008b;
    L_0x0073:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "InAppMessageManager - Unable to display in-app message. Unable to find container: ";
        r0 = r0.append(r2);
        r0 = r0.append(r9);
        r0 = r0.toString();
        com.urbanairship.C3783j.m19727d(r0);
        r0 = r1;
        goto L_0x002c;
    L_0x008b:
        r0 = r4.m20187c();
        r3 = r7.f13859e;
        r5 = "com.urbanairship.push.iam.LAST_DISPLAYED_ID";
        r3 = r3.m19810a(r5, r6);
        r0 = com.urbanairship.util.C3954i.m20513a(r0, r3);
        if (r0 != 0) goto L_0x00d4;
    L_0x009d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = "InAppMessageManager - Displaying pending message: ";
        r0 = r0.append(r3);
        r0 = r0.append(r4);
        r3 = " for first time.";
        r0 = r0.append(r3);
        r0 = r0.toString();
        com.urbanairship.C3783j.m19725c(r0);
        r0 = new com.urbanairship.push.iam.a;
        r0.<init>(r4);
        r3 = com.urbanairship.C3929q.m20372a();
        r3 = r3.m20394r();
        r3.m19455a(r0);
        r0 = r7.f13859e;
        r3 = "com.urbanairship.push.iam.LAST_DISPLAYED_ID";
        r5 = r4.m20187c();
        r0.m19819b(r3, r5);
    L_0x00d4:
        r0 = r7.f13865k;
        if (r0 == 0) goto L_0x00f1;
    L_0x00d8:
        r0 = r7.f13865k;
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x00f1;
    L_0x00e0:
        r0 = r7.f13865k;
        r0 = com.urbanairship.push.iam.C3910d.m20277a(r0, r4);
        r3 = com.urbanairship.C3929q.m20372a();
        r3 = r3.m20394r();
        r3.m19455a(r0);
    L_0x00f1:
        r0 = "InAppMessageManager - Displaying in-app message.";
        com.urbanairship.C3783j.m19727d(r0);
        r0 = r7.m20272f();	 Catch:{ IllegalStateException -> 0x015d }
        if (r0 != 0) goto L_0x0104;
    L_0x00fc:
        r0 = "InAppMessageManager - InAppMessageFragmentFactory is null, unable to display an in-app message.";
        com.urbanairship.C3783j.m19728e(r0);	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r1;
        goto L_0x002c;
    L_0x0104:
        r0 = r0.mo2826a(r4);	 Catch:{ IllegalStateException -> 0x015d }
        r7.f13862h = r0;	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r7.f13862h;	 Catch:{ IllegalStateException -> 0x015d }
        if (r0 != 0) goto L_0x0116;
    L_0x010e:
        r0 = "InAppMessageManager - InAppMessageFragmentFactory returned a null fragment, unable to display an in-app message.";
        com.urbanairship.C3783j.m19728e(r0);	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r1;
        goto L_0x002c;
    L_0x0116:
        r0 = com.urbanairship.push.iam.InAppMessageFragment.m20213a(r4, r11);	 Catch:{ IllegalStateException -> 0x015d }
        r3 = r7.f13862h;	 Catch:{ IllegalStateException -> 0x015d }
        r3 = r3.getArguments();	 Catch:{ IllegalStateException -> 0x015d }
        if (r3 == 0) goto L_0x012b;
    L_0x0122:
        r3 = r7.f13862h;	 Catch:{ IllegalStateException -> 0x015d }
        r3 = r3.getArguments();	 Catch:{ IllegalStateException -> 0x015d }
        r0.putAll(r3);	 Catch:{ IllegalStateException -> 0x015d }
    L_0x012b:
        r3 = r7.f13862h;	 Catch:{ IllegalStateException -> 0x015d }
        r3.setArguments(r0);	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r7.f13862h;	 Catch:{ IllegalStateException -> 0x015d }
        r3 = r7.f13871q;	 Catch:{ IllegalStateException -> 0x015d }
        r0.m20219a(r3);	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r7.f13862h;	 Catch:{ IllegalStateException -> 0x015d }
        r3 = 1;
        r0.m20223b(r3);	 Catch:{ IllegalStateException -> 0x015d }
        r7.f13865k = r4;	 Catch:{ IllegalStateException -> 0x015d }
        r3 = r7.f13866l;	 Catch:{ IllegalStateException -> 0x015d }
        monitor-enter(r3);	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r7.f13866l;	 Catch:{ all -> 0x015a }
        r5 = r0.iterator();	 Catch:{ all -> 0x015a }
    L_0x0148:
        r0 = r5.hasNext();	 Catch:{ all -> 0x015a }
        if (r0 == 0) goto L_0x0166;
    L_0x014e:
        r0 = r5.next();	 Catch:{ all -> 0x015a }
        r0 = (com.urbanairship.push.iam.C3909c.C1707a) r0;	 Catch:{ all -> 0x015a }
        r6 = r7.f13862h;	 Catch:{ all -> 0x015a }
        r0.mo1051a(r6, r4);	 Catch:{ all -> 0x015a }
        goto L_0x0148;
    L_0x015a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x015a }
        throw r0;	 Catch:{ IllegalStateException -> 0x015d }
    L_0x015d:
        r0 = move-exception;
        r2 = "InAppMessageManager - Failed to display in-app message.";
        com.urbanairship.C3783j.m19724b(r2, r0);
        r0 = r1;
        goto L_0x002c;
    L_0x0166:
        monitor-exit(r3);	 Catch:{ all -> 0x015a }
        r0 = r8.getFragmentManager();	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r0.beginTransaction();	 Catch:{ IllegalStateException -> 0x015d }
        r3 = 0;
        r0 = r0.setCustomAnimations(r10, r3);	 Catch:{ IllegalStateException -> 0x015d }
        r3 = r7.f13862h;	 Catch:{ IllegalStateException -> 0x015d }
        r4 = "com.urbanairship.in_app_fragment";
        r0 = r0.add(r9, r3, r4);	 Catch:{ IllegalStateException -> 0x015d }
        r0.commit();	 Catch:{ IllegalStateException -> 0x015d }
        r0 = r2;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.iam.c.a(android.app.Activity, int, int, int):boolean");
    }

    public void m20261a(C1707a c1707a) {
        synchronized (this.f13866l) {
            this.f13866l.add(c1707a);
        }
    }

    public C3900b m20272f() {
        return this.f13868n;
    }

    private Activity m20258m() {
        return this.f13861g == null ? null : (Activity) this.f13861g.get();
    }

    void m20273g() {
        C3783j.m19723b("InAppMessageManager - App foregrounded.");
        InAppMessage d = m20270d();
        if ((this.f13865k == null && d != null) || (d != null && !d.equals(this.f13865k))) {
            if (this.f13865k != null) {
                C3929q.m20372a().m20394r().m19455a(C3910d.m20277a(this.f13865k, d));
            }
            this.f13865k = null;
            this.f13863i = true;
            this.f13860f.removeCallbacks(this.f13870p);
            this.f13860f.postDelayed(this.f13870p, this.f13869o);
        }
    }

    void m20266b(Activity activity) {
        C3783j.m19723b("InAppMessageManager - Activity paused: " + activity);
        this.f13861g = null;
        this.f13860f.removeCallbacks(this.f13870p);
    }

    void m20268c(Activity activity) {
        C3783j.m19723b("InAppMessageManager - Activity resumed: " + activity);
        ActivityInfo b = C3949d.m20498b(activity.getClass());
        if (b == null || b.metaData == null || !b.metaData.getBoolean("com.urbanairship.push.iam.EXCLUDE_FROM_AUTO_SHOW", false)) {
            this.f13861g = new WeakReference(activity);
            this.f13860f.removeCallbacks(this.f13870p);
            if (this.f13863i) {
                this.f13860f.postDelayed(this.f13870p, this.f13869o);
                return;
            }
            return;
        }
        C3783j.m19723b("InAppMessageManager - Activity contains metadata to exclude it from auto showing an in-app message");
    }

    @TargetApi(14)
    public static void m20241a(Application application) {
        if (f13855a == null) {
            f13855a = new C3731i(application) {

                class C39051 implements C1186a {
                    final /* synthetic */ C39085 f13851a;

                    C39051(C39085 c39085) {
                        this.f13851a = c39085;
                    }

                    public void mo872a(C3929q c3929q) {
                        C3929q.m20372a().m20393q().m20273g();
                    }
                }

                class C39062 implements Runnable {
                    final /* synthetic */ C39085 f13852a;

                    C39062(C39085 c39085) {
                        this.f13852a = c39085;
                    }

                    public void run() {
                        if (C3909c.f13857c == 0) {
                            C3909c.f13858d = false;
                        }
                    }
                }

                public void mo2775b(Activity activity) {
                    C3909c.m20251h();
                    if (!C3909c.f13858d) {
                        C3909c.f13858d = true;
                        if (C3929q.m20383i()) {
                            C3929q.m20372a().m20393q().m20273g();
                        } else {
                            C3929q.m20370a(new C39051(this));
                        }
                    }
                }

                public void mo2774a(Activity activity) {
                    C3909c.m20255j();
                    if (C3909c.f13857c == 0) {
                        new Handler(Looper.getMainLooper()).postDelayed(new C39062(this), 500);
                    }
                }

                public void mo2831d(Activity activity) {
                    final WeakReference weakReference = new WeakReference(activity);
                    C3909c.f13856b = C3929q.m20370a(new C1186a(this) {
                        final /* synthetic */ C39085 f13854b;

                        public void mo872a(C3929q c3929q) {
                            Activity activity = (Activity) weakReference.get();
                            if (activity != null) {
                                C3929q.m20372a().m20393q().m20268c(activity);
                            }
                        }
                    });
                }

                public void mo2830c(Activity activity) {
                    if (C3909c.f13856b == null || C3909c.f13856b.mo2788b()) {
                        C3929q.m20372a().m20393q().m20266b(activity);
                    } else {
                        C3909c.f13856b.mo2787a();
                    }
                }
            };
            f13855a.m19431a();
        }
    }
}
