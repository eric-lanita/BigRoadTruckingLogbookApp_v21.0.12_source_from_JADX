package com.urbanairship.analytics;

import com.google.android.gms.gcm.Task;
import com.urbanairship.p055b.C3760c;
import com.urbanairship.util.C3953h;
import java.util.List;

class C3748l {
    private final C3760c f13438a;

    public C3748l(C3760c c3760c) {
        this.f13438a = c3760c;
    }

    public int m19575a() {
        return this.f13438a.m19659a();
    }

    int m19576b() {
        if (this.f13438a.m19663d() != null) {
            List list = (List) this.f13438a.m19663d().get("X-UA-Max-Total");
            if (list != null && list.size() > 0) {
                return C3953h.m20510a(Integer.parseInt((String) list.get(0)), Task.EXTRAS_LIMIT_BYTES, 5242880);
            }
        }
        return Task.EXTRAS_LIMIT_BYTES;
    }

    int m19577c() {
        if (this.f13438a.m19663d() != null) {
            List list = (List) this.f13438a.m19663d().get("X-UA-Max-Batch");
            if (list != null && list.size() > 0) {
                return C3953h.m20510a(Integer.parseInt((String) list.get(0)), 1024, 512000);
            }
        }
        return 1024;
    }

    int m19578d() {
        if (this.f13438a.m19663d() != null) {
            List list = (List) this.f13438a.m19663d().get("X-UA-Max-Wait");
            if (list != null && list.size() > 0) {
                return C3953h.m20510a(Integer.parseInt((String) list.get(0)), 604800000, 1209600000);
            }
        }
        return 604800000;
    }

    int m19579e() {
        if (this.f13438a.m19663d() != null) {
            List list = (List) this.f13438a.m19663d().get("X-UA-Min-Batch-Interval");
            if (list != null && list.size() > 0) {
                return C3953h.m20510a(Integer.parseInt((String) list.get(0)), 60000, 604800000);
            }
        }
        return 60000;
    }
}
