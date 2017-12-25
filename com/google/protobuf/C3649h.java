package com.google.protobuf;

import java.io.IOException;

class C3649h {
    private final C2487l f13234a;
    private final C3645e f13235b;
    private C3642c f13236c;
    private volatile C2487l f13237d;

    public C2487l m19152a() {
        m19151b();
        return this.f13237d;
    }

    public int hashCode() {
        m19151b();
        return this.f13237d.hashCode();
    }

    public boolean equals(Object obj) {
        m19151b();
        return this.f13237d.equals(obj);
    }

    public String toString() {
        m19151b();
        return this.f13237d.toString();
    }

    private void m19151b() {
        if (this.f13237d == null) {
            synchronized (this) {
                if (this.f13237d != null) {
                    return;
                }
                try {
                    if (this.f13236c != null) {
                        this.f13237d = (C2487l) this.f13234a.getParserForType().mo1352c(this.f13236c, this.f13235b);
                    }
                } catch (IOException e) {
                }
            }
        }
    }
}
