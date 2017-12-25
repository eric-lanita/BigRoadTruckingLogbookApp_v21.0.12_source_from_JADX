package com.urbanairship.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;

public class C3951f {
    private static int f14008a = 1000;
    private static int f14009b = 40;

    private static SharedPreferences m20507b() {
        return C3929q.m20382h().getSharedPreferences("com.urbanairship.notificationidgenerator", 0);
    }

    private static void m20505a(String str, int i) {
        Editor edit = C3951f.m20507b().edit();
        edit.putInt(str, i);
        edit.commit();
    }

    private static int m20506b(String str, int i) {
        return C3951f.m20507b().getInt(str, i);
    }

    public static int m20504a() {
        int b = C3951f.m20506b("count", f14008a) + 1;
        if (b < f14008a + f14009b) {
            C3783j.m19723b("NotificationIdGenerator - Incrementing notification ID count");
            C3951f.m20505a("count", b);
        } else {
            C3783j.m19723b("NotificationIdGenerator - Resetting notification ID count");
            C3951f.m20505a("count", f14008a);
        }
        C3783j.m19723b("NotificationIdGenerator - Notification ID: " + b);
        return b;
    }
}
