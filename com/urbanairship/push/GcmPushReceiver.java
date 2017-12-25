package com.urbanairship.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import com.urbanairship.C3783j;

public class GcmPushReceiver extends WakefulBroadcastReceiver {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
        r4 = this;
        r0 = 0;
        r1 = -1;
        com.urbanairship.C1187d.m6035c(r5);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "GcmPushReceiver - Received intent: ";
        r2 = r2.append(r3);
        r3 = r6.getAction();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.urbanairship.C3783j.m19723b(r2);
        r4.m20037b(r5, r6);
        r2 = r6.getAction();
        if (r2 != 0) goto L_0x0032;
    L_0x0028:
        r1 = r4.isOrderedBroadcast();
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r4.setResultCode(r0);
    L_0x0031:
        return;
    L_0x0032:
        r2 = r6.getAction();
        r3 = r2.hashCode();
        switch(r3) {
            case 366519424: goto L_0x0062;
            case 1111963330: goto L_0x006b;
            case 1736128796: goto L_0x0075;
            default: goto L_0x003d;
        };
    L_0x003d:
        r0 = r1;
    L_0x003e:
        switch(r0) {
            case 0: goto L_0x0042;
            case 1: goto L_0x007f;
            case 2: goto L_0x0083;
            default: goto L_0x0041;
        };
    L_0x0041:
        goto L_0x0031;
    L_0x0042:
        r0 = new android.content.Intent;
        r2 = com.urbanairship.push.PushService.class;
        r0.<init>(r5, r2);
        r2 = "com.urbanairship.push.ACTION_RECEIVE_GCM_MESSAGE";
        r0 = r0.setAction(r2);
        r2 = "com.urbanairship.push.EXTRA_INTENT";
        r0 = r0.putExtra(r2, r6);
        android.support.v4.content.WakefulBroadcastReceiver.startWakefulService(r5, r0);
        r0 = r4.isOrderedBroadcast();
        if (r0 == 0) goto L_0x0031;
    L_0x005e:
        r4.setResultCode(r1);
        goto L_0x0031;
    L_0x0062:
        r3 = "com.google.android.c2dm.intent.RECEIVE";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003d;
    L_0x006a:
        goto L_0x003e;
    L_0x006b:
        r0 = "com.google.android.gms.iid.InstanceID";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x003d;
    L_0x0073:
        r0 = 1;
        goto L_0x003e;
    L_0x0075:
        r0 = "com.google.android.c2dm.intent.REGISTRATION";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x003d;
    L_0x007d:
        r0 = 2;
        goto L_0x003e;
    L_0x007f:
        r4.m20036a(r5, r6);
        goto L_0x0031;
    L_0x0083:
        r0 = new android.content.Intent;
        r1 = com.urbanairship.push.PushService.class;
        r0.<init>(r5, r1);
        r1 = "com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION";
        r0 = r0.setAction(r1);
        android.support.v4.content.WakefulBroadcastReceiver.startWakefulService(r5, r0);
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.GcmPushReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    private void m20036a(Context context, Intent intent) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (!(resolveService == null || resolveService.serviceInfo == null)) {
            ServiceInfo serviceInfo = resolveService.serviceInfo;
            if (!context.getPackageName().equals(serviceInfo.packageName) || serviceInfo.name == null) {
                C3783j.m19728e("GcmPushReceiver - Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
            } else {
                String str = serviceInfo.name;
                if (str.startsWith(".")) {
                    str = context.getPackageName() + str;
                }
                C3783j.m19725c("GcmPushReceiver - Forwarding GCM intent to " + str);
                intent.setClassName(context.getPackageName(), str);
            }
        }
        try {
            ComponentName startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            if (isOrderedBroadcast()) {
                setResultCode(startWakefulService == null ? 404 : -1);
            }
        } catch (Throwable e) {
            C3783j.m19726c("GcmPushReceiver - Error while delivering the message to the serviceIntent", e);
            if (isOrderedBroadcast()) {
                setResultCode(401);
            }
        }
    }

    private void m20037b(Context context, Intent intent) {
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT < 19) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        stringExtra = intent.getStringExtra("from");
        if ("google.com/iid".equals(stringExtra) || "gcm.googleapis.com/refresh".equals(stringExtra)) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
    }
}
