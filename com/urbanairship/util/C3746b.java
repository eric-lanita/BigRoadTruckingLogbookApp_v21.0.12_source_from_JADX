package com.urbanairship.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.urbanairship.C3783j;
import java.io.File;

public abstract class C3746b {
    private final SQLiteOpenHelper f13437a;

    protected abstract SQLiteStatement mo2781a(String str, SQLiteDatabase sQLiteDatabase);

    protected abstract void mo2782a(SQLiteDatabase sQLiteDatabase);

    protected abstract void mo2784a(SQLiteStatement sQLiteStatement, ContentValues contentValues);

    public C3746b(Context context, String str, String str2, int i) {
        this.f13437a = new SQLiteOpenHelper(this, context, m19540a(context, str, str2), null, i) {
            final /* synthetic */ C3746b f14004a;

            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                this.f14004a.mo2782a(sQLiteDatabase);
            }

            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                C3783j.m19725c("DataManager - Upgrading database " + sQLiteDatabase + " from version " + i + " to " + i2);
                this.f14004a.mo2785b(sQLiteDatabase, i, i2);
            }

            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                C3783j.m19725c("DataManager - Downgrading database " + sQLiteDatabase + " from version " + i + " to " + i2);
                this.f14004a.mo2783a(sQLiteDatabase, i, i2);
            }
        };
    }

    protected SQLiteDatabase m19558e() {
        int i = 0;
        while (i < 3) {
            try {
                return this.f13437a.getWritableDatabase();
            } catch (SQLiteException e) {
                SystemClock.sleep(100);
                C3783j.m19728e("DataManager - Error opening writable database. Retrying...");
                i++;
            }
        }
        return null;
    }

    protected SQLiteDatabase m19559f() {
        int i = 0;
        while (i < 3) {
            try {
                return this.f13437a.getReadableDatabase();
            } catch (SQLiteException e) {
                SystemClock.sleep(100);
                C3783j.m19728e("DataManager - Error opening readable database. Retrying...");
                i++;
            }
        }
        return null;
    }

    protected void mo2785b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C3783j.m19725c("DataManager - onUpgrade not implemented yet.");
    }

    protected void mo2783a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Unable to downgrade database");
    }

    protected String m19548a(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("INSERT INTO ");
        stringBuilder.append(str);
        stringBuilder.append(" (");
        CharSequence stringBuilder2 = new StringBuilder(128);
        stringBuilder2.append("VALUES (");
        int i = 0;
        while (i < strArr.length) {
            String str2;
            stringBuilder.append("'");
            stringBuilder.append(strArr[i]);
            stringBuilder.append("'");
            stringBuilder2.append("?");
            stringBuilder.append(i == strArr.length + -1 ? ") " : ", ");
            if (i == strArr.length - 1) {
                str2 = ");";
            } else {
                str2 = ", ";
            }
            stringBuilder2.append(str2);
            i++;
        }
        stringBuilder.append(stringBuilder2);
        return stringBuilder.toString();
    }

    protected void m19552a(SQLiteStatement sQLiteStatement, int i, int i2) {
        sQLiteStatement.bindLong(i, (long) i2);
    }

    protected void m19553a(SQLiteStatement sQLiteStatement, int i, Boolean bool) {
        if (bool == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindLong(i, bool.booleanValue() ? 1 : 0);
        }
    }

    protected void m19554a(SQLiteStatement sQLiteStatement, int i, Boolean bool, Boolean bool2) {
        if (bool == null) {
            m19553a(sQLiteStatement, i, bool2);
        } else {
            m19553a(sQLiteStatement, i, bool);
        }
    }

    protected void m19555a(SQLiteStatement sQLiteStatement, int i, String str) {
        if (str == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindString(i, str);
        }
    }

    public int m19543a(String str, String str2, String[] strArr) {
        int i = -1;
        if (str2 == null) {
            str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        SQLiteDatabase e = m19558e();
        if (e != null) {
            int i2 = 0;
            while (i2 < 3) {
                try {
                    i = e.delete(str, str2, strArr);
                    break;
                } catch (Throwable e2) {
                    C3783j.m19726c("Unable to delete item from a database", e2);
                    i2++;
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.content.ContentValues> m19549a(java.lang.String r8, android.content.ContentValues[] r9) {
        /*
        r7 = this;
        r2 = r7.m19558e();
        r0 = new java.util.ArrayList;
        r0.<init>();
        if (r2 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r2.beginTransaction();
        r3 = r7.mo2781a(r8, r2);
        r4 = r9.length;	 Catch:{ Exception -> 0x0032 }
        r1 = 0;
    L_0x0015:
        if (r1 >= r4) goto L_0x0025;
    L_0x0017:
        r5 = r9[r1];	 Catch:{ Exception -> 0x0032 }
        r6 = r7.m19541b(r3, r5);	 Catch:{ Exception -> 0x0032 }
        if (r6 == 0) goto L_0x0022;
    L_0x001f:
        r0.add(r5);	 Catch:{ Exception -> 0x0032 }
    L_0x0022:
        r1 = r1 + 1;
        goto L_0x0015;
    L_0x0025:
        r1 = r0.isEmpty();	 Catch:{ Exception -> 0x0032 }
        if (r1 != 0) goto L_0x002e;
    L_0x002b:
        r2.setTransactionSuccessful();	 Catch:{ Exception -> 0x0032 }
    L_0x002e:
        r2.endTransaction();
        goto L_0x000b;
    L_0x0032:
        r1 = move-exception;
        r3 = "Unable to insert into database";
        com.urbanairship.C3783j.m19726c(r3, r1);	 Catch:{ all -> 0x003c }
        r2.endTransaction();
        goto L_0x000b;
    L_0x003c:
        r0 = move-exception;
        r2.endTransaction();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.util.b.a(java.lang.String, android.content.ContentValues[]):java.util.List<android.content.ContentValues>");
    }

    public long m19544a(String str, ContentValues contentValues) {
        long j = -1;
        if (m19558e() != null) {
            int i = 0;
            while (i < 3) {
                try {
                    j = m19558e().replaceOrThrow(str, null, contentValues);
                    break;
                } catch (Throwable e) {
                    C3783j.m19726c("Unable to insert into database", e);
                    i++;
                }
            }
        }
        return j;
    }

    public int m19542a(String str, ContentValues contentValues, String str2, String[] strArr) {
        int i = -1;
        SQLiteDatabase e = m19558e();
        if (e != null) {
            int i2 = 0;
            while (i2 < 3) {
                try {
                    i = e.update(str, contentValues, str2, strArr);
                    break;
                } catch (Throwable e2) {
                    C3783j.m19726c("Update Failed", e2);
                    i2++;
                }
            }
        }
        return i;
    }

    public Cursor m19545a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return m19546a(str, strArr, str2, strArr2, str3, null);
    }

    public Cursor m19546a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4) {
        SQLiteDatabase f = m19559f();
        if (f == null) {
            return null;
        }
        int i = 0;
        while (i < 3) {
            try {
                return f.query(str, strArr, str2, strArr2, null, null, str3, str4);
            } catch (Throwable e) {
                C3783j.m19726c("Query Failed", e);
                i++;
            }
        }
        return null;
    }

    public void m19560g() {
        try {
            this.f13437a.close();
        } catch (Throwable e) {
            C3783j.m19726c("Failed to close the database.", e);
        }
    }

    private boolean m19541b(SQLiteStatement sQLiteStatement, ContentValues contentValues) {
        int i = 0;
        while (i < 3) {
            try {
                sQLiteStatement.clearBindings();
                mo2784a(sQLiteStatement, contentValues);
                sQLiteStatement.execute();
                return true;
            } catch (Throwable e) {
                C3783j.m19726c("Unable to insert into database", e);
                i++;
            }
        }
        return false;
    }

    private String m19540a(Context context, String str, String str2) {
        File file;
        File file2;
        File[] fileArr;
        int i = 0;
        String str3 = str + "_" + str2;
        if (VERSION.SDK_INT >= 21) {
            file = new File(context.getNoBackupFilesDir(), "com.urbanairship.databases");
            if (!file.exists()) {
                file.mkdirs();
            }
            file2 = new File(file, str3);
            fileArr = new File[]{context.getDatabasePath(str3), new File(file, str2), context.getDatabasePath(str2)};
        } else {
            file2 = context.getDatabasePath(str3);
            fileArr = new File[]{context.getDatabasePath(str2)};
        }
        if (file2.exists()) {
            return file2.getAbsolutePath();
        }
        int length = fileArr.length;
        while (i < length) {
            file = fileArr[i];
            if (file.exists()) {
                if (!file.renameTo(file2)) {
                    return file.getAbsolutePath();
                }
                File file3 = new File(file.getAbsolutePath() + "-journal");
                if (file3.exists()) {
                    file3.renameTo(new File(file2.getAbsolutePath() + "-journal"));
                }
            }
            i++;
        }
        return file2.getAbsolutePath();
    }
}
