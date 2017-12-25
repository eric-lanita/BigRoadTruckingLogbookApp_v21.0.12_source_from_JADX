package com.bigroad.ttb.android.util;

import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.android.C2032f;

public class C2286g {
    public static boolean m11210a(C2032f c2032f, int i) {
        return C2286g.m11211a(c2032f, c2032f.mo1302j().m8469a(i), DailyLogUtils.m4284a(c2032f.mo1295c().m12228r().m4879m()));
    }

    public static boolean m11211a(C2032f c2032f, int i, int i2) {
        while (i2 >= i) {
            if (C2286g.m11212b(c2032f, i2)) {
                return true;
            }
            i2--;
        }
        return false;
    }

    public static boolean m11212b(C2032f c2032f, int i) {
        return c2032f.mo1301i().m10064n() && c2032f.mo1301i().m10036c(i) >= 1800000;
    }
}
