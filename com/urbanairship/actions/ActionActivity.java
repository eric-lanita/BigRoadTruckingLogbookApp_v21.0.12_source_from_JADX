package com.urbanairship.actions;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.analytics.C3735b;

public class ActionActivity extends Activity {
    private static int f13305b = 0;
    private ResultReceiver f13306a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1187d.m6033a(getApplication());
        if (C3929q.m20384j() || C3929q.m20383i()) {
            Intent intent = getIntent();
            if (intent == null) {
                C3783j.m19721a("ActionActivity - Started with null intent");
                finish();
                return;
            } else if (bundle == null) {
                Intent intent2 = (Intent) intent.getParcelableExtra("com.urbanairship.actions.START_ACTIVITY_INTENT_EXTRA");
                String[] stringArrayExtra = intent.getStringArrayExtra("com.urbanairship.actions.actionactivity.PERMISSIONS_EXTRA");
                if (intent2 != null) {
                    this.f13306a = (ResultReceiver) intent.getParcelableExtra("com.urbanairship.actions.actionactivity.RESULT_RECEIVER_EXTRA");
                    int i = f13305b + 1;
                    f13305b = i;
                    startActivityForResult(intent2, i);
                    return;
                } else if (VERSION.SDK_INT < 23 || stringArrayExtra == null) {
                    C3783j.m19721a("ActionActivity - Started without START_ACTIVITY_INTENT_EXTRA or PERMISSIONS_EXTRA extra.");
                    finish();
                    return;
                } else {
                    this.f13306a = (ResultReceiver) intent.getParcelableExtra("com.urbanairship.actions.actionactivity.RESULT_RECEIVER_EXTRA");
                    int i2 = f13305b + 1;
                    f13305b = i2;
                    requestPermissions(stringArrayExtra, i2);
                    return;
                }
            } else {
                return;
            }
        }
        C3783j.m19728e("ActionActivity - unable to create activity, takeOff not called.");
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f13306a != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.urbanairship.actions.actionactivity.RESULT_INTENT_EXTRA", intent);
            this.f13306a.send(i2, bundle);
        }
        super.onActivityResult(i, i2, intent);
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.f13306a != null) {
            Bundle bundle = new Bundle();
            bundle.putIntArray("com.urbanairship.actions.actionactivity.RESULT_INTENT_EXTRA", iArr);
            this.f13306a.send(-1, bundle);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
        finish();
    }

    protected void onStart() {
        super.onStart();
        C3735b.m19444a((Activity) this);
    }

    protected void onStop() {
        super.onStop();
        C3735b.m19448b((Activity) this);
    }
}
