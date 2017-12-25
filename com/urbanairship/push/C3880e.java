package com.urbanairship.push;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.google.C3780c;
import com.urbanairship.util.C3949d;

class C3880e {
    public static void m20120a() {
        if (C3880e.m20121b()) {
            String token = InstanceID.getInstance(C3929q.m20382h()).getToken(C3929q.m20372a().m20388l().f13508h, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            if (token == null) {
                C3783j.m19728e("GCM registration failed. Token is null.");
            } else if (token.equals(C3929q.m20372a().m20390n().m20332x())) {
                C3783j.m19723b("GCM token up to date.");
            } else {
                C3783j.m19727d("GCM registration successful. Token: " + token);
                C3929q.m20372a().m20390n().m20312d(token);
            }
        }
    }

    private static boolean m20121b() {
        if (C3780c.m19708b()) {
            try {
                if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(C3929q.m20382h()) != 0) {
                    C3783j.m19728e("Google Play services is currently unavailable.");
                    return false;
                } else if (!C3949d.m20502d("com.google.android.c2dm.permission.RECEIVE")) {
                    C3783j.m19728e("com.google.android.c2dm.permission.RECEIVE is unknown to PackageManager. Note that an AVD emulator may not support GCM.");
                    C3783j.m19728e("If you're running in an emulator, you need to install the appropriate image through the Android SDK and AVM manager. See http://developer.android.com/guide/google/gcm/ for further details.");
                    return false;
                } else if (C3929q.m20372a().m20388l().f13508h != null) {
                    return true;
                } else {
                    C3783j.m19728e("The GCM sender ID is not set. Unable to register.");
                    return false;
                }
            } catch (IllegalStateException e) {
                C3783j.m19728e("Unable to register with GCM: " + e.getMessage());
                return false;
            }
        }
        C3783j.m19728e("Google Play services for GCM is unavailable.");
        return false;
    }
}
