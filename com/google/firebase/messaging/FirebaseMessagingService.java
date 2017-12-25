package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import com.google.firebase.iid.zzb;
import java.util.Iterator;

public class FirebaseMessagingService extends zzb {
    static void m6224a(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    static boolean m6225b(Bundle bundle) {
        return bundle == null ? false : AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(bundle.getString("google.c.a.e"));
    }

    private void m6226d(Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException e) {
                Log.e("FirebaseMessaging", "Notification pending intent canceled");
            }
        }
        if (m6225b(intent.getExtras())) {
            C3627b.m18976b(this, intent);
        }
    }

    private void m6227e(Intent intent) {
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
        }
        Object obj = -1;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                    obj = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                    obj = null;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                    obj = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                if (m6225b(intent.getExtras())) {
                    C3627b.m18974a(this, intent);
                }
                m6228f(intent);
                return;
            case 1:
                m6231a();
                return;
            case 2:
                m6233a(intent.getStringExtra("google.message_id"));
                return;
            case 3:
                m6234a(m6229g(intent), new SendException(intent.getStringExtra("error")));
                return;
            default:
                String str = "FirebaseMessaging";
                String str2 = "Received message with unknown type: ";
                stringExtra = String.valueOf(stringExtra);
                Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                return;
        }
    }

    private void m6228f(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("android.support.content.wakelockid");
        if (C3626a.m18961a(extras)) {
            if (!C3626a.m18964b((Context) this)) {
                C3626a.m18956a((Context) this).m18972b(extras);
                return;
            } else if (m6225b(extras)) {
                C3627b.m18978d(this, intent);
            }
        }
        mo902a(new RemoteMessage(extras));
    }

    private String m6229g(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    protected int mo898a(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return super.mo898a(intent);
        }
        m6226d(intent);
        m6200b();
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
        return 3;
    }

    public void m6231a() {
    }

    public void mo902a(RemoteMessage remoteMessage) {
    }

    public void m6233a(String str) {
    }

    public void m6234a(String str, Exception exception) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo899b(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = r5.getAction();	 Catch:{ all -> 0x0047 }
        r0 = -1;
        r2 = r1.hashCode();	 Catch:{ all -> 0x0047 }
        switch(r2) {
            case 75300319: goto L_0x0039;
            case 366519424: goto L_0x002f;
            default: goto L_0x000c;
        };	 Catch:{ all -> 0x0047 }
    L_0x000c:
        switch(r0) {
            case 0: goto L_0x0043;
            case 1: goto L_0x004c;
            default: goto L_0x000f;
        };	 Catch:{ all -> 0x0047 }
    L_0x000f:
        r1 = "FirebaseMessaging";
        r2 = "Unknown intent action: ";
        r0 = r5.getAction();	 Catch:{ all -> 0x0047 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x0047 }
        r3 = r0.length();	 Catch:{ all -> 0x0047 }
        if (r3 == 0) goto L_0x005a;
    L_0x0021:
        r0 = r2.concat(r0);	 Catch:{ all -> 0x0047 }
    L_0x0025:
        android.util.Log.d(r1, r0);	 Catch:{ all -> 0x0047 }
    L_0x0028:
        r4.m6200b();	 Catch:{ all -> 0x0047 }
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r5);
        return;
    L_0x002f:
        r2 = "com.google.android.c2dm.intent.RECEIVE";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x000c;
    L_0x0037:
        r0 = 0;
        goto L_0x000c;
    L_0x0039:
        r2 = "com.google.firebase.messaging.NOTIFICATION_DISMISS";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x000c;
    L_0x0041:
        r0 = 1;
        goto L_0x000c;
    L_0x0043:
        r4.m6227e(r5);	 Catch:{ all -> 0x0047 }
        goto L_0x0028;
    L_0x0047:
        r0 = move-exception;
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r5);
        throw r0;
    L_0x004c:
        r0 = r5.getExtras();	 Catch:{ all -> 0x0047 }
        r0 = m6225b(r0);	 Catch:{ all -> 0x0047 }
        if (r0 == 0) goto L_0x0028;
    L_0x0056:
        com.google.firebase.messaging.C3627b.m18977c(r4, r5);	 Catch:{ all -> 0x0047 }
        goto L_0x0028;
    L_0x005a:
        r0 = new java.lang.String;	 Catch:{ all -> 0x0047 }
        r0.<init>(r2);	 Catch:{ all -> 0x0047 }
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessagingService.b(android.content.Intent):void");
    }

    protected Intent mo900c(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.m18898b();
    }
}
