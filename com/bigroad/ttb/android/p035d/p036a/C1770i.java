package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Correction;
import com.facebook.share.internal.ShareConstants;

public class C1770i extends C1762b {
    public C1770i(Cursor cursor) {
        m8556c(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1770i(long j, byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public C1770i(Correction correction) {
        this(correction.getId(), correction.toByteArray());
    }

    public String mo1062a() {
        return "stored_correction";
    }

    public byte[] m8602b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public Correction m8603d() {
        try {
            return Correction.parseFrom(m8602b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredCorrection", "Error parsing stored Correction", e);
            return null;
        }
    }
}
