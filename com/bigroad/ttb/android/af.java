package com.bigroad.ttb.android;

import android.content.Context;
import android.content.res.Resources;
import com.bigroad.shared.aq;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.TimeZone;

public abstract class af {
    public static String m8282a(String str, Context context) {
        Resources resources = context.getResources();
        String a = aq.m4216a(str);
        if (a == null) {
            C2134e.m10680d("TT-L10n_TZ", "Missing TZ resource identifier for timeZone: " + str);
            return str;
        }
        int identifier = resources.getIdentifier(a, "string", context.getPackageName());
        if (identifier != 0) {
            return resources.getString(identifier);
        }
        C2134e.m10680d("TT-L10n_TZ", "Missing TZ resource identifier: " + a);
        return str;
    }

    public static String m8283a(TimeZone timeZone, Context context) {
        return m8282a(timeZone.getID(), context);
    }
}
