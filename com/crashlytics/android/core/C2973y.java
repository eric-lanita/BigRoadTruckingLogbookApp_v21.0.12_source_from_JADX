package com.crashlytics.android.core;

import com.crashlytics.android.core.p048a.p049a.C2872a;
import com.crashlytics.android.core.p048a.p049a.C2873b;
import com.crashlytics.android.core.p048a.p049a.C2874c;
import com.crashlytics.android.core.p048a.p049a.C2875d;
import com.crashlytics.android.core.p048a.p049a.C2876e;
import com.crashlytics.android.core.p048a.p049a.C2878f;
import com.crashlytics.android.core.p048a.p049a.C2878f.C2877a;
import io.fabric.sdk.android.C3969c;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class C2973y {
    private static final C2876e f10139a = new C2876e("", "", 0);
    private static final C2960j[] f10140b = new C2960j[0];
    private static final C2972m[] f10141c = new C2972m[0];
    private static final C2967g[] f10142d = new C2967g[0];
    private static final C2962b[] f10143e = new C2962b[0];
    private static final C2963c[] f10144f = new C2963c[0];

    private static abstract class C2960j {
        private final int f10111a;
        private final C2960j[] f10112b;

        public C2960j(int i, C2960j... c2960jArr) {
            this.f10111a = i;
            if (c2960jArr == null) {
                c2960jArr = C2973y.f10140b;
            }
            this.f10112b = c2960jArr;
        }

        public int mo1490b() {
            int c = m16474c();
            return (c + CodedOutputStream.m16142l(c)) + CodedOutputStream.m16141j(this.f10111a);
        }

        public int m16474c() {
            int a = mo1488a();
            for (C2960j b : this.f10112b) {
                a += b.mo1490b();
            }
            return a;
        }

        public void mo1491b(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16165g(this.f10111a, 2);
            codedOutputStream.m16167k(m16474c());
            mo1489a(codedOutputStream);
            for (C2960j b : this.f10112b) {
                b.mo1491b(codedOutputStream);
            }
        }

        public int mo1488a() {
            return 0;
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
        }
    }

    private static final class C2961a extends C2960j {
        public C2961a(C2966f c2966f, C2970k c2970k) {
            super(3, c2966f, c2970k);
        }
    }

    private static final class C2962b extends C2960j {
        private final long f10113a;
        private final long f10114b;
        private final String f10115c;
        private final String f10116d;

        public C2962b(C2872a c2872a) {
            super(4, new C2960j[0]);
            this.f10113a = c2872a.f9898a;
            this.f10114b = c2872a.f9899b;
            this.f10115c = c2872a.f9900c;
            this.f10116d = c2872a.f9901d;
        }

        public int mo1488a() {
            int b = CodedOutputStream.m16127b(1, this.f10113a);
            return ((b + CodedOutputStream.m16128b(3, C2891b.m16252a(this.f10115c))) + CodedOutputStream.m16127b(2, this.f10114b)) + CodedOutputStream.m16128b(4, C2891b.m16252a(this.f10116d));
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16149a(1, this.f10113a);
            codedOutputStream.m16149a(2, this.f10114b);
            codedOutputStream.m16150a(3, C2891b.m16252a(this.f10115c));
            codedOutputStream.m16150a(4, C2891b.m16252a(this.f10116d));
        }
    }

    private static final class C2963c extends C2960j {
        private final String f10117a;
        private final String f10118b;

        public C2963c(C2873b c2873b) {
            super(2, new C2960j[0]);
            this.f10117a = c2873b.f9902a;
            this.f10118b = c2873b.f9903b;
        }

        public int mo1488a() {
            return CodedOutputStream.m16128b(2, C2891b.m16252a(this.f10118b == null ? "" : this.f10118b)) + CodedOutputStream.m16128b(1, C2891b.m16252a(this.f10117a));
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16150a(1, C2891b.m16252a(this.f10117a));
            codedOutputStream.m16150a(2, C2891b.m16252a(this.f10118b == null ? "" : this.f10118b));
        }
    }

    private static final class C2964d extends C2960j {
        private final float f10119a;
        private final int f10120b;
        private final boolean f10121c;
        private final int f10122d;
        private final long f10123e;
        private final long f10124f;

        public C2964d(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new C2960j[0]);
            this.f10119a = f;
            this.f10120b = i;
            this.f10121c = z;
            this.f10122d = i2;
            this.f10123e = j;
            this.f10124f = j2;
        }

        public int mo1488a() {
            return (((((0 + CodedOutputStream.m16126b(1, this.f10119a)) + CodedOutputStream.m16138f(2, this.f10120b)) + CodedOutputStream.m16129b(3, this.f10121c)) + CodedOutputStream.m16133d(4, this.f10122d)) + CodedOutputStream.m16127b(5, this.f10123e)) + CodedOutputStream.m16127b(6, this.f10124f);
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16147a(1, this.f10119a);
            codedOutputStream.m16161c(2, this.f10120b);
            codedOutputStream.m16151a(3, this.f10121c);
            codedOutputStream.m16148a(4, this.f10122d);
            codedOutputStream.m16149a(5, this.f10123e);
            codedOutputStream.m16149a(6, this.f10124f);
        }
    }

    private static final class C2965e extends C2960j {
        private final long f10125a;
        private final String f10126b;

        public C2965e(long j, String str, C2960j... c2960jArr) {
            super(10, c2960jArr);
            this.f10125a = j;
            this.f10126b = str;
        }

        public int mo1488a() {
            return CodedOutputStream.m16127b(1, this.f10125a) + CodedOutputStream.m16128b(2, C2891b.m16252a(this.f10126b));
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16149a(1, this.f10125a);
            codedOutputStream.m16150a(2, C2891b.m16252a(this.f10126b));
        }
    }

    private static final class C2966f extends C2960j {
        public C2966f(C2971l c2971l, C2970k c2970k, C2970k c2970k2) {
            super(1, c2970k, c2971l, c2970k2);
        }
    }

    private static final class C2967g extends C2960j {
        private final long f10127a;
        private final String f10128b;
        private final String f10129c;
        private final long f10130d;
        private final int f10131e;

        public C2967g(C2877a c2877a) {
            super(3, new C2960j[0]);
            this.f10127a = c2877a.f9921a;
            this.f10128b = c2877a.f9922b;
            this.f10129c = c2877a.f9923c;
            this.f10130d = c2877a.f9924d;
            this.f10131e = c2877a.f9925e;
        }

        public int mo1488a() {
            return (((CodedOutputStream.m16127b(1, this.f10127a) + CodedOutputStream.m16128b(2, C2891b.m16252a(this.f10128b))) + CodedOutputStream.m16128b(3, C2891b.m16252a(this.f10129c))) + CodedOutputStream.m16127b(4, this.f10130d)) + CodedOutputStream.m16133d(5, this.f10131e);
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16149a(1, this.f10127a);
            codedOutputStream.m16150a(2, C2891b.m16252a(this.f10128b));
            codedOutputStream.m16150a(3, C2891b.m16252a(this.f10129c));
            codedOutputStream.m16149a(4, this.f10130d);
            codedOutputStream.m16148a(5, this.f10131e);
        }
    }

    private static final class C2968h extends C2960j {
        C2891b f10132a;

        public C2968h(C2891b c2891b) {
            super(6, new C2960j[0]);
            this.f10132a = c2891b;
        }

        public int mo1488a() {
            return CodedOutputStream.m16128b(1, this.f10132a);
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16150a(1, this.f10132a);
        }
    }

    private static final class C2969i extends C2960j {
        public C2969i() {
            super(0, new C2960j[0]);
        }

        public void mo1491b(CodedOutputStream codedOutputStream) {
        }

        public int mo1490b() {
            return 0;
        }
    }

    private static final class C2970k extends C2960j {
        private final C2960j[] f10133a;

        public C2970k(C2960j... c2960jArr) {
            super(0, new C2960j[0]);
            this.f10133a = c2960jArr;
        }

        public void mo1491b(CodedOutputStream codedOutputStream) {
            for (C2960j b : this.f10133a) {
                b.mo1491b(codedOutputStream);
            }
        }

        public int mo1490b() {
            int i = 0;
            C2960j[] c2960jArr = this.f10133a;
            int i2 = 0;
            while (i < c2960jArr.length) {
                i2 += c2960jArr[i].mo1490b();
                i++;
            }
            return i2;
        }
    }

    private static final class C2971l extends C2960j {
        private final String f10134a;
        private final String f10135b;
        private final long f10136c;

        public C2971l(C2876e c2876e) {
            super(3, new C2960j[0]);
            this.f10134a = c2876e.f9918a;
            this.f10135b = c2876e.f9919b;
            this.f10136c = c2876e.f9920c;
        }

        public int mo1488a() {
            return (CodedOutputStream.m16128b(1, C2891b.m16252a(this.f10134a)) + CodedOutputStream.m16128b(2, C2891b.m16252a(this.f10135b))) + CodedOutputStream.m16127b(3, this.f10136c);
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            codedOutputStream.m16150a(1, C2891b.m16252a(this.f10134a));
            codedOutputStream.m16150a(2, C2891b.m16252a(this.f10135b));
            codedOutputStream.m16149a(3, this.f10136c);
        }
    }

    private static final class C2972m extends C2960j {
        private final String f10137a;
        private final int f10138b;

        public C2972m(C2878f c2878f, C2970k c2970k) {
            super(1, c2970k);
            this.f10137a = c2878f.f9926a;
            this.f10138b = c2878f.f9927b;
        }

        public int mo1488a() {
            return (m16493d() ? CodedOutputStream.m16128b(1, C2891b.m16252a(this.f10137a)) : 0) + CodedOutputStream.m16133d(2, this.f10138b);
        }

        public void mo1489a(CodedOutputStream codedOutputStream) {
            if (m16493d()) {
                codedOutputStream.m16150a(1, C2891b.m16252a(this.f10137a));
            }
            codedOutputStream.m16148a(2, this.f10138b);
        }

        private boolean m16493d() {
            return this.f10137a != null && this.f10137a.length() > 0;
        }
    }

    private static C2965e m16496a(C2875d c2875d, C2954t c2954t, Map<String, String> map) {
        C2961a c2961a = new C2961a(new C2966f(new C2971l(c2875d.f9913b != null ? c2875d.f9913b : f10139a), C2973y.m16501a(c2875d.f9914c), C2973y.m16498a(c2875d.f9915d)), C2973y.m16499a(C2973y.m16503a(c2875d.f9916e, map)));
        C2960j a = C2973y.m16497a(c2875d.f9917f);
        C2891b a2 = c2954t.m16452a();
        if (a2 == null) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "No log data to include with this event.");
        }
        c2954t.m16457b();
        C2968h c2968h = a2 != null ? new C2968h(a2) : new C2969i();
        return new C2965e(c2875d.f9912a, "ndk-crash", c2961a, a, c2968h);
    }

    private static C2873b[] m16503a(C2873b[] c2873bArr, Map<String, String> map) {
        int i;
        Map treeMap = new TreeMap(map);
        if (c2873bArr != null) {
            for (C2873b c2873b : c2873bArr) {
                treeMap.put(c2873b.f9902a, c2873b.f9903b);
            }
        }
        Entry[] entryArr = (Entry[]) treeMap.entrySet().toArray(new Entry[treeMap.size()]);
        C2873b[] c2873bArr2 = new C2873b[entryArr.length];
        for (i = 0; i < c2873bArr2.length; i++) {
            c2873bArr2[i] = new C2873b((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return c2873bArr2;
    }

    private static C2960j m16497a(C2874c c2874c) {
        if (c2874c == null) {
            return new C2969i();
        }
        return new C2964d(((float) c2874c.f9909f) / 100.0f, c2874c.f9910g, c2874c.f9911h, c2874c.f9904a, c2874c.f9905b - c2874c.f9907d, c2874c.f9906c - c2874c.f9908e);
    }

    private static C2970k m16501a(C2878f[] c2878fArr) {
        C2960j[] c2960jArr = c2878fArr != null ? new C2972m[c2878fArr.length] : f10141c;
        for (int i = 0; i < c2960jArr.length; i++) {
            C2878f c2878f = c2878fArr[i];
            c2960jArr[i] = new C2972m(c2878f, C2973y.m16500a(c2878f.f9928c));
        }
        return new C2970k(c2960jArr);
    }

    private static C2970k m16500a(C2877a[] c2877aArr) {
        C2960j[] c2960jArr = c2877aArr != null ? new C2967g[c2877aArr.length] : f10142d;
        for (int i = 0; i < c2960jArr.length; i++) {
            c2960jArr[i] = new C2967g(c2877aArr[i]);
        }
        return new C2970k(c2960jArr);
    }

    private static C2970k m16498a(C2872a[] c2872aArr) {
        C2960j[] c2960jArr = c2872aArr != null ? new C2962b[c2872aArr.length] : f10143e;
        for (int i = 0; i < c2960jArr.length; i++) {
            c2960jArr[i] = new C2962b(c2872aArr[i]);
        }
        return new C2970k(c2960jArr);
    }

    private static C2970k m16499a(C2873b[] c2873bArr) {
        C2960j[] c2960jArr = c2873bArr != null ? new C2963c[c2873bArr.length] : f10144f;
        for (int i = 0; i < c2960jArr.length; i++) {
            c2960jArr[i] = new C2963c(c2873bArr[i]);
        }
        return new C2970k(c2960jArr);
    }

    public static void m16502a(C2875d c2875d, C2954t c2954t, Map<String, String> map, CodedOutputStream codedOutputStream) {
        C2973y.m16496a(c2875d, c2954t, map).mo1491b(codedOutputStream);
    }
}
