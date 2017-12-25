package com.urbanairship;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.urbanairship.util.C3746b;

class C3822m extends C3746b {
    public C3822m(Context context, String str) {
        super(context, str, "ua_preferences.db", 1);
    }

    protected void mo2782a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (_id TEXT PRIMARY KEY, value TEXT);");
    }

    protected void mo2784a(SQLiteStatement sQLiteStatement, ContentValues contentValues) {
        m19555a(sQLiteStatement, 1, contentValues.getAsString("_id"));
        m19555a(sQLiteStatement, 2, contentValues.getAsString("value"));
    }

    protected SQLiteStatement mo2781a(String str, SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement(m19548a(str, "_id", "value"));
    }

    protected void mo2783a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
        mo2782a(sQLiteDatabase);
    }
}
