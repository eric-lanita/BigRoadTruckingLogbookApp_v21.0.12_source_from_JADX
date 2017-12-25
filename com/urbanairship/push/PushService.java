package com.urbanairship.push;

import com.urbanairship.BaseIntentService;
import com.urbanairship.BaseIntentService.C3676a;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;

public class PushService extends BaseIntentService {
    public PushService() {
        super("PushService");
    }

    protected C3676a mo2818a(String str, C3796l c3796l) {
        C3783j.m19723b("PushService - Service delegate for intent: " + str);
        Object obj = -1;
        switch (str.hashCode()) {
            case -1411187451:
                if (str.equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER")) {
                    obj = 3;
                    break;
                }
                break;
            case -1138418629:
                if (str.equals("com.urbanairship.push.ACTION_RECEIVE_GCM_MESSAGE")) {
                    obj = 9;
                    break;
                }
                break;
            case -1003583816:
                if (str.equals("com.urbanairship.push.ACTION_START_REGISTRATION")) {
                    obj = 5;
                    break;
                }
                break;
            case -901120150:
                if (str.equals("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION")) {
                    obj = 7;
                    break;
                }
                break;
            case -832939733:
                if (str.equals("com.urbanairship.push.ACTION_CLEAR_PENDING_NAMED_USER_TAGS")) {
                    obj = 2;
                    break;
                }
                break;
            case 720921569:
                if (str.equals("com.urbanairship.push.ACTION_ADM_REGISTRATION_FINISHED")) {
                    obj = 4;
                    break;
                }
                break;
            case 856841428:
                if (str.equals("com.urbanairship.push.ACTION_RECEIVE_ADM_MESSAGE")) {
                    obj = 8;
                    break;
                }
                break;
            case 962413331:
                if (str.equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS")) {
                    obj = null;
                    break;
                }
                break;
            case 1048059625:
                if (str.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS")) {
                    obj = 1;
                    break;
                }
                break;
            case 1402665321:
                if (str.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION")) {
                    obj = 6;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                return new C3923l(getApplicationContext(), c3796l);
            case 3:
                return new C3885i(getApplicationContext(), c3796l);
            case 4:
            case 5:
            case 6:
            case 7:
                return new C3879d(getApplicationContext(), c3796l);
            case 8:
            case 9:
                return new C3882f(getApplicationContext(), c3796l);
            default:
                return null;
        }
    }
}
