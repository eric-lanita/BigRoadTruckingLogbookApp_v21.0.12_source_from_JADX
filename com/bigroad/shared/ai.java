package com.bigroad.shared;

import com.google.common.base.Function;
import com.google.protobuf.C2487l;
import com.google.protobuf.C3642c;
import java.util.Arrays;
import java.util.Comparator;

public abstract class ai {
    public static final Comparator<C3642c> f2620a = new C08381();
    public static final Function<C3642c, byte[]> f2621b = new C08392();

    static class C08381 implements Comparator<C3642c> {
        C08381() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4172a((C3642c) obj, (C3642c) obj2);
        }

        public int m4172a(C3642c c3642c, C3642c c3642c2) {
            int b = c3642c.mo2752b();
            int b2 = c3642c2.mo2752b();
            int min = Math.min(b, b2);
            for (int i = 0; i < min; i++) {
                int a = c3642c.mo2749a(i) & 255;
                int a2 = c3642c2.mo2749a(i) & 255;
                if (a < a2) {
                    return -1;
                }
                if (a > a2) {
                    return 1;
                }
            }
            if (b >= b2) {
                return b > b2 ? 1 : 0;
            } else {
                return -1;
            }
        }
    }

    static class C08392 implements Function<C3642c, byte[]> {
        C08392() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m4173a((C3642c) obj);
        }

        public byte[] m4173a(C3642c c3642c) {
            return ai.m4178b(c3642c);
        }
    }

    public static boolean m4176a(C3642c c3642c) {
        return c3642c == null || c3642c.m19090c();
    }

    public static byte[] m4178b(C3642c c3642c) {
        return m4176a(c3642c) ? null : c3642c.m19091d();
    }

    public static C3642c m4175a(byte[] bArr) {
        return bArr == null ? null : C3642c.m19078a(bArr);
    }

    public static C3642c m4174a() {
        return C3642c.m19078a(aj.m4179a());
    }

    public static boolean m4177a(C2487l c2487l, C2487l c2487l2) {
        if (c2487l == c2487l2) {
            return true;
        }
        if (c2487l == null || c2487l2 == null) {
            return false;
        }
        return Arrays.equals(c2487l.toByteArray(), c2487l2.toByteArray());
    }
}
