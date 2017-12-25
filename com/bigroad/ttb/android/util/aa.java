package com.bigroad.ttb.android.util;

import android.util.Base64;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;

public class aa {
    public static String m11165a() {
        byte[] toByteArray = OurApplication.m6285g().m12210f().toByteArray();
        return ("&token=" + Base64.encodeToString(toByteArray, 8)).trim();
    }

    public static String m11166a(String str, String str2, String str3, String str4) {
        String str5 = "";
        if (!am.m4188a((CharSequence) str)) {
            str5 = str5 + "&utm_campaign=" + str;
        }
        if (!am.m4188a((CharSequence) str2)) {
            str5 = str5 + "&utm_content=" + str2;
        }
        if (!am.m4188a((CharSequence) str3)) {
            str5 = str5 + "&utm_medium=" + str3;
        }
        if (am.m4188a((CharSequence) str4)) {
            return str5;
        }
        return str5 + "&utm_source=" + str4;
    }
}
