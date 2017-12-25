package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    private static final class JdkMatcher extends CommonMatcher {
        final Matcher matcher;

        JdkMatcher(Matcher matcher) {
            this.matcher = (Matcher) Preconditions.checkNotNull(matcher);
        }

        boolean matches() {
            return this.matcher.matches();
        }

        boolean find() {
            return this.matcher.find();
        }

        boolean find(int i) {
            return this.matcher.find(i);
        }

        String replaceAll(String str) {
            return this.matcher.replaceAll(str);
        }

        int end() {
            return this.matcher.end();
        }

        int start() {
            return this.matcher.start();
        }
    }

    JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern);
    }

    CommonMatcher matcher(CharSequence charSequence) {
        return new JdkMatcher(this.pattern.matcher(charSequence));
    }

    String pattern() {
        return this.pattern.pattern();
    }

    int flags() {
        return this.pattern.flags();
    }

    public String toString() {
        return this.pattern.toString();
    }

    public int hashCode() {
        return this.pattern.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof JdkPattern) {
            return this.pattern.equals(((JdkPattern) obj).pattern);
        }
        return false;
    }
}
