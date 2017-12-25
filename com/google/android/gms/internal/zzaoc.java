package com.google.android.gms.internal;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class zzaoc extends zzaom {
    private static final Reader f11280a = new C32911();
    private static final Object f11281b = new Object();
    private final List<Object> f11282c = new ArrayList();

    static class C32911 extends Reader {
        C32911() {
        }

        public void close() {
            throw new AssertionError();
        }

        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public zzaoc(zzamv com_google_android_gms_internal_zzamv) {
        super(f11280a);
        this.f11282c.add(com_google_android_gms_internal_zzamv);
    }

    private Object m17257a() {
        return this.f11282c.get(this.f11282c.size() - 1);
    }

    private void m17258a(zzaon com_google_android_gms_internal_zzaon) {
        if (mo1835b() != com_google_android_gms_internal_zzaon) {
            String valueOf = String.valueOf(com_google_android_gms_internal_zzaon);
            String valueOf2 = String.valueOf(mo1835b());
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
        }
    }

    private Object m17259c() {
        return this.f11282c.remove(this.f11282c.size() - 1);
    }

    public zzaon mo1835b() {
        if (this.f11282c.isEmpty()) {
            return zzaon.END_DOCUMENT;
        }
        Object a = m17257a();
        if (a instanceof Iterator) {
            boolean z = this.f11282c.get(this.f11282c.size() - 2) instanceof zzamy;
            Iterator it = (Iterator) a;
            if (!it.hasNext()) {
                return z ? zzaon.END_OBJECT : zzaon.END_ARRAY;
            } else {
                if (z) {
                    return zzaon.NAME;
                }
                this.f11282c.add(it.next());
                return mo1835b();
            }
        } else if (a instanceof zzamy) {
            return zzaon.BEGIN_OBJECT;
        } else {
            if (a instanceof zzams) {
                return zzaon.BEGIN_ARRAY;
            }
            if (a instanceof zzanb) {
                zzanb com_google_android_gms_internal_zzanb = (zzanb) a;
                if (com_google_android_gms_internal_zzanb.zzczq()) {
                    return zzaon.STRING;
                }
                if (com_google_android_gms_internal_zzanb.zzczo()) {
                    return zzaon.BOOLEAN;
                }
                if (com_google_android_gms_internal_zzanb.zzczp()) {
                    return zzaon.NUMBER;
                }
                throw new AssertionError();
            } else if (a instanceof zzamx) {
                return zzaon.NULL;
            } else {
                if (a == f11281b) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public void beginArray() {
        m17258a(zzaon.BEGIN_ARRAY);
        this.f11282c.add(((zzams) m17257a()).iterator());
    }

    public void beginObject() {
        m17258a(zzaon.BEGIN_OBJECT);
        this.f11282c.add(((zzamy) m17257a()).entrySet().iterator());
    }

    public void close() {
        this.f11282c.clear();
        this.f11282c.add(f11281b);
    }

    public void mo1839e() {
        m17258a(zzaon.NAME);
        Entry entry = (Entry) ((Iterator) m17257a()).next();
        this.f11282c.add(entry.getValue());
        this.f11282c.add(new zzanb((String) entry.getKey()));
    }

    public void endArray() {
        m17258a(zzaon.END_ARRAY);
        m17259c();
        m17259c();
    }

    public void endObject() {
        m17258a(zzaon.END_OBJECT);
        m17259c();
        m17259c();
    }

    public boolean hasNext() {
        zzaon b = mo1835b();
        return (b == zzaon.END_OBJECT || b == zzaon.END_ARRAY) ? false : true;
    }

    public boolean nextBoolean() {
        m17258a(zzaon.BOOLEAN);
        return ((zzanb) m17259c()).getAsBoolean();
    }

    public double nextDouble() {
        zzaon b = mo1835b();
        if (b == zzaon.NUMBER || b == zzaon.STRING) {
            double asDouble = ((zzanb) m17257a()).getAsDouble();
            if (isLenient() || !(Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
                m17259c();
                return asDouble;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        String valueOf = String.valueOf(zzaon.NUMBER);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public int nextInt() {
        zzaon b = mo1835b();
        if (b == zzaon.NUMBER || b == zzaon.STRING) {
            int asInt = ((zzanb) m17257a()).getAsInt();
            m17259c();
            return asInt;
        }
        String valueOf = String.valueOf(zzaon.NUMBER);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public long nextLong() {
        zzaon b = mo1835b();
        if (b == zzaon.NUMBER || b == zzaon.STRING) {
            long asLong = ((zzanb) m17257a()).getAsLong();
            m17259c();
            return asLong;
        }
        String valueOf = String.valueOf(zzaon.NUMBER);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public String nextName() {
        m17258a(zzaon.NAME);
        Entry entry = (Entry) ((Iterator) m17257a()).next();
        this.f11282c.add(entry.getValue());
        return (String) entry.getKey();
    }

    public void nextNull() {
        m17258a(zzaon.NULL);
        m17259c();
    }

    public String nextString() {
        zzaon b = mo1835b();
        if (b == zzaon.STRING || b == zzaon.NUMBER) {
            return ((zzanb) m17259c()).zzczf();
        }
        String valueOf = String.valueOf(zzaon.STRING);
        String valueOf2 = String.valueOf(b);
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append("Expected ").append(valueOf).append(" but was ").append(valueOf2).toString());
    }

    public void skipValue() {
        if (mo1835b() == zzaon.NAME) {
            nextName();
        } else {
            m17259c();
        }
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
