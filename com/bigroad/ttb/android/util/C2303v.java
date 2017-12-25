package com.bigroad.ttb.android.util;

import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;

public class C2303v implements Appendable {
    private static final CharacterStyle f7946a = new StyleSpan(1);
    private static final CharacterStyle f7947b = new StyleSpan(2);
    private final ParagraphStyle f7948c;
    private final ParagraphStyle f7949d;
    private SpannableStringBuilder f7950e = null;
    private Integer f7951f = null;

    public /* synthetic */ Appendable append(char c) {
        return m11260a(c);
    }

    public /* synthetic */ Appendable append(CharSequence charSequence) {
        return m11268c(charSequence);
    }

    public /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) {
        return m11263a(charSequence, i, i2);
    }

    private SpannableStringBuilder m11259f() {
        if (this.f7950e == null) {
            this.f7950e = new SpannableStringBuilder();
        }
        return this.f7950e;
    }

    public void m11265a() {
        this.f7950e = null;
        this.f7951f = null;
    }

    public C2303v m11261a(int i) {
        this.f7951f = Integer.valueOf(i);
        return this;
    }

    public C2303v m11266b() {
        this.f7951f = null;
        return this;
    }

    public static C2303v m11258c() {
        return new C2303v(null, null);
    }

    public static C2303v m11257b(int i) {
        return new C2303v(new Standard(0, i), new Standard(i));
    }

    private C2303v(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2) {
        this.f7948c = paragraphStyle;
        this.f7949d = paragraphStyle2;
    }

    public C2303v m11262a(CharSequence charSequence) {
        return m11264a(charSequence, f7946a);
    }

    public C2303v m11267b(CharSequence charSequence) {
        return m11264a(charSequence, f7947b);
    }

    public C2303v m11268c(CharSequence charSequence) {
        return m11264a(charSequence, null);
    }

    public C2303v m11260a(char c) {
        m11259f().append(c);
        return this;
    }

    public C2303v m11263a(CharSequence charSequence, int i, int i2) {
        m11259f().append(charSequence, i, i2);
        return this;
    }

    public C2303v m11264a(CharSequence charSequence, CharacterStyle characterStyle) {
        SpannableStringBuilder f = m11259f();
        int length = f.length();
        int length2 = charSequence.length() + length;
        f.append(charSequence);
        if (characterStyle != null) {
            f.setSpan(CharacterStyle.wrap(characterStyle), length, length2, 33);
        }
        if (this.f7951f != null) {
            f.setSpan(new ForegroundColorSpan(this.f7951f.intValue()), length, length2, 33);
        }
        return this;
    }

    public boolean m11269d() {
        return this.f7950e == null || this.f7950e.length() == 0;
    }

    public CharSequence m11270e() {
        SpannableStringBuilder f = m11259f();
        if (this.f7948c != null) {
            int i;
            int length = f.length();
            if (this.f7949d != null) {
                for (i = 0; i < f.length(); i++) {
                    if (f.charAt(i) == '\n') {
                        i++;
                        break;
                    }
                }
                i = length;
                if (i < f.length()) {
                    f.setSpan(this.f7949d, i, f.length(), 33);
                }
            } else {
                i = length;
            }
            f.setSpan(this.f7948c, 0, i, 33);
        } else if (this.f7949d != null) {
            f.setSpan(this.f7949d, 0, f.length(), 33);
        }
        m11265a();
        return f;
    }
}
