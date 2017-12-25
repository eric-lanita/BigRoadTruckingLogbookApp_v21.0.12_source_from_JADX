package com.urbanairship.p053a;

import android.content.Context;
import com.urbanairship.C3783j;

public class C3678a {
    private static Boolean f13302a;

    public static boolean m19291a() {
        if (f13302a != null) {
            return f13302a.booleanValue();
        }
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            f13302a = Boolean.valueOf(true);
        } catch (ClassNotFoundException e) {
            f13302a = Boolean.valueOf(false);
        }
        return f13302a.booleanValue();
    }

    public static boolean m19293b() {
        return C3678a.m19291a() && C3679b.m19298b();
    }

    public static void m19290a(Context context) {
        if (C3678a.m19293b()) {
            C3679b.m19296a(context);
        }
    }

    public static String m19292b(Context context) {
        if (C3678a.m19293b()) {
            return C3679b.m19297b(context);
        }
        return null;
    }

    public static void m19294c() {
        if (C3678a.m19291a()) {
            C3679b.m19295a();
        } else {
            C3783j.m19721a("ADM is not available on this device.");
        }
    }
}
