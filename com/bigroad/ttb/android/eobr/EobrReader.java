package com.bigroad.ttb.android.eobr;

import android.support.v4.p008d.C0281i;
import android.util.Log;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.C1181z;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.as;
import com.bigroad.shared.at;
import com.bigroad.shared.eobr.C0968a;
import com.bigroad.shared.eobr.C0974g;
import com.bigroad.shared.eobr.C0997h;
import com.bigroad.shared.eobr.C0998i;
import com.bigroad.shared.eobr.C0999j;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2182e.C2181a;
import com.bigroad.ttb.android.p038g.C2078a;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.common.base.Ascii;
import com.google.common.collect.EvictingQueue;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

public abstract class EobrReader extends Thread {
    private static final Pattern f6477e = Pattern.compile("\\*");
    private static final double f6478f = as.m4243b(119.5d);
    private static final long f6479g = as.m4242a(10000000);
    protected final C1902e f6480a;
    protected final C2078a f6481b;
    protected final C1903f f6482c = new C1903f();
    protected volatile boolean f6483d = false;
    private ap f6484h = OurApplication.m6269Z();
    private final C0281i<Long> f6485i = new C0281i();
    private final C0281i<Long> f6486j = new C0281i();
    private final C0281i<Long> f6487k = new C0281i();
    private final C0281i<Long> f6488l = new C0281i();
    private final C0281i<Long> f6489m = new C0281i();
    private final C0281i<Long> f6490n = new C0281i();
    private long f6491o = 0;
    private final C1885d f6492p = new C1885d();
    private final C1883b f6493q = new C1883b();
    private final C1884c f6494r = new C1884c();
    private final EvictingQueue<C1890b> f6495s = EvictingQueue.m18488a(5);
    private C1890b f6496t = C1890b.f6522b;
    private final C1882a f6497u = new C1882a();
    private long f6498v = 0;
    private long f6499w = 0;
    private long f6500x = 0;
    private long f6501y = 0;

    public enum VinPriority {
        VIN_PRIORITY_NONE,
        VIN_PRIORITY_OTHER,
        VIN_PRIORITY_J1708,
        VIN_PRIORITY_J1939_ENGINE,
        VIN_PRIORITY_OBD_ENGINE,
        VIN_PRIORITY_EOBR
    }

    private class C1882a {
        final /* synthetic */ EobrReader f6450a;
        private int f6451b;
        private int f6452c;
        private int f6453d;
        private long f6454e;
        private EngineUseState f6455f;

        private C1882a(EobrReader eobrReader) {
            this.f6450a = eobrReader;
            this.f6451b = -1;
            this.f6452c = -1;
            this.f6453d = -1;
            this.f6454e = 0;
            this.f6455f = EngineUseState.ENGINE_USE_UNKNOWN;
        }

        private int m9129a() {
            if (this.f6453d >= 0) {
                return this.f6453d;
            }
            if (this.f6452c >= 0) {
                return this.f6452c;
            }
            if (this.f6451b >= 0) {
                return this.f6451b;
            }
            return -1;
        }

        private void m9130b() {
            int a = m9129a();
            EngineUseState engineUseState = EngineUseState.ENGINE_USE_UNKNOWN;
            if (a > 0) {
                engineUseState = EngineUseState.ENGINE_ON;
            } else if (a == 0) {
                engineUseState = EngineUseState.ENGINE_OFF;
            }
            long c = this.f6450a.f6484h.mo915c();
            if (engineUseState != this.f6455f || c >= this.f6454e + 20000) {
                this.f6450a.f6480a.m9269a(engineUseState, c);
                this.f6455f = engineUseState;
                this.f6454e = c;
            }
        }

        public void m9131a(int i) {
            this.f6452c = i;
            m9130b();
        }

        public void m9132b(int i) {
            this.f6451b = i;
            m9130b();
        }

        public void m9133c(int i) {
            this.f6453d = i;
            m9130b();
        }
    }

    private class C1883b {
        final /* synthetic */ EobrReader f6456a;
        private final long[] f6457b;
        private final long[] f6458c;
        private long f6459d;

        private C1883b(EobrReader eobrReader) {
            this.f6456a = eobrReader;
            this.f6457b = new long[CanonicalOdometerSource.f3603l];
            this.f6458c = new long[CanonicalOdometerSource.f3603l];
            this.f6459d = 0;
        }

