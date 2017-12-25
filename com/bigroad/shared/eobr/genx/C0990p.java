package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.eobr.C0968a;
import com.bigroad.shared.eobr.EobrSessionLogEntry.SessionState;
import com.bigroad.ttb.protocol.TTProtocol.EobrSessionLogEntry;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.io.IOException;
import java.util.Arrays;

public class C0990p extends C0981n {
    private final byte[] f3108a;

    public C0990p(byte[] bArr) {
        this.f3108a = new byte[(bArr.length + 5)];
        C0968a.m4968b(this.f3108a, 0, 2);
        this.f3108a[2] = (byte) 1;
        this.f3108a[3] = (byte) 1;
        this.f3108a[4] = (byte) -5;
        System.arraycopy(bArr, 0, this.f3108a, 5, bArr.length);
    }

    protected GenxDataType mo758b() {
        return GenxDataType.START_SESSION;
    }

    protected byte[] mo759c() {
        return this.f3108a;
    }

    private EobrSessionLogEntry m5080d() {
        return EobrSessionLogEntry.parseFrom(Arrays.copyOfRange(this.f3108a, 5, this.f3108a.length));
    }

    public static SessionState m5079a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return SessionState.UNKNOWN;
        }
        if (bArr[0] == (byte) 1) {
            return SessionState.START;
        }
        if (bArr[0] == (byte) 2) {
            return SessionState.STATUS;
        }
        if (bArr[0] == (byte) -1) {
            return SessionState.END;
        }
        return SessionState.UNKNOWN;
    }

    public String toString() {
        ToStringHelper toStringHelper = MoreObjects.toStringHelper(C0990p.class);
        Object obj = "INVALID";
        try {
            obj = m5080d().toString();
        } catch (IOException e) {
        }
        toStringHelper.add("session", obj);
        return toStringHelper.toString();
    }
}
