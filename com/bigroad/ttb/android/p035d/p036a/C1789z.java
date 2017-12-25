package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import java.util.Comparator;

public class C1789z extends C1762b {
    public static final Comparator<C1789z> f6118b = new C17881();

    static class C17881 implements Comparator<C1789z> {
        C17881() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8681a((C1789z) obj, (C1789z) obj2);
        }

        public int m8681a(C1789z c1789z, C1789z c1789z2) {
            int d = c1789z.m8684d();
            int d2 = c1789z2.m8684d();
            if (d > d2) {
                return -1;
            }
            if (d < d2) {
                return 1;
            }
            long e = c1789z.m8685e();
            long e2 = c1789z2.m8685e();
            if (e > e2) {
                return -1;
            }
            if (e < e2) {
                return 1;
            }
            return c1789z.m8683b().compareToIgnoreCase(c1789z2.m8683b());
        }
    }

    public C1789z(Cursor cursor) {
        m8554b(cursor, "text_type");
        m8556c(cursor, "owning_person_id");
        m8557d(cursor, "text");
        m8554b(cursor, "use_count");
        m8556c(cursor, "last_used_at");
    }

    public String toString() {
        return m8683b();
    }

    public String mo1062a() {
        return "user_text_history";
    }

    public String m8683b() {
        return this.a.getAsString("text");
    }

    public int m8684d() {
        return this.a.getAsInteger("use_count").intValue();
    }

    public long m8685e() {
        return this.a.getAsLong("last_used_at").longValue();
    }
}
