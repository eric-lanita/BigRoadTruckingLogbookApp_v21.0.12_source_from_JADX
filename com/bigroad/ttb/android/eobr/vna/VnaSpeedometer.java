package com.bigroad.ttb.android.eobr.vna;

import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;
import com.bigroad.ttb.android.logging.C2134e;
import com.google.common.collect.EvictingQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class VnaSpeedometer {
    private final C2006i f6845a;
    private final C1980b[] f6846b = new C1980b[SpeedometerSource.values().length];
    private final C1979a[] f6847c = new C1979a[SpeedometerSource.values().length];
    private boolean f6848d;
    private long f6849e;

    private enum J1587MidBlacklist {
        J1587_MID_BRAKES_TRAILER_1(-119);
        
        final int m_sourceAddress;

        private J1587MidBlacklist(int i) {
            this.m_sourceAddress = i;
        }
    }

    private enum J1587MidPriority {
        J1587_MID_ROAD_SPEED_INDICATOR(-111),
        J1587_MID_INSTRUMENT_CLUSTER(-116),
        J1587_MID_ENGINE_1(-128),
        J1587_MID_BODY_COMPUTER_1(-114),
        UNKNOWN(Integer.MAX_VALUE);
        
        final int m_sourceAddress;

        private J1587MidPriority(int i) {
            this.m_sourceAddress = i;
        }
    }

    private static class C1979a {
        final EvictingQueue<C1981c> f6837a;
        long f6838b;
        long f6839c;

        C1979a(int i, long j, long j2) {
            this.f6837a = EvictingQueue.m18488a(i);
            this.f6838b = j;
            this.f6839c = j2;
        }
    }

    private static class C1980b {
        final EvictingQueue<C1981c> f6840a;
        boolean f6841b;
        int f6842c;

        C1980b(int i, boolean z, int i2) {
            this.f6840a = EvictingQueue.m18488a(i);
            this.f6841b = z;
            this.f6842c = i2;
        }
    }

    protected static class C1981c {
        long f6843a;
        int f6844b;

        C1981c(long j, int i) {
            this.f6843a = j;
            this.f6844b = i;
        }
    }

    public VnaSpeedometer(C2006i c2006i) {
        this.f6845a = c2006i;
        for (SpeedometerSource speedometerSource : SpeedometerSource.values()) {
            this.f6846b[speedometerSource.ordinal()] = new C1980b(16, false, 0);
            C1979a c1979a = new C1979a(5, -1, 0);
            for (int i = 0; i < 5; i++) {
                c1979a.f6837a.add(new C1981c(0, 0));
            }
            this.f6847c[speedometerSource.ordinal()] = c1979a;
        }
        this.f6848d = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean m9818a(com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource r9, int r10, int r11, long r12) {
        /*
        r8 = this;
        r1 = 0;
        r0 = 1;
        monitor-enter(r8);
        r2 = r8.f6846b;	 Catch:{ all -> 0x0087 }
        r3 = r9.ordinal();	 Catch:{ all -> 0x0087 }
        r3 = r2[r3];	 Catch:{ all -> 0x0087 }
        r2 = r3.f6841b;	 Catch:{ all -> 0x0087 }
        if (r2 != 0) goto L_0x004c;
    L_0x000f:
        r2 = 1;
        r3.f6841b = r2;	 Catch:{ all -> 0x0087 }
        r2 = "TT-VnaSpeedometer";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0087 }
        r4.<init>();	 Catch:{ all -> 0x0087 }
        r5 = "Using speedometer source address ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0087 }
        r4 = r4.append(r11);	 Catch:{ all -> 0x0087 }
        r4 = r4.toString();	 Catch:{ all -> 0x0087 }
        com.bigroad.ttb.android.logging.C2134e.m10676b(r2, r4);	 Catch:{ all -> 0x0087 }
    L_0x002a:
        r2 = com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource.SPEEDOMETER_SOURCE_J1587_ROAD_SPEED;	 Catch:{ all -> 0x0087 }
        if (r9 != r2) goto L_0x0098;
    L_0x002e:
        r4 = com.bigroad.ttb.android.eobr.vna.VnaSpeedometer.J1587MidBlacklist.values();	 Catch:{ all -> 0x0087 }
        r5 = r4.length;	 Catch:{ all -> 0x0087 }
        r2 = r1;
    L_0x0034:
        if (r2 >= r5) goto L_0x0098;
    L_0x0036:
        r6 = r4[r2];	 Catch:{ all -> 0x0087 }
        r6 = r6.m_sourceAddress;	 Catch:{ all -> 0x0087 }
        if (r6 != r11) goto L_0x0095;
    L_0x003c:
        if (r1 == 0) goto L_0x004a;
    L_0x003e:
        r0 = new com.bigroad.ttb.android.eobr.vna.VnaSpeedometer$c;	 Catch:{ all -> 0x0087 }
        r0.<init>(r12, r10);	 Catch:{ all -> 0x0087 }
        r2 = r3.f6840a;	 Catch:{ all -> 0x0087 }
        r2.add(r0);	 Catch:{ all -> 0x0087 }
        r3.f6842c = r11;	 Catch:{ all -> 0x0087 }
    L_0x004a:
        monitor-exit(r8);
        return r1;
    L_0x004c:
        r2 = com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource.SPEEDOMETER_SOURCE_J1587_ROAD_SPEED;	 Catch:{ all -> 0x0087 }
        if (r9 != r2) goto L_0x0090;
    L_0x0050:
        r2 = r8.m9812a(r11);	 Catch:{ all -> 0x0087 }
        r4 = r3.f6842c;	 Catch:{ all -> 0x0087 }
        r4 = r8.m9812a(r4);	 Catch:{ all -> 0x0087 }
        r5 = r2.ordinal();	 Catch:{ all -> 0x0087 }
        r4 = r4.ordinal();	 Catch:{ all -> 0x0087 }
        if (r5 > r4) goto L_0x008e;
    L_0x0064:
        r4 = com.bigroad.ttb.android.eobr.vna.VnaSpeedometer.J1587MidPriority.UNKNOWN;	 Catch:{ all -> 0x0087 }
        if (r2 == r4) goto L_0x008a;
    L_0x0068:
        if (r0 == 0) goto L_0x002a;
    L_0x006a:
        r2 = r3.f6842c;	 Catch:{ all -> 0x0087 }
        if (r11 == r2) goto L_0x002a;
    L_0x006e:
        r2 = "TT-VnaSpeedometer";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0087 }
        r4.<init>();	 Catch:{ all -> 0x0087 }
        r5 = "Changing speedometer source address to ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0087 }
        r4 = r4.append(r11);	 Catch:{ all -> 0x0087 }
        r4 = r4.toString();	 Catch:{ all -> 0x0087 }
        com.bigroad.ttb.android.logging.C2134e.m10676b(r2, r4);	 Catch:{ all -> 0x0087 }
        goto L_0x002a;
    L_0x0087:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x008a:
        r2 = r3.f6842c;	 Catch:{ all -> 0x0087 }
        if (r11 <= r2) goto L_0x0068;
    L_0x008e:
        r0 = r1;
        goto L_0x0068;
    L_0x0090:
        r2 = r3.f6842c;	 Catch:{ all -> 0x0087 }
        if (r11 > r2) goto L_0x008e;
    L_0x0094:
        goto L_0x0068;
    L_0x0095:
        r2 = r2 + 1;
        goto L_0x0034;
    L_0x0098:
        r1 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.eobr.vna.VnaSpeedometer.a(com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage$SpeedometerSource, int, int, long):boolean");
    }

    synchronized void m9817a(long j, long j2) {
        for (SpeedometerSource speedometerSource : SpeedometerSource.values()) {
            int i;
            int i2;
            if (C2005h.m9927a(speedometerSource)) {
                C1980b c1980b = this.f6846b[speedometerSource.ordinal()];
                C1979a c1979a = this.f6847c[speedometerSource.ordinal()];
                c1979a.f6839c <<= 1;
                if (c1980b.f6841b) {
                    C1981c c1981c;
                    List<C1981c> a = m9813a(c1980b.f6840a, 16);
                    int size = a.size();
                    int i3 = 0;
                    if (!a.isEmpty()) {
                        long j3;
                        if (speedometerSource == SpeedometerSource.SPEEDOMETER_SOURCE_OBD_VEHICLE_SPEED) {
                            j3 = 5000;
                        } else {
                            j3 = 1000;
                        }
                        if (j2 - ((C1981c) a.get(size - 1)).f6843a < j3) {
                            j3 = this.f6847c[speedometerSource.ordinal()].f6838b;
                            long j4 = ((C1981c) a.get(size - 1)).f6843a;
                            i3 = 0;
                            while (i3 < size) {
                                if (((C1981c) a.get(i3)).f6843a > j3 && ((C1981c) a.get(i3)).f6843a <= j4) {
                                    i = size;
                                    break;
                                }
                                i3++;
                            }
                        } else {
                            C2134e.m10676b("TT-VnaSpeedometer", "Deactivating speedometer source " + speedometerSource + " @ " + j2);
                            for (C1981c c1981c2 : a) {
                                C2134e.m10676b("TT-VnaSpeedometer", "tick " + c1981c2.f6843a + " speed " + c1981c2.f6844b);
                            }
                            m9814a(speedometerSource, true, false);
                            i = 0;
                        }
                        if (i3 < i) {
                            c1981c = new C1981c(j2, 0);
                            for (size = i3; size < i; size++) {
                                c1981c.f6844b = ((C1981c) a.get(size)).f6844b + c1981c.f6844b;
                            }
                            i2 = i - i3;
                            c1981c.f6844b = (c1981c.f6844b + (i2 >> 1)) / i2;
                            c1979a.f6839c |= 1;
                            this.f6847c[speedometerSource.ordinal()].f6838b = ((C1981c) a.get(i - 1)).f6843a;
                            c1979a.f6837a.add(c1981c);
                        }
                    }
                    i = size;
                    if (i3 < i) {
                        c1981c = new C1981c(j2, 0);
                        for (size = i3; size < i; size++) {
                            c1981c.f6844b = ((C1981c) a.get(size)).f6844b + c1981c.f6844b;
                        }
                        i2 = i - i3;
                        c1981c.f6844b = (c1981c.f6844b + (i2 >> 1)) / i2;
                        c1979a.f6839c |= 1;
                        this.f6847c[speedometerSource.ordinal()].f6838b = ((C1981c) a.get(i - 1)).f6843a;
                        c1979a.f6837a.add(c1981c);
                    }
                }
                if ((c1979a.f6839c & 1) == 0) {
                    c1979a.f6837a.add(new C1981c(j2, 0));
                }
            }
        }
        SpeedometerSource a2 = m9816a();
        Object obj = null;
        long j5 = 0;
        if (C2005h.m9927a(a2)) {
            if ((this.f6845a.m9930a() & 1) == 1) {
                obj = (this.f6847c[a2.ordinal()].f6839c & 31) != 0 ? 1 : null;
            } else {
                obj = (this.f6847c[a2.ordinal()].f6839c & 16) != 0 ? 1 : null;
            }
            j5 = (long) m9815a(a2);
        }
        if (j5 > 8046) {
            if (!this.f6848d) {
                this.f6848d = true;
                C2134e.m10676b("TT-VnaSpeedometer", "Vehicle is moving");
            }
            this.f6849e = 0;
        } else if (j5 >= 3000) {
            this.f6849e = 0;
        } else if (this.f6848d) {
            this.f6849e++;
            if (this.f6849e >= 3) {
                this.f6848d = false;
                for (SpeedometerSource speedometerSource2 : SpeedometerSource.values()) {
                    if (C2005h.m9927a(speedometerSource2)) {
                        m9814a(speedometerSource2, false, false);
                    }
                }
                C2134e.m10676b("TT-VnaSpeedometer", "Vehicle has stopped moving");
            }
        }
        if (this.f6848d) {
            this.f6845a.m9932b(3, j2);
        } else {
            this.f6845a.m9931a(((obj != null ? 0 : 1) | 2) ^ -1, j2);
            this.f6845a.m9932b(obj != null ? 1 : 0, j2);
        }
    }

    protected synchronized SpeedometerSource m9816a() {
        SpeedometerSource speedometerSource;
        for (SpeedometerSource speedometerSource2 : SpeedometerSource.values()) {
            if (C2005h.m9927a(speedometerSource2) && this.f6846b[speedometerSource2.ordinal()].f6841b) {
                break;
            }
        }
        speedometerSource2 = SpeedometerSource.SPEEDOMETER_SOURCE_UNKNOWN;
        return speedometerSource2;
    }

    private synchronized J1587MidPriority m9812a(int i) {
        J1587MidPriority j1587MidPriority;
        for (J1587MidPriority j1587MidPriority2 : J1587MidPriority.values()) {
            if (i == j1587MidPriority2.m_sourceAddress) {
                break;
            }
        }
        j1587MidPriority2 = J1587MidPriority.UNKNOWN;
        return j1587MidPriority2;
    }

    private synchronized void m9814a(SpeedometerSource speedometerSource, boolean z, boolean z2) {
        if (C2005h.m9927a(speedometerSource)) {
            C1980b c1980b = this.f6846b[speedometerSource.ordinal()];
            if (!z2 || c1980b.f6840a.isEmpty()) {
                c1980b.f6840a.clear();
                this.f6847c[speedometerSource.ordinal()].f6839c = 0;
                this.f6847c[speedometerSource.ordinal()].f6838b = -1;
            } else {
                C1981c c1981c;
                Iterator it = c1980b.f6840a.iterator();
                do {
                    c1981c = (C1981c) it.next();
                } while (it.hasNext());
                c1980b.f6840a.clear();
                c1980b.f6840a.add(c1981c);
                this.f6847c[speedometerSource.ordinal()].f6839c = 1;
            }
            if (z) {
                c1980b.f6841b = false;
            }
        }
    }

    protected synchronized int m9815a(SpeedometerSource speedometerSource) {
        long j;
        if (C2005h.m9927a(speedometerSource)) {
            C1979a c1979a = this.f6847c[speedometerSource.ordinal()];
            List a = m9813a(c1979a.f6837a, 5);
            int i = 0;
            int i2 = 0;
            j = 0;
            while (i < a.size()) {
                int i3;
                if ((c1979a.f6839c & ((long) (1 << i))) != 0) {
                    j += (long) ((C1981c) a.get((a.size() - 1) - i)).f6844b;
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i++;
                i2 = i3;
            }
            if (i2 > 0) {
                j = (j + ((long) (i2 >> 1))) / ((long) i2);
            }
        } else {
            j = 0;
        }
        return (int) j;
    }

    private synchronized List<C1981c> m9813a(Collection<C1981c> collection, int i) {
        List<C1981c> arrayList;
        arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext() && arrayList.size() < i) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
