package com.urbanairship.analytics;

import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.C3788b.C3787a;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.util.C3954i;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class C3744h extends C3737i {
    private static final BigDecimal f13426a = new BigDecimal(Integer.MAX_VALUE);
    private static final BigDecimal f13427b = new BigDecimal(Integer.MIN_VALUE);
    private final String f13428c;
    private final BigDecimal f13429d;
    private final String f13430e;
    private final String f13431f;
    private final String f13432g;
    private final String f13433h;
    private final String f13434i;
    private final Map<String, Object> f13435j;

    public static class C3743a {
        private String f13418a;
        private BigDecimal f13419b;
        private String f13420c;
        private String f13421d;
        private String f13422e;
        private String f13423f;
        private String f13424g;
        private Map<String, Object> f13425h = new HashMap();

        public C3743a(String str) {
            this.f13418a = str;
        }

        public C3743a m19528a(BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                this.f13419b = null;
            } else {
                this.f13419b = bigDecimal;
            }
            return this;
        }

        public C3743a m19519a(double d) {
            return m19528a(BigDecimal.valueOf(d));
        }

        public C3743a m19522a(String str) {
            if (!C3954i.m20512a(str)) {
                return m19528a(new BigDecimal(str));
            }
            this.f13419b = null;
            return this;
        }

        public C3743a m19530b(String str) {
            this.f13420c = str;
            return this;
        }

        public C3743a m19521a(C3942c c3942c) {
            if (c3942c != null) {
                this.f13421d = "ua_mcrap";
                this.f13422e = c3942c.m20446a();
            }
            return this;
        }

        public C3743a m19525a(String str, String str2) {
            this.f13422e = str2;
            this.f13421d = str;
            return this;
        }

        public C3743a m19520a(PushMessage pushMessage) {
            if (pushMessage != null) {
                this.f13423f = pushMessage.m20047f();
                this.f13424g = pushMessage.m20048g();
            }
            return this;
        }

        public C3743a m19531b(String str, String str2) {
            this.f13425h.put(str, str2);
            return this;
        }

        public C3743a m19524a(String str, long j) {
            this.f13425h.put(str, Long.valueOf(j));
            return this;
        }

        public C3743a m19523a(String str, double d) {
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new NumberFormatException("Infinity or NaN: " + d);
            }
            this.f13425h.put(str, Double.valueOf(d));
            return this;
        }

        public C3743a m19527a(String str, boolean z) {
            this.f13425h.put(str, Boolean.valueOf(z));
            return this;
        }

        public C3743a m19526a(String str, Collection<String> collection) {
            this.f13425h.put(str, new ArrayList(collection));
            return this;
        }

        public C3744h m19529a() {
            return new C3744h();
        }

        public C3744h m19532b() {
            C3737i a = m19529a();
            C3929q.m20372a().m20394r().m19455a(a);
            return a;
        }
    }

    private C3744h(C3743a c3743a) {
        String str = null;
        this.f13428c = c3743a.f13418a;
        this.f13429d = c3743a.f13419b;
        this.f13430e = C3954i.m20512a(c3743a.f13420c) ? null : c3743a.f13420c;
        this.f13431f = C3954i.m20512a(c3743a.f13421d) ? null : c3743a.f13421d;
        if (!C3954i.m20512a(c3743a.f13422e)) {
            str = c3743a.f13422e;
        }
        this.f13432g = str;
        this.f13433h = c3743a.f13423f;
        this.f13434i = c3743a.f13424g;
        this.f13435j = new HashMap(c3743a.f13425h);
    }

    public final String mo2778a() {
        return "custom_event";
    }

    protected final C3788b mo2779b() {
        C3787a a = C3788b.m19777a();
        String c = C3929q.m20372a().m20394r().m19459c();
        String d = C3929q.m20372a().m20394r().m19461d();
        a.m19774a("event_name", this.f13428c);
        a.m19774a("interaction_id", this.f13432g);
        a.m19774a("interaction_type", this.f13431f);
        a.m19774a("transaction_id", this.f13430e);
        if (this.f13429d != null) {
            a.m19771a("event_value", this.f13429d.movePointRight(6).longValue());
        }
        if (C3954i.m20512a(this.f13433h)) {
            a.m19774a("conversion_send_id", c);
        } else {
            a.m19774a("conversion_send_id", this.f13433h);
        }
        if (!C3954i.m20512a(this.f13434i)) {
            a.m19774a("conversion_metadata", this.f13434i);
        } else if (d != null) {
            a.m19774a("conversion_metadata", d);
        } else {
            a.m19774a("last_received_metadata", C3929q.m20372a().m20390n().m20328t());
        }
        C3787a a2 = C3788b.m19777a();
        for (Entry entry : this.f13435j.entrySet()) {
            if (entry.getValue() instanceof Collection) {
                a2.m19772a((String) entry.getKey(), JsonValue.m19732a(entry.getValue()).m19752c());
            } else {
                a2.m19773a((String) entry.getKey(), JsonValue.m19732a(entry.getValue()).toString());
            }
        }
        if (a2.m19776a().m19784d().size() > 0) {
            a.m19772a("properties", a2.m19776a());
        }
        return a.m19776a();
    }

    public boolean mo2780c() {
        boolean z = true;
        if (C3954i.m20512a(this.f13428c) || this.f13428c.length() > 255) {
            C3783j.m19728e("Event name must not be null, empty, or larger than 255 characters.");
            z = false;
        }
        if (this.f13429d != null) {
            if (this.f13429d.compareTo(f13426a) > 0) {
                C3783j.m19728e("Event value is bigger than " + f13426a);
                z = false;
            } else if (this.f13429d.compareTo(f13427b) < 0) {
                C3783j.m19728e("Event value is smaller than " + f13427b);
                z = false;
            }
        }
        if (this.f13430e != null && this.f13430e.length() > 255) {
            C3783j.m19728e("Transaction ID is larger than 255 characters.");
            z = false;
        }
        if (this.f13432g != null && this.f13432g.length() > 255) {
            C3783j.m19728e("Interaction ID is larger than 255 characters.");
            z = false;
        }
        if (this.f13431f != null && this.f13431f.length() > 255) {
            C3783j.m19728e("Interaction type is larger than 255 characters.");
            z = false;
        }
        if (this.f13435j.size() > 100) {
            C3783j.m19728e("Number of custom properties exceeds 100");
            z = false;
        }
        boolean z2 = z;
        for (Entry entry : this.f13435j.entrySet()) {
            if (((String) entry.getKey()).length() > 255) {
                C3783j.m19728e("The custom property " + ((String) entry.getKey()) + " is larger than " + 255 + " characters.");
                z2 = false;
            }
            if (entry.getValue() instanceof Collection) {
                Collection<Object> collection = (Collection) entry.getValue();
                if (collection.size() > 20) {
                    C3783j.m19728e("The custom property " + ((String) entry.getKey()) + " contains a Collection<String> that is larger than  " + 20);
                    z2 = false;
                }
                for (Object valueOf : collection) {
                    String valueOf2 = String.valueOf(valueOf);
                    if (valueOf2 != null && valueOf2.length() > 255) {
                        C3783j.m19728e("The custom property " + ((String) entry.getKey()) + " contains a value that is larger than  " + 255 + " characters.");
                        z2 = false;
                    }
                }
                z = z2;
            } else if (!(entry.getValue() instanceof String) || ((String) entry.getValue()).length() <= 255) {
                z = z2;
            } else {
                C3783j.m19728e("The custom property " + ((String) entry.getKey()) + " contains a value that is larger than  " + 255 + " characters.");
                z = false;
            }
            z2 = z;
        }
        return z2;
    }
}
