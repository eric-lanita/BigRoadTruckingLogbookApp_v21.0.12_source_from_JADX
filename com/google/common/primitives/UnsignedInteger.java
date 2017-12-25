package com.google.common.primitives;

import com.google.common.base.Preconditions;

public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger f13081a = m18836a(0);
    public static final UnsignedInteger f13082b = m18836a(1);
    public static final UnsignedInteger f13083c = m18836a(-1);
    private final int value;

    public /* synthetic */ int compareTo(Object obj) {
        return m18838a((UnsignedInteger) obj);
    }

    private UnsignedInteger(int i) {
        this.value = i & -1;
    }

    public static UnsignedInteger m18836a(int i) {
        return new UnsignedInteger(i);
    }

    public static UnsignedInteger m18837a(long j) {
        Preconditions.checkArgument((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return m18836a((int) j);
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return C3608c.m18849b(this.value);
    }

    public float floatValue() {
        return (float) longValue();
    }

    public double doubleValue() {
        return (double) longValue();
    }

    public int m18838a(UnsignedInteger unsignedInteger) {
        Preconditions.checkNotNull(unsignedInteger);
        return C3608c.m18848a(this.value, unsignedInteger.value);
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UnsignedInteger)) {
            return false;
        }
        if (this.value == ((UnsignedInteger) obj).value) {
            return true;
        }
        return false;
    }

    public String toString() {
        return m18839b(10);
    }

    public String m18839b(int i) {
        return C3608c.m18850b(this.value, i);
    }
}
