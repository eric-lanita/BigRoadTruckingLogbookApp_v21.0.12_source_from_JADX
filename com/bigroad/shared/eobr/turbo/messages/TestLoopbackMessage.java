package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;
import java.util.Arrays;

public class TestLoopbackMessage extends ak {
    public final boolean f3320a;
    public final int f3321b;
    public final long f3322c;
    public final int f3323d;
    public final long f3324e;
    public final TestLoopbackEnum f3325f;
    public final boolean[] f3326g;
    public final byte[] f3327h;
    public final int[] f3328i;
    public final int[] f3329j;
    public final long[] f3330k;
    public final long[] f3331l;
    public final TestLoopbackEnum[] f3332m;

    public enum TestLoopbackEnum implements C1000c {
        TEST0(0),
        TEST1(1),
        TEST2(2);
        
        private final int m_id;

        private TestLoopbackEnum(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == TEST0;
        }
    }

    public TestLoopbackMessage(boolean z, int i, long j, int i2, long j2, TestLoopbackEnum testLoopbackEnum, boolean[] zArr, byte[] bArr, int[] iArr, int[] iArr2, long[] jArr, long[] jArr2, TestLoopbackEnum[] testLoopbackEnumArr) {
        this.f3320a = z;
        this.f3321b = i;
        this.f3322c = j;
        this.f3323d = i2;
        this.f3324e = j2;
        this.f3325f = testLoopbackEnum;
        this.f3326g = zArr;
        this.f3327h = bArr;
        this.f3328i = iArr;
        this.f3329j = iArr2;
        this.f3330k = jArr;
        this.f3331l = jArr2;
        this.f3332m = testLoopbackEnumArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TestLoopbackMessage)) {
            return false;
        }
        TestLoopbackMessage testLoopbackMessage = (TestLoopbackMessage) obj;
        if (this.f3320a == testLoopbackMessage.f3320a && this.f3321b == testLoopbackMessage.f3321b && this.f3322c == testLoopbackMessage.f3322c && this.f3323d == testLoopbackMessage.f3323d && this.f3324e == testLoopbackMessage.f3324e && this.f3325f == testLoopbackMessage.f3325f && Arrays.equals(this.f3326g, testLoopbackMessage.f3326g) && Arrays.equals(this.f3327h, testLoopbackMessage.f3327h) && Arrays.equals(this.f3328i, testLoopbackMessage.f3328i) && Arrays.equals(this.f3329j, testLoopbackMessage.f3329j) && Arrays.equals(this.f3330k, testLoopbackMessage.f3330k) && Arrays.equals(this.f3331l, testLoopbackMessage.f3331l) && Arrays.equals(this.f3332m, testLoopbackMessage.f3332m)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }
}
