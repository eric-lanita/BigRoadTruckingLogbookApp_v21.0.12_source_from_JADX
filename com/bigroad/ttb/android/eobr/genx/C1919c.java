package com.bigroad.ttb.android.eobr.genx;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import com.bigroad.shared.C1098j;
import com.bigroad.shared.aj;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.genx.C0982e;
import com.bigroad.shared.eobr.genx.C0986i;
import com.bigroad.shared.eobr.genx.C0990p;
import com.bigroad.shared.eobr.genx.C0991q;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.FirmwareUpdateRequestMessage.FirmwareUpdateRequest;
import com.bigroad.ttb.android.eobr.C1902e;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.C1902e.C1856a;
import com.bigroad.ttb.android.eobr.C1902e.C1901b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p038g.C2078a;
import com.bigroad.ttb.android.util.C2281d;
import com.bigroad.ttb.protocol.TTProtocol.EobrSessionLogEntry;
import com.bigroad.ttb.protocol.TTProtocol.EobrSessionLogEntry.C2637a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.google.common.base.Ascii;
import com.google.protobuf.C3642c;
import java.util.regex.Pattern;

public class C1919c extends C1902e {
    private static final Pattern f6633n = Pattern.compile("GENX_[0-9]{12}");
    private static final C1098j f6634o = new C1098j("604.10.94");
    private static int f6635t = 1;
    private final C1927g f6636p;
    private final Handler f6637q = new Handler(Looper.getMainLooper());
    private C1098j f6638r;
    private C0972e f6639s = null;
    private C1923f f6640u;
    private final Runnable f6641v = new C19171(this);
    private C1920d f6642w = new C1920d(this);

    class C19171 implements Runnable {
        final /* synthetic */ C1919c f6627a;

        C19171(C1919c c1919c) {
            this.f6627a = c1919c;
        }

        public void run() {
            C0972e c0982e = new C0982e("DIAG FWVER");
            c0982e.m5034a(this.f6627a.mo1143r());
            this.f6627a.m9282b(c0982e, this.f6627a.f6642w, Long.valueOf(this.f6627a.m9298p() + 5000), true);
        }
    }

    public C1919c(C2078a c2078a, C1856a c1856a) {
        this.f6636p = new C1927g(this, c2078a);
        m9274a(c2078a, c1856a, this.f6636p, new C1930j(this, c2078a));
        m9296n();
        m9438b(false);
        this.f6640u = new C1923f(this, this.f6637q);
        this.f6640u.m9466a();
    }

    public void close() {
        this.f6640u.m9470b();
        m9297o();
        super.close();
        this.f6637q.removeCallbacks(this.f6641v);
    }

    public long mo1124a() {
        return 0;
    }

    public C1098j mo1135b() {
        return this.f6638r;
    }

    void m9431a(C1098j c1098j) {
        this.f6638r = c1098j;
        this.b.mo1072a(this);
    }

    public static boolean m9417b(C1098j c1098j) {
        if (c1098j == null) {
            return false;
        }
        Integer a = c1098j.m5444a();
        Integer b = c1098j.m5445b();
        if (a == null || b == null || !f6634o.m5444a().equals(a) || !f6634o.m5445b().equals(b)) {
            return false;
        }
        return true;
    }

    public String mo1138c() {
        return "MGS700";
    }

    public void mo1126a(long j, C1206c c1206c) {
        throw new UnsupportedOperationException();
    }

    public void mo1129a(C0986i c0986i, C1206c c1206c) {
        c0986i.m5034a(mo1143r());
        m9282b(c0986i, c1206c, Long.valueOf(m9298p() + 30000), true);
    }

    public void m9427a(C0982e c0982e, C1206c c1206c) {
        c0982e.m5034a(mo1143r());
        m9282b(c0982e, c1206c, Long.valueOf(m9298p() + 5000), true);
    }

    public void m9438b(boolean z) {
        this.f6637q.removeCallbacks(this.f6641v);
        this.f6637q.postDelayed(this.f6641v, z ? 5000 : 0);
    }

