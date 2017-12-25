package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.MenuItem;
import com.urbanairship.C1187d;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.richpush.C3942c;

@TargetApi(14)
public class MessageActivity extends ThemedActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1187d.m6033a(getApplication());
        if (C3929q.m20384j() || C3929q.m20383i()) {
            String str;
            m19923a(true);
            if (getIntent() == null || getIntent().getData() == null || !"com.urbanairship.VIEW_RICH_PUSH_MESSAGE".equals(getIntent().getAction())) {
                str = null;
            } else {
                str = getIntent().getData().getSchemeSpecificPart();
            }
            C3942c b = C3929q.m20372a().m20391o().m20438b(str);
            if (b == null) {
                finish();
                return;
            }
            if (((MessageFragment) getSupportFragmentManager().mo149a("MessageFragment")) == null) {
                getSupportFragmentManager().mo150a().mo140a(16908290, MessageFragment.m19934a(str), "MessageFragment").mo138a();
            }
            setTitle(b.m20448c());
            return;
        }
        C3783j.m19728e("MessageActivity - unable to create activity, takeOff not called.");
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
