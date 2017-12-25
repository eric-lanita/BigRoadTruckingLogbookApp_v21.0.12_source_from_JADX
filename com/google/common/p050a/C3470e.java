package com.google.common.p050a;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

public final class C3470e {
    private static final C3462d f12910a = new C34671();

    static class C34671 extends C3463c {
        C34671() {
        }

        public String mo2541a(String str) {
            return (String) Preconditions.checkNotNull(str);
        }

        protected char[] mo2542a(char c) {
            return null;
        }
    }

    public static final class C3469a {
        private final Map<Character, String> f12906a;
        private char f12907b;
        private char f12908c;
        private String f12909d;

        private C3469a() {
            this.f12906a = new HashMap();
            this.f12907b = '\u0000';
            this.f12908c = '￿';
            this.f12909d = null;
        }

        @CanIgnoreReturnValue
        public C3469a m18310a(char c, String str) {
            Preconditions.checkNotNull(str);
            this.f12906a.put(Character.valueOf(c), str);
            return this;
        }

        public C3462d m18309a() {
            return new C3464a(this, this.f12906a, this.f12907b, this.f12908c) {
                final /* synthetic */ C3469a f12904a;
                private final char[] f12905b;

                protected char[] mo2543b(char c) {
                    return this.f12905b;
                }
            };
        }
    }

    public static C3469a m18311a() {
        return new C3469a();
    }
}