        private void m9134a() {
            long c = this.f6456a.f6484h.mo915c();
            if (c - this.f6459d >= 1000) {
                this.f6459d = c;
                long[] jArr = new long[CanonicalOdometerSource.f3603l];
                for (int i = 0; i < this.f6457b.length; i++) {
                    if (c - this.f6458c[i] < 60000) {
                        jArr[i] = this.f6457b[i];
                    }
                }
                this.f6456a.f6480a.m9275a(new C2181a(jArr).m10814a());
            }
        }

        private void m9135a(CanonicalOdometerSource canonicalOdometerSource, long j) {
            int ordinal = canonicalOdometerSource.ordinal();
            if (j >= this.f6457b[ordinal]) {
                this.f6457b[ordinal] = j;
                this.f6458c[ordinal] = this.f6456a.f6484h.mo915c();
                m9134a();
            }
        }

        public void m9136a(byte b, long j) {
            CanonicalOdometerSource canonicalOdometerSource;
            if (b == Byte.MIN_VALUE) {
                canonicalOdometerSource = CanonicalOdometerSource.J1587_MID128;
            } else if (b == (byte) -116) {
                canonicalOdometerSource = CanonicalOdometerSource.J1587_MID140;
            } else if (b == (byte) -114) {
                canonicalOdometerSource = CanonicalOdometerSource.J1587_MID142;
            } else {
                C2134e.m10678c("TT-EobrReader", "Unused J1587 TVD of " + j + " from mid=" + (b & 255));
                return;
            }
            m9135a(canonicalOdometerSource, j);
        }

        public void m9138b(byte b, long j) {
            CanonicalOdometerSource canonicalOdometerSource;
            if (b == (byte) 0) {
                canonicalOdometerSource = CanonicalOdometerSource.J1939_SRC0;
            } else if (b == Ascii.ETB) {
                canonicalOdometerSource = CanonicalOdometerSource.J1939_SRC23;
            } else {
                C2134e.m10678c("TT-EobrReader", "Unused J1939 TVD of " + j + " from src=" + (b & 255));
                return;
            }
            m9135a(canonicalOdometerSource, j);
        }

        public void m9140c(byte b, long j) {
            CanonicalOdometerSource canonicalOdometerSource;
            if (b == (byte) 0) {
                canonicalOdometerSource = CanonicalOdometerSource.J1939_HR_SRC0;
            } else if (b == Ascii.ETB) {
                canonicalOdometerSource = CanonicalOdometerSource.J1939_HR_SRC23;
            } else {
                C2134e.m10678c("TT-EobrReader", "Unused J1939 HRTVD of " + j + " from src=" + (b & 255));
                return;
            }
            m9135a(canonicalOdometerSource, j);
        }

        public void m9137a(long j) {
            m9135a(CanonicalOdometerSource.DASHLINK_FIRMWARE, j);
        }

        public void m9139b(long j) {
            m9135a(CanonicalOdometerSource.J1939_HINO_ODOMETER, j);
        }
    }

    private class C1884c {
        final /* synthetic */ EobrReader f6460a;
        private C1933i f6461b;
        private C1933i f6462c;
        private C1933i f6463d;
        private C1933i f6464e;
        private long f6465f;
        private float f6466g;

        private C1884c(EobrReader eobrReader) {
            this.f6460a = eobrReader;
            this.f6461b = new C1933i();
            this.f6462c = new C1933i();
            this.f6463d = new C1933i();
            this.f6464e = new C1933i();
            this.f6465f = 0;
            this.f6466g = C1890b.f6522b.m9226a();
        }

        private void m9142b() {
            this.f6461b.m9506a();
            this.f6462c.m9506a();
            this.f6463d.m9506a();
            this.f6464e.m9506a();
        }

        private C1890b m9143c() {
            C1890b b = this.f6463d.m9508b();
            C1890b b2 = this.f6462c.m9508b();
            C1890b b3 = this.f6461b.m9508b();
            C1890b b4 = this.f6464e.m9508b();
            C1890b c1890b = C1890b.f6521a;
            if (b4 == null || b4.m9226a() < 0.0f) {
                if (b != null && b.m9226a() >= 0.0f) {
                    b4 = b;
                } else if (b2 != null && b2.m9226a() >= 0.0f) {
                    b4 = b2;
                } else if (b3 == null || b3.m9226a() < 0.0f) {
                    b4 = c1890b;
                } else {
                    b4 = b3;
                }
            }
            return m9141a(b4);
        }

