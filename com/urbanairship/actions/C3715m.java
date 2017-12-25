package com.urbanairship.actions;

import android.os.Handler;
import android.os.Looper;
import com.urbanairship.C3929q;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.C3942c;

public class C3715m extends C3690a {
    public boolean mo2769b(C3694b c3694b) {
        switch (c3694b.m19358b()) {
            case 0:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public C3701e mo2770d(C3694b c3694b) {
        String d;
        final C3942c b;
        String a = c3694b.m19357a().m19314a();
        if ("auto".equalsIgnoreCase(a)) {
            PushMessage pushMessage = (PushMessage) c3694b.m19359c().getParcelable("com.urbanairship.PUSH_MESSAGE");
            if (pushMessage != null && pushMessage.m20045d() != null) {
                d = pushMessage.m20045d();
                b = C3929q.m20372a().m20391o().m20438b(d);
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ C3715m f13363b;

                    public void run() {
                        if (b != null) {
                            C3929q.m20372a().m20391o().m20435a(b.m20446a());
                        } else {
                            C3929q.m20372a().m20391o().m20442c();
                        }
                    }
                });
                return C3701e.m19372a();
            } else if (c3694b.m19359c().containsKey("com.urbanairship.RICH_PUSH_ID_METADATA")) {
                d = c3694b.m19359c().getString("com.urbanairship.RICH_PUSH_ID_METADATA");
                b = C3929q.m20372a().m20391o().m20438b(d);
                new Handler(Looper.getMainLooper()).post(/* anonymous class already generated */);
                return C3701e.m19372a();
            }
        }
        d = a;
        b = C3929q.m20372a().m20391o().m20438b(d);
        new Handler(Looper.getMainLooper()).post(/* anonymous class already generated */);
        return C3701e.m19372a();
    }
}
