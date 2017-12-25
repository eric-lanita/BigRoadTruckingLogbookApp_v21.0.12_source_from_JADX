package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.facebook.share.internal.ShareConstants;

public class C1768g extends C1762b {
    public C1768g(Cursor cursor) {
        m8556c(cursor, "owner_person_id");
        m8554b(cursor, "log_day");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public String mo1062a() {
        return "stored_auto_daily_log_truck";
    }

    public long m8592b() {
        return this.a.getAsLong("owner_person_id").longValue();
    }

    public int m8593d() {
        return this.a.getAsInteger("log_day").intValue();
    }

    public byte[] m8594e() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public AutoDailyLogTruck m8595f() {
        try {
            return AutoDailyLogTruck.parseFrom(m8594e());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredAdlt", "Error parsing stored auto daily log truck", e);
            return null;
        }
    }
}
