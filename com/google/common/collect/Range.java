package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Function<Range, Cut> f13033a = new C35781();
    private static final Function<Range, Cut> f13034b = new C35792();
    private static final Range<Comparable> f13035c = new Range(Cut.m18454b(), Cut.m18456c());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    static class C35781 implements Function<Range, Cut> {
        C35781() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m18687a((Range) obj);
        }

        public Cut m18687a(Range range) {
            return range.lowerBound;
        }
    }

    static class C35792 implements Function<Range, Cut> {
        C35792() {
        }

        public /* synthetic */ Object apply(Object obj) {
            return m18688a((Range) obj);
        }

        public Cut m18688a(Range range) {
            return range.upperBound;
        }
    }

    @Deprecated
    public /* synthetic */ boolean apply(Object obj) {
        return m18697b((Comparable) obj);
    }

    static <C extends Comparable<?>> Range<C> m18690a(Cut<C> cut, Cut<C> cut2) {
        return new Range(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> m18692a(C c, C c2) {
        return m18690a(Cut.m18455b((Comparable) c), Cut.m18457c(c2));
    }

    public static <C extends Comparable<?>> Range<C> m18691a(C c, BoundType boundType, C c2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return m18690a(boundType == BoundType.OPEN ? Cut.m18457c(c) : Cut.m18455b((Comparable) c), boundType2 == BoundType.OPEN ? Cut.m18455b((Comparable) c2) : Cut.m18457c(c2));
    }

    public static <C extends Comparable<?>> Range<C> m18689a() {
        return f13035c;
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(cut);
        this.upperBound = (Cut) Preconditions.checkNotNull(cut2);
        if (cut.mo2661a((Cut) cut2) > 0 || cut == Cut.m18456c() || cut2 == Cut.m18454b()) {
            throw new IllegalArgumentException("Invalid range: " + m18694b((Cut) cut, (Cut) cut2));
        }
    }

    public boolean m18696b() {
        return this.lowerBound != Cut.m18454b();
    }

    public C m18698c() {
        return this.lowerBound.mo2662a();
    }

    public boolean m18699d() {
        return this.upperBound != Cut.m18456c();
    }

    public C m18700e() {
        return this.upperBound.mo2662a();
    }

    public boolean m18695a(C c) {
        Preconditions.checkNotNull(c);
        return this.lowerBound.mo2664a((Comparable) c) && !this.upperBound.mo2664a((Comparable) c);
    }

    @Deprecated
    public boolean m18697b(C c) {
        return m18695a(c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public String toString() {
        return m18694b(this.lowerBound, this.upperBound);
    }

    private static String m18694b(Cut<?> cut, Cut<?> cut2) {
        StringBuilder stringBuilder = new StringBuilder(16);
        cut.mo2663a(stringBuilder);
        stringBuilder.append("..");
        cut2.mo2665b(stringBuilder);
        return stringBuilder.toString();
    }

    Object readResolve() {
        if (equals(f13035c)) {
            return m18689a();
        }
        return this;
    }

    static int m18693b(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}
