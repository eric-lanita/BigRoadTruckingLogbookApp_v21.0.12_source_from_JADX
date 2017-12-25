package com.google.android.gms.common.images;

public final class Size {
    private final int f10637a;
    private final int f10638b;

    public Size(int i, int i2) {
        this.f10637a = i;
        this.f10638b = i2;
    }

    private static NumberFormatException m16852a(String str) {
        throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 16).append("Invalid Size: \"").append(str).append("\"").toString());
    }

    public static Size parseSize(String str) {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            throw m16852a(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException e) {
            throw m16852a(str);
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (!(this.f10637a == size.f10637a && this.f10638b == size.f10638b)) {
            z = false;
        }
        return z;
    }

    public int getHeight() {
        return this.f10638b;
    }

    public int getWidth() {
        return this.f10637a;
    }

    public int hashCode() {
        return this.f10638b ^ ((this.f10637a << 16) | (this.f10637a >>> 16));
    }

    public String toString() {
        int i = this.f10637a;
        return i + "x" + this.f10638b;
    }
}
