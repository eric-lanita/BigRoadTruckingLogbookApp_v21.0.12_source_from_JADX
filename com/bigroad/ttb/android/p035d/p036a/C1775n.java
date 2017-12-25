package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.facebook.share.internal.ShareConstants;

public class C1775n extends C1762b {
    public C1775n(Cursor cursor) {
        m8556c(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1775n(long j, byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public String mo1062a() {
        return "stored_fleet";
    }

    public byte[] m8615b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public Fleet m8616d() {
        try {
            return Fleet.parseFrom(m8615b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredFleet", "Error parsing stored fleet", e);
            return null;
        }
    }
}
