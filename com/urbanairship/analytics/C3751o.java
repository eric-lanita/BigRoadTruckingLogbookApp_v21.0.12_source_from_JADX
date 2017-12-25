package com.urbanairship.analytics;

import android.location.Location;
import com.facebook.internal.ServerProtocol;
import com.urbanairship.json.C3788b;
import com.urbanairship.util.C3954i;
import java.util.Locale;

public class C3751o extends C3737i {
    private final String f13446a;
    private final String f13447b;
    private final String f13448c;
    private final String f13449d;
    private final String f13450e;
    private final String f13451f;
    private final String f13452g;
    private final int f13453h;

    public C3751o(Location location, int i, int i2, int i3, boolean z) {
        this.f13447b = String.format(Locale.US, "%.6f", new Object[]{Double.valueOf(location.getLatitude())});
        this.f13448c = String.format(Locale.US, "%.6f", new Object[]{Double.valueOf(location.getLongitude())});
        this.f13446a = C3954i.m20512a(location.getProvider()) ? "UNKNOWN" : location.getProvider();
        this.f13449d = String.valueOf(location.getAccuracy());
        this.f13450e = i2 >= 0 ? String.valueOf(i2) : "NONE";
        this.f13451f = i3 >= 0 ? String.valueOf(i3) : "NONE";
        this.f13452g = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        this.f13453h = i;
    }

    public String mo2778a() {
        return "location";
    }

    protected final C3788b mo2779b() {
        return C3788b.m19777a().m19774a("lat", this.f13447b).m19774a("long", this.f13448c).m19774a("requested_accuracy", this.f13450e).m19774a("update_type", this.f13453h == 0 ? "CONTINUOUS" : "SINGLE").m19774a("provider", this.f13446a).m19774a("h_accuracy", this.f13449d).m19774a("v_accuracy", "NONE").m19774a("foreground", this.f13452g).m19774a("update_dist", this.f13451f).m19776a();
    }

    protected int mo2786l() {
        return 0;
    }
}
