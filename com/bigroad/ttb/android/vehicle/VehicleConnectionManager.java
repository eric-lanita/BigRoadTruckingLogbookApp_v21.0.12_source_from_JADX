package com.bigroad.ttb.android.vehicle;

import android.content.Context;
import android.os.Handler;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ai;
import com.bigroad.shared.am;
import com.bigroad.shared.an;
import com.bigroad.shared.ap;
import com.bigroad.shared.aq;
import com.bigroad.shared.eobr.ConnectionError;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.BluetoothMonitor;
import com.bigroad.ttb.android.BluetoothMonitor.BluetoothStatus;
import com.bigroad.ttb.android.BluetoothMonitor.C1188a;
import com.bigroad.ttb.android.BluetoothMonitor.C1189b;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2081g;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.PowerStatus;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.eobr.EobrManager.ChangeListener.Priority;
import com.bigroad.ttb.android.eobr.genx.C1919c;
import com.bigroad.ttb.android.eobr.turbo.TurboFirmwareUpdateManager.C1952a;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2177b;
import com.bigroad.ttb.android.model.C2178c;
import com.bigroad.ttb.android.model.C2179d;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.android.vehicle.C2338a.C2331a;
import com.bigroad.ttb.android.vehicle.C2363e.C2320a;
import com.bigroad.ttb.protocol.TTProtocol.CursorReset;
import com.bigroad.ttb.protocol.TTProtocol.CursorResetReason;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntry;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntryType;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets.C2710a;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.common.base.Objects;
import com.google.common.primitives.C3607b;
import com.google.protobuf.C3642c;
import java.util.Arrays;

public class VehicleConnectionManager {
    private static VehicleConnectionManager f8043a;
    private final C2320a f8044A = new C2320a(this) {
        final /* synthetic */ VehicleConnectionManager f8023a;

        {
            this.f8023a = r1;
        }

        public void mo1275a(ProcessingState processingState) {
            this.f8023a.m11394o();
            this.f8023a.m11363a(processingState);
        }

        public void mo1276a(C2363e c2363e, C2369i c2369i, RelativeTimestamp relativeTimestamp) {
            if (c2369i != null && C2371k.m11634a(relativeTimestamp, this.f8023a.f8055g)) {
                this.f8023a.m11372a(c2369i.m11612k().getMotionType());
            }
            long truckId = c2369i.m11600b().getTruckId();
            Truck a = this.f8023a.f8053e.m6552a(truckId);
            if (a == null) {
                C2134e.m10678c("TT-VehicleMgr", "Could not find truckID " + truckId + " in the truck manager");
            } else if (c2363e.m11544g()) {
                this.f8023a.m11373a(a, c2369i);
            }
            this.f8023a.m11394o();
            this.f8023a.m11371a(c2369i);
        }

        public void mo1277a(final RelativeTimestamp relativeTimestamp) {
            if (this.f8023a.f8060l != null && C2371k.m11634a(relativeTimestamp, this.f8023a.f8055g)) {
                C2369i e = this.f8023a.f8060l.m11542e();
                if (e != null) {
                    this.f8023a.m11372a(e.m11612k().getMotionType());
                }
            }
            this.f8023a.m11394o();
            if (relativeTimestamp != null && relativeTimestamp.hasAbsoluteTimeMillis()) {
                this.f8023a.f8067s.m4157a(new C0837a<ChangeListener>(this) {
                    final /* synthetic */ AnonymousClass17 f8022b;

                    public void m11341a(ChangeListener changeListener) {
                        changeListener.mo886a(relativeTimestamp.getAbsoluteTimeMillis());
                    }
                });
            }
        }
    };
    private final Runnable f8045B = new Runnable(this) {
        final /* synthetic */ VehicleConnectionManager f8024a;

        {
            this.f8024a = r1;
        }

        public void run() {
            this.f8024a.m11390m();
        }
    };
    private final Runnable f8046C = new Runnable(this) {
        final /* synthetic */ VehicleConnectionManager f8025a;

        {
            this.f8025a = r1;
        }

        public void run() {
            this.f8025a.m11390m();
        }
    };
    private final Runnable f8047D = new C23222(this);
    private final Runnable f8048E = new C23233(this);
    private final Runnable f8049F = new C23244(this);
    private boolean f8050b;
    private final Handler f8051c = new Handler();
    private final C2032f f8052d;
    private final TruckManager f8053e;
    private final BluetoothMonitor f8054f;
    private final ap f8055g;
    private final PowerStatus f8056h;
    private final C2081g f8057i;
    private C2338a f8058j;
    private final SearchState f8059k;
    private C2363e f8060l = null;
    private Truck f8061m = null;
    private C2355b f8062n = null;
    private Long f8063o = null;
    private boolean f8064p = false;
    private long f8065q = 0;
    private boolean f8066r = false;
    private final ag<ChangeListener> f8067s = new ag();
    private MotionType f8068t = MotionType.UNKNOWN_MOTION_TYPE;
    private final com.bigroad.ttb.android.TruckManager.ChangeListener f8069u = new C23211(this);
    private final com.bigroad.ttb.android.eobr.EobrManager.ChangeListener f8070v = new com.bigroad.ttb.android.eobr.EobrManager.ChangeListener(this) {
        final /* synthetic */ VehicleConnectionManager f8016a;

        {
            this.f8016a = r1;
        }

        public void mo998a(EobrDevice eobrDevice, boolean z) {
            this.f8016a.m11390m();
        }

        public void mo997a(EobrDevice eobrDevice) {
            this.f8016a.m11390m();
        }

        public void mo999a(EobrManager eobrManager) {
            this.f8016a.m11390m();
        }

        public void mo1000b(EobrDevice eobrDevice) {
            if (this.f8016a.f8059k.m11327d()) {
                CharSequence l = eobrDevice.m9000l();
                if (!am.m4188a(l)) {
                    C2134e.m10676b("TT-VehicleMgr", "VIN: " + l);
                    this.f8016a.m11390m();
                }
            }
            if (this.f8016a.f8058j.m11451a(ConnectionSetupFlag.FIRMWARE_DETECTING) && eobrDevice.m9010v() != null) {
                this.f8016a.m11390m();
            }
        }

        public void mo1001c(EobrDevice eobrDevice) {
            if (this.f8016a.f8059k.m11327d()) {
                eobrDevice.m9005q();
            }
            this.f8016a.m11394o();
        }
    };
    private final C1188a f8071w = new C1189b(this) {
        final /* synthetic */ VehicleConnectionManager f8017a;

        {
            this.f8017a = r1;
        }

        public void mo875a() {
            this.f8017a.m11390m();
        }
    };
    private final C1952a f8072x = new C1952a(this) {
        final /* synthetic */ VehicleConnectionManager f8018a;

        {
            this.f8018a = r1;
        }

        public void mo1274a() {
            this.f8018a.m11394o();
        }
    };
    private final C1216a f8073y = new C1216a(this) {
        final /* synthetic */ VehicleConnectionManager f8019a;

        {
            this.f8019a = r1;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f8019a.m11390m();
        }
    };
    private final C1230a f8074z = new C1231b(this) {
        final /* synthetic */ VehicleConnectionManager f8020a;

        {
            this.f8020a = r1;
        }

        public void mo906a(C2081g c2081g) {
            if (c2081g.m10450b()) {
                this.f8020a.f8065q = this.f8020a.f8055g.mo915c();
                this.f8020a.f8051c.removeCallbacks(this.f8020a.f8048E);
                this.f8020a.f8051c.postDelayed(this.f8020a.f8048E, 300000);
            }
            this.f8020a.m11390m();
        }
    };

