package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.bigroad.shared.eobr.genx.C0975o;
import com.bigroad.shared.eobr.genx.C0976j;
import com.bigroad.shared.eobr.genx.GenxDataSerializationException;
import com.bigroad.shared.eobr.genx.GenxEntryResponse;
import com.bigroad.ttb.protocol.TTProtocol.GenxEntry;
import com.bigroad.ttb.protocol.TTProtocol.GenxEntry.C2671a;
import com.facebook.share.internal.ShareConstants;
import com.google.protobuf.C3642c;

public class C1776o extends C1762b {
    public static final String[] f6114b = new String[]{"mgs_serial_number", "entry_id", ShareConstants.WEB_DIALOG_PARAM_DATA, "was_synced"};

    public C1776o(Cursor cursor) {
        m8557d(cursor, "mgs_serial_number");
        m8556c(cursor, "entry_id");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
        m8553a(cursor, "was_synced");
    }

    private C1776o(String str, long j, byte[] bArr, boolean z) {
        this.a.put("mgs_serial_number", str);
        this.a.put("entry_id", Long.valueOf(j));
        this.a.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
        this.a.put("was_synced", Boolean.valueOf(z));
    }

    protected C1776o(String str, C0976j c0976j) {
        this(str, c0976j.m4995t(), c0976j.m4996u(), false);
    }

    public C0976j m8620b() {
        if (!m8623f()) {
            return null;
        }
        C0975o a = GenxEntryResponse.m4997a(m8624g());
        if (a == null) {
            throw new GenxDataSerializationException("Could not parse unversioned data");
        } else if (a instanceof C0976j) {
            return (C0976j) a;
        } else {
            throw new GenxDataSerializationException("Unexpected response type in StoredGenxEntry: " + a.getClass().getName());
        }
    }

    public String mo1062a() {
        return "stored_mgs_entry";
    }

    public String m8621d() {
        return this.a.getAsString("mgs_serial_number");
    }

    public long m8622e() {
        return this.a.getAsLong("entry_id").longValue();
    }

    public boolean m8623f() {
        return this.a.containsKey(ShareConstants.WEB_DIALOG_PARAM_DATA) && m8624g() != null;
    }

    public byte[] m8624g() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public boolean m8625h() {
        return this.a.getAsBoolean("was_synced").booleanValue();
    }

    public void m8619a(boolean z) {
        this.a.put("was_synced", Boolean.valueOf(z));
    }

    public GenxEntry m8626i() {
        C2671a a = GenxEntry.newBuilder().m14158a(m8622e());
        if (m8623f()) {
            a.m14160a(C3642c.m19078a(m8624g()));
        }
        return a.m14164c();
    }

    public static void m8617a(SQLiteStatement sQLiteStatement, C1776o c1776o) {
        sQLiteStatement.bindString(1, c1776o.m8621d());
        sQLiteStatement.bindLong(2, c1776o.m8622e());
        if (c1776o.m8623f()) {
            sQLiteStatement.bindBlob(3, c1776o.m8624g());
        } else {
            sQLiteStatement.bindNull(3);
        }
        sQLiteStatement.bindLong(4, c1776o.m8625h() ? 1 : 0);
    }
}
