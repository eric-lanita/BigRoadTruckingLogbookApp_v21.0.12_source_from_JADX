package com.crashlytics.android.core;

import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C2888h;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ae {
    static final Map<String, String> f9946a = Collections.singletonMap("X-CRASHLYTICS-INVALID-SESSION", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    private static final short[] f9947b = new short[]{(short) 10, (short) 20, (short) 30, (short) 60, (short) 120, (short) 300};
    private final Object f9948c = new Object();
    private final C2945n f9949d;
    private final String f9950e;
    private final C2887c f9951f;
    private final C2886b f9952g;
    private Thread f9953h;

    interface C2884d {
        boolean mo1460a();
    }

    static final class C2885a implements C2884d {
        C2885a() {
        }

        public boolean mo1460a() {
            return true;
        }
    }

    interface C2886b {
        boolean mo1473a();
    }

    interface C2887c {
        File[] mo1471a();

        File[] mo1472b();
    }

    private class C2889e extends C2888h {
        final /* synthetic */ ae f9943a;
        private final float f9944b;
        private final C2884d f9945c;

        C2889e(ae aeVar, float f, C2884d c2884d) {
            this.f9943a = aeVar;
            this.f9944b = f;
            this.f9945c = c2884d;
        }

        public void mo1461a() {
            try {
                m16202b();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "An unexpected error occurred while attempting to upload crash reports.", e);
            }
            this.f9943a.f9953h = null;
        }

        private void m16202b() {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Starting report processing in " + this.f9944b + " second(s)...");
            if (this.f9944b > 0.0f) {
                try {
                    Thread.sleep((long) (this.f9944b * 1000.0f));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            List<ad> a = this.f9943a.m16207a();
            if (!this.f9943a.f9952g.mo1473a()) {
                if (a.isEmpty() || this.f9945c.mo1460a()) {
                    List list = a;
                    int i = 0;
                    while (!r0.isEmpty() && !this.f9943a.f9952g.mo1473a()) {
                        C3969c.m20576h().mo2849a("CrashlyticsCore", "Attempting to send " + r0.size() + " report(s)");
                        for (ad a2 : r0) {
                            this.f9943a.m16209a(a2);
                        }
                        List a3 = this.f9943a.m16207a();
                        if (a3.isEmpty()) {
                            list = a3;
                        } else {
                            int i2 = i + 1;
                            long j = (long) ae.f9947b[Math.min(i, ae.f9947b.length - 1)];
                            C3969c.m20576h().mo2849a("CrashlyticsCore", "Report submisson: scheduling delayed retry in " + j + " seconds");
                            try {
                                Thread.sleep(j * 1000);
                                i = i2;
                                list = a3;
                            } catch (InterruptedException e2) {
                                Thread.currentThread().interrupt();
                                return;
                            }
                        }
                    }
                    return;
                }
                C3969c.m20576h().mo2849a("CrashlyticsCore", "User declined to send. Removing " + a.size() + " Report(s).");
                for (ad a22 : a) {
                    a22.mo1467f();
                }
            }
        }
    }

    public ae(String str, C2945n c2945n, C2887c c2887c, C2886b c2886b) {
        if (c2945n == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f9949d = c2945n;
        this.f9950e = str;
        this.f9951f = c2887c;
        this.f9952g = c2886b;
    }

    public synchronized void m16208a(float f, C2884d c2884d) {
        if (this.f9953h != null) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Report upload has already been started.");
        } else {
            this.f9953h = new Thread(new C2889e(this, f, c2884d), "Crashlytics Report Uploader");
            this.f9953h.start();
        }
    }

    boolean m16209a(ad adVar) {
        boolean z = false;
        synchronized (this.f9948c) {
            try {
                boolean a = this.f9949d.mo1486a(new C2944m(this.f9950e, adVar));
                C3969c.m20576h().mo2853c("CrashlyticsCore", "Crashlytics report upload " + (a ? "complete: " : "FAILED: ") + adVar.mo1463b());
                if (a) {
                    adVar.mo1467f();
                    z = true;
                }
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Error occurred sending report " + adVar, e);
            }
        }
        return z;
    }

    List<ad> m16207a() {
        String a;
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Checking for crash reports...");
        synchronized (this.f9948c) {
            File[] a2 = this.f9951f.mo1471a();
            File[] b = this.f9951f.mo1472b();
        }
        List<ad> linkedList = new LinkedList();
        if (a2 != null) {
            for (File file : a2) {
                C3969c.m20576h().mo2849a("CrashlyticsCore", "Found crash report " + file.getPath());
                linkedList.add(new ag(file));
            }
        }
        Map hashMap = new HashMap();
        if (b != null) {
            for (File file2 : b) {
                a = C2926g.m16295a(file2);
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, new LinkedList());
                }
                ((List) hashMap.get(a)).add(file2);
            }
        }
        for (String a3 : hashMap.keySet()) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Found invalid session: " + a3);
            List list = (List) hashMap.get(a3);
            linkedList.add(new C2951s(a3, (File[]) list.toArray(new File[list.size()])));
        }
        if (linkedList.isEmpty()) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "No reports found.");
        }
        return linkedList;
    }
}
