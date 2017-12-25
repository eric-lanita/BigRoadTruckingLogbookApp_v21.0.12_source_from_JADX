package com.google.common.collect;

import com.google.common.primitives.C3606a;
import com.google.common.primitives.C3607b;
import com.google.common.primitives.Ints;
import java.util.Comparator;

public abstract class C3589f {
    private static final C3589f f13066a = new C35901();
    private static final C3589f f13067b = new C3591a(-1);
    private static final C3589f f13068c = new C3591a(1);

    static class C35901 extends C3589f {
        C35901() {
            super();
        }

        public C3589f mo2737a(Comparable comparable, Comparable comparable2) {
            return m18785a(comparable.compareTo(comparable2));
        }

        public <T> C3589f mo2738a(T t, T t2, Comparator<T> comparator) {
            return m18785a(comparator.compare(t, t2));
        }

        public C3589f mo2735a(int i, int i2) {
            return m18785a(Ints.m18830a(i, i2));
        }

        public C3589f mo2736a(long j, long j2) {
            return m18785a(C3607b.m18841a(j, j2));
        }

        public C3589f mo2739a(boolean z, boolean z2) {
            return m18785a(C3606a.m18840a(z2, z));
        }

        public C3589f mo2741b(boolean z, boolean z2) {
            return m18785a(C3606a.m18840a(z, z2));
        }

        C3589f m18785a(int i) {
            if (i < 0) {
                return C3589f.f13067b;
            }
            return i > 0 ? C3589f.f13068c : C3589f.f13066a;
        }

        public int mo2740b() {
            return 0;
        }
    }

    private static final class C3591a extends C3589f {
        final int f13069a;

        C3591a(int i) {
            super();
            this.f13069a = i;
        }

        public C3589f mo2737a(Comparable comparable, Comparable comparable2) {
            return this;
        }

        public <T> C3589f mo2738a(T t, T t2, Comparator<T> comparator) {
            return this;
        }

        public C3589f mo2735a(int i, int i2) {
            return this;
        }

        public C3589f mo2736a(long j, long j2) {
            return this;
        }

        public C3589f mo2739a(boolean z, boolean z2) {
            return this;
        }

        public C3589f mo2741b(boolean z, boolean z2) {
            return this;
        }

        public int mo2740b() {
            return this.f13069a;
        }
    }

    public abstract C3589f mo2735a(int i, int i2);

    public abstract C3589f mo2736a(long j, long j2);

    public abstract C3589f mo2737a(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> C3589f mo2738a(T t, T t2, Comparator<T> comparator);

    public abstract C3589f mo2739a(boolean z, boolean z2);

    public abstract int mo2740b();

    public abstract C3589f mo2741b(boolean z, boolean z2);

    private C3589f() {
    }

    public static C3589f m18773a() {
        return f13066a;
    }

    @Deprecated
    public final C3589f m18779a(Boolean bool, Boolean bool2) {
        return mo2741b(bool.booleanValue(), bool2.booleanValue());
    }
}
