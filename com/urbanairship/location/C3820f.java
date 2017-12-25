package com.urbanairship.location;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.content.C0126a;
import android.support.v4.content.C0265i;
import android.util.SparseArray;
import com.urbanairship.C3680a;
import com.urbanairship.C3783j;
import com.urbanairship.C3790k;
import com.urbanairship.C3796l;
import com.urbanairship.C3796l.C3795b;
import com.urbanairship.C3929q;
import com.urbanairship.json.JsonException;
import com.urbanairship.location.LocationRequestOptions.C3798a;
import java.util.ArrayList;
import java.util.List;

public class C3820f extends C3680a {
    private final Messenger f13638a;
    private final Context f13639b;
    private Messenger f13640c;
    private boolean f13641d;
    private boolean f13642e;
    private int f13643f = 1;
    private final SparseArray<C3819b> f13644g = new SparseArray();
    private final C3796l f13645h;
    private BroadcastReceiver f13646i = new C38151(this);
    private final List<C3808d> f13647j = new ArrayList();
    private final ServiceConnection f13648k = new C38162(this);
    private final C3795b f13649l = new C38173(this);

    class C38151 extends BroadcastReceiver {
        final /* synthetic */ C3820f f13632a;

        C38151(C3820f c3820f) {
            this.f13632a = c3820f;
        }

        public void onReceive(Context context, Intent intent) {
            this.f13632a.m19900h();
        }
    }

    class C38162 implements ServiceConnection {
        final /* synthetic */ C3820f f13633a;

        C38162(C3820f c3820f) {
            this.f13633a = c3820f;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C3783j.m19723b("Location service connected.");
            this.f13633a.m19892a(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C3783j.m19723b("Location service disconnected.");
            this.f13633a.m19905m();
        }
    }

    class C38173 implements C3795b {
        final /* synthetic */ C3820f f13634a;

        C38173(C3820f c3820f) {
            this.f13634a = c3820f;
        }

