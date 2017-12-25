package com.google.common.p050a;

import com.google.common.base.Preconditions;
import java.util.Map;

public abstract class C3464a extends C3463c {
    private final char[][] f12897a;
    private final int f12898b;
    private final char f12899c;
    private final char f12900d;

    protected abstract char[] mo2543b(char c);

    protected C3464a(Map<Character, String> map, char c, char c2) {
        this(C3465b.m18301a(map), c, c2);
    }

    protected C3464a(C3465b c3465b, char c, char c2) {
        Preconditions.checkNotNull(c3465b);
        this.f12897a = c3465b.m18303a();
        this.f12898b = this.f12897a.length;
        if (c2 < c) {
            c2 = '\u0000';
            c = '￿';
        }
        this.f12899c = c;
        this.f12900d = c2;
    }

    public final String mo2541a(String str) {
        Preconditions.checkNotNull(str);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < this.f12898b && this.f12897a[charAt] != null) || charAt > this.f12900d || charAt < this.f12899c) {
                return m18296a(str, i);
            }
        }
        return str;
    }

    protected final char[] mo2542a(char c) {
        if (c < this.f12898b) {
            char[] cArr = this.f12897a[c];
            if (cArr != null) {
                return cArr;
            }
        }
        if (c < this.f12899c || c > this.f12900d) {
            return mo2543b(c);
        }
        return null;
    }
}
