package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.TruckGap;
import com.facebook.share.internal.ShareConstants;

public class C1785w extends C1762b {
    public C1785w(Cursor cursor) {
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1785w(byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public C1785w(TruckGap truckGap) {
        this(truckGap.toByteArray());
    }

    public String mo1062a() {
        return "stored_truck_gap";
    }

    public byte[] m8655b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public TruckGap m8656d() {
        try {
            return TruckGap.parseFrom(m8655b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredTruckGap", "Error parsing stored truck gap", e);
            return null;
        }
    }
}
