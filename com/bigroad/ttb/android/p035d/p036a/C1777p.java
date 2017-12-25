package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;

public class C1777p extends C1762b {
    public C1777p(String str, byte[] bArr) {
        this.a.put("key", str);
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public C1777p(Cursor cursor) {
        m8557d(cursor, "key");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public String mo1062a() {
        return "stored_key_values";
    }

    public byte[] m8628b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }
}
