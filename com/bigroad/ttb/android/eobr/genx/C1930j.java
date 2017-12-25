package com.bigroad.ttb.android.eobr.genx;

import android.util.Log;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.C1181z;
import com.bigroad.shared.eobr.genx.C0981n;
import com.bigroad.shared.eobr.genx.C0996s;
import com.bigroad.shared.eobr.turbo.messages.al;
import com.bigroad.ttb.android.eobr.EobrWriter;
import com.bigroad.ttb.android.eobr.EobrWriter.BroadcastSetting;
import com.bigroad.ttb.android.p038g.C2078a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class C1930j extends EobrWriter {
    private final BlockingQueue<C0981n> f6654g = new LinkedBlockingQueue();

    public C1930j(C1919c c1919c, C2078a c2078a) {
        super(c1919c, c2078a);
    }

    private void m9485b(C0981n c0981n) {
        if (!this.f) {
            try {
                this.f6654g.put(c0981n);
            } catch (InterruptedException e) {
            }
        }
    }

    public void mo1157b() {
    }

    public void mo1161c(int i) {
    }

    protected void mo1159b(int i, boolean z) {
    }

    public void mo1160b(BroadcastSetting broadcastSetting) {
    }

    protected void mo1158b(int i) {
    }

    protected void mo1150a(int i) {
    }

    protected void mo1151a(int i, boolean z) {
    }

    public void mo1155a(BroadcastSetting broadcastSetting) {
    }

    protected void mo1156a(short s) {
    }

    public void mo1153a(al alVar) {
        throw new UnsupportedOperationException();
    }

    public void mo1152a(C0981n c0981n) {
        m9485b(c0981n);
    }

    public void mo1154a(C1098j c1098j) {
    }

    public void run() {
        try {
            Closeable bufferedOutputStream = new BufferedOutputStream(this.e.mo1217b(), 1024);
            C0996s c0996s = new C0996s(bufferedOutputStream);
            while (!this.f) {
                try {
                    C0981n c0981n = (C0981n) this.f6654g.take();
                    if (c0981n != null) {
                        c0996s.m5105a(c0981n);
                    }
                } catch (InterruptedException e) {
                } catch (Throwable e2) {
                    throw new IOException(e2);
                } catch (Throwable e22) {
                    try {
                        Log.w("TT-GenxWriter", "IOException while processing output: ", e22);
                        this.d.m9294l();
                        return;
                    } finally {
                        this.f = true;
                        C1181z.m5999a(bufferedOutputStream);
                    }
                }
            }
            this.f = true;
            C1181z.m5999a(bufferedOutputStream);
        } catch (Throwable e222) {
            Log.e("TT-GenxWriter", "Exception creating OutputStream for writer", e222);
            this.f = true;
            this.d.m9294l();
        }
    }
}
