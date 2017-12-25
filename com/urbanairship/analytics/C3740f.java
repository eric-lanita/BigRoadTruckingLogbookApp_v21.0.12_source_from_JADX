package com.urbanairship.analytics;

import com.urbanairship.C3783j;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import java.util.Map;
import java.util.Map.Entry;

class C3740f extends C3737i {
    private final Map<String, String> f13416a;

    C3740f(C3741g c3741g) {
        this.f13416a = c3741g.m19507a();
    }

    public String mo2778a() {
        return "associate_identifiers";
    }

    public boolean mo2780c() {
        boolean z = true;
        if (this.f13416a.size() > 100) {
            C3783j.m19728e("Associated identifiers exceeds 100");
            z = false;
        }
        boolean z2 = z;
        for (Entry entry : this.f13416a.entrySet()) {
            if (((String) entry.getKey()).length() > 255) {
                C3783j.m19728e("Associated identifiers key " + ((String) entry.getKey()) + " exceeds " + 255 + "  characters.");
                z2 = false;
            }
            if (((String) entry.getValue()).length() > 255) {
                C3783j.m19728e("Associated identifiers for key " + ((String) entry.getKey()) + " exceeds " + 255 + " characters.");
                z = false;
            } else {
                z = z2;
            }
            z2 = z;
        }
        return z2;
    }

    protected C3788b mo2779b() {
        return JsonValue.m19732a(this.f13416a).m19756g();
    }
}
