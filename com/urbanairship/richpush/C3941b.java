package com.urbanairship.richpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.content.C0265i;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3680a;
import com.urbanairship.C3767e;
import com.urbanairship.C3783j;
import com.urbanairship.C3790k;
import com.urbanairship.C3790k.C3789a;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.messagecenter.MessageCenterActivity;
import com.urbanairship.richpush.C3944e.C3932a;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class C3941b extends C3680a {
    private static final C3940d f13973a = new C3940d();
    private static final Object f13974b = new Object();
    private final List<C3823b> f13975c;
    private final Set<String> f13976d;
    private final Map<String, C3942c> f13977e;
    private final Map<String, C3942c> f13978f;
    private final C3943d f13979g;
    private C3944e f13980h;
    private final Executor f13981i;
    private int f13982j;
    private BroadcastReceiver f13983k;
    private Context f13984l;
    private Handler f13985m;

    public interface C3823b {
        void mo2802a();
    }

    public interface C3837a {
        void mo2805a(boolean z);
    }

    class C39331 implements C3932a {
        final /* synthetic */ C3941b f13964a;

        C39331(C3941b c3941b) {
            this.f13964a = c3941b;
        }

        public void mo2846a(boolean z) {
            if (z) {
                this.f13964a.f13980h.m20479b(this);
                this.f13964a.m20443d();
            }
        }
    }

    class C39342 extends BroadcastReceiver {
        final /* synthetic */ C3941b f13965a;

        C39342(C3941b c3941b) {
            this.f13965a = c3941b;
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.urbanairship.analytics.APP_FOREGROUND".equals(intent.getAction())) {
                this.f13965a.m20443d();
            } else {
                context.startService(new Intent(context, RichPushUpdateService.class).setAction("com.urbanairship.richpush.SYNC_MESSAGE_STATE"));
            }
        }
    }

    class C39386 implements Runnable {
        final /* synthetic */ C3941b f13972a;

        C39386(C3941b c3941b) {
            this.f13972a = c3941b;
        }

        public void run() {
            synchronized (this.f13972a.f13975c) {
                Iterator it = new ArrayList(this.f13972a.f13975c).iterator();
                while (it.hasNext()) {
                    ((C3823b) it.next()).mo2802a();
                }
            }
        }
    }

    public interface C3939c {
        boolean m20421a(C3942c c3942c);
    }

    static class C3940d implements Comparator<C3942c> {
        C3940d() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m20422a((C3942c) obj, (C3942c) obj2);
        }

        public int m20422a(C3942c c3942c, C3942c c3942c2) {
            if (c3942c2.m20451f() == c3942c.m20451f()) {
                return c3942c.m20446a().compareTo(c3942c2.m20446a());
            }
            return Long.valueOf(c3942c2.m20451f()).compareTo(Long.valueOf(c3942c.m20451f()));
        }
    }

    public C3941b(Context context, C3796l c3796l) {
        this(context, new C3944e(c3796l), new C3943d(context), Executors.newSingleThreadExecutor());
    }

    C3941b(Context context, C3944e c3944e, C3943d c3943d, Executor executor) {
        this.f13975c = new ArrayList();
        this.f13976d = new HashSet();
        this.f13977e = new HashMap();
        this.f13978f = new HashMap();
        this.f13982j = 0;
        this.f13985m = new Handler(Looper.getMainLooper());
        this.f13984l = context.getApplicationContext();
        this.f13980h = c3944e;
        this.f13979g = c3943d;
        this.f13981i = executor;
    }

    protected void mo2777a() {
        if (C3954i.m20512a(this.f13980h.m20478b())) {
            this.f13980h.m20475a(new C39331(this));
        } else {
            this.f13980h.m20477a(false);
        }
        m20437a(false);
        this.f13983k = new C39342(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.urbanairship.analytics.APP_FOREGROUND");
        intentFilter.addAction("com.urbanairship.analytics.APP_BACKGROUND");
        C0265i.m1105a(this.f13984l).m1109a(this.f13983k, intentFilter);
    }

    public C3944e m20439b() {
        return this.f13980h;
    }

    public void m20442c() {
        Intent addFlags = new Intent("com.urbanairship.VIEW_RICH_PUSH_INBOX").setPackage(this.f13984l.getPackageName()).addFlags(805306368);
        if (addFlags.resolveActivity(this.f13984l.getPackageManager()) == null) {
            if (VERSION.SDK_INT >= 14) {
                addFlags.setClass(this.f13984l, MessageCenterActivity.class);
            } else {
                C3783j.m19728e("Failed to display inbox. No activities available.");
                return;
            }
        }
        this.f13984l.startActivity(addFlags);
    }

    public void m20435a(String str) {
        Intent data = new Intent("com.urbanairship.VIEW_RICH_PUSH_MESSAGE").setPackage(this.f13984l.getPackageName()).addFlags(805306368).setData(Uri.fromParts(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str, null));
        if (data.resolveActivity(this.f13984l.getPackageManager()) == null) {
            if (VERSION.SDK_INT >= 14) {
                data.setClass(this.f13984l, MessageCenterActivity.class);
            } else {
                data.setAction("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION");
            }
        }
        this.f13984l.startActivity(data);
    }

    public void m20434a(C3823b c3823b) {
        synchronized (this.f13975c) {
            this.f13975c.add(c3823b);
        }
    }

    public void m20440b(C3823b c3823b) {
        synchronized (this.f13975c) {
            this.f13975c.remove(c3823b);
        }
    }

    public void m20443d() {
        m20423a(false, null, null);
    }

    public C3767e m20430a(C3837a c3837a) {
        return m20423a(true, c3837a, null);
    }

    public C3767e m20431a(C3837a c3837a, Looper looper) {
        return m20423a(true, c3837a, looper);
    }

    private C3767e m20423a(boolean z, final C3837a c3837a, Looper looper) {
        C3790k c3790k = new C3790k(new C3789a<Boolean>(this) {
            final /* synthetic */ C3941b f13967b;

            public void m20419a(Boolean bool) {
                if (c3837a != null) {
                    C3837a c3837a = c3837a;
                    boolean z = bool != null && bool.booleanValue();
                    c3837a.mo2805a(z);
                }
            }
        });
        if (this.f13982j <= 0 || z) {
            this.f13982j++;
            Looper mainLooper = looper == null ? Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper() : looper;
            Parcelable richPushInbox$4 = new RichPushInbox$4(this, new Handler(mainLooper), c3790k);
            C3783j.m19725c("RichPushInbox - Starting update service.");
            Context h = C3929q.m20382h();
            h.startService(new Intent(h, RichPushUpdateService.class).setAction("com.urbanairship.richpush.MESSAGES_UPDATE").putExtra("com.urbanairship.richpush.RESULT_RECEIVER", richPushInbox$4));
            return c3790k;
        }
        C3783j.m19725c("Skipping refresh messages, messages are already refreshing. Callback will not be triggered.");
        c3790k.mo2787a();
        return c3790k;
    }

    private Collection<C3942c> m20425a(Collection<C3942c> collection, C3939c c3939c) {
        List arrayList = new ArrayList();
        if (c3939c == null) {
            return collection;
        }
        for (C3942c c3942c : collection) {
            if (c3939c.m20421a(c3942c)) {
                arrayList.add(c3942c);
            }
        }
        return arrayList;
    }

    public List<C3942c> m20432a(C3939c c3939c) {
        List<C3942c> arrayList;
        synchronized (f13974b) {
            arrayList = new ArrayList();
            arrayList.addAll(m20425a(this.f13977e.values(), c3939c));
            arrayList.addAll(m20425a(this.f13978f.values(), c3939c));
            Collections.sort(arrayList, f13973a);
        }
        return arrayList;
    }

    public C3942c m20438b(String str) {
        if (str == null) {
            return null;
        }
        synchronized (f13974b) {
            if (this.f13977e.containsKey(str)) {
                C3942c c3942c = (C3942c) this.f13977e.get(str);
                return c3942c;
            }
            c3942c = (C3942c) this.f13978f.get(str);
            return c3942c;
        }
    }

    public void m20436a(final Set<String> set) {
        this.f13981i.execute(new Runnable(this) {
            final /* synthetic */ C3941b f13969b;

            public void run() {
                this.f13969b.f13979g.m20462a(set);
            }
        });
        synchronized (f13974b) {
            for (String str : set) {
                C3942c c3942c = (C3942c) this.f13977e.get(str);
                if (c3942c != null) {
                    c3942c.f13987b = false;
                    this.f13977e.remove(str);
                    this.f13978f.put(str, c3942c);
                }
            }
            m20429e();
        }
    }

    public void m20441b(final Set<String> set) {
        this.f13981i.execute(new Runnable(this) {
            final /* synthetic */ C3941b f13971b;

            public void run() {
                this.f13971b.f13979g.m20464b(set);
            }
        });
        synchronized (f13974b) {
            for (String str : set) {
                C3942c b = m20438b(str);
                if (b != null) {
                    b.f13986a = true;
                    this.f13977e.remove(str);
                    this.f13978f.remove(str);
                    this.f13976d.add(str);
                }
            }
        }
        m20429e();
    }

    void m20437a(boolean z) {
        List<C3942c> a = this.f13979g.mo2847a();
        synchronized (f13974b) {
            Set hashSet = new HashSet(this.f13977e.keySet());
            Set hashSet2 = new HashSet(this.f13978f.keySet());
            Set hashSet3 = new HashSet(this.f13976d);
            this.f13977e.clear();
            this.f13978f.clear();
            for (C3942c c3942c : a) {
                if (c3942c.m20455j() || hashSet3.contains(c3942c.m20446a())) {
                    this.f13976d.add(c3942c.m20446a());
                } else if (c3942c.m20452g()) {
                    this.f13976d.add(c3942c.m20446a());
                } else if (hashSet.contains(c3942c.m20446a())) {
                    c3942c.f13987b = true;
                    this.f13977e.put(c3942c.m20446a(), c3942c);
                } else if (hashSet2.contains(c3942c.m20446a())) {
                    c3942c.f13987b = false;
                    this.f13978f.put(c3942c.m20446a(), c3942c);
                } else if (c3942c.f13987b) {
                    this.f13977e.put(c3942c.m20446a(), c3942c);
                } else {
                    this.f13978f.put(c3942c.m20446a(), c3942c);
                }
            }
        }
        if (z) {
            m20429e();
        }
    }

    private void m20429e() {
        this.f13985m.post(new C39386(this));
    }
}
