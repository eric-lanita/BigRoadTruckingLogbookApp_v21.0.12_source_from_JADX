package com.urbanairship.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3783j;
import com.urbanairship.util.C3746b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class C3747k extends C3746b {
    C3747k(Context context, String str) {
        super(context, str, "ua_analytics.db", 1);
    }

    protected void mo2785b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C3783j.m19725c("EventDataManager - Upgrading analytics database from version " + i + " to " + i2 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        mo2782a(sQLiteDatabase);
    }

    protected void mo2782a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (_id INTEGER PRIMARY KEY AUTOINCREMENT,type TEXT,event_id TEXT,time INTEGER,data TEXT,session_id TEXT,event_size INTEGER);");
    }

    protected void mo2784a(SQLiteStatement sQLiteStatement, ContentValues contentValues) {
        m19555a(sQLiteStatement, 1, contentValues.getAsString(ShareConstants.MEDIA_TYPE));
        m19555a(sQLiteStatement, 2, contentValues.getAsString("event_id"));
        m19555a(sQLiteStatement, 3, contentValues.getAsString(ShareConstants.WEB_DIALOG_PARAM_DATA));
        m19552a(sQLiteStatement, 4, contentValues.getAsInteger("time").intValue());
        m19555a(sQLiteStatement, 5, contentValues.getAsString("session_id"));
        m19552a(sQLiteStatement, 6, contentValues.getAsInteger("event_size").intValue());
    }

    protected SQLiteStatement mo2781a(String str, SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.compileStatement(m19548a(str, ShareConstants.MEDIA_TYPE, "event_id", ShareConstants.WEB_DIALOG_PARAM_DATA, "time", "session_id", "event_size"));
    }

    protected void mo2783a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        mo2782a(sQLiteDatabase);
    }

    Map<String, String> m19564a(int i) {
        HashMap hashMap = new HashMap(i);
        String[] strArr = null;
        Cursor a = m19546a("events", new String[]{"event_id", ShareConstants.WEB_DIALOG_PARAM_DATA}, null, strArr, "_id ASC", "0, " + i);
        if (a == null) {
            return hashMap;
        }
        a.moveToFirst();
        while (!a.isAfterLast()) {
            hashMap.put(a.getString(0), a.getString(1));
            a.moveToNext();
        }
        a.close();
        return hashMap;
    }

    void m19565a() {
        m19543a("events", null, null);
    }

    boolean m19570a(Set<String> set) {
        if (set == null || set.size() == 0) {
            C3783j.m19723b("EventDataManager - Nothing to delete. Returning.");
            return false;
        }
        int size = set.size();
        return m19543a("events", new StringBuilder().append("event_id IN ( ").append(C3747k.m19561a("?", size, ", ")).append(" )").toString(), (String[]) set.toArray(new String[size])) > 0;
    }

    private static String m19561a(String str, int i, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
            if (i2 + 1 != i) {
                stringBuilder.append(str2);
            }
        }
        return stringBuilder.toString();
    }

    boolean m19569a(String str) {
        int a = m19543a("events", "session_id = ?", new String[]{str});
        if (a <= 0) {
            return false;
        }
        C3783j.m19725c("EventDataManager - Deleted " + a + " rows with session ID " + str);
        return true;
    }

    String m19571b() {
        String str = null;
        Cursor a = m19546a("events", new String[]{"session_id"}, null, null, "_id ASC", "0, 1");
        if (a == null) {
            C3783j.m19728e("EventDataManager - Unable to query database.");
        } else {
            if (a.moveToFirst()) {
                str = a.getString(0);
            }
            a.close();
        }
        return str;
    }

    int m19573c() {
        Integer num = null;
        Cursor a = m19546a("events", new String[]{"COUNT(*) as _cnt"}, null, null, null, null);
        if (a == null) {
            C3783j.m19728e("EventDataManager - Unable to query events database.");
            return -1;
        }
        if (a.moveToFirst()) {
            num = Integer.valueOf(a.getInt(0));
        }
        a.close();
        return num == null ? -1 : num.intValue();
    }

    int m19574d() {
        Integer num = null;
        Cursor a = m19546a("events", new String[]{"SUM(event_size) as _size"}, null, null, null, null);
        if (a == null) {
            C3783j.m19728e("EventDataManager - Unable to query events database.");
            return -1;
        }
        if (a.moveToFirst()) {
            num = Integer.valueOf(a.getInt(0));
            a.close();
        }
        return num == null ? -1 : num.intValue();
    }

    long m19562a(String str, String str2, String str3, String str4, String str5) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.MEDIA_TYPE, str);
        contentValues.put("event_id", str3);
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, str2);
        contentValues.put("time", str5);
        contentValues.put("session_id", str4);
        contentValues.put("event_size", Integer.valueOf(str2.length()));
        return m19544a("events", contentValues);
    }
}
