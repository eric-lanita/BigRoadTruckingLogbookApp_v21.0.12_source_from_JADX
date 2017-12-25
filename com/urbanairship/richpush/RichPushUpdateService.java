package com.urbanairship.richpush;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.urbanairship.BaseIntentService;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import java.net.URL;

public class RichPushUpdateService extends BaseIntentService {
    public RichPushUpdateService() {
        super("RichPushUpdateService");
    }

    protected C3676a mo2818a(String str, C3796l c3796l) {
        C3783j.m19723b("RichPushUpdateService - Service delegate for intent: " + str);
        Object obj = -1;
        switch (str.hashCode()) {
            case -1229158830:
                if (str.equals("com.urbanairship.richpush.USER_UPDATE")) {
                    obj = null;
                    break;
                }
                break;
            case 1699160881:
                if (str.equals("com.urbanairship.richpush.MESSAGES_UPDATE")) {
                    obj = 2;
                    break;
                }
                break;
            case 2078637888:
                if (str.equals("com.urbanairship.richpush.SYNC_MESSAGE_STATE")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return new C3945f(getApplicationContext(), c3796l);
            case 1:
            case 2:
                return new C3931a(getApplicationContext(), c3796l);
            default:
                return null;
        }
    }

    static void m20409a(Intent intent, boolean z) {
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("com.urbanairship.richpush.RESULT_RECEIVER");
        if (resultReceiver == null) {
            return;
        }
        if (z) {
            resultReceiver.send(0, new Bundle());
        } else {
            resultReceiver.send(1, new Bundle());
        }
    }

    static URL m20408a(String str, Object... objArr) {
        try {
            return new URL(String.format(C3929q.m20372a().m20388l().f13505e + str, objArr));
        } catch (Throwable e) {
            C3783j.m19726c("Invalid userURL", e);
            return null;
        }
    }
}
