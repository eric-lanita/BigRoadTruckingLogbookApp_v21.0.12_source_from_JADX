package com.google.android.gms.internal;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class zzaoo implements Closeable, Flushable {
    private static final String[] f11283a = new String[128];
    private static final String[] f11284b = ((String[]) f11283a.clone());
    private final Writer f11285c;
    private int[] f11286d = new int[32];
    private int f11287e = 0;
    private String f11288f;
    private String f11289g;
    private boolean f11290h;
    private boolean f11291i;
    private String f11292j;
    private boolean f11293k;

    static {
        for (int i = 0; i <= 31; i++) {
            f11283a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f11283a[34] = "\\\"";
        f11283a[92] = "\\\\";
        f11283a[9] = "\\t";
        f11283a[8] = "\\b";
        f11283a[10] = "\\n";
        f11283a[13] = "\\r";
        f11283a[12] = "\\f";
        f11284b[60] = "\\u003c";
        f11284b[62] = "\\u003e";
        f11284b[38] = "\\u0026";
        f11284b[61] = "\\u003d";
        f11284b[39] = "\\u0027";
    }

    public zzaoo(Writer writer) {
        m17265a(6);
        this.f11289g = ":";
        this.f11293k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f11285c = writer;
    }

    private int m17262a() {
        if (this.f11287e != 0) {
            return this.f11286d[this.f11287e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private zzaoo m17263a(int i, int i2, String str) {
        int a = m17262a();
        if (a != i2 && a != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f11292j != null) {
            String str2 = "Dangling name: ";
            String valueOf = String.valueOf(this.f11292j);
            throw new IllegalStateException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else {
            this.f11287e--;
            if (a == i2) {
                m17270c();
            }
            this.f11285c.write(str);
            return this;
        }
    }

    private zzaoo m17264a(int i, String str) {
        m17267a(true);
        m17265a(i);
        this.f11285c.write(str);
        return this;
    }

    private void m17265a(int i) {
        if (this.f11287e == this.f11286d.length) {
            Object obj = new int[(this.f11287e * 2)];
            System.arraycopy(this.f11286d, 0, obj, 0, this.f11287e);
            this.f11286d = obj;
        }
        int[] iArr = this.f11286d;
        int i2 = this.f11287e;
        this.f11287e = i2 + 1;
        iArr[i2] = i;
    }

    private void m17266a(String str) {
        int i = 0;
        String[] strArr = this.f11291i ? f11284b : f11283a;
        this.f11285c.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            String str2;
            if (charAt < '') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
                if (i < i2) {
                    this.f11285c.write(str, i, i2 - i);
                }
                this.f11285c.write(str2);
                i = i2 + 1;
            } else {
                if (charAt == ' ') {
                    str2 = "\\u2028";
                } else if (charAt == ' ') {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                    this.f11285c.write(str, i, i2 - i);
                }
                this.f11285c.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f11285c.write(str, i, length - i);
        }
        this.f11285c.write("\"");
    }

    private void m17267a(boolean z) {
        switch (m17262a()) {
            case 1:
                m17269b(2);
                m17270c();
                return;
            case 2:
                this.f11285c.append(',');
                m17270c();
                return;
            case 4:
                this.f11285c.append(this.f11289g);
                m17269b(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.f11290h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.f11290h || z) {
            m17269b(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    private void m17268b() {
        if (this.f11292j != null) {
            m17271d();
            m17266a(this.f11292j);
            this.f11292j = null;
        }
    }

    private void m17269b(int i) {
        this.f11286d[this.f11287e - 1] = i;
    }

    private void m17270c() {
        if (this.f11288f != null) {
            this.f11285c.write("\n");
            int i = this.f11287e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f11285c.write(this.f11288f);
            }
        }
    }

    private void m17271d() {
        int a = m17262a();
        if (a == 5) {
            this.f11285c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m17270c();
        m17269b(4);
    }

    public void close() {
        this.f11285c.close();
        int i = this.f11287e;
        if (i > 1 || (i == 1 && this.f11286d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f11287e = 0;
    }

    public void flush() {
        if (this.f11287e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f11285c.flush();
    }

    public zzaoo mo1854h() {
        m17268b();
        return m17264a(1, "[");
    }

    public zzaoo mo1855i() {
        return m17263a(1, 2, "]");
    }

    public boolean isLenient() {
        return this.f11290h;
    }

    public zzaoo mo1856j() {
        m17268b();
        return m17264a(3, "{");
    }

    public zzaoo mo1857k() {
        return m17263a(3, 5, "}");
    }

    public zzaoo mo1858l() {
        if (this.f11292j != null) {
            if (this.f11293k) {
                m17268b();
            } else {
                this.f11292j = null;
                return this;
            }
        }
        m17267a(false);
        this.f11285c.write("null");
        return this;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.f11288f = null;
            this.f11289g = ":";
            return;
        }
        this.f11288f = str;
        this.f11289g = ": ";
    }

    public final void setLenient(boolean z) {
        this.f11290h = z;
    }

    public final boolean m17277x() {
        return this.f11291i;
    }

    public final boolean m17278y() {
        return this.f11293k;
    }

    public zzaoo zza(Number number) {
        if (number == null) {
            return mo1858l();
        }
        m17268b();
        CharSequence obj = number.toString();
        if (this.f11290h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            m17267a(false);
            this.f11285c.append(obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39).append("Numeric values must be finite, but was ").append(valueOf).toString());
    }

    public zzaoo zzcr(long j) {
        m17268b();
        m17267a(false);
        this.f11285c.write(Long.toString(j));
        return this;
    }

    public zzaoo zzda(boolean z) {
        m17268b();
        m17267a(false);
        this.f11285c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    public final void zzdc(boolean z) {
        this.f11291i = z;
    }

    public final void zzdd(boolean z) {
        this.f11293k = z;
    }

    public zzaoo zztr(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f11292j != null) {
            throw new IllegalStateException();
        } else if (this.f11287e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.f11292j = str;
            return this;
        }
    }

    public zzaoo zzts(String str) {
        if (str == null) {
            return mo1858l();
        }
        m17268b();
        m17267a(false);
        m17266a(str);
        return this;
    }
}