    public interface ChangeListener {

        public enum Priority {
            MALFUNCTION_MONITOR,
            AOBRD_MANAGER,
            AOBRD_MOTION_TRACKER,
            DEFAULT
        }

        void mo886a(long j);

        void mo887a(ProcessingState processingState);

        void mo888a(C2338a c2338a);

        void mo889a(C2363e c2363e);

        void mo890a(C2369i c2369i);

        void mo891a(MotionType motionType);

        void mo892b(C2363e c2363e);
    }

    public static class C1201a implements ChangeListener {
        public void mo889a(C2363e c2363e) {
        }

        public void mo892b(C2363e c2363e) {
        }

        public void mo888a(C2338a c2338a) {
        }

        public void mo890a(C2369i c2369i) {
        }

        public void mo891a(MotionType motionType) {
        }

        public void mo887a(ProcessingState processingState) {
        }

        public void mo886a(long j) {
        }
    }

    class C23211 extends C1203b {
        final /* synthetic */ VehicleConnectionManager f8026a;

        C23211(VehicleConnectionManager vehicleConnectionManager) {
            this.f8026a = vehicleConnectionManager;
        }

        public void mo894a(Truck truck) {
            C2134e.m10676b("TT-VehicleMgr", "activeTruckChanged");
            if (!(this.f8026a.f8061m == null || truck == null || this.f8026a.f8061m.getTruckId() != truck.getTruckId())) {
                this.f8026a.f8061m = truck;
            }
            Long valueOf = truck == null ? null : Long.valueOf(truck.getTruckId());
            if (!Objects.equal(valueOf, this.f8026a.f8063o)) {
                this.f8026a.f8051c.removeCallbacks(this.f8026a.f8049F);
                OurApplication.m6295q().m10068r();
                this.f8026a.f8063o = valueOf;
            }
            this.f8026a.m11390m();
        }
    }

    class C23222 implements Runnable {
        final /* synthetic */ VehicleConnectionManager f8027a;

        C23222(VehicleConnectionManager vehicleConnectionManager) {
            this.f8027a = vehicleConnectionManager;
        }

        public void run() {
            MotionType motionType = MotionType.UNKNOWN_MOTION_TYPE;
            if (this.f8027a.f8060l != null) {
                if (C2371k.m11634a(this.f8027a.f8060l.m11528a(), this.f8027a.f8055g)) {
                    motionType = this.f8027a.f8060l.m11542e().m11612k().getMotionType();
                } else {
                    C2134e.m10676b("TT-VehicleMgr", "Invalidating realtime motion");
                    long b = this.f8027a.f8055g.mo914b();
                    if (this.f8027a.f8060l.m11528a() == null) {
                        C2134e.m10676b("TT-VehicleMgr", "Got unexpected null timestamp! Event time: " + aq.m4233e(b));
                    } else {
                        C2134e.m10676b("TT-VehicleMgr", "Last processed: " + aq.m4233e(this.f8027a.f8060l.m11528a().getAbsoluteTimeMillis()) + "; event time: " + aq.m4233e(b));
                    }
                }
            }
            this.f8027a.m11372a(motionType);
        }
    }

