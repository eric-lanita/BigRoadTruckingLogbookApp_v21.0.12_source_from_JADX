package com.urbanairship.push;

import android.support.v4.content.WakefulBroadcastReceiver;

public class AdmPushReceiver extends WakefulBroadcastReceiver {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
        r3 = this;
        r1 = -1;
        com.urbanairship.C1187d.m6035c(r4);
        if (r5 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r5.getAction();
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "AdmPushReceiver - Received intent: ";
        r0 = r0.append(r2);
        r2 = r5.getAction();
        r0 = r0.append(r2);
        r0 = r0.toString();
        com.urbanairship.C3783j.m19723b(r0);
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 15;
        if (r0 >= r2) goto L_0x0033;
    L_0x002d:
        r0 = "AdmPushReceiver - Received intent from ADM transport on an unsupported API version.";
        com.urbanairship.C3783j.m19728e(r0);
        goto L_0x000c;
    L_0x0033:
        r0 = r5.getAction();
        r2 = r0.hashCode();
        switch(r2) {
            case -743092218: goto L_0x0056;
            case 1060266838: goto L_0x004c;
            default: goto L_0x003e;
        };
    L_0x003e:
        r0 = r1;
    L_0x003f:
        switch(r0) {
            case 0: goto L_0x0060;
            case 1: goto L_0x0077;
            default: goto L_0x0042;
        };
    L_0x0042:
        r0 = r3.isOrderedBroadcast();
        if (r0 == 0) goto L_0x000c;
    L_0x0048:
        r3.setResultCode(r1);
        goto L_0x000c;
    L_0x004c:
        r2 = "com.amazon.device.messaging.intent.RECEIVE";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x003e;
    L_0x0054:
        r0 = 0;
        goto L_0x003f;
    L_0x0056:
        r2 = "com.amazon.device.messaging.intent.REGISTRATION";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x003e;
    L_0x005e:
        r0 = 1;
        goto L_0x003f;
    L_0x0060:
        r0 = new android.content.Intent;
        r2 = com.urbanairship.push.PushService.class;
        r0.<init>(r4, r2);
        r2 = "com.urbanairship.push.ACTION_RECEIVE_ADM_MESSAGE";
        r0 = r0.setAction(r2);
        r2 = "com.urbanairship.push.EXTRA_INTENT";
        r0 = r0.putExtra(r2, r5);
        android.support.v4.content.WakefulBroadcastReceiver.startWakefulService(r4, r0);
        goto L_0x0042;
    L_0x0077:
        r0 = new android.content.Intent;
        r2 = com.urbanairship.push.PushService.class;
        r0.<init>(r4, r2);
        r2 = "com.urbanairship.push.ACTION_ADM_REGISTRATION_FINISHED";
        r0 = r0.setAction(r2);
        r2 = "com.urbanairship.push.EXTRA_INTENT";
        r0 = r0.putExtra(r2, r5);
        android.support.v4.content.WakefulBroadcastReceiver.startWakefulService(r4, r0);
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.AdmPushReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
