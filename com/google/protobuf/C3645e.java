package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite.C3632c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class C3645e {
    private static volatile boolean f13225a = false;
    private static final C3645e f13226c = new C3645e(true);
    private final Map<C3644a, C3632c<?, ?>> f13227b;

    private static final class C3644a {
        private final Object f13223a;
        private final int f13224b;

        C3644a(Object obj, int i) {
            this.f13223a = obj;
            this.f13224b = i;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f13223a) * 65535) + this.f13224b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3644a)) {
                return false;
            }
            C3644a c3644a = (C3644a) obj;
            if (this.f13223a == c3644a.f13223a && this.f13224b == c3644a.f13224b) {
                return true;
            }
            return false;
        }
    }

    public static C3645e m19140a() {
        return f13226c;
    }

    public <ContainingType extends C2487l> C3632c<ContainingType, ?> m19141a(ContainingType containingType, int i) {
        return (C3632c) this.f13227b.get(new C3644a(containingType, i));
    }

    C3645e() {
        this.f13227b = new HashMap();
    }

    private C3645e(boolean z) {
        this.f13227b = Collections.emptyMap();
    }
}
