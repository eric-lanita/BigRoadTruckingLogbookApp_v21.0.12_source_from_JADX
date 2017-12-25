package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.ConversationData;
import com.facebook.share.internal.ShareConstants;

public class C1769h extends C1762b {
    public C1769h(Cursor cursor) {
        m8556c(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8556c(cursor, "modified_seq");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1769h(long j, long j2, byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, Long.valueOf(j));
        this.a.put("modified_seq", Long.valueOf(j2));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public String mo1062a() {
        return "stored_conversation";
    }

    public long m8597b() {
        return this.a.getAsLong(ShareConstants.WEB_DIALOG_PARAM_ID).longValue();
    }

    public long m8598d() {
        return this.a.getAsLong("modified_seq").longValue();
    }

    public byte[] m8599e() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public ConversationData m8600f() {
        try {
            return ConversationData.parseFrom(m8599e());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredConv", "Error parsing stored conversation", e);
            return null;
        }
    }
}
