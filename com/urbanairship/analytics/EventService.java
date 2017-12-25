package com.urbanairship.analytics;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings.Secure;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.google.C3780c;
import com.urbanairship.util.C3954i;
import java.io.IOException;
import java.util.Map;

public class EventService extends IntentService {
    private static long f13373a = 0;
    private final C3745j f13374b;

    public EventService() {
        this("EventService");
    }

    public EventService(String str) {
        this(str, new C3745j());
    }

    EventService(String str, C3745j c3745j) {
        super(str);
        this.f13374b = c3745j;
    }

    public void onCreate() {
        super.onCreate();
        C1187d.m6035c(getApplicationContext());
    }

    protected void onHandleIntent(Intent intent) {
        if (!C3929q.m20384j() && !C3929q.m20383i()) {
            C3783j.m19728e("EventService - unable to handle intent, takeOff not called.");
        } else if (intent != null && intent.getAction() != null) {
            C3783j.m19723b("EventService - Received intent: " + intent.getAction());
            String action = intent.getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case -1528883156:
                    if (action.equals("com.urbanairship.analytics.ADD")) {
                        obj = 1;
                        break;
                    }
                    break;
                case -749312150:
                    if (action.equals("com.urbanairship.com.analytics.UPDATE_ADVERTISING_ID")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -150200003:
                    if (action.equals("com.urbanairship.analytics.SEND")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1857115874:
                    if (action.equals("com.urbanairship.analytics.DELETE_ALL")) {
                        obj = null;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    C3783j.m19727d("Deleting all analytic events.");
                    C3929q.m20372a().m20394r().m19462e().m19565a();
                    return;
                case 1:
                    m19414a(intent);
                    return;
                case 2:
                    m19412a();
                    return;
                case 3:
                    m19416c();
                    return;
                default:
                    C3783j.m19721a("EventService - Unrecognized intent action: " + intent.getAction());
                    return;
            }
        }
    }

    private void m19414a(Intent intent) {
        C3736c f = C3929q.m20372a().m20394r().m19463f();
        C3747k e = C3929q.m20372a().m20394r().m19462e();
        String stringExtra = intent.getStringExtra("EXTRA_EVENT_TYPE");
        String stringExtra2 = intent.getStringExtra("EXTRA_EVENT_ID");
        String stringExtra3 = intent.getStringExtra("EXTRA_EVENT_DATA");
        String stringExtra4 = intent.getStringExtra("EXTRA_EVENT_TIME_STAMP");
        String stringExtra5 = intent.getStringExtra("EXTRA_EVENT_SESSION_ID");
        int intExtra = intent.getIntExtra("EXTRA_EVENT_PRIORITY", 1);
        if (stringExtra == null || stringExtra3 == null || stringExtra4 == null || stringExtra2 == null) {
            C3783j.m19721a("Event service unable to add event with missing data.");
            return;
        }
        if (e.m19574d() > f.m19469a()) {
            C3783j.m19727d("Event database size exceeded. Deleting oldest session.");
            String b = e.m19571b();
            if (b != null && b.length() > 0) {
                e.m19569a(b);
            }
        }
        if (e.m19562a(stringExtra, stringExtra3, stringExtra2, stringExtra5, stringExtra4) <= 0) {
            C3783j.m19728e("EventService - Unable to insert event into database.");
        }
        switch (intExtra) {
            case 1:
                m19413a(Math.max(m19415b(), 10000));
                return;
            case 2:
                m19413a(1000);
                return;
            default:
                if (C3929q.m20372a().m20394r().m19458b()) {
                    m19413a(Math.max(m19415b(), 30000));
                    return;
                }
                m19413a(Math.max(Math.max(C3929q.m20372a().m20388l().f13513m - (System.currentTimeMillis() - f.m19480e()), m19415b()), 30000));
                return;
        }
    }

    private void m19412a() {
        C3736c f = C3929q.m20372a().m20394r().m19463f();
        C3747k e = C3929q.m20372a().m20394r().m19462e();
        f.m19471a(System.currentTimeMillis());
        int c = e.m19573c();
        if (C3929q.m20372a().m20390n().m20329u() == null) {
            C3783j.m19725c("EventService - No channel ID, skipping analytics send.");
        } else if (c <= 0) {
            C3783j.m19725c("EventService - No events to send. Ending analytics upload.");
        } else {
            Map a = e.m19564a(Math.min(500, f.m19473b() / (e.m19574d() / c)));
            C3748l a2 = this.f13374b.m19539a(a.values());
            Object obj = (a2 == null || a2.m19575a() != 200) ? null : 1;
            if (obj != null) {
                C3783j.m19727d("Analytic events uploaded successfully.");
                e.m19570a(a.keySet());
                f13373a = 0;
            } else {
                if (f13373a == 0) {
                    f13373a = (long) f.m19478d();
                } else {
                    f13373a = Math.min(f13373a * 2, (long) f.m19476c());
                }
                C3783j.m19725c("Analytic events failed to send. Will retry in " + f13373a + "ms.");
            }
            if (obj == null || c - a.size() > 0) {
                C3783j.m19725c("EventService - Scheduling next event batch upload.");
                m19413a(m19415b());
            }
            if (a2 != null) {
                f.m19470a(a2.m19576b());
                f.m19474b(a2.m19577c());
                f.m19477c(a2.m19578d());
                f.m19479d(a2.m19579e());
            }
        }
    }

    private long m19415b() {
        C3736c f = C3929q.m20372a().m20394r().m19463f();
        return Math.max(((((long) f.m19478d()) + f.m19480e()) + f13373a) - System.currentTimeMillis(), 0);
    }

    private void m19413a(long j) {
        int i = 1;
        long currentTimeMillis = System.currentTimeMillis() + j;
        C3736c f = C3929q.m20372a().m20394r().m19463f();
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService("alarm");
        Intent intent = new Intent(getApplicationContext(), EventService.class);
        intent.setAction("com.urbanairship.analytics.SEND");
        long f2 = f.m19481f();
        if (f2 >= System.currentTimeMillis() && f2 <= currentTimeMillis) {
            i = 0;
        }
        if (i != 0 || PendingIntent.getService(getApplicationContext(), 0, intent, 536870912) == null) {
            C3783j.m19723b("EventService - Scheduling event uploads in " + j + "ms.");
            try {
                alarmManager.set(1, currentTimeMillis, PendingIntent.getService(getApplicationContext(), 0, intent, 134217728));
                f.m19475b(currentTimeMillis);
                return;
            } catch (Throwable e) {
                C3783j.m19726c("EventService - Failed to schedule event uploads.", e);
                f.m19475b(-1);
                return;
            }
        }
        C3783j.m19723b("EventService - Alarm already scheduled for an earlier time.");
    }

    private void m19416c() {
        Throwable e;
        C3735b r = C3929q.m20372a().m20394r();
        C3741g k = r.m19468k();
        String b = k.m19508b();
        boolean c = k.m19509c();
        switch (C3929q.m20372a().m20399w()) {
            case 1:
                b = Secure.getString(getContentResolver(), "advertising_id");
                if (Secure.getInt(getContentResolver(), "limit_ad_tracking", -1) != 0) {
                    c = false;
                    break;
                } else {
                    c = true;
                    break;
                }
            case 2:
                if (C3780c.m19711d()) {
                    try {
                        Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
                        b = advertisingIdInfo.getId();
                        c = advertisingIdInfo.isLimitAdTrackingEnabled();
                        break;
                    } catch (IOException e2) {
                        e = e2;
                        C3783j.m19726c("EventService - Failed to retrieve and update advertising ID.", e);
                        return;
                    } catch (GooglePlayServicesNotAvailableException e3) {
                        e = e3;
                        C3783j.m19726c("EventService - Failed to retrieve and update advertising ID.", e);
                        return;
                    } catch (GooglePlayServicesRepairableException e4) {
                        e = e4;
                        C3783j.m19726c("EventService - Failed to retrieve and update advertising ID.", e);
                        return;
                    }
                }
                break;
        }
        if (!C3954i.m20513a(k.m19508b(), b) || k.m19509c() != c) {
            r.m19467j().m19439a(b, c).m19440a();
        }
    }
}
