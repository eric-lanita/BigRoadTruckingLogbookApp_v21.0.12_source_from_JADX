package com.urbanairship;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.am;
import android.support.v4.app.ao;
import com.urbanairship.actions.ActionService;
import com.urbanairship.analytics.C3750n;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.iam.C3909c;
import com.urbanairship.push.iam.C3910d;
import com.urbanairship.push.iam.InAppMessage;
import com.urbanairship.util.C3954i;

public class CoreReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C1187d.m6035c(context);
        if (!C3929q.m20384j() && !C3929q.m20383i()) {
            C3783j.m19728e("CoreReceiver - unable to receive intent, takeOff not called.");
        } else if (intent != null && intent.getAction() != null) {
            C3783j.m19723b("CoreReceiver - Received intent: " + intent.getAction());
            String action = intent.getAction();
            Object obj = -1;
            switch (action.hashCode()) {
                case -1604106496:
                    if (action.equals("com.urbanairship.ACTION_NOTIFICATION_DISMISSED_PROXY")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -618294128:
                    if (action.equals("com.urbanairship.push.OPENED")) {
                        obj = 3;
                        break;
                    }
                    break;
                case -94640370:
                    if (action.equals("com.urbanairship.ACTION_CHANNEL_CAPTURE")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 168853520:
                    if (action.equals("com.urbanairship.ACTION_NOTIFICATION_OPENED_PROXY")) {
                        obj = null;
                        break;
                    }
                    break;
                case 1702142669:
                    if (action.equals("com.urbanairship.ACTION_NOTIFICATION_BUTTON_OPENED_PROXY")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    m19279b(context, intent);
                    return;
                case 1:
                    m19280c(context, intent);
                    return;
                case 2:
                    m19281d(context, intent);
                    return;
                case 3:
                    m19282e(context, intent);
                    return;
                case 4:
                    m19276a(context, intent);
                    return;
                default:
                    return;
            }
        }
    }

    private void m19276a(Context context, Intent intent) {
        if (intent.hasExtra("com.urbanairship.EXTRA_NOTIFICATION_ID")) {
            am.m737a(context).m741a(intent.getIntExtra("com.urbanairship.EXTRA_NOTIFICATION_ID", -1));
        }
        String stringExtra = intent.getStringExtra("com.urbanairship.EXTRA_ACTIONS");
        if (!C3954i.m20512a(stringExtra)) {
            C3783j.m19725c("Running actions for notification action: " + stringExtra);
            ActionService.m19304a(context, stringExtra, 0, null);
        }
    }

    private void m19279b(Context context, Intent intent) {
        PushMessage a = PushMessage.m20040a(intent);
        if (a == null) {
            C3783j.m19728e("CoreReceiver - Intent is missing push message for: " + intent.getAction());
            return;
        }
        C3783j.m19727d("Notification opened ID: " + intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1));
        C3929q.m20372a().m20394r().m19456a(a.m20047f());
        C3929q.m20372a().m20394r().m19457b(a.m20048g());
        m19277a(a.m20047f());
        context.sendOrderedBroadcast(new Intent("com.urbanairship.push.OPENED").putExtras(intent.getExtras()).setPackage(C3929q.m20374b()).addCategory(C3929q.m20374b()), C3929q.m20376c());
    }

    private void m19280c(Context context, Intent intent) {
        PushMessage a = PushMessage.m20040a(intent);
        if (a == null) {
            C3783j.m19728e("CoreReceiver - Intent is missing push message for: " + intent.getAction());
            return;
        }
        Bundle a2 = ao.m761a(intent);
        String stringExtra = intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID");
        if (stringExtra == null) {
            C3783j.m19728e("CoreReceiver - Intent is missing notification button ID: " + intent.getAction());
            return;
        }
        int intExtra = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
        boolean booleanExtra = intent.getBooleanExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND", true);
        String stringExtra2 = intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION");
        C3783j.m19727d("Notification opened ID: " + intExtra + " action button Id: " + stringExtra);
        if (booleanExtra) {
            C3929q.m20372a().m20394r().m19456a(a.m20047f());
            C3929q.m20372a().m20394r().m19457b(a.m20048g());
        }
        m19277a(a.m20047f());
        am.m737a(context).m741a(intExtra);
        C3929q.m20372a().m20394r().m19455a(new C3750n(a, stringExtra, stringExtra2, booleanExtra, a2));
        Intent addCategory = new Intent("com.urbanairship.push.OPENED").putExtras(intent.getExtras()).setPackage(C3929q.m20374b()).addCategory(C3929q.m20374b());
        if (!(a2 == null || a2.size() == 0)) {
            addCategory.putExtra("com.urbanairship.push.EXTRA_REMOTE_INPUT", a2);
        }
        context.sendOrderedBroadcast(addCategory, C3929q.m20376c());
    }

    private void m19281d(Context context, Intent intent) {
        if (PushMessage.m20040a(intent) == null) {
            C3783j.m19728e("CoreReceiver - Intent is missing push message for: " + intent.getAction());
            return;
        }
        C3783j.m19727d("Notification dismissed ID: " + intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1));
        PendingIntent pendingIntent = (PendingIntent) intent.getExtras().get("com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (CanceledException e) {
                C3783j.m19725c("Failed to send notification's deleteIntent, already canceled.");
            }
        }
        context.sendOrderedBroadcast(new Intent("com.urbanairship.push.DISMISSED").putExtras(intent.getExtras()).setPackage(C3929q.m20374b()).addCategory(C3929q.m20374b()), C3929q.m20376c());
    }

    private void m19282e(Context context, Intent intent) {
        C3761b l = C3929q.m20372a().m20388l();
        Object a = PushMessage.m20040a(intent);
        if (a == null) {
            C3783j.m19728e("CoreReceiver - Intent is missing push message for: " + intent.getAction());
        } else if (intent.hasExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID")) {
            boolean booleanExtra = intent.getBooleanExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND", false);
            String stringExtra = intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD");
            if (booleanExtra && getResultCode() != 1 && l.f13517q && m19278a(context) && isOrderedBroadcast()) {
                setResultCode(1);
            }
            if (!C3954i.m20512a(stringExtra)) {
                C3783j.m19725c("Running actions for notification action: " + stringExtra);
                int i = booleanExtra ? 4 : 5;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.urbanairship.PUSH_MESSAGE", a);
                if (intent.hasExtra("com.urbanairship.push.EXTRA_REMOTE_INPUT")) {
                    bundle.putBundle("com.urbanairship.REMOTE_INPUT", intent.getBundleExtra("com.urbanairship.push.EXTRA_REMOTE_INPUT"));
                }
                ActionService.m19304a(context, stringExtra, i, bundle);
            }
        } else {
            if (getResultCode() != 1) {
                PendingIntent pendingIntent = (PendingIntent) intent.getExtras().get("com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT");
                if (pendingIntent != null) {
                    try {
                        pendingIntent.send();
                        if (isOrderedBroadcast()) {
                            setResultCode(1);
                        }
                    } catch (CanceledException e) {
                        C3783j.m19725c("Failed to send notification's contentIntent, already canceled.");
                    }
                } else if (l.f13517q && m19278a(context) && isOrderedBroadcast()) {
                    setResultCode(1);
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("com.urbanairship.PUSH_MESSAGE", a);
            ActionService.m19305a(context, a.m20050i(), 2, bundle2);
        }
    }

    private boolean m19278a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(C3929q.m20374b());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(805306368);
            C3783j.m19727d("Starting application's launch intent.");
            context.startActivity(launchIntentForPackage);
            return true;
        }
        C3783j.m19727d("Unable to launch application. Launch intent is unavailable.");
        return false;
    }

    private static void m19277a(String str) {
        if (!C3954i.m20512a(str)) {
            C3909c q = C3929q.m20372a().m20393q();
            InAppMessage d = q.m20270d();
            InAppMessage e = q.m20271e();
            if (d != null && str.equals(d.m20187c()) && !d.equals(e)) {
                C3783j.m19727d("Clearing pending in-app message due to directly interacting with the message's push notification.");
                q.m20260a(null);
                C3929q.m20372a().m20394r().m19455a(C3910d.m20275a(d));
            }
        }
    }
}
