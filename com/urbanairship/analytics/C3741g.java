package com.urbanairship.analytics;

import com.facebook.internal.ServerProtocol;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class C3741g implements C3684c {
    private final Map<String, String> f13417a;

    public static abstract class C3733a {
        private boolean f13395a = false;
        private Map<String, String> f13396b = new HashMap();
        private List<String> f13397c = new ArrayList();

        abstract void mo2776a(boolean z, Map<String, String> map, List<String> list);

        C3733a() {
        }

        public C3733a m19439a(String str, boolean z) {
            m19438a("com.urbanairship.aaid", str);
            m19438a("com.urbanairship.limited_ad_tracking_enabled", z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            return this;
        }

        public C3733a m19438a(String str, String str2) {
            this.f13397c.remove(str);
            this.f13396b.put(str, str2);
            return this;
        }

        public void m19440a() {
            mo2776a(this.f13395a, this.f13396b, this.f13397c);
        }
    }

    C3741g() {
        this.f13417a = new HashMap();
    }

    C3741g(Map<String, String> map) {
        this.f13417a = new HashMap(map);
    }

    public Map<String, String> m19507a() {
        return Collections.unmodifiableMap(this.f13417a);
    }

    public String m19508b() {
        return (String) this.f13417a.get("com.urbanairship.aaid");
    }

    public boolean m19509c() {
        String str = (String) this.f13417a.get("com.urbanairship.limited_ad_tracking_enabled");
        return str != null && str.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    public JsonValue mo2767e() {
        return JsonValue.m19732a(this.f13417a);
    }

    public static C3741g m19506a(String str) {
        Map hashMap = new HashMap();
        JsonValue b = JsonValue.m19740b(str);
        if (b != null && b.m19764o()) {
            Iterator it = b.m19755f().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                hashMap.put(entry.getKey(), ((JsonValue) entry.getValue()).m19747a());
            }
        }
        return new C3741g(hashMap);
    }
}
