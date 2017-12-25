package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.eobr.turbo.hardware.AccelerometerType;
import com.bigroad.shared.eobr.turbo.hardware.BluetoothType;
import com.bigroad.shared.eobr.turbo.hardware.BoardType;
import com.bigroad.shared.eobr.turbo.hardware.FlashType;
import com.bigroad.shared.eobr.turbo.hardware.GpsType;
import com.bigroad.shared.eobr.turbo.hardware.McuType;
import com.bigroad.shared.eobr.turbo.logs.C1020a;
import com.bigroad.shared.eobr.turbo.logs.C1021r;
import com.bigroad.shared.eobr.turbo.logs.C1022b;
import com.bigroad.shared.eobr.turbo.logs.C1023c;
import com.bigroad.shared.eobr.turbo.logs.C1025e;
import com.bigroad.shared.eobr.turbo.logs.C1026f;
import com.bigroad.shared.eobr.turbo.logs.C1027g;
import com.bigroad.shared.eobr.turbo.logs.C1028h;
import com.bigroad.shared.eobr.turbo.logs.C1029i;
import com.bigroad.shared.eobr.turbo.logs.C1030j;
import com.bigroad.shared.eobr.turbo.logs.C1031k;
import com.bigroad.shared.eobr.turbo.logs.C1032l;
import com.bigroad.shared.eobr.turbo.logs.C1033m;
import com.bigroad.shared.eobr.turbo.logs.C1034n;
import com.bigroad.shared.eobr.turbo.logs.C1035q;
import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.shared.eobr.turbo.logs.C1037t;
import com.bigroad.shared.eobr.turbo.logs.EngineHoursLogEntry;
import com.bigroad.shared.eobr.turbo.logs.EngineHoursLogEntry.EngineHoursSource;
import com.bigroad.shared.eobr.turbo.logs.LogworthyLogEntry;
import com.bigroad.shared.eobr.turbo.logs.LogworthyLogEntry.LogworthyReason;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry.MobileClientSessionState;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.logs.PowerLogEntry;
import com.bigroad.shared.eobr.turbo.logs.PowerLogEntry.PowerLogReason;
import com.bigroad.shared.eobr.turbo.messages.C1038a;
import com.bigroad.shared.eobr.turbo.messages.C1039b;
import com.bigroad.shared.eobr.turbo.messages.C1040c;
import com.bigroad.shared.eobr.turbo.messages.C1041d;
import com.bigroad.shared.eobr.turbo.messages.C1042e;
import com.bigroad.shared.eobr.turbo.messages.C1043f;
import com.bigroad.shared.eobr.turbo.messages.C1044g;
import com.bigroad.shared.eobr.turbo.messages.C1045h;
import com.bigroad.shared.eobr.turbo.messages.C1046i;
import com.bigroad.shared.eobr.turbo.messages.C1047j;
import com.bigroad.shared.eobr.turbo.messages.C1048k;
import com.bigroad.shared.eobr.turbo.messages.C1050m;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.C1052o;
import com.bigroad.shared.eobr.turbo.messages.C1053p;
import com.bigroad.shared.eobr.turbo.messages.C1054q;
import com.bigroad.shared.eobr.turbo.messages.C1055r;
import com.bigroad.shared.eobr.turbo.messages.C1056s;
import com.bigroad.shared.eobr.turbo.messages.C1057t;
import com.bigroad.shared.eobr.turbo.messages.C1058u;
import com.bigroad.shared.eobr.turbo.messages.C1059v;
import com.bigroad.shared.eobr.turbo.messages.C1060w;
import com.bigroad.shared.eobr.turbo.messages.C1061x;
import com.bigroad.shared.eobr.turbo.messages.C1062y;
import com.bigroad.shared.eobr.turbo.messages.C1063z;
import com.bigroad.shared.eobr.turbo.messages.DataRegister;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage.FirmwareUpdateRequest;
import com.bigroad.shared.eobr.turbo.messages.GpsMessageType;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;
import com.bigroad.shared.eobr.turbo.messages.TestLoopbackMessage;
import com.bigroad.shared.eobr.turbo.messages.TestLoopbackMessage.TestLoopbackEnum;
import com.bigroad.shared.eobr.turbo.messages.TestRequestMessage;
import com.bigroad.shared.eobr.turbo.messages.TestRequestMessage.TestType;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;
import com.bigroad.shared.eobr.turbo.messages.TurboSignedRequestMessage.MessageSigner;
import com.bigroad.shared.eobr.turbo.messages.UsbStatusMessage;
import com.bigroad.shared.eobr.turbo.messages.UsbStatusMessage.UsbStatus;
import com.bigroad.shared.eobr.turbo.messages.ValueRegister;
import com.bigroad.shared.eobr.turbo.messages.aa;
import com.bigroad.shared.eobr.turbo.messages.ab;
import com.bigroad.shared.eobr.turbo.messages.ac;
import com.bigroad.shared.eobr.turbo.messages.ad;
import com.bigroad.shared.eobr.turbo.messages.ae;
import com.bigroad.shared.eobr.turbo.messages.af;
import com.bigroad.shared.eobr.turbo.messages.ag;
import com.bigroad.shared.eobr.turbo.messages.ah;
import com.bigroad.shared.eobr.turbo.messages.ai;
import com.bigroad.shared.eobr.turbo.messages.am;
import com.bigroad.shared.eobr.turbo.messages.an;
import java.io.InputStream;

