package com.crashlytics.android.core;

import android.os.Process;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.IdManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class C2892c {
    private static final AtomicLong f9975a = new AtomicLong(0);
    private static String f9976b;

    public C2892c(IdManager idManager) {
        r0 = new byte[10];
        m16257a(r0);
        m16259b(r0);
        m16261c(r0);
        String a = CommonUtils.m20695a(idManager.m20735b());
        String a2 = CommonUtils.m20697a(r0);
        f9976b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a2.substring(0, 12), a2.substring(12, 16), a2.subSequence(16, 20), a.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void m16257a(byte[] bArr) {
        long time = new Date().getTime();
        long j = time / 1000;
        time %= 1000;
        byte[] a = C2892c.m16258a(j);
        bArr[0] = a[0];
        bArr[1] = a[1];
        bArr[2] = a[2];
        bArr[3] = a[3];
        byte[] b = C2892c.m16260b(time);
        bArr[4] = b[0];
        bArr[5] = b[1];
    }

    private void m16259b(byte[] bArr) {
        byte[] b = C2892c.m16260b(f9975a.incrementAndGet());
        bArr[6] = b[0];
        bArr[7] = b[1];
    }

    private void m16261c(byte[] bArr) {
        byte[] b = C2892c.m16260b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b[0];
        bArr[9] = b[1];
    }

    private static byte[] m16258a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] m16260b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f9976b;
    }
}
