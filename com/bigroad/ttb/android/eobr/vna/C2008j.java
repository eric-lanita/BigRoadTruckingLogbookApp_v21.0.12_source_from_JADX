package com.bigroad.ttb.android.eobr.vna;

import android.util.Log;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.eobr.C0998i;
import com.bigroad.shared.eobr.OBD2AddressType;
import com.bigroad.shared.eobr.genx.C0981n;
import com.bigroad.shared.eobr.p025a.C0964a;
import com.bigroad.shared.eobr.p025a.C0966c;
import com.bigroad.shared.eobr.turbo.messages.al;
import com.bigroad.ttb.android.eobr.EobrWriter;
import com.bigroad.ttb.android.eobr.EobrWriter.BroadcastSetting;
import com.bigroad.ttb.android.p038g.C2078a;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class C2008j extends EobrWriter {
    private final BlockingQueue<C0964a> f6930g = new LinkedBlockingQueue();

    public C2008j(C1992b c1992b, C2078a c2078a) {
        super(c1992b, c2078a);
    }

    private void m9934a(C0964a c0964a) {
        if (!this.f) {
            try {
                this.f6930g.put(c0964a);
            } catch (InterruptedException e) {
            }
        }
    }

    protected void mo1151a(int i, boolean z) {
        m9934a(C0964a.m4943a((byte) 0, i));
        m9934a(C0964a.m4943a((byte) 1, i));
    }

    protected void mo1159b(int i, boolean z) {
        m9934a(C0964a.m4946a(i));
    }

    public void mo1155a(BroadcastSetting broadcastSetting) {
        Log.d("TT-VnaWriter", "Adding default VNA J1939 filters");
        mo1151a(65260, true);
        mo1151a(65248, true);
        mo1151a(65217, true);
        mo1151a(65265, true);
        mo1151a(65215, true);
        mo1151a(64965, true);
        mo1151a(65259, true);
        mo1151a(61444, true);
        mo1151a(65392, true);
    }

    public void mo1160b(BroadcastSetting broadcastSetting) {
        Log.d("TT-VnaWriter", "Adding default VNA J1587 filters");
        mo1159b(237, true);
        mo1159b(245, true);
        mo1159b(84, true);
        mo1159b(FacebookRequestErrorClassification.EC_INVALID_TOKEN, true);
    }

    protected void mo1150a(int i) {
        byte[] bArr = new byte[3];
        C0998i.m5110a(bArr, 0, i);
        m9934a(C0964a.m4944a((byte) 0, 59904, (byte) -1, (byte) -4, (byte) 6, bArr));
        m9934a(C0964a.m4944a((byte) 1, 59904, (byte) -1, (byte) -4, (byte) 6, bArr));
    }

    protected void mo1158b(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("J1587 PID request out of range: " + i);
        }
        m9934a(C0964a.m4945a((byte) -111, 0, (byte) 3, new byte[]{(byte) i}));
        m9934a(C0964a.m4945a((byte) -111, 128, (byte) 3, new byte[]{(byte) 0, (byte) i}));
    }

    protected void mo1156a(short s) {
        byte[] bArr = new byte[]{(byte) (s >> 8), (byte) s};
        OBD2AddressType s2 = ((C1992b) this.d).m9872s();
        if (s2 != null) {
            switch (s2) {
                case OBD2_11_BIT:
                    m9934a(C0964a.m4942a((byte) 0, (byte) 1, (byte) -15, (byte) 3, (byte) 119, bArr));
                    m9934a(C0964a.m4942a((byte) 1, (byte) 1, (byte) -15, (byte) 3, (byte) 119, bArr));
                    return;
                case OBD2_29_BIT:
                    m9934a(C0964a.m4942a((byte) 0, (byte) 51, (byte) -15, (byte) 6, (byte) -37, bArr));
                    m9934a(C0964a.m4942a((byte) 1, (byte) 51, (byte) -15, (byte) 6, (byte) -37, bArr));
                    return;
                default:
                    return;
            }
        }
    }

    public void mo1157b() {
        Log.d("TT-VnaWriter", "Requesting OBD2 Address Type");
        m9933a((byte) Ascii.EM);
    }

    public void mo1154a(C1098j c1098j) {
        mo1150a(65260);
        mo1158b(237);
        mo1156a((short) 2306);
    }

    public void mo1153a(al alVar) {
        throw new UnsupportedOperationException();
    }

    public void mo1152a(C0981n c0981n) {
        throw new UnsupportedOperationException();
    }

    public void mo1161c(int i) {
        throw new UnsupportedOperationException();
    }

    private void m9933a(byte b) {
        m9934a(C0964a.m4941a(b, (byte) 0));
        m9934a(C0964a.m4941a(b, (byte) 1));
    }

    void m9947h() {
        Log.d("TT-VnaWriter", "Issuing keep alive");
        mo1159b(84, true);
    }

    public void run() {
        try {
            C0966c c0966c = new C0966c(new BufferedOutputStream(this.e.mo1217b(), 256));
            while (!this.f) {
                try {
                    C0964a c0964a = (C0964a) this.f6930g.take();
                    if (c0964a != null) {
                        c0966c.m4963a(c0964a);
                    }
                } catch (InterruptedException e) {
                } catch (Throwable e2) {
                    throw new IOException(e2);
                } catch (Throwable e22) {
                    try {
                        Log.w("TT-VnaWriter", "IOException while processing output: ", e22);
                        this.d.m9294l();
                        return;
                    } finally {
                        this.f = true;
                    }
                }
            }
            this.f = true;
        } catch (Throwable e222) {
            Log.e("TT-VnaWriter", "Exception creating OutputStream for writer", e222);
            this.f = true;
            this.d.m9294l();
        }
    }
}
