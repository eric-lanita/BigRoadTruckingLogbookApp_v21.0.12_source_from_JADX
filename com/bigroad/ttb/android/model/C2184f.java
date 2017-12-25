package com.bigroad.ttb.android.model;

import android.content.Context;
import com.bigroad.shared.model.C1107b;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.VehicleType;
import java.util.Comparator;

public class C2184f {
    public static final Comparator<C2184f> f7573a = new C21831();
    private final C2186g f7574b;
    private final String f7575c;

    static class C21831 implements Comparator<C2184f> {
        C21831() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m10823a((C2184f) obj, (C2184f) obj2);
        }

        public int m10823a(C2184f c2184f, C2184f c2184f2) {
            return C2186g.f7576a.compare(c2184f.f7574b, c2184f2.f7574b);
        }
    }

    public static C2184f m10825a(DvirInspection dvirInspection) {
        return new C2184f(C2186g.m10833a(dvirInspection), dvirInspection.getVehicleLicense());
    }

    public static C2184f m10826a(Truck truck) {
        return new C2184f(new C2186g(VehicleType.TRUCK, truck.getTruckNumber()), truck.getTruckLicense());
    }

    public static C2184f m10824a(C1107b c1107b) {
        return new C2184f(new C2186g(VehicleType.TRUCK, c1107b.m5490q()), c1107b.m5491r());
    }

    private C2184f(C2186g c2186g, String str) {
        this.f7574b = c2186g;
        this.f7575c = str;
    }

    public int hashCode() {
        return this.f7574b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2184f)) {
            return false;
        }
        return this.f7574b.equals(((C2184f) obj).f7574b);
    }

    public String m10829a(Context context) {
        return this.f7574b.m10837a(context);
    }

    public VehicleType m10828a() {
        return this.f7574b.m10836a();
    }

    public String m10830b() {
        return this.f7574b.m10838b();
    }

    public String m10831c() {
        return this.f7575c;
    }
}
