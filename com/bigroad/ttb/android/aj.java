package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.HashSet;
import java.util.Set;

public class aj {
    private static aj f5930a;
    private final C2474y f5931b = OurApplication.m6285g();
    private final Set<C1716a> f5932c = new HashSet();
    private String f5933d = this.f5931b.m12181Z();
    private String f5934e = this.f5931b.m12180Y();

    public interface C1716a {
        void mo1055a(String str);

        void mo1056b(String str);
    }

    public static aj m8381a(Context context) {
        if (f5930a == null) {
            f5930a = new aj();
        }
        return f5930a;
    }

    private aj() {
    }

    public String m8384a() {
        return this.f5934e;
    }

    public void m8386a(String str) {
        if (am.m4189a(this.f5934e, str)) {
            C2134e.m10676b("TT-VehicleUpdateManager", "Trailer remains unchanged, no need to update.");
            return;
        }
        C2134e.m10676b("TT-VehicleUpdateManager", String.format("Active trailer is changing from %s to %s.", new Object[]{this.f5934e, str}));
        this.f5934e = str;
        this.f5931b.m12212f(str);
        m8382c();
    }

    public String m8387b() {
        return this.f5933d;
    }

    public void m8389b(String str) {
        if (am.m4189a(this.f5933d, str)) {
            C2134e.m10676b("TT-VehicleUpdateManager", "Shipping doc remains unchanged, no need to update.");
            return;
        }
        C2134e.m10676b("TT-VehicleUpdateManager", String.format("Active shipping doc is changing from %s to %s.", new Object[]{this.f5933d, str}));
        this.f5933d = str;
        this.f5931b.m12215g(str);
        m8383d();
    }

    private void m8382c() {
        String a = m8384a();
        for (C1716a a2 : (C1716a[]) this.f5932c.toArray(new C1716a[this.f5932c.size()])) {
            a2.mo1055a(a);
        }
    }

    private void m8383d() {
        String b = m8387b();
        for (C1716a b2 : (C1716a[]) this.f5932c.toArray(new C1716a[this.f5932c.size()])) {
            b2.mo1056b(b);
        }
    }

    public void m8385a(C1716a c1716a) {
        this.f5932c.add(c1716a);
    }

    public void m8388b(C1716a c1716a) {
        this.f5932c.remove(c1716a);
    }
}
