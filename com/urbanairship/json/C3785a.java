package com.urbanairship.json;

import com.urbanairship.C3783j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONStringer;

public class C3785a implements C3684c, Iterable<JsonValue> {
    static final C3785a f13567a = new C3785a(null);
    private final List<JsonValue> f13568b;

    public C3785a(List<JsonValue> list) {
        this.f13568b = list == null ? new ArrayList() : new ArrayList(list);
    }

    public Iterator<JsonValue> iterator() {
        return this.f13568b.iterator();
    }

    public int m19766a() {
        return this.f13568b.size();
    }

    public List<JsonValue> m19768b() {
        return new ArrayList(this.f13568b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3785a) {
            return this.f13568b.equals(((C3785a) obj).f13568b);
        }
        return false;
    }

    public int hashCode() {
        return this.f13568b.hashCode();
    }

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            m19767a(jSONStringer);
            return jSONStringer.toString();
        } catch (Throwable e) {
            C3783j.m19726c("JsonList - Failed to create JSON String.", e);
            return "";
        }
    }

    void m19767a(JSONStringer jSONStringer) {
        jSONStringer.array();
        Iterator it = iterator();
        while (it.hasNext()) {
            ((JsonValue) it.next()).m19749a(jSONStringer);
        }
        jSONStringer.endArray();
    }

    public JsonValue mo2767e() {
        return JsonValue.m19731a((C3684c) this);
    }
}
