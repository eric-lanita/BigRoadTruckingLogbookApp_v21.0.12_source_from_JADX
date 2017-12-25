package com.bigroad.shared;

import java.text.Collator;
import java.util.Comparator;

public class C0849b implements Comparator<CharSequence> {
    private final Collator f2649a;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m4269a((CharSequence) obj, (CharSequence) obj2);
    }

    public C0849b(Collator collator) {
        this.f2649a = collator;
    }

    private static boolean m4268a(int i) {
        return i >= 48 && i <= 57;
    }

    private static CharSequence m4267a(CharSequence charSequence, int i) {
        int i2;
        int length = charSequence.length();
        int i3 = i + 1;
        boolean a = C0849b.m4268a(charSequence.charAt(i));
        while (i3 < length) {
            i2 = i3 + 1;
            if (C0849b.m4268a(charSequence.charAt(i3)) != a) {
                break;
            }
            i3 = i2;
        }
        i2 = i3;
        return charSequence.subSequence(i, i2);
    }

    public int m4269a(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 == 0 && i < length && i2 < length2) {
            CharSequence a = C0849b.m4267a(charSequence, i);
            int length3 = i + a.length();
            CharSequence a2 = C0849b.m4267a(charSequence2, i2);
            int length4 = i2 + a2.length();
            if (C0849b.m4268a(a.charAt(0)) && C0849b.m4268a(a2.charAt(0))) {
                int length5 = a.length();
                int length6 = a2.length();
                i2 = 0;
                while (i2 < length5 && a.charAt(i2) == '0') {
                    i2++;
                }
                i3 = 0;
                while (i3 < length6 && a2.charAt(i3) == '0') {
                    i3++;
                }
                int i4 = i3;
                i3 = (length5 - i2) - (length6 - i3);
                i = i2;
                i2 = i4;
                while (i3 == 0 && i < length5 && i2 < length6) {
                    i3 = i2 + 1;
                    i2 = a.charAt(i) - a2.charAt(i2);
                    i++;
                    i4 = i3;
                    i3 = i2;
                    i2 = i4;
                }
                if (i3 == 0) {
                    i3 = i - i2;
                }
            } else {
                i3 = this.f2649a.compare(a.toString(), a2.toString());
            }
            i2 = length4;
            i = length3;
        }
        if (i3 == 0) {
            i3 = length - length2;
        }
        return Integer.signum(i3);
    }
}
