package com.urbanairship.push;

import com.facebook.AccessToken;
import com.urbanairship.C3783j;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.C3954i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class C3878c implements C3684c {
    private final boolean f13777a;
    private final boolean f13778b;
    private final String f13779c;
    private final String f13780d;
    private final String f13781e;
    private final boolean f13782f;
    private final Set<String> f13783g;
    private final String f13784h;
    private final String f13785i;

    static class C3877a {
        private boolean f13768a;
        private boolean f13769b;
        private String f13770c;
        private String f13771d;
        private String f13772e;
        private boolean f13773f;
        private Set<String> f13774g;
        private String f13775h;
        private String f13776i;

        C3877a() {
        }

        C3877a m20096a(boolean z) {
            this.f13768a = z;
            return this;
        }

        C3877a m20100b(boolean z) {
            this.f13769b = z;
            return this;
        }

        C3877a m20095a(String str) {
            if (str != null) {
                str = str.trim();
            }
            this.f13770c = str;
            return this;
        }

        C3877a m20099b(String str) {
            this.f13771d = str;
            return this;
        }

        C3877a m20101c(String str) {
            this.f13772e = str;
            return this;
        }

        C3877a m20097a(boolean z, Set<String> set) {
            this.f13773f = z;
            this.f13774g = set;
            return this;
        }

        C3877a m20102d(String str) {
            this.f13775h = str;
            return this;
        }

        C3877a m20103e(String str) {
            this.f13776i = str;
            return this;
        }

        C3878c m20098a() {
            return new C3878c();
        }
    }

    private C3878c(C3877a c3877a) {
        this.f13777a = c3877a.f13768a;
        this.f13778b = c3877a.f13769b;
        this.f13779c = c3877a.f13770c;
        this.f13780d = c3877a.f13771d;
        this.f13781e = c3877a.f13772e;
        this.f13782f = c3877a.f13773f;
        this.f13783g = c3877a.f13773f ? c3877a.f13774g : null;
        this.f13784h = c3877a.f13775h;
        this.f13785i = c3877a.f13776i;
    }

    public JsonValue mo2767e() {
        Object hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        Map hashMap3 = new HashMap();
        hashMap3.put("device_type", this.f13780d);
        hashMap3.put("opt_in", Boolean.valueOf(this.f13777a));
        hashMap3.put("background", Boolean.valueOf(this.f13778b));
        hashMap3.put("push_address", this.f13781e);
        if (!C3954i.m20512a(this.f13779c)) {
            hashMap3.put("alias", this.f13779c);
        }
        hashMap3.put("set_tags", Boolean.valueOf(this.f13782f));
        if (this.f13782f && this.f13783g != null) {
            hashMap3.put("tags", JsonValue.m19732a(this.f13783g).m19752c());
        }
        hashMap.put("channel", hashMap3);
        if (!C3954i.m20512a(this.f13784h)) {
            hashMap2.put(AccessToken.USER_ID_KEY, this.f13784h);
        }
        if (!C3954i.m20512a(this.f13785i)) {
            hashMap2.put("apid", this.f13785i);
        }
        if (!hashMap2.isEmpty()) {
            hashMap.put("identity_hints", hashMap2);
        }
        try {
            return JsonValue.m19739b(hashMap);
        } catch (Throwable e) {
            C3783j.m19726c("ChannelRegistrationPayload - Failed to create channel registration payload as json", e);
            return JsonValue.f13565a;
        }
    }

    public String toString() {
        return mo2767e().toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C3878c)) {
            return false;
        }
        C3878c c3878c = (C3878c) obj;
        if (this.f13777a != c3878c.f13777a || this.f13778b != c3878c.f13778b) {
            return false;
        }
        if (this.f13779c == null) {
            if (c3878c.f13779c != null) {
                return false;
            }
        } else if (!this.f13779c.equals(c3878c.f13779c)) {
            return false;
        }
        if (this.f13780d == null) {
            if (c3878c.f13780d != null) {
                return false;
            }
        } else if (!this.f13780d.equals(c3878c.f13780d)) {
            return false;
        }
        if (this.f13781e == null) {
            if (c3878c.f13781e != null) {
                return false;
            }
        } else if (!this.f13781e.equals(c3878c.f13781e)) {
            return false;
        }
        if (this.f13782f != c3878c.f13782f) {
            return false;
        }
        if (this.f13783g == null) {
            if (c3878c.f13783g != null) {
                return false;
            }
        } else if (!this.f13783g.equals(c3878c.f13783g)) {
            return false;
        }
        if (this.f13784h == null) {
            if (c3878c.f13784h != null) {
                return false;
            }
        } else if (!this.f13784h.equals(c3878c.f13784h)) {
            return false;
        }
        if (this.f13785i == null) {
            if (c3878c.f13785i != null) {
                return false;
            }
        } else if (!this.f13785i.equals(c3878c.f13785i)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int i4 = ((this.f13777a ? 1 : 0) + 527) * 31;
        if (this.f13778b) {
            i = 1;
        } else {
            i = 0;
        }
        i = ((this.f13781e == null ? 0 : this.f13781e.hashCode()) + (((this.f13780d == null ? 0 : this.f13780d.hashCode()) + (((this.f13779c == null ? 0 : this.f13779c.hashCode()) + ((i + i4) * 31)) * 31)) * 31)) * 31;
        if (!this.f13782f) {
            i2 = 0;
        }
        i = ((this.f13784h == null ? 0 : this.f13784h.hashCode()) + (((this.f13783g == null ? 0 : this.f13783g.hashCode()) + ((i + i2) * 31)) * 31)) * 31;
        if (this.f13785i != null) {
            i3 = this.f13785i.hashCode();
        }
        return i + i3;
    }

    static C3878c m20104a(String str) {
        Set set = null;
        C3788b f = JsonValue.m19740b(str).m19755f();
        if (f == null || f.m19783c()) {
            return null;
        }
        C3877a c3877a = new C3877a();
        C3788b f2 = f.m19782c("channel").m19755f();
        if (f2 != null) {
            c3877a.m20096a(f2.m19782c("opt_in").m19750a(false)).m20100b(f2.m19782c("background").m19750a(false)).m20099b(f2.m19782c("device_type").m19747a()).m20101c(f2.m19782c("push_address").m19747a()).m20095a(f2.m19782c("alias").m19747a()).m20102d(f2.m19782c(AccessToken.USER_ID_KEY).m19747a()).m20103e(f2.m19782c("apid").m19747a());
            if (f2.m19782c("tags").m19765p()) {
                Set hashSet = new HashSet();
                Iterator it = f2.m19780b("tags").m19752c().iterator();
                while (it.hasNext()) {
                    JsonValue jsonValue = (JsonValue) it.next();
                    if (jsonValue.m19758i()) {
                        hashSet.add(jsonValue.m19747a());
                    }
                }
                set = hashSet;
            }
            c3877a.m20097a(f2.m19782c("set_tags").m19750a(false), set);
        }
        C3788b f3 = f.m19782c("identity_hints").m19755f();
        if (f3 != null) {
            c3877a.m20102d(f3.m19782c(AccessToken.USER_ID_KEY).m19747a()).m20103e(f3.m19782c("apid").m19747a());
        }
        return c3877a.m20098a();
    }
}
