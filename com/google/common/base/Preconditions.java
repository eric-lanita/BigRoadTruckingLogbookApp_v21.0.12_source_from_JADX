package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static void checkArgument(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj));
        }
    }

    public static void checkArgument(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void checkArgument(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, char c, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Character.valueOf(c), obj));
        }
    }

    public static void checkArgument(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkArgument(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, int i, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Integer.valueOf(i), obj));
        }
    }

    public static void checkArgument(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void checkArgument(boolean z, String str, long j, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(format(str, Long.valueOf(j), obj));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj, char c) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, Character.valueOf(c)));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, Integer.valueOf(i)));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj, long j) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, Long.valueOf(j)));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(format(str, obj, obj2, obj3, obj4));
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(format(str, objArr));
        }
    }

    public static void checkState(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalStateException(format(str, Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(format(str, Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(format(str, Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalStateException(format(str, obj));
        }
    }

    public static void checkState(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalStateException(format(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void checkState(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalStateException(format(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalStateException(format(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, char c, Object obj) {
        if (!z) {
            throw new IllegalStateException(format(str, Character.valueOf(c), obj));
        }
    }

    public static void checkState(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalStateException(format(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalStateException(format(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void checkState(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalStateException(format(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, int i, Object obj) {
        if (!z) {
            throw new IllegalStateException(format(str, Integer.valueOf(i), obj));
        }
    }

    public static void checkState(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalStateException(format(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalStateException(format(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalStateException(format(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void checkState(boolean z, String str, long j, Object obj) {
        if (!z) {
            throw new IllegalStateException(format(str, Long.valueOf(j), obj));
        }
    }

    public static void checkState(boolean z, String str, Object obj, char c) {
        if (!z) {
            throw new IllegalStateException(format(str, obj, Character.valueOf(c)));
        }
    }

    public static void checkState(boolean z, String str, Object obj, int i) {
        if (!z) {
            throw new IllegalStateException(format(str, obj, Integer.valueOf(i)));
        }
    }

    public static void checkState(boolean z, String str, Object obj, long j) {
        if (!z) {
            throw new IllegalStateException(format(str, obj, Long.valueOf(j)));
        }
    }

    public static void checkState(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalStateException(format(str, obj, obj2));
        }
    }

    public static void checkState(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (!z) {
            throw new IllegalStateException(format(str, obj, obj2, obj3));
        }
    }

    public static void checkState(boolean z, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z) {
            throw new IllegalStateException(format(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, objArr));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, char c, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Character.valueOf(c), Character.valueOf(c2)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, char c, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Character.valueOf(c), Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, char c, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Character.valueOf(c), Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, char c, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Character.valueOf(c), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, int i, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Integer.valueOf(i), Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, int i, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, int i, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Integer.valueOf(i), Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, int i, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Integer.valueOf(i), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, long j, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Long.valueOf(j), Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, long j, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Long.valueOf(j), Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, long j, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Long.valueOf(j), Long.valueOf(j2)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, long j, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, Long.valueOf(j), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object obj, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj, Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object obj, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj, Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object obj, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj, Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object obj, Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj, obj2));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object obj, Object obj2, Object obj3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj, obj2, obj3));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, obj, obj2, obj3, obj4));
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, "index");
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i, int i2, String str) {
        if (i >= 0 && i < i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(badElementIndex(i, i2, str));
    }

    private static String badElementIndex(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return format("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i, int i2) {
        return checkPositionIndex(i, i2, "index");
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i, int i2, String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(badPositionIndex(i, i2, str));
    }

    private static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return format("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException("negative size: " + i2);
        } else {
            return format("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i, i2, i3));
        }
    }

    private static String badPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return badPositionIndex(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return badPositionIndex(i2, i3, "end index");
        }
        return format("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    static String format(String str, Object... objArr) {
        int i = 0;
        CharSequence valueOf = String.valueOf(str);
        StringBuilder stringBuilder = new StringBuilder(valueOf.length() + (objArr.length * 16));
        int i2 = 0;
        while (i < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i2);
            if (indexOf == -1) {
                break;
            }
            stringBuilder.append(valueOf, i2, indexOf);
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            int i3 = i2;
            i2 = indexOf + 2;
            i = i3;
        }
        stringBuilder.append(valueOf, i2, valueOf.length());
        if (i < objArr.length) {
            stringBuilder.append(" [");
            i2 = i + 1;
            stringBuilder.append(objArr[i]);
            i = i2;
            while (i < objArr.length) {
                stringBuilder.append(", ");
                i2 = i + 1;
                stringBuilder.append(objArr[i]);
                i = i2;
            }
            stringBuilder.append(']');
        }
        return stringBuilder.toString();
    }
}
