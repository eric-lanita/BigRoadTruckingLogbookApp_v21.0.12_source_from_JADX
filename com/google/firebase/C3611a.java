package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.support.v4.p008d.C0270a;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.util.zza;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzalo;
import com.google.android.gms.internal.zzalp;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class C3611a {
    static final Map<String, C3611a> f13086a = new C0270a();
    private static final List<String> f13087b = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> f13088c = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> f13089d = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final Set<String> f13090e = Collections.emptySet();
    private static final Object f13091f = new Object();
    private final Context f13092g;
    private final String f13093h;
    private final C3615b f13094i;
    private final AtomicBoolean f13095j = new AtomicBoolean(true);
    private final AtomicBoolean f13096k = new AtomicBoolean();
    private final List<Object> f13097l = new CopyOnWriteArrayList();
    private final List<C3609a> f13098m = new CopyOnWriteArrayList();
    private final List<Object> f13099n = new CopyOnWriteArrayList();

    public interface C3609a {
        void m18851a(boolean z);
    }

    protected C3611a(Context context, String str, C3615b c3615b) {
        this.f13092g = (Context) zzab.zzy(context);
        this.f13093h = zzab.zzhr(str);
        this.f13094i = (C3615b) zzab.zzy(c3615b);
    }

    public static C3611a m18852a(Context context) {
        C3615b a = C3615b.m18875a(context);
        return a == null ? null : C3611a.m18853a(context, a);
    }

    public static C3611a m18853a(Context context, C3615b c3615b) {
        return C3611a.m18854a(context, c3615b, "[DEFAULT]");
    }

    public static C3611a m18854a(Context context, C3615b c3615b, String str) {
        Object c3611a;
        zzalp zzeq = zzalp.zzeq(context);
        C3611a.m18859b(context);
        String b = C3611a.m18858b(str);
        Object applicationContext = context.getApplicationContext();
        synchronized (f13091f) {
            zzab.zza(!f13086a.containsKey(b), new StringBuilder(String.valueOf(b).length() + 33).append("FirebaseApp name ").append(b).append(" already exists!").toString());
            zzab.zzb(applicationContext, (Object) "Application context cannot be null.");
            c3611a = new C3611a(applicationContext, b, c3615b);
            f13086a.put(b, c3611a);
        }
        zzeq.zzf(c3611a);
        C3611a.m18856a(C3611a.class, c3611a, f13087b);
        if (c3611a.m18867e()) {
            C3611a.m18856a(C3611a.class, c3611a, f13088c);
            C3611a.m18856a(Context.class, c3611a.m18864a(), f13089d);
        }
        return c3611a;
    }

    public static C3611a m18855a(String str) {
        C3611a c3611a;
        synchronized (f13091f) {
            c3611a = (C3611a) f13086a.get(C3611a.m18858b(str));
            if (c3611a != null) {
            } else {
                String str2;
                Iterable g = C3611a.m18863g();
                if (g.isEmpty()) {
                    str2 = "";
                } else {
                    String str3 = "Available app names: ";
                    str2 = String.valueOf(zzy.zzhq(", ").zza(g));
                    str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
            }
        }
        return c3611a;
    }

    private static <T> void m18856a(Class<T> cls, T t, Iterable<String> iterable) {
        String valueOf;
        for (String valueOf2 : iterable) {
            try {
                Method method = Class.forName(valueOf2).getMethod("getInstance", new Class[]{cls});
                int modifiers = method.getModifiers();
                if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                    method.invoke(null, new Object[]{t});
                }
            } catch (ClassNotFoundException e) {
                if (f13090e.contains(valueOf2)) {
                    throw new IllegalStateException(String.valueOf(valueOf2).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                }
                Log.d("FirebaseApp", String.valueOf(valueOf2).concat(" is not linked. Skipping initialization."));
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(String.valueOf(valueOf2).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
            } catch (Throwable e3) {
                Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
            } catch (Throwable e4) {
                String str = "FirebaseApp";
                String str2 = "Failed to initialize ";
                valueOf2 = String.valueOf(valueOf2);
                Log.wtf(str, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2), e4);
            }
        }
    }

    public static void m18857a(boolean z) {
        synchronized (f13091f) {
            Iterator it = new ArrayList(f13086a.values()).iterator();
            while (it.hasNext()) {
                C3611a c3611a = (C3611a) it.next();
                if (c3611a.f13095j.get()) {
                    c3611a.m18860b(z);
                }
            }
        }
    }

    private static String m18858b(String str) {
        return str.trim();
    }

    @TargetApi(14)
    private static void m18859b(Context context) {
        if (zzs.zzavq() && (context.getApplicationContext() instanceof Application)) {
            zzalo.zza((Application) context.getApplicationContext());
        }
    }

    private void m18860b(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (C3609a a : this.f13098m) {
            a.m18851a(z);
        }
    }

    public static C3611a m18861d() {
        return C3611a.m18855a("[DEFAULT]");
    }

    private void m18862f() {
        zzab.zza(!this.f13096k.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> m18863g() {
        Collection com_google_android_gms_common_util_zza = new zza();
        synchronized (f13091f) {
            for (C3611a b : f13086a.values()) {
                com_google_android_gms_common_util_zza.add(b.m18865b());
            }
            zzalp zzcxc = zzalp.zzcxc();
            if (zzcxc != null) {
                com_google_android_gms_common_util_zza.addAll(zzcxc.zzcxd());
            }
        }
        List<String> arrayList = new ArrayList(com_google_android_gms_common_util_zza);
        Collections.sort(arrayList);
        return arrayList;
    }

    public Context m18864a() {
        m18862f();
        return this.f13092g;
    }

    public String m18865b() {
        m18862f();
        return this.f13093h;
    }

    public C3615b m18866c() {
        m18862f();
        return this.f13094i;
    }

    public boolean m18867e() {
        return "[DEFAULT]".equals(m18865b());
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C3611a) ? false : this.f13093h.equals(((C3611a) obj).m18865b());
    }

    public int hashCode() {
        return this.f13093h.hashCode();
    }

    public String toString() {
        return zzaa.zzx(this).zzg("name", this.f13093h).zzg("options", this.f13094i).toString();
    }
}
