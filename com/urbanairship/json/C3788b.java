package com.urbanairship.json;

import com.urbanairship.C3783j;
import com.urbanairship.util.C3954i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONStringer;

public class C3788b implements C3684c, Iterable<Entry<String, JsonValue>> {
    static final C3788b f13570a = new C3788b(null);
    private final Map<String, JsonValue> f13571b;

    public static class C3787a {
        private Map<String, JsonValue> f13569a;

        private C3787a() {
            this.f13569a = new HashMap();
        }

        public C3787a m19770a(C3788b c3788b) {
            for (Entry entry : c3788b.m19781b()) {
                m19772a((String) entry.getKey(), (C3684c) entry.getValue());
            }
            return this;
        }

        public C3787a m19772a(String str, C3684c c3684c) {
            if (c3684c == null || c3684c.mo2767e().m19757h()) {
                this.f13569a.remove(str);
            } else {
                this.f13569a.put(str, c3684c.mo2767e());
            }
            return this;
        }

        public C3787a m19773a(String str, Object obj) {
            m19772a(str, JsonValue.m19732a(obj));
            return this;
        }

        public C3787a m19774a(String str, String str2) {
            if (C3954i.m20512a(str2)) {
                this.f13569a.remove(str);
            } else {
                m19772a(str, JsonValue.m19743c(str2));
            }
            return this;
        }

        public C3787a m19775a(String str, boolean z) {
            return m19772a(str, JsonValue.m19741b(z));
        }

        public C3787a m19771a(String str, long j) {
            return m19772a(str, JsonValue.m19738b(j));
        }

        public C3788b m19776a() {
            return new C3788b(this.f13569a);
        }
    }

    public C3788b(Map<String, JsonValue> map) {
        this.f13571b = map == null ? new HashMap() : new HashMap(map);
    }

    public static C3787a m19777a() {
        return new C3787a();
    }

    public boolean m19779a(String str) {
        return this.f13571b.containsKey(str);
    }

    public Set<Entry<String, JsonValue>> m19781b() {
        return this.f13571b.entrySet();
    }

    public JsonValue m19780b(String str) {
        return (JsonValue) this.f13571b.get(str);
    }

    public JsonValue m19782c(String str) {
        JsonValue b = m19780b(str);
        return b != null ? b : JsonValue.f13565a;
    }

    public boolean m19783c() {
        return this.f13571b.isEmpty();
    }

    public Map<String, JsonValue> m19784d() {
        return new HashMap(this.f13571b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3788b) {
            return this.f13571b.equals(((C3788b) obj).f13571b);
        }
        return false;
    }

    public int hashCode() {
        return this.f13571b.hashCode();
    }

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            m19778a(jSONStringer);
            return jSONStringer.toString();
        } catch (Throwable e) {
            C3783j.m19726c("JsonMap - Failed to create JSON String.", e);
            return "";
        }
    }

    void m19778a(JSONStringer jSONStringer) {
        jSONStringer.object();
        for (Entry entry : m19781b()) {
            jSONStringer.key((String) entry.getKey());
            ((JsonValue) entry.getValue()).m19749a(jSONStringer);
        }
        jSONStringer.endObject();
    }

    public Iterator<Entry<String, JsonValue>> iterator() {
        return m19781b().iterator();
    }

    public JsonValue mo2767e() {
        return JsonValue.m19731a((C3684c) this);
    }
}
