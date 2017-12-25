package com.bigroad.shared.p021a;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class C0835b {
    private static final C0832c<Object> f2612a = new C08331();

    static class C08331 extends C0832c<Object> {
        C08331() {
        }

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }
    }

    public static <T> C0832c<T> m4108a() {
        return f2612a;
    }

    public static <T> Iterator<T> m4110a(Iterator<? extends T> it, Iterator<? extends T> it2) {
        return C0835b.m4109a(Arrays.asList(new Iterator[]{it, it2}).iterator());
    }

    public static <T> Iterator<T> m4111a(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        return C0835b.m4109a(Arrays.asList(new Iterator[]{it, it2, it3}).iterator());
    }

    public static <T> Iterator<T> m4109a(final Iterator<? extends Iterator<? extends T>> it) {
        return new Iterator<T>() {
            Iterator<? extends T> f2609a = C0835b.m4108a();
            Iterator<? extends T> f2610b;

            public boolean hasNext() {
                boolean hasNext;
                while (true) {
                    hasNext = this.f2609a.hasNext();
                    if (hasNext || !it.hasNext()) {
                        return hasNext;
                    }
                    this.f2609a = (Iterator) it.next();
                }
                return hasNext;
            }

            public T next() {
                if (hasNext()) {
                    this.f2610b = this.f2609a;
                    return this.f2609a.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                this.f2610b.remove();
                this.f2610b = null;
            }
        };
    }
}
