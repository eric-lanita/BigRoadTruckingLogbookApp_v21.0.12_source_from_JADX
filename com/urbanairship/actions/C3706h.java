package com.urbanairship.actions;

import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.analytics.C3744h.C3743a;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.C3942c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

public class C3706h extends C3690a {
    public C3701e mo2770d(C3694b c3694b) {
        C3788b c = c3694b.m19357a().m19318c();
        String a = c.m19782c("event_name").m19747a();
        String a2 = c.m19782c("event_value").m19747a();
        double a3 = c.m19782c("event_value").m19744a(0.0d);
        String a4 = c.m19782c("transaction_id").m19747a();
        String a5 = c.m19782c("interaction_type").m19747a();
        String a6 = c.m19782c("interaction_id").m19747a();
        C3788b f = c.m19782c("properties").m19755f();
        C3743a a7 = new C3743a(a).m19530b(a4).m19525a(a5, a6).m19520a((PushMessage) c3694b.m19359c().getParcelable("com.urbanairship.PUSH_MESSAGE"));
        if (a2 != null) {
            a7.m19522a(a2);
        } else {
            a7.m19519a(a3);
        }
        if (a6 == null && a5 == null) {
            C3942c b = C3929q.m20372a().m20391o().m20438b(c3694b.m19359c().getString("com.urbanairship.RICH_PUSH_ID_METADATA"));
            if (b != null) {
                a7.m19521a(b);
            }
        }
        if (f != null) {
            Iterator it = f.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (((JsonValue) entry.getValue()).m19763n()) {
                    a7.m19527a((String) entry.getKey(), ((JsonValue) entry.getValue()).m19750a(false));
                } else if (((JsonValue) entry.getValue()).m19760k()) {
                    a7.m19523a((String) entry.getKey(), ((JsonValue) entry.getValue()).m19744a(0.0d));
                } else if (((JsonValue) entry.getValue()).m19762m()) {
                    a7.m19524a((String) entry.getKey(), ((JsonValue) entry.getValue()).m19751b().longValue());
                } else if (((JsonValue) entry.getValue()).m19758i()) {
                    a7.m19531b((String) entry.getKey(), ((JsonValue) entry.getValue()).m19747a());
                } else if (((JsonValue) entry.getValue()).m19765p()) {
                    Collection arrayList = new ArrayList();
                    Iterator it2 = ((JsonValue) entry.getValue()).m19752c().iterator();
                    while (it2.hasNext()) {
                        JsonValue jsonValue = (JsonValue) it2.next();
                        if (jsonValue.m19758i()) {
                            arrayList.add(jsonValue.m19747a());
                        } else {
                            arrayList.add(jsonValue.toString());
                        }
                    }
                    a7.m19526a((String) entry.getKey(), arrayList);
                }
            }
        }
        if (a7.m19532b().mo2780c()) {
            return C3701e.m19372a();
        }
        return C3701e.m19375a(new IllegalArgumentException("Unable to add custom event. Event is invalid."));
    }

    public boolean mo2769b(C3694b c3694b) {
        if (c3694b.m19357a().m19318c() == null) {
            C3783j.m19725c("CustomEventAction requires a map of event data.");
            return false;
        } else if (c3694b.m19357a().m19318c().m19780b("event_name") != null) {
            return true;
        } else {
            C3783j.m19725c("CustomEventAction requires an event name in the event data.");
            return false;
        }
    }
}
