package com.urbanairship.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.am;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.CoreReceiver;
import com.urbanairship.actions.ActionService;
import com.urbanairship.analytics.C3752p;
import com.urbanairship.json.C3785a;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.iam.InAppMessage;
import com.urbanairship.push.p033a.C1711e;
import com.urbanairship.richpush.C3941b.C3837a;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class C3882f extends C3676a {
    private final am f13794a;
    private final C3919j f13795b;
    private final C3929q f13796c;

    public C3882f(Context context, C3796l c3796l) {
        this(context, c3796l, C3929q.m20372a(), am.m737a(context));
    }

    public C3882f(Context context, C3796l c3796l, C3929q c3929q, am amVar) {
        super(context, c3796l);
        this.f13796c = c3929q;
        this.f13795b = c3929q.m20390n();
        this.f13794a = amVar;
    }

    protected void mo2820a(Intent intent) {
        String action = intent.getAction();
        Object obj = -1;
        switch (action.hashCode()) {
            case -1138418629:
                if (action.equals("com.urbanairship.push.ACTION_RECEIVE_GCM_MESSAGE")) {
                    obj = 1;
                    break;
                }
                break;
            case 856841428:
                if (action.equals("com.urbanairship.push.ACTION_RECEIVE_ADM_MESSAGE")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                m20129f(intent);
                return;
            case 1:
                m20128e(intent);
                return;
            default:
                return;
        }
    }

    private void m20128e(Intent intent) {
        if (this.f13796c.m20399w() != 2) {
            C3783j.m19728e("Received intent from invalid transport acting as GCM.");
        } else if (this.f13796c.m20390n().m20313e()) {
            Intent intent2 = (Intent) intent.getParcelableExtra("com.urbanairship.push.EXTRA_INTENT");
            if (intent2 == null) {
                C3783j.m19728e("IncomingPushServiceDelegate - Received GCM message missing original intent.");
                return;
            }
            String stringExtra = intent2.getStringExtra("from");
            if (stringExtra != null && !stringExtra.equals(this.f13796c.m20388l().f13508h)) {
                C3783j.m19727d("Ignoring GCM message from sender: " + stringExtra);
            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(intent2.getStringExtra("message_type"))) {
                C3783j.m19727d("GCM deleted " + intent2.getStringExtra("total_deleted") + " pending messages.");
            } else {
                m20124a(new PushMessage(intent2.getExtras()));
            }
        } else {
            C3783j.m19728e("IncomingPushServiceDelegate - Received intent from GCM without registering.");
        }
    }

    private void m20129f(Intent intent) {
        if (this.f13796c.m20399w() != 1) {
            C3783j.m19728e("Received intent from invalid transport acting as ADM.");
        } else if (this.f13796c.m20390n().m20313e()) {
            Intent intent2 = (Intent) intent.getParcelableExtra("com.urbanairship.push.EXTRA_INTENT");
            if (intent2 == null) {
                C3783j.m19728e("IncomingPushServiceDelegate - Received ADM message missing original intent.");
            } else {
                m20124a(new PushMessage(intent2.getExtras()));
            }
        } else {
            C3783j.m19728e("IncomingPushServiceDelegate - Received intent from ADM without registering.");
        }
    }

    private void m20124a(PushMessage pushMessage) {
        if (!this.f13795b.m20308b()) {
            C3783j.m19727d("Received a push when push is disabled! Ignoring.");
        } else if (m20126a(pushMessage.m20044c())) {
            this.f13795b.m20302a(pushMessage.m20048g());
            this.f13796c.m20394r().m19455a(new C3752p(pushMessage));
            if (pushMessage.m20042a()) {
                C3783j.m19725c("Received expired push message, ignoring.");
            } else if (pushMessage.m20043b()) {
                C3783j.m19723b("IncomingPushServiceDelegate - Received UA Ping");
            } else {
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.urbanairship.PUSH_MESSAGE", pushMessage);
                ActionService.m19305a(C3929q.m20382h(), pushMessage.m20050i(), 1, bundle);
                InAppMessage u = pushMessage.m20062u();
                if (u != null) {
                    C3783j.m19725c("IncomingPushServiceDelegate - Received a Push with an in-app message.");
                    this.f13796c.m20393q().m20260a(u);
                }
                if (!C3954i.m20512a(pushMessage.m20045d())) {
                    C3783j.m19725c("IncomingPushServiceDelegate - Received a Rich Push.");
                    m20127c();
                }
                Integer num = null;
                if (this.f13795b.m20310c()) {
                    num = m20123a(pushMessage, this.f13795b.m20311d());
                } else {
                    C3783j.m19727d("User notifications disabled. Unable to display notification for message: " + pushMessage);
                }
                m20125a(pushMessage, num);
            }
        } else {
            C3783j.m19727d("Received a duplicate push with canonical ID: " + pushMessage.m20044c());
        }
    }

    private Integer m20123a(PushMessage pushMessage, C1711e c1711e) {
        if (c1711e == null) {
            C3783j.m19727d("NotificationFactory is null. Unable to display notification for message: " + pushMessage);
            return null;
        }
        try {
            int a = c1711e.mo1052a(pushMessage);
            Notification a2 = c1711e.mo1053a(pushMessage, a);
            if (a2 == null) {
                return null;
            }
            if (!this.f13795b.m20323o() || this.f13795b.m20325q()) {
                a2.vibrate = null;
                a2.defaults &= -3;
            }
            if (!this.f13795b.m20322n() || this.f13795b.m20325q()) {
                a2.sound = null;
                a2.defaults &= -2;
            }
            Intent putExtra = new Intent(m19269a(), CoreReceiver.class).setAction("com.urbanairship.ACTION_NOTIFICATION_OPENED_PROXY").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", pushMessage.m20049h()).putExtra("com.urbanairship.push.NOTIFICATION_ID", a);
            if (a2.contentIntent != null) {
                putExtra.putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT", a2.contentIntent);
            }
            Intent putExtra2 = new Intent(m19269a(), CoreReceiver.class).setAction("com.urbanairship.ACTION_NOTIFICATION_DISMISSED_PROXY").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", pushMessage.m20049h()).putExtra("com.urbanairship.push.NOTIFICATION_ID", a);
            if (a2.deleteIntent != null) {
                putExtra2.putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT", a2.deleteIntent);
            }
            a2.contentIntent = PendingIntent.getBroadcast(m19269a(), 0, putExtra, 0);
            a2.deleteIntent = PendingIntent.getBroadcast(m19269a(), 0, putExtra2, 0);
            C3783j.m19727d("Posting notification " + a2 + " with ID " + a);
            this.f13794a.m742a(a, a2);
            return Integer.valueOf(a);
        } catch (Throwable e) {
            C3783j.m19726c("Unable to create and display notification.", e);
            return null;
        }
    }

    private void m20125a(PushMessage pushMessage, Integer num) {
        Intent intent = new Intent("com.urbanairship.push.RECEIVED").putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", pushMessage.m20049h()).addCategory(C3929q.m20374b()).setPackage(C3929q.m20374b());
        if (num != null) {
            intent.putExtra("com.urbanairship.push.NOTIFICATION_ID", num.intValue());
        }
        m19269a().sendBroadcast(intent, C3929q.m20376c());
    }

    private void m20127c() {
        final Semaphore semaphore = new Semaphore(0);
        this.f13796c.m20391o().m20431a(new C3837a(this) {
            final /* synthetic */ C3882f f13793b;

            public void mo2805a(boolean z) {
                semaphore.release();
            }
        }, Looper.getMainLooper());
        try {
            semaphore.tryAcquire(60000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            C3783j.m19721a("Interrupted while waiting for rich push messages to refresh");
        }
    }

    private boolean m20126a(String str) {
        if (C3954i.m20512a(str)) {
            return true;
        }
        C3785a c;
        try {
            c = JsonValue.m19740b(m19272b().m19810a("com.urbanairship.push.LAST_CANONICAL_IDS", null)).m19752c();
        } catch (Throwable e) {
            C3783j.m19724b("IncomingPushServiceDelegate - Unable to parse canonical Ids.", e);
            c = null;
        }
        Object arrayList = c == null ? new ArrayList() : c.m19768b();
        JsonValue c2 = JsonValue.m19743c(str);
        if (arrayList.contains(c2)) {
            return false;
        }
        arrayList.add(c2);
        if (arrayList.size() > 10) {
            arrayList = arrayList.subList(arrayList.size() - 10, arrayList.size());
        }
        m19272b().m19819b("com.urbanairship.push.LAST_CANONICAL_IDS", JsonValue.m19732a(arrayList).toString());
        return true;
    }
}
