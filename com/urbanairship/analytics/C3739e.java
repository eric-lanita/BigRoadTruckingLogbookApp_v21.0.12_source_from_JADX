package com.urbanairship.analytics;

import android.os.Build.VERSION;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;

class C3739e extends C3737i {
    C3739e(long j) {
        super(j);
    }

    public final String mo2778a() {
        return "app_foreground";
    }

    protected final C3788b mo2779b() {
        return C3788b.m19777a().m19774a("connection_type", m19493g()).m19774a("connection_subtype", m19494h()).m19774a("carrier", m19495i()).m19771a("time_zone", m19496j()).m19775a("daylight_savings", m19497k()).m19772a("notification_types", JsonValue.m19732a(m19492f()).m19752c()).m19774a("os_version", VERSION.RELEASE).m19774a("lib_version", C3929q.m20385k()).m19774a("package_version", C3929q.m20379e().versionName).m19774a("push_id", C3929q.m20372a().m20394r().m19459c()).m19774a("metadata", C3929q.m20372a().m20394r().m19461d()).m19774a("last_metadata", C3929q.m20372a().m20390n().m20328t()).m19776a();
    }
}
