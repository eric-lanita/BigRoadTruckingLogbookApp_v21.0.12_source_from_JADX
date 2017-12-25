package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.C3606a;
import java.io.Serializable;

abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
    private static final long serialVersionUID = 0;
    final C endpoint;

    private static final class AboveAll extends Cut<Comparable<?>> {
        private static final AboveAll f12975a = new AboveAll();
        private static final long serialVersionUID = 0;

        public /* synthetic */ int compareTo(Object obj) {
            return mo2661a((Cut) obj);
        }

        private AboveAll() {
            super(null);
        }

        Comparable<?> mo2662a() {
            throw new IllegalStateException("range unbounded on this side");
        }

        boolean mo2664a(Comparable<?> comparable) {
            return false;
        }

        void mo2663a(StringBuilder stringBuilder) {
            throw new AssertionError();
        }

        void mo2665b(StringBuilder stringBuilder) {
            stringBuilder.append("+∞)");
        }

        public int mo2661a(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "+∞";
        }

        private Object readResolve() {
            return f12975a;
        }
    }

    private static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public /* synthetic */ int compareTo(Object obj) {
            return super.mo2661a((Cut) obj);
        }

        AboveValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        boolean mo2664a(C c) {
            return Range.m18693b(this.endpoint, (Comparable) c) < 0;
        }

        void mo2663a(StringBuilder stringBuilder) {
            stringBuilder.append('(').append(this.endpoint);
        }

        void mo2665b(StringBuilder stringBuilder) {
            stringBuilder.append(this.endpoint).append(']');
        }

        public int hashCode() {
            return this.endpoint.hashCode() ^ -1;
        }

        public String toString() {
            return "/" + this.endpoint + "\\";
        }
    }

    private static final class BelowAll extends Cut<Comparable<?>> {
        private static final BelowAll f12976a = new BelowAll();
        private static final long serialVersionUID = 0;

        public /* synthetic */ int compareTo(Object obj) {
            return mo2661a((Cut) obj);
        }

        private BelowAll() {
            super(null);
        }

        Comparable<?> mo2662a() {
            throw new IllegalStateException("range unbounded on this side");
        }

        boolean mo2664a(Comparable<?> comparable) {
            return true;
        }

        void mo2663a(StringBuilder stringBuilder) {
            stringBuilder.append("(-∞");
        }

        void mo2665b(StringBuilder stringBuilder) {
            throw new AssertionError();
        }

        public int mo2661a(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        public int hashCode() {
            return System.identityHashCode(this);
        }

        public String toString() {
            return "-∞";
        }

        private Object readResolve() {
            return f12976a;
        }
    }

    private static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public /* synthetic */ int compareTo(Object obj) {
            return super.mo2661a((Cut) obj);
        }

        BelowValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        boolean mo2664a(C c) {
            return Range.m18693b(this.endpoint, (Comparable) c) <= 0;
        }

        void mo2663a(StringBuilder stringBuilder) {
            stringBuilder.append('[').append(this.endpoint);
        }

        void mo2665b(StringBuilder stringBuilder) {
            stringBuilder.append(this.endpoint).append(')');
        }

        public int hashCode() {
            return this.endpoint.hashCode();
        }

        public String toString() {
            return "\\" + this.endpoint + "/";
        }
    }

    abstract void mo2663a(StringBuilder stringBuilder);

    abstract boolean mo2664a(C c);

    abstract void mo2665b(StringBuilder stringBuilder);

    public abstract int hashCode();

    public /* synthetic */ int compareTo(Object obj) {
        return mo2661a((Cut) obj);
    }

    Cut(C c) {
        this.endpoint = c;
    }

    public int mo2661a(Cut<C> cut) {
        if (cut == m18454b()) {
            return 1;
        }
        if (cut == m18456c()) {
            return -1;
        }
        int b = Range.m18693b(this.endpoint, cut.endpoint);
        return b == 0 ? C3606a.m18840a(this instanceof AboveValue, cut instanceof AboveValue) : b;
    }

    C mo2662a() {
        return this.endpoint;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            if (mo2661a((Cut) obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }

    static <C extends Comparable> Cut<C> m18454b() {
        return BelowAll.f12976a;
    }

    static <C extends Comparable> Cut<C> m18456c() {
        return AboveAll.f12975a;
    }

    static <C extends Comparable> Cut<C> m18455b(C c) {
        return new BelowValue(c);
    }

    static <C extends Comparable> Cut<C> m18457c(C c) {
        return new AboveValue(c);
    }
}
