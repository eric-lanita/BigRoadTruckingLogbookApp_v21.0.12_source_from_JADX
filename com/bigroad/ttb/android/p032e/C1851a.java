package com.bigroad.ttb.android.p032e;

import android.content.Context;
import android.os.Handler;
import com.bigroad.shared.C1097i;
import com.bigroad.shared.C1145t;
import com.bigroad.shared.C1180y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1764c;
import com.bigroad.ttb.android.util.C2279b;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C1851a {
    private static C1851a f6294a;
    private final Runnable f6295b = new C18491(this);
    private final Handler f6296c = new Handler();
    private final C1790a f6297d = OurApplication.m6287i();
    private final File f6298e;
    private final Set<C1698a> f6299f = new HashSet();
    private Runnable f6300g = null;
    private ExecutorService f6301h = null;
    private boolean f6302i = false;
    private final C2279b f6303j = new C2279b(this.f6295b, 1000, 60000, 1.5f);

    public interface C1698a {
        void mo1047a();

        void mo1048b();
    }

    class C18491 implements Runnable {
        final /* synthetic */ C1851a f6291a;

        C18491(C1851a c1851a) {
            this.f6291a = c1851a;
        }

        public void run() {
            this.f6291a.m8928c();
        }
    }

    public static C1851a m8920a(Context context) {
        if (f6294a == null) {
            f6294a = new C1851a(context);
        }
        return f6294a;
    }

    public boolean m8935a() {
        return this.f6302i;
    }

    public File m8932a(String str) {
        return new File(this.f6298e, str);
    }

    public void m8933a(C1698a c1698a) {
        this.f6299f.add(c1698a);
    }

    private void m8926b() {
        if (!this.f6299f.isEmpty()) {
            for (C1698a c1698a : (C1698a[]) this.f6299f.toArray(new C1698a[this.f6299f.size()])) {
                if (this.f6302i) {
                    c1698a.mo1048b();
                } else {
                    c1698a.mo1047a();
                }
            }
        }
    }

    private C1851a(Context context) {
        this.f6298e = new File(context.getApplicationContext().getFilesDir(), "FileUploads");
        this.f6298e.mkdirs();
        m8931e();
        m8928c();
    }

    private void m8927b(C1852b c1852b) {
        this.f6300g = c1852b;
        if (this.f6301h == null) {
            this.f6301h = Executors.newSingleThreadExecutor();
        }
        this.f6301h.execute(c1852b);
    }

    public void m8934a(final C1852b c1852b) {
        this.f6296c.post(new Runnable(this) {
            final /* synthetic */ C1851a f6293b;

            public void run() {
                if (c1852b.m8942c()) {
                    this.f6293b.f6303j.m11190d();
                    this.f6293b.m8929c(c1852b);
                } else {
                    this.f6293b.f6303j.m11188b();
                }
                this.f6293b.f6300g = null;
                this.f6293b.m8928c();
            }
        });
    }

    private void m8928c() {
        if (this.f6300g == null && !this.f6303j.m11189c()) {
            boolean z;
            C1852b d = m8930d();
            while (d != null && !d.m8941b()) {
                m8929c(d);
                d = m8930d();
            }
            if (d == null) {
                z = false;
            } else {
                z = true;
                m8927b(d);
            }
            if (z != this.f6302i) {
                this.f6302i = z;
                m8926b();
            }
        }
    }

    private C1852b m8930d() {
        C1764c a = this.f6297d.m8716a();
        return a == null ? null : new C1852b(a, this);
    }

    private void m8929c(C1852b c1852b) {
        String a = c1852b.m8940a();
        this.f6297d.m8739a(a);
        File a2 = m8932a(a);
        if (a2 != null) {
            a2.delete();
        }
    }

    public byte[] m8936a(File file, String str) {
        try {
            byte[] a = C1097i.m5441a(file);
            String a2 = C1180y.m5990a(a);
            File a3 = m8932a(a2);
            try {
                C1145t.m5766a(file, a3);
                file.delete();
                this.f6297d.m8741a(a2, str);
                m8928c();
                return a;
            } catch (Throwable e) {
                C2134e.m10679c("TT-FileUploadQueue", "Could not copy file: " + file.getAbsolutePath() + " to " + a3.getAbsolutePath(), e);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    public boolean m8937b(File file, String str) {
        File a = m8932a(str);
        try {
            C1145t.m5766a(file, a);
            this.f6297d.m8741a(str, "image/png");
            m8928c();
            return true;
        } catch (Throwable e) {
            C2134e.m10681d("TT-FileUploadQueue", "Could not copy signature file: " + file.getAbsolutePath() + " to " + a.getAbsolutePath(), e);
            return false;
        }
    }

    private void m8924a(Set<String> set, File file) {
        if (file != null) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                C2134e.m10682e("TT-FileUploadQueue", "Unable to remove orphaned file uploads from non-directory: " + file.getAbsolutePath());
                return;
            }
            for (File file2 : listFiles) {
                if (!set.contains(file2.getName())) {
                    C2134e.m10678c("TT-FileUploadQueue", "Removing orphaned file upload: " + file2.getAbsolutePath());
                    file2.delete();
                }
            }
        }
    }

    private void m8931e() {
        List<C1764c> b = this.f6297d.m8751b();
        Set hashSet = new HashSet();
        for (C1764c b2 : b) {
            hashSet.add(b2.m8573b());
        }
        m8924a(hashSet, this.f6298e);
    }
}
