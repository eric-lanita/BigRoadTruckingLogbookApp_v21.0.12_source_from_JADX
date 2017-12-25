package com.bigroad.shared;

import java.util.Comparator;

public abstract class C0855c {
    public static final Comparator<byte[]> f2653a = new C08501();

    static class C08501 implements Comparator<byte[]> {
        C08501() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4270a((byte[]) obj, (byte[]) obj2);
        }

        public int m4270a(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                int i2 = bArr[i] & 255;
                int i3 = bArr2[i] & 255;
                if (i2 < i3) {
                    return -1;
                }
                if (i2 > i3) {
                    return 1;
                }
            }
            if (bArr.length >= bArr2.length) {
                return bArr.length > bArr2.length ? 1 : 0;
            } else {
                return -1;
            }
        }
    }
}
