package com.bigroad.ttb.android.eobr;

import android.os.Handler;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.C1181z;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.genx.C0986i;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage.FirmwareUpdateRequest;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;
import com.bigroad.shared.eobr.turbo.messages.ae;
import com.bigroad.ttb.android.ClockMonitor;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.C1902e.C1856a;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.model.C2178c;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.p038g.C2078a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class EobrDevice {
    protected C1902e f6340a;
    private final Handler f6341b;
    private final LocationTracker f6342c = OurApplication.m6302x();
    private final ClockMonitor f6343d = OurApplication.m6262S();
    private final boolean f6344e;
    private ConnectionState f6345f;
    private C1859a f6346g;
    private C1888d f6347h;
    private C1886c f6348i;
    private ExecutorService f6349j;
    private final C1206c f6350k = new C18551(this);
    private final C1856a f6351l = new C18572(this);

    class C18551 implements C1206c {
        final /* synthetic */ EobrDevice f6328a;

        C18551(EobrDevice eobrDevice) {
            this.f6328a = eobrDevice;
        }

        public void mo897a(C0972e c0972e, C0973f c0973f) {
            if ((c0972e instanceof ae) && (c0973f instanceof TurboResponseMessage) && ((TurboResponseMessage) c0973f).f3353e == TurboResponse.TURBO_RESPONSE_OK) {
                this.f6328a.m8999k();
            }
        }
    }

    class C18572 implements C1856a {
        final /* synthetic */ EobrDevice f6329a;

        C18572(EobrDevice eobrDevice) {
            this.f6329a = eobrDevice;
        }

        public void mo1072a(C1902e c1902e) {
            if (this.f6329a.f6340a == c1902e && this.f6329a.f6346g != null) {
                this.f6329a.f6346g.mo1083d(this.f6329a);
            }
        }

        public void mo1074b(C1902e c1902e) {
            if (this.f6329a.f6340a == c1902e && this.f6329a.f6346g != null) {
                this.f6329a.f6346g.mo1084e(this.f6329a);
            }
        }

        public void mo1075c(C1902e c1902e) {
            if (this.f6329a.f6340a == c1902e) {
                this.f6329a.m8999k();
            }
        }

        public void mo1073a(C1902e c1902e, C1051n c1051n, long j, long j2) {
            if (this.f6329a.f6340a == c1902e) {
                this.f6329a.f6342c.m10598a(c1051n, this.f6329a);
                this.f6329a.f6343d.m6098a(c1051n, j, j2);
            }
        }
    }

    public enum ConnectionState {
        NOT_CONNECTED,
        CONNECTING,
        CONNECTED
    }

    public enum EngineUseState {
        ENGINE_USE_UNKNOWN,
        ENGINE_ON,
        ENGINE_OFF
    }

    public interface C1859a {
        void mo1080a(EobrDevice eobrDevice);

        void mo1081b(EobrDevice eobrDevice);

        void mo1082c(EobrDevice eobrDevice);

        void mo1083d(EobrDevice eobrDevice);

        void mo1084e(EobrDevice eobrDevice);
    }

    protected abstract C1902e mo1117a(C2078a c2078a, C1856a c1856a);

    public abstract byte[] mo1120h();

    public abstract EobrType mo1121o();

    public abstract String mo1122w();

    public EobrDevice(C1888d c1888d, boolean z) {
        this.f6347h = c1888d;
        this.f6341b = new Handler();
        this.f6345f = ConnectionState.NOT_CONNECTED;
        this.f6344e = z;
    }

    private void m8974x() {
        if (this.f6348i != null) {
            this.f6348i = null;
            if (this.f6349j != null) {
                this.f6349j.shutdownNow();
                this.f6349j = null;
            }
        }
    }

    private void m8975y() {
        m8974x();
        if (this.f6349j == null) {
            this.f6349j = Executors.newSingleThreadExecutor();
        }
        this.f6348i = this.f6347h.mo1086a(this);
        this.f6349j.execute(this.f6348i);
    }

    public void m8987a(final C1886c c1886c) {
        this.f6341b.post(new Runnable(this) {
            final /* synthetic */ EobrDevice f6331b;

            public void run() {
                this.f6331b.m8972b(c1886c);
            }
        });
    }

    public String m8980a() {
        String b = m8989b();
        C1098j v = m9010v();
        if (b == null || v == null) {
            return null;
        }
        return String.format("%s v%s", new Object[]{b, v.toString()});
    }

    protected String m8989b() {
        return this.f6340a == null ? null : this.f6340a.mo1138c();
    }

    private void m8972b(C1886c c1886c) {
        C2078a a = c1886c.mo1085a();
        if (c1886c != this.f6348i) {
            C1181z.m5999a(a);
            return;
        }
        this.f6348i = null;
        m8976z();
        if (a != null) {
            this.f6340a = mo1117a(a, this.f6351l);
            this.f6345f = ConnectionState.CONNECTED;
            if (this.f6346g != null) {
                this.f6346g.mo1080a(this);
            }
        } else if (this.f6346g != null) {
            this.f6346g.mo1081b(this);
        }
    }

    private void m8976z() {
        m8974x();
        if (this.f6340a != null) {
            this.f6340a.close();
            this.f6340a = null;
        }
        this.f6345f = ConnectionState.NOT_CONNECTED;
    }

    public String m8991c() {
        return this.f6347h.mo1087a();
    }

    public byte[] m8992d() {
        return C1180y.m5994b(m8991c());
    }

    public String m8993e() {
        return this.f6347h.mo1088b();
    }

    public String mo1118f() {
        return C1180y.m5995c(m8991c());
    }

    public String mo1119g() {
        return "";
    }

    public ConnectionState m8997i() {
        return this.f6345f;
    }

    public void m8986a(C1859a c1859a) {
        this.f6346g = c1859a;
    }

    public void m8998j() {
        if (this.f6345f != ConnectionState.CONNECTING && this.f6345f != ConnectionState.CONNECTED) {
            m8976z();
            this.f6345f = ConnectionState.CONNECTING;
            m8975y();
        }
    }

    public void m8999k() {
        if (this.f6345f != ConnectionState.NOT_CONNECTED) {
            m8976z();
            if (this.f6346g != null) {
                this.f6346g.mo1082c(this);
            }
        }
    }

    public String m9000l() {
        return this.f6340a == null ? null : this.f6340a.m9288f();
    }

    public C2182e m9001m() {
        return this.f6340a == null ? null : this.f6340a.m9287e();
    }

    public C2178c m8979a(OdometerOffsets odometerOffsets) {
        C2182e m = m9001m();
        return m == null ? null : m.m10818a(odometerOffsets);
    }

    public long m9002n() {
        return this.f6340a == null ? 0 : this.f6340a.m9289g();
    }

    public long m9004p() {
        return this.f6340a == null ? 0 : this.f6340a.mo1124a();
    }

    public void m8982a(long j, C1206c c1206c) {
        if (this.f6340a != null) {
            this.f6340a.mo1126a(j, c1206c);
        }
    }

    public void m8984a(C0986i c0986i, C1206c c1206c) {
        if (this.f6340a != null) {
            this.f6340a.mo1129a(c0986i, c1206c);
        }
    }

    public void m8988a(byte[] bArr, C1206c c1206c) {
        if (this.f6340a != null) {
            this.f6340a.mo1134a(bArr, c1206c);
        }
    }

    public void m8990b(byte[] bArr, C1206c c1206c) {
        if (this.f6340a != null) {
            this.f6340a.mo1137b(bArr, c1206c);
        }
    }

    public void m8985a(FirmwareUpdateRequest firmwareUpdateRequest, byte[] bArr, C1206c c1206c) {
        if (this.f6340a != null) {
            this.f6340a.mo1130a(firmwareUpdateRequest, bArr, c1206c);
        }
    }

    public int m8977a(byte[] bArr, long j, long j2, int i) {
        if (this.f6340a != null) {
            return this.f6340a.mo1123a(bArr, j, j2, i);
        }
        return -1;
    }

    public void m8983a(long j, OdometerOffsets odometerOffsets) {
        if (this.f6340a != null) {
            this.f6340a.mo1127a(j, odometerOffsets);
        }
    }

    public void m9005q() {
        if (this.f6340a != null) {
            this.f6340a.m9292j();
        }
    }

    public void m9006r() {
        if (this.f6340a != null) {
            this.f6340a.mo1132a(this.f6350k);
        }
    }

    public boolean m9007s() {
        return this.f6344e;
    }

    public long m9008t() {
        return this.f6340a == null ? 0 : this.f6340a.m9290h();
    }

    public long m9009u() {
        return this.f6340a == null ? 0 : this.f6340a.m9291i();
    }

    public C1098j m9010v() {
        return this.f6340a == null ? null : this.f6340a.mo1135b();
    }

    public void m8981a(int i) {
        if (this.f6340a != null) {
            this.f6340a.m9258a(i);
        }
    }
}
