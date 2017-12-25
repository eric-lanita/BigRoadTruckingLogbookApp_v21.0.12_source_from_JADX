package com.bigroad.ttb.android.p035d.p036a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;

public abstract class C1762b {
    protected final ContentValues f6111a = new ContentValues();

    public abstract String mo1062a();

    protected void m8553a(Cursor cursor, String str) {
        this.f6111a.put(str, Boolean.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(str)) != 0));
    }

    protected void m8554b(Cursor cursor, String str) {
        DatabaseUtils.cursorIntToContentValues(cursor, str, this.f6111a);
    }

    protected void m8556c(Cursor cursor, String str) {
        DatabaseUtils.cursorLongToContentValues(cursor, str, this.f6111a);
    }

    protected void m8557d(Cursor cursor, String str) {
        DatabaseUtils.cursorStringToContentValues(cursor, str, this.f6111a);
    }

    protected void m8558e(Cursor cursor, String str) {
        this.f6111a.put(str, cursor.getBlob(cursor.getColumnIndexOrThrow(str)));
    }

    public ContentValues m8555c() {
        return this.f6111a;
    }
}
