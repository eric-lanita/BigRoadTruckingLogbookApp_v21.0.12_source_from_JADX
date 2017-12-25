package com.urbanairship.analytics;

import com.urbanairship.json.C3788b;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.C3954i;

public class C3752p extends C3737i {
    private final String f13454a;
    private final String f13455b;

    public C3752p(PushMessage pushMessage) {
        this.f13454a = pushMessage.m20047f();
        this.f13455b = pushMessage.m20048g();
    }

    public final String mo2778a() {
        return "push_arrived";
    }

    protected final C3788b mo2779b() {
        return C3788b.m19777a().m19774a("push_id", !C3954i.m20512a(this.f13454a) ? this.f13454a : "MISSING_SEND_ID").m19774a("metadata", this.f13455b).m19774a("connection_type", m19493g()).m19774a("connection_subtype", m19494h()).m19774a("carrier", m19495i()).m19776a();
    }
}
