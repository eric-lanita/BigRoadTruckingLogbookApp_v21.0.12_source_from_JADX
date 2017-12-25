package com.bigroad.ttb.android;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class C1729b extends Thread {
    private final Handler f5991a = new Handler(Looper.getMainLooper());
    private volatile int f5992b = 0;
    private volatile long f5993c = 0;
    private final Runnable f5994d = new C17241(this);

    class C17241 implements Runnable {
        final /* synthetic */ C1729b f5980a;

        C17241(C1729b c1729b) {
            this.f5980a = c1729b;
        }

        public void run() {
            this.f5980a.f5992b = (this.f5980a.f5992b + 1) % Integer.MAX_VALUE;
            this.f5980a.f5993c = SystemClock.elapsedRealtime();
        }
    }

    private static class C1726a {
        public long f5983a;
        public boolean f5984b;

        private C1726a() {
            this.f5983a = 0;
            this.f5984b = false;
        }
    }

    public void run() {
        C2134e.m10678c("TT-AnrWatchDog", "Starting ANR WatchDog");
        setName("ANR-WatchDog");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = -1;
        C1726a c1726a = null;
        while (!isInterrupted()) {
            if (c1726a == null) {
                i = this.f5992b;
                this.f5991a.post(this.f5994d);
            }
            try {
                Thread.sleep(5000);
                if (this.f5992b == i) {
                    if (c1726a == null) {
                        c1726a = new C1726a();
                    }
                    c1726a.f5983a = SystemClock.elapsedRealtime() - elapsedRealtime;
                    m8449a(c1726a);
                } else {
                    if (c1726a != null) {
                        c1726a.f5983a = this.f5993c - elapsedRealtime;
                        m8451b(c1726a);
                        c1726a = null;
                    }
                    if (this.f5993c > 0) {
                        elapsedRealtime = this.f5993c;
                    } else {
                        elapsedRealtime = SystemClock.elapsedRealtime();
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        C2134e.m10678c("TT-AnrWatchDog", "Stopping ANR WatchDog");
    }

    private void m8449a(C1726a c1726a) {
        boolean b = OurApplication.m6284f().m10450b();
        if (!c1726a.f5984b && !Debug.isDebuggerConnected()) {
            if ((b && c1726a.f5983a > 30000) || (!b && c1726a.f5983a > 10000)) {
                C2134e.m10670a(MobileAppDiagnosticFlags.LOG_ANRS, 5, "TT-AnrWatchDog", "ANR detected after " + c1726a.f5983a + "ms" + (b ? " (in background)" : ""));
                m8450a(true);
                c1726a.f5984b = true;
            }
        }
    }

    private void m8451b(C1726a c1726a) {
        boolean b = OurApplication.m6284f().m10450b();
        if (Debug.isDebuggerConnected()) {
            C2134e.m10670a(MobileAppDiagnosticFlags.LOG_ANRS, 4, "TT-AnrWatchDog", "ANR recovered after " + c1726a.f5983a + "ms (debugger connected)" + (b ? " (in background)" : ""));
        } else {
            C2134e.m10670a(MobileAppDiagnosticFlags.LOG_ANRS, 5, "TT-AnrWatchDog", "ANR recovered after " + c1726a.f5983a + "ms" + (b ? " (in background)" : ""));
        }
    }

    private void m8450a(boolean z) {
        final Thread thread = Looper.getMainLooper().getThread();
        Map treeMap = new TreeMap(new Comparator<Thread>(this) {
            final /* synthetic */ C1729b f5982b;

            public /* synthetic */ int compare(Object obj, Object obj2) {
                return m8433a((Thread) obj, (Thread) obj2);
            }

            public int m8433a(Thread thread, Thread thread2) {
                if (thread == thread2) {
                    return 0;
                }
                if (thread == thread) {
                    return 1;
                }
                if (thread2 == thread) {
                    return -1;
                }
                return thread2.getName().compareTo(thread.getName());
            }
        });
        for (Entry entry : Thread.getAllStackTraces().entrySet()) {
            if (!z || am.m4189a(((Thread) entry.getKey()).getName(), thread.getName())) {
                treeMap.put(entry.getKey(), entry.getValue());
                if (z) {
                    break;
                }
            }
        }
        for (Entry entry2 : treeMap.entrySet()) {
            Throwable th = new Throwable();
            th.setStackTrace((StackTraceElement[]) entry2.getValue());
            C2134e.m10671a(MobileAppDiagnosticFlags.LOG_ANRS, 3, "TT-AnrWatchDog", "Thread " + ((Thread) entry2.getKey()).getId() + " (" + ((Thread) entry2.getKey()).getName() + ")", th);
        }
        C2134e.m10666a();
    }
}
