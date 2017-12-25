package com.urbanairship;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.WakefulBroadcastReceiver;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseIntentService extends IntentService {
    private final Map<String, C3676a> f13294a = new HashMap();

    public static abstract class C3676a {
        private final C3796l f13292a;
        private final Context f13293b;

        protected abstract void mo2820a(Intent intent);

        public C3676a(Context context, C3796l c3796l) {
            this.f13293b = context;
            this.f13292a = c3796l;
        }

        protected Context m19269a() {
            return this.f13293b;
        }

        protected C3796l m19272b() {
            return this.f13292a;
        }

        protected long m19271b(Intent intent) {
            return 10000;
        }

        protected long m19273c(Intent intent) {
            return 5120000;
        }

        public void m19274d(Intent intent) {
            long b;
            Intent intent2 = new Intent(intent);
            intent2.removeExtra("android.support.content.wakelockid");
            long longExtra = intent2.getLongExtra("com.urbanairship.EXTRA_BACK_OFF_MS", 0);
            if (longExtra <= 0) {
                b = m19271b(intent2);
            } else {
                b = Math.min(longExtra * 2, m19273c(intent2));
            }
            intent2.putExtra("com.urbanairship.EXTRA_BACK_OFF_MS", b);
            C3783j.m19723b("BaseIntentService - Scheduling intent " + intent2.getAction() + " in " + b + " milliseconds.");
            try {
                ((AlarmManager) this.f13293b.getSystemService("alarm")).set(3, b + SystemClock.elapsedRealtime(), PendingIntent.getService(this.f13293b, 0, intent2, 134217728));
            } catch (Throwable e) {
                C3783j.m19726c("BaseIntentService - Failed to schedule intent " + intent2.getAction(), e);
            }
        }
    }

    protected abstract C3676a mo2818a(String str, C3796l c3796l);

    public BaseIntentService(String str) {
        super(str);
    }

    public void onCreate() {
        super.onCreate();
        C1187d.m6035c(getApplicationContext());
    }

    protected void onHandleIntent(Intent intent) {
        if (!C3929q.m20384j() && !C3929q.m20383i()) {
            C3783j.m19728e("BaseIntentService - unable to handle intent, takeOff not called.");
        } else if (intent != null) {
            try {
                String action = intent.getAction();
                if (action != null) {
                    C3676a c3676a = (C3676a) this.f13294a.get(action);
                    if (c3676a == null) {
                        c3676a = mo2818a(action, C3929q.m20372a().f13946j);
                    }
                    if (c3676a == null) {
                        C3783j.m19725c("BaseIntentService - No delegate for intent action: " + action);
                        WakefulBroadcastReceiver.completeWakefulIntent(intent);
                        return;
                    }
                    this.f13294a.put(action, c3676a);
                    c3676a.mo2820a(intent);
                    WakefulBroadcastReceiver.completeWakefulIntent(intent);
                }
            } finally {
                WakefulBroadcastReceiver.completeWakefulIntent(intent);
            }
        }
    }
}
