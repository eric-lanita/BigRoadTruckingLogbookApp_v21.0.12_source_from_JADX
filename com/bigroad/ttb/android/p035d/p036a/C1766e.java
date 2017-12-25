package com.bigroad.ttb.android.p035d.p036a;

import android.database.Cursor;
import com.bigroad.shared.eobr.genx.C0976j;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.google.common.base.MoreObjects;

public class C1766e extends C1762b {
    protected boolean f6113b = false;

    public C1766e(Cursor cursor) {
        m8557d(cursor, "associated_serial_number");
        m8556c(cursor, "server_min_expected_entry_id");
        m8556c(cursor, "highest_fetched_entry_id");
    }

    public C1766e(String str, Long l) {
        this.a.put("associated_serial_number", str);
        this.a.put("server_min_expected_entry_id", l);
    }

    public String mo1062a() {
        return "mgs_sync_progress";
    }

    public String m8581b() {
        return this.a.getAsString("associated_serial_number");
    }

    public Long m8582d() {
        return this.a.getAsLong("highest_fetched_entry_id");
    }

    public Long m8583e() {
        return this.a.getAsLong("server_min_expected_entry_id");
    }

    public void m8580a(Long l) {
        this.a.put("highest_fetched_entry_id", l);
        this.f6113b = true;
    }

    public void m8578a(long j) {
        this.a.put("server_min_expected_entry_id", Long.valueOf(j));
        this.f6113b = true;
    }

    public C1015l m8584f() {
        Long asLong = this.a.getAsLong("last_cursor_position");
        return asLong != null ? C1015l.m5227a(asLong.longValue()) : null;
    }

    public void m8579a(C1015l c1015l) {
        this.a.put("last_cursor_position", c1015l != null ? Long.valueOf(c1015l.m5232c()) : null);
        this.f6113b = true;
    }

    public boolean m8585g() {
        return this.f6113b;
    }

    public void m8586h() {
        this.f6113b = false;
    }

    public C1776o m8576a(C0976j c0976j) {
        return new C1776o(m8581b(), c0976j);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("serialNumber", m8581b()).add("serverMinExpected", m8583e()).add("lastStoredCursorPosition", m8584f()).add("highestFetchedEntryId", m8582d()).toString();
    }
}
