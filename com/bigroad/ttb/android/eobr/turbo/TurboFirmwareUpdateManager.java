package com.bigroad.ttb.android.eobr.turbo;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.C1181z;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.turbo.C1006g;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage.FirmwareUpdateRequest;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2081g;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.PowerStatus;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.DashLinkFirmwareVersion;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TurboFirmwareUpdateManager {
    private static TurboFirmwareUpdateManager f6725j;
    private final ChangeListener f6726a = new C19431(this);
    private final C1185a f6727b = new C19475(this);
    private final C1230a f6728c = new C19486(this);
    private final C1216a f6729d = new C19497(this);
    private final Runnable f6730e = new C19508(this);
    private final Runnable f6731f = new C19519(this);
    private final Runnable f6732g = new Runnable(this) {
        final /* synthetic */ TurboFirmwareUpdateManager f6708a;

        {
            this.f6708a = r1;
        }

        public void run() {
            this.f6708a.m9581d();
        }
    };
    private final Runnable f6733h = new Runnable(this) {
        final /* synthetic */ TurboFirmwareUpdateManager f6709a;

        {
            this.f6709a = r1;
        }

        public void run() {
            this.f6709a.m9581d();
        }
    };
    private final C1206c f6734i = new C1206c(this) {
        final /* synthetic */ TurboFirmwareUpdateManager f6710a;

        {
            this.f6710a = r1;
        }

        public void mo897a(C0972e c0972e, C0973f c0973f) {
            TurboResponseMessage turboResponseMessage = (TurboResponseMessage) c0973f;
            this.f6710a.f6743s.removeCallbacks(this.f6710a.f6730e);
            if (c0973f == null) {
                C2134e.m10680d("TT-FwUpdateMgr", "Firmware update request did not receive a response");
                this.f6710a.m9578c();
            } else if (turboResponseMessage.f3353e != TurboResponse.TURBO_RESPONSE_OK) {
                C2134e.m10682e("TT-FwUpdateMgr", "Bad response from device: " + turboResponseMessage.f3353e);
                this.f6710a.m9578c();
            } else {
                this.f6710a.m9582e();
            }
        }
    };
    private final AssetManager f6735k;
    private VehicleConnectionManager f6736l;
    private final AuthMonitor f6737m;
    private final C2081g f6738n;
    private final PowerStatus f6739o;
    private final C1790a f6740p;
    private final ap f6741q;
    private Long f6742r = null;
    private Handler f6743s = new Handler();
    private State f6744t;
    private BufferedInputStream f6745u;
    private boolean f6746v;
    private String f6747w;
    private C1098j f6748x;
    private final ag<C1952a> f6749y = new ag();

    class C19431 extends C1201a {
        final /* synthetic */ TurboFirmwareUpdateManager f6711a;

        C19431(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6711a = turboFirmwareUpdateManager;
        }

        public void mo888a(C2338a c2338a) {
            EobrDevice j = this.f6711a.f6736l.m11412j();
            if (c2338a.m11450a(ConnectionFlag.CONNECTED) && this.f6711a.m9575a(j)) {
                this.f6711a.f6742r = this.f6711a.f6740p.m8778f(j.m8992d());
                this.f6711a.m9581d();
                return;
            }
            if (this.f6711a.f6744t == State.SENDING_FIRMWARE) {
                C2134e.m10678c("TT-FwUpdateMgr", "Connection lost during update.");
            }
            this.f6711a.m9578c();
            this.f6711a.f6742r = null;
        }
    }

    class C19442 implements Runnable {
        final /* synthetic */ TurboFirmwareUpdateManager f6712a;

        C19442(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6712a = turboFirmwareUpdateManager;
        }

        public void run() {
            this.f6712a.f6736l = OurApplication.m6252I();
            this.f6712a.f6736l.m11399a(this.f6712a.f6726a);
        }
    }

    class C19453 implements C0837a<C1952a> {
        final /* synthetic */ TurboFirmwareUpdateManager f6713a;

        C19453(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6713a = turboFirmwareUpdateManager;
        }

        public void m9564a(C1952a c1952a) {
            c1952a.mo1274a();
        }
    }

    class C19475 implements C1185a {
        final /* synthetic */ TurboFirmwareUpdateManager f6715a;

        C19475(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6715a = turboFirmwareUpdateManager;
        }

        public void mo912a(AuthStatus authStatus) {
            this.f6715a.f6731f.run();
        }
    }

    class C19486 extends C1231b {
        final /* synthetic */ TurboFirmwareUpdateManager f6716a;

        C19486(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6716a = turboFirmwareUpdateManager;
        }

        public void mo906a(C2081g c2081g) {
            this.f6716a.m9581d();
        }
    }

    class C19497 implements C1216a {
        final /* synthetic */ TurboFirmwareUpdateManager f6717a;

        C19497(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6717a = turboFirmwareUpdateManager;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f6717a.m9581d();
        }
    }

    class C19508 implements Runnable {
        final /* synthetic */ TurboFirmwareUpdateManager f6718a;

        C19508(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6718a = turboFirmwareUpdateManager;
        }

        public void run() {
            C2134e.m10682e("TT-FwUpdateMgr", "Response from device timed out.");
            this.f6718a.m9578c();
        }
    }

    class C19519 implements Runnable {
        final /* synthetic */ TurboFirmwareUpdateManager f6719a;

        C19519(TurboFirmwareUpdateManager turboFirmwareUpdateManager) {
            this.f6719a = turboFirmwareUpdateManager;
        }

        public void run() {
            this.f6719a.f6743s.removeCallbacks(this.f6719a.f6731f);
            if (OurApplication.m6249F().m6031d()) {
                OurApplication.m6289k().m6505j();
                this.f6719a.f6743s.postDelayed(this.f6719a.f6731f, 21600000);
            }
        }
    }

    private enum State {
        IDLE,
        SENDING_FIRMWARE,
        FINISHING_UPDATE,
        VALID
    }

    public interface C1952a {
        void mo1274a();
    }

    public static TurboFirmwareUpdateManager m9570a(Context context) {
        if (f6725j == null) {
            f6725j = new TurboFirmwareUpdateManager(context);
        }
        return f6725j;
    }

    private TurboFirmwareUpdateManager(Context context) {
        String[] list;
        Closeable open;
        Object e;
        this.f6735k = context.getAssets();
        this.f6737m = OurApplication.m6249F();
        this.f6738n = OurApplication.m6284f();
        this.f6739o = OurApplication.m6286h();
        this.f6740p = OurApplication.m6287i();
        this.f6741q = OurApplication.m6269Z();
        this.f6737m.m6027a(this.f6727b);
        this.f6738n.m10446a(this.f6728c);
        this.f6739o.m6311a(this.f6729d);
        this.f6743s.post(new C19442(this));
        this.f6743s.post(this.f6731f);
        try {
            list = this.f6735k.list("firmware");
        } catch (IOException e2) {
            list = null;
        }
        if (list != null && list.length != 0) {
            if (list.length > 1) {
                C2134e.m10678c("TT-FwUpdateMgr", "Multiple firmware images found");
            }
            this.f6747w = "firmware" + File.separator + list[0];
            C2134e.m10678c("TT-FwUpdateMgr", "Using " + this.f6747w);
            try {
                open = this.f6735k.open(this.f6747w);
                try {
                    this.f6748x = C1006g.m5172a(open);
                } catch (IOException e3) {
                    e = e3;
                    C2134e.m10682e("TT-FwUpdateMgr", "Could not read firmware version: " + e);
                    C1181z.m5999a(open);
                    m9578c();
                    m9581d();
                }
            } catch (IOException e4) {
                IOException iOException = e4;
                open = null;
                e = iOException;
                C2134e.m10682e("TT-FwUpdateMgr", "Could not read firmware version: " + e);
                C1181z.m5999a(open);
                m9578c();
                m9581d();
            }
            C1181z.m5999a(open);
        } else if (OurApplication.m6279b().m6306a()) {
            C2134e.m10682e("TT-FwUpdateMgr", "No firmware image found");
        } else {
            C2134e.m10678c("TT-FwUpdateMgr", "No firmware image found (not release build)");
        }
        m9578c();
        m9581d();
    }

    private void m9574a(State state) {
        if (this.f6744t != state) {
            this.f6744t = state;
            m9589h();
        }
    }

    private void m9578c() {
        this.f6743s.removeCallbacks(this.f6730e);
        C1181z.m5999a(this.f6745u);
        this.f6745u = null;
        m9587g();
        if (this.f6746v) {
            m9574a(State.IDLE);
        } else {
            m9574a(State.VALID);
        }
    }

    private void m9581d() {
        if (this.f6746v && this.f6736l != null) {
            if (this.f6744t == State.IDLE) {
                m9582e();
            } else if (this.f6736l.m11412j() == null) {
                C2134e.m10678c("TT-FwUpdateMgr", "Connection lost during update.");
                m9578c();
            }
        }
    }

    private void m9582e() {
        if (this.f6736l != null) {
            EobrDevice j = this.f6736l.m11412j();
            if (j != null) {
                switch (this.f6744t) {
                    case IDLE:
                        if (m9585f()) {
                            C2134e.m10678c("TT-FwUpdateMgr", "Updating firmware for device=" + j.m8991c() + " from version " + j.m9010v() + " to version " + this.f6748x);
                            m9574a(State.SENDING_FIRMWARE);
                            long c = this.f6741q.mo915c();
                            this.f6740p.m8759b(j.m8992d(), c);
                            this.f6742r = Long.valueOf(c);
                            j.m8985a(FirmwareUpdateRequest.FIRMWARE_UPDATE_REQUEST_START, null, this.f6734i);
                            this.f6743s.postDelayed(this.f6730e, 20000);
                            return;
                        }
                        return;
                    case SENDING_FIRMWARE:
                        try {
                            if (this.f6745u == null) {
                                this.f6745u = new BufferedInputStream(this.f6735k.open(this.f6747w));
                            }
                            byte[] bArr = new byte[1024];
                            int read = this.f6745u.read(bArr);
                            if (read > 0) {
                                if (read < bArr.length) {
                                    bArr = Arrays.copyOf(bArr, read);
                                }
                                j.m8985a(FirmwareUpdateRequest.FIRMWARE_UPDATE_REQUEST_WRITE, bArr, this.f6734i);
                            } else {
                                m9574a(State.FINISHING_UPDATE);
                                j.m8985a(FirmwareUpdateRequest.FIRMWARE_UPDATE_REQUEST_END, null, this.f6734i);
                            }
                            this.f6743s.postDelayed(this.f6730e, 20000);
                            return;
                        } catch (Throwable e) {
                            C2134e.m10681d("TT-FwUpdateMgr", "Error while reading from firmware file.", e);
                            m9578c();
                            return;
                        }
                    case FINISHING_UPDATE:
                        C2134e.m10678c("TT-FwUpdateMgr", "Finished updating firmware. Disconnecting from device.");
                        j.m8999k();
                        m9578c();
                        return;
                    default:
                        return;
                }
            } else if (this.f6744t != State.IDLE) {
                C2134e.m10680d("TT-FwUpdateMgr", "Active AOBRD became null during the update process.");
                m9578c();
            }
        }
    }

    public void m9593a(List<DashLinkFirmwareVersion> list) {
        this.f6743s.removeCallbacks(this.f6731f);
        this.f6740p.m8798l(list);
        m9587g();
        String str = "TT-FwUpdateMgr";
        String str2 = "Received list of firmware versions. Stored firmware file (v%s) is %s.";
        Object[] objArr = new Object[2];
        objArr[0] = this.f6748x;
        objArr[1] = this.f6746v ? "valid" : "invalid";
        C2134e.m10676b(str, String.format(str2, objArr));
        this.f6743s.postDelayed(this.f6731f, 21600000);
    }

    private boolean m9585f() {
        boolean z = true;
        if (!this.f6746v || this.f6736l == null) {
            return false;
        }
        EobrDevice j = this.f6736l.m11412j();
        if (!m9575a(j)) {
            return false;
        }
        C1098j v = j.m9010v();
        if (v == null) {
            C2134e.m10676b("TT-FwUpdateMgr", "No known FW version yet.");
            this.f6743s.removeCallbacks(this.f6733h);
            this.f6743s.postDelayed(this.f6733h, 1000);
            return false;
        }
        long c = this.f6741q.mo915c();
        boolean z2 = this.f6742r != null && c >= this.f6742r.longValue() && c - this.f6742r.longValue() < 60000;
        if (z2) {
            C2134e.m10676b("TT-FwUpdateMgr", "Turbo recently updated.  Throttling Update attempt.");
            this.f6743s.removeCallbacks(this.f6732g);
            this.f6743s.postDelayed(this.f6732g, c - this.f6742r.longValue());
        } else if (this.f6748x.m5443a(v) <= 0) {
            C2134e.m10676b("TT-FwUpdateMgr", "No update required for " + v.toString());
            m9574a(State.VALID);
        }
        if (!this.f6736l.m11406d().m11450a(ConnectionFlag.CONNECTED) || z2 || this.f6748x.m5443a(v) <= 0) {
            z = false;
        }
        return z;
    }

    private boolean m9575a(EobrDevice eobrDevice) {
        return eobrDevice != null && eobrDevice.mo1121o() == EobrType.TURBO;
    }

    private void m9587g() {
        boolean z = this.f6748x != null && this.f6740p.m8777e(this.f6748x.toString());
        this.f6746v = z;
        if (!this.f6746v) {
            C2134e.m10680d("TT-FwUpdateMgr", "Locally stored FW (" + this.f6748x + ") is invalid and cannot be used to update Turbo");
            m9574a(State.VALID);
        }
    }

    public boolean m9594a() {
        return this.f6744t == State.SENDING_FIRMWARE || this.f6744t == State.FINISHING_UPDATE;
    }

    public boolean m9595b() {
        return this.f6744t == State.VALID;
    }

    public void m9592a(C1952a c1952a) {
        this.f6749y.m4159a(c1952a, 0);
    }

    private void m9589h() {
        this.f6749y.m4157a(new C19453(this));
    }
}