        private C1890b m9141a(C1890b c1890b) {
            synchronized (this.f6460a.f6495s) {
                if (c1890b != null) {
                    this.f6460a.f6495s.add(c1890b);
                }
                if (this.f6460a.f6495s.isEmpty()) {
                    C1890b c1890b2 = C1890b.f6522b;
                    return c1890b2;
                }
                c1890b2 = (C1890b) this.f6460a.f6495s.peek();
                Iterator it = this.f6460a.f6495s.iterator();
                C1890b c1890b3 = c1890b2;
                float f = 0.0f;
                C1890b c1890b4 = c1890b2;
                while (it.hasNext()) {
                    c1890b2 = (C1890b) it.next();
                    if (c1890b2.m9226a() < c1890b3.m9226a()) {
                        c1890b3 = c1890b2;
                    }
                    if (c1890b2.m9226a() > c1890b4.m9226a()) {
                        c1890b4 = c1890b2;
                    }
                    f = c1890b2.m9226a() + f;
                }
                this.f6460a.f6496t = new C1890b(f / 5.0f, c1890b3.m9228b(), c1890b4.m9229c());
                return this.f6460a.f6496t;
            }
        }

        private void m9144d() {
            long c = this.f6460a.f6484h.mo915c();
            this.f6460a.f6500x = c;
            if (c - this.f6465f >= 1000) {
                C1890b c2 = m9143c();
                this.f6465f = c;
                if (c2.m9226a() != this.f6466g) {
                    this.f6466g = c2.m9226a();
                    this.f6460a.f6480a.m9270a(c2.m9227a(as.m4241a(c2.m9226a())));
                }
            }
        }

        public void m9145a() {
            m9142b();
            this.f6466g = GroundOverlayOptions.NO_DIMENSION;
            this.f6465f = this.f6460a.f6484h.mo915c();
            this.f6460a.f6480a.m9270a(C1890b.f6523c);
        }

        public void m9146a(float f, EcmDiagnosticData ecmDiagnosticData) {
            this.f6461b.m9507a(f, ecmDiagnosticData);
            m9144d();
        }

        public void m9147b(float f, EcmDiagnosticData ecmDiagnosticData) {
            this.f6462c.m9507a(f, ecmDiagnosticData);
            m9144d();
        }

        public void m9148c(float f, EcmDiagnosticData ecmDiagnosticData) {
            this.f6463d.m9507a(f, ecmDiagnosticData);
            m9144d();
        }

        public void m9149d(float f, EcmDiagnosticData ecmDiagnosticData) {
            this.f6464e.m9507a(f, ecmDiagnosticData);
            m9144d();
        }
    }

    private class C1885d {
        final /* synthetic */ EobrReader f6467a;
        private boolean f6468b;
        private boolean f6469c;
        private boolean f6470d;
        private boolean f6471e;
        private String f6472f;
        private boolean f6473g;
        private VinPriority f6474h;
        private String f6475i;
        private at f6476j;

        private C1885d(EobrReader eobrReader) {
            this.f6467a = eobrReader;
            this.f6473g = false;
            this.f6474h = VinPriority.VIN_PRIORITY_NONE;
            this.f6476j = null;
        }

        private at m9151f() {
            return this.f6476j;
        }

        void m9152a(String str, VinPriority vinPriority) {
            if (str != null) {
                at atVar = new at(str);
                if (atVar.m4251a()) {
                    switch (vinPriority) {
                        case VIN_PRIORITY_J1708:
                            this.f6469c = true;
                            break;
                        case VIN_PRIORITY_J1939_ENGINE:
                            this.f6468b = true;
                            break;
                        case VIN_PRIORITY_OBD_ENGINE:
                            this.f6470d = true;
                            break;
                        case VIN_PRIORITY_EOBR:
                            this.f6471e = true;
                            break;
                    }
                }
                if (!this.f6473g || this.f6474h.ordinal() < vinPriority.ordinal()) {
                    boolean z;
                    String e = atVar.m4255e();
                    if (e.length() < 17) {
                        C2134e.m10676b("TT-EobrReader", "short VIN: " + e);
                        z = false;
                    } else {
                        z = atVar.m4254d();
                    }
                    if ((!this.f6473g && z) || (this.f6473g == z && vinPriority.ordinal() > this.f6474h.ordinal())) {
                        this.f6472f = e;
                        this.f6473g = z;
                        this.f6474h = vinPriority;
                        C2134e.m10676b("TT-EobrReader", this.f6472f + "; valid=" + this.f6473g);
                        if (!am.m4189a(this.f6475i, e)) {
                            this.f6475i = e;
                            this.f6476j = atVar;
                            this.f6467a.f6480a.mo1177a(e, z);
                            this.f6467a.mo1148b(e);
                        }
                    }
                }
            }
        }

