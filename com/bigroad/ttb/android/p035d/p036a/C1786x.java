package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.shared.C1144s;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.facebook.share.internal.ShareConstants;

public class C1786x extends C1762b {
    public C1786x(Cursor cursor) {
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8558e(cursor, "device_id");
        m8556c(cursor, "occurred_at");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
        m8553a(cursor, "is_ignored");
    }

    public C1786x(byte[] bArr, byte[] bArr2, long j, byte[] bArr3, boolean z) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, bArr);
        this.a.put("device_id", bArr2);
        this.a.put("occurred_at", Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr3);
        this.a.put("is_ignored", Boolean.valueOf(z));
    }

    public C1786x(Event event) {
        this(event.getEventId().m19091d(), C1144s.m5764d(event), event.getOccurredAt(), event.toByteArray(), false);
    }

    public String mo1062a() {
        return "stored_unclaimed_event";
    }

    public byte[] m8658b() {
        return this.a.getAsByteArray("device_id");
    }

    public byte[] m8659d() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public boolean m8660e() {
        return this.a.getAsBoolean("is_ignored").booleanValue();
    }

    public Event m8661f() {
        try {
            return Event.parseFrom(m8659d());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredUnclaimedEvent", "Error parsing stored unclaimed event", e);
            return null;
        }
    }
}
