package com.crashlytics.android.core;

import android.content.Context;
import com.facebook.internal.NativeProtocol;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.util.Set;

class C2954t {
    private static final C2953b f10098a = new C2953b();
    private final Context f10099b;
    private final C2917a f10100c;
    private C2883r f10101d;

    public interface C2917a {
        File mo1469a();
    }

    private static final class C2953b implements C2883r {
        private C2953b() {
        }

        public void mo1456a(long j, String str) {
        }

        public C2891b mo1455a() {
            return null;
        }

        public void mo1457b() {
        }

        public void mo1458c() {
        }
    }

    C2954t(Context context, C2917a c2917a) {
        this(context, c2917a, null);
    }

    C2954t(Context context, C2917a c2917a, String str) {
        this.f10099b = context;
        this.f10100c = c2917a;
        this.f10101d = f10098a;
        m16455a(str);
    }

    final void m16455a(String str) {
        this.f10101d.mo1457b();
        this.f10101d = f10098a;
        if (str != null) {
            if (CommonUtils.m20707a(this.f10099b, "com.crashlytics.CollectCustomLogs", true)) {
                m16454a(m16451b(str), (int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            } else {
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
            }
        }
    }

    void m16453a(long j, String str) {
        this.f10101d.mo1456a(j, str);
    }

    C2891b m16452a() {
        return this.f10101d.mo1455a();
    }

    void m16457b() {
        this.f10101d.mo1458c();
    }

    void m16456a(Set<String> set) {
        File[] listFiles = this.f10100c.mo1469a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m16450a(file))) {
                    file.delete();
                }
            }
        }
    }

    void m16454a(File file, int i) {
        this.f10101d = new ab(file, i);
    }

    private File m16451b(String str) {
        return new File(this.f10100c.mo1469a(), "crashlytics-userlog-" + str + ".temp");
    }

    private String m16450a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring("crashlytics-userlog-".length(), lastIndexOf);
    }
}
