package com.urbanairship.preference;

import com.urbanairship.C3929q;
import java.util.Date;

public class QuietTimeStartPreference extends QuietTimePickerPreference {
    protected String mo2816a() {
        return "QUIET_TIME_START";
    }

    protected void mo2817a(C3929q c3929q, long j) {
        Date[] s = c3929q.m20390n().m20327s();
        c3929q.m20390n().m20304a(new Date(j), s != null ? s[1] : new Date());
    }
}
