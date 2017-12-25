package io.fabric.sdk.android.services.common;

import android.os.SystemClock;
import android.util.Log;

public class C4017q {
    private final String f14189a;
    private final String f14190b;
    private final boolean f14191c;
    private long f14192d;
    private long f14193e;

    public C4017q(String str, String str2) {
        this.f14189a = str;
        this.f14190b = str2;
        this.f14191c = !Log.isLoggable(str2, 2);
    }

    public synchronized void m20818a() {
        if (!this.f14191c) {
            this.f14192d = SystemClock.elapsedRealtime();
            this.f14193e = 0;
        }
    }

    public synchronized void m20819b() {
        if (!this.f14191c) {
            if (this.f14193e == 0) {
                this.f14193e = SystemClock.elapsedRealtime() - this.f14192d;
                m20817c();
            }
        }
    }

    private void m20817c() {
        Log.v(this.f14190b, this.f14189a + ": " + this.f14193e + "ms");
    }
}
