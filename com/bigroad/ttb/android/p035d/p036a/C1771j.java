package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.facebook.share.internal.ShareConstants;

public class C1771j extends C1762b {
    public C1771j(Cursor cursor) {
        m8554b(cursor, "log_day");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1771j(int i, byte[] bArr) {
        this.a.put("log_day", Integer.valueOf(i));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public String mo1062a() {
        return "stored_daily_log";
    }

    public byte[] m8605b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public DailyLog m8606d() {
        try {
            return DailyLog.parseFrom(m8605b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredDailyLog", "Error parsing stored daily log", e);
            return null;
        }
    }
}