        public boolean m9153a() {
            return this.f6468b;
        }

        public boolean m9154b() {
            return this.f6469c;
        }

        public boolean m9155c() {
            return this.f6470d;
        }

        public boolean m9156d() {
            return m9153a() && m9154b();
        }

        public boolean m9157e() {
            return this.f6471e;
        }
    }

    protected abstract void mo1144a(OdometerSource odometerSource, long j, long j2);

    protected abstract void mo1145a(SpeedometerSource speedometerSource, int i, int i2, long j);

    protected abstract void mo1146a(RpmSource rpmSource, int i);

    protected abstract void mo1147a(InputStream inputStream);

    protected abstract void mo1148b(String str);

    protected abstract void mo1149f();

    protected void m9190a(String str) {
        this.f6492p.m9152a(str, VinPriority.VIN_PRIORITY_EOBR);
    }

    protected EobrReader(C1902e c1902e, C2078a c2078a) {
        super("Eobr-Reader");
        this.f6480a = c1902e;
        this.f6481b = c2078a;
    }

    public void m9181a() {
        if (!this.f6483d) {
            this.f6483d = true;
            interrupt();
        }
    }

    public void m9191b() {
        synchronized (this.f6495s) {
            this.f6495s.clear();
            this.f6496t = C1890b.f6522b;
        }
    }

    protected void m9193c() {
        long c = this.f6484h.mo915c();
        if (this.f6500x != 0 && this.f6501y != this.f6500x && c - this.f6500x >= 15000 && this.f6496t.m9226a() > 0.0f) {
            C2134e.m10678c("TT-EobrReader", "No speedometer data detected, setting rolling average speed to zero");
            m9191b();
            this.f6501y = this.f6500x;
            this.f6494r.m9145a();
        }
    }

    private void m9171b(long j) {
        String str = "RXODO: " + j + " m";
        Log.v("TT-EobrReader", str);
        long c = this.f6484h.mo915c();
        if (this.f6491o == 0 || c - this.f6491o >= 60000) {
            C2134e.m10673a("TT-EobrReader", str);
            this.f6491o = c;
        }
    }

    private boolean m9165a(C0281i<Long> c0281i, int i, long j) {
        long c = this.f6484h.mo915c();
        Long l = (Long) c0281i.m1179a(i);
        if (l != null && c - l.longValue() < j) {
            return false;
        }
        c0281i.m1183b(i, Long.valueOf(c));
        return true;
    }

    private void m9163a(byte b, int i, String str) {
        String str2 = "RX1939 " + C0997h.m5108a(i) + " src=" + (b & 255) + ": " + str;
        C2134e.m10673a("TT-EobrReader", str2);
        if (m9179e(b, i)) {
            C2134e.m10673a("TT-EobrReader", str2);
        }
    }

    private void m9169b(byte b, int i, String str) {
        String str2 = "RX1587 " + C0974g.m4979a(i) + " mid=" + (b & 255) + ": " + str;
        C2134e.m10673a("TT-EobrReader", str2);
        if (m9180f(b, i)) {
            C2134e.m10673a("TT-EobrReader", str2);
        }
    }

    private void m9164a(byte b, short s, String str) {
        String str2 = "RXOBD2 " + C0999j.m5112a(s) + " src=" + (b & 255) + ": " + str;
        C2134e.m10673a("TT-EobrReader", str2);
        if (m9176c(b, s)) {
            C2134e.m10673a("TT-EobrReader", str2);
        }
    }

