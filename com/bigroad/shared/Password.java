package com.bigroad.shared;

import com.google.common.base.CharMatcher;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Password {
    private static final char[] f2578a = "abcdefghijkmnpqrstuvwxyz".toCharArray();
    private static final char[] f2579b = "23456789".toCharArray();
    private static final List<String> f2580c = new ArrayList(Arrays.asList(new String[]{"bigroad", "dashlink"}));
    private static final Random f2581d = new SecureRandom();

    public enum NewPasswordStatus {
        PASSWORD_VALID("common.password.validation.ok"),
        NO_PASSWORD("common.password.validation.noPassword"),
        PASSWORDS_DO_NOT_MATCH("common.password.validation.passwordsDontMatch"),
        PASSWORD_FAILED_VALIDATION("common.password.validation.failed");
        
        private String m_localizationKey;

        private NewPasswordStatus(String str) {
            this.m_localizationKey = str;
        }

        public String m4090a() {
            return this.m_localizationKey;
        }
    }

    public static class C0826a {
        private final String f2573a;
        private final String f2574b;
        private final String f2575c;
        private final String f2576d;
        private final String f2577e;

        public C0826a(String str, String str2, String str3, String str4, String str5) {
            this.f2573a = str;
            this.f2574b = str2;
            this.f2575c = str3;
            this.f2576d = str4;
            this.f2577e = str5;
        }

        public String m4091a() {
            return this.f2573a;
        }

        public String m4092b() {
            return this.f2574b;
        }

        public String m4093c() {
            return this.f2575c;
        }

        public String m4094d() {
            return this.f2576d;
        }

        public String m4095e() {
            return this.f2577e;
        }
    }

    public static NewPasswordStatus m4096a(C0826a c0826a) {
        String a = c0826a.m4091a();
        if (am.m4188a((CharSequence) a)) {
            return NewPasswordStatus.NO_PASSWORD;
        }
        if (!am.m4189a(a, c0826a.m4092b())) {
            return NewPasswordStatus.PASSWORDS_DO_NOT_MATCH;
        }
        if (a.length() < 6 || a.equalsIgnoreCase(c0826a.m4093c()) || a.equalsIgnoreCase(c0826a.m4094d()) || a.equalsIgnoreCase(c0826a.m4095e()) || f2580c.contains(a.toLowerCase()) || !CharMatcher.javaLetter().matchesAnyOf(a) || !CharMatcher.javaDigit().matchesAnyOf(a)) {
            return NewPasswordStatus.PASSWORD_FAILED_VALIDATION;
        }
        return NewPasswordStatus.PASSWORD_VALID;
    }
}
