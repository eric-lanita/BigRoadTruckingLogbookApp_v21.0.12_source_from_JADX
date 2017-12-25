package com.google.android.gms.internal;

import java.lang.reflect.Field;
import java.util.Locale;

public enum zzamn implements zzamo {
    IDENTITY {
        public String zzc(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String zzc(Field field) {
            return zzamn.m17181b(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String zzc(Field field) {
            return zzamn.m17181b(zzamn.m17182b(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String zzc(Field field) {
            return zzamn.m17182b(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String zzc(Field field) {
            return zzamn.m17182b(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    private static String m17178a(char c, String str, int i) {
        if (i >= str.length()) {
            return String.valueOf(c);
        }
        String valueOf = String.valueOf(str.substring(i));
        return new StringBuilder(String.valueOf(valueOf).length() + 1).append(c).append(valueOf).toString();
    }

    private static String m17181b(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        char charAt = str.charAt(0);
        while (i < str.length() - 1 && !Character.isLetter(charAt)) {
            stringBuilder.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        return i == str.length() ? stringBuilder.toString() : !Character.isUpperCase(charAt) ? stringBuilder.append(m17178a(Character.toUpperCase(charAt), str, i + 1)).toString() : str;
    }

    private static String m17182b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && stringBuilder.length() != 0) {
                stringBuilder.append(str2);
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }
}
