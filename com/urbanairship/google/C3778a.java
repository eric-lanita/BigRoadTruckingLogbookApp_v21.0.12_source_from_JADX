package com.urbanairship.google;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.push.GcmPushReceiver;
import com.urbanairship.util.C3949d;

public class C3778a {
    public static void m19703a(C3761b c3761b) {
        PackageManager d = C3929q.m20378d();
        String b = C3929q.m20374b();
        C3949d.m20497a("android.permission.WAKE_LOCK");
        if (C3949d.m20502d("com.google.android.c2dm.permission.RECEIVE")) {
            C3949d.m20497a("com.google.android.c2dm.permission.RECEIVE");
        } else {
            C3783j.m19728e("Required permission com.google.android.c2dm.permission.RECEIVE is unknown to PackageManager.");
        }
        ApplicationInfo applicationInfo = C3929q.m20379e().applicationInfo;
        if ((applicationInfo != null && applicationInfo.targetSdkVersion < 16) || VERSION.SDK_INT < 16) {
            String str = b + ".permission.C2D_MESSAGE";
            if (C3949d.m20502d(str)) {
                C3949d.m20497a(str);
            } else {
                C3783j.m19728e("Required permission " + str + " is unknown to PackageManager.");
            }
        }
        if (C3780c.m19708b()) {
            if (C3949d.m20500c(GcmPushReceiver.class) != null) {
                Intent intent = new Intent("com.google.android.c2dm.intent.RECEIVE");
                intent.addCategory(b);
                if (d.queryBroadcastReceivers(intent, 0).isEmpty()) {
                    C3783j.m19728e("AndroidManifest.xml's " + GcmPushReceiver.class.getCanonicalName() + " declaration missing required " + intent.getAction() + " filter with category = " + b);
                }
            } else {
                C3783j.m19728e("AndroidManifest.xml missing required receiver: " + GcmPushReceiver.class.getCanonicalName());
            }
            try {
                C3780c.m19705a(C3929q.m20382h());
                return;
            } catch (IllegalStateException e) {
                C3783j.m19728e("Google Play services developer error: " + e.getMessage());
                return;
            }
        }
        C3783j.m19728e("Google Play services required for GCM.");
    }
}
