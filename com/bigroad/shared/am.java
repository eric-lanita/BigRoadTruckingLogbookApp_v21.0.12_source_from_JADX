package com.bigroad.shared;

import com.google.common.collect.C3540t;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public abstract class am {
    public static final Pattern f2628a = Pattern.compile("\\s+");
    public static final Pattern f2629b = Pattern.compile("[\\s\\p{Punct}$]+");
    public static final C3540t<String> f2630c = C3540t.m18449a(new C08411()).mo2709b();
    public static final Collator f2631d = Collator.getInstance();
    public static final Comparator<CharSequence> f2632e = new C0849b(f2631d);

    static class C08411 implements Comparator<String> {
        C08411() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4184a((String) obj, (String) obj2);
        }

        public int m4184a(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    static {
        f2631d.setStrength(2);
        f2631d.setDecomposition(1);
    }

    public static boolean m4188a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String m4185a(String str) {
        return str == null ? "" : str;
    }

    public static String m4191b(String str) {
        return str == null ? null : str.trim();
    }

    public static String m4187a(String str, Object... objArr) {
        return m4186a(str, Arrays.asList(objArr));
    }

    public static String m4186a(String str, Iterable<?> iterable) {
        if (iterable == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object next : iterable) {
            if (next != null) {
                CharSequence obj = next.toString();
                if (!m4188a(obj)) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(str);
                    }
                    stringBuilder.append(obj);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static boolean m4189a(String str, String str2) {
        return (str == null && str2 == null) || (str != null && str.equals(str2));
    }

    public static boolean m4190a(String str, String str2, List<String> list, List<String> list2) {
        if (str.regionMatches(true, 0, str2, 0, str2.length())) {
            return true;
        }
        for (String str3 : list2) {
            boolean z;
            for (String regionMatches : list) {
                if (regionMatches.regionMatches(true, 0, str3, 0, str3.length())) {
                    z = true;
                    continue;
                    break;
                }
            }
            z = false;
            continue;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static List<String> m4192c(String str) {
        return Arrays.asList(f2628a.split(str));
    }

    public static List<String> m4193d(String str) {
        return Arrays.asList(f2629b.split(str));
    }
}
