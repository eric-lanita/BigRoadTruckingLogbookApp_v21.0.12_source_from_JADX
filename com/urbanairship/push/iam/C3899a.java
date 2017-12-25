package com.urbanairship.push.iam;

import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3929q;
import com.urbanairship.analytics.C3737i;
import com.urbanairship.json.C3788b;
import com.urbanairship.util.C3954i;

public class C3899a extends C3737i {
    private final String f13845a;

    public C3899a(InAppMessage inAppMessage) {
        this.f13845a = inAppMessage.m20187c();
    }

    public final String mo2778a() {
        return "in_app_display";
    }

    protected final C3788b mo2779b() {
        return C3788b.m19777a().m19774a(ShareConstants.WEB_DIALOG_PARAM_ID, this.f13845a).m19774a("conversion_send_id", C3929q.m20372a().m20394r().m19459c()).m19774a("conversion_metadata", C3929q.m20372a().m20394r().m19461d()).m19776a();
    }

    public boolean mo2780c() {
        return !C3954i.m20512a(this.f13845a);
    }
}
