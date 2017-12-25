package com.bigroad.ttb.android.util;

import android.content.res.Resources;
import com.bigroad.shared.ak;
import com.bigroad.shared.duty.C0954t;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.RecapType;
import com.bigroad.ttb.protocol.TTProtocol.al;

public class C2300s extends ak {
    public static String m11250a(Resources resources, int i) {
        return C2300s.m11251a(resources, RecapType.m14775a(i));
    }

    public static String m11251a(Resources resources, RecapType recapType) {
        switch (recapType) {
            case NO_RECAP:
                return resources.getString(R.string.recapType_noRecap);
            case SUMMARY:
                return resources.getString(R.string.recapType_summary);
            case FULL:
                return resources.getString(R.string.recapType_full);
            default:
                return resources.getString(R.string.recapType_noRecap);
        }
    }

    public static C0954t m11249a(DailyLog dailyLog, long j) {
        if (dailyLog == null) {
            return null;
        }
        return new C0954t(new C0956v((al) dailyLog), OurApplication.m6295q().m10025b(), dailyLog.getLogDay(), OurApplication.m6296r().m8493g(), C2292l.m11231a(dailyLog), j);
    }
}
