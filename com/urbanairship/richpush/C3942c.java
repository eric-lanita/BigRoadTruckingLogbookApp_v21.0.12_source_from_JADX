package com.urbanairship.richpush;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.C3948c;
import com.urbanairship.util.C3954i;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class C3942c implements Comparable<C3942c> {
    boolean f13986a = false;
    boolean f13987b;
    private boolean f13988c;
    private Bundle f13989d;
    private long f13990e;
    private Long f13991f;
    private String f13992g;
    private String f13993h;
    private String f13994i;
    private String f13995j;
    private String f13996k;
    private JsonValue f13997l;

    public /* synthetic */ int compareTo(Object obj) {
        return m20445a((C3942c) obj);
    }

    private C3942c() {
    }

    static C3942c m20444a(JsonValue jsonValue, boolean z, boolean z2) {
        C3788b f = jsonValue.m19755f();
        if (f == null) {
            return null;
        }
        C3942c c3942c = new C3942c();
        c3942c.f13992g = f.m19782c("message_id").m19747a();
        c3942c.f13993h = f.m19782c("message_url").m19747a();
        c3942c.f13994i = f.m19782c("message_body_url").m19747a();
        c3942c.f13995j = f.m19782c("message_read_url").m19747a();
        c3942c.f13996k = f.m19782c(ShareConstants.WEB_DIALOG_PARAM_TITLE).m19747a();
        c3942c.f13988c = f.m19782c("unread").m19750a(true);
        c3942c.f13997l = jsonValue;
        String a = f.m19782c("message_sent").m19747a();
        if (C3954i.m20512a(a)) {
            c3942c.f13990e = System.currentTimeMillis();
        } else {
            c3942c.f13990e = C3948c.m20491a(a, System.currentTimeMillis());
        }
        a = f.m19782c("message_expiry").m19747a();
        if (!C3954i.m20512a(a)) {
            c3942c.f13991f = Long.valueOf(C3948c.m20491a(a, Long.MAX_VALUE));
        }
        c3942c.f13989d = new Bundle();
        f = f.m19782c("extra").m19755f();
        if (f != null) {
            Iterator it = f.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (((JsonValue) entry.getValue()).m19758i()) {
                    c3942c.f13989d.putString((String) entry.getKey(), ((JsonValue) entry.getValue()).m19747a());
                } else {
                    c3942c.f13989d.putString((String) entry.getKey(), ((JsonValue) entry.getValue()).toString());
                }
            }
        }
        c3942c.f13986a = z2;
        c3942c.f13987b = z;
        return c3942c;
    }

    public String m20446a() {
        return this.f13992g;
    }

    public String m20447b() {
        return this.f13994i;
    }

    public String m20448c() {
        return this.f13996k;
    }

    public boolean m20449d() {
        return !this.f13987b;
    }

    public Date m20450e() {
        return new Date(this.f13990e);
    }

    public long m20451f() {
        return this.f13990e;
    }

    public boolean m20452g() {
        return this.f13991f != null && System.currentTimeMillis() >= this.f13991f.longValue();
    }

    public void m20453h() {
        if (this.f13987b) {
            this.f13987b = false;
            Set hashSet = new HashSet();
            hashSet.add(this.f13992g);
            C3929q.m20372a().m20391o().m20436a(hashSet);
        }
    }

    public JsonValue m20454i() {
        return this.f13997l;
    }

    public boolean m20455j() {
        return this.f13986a;
    }

    public String m20456k() {
        JsonValue b = m20454i().m19755f().m19780b("icons");
        if (b == null || !b.m19764o()) {
            return null;
        }
        return b.m19755f().m19782c("list_icon").m19747a();
    }

    public int m20445a(C3942c c3942c) {
        return m20446a().compareTo(c3942c.m20446a());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        if (r7 == 0) goto L_0x0008;
    L_0x0004:
        r2 = r7 instanceof com.urbanairship.richpush.C3942c;
        if (r2 != 0) goto L_0x000a;
    L_0x0008:
        r0 = r1;
    L_0x0009:
        return r0;
    L_0x000a:
        r7 = (com.urbanairship.richpush.C3942c) r7;
        if (r6 == r7) goto L_0x0009;
    L_0x000e:
        r2 = r6.f13992g;
        if (r2 != 0) goto L_0x0052;
    L_0x0012:
        r2 = r7.f13992g;
        if (r2 != 0) goto L_0x0050;
    L_0x0016:
        r2 = r6.f13994i;
        if (r2 != 0) goto L_0x005d;
    L_0x001a:
        r2 = r7.f13994i;
        if (r2 != 0) goto L_0x0050;
    L_0x001e:
        r2 = r6.f13995j;
        if (r2 != 0) goto L_0x0068;
    L_0x0022:
        r2 = r7.f13995j;
        if (r2 != 0) goto L_0x0050;
    L_0x0026:
        r2 = r6.f13993h;
        if (r2 != 0) goto L_0x0073;
    L_0x002a:
        r2 = r7.f13993h;
        if (r2 != 0) goto L_0x0050;
    L_0x002e:
        r2 = r6.f13989d;
        if (r2 != 0) goto L_0x007e;
    L_0x0032:
        r2 = r7.f13989d;
        if (r2 != 0) goto L_0x0050;
    L_0x0036:
        r2 = r6.f13987b;
        r3 = r7.f13987b;
        if (r2 != r3) goto L_0x0050;
    L_0x003c:
        r2 = r6.f13988c;
        r3 = r7.f13988c;
        if (r2 != r3) goto L_0x0050;
    L_0x0042:
        r2 = r6.f13986a;
        r3 = r7.f13986a;
        if (r2 != r3) goto L_0x0050;
    L_0x0048:
        r2 = r6.f13990e;
        r4 = r7.f13990e;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0009;
    L_0x0050:
        r0 = r1;
        goto L_0x0009;
    L_0x0052:
        r2 = r6.f13992g;
        r3 = r7.f13992g;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0050;
    L_0x005c:
        goto L_0x0016;
    L_0x005d:
        r2 = r6.f13994i;
        r3 = r7.f13994i;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0050;
    L_0x0067:
        goto L_0x001e;
    L_0x0068:
        r2 = r6.f13995j;
        r3 = r7.f13995j;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0050;
    L_0x0072:
        goto L_0x0026;
    L_0x0073:
        r2 = r6.f13993h;
        r3 = r7.f13993h;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0050;
    L_0x007d:
        goto L_0x002e;
    L_0x007e:
        r2 = r6.f13989d;
        r3 = r7.f13989d;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0050;
    L_0x0088:
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.richpush.c.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((this.f13989d == null ? 0 : this.f13989d.hashCode()) + (((this.f13993h == null ? 0 : this.f13993h.hashCode()) + (((this.f13995j == null ? 0 : this.f13995j.hashCode()) + (((this.f13994i == null ? 0 : this.f13994i.hashCode()) + (((this.f13992g == null ? 0 : this.f13992g.hashCode()) + 629) * 37)) * 37)) * 37)) * 37)) * 37;
        if (this.f13987b) {
            i = 0;
        } else {
            i = 1;
        }
        hashCode = (i + hashCode) * 37;
        if (this.f13988c) {
            i = 0;
        } else {
            i = 1;
        }
        i = (i + hashCode) * 37;
        if (!this.f13986a) {
            i2 = 1;
        }
        return ((i + i2) * 37) + Long.valueOf(this.f13990e).hashCode();
    }
}
