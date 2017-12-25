package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public class TestRequestMessage extends al {
    public final TestType f3339a;
    public final int f3340b;
    public final byte[] f3341c;

    public enum TestType implements C1000c {
        TEST_UNKNOWN(0),
        TEST_FLASH_ERASE_SECTOR(1),
        TEST_FLASH_ERASE_BLOCK(2),
        TEST_FLASH_WRITE(3),
        TEST_FLASH_READ(4);
        
        private final int m_id;

        private TestType(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == TEST_UNKNOWN;
        }
    }

    public TestRequestMessage(int i, TestType testType, int i2, byte[] bArr) {
        super(i);
        this.f3339a = testType;
        this.f3340b = i2;
        this.f3341c = bArr;
    }
}
