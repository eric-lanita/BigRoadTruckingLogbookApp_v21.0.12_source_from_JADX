package com.bigroad.ttb.android.model;

import android.content.Context;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.util.ab;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.VehicleType;
import com.google.common.collect.C3540t;
import com.google.common.collect.C3589f;
import java.util.Comparator;

public final class C2186g {
    public static final Comparator<C2186g> f7576a = new C21851();
    private final VehicleType f7577b;
    private final String f7578c;

    static class C21851 implements Comparator<C2186g> {
        C21851() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m10832a((C2186g) obj, (C2186g) obj2);
        }

        public int m10832a(C2186g c2186g, C2186g c2186g2) {
            return C3589f.m18773a().mo2738a(c2186g.f7577b, c2186g2.f7577b, C3540t.m18450c().mo2709b()).mo2738a(c2186g.f7578c, c2186g2.f7578c, C3540t.m18449a(String.CASE_INSENSITIVE_ORDER).mo2709b()).mo2740b();
        }
    }

    public C2186g(VehicleType vehicleType, String str) {
        this.f7577b = vehicleType;
        this.f7578c = str;
    }

    public static C2186g m10833a(DvirInspection dvirInspection) {
        VehicleType a = VehicleType.m15917a(dvirInspection.getVehicleType());
        if (a == null) {
            a = VehicleType.UNKNOWN;
        }
        return new C2186g(a, dvirInspection.getVehicleNumber());
    }

    public String m10837a(Context context) {
        String a = ab.m11169a(context, this.f7577b);
        return am.m4188a(this.f7578c) ? a : a + ' ' + this.f7578c;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f7578c == null ? 0 : this.f7578c.hashCode()) + 31) * 31;
        if (this.f7577b != null) {
            i = this.f7577b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2186g)) {
            return false;
        }
        C2186g c2186g = (C2186g) obj;
        if (this.f7577b != c2186g.f7577b) {
            return false;
        }
        if (this.f7578c != null) {
            return this.f7578c.equals(c2186g.f7578c);
        }
        if (c2186g.f7578c != null) {
            return false;
        }
        return true;
    }

    public VehicleType m10836a() {
        return this.f7577b;
    }

    public String m10838b() {
        return this.f7578c;
    }
}
