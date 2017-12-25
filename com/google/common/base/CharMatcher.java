package com.google.common.base;

import java.util.Arrays;
import java.util.BitSet;

public abstract class CharMatcher implements Predicate<Character> {
    @Deprecated
    public static final CharMatcher ANY = any();
    @Deprecated
    public static final CharMatcher ASCII = ascii();
    @Deprecated
    public static final CharMatcher BREAKING_WHITESPACE = breakingWhitespace();
    @Deprecated
    public static final CharMatcher DIGIT = digit();
    private static final int DISTINCT_CHARS = 65536;
    @Deprecated
    public static final CharMatcher INVISIBLE = invisible();
    @Deprecated
    public static final CharMatcher JAVA_DIGIT = javaDigit();
    @Deprecated
    public static final CharMatcher JAVA_ISO_CONTROL = javaIsoControl();
    @Deprecated
    public static final CharMatcher JAVA_LETTER = javaLetter();
    @Deprecated
    public static final CharMatcher JAVA_LETTER_OR_DIGIT = javaLetterOrDigit();
    @Deprecated
    public static final CharMatcher JAVA_LOWER_CASE = javaLowerCase();
    @Deprecated
    public static final CharMatcher JAVA_UPPER_CASE = javaUpperCase();
    @Deprecated
    public static final CharMatcher NONE = none();
    @Deprecated
    public static final CharMatcher SINGLE_WIDTH = singleWidth();
    @Deprecated
    public static final CharMatcher WHITESPACE = whitespace();

    private static class Negated extends CharMatcher {
        final CharMatcher original;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        Negated(CharMatcher charMatcher) {
            this.original = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        public boolean matches(char c) {
            return !this.original.matches(c);
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            return this.original.matchesNoneOf(charSequence);
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.original.matchesAllOf(charSequence);
        }

        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.original.countIn(charSequence);
        }

        void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.original.setBits(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        public CharMatcher negate() {
            return this.original;
        }

        public String toString() {
            return this.original + ".negate()";
        }
    }

    static class NegatedFastMatcher extends Negated {
        NegatedFastMatcher(CharMatcher charMatcher) {
            super(charMatcher);
        }

        public final CharMatcher precomputed() {
            return this;
        }
    }

    private static final class And extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.first = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.second = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        public boolean matches(char c) {
            return this.first.matches(c) && this.second.matches(c);
        }

        void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.first.setBits(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.second.setBits(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        public String toString() {
            return "CharMatcher.and(" + this.first + ", " + this.second + ")";
        }
    }

    static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public final CharMatcher precomputed() {
            return this;
        }

        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
    }

    static abstract class NamedFastMatcher extends FastMatcher {
        private final String description;

        NamedFastMatcher(String str) {
            this.description = (String) Preconditions.checkNotNull(str);
        }

        public final String toString() {
            return this.description;
        }
    }

