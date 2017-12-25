package com.bigroad.ttb.android.eobr.vna;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.aj;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.OBD2AddressType;
import com.bigroad.shared.eobr.genx.C0986i;
import com.bigroad.shared.eobr.turbo.logs.C1023c;
import com.bigroad.shared.eobr.turbo.logs.C1025e;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry.MobileClientSessionState;
import com.bigroad.shared.eobr.turbo.messages.C1043f;
import com.bigroad.shared.eobr.turbo.messages.C1044g;
import com.bigroad.shared.eobr.turbo.messages.C1063z;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage.FirmwareUpdateRequest;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;
import com.bigroad.shared.eobr.turbo.messages.ac;
import com.bigroad.shared.eobr.turbo.messages.al;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.C1902e;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.C1902e.C1856a;
import com.bigroad.ttb.android.eobr.C1902e.C1901b;
import com.bigroad.ttb.android.eobr.EobrWriter.BroadcastSetting;
import com.bigroad.ttb.android.eobr.realtime.RealtimeSessionHandler;
import com.bigroad.ttb.android.eobr.vna.C2003f.C2002a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p038g.C2078a;
import com.bigroad.ttb.android.util.C2281d;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import java.util.regex.Pattern;

public final class C1992b extends C1902e {
    private static final Pattern f6870n = Pattern.compile("(FireFly|RNBT)-[0-9a-fA-F]+");
    private final ap f6871o = OurApplication.m6269Z();
    private final RealtimeSessionHandler f6872p;
    private final C2001e f6873q;
    private OBD2AddressType f6874r = OBD2AddressType.UNKNOWN;
    private int f6875s = 0;
    private volatile EobrType f6876t = EobrType.UNKNOWN_EOBR_TYPE;
    private C1098j f6877u;
    private final Runnable f6878v = new C19831(this);
    private final Runnable f6879w = new C19853(this);
    private final Runnable f6880x = new C19864(this);
    private final Runnable f6881y = new C19875(this);

    class C19831 implements Runnable {
        final /* synthetic */ C1992b f6853a;

        C19831(C1992b c1992b) {
            this.f6853a = c1992b;
        }

        public void run() {
            ((C2008j) this.f6853a.e).m9947h();
            this.f6853a.a.postDelayed(this.f6853a.f6878v, 5000);
        }
    }

    class C19853 implements Runnable {
        final /* synthetic */ C1992b f6857a;

        C19853(C1992b c1992b) {
            this.f6857a = c1992b;
        }

        public void run() {
            if (this.f6857a.f6875s >= 3) {
                this.f6857a.a.removeCallbacks(this.f6857a.f6879w);
                this.f6857a.f6875s = 0;
                return;
            }
            C1992b.m9835g(this.f6857a);
            this.f6857a.e.mo1157b();
            this.f6857a.a.postDelayed(this.f6857a.f6879w, 1000);
        }
    }

    class C19864 implements Runnable {
        final /* synthetic */ C1992b f6858a;

        C19864(C1992b c1992b) {
            this.f6858a = c1992b;
        }

        public void run() {
            this.f6858a.m9292j();
            this.f6858a.a.postDelayed(this.f6858a.f6880x, 4000);
        }
    }

    class C19875 implements Runnable {
        final /* synthetic */ C1992b f6859a;

        C19875(C1992b c1992b) {
            this.f6859a = c1992b;
        }

        public void run() {
            this.f6859a.a.removeCallbacks(this);
            this.f6859a.e.m9214g();
            this.f6859a.a.postDelayed(this, 1000);
        }
    }

    static /* synthetic */ int m9835g(C1992b c1992b) {
        int i = c1992b.f6875s + 1;
        c1992b.f6875s = i;
        return i;
    }

    public C1992b(C2078a c2078a, C1856a c1856a, String str) {
        this.f6872p = RealtimeSessionHandler.m9528a(str, (Object) this, OurApplication.ac());
        this.f6873q = new C2001e(OurApplication.ac(), this.f6872p);
        this.f6873q.start();
        m9274a(c2078a, c1856a, new C2004g(this, c2078a), new C2008j(this, c2078a));
        this.e.mo1155a(BroadcastSetting.ENABLED);
        this.e.mo1160b(BroadcastSetting.ENABLED);
        this.f6879w.run();
        this.f6880x.run();
        this.f6878v.run();
    }

    public void close() {
        this.f6872p.m9549a((Object) this);
        this.f6873q.m9900a();
        this.a.removeCallbacks(this.f6879w);
        this.a.removeCallbacks(this.f6880x);
        this.a.removeCallbacks(this.f6878v);
        this.a.removeCallbacks(this.f6881y);
        super.close();
    }

    OBD2AddressType m9872s() {
        return this.f6874r;
    }

    void m9857a(final OBD2AddressType oBD2AddressType) {
        this.a.post(new Runnable(this) {
            final /* synthetic */ C1992b f6861b;

            public void run() {
                this.f6861b.f6874r = oBD2AddressType;
                if (oBD2AddressType != null) {
                    this.f6861b.a.removeCallbacks(this.f6861b.f6879w);
                    if (oBD2AddressType != OBD2AddressType.UNKNOWN) {
                        C2134e.m10673a("TT-VnaDriver", "Requesting OBD2Mode0Pid1_20 support");
                        this.f6861b.e.m9213f();
                    }
                }
                this.f6861b.b.mo1074b(this.f6861b);
            }
        });
    }

    void m9866b(final int i) {
        this.a.post(new Runnable(this) {
            final /* synthetic */ C1992b f6863b;

            public void run() {
                this.f6863b.f6877u = new C1098j(i);
                this.f6863b.b.mo1072a(this.f6863b);
            }
        });
    }