    public void mo1130a(FirmwareUpdateRequest firmwareUpdateRequest, byte[] bArr, C1206c c1206c) {
    }

    public int mo1123a(byte[] bArr, long j, long j2, int i) {
        int b = aj.m4180b();
        C2637a newBuilder = EobrSessionLogEntry.newBuilder();
        newBuilder.m13722a(b).m13725a(C3642c.m19078a(bArr)).m13723a(j).m13729b(j2).m13728b(i);
        C0972e c0990p = new C0990p(newBuilder.m13731c().toByteArray());
        c0990p.m5034a(mo1143r());
        m9265a(c0990p, null, false);
        return b;
    }

    public void mo1127a(long j, OdometerOffsets odometerOffsets) {
    }

    public void mo1132a(C1206c c1206c) {
    }

    public void mo1133a(short s, long j) {
    }

    public void mo1125a(long j, long j2) {
    }

    public void mo1134a(byte[] bArr, C1206c c1206c) {
        C0972e c0991q = new C0991q(Ascii.VT, bArr);
        c0991q.m5034a(mo1143r());
        m9265a(c0991q, c1206c, false);
    }

    public void mo1137b(byte[] bArr, C1206c c1206c) {
        C0972e c0991q = new C0991q((byte) 10, bArr);
        c0991q.m5034a(mo1143r());
        m9265a(c0991q, c1206c, false);
    }

    public boolean mo1140d() {
        return false;
    }

    public static boolean m9415a(BluetoothDevice bluetoothDevice) {
        return f6633n.matcher(C2281d.m11194a(bluetoothDevice)).matches();
    }

    void m9430a(C1051n c1051n, long j, long j2) {
        if (this.b != null) {
            final C1856a c1856a = this.b;
            final C1051n c1051n2 = c1051n;
            final long j3 = j;
            final long j4 = j2;
            this.f6637q.post(new Runnable(this) {
                final /* synthetic */ C1919c f6632e;

                public void run() {
                    c1856a.mo1073a(this.f6632e, c1051n2, j3, j4);
                }
            });
        }
    }

    protected int mo1141m() {
        return 30;
    }

    protected void mo1131a(C1901b c1901b) {
        synchronized (this.g) {
            C2134e.m10673a("TT-GenxDriver", "writeRequest called, queue size: " + this.g.size());
            m9420t();
            m9418d(c1901b.m9237a());
        }
    }

    protected void mo1128a(C0972e c0972e) {
        synchronized (this.g) {
            C2134e.m10673a("TT-GenxDriver", "signalRequestHasExpired called, queue size: " + this.g.size());
            m9420t();
            m9418d(null);
        }
    }

    protected void mo1136b(C0972e c0972e) {
        synchronized (this.g) {
            C2134e.m10673a("TT-GenxDriver", "signalRequestHasCompleted called, queue size: " + this.g.size());
            m9420t();
            m9418d(null);
        }
    }

    private void m9420t() {
        synchronized (this.g) {
            if (this.f6639s == null) {
                C2134e.m10673a("TT-GenxDriver", "{ No request in flight");
            } else if (this.g.isEmpty() || ((C1901b) this.g.peek()).m9237a().mo757a() != this.f6639s.mo757a()) {
                C2134e.m10673a("TT-GenxDriver", "{ In-flight request " + this.f6639s.mo757a() + " is no longer at the head of the queue, discarding");
                if (!this.g.isEmpty()) {
                    C2134e.m10673a("TT-GenxDriver", "Head of the queue is " + ((C1901b) this.g.peek()).m9237a().mo757a());
                }
                this.f6639s = null;
            } else {
                C2134e.m10673a("TT-GenxDriver", "{ Request " + this.f6639s.mo757a() + " still live");
            }
        }
    }

