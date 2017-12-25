package com.bigroad.ttb.android.widget.p043a;

public final class C2446d {
    private final String f8694a;
    private final String f8695b;
    private final String f8696c;
    private final String f8697d;
    private final String f8698e;

    public C2446d(String str, String str2, String str3, String str4, String str5) {
        this.f8694a = str;
        this.f8695b = str2;
        this.f8696c = str3;
        this.f8697d = str4;
        this.f8698e = str5;
    }

    public C2446d(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null);
    }

    public C2446d(String str, String str2, String str3) {
        this(str, str2, str3, null, null);
    }

    public String m12059a() {
        return this.f8694a;
    }

    public String m12060b() {
        return this.f8696c;
    }

    public String m12061c() {
        return this.f8697d;
    }

    public String m12062d() {
        return this.f8698e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f8695b);
        if (this.f8696c != null) {
            stringBuilder.append(": ").append(this.f8696c);
        }
        if (this.f8697d != null) {
            stringBuilder.append('/').append(this.f8697d);
        }
        return stringBuilder.toString();
    }
}
