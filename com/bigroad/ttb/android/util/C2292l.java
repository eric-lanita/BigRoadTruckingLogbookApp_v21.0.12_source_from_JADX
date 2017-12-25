package com.bigroad.ttb.android.util;

import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.SignatureManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.Dvir.C2630a;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.google.protobuf.C3642c;

public class C2292l {
    public static boolean m11230a(int i) {
        return C2292l.m11231a(OurApplication.m6296r().m8480b(i));
    }

    public static boolean m11231a(DailyLog dailyLog) {
        return dailyLog != null && dailyLog.hasDriverApproval();
    }

    public static boolean m11232a(Dvir dvir) {
        return dvir != null && dvir.hasDriverApproval();
    }

    public static boolean m11233b(DailyLog dailyLog) {
        return C2292l.m11231a(dailyLog) && dailyLog.hasSignatureId();
    }

    public static C3642c m11235c(DailyLog dailyLog) {
        return dailyLog != null ? dailyLog.getSignatureId() : null;
    }

    public static boolean m11234b(Dvir dvir) {
        return C2292l.m11232a(dvir) && dvir.hasSignatureId();
    }

    public static C3642c m11236c(Dvir dvir) {
        return dvir != null ? dvir.getSignatureId() : null;
    }

    public static DailyLog m11237d(DailyLog dailyLog) {
        if (dailyLog == null) {
            return null;
        }
        return DailyLog.newBuilder(dailyLog).m13108y().m13109z().m13069c();
    }

    public static DailyLog m11226a(DailyLog dailyLog, long j) {
        Person person = null;
        if (dailyLog == null) {
            return null;
        }
        C2474y g = OurApplication.m6285g();
        for (Person person2 : OurApplication.m6293o().m12139a()) {
            Person person22;
            if (person22.getPersonId() != j) {
                person22 = person;
            }
            person = person22;
        }
        if (person == null) {
            person = g.m12222l();
        }
        return DailyLog.newBuilder(dailyLog).m13085g(OurApplication.m6269Z().mo914b()).m13049a(person).m13069c();
    }

