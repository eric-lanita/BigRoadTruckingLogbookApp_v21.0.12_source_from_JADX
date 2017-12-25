package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.answers.C2837a;
import com.crashlytics.android.core.C2900e.C2898a;
import com.crashlytics.android.core.C2943l.C2904a;
import com.crashlytics.android.core.C2954t.C2917a;
import com.crashlytics.android.core.ae.C2884d;
import com.crashlytics.android.core.ae.C2885a;
import com.crashlytics.android.core.ae.C2886b;
import com.crashlytics.android.core.ae.C2887c;
import com.crashlytics.android.core.p048a.p049a.C2875d;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4002i.C4003a;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.C4045c;
import io.fabric.sdk.android.services.p057c.C3987a;
import io.fabric.sdk.android.services.settings.C4067o;
import io.fabric.sdk.android.services.settings.C4068p;
import io.fabric.sdk.android.services.settings.C4071q;
import io.fabric.sdk.android.services.settings.C4072s;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class C2926g {
    static final FilenameFilter f10029a = new C29051();
    static final Comparator<File> f10030b = new C29117();
    static final Comparator<File> f10031c = new C29128();
    static final FilenameFilter f10032d = new C29139();
    private static final Pattern f10033e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final Map<String, String> f10034f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private static final String[] f10035g = new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};
    private final AtomicInteger f10036h = new AtomicInteger(0);
    private final C2939h f10037i;
    private final C2903f f10038j;
    private final C4045c f10039k;
    private final IdManager f10040l;
    private final aa f10041m;
    private final C3987a f10042n;
    private final C2880a f10043o;
    private final C2918d f10044p;
    private final C2954t f10045q;
    private final C2887c f10046r;
    private final C2886b f10047s;
    private final C2949p f10048t;
    private final ah f10049u;
    private final String f10050v;
    private C2943l f10051w;

    static class C29051 implements FilenameFilter {
        C29051() {
        }

        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    }

    class C29062 implements Callable<Void> {
        final /* synthetic */ C2926g f10007a;

        C29062(C2926g c2926g) {
            this.f10007a = c2926g;
        }

        public /* synthetic */ Object call() {
            return m16281a();
        }

        public Void m16281a() {
            this.f10007a.m16340m();
            return null;
        }
    }

    class C29084 implements Runnable {
        final /* synthetic */ C2926g f10010a;

        C29084(C2926g c2926g) {
            this.f10010a = c2926g;
        }

        public void run() {
            this.f10010a.m16351a(this.f10010a.m16319a(new C2916c()));
        }
    }

    static class C29117 implements Comparator<File> {
        C29117() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16284a((File) obj, (File) obj2);
        }

        public int m16284a(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    static class C29128 implements Comparator<File> {
        C29128() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m16285a((File) obj, (File) obj2);
        }

        public int m16285a(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    static class C29139 implements FilenameFilter {
        C29139() {
        }

        public boolean accept(File file, String str) {
            return C2926g.f10033e.matcher(str).matches();
        }
    }

    private static class C2914a implements FilenameFilter {
        private C2914a() {
        }

        public boolean accept(File file, String str) {
            return !C2926g.f10029a.accept(file, str) && C2926g.f10033e.matcher(str).matches();
        }
    }

    static class C2915b implements FilenameFilter {
        private final String f10015a;

        public C2915b(String str) {
            this.f10015a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f10015a) && !str.endsWith(".cls_temp");
        }
    }

    static class C2916c implements FilenameFilter {
        C2916c() {
        }

        public boolean accept(File file, String str) {
            return C2894d.f9977a.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    private static final class C2918d implements C2917a {
        private final C3987a f10016a;

        public C2918d(C3987a c3987a) {
            this.f10016a = c3987a;
        }

        public File mo1469a() {
            File file = new File(this.f10016a.mo2877a(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    private static final class C2921e implements C2884d {
        private final C2822h f10020a;
        private final aa f10021b;
        private final C4067o f10022c;

        class C29191 implements C2898a {
            final /* synthetic */ C2921e f10017a;

            C29191(C2921e c2921e) {
                this.f10017a = c2921e;
            }

            public void mo1470a(boolean z) {
                this.f10017a.f10021b.m16172a(z);
            }
        }

        public C2921e(C2822h c2822h, aa aaVar, C4067o c4067o) {
            this.f10020a = c2822h;
            this.f10021b = aaVar;
            this.f10022c = c4067o;
        }

        public boolean mo1460a() {
            Activity b = this.f10020a.m15971s().m20583b();
            if (b == null || b.isFinishing()) {
                return true;
            }
            final C2900e a = C2900e.m16269a(b, this.f10022c, new C29191(this));
            b.runOnUiThread(new Runnable(this) {
                final /* synthetic */ C2921e f10019b;

                public void run() {
                    a.m16270a();
                }
            });
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Waiting for user opt-in.");
            a.m16271b();
            return a.m16272c();
        }
    }

    private final class C2922f implements C2887c {
        final /* synthetic */ C2926g f10023a;

        private C2922f(C2926g c2926g) {
            this.f10023a = c2926g;
        }

        public File[] mo1471a() {
            return this.f10023a.m16354b();
        }

        public File[] mo1472b() {
            return this.f10023a.m16361i().listFiles();
        }
    }

    private final class C2923g implements C2886b {
        final /* synthetic */ C2926g f10024a;

        private C2923g(C2926g c2926g) {
            this.f10024a = c2926g;
        }

        public boolean mo1473a() {
            return this.f10024a.m16357e();
        }
    }

    private static final class C2924h implements Runnable {
        private final Context f10025a;
        private final ad f10026b;
        private final ae f10027c;

        public C2924h(Context context, ad adVar, ae aeVar) {
            this.f10025a = context;
            this.f10026b = adVar;
            this.f10027c = aeVar;
        }

        public void run() {
            if (CommonUtils.m20727n(this.f10025a)) {
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                this.f10027c.m16209a(this.f10026b);
            }
        }
    }

    static class C2925i implements FilenameFilter {
        private final String f10028a;

        public C2925i(String str) {
            this.f10028a = str;
        }

        public boolean accept(File file, String str) {
            if (str.equals(this.f10028a + ".cls") || !str.contains(this.f10028a) || str.endsWith(".cls_temp")) {
                return false;
            }
            return true;
        }
    }

    C2926g(C2939h c2939h, C2903f c2903f, C4045c c4045c, IdManager idManager, aa aaVar, C3987a c3987a, C2880a c2880a, aj ajVar) {
        this.f10037i = c2939h;
        this.f10038j = c2903f;
        this.f10039k = c4045c;
        this.f10040l = idManager;
        this.f10041m = aaVar;
        this.f10042n = c3987a;
        this.f10043o = c2880a;
        this.f10050v = ajVar.mo1487a();
        Context r = c2939h.m15970r();
        this.f10044p = new C2918d(c3987a);
        this.f10045q = new C2954t(r, this.f10044p);
        this.f10046r = new C2922f();
        this.f10047s = new C2923g();
        this.f10048t = new C2949p(r);
        this.f10049u = new C2958w(1024, new ac(10));
    }

    void m16349a(UncaughtExceptionHandler uncaughtExceptionHandler) {
        m16343a();
        this.f10051w = new C2943l(new C2904a(this) {
            final /* synthetic */ C2926g f9995a;

            {
                this.f9995a = r1;
            }

            public void mo1468a(Thread thread, Throwable th) {
                this.f9995a.m16350a(thread, th);
            }
        }, uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.f10051w);
    }

    synchronized void m16350a(final Thread thread, final Throwable th) {
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        this.f10048t.m16431b();
        final Date date = new Date();
        this.f10038j.m16273a(new Callable<Void>(this) {
            final /* synthetic */ C2926g f9999d;

            public /* synthetic */ Object call() {
                return m16278a();
            }

            public Void m16278a() {
                this.f9999d.f10037i.m16411o();
                this.f9999d.m16312a(date, thread, th);
                C4072s b = C4071q.m20977a().m20980b();
                C4068p c4068p = b != null ? b.f14336b : null;
                this.f9999d.m16353b(c4068p);
                this.f9999d.m16340m();
                if (c4068p != null) {
                    this.f9999d.m16345a(c4068p.f14329g);
                }
                if (!this.f9999d.m16316a(b)) {
                    this.f9999d.m16325b(b);
                }
                return null;
            }
        });
    }

    void m16344a(float f, C4072s c4072s) {
        if (c4072s == null) {
            C3969c.m20576h().mo2854d("CrashlyticsCore", "Could not send reports. Settings are not available.");
            return;
        }
        new ae(this.f10043o.f9929a, m16336h(c4072s.f14335a.f14295d), this.f10046r, this.f10047s).m16208a(f, m16316a(c4072s) ? new C2921e(this.f10037i, this.f10041m, c4072s.f14337c) : new C2885a());
    }

    void m16346a(final long j, final String str) {
        this.f10038j.m16275b(new Callable<Void>(this) {
            final /* synthetic */ C2926g f10002c;

            public /* synthetic */ Object call() {
                return m16279a();
            }

            public Void m16279a() {
                if (!this.f10002c.m16357e()) {
                    this.f10002c.f10045q.m16453a(j, str);
                }
                return null;
            }
        });
    }

    void m16348a(final String str, final String str2, final String str3) {
        this.f10038j.m16275b(new Callable<Void>(this) {
            final /* synthetic */ C2926g f10006d;

            public /* synthetic */ Object call() {
                return m16280a();
            }

            public Void m16280a() {
                new C2957v(this.f10006d.m16358f()).m16466a(this.f10006d.m16338k(), new ak(str, str2, str3));
                return null;
            }
        });
    }

    void m16343a() {
        this.f10038j.m16275b(new C29062(this));
    }

    private String m16338k() {
        File[] n = m16341n();
        return n.length > 0 ? C2926g.m16295a(n[0]) : null;
    }

    private String m16339l() {
        File[] n = m16341n();
        return n.length > 1 ? C2926g.m16295a(n[1]) : null;
    }

    static String m16295a(File file) {
        return file.getName().substring(0, 35);
    }

    boolean m16352a(final C4068p c4068p) {
        return ((Boolean) this.f10038j.m16273a(new Callable<Boolean>(this) {
            final /* synthetic */ C2926g f10009b;

            public /* synthetic */ Object call() {
                return m16282a();
            }

            public Boolean m16282a() {
                if (this.f10009b.m16357e()) {
                    C3969c.m20576h().mo2849a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Finalizing previously open sessions.");
                this.f10009b.m16304a(c4068p, true);
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void m16340m() {
        Date date = new Date();
        String c2892c = new C2892c(this.f10040l).toString();
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Opening a new session with ID " + c2892c);
        m16311a(c2892c, date);
        m16330c(c2892c);
        m16332d(c2892c);
        m16333e(c2892c);
        this.f10045q.m16455a(c2892c);
    }

    void m16353b(C4068p c4068p) {
        m16304a(c4068p, false);
    }

    private void m16304a(C4068p c4068p, boolean z) {
        int i = z ? 1 : 0;
        m16321b(i + 8);
        File[] n = m16341n();
        if (n.length <= i) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
        m16334f(C2926g.m16295a(n[i]));
        if (c4068p == null) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
        } else {
            m16313a(n, i, c4068p.f14325c);
        }
    }

    private void m16313a(File[] fileArr, int i, int i2) {
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String a = C2926g.m16295a(file);
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Closing session: " + a);
            m16305a(file, a, i2);
            i++;
        }
    }

    private void m16300a(C2894d c2894d) {
        if (c2894d != null) {
            try {
                c2894d.m16262a();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void m16308a(String str) {
        for (File delete : m16327b(str)) {
            delete.delete();
        }
    }

    private File[] m16327b(String str) {
        return m16319a(new C2925i(str));
    }

    File[] m16354b() {
        List linkedList = new LinkedList();
        Collections.addAll(linkedList, m16318a(m16359g(), f10029a));
        Collections.addAll(linkedList, m16318a(m16360h(), f10029a));
        Collections.addAll(linkedList, m16318a(m16358f(), f10029a));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] m16355c() {
        return m16319a(new C2915b("BeginSession"));
    }

    private File[] m16341n() {
        File[] c = m16355c();
        Arrays.sort(c, f10030b);
        return c;
    }

    private File[] m16319a(FilenameFilter filenameFilter) {
        return m16318a(m16358f(), filenameFilter);
    }

    private File[] m16318a(File file, FilenameFilter filenameFilter) {
        return m16328b(file.listFiles(filenameFilter));
    }

    private File[] m16326b(File file) {
        return m16328b(file.listFiles());
    }

    private File[] m16328b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void m16309a(String str, int i) {
        al.m16250a(m16358f(), new C2915b(str + "SessionEvent"), i, f10031c);
    }

    void m16345a(int i) {
        int a = i - al.m16249a(m16359g(), i, f10031c);
        al.m16250a(m16358f(), f10029a, a - al.m16249a(m16360h(), a, f10031c), f10031c);
    }

    private void m16321b(int i) {
        Set hashSet = new HashSet();
        File[] n = m16341n();
        int min = Math.min(i, n.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(C2926g.m16295a(n[i2]));
        }
        this.f10045q.m16456a(hashSet);
        m16314a(m16319a(new C2914a()), hashSet);
    }

    private void m16314a(File[] fileArr, Set<String> set) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            String name = file.getName();
            Matcher matcher = f10033e.matcher(name);
            if (matcher.matches()) {
                if (!set.contains(matcher.group(1))) {
                    C3969c.m20576h().mo2849a("CrashlyticsCore", "Trimming session file: " + name);
                    file.delete();
                }
                i++;
            } else {
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Deleting unknown file: " + name);
                file.delete();
                return;
            }
        }
    }

    private File[] m16320a(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        C3969c.m20576h().mo2849a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        m16309a(str, i);
        return m16319a(new C2915b(str + "SessionEvent"));
    }

    void m16356d() {
        this.f10038j.m16274a(new C29084(this));
    }

    void m16351a(File[] fileArr) {
        int length;
        File file;
        int i = 0;
        final Set hashSet = new HashSet();
        for (File file2 : fileArr) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Found invalid session part file: " + file2);
            hashSet.add(C2926g.m16295a(file2));
        }
        if (!hashSet.isEmpty()) {
            File i2 = m16361i();
            if (!i2.exists()) {
                i2.mkdir();
            }
            File[] a = m16319a(new FilenameFilter(this) {
                final /* synthetic */ C2926g f10012b;

                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            });
            length = a.length;
            while (i < length) {
                file2 = a[i];
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Moving session file: " + file2);
                if (!file2.renameTo(new File(i2, file2.getName()))) {
                    C3969c.m20576h().mo2849a("CrashlyticsCore", "Could not move session file. Deleting " + file2);
                    file2.delete();
                }
                i++;
            }
            m16342o();
        }
    }

    private void m16342o() {
        File i = m16361i();
        if (i.exists()) {
            File[] a = m16318a(i, new C2916c());
            Arrays.sort(a, Collections.reverseOrder());
            Set hashSet = new HashSet();
            for (int i2 = 0; i2 < a.length && hashSet.size() < 4; i2++) {
                hashSet.add(C2926g.m16295a(a[i2]));
            }
            m16314a(m16326b(i), hashSet);
        }
    }

    private void m16312a(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        try {
            String k = m16338k();
            if (k == null) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
                CommonUtils.m20705a(null, "Failed to flush to session begin file.");
                CommonUtils.m20704a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C2926g.m16310a(k, th.getClass().getName());
            Closeable c2894d = new C2894d(m16358f(), k + "SessionCrash");
            try {
                flushable = CodedOutputStream.m16122a((OutputStream) c2894d);
                m16298a(flushable, date, thread, th, "crash", true);
                CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m20704a(c2894d, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                closeable = c2894d;
                try {
                    C3969c.m20576h().mo2857e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                    CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m20704a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable th2) {
                    e = th2;
                    CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m20704a(closeable, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                closeable = c2894d;
                CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m20704a(closeable, "Failed to close fatal exception file output stream.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            closeable = null;
            C3969c.m20576h().mo2857e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m20704a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            e = th4;
            closeable = null;
            CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m20704a(closeable, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    void m16347a(final C2875d c2875d) {
        this.f10038j.m16275b(new Callable<Void>(this) {
            final /* synthetic */ C2926g f10014b;

            public /* synthetic */ Object call() {
                return m16283a();
            }

            public Void m16283a() {
                if (!this.f10014b.m16357e()) {
                    this.f10014b.m16322b(c2875d);
                }
                return null;
            }
        });
    }

    private void m16322b(C2875d c2875d) {
        Throwable e;
        Object obj = 1;
        Flushable flushable = null;
        Closeable c2894d;
        try {
            String l = m16339l();
            if (l == null) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
                CommonUtils.m20705a(null, "Failed to flush to session begin file.");
                CommonUtils.m20704a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            C2926g.m16310a(l, String.format(Locale.US, "<native-crash [%s (%s)]>", new Object[]{c2875d.f9913b.f9919b, c2875d.f9913b.f9918a}));
            if (c2875d.f9915d == null || c2875d.f9915d.length <= 0) {
                obj = null;
            }
            c2894d = new C2894d(m16358f(), l + (obj != null ? "SessionCrash" : "SessionMissingBinaryImages"));
            try {
                flushable = CodedOutputStream.m16122a((OutputStream) c2894d);
                C2973y.m16502a(c2875d, new C2954t(this.f10037i.m15970r(), this.f10044p, l), new C2957v(m16358f()).m16467b(l), flushable);
                CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m20704a(c2894d, "Failed to close fatal exception file output stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("CrashlyticsCore", "An error occurred in the native crash logger", e);
                    CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m20704a(c2894d, "Failed to close fatal exception file output stream.");
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m20704a(c2894d, "Failed to close fatal exception file output stream.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c2894d = null;
            C3969c.m20576h().mo2857e("CrashlyticsCore", "An error occurred in the native crash logger", e);
            CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m20704a(c2894d, "Failed to close fatal exception file output stream.");
        } catch (Throwable th2) {
            e = th2;
            c2894d = null;
            CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m20704a(c2894d, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m16311a(String str, Date date) {
        Throwable th;
        Flushable flushable = null;
        Closeable c2894d;
        try {
            c2894d = new C2894d(m16358f(), str + "BeginSession");
            try {
                flushable = CodedOutputStream.m16122a((OutputStream) c2894d);
                af.m16234a((CodedOutputStream) flushable, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f10037i.mo1426a()}), date.getTime() / 1000);
                CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m20704a(c2894d, "Failed to close begin session file.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m20704a(c2894d, "Failed to close begin session file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c2894d = null;
            CommonUtils.m20705a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m20704a(c2894d, "Failed to close begin session file.");
            throw th;
        }
    }

    private void m16330c(String str) {
        Closeable closeable;
        Throwable th;
        Flushable flushable = null;
        try {
            Closeable c2894d = new C2894d(m16358f(), str + "SessionApp");
            try {
                Flushable a = CodedOutputStream.m16122a((OutputStream) c2894d);
                try {
                    af.m16236a((CodedOutputStream) a, this.f10040l.m20736c(), this.f10043o.f9929a, this.f10043o.f9933e, this.f10043o.f9934f, this.f10040l.m20735b(), DeliveryMechanism.m20728a(this.f10043o.f9931c).m20729a(), this.f10050v);
                    CommonUtils.m20705a(a, "Failed to flush to session app file.");
                    CommonUtils.m20704a(c2894d, "Failed to close session app file.");
                } catch (Throwable th2) {
                    closeable = c2894d;
                    Flushable flushable2 = a;
                    th = th2;
                    flushable = flushable2;
                    CommonUtils.m20705a(flushable, "Failed to flush to session app file.");
                    CommonUtils.m20704a(closeable, "Failed to close session app file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = c2894d;
                CommonUtils.m20705a(flushable, "Failed to flush to session app file.");
                CommonUtils.m20704a(closeable, "Failed to close session app file.");
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            CommonUtils.m20705a(flushable, "Failed to flush to session app file.");
            CommonUtils.m20704a(closeable, "Failed to close session app file.");
            throw th;
        }
    }

    private void m16332d(String str) {
        Throwable th;
        Flushable flushable = null;
        Closeable c2894d;
        try {
            c2894d = new C2894d(m16358f(), str + "SessionOS");
            try {
                flushable = CodedOutputStream.m16122a((OutputStream) c2894d);
                af.m16239a((CodedOutputStream) flushable, CommonUtils.m20720g(this.f10037i.m15970r()));
                CommonUtils.m20705a(flushable, "Failed to flush to session OS file.");
                CommonUtils.m20704a(c2894d, "Failed to close session OS file.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m20705a(flushable, "Failed to flush to session OS file.");
                CommonUtils.m20704a(c2894d, "Failed to close session OS file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c2894d = null;
            CommonUtils.m20705a(flushable, "Failed to flush to session OS file.");
            CommonUtils.m20704a(c2894d, "Failed to close session OS file.");
            throw th;
        }
    }

    private void m16333e(String str) {
        Throwable th;
        Closeable closeable = null;
        Flushable flushable = null;
        try {
            OutputStream c2894d = new C2894d(m16358f(), str + "SessionDevice");
            try {
                flushable = CodedOutputStream.m16122a(c2894d);
                Context r = this.f10037i.m15970r();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                af.m16233a((CodedOutputStream) flushable, this.f10040l.m20741h(), CommonUtils.m20685a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.m20708b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.m20719f(r), this.f10040l.m20742i(), CommonUtils.m20721h(r), Build.MANUFACTURER, Build.PRODUCT);
                CommonUtils.m20705a(flushable, "Failed to flush session device info.");
                CommonUtils.m20704a((Closeable) c2894d, "Failed to close session device file.");
            } catch (Throwable th2) {
                th = th2;
                Object obj = c2894d;
                CommonUtils.m20705a(flushable, "Failed to flush session device info.");
                CommonUtils.m20704a(closeable, "Failed to close session device file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.m20705a(flushable, "Failed to flush session device info.");
            CommonUtils.m20704a(closeable, "Failed to close session device file.");
            throw th;
        }
    }

    private void m16334f(String str) {
        Closeable c2894d;
        Throwable th;
        Flushable flushable = null;
        try {
            c2894d = new C2894d(m16358f(), str + "SessionUser");
            try {
                flushable = CodedOutputStream.m16122a((OutputStream) c2894d);
                ak g = m16335g(str);
                if (g.m16248a()) {
                    CommonUtils.m20705a(flushable, "Failed to flush session user file.");
                    CommonUtils.m20704a(c2894d, "Failed to close session user file.");
                    return;
                }
                af.m16235a((CodedOutputStream) flushable, g.f9964b, g.f9965c, g.f9966d);
                CommonUtils.m20705a(flushable, "Failed to flush session user file.");
                CommonUtils.m20704a(c2894d, "Failed to close session user file.");
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.m20705a(flushable, "Failed to flush session user file.");
                CommonUtils.m20704a(c2894d, "Failed to close session user file.");
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            c2894d = null;
            CommonUtils.m20705a(flushable, "Failed to flush session user file.");
            CommonUtils.m20704a(c2894d, "Failed to close session user file.");
            throw th;
        }
    }

    private void m16298a(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) {
        Thread[] threadArr;
        Map treeMap;
        ai aiVar = new ai(th, this.f10049u);
        Context r = this.f10037i.m15970r();
        long time = date.getTime() / 1000;
        Float c = CommonUtils.m20713c(r);
        int a = CommonUtils.m20687a(r, this.f10048t.m16430a());
        boolean d = CommonUtils.m20717d(r);
        int i = r.getResources().getConfiguration().orientation;
        long b = CommonUtils.m20708b() - CommonUtils.m20709b(r);
        long b2 = CommonUtils.m20710b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = CommonUtils.m20689a(r.getPackageName(), r);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = aiVar.f9961c;
        String str2 = this.f10043o.f9930b;
        String c2 = this.f10040l.m20736c();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(this.f10049u.mo1459a((StackTraceElement[]) entry.getValue()));
                i2++;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (CommonUtils.m20707a(r, "com.crashlytics.CollectCustomKeys", true)) {
            Map g = this.f10037i.m16403g();
            treeMap = (g == null || g.size() <= 1) ? g : new TreeMap(g);
        } else {
            treeMap = new TreeMap();
        }
        af.m16227a(codedOutputStream, time, str, aiVar, thread, stackTraceElementArr, threadArr, linkedList, treeMap, this.f10045q, a2, i, c2, str2, c, a, d, b, b2);
    }

    private void m16305a(File file, String str, int i) {
        boolean z;
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] a = m16319a(new C2915b(str + "SessionCrash"));
        boolean z2 = a != null && a.length > 0;
        C3969c.m20576h().mo2849a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] a2 = m16319a(new C2915b(str + "SessionEvent"));
        if (a2 == null || a2.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        C3969c.m20576h().mo2849a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            m16306a(file, str, m16320a(str, a2, i), z2 ? a[0] : null);
        } else {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "No events present for session ID " + str);
        }
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Removing session part files for ID " + str);
        m16308a(str);
    }

    private void m16306a(File file, String str, File[] fileArr, File file2) {
        Closeable c2894d;
        Throwable e;
        boolean z = file2 != null;
        File g = z ? m16359g() : m16360h();
        if (!g.exists()) {
            g.mkdirs();
        }
        try {
            c2894d = new C2894d(g, str);
            try {
                Flushable a = CodedOutputStream.m16122a((OutputStream) c2894d);
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                C2926g.m16296a((CodedOutputStream) a, file);
                a.m16149a(4, new Date().getTime() / 1000);
                a.m16151a(5, z);
                a.m16148a(11, 1);
                a.m16159b(12, 3);
                m16297a((CodedOutputStream) a, str);
                C2926g.m16299a((CodedOutputStream) a, fileArr, str);
                if (z) {
                    C2926g.m16296a((CodedOutputStream) a, file2);
                }
                CommonUtils.m20705a(a, "Error flushing session file stream");
                CommonUtils.m20704a(c2894d, "Failed to close CLS file");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    CommonUtils.m20705a(null, "Error flushing session file stream");
                    m16300a((C2894d) c2894d);
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m20705a(null, "Error flushing session file stream");
                    CommonUtils.m20704a(c2894d, "Failed to close CLS file");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c2894d = null;
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
            CommonUtils.m20705a(null, "Error flushing session file stream");
            m16300a((C2894d) c2894d);
        } catch (Throwable th2) {
            e = th2;
            c2894d = null;
            CommonUtils.m20705a(null, "Error flushing session file stream");
            CommonUtils.m20704a(c2894d, "Failed to close CLS file");
            throw e;
        }
    }

    private static void m16299a(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.f14119a);
        for (File name : fileArr) {
            try {
                C3969c.m20576h().mo2849a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                C2926g.m16296a(codedOutputStream, name);
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void m16297a(CodedOutputStream codedOutputStream, String str) {
        for (String str2 : f10035g) {
            File[] a = m16319a(new C2915b(str + str2));
            if (a.length == 0) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                C2926g.m16296a(codedOutputStream, a[0]);
            }
        }
    }

    private static void m16296a(CodedOutputStream codedOutputStream, File file) {
        Closeable fileInputStream;
        Throwable th;
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    C2926g.m16307a((InputStream) fileInputStream, codedOutputStream, (int) file.length());
                    CommonUtils.m20704a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.m20704a(fileInputStream, "Failed to close file input stream.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                CommonUtils.m20704a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        C3969c.m20576h().mo2857e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private static void m16307a(InputStream inputStream, CodedOutputStream codedOutputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = inputStream.read(bArr, i2, bArr.length - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        codedOutputStream.m16156a(bArr);
    }

    private ak m16335g(String str) {
        if (m16357e()) {
            return new ak(this.f10037i.m16404h(), this.f10037i.m16406j(), this.f10037i.m16405i());
        }
        return new C2957v(m16358f()).m16465a(str);
    }

    boolean m16357e() {
        return this.f10051w != null && this.f10051w.m16424a();
    }

    File m16358f() {
        return this.f10042n.mo2877a();
    }

    File m16359g() {
        return new File(m16358f(), "fatal-sessions");
    }

    File m16360h() {
        return new File(m16358f(), "nonfatal-sessions");
    }

    File m16361i() {
        return new File(m16358f(), "invalidClsFiles");
    }

    private boolean m16316a(C4072s c4072s) {
        if (c4072s == null || !c4072s.f14338d.f14308a || this.f10041m.m16173a()) {
            return false;
        }
        return true;
    }

    private C2945n m16336h(String str) {
        return new C2946o(this.f10037i, CommonUtils.m20711b(this.f10037i.m15970r(), "com.crashlytics.ApiEndpoint"), str, this.f10039k);
    }

    private void m16325b(C4072s c4072s) {
        if (c4072s == null) {
            C3969c.m20576h().mo2854d("CrashlyticsCore", "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context r = this.f10037i.m15970r();
        ae aeVar = new ae(this.f10043o.f9929a, m16336h(c4072s.f14335a.f14295d), this.f10046r, this.f10047s);
        for (File agVar : m16354b()) {
            this.f10038j.m16274a(new C2924h(r, new ag(agVar, f10034f), aeVar));
        }
    }

    private static void m16310a(String str, String str2) {
        C2837a c2837a = (C2837a) C3969c.m20567a(C2837a.class);
        if (c2837a == null) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Answers is not available");
        } else {
            c2837a.m16018a(new C4003a(str, str2));
        }
    }
}
