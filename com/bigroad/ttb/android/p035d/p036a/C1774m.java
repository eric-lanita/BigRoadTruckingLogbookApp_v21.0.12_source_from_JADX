package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.facebook.share.internal.ShareConstants;

public class C1774m extends C1762b {
    public C1774m(Cursor cursor) {
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8556c(cursor, "occurred_at");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1774m(byte[] bArr, long j, byte[] bArr2) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, bArr);
        this.a.put("occurred_at", Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr2);
    }

    public C1774m(Event event) {
        this(event.getEventId().m19091d(), event.getOccurredAt(), event.toByteArray());
    }

    public String mo1062a() {
        return "stored_event";
    }

    public byte[] m8612b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public Event m8613d() {
        try {
            return Event.parseFrom(m8612b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredEvent", "Error parsing stored event", e);
            return null;
        }
    }
}
