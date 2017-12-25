package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;

public class C1763a extends C1762b {
    public C1763a(Cursor cursor) {
        m8557d(cursor, "email_address");
    }

    public C1763a(String str) {
        this.a.put("email_address", str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1763a)) {
            return false;
        }
        String b = m8560b();
        String b2 = ((C1763a) obj).m8560b();
        if (b != null) {
            return b.equalsIgnoreCase(b2);
        }
        if (b2 != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String b = m8560b();
        return b == null ? 0 : b.toUpperCase().hashCode();
    }

    public String mo1062a() {
        return "contact";
    }

    public String m8560b() {
        return this.a.getAsString("email_address");
    }
}
