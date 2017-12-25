package com.urbanairship.actions;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.C3942c;

public class C3717n extends C3690a {
    public boolean mo2769b(C3694b c3694b) {
        switch (c3694b.m19358b()) {
            case 0:
            case 2:
            case 3:
            case 4:
                if (c3694b.m19357a().m19314a() == null) {
                    return false;
                }
                if (!"auto".equalsIgnoreCase(c3694b.m19357a().m19314a())) {
                    return true;
                }
                if (c3694b.m19359c().containsKey("com.urbanairship.RICH_PUSH_ID_METADATA") || c3694b.m19359c().containsKey("com.urbanairship.PUSH_MESSAGE")) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public C3701e mo2770d(C3694b c3694b) {
        String d;
        final C3942c b;
        String a = c3694b.m19357a().m19314a();
        if (a.equalsIgnoreCase("auto")) {
            PushMessage pushMessage = (PushMessage) c3694b.m19359c().getParcelable("com.urbanairship.PUSH_MESSAGE");
            if (pushMessage != null && pushMessage.m20045d() != null) {
                d = pushMessage.m20045d();
                b = C3929q.m20372a().m20391o().m20438b(d);
                if (b != null) {
                    return C3701e.m19375a(new Exception("Unable to find message with ID " + d));
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ C3717n f13365b;

                    public void run() {
                        try {
                            C3929q.m20382h().startActivity(new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION").setPackage(C3929q.m20374b()).addFlags(805306368).setData(Uri.fromParts(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, b.m20446a(), null)));
                        } catch (ActivityNotFoundException e) {
                            C3783j.m19728e("Unable to view the inbox message in a landing page. The landing page activity is either missing in the manifest or does not include the message scheme in its intent filter.");
                        }
                    }
                });
                return C3701e.m19372a();
            } else if (c3694b.m19359c().containsKey("com.urbanairship.RICH_PUSH_ID_METADATA")) {
                d = c3694b.m19359c().getString("com.urbanairship.RICH_PUSH_ID_METADATA");
                b = C3929q.m20372a().m20391o().m20438b(d);
                if (b != null) {
                    return C3701e.m19375a(new Exception("Unable to find message with ID " + d));
                }
                new Handler(Looper.getMainLooper()).post(/* anonymous class already generated */);
                return C3701e.m19372a();
            }
        }
        d = a;
        b = C3929q.m20372a().m20391o().m20438b(d);
        if (b != null) {
            return C3701e.m19375a(new Exception("Unable to find message with ID " + d));
        }
        new Handler(Looper.getMainLooper()).post(/* anonymous class already generated */);
        return C3701e.m19372a();
    }
}
