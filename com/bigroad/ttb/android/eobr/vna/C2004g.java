package com.bigroad.ttb.android.eobr.vna;

import android.util.Log;
import com.bigroad.shared.ap;
import com.bigroad.shared.as;
import com.bigroad.shared.eobr.C0968a;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.OBD2AddressType;
import com.bigroad.shared.eobr.OBD2BaudRate;
import com.bigroad.shared.eobr.p025a.C0964a;
import com.bigroad.shared.eobr.p025a.C0965b;
import com.bigroad.shared.eobr.p025a.C0967d;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.EobrReader;
import com.bigroad.ttb.android.eobr.RpmSource;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p038g.C2078a;
import java.io.InputStream;

public final class C2004g extends EobrReader {
    private final ap f6921e = OurApplication.m6269Z();
    private final C1992b f6922f;
    private long f6923g = 0;
    private long f6924h = 0;
    private long f6925i = 0;
    private OBD2AddressType f6926j;

    public C2004g(C1992b c1992b, C2078a c2078a) {
        super(c1992b, c2078a);
        this.f6922f = c1992b;
    }

    private void m9919a(C0964a c0964a) {
        byte[] b = c0964a.m4950b();
        if (b.length == 0) {
            this.c.m9305c();
            return;
        }
        m9194d();
        byte b2 = b[0];
        long a;
        byte b3;
        switch (b2) {
            case (byte) 0:
                if (b.length < 2) {
                    this.c.m9305c();
                    return;
                }
                return;
            case (byte) 6:
                this.c.m9308f();
                m9917a(EobrType.VNA_JBUS);
                if (b.length < 8) {
                    this.c.m9305c();
                    return;
                } else {
                    m9184a(C0968a.m4969c(b, 2), b[6], b, 8);
                    return;
                }
            case (byte) 9:
                this.c.m9309g();
                m9917a(EobrType.VNA_JBUS);
                if (b.length < 4) {
                    this.c.m9305c();
                    return;
                } else {
                    m9182a(b[1], C0968a.m4970d(b, 2), b, 4);
                    return;
                }
            case (byte) 23:
                m9917a(EobrType.VNA_JBUS);
                if (b.length < 15) {
                    this.c.m9305c();
                    return;
                }
                a = C0968a.m4965a(b, 1);
                long a2 = C0968a.m4965a(b, 5);
                long a3 = C0968a.m4965a(b, 9);
                byte b4 = b[13];
                b3 = b[14];
                this.c.m9303a(a, a2, a3);
                m9916a(b4, b3);
                return;
            case (byte) 25:
                m9917a(EobrType.VNA_OBD2);
                if (b.length < 4) {
                    this.c.m9305c();
                    return;
                }
                OBD2BaudRate oBD2BaudRate;
                OBD2AddressType oBD2AddressType;
                int i = b[3] & 255;
                switch (b[2] & 255) {
                    case 0:
                        oBD2BaudRate = OBD2BaudRate.OBD2_250_KBPS;
                        break;
                    case 1:
                        oBD2BaudRate = OBD2BaudRate.OBD2_500_KBPS;
                        break;
                    case 254:
                        oBD2BaudRate = OBD2BaudRate.AUTO_CONNECT_FAILED;
                        break;
                    case 255:
                        oBD2BaudRate = OBD2BaudRate.INITIAL_STATE_NO_ATTEMPT;
                        break;
                    default:
                        oBD2BaudRate = OBD2BaudRate.UNKNOWN;
                        break;
                }
                switch (i) {
                    case 0:
                        oBD2AddressType = OBD2AddressType.OBD2_11_BIT;
                        break;
                    case 1:
                        oBD2AddressType = OBD2AddressType.OBD2_29_BIT;
                        break;
                    default:
                        oBD2AddressType = OBD2AddressType.UNKNOWN;
                        break;
                }
                m9918a(oBD2BaudRate, oBD2AddressType);
                return;
            case (byte) 43:
                this.c.m9310h();
                m9917a(EobrType.VNA_OBD2);
                if (b.length < 8) {
                    this.c.m9305c();
                    return;
                } else {
                    m9183a(b[3], (short) ((b[6] << 8) | b[7]), b, 8);
                    return;
                }
            case (byte) 45:
                m9917a(EobrType.VNA_OBD2);
                if (b.length < 7) {
                    this.c.m9305c();
                    return;
                }
                a = C0968a.m4965a(b, 1);
                b2 = b[5];
                b3 = b[6];
                this.c.m9302a(a);
                m9916a(b2, b3);
                return;
            case (byte) 46:
                this.c.m9311i();
                if (b.length < 1) {
                    this.c.m9305c();
                    return;
                } else if (b.length - 1 < 4) {
                    this.c.m9307e();
                    return;
                } else {
                    m9185a(as.m4242a(C0968a.m4965a(b, 1)) / 10);
                    return;
                }
            default:
                C2134e.m10678c("TT-VnaReader", "Unrecognized message: " + C0967d.m4964a(b2));
                this.c.m9306d();
                return;
        }
    }

