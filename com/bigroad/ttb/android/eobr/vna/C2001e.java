package com.bigroad.ttb.android.eobr.vna;

import android.os.Handler;
import android.os.HandlerThread;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.turbo.BusType;
import com.bigroad.shared.eobr.turbo.logs.C1020a;
import com.bigroad.shared.eobr.turbo.logs.C1037t;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.eobr.EobrManager.C1449b;
import com.bigroad.ttb.android.eobr.EobrManager.ChangeListener;
import com.bigroad.ttb.android.eobr.RpmSource;
import com.bigroad.ttb.android.eobr.realtime.RealtimeSessionHandler;
import com.bigroad.ttb.android.eobr.vna.C2003f.C2002a;
import com.bigroad.ttb.android.logging.C2134e;

public class C2001e extends HandlerThread {
    private final ap f6902a;
    private final EobrManager f6903b;
    private final String f6904c;
    private final C2006i f6905d;
    private final VnaSpeedometer f6906e;
    private final C2003f f6907f;
    private final C1995c f6908g;
    private final C1997d f6909h;
    private Handler f6910i = null;
    private volatile boolean f6911j = false;
    private RealtimeSessionHandler f6912k;
    private final ChangeListener f6913l = new C19981(this);
    private final Runnable f6914m = new C19992(this);

    class C19981 extends C1449b {
        final /* synthetic */ C2001e f6899a;

        C19981(C2001e c2001e) {
            this.f6899a = c2001e;
        }

        public void mo1001c(EobrDevice eobrDevice) {
            if (am.m4189a(this.f6899a.f6904c, eobrDevice.m8991c())) {
                this.f6899a.m9892a(eobrDevice);
            }
        }
    }

    class C19992 implements Runnable {
        final /* synthetic */ C2001e f6900a;

        C19992(C2001e c2001e) {
            this.f6900a = c2001e;
        }

        public void run() {
            long a = this.f6900a.f6902a.mo913a();
            long c = this.f6900a.f6902a.mo915c();
            this.f6900a.f6906e.m9817a(a, c);
            this.f6900a.f6907f.m9913a(c);
            this.f6900a.f6908g.m9878a(a, c);
            if (this.f6900a.f6910i != null) {
                this.f6900a.f6910i.postDelayed(this.f6900a.f6914m, 1000);
            }
        }
    }

    C2001e(C2032f c2032f, RealtimeSessionHandler realtimeSessionHandler) {
        super("VnaHandler");
        this.f6904c = realtimeSessionHandler.m9551c();
        this.f6912k = realtimeSessionHandler;
        this.f6902a = c2032f.mo1314v();
        this.f6903b = c2032f.mo1310r();
        this.f6905d = new C2006i(this.f6912k);
        this.f6906e = new VnaSpeedometer(this.f6905d);
        this.f6908g = new C1995c(this.f6905d);
        this.f6907f = new C2003f(this.f6912k);
        this.f6909h = new C1997d(c2032f, this.f6912k);
        this.f6903b.m9118a(this.f6913l);
    }

    protected void onLooperPrepared() {
        this.f6910i = new Handler(getLooper());
        this.f6910i.post(this.f6914m);
        super.onLooperPrepared();
    }

    synchronized void m9900a() {
        this.f6903b.m9122b(this.f6913l);
        if (!this.f6911j) {
            this.f6911j = true;
            this.f6910i.removeCallbacks(this.f6914m);
            this.f6909h.m9887a();
            this.f6910i = null;
            quit();
        }
    }

    void m9903a(SpeedometerSource speedometerSource, int i, int i2, long j) {
        if (C2005h.m9927a(speedometerSource)) {
            this.f6906e.m9818a(speedometerSource, i, i2, j);
        }
    }

    void m9902a(OdometerSource odometerSource, long j, long j2) {
        if (C2005h.m9926a(odometerSource)) {
            this.f6907f.m9914a(odometerSource, j, j2);
        }
    }

    void m9904a(RpmSource rpmSource, int i) {
        this.f6908g.m9879a(rpmSource, i);
    }

    synchronized void m9906a(String str, long j) {
        this.f6912k.mo1163a(new C1037t((int) (j / 1000), str));
    }

    void m9905a(C2002a c2002a, long j) {
        this.f6907f.m9915a(c2002a, j);
    }

    private void m9892a(EobrDevice eobrDevice) {
        EobrType o = eobrDevice.mo1121o();
        switch (o) {
            case UNKNOWN_EOBR_TYPE:
                return;
            case VNA_JBUS:
                m9891a(BusType.BUS_TYPE_J1939);
                m9891a(BusType.BUS_TYPE_J1708);
                return;
            case VNA_OBD2:
                m9891a(BusType.BUS_TYPE_OBD);
                return;
            default:
                C2134e.m10680d("TT-VnaHandler", "Unexpected EOBR type: EOBR type should be VNA_JBUS or VNA_OBD2 but was " + o);
                return;
        }
    }

    private synchronized void m9891a(BusType busType) {
        this.f6912k.mo1163a(new C1020a((int) (this.f6902a.mo915c() / 1000), 0, busType, 0, 0, 0, 0));
    }

    public void m9907a(boolean z) {
        C2134e.m10673a("TT-VnaHandler", "setEngineRunningTimeSupport(" + z + ")");
        this.f6908g.m9880a(z, this.f6902a.mo915c());
    }

    public void m9901a(long j, long j2) {
        this.f6908g.m9882b(j, j2);
    }
}
