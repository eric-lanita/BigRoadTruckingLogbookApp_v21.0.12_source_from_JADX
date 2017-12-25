package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.shared.eobr.turbo.C1014k;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class EobrEventLogData {

    enum DataType {
        UNKNOWN_TYPE,
        EOBR_EVENT
    }

    public static class C1019a {
        private final EventType f3199a;
        private final C1015l f3200b;

        private C1019a(EventType eventType, C1015l c1015l) {
            this.f3199a = eventType;
            this.f3200b = c1015l;
        }

        public C1015l m5239a() {
            return this.f3200b;
        }
    }

    public static C1019a m5240a(byte[] bArr) {
        if (bArr == null || bArr.length < 4 || bArr[0] != DataType.EOBR_EVENT.ordinal()) {
            return null;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 1, bArr.length - 1);
        return new C1019a(EventType.m13979a(C1014k.m5223a(byteArrayInputStream)), C1015l.m5227a(C1014k.m5226b(byteArrayInputStream)));
    }

    public static Event m5242b(byte[] bArr) {
        if (bArr != null && bArr.length >= 4 && bArr[0] == DataType.EOBR_EVENT.ordinal()) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 1, bArr.length - 1);
            C1014k.m5223a(byteArrayInputStream);
            C1014k.m5226b(byteArrayInputStream);
            byte[] bArr2 = new byte[byteArrayInputStream.available()];
            byteArrayInputStream.read(bArr2, 0, byteArrayInputStream.available());
            try {
                return Event.parseFrom(bArr2);
            } catch (InvalidProtocolBufferException e) {
            }
        }
        return null;
    }

    public static byte[] m5241a(Event event) {
        byte[] toByteArray = event.toByteArray();
        int eventType = event.getEventType();
        long varPosition = event.hasVarPosition() ? event.getVarPosition() : 0;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(toByteArray.length + 16);
        byteArrayOutputStream.write(DataType.EOBR_EVENT.ordinal());
        C1014k.m5224a(byteArrayOutputStream, eventType);
        C1014k.m5225a(byteArrayOutputStream, varPosition);
        byteArrayOutputStream.write(toByteArray);
        return byteArrayOutputStream.toByteArray();
    }
}
