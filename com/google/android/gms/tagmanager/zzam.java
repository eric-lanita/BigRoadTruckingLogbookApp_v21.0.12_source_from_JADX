package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

class zzam {
    @TargetApi(9)
    static boolean m18081a(String str) {
        if (version() < 9) {
            return false;
        }
        File file = new File(str);
        file.setReadable(false, false);
        file.setWritable(false, false);
        file.setReadable(true, true);
        file.setWritable(true, true);
        return true;
    }

    public static int version() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            String str = "Invalid version number: ";
            String valueOf = String.valueOf(VERSION.SDK);
            zzbn.m18105e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            return 0;
        }
    }
}
