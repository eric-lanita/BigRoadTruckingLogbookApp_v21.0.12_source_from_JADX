package com.urbanairship.push;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.json.JsonValue;
import com.urbanairship.p055b.C3757b;
import com.urbanairship.p055b.C3760c;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class C3924m {
    private final String f13924a;
    private final String f13925b;
    private final String f13926c;
    private final C3757b f13927d;

    C3924m(C3761b c3761b) {
        this(c3761b, new C3757b());
    }

    public C3924m(C3761b c3761b, C3757b c3757b) {
        this.f13927d = c3757b;
        this.f13924a = c3761b.f13505e;
        this.f13925b = c3761b.m19664a();
        this.f13926c = c3761b.m19666b();
    }

    C3760c m20357a(String str, Map<String, Set<String>> map, Map<String, Set<String>> map2) {
        URL a = m20359a("api/named_users/tags/");
        if (a == null) {
            C3783j.m19728e("The named user tags URL cannot be null.");
            return null;
        } else if (!map.isEmpty() || !map2.isEmpty()) {
            return m20356a(a, "named_user_id", str, map, map2);
        } else {
            C3783j.m19728e("Both addTags and removeTags cannot be empty.");
            return null;
        }
    }

    C3760c m20360b(String str, Map<String, Set<String>> map, Map<String, Set<String>> map2) {
        URL a = m20359a("api/channels/tags/");
        if (a == null) {
            C3783j.m19728e("The channel tags URL cannot be null.");
            return null;
        } else if (!map.isEmpty() || !map2.isEmpty()) {
            return m20356a(a, m20358a(), str, map, map2);
        } else {
            C3783j.m19728e("Both addTags and removeTags cannot be empty.");
            return null;
        }
    }

    private C3760c m20356a(URL url, String str, String str2, Map<String, Set<String>> map, Map<String, Set<String>> map2) {
        Object hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        hashMap2.put(str, str2);
        hashMap.put("audience", hashMap2);
        if (!map.isEmpty()) {
            hashMap.put(ProductAction.ACTION_ADD, map);
        }
        if (!map2.isEmpty()) {
            hashMap.put(ProductAction.ACTION_REMOVE, map2);
        }
        try {
            String jsonValue = JsonValue.m19739b(hashMap).toString();
            C3783j.m19727d("Updating tag groups with payload: " + jsonValue);
            C3760c a = this.f13927d.m19648a("POST", url).m19643a(this.f13925b, this.f13926c).m19646b(jsonValue, "application/json").m19647c("Accept", "application/vnd.urbanairship+json; version=3;").m19645a();
            if (a == null) {
                C3783j.m19728e("Failed to receive a response for tag groups.");
                return a;
            }
            C3783j.m19725c("Received a response for tag groups: " + a);
            return a;
        } catch (Throwable e) {
            C3783j.m19726c("Failed to create channel tag groups payload as json.", e);
            return null;
        }
    }

    String m20358a() {
        switch (C3929q.m20372a().m20399w()) {
            case 1:
                return "amazon_channel";
            case 2:
                return "android_channel";
            default:
                return null;
        }
    }

    URL m20359a(String str) {
        try {
            return new URL(this.f13924a + str);
        } catch (Throwable e) {
            C3783j.m19726c("Invalid tag URL.", e);
            return null;
        }
    }
}
