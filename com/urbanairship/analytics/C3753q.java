package com.urbanairship.analytics;

import com.urbanairship.C3783j;
import com.urbanairship.json.C3788b;

class C3753q extends C3737i {
    private final String f13456a;
    private final long f13457b;
    private final long f13458c;
    private final String f13459d;

    C3753q(String str, String str2, long j, long j2) {
        this.f13456a = str;
        this.f13457b = j;
        this.f13458c = j2;
        this.f13459d = str2;
    }

    public boolean mo2780c() {
        if (this.f13456a.length() > 255 || this.f13456a.length() <= 0) {
            C3783j.m19728e("Screen identifier string must be between 1 and 255 characters long.");
            return false;
        } else if (this.f13457b <= this.f13458c) {
            return true;
        } else {
            C3783j.m19728e("Screen tracking duration must be positive or zero.");
            return false;
        }
    }

    public String mo2778a() {
        return "screen_tracking";
    }

    protected final C3788b mo2779b() {
        return C3788b.m19777a().m19774a("screen", this.f13456a).m19774a("entered_time", C3737i.m19485a(this.f13457b)).m19774a("exited_time", C3737i.m19485a(this.f13458c)).m19774a("duration", C3737i.m19485a(this.f13458c - this.f13457b)).m19774a("previous_screen", this.f13459d).m19776a();
    }
}