        public void mo2801a(String str) {
            Object obj = -1;
            switch (str.hashCode()) {
                case 56233632:
                    if (str.equals("com.urbanairship.location.LOCATION_OPTIONS")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 283482798:
                    if (str.equals("com.urbanairship.location.LOCATION_UPDATES_ENABLED")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 375109006:
                    if (str.equals("com.urbanairship.location.BACKGROUND_UPDATES_ALLOWED")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                case 1:
                case 2:
                    this.f13634a.m19900h();
                    return;
                default:
                    return;
            }
        }
    }

    private static class C3818a extends Handler {
        C3818a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            C3820f p = C3929q.m20372a().m20392p();
            Location location;
            switch (message.what) {
                case 3:
                    location = (Location) message.obj;
                    if (location != null) {
                        synchronized (p.f13647j) {
                            for (C3808d a : p.f13647j) {
                                a.m19870a(location);
                            }
                        }
                        return;
                    }
                    return;
                case 4:
                    location = (Location) message.obj;
                    int i = message.arg1;
                    synchronized (p.f13644g) {
                        C3790k c3790k = (C3790k) p.f13644g.get(i);
                        if (c3790k != null) {
                            c3790k.m19788a(location);
                            p.f13644g.remove(i);
                            p.m19900h();
                        }
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    private class C3819b extends C3790k<Location> {
        final /* synthetic */ C3820f f13635a;
        private final LocationRequestOptions f13636b;
        private final int f13637c;

        protected void mo2792c() {
            if (!mo2788b()) {
                this.f13635a.m19895a(6, this.f13637c, null);
            }
            synchronized (this.f13635a.f13644g) {
                this.f13635a.f13644g.remove(this.f13637c);
            }
        }

        synchronized void m19891e() {
            if (!mo2788b()) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.urbanairship.location.EXTRA_LOCATION_REQUEST_OPTIONS", this.f13636b);
                this.f13635a.m19895a(5, this.f13637c, bundle);
            }
        }
    }

    public C3820f(Context context, C3796l c3796l) {
        this.f13639b = context.getApplicationContext();
        this.f13645h = c3796l;
        this.f13638a = new Messenger(new C3818a(Looper.getMainLooper()));
    }

    protected void mo2777a() {
        this.f13645h.m19812a(this.f13649l);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.urbanairship.analytics.APP_FOREGROUND");
        intentFilter.addAction("com.urbanairship.analytics.APP_BACKGROUND");
        C0265i.m1105a(this.f13639b).m1109a(this.f13646i, intentFilter);
        m19900h();
    }

    public boolean m19907b() {
        return this.f13645h.m19815a("com.urbanairship.location.LOCATION_UPDATES_ENABLED", false);
    }

    public boolean m19908c() {
        return this.f13645h.m19815a("com.urbanairship.location.BACKGROUND_UPDATES_ALLOWED", false);
    }

    public LocationRequestOptions m19909d() {
        LocationRequestOptions locationRequestOptions = null;
        String a = this.f13645h.m19810a("com.urbanairship.location.LOCATION_OPTIONS", (String) locationRequestOptions);
        if (a != null) {
            try {
                locationRequestOptions = LocationRequestOptions.m19828a(a);
            } catch (JsonException e) {
                C3783j.m19728e("UALocationManager - Failed parsing LocationRequestOptions from JSON: " + e.getMessage());
            } catch (IllegalArgumentException e2) {
                C3783j.m19728e("UALocationManager - Invalid LocationRequestOptions from JSON: " + e2.getMessage());
            }
        }
        if (locationRequestOptions == null) {
            return new C3798a().m19827a();
        }
        return locationRequestOptions;
    }

    C3796l m19910e() {
        return this.f13645h;
    }

    private void m19900h() {
        if (m19912g()) {
            if (m19911f()) {
                synchronized (this.f13647j) {
                    if (!this.f13647j.isEmpty()) {
                        if (this.f13641d) {
                            m19902j();
                        } else {
                            m19901i();
                            return;
                        }
                    }
                }
            }
            m19903k();
            synchronized (this.f13644g) {
                if (this.f13644g.size() == 0) {
                    m19904l();
                }
            }
            if (this.f13639b.startService(new Intent(this.f13639b, LocationService.class).setAction("com.urbanairship.location.ACTION_CHECK_LOCATION_UPDATES")) == null) {
                C3783j.m19728e("Unable to start location service. Check that the location service is added to the manifest.");
            }
        }
    }

    private synchronized void m19901i() {
        if (!this.f13641d) {
            C3783j.m19723b("UALocationManager - Binding to location service.");
            if (this.f13639b.bindService(new Intent(this.f13639b, LocationService.class), this.f13648k, 1)) {
                this.f13641d = true;
            } else {
                C3783j.m19728e("Unable to bind to location service. Check that the location service is added to the manifest.");
            }
        }
    }

    private synchronized void m19902j() {
        if (!this.f13642e && m19895a(1, 0, null)) {
            C3783j.m19727d("Subscribing to continuous location updates.");
            this.f13642e = true;
        }
    }

    private synchronized void m19903k() {
        if (this.f13642e) {
            C3783j.m19727d("Unsubscribing from continuous location updates.");
            m19895a(2, 0, null);
            this.f13642e = false;
        }
    }

    private synchronized void m19904l() {
        if (this.f13641d) {
            C3783j.m19723b("UALocationManager - Unbinding to location service.");
            this.f13639b.unbindService(this.f13648k);
            this.f13641d = false;
        }
    }

    private synchronized void m19892a(IBinder iBinder) {
        this.f13640c = new Messenger(iBinder);
        synchronized (this.f13644g) {
            for (int i = 0; i < this.f13644g.size(); i++) {
                ((C3819b) this.f13644g.valueAt(i)).m19891e();
            }
        }
        m19900h();
    }

    private synchronized void m19905m() {
        this.f13640c = null;
        this.f13642e = false;
    }

    private boolean m19895a(int i, int i2, Bundle bundle) {
        if (this.f13640c == null) {
            return false;
        }
        Message obtain = Message.obtain(null, i, i2, 0);
        if (bundle != null) {
            obtain.setData(bundle);
        }
        obtain.replyTo = this.f13638a;
        try {
            this.f13640c.send(obtain);
            return true;
        } catch (RemoteException e) {
            C3783j.m19725c("UALocationManager - Remote exception when sending message to location service");
            return false;
        }
    }

    boolean m19911f() {
        return m19907b() && (m19908c() || C3929q.m20372a().m20394r().m19458b());
    }

    boolean m19912g() {
        try {
            int a = C0126a.m581a(this.f13639b, "android.permission.ACCESS_FINE_LOCATION");
            int a2 = C0126a.m581a(this.f13639b, "android.permission.ACCESS_COARSE_LOCATION");
            if (a == 0 || a2 == 0) {
                return true;
            }
            return false;
        } catch (RuntimeException e) {
            C3783j.m19728e("UALocationManager - Unable to retrieve location permissions: " + e.getMessage());
            return false;
        }
    }
}
