package com.urbanairship.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;

public class C3950e {
    public static boolean m20503a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C3929q.m20382h().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        }
        C3783j.m19728e("Error fetching network info.");
        return false;
    }
}
