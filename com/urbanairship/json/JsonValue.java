package com.urbanairship.json;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.urbanairship.C3783j;
import com.urbanairship.util.C3954i;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

public class JsonValue implements Parcelable, C3684c {
    public static final Creator<JsonValue> CREATOR = new C37841();
    public static final JsonValue f13565a = new JsonValue(null);
    private final Object f13566b;

    static class C37841 implements Creator<JsonValue> {
        C37841() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m19729a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m19730a(i);
        }

        public JsonValue m19729a(Parcel parcel) {
            try {
                return JsonValue.m19740b(parcel.readString());
            } catch (Throwable e) {
                C3783j.m19726c("JsonValue - Unable to create JsonValue from parcel.", e);
                return null;
            }
        }

        public JsonValue[] m19730a(int i) {
            return new JsonValue[i];
        }
    }

    private JsonValue(Object obj) {
        this.f13566b = obj;
    }

    public String m19747a() {
        return m19748a(null);
    }

    public String m19748a(String str) {
        if (!m19757h() && m19758i()) {
            return (String) this.f13566b;
        }
        return str;
    }

    public int m19745a(int i) {
        if (m19757h()) {
            return i;
        }
        if (m19759j()) {
            return ((Integer) this.f13566b).intValue();
        }
        if (m19762m()) {
            return ((Number) this.f13566b).intValue();
        }
        return i;
    }

    public double m19744a(double d) {
        if (m19757h()) {
            return d;
        }
        if (m19760k()) {
            return ((Double) this.f13566b).doubleValue();
        }
        if (m19762m()) {
            return ((Number) this.f13566b).doubleValue();
        }
        return d;
    }

    public long m19746a(long j) {
        if (m19757h()) {
            return j;
        }
        if (m19761l()) {
            return ((Long) this.f13566b).longValue();
        }
        if (m19762m()) {
            return ((Number) this.f13566b).longValue();
        }
        return j;
    }

    public Number m19751b() {
        if (m19757h() || !m19762m()) {
            return null;
        }
        return (Number) this.f13566b;
    }

    public boolean m19750a(boolean z) {
        if (!m19757h() && m19763n()) {
            return ((Boolean) this.f13566b).booleanValue();
        }
        return z;
    }

    public C3785a m19752c() {
        if (m19757h() || !m19765p()) {
            return null;
        }
        return (C3785a) this.f13566b;
    }

    public C3785a m19753d() {
        if (m19757h() || !m19765p()) {
            return C3785a.f13567a;
        }
        return m19752c();
    }

    public C3788b m19755f() {
        if (m19757h() || !m19764o()) {
            return null;
        }
        return (C3788b) this.f13566b;
    }

    public C3788b m19756g() {
        if (m19757h() || !m19764o()) {
            return C3788b.f13570a;
        }
        return m19755f();
    }

    public boolean m19757h() {
        return this.f13566b == null;
    }

    public boolean m19758i() {
        return this.f13566b instanceof String;
    }

    public boolean m19759j() {
        return this.f13566b instanceof Integer;
    }

    public boolean m19760k() {
        return this.f13566b instanceof Double;
    }

    public boolean m19761l() {
        return this.f13566b instanceof Long;
    }

    public boolean m19762m() {
        return this.f13566b instanceof Number;
    }

    public boolean m19763n() {
        return this.f13566b instanceof Boolean;
    }

    public boolean m19764o() {
        return this.f13566b instanceof C3788b;
    }

    public boolean m19765p() {
        return this.f13566b instanceof C3785a;
    }

    public static JsonValue m19740b(String str) {
        if (C3954i.m20512a(str)) {
            return f13565a;
        }
        try {
            return m19739b(new JSONTokener(str).nextValue());
        } catch (Throwable e) {
            throw new JsonException("Unable to parse string", e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsonValue)) {
            return false;
        }
        JsonValue jsonValue = (JsonValue) obj;
        if (m19757h()) {
            return jsonValue.m19757h();
        }
        return this.f13566b.equals(jsonValue.f13566b);
    }

    public int hashCode() {
        if (this.f13566b != null) {
            return this.f13566b.hashCode() + 527;
        }
        return 17;
    }

    public String toString() {
        if (m19757h()) {
            return "null";
        }
        try {
            if (this.f13566b instanceof String) {
                return JSONObject.quote((String) this.f13566b);
            }
            if (this.f13566b instanceof Number) {
                return JSONObject.numberToString((Number) this.f13566b);
            }
            if ((this.f13566b instanceof C3788b) || (this.f13566b instanceof C3785a)) {
                return this.f13566b.toString();
            }
            return String.valueOf(this.f13566b);
        } catch (Throwable e) {
            C3783j.m19726c("JsonValue - Failed to create JSON String.", e);
            return "";
        }
    }

    void m19749a(JSONStringer jSONStringer) {
        if (m19757h()) {
            jSONStringer.value(null);
        } else if (this.f13566b instanceof C3785a) {
            ((C3785a) this.f13566b).m19767a(jSONStringer);
        } else if (this.f13566b instanceof C3788b) {
            ((C3788b) this.f13566b).m19778a(jSONStringer);
        } else {
            jSONStringer.value(this.f13566b);
        }
    }

    public static JsonValue m19743c(String str) {
        return m19732a((Object) str);
    }

    public static JsonValue m19738b(long j) {
        return m19732a(Long.valueOf(j));
    }

    public static JsonValue m19741b(boolean z) {
        return m19732a(Boolean.valueOf(z));
    }

    public static JsonValue m19731a(C3684c c3684c) {
        return m19732a((Object) c3684c);
    }

    public static JsonValue m19732a(Object obj) {
        return m19733a(obj, f13565a);
    }

    public static JsonValue m19733a(Object obj, JsonValue jsonValue) {
        try {
            jsonValue = m19739b(obj);
        } catch (JsonException e) {
        }
        return jsonValue;
    }

    public static JsonValue m19739b(Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            return f13565a;
        }
        if (obj instanceof JsonValue) {
            return (JsonValue) obj;
        }
        if ((obj instanceof C3788b) || (obj instanceof C3785a) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof String)) {
            return new JsonValue(obj);
        }
        if (obj instanceof C3684c) {
            JsonValue e = ((C3684c) obj).mo2767e();
            if (e == null) {
                e = f13565a;
            }
            return e;
        } else if ((obj instanceof Byte) || (obj instanceof Short)) {
            return new JsonValue(Integer.valueOf(((Number) obj).intValue()));
        } else {
            if (obj instanceof Character) {
                return new JsonValue(((Character) obj).toString());
            }
            if (obj instanceof Float) {
                return new JsonValue(Double.valueOf(((Number) obj).doubleValue()));
            }
            if (obj instanceof Double) {
                Double d = (Double) obj;
                if (!d.isInfinite() && !d.isNaN()) {
                    return new JsonValue(obj);
                }
                throw new JsonException("Invalid Double value: " + d);
            }
            try {
                if (obj instanceof JSONArray) {
                    return m19736a((JSONArray) obj);
                }
                if (obj instanceof JSONObject) {
                    return m19737a((JSONObject) obj);
                }
                if (obj instanceof Collection) {
                    return m19734a((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return m19742c(obj);
                }
                if (obj instanceof Map) {
                    return m19735a((Map) obj);
                }
                throw new JsonException("Illegal object: " + obj);
            } catch (JsonException e2) {
                throw e2;
            } catch (Throwable e3) {
                throw new JsonException("Failed to wrap value.", e3);
            }
        }
    }

    private static JsonValue m19742c(Object obj) {
        int length = Array.getLength(obj);
        List arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                arrayList.add(m19739b(obj2));
            }
        }
        return new JsonValue(new C3785a(arrayList));
    }

    private static JsonValue m19734a(Collection collection) {
        List arrayList = new ArrayList();
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(m19739b(next));
            }
        }
        return new JsonValue(new C3785a(arrayList));
    }

    private static JsonValue m19735a(Map<?, ?> map) {
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw new JsonException("Only string map keys are accepted.");
            } else if (entry.getValue() != null) {
                hashMap.put((String) entry.getKey(), m19739b(entry.getValue()));
            }
        }
        return new JsonValue(new C3788b(hashMap));
    }

    private static JsonValue m19736a(JSONArray jSONArray) {
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!jSONArray.isNull(i)) {
                arrayList.add(m19739b(jSONArray.opt(i)));
            }
        }
        return new JsonValue(new C3785a(arrayList));
    }

    private static JsonValue m19737a(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (!jSONObject.isNull(str)) {
                hashMap.put(str, m19739b(jSONObject.opt(str)));
            }
        }
        return new JsonValue(new C3788b(hashMap));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(toString());
    }

    public JsonValue mo2767e() {
        return this;
    }
}
