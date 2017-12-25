package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;

public class C1764c extends C1762b {
    public C1764c(String str, String str2) {
        this.a.put("file_hash", str);
        this.a.put("content_type", str2);
    }

    public C1764c(Cursor cursor) {
        m8556c(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8557d(cursor, "file_hash");
        m8557d(cursor, "content_type");
    }

    public String mo1062a() {
        return "file_upload";
    }

    public String m8573b() {
        return this.a.getAsString("file_hash");
    }

    public String m8574d() {
        return this.a.getAsString("content_type");
    }
}