    C2001e m9873t() {
        return this.f6873q;
    }

    public void mo1177a(String str, boolean z) {
        super.mo1177a(str, z);
        if (z) {
            this.a.removeCallbacks(this.f6880x);
        }
    }

    public EobrType m9874u() {
        return this.f6876t;
    }

    public long mo1124a() {
        return this.f6876t.m4936a();
    }

    void m9856a(final EobrType eobrType) {
        Log.v("TT-VnaDriver", "Setting EOBR type to " + eobrType);
        this.a.post(new Runnable(this) {
            final /* synthetic */ C1992b f6865b;

            public void run() {
                if (this.f6865b.f6876t != EobrType.UNKNOWN_EOBR_TYPE || eobrType == EobrType.UNKNOWN_EOBR_TYPE) {
                    C2134e.m10678c("TT-VnaDriver", "Ignored attempt to set EOBR type to " + eobrType + " (current type: " + this.f6865b.f6876t + ")");
                    return;
                }
                this.f6865b.f6876t = eobrType;
                this.f6865b.b.mo1074b(this.f6865b);
            }
        });
    }

    public static boolean m9829a(BluetoothDevice bluetoothDevice) {
        if (!f6870n.matcher(C2281d.m11194a(bluetoothDevice)).matches()) {
            return false;
        }
        BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
        if (bluetoothClass == null || bluetoothClass.getDeviceClass() != 7936) {
            return false;
        }
        return true;
    }

    public C1098j mo1135b() {
        return this.f6877u;
    }

    public String mo1138c() {
        return m9874u().m4938b();
    }

    public void mo1126a(long j, C1206c c1206c) {
    }

    public void mo1129a(C0986i c0986i, C1206c c1206c) {
    }

    public void mo1134a(byte[] bArr, C1206c c1206c) {
        m9828a(new C1043f(0, bArr), c1206c, this.f6871o.mo915c());
    }

    public void mo1137b(byte[] bArr, C1206c c1206c) {
        m9828a(new C1044g(0, bArr), c1206c, this.f6871o.mo915c());
    }

    public void mo1130a(FirmwareUpdateRequest firmwareUpdateRequest, byte[] bArr, C1206c c1206c) {
    }

    public int mo1123a(byte[] bArr, long j, long j2, int i) {
        int b = aj.m4180b();
        m9828a(new C1063z(0, bArr, j, j2, b, i), null, this.f6871o.mo915c());
        return b;
    }

    public void mo1127a(long j, OdometerOffsets odometerOffsets) {
        al a = m9257a(0, j, odometerOffsets);
        if (a != null) {
            m9828a(a, null, this.f6871o.mo915c());
        }
    }

    public void mo1132a(C1206c c1206c) {
    }

    protected void mo1131a(C1901b c1901b) {
        throw new UnsupportedOperationException();
    }

    protected int mo1141m() {
        return 0;
    }

    public boolean mo1140d() {
        return true;
    }

    private void m9828a(final al alVar, final C1206c c1206c, long j) {
        TurboResponse turboResponse;
        int i = (int) (j / 1000);
        TurboResponse turboResponse2 = TurboResponse.TURBO_RESPONSE_OK;
        if (alVar instanceof C1044g) {
            this.f6872p.mo1163a(new C1025e(i, ((C1044g) alVar).f3433a));
            turboResponse = turboResponse2;
        } else if (alVar instanceof C1043f) {
            this.f6872p.mo1163a(new C1023c(i, ((C1043f) alVar).f3432a));
            turboResponse = turboResponse2;
        } else if (alVar instanceof C1063z) {
            C1063z c1063z = (C1063z) alVar;
            this.f6872p.mo1163a(new MobileClientSessionLogEntry(i, c1063z.f3476a, c1063z.f3477b, c1063z.f3478c, c1063z.f3479d, c1063z.f3480e, MobileClientSessionState.MOBILE_CLIENT_SESSION_STATE_START));
            turboResponse = turboResponse2;
        } else if (alVar instanceof ac) {
            ac acVar = (ac) alVar;
            C2002a c2002a = new C2002a();
            c2002a.f6915a = acVar.f3402c;
            c2002a.f6916b = acVar.f3400a;
            c2002a.f6917c = acVar.f3401b;
            this.f6873q.m9905a(c2002a, this.f6871o.mo915c());
            turboResponse = turboResponse2;
        } else {
            turboResponse = TurboResponse.TURBO_RESPONSE_ERROR_STATE;
        }
        if (c1206c != null) {
            final TurboResponseMessage turboResponseMessage = new TurboResponseMessage(alVar.f3298f, turboResponse);
            this.a.post(new Runnable(this) {
                final /* synthetic */ C1992b f6869d;

                public void run() {
                    c1206c.mo897a(alVar, turboResponseMessage);
                }
            });
        }
    }

    public void mo1133a(final short s, final long j) {
        this.a.post(new Runnable(this) {
            final /* synthetic */ C1992b f6852c;

            public void run() {
                if (s == (short) 16640 && (j & ((long) 2)) != 0) {
                    this.f6852c.f6881y.run();
                    this.f6852c.f6873q.m9907a(true);
                }
            }
        });
    }

    public void mo1125a(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        this.a.post(new Runnable(this) {
            final /* synthetic */ C1992b f6856c;

            public void run() {
                this.f6856c.f6873q.m9901a(j3, j4);
            }
        });
    }

    protected long mo1142q() {
        return 5000;
    }
}