    class C23233 implements Runnable {
        final /* synthetic */ VehicleConnectionManager f8028a;

        C23233(VehicleConnectionManager vehicleConnectionManager) {
            this.f8028a = vehicleConnectionManager;
        }

        public void run() {
            this.f8028a.f8051c.removeCallbacks(this.f8028a.f8048E);
            if (this.f8028a.f8057i.m10450b()) {
                this.f8028a.m11390m();
                this.f8028a.f8051c.postDelayed(this.f8028a.f8048E, 30000);
            }
        }
    }

    class C23244 implements Runnable {
        final /* synthetic */ VehicleConnectionManager f8029a;

        C23244(VehicleConnectionManager vehicleConnectionManager) {
            this.f8029a = vehicleConnectionManager;
        }

        public void run() {
            OurApplication.m6295q().m10068r();
        }
    }

    class C23255 implements Runnable {
        final /* synthetic */ VehicleConnectionManager f8030a;

        C23255(VehicleConnectionManager vehicleConnectionManager) {
            this.f8030a = vehicleConnectionManager;
        }

        public void run() {
            this.f8030a.m11390m();
        }
    }

    class C23288 implements C0837a<ChangeListener> {
        final /* synthetic */ VehicleConnectionManager f8035a;

        C23288(VehicleConnectionManager vehicleConnectionManager) {
            this.f8035a = vehicleConnectionManager;
        }

        public void m11354a(ChangeListener changeListener) {
            changeListener.mo888a(this.f8035a.f8058j);
        }
    }

