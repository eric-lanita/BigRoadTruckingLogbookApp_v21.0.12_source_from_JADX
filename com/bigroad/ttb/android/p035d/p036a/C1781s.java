package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.PersonGroup;
import com.facebook.share.internal.ShareConstants;

public class C1781s extends C1762b {
    public C1781s(Cursor cursor) {
        m8556c(cursor, "group_id");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1781s(long j, byte[] bArr) {
        this.a.put("group_id", Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public C1781s(PersonGroup personGroup) {
        this(personGroup.getGroupId(), personGroup.toByteArray());
    }

    public String mo1062a() {
        return "stored_person_group";
    }

    public byte[] m8638b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public PersonGroup m8639d() {
        try {
            return PersonGroup.parseFrom(m8638b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredPersonGroup", "Error parsing stored person", e);
            return null;
        }
    }
}