abstract class C1004e {
    protected InputStream f3143a;

    protected abstract TurboData mo762a(int i, TurboData turboData);

    protected abstract void mo763a();

    protected abstract void mo764a(int i);

    C1004e() {
    }

    private int mo765c() {
        return C1014k.m5223a(this.f3143a);
    }

    private int[] m5139d() {
        int c = mo765c();
        mo764a(c);
        int[] iArr = new int[c];
        for (int i = 0; i < c; i++) {
            iArr[i] = mo765c();
        }
        return iArr;
    }

    private long m5140e() {
        return C1014k.m5226b(this.f3143a);
    }

    private long[] m5141f() {
        int c = mo765c();
        mo764a(c);
        long[] jArr = new long[c];
        for (int i = 0; i < c; i++) {
            jArr[i] = m5140e();
        }
        return jArr;
    }

    private int m5142g() {
        return C1001a.m5125a(this.f3143a);
    }

    private int[] m5143h() {
        int c = mo765c();
        mo764a(c);
        int[] iArr = new int[c];
        for (int i = 0; i < c; i++) {
            iArr[i] = m5142g();
        }
        return iArr;
    }

    private long m5144i() {
        return C1001a.m5128b(this.f3143a);
    }

    private long[] m5145j() {
        int c = mo765c();
        mo764a(c);
        long[] jArr = new long[c];
        for (int i = 0; i < c; i++) {
            jArr[i] = m5144i();
        }
        return jArr;
    }

    private C1000c m5136a(C1000c[] c1000cArr) {
        return TurboData.m5121a(c1000cArr, mo765c());
    }

    private C1000c[] m5137b(C1000c[] c1000cArr) {
        int c = mo765c();
        mo764a(c);
        C1000c[] c1000cArr2 = new C1000c[c];
        for (int i = 0; i < c; i++) {
            c1000cArr2[i] = m5136a(c1000cArr);
        }
        return c1000cArr2;
    }

    private boolean m5146k() {
        return this.f3143a.read() != 0;
    }

