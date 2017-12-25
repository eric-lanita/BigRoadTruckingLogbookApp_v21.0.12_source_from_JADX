package com.urbanairship.location;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3790k;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.JsonException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LocationService extends Service {
    static boolean f13600d = false;
    static LocationRequestOptions f13601e = null;
    C3801a f13602a;
    C3821g f13603b;
    Looper f13604c;
    private final Set<Messenger> f13605f = new HashSet();
    private final HashMap<Messenger, SparseArray<C3790k<Location>>> f13606g = new HashMap();
    private Messenger f13607h;
    private Location f13608i;

    protected class C3801a extends Handler {
        final /* synthetic */ LocationService f13599a;

        public C3801a(LocationService locationService, Looper looper) {
            this.f13599a = locationService;
            super(looper);
        }

        public void handleMessage(Message message) {
            C3783j.m19723b("LocationService - Received message: " + message);
            switch (message.what) {
                case 1:
                    this.f13599a.m19842a(message);
                    return;
                case 2:
                    this.f13599a.m19849b(message);
                    return;
                case 5:
                    this.f13599a.m19852c(message);
                    return;
                case 6:
                    this.f13599a.m19854d(message);
                    return;
                case 7:
                    this.f13599a.m19841a((Intent) message.obj);
                    this.f13599a.stopSelf(message.arg1);
                    return;
                default:
                    C3783j.m19728e("LocationService - Unexpected message sent to location service: " + message);
                    return;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f13607h.getBinder();
    }

    public void onDestroy() {
        this.f13603b.m19917b();
        this.f13604c.quit();
        super.onDestroy();
        C3783j.m19723b("LocationService - Service destroyed.");
    }

    public void onCreate() {
        super.onCreate();
        C1187d.m6035c(getApplicationContext());
        HandlerThread handlerThread = new HandlerThread("LocationService");
        handlerThread.start();
        this.f13604c = handlerThread.getLooper();
        this.f13602a = new C3801a(this, this.f13604c);
        this.f13607h = new Messenger(this.f13602a);
        this.f13603b = new C3821g(getApplicationContext());
        C3783j.m19723b("LocationService - Service created.");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (C3929q.m20384j() || C3929q.m20383i()) {
            Message obtainMessage = this.f13602a.obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = intent;
            obtainMessage.what = 7;
            this.f13602a.sendMessage(obtainMessage);
        } else {
            C3783j.m19728e("LocationService - unable to start service, takeOff not called.");
            stopSelf(i2);
        }
        return 2;
    }

    private void m19841a(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            C3783j.m19723b("LocationService - Received intent with action: " + intent.getAction());
            String action = intent.getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case -895304300:
                    if (action.equals("com.urbanairship.location.ACTION_CHECK_LOCATION_UPDATES")) {
                        obj = null;
                        break;
                    }
                    break;
                case 569879094:
                    if (action.equals("com.urbanairship.location.ACTION_LOCATION_UPDATE")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    m19851c(intent);
                    return;
                case 1:
                    m19848b(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private void m19842a(Message message) {
        if (message.replyTo != null) {
            C3783j.m19725c("LocationService - Client subscribed for updates: " + message.replyTo);
            this.f13605f.add(message.replyTo);
            if (this.f13608i != null && System.currentTimeMillis() - this.f13608i.getTime() < 5000 && !m19846a(message.replyTo, 3, 0, this.f13608i)) {
                this.f13605f.remove(message.replyTo);
            }
        }
    }

    private void m19849b(Message message) {
        if (this.f13605f.remove(message.replyTo)) {
            C3783j.m19725c("LocationService - Client unsubscribed from updates: " + message.replyTo);
        }
    }

    private void m19852c(Message message) {
        final int i = message.arg1;
        final Messenger messenger = message.replyTo;
        final LocationRequestOptions locationRequestOptions = (LocationRequestOptions) message.getData().getParcelable("com.urbanairship.location.EXTRA_LOCATION_REQUEST_OPTIONS");
        if (locationRequestOptions == null) {
            C3783j.m19721a("Location service unable to perform single location request. Missing request options.");
            m19846a(messenger, 4, i, null);
            return;
        }
        C3783j.m19723b("LocationService - Single location request for client: " + messenger + " ID: " + i);
        C3783j.m19727d("Requesting single location update with request options: " + locationRequestOptions);
        this.f13603b.m19914a();
        C3790k a = this.f13603b.m19913a(new C3799c(this) {
            final /* synthetic */ LocationService f13598d;

            public void m19836a(Location location) {
                C3783j.m19723b("LocationService - Single location received for client: " + messenger + " ID: " + i);
                C3783j.m19727d("Received single location update: " + location);
                C3929q.m20372a().m20394r().m19454a(location, locationRequestOptions, 1);
                this.f13598d.m19846a(messenger, 4, i, location);
                this.f13598d.m19839a(messenger, i);
            }
        }, locationRequestOptions);
        if (a == null) {
            C3783j.m19721a("Location service unable to perform single location request. UALocationProvider failed to request a location.");
            m19846a(messenger, 4, i, null);
            return;
        }
        m19843a(messenger, i, a);
    }

    private void m19854d(Message message) {
        int i = message.arg1;
        Messenger messenger = message.replyTo;
        C3790k a = m19839a(messenger, i);
        if (a != null) {
            C3783j.m19725c("LocationService - Canceled single request for client: " + messenger + " ID: " + i);
            a.mo2787a();
        }
    }

    private void m19848b(Intent intent) {
        if (C3929q.m20372a().m20392p().m19911f() && !f13600d) {
            if (f13601e == null) {
                String a = C3929q.m20372a().m20392p().m19910e().m19810a("com.urbanairship.location.LAST_REQUESTED_LOCATION_OPTIONS", null);
                if (a != null) {
                    try {
                        f13601e = LocationRequestOptions.m19828a(a);
                    } catch (JsonException e) {
                        C3783j.m19728e("LocationService - Failed parsing LocationRequestOptions from JSON: " + e.getMessage());
                    } catch (IllegalArgumentException e2) {
                        C3783j.m19728e("LocationService - Invalid LocationRequestOptions from JSON: " + e2.getMessage());
                    }
                }
            }
            if (intent.hasExtra("providerEnabled")) {
                C3783j.m19725c("LocationService - Restarting location updates. One of the location providers was enabled or disabled.");
                LocationRequestOptions d = C3929q.m20372a().m20392p().m19909d();
                PendingIntent a2 = m19838a();
                C3929q.m20372a().m20392p().m19910e().m19814a("com.urbanairship.location.LAST_REQUESTED_LOCATION_OPTIONS", (C3684c) d);
                this.f13603b.m19914a();
                this.f13603b.m19915a(a2);
                this.f13603b.m19916a(d, a2);
                return;
            }
            Location location = (Location) (intent.hasExtra("location") ? intent.getParcelableExtra("location") : intent.getParcelableExtra("com.google.android.location.LOCATION"));
            if (location != null) {
                this.f13608i = location;
                C3783j.m19727d("Received location update: " + location);
                C3929q.m20372a().m20394r().m19454a(location, f13601e == null ? C3929q.m20372a().m20392p().m19909d() : f13601e, 0);
                for (Messenger messenger : new ArrayList(this.f13605f)) {
                    if (!m19846a(messenger, 3, 0, location)) {
                        this.f13605f.remove(messenger);
                    }
                }
            }
        }
    }

    private void m19851c(Intent intent) {
        if (C3929q.m20372a().m20392p().m19911f()) {
            LocationRequestOptions d = C3929q.m20372a().m20392p().m19909d();
            if (f13601e == null || !f13601e.equals(d)) {
                C3783j.m19725c("LocationService - Starting updates.");
                C3929q.m20372a().m20392p().m19910e().m19814a("com.urbanairship.location.LAST_REQUESTED_LOCATION_OPTIONS", (C3684c) d);
                f13601e = d;
                f13600d = false;
                PendingIntent a = m19838a();
                this.f13603b.m19914a();
                this.f13603b.m19915a(a);
                this.f13603b.m19916a(d, a);
            }
        } else if (!f13600d) {
            C3783j.m19725c("LocationService - Stopping updates.");
            this.f13603b.m19915a(m19838a());
            f13601e = null;
            f13600d = true;
        }
    }

    private void m19843a(Messenger messenger, int i, C3790k<Location> c3790k) {
        synchronized (this.f13606g) {
            if (messenger != null && i > 0) {
                if (!this.f13606g.containsKey(messenger)) {
                    this.f13606g.put(messenger, new SparseArray());
                }
                ((SparseArray) this.f13606g.get(messenger)).put(i, c3790k);
            }
        }
    }

    private synchronized C3790k<Location> m19839a(Messenger messenger, int i) {
        C3790k<Location> c3790k = null;
        synchronized (this) {
            synchronized (this.f13606g) {
                if (this.f13606g.containsKey(messenger)) {
                    SparseArray sparseArray = (SparseArray) this.f13606g.get(messenger);
                    if (sparseArray != null) {
                        c3790k = (C3790k) sparseArray.get(i);
                        sparseArray.remove(i);
                        if (sparseArray.size() == 0) {
                            this.f13606g.remove(messenger);
                        }
                    }
                }
            }
        }
        return c3790k;
    }

    private boolean m19846a(Messenger messenger, int i, int i2, Object obj) {
        if (messenger == null) {
            return false;
        }
        try {
            messenger.send(Message.obtain(null, i, i2, 0, obj));
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    private PendingIntent m19838a() {
        return PendingIntent.getService(getApplicationContext(), 0, new Intent(getApplicationContext(), LocationService.class).setAction("com.urbanairship.location.ACTION_LOCATION_UPDATE"), 134217728);
    }
}
