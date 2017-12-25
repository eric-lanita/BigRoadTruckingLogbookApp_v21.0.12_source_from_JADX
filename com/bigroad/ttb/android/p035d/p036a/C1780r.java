package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.facebook.share.internal.ShareConstants;

public class C1780r extends C1762b {
    public C1780r(Cursor cursor) {
        m8556c(cursor, ShareConstants.WEB_DIALOG_PARAM_ID);
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public C1780r(long j, byte[] bArr) {
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_ID, Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
    }

    public C1780r(Person person) {
        this(person.getPersonId(), person.toByteArray());
    }

    public String mo1062a() {
        return "stored_person";
    }

    public byte[] m8635b() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public Person m8636d() {
        try {
            return Person.parseFrom(m8635b());
        } catch (Throwable e) {
            C2134e.m10681d("TT-StoredPerson", "Error parsing stored person", e);
            return null;
        }
    }
}
