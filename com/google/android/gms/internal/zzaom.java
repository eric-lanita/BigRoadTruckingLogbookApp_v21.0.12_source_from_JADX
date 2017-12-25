package com.google.android.gms.internal;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzaom implements Closeable {
    private static final char[] f11264a = ")]}'\n".toCharArray();
    private final Reader f11265b;
    private boolean f11266c = false;
    private final char[] f11267d = new char[1024];
    private int f11268e = 0;
    private int f11269f = 0;
    private int f11270g = 0;
    private int f11271h = 0;
    private int f11272i = 0;
    private long f11273j;
    private int f11274k;
    private String f11275l;
    private int[] f11276m = new int[32];
    private int f11277n = 0;
    private String[] f11278o;
    private int[] f11279p;

    static class C33081 extends zzanr {
        C33081() {
        }

        public void zzi(zzaom com_google_android_gms_internal_zzaom) {
            if (com_google_android_gms_internal_zzaom instanceof zzaoc) {
                ((zzaoc) com_google_android_gms_internal_zzaom).mo1839e();
                return;
            }
            int a = com_google_android_gms_internal_zzaom.f11272i;
            if (a == 0) {
                a = com_google_android_gms_internal_zzaom.m17232a();
            }
            if (a == 13) {
                com_google_android_gms_internal_zzaom.f11272i = 9;
            } else if (a == 12) {
                com_google_android_gms_internal_zzaom.f11272i = 8;
            } else if (a == 14) {
                com_google_android_gms_internal_zzaom.f11272i = 10;
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzaom.mo1835b());
                int c = com_google_android_gms_internal_zzaom.m17250g();
                int d = com_google_android_gms_internal_zzaom.m17251h();
                String path = com_google_android_gms_internal_zzaom.getPath();
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(c).append(" column ").append(d).append(" path ").append(path).toString());
            }
        }
    }

    static {
        zzanr.beV = new C33081();
    }

    public zzaom(Reader reader) {
        int[] iArr = this.f11276m;
        int i = this.f11277n;
        this.f11277n = i + 1;
        iArr[i] = 6;
        this.f11278o = new String[32];
        this.f11279p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f11265b = reader;
    }

    private int m17232a() {
        int a;
        int i = this.f11276m[this.f11277n - 1];
        if (i == 1) {
            this.f11276m[this.f11277n - 1] = 2;
        } else if (i == 2) {
            switch (m17235a(true)) {
                case 44:
                    break;
                case 59:
                    m17252i();
                    break;
                case 93:
                    this.f11272i = 4;
                    return 4;
                default:
                    throw m17240b("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.f11276m[this.f11277n - 1] = 4;
            if (i == 5) {
                switch (m17235a(true)) {
                    case 44:
                        break;
                    case 59:
                        m17252i();
                        break;
                    case 125:
                        this.f11272i = 2;
                        return 2;
                    default:
                        throw m17240b("Unterminated object");
                }
            }
            a = m17235a(true);
            switch (a) {
                case 34:
                    this.f11272i = 13;
                    return 13;
                case 39:
                    m17252i();
                    this.f11272i = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.f11272i = 2;
                        return 2;
                    }
                    throw m17240b("Expected name");
                default:
                    m17252i();
                    this.f11268e--;
                    if (m17237a((char) a)) {
                        this.f11272i = 14;
                        return 14;
                    }
                    throw m17240b("Expected name");
            }
        } else if (i == 4) {
            this.f11276m[this.f11277n - 1] = 5;
            switch (m17235a(true)) {
                case 58:
                    break;
                case 61:
                    m17252i();
                    if ((this.f11268e < this.f11269f || m17242b(1)) && this.f11267d[this.f11268e] == '>') {
                        this.f11268e++;
                        break;
                    }
                default:
                    throw m17240b("Expected ':'");
            }
        } else if (i == 6) {
            if (this.f11266c) {
                m17255l();
            }
            this.f11276m[this.f11277n - 1] = 7;
        } else if (i == 7) {
            if (m17235a(false) == -1) {
                this.f11272i = 17;
                return 17;
            }
            m17252i();
            this.f11268e--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (m17235a(true)) {
            case 34:
                if (this.f11277n == 1) {
                    m17252i();
                }
                this.f11272i = 9;
                return 9;
            case 39:
                m17252i();
                this.f11272i = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.f11272i = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.f11272i = 4;
                    return 4;
                }
                break;
            case 123:
                this.f11272i = 1;
                return 1;
            default:
                this.f11268e--;
                if (this.f11277n == 1) {
                    m17252i();
                }
                a = m17243c();
                if (a != 0) {
                    return a;
                }
                a = m17246d();
                if (a != 0) {
                    return a;
                }
                if (m17237a(this.f11267d[this.f11268e])) {
                    m17252i();
                    this.f11272i = 10;
                    return 10;
                }
                throw m17240b("Expected value");
        }
        if (i == 1 || i == 2) {
            m17252i();
            this.f11268e--;
            this.f11272i = 7;
            return 7;
        }
        throw m17240b("Unexpected value");
    }

    private int m17235a(boolean z) {
        char[] cArr = this.f11267d;
        int i = this.f11268e;
        int i2 = this.f11269f;
        while (true) {
            int g;
            if (i == i2) {
                this.f11268e = i;
                if (m17242b(1)) {
                    i = this.f11268e;
                    i2 = this.f11269f;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    g = m17250g();
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(g).append(" column ").append(m17251h()).toString());
                }
            }
            g = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f11270g++;
                this.f11271h = g;
                i = g;
            } else if (c == ' ' || c == '\r') {
                i = g;
            } else if (c == '\t') {
                i = g;
            } else if (c == '/') {
                this.f11268e = g;
                if (g == i2) {
                    this.f11268e--;
                    boolean b = m17242b(2);
                    this.f11268e++;
                    if (!b) {
                        return c;
                    }
                }
                m17252i();
                switch (cArr[this.f11268e]) {
                    case '*':
                        this.f11268e++;
                        if (m17238a("*/")) {
                            i = this.f11268e + 2;
                            i2 = this.f11269f;
                            break;
                        }
                        throw m17240b("Unterminated comment");
                    case '/':
                        this.f11268e++;
                        m17253j();
                        i = this.f11268e;
                        i2 = this.f11269f;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.f11268e = g;
                m17252i();
                m17253j();
                i = this.f11268e;
                i2 = this.f11269f;
            } else {
                this.f11268e = g;
                return c;
            }
        }
    }

    private void m17236a(int i) {
        if (this.f11277n == this.f11276m.length) {
            Object obj = new int[(this.f11277n * 2)];
            Object obj2 = new int[(this.f11277n * 2)];
            Object obj3 = new String[(this.f11277n * 2)];
            System.arraycopy(this.f11276m, 0, obj, 0, this.f11277n);
            System.arraycopy(this.f11279p, 0, obj2, 0, this.f11277n);
            System.arraycopy(this.f11278o, 0, obj3, 0, this.f11277n);
            this.f11276m = obj;
            this.f11279p = obj2;
            this.f11278o = obj3;
        }
        int[] iArr = this.f11276m;
        int i2 = this.f11277n;
        this.f11277n = i2 + 1;
        iArr[i2] = i;
    }

    private boolean m17237a(char c) {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m17252i();
                break;
            default:
                return true;
        }
        return false;
    }

    private boolean m17238a(String str) {
        while (true) {
            if (this.f11268e + str.length() > this.f11269f && !m17242b(str.length())) {
                return false;
            }
            if (this.f11267d[this.f11268e] == '\n') {
                this.f11270g++;
                this.f11271h = this.f11268e + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.f11267d[this.f11268e + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.f11268e++;
        }
    }

    private IOException m17240b(String str) {
        int g = m17250g();
        int h = m17251h();
        String path = getPath();
        throw new zzaop(new StringBuilder((String.valueOf(str).length() + 45) + String.valueOf(path).length()).append(str).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    private String m17241b(char c) {
        char[] cArr = this.f11267d;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.f11268e;
            int i2 = this.f11269f;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f11268e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.f11268e = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(m17254k());
                    i = this.f11268e;
                    i2 = this.f11269f;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.f11270g++;
                    this.f11271h = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.f11268e = i3;
        } while (m17242b(1));
        throw m17240b("Unterminated string");
    }

    private boolean m17242b(int i) {
        Object obj = this.f11267d;
        this.f11271h -= this.f11268e;
        if (this.f11269f != this.f11268e) {
            this.f11269f -= this.f11268e;
            System.arraycopy(obj, this.f11268e, obj, 0, this.f11269f);
        } else {
            this.f11269f = 0;
        }
        this.f11268e = 0;
        do {
            int read = this.f11265b.read(obj, this.f11269f, obj.length - this.f11269f);
            if (read == -1) {
                return false;
            }
            this.f11269f = read + this.f11269f;
            if (this.f11270g == 0 && this.f11271h == 0 && this.f11269f > 0 && obj[0] == '﻿') {
                this.f11268e++;
                this.f11271h++;
                i++;
            }
        } while (this.f11269f < i);
        return true;
    }

    private int m17243c() {
        String str;
        int i;
        char c = this.f11267d[this.f11268e];
        String str2;
        if (c == 't' || c == 'T') {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.f11268e + i2 >= this.f11269f && !m17242b(i2 + 1)) {
                return 0;
            }
            char c2 = this.f11267d[this.f11268e + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.f11268e + length < this.f11269f || m17242b(length + 1)) && m17237a(this.f11267d[this.f11268e + length])) {
            return 0;
        }
        this.f11268e += length;
        this.f11272i = i;
        return i;
    }

    private void m17245c(char c) {
        char[] cArr = this.f11267d;
        do {
            int i = this.f11268e;
            int i2 = this.f11269f;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.f11268e = i;
                    return;
                }
                if (c2 == '\\') {
                    this.f11268e = i;
                    m17254k();
                    i = this.f11268e;
                    i2 = this.f11269f;
                } else if (c2 == '\n') {
                    this.f11270g++;
                    this.f11271h = i;
                }
                i3 = i;
            }
            this.f11268e = i3;
        } while (m17242b(1));
        throw m17240b("Unterminated string");
    }

    private int m17246d() {
        char[] cArr = this.f11267d;
        int i = this.f11268e;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f11269f;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (m17242b(i4 + 1)) {
                    i6 = this.f11268e;
                    i5 = this.f11269f;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.f11273j = j;
                    this.f11268e += i4;
                    this.f11272i = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.f11274k = i4;
                    this.f11272i = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case '+':
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case '-':
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case 'E':
                case 'e':
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (m17237a(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.f11274k = i4;
            this.f11272i = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private String mo1839e() {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.f11268e + i < this.f11269f) {
                switch (this.f11267d[this.f11268e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m17252i();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.f11267d.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.f11267d, this.f11268e, i);
                this.f11268e = i + this.f11268e;
                i = !m17242b(1) ? 0 : 0;
            } else if (m17242b(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.f11267d, this.f11268e, i);
            } else {
                stringBuilder.append(this.f11267d, this.f11268e, i);
                str = stringBuilder.toString();
            }
            this.f11268e = i + this.f11268e;
            return str;
        }
    }

    private void m17249f() {
        do {
            int i = 0;
            while (this.f11268e + i < this.f11269f) {
                switch (this.f11267d[this.f11268e + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m17252i();
                        break;
                    default:
                        i++;
                }
                this.f11268e = i + this.f11268e;
                return;
            }
            this.f11268e = i + this.f11268e;
        } while (m17242b(1));
    }

    private int m17250g() {
        return this.f11270g + 1;
    }

    private int m17251h() {
        return (this.f11268e - this.f11271h) + 1;
    }

    private void m17252i() {
        if (!this.f11266c) {
            throw m17240b("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void m17253j() {
        char c;
        do {
            if (this.f11268e < this.f11269f || m17242b(1)) {
                char[] cArr = this.f11267d;
                int i = this.f11268e;
                this.f11268e = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.f11270g++;
                    this.f11271h = this.f11268e;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private char m17254k() {
        if (this.f11268e != this.f11269f || m17242b(1)) {
            char[] cArr = this.f11267d;
            int i = this.f11268e;
            this.f11268e = i + 1;
            char c = cArr[i];
            switch (c) {
                case '\n':
                    this.f11270g++;
                    this.f11271h = this.f11268e;
                    return c;
                case 'b':
                    return '\b';
                case 'f':
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.f11268e + 4 <= this.f11269f || m17242b(4)) {
                        int i2 = this.f11268e;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.f11267d[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                String str = "\\u";
                                String valueOf = String.valueOf(new String(this.f11267d, this.f11268e, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.f11268e += 4;
                        return c;
                    }
                    throw m17240b("Unterminated escape sequence");
                default:
                    return c;
            }
        }
        throw m17240b("Unterminated escape sequence");
    }

    private void m17255l() {
        m17235a(true);
        this.f11268e--;
        if (this.f11268e + f11264a.length <= this.f11269f || m17242b(f11264a.length)) {
            int i = 0;
            while (i < f11264a.length) {
                if (this.f11267d[this.f11268e + i] == f11264a[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.f11268e += f11264a.length;
        }
    }

    public zzaon mo1835b() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        switch (i) {
            case 1:
                return zzaon.BEGIN_OBJECT;
            case 2:
                return zzaon.END_OBJECT;
            case 3:
                return zzaon.BEGIN_ARRAY;
            case 4:
                return zzaon.END_ARRAY;
            case 5:
            case 6:
                return zzaon.BOOLEAN;
            case 7:
                return zzaon.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzaon.STRING;
            case 12:
            case 13:
            case 14:
                return zzaon.NAME;
            case 15:
            case 16:
                return zzaon.NUMBER;
            case 17:
                return zzaon.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void beginArray() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 3) {
            m17236a(1);
            this.f11279p[this.f11277n - 1] = 0;
            this.f11272i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1835b());
        int g = m17250g();
        int h = m17251h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 74) + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public void beginObject() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 1) {
            m17236a(3);
            this.f11272i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1835b());
        int g = m17250g();
        int h = m17251h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 75) + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public void close() {
        this.f11272i = 0;
        this.f11276m[0] = 8;
        this.f11277n = 1;
        this.f11265b.close();
    }

    public void endArray() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 4) {
            this.f11277n--;
            int[] iArr = this.f11279p;
            int i2 = this.f11277n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f11272i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1835b());
        int g = m17250g();
        int h = m17251h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public void endObject() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 2) {
            this.f11277n--;
            this.f11278o[this.f11277n] = null;
            int[] iArr = this.f11279p;
            int i2 = this.f11277n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.f11272i = 0;
            return;
        }
        String valueOf = String.valueOf(mo1835b());
        int g = m17250g();
        int h = m17251h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 73) + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.f11277n;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.f11276m[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.f11279p[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.f11278o[i2] == null) {
                        break;
                    }
                    append.append(this.f11278o[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    public boolean hasNext() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.f11266c;
    }

    public boolean nextBoolean() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 5) {
            this.f11272i = 0;
            int[] iArr = this.f11279p;
            i = this.f11277n - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.f11272i = 0;
            int[] iArr2 = this.f11279p;
            r2 = this.f11277n - 1;
            iArr2[r2] = iArr2[r2] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(mo1835b());
            r2 = m17250g();
            int h = m17251h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 72) + String.valueOf(path).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(r2).append(" column ").append(h).append(" path ").append(path).toString());
        }
    }

    public double nextDouble() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 15) {
            this.f11272i = 0;
            int[] iArr = this.f11279p;
            int i2 = this.f11277n - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.f11273j;
        }
        if (i == 16) {
            this.f11275l = new String(this.f11267d, this.f11268e, this.f11274k);
            this.f11268e += this.f11274k;
        } else if (i == 8 || i == 9) {
            this.f11275l = m17241b(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.f11275l = mo1839e();
        } else if (i != 11) {
            String valueOf = String.valueOf(mo1835b());
            int g = m17250g();
            int h = m17251h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(path).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
        this.f11272i = 11;
        double parseDouble = Double.parseDouble(this.f11275l);
        if (this.f11266c || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.f11275l = null;
            this.f11272i = 0;
            int[] iArr2 = this.f11279p;
            h = this.f11277n - 1;
            iArr2[h] = iArr2[h] + 1;
            return parseDouble;
        }
        h = m17250g();
        int h2 = m17251h();
        String path2 = getPath();
        throw new zzaop(new StringBuilder(String.valueOf(path2).length() + 102).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(h).append(" column ").append(h2).append(" path ").append(path2).toString());
    }

    public int nextInt() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.f11273j;
            if (this.f11273j != ((long) i)) {
                long j = this.f11273j;
                int g = m17250g();
                int h = m17251h();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
            }
            this.f11272i = 0;
            iArr = this.f11279p;
            i2 = this.f11277n - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            String valueOf;
            int h2;
            String path2;
            if (i == 16) {
                this.f11275l = new String(this.f11267d, this.f11268e, this.f11274k);
                this.f11268e += this.f11274k;
            } else if (i == 8 || i == 9) {
                this.f11275l = m17241b(i == 8 ? '\'' : '\"');
                try {
                    i = Integer.parseInt(this.f11275l);
                    this.f11272i = 0;
                    iArr = this.f11279p;
                    i2 = this.f11277n - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                valueOf = String.valueOf(mo1835b());
                i2 = m17250g();
                h2 = m17251h();
                path2 = getPath();
                throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(h2).append(" path ").append(path2).toString());
            }
            this.f11272i = 11;
            double parseDouble = Double.parseDouble(this.f11275l);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                valueOf = this.f11275l;
                i2 = m17250g();
                h2 = m17251h();
                path2 = getPath();
                throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(i2).append(" column ").append(h2).append(" path ").append(path2).toString());
            }
            this.f11275l = null;
            this.f11272i = 0;
            iArr = this.f11279p;
            i2 = this.f11277n - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public long nextLong() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 15) {
            this.f11272i = 0;
            int[] iArr = this.f11279p;
            int i2 = this.f11277n - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f11273j;
        }
        long parseLong;
        int i3;
        if (i == 16) {
            this.f11275l = new String(this.f11267d, this.f11268e, this.f11274k);
            this.f11268e += this.f11274k;
        } else if (i == 8 || i == 9) {
            this.f11275l = m17241b(i == 8 ? '\'' : '\"');
            try {
                parseLong = Long.parseLong(this.f11275l);
                this.f11272i = 0;
                int[] iArr2 = this.f11279p;
                i3 = this.f11277n - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(mo1835b());
            int g = m17250g();
            i3 = m17251h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(i3).append(" path ").append(path).toString());
        }
        this.f11272i = 11;
        double parseDouble = Double.parseDouble(this.f11275l);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            valueOf = this.f11275l;
            g = m17250g();
            i3 = m17251h();
            path = getPath();
            throw new NumberFormatException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(i3).append(" path ").append(path).toString());
        }
        this.f11275l = null;
        this.f11272i = 0;
        iArr2 = this.f11279p;
        i3 = this.f11277n - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    public String nextName() {
        String e;
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 14) {
            e = mo1839e();
        } else if (i == 12) {
            e = m17241b('\'');
        } else if (i == 13) {
            e = m17241b('\"');
        } else {
            String valueOf = String.valueOf(mo1835b());
            int g = m17250g();
            int h = m17251h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
        this.f11272i = 0;
        this.f11278o[this.f11277n - 1] = e;
        return e;
    }

    public void nextNull() {
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 7) {
            this.f11272i = 0;
            int[] iArr = this.f11279p;
            int i2 = this.f11277n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(mo1835b());
        int g = m17250g();
        int h = m17251h();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 67) + String.valueOf(path).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
    }

    public String nextString() {
        String e;
        int g;
        int i = this.f11272i;
        if (i == 0) {
            i = m17232a();
        }
        if (i == 10) {
            e = mo1839e();
        } else if (i == 8) {
            e = m17241b('\'');
        } else if (i == 9) {
            e = m17241b('\"');
        } else if (i == 11) {
            e = this.f11275l;
            this.f11275l = null;
        } else if (i == 15) {
            e = Long.toString(this.f11273j);
        } else if (i == 16) {
            e = new String(this.f11267d, this.f11268e, this.f11274k);
            this.f11268e += this.f11274k;
        } else {
            String valueOf = String.valueOf(mo1835b());
            g = m17250g();
            int h = m17251h();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 71) + String.valueOf(path).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(g).append(" column ").append(h).append(" path ").append(path).toString());
        }
        this.f11272i = 0;
        int[] iArr = this.f11279p;
        g = this.f11277n - 1;
        iArr[g] = iArr[g] + 1;
        return e;
    }

    public final void setLenient(boolean z) {
        this.f11266c = z;
    }

    public void skipValue() {
        int i = 0;
        do {
            int i2 = this.f11272i;
            if (i2 == 0) {
                i2 = m17232a();
            }
            if (i2 == 3) {
                m17236a(1);
                i++;
            } else if (i2 == 1) {
                m17236a(3);
                i++;
            } else if (i2 == 4) {
                this.f11277n--;
                i--;
            } else if (i2 == 2) {
                this.f11277n--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m17249f();
            } else if (i2 == 8 || i2 == 12) {
                m17245c('\'');
            } else if (i2 == 9 || i2 == 13) {
                m17245c('\"');
            } else if (i2 == 16) {
                this.f11268e += this.f11274k;
            }
            this.f11272i = 0;
        } while (i != 0);
        int[] iArr = this.f11279p;
        int i3 = this.f11277n - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f11278o[this.f11277n - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int g = m17250g();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(g).append(" column ").append(m17251h()).toString();
    }
}