    private int m9158a(byte b, int i) {
        return ((b & 255) << 24) | (16777215 & i);
    }

    private int m9167b(byte b, int i) {
        return ((b & 255) << 24) | (16777215 & i);
    }

    private int m9159a(byte b, short s) {
        return ((b & 255) << 16) | (65535 & s);
    }

    private boolean m9175c(byte b, int i) {
        return m9165a(this.f6485i, m9158a(b, i), 1000);
    }

    private boolean m9178d(byte b, int i) {
        return m9165a(this.f6487k, m9167b(b, i), 1000);
    }

    private boolean m9172b(byte b, short s) {
        return m9165a(this.f6489m, m9159a(b, s), 1000);
    }

    private boolean m9179e(byte b, int i) {
        return m9165a(this.f6486j, m9158a(b, i), 60000);
    }

    private boolean m9180f(byte b, int i) {
        return m9165a(this.f6488l, m9167b(b, i), 60000);
    }

    private boolean m9176c(byte b, short s) {
        return m9165a(this.f6490n, m9159a(b, s), 60000);
    }

    private void m9174c(byte b, int i, String str) {
        if (m9175c(b, i)) {
            m9163a(b, i, str);
        }
    }

    private void m9177d(byte b, int i, String str) {
        if (m9178d(b, i)) {
            m9169b(b, i, str);
        }
    }

    private void m9170b(byte b, short s, String str) {
        if (m9172b(b, s)) {
            m9164a(b, s, str);
        }
    }

    protected void m9194d() {
        long c = this.f6484h.mo915c();
        if (c - this.f6499w >= 5000) {
            this.f6499w = c;
            this.f6480a.m9293k();
        }
    }

    protected void m9195e() {
        long j;
        if (this.f6492p.m9157e()) {
            j = 131072 | 0;
        } else if (this.f6492p.m9155c()) {
            j = 16384 | 0;
        } else if (this.f6492p.m9156d()) {
            j = 24 | 0;
        } else if (this.f6492p.m9153a()) {
            j = 8 | 0;
        } else if (this.f6492p.m9154b()) {
            j = 16 | 0;
        } else {
            j = 0 | 0;
        }
        if (this.f6498v != j) {
            this.f6498v = j;
            this.f6480a.m9259a(j);
        }
    }

    private static String[] m9166a(byte[] bArr, int i, int i2) {
        String[] split = f6477e.split(new String(bArr, i, i2, "ISO-8859-1"));
        for (int i3 = 0; i3 < split.length; i3++) {
            split[i3] = am.m4191b(split[i3]);
        }
        return split;
    }

