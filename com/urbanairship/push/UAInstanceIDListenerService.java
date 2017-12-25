package com.urbanairship.push;

import com.google.android.gms.iid.InstanceIDListenerService;
import com.urbanairship.C3783j;

public class UAInstanceIDListenerService extends InstanceIDListenerService {
    public void onTokenRefresh() {
        super.onTokenRefresh();
        C3783j.m19727d("GCM token refreshed.");
    }
}
