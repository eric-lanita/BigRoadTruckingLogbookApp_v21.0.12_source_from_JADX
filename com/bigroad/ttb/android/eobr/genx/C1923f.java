package com.bigroad.ttb.android.eobr.genx;

import android.os.Handler;
import com.bigroad.shared.am;
import com.bigroad.shared.eobr.genx.C0979c;
import com.bigroad.shared.eobr.genx.C0982e;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.model.C2182e.C2181a;
import java.util.Map;

public class C1923f implements C1206c {
    private final C1919c f6647a;
    private final Handler f6648b;
    private final Runnable f6649c = new C19221(this);

    class C19221 implements Runnable {
        final /* synthetic */ C1923f f6646a;

        C19221(C1923f c1923f) {
            this.f6646a = c1923f;
        }

        public void run() {
            this.f6646a.m9465d();
        }
    }

    public C1923f(C1919c c1919c, Handler handler) {
        this.f6647a = c1919c;
        this.f6648b = handler;
    }

    private void m9465d() {
        this.f6647a.m9427a(new C0982e("DIAG HOS PVT"), (C1206c) this);
    }

    public void m9466a() {
        this.f6648b.post(this.f6649c);
    }

    public void m9470b() {
        this.f6648b.removeCallbacks(this.f6649c);
    }

    public void m9472c() {
        m9470b();
        this.f6648b.postDelayed(this.f6649c, 5000);
    }