    private static final class Any extends NamedFastMatcher {
        static final Any INSTANCE = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        public boolean matches(char c) {
            return true;
        }

        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        public int indexIn(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i, length);
            return i == length ? -1 : i;
        }

        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c);
            return new String(cArr);
        }

        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder stringBuilder = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i = 0; i < charSequence.length(); i++) {
                stringBuilder.append(charSequence2);
            }
            return stringBuilder.toString();
        }

        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.length() == 0 ? "" : String.valueOf(c);
        }

        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        public CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        public CharMatcher negate() {
            return CharMatcher.none();
        }
    }

    private static final class AnyOf extends CharMatcher {
        private final char[] chars;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public AnyOf(CharSequence charSequence) {
            this.chars = charSequence.toString().toCharArray();
            Arrays.sort(this.chars);
        }

        public boolean matches(char c) {
            return Arrays.binarySearch(this.chars, c) >= 0;
        }

        void setBits(BitSet bitSet) {
            for (char c : this.chars) {
                bitSet.set(c);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
            for (char access$100 : this.chars) {
                stringBuilder.append(CharMatcher.showCharacter(access$100));
            }
            stringBuilder.append("\")");
            return stringBuilder.toString();
        }
    }

    private static final class Ascii extends NamedFastMatcher {
        static final Ascii INSTANCE = new Ascii();

        Ascii() {
            super("CharMatcher.ascii()");
        }

        public boolean matches(char c) {
            return c <= Ascii.MAX;
        }
    }

    private static final class BitSetMatcher extends NamedFastMatcher {
        private final BitSet table;

        private BitSetMatcher(BitSet bitSet, String str) {
            BitSet bitSet2;
            super(str);
            if (bitSet.length() + 64 < bitSet.size()) {
                bitSet2 = (BitSet) bitSet.clone();
            } else {
                bitSet2 = bitSet;
            }
            this.table = bitSet2;
        }

        public boolean matches(char c) {
            return this.table.get(c);
        }

        void setBits(BitSet bitSet) {
            bitSet.or(this.table);
        }
    }

    private static final class BreakingWhitespace extends CharMatcher {
        static final CharMatcher INSTANCE = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public boolean matches(char c) {
            switch (c) {
                case '\t':
                case '\n':
                case '\u000b':
                case '\f':
                case '\r':
                case ' ':
                case '':
                case ' ':
                case ' ':
                case ' ':
                case ' ':
                case '　':
                    return true;
                case ' ':
                    return false;
                default:
                    if (c < ' ' || c > ' ') {
                        return false;
                    }
                    return true;
            }
        }

        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    private static class RangesMatcher extends CharMatcher {
        private final String description;
        private final char[] rangeEnds;
        private final char[] rangeStarts;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            boolean z;
            this.description = str;
            this.rangeStarts = cArr;
            this.rangeEnds = cArr2;
            if (cArr.length == cArr2.length) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            for (int i = 0; i < cArr.length; i++) {
                boolean z2;
                if (cArr[i] <= cArr2[i]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2);
                if (i + 1 < cArr.length) {
                    if (cArr2[i] < cArr[i + 1]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Preconditions.checkArgument(z2);
                }
            }
        }

        public boolean matches(char c) {
            int binarySearch = Arrays.binarySearch(this.rangeStarts, c);
            if (binarySearch >= 0) {
                return true;
            }
            binarySearch = (binarySearch ^ -1) - 1;
            if (binarySearch < 0 || c > this.rangeEnds[binarySearch]) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    private static final class Digit extends RangesMatcher {
        static final Digit INSTANCE = new Digit();
        private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０";

        private static char[] zeroes() {
            return ZEROES.toCharArray();
        }

        private static char[] nines() {
            char[] cArr = new char[ZEROES.length()];
            for (int i = 0; i < ZEROES.length(); i++) {
                cArr[i] = (char) (ZEROES.charAt(i) + 9);
            }
            return cArr;
        }

        private Digit() {
            super("CharMatcher.digit()", zeroes(), nines());
        }
    }

    private static final class ForPredicate extends CharMatcher {
        private final Predicate<? super Character> predicate;

        ForPredicate(Predicate<? super Character> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        public boolean matches(char c) {
            return this.predicate.apply(Character.valueOf(c));
        }

        public boolean apply(Character ch) {
            return this.predicate.apply(Preconditions.checkNotNull(ch));
        }

        public String toString() {
            return "CharMatcher.forPredicate(" + this.predicate + ")";
        }
    }

    private static final class InRange extends FastMatcher {
        private final char endInclusive;
        private final char startInclusive;

        InRange(char c, char c2) {
            Preconditions.checkArgument(c2 >= c);
            this.startInclusive = c;
            this.endInclusive = c2;
        }

        public boolean matches(char c) {
            return this.startInclusive <= c && c <= this.endInclusive;
        }

        void setBits(BitSet bitSet) {
            bitSet.set(this.startInclusive, this.endInclusive + 1);
        }

        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.showCharacter(this.startInclusive) + "', '" + CharMatcher.showCharacter(this.endInclusive) + "')";
        }
    }

    private static final class Invisible extends RangesMatcher {
        static final Invisible INSTANCE = new Invisible();
        private static final String RANGE_ENDS = "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻";
        private static final String RANGE_STARTS = "\u0000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺";

        private Invisible() {
            super("CharMatcher.invisible()", RANGE_STARTS.toCharArray(), RANGE_ENDS.toCharArray());
        }
    }

    private static final class Is extends FastMatcher {
        private final char match;

        Is(char c) {
            this.match = c;
        }

        public boolean matches(char c) {
            return c == this.match;
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString().replace(this.match, c);
        }

        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? this : CharMatcher.none();
        }

        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? charMatcher : super.or(charMatcher);
        }

        public CharMatcher negate() {
            return CharMatcher.isNot(this.match);
        }

        void setBits(BitSet bitSet) {
            bitSet.set(this.match);
        }

        public String toString() {
            return "CharMatcher.is('" + CharMatcher.showCharacter(this.match) + "')";
        }
    }

    private static final class IsEither extends FastMatcher {
        private final char match1;
        private final char match2;

        IsEither(char c, char c2) {
            this.match1 = c;
            this.match2 = c2;
        }

        public boolean matches(char c) {
            return c == this.match1 || c == this.match2;
        }

        void setBits(BitSet bitSet) {
            bitSet.set(this.match1);
            bitSet.set(this.match2);
        }

        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.match1) + CharMatcher.showCharacter(this.match2) + "\")";
        }
    }

    private static final class IsNot extends FastMatcher {
        private final char match;

        IsNot(char c) {
            this.match = c;
        }

        public boolean matches(char c) {
            return c != this.match;
        }

        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? super.and(charMatcher) : charMatcher;
        }

        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.match) ? CharMatcher.any() : this;
        }

        void setBits(BitSet bitSet) {
            bitSet.set(0, this.match);
            bitSet.set(this.match + 1, 65536);
        }

        public CharMatcher negate() {
            return CharMatcher.is(this.match);
        }

        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.showCharacter(this.match) + "')";
        }
    }

    private static final class JavaDigit extends CharMatcher {
        static final JavaDigit INSTANCE = new JavaDigit();

        private JavaDigit() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isDigit(c);
        }

        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    private static final class JavaIsoControl extends NamedFastMatcher {
        static final JavaIsoControl INSTANCE = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        public boolean matches(char c) {
            return c <= '\u001f' || (c >= Ascii.MAX && c <= '');
        }
    }

    private static final class JavaLetter extends CharMatcher {
        static final JavaLetter INSTANCE = new JavaLetter();

        private JavaLetter() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLetter(c);
        }

        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    private static final class JavaLetterOrDigit extends CharMatcher {
        static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }

        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    private static final class JavaLowerCase extends CharMatcher {
        static final JavaLowerCase INSTANCE = new JavaLowerCase();

        private JavaLowerCase() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isLowerCase(c);
        }

        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    private static final class JavaUpperCase extends CharMatcher {
        static final JavaUpperCase INSTANCE = new JavaUpperCase();

        private JavaUpperCase() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public boolean matches(char c) {
            return Character.isUpperCase(c);
        }

        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    private static final class None extends NamedFastMatcher {
        static final None INSTANCE = new None();

        private None() {
            super("CharMatcher.none()");
        }

        public boolean matches(char c) {
            return false;
        }

        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        public int indexIn(CharSequence charSequence, int i) {
            Preconditions.checkPositionIndex(i, charSequence.length());
            return -1;
        }

        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        public boolean matchesAllOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String replaceFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }

        public String collapseFrom(CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        public CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        public CharMatcher negate() {
            return CharMatcher.any();
        }
    }

    private static final class Or extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.first = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.second = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        void setBits(BitSet bitSet) {
            this.first.setBits(bitSet);
            this.second.setBits(bitSet);
        }

        public boolean matches(char c) {
            return this.first.matches(c) || this.second.matches(c);
        }

        public String toString() {
            return "CharMatcher.or(" + this.first + ", " + this.second + ")";
        }
    }

    private static final class SingleWidth extends RangesMatcher {
        static final SingleWidth INSTANCE = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    static final class Whitespace extends NamedFastMatcher {
        static final Whitespace INSTANCE = new Whitespace();
        static final int MULTIPLIER = 1682554634;
        static final int SHIFT = Integer.numberOfLeadingZeros(TABLE.length() - 1);
        static final String TABLE = " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　";

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        public boolean matches(char c) {
            return TABLE.charAt((MULTIPLIER * c) >>> SHIFT) == c;
        }

        void setBits(BitSet bitSet) {
            for (int i = 0; i < TABLE.length(); i++) {
                bitSet.set(TABLE.charAt(i));
            }
        }
    }

    public abstract boolean matches(char c);

    public static CharMatcher any() {
        return Any.INSTANCE;
    }

    public static CharMatcher none() {
        return None.INSTANCE;
    }

    public static CharMatcher whitespace() {
        return Whitespace.INSTANCE;
    }

    public static CharMatcher breakingWhitespace() {
        return BreakingWhitespace.INSTANCE;
    }

    public static CharMatcher ascii() {
        return Ascii.INSTANCE;
    }

    public static CharMatcher digit() {
        return Digit.INSTANCE;
    }

    public static CharMatcher javaDigit() {
        return JavaDigit.INSTANCE;
    }

    public static CharMatcher javaLetter() {
        return JavaLetter.INSTANCE;
    }

    public static CharMatcher javaLetterOrDigit() {
        return JavaLetterOrDigit.INSTANCE;
    }

    public static CharMatcher javaUpperCase() {
        return JavaUpperCase.INSTANCE;
    }

    public static CharMatcher javaLowerCase() {
        return JavaLowerCase.INSTANCE;
    }

    public static CharMatcher javaIsoControl() {
        return JavaIsoControl.INSTANCE;
    }

    public static CharMatcher invisible() {
        return Invisible.INSTANCE;
    }

    public static CharMatcher singleWidth() {
        return SingleWidth.INSTANCE;
    }

    public static CharMatcher is(char c) {
        return new Is(c);
    }

    public static CharMatcher isNot(char c) {
        return new IsNot(c);
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return none();
            case 1:
                return is(charSequence.charAt(0));
            case 2:
                return isEither(charSequence.charAt(0), charSequence.charAt(1));
            default:
                return new AnyOf(charSequence);
        }
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    public static CharMatcher inRange(char c, char c2) {
        return new InRange(c, c2);
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new ForPredicate(predicate);
    }

    protected CharMatcher() {
    }

    public CharMatcher negate() {
        return new Negated(this);
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new And(this, charMatcher);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new Or(this, charMatcher);
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    CharMatcher precomputedInternal() {
        BitSet bitSet = new BitSet();
        setBits(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return precomputedPositive(cardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i = 65536 - cardinality;
        String str = ".negate()";
        final String charMatcher = toString();
        return new NegatedFastMatcher(precomputedPositive(i, bitSet, charMatcher.endsWith(str) ? charMatcher.substring(0, charMatcher.length() - str.length()) : charMatcher + str)) {
            public String toString() {
                return charMatcher;
            }
        };
    }

    private static CharMatcher precomputedPositive(int i, BitSet bitSet, String str) {
        switch (i) {
            case 0:
                return none();
            case 1:
                return is((char) bitSet.nextSetBit(0));
            case 2:
                char nextSetBit = (char) bitSet.nextSetBit(0);
                return isEither(nextSetBit, (char) bitSet.nextSetBit(nextSetBit + 1));
            default:
                if (isSmall(i, bitSet.length())) {
                    return SmallCharMatcher.from(bitSet, str);
                }
                return new BitSetMatcher(bitSet, str);
        }
    }

    private static boolean isSmall(int i, int i2) {
        return i <= 1023 && i2 > (i * 4) * 16;
    }

    void setBits(BitSet bitSet) {
        for (int i = 65535; i >= 0; i--) {
            if (matches((char) i)) {
                bitSet.set(i);
            }
        }
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int indexIn(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i, length);
        for (int i2 = i; i2 < length; i2++) {
            if (matches(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public int countIn(CharSequence charSequence) {
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            if (matches(charSequence.charAt(i))) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    public String removeFrom(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] toCharArray = charSequence2.toCharArray();
        int i = 1;
        while (true) {
            indexIn++;
            while (indexIn != toCharArray.length) {
                if (matches(toCharArray[indexIn])) {
                    i++;
                } else {
                    toCharArray[indexIn - i] = toCharArray[indexIn];
                    indexIn++;
                }
            }
            return new String(toCharArray, 0, indexIn - i);
        }
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public String replaceFrom(CharSequence charSequence, char c) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] toCharArray = charSequence2.toCharArray();
        toCharArray[indexIn] = c;
        for (int i = indexIn + 1; i < toCharArray.length; i++) {
            if (matches(toCharArray[i])) {
                toCharArray[i] = c;
            }
        }
        return new String(toCharArray);
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        CharSequence charSequence3 = charSequence.toString();
        length = indexIn(charSequence3);
        if (length == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder stringBuilder = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            stringBuilder.append(charSequence3, i, length);
            stringBuilder.append(charSequence2);
            i = length + 1;
            length = indexIn(charSequence3, i);
        } while (length != -1);
        stringBuilder.append(charSequence3, i, length2);
        return stringBuilder.toString();
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && matches(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        while (i2 > i && matches(charSequence.charAt(i2))) {
            i2--;
        }
        return charSequence.subSequence(i, i2 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    public String collapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (matches(charAt)) {
                if (charAt != c || (i != length - 1 && matches(charSequence.charAt(i + 1)))) {
                    StringBuilder append = new StringBuilder(length).append(charSequence, 0, i).append(c);
                    return finishCollapseFrom(charSequence, i + 1, length, c, append, true);
                }
                i++;
            }
            i++;
        }
        return charSequence.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = length - 1;
        int i2 = 0;
        while (i2 < length && matches(charSequence.charAt(i2))) {
            i2++;
        }
        while (i > i2 && matches(charSequence.charAt(i))) {
            i--;
        }
        if (i2 == 0 && i == length - 1) {
            return collapseFrom(charSequence, c);
        }
        return finishCollapseFrom(charSequence, i2, i + 1, c, new StringBuilder((i + 1) - i2), false);
    }

    private String finishCollapseFrom(CharSequence charSequence, int i, int i2, char c, StringBuilder stringBuilder, boolean z) {
        boolean z2 = z;
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (!matches(charAt)) {
                stringBuilder.append(charAt);
                z2 = false;
            } else if (!z2) {
                stringBuilder.append(c);
                z2 = true;
            }
            i++;
        }
        return stringBuilder.toString();
    }

    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public String toString() {
        return super.toString();
    }

    private static String showCharacter(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    private static IsEither isEither(char c, char c2) {
        return new IsEither(c, c2);
    }
}
