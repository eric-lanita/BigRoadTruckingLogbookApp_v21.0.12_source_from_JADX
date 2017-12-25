package com.google.common.p050a;

final class C3472f {
    private static final ThreadLocal<char[]> f12911a = new C34711();

    static class C34711 extends ThreadLocal<char[]> {
        C34711() {
        }

        protected /* synthetic */ Object initialValue() {
            return m18312a();
        }

        protected char[] m18312a() {
            return new char[1024];
        }
    }

    static char[] m18313a() {
        return (char[]) f12911a.get();
    }
}