    public void mo897a(com.bigroad.shared.eobr.C0972e r7, com.bigroad.shared.eobr.C0973f r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.bigroad.ttb.android.eobr.genx.f.a(com.bigroad.shared.eobr.e, com.bigroad.shared.eobr.f):void. bs: [B:1:0x0002, B:7:0x0026, B:33:0x0081]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        if (r8 != 0) goto L_0x000d;
    L_0x0002:
        r0 = "TT-GenxPvtHosRC";	 Catch:{ all -> 0x0085 }
        r1 = "Unexpected null response received!";	 Catch:{ all -> 0x0085 }
        com.bigroad.ttb.android.logging.C2134e.m10680d(r0, r1);	 Catch:{ all -> 0x0085 }
        r6.m9472c();
    L_0x000c:
        return;
    L_0x000d:
        r0 = r8 instanceof com.bigroad.shared.eobr.genx.C0983f;	 Catch:{ all -> 0x0085 }
        if (r0 == 0) goto L_0x0092;	 Catch:{ all -> 0x0085 }
    L_0x0011:
        r1 = new java.util.HashMap;	 Catch:{ all -> 0x0085 }
        r1.<init>();	 Catch:{ all -> 0x0085 }
        r8 = (com.bigroad.shared.eobr.genx.C0983f) r8;	 Catch:{ all -> 0x0085 }
        r2 = new com.bigroad.shared.eobr.genx.d;	 Catch:{ all -> 0x0085 }
        r0 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x0085 }
        r3 = r8.m5042b();	 Catch:{ all -> 0x0085 }
        r0.<init>(r3);	 Catch:{ all -> 0x0085 }
        r2.<init>(r0);	 Catch:{ all -> 0x0085 }
    L_0x0026:
        r3 = r2.m5031a();	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r4 = r3.m5027a();	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r0 = -1;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r5 = r4.hashCode();	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        switch(r5) {
            case 70794: goto L_0x0047;
            case 78106: goto L_0x0051;
            case 84987: goto L_0x0065;
            case 451228919: goto L_0x005b;
            default: goto L_0x0036;
        };	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x0036:
        switch(r0) {
            case 0: goto L_0x003a;
            case 1: goto L_0x006f;
            case 2: goto L_0x0081;
            case 3: goto L_0x008a;
            default: goto L_0x0039;
        };	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x0039:
        goto L_0x0026;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x003a:
        r0 = r3.m5028b();	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r6.m9469a(r0);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0026;
    L_0x0042:
        r0 = move-exception;
        r6.m9472c();
        goto L_0x000c;
    L_0x0047:
        r5 = "GPS";	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r4 = r4.equals(r5);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        if (r4 == 0) goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x004f:
        r0 = 0;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x0051:
        r5 = "ODO";	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r4 = r4.equals(r5);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        if (r4 == 0) goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x0059:
        r0 = 1;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x005b:
        r5 = "ODO DERIVED";	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r4 = r4.equals(r5);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        if (r4 == 0) goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x0063:
        r0 = 2;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x0065:
        r5 = "VIN";	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r4 = r4.equals(r5);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        if (r4 == 0) goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x006d:
        r0 = 3;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0036;	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
    L_0x006f:
        r6.m9468a(r3, r1);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0026;
    L_0x0073:
        r0 = move-exception;
        r1 = "TT-GenxPvtHosRC";	 Catch:{ all -> 0x0085 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0085 }
        com.bigroad.ttb.android.logging.C2134e.m10682e(r1, r0);	 Catch:{ all -> 0x0085 }
        r6.m9472c();
        goto L_0x000c;
    L_0x0081:
        r6.m9468a(r3, r1);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0026;
    L_0x0085:
        r0 = move-exception;
        r6.m9472c();
        throw r0;
    L_0x008a:
        r0 = r3.m5028b();	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        r6.m9471b(r0);	 Catch:{ EOFException -> 0x0042, IOException -> 0x0073 }
        goto L_0x0026;
    L_0x0092:
        r0 = "TT-GenxPvtHosRC";	 Catch:{ all -> 0x0085 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0085 }
        r1.<init>();	 Catch:{ all -> 0x0085 }
        r2 = "Callback received for class ";	 Catch:{ all -> 0x0085 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0085 }
        r2 = r8.getClass();	 Catch:{ all -> 0x0085 }
        r2 = r2.getSimpleName();	 Catch:{ all -> 0x0085 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0085 }
        r1 = r1.toString();	 Catch:{ all -> 0x0085 }
        com.bigroad.ttb.android.logging.C2134e.m10673a(r0, r1);	 Catch:{ all -> 0x0085 }
        r6.m9472c();
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.eobr.genx.f.a(com.bigroad.shared.eobr.e, com.bigroad.shared.eobr.f):void");
    }

    void m9469a(String str) {
        C1929i.m9484a(this.f6647a, str);
    }

    void m9468a(C0979c c0979c, Map<String, String> map) {
        Object obj = 1;
        map.put(c0979c.m5027a(), c0979c.m5028b());
        if (map.containsKey("ODO") && map.containsKey("ODO DERIVED")) {
            long a = C1929i.m9483a((String) map.get("ODO"));
            long a2 = C1929i.m9483a((String) map.get("ODO DERIVED"));
            long[] jArr = new long[CanonicalOdometerSource.f3603l];
            C2182e e = this.f6647a.m9287e();
            if (e == null) {
                jArr[CanonicalOdometerSource.GENX_ECM.ordinal()] = a;
                jArr[CanonicalOdometerSource.GENX_FW.ordinal()] = a2;
                this.f6647a.m9275a(new C2181a(jArr).m10814a());
                return;
            }
            Object obj2 = null;
            if (a > e.m10816a(CanonicalOdometerSource.GENX_ECM)) {
                jArr[CanonicalOdometerSource.GENX_ECM.ordinal()] = a;
                obj2 = 1;
            } else {
                jArr[CanonicalOdometerSource.GENX_ECM.ordinal()] = e.m10816a(CanonicalOdometerSource.GENX_ECM);
            }
            if (a2 > e.m10816a(CanonicalOdometerSource.GENX_FW)) {
                jArr[CanonicalOdometerSource.GENX_FW.ordinal()] = a2;
            } else {
                jArr[CanonicalOdometerSource.GENX_FW.ordinal()] = e.m10816a(CanonicalOdometerSource.GENX_FW);
                obj = obj2;
            }
            if (obj != null) {
                this.f6647a.m9275a(new C2181a(jArr).m10814a());
            }
        }
    }

    void m9471b(String str) {
        if (!am.m4188a((CharSequence) str)) {
            if (this.f6647a.m9288f() == null || !this.f6647a.m9288f().equals(str)) {
                this.f6647a.mo1177a(str, true);
                long j = 0 | 131072;
                if (this.f6647a.m9289g() != j) {
                    this.f6647a.m9259a(j);
                }
            }
        }
    }
}
