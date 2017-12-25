package com.urbanairship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CoreActivity extends Activity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1187d.m6033a(getApplication());
        Intent intent = getIntent();
        if (intent != null) {
            C3783j.m19723b("CoreActivity - Received intent: " + intent.getAction());
            new CoreReceiver().onReceive(getApplicationContext(), intent);
        }
        finish();
    }
}
