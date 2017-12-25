package com.urbanairship.preference;

import com.urbanairship.C3929q;
import java.util.Date;

public class QuietTimeEndPreference extends QuietTimePickerPreference {
    protected String mo2816a() {
        return "QUIET_TIME_END";
    }

    protected void mo2817a(C3929q c3929q, long j) {
        Date[] s = c3929q.m20390n().m20327s();
        c3929q.m20390n().m20304a(s != null ? s[0] : new Date(), new Date(j));
    }
}
