package com.bigroad.ttb.android.eobr.turbo;

import android.util.Log;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.C1181z;
import com.bigroad.shared.eobr.genx.C0981n;
import com.bigroad.shared.eobr.turbo.BusType;
import com.bigroad.shared.eobr.turbo.C1013j;
import com.bigroad.shared.eobr.turbo.TurboData;
import com.bigroad.shared.eobr.turbo.messages.C1052o;
import com.bigroad.shared.eobr.turbo.messages.C1053p;
import com.bigroad.shared.eobr.turbo.messages.C1055r;
import com.bigroad.shared.eobr.turbo.messages.C1057t;
import com.bigroad.shared.eobr.turbo.messages.GpsMessageType;
import com.bigroad.shared.eobr.turbo.messages.aa;
import com.bigroad.shared.eobr.turbo.messages.al;
import com.bigroad.shared.eobr.turbo.messages.am;
import com.bigroad.ttb.android.eobr.EobrWriter;
import com.bigroad.ttb.android.eobr.EobrWriter.BroadcastSetting;
import com.bigroad.ttb.android.p038g.C2078a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class C1962e extends EobrWriter {
    private final BlockingQueue<TurboData> f6792g = new LinkedBlockingQueue();

    public C1962e(C1960c c1960c, C2078a c2078a) {
        super(c1960c, c2078a);
    }

    private void m9679a(TurboData turboData) {
        if (!this.f) {
            try {
                this.f6792g.put(turboData);
            } catch (InterruptedException e) {
            }
        }
    }

    private C1960c m9680h() {
        return (C1960c) this.d;
    }

    protected void mo1151a(int i, boolean z) {
        int a = m9680h().m9650a(BusType.BUS_TYPE_J1939);
        if (a != -1) {
            m9680h().m9265a(new C1055r(m9680h().mo1143r(), a, z, i), null, false);
        }
    }

    protected void mo1159b(int i, boolean z) {
        m9680h().m9265a(new C1053p(m9680h().mo1143r(), z, i), null, false);
    }

    public void mo1155a(BroadcastSetting broadcastSetting) {
        Log.d("TT-TurboWriter", "Setting J1939 broadcast filters to " + broadcastSetting);
        for (Integer intValue : a) {
            boolean z;
            int intValue2 = intValue.intValue();
            if (broadcastSetting != BroadcastSetting.DISABLED) {
                z = true;
            } else {
                z = false;
            }
            if (broadcastSetting == BroadcastSetting.RESTRICTED) {
                if (b.contains(Integer.valueOf(intValue2))) {
                    z = false;
                } else {
                    z = true;
                }
            }
            mo1151a(intValue2, z);
        }
    }

    public void mo1160b(BroadcastSetting broadcastSetting) {
        Log.d("TT-TurboWriter", "Setting J1587 broadcast filters to " + broadcastSetting);
        for (Integer intValue : c) {
            mo1159b(intValue.intValue(), broadcastSetting != BroadcastSetting.DISABLED);
        }
    }

    protected void mo1150a(int i) {
        int a = m9680h().m9650a(BusType.BUS_TYPE_J1939);
        if (a != -1) {
            m9680h().m9265a(new C1057t(m9680h().mo1143r(), a, 6, i, -1), null, false);
        }
    }

    protected void mo1158b(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("J1587 PID request out of range: " + i);
        }
    }

    protected void mo1156a(short s) {
        int a = m9680h().m9650a(BusType.BUS_TYPE_OBD);
        if (a != -1) {
            m9680h().m9265a(new aa(m9680h().mo1143r(), a, 0, s >> 8, s & 255), null, false);
        }
    }

    public void mo1157b() {
    }

    public void mo1154a(C1098j c1098j) {
        Log.i("TT-TurboWriter", "Requesting VIN");
        if (c1098j == null || c1098j.m5443a(new C1098j("10.0.0")) < 0) {
            mo1150a(65260);
            mo1158b(237);
            mo1156a((short) 2306);
            return;
        }
        m9680h().m9265a(new am(m9680h().mo1143r()), null, true);
    }

    public void mo1153a(al alVar) {
        m9679a((TurboData) alVar);
    }

    public void mo1152a(C0981n c0981n) {
    }

    public void mo1161c(int i) {
        m9680h().m9265a(new C1052o(m9680h().mo1143r(), GpsMessageType.GPS_MESSAGE_TYPE_PVT, Math.max(0, i)), null, false);
    }

    public void run() {
        try {
            Closeable bufferedOutputStream = new BufferedOutputStream(this.e.mo1217b(), 256);
            C1013j c1013j = new C1013j(bufferedOutputStream);
            while (!this.f) {
                try {
                    TurboData turboData = (TurboData) this.f6792g.take();
                    if (turboData != null) {
                        c1013j.m5169a(turboData);
                    }
                } catch (InterruptedException e) {
                } catch (Throwable e2) {
                    throw new IOException(e2);
                } catch (Throwable e22) {
                    try {
                        Log.w("TT-TurboWriter", "IOException while processing output: ", e22);
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
            Log.e("TT-TurboWriter", "Exception creating OutputStream for writer", e222);
            this.f = true;
            this.d.m9294l();
        }
    }
}
