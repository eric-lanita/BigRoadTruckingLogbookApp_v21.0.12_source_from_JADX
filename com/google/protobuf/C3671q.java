package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class C3671q extends AbstractList<String> implements C3650j, RandomAccess {
    private final C3650j f13286a;

    class C36702 implements Iterator<String> {
        Iterator<String> f13284a = this.f13285b.f13286a.iterator();
        final /* synthetic */ C3671q f13285b;

        C36702(C3671q c3671q) {
            this.f13285b = c3671q;
        }

        public /* synthetic */ Object next() {
            return m19242a();
        }

        public boolean hasNext() {
            return this.f13284a.hasNext();
        }

        public String m19242a() {
            return (String) this.f13284a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public /* synthetic */ Object get(int i) {
        return m19244a(i);
    }

    public C3671q(C3650j c3650j) {
        this.f13286a = c3650j;
    }

    public String m19244a(int i) {
        return (String) this.f13286a.get(i);
    }

    public int size() {
        return this.f13286a.size();
    }

    public C3642c mo2747c(int i) {
        return this.f13286a.mo2747c(i);
    }

    public void mo2746a(C3642c c3642c) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>(this) {
            ListIterator<String> f13281a = this.f13283c.f13286a.listIterator(i);
            final /* synthetic */ C3671q f13283c;

            public /* synthetic */ void add(Object obj) {
                m19241b((String) obj);
            }

            public /* synthetic */ Object next() {
                return m19238a();
            }

            public /* synthetic */ Object previous() {
                return m19240b();
            }

            public /* synthetic */ void set(Object obj) {
                m19239a((String) obj);
            }

            public boolean hasNext() {
                return this.f13281a.hasNext();
            }

            public String m19238a() {
                return (String) this.f13281a.next();
            }

            public boolean hasPrevious() {
                return this.f13281a.hasPrevious();
            }

            public String m19240b() {
                return (String) this.f13281a.previous();
            }

            public int nextIndex() {
                return this.f13281a.nextIndex();
            }

            public int previousIndex() {
                return this.f13281a.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public void m19239a(String str) {
                throw new UnsupportedOperationException();
            }

            public void m19241b(String str) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterator<String> iterator() {
        return new C36702(this);
    }

    public List<?> mo2745a() {
        return this.f13286a.mo2745a();
    }
}