    private boolean[] m5147l() {
        int c = mo765c();
        mo764a(c);
        boolean[] zArr = new boolean[c];
        for (int i = 0; i < c; i++) {
            boolean z;
            if (this.f3143a.read() != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
        }
        return zArr;
    }

    private byte[] m5148m() {
        int c = mo765c();
        mo764a(c);
        byte[] bArr = new byte[c];
        for (int i = 0; i < c; i++) {
            bArr[i] = (byte) this.f3143a.read();
        }
        return bArr;
    }

    public final synchronized TurboData m5152b() {
        TurboData turboData;
        int c;
        mo763a();
        turboData = null;
        c = mo765c();
        int g;
        long i;
        Object b;
        int[] d;
        Object obj;
        switch (c) {
            case 0:
                boolean k = m5146k();
                int c2 = mo765c();
                long e = m5140e();
                g = m5142g();
                i = m5144i();
                TestLoopbackEnum testLoopbackEnum = (TestLoopbackEnum) m5136a(TestLoopbackEnum.values());
                boolean[] l = m5147l();
                byte[] m = m5148m();
                int[] d2 = m5139d();
                int[] h = m5143h();
                long[] f = m5141f();
                long[] j = m5145j();
                b = m5137b(TestLoopbackEnum.values());
                Object obj2 = new TestLoopbackEnum[b.length];
                System.arraycopy(b, 0, obj2, 0, b.length);
                turboData = new TestLoopbackMessage(k, c2, e, g, i, testLoopbackEnum, l, m, d2, h, f, j, obj2);
                break;
            case 1:
                turboData = new ai(mo765c(), m5148m());
                break;
            case 2:
                turboData = new TurboResponseMessage(mo765c(), (TurboResponse) m5136a(TurboResponse.values()));
                break;
            case 3:
                turboData = new C1039b(mo765c(), mo765c(), m5146k(), mo765c(), mo765c());
                break;
            case 4:
                turboData = new C1040c(mo765c(), mo765c(), m5146k(), m5148m());
                break;
            case 5:
                turboData = new C1055r(mo765c(), mo765c(), m5146k(), mo765c());
                break;
            case 6:
                turboData = new C1056s(mo765c(), mo765c(), mo765c(), mo765c(), m5148m());
                break;
            case 7:
                turboData = new C1057t(mo765c(), mo765c(), mo765c(), mo765c(), mo765c());
                break;
            case 8:
                turboData = new aa(mo765c(), mo765c(), mo765c(), mo765c(), mo765c());
                break;
            case 9:
                turboData = new ab(mo765c(), mo765c(), mo765c(), mo765c(), m5148m());
                break;
            case 12:
                turboData = new C1038a((BusType) m5136a(BusType.values()), mo765c(), mo765c());
                break;
            case 13:
                turboData = new FirmwareUpdateRequestMessage(mo765c(), (FirmwareUpdateRequest) m5136a(FirmwareUpdateRequest.values()), m5148m());
                break;
            case 14:
                turboData = new ad(mo765c());
                break;
            case 15:
                turboData = new C1052o(mo765c(), (GpsMessageType) m5136a(GpsMessageType.values()), mo765c());
                break;
            case 16:
                turboData = new C1050m((GpsMessageType) m5136a(GpsMessageType.values()), new String(m5148m(), "UTF-8"));
                break;
            case 17:
                turboData = new C1053p(mo765c(), m5146k(), mo765c());
                break;
            case 18:
                turboData = new C1054q(mo765c(), mo765c(), mo765c(), m5148m());
                break;
            case 19:
                turboData = new C1035q(mo765c(), mo765c(), mo765c());
                break;
            case 20:
                turboData = new C1034n(mo765c(), m5140e());
                break;
            case 22:
                turboData = new C1042e(mo765c(), mo765c(), mo765c(), mo765c(), (BoardType) m5136a(BoardType.values()), (McuType) m5136a(McuType.values()), (FlashType) m5136a(FlashType.values()), (BluetoothType) m5136a(BluetoothType.values()), (GpsType) m5136a(GpsType.values()), (AccelerometerType) m5136a(AccelerometerType.values()));
                break;
            case 23:
                turboData = new C1058u(mo765c(), mo765c());
                break;
            case 24:
                turboData = new C1060w(mo765c(), (TurboResponse) m5136a(TurboResponse.values()), mo765c(), m5148m());
                break;
            case 25:
                turboData = new PowerLogEntry(mo765c(), (PowerLogReason) m5136a(PowerLogReason.values()), mo765c());
                break;
            case 26:
                turboData = new C1026f(mo765c(), m5142g(), m5142g(), mo765c());
                break;
            case 27:
                turboData = new C1037t(mo765c(), new String(m5148m(), "UTF-8"));
                break;
            case 28:
                turboData = new C1020a(mo765c(), mo765c(), (BusType) m5136a(BusType.values()), mo765c(), mo765c(), mo765c(), mo765c());
                break;
            case 29:
                turboData = new C1033m(mo765c(), mo765c(), mo765c());
                break;
            case 30:
                turboData = new UsbStatusMessage((UsbStatus) m5136a(UsbStatus.values()));
                break;
            case 31:
                turboData = new C1032l(mo765c(), new String(m5148m(), "UTF-8"));
                break;
            case 33:
                turboData = new LogworthyLogEntry(mo765c(), (LogworthyReason) m5136a(LogworthyReason.values()), new String(m5148m(), "UTF-8"));
                break;
            case 34:
                turboData = new C1031k(mo765c(), mo765c(), mo765c(), mo765c(), mo765c(), mo765c(), mo765c());
                break;
            case 35:
                turboData = new C1030j(mo765c(), mo765c(), m5148m());
                break;
            case 37:
                turboData = new C1051n(m5142g(), m5142g(), mo765c(), mo765c(), m5140e());
                break;
            case 38:
                d = m5139d();
                b = m5137b(OdometerSource.values());
                obj = new OdometerSource[b.length];
                System.arraycopy(b, 0, obj, 0, b.length);
                turboData = new MultiOdometerLogEntry(mo765c(), d, obj);
                break;
            case 39:
                turboData = new C1036s(mo765c(), mo765c());
                break;
            case 40:
                turboData = new SpeedometerMessage(mo765c(), (SpeedometerSource) m5136a(SpeedometerSource.values()));
                break;
            case 41:
                turboData = new C1043f(mo765c(), m5148m());
                break;
            case 42:
                turboData = new C1023c(mo765c(), m5148m());
                break;
            case 43:
                turboData = new C1063z(mo765c(), m5148m(), m5140e(), m5140e(), mo765c(), mo765c());
                break;
            case 44:
                turboData = new MobileClientSessionLogEntry(mo765c(), m5148m(), m5140e(), m5140e(), mo765c(), mo765c(), (MobileClientSessionState) m5136a(MobileClientSessionState.values()));
                break;
            case 45:
                turboData = new C1041d(mo765c(), mo765c());
                break;
            case 46:
                turboData = new am(mo765c());
                break;
            case 47:
                turboData = new an(mo765c(), (TurboResponse) m5136a(TurboResponse.values()), new String(m5148m(), "UTF-8"));
                break;
            case 48:
                turboData = new C1059v(mo765c(), mo765c());
                break;
            case 49:
                g = mo765c();
                turboData = new C1061x(mo765c(), (TurboResponse) m5136a(TurboResponse.values()), mo765c(), m5148m(), g);
                break;
            case 50:
                turboData = new af(mo765c(), (DataRegister) m5136a(DataRegister.values()), m5148m());
                break;
            case 51:
                turboData = new ag(mo765c(), (ValueRegister) m5136a(ValueRegister.values()), m5140e());
                break;
            case 52:
                turboData = new C1045h(mo765c(), (DataRegister) m5136a(DataRegister.values()));
                break;
            case 53:
                turboData = new C1047j(mo765c(), (ValueRegister) m5136a(ValueRegister.values()));
                break;
            case 54:
                turboData = new C1046i(mo765c(), (TurboResponse) m5136a(TurboResponse.values()), (DataRegister) m5136a(DataRegister.values()), m5148m());
                break;
            case 55:
                turboData = new C1048k(mo765c(), (TurboResponse) m5136a(TurboResponse.values()), (ValueRegister) m5136a(ValueRegister.values()), m5140e());
                break;
            case 56:
                ManufacturingEvent manufacturingEvent = (ManufacturingEvent) m5136a(ManufacturingEvent.values());
                i = m5140e();
                String str = new String(m5148m(), "UTF-8");
                byte[] m2 = m5148m();
                turboData = new C1062y(mo765c(), (MessageSigner) m5136a(MessageSigner.values()), m5148m(), manufacturingEvent, i, str, m2);
                break;
            case 57:
                turboData = new C1028h(mo765c(), (ManufacturingEvent) m5136a(ManufacturingEvent.values()), m5140e(), new String(m5148m(), "UTF-8"), m5148m());
                break;
            case 58:
                turboData = new C1044g(mo765c(), m5148m());
                break;
            case 59:
                turboData = new C1025e(mo765c(), m5148m());
                break;
            case 60:
                int[] d3 = m5139d();
                boolean[] l2 = m5147l();
                turboData = new ac(mo765c(), m5140e(), d3, l2);
                break;
            case 61:
                turboData = new C1029i(mo765c(), m5140e(), m5139d(), m5147l(), m5146k());
                break;
            case 62:
                g = mo765c();
                i = m5140e();
                turboData = new C1027g(mo765c(), m5142g(), m5142g(), mo765c(), g, i);
                break;
            case 63:
                turboData = new C1021r(mo765c());
                break;
            case 64:
                turboData = new ae(mo765c());
                break;
            case 65:
                turboData = new C1022b(mo765c());
                break;
            case 66:
                turboData = new TestRequestMessage(mo765c(), (TestType) m5136a(TestType.values()), mo765c(), m5148m());
                break;
            case 67:
                turboData = new ah(mo765c(), (TurboResponse) m5136a(TurboResponse.values()), mo765c(), m5148m());
                break;
            case 68:
                d = m5139d();
                b = m5137b(EngineHoursSource.values());
                obj = new EngineHoursSource[b.length];
                System.arraycopy(b, 0, obj, 0, b.length);
                turboData = new EngineHoursLogEntry(mo765c(), d, obj);
                break;
        }
        return mo762a(c, turboData);
    }
}
