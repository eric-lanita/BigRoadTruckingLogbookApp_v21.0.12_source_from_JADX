package com.bigroad.ttb.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.HashSet;
import java.util.Set;

public class ConnectivityTracker {
    private static ConnectivityTracker f4062a;
    private final ConnectivityManager f4063b;
    private final Set<C1198a> f4064c = new HashSet();

    public enum Connectivity {
        CONNECTED,
        CONNECTING,
        NOT_CONNECTED
    }

    public interface C1198a {
        void mo1005a(ConnectivityTracker connectivityTracker);
    }

    public static ConnectivityTracker m6107a(Context context) {
        if (f4062a == null) {
            f4062a = new ConnectivityTracker(context);
        }
        return f4062a;
    }

    private ConnectivityTracker(Context context) {
        this.f4063b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public void m6110a(C1198a c1198a) {
        this.f4064c.add(c1198a);
    }

    public void m6112b(C1198a c1198a) {
        this.f4064c.remove(c1198a);
    }

    private void m6108d() {
        for (C1198a a : (C1198a[]) this.f4064c.toArray(new C1198a[this.f4064c.size()])) {
            a.mo1005a(this);
        }
    }

    public void m6109a() {
        m6108d();
    }

    public Connectivity m6111b() {
        NetworkInfo c = m6113c();
        if (c != null) {
            if (c.isConnected()) {
                return Connectivity.CONNECTED;
            }
            if (c.isConnectedOrConnecting()) {
                return Connectivity.CONNECTING;
            }
        }
        NetworkInfo[] allNetworkInfo = this.f4063b.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                    return Connectivity.CONNECTING;
                }
            }
        }
        return Connectivity.NOT_CONNECTED;
    }

    public NetworkInfo m6113c() {
        return this.f4063b.getActiveNetworkInfo();
    }
}
