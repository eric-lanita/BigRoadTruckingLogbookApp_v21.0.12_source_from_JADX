package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;

public class C1767f extends C1762b {
    public C1767f(byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, bArr);
    }

    public C1767f(long j, byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, bArr);
    }

    public C1767f(Cursor cursor) {
        m8556c(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8558e(cursor, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        m8553a(cursor, "frozen");
    }

    public String mo1062a() {
        return "queued_request";
    }

    public long m8588b() {
        return this.a.getAsLong(ShareConstants.WEB_DIALOG_PARAM_ID).longValue();
    }

    public byte[] m8589d() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
    }

    public boolean m8590e() {
        return this.a.getAsBoolean("frozen").booleanValue();
    }
}