    private void m9418d(com.bigroad.shared.eobr.C0972e r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.bigroad.ttb.android.eobr.genx.c.d(com.bigroad.shared.eobr.e):void. bs: [B:20:0x00ae, B:30:0x00f2]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r5 = r8.g;
        monitor-enter(r5);
        r2 = r8.g;	 Catch:{ all -> 0x0048 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0048 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ all -> 0x0048 }
    L_0x000b:
        r2 = "TT-GenxDriver";	 Catch:{ all -> 0x0048 }
        r3 = "  No requests to send }";	 Catch:{ all -> 0x0048 }
        com.bigroad.ttb.android.logging.C2134e.m10673a(r2, r3);	 Catch:{ all -> 0x0048 }
        monitor-exit(r5);	 Catch:{ all -> 0x0048 }
    L_0x0013:
        return;	 Catch:{ all -> 0x0048 }
    L_0x0014:
        r2 = r8.g;	 Catch:{ all -> 0x0048 }
        r2 = r2.peek();	 Catch:{ all -> 0x0048 }
        r2 = (com.bigroad.ttb.android.eobr.C1902e.C1901b) r2;	 Catch:{ all -> 0x0048 }
        r4 = r2.m9237a();	 Catch:{ all -> 0x0048 }
        r3 = r4 instanceof com.bigroad.shared.eobr.genx.C0981n;	 Catch:{ all -> 0x0048 }
        if (r3 != 0) goto L_0x004b;	 Catch:{ all -> 0x0048 }
    L_0x0024:
        r2 = "TT-GenxDriver";	 Catch:{ all -> 0x0048 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0048 }
        r3.<init>();	 Catch:{ all -> 0x0048 }
        r6 = " Non-GenxRequest queued in GenxDriver: ";	 Catch:{ all -> 0x0048 }
        r3 = r3.append(r6);	 Catch:{ all -> 0x0048 }
        r4 = r4.toString();	 Catch:{ all -> 0x0048 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0048 }
        r4 = " }";	 Catch:{ all -> 0x0048 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0048 }
        r3 = r3.toString();	 Catch:{ all -> 0x0048 }
        com.bigroad.ttb.android.logging.C2134e.m10682e(r2, r3);	 Catch:{ all -> 0x0048 }
        monitor-exit(r5);	 Catch:{ all -> 0x0048 }
        goto L_0x0013;	 Catch:{ all -> 0x0048 }
    L_0x0048:
        r2 = move-exception;	 Catch:{ all -> 0x0048 }
        monitor-exit(r5);	 Catch:{ all -> 0x0048 }
        throw r2;
    L_0x004b:
        if (r9 == 0) goto L_0x007a;
    L_0x004d:
        r3 = r9.mo757a();	 Catch:{ all -> 0x0048 }
        r6 = r4.mo757a();	 Catch:{ all -> 0x0048 }
        if (r3 == r6) goto L_0x007a;	 Catch:{ all -> 0x0048 }
    L_0x0057:
        r3 = "TT-GenxDriver";	 Catch:{ all -> 0x0048 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0048 }
        r6.<init>();	 Catch:{ all -> 0x0048 }
        r7 = "  EOBR requested delivery of request ";	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = r9.mo757a();	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = " but it is not at the head of the queue";	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r6 = r6.toString();	 Catch:{ all -> 0x0048 }
        com.bigroad.ttb.android.logging.C2134e.m10673a(r3, r6);	 Catch:{ all -> 0x0048 }
        r9 = 0;	 Catch:{ all -> 0x0048 }
    L_0x007a:
        r3 = r8.f6639s;	 Catch:{ all -> 0x0048 }
        if (r3 != 0) goto L_0x00ce;	 Catch:{ all -> 0x0048 }
    L_0x007e:
        r3 = "TT-GenxDriver";	 Catch:{ all -> 0x0048 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0048 }
        r6.<init>();	 Catch:{ all -> 0x0048 }
        r7 = "  Sending request ";	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = r4.mo757a();	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = " ";	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = r4.toString();	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = " }";	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r6 = r6.toString();	 Catch:{ all -> 0x0048 }
        com.bigroad.ttb.android.logging.C2134e.m10673a(r3, r6);	 Catch:{ all -> 0x0048 }
        r6 = r8.e;	 Catch:{ all -> 0x00c3 }
        r0 = r4;	 Catch:{ all -> 0x00c3 }
        r0 = (com.bigroad.shared.eobr.genx.C0981n) r0;	 Catch:{ all -> 0x00c3 }
        r3 = r0;	 Catch:{ all -> 0x00c3 }
        r6.mo1152a(r3);	 Catch:{ all -> 0x00c3 }
        r8.f6639s = r4;	 Catch:{ all -> 0x0048 }
        r6 = r8.m9298p();	 Catch:{ all -> 0x0048 }
        r2.m9239a(r6);	 Catch:{ all -> 0x0048 }
    L_0x00c0:
        monitor-exit(r5);	 Catch:{ all -> 0x0048 }
        goto L_0x0013;	 Catch:{ all -> 0x0048 }
    L_0x00c3:
        r3 = move-exception;	 Catch:{ all -> 0x0048 }
        r8.f6639s = r4;	 Catch:{ all -> 0x0048 }
        r6 = r8.m9298p();	 Catch:{ all -> 0x0048 }
        r2.m9239a(r6);	 Catch:{ all -> 0x0048 }
        throw r3;	 Catch:{ all -> 0x0048 }
    L_0x00ce:
        if (r9 == 0) goto L_0x0110;	 Catch:{ all -> 0x0048 }
    L_0x00d0:
        r3 = "TT-GenxDriver";	 Catch:{ all -> 0x0048 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0048 }
        r6.<init>();	 Catch:{ all -> 0x0048 }
        r7 = "  Retrying request ";	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = r4.mo757a();	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r7 = " }";	 Catch:{ all -> 0x0048 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x0048 }
        r6 = r6.toString();	 Catch:{ all -> 0x0048 }
        com.bigroad.ttb.android.logging.C2134e.m10673a(r3, r6);	 Catch:{ all -> 0x0048 }
        r6 = r8.e;	 Catch:{ all -> 0x0105 }
        r0 = r4;	 Catch:{ all -> 0x0105 }
        r0 = (com.bigroad.shared.eobr.genx.C0981n) r0;	 Catch:{ all -> 0x0105 }
        r3 = r0;	 Catch:{ all -> 0x0105 }
        r6.mo1152a(r3);	 Catch:{ all -> 0x0105 }
        r8.f6639s = r4;	 Catch:{ all -> 0x0048 }
        r6 = r8.m9298p();	 Catch:{ all -> 0x0048 }
        r2.m9239a(r6);	 Catch:{ all -> 0x0048 }
        goto L_0x00c0;	 Catch:{ all -> 0x0048 }
    L_0x0105:
        r3 = move-exception;	 Catch:{ all -> 0x0048 }
        r8.f6639s = r4;	 Catch:{ all -> 0x0048 }
        r6 = r8.m9298p();	 Catch:{ all -> 0x0048 }
        r2.m9239a(r6);	 Catch:{ all -> 0x0048 }
        throw r3;	 Catch:{ all -> 0x0048 }
    L_0x0110:
        r2 = "TT-GenxDriver";	 Catch:{ all -> 0x0048 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0048 }
        r3.<init>();	 Catch:{ all -> 0x0048 }
        r4 = "  Sending deferred; request ";	 Catch:{ all -> 0x0048 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0048 }
        r4 = r8.f6639s;	 Catch:{ all -> 0x0048 }
        r4 = r4.mo757a();	 Catch:{ all -> 0x0048 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0048 }
        r4 = " still in-flight }";	 Catch:{ all -> 0x0048 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0048 }
        r3 = r3.toString();	 Catch:{ all -> 0x0048 }
        com.bigroad.ttb.android.logging.C2134e.m10673a(r2, r3);	 Catch:{ all -> 0x0048 }
        goto L_0x00c0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.eobr.genx.c.d(com.bigroad.shared.eobr.e):void");
    }

    public synchronized int mo1143r() {
        return C1919c.m9419s();
    }

    public static synchronized int m9419s() {
        int i;
        synchronized (C1919c.class) {
            f6635t++;
            if (f6635t >= 255) {
                f6635t = 1;
            }
            i = f6635t;
        }
        return i;
    }

    protected long mo1142q() {
        return 10000;
    }
}
