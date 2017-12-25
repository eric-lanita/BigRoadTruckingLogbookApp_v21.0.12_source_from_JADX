package com.urbanairship.push.p033a;

import android.content.Context;
import android.support.v4.app.ad.C0134a;
import com.urbanairship.C3783j;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.List;

public class C3872d {
    private final List<C3869c> f13763a;

    public static class C3871a {
        private final List<C3869c> f13762a = new ArrayList();

        public C3871a m20076a(C3869c c3869c) {
            this.f13762a.add(c3869c);
            return this;
        }

        public C3872d m20077a() {
            return new C3872d(this.f13762a);
        }
    }

    private C3872d(List<C3869c> list) {
        this.f13763a = new ArrayList(list);
    }

    public List<C3869c> m20078a() {
        return new ArrayList(this.f13763a);
    }

    List<C0134a> m20079a(Context context, PushMessage pushMessage, int i, String str) {
        C3788b g;
        List<C0134a> arrayList = new ArrayList();
        if (!C3954i.m20512a(str)) {
            try {
                g = JsonValue.m19740b(str).m19756g();
            } catch (Throwable e) {
                C3783j.m19726c("Failed to parse notification actions payload: " + str, e);
            }
            for (C3869c c3869c : m20078a()) {
                arrayList.add(c3869c.m20070a(context, g != null ? null : g.m19782c(c3869c.m20072b()).toString(), pushMessage, i));
            }
            return arrayList;
        }
        g = null;
        for (C3869c c3869c2 : m20078a()) {
            if (g != null) {
            }
            arrayList.add(c3869c2.m20070a(context, g != null ? null : g.m19782c(c3869c2.m20072b()).toString(), pushMessage, i));
        }
        return arrayList;
    }
}
