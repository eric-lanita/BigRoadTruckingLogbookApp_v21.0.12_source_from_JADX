package com.google.common.p050a;

import com.google.common.base.Function;

public abstract class C3462d {
    private final Function<String, String> f12896a = new C34661(this);

    class C34661 implements Function<String, String> {
        final /* synthetic */ C3462d f12903a;

        C34661(C3462d c3462d) {
            this.f12903a = c3462d;
        }

        public /* synthetic */ Object apply(Object obj) {
            return m18304a((String) obj);
        }

        public String m18304a(String str) {
            return this.f12903a.mo2541a(str);
        }
    }

    public abstract String mo2541a(String str);

    protected C3462d() {
    }
}
