package com.urbanairship;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.util.C3746b;

class C3861p extends C3746b {
    C3861p(Context context, String str) {
        super(context, str, "ua_richpush.db", 3);
    }

    protected void mo2782a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS richpush (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_id TEXT UNIQUE, message_url TEXT, message_body_url TEXT, message_read_url TEXT, title TEXT, extra TEXT, unread INTEGER, unread_orig INTEGER, deleted INTEGER, timestamp TEXT, raw_message_object TEXT,expiration_timestamp TEXT);");
    }

    protected void mo2784a(SQLiteStatement sQLiteStatement, ContentValues contentValues) {
        m19555a(sQLiteStatement, 1, contentValues.getAsString("message_id"));
        m19555a(sQLiteStatement, 2, contentValues.getAsString("message_url"));
        m19555a(sQLiteStatement, 3, contentValues.getAsString("message_body_url"));
        m19555a(sQLiteStatement, 4, contentValues.getAsString("message_read_url"));
        m19555a(sQLiteStatement, 5, contentValues.getAsString(ShareConstants.WEB_DIALOG_PARAM_TITLE));
        m19555a(sQLiteStatement, 6, contentValues.getAsString("extra"));
        m19554a(sQLiteStatement, 7, contentValues.getAsBoolean("unread"), Boolean.valueOf(true));
        m19554a(sQLiteStatement, 8, contentValues.getAsBoolean("unread_orig"), Boolean.valueOf(true));
        m19554a(sQLiteStatement, 9, contentValues.getAsBoolean("deleted"), Boolean.valueOf(false));
        m19555a(sQLiteStatement, 10, contentValues.getAsString("timestamp"));
        m19555a(sQLiteStatement, 11, contentValues.getAsString("raw_message_object"));
        m19555a(sQLiteStatement, 12, contentValues.getAsString("expiration_timestamp"));
    }

    protected SQLiteStatement mo2781a(String str, SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement(m19548a(str, "message_id", "message_url", "message_body_url", "message_read_url", ShareConstants.WEB_DIALOG_PARAM_TITLE, "extra", "unread", "unread_orig", "deleted", "timestamp", "raw_message_object", "expiration_timestamp"));
    }

    protected void mo2785b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                sQLiteDatabase.execSQL("ALTER TABLE richpush ADD COLUMN raw_message_object TEXT;");
                break;
            case 2:
                break;
            default:
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS richpush");
                return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE richpush ADD COLUMN expiration_timestamp TEXT;");
    }

    protected void mo2783a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS richpush");
        mo2782a(sQLiteDatabase);
    }
}
