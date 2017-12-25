package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.C3962a.C2819b;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.C4031b;
import io.fabric.sdk.android.services.concurrency.C4036h;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class C3969c {
    static volatile C3969c f14041a;
    static final C3963k f14042b = new C3964b();
    final C3963k f14043c;
    final boolean f14044d;
    private final Context f14045e;
    private final Map<Class<? extends C2822h>, C2822h> f14046f;
    private final ExecutorService f14047g;
    private final Handler f14048h;
    private final C3966f<C3969c> f14049i;
    private final C3966f<?> f14050j;
    private final IdManager f14051k;
    private C3962a f14052l;
    private WeakReference<Activity> f14053m;
    private AtomicBoolean f14054n = new AtomicBoolean(false);

    class C39651 extends C2819b {
        final /* synthetic */ C3969c f14027a;

        C39651(C3969c c3969c) {
            this.f14027a = c3969c;
        }

        public void mo1434a(Activity activity, Bundle bundle) {
            this.f14027a.m20579a(activity);
        }

        public void mo1425a(Activity activity) {
            this.f14027a.m20579a(activity);
        }

        public void mo1435b(Activity activity) {
            this.f14027a.m20579a(activity);
        }
    }

    public static class C3968a {
        private final Context f14032a;
        private C2822h[] f14033b;
        private C4036h f14034c;
        private Handler f14035d;
        private C3963k f14036e;
        private boolean f14037f;
        private String f14038g;
        private String f14039h;
        private C3966f<C3969c> f14040i;

        public C3968a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f14032a = context;
        }

        public C3968a m20563a(C2822h... c2822hArr) {
            if (this.f14033b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f14033b = c2822hArr;
            return this;
        }

        public C3969c m20564a() {
            Map hashMap;
            if (this.f14034c == null) {
                this.f14034c = C4036h.m20849a();
            }
            if (this.f14035d == null) {
                this.f14035d = new Handler(Looper.getMainLooper());
            }
            if (this.f14036e == null) {
                if (this.f14037f) {
                    this.f14036e = new C3964b(3);
                } else {
                    this.f14036e = new C3964b();
                }
            }
            if (this.f14039h == null) {
                this.f14039h = this.f14032a.getPackageName();
            }
            if (this.f14040i == null) {
                this.f14040i = C3966f.f14028d;
            }
            if (this.f14033b == null) {
                hashMap = new HashMap();
            } else {
                hashMap = C3969c.m20572b(Arrays.asList(this.f14033b));
            }
            Context applicationContext = this.f14032a.getApplicationContext();
            return new C3969c(applicationContext, hashMap, this.f14034c, this.f14035d, this.f14036e, this.f14037f, this.f14040i, new IdManager(applicationContext, this.f14039h, this.f14038g, hashMap.values()), C3969c.m20575d(this.f14032a));
        }
    }

    static C3969c m20565a() {
        if (f14041a != null) {
            return f14041a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C3969c(Context context, Map<Class<? extends C2822h>, C2822h> map, C4036h c4036h, Handler handler, C3963k c3963k, boolean z, C3966f c3966f, IdManager idManager, Activity activity) {
        this.f14045e = context;
        this.f14046f = map;
        this.f14047g = c4036h;
        this.f14048h = handler;
        this.f14043c = c3963k;
        this.f14044d = z;
        this.f14049i = c3966f;
        this.f14050j = m20580a(map.size());
        this.f14051k = idManager;
        m20579a(activity);
    }

    public static C3969c m20566a(Context context, C2822h... c2822hArr) {
        if (f14041a == null) {
            synchronized (C3969c.class) {
                if (f14041a == null) {
                    C3969c.m20574c(new C3968a(context).m20563a(c2822hArr).m20564a());
                }
            }
        }
        return f14041a;
    }

    private static void m20574c(C3969c c3969c) {
        f14041a = c3969c;
        c3969c.m20578j();
    }

    public C3969c m20579a(Activity activity) {
        this.f14053m = new WeakReference(activity);
        return this;
    }

    public Activity m20583b() {
        if (this.f14053m != null) {
            return (Activity) this.f14053m.get();
        }
        return null;
    }

    private void m20578j() {
        this.f14052l = new C3962a(this.f14045e);
        this.f14052l.m20532a(new C39651(this));
        m20581a(this.f14045e);
    }

    public String m20585c() {
        return "1.3.17.dev";
    }

    public String m20586d() {
        return "io.fabric.sdk.android:fabric";
    }

    void m20581a(Context context) {
        StringBuilder append;
        Future b = m20584b(context);
        Collection g = m20589g();
        C3977l c3977l = new C3977l(b, g);
        List<C2822h> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        c3977l.m15962a(context, this, C3966f.f14028d, this.f14051k);
        for (C2822h a : arrayList) {
            a.m15962a(context, this, this.f14050j, this.f14051k);
        }
        c3977l.m15968p();
        if (C3969c.m20576h().mo2851a("Fabric", 3)) {
            append = new StringBuilder("Initializing ").append(m20586d()).append(" [Version: ").append(m20585c()).append("], with the following kits:\n");
        } else {
            append = null;
        }
        for (C2822h a2 : arrayList) {
            a2.f9758f.m20612a(c3977l.f);
            m20582a(this.f14046f, a2);
            a2.m15968p();
            if (append != null) {
                append.append(a2.mo1427b()).append(" [Version: ").append(a2.mo1426a()).append("]\n");
            }
        }
        if (append != null) {
            C3969c.m20576h().mo2849a("Fabric", append.toString());
        }
    }

    void m20582a(Map<Class<? extends C2822h>, C2822h> map, C2822h c2822h) {
        C4031b c4031b = c2822h.f9762j;
        if (c4031b != null) {
            for (Class cls : c4031b.m20836a()) {
                if (cls.isInterface()) {
                    for (C2822h c2822h2 : map.values()) {
                        if (cls.isAssignableFrom(c2822h2.getClass())) {
                            c2822h.f9758f.m20612a(c2822h2.f9758f);
                        }
                    }
                } else if (((C2822h) map.get(cls)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    c2822h.f9758f.m20612a(((C2822h) map.get(cls)).f9758f);
                }
            }
        }
    }

    private static Activity m20575d(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public C3962a m20587e() {
        return this.f14052l;
    }

    public ExecutorService m20588f() {
        return this.f14047g;
    }

    public Collection<C2822h> m20589g() {
        return this.f14046f.values();
    }

    public static <T extends C2822h> T m20567a(Class<T> cls) {
        return (C2822h) C3969c.m20565a().f14046f.get(cls);
    }

    public static C3963k m20576h() {
        if (f14041a == null) {
            return f14042b;
        }
        return f14041a.f14043c;
    }

    public static boolean m20577i() {
        if (f14041a == null) {
            return false;
        }
        return f14041a.f14044d;
    }

    private static Map<Class<? extends C2822h>, C2822h> m20572b(Collection<? extends C2822h> collection) {
        Map hashMap = new HashMap(collection.size());
        C3969c.m20570a(hashMap, (Collection) collection);
        return hashMap;
    }

    private static void m20570a(Map<Class<? extends C2822h>, C2822h> map, Collection<? extends C2822h> collection) {
        for (C2822h c2822h : collection) {
            map.put(c2822h.getClass(), c2822h);
            if (c2822h instanceof C2833i) {
                C3969c.m20570a((Map) map, ((C2833i) c2822h).mo1432c());
            }
        }
    }

    C3966f<?> m20580a(final int i) {
        return new C3966f(this) {
            final CountDownLatch f14029a = new CountDownLatch(i);
            final /* synthetic */ C3969c f14031c;

            public void mo2859a(Object obj) {
                this.f14029a.countDown();
                if (this.f14029a.getCount() == 0) {
                    this.f14031c.f14054n.set(true);
                    this.f14031c.f14049i.mo2859a(this.f14031c);
                }
            }

            public void mo2858a(Exception exception) {
                this.f14031c.f14049i.mo2858a(exception);
            }
        };
    }

    Future<Map<String, C3976j>> m20584b(Context context) {
        return m20588f().submit(new C3971e(context.getPackageCodePath()));
    }
}
