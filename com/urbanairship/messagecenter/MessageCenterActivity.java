package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.MenuItem;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;

@TargetApi(14)
public class MessageCenterActivity extends ThemedActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1187d.m6033a(getApplication());
        if (C3929q.m20384j() || C3929q.m20383i()) {
            MessageCenterFragment a;
            m19923a(true);
            String str = null;
            if (!(getIntent() == null || getIntent().getData() == null || !"com.urbanairship.VIEW_RICH_PUSH_MESSAGE".equals(getIntent().getAction()))) {
                str = getIntent().getData().getSchemeSpecificPart();
            }
            if (bundle == null) {
                a = MessageCenterFragment.m19926a(str);
                getSupportFragmentManager().mo150a().mo140a(16908290, a, "MESSAGE_CENTER_FRAGMENT").mo138a();
            } else {
                a = (MessageCenterFragment) getSupportFragmentManager().mo149a("MESSAGE_CENTER_FRAGMENT");
            }
            a.m19932a(C3929q.m20372a().m20398v().m20009b());
            return;
        }
        C3783j.m19728e("MessageCenterActivity - unable to create activity, takeOff not called.");
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return false;
        }
    }
}