    public static DailyLog m11227a(DailyLog dailyLog, boolean z, C2032f c2032f) {
        if (dailyLog == null) {
            return null;
        }
        if (!z || SignatureManager.m6342d()) {
            long b = c2032f.mo1314v().mo914b();
            C2582a newBuilder = DailyLog.newBuilder(dailyLog);
            if (z) {
                newBuilder.m13081f(b);
                newBuilder.m13050a(SignatureManager.m6339c());
            } else {
                newBuilder.m13108y();
                newBuilder.m13109z();
            }
            dailyLog = newBuilder.m13069c();
            if (z) {
                C2292l.m11228a(dailyLog, c2032f);
                return dailyLog;
            }
            c2032f.mo1302j().m8484b(dailyLog);
            return dailyLog;
        }
        C2134e.m10682e("TT-LogApprovalUtils", "Attempt to sign a log without an available signature");
        return dailyLog;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m11228a(com.bigroad.ttb.protocol.TTProtocol.DailyLog r13, com.bigroad.ttb.android.C2032f r14) {
        /*
        r1 = 0;
        r0 = r14.mo1311s();
        r0 = r0.m11411i();
        if (r0 == 0) goto L_0x005f;
    L_0x000b:
        r0 = r14.mo1311s();
        r6 = r0.m11410h();
        r0 = com.bigroad.ttb.protocol.TTProtocol.EventType.CERTIFY_DAILY_LOG;
        r2 = com.bigroad.shared.EventStatusMaskBits.RecordOrigin.AUTOMATICALLY_RECORDED;
        r4 = r13.getOwnerPersonId();
        r3 = java.lang.Long.valueOf(r4);
        r4 = r13.getDriverApproval();
        r7 = r6.m11542e();
        r6 = r13.getLogDay();
        r8 = (long) r6;
        r8 = java.lang.Long.valueOf(r8);
        r6 = r1;
        r9 = r14;
        r0 = com.bigroad.ttb.android.event.C2022a.m10087a(r0, r1, r2, r3, r4, r6, r7, r8, r9);
    L_0x0036:
        if (r0 == 0) goto L_0x005e;
    L_0x0038:
        r2 = new com.bigroad.shared.r;
        r2.<init>();
        r1 = r2.m5747a(r0, r1);
        r2 = r14.mo1301i();
        r4 = r0.getOccurredAt();
        r2.m10011a(r1, r4);
        r1 = r14.mo1302j();
        r1.m8475a(r13);
        r1 = r14.mo1298f();
        r2 = r13.getSignatureId();
        r1.m6470a(r0, r2);
    L_0x005e:
        return;
    L_0x005f:
        r0 = r14.mo1300h();
        r0 = r0.m6578f();
        r2 = com.bigroad.shared.C1130o.m5714a(r0);
        if (r2 != 0) goto L_0x00c2;
    L_0x006d:
        r2 = r14.mo1301i();
        r3 = r13.getLogDay();
        r2 = r2.m10007a(r3);
        r2 = com.bigroad.shared.p021a.C0831a.m4105a(r2);
        r3 = r2.iterator();
        r2 = r0;
    L_0x0082:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00c3;
    L_0x0088:
        r0 = r3.next();
        r0 = (com.bigroad.ttb.protocol.TTProtocol.Event) r0;
        r4 = r0.hasTruckId();
        if (r4 == 0) goto L_0x00c0;
    L_0x0094:
        if (r2 == 0) goto L_0x00a2;
    L_0x0096:
        r4 = r2.getTruckId();
        r6 = r0.getTruckId();
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x0082;
    L_0x00a2:
        r4 = r14.mo1300h();
        r6 = r0.getTruckId();
        r0 = r4.m6552a(r6);
        if (r0 == 0) goto L_0x00c0;
    L_0x00b0:
        r4 = com.bigroad.shared.C1130o.m5714a(r2);
        if (r4 != 0) goto L_0x00be;
    L_0x00b6:
        r4 = com.bigroad.shared.C1130o.m5714a(r0);
        if (r4 == 0) goto L_0x00be;
    L_0x00bc:
        r2 = r0;
        goto L_0x0082;
    L_0x00be:
        if (r2 == 0) goto L_0x00bc;
    L_0x00c0:
        r0 = r2;
        goto L_0x00bc;
    L_0x00c2:
        r2 = r0;
    L_0x00c3:
        r0 = com.bigroad.shared.C1130o.m5714a(r2);
        if (r0 != 0) goto L_0x0121;
    L_0x00c9:
        r0 = r14.mo1301i();
        r0 = r0.m10010a(r13);
        r0 = com.bigroad.shared.p021a.C0831a.m4105a(r0);
        r3 = r0.iterator();
    L_0x00d9:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0121;
    L_0x00df:
        r0 = r3.next();
        r0 = (com.bigroad.shared.duty.C0890f) r0;
        r4 = r0.m4528w();
        if (r4 == 0) goto L_0x00d9;
    L_0x00eb:
        if (r2 == 0) goto L_0x00fd;
    L_0x00ed:
        r4 = r2.getTruckId();
        r6 = r0.m4528w();
        r6 = r6.longValue();
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x00d9;
    L_0x00fd:
        r4 = r14.mo1300h();
        r0 = r0.m4528w();
        r6 = r0.longValue();
        r0 = r4.m6552a(r6);
        if (r0 == 0) goto L_0x00d9;
    L_0x010f:
        r4 = com.bigroad.shared.C1130o.m5714a(r2);
        if (r4 != 0) goto L_0x011d;
    L_0x0115:
        r4 = com.bigroad.shared.C1130o.m5714a(r0);
        if (r4 == 0) goto L_0x011d;
    L_0x011b:
        r2 = r0;
        goto L_0x00d9;
    L_0x011d:
        if (r2 != 0) goto L_0x00d9;
    L_0x011f:
        r2 = r0;
        goto L_0x00d9;
    L_0x0121:
        r3 = com.bigroad.ttb.protocol.TTProtocol.EventType.CERTIFY_DAILY_LOG;
        r4 = r13.getDriverApproval();
        r6 = r13.getOwnerPersonId();
        r8 = com.bigroad.shared.ar.m4239c(r2);
        r0 = r14.mo1304l();
        r9 = r0.m10605e();
        r0 = r13.getLogDay();
        r10 = (long) r0;
        r12 = r14;
        r0 = com.bigroad.ttb.android.event.C2022a.m10096b(r3, r4, r6, r8, r9, r10, r12);
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.util.l.a(com.bigroad.ttb.protocol.TTProtocol$DailyLog, com.bigroad.ttb.android.f):void");
    }

    public static void m11229a(Dvir dvir, boolean z) {
        if (dvir != null) {
            if (!z || SignatureManager.m6342d()) {
                long a = OurApplication.m6269Z().mo913a();
                C2630a newBuilder = Dvir.newBuilder(dvir);
                if (z) {
                    newBuilder.m13637c(a);
                    newBuilder.m13634b(SignatureManager.m6339c());
                } else {
                    newBuilder.m13655q();
                    newBuilder.m13656r();
                }
                OurApplication.m6297s().m10983b(newBuilder.m13638c());
                return;
            }
            C2134e.m10682e("TT-LogApprovalUtils", "Attempt to sign a DVIR without an available signature");
        }
    }
}
