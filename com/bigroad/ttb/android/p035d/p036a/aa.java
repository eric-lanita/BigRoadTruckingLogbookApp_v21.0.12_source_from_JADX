package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.google.common.base.MoreObjects;

public class aa extends C1762b {
    private boolean f6112b = false;

    public aa(Cursor cursor) {
        m8558e(cursor, "dash_link_id");
        m8556c(cursor, "server_min_expected_var_page_number");
        m8556c(cursor, "highest_fetched_page_number");
    }

    public aa(byte[] bArr, Long l, Long l2) {
        this.a.put("dash_link_id", bArr);
        this.a.put("server_min_expected_var_page_number", l);
        this.a.put("highest_fetched_page_number", l2);
    }

    public boolean m8565b() {
        return this.f6112b;
    }

    public void m8566d() {
        this.f6112b = false;
    }

    public String mo1062a() {
        return "var_sync_progress";
    }

    public byte[] m8567e() {
        return this.a.getAsByteArray("dash_link_id");
    }

    public void m8563a(Long l) {
        this.a.put("highest_fetched_page_number", l);
        this.f6112b = true;
    }

    public void m8564b(Long l) {
        this.a.put("server_min_expected_var_page_number", l);
        this.f6112b = true;
    }

    public void m8562a(C1015l c1015l) {
        this.a.put("last_cursor_position", c1015l != null ? Long.valueOf(c1015l.m5232c()) : null);
        this.f6112b = true;
    }

    public Long m8568f() {
        return this.a.getAsLong("server_min_expected_var_page_number");
    }

    public Long m8569g() {
        return this.a.getAsLong("highest_fetched_page_number");
    }

    public C1015l m8570h() {
        Long asLong = this.a.getAsLong("last_cursor_position");
        return asLong != null ? C1015l.m5227a(asLong.longValue()) : null;
    }

    public Long m8571i() {
        return this.a.getAsLong("last_event_sequence_number");
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("dashLinkId", C1180y.m5996c(m8567e())).add("serverMinExpected", m8568f()).add("clientHighestFetched", m8569g()).add("lastStoredCursorPosition", m8570h()).add("lastStoredSequenceNumber", m8571i()).toString();
    }
}