    protected void mo1147a(InputStream inputStream) {
        C0965b c0965b = new C0965b(inputStream);
        while (!this.d) {
            C0964a a = c0965b.m4957a();
            if (a.m4949a()) {
                this.c.m9301a();
                m9919a(a);
                m9195e();
            } else {
                this.c.m9304b();
            }
        }
    }

    protected void mo1145a(SpeedometerSource speedometerSource, int i, int i2, long j) {
        this.f6922f.m9873t().m9903a(speedometerSource, i, i2, j);
    }

    protected void mo1144a(OdometerSource odometerSource, long j, long j2) {
        this.f6922f.m9873t().m9902a(odometerSource, j, j2);
    }

    protected void mo1146a(RpmSource rpmSource, int i) {
        this.f6922f.m9873t().m9904a(rpmSource, i);
    }

    protected void mo1148b(String str) {
        this.f6922f.m9873t().m9906a(str, this.f6921e.mo915c());
    }

    protected void mo1149f() {
    }

    private void m9917a(EobrType eobrType) {
        EobrType u = this.f6922f.m9874u();
        if (u == EobrType.UNKNOWN_EOBR_TYPE && eobrType != u) {
            this.f6922f.m9856a(eobrType);
            String str = "Setting EOBR type to " + eobrType;
            Log.v("TT-VnaReader", str);
            long c = this.f6921e.mo915c();
            if (this.f6924h == 0 || c - this.f6924h >= 60000) {
                C2134e.m10673a("TT-VnaReader", str);
                this.f6924h = c;
            }
        }
    }

    private void m9918a(OBD2BaudRate oBD2BaudRate, OBD2AddressType oBD2AddressType) {
        if (oBD2AddressType != this.f6926j) {
            this.f6926j = oBD2AddressType;
            this.f6922f.m9857a(oBD2AddressType);
        }
        String str = "ACONN: Baud Rate = " + oBD2BaudRate + ", Address Type = " + oBD2AddressType;
        Log.v("TT-VnaReader", str);
        long c = this.f6921e.mo915c();
        if (this.f6923g == 0 || c - this.f6923g >= 60000) {
            C2134e.m10673a("TT-VnaReader", str);
            this.f6923g = c;
        }
    }

    private void m9916a(byte b, byte b2) {
        this.f6922f.m9866b((int) b2);
        String str = "STAT: HW=" + b + " SW=" + b2 + " " + this.c.toString();
        Log.v("TT-VnaReader", str);
        long c = this.f6921e.mo915c();
        if (this.f6925i == 0 || c - this.f6925i >= 60000) {
            C2134e.m10673a("TT-VnaReader", str);
            this.f6925i = c;
        }
        m9193c();
    }
}
