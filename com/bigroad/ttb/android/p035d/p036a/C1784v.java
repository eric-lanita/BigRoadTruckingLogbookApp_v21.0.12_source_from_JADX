package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.facebook.share.internal.ShareConstants;

public class C1784v extends C1762b {
    public C1784v(Cursor cursor) {
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1784v(byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public C1784v(Truck truck) {
        this(truck.toByteArray());
    }

    public String mo1062a() {
        return "stored_truck";
    }

    public byte[] m8652b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public Truck m8653d() {
        try {
            return Truck.parseFrom(m8652b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredTruck", "Error parsing stored truck", e);
            return null;
        }
    }
}
