package com.urbanairship.google;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.lang.reflect.Modifier;

public class C3780c {
    private static Boolean f13557a;
    private static Boolean f13558b;
    private static Boolean f13559c;
    private static Boolean f13560d;
    private static Boolean f13561e;

    public static int m19705a(Context context) {
        if (C3780c.m19706a()) {
            return C3779b.m19704a(context);
        }
        return -1;
    }

    public static boolean m19706a() {
        if (f13557a == null) {
            try {
                Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                f13557a = Boolean.valueOf(true);
            } catch (ClassNotFoundException e) {
                f13557a = Boolean.valueOf(false);
            }
        }
        return f13557a.booleanValue();
    }

    public static boolean m19708b() {
        if (f13558b == null) {
            if (C3780c.m19706a()) {
                try {
                    Class.forName("com.google.android.gms.gcm.GoogleCloudMessaging");
                    Class.forName("com.google.android.gms.gcm.GcmReceiver");
                    f13558b = Boolean.valueOf(true);
                } catch (ClassNotFoundException e) {
                    f13558b = Boolean.valueOf(false);
                }
            } else {
                f13558b = Boolean.valueOf(false);
            }
        }
        return f13558b.booleanValue();
    }

    public static boolean m19710c() {
        if (f13559c == null) {
            if (C3780c.m19706a()) {
                try {
                    boolean z;
                    Class.forName("com.google.android.gms.location.LocationServices");
                    if (Modifier.isInterface(Class.forName("com.google.android.gms.common.api.GoogleApiClient").getModifiers())) {
                        z = false;
                    } else {
                        z = true;
                    }
                    f13559c = Boolean.valueOf(z);
                } catch (ClassNotFoundException e) {
                    f13559c = Boolean.valueOf(false);
                }
            } else {
                f13559c = Boolean.valueOf(false);
            }
        }
        return f13559c.booleanValue();
    }

    public static boolean m19711d() {
        if (f13561e == null) {
            if (C3780c.m19706a()) {
                try {
                    Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                    f13561e = Boolean.valueOf(true);
                } catch (ClassNotFoundException e) {
                    f13561e = Boolean.valueOf(false);
                }
            } else {
                f13561e = Boolean.valueOf(false);
            }
        }
        return f13561e.booleanValue();
    }

    public static boolean m19709b(Context context) {
        if (f13560d == null) {
            boolean z = C3780c.m19707a(context, "com.android.vending") || C3780c.m19707a(context, "com.google.market");
            f13560d = Boolean.valueOf(z);
        }
        return f13560d.booleanValue();
    }

    private static boolean m19707a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
