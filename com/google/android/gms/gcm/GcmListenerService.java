package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.util.Iterator;

public abstract class GcmListenerService extends Service {
    private final Object f10972a = new Object();
    private int f10973b;
    private int f10974c = 0;

    private void m17039a() {
        synchronized (this.f10972a) {
            this.f10974c--;
            if (this.f10974c == 0) {
                m17047a(this.f10973b);
            }
        }
    }

    @TargetApi(11)
    private void m17040a(final Intent intent) {
        if (VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(this) {
                final /* synthetic */ GcmListenerService f10969b;

                public void run() {
                    this.f10969b.m17043b(intent);
                }
            });
        } else {
            new AsyncTask<Void, Void, Void>(this) {
                final /* synthetic */ GcmListenerService f10971b;

                protected Void m17038a(Void... voidArr) {
                    this.f10971b.m17043b(intent);
                    return null;
                }

                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m17038a((Void[]) objArr);
                }
            }.execute(new Void[0]);
        }
    }

    static void m17041a(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith("google.c.")) {
                it.remove();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m17043b(android.content.Intent r5) {
        /*
        r4 = this;
        r1 = r5.getAction();	 Catch:{ all -> 0x003d }
        r0 = -1;
        r2 = r1.hashCode();	 Catch:{ all -> 0x003d }
        switch(r2) {
            case 366519424: goto L_0x002f;
            default: goto L_0x000c;
        };	 Catch:{ all -> 0x003d }
    L_0x000c:
        switch(r0) {
            case 0: goto L_0x0039;
            default: goto L_0x000f;
        };	 Catch:{ all -> 0x003d }
    L_0x000f:
        r1 = "GcmListenerService";
        r2 = "Unknown intent action: ";
        r0 = r5.getAction();	 Catch:{ all -> 0x003d }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x003d }
        r3 = r0.length();	 Catch:{ all -> 0x003d }
        if (r3 == 0) goto L_0x0042;
    L_0x0021:
        r0 = r2.concat(r0);	 Catch:{ all -> 0x003d }
    L_0x0025:
        android.util.Log.d(r1, r0);	 Catch:{ all -> 0x003d }
    L_0x0028:
        r4.m17039a();	 Catch:{ all -> 0x003d }
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r5);
        return;
    L_0x002f:
        r2 = "com.google.android.c2dm.intent.RECEIVE";
        r1 = r1.equals(r2);	 Catch:{ all -> 0x003d }
        if (r1 == 0) goto L_0x000c;
    L_0x0037:
        r0 = 0;
        goto L_0x000c;
    L_0x0039:
        r4.m17044c(r5);	 Catch:{ all -> 0x003d }
        goto L_0x0028;
    L_0x003d:
        r0 = move-exception;
        android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent(r5);
        throw r0;
    L_0x0042:
        r0 = new java.lang.String;	 Catch:{ all -> 0x003d }
        r0.<init>(r2);	 Catch:{ all -> 0x003d }
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmListenerService.b(android.content.Intent):void");
    }

    private void m17044c(Intent intent) {
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
                m17045d(intent);
                return;
            case 1:
                onDeletedMessages();
                return;
            case 2:
                onMessageSent(intent.getStringExtra("google.message_id"));
                return;
            case 3:
                onSendError(m17046e(intent), intent.getStringExtra("error"));
                return;
            default:
                String str = "GcmListenerService";
                String str2 = "Received message with unknown type: ";
                stringExtra = String.valueOf(stringExtra);
                Log.w(str, stringExtra.length() != 0 ? str2.concat(stringExtra) : new String(str2));
                return;
        }
    }

    private void m17045d(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.remove("message_type");
        extras.remove("android.support.content.wakelockid");
        if (zza.m17083a(extras)) {
            if (zza.m17087b((Context) this)) {
                zza.m17086b(extras);
            } else {
                zza.m17079a((Context) this).m17091c(extras);
                return;
            }
        }
        String string = extras.getString("from");
        extras.remove("from");
        m17041a(extras);
        onMessageReceived(string, extras);
    }

    private String m17046e(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    boolean m17047a(int i) {
        return stopSelfResult(i);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.f10972a) {
            this.f10973b = i2;
            this.f10974c++;
        }
        if (intent == null) {
            m17039a();
            return 2;
        }
        m17040a(intent);
        return 3;
    }
}
