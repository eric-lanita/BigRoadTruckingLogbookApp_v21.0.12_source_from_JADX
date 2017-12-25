package com.bigroad.ttb.android.eobr.turbo;

import android.bluetooth.BluetoothDevice;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.aj;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.genx.C0986i;
import com.bigroad.shared.eobr.turbo.BusType;
import com.bigroad.shared.eobr.turbo.C1006g;
import com.bigroad.shared.eobr.turbo.messages.C1042e;
import com.bigroad.shared.eobr.turbo.messages.C1043f;
import com.bigroad.shared.eobr.turbo.messages.C1044g;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.C1059v;
import com.bigroad.shared.eobr.turbo.messages.C1063z;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage.FirmwareUpdateRequest;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.ae;
import com.bigroad.shared.eobr.turbo.messages.al;
import com.bigroad.ttb.android.eobr.C1902e;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.C1902e.C1856a;
import com.bigroad.ttb.android.eobr.C1902e.C1901b;
import com.bigroad.ttb.android.eobr.EobrWriter.BroadcastSetting;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p038g.C2078a;
import com.bigroad.ttb.android.util.C2281d;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import java.util.Arrays;
import java.util.regex.Pattern;

public class C1960c extends C1902e {
    private static final C1098j f6785n = new C1098j("13.0.3");
    private static final Pattern f6786o = Pattern.compile("BigRoad-[0-9a-f]+|DashLink-[0-9A-F-]+");
    private final int[] f6787p = new int[BusType.values().length];
    private BroadcastSetting f6788q;
    private long f6789r;
    private C1098j f6790s;
    private String f6791t;

    public C1960c(C2078a c2078a, C1856a c1856a) {
        m9274a(c2078a, c1856a, new C1961d(this, c2078a), new C1962e(this, c2078a));
        this.f6788q = BroadcastSetting.RESTRICTED;
        Arrays.fill(this.f6787p, -1);
        m9296n();
    }

    public void close() {
        m9297o();
        super.close();
    }

    public static boolean m9639a(BluetoothDevice bluetoothDevice) {
        return f6786o.matcher(C2281d.m11194a(bluetoothDevice)).matches();
    }

    public long mo1124a() {
        return this.f6789r;
    }

    int m9650a(BusType busType) {
        return this.f6787p[busType.ordinal()];
    }

    void m9653a(final int i, final BusType busType) {
        this.a.post(new Runnable(this) {
            final /* synthetic */ C1960c f6776c;

            public void run() {
                Object obj;
                Object obj2 = null;
                if (busType.ordinal() >= this.f6776c.f6787p.length || this.f6776c.f6787p[busType.ordinal()] == i) {
                    obj = null;
                } else {
                    this.f6776c.f6787p[busType.ordinal()] = i;
                    obj = 1;
                }
                long b = this.f6776c.f6789r;
                switch (busType) {
                    case BUS_TYPE_J1939:
                        this.f6776c.f6789r = this.f6776c.f6789r | 1;
                        this.f6776c.e.mo1155a(this.f6776c.f6788q);
                        break;
                    case BUS_TYPE_J1708:
                        this.f6776c.f6789r = this.f6776c.f6789r | 2;
                        this.f6776c.e.mo1160b(this.f6776c.f6788q);
                        break;
                    case BUS_TYPE_OBD:
                        this.f6776c.f6789r = this.f6776c.f6789r | 4;
                        break;
                }
                if (!(obj == null && this.f6776c.f6789r == b)) {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    this.f6776c.b.mo1074b(this.f6776c);
                }
            }
        });
    }

    void m9660a(final C1042e c1042e) {
        this.a.post(new Runnable(this) {
            final /* synthetic */ C1960c f6778b;

            public void run() {
                if (this.f6778b.f6788q != BroadcastSetting.ENABLED) {
                    this.f6778b.f6790s = C1006g.m5171a(c1042e.f3424c, c1042e.f3425d);
                    this.f6778b.f6791t = c1042e.f3426e.m5200c();
                    if (this.f6778b.f6790s.m5443a(C1960c.f6785n) >= 0) {
                        this.f6778b.f6788q = BroadcastSetting.ENABLED;
                        if ((this.f6778b.f6789r & 1) != 0) {
                            this.f6778b.e.mo1155a(this.f6778b.f6788q);
                        }
                        if ((this.f6778b.f6789r & 2) != 0) {
                            this.f6778b.e.mo1160b(this.f6778b.f6788q);
                            return;
                        }
                        return;
                    }
                    C2134e.m10676b("TT-TurboDriver", "EobrWriter broadcast setting will not be set to fully enabled until the firmware version is at least " + C1960c.f6785n + ". Current version is: " + this.f6778b.f6790s + ".");
                }
            }
        });
    }

    public String mo1138c() {
        return this.f6791t;
    }

    public C1098j mo1135b() {
        return this.f6790s;
    }

    public void mo1126a(long j, C1206c c1206c) {
        m9282b(new C1059v(mo1143r(), (int) j), c1206c, Long.valueOf(m9298p() + 30000), true);
    }

    public void mo1129a(C0986i c0986i, C1206c c1206c) {
        throw new UnsupportedOperationException();
    }

    public void mo1134a(byte[] bArr, C1206c c1206c) {
        m9265a(new C1043f(mo1143r(), bArr), c1206c, false);
    }

    public void mo1137b(byte[] bArr, C1206c c1206c) {
        m9265a(new C1044g(mo1143r(), bArr), c1206c, false);
    }

    public void mo1130a(FirmwareUpdateRequest firmwareUpdateRequest, byte[] bArr, C1206c c1206c) {
        m9265a(new FirmwareUpdateRequestMessage(mo1143r(), firmwareUpdateRequest, bArr), c1206c, false);
    }

    public int mo1123a(byte[] bArr, long j, long j2, int i) {
        int b = aj.m4180b();
        m9265a(new C1063z(mo1143r(), bArr, j, j2, b, i), null, false);
        return b;
    }

    public void mo1127a(long j, OdometerOffsets odometerOffsets) {
        C0972e a = m9257a(mo1143r(), j, odometerOffsets);
        if (a != null) {
            m9265a(a, null, false);
        }
    }

    public void mo1132a(C1206c c1206c) {
        m9265a(new ae(mo1143r()), c1206c, true);
    }

    protected int mo1141m() {
        return 30;
    }

    protected void mo1131a(C1901b c1901b) {
        try {
            if (c1901b.m9237a() instanceof al) {
                this.e.mo1153a((al) c1901b.m9237a());
            }
            c1901b.m9239a(m9298p());
        } catch (Throwable th) {
            c1901b.m9239a(m9298p());
        }
    }

    public boolean mo1140d() {
        return true;
    }

    void m9659a(TurboResponseMessage turboResponseMessage) {
        m9266a((C0973f) turboResponseMessage);
    }

    void m9661a(C1051n c1051n, long j, long j2) {
        if (this.b != null) {
            final C1856a c1856a = this.b;
            final C1051n c1051n2 = c1051n;
            final long j3 = j;
            final long j4 = j2;
            this.a.post(new Runnable(this) {
                final /* synthetic */ C1960c f6783e;

                public void run() {
                    c1856a.mo1073a(this.f6783e, c1051n2, j3, j4);
                }
            });
        }
    }

    public void mo1133a(short s, long j) {
    }

    public void mo1125a(long j, long j2) {
    }

    protected long mo1142q() {
        return 5000;
    }
}
