package com.urbanairship.analytics;

import android.os.Bundle;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.C3788b.C3787a;
import com.urbanairship.push.PushMessage;

public class C3750n extends C3737i {
    private final String f13440a;
    private final String f13441b;
    private final String f13442c;
    private final String f13443d;
    private final boolean f13444e;
    private final Bundle f13445f;

    public C3750n(PushMessage pushMessage, String str, String str2, boolean z, Bundle bundle) {
        this.f13440a = pushMessage.m20047f();
        this.f13441b = pushMessage.m20052k();
        this.f13442c = str;
        this.f13443d = str2;
        this.f13444e = z;
        this.f13445f = bundle;
    }

    public final String mo2778a() {
        return "interactive_notification_action";
    }

    protected final C3788b mo2779b() {
        C3787a a = C3788b.m19777a().m19774a("send_id", this.f13440a).m19774a("button_group", this.f13441b).m19774a("button_id", this.f13442c).m19774a("button_description", this.f13443d).m19775a("foreground", this.f13444e);
        if (!(this.f13445f == null || this.f13445f.isEmpty())) {
            C3787a a2 = C3788b.m19777a();
            for (String str : this.f13445f.keySet()) {
                a2.m19774a(str, this.f13445f.getString(str));
            }
            a.m19772a("user_input", a2.m19776a());
        }
        return a.m19776a();
    }
}
