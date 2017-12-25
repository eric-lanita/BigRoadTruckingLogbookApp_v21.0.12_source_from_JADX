package com.bigroad.ttb.android.eobr;

import android.util.Log;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.eobr.genx.C0981n;
import com.bigroad.shared.eobr.turbo.messages.al;
import com.bigroad.ttb.android.p038g.C2078a;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class EobrWriter extends Thread {
    protected static final List<Integer> f6506a = Collections.unmodifiableList(Arrays.asList(new Integer[]{Integer.valueOf(65260), Integer.valueOf(65248), Integer.valueOf(65217), Integer.valueOf(65265), Integer.valueOf(65215), Integer.valueOf(64965), Integer.valueOf(65259), Integer.valueOf(61444), Integer.valueOf(65392)}));
    protected static final List<Integer> f6507b = Collections.unmodifiableList(Arrays.asList(new Integer[]{Integer.valueOf(65265), Integer.valueOf(65215), Integer.valueOf(61444)}));
    protected static final List<Integer> f6508c = Collections.unmodifiableList(Arrays.asList(new Integer[]{Integer.valueOf(237), Integer.valueOf(245), Integer.valueOf(84), Integer.valueOf(FacebookRequestErrorClassification.EC_INVALID_TOKEN)}));
    protected final C1902e f6509d;
    protected final C2078a f6510e;
    protected volatile boolean f6511f = false;

    public enum BroadcastSetting {
        DISABLED,
        RESTRICTED,
        ENABLED
    }

    protected abstract void mo1150a(int i);

    protected abstract void mo1151a(int i, boolean z);

    public abstract void mo1152a(C0981n c0981n);

    public abstract void mo1153a(al alVar);

    public abstract void mo1154a(C1098j c1098j);

    public abstract void mo1155a(BroadcastSetting broadcastSetting);

    protected abstract void mo1156a(short s);

    public abstract void mo1157b();

    protected abstract void mo1158b(int i);

    protected abstract void mo1159b(int i, boolean z);

    public abstract void mo1160b(BroadcastSetting broadcastSetting);

    public abstract void mo1161c(int i);

    public EobrWriter(C1902e c1902e, C2078a c2078a) {
        super("Eobr-Writer");
        this.f6509d = c1902e;
        this.f6510e = c2078a;
    }

    public synchronized void m9197a() {
        if (!this.f6511f) {
            this.f6511f = true;
            interrupt();
        }
    }

    public void m9209c() {
        Log.d("TT-EobrWriter", "Requesting ECU ID");
        mo1150a(64965);
    }

    public void m9211d() {
        Log.d("TT-EobrWriter", "Requesting Component ID");
        mo1150a(65259);
        mo1158b(243);
    }

    public void m9212e() {
        mo1156a((short) 268);
    }

    public void m9213f() {
        mo1156a((short) 256);
    }

    public void m9214g() {
        mo1156a((short) 287);
    }
}
