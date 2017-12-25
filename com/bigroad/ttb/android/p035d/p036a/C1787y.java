package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.bigroad.shared.eobr.turbo.C1009h;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.android.eobr.turbo.VarPage;
import com.bigroad.ttb.android.logging.C2134e;
import com.facebook.share.internal.ShareConstants;

public class C1787y extends C1762b {
    public static final String[] f6117b = new String[]{"dash_link_id", "page_number", ShareConstants.WEB_DIALOG_PARAM_DATA, "was_synced", "is_complete", "is_carry_over_complete", "start_utc_timestamp", "first_timestamped_entry_index", "last_uptime_to_utc_offset", "last_eobr_event_position", "last_cursor_reset_position", "reset_cause", "reset_sub_code"};

    public C1787y(Cursor cursor) {
        m8558e(cursor, "dash_link_id");
        m8554b(cursor, "page_number");
        m8558e(cursor, ShareConstants.WEB_DIALOG_PARAM_DATA);
        m8553a(cursor, "was_synced");
        m8553a(cursor, "is_complete");
        m8553a(cursor, "is_carry_over_complete");
        m8556c(cursor, "start_utc_timestamp");
        m8554b(cursor, "first_timestamped_entry_index");
        m8556c(cursor, "last_uptime_to_utc_offset");
        m8556c(cursor, "last_eobr_event_position");
        m8556c(cursor, "last_cursor_reset_position");
        m8554b(cursor, "reset_cause");
        m8554b(cursor, "reset_sub_code");
    }

    private static byte[] m8665a(VarPage varPage) {
        byte[] c = varPage.m9610c();
        byte[] a = C1009h.m5183a(varPage.m9610c());
        if (a != null) {
            return a;
        }
        C2134e.m10680d("TT-StoredVarPage", "Could not remove filler bytes from VAR page.");
        return c;
    }

    private static void m8663a(SQLiteStatement sQLiteStatement, int i, Long l) {
        if (l == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindLong(i, l.longValue());
        }
    }

    private static void m8662a(SQLiteStatement sQLiteStatement, int i, Integer num) {
        if (num == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindLong(i, (long) num.intValue());
        }
    }

    public static void m8664a(SQLiteStatement sQLiteStatement, VarPage varPage) {
        long j;
        long j2 = 1;
        sQLiteStatement.bindBlob(1, varPage.m9606a());
        C1787y.m8663a(sQLiteStatement, 2, Long.valueOf(varPage.m9607b()));
        sQLiteStatement.bindBlob(3, C1787y.m8665a(varPage));
        sQLiteStatement.bindLong(4, varPage.m9612e() ? 1 : 0);
        if (varPage.m9611d()) {
            j = 1;
        } else {
            j = 0;
        }
        sQLiteStatement.bindLong(5, j);
        if (!varPage.m9624q()) {
            j2 = 0;
        }
        sQLiteStatement.bindLong(6, j2);
        C1787y.m8663a(sQLiteStatement, 7, varPage.m9620m());
        C1787y.m8662a(sQLiteStatement, 8, varPage.m9622o());
        C1787y.m8663a(sQLiteStatement, 9, varPage.m9623p());
        if (varPage.m9613f() == null) {
            sQLiteStatement.bindNull(10);
        } else {
            sQLiteStatement.bindLong(10, varPage.m9613f().m5232c());
        }
        if (varPage.m9615h() == null) {
            sQLiteStatement.bindNull(11);
        } else {
            sQLiteStatement.bindLong(11, varPage.m9615h().m5232c());
        }
        C1787y.m8662a(sQLiteStatement, 12, varPage.m9616i());
        C1787y.m8662a(sQLiteStatement, 13, varPage.m9617j());
    }

    public String mo1062a() {
        return "stored_var_page";
    }

    public byte[] m8667b() {
        return this.a.getAsByteArray("dash_link_id");
    }

    public long m8668d() {
        return this.a.getAsLong("page_number").longValue();
    }

    public byte[] m8669e() {
        return this.a.getAsByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    public boolean m8670f() {
        return this.a.getAsBoolean("is_complete").booleanValue();
    }

    public boolean m8671g() {
        return this.a.getAsBoolean("was_synced").booleanValue();
    }

    public boolean m8672h() {
        return this.a.getAsBoolean("is_carry_over_complete").booleanValue();
    }

    public Long m8673i() {
        return this.a.getAsLong("start_utc_timestamp");
    }

    public Integer m8674j() {
        return this.a.getAsInteger("first_timestamped_entry_index");
    }

    public Long m8675k() {
        return this.a.getAsLong("last_uptime_to_utc_offset");
    }

    public C1015l m8676l() {
        Long asLong = this.a.getAsLong("last_eobr_event_position");
        return asLong != null ? C1015l.m5227a(asLong.longValue()) : null;
    }

    public C1015l m8677m() {
        Long asLong = this.a.getAsLong("last_cursor_reset_position");
        return asLong != null ? C1015l.m5227a(asLong.longValue()) : null;
    }

    public Integer m8678n() {
        return this.a.getAsInteger("reset_cause");
    }

    public Integer m8679o() {
        return this.a.getAsInteger("reset_sub_code");
    }

    public VarPage m8680p() {
        byte[] e = m8669e();
        VarPage varPage = new VarPage(m8667b(), m8668d(), e, m8670f(), m8671g(), m8672h(), m8673i(), m8674j(), m8675k(), m8676l(), m8677m(), m8678n(), m8679o());
        if (e != null) {
            varPage.m9605a((long) e.length);
        }
        return varPage;
    }
}
