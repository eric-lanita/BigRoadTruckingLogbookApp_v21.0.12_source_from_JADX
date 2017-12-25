package com.bigroad.ttb.android.eobr;

import android.os.Handler;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.C1181z;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.genx.C0986i;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage.FirmwareUpdateRequest;
import com.bigroad.shared.eobr.turbo.messages.ac;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.p038g.C2078a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import java.io.Closeable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public abstract class C1902e implements Closeable {
    protected Handler f6556a = new Handler();
    protected C1856a f6557b;
    protected C2078a f6558c;
    protected EobrReader f6559d;
    protected EobrWriter f6560e;
    protected int f6561f = 1;
    protected final Queue<C1901b> f6562g = new LinkedList();
    protected final Runnable f6563h = new C18911(this);
    protected final Runnable f6564i = new C18955(this);
    protected final Runnable f6565j = new C18966(this);
    protected final Runnable f6566k = new C18977(this);
    protected final Runnable f6567l = new C18988(this);
    protected final Runnable f6568m = new C18999(this);
    private C2182e f6569n;
    private C1890b f6570o = C1890b.f6522b;
    private String f6571p;
    private long f6572q = 0;
    private EngineUseState f6573r = EngineUseState.ENGINE_USE_UNKNOWN;
    private long f6574s = -1;
    private Long f6575t = null;
    private Long f6576u = null;
    private final Set<Integer> f6577v = new HashSet();
    private final Runnable f6578w = new Runnable(this) {
        final /* synthetic */ C1902e f6528a;

        {
            this.f6528a = r1;
        }

        public void run() {
            this.f6528a.m9278a(false);
            this.f6528a.f6556a.postDelayed(this.f6528a.f6578w, 5000);
        }
    };

    public interface C1206c {
        void mo897a(C0972e c0972e, C0973f c0973f);
    }

    public interface C1856a {
        void mo1072a(C1902e c1902e);

        void mo1073a(C1902e c1902e, C1051n c1051n, long j, long j2);

        void mo1074b(C1902e c1902e);

        void mo1075c(C1902e c1902e);
    }

    class C18911 implements Runnable {
        final /* synthetic */ C1902e f6533a;

        C18911(C1902e c1902e) {
            this.f6533a = c1902e;
        }

        public void run() {
            this.f6533a.f6560e.m9209c();
            this.f6533a.f6556a.postDelayed(this.f6533a.f6563h, 4000);
        }
    }

    class C18955 implements Runnable {
        final /* synthetic */ C1902e f6541a;

        C18955(C1902e c1902e) {
            this.f6541a = c1902e;
        }

        public void run() {
            this.f6541a.f6560e.m9211d();
            this.f6541a.f6556a.postDelayed(this.f6541a.f6564i, 4000);
        }
    }

    class C18966 implements Runnable {
        final /* synthetic */ C1902e f6542a;

        C18966(C1902e c1902e) {
            this.f6542a = c1902e;
        }

        public void run() {
            this.f6542a.f6556a.removeCallbacks(this.f6542a.f6567l);
            this.f6542a.f6556a.postDelayed(this.f6542a.f6567l, 30000);
        }
    }

    class C18977 implements Runnable {
        final /* synthetic */ C1902e f6543a;

        C18977(C1902e c1902e) {
            this.f6543a = c1902e;
        }

        public void run() {
            this.f6543a.close();
            this.f6543a.f6557b.mo1075c(this.f6543a);
        }
    }

    class C18988 implements Runnable {
        final /* synthetic */ C1902e f6544a;

        C18988(C1902e c1902e) {
            this.f6544a = c1902e;
        }

        public void run() {
            C2134e.m10678c("TT-EobrDriver", "Bluetooth connection timed out");
            this.f6544a.f6566k.run();
        }
    }

    class C18999 implements Runnable {
        final /* synthetic */ C1902e f6545a;

        C18999(C1902e c1902e) {
            this.f6545a = c1902e;
        }

        public void run() {
            this.f6545a.f6560e.m9212e();
            this.f6545a.f6556a.postDelayed(this.f6545a.f6568m, 1000);
        }
    }

    public class C1901b {
        final /* synthetic */ C1902e f6548a;
        private final C0972e f6549b;
        private final C1206c f6550c;
        private final long f6551d;
        private Long f6552e;
        private final boolean f6553f;
        private int f6554g;
        private Long f6555h;

        C1901b(C1902e c1902e, C0972e c0972e, C1206c c1206c, long j, Long l, boolean z) {
            this.f6548a = c1902e;
            this.f6549b = c0972e;
            this.f6550c = c1206c;
            this.f6551d = j;
            this.f6552e = l;
            this.f6553f = z;
            this.f6554g = 0;
            this.f6555h = null;
        }

        public void m9239a(long j) {
            if (this.f6555h == null && this.f6552e != null) {
                this.f6552e = Long.valueOf(this.f6552e.longValue() + (j - this.f6551d));
            }
            this.f6555h = Long.valueOf(j);
        }

        C1901b(C1902e c1902e, C1901b c1901b, long j) {
            this.f6548a = c1902e;
            this.f6549b = c1901b.f6549b;
            this.f6550c = c1901b.f6550c;
            this.f6551d = j;
            this.f6552e = c1901b.f6552e;
            this.f6553f = c1901b.f6553f;
            this.f6554g = 0;
            this.f6555h = c1901b.f6555h;
        }

        public C0972e m9237a() {
            return this.f6549b;
        }

        public void m9240a(final C0973f c0973f) {
            if (this.f6550c != null && this.f6548a.f6556a != null) {
                this.f6548a.f6556a.post(new Runnable(this) {
                    final /* synthetic */ C1901b f6547b;

                    public void run() {
                        this.f6547b.f6550c.mo897a(this.f6547b.f6549b, c0973f);
                    }
                });
            }
        }

        public String m9238a(String str, long j) {
            if (this.f6555h == null) {
                return "Message not marked as written, are you using GpsRemote?";
            }
            return this.f6549b.mo757a() + " " + str + " InQueue: " + (this.f6555h.longValue() - this.f6551d) + "ms InFlight: " + (j - this.f6555h.longValue()) + "ms";
        }
    }

    public abstract int mo1123a(byte[] bArr, long j, long j2, int i);

    public abstract long mo1124a();

    public abstract void mo1125a(long j, long j2);

    public abstract void mo1126a(long j, C1206c c1206c);

    public abstract void mo1127a(long j, OdometerOffsets odometerOffsets);

    public abstract void mo1129a(C0986i c0986i, C1206c c1206c);

    public abstract void mo1130a(FirmwareUpdateRequest firmwareUpdateRequest, byte[] bArr, C1206c c1206c);

    protected abstract void mo1131a(C1901b c1901b);

    public abstract void mo1132a(C1206c c1206c);

    public abstract void mo1133a(short s, long j);

    public abstract void mo1134a(byte[] bArr, C1206c c1206c);

    public abstract C1098j mo1135b();

    public abstract void mo1137b(byte[] bArr, C1206c c1206c);

    public abstract String mo1138c();

    public abstract boolean mo1140d();

    protected abstract int mo1141m();

    protected abstract long mo1142q();

    protected void m9274a(C2078a c2078a, C1856a c1856a, EobrReader eobrReader, EobrWriter eobrWriter) {
        this.f6558c = c2078a;
        this.f6557b = c1856a;
        this.f6559d = eobrReader;
        this.f6560e = eobrWriter;
        this.f6565j.run();
        this.f6559d.start();
        this.f6560e.start();
        m9292j();
        this.f6568m.run();
    }

    public void close() {
        this.f6559d.m9181a();
        this.f6560e.m9197a();
        C1181z.m5999a(this.f6558c);
        this.f6556a.removeCallbacks(this.f6568m);
        this.f6556a.removeCallbacks(this.f6563h);
        this.f6556a.removeCallbacks(this.f6564i);
        this.f6556a.removeCallbacks(this.f6565j);
        this.f6556a.removeCallbacks(this.f6566k);
        this.f6556a.removeCallbacks(this.f6567l);
    }

    public C2182e m9287e() {
        return this.f6569n;
    }

    public String m9288f() {
        return this.f6571p;
    }

    public long m9289g() {
        return this.f6572q;
    }

    public long m9290h() {
        if (this.f6575t == null) {
            return 0;
        }
        return this.f6574s - this.f6575t.longValue();
    }

    public long m9291i() {
        if (this.f6576u == null) {
            return 0;
        }
        return this.f6574s - this.f6576u.longValue();
    }

    public void m9258a(int i) {
        this.f6560e.mo1161c(i);
    }

    public void m9292j() {
        this.f6560e.mo1154a(mo1135b());
    }

    void m9293k() {
        this.f6556a.post(this.f6565j);
    }

    public void m9275a(final C2182e c2182e) {
        this.f6556a.post(new Runnable(this) {
            final /* synthetic */ C1902e f6530b;

            public void run() {
                this.f6530b.f6569n = c2182e;
                this.f6530b.f6557b.mo1072a(this.f6530b);
            }
        });
    }

    void m9270a(final C1890b c1890b) {
        this.f6556a.post(new Runnable(this) {
            final /* synthetic */ C1902e f6532b;

            public void run() {
                this.f6532b.f6570o = c1890b;
                this.f6532b.f6557b.mo1072a(this.f6532b);
            }
        });
    }

    public void mo1177a(final String str, boolean z) {
        this.f6556a.post(new Runnable(this) {
            final /* synthetic */ C1902e f6535b;

            public void run() {
                this.f6535b.f6571p = str;
                this.f6535b.f6557b.mo1072a(this.f6535b);
            }
        });
    }

    public void m9259a(final long j) {
        this.f6556a.post(new Runnable(this) {
            final /* synthetic */ C1902e f6537b;

            public void run() {
                this.f6537b.f6572q = j;
                this.f6537b.f6557b.mo1072a(this.f6537b);
            }
        });
    }

    void m9269a(final EngineUseState engineUseState, final long j) {
        this.f6556a.post(new Runnable(this) {
            final /* synthetic */ C1902e f6540c;

            public void run() {
                this.f6540c.f6574s = j;
                if (this.f6540c.f6573r != engineUseState) {
                    if (engineUseState == EngineUseState.ENGINE_ON) {
                        this.f6540c.f6575t = Long.valueOf(j);
                        this.f6540c.f6576u = null;
                    } else {
                        this.f6540c.f6576u = Long.valueOf(j);
                        this.f6540c.f6575t = null;
                    }
                    this.f6540c.f6573r = engineUseState;
                    this.f6540c.f6557b.mo1072a(this.f6540c);
                }
            }
        });
    }

    public void m9294l() {
        this.f6556a.post(this.f6566k);
    }

    protected ac m9257a(int i, long j, OdometerOffsets odometerOffsets) {
        if (odometerOffsets == null) {
            return null;
        }
        int[] iArr = new int[OdometerSource.values().length];
        boolean[] zArr = new boolean[OdometerSource.values().length];
        if (odometerOffsets.hasJ1939HrSrc23Offset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_INSTRUMENT_CLUSTER.ordinal()] = odometerOffsets.getJ1939HrSrc23Offset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_INSTRUMENT_CLUSTER.ordinal()] = true;
        }
        if (odometerOffsets.hasJ1939Src23Offset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1939_INSTRUMENT_CLUSTER.ordinal()] = odometerOffsets.getJ1939Src23Offset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1939_INSTRUMENT_CLUSTER.ordinal()] = true;
        }
        if (odometerOffsets.hasJ1587Mid140Offset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1587_INSTRUMENT_CLUSTER.ordinal()] = odometerOffsets.getJ1587Mid140Offset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1587_INSTRUMENT_CLUSTER.ordinal()] = true;
        }
        if (odometerOffsets.hasJ1939HrSrc0Offset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_ENGINE_1.ordinal()] = odometerOffsets.getJ1939HrSrc0Offset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_ENGINE_1.ordinal()] = true;
        }
        if (odometerOffsets.hasJ1939Src0Offset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1939_ENGINE_1.ordinal()] = odometerOffsets.getJ1939Src0Offset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1939_ENGINE_1.ordinal()] = true;
        }
        if (odometerOffsets.hasJ1587Mid128Offset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1587_ENGINE_1.ordinal()] = odometerOffsets.getJ1587Mid128Offset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1587_ENGINE_1.ordinal()] = true;
        }
        if (odometerOffsets.hasJ1587Mid142Offset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1587_VEHICLE_MANAGEMENT_SYSTEM.ordinal()] = odometerOffsets.getJ1587Mid142Offset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1587_VEHICLE_MANAGEMENT_SYSTEM.ordinal()] = true;
        }
        if (odometerOffsets.hasJ1939HinoOdometerOffset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_J1939_HINO.ordinal()] = odometerOffsets.getJ1939HinoOdometerOffset();
            zArr[OdometerSource.ODOMETER_SOURCE_J1939_HINO.ordinal()] = true;
        }
        if (odometerOffsets.hasDashlinkFirmwareOffset()) {
            iArr[OdometerSource.ODOMETER_SOURCE_DASHLINK_FIRMWARE.ordinal()] = odometerOffsets.getDashlinkFirmwareOffset();
            zArr[OdometerSource.ODOMETER_SOURCE_DASHLINK_FIRMWARE.ordinal()] = true;
        }
        return new ac(i, j, iArr, zArr);
    }

    protected void m9296n() {
        this.f6556a.post(this.f6578w);
    }

    protected void m9297o() {
        this.f6556a.removeCallbacks(this.f6578w);
        m9278a(true);
    }

    protected long m9298p() {
        return OurApplication.m6269Z().mo915c();
    }

    protected void m9264a(C0972e c0972e, C1206c c1206c, Long l, boolean z) {
        m9251b(new C1901b(this, c0972e, c1206c, m9298p(), l, z));
    }

    private void m9251b(C1901b c1901b) {
        synchronized (this.f6562g) {
            this.f6577v.add(Integer.valueOf(c1901b.f6549b.mo757a()));
            Queue<C1901b> linkedList = new LinkedList();
            while (this.f6562g.size() >= mo1141m()) {
                C1901b c1901b2 = (C1901b) this.f6562g.remove();
                m9252c(c1901b2);
                C2134e.m10680d("TT-EobrDriver", "Response callback queue is full. Removed callback for requestId=" + c1901b2.f6549b.mo757a());
                linkedList.add(c1901b2);
                m9272a(c1901b2, null);
            }
            for (C1901b c1901b22 : linkedList) {
                m9253d(c1901b22.m9237a());
            }
            this.f6562g.add(c1901b);
        }
        mo1131a(c1901b);
    }

    protected void mo1128a(C0972e c0972e) {
    }

    private void m9253d(C0972e c0972e) {
        try {
            mo1128a(c0972e);
        } catch (Throwable th) {
            C2134e.m10681d("TT-EobrDriver", "Unexpected exception raised when signaling request expiry", th);
        }
    }

    protected void mo1136b(C0972e c0972e) {
    }

    private void m9254e(C0972e c0972e) {
        try {
            mo1136b(c0972e);
        } catch (Throwable th) {
            C2134e.m10681d("TT-EobrDriver", "Unexpected exception raised when signaling request expiry", th);
        }
    }

    public void m9285c(C0972e c0972e) {
        C2134e.m10680d("TT-EobrDriver", "No response for request " + c0972e);
    }

    private void m9252c(C1901b c1901b) {
        c1901b.f6554g = c1901b.f6554g + 1;
        m9285c(c1901b.f6549b);
    }

    public void m9278a(boolean z) {
        synchronized (this.f6562g) {
            long p = m9298p();
            Queue<C1901b> linkedList = new LinkedList();
            Queue<C1901b> linkedList2 = new LinkedList();
            Object obj = null;
            Iterator it = this.f6562g.iterator();
            while (it.hasNext()) {
                Object obj2;
                C1901b c1901b = (C1901b) it.next();
                if (z) {
                    C2134e.m10678c("TT-EobrDriver", "Dropping pending request " + c1901b.f6549b);
                    m9272a(c1901b, null);
                    it.remove();
                    obj2 = obj;
                } else if (c1901b.f6555h != null) {
                    if (c1901b.f6552e == null || p < c1901b.f6552e.longValue()) {
                        if (p >= c1901b.f6555h.longValue() + mo1142q()) {
                            if (c1901b.f6553f) {
                                C2134e.m10676b("TT-EobrDriver", "Timeout for requestId=" + c1901b.f6549b.mo757a());
                                C2134e.m10673a("TT-EobrDriver-Timing", c1901b.m9238a("timeout/retry", m9298p()));
                                m9252c(c1901b);
                                if (mo1140d()) {
                                    it.remove();
                                    linkedList.add(c1901b);
                                    obj2 = obj;
                                } else {
                                    obj2 = 1;
                                }
                            } else if (p >= c1901b.f6555h.longValue() + 300000 && c1901b.f6552e == null && c1901b.f6554g <= 0) {
                                m9252c(c1901b);
                                C2134e.m10680d("TT-EobrDriver", "No longer expecting a response for requestId=" + c1901b.f6549b.mo757a());
                                C2134e.m10673a("TT-EobrDriver-Timing", c1901b.m9238a("abandoned", m9298p()));
                            }
                        }
                        obj2 = obj;
                    } else {
                        m9252c(c1901b);
                        C2134e.m10680d("TT-EobrDriver", "Expiring stale requestId=" + c1901b.f6549b.mo757a());
                        C2134e.m10673a("TT-EobrDriver-Timing", c1901b.m9238a("expired", m9298p()));
                        linkedList2.add(c1901b);
                        m9272a(c1901b, null);
                        it.remove();
                        obj2 = obj;
                    }
                }
                obj = obj2;
            }
            for (C1901b c1901b2 : linkedList2) {
                m9253d(c1901b2.m9237a());
            }
            for (C1901b c1901b22 : linkedList) {
                C1901b c1901b3 = new C1901b(this, c1901b22, p);
                C2134e.m10680d("TT-EobrDriver", "Retrying requestId=" + c1901b3.f6549b.mo757a() + " by adding it to the end of the queue");
                m9251b(c1901b3);
            }
            if (obj != null) {
                C2134e.m10680d("TT-EobrDriver", "Retrying requestId=" + ((C1901b) this.f6562g.peek()).f6549b.mo757a() + " immediately");
                mo1131a(new C1901b(this, (C1901b) this.f6562g.peek(), m9298p()));
            }
        }
    }

    public void m9265a(C0972e c0972e, C1206c c1206c, boolean z) {
        m9282b(c0972e, c1206c, null, z);
    }

    public void m9282b(C0972e c0972e, C1206c c1206c, Long l, boolean z) {
        m9264a(c0972e, c1206c, l, z);
    }

    public void m9272a(C1901b c1901b, C0973f c0973f) {
        try {
            c1901b.m9240a(c0973f);
        } catch (Throwable th) {
            C2134e.m10681d("TT-EobrDriver", "Unexpected exception raised from EOBR reqeust callback", th);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m9266a(com.bigroad.shared.eobr.C0973f r9) {
        /*
        r8 = this;
        r2 = r8.f6562g;
        monitor-enter(r2);
        r0 = 0;
        r1 = r8.f6577v;	 Catch:{ all -> 0x008b }
        r3 = r9.mo743e();	 Catch:{ all -> 0x008b }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x008b }
        r1 = r1.contains(r3);	 Catch:{ all -> 0x008b }
        if (r1 == 0) goto L_0x008e;
    L_0x0014:
        r0 = r8.f6577v;	 Catch:{ all -> 0x008b }
        r1 = r9.mo743e();	 Catch:{ all -> 0x008b }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x008b }
        r0.remove(r1);	 Catch:{ all -> 0x008b }
        r0 = 1;
        r1 = r0;
    L_0x0023:
        r0 = r8.f6562g;	 Catch:{ all -> 0x008b }
        r3 = r0.iterator();	 Catch:{ all -> 0x008b }
    L_0x0029:
        r0 = r3.hasNext();	 Catch:{ all -> 0x008b }
        if (r0 == 0) goto L_0x0061;
    L_0x002f:
        r0 = r3.next();	 Catch:{ all -> 0x008b }
        r0 = (com.bigroad.ttb.android.eobr.C1902e.C1901b) r0;	 Catch:{ all -> 0x008b }
        r4 = r0.f6549b;	 Catch:{ all -> 0x008b }
        r4 = r4.mo757a();	 Catch:{ all -> 0x008b }
        r5 = r9.mo743e();	 Catch:{ all -> 0x008b }
        if (r4 != r5) goto L_0x0029;
    L_0x0043:
        r1 = "TT-EobrDriver-Timing";
        r4 = "successful";
        r6 = r8.m9298p();	 Catch:{ all -> 0x008b }
        r4 = r0.m9238a(r4, r6);	 Catch:{ all -> 0x008b }
        com.bigroad.ttb.android.logging.C2134e.m10673a(r1, r4);	 Catch:{ all -> 0x008b }
        r8.m9272a(r0, r9);	 Catch:{ all -> 0x008b }
        r3.remove();	 Catch:{ all -> 0x008b }
        r0 = r0.f6549b;	 Catch:{ all -> 0x008b }
        r8.m9254e(r0);	 Catch:{ all -> 0x008b }
        monitor-exit(r2);	 Catch:{ all -> 0x008b }
    L_0x0060:
        return;
    L_0x0061:
        if (r1 != 0) goto L_0x0089;
    L_0x0063:
        r0 = "TT-EobrDriver";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008b }
        r1.<init>();	 Catch:{ all -> 0x008b }
        r3 = "Unexpected response ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x008b }
        r3 = r9.mo743e();	 Catch:{ all -> 0x008b }
        r1 = r1.append(r3);	 Catch:{ all -> 0x008b }
        r3 = ": ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x008b }
        r1 = r1.append(r9);	 Catch:{ all -> 0x008b }
        r1 = r1.toString();	 Catch:{ all -> 0x008b }
        com.bigroad.ttb.android.logging.C2134e.m10680d(r0, r1);	 Catch:{ all -> 0x008b }
    L_0x0089:
        monitor-exit(r2);	 Catch:{ all -> 0x008b }
        goto L_0x0060;
    L_0x008b:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x008b }
        throw r0;
    L_0x008e:
        r1 = r0;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.eobr.e.a(com.bigroad.shared.eobr.f):void");
    }

    public synchronized int mo1143r() {
        int i;
        i = this.f6561f;
        this.f6561f = i + 1;
        return i;
    }
}