    protected void m9184a(int i, byte b, byte[] bArr, int i2) {
        int length = bArr.length - i2;
        float f;
        OdometerSource odometerSource;
        long a;
        switch (i) {
            case 61444:
                if (length >= 8) {
                    length = C0998i.m5111b(bArr, i2 + 3);
                    if (length <= 64255 && b == (byte) 0) {
                        length /= 8;
                        m9174c(b, i, length + " rpm");
                        this.f6497u.m9131a(length);
                        mo1146a(RpmSource.RPM_SOURCE_J1939_ENGINE, length);
                        return;
                    }
                    return;
                }
                this.f6482c.m9307e();
                return;
            case 64965:
                try {
                    m9174c(b, i, Arrays.toString(m9166a(bArr, i2, length)));
                    return;
                } catch (Throwable e) {
                    C2134e.m10681d("TT-EobrReader", "Exception decoding ECU ID", e);
                    return;
                }
            case 65215:
                if (length >= 8) {
                    length = C0998i.m5111b(bArr, i2);
                    if (length <= 64255) {
                        f = ((float) length) / 256.0f;
                        m9174c(b, i, String.format("%.1f km/h", new Object[]{Float.valueOf(f)}));
                        if (((double) f) <= f6478f) {
                            this.f6494r.m9148c(f, EcmDiagnosticData.m8952b(b, i, length));
                            mo1145a(SpeedometerSource.SPEEDOMETER_SOURCE_J1939_WHEEL_AXLE_SPEED, (int) (1000.0f * f), (int) b, this.f6484h.mo915c());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f6482c.m9307e();
                return;
            case 65217:
                if (b == Ascii.ETB) {
                    odometerSource = OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_INSTRUMENT_CLUSTER;
                } else if (b == (byte) 0) {
                    odometerSource = OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_ENGINE_1;
                } else {
                    C2134e.m10680d("TT-EobrReader", "Unhandled distance source:" + b);
                    return;
                }
                if (length >= 8) {
                    a = C0998i.m5109a(bArr, i2);
                    if (a <= 4211081215L) {
                        a *= 5;
                        m9174c(b, i, Long.toString(a));
                        this.f6493q.m9140c(b, a);
                        mo1144a(odometerSource, a, this.f6484h.mo915c());
                        return;
                    }
                    return;
                }
                this.f6482c.m9307e();
                return;
            case 65248:
                if (b == (byte) 0 && this.f6492p.m9151f() != null && "FAKEDAFULA1V1N123".equals(this.f6492p.m9151f().m4255e())) {
                    C2134e.m10678c("TT-EobrReader", "Using fixed odometer value for Dafulai vehicle simulator");
                    this.f6493q.m9138b(b, 107000);
                    mo1144a(OdometerSource.ODOMETER_SOURCE_J1939_ENGINE_1, 107000, this.f6484h.mo915c());
                    return;
                }
                if (b == Ascii.ETB) {
                    odometerSource = OdometerSource.ODOMETER_SOURCE_J1939_INSTRUMENT_CLUSTER;
                } else if (b == (byte) 0) {
                    odometerSource = OdometerSource.ODOMETER_SOURCE_J1939_ENGINE_1;
                } else {
                    C2134e.m10680d("TT-EobrReader", "Unhandled distance source:" + b);
                    return;
                }
                if (length >= 8) {
                    a = C0998i.m5109a(bArr, i2 + 4);
                    if (a <= 4211081215L) {
                        a *= 125;
                        m9174c(b, i, Long.toString(a));
                        this.f6493q.m9138b(b, a);
                        mo1144a(odometerSource, a, this.f6484h.mo915c());
                        return;
                    }
                    return;
                }
                this.f6482c.m9307e();
                return;
            case 65259:
                try {
                    m9174c(b, i, Arrays.toString(m9166a(bArr, i2, length)));
                    return;
                } catch (Throwable e2) {
                    C2134e.m10681d("TT-EobrReader", "Exception decoding Component ID", e2);
                    return;
                }
            case 65260:
                try {
                    String str;
                    String[] a2 = m9166a(bArr, i2, length);
                    String str2 = a2.length > 0 ? a2[0] : null;
                    m9174c(b, i, str2);
                    if ("DafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiDafulaiCD.".equals(str2)) {
                        C2134e.m10678c("TT-EobrReader", "Dafulai vehicle simulator detected, overriding VIN and setting odometer");
                        str = "FAKEDAFULA1V1N123";
                    } else {
                        str = str2;
                    }
                    this.f6492p.m9152a(str, b == (byte) 0 ? VinPriority.VIN_PRIORITY_J1939_ENGINE : VinPriority.VIN_PRIORITY_OTHER);
                    return;
                } catch (Throwable e22) {
                    C2134e.m10681d("TT-EobrReader", "Exception decoding VIN", e22);
                    return;
                }
            case 65265:
                if (length >= 8) {
                    length = C0998i.m5111b(bArr, i2 + 1);
                    if (length <= 64255) {
                        f = ((float) length) / 256.0f;
                        m9174c(b, i, String.format("%.1f km/h", new Object[]{Float.valueOf(f)}));
                        if (((double) f) <= f6478f) {
                            this.f6494r.m9147b(f, EcmDiagnosticData.m8952b(b, i, length));
                            mo1145a(SpeedometerSource.SPEEDOMETER_SOURCE_J1939_CRUISE_CONTROL_SPEED, (int) (1000.0f * f), (int) b, this.f6484h.mo915c());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f6482c.m9307e();
                return;
            case 65392:
                if (length >= 8) {
                    long a3 = C0998i.m5109a(bArr, i2 + 3);
                    if (a3 <= 4211081215L) {
                        a = 100 * a3;
                        if (a <= f6479g) {
                            m9174c(b, i, Long.toString(a));
                            this.f6493q.m9139b(a);
                            mo1144a(OdometerSource.ODOMETER_SOURCE_J1939_HINO, a, this.f6484h.mo915c());
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f6482c.m9307e();
                return;
            default:
                m9174c(b, i, "data=" + C1180y.m5991a(bArr, i2));
                return;
        }
    }

    protected void m9182a(byte b, int i, byte[] bArr, int i2) {
        int length = bArr.length - i2;
        int b2;
        switch (i) {
            case 84:
                if (length >= 1) {
                    double b3 = as.m4243b(((double) (bArr[i2] & 255)) * 0.5d);
                    String str = "%.1f km/h%s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Double.valueOf(b3);
                    objArr[1] = b == (byte) -119 ? ", ignored" : "";
                    m9177d(b, i, String.format(str, objArr));
                    if (b3 <= f6478f && b != (byte) -119) {
                        this.f6494r.m9146a((float) b3, EcmDiagnosticData.m8951a(b, i, bArr[i2] & 255));
                        mo1145a(SpeedometerSource.SPEEDOMETER_SOURCE_J1587_ROAD_SPEED, (int) (1000.0d * b3), (int) b, this.f6484h.mo915c());
                        return;
                    }
                    return;
                }
                this.f6482c.m9307e();
                return;
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /*190*/:
                if (length < 2) {
                    this.f6482c.m9307e();
                    return;
                }
                b2 = C0998i.m5111b(bArr, i2) / 4;
                this.f6497u.m9132b(b2);
                mo1146a(RpmSource.RPM_SOURCE_J1587_ENGINE, b2);
                m9177d(b, i, Integer.toString(b2));
                return;
            case 237:
                if (length < 1) {
                    this.f6482c.m9307e();
                    return;
                }
                b2 = bArr[i2] & 255;
                if (b2 >= 32) {
                    b2 = length;
                } else if (b2 > length - 1) {
                    this.f6482c.m9307e();
                    return;
                } else {
                    i2++;
                }
                try {
                    String[] a = m9166a(bArr, i2, b2);
                    String str2 = a.length > 0 ? a[0] : null;
                    m9177d(b, i, str2);
                    this.f6492p.m9152a(str2, VinPriority.VIN_PRIORITY_J1708);
                    return;
                } catch (Throwable e) {
                    C2134e.m10681d("TT-EobrReader", "Exception decoding VIN", e);
                    return;
                }
            case 243:
                if (length < 2) {
                    this.f6482c.m9307e();
                    return;
                }
                try {
                    m9177d(b, i, Arrays.toString(m9166a(bArr, i2 + 2, length - 2)));
                    return;
                } catch (Throwable e2) {
                    C2134e.m10681d("TT-EobrReader", "Exception decoding Component ID", e2);
                    return;
                }
            case 245:
                if (length < 4) {
                    this.f6482c.m9307e();
                    return;
                }
                if (length > 4) {
                    i2++;
                }
                long a2 = C0998i.m5109a(bArr, i2);
                long a3 = as.m4242a(a2) / 10;
                m9177d(b, i, Long.toString(a3));
                if (a2 != 4294967295L) {
                    OdometerSource odometerSource;
                    this.f6493q.m9136a(b, a3);
                    if (b == Byte.MIN_VALUE) {
                        odometerSource = OdometerSource.ODOMETER_SOURCE_J1587_ENGINE_1;
                    } else if (b == (byte) -116) {
                        odometerSource = OdometerSource.ODOMETER_SOURCE_J1587_INSTRUMENT_CLUSTER;
                    } else if (b == (byte) -114) {
                        odometerSource = OdometerSource.ODOMETER_SOURCE_J1587_VEHICLE_MANAGEMENT_SYSTEM;
                    } else {
                        C2134e.m10678c("TT-EobrReader", "Could not handle odometer value from J1587 mid=" + (b & 255));
                        return;
                    }
                    mo1144a(odometerSource, a3, this.f6484h.mo915c());
                    return;
                }
                return;
            default:
                m9177d(b, i, "data=" + C1180y.m5991a(bArr, i2));
                return;
        }
    }

    protected void m9183a(byte b, short s, byte[] bArr, int i) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, bArr.length);
        long a;
        int d;
        switch (s) {
            case (short) 16640:
                if (copyOfRange.length < 4) {
                    this.f6482c.m9305c();
                    return;
                }
                a = C0968a.m4965a(copyOfRange, 0);
                m9170b(b, s, Long.toHexString(a));
                this.f6480a.mo1133a(s, a);
                return;
            case (short) 16652:
                if (copyOfRange.length < 2) {
                    this.f6482c.m9305c();
                    return;
                }
                d = C0968a.m4970d(copyOfRange, 0) / 4;
                m9170b(b, s, Integer.toString(d) + " rpm");
                this.f6497u.m9133c(d);
                mo1146a(RpmSource.RPM_SOURCE_OBD_ENGINE, d);
                return;
            case (short) 16653:
                if (copyOfRange.length < 1) {
                    this.f6482c.m9305c();
                    return;
                }
                d = copyOfRange[0] & 255;
                m9170b(b, s, Integer.toString(d) + " km/h");
                if (((double) d) <= f6478f) {
                    this.f6494r.m9149d((float) d, EcmDiagnosticData.m8953c(b, s, d));
                    mo1145a(SpeedometerSource.SPEEDOMETER_SOURCE_OBD_VEHICLE_SPEED, d * 1000, (int) b, this.f6484h.mo915c());
                    return;
                }
                return;
            case (short) 16671:
                if (copyOfRange.length < 2) {
                    this.f6482c.m9305c();
                    return;
                }
                a = (long) C0968a.m4970d(copyOfRange, 0);
                long c = this.f6484h.mo915c();
                m9170b(b, s, Long.toString(a) + " (" + c + ")");
                this.f6480a.mo1125a(a, c);
                return;
            case (short) 18690:
                if (copyOfRange.length < 1) {
                    this.f6482c.m9305c();
                    return;
                }
                try {
                    String[] a2 = m9166a(copyOfRange, 0, copyOfRange.length);
                    String str = a2.length > 0 ? a2[0] : null;
                    if ("DAFULAIELECTRONIC".equals(str)) {
                        C2134e.m10678c("TT-EobrReader", "Dafulai vehicle simulator detected, overriding VIN");
                        str = "FAKEDAFULA1V1N123";
                    }
                    m9170b(b, s, str);
                    VinPriority vinPriority = (b == (byte) 1 || b == Ascii.DLE) ? VinPriority.VIN_PRIORITY_OBD_ENGINE : VinPriority.VIN_PRIORITY_OTHER;
                    this.f6492p.m9152a(str, vinPriority);
                    return;
                } catch (Throwable e) {
                    C2134e.m10681d("TT-EobrReader", "Exception decoding VIN", e);
                    return;
                }
            default:
                m9170b(b, s, "data=" + C1180y.m5990a(copyOfRange));
                return;
        }
    }

    protected void m9185a(long j) {
        long max = Math.max(j, 1);
        m9171b(max);
        this.f6493q.m9137a(max);
        mo1144a(OdometerSource.ODOMETER_SOURCE_DASHLINK_FIRMWARE, max, this.f6484h.mo915c());
    }

    public void run() {
        Closeable bufferedInputStream;
        Throwable e;
        try {
            bufferedInputStream = new BufferedInputStream(this.f6481b.mo1216a(), 256);
            try {
                mo1147a((InputStream) bufferedInputStream);
                this.f6483d = true;
                C1181z.m5999a(bufferedInputStream);
                this.f6480a.m9294l();
                mo1149f();
            } catch (IOException e2) {
                e = e2;
                try {
                    if (!this.f6483d) {
                        C2134e.m10679c("TT-EobrReader", "Unexpected IOException while processing input: ", e);
                    }
                    this.f6483d = true;
                    C1181z.m5999a(bufferedInputStream);
                    this.f6480a.m9294l();
                    mo1149f();
                } catch (Throwable th) {
                    e = th;
                    this.f6483d = true;
                    C1181z.m5999a(bufferedInputStream);
                    this.f6480a.m9294l();
                    mo1149f();
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            bufferedInputStream = null;
            if (this.f6483d) {
                C2134e.m10679c("TT-EobrReader", "Unexpected IOException while processing input: ", e);
            }
            this.f6483d = true;
            C1181z.m5999a(bufferedInputStream);
            this.f6480a.m9294l();
            mo1149f();
        } catch (Throwable th2) {
            e = th2;
            bufferedInputStream = null;
            this.f6483d = true;
            C1181z.m5999a(bufferedInputStream);
            this.f6480a.m9294l();
            mo1149f();
            throw e;
        }
    }
}
