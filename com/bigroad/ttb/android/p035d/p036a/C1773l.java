package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.facebook.share.internal.ShareConstants;

public class C1773l extends C1762b {
    public C1773l(Cursor cursor) {
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1773l(byte[] bArr, byte[] bArr2) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, bArr);
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr2);
    }

    public C1773l(Dvir dvir) {
        this(dvir.getId().m19091d(), dvir.toByteArray());
    }

    public String mo1062a() {
        return "stored_dvir";
    }

    public byte[] m8609b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public Dvir m8610d() {
        try {
            return Dvir.parseFrom(m8609b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredDvir", "Error parsing stored DVIR", e);
            return null;
        }
    }
}