    private void m11373a(Truck truck, C2369i c2369i) {
        boolean z = false;
        OdometerOffsets a = c2369i.m11594a(this.f8052d);
        boolean z2 = a != null;
        boolean hasOdometerOffsets = truck.hasOdometerOffsets();
        if (z2 && hasOdometerOffsets) {
            OdometerOffsets odometerOffsets = truck.getOdometerOffsets();
            C2710a newBuilder = OdometerOffsets.newBuilder(odometerOffsets);
            if (!a.hasDashlinkFirmwareOffset()) {
                if (odometerOffsets.hasDashlinkFirmwareOffset()) {
                    z2 = false;
                    z = true;
                }
                z2 = false;
            } else if (odometerOffsets.hasDashlinkFirmwareOffset()) {
                if (odometerOffsets.getDashlinkFirmwareOffset() != a.getDashlinkFirmwareOffset()) {
                    z2 = false;
                    z = true;
                }
                z2 = false;
            } else {
                newBuilder.m14602h(a.getDashlinkFirmwareOffset());
                z2 = true;
            }
            if (a.hasJ1939HrSrc0Offset()) {
                if (!odometerOffsets.hasJ1939HrSrc0Offset()) {
                    newBuilder.m14590b(a.getJ1939HrSrc0Offset());
                    z2 = true;
                } else if (odometerOffsets.getJ1939HrSrc0Offset() != a.getJ1939HrSrc0Offset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1939HrSrc0Offset()) {
                z = true;
            }
            if (a.hasJ1939Src0Offset()) {
                if (!odometerOffsets.hasJ1939Src0Offset()) {
                    newBuilder.m14586a(a.getJ1939Src0Offset());
                    z2 = true;
                } else if (odometerOffsets.getJ1939Src0Offset() != a.getJ1939Src0Offset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1939Src0Offset()) {
                z = true;
            }
            if (a.hasJ1939HrSrc23Offset()) {
                if (!odometerOffsets.hasJ1939HrSrc23Offset()) {
                    newBuilder.m14595d(a.getJ1939HrSrc23Offset());
                    z2 = true;
                } else if (odometerOffsets.getJ1939HrSrc23Offset() != a.getJ1939HrSrc23Offset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1939HrSrc23Offset()) {
                z = true;
            }
            if (a.hasJ1939Src23Offset()) {
                if (!odometerOffsets.hasJ1939Src23Offset()) {
                    newBuilder.m14592c(a.getJ1939Src23Offset());
                    z2 = true;
                } else if (odometerOffsets.getJ1939Src23Offset() != a.getJ1939Src23Offset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1939Src23Offset()) {
                z = true;
            }
            if (a.hasJ1587Mid128Offset()) {
                if (!odometerOffsets.hasJ1587Mid128Offset()) {
                    newBuilder.m14598f(a.getJ1587Mid128Offset());
                    z2 = true;
                } else if (odometerOffsets.getJ1587Mid128Offset() != a.getJ1587Mid128Offset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1587Mid128Offset()) {
                z = true;
            }
            if (a.hasJ1587Mid140Offset()) {
                if (!odometerOffsets.hasJ1587Mid140Offset()) {
                    newBuilder.m14597e(a.getJ1587Mid140Offset());
                    z2 = true;
                } else if (odometerOffsets.getJ1587Mid140Offset() != a.getJ1587Mid140Offset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1587Mid140Offset()) {
                z = true;
            }
            if (a.hasJ1587Mid142Offset()) {
                if (!odometerOffsets.hasJ1587Mid142Offset()) {
                    newBuilder.m14600g(a.getJ1587Mid142Offset());
                    z2 = true;
                } else if (odometerOffsets.getJ1587Mid142Offset() != a.getJ1587Mid142Offset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1587Mid142Offset()) {
                z = true;
            }
            if (a.hasJ1939HinoOdometerOffset()) {
                if (!odometerOffsets.hasJ1939HinoOdometerOffset()) {
                    newBuilder.m14604i(a.getJ1939HinoOdometerOffset());
                    z2 = true;
                } else if (odometerOffsets.getJ1939HinoOdometerOffset() != a.getJ1939HinoOdometerOffset()) {
                    z = true;
                }
            } else if (odometerOffsets.hasJ1939HinoOdometerOffset()) {
                z = true;
            }
            if (z) {
                C2134e.m10680d("TT-VehicleMgr", "Mismatch of odometer offsets. TruckId: " + truck.getTruckId() + " Truck Offsets: " + C2297q.m11245a(truck.getOdometerOffsets()) + " offsetBuilder: " + C2297q.m11245a(newBuilder.m14593c()));
            } else if (z2) {
                byte[] d;
                C2134e.m10678c("TT-VehicleMgr", "Updating truck record for truckId " + truck.getTruckId());
                if (c2369i.m11608g()) {
                    C2179d b = c2369i.m11609h().m10821b();
                    if (b != null && b.m10812b() == CanonicalOdometerSource.DASHLINK_FIRMWARE) {
                        d = m11412j().m8992d();
                        if (d != null) {
                            OurApplication.m6295q().m10050e(C2022a.m10081a(OurApplication.ac(), truck, d));
                        }
                        this.f8053e.m6554a(truck.getTruckNumber(), null, null, null, null, true, newBuilder.m14593c(), d);
                    }
                }
                d = null;
                if (d != null) {
                    OurApplication.m6295q().m10050e(C2022a.m10081a(OurApplication.ac(), truck, d));
                }
                this.f8053e.m6554a(truck.getTruckNumber(), null, null, null, null, true, newBuilder.m14593c(), d);
            }
        } else if (z2 != hasOdometerOffsets) {
            C2134e.m10680d("TT-VehicleMgr", "Unexpected mismatch of odometer offsets.  TruckId: " + truck.getTruckId() + " Truck Offsets: " + hasOdometerOffsets);
        }
    }

    public C2178c m11398a() {
        if (this.f8060l == null || this.f8061m == null || !this.f8060l.m11544g() || this.f8060l.m11541d() == null) {
            return null;
        }
        OdometerOffsets odometerOffsets = this.f8061m.getOdometerOffsets();
        C2369i e = this.f8060l.m11542e();
        if (e == null) {
            return null;
        }
        C2182e h = e.m11609h();
        if (h != null) {
            return h.m10818a(odometerOffsets);
        }
        return null;
    }

    public C2177b m11403b() {
        C2178c a = m11398a();
        return a == null ? null : a.m10809b();
    }

    public static VehicleConnectionManager m11359a(Context context, C2032f c2032f) {
        if (f8043a == null) {
            f8043a = new VehicleConnectionManager(c2032f);
        }
        return f8043a;
    }

    private VehicleConnectionManager(C2032f c2032f) {
        this.f8052d = c2032f;
        this.f8053e = c2032f.mo1300h();
        this.f8054f = c2032f.mo1309q();
        this.f8055g = c2032f.mo1314v();
        this.f8056h = c2032f.mo1296d();
        this.f8057i = c2032f.mo1294b();
        this.f8059k = new SearchState(c2032f);
        OurApplication.m6251H().m9119a(this.f8070v, Priority.DEFAULT);
        this.f8053e.m6560a(this.f8069u, com.bigroad.ttb.android.TruckManager.ChangeListener.Priority.DEFAULT);
        this.f8054f.m6060a(this.f8071w);
        OurApplication.m6267X().m9592a(this.f8072x);
        this.f8056h.m6311a(this.f8073y);
        this.f8057i.m10446a(this.f8074z);
        this.f8058j = C2338a.m11444a(this.f8055g);
        this.f8051c.post(new C23255(this));
        if (this.f8057i.m10450b()) {
            this.f8051c.postDelayed(this.f8048E, 300000);
        }
    }

    private void m11372a(MotionType motionType) {
        if (motionType != this.f8068t) {
            this.f8068t = motionType;
            C2134e.m10676b("TT-VehicleMgr", "Realtime motion: " + motionType + "; Vehicle motion: " + (this.f8060l != null ? this.f8060l.m11542e().m11612k().getMotionType() : "none"));
            m11396q();
        }
        if (motionType != MotionType.UNKNOWN_MOTION_TYPE) {
            this.f8051c.removeCallbacks(this.f8047D);
            this.f8051c.postDelayed(this.f8047D, 15000);
        }
    }

    public void m11402a(boolean z) {
        if (this.f8050b != z) {
            this.f8050b = z;
            m11390m();
        }
    }

    private void m11390m() {
        if (this.f8064p) {
            C2134e.m10680d("TT-VehicleMgr", "updating connection state during update connection state callback!");
            this.f8051c.removeCallbacks(this.f8045B);
            this.f8051c.post(this.f8045B);
            return;
        }
        this.f8064p = true;
        try {
            C2338a c2338a = this.f8058j;
            C2331a d = this.f8058j.m11456d();
            m11369a(c2338a, d);
            m11368a(d);
            this.f8058j = d.m11428e();
            if (!c2338a.equals(this.f8058j)) {
                if (this.f8058j.m11450a(ConnectionFlag.CONNECTED)) {
                    this.f8053e.m6561a(m11412j());
                }
                m11395p();
            }
            if (!c2338a.m11449a() && this.f8058j.m11449a()) {
                this.f8051c.removeCallbacks(this.f8046C);
                this.f8051c.postDelayed(this.f8046C, 120000);
            } else if (c2338a.m11449a() && !this.f8058j.m11449a()) {
                this.f8051c.removeCallbacks(this.f8046C);
            }
            this.f8064p = false;
        } catch (Throwable th) {
            this.f8064p = false;
        }
    }

    public boolean m11405c() {
        return m11406d().m11451a(ConnectionSetupFlag.REQUIRED);
    }

    public C2338a m11406d() {
        return this.f8058j;
    }

    public Truck m11407e() {
        return this.f8061m;
    }

    public int m11397a(int i) {
        int i2;
        EobrDevice j = m11412j();
        Truck e = m11407e();
        if (j == null || e == null) {
            i2 = -1;
        } else {
            i2 = j.m8977a(OurApplication.m6285g().m12191a(), OurApplication.m6285g().m12202d(), e.getTruckId(), i);
            this.f8060l.m11529a(i2);
            if (i == -1) {
                OurApplication.m6295q().m10068r();
            } else {
                OurApplication.m6295q().m10069s();
            }
        }
        if (i2 == -1) {
            C2134e.m10680d("TT-VehicleMgr", "Unable to write mobile client session start");
        }
        return i2;
    }

    public void m11408f() {
        EobrDevice j = m11412j();
        Truck e = m11407e();
        if (j == null || e == null || !e.hasOdometerOffsets()) {
            C2134e.m10680d("TT-VehicleMgr", "Unable to write odometer calibration data");
        } else {
            j.m8983a(e.getTruckId(), e.getOdometerOffsets());
        }
    }

    public void m11401a(CursorResetReason cursorResetReason, C1206c c1206c) {
        ExternalVarEntry c = ExternalVarEntry.newBuilder().m13994a(ExternalVarEntryType.CURSOR_RESET).m13989a(CursorReset.newBuilder().m12998a(cursorResetReason)).m14000c();
        EobrDevice j = m11412j();
        if (j != null) {
            j.m8990b(c.toByteArray(), c1206c);
        }
    }

    public boolean m11409g() {
        return this.f8060l != null;
    }

    public C2363e m11410h() {
        return this.f8060l;
    }

    public boolean m11411i() {
        return m11409g() && m11410h().m11544g();
    }

    public EobrDevice m11412j() {
        if (m11409g()) {
            return m11410h().m11541d();
        }
        return null;
    }

    public boolean m11413k() {
        return this.f8060l != null && this.f8068t == MotionType.MOVING;
    }

    public C2177b m11414l() {
        if (m11411i()) {
            C2369i e = this.f8060l.m11542e();
            if (e != null) {
                return e.m11604d(this.f8052d);
            }
        }
        return null;
    }

    private void m11378b(boolean z) {
        if (this.f8060l != null) {
            C2134e.m10676b("TT-VehicleMgr", "disconnect");
            this.f8060l.m11550m();
            Integer f = this.f8060l.m11536b().m11508f();
            if (f != null && this.f8062n.m11493a(f.intValue())) {
                Event a = C2022a.m10087a(EventType.DRIVER_LOGOUT, null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(OurApplication.m6285g().m12202d()), this.f8055g.mo914b(), null, this.f8060l.m11542e(), Long.valueOf((long) this.f8060l.m11536b().m11508f().intValue()), OurApplication.ac());
                if (a == null) {
                    C2134e.m10682e("TT-VehicleMgr", "Unable to create driver logout EOBR event (probably no truck in VehicleState)");
                } else if (z) {
                    C2134e.m10678c("TT-EobrLoginLogout", "Recording logout of session " + a.getContextualData());
                    OurApplication.m6295q().m10046d(a);
                } else {
                    OurApplication.m6295q().m10058i(a);
                    this.f8051c.postDelayed(this.f8049F, 60000);
                }
            }
            C2363e c2363e = this.f8060l;
            this.f8060l = null;
            this.f8061m = null;
            OurApplication.m6251H().m9121b(c2363e.m11541d());
            m11377b(c2363e);
        }
    }

    private void m11392n() {
        m11378b(true);
        this.f8059k.m11325b();
    }

    private boolean m11374a(EobrType eobrType, Long l) {
        if (eobrType == null || eobrType == EobrType.UNKNOWN_EOBR_TYPE || l == null || !an.m4194a(l.longValue()) || eobrType.m4937a(l.longValue())) {
            return false;
        }
        return true;
    }

    private boolean m11375a(Truck truck) {
        CharSequence charSequence = null;
        if (this.f8061m == null) {
            return false;
        }
        if (!am.m4189a(this.f8061m.getTruckNumber(), truck.getTruckNumber())) {
            return false;
        }
        byte[] d = truck.hasAssociatedDashLink() ? truck.getAssociatedDashLink().m19091d() : null;
        byte[] d2;
        if (this.f8061m.hasAssociatedDashLink()) {
            d2 = this.f8061m.getAssociatedDashLink().m19091d();
        } else {
            d2 = null;
        }
        if (d != null && Arrays.equals(d, r4)) {
            return true;
        }
        if (truck.hasGenxSerialNumber()) {
            charSequence = truck.getGenxSerialNumber();
        }
        if (!am.m4188a(charSequence) && charSequence.equals(this.f8061m.getGenxSerialNumber())) {
            return true;
        }
        CharSequence vin = truck.getVin();
        if (am.m4188a(vin) || !vin.equalsIgnoreCase(this.f8061m.getVin())) {
            return false;
        }
        return true;
    }

    private void m11369a(C2338a c2338a, C2331a c2331a) {
        EobrManager H = OurApplication.m6251H();
        c2331a.m11415a(ConnectionError.NONE);
        c2331a.m11426c(ConnectionSetupFlag.BACKGROUND_DISCONNECT_TIMEOUT);
        Truck f = this.f8053e.m6578f();
        CharSequence vin = f != null ? f.getVin() : null;
        C3642c associatedDashLink = f != null ? f.getAssociatedDashLink() : null;
        CharSequence genxSerialNumber = f != null ? f.getGenxSerialNumber() : null;
        if (f == null || !f.getHasAobrd()) {
            if (!this.f8059k.m11326c()) {
                C2134e.m10676b("TT-VehicleMgr", "Stop discovery: No AOBRD truck is required");
            }
            m11392n();
            c2331a.m11424c();
            return;
        }
        c2331a.m11422b(ConnectionSetupFlag.REQUIRED);
        if (this.f8056h.m6312a() || !this.f8057i.m10450b()) {
            this.f8066r = false;
        } else if (this.f8066r) {
            c2331a.m11422b(ConnectionSetupFlag.BACKGROUND_DISCONNECT_TIMEOUT);
            c2331a.m11425c(ConnectionFlag.CONNECTED);
            return;
        }
        if (!c2331a.m11419a(ConnectionFlag.CONNECTED)) {
            c2331a.m11422b(ConnectionSetupFlag.SEARCHING);
        }
        if (am.m4188a(vin) && ai.m4176a(associatedDashLink) && am.m4188a(genxSerialNumber)) {
            C2134e.m10676b("TT-VehicleMgr", "Stop discovery: AOBRD truck is not configured properly");
            m11392n();
            c2331a.m11415a(ConnectionError.EOBR_NOT_CONFIGURED);
            return;
        }
        if (!(m11407e() == null || m11375a(f))) {
            C2134e.m10676b("TT-VehicleMgr", "Truck change detected");
            m11378b(true);
            this.f8059k.m11325b();
            c2331a.m11426c(ConnectionSetupFlag.RECONNECTING);
            c2331a.m11425c(ConnectionFlag.CONNECTED);
            c2331a.m11422b(ConnectionSetupFlag.SEARCHING);
        }
        long b = this.f8056h.m6313b();
        long c = this.f8055g.mo915c() - this.f8065q;
        EobrDevice a = H.m9112a(f);
        if (a != null) {
            Object obj;
            this.f8059k.m11323a(a);
            if (c2331a.m11420a(ConnectionSetupFlag.SEARCHING)) {
                C2134e.m10676b("TT-VehicleMgr", "CONNECTED to correct EobrDevice");
                if (this.f8060l != null) {
                    C2134e.m10680d("TT-VehicleMgr", "Ending unexpected vehicle session");
                    this.f8060l = null;
                }
            } else if (!c2331a.m11419a(ConnectionFlag.CONNECTED)) {
                C2134e.m10680d("TT-VehicleMgr", "Unexpected VehicleStatus (" + c2331a + ") when a connected EOBR device was found. Expected CONNECTED to be active.");
            }
            c2331a.m11426c(ConnectionSetupFlag.SEARCHING);
            c2331a.m11426c(ConnectionSetupFlag.RECONNECTING);
            long u = a.m9009u();
            if (!this.f8056h.m6312a() && this.f8057i.m10450b()) {
                if (C3607b.m18844a(b, c, u) > 300000) {
                    obj = 1;
                    if (obj == null) {
                        this.f8066r = true;
                        c2331a.m11422b(ConnectionSetupFlag.BACKGROUND_DISCONNECT_TIMEOUT);
                        c2331a.m11425c(ConnectionFlag.CONNECTED);
                        m11378b(true);
                        return;
                    }
                    c2331a.m11421b(ConnectionFlag.CONNECTED);
                    if (this.f8060l == null) {
                        if (!(this.f8062n == null || f.getTruckId() == this.f8062n.m11491a())) {
                            C2134e.m10678c("TT-VehicleMgr", "Truck changed, dropping current EOBR login session for truck " + this.f8062n.m11491a());
                            this.f8062n = null;
                        }
                        if (this.f8062n == null) {
                            C2134e.m10678c("TT-VehicleMgr", "Creating new EOBR login session tracker for truck " + f.getTruckId());
                            this.f8062n = new C2355b(f);
                        }
                        this.f8060l = new C2363e(a, this.f8044A, this.f8062n, OurApplication.ac());
                        this.f8061m = f;
                        c2331a.m11416a(ConnectionFlag.EOBR_TYPE_MATCH, m11374a(a.mo1121o(), Long.valueOf(f.getSupportedBusTypes())));
                        m11370a(this.f8060l);
                        return;
                    }
                    return;
                }
            }
            obj = null;
            if (obj == null) {
                c2331a.m11421b(ConnectionFlag.CONNECTED);
                if (this.f8060l == null) {
                    C2134e.m10678c("TT-VehicleMgr", "Truck changed, dropping current EOBR login session for truck " + this.f8062n.m11491a());
                    this.f8062n = null;
                    if (this.f8062n == null) {
                        C2134e.m10678c("TT-VehicleMgr", "Creating new EOBR login session tracker for truck " + f.getTruckId());
                        this.f8062n = new C2355b(f);
                    }
                    this.f8060l = new C2363e(a, this.f8044A, this.f8062n, OurApplication.ac());
                    this.f8061m = f;
                    if (m11374a(a.mo1121o(), Long.valueOf(f.getSupportedBusTypes()))) {
                    }
                    c2331a.m11416a(ConnectionFlag.EOBR_TYPE_MATCH, m11374a(a.mo1121o(), Long.valueOf(f.getSupportedBusTypes())));
                    m11370a(this.f8060l);
                    return;
                }
                return;
            }
            this.f8066r = true;
            c2331a.m11422b(ConnectionSetupFlag.BACKGROUND_DISCONNECT_TIMEOUT);
            c2331a.m11425c(ConnectionFlag.CONNECTED);
            m11378b(true);
            return;
        }
        boolean z;
        byte[] bArr;
        if (c2331a.m11419a(ConnectionFlag.CONNECTED)) {
            c2331a.m11422b(ConnectionSetupFlag.RECONNECTING);
            c2331a.m11427d();
            this.f8059k.m11325b();
        }
        m11378b(false);
        c2331a.m11425c(ConnectionFlag.EOBR_TYPE_MATCH);
        if (!this.f8050b) {
            BluetoothStatus d = this.f8054f.m6063d();
            if (d == BluetoothStatus.DISABLED || d == BluetoothStatus.UNSUPPORTED) {
                C2134e.m10676b("TT-VehicleMgr", "Stop discovery: Bluetooth is not enabled");
                m11392n();
                if (d == BluetoothStatus.UNSUPPORTED) {
                    c2331a.m11415a(ConnectionError.BLUETOOTH_NOT_SUPPORTED);
                    return;
                } else {
                    c2331a.m11415a(ConnectionError.BLUETOOTH_NOT_ENABLED);
                    return;
                }
            }
        }
        c2331a.m11422b(ConnectionSetupFlag.SEARCHING);
        long j = 0;
        Long b2 = c2338a.m11454b(ConnectionSetupFlag.SEARCHING);
        if (b2 != null) {
            j = this.f8055g.mo915c() - b2.longValue();
        }
        if (!this.f8056h.m6312a() && this.f8057i.m10450b()) {
            if (C3607b.m18844a(b, c, j) > 300000) {
                z = true;
                c2331a.m11417a(ConnectionSetupFlag.BACKGROUND_SEARCH_TIMEOUT, z);
                if (z) {
                    bArr = null;
                    if (f.hasLastConnectedDashLink()) {
                        bArr = f.getLastConnectedDashLink().m19091d();
                    }
                    this.f8059k.m11324a(bArr);
                    return;
                }
                this.f8059k.m11325b();
            }
        }
        z = false;
        c2331a.m11417a(ConnectionSetupFlag.BACKGROUND_SEARCH_TIMEOUT, z);
        if (z) {
            bArr = null;
            if (f.hasLastConnectedDashLink()) {
                bArr = f.getLastConnectedDashLink().m19091d();
            }
            this.f8059k.m11324a(bArr);
            return;
        }
        this.f8059k.m11325b();
    }

    private void m11394o() {
        C2338a c2338a = this.f8058j;
        C2331a d = this.f8058j.m11456d();
        m11368a(d);
        this.f8058j = d.m11428e();
        if (!this.f8058j.equals(c2338a)) {
            m11395p();
        }
    }

    private void m11368a(C2331a c2331a) {
        C2179d c2179d = null;
        boolean z = true;
        if (c2331a.m11418a()) {
            C2369i c2369i;
            boolean z2;
            boolean i = m11411i();
            c2331a.m11416a(ConnectionFlag.CURRENT, i);
            if (i) {
                C2369i e = this.f8060l.m11542e();
                RelativeTimestamp a = this.f8060l.m11528a();
                ConnectionFlag connectionFlag = ConnectionFlag.ABSOLUTE_TIMESTAMP;
                i = a != null && a.hasAbsoluteTimeMillis();
                c2331a.m11416a(connectionFlag, i);
                c2369i = e;
            } else {
                c2331a.m11425c(ConnectionFlag.ABSOLUTE_TIMESTAMP);
                c2369i = null;
            }
            if (this.f8060l == null || this.f8060l.m11539c() != ProcessingState.CORRUPT_ENTRIES_DETECTED) {
                z2 = false;
            } else {
                z2 = true;
            }
            c2331a.m11417a(ConnectionSetupFlag.CORRUPTED, z2);
            EobrDevice a2 = OurApplication.m6251H().m9112a(this.f8061m);
            Truck truck = this.f8061m;
            if (!(a2 == null || truck == null)) {
                if (m11374a(a2.mo1121o(), Long.valueOf(truck.getSupportedBusTypes()))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                c2331a.m11416a(ConnectionFlag.EOBR_TYPE_MATCH, z2);
            }
            if (c2369i != null) {
                boolean z3;
                C2182e h = c2369i.m11609h();
                if (h != null) {
                    c2179d = h.m10821b();
                }
                if (c2369i.m11594a(this.f8052d) != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                C2177b d = c2369i.m11604d(this.f8052d);
                boolean z4;
                if (d == null || d.m10803b().m5465a()) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (d == null && r4 == null) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (c2369i.m11622u() != null) {
                    if (!z3 || ((long) c2369i.m11622u().intValue()) >= 15) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                }
                c2331a.m11416a(ConnectionFlag.ODOMETER_READINGS_VALID, z3);
                ConnectionFlag connectionFlag2 = ConnectionFlag.ODOMETER_CALIBRATED;
                if (z2 || !r5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2331a.m11416a(connectionFlag2, z2);
                ConnectionFlag connectionFlag3 = ConnectionFlag.ENGINE_ON;
                if (c2369i.m11615n() == EngineUseState.ENGINE_ON) {
                    i = true;
                } else {
                    i = false;
                }
                c2331a.m11416a(connectionFlag3, i);
            } else {
                c2331a.m11425c(ConnectionFlag.ODOMETER_READINGS_VALID);
                c2331a.m11425c(ConnectionFlag.ODOMETER_CALIBRATED);
                c2331a.m11425c(ConnectionFlag.ENGINE_ON);
            }
            if (m11412j().mo1121o() == EobrType.TURBO) {
                c2331a.m11417a(ConnectionSetupFlag.TURBO_FIRMWARE_UPDATING, OurApplication.m6267X().m9594a());
                c2331a.m11416a(ConnectionFlag.TURBO_FIRMWARE_VALID, OurApplication.m6267X().m9595b());
                return;
            } else if (m11412j().mo1121o() == EobrType.GENX) {
                c2331a.m11426c(ConnectionSetupFlag.FIRMWARE_DETECTING);
                c2331a.m11426c(ConnectionSetupFlag.FIRMWARE_INCOMPATIBLE);
                C1098j v = m11412j().m9010v();
                if (v == null) {
                    c2331a.m11422b(ConnectionSetupFlag.FIRMWARE_DETECTING);
                    c2331a.m11426c(ConnectionSetupFlag.FIRMWARE_INCOMPATIBLE);
                    return;
                }
                c2331a.m11426c(ConnectionSetupFlag.FIRMWARE_DETECTING);
                ConnectionSetupFlag connectionSetupFlag = ConnectionSetupFlag.FIRMWARE_INCOMPATIBLE;
                if (C1919c.m9417b(v)) {
                    z = false;
                }
                c2331a.m11417a(connectionSetupFlag, z);
                return;
            } else {
                return;
            }
        }
        c2331a.m11427d();
    }

    private void m11370a(final C2363e c2363e) {
        C2134e.m10676b("TT-VehicleMgr", "notifyEobrConnected: " + this.f8058j);
        m11371a(c2363e.m11542e());
        m11363a(c2363e.m11539c());
        this.f8067s.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ VehicleConnectionManager f8032b;

            public void m11350a(ChangeListener changeListener) {
                changeListener.mo889a(c2363e);
            }
        });
    }

    private void m11377b(final C2363e c2363e) {
        C2134e.m10676b("TT-VehicleMgr", "notifyEobrDisconnected: " + this.f8058j);
        m11371a(null);
        m11363a(ProcessingState.NOT_PROCESSING);
        this.f8067s.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ VehicleConnectionManager f8034b;

            public void m11352a(ChangeListener changeListener) {
                changeListener.mo892b(c2363e);
            }
        });
    }

    private void m11395p() {
        C2134e.m10676b("TT-VehicleMgr", "notifyConnectionStateChanged: " + this.f8058j);
        this.f8067s.m4157a(new C23288(this));
    }

    private void m11371a(final C2369i c2369i) {
        this.f8067s.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ VehicleConnectionManager f8037b;

            public void m11356a(ChangeListener changeListener) {
                changeListener.mo890a(c2369i);
            }
        });
    }

    private void m11363a(final ProcessingState processingState) {
        this.f8067s.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ VehicleConnectionManager f8014b;

            public void m11328a(ChangeListener changeListener) {
                changeListener.mo887a(processingState);
            }
        });
    }

    private void m11396q() {
        C2134e.m10676b("TT-VehicleMgr", "notifyRealtimeMotionChange: " + this.f8068t);
        this.f8067s.m4157a(new C0837a<ChangeListener>(this) {
            final /* synthetic */ VehicleConnectionManager f8015a;

            {
                this.f8015a = r1;
            }

            public void m11330a(ChangeListener changeListener) {
                changeListener.mo891a(this.f8015a.f8068t);
            }
        });
    }

    public void m11400a(ChangeListener changeListener, Priority priority) {
        this.f8067s.m4159a(changeListener, priority.ordinal());
    }

    public void m11399a(ChangeListener changeListener) {
        m11400a(changeListener, Priority.DEFAULT);
    }

    public void m11404b(ChangeListener changeListener) {
        this.f8067s.m4158a((Object) changeListener);
    }
}
