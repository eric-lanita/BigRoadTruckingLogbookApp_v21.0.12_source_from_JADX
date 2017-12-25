package com.urbanairship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.urbanairship.push.PushMessage;

public class AirshipReceiver extends BroadcastReceiver {

    protected static class C3674a {
        private final String f13287a;
        private final boolean f13288b;
        private final Bundle f13289c;

        private C3674a(String str, boolean z, Bundle bundle) {
            this.f13287a = str;
            this.f13288b = z;
            this.f13289c = bundle;
        }
    }

    protected static class C3675b {
        private final PushMessage f13290a;
        private final int f13291b;

        private C3675b(PushMessage pushMessage, int i) {
            this.f13290a = pushMessage;
            this.f13291b = i;
        }
    }

    public void onReceive(Context context, Intent intent) {
        C1187d.m6035c(context);
        if (intent != null && intent.getAction() != null) {
            String action = intent.getAction();
            C3783j.m19725c(getClass().getSimpleName() + " - Received intent with action: " + action);
            Object obj = -1;
            switch (action.hashCode()) {
                case -1779743672:
                    if (action.equals("com.urbanairship.push.RECEIVED")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1678512904:
                    if (action.equals("com.urbanairship.push.CHANNEL_UPDATED")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -618294128:
                    if (action.equals("com.urbanairship.push.OPENED")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 122500866:
                    if (action.equals("com.urbanairship.push.DISMISSED")) {
                        obj = 3;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    m19256a(context, intent);
                    return;
                case 1:
                    m19257b(context, intent);
                    return;
                case 2:
                    m19258c(context, intent);
                    return;
                case 3:
                    m19259d(context, intent);
                    return;
                default:
                    return;
            }
        }
    }

    private void m19256a(Context context, Intent intent) {
        PushMessage a = PushMessage.m20040a(intent);
        if (a == null) {
            C3783j.m19728e("AirshipReceiver - Intent is missing push message for: " + intent.getAction());
            return;
        }
        boolean hasExtra = intent.hasExtra("com.urbanairship.push.NOTIFICATION_ID");
        m19262a(context, a, hasExtra);
        if (hasExtra) {
            m19261a(context, new C3675b(a, intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1)));
        }
    }

    private void m19257b(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
        PushMessage a = PushMessage.m20040a(intent);
        if (a == null) {
            C3783j.m19728e("AirshipReceiver - Intent is missing push message for: " + intent.getAction());
            return;
        }
        boolean a2;
        C3675b c3675b = new C3675b(a, intExtra);
        if (intent.hasExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID")) {
            a2 = m19264a(context, c3675b, new C3674a(intent.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID"), intent.getBooleanExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND", false), intent.getBundleExtra("com.urbanairship.push.EXTRA_REMOTE_INPUT")));
        } else {
            a2 = m19266b(context, c3675b);
        }
        if (isOrderedBroadcast() && getResultCode() != 1) {
            setResultCode(a2 ? 1 : -1);
        }
    }

    private void m19258c(Context context, Intent intent) {
        if (intent.hasExtra("com.urbanairship.push.EXTRA_ERROR")) {
            m19260a(context);
            return;
        }
        String stringExtra = intent.getStringExtra("com.urbanairship.push.EXTRA_CHANNEL_ID");
        if (stringExtra == null) {
            C3783j.m19728e("AirshipReceiver - Intent is missing channel ID for: " + intent.getAction());
            return;
        }
        m19263a(context, stringExtra);
        if (intent.getBooleanExtra("com.urbanairship.push.EXTRA_CHANNEL_CREATE_REQUEST", true)) {
            m19268c(context, stringExtra);
        } else {
            m19265b(context, stringExtra);
        }
    }

    private void m19259d(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("com.urbanairship.push.NOTIFICATION_ID", -1);
        if (intent.hasExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE")) {
            PushMessage a = PushMessage.m20040a(intent);
            if (a == null) {
                C3783j.m19728e("AirshipReceiver - Intent is missing push message for: " + intent.getAction());
                return;
            } else {
                m19267c(context, new C3675b(a, intExtra));
                return;
            }
        }
        C3783j.m19728e("AirshipReceiver - Intent is missing push message for: " + intent.getAction());
    }

    @Deprecated
    protected void m19263a(Context context, String str) {
    }

    protected void m19265b(Context context, String str) {
    }

    protected void m19268c(Context context, String str) {
    }

    protected void m19260a(Context context) {
    }

    protected void m19262a(Context context, PushMessage pushMessage, boolean z) {
    }

    protected void m19261a(Context context, C3675b c3675b) {
    }

    protected boolean m19266b(Context context, C3675b c3675b) {
        return false;
    }

    protected boolean m19264a(Context context, C3675b c3675b, C3674a c3674a) {
        return false;
    }

    protected void m19267c(Context context, C3675b c3675b) {
    }
}
