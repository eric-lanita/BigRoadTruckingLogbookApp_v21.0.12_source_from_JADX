package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Ints {

    private static class IntArrayAsList extends AbstractList<Integer> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public /* synthetic */ Object get(int i) {
            return m18826a(i);
        }

        public /* synthetic */ Object set(int i, Object obj) {
            return m18827a(i, (Integer) obj);
        }

        IntArrayAsList(int[] iArr, int i, int i2) {
            this.array = iArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        public boolean isEmpty() {
            return false;
        }

        public Integer m18826a(int i) {
            Preconditions.checkElementIndex(i, size());
            return Integer.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Integer) && Ints.m18834c(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                int a = Ints.m18834c(this.array, ((Integer) obj).intValue(), this.start, this.end);
                if (a >= 0) {
                    return a - this.start;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                int b = Ints.m18835d(this.array, ((Integer) obj).intValue(), this.start, this.end);
                if (b >= 0) {
                    return b - this.start;
                }
            }
            return -1;
        }

        public Integer m18827a(int i, Integer num) {
            Preconditions.checkElementIndex(i, size());
            int i2 = this.array[this.start + i];
            this.array[this.start + i] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i2);
        }

        public List<Integer> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            return new IntArrayAsList(this.array, this.start + i, this.start + i2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IntArrayAsList)) {
                return super.equals(obj);
            }
            IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
            int size = size();
            if (intArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != intArrayAsList.array[intArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Ints.m18829a(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(size() * 5);
            stringBuilder.append('[').append(this.array[this.start]);
            for (int i = this.start + 1; i < this.end; i++) {
                stringBuilder.append(", ").append(this.array[i]);
            }
            return stringBuilder.append(']').toString();
        }

        int[] m18828a() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }

    public static int m18829a(int i) {
        return i;
    }

    public static int m18830a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    private static int m18834c(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i2; i4 < i3; i4++) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    private static int m18835d(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int[] m18832a(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).m18828a();
        }
        Object[] toArray = collection.toArray();
        int length = toArray.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) Preconditions.checkNotNull(toArray[i])).intValue();
        }
        return iArr;
    }
}
