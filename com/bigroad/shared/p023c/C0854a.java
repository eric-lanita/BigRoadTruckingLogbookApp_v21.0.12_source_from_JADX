package com.bigroad.shared.p023c;

import com.bigroad.shared.ai;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import java.util.Comparator;

public class C0854a {
    public static final Comparator<Dvir> f2650a = new C08511();
    public static final Comparator<DvirInspection> f2651b = new C08522();
    public static final Comparator<DvirInspection> f2652c = new C08533();

    static class C08511 implements Comparator<Dvir> {
        C08511() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4271a((Dvir) obj, (Dvir) obj2);
        }

        public int m4271a(Dvir dvir, Dvir dvir2) {
            int signum = Integer.signum(dvir.getLogDay() - dvir2.getLogDay());
            if (signum != 0) {
                return signum;
            }
            signum = Integer.signum(dvir.getSequenceNum() - dvir2.getSequenceNum());
            return signum == 0 ? ai.f2620a.compare(dvir.getId(), dvir2.getId()) : signum;
        }
    }

    static class C08522 implements Comparator<DvirInspection> {
        C08522() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4272a((DvirInspection) obj, (DvirInspection) obj2);
        }

        public int m4272a(DvirInspection dvirInspection, DvirInspection dvirInspection2) {
            int signum = Long.signum(dvirInspection.getOccurredAt() - dvirInspection2.getOccurredAt());
            if (signum != 0) {
                return signum;
            }
            signum = Integer.signum(dvirInspection.getSequenceNum() - dvirInspection2.getSequenceNum());
            return signum == 0 ? ai.f2620a.compare(dvirInspection.getId(), dvirInspection2.getId()) : signum;
        }
    }

    static class C08533 implements Comparator<DvirInspection> {
        C08533() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4273a((DvirInspection) obj, (DvirInspection) obj2);
        }

        public int m4273a(DvirInspection dvirInspection, DvirInspection dvirInspection2) {
            int signum = Integer.signum(dvirInspection.getVehicleType() - dvirInspection2.getVehicleType());
            return signum != 0 ? signum : dvirInspection.getVehicleNumber().compareToIgnoreCase(dvirInspection2.getVehicleNumber());
        }
    }
}
