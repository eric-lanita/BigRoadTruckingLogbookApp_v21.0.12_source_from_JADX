package com.google.protobuf;

import com.google.protobuf.C2487l.C2482a;
import com.google.protobuf.C3642c.C3641b;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

public abstract class C2488a implements C2487l {

    public static abstract class C2483a<BuilderType extends C2483a> implements C2482a {

        static final class C3638a extends FilterInputStream {
            private int f13207a;

            C3638a(InputStream inputStream, int i) {
                super(inputStream);
                this.f13207a = i;
            }

            public int available() {
                return Math.min(super.available(), this.f13207a);
            }

            public int read() {
                if (this.f13207a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read < 0) {
                    return read;
                }
                this.f13207a--;
                return read;
            }

            public int read(byte[] bArr, int i, int i2) {
                if (this.f13207a <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, this.f13207a));
                if (read < 0) {
                    return read;
                }
                this.f13207a -= read;
                return read;
            }

            public long skip(long j) {
                long skip = super.skip(Math.min(j, (long) this.f13207a));
                if (skip >= 0) {
                    this.f13207a = (int) (((long) this.f13207a) - skip);
                }
                return skip;
            }
        }

        public abstract BuilderType mo1363b(C3643d c3643d, C3645e c3645e);

        public abstract BuilderType mo1362h();

        public /* synthetic */ C2482a mo1359b(byte[] bArr) {
            return m12285a(bArr);
        }

        public /* synthetic */ C2482a mo1360c(C3643d c3643d, C3645e c3645e) {
            return mo1363b(c3643d, c3645e);
        }

        public /* synthetic */ Object clone() {
            return mo1362h();
        }

        public BuilderType m12284a(C3643d c3643d) {
            return mo1363b(c3643d, C3645e.m19140a());
        }

        public BuilderType m12285a(byte[] bArr) {
            return m12286a(bArr, 0, bArr.length);
        }

        public BuilderType m12286a(byte[] bArr, int i, int i2) {
            try {
                C3643d a = C3643d.m19102a(bArr, i, i2);
                m12284a(a);
                a.m19108a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (Throwable e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        protected static UninitializedMessageException m12281a(C2487l c2487l) {
            return new UninitializedMessageException(c2487l);
        }

        protected static <T> void m12283a(Iterable<T> iterable, Collection<? super T> collection) {
            if (iterable instanceof C3650j) {
                C2483a.mo1377a(((C3650j) iterable).mo2745a());
            } else {
                C2483a.mo1377a((Iterable) iterable);
            }
            if (iterable instanceof Collection) {
                collection.addAll((Collection) iterable);
                return;
            }
            for (T add : iterable) {
                collection.add(add);
            }
        }

        private static void mo1377a(Iterable<?> iterable) {
            for (Object obj : iterable) {
                if (obj == null) {
                    throw new NullPointerException();
                }
            }
        }
    }

    public C3642c toByteString() {
        try {
            C3641b b = C3642c.m19080b(getSerializedSize());
            writeTo(b.m19076b());
            return b.m19075a();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream a = CodedOutputStream.m18986a(bArr);
            writeTo(a);
            a.m19028c();
            return bArr;
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public void writeTo(OutputStream outputStream) {
        CodedOutputStream a = CodedOutputStream.m18985a(outputStream, CodedOutputStream.m18984a(getSerializedSize()));
        writeTo(a);
        a.m19011a();
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        CodedOutputStream a = CodedOutputStream.m18985a(outputStream, CodedOutputStream.m18984a(CodedOutputStream.m19009m(serializedSize) + serializedSize));
        a.m19038l(serializedSize);
        writeTo(a);
        a.m19011a();
    }

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }
}
