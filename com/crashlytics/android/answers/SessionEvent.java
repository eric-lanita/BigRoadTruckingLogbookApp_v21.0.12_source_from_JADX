package com.crashlytics.android.answers;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

final class SessionEvent {
    public final C2868s f9803a;
    public final long f9804b;
    public final Type f9805c;
    public final Map<String, String> f9806d;
    public final String f9807e;
    public final Map<String, Object> f9808f;
    public final String f9809g;
    public final Map<String, Object> f9810h;
    private String f9811i;

    enum Type {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    static class C2836a {
        final Type f9796a;
        final long f9797b = System.currentTimeMillis();
        Map<String, String> f9798c = null;
        String f9799d = null;
        Map<String, Object> f9800e = null;
        String f9801f = null;
        Map<String, Object> f9802g = null;

        public C2836a(Type type) {
            this.f9796a = type;
        }

        public C2836a m16010a(Map<String, String> map) {
            this.f9798c = map;
            return this;
        }

        public C2836a m16012b(Map<String, Object> map) {
            this.f9800e = map;
            return this;
        }

        public SessionEvent m16011a(C2868s c2868s) {
            return new SessionEvent(c2868s, this.f9797b, this.f9796a, this.f9798c, this.f9799d, this.f9800e, this.f9801f, this.f9802g);
        }
    }

    public static C2836a m16014a(Type type, Activity activity) {
        return new C2836a(type).m16010a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    public static C2836a m16013a(long j) {
        return new C2836a(Type.INSTALL).m16010a(Collections.singletonMap("installedAt", String.valueOf(j)));
    }

    public static C2836a m16015a(String str) {
        return new C2836a(Type.CRASH).m16010a(Collections.singletonMap("sessionId", str));
    }

    public static C2836a m16016a(String str, String str2) {
        return m16015a(str).m16012b(Collections.singletonMap("exceptionName", str2));
    }

    private SessionEvent(C2868s c2868s, long j, Type type, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f9803a = c2868s;
        this.f9804b = j;
        this.f9805c = type;
        this.f9806d = map;
        this.f9807e = str;
        this.f9808f = map2;
        this.f9809g = str2;
        this.f9810h = map3;
    }

    public String toString() {
        if (this.f9811i == null) {
            this.f9811i = "[" + getClass().getSimpleName() + ": " + "timestamp=" + this.f9804b + ", type=" + this.f9805c + ", details=" + this.f9806d + ", customType=" + this.f9807e + ", customAttributes=" + this.f9808f + ", predefinedType=" + this.f9809g + ", predefinedAttributes=" + this.f9810h + ", metadata=[" + this.f9803a + "]]";
        }
        return this.f9811i;
    }
}
