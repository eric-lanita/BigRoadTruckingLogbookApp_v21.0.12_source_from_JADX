package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class zzw implements zzc {
    private static final String f12835a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    private final Executor f12836b;
    private final Context f12837c;
    private zza f12838d;
    private zze f12839e;
    private int f12840f;

    class zza extends SQLiteOpenHelper {
        final /* synthetic */ zzw f12832a;

        zza(zzw com_google_android_gms_tagmanager_zzw, Context context, String str) {
            this.f12832a = com_google_android_gms_tagmanager_zzw;
            super(context, str, null, 1);
        }

        private void m18250a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m18251a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            String str2;
            String valueOf;
            Throwable th;
            Cursor cursor2 = null;
            try {
                Cursor query = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        str2 = "Error querying for table ";
                        valueOf = String.valueOf(str);
                        zzbn.zzcx(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                str2 = "Error querying for table ";
                valueOf = String.valueOf(str);
                if (valueOf.length() == 0) {
                }
                zzbn.zzcx(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf));
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.f12832a.f12837c.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            zzam.m18081a(sQLiteDatabase.getPath());
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m18251a("datalayer", sQLiteDatabase)) {
                m18250a(sQLiteDatabase);
            } else {
                sQLiteDatabase.execSQL(zzw.f12835a);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    private static class zzb {
        final String f12833a;
        final byte[] f12834b;

        zzb(String str, byte[] bArr) {
            this.f12833a = str;
            this.f12834b = bArr;
        }

        public String toString() {
            String str = this.f12833a;
            return new StringBuilder(String.valueOf(str).length() + 54).append("KeyAndSerialized: key = ").append(str).append(" serialized hash = ").append(Arrays.hashCode(this.f12834b)).toString();
        }
    }

    public zzw(Context context) {
        this(context, zzh.zzavm(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zze com_google_android_gms_common_util_zze, String str, int i, Executor executor) {
        this.f12837c = context;
        this.f12839e = com_google_android_gms_common_util_zze;
        this.f12840f = i;
        this.f12836b = executor;
        this.f12838d = new zza(this, this.f12837c, str);
    }

    private Object m18252a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream2 = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream = objectInputStream2;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream = objectInputStream2;
            th = th4;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private List<zza> m18255a(List<zzb> list) {
        List<zza> arrayList = new ArrayList();
        for (zzb com_google_android_gms_tagmanager_zzw_zzb : list) {
            arrayList.add(new zza(com_google_android_gms_tagmanager_zzw_zzb.f12833a, m18252a(com_google_android_gms_tagmanager_zzw_zzb.f12834b)));
        }
        return arrayList;
    }

    private void m18256a(int i) {
        int d = (m18271d() - this.f12840f) + i;
        if (d > 0) {
            List b = m18267b(d);
            zzbn.zzcw("DataLayer store full, deleting " + b.size() + " entries to make room.");
            m18262a((String[]) b.toArray(new String[0]));
        }
    }

    private void m18257a(long j) {
        SQLiteDatabase b = m18265b("Error opening database for deleteOlderThan.");
        if (b != null) {
            try {
                zzbn.m18106v("Deleted " + b.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                zzbn.zzcx("Error deleting old entries.");
            }
        }
    }

    private void m18260a(String str) {
        SQLiteDatabase b = m18265b("Error opening database for clearKeysWithPrefix.");
        if (b != null) {
            try {
                zzbn.m18106v("Cleared " + b.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")}) + " items");
            } catch (SQLiteException e) {
                String valueOf = String.valueOf(e);
                zzbn.zzcx(new StringBuilder((String.valueOf(str).length() + 44) + String.valueOf(valueOf).length()).append("Error deleting entries with key prefix: ").append(str).append(" (").append(valueOf).append(").").toString());
            } finally {
                m18272e();
            }
        }
    }

    private synchronized void m18261a(List<zzb> list, long j) {
        try {
            long currentTimeMillis = this.f12839e.currentTimeMillis();
            m18257a(currentTimeMillis);
            m18256a(list.size());
            m18269b(list, currentTimeMillis + j);
            m18272e();
        } catch (Throwable th) {
            m18272e();
        }
    }

    private void m18262a(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase b = m18265b("Error opening database for deleteEntries.");
            if (b != null) {
                try {
                    b.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    String str = "Error deleting entries ";
                    String valueOf = String.valueOf(Arrays.toString(strArr));
                    zzbn.zzcx(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
            }
        }
    }

    private byte[] m18263a(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private SQLiteDatabase m18265b(String str) {
        try {
            return this.f12838d.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbn.zzcx(str);
            return null;
        }
    }

    private List<zza> m18266b() {
        try {
            m18257a(this.f12839e.currentTimeMillis());
            List<zza> a = m18255a(m18270c());
            return a;
        } finally {
            m18272e();
        }
    }

    private List<String> m18267b(int i) {
        Cursor query;
        SQLiteException e;
        String str;
        String valueOf;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (i <= 0) {
            zzbn.zzcx("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase b = m18265b("Error opening database for peekEntryIds.");
        if (b == null) {
            return arrayList;
        }
        try {
            query = b.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    str = "Error in peekEntries fetching entryIds: ";
                    valueOf = String.valueOf(e.getMessage());
                    zzbn.zzcx(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            str = "Error in peekEntries fetching entryIds: ";
            valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() == 0) {
            }
            zzbn.zzcx(valueOf.length() == 0 ? str.concat(valueOf) : new String(str));
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    private List<zzb> m18268b(List<zza> list) {
        List<zzb> arrayList = new ArrayList();
        for (zza com_google_android_gms_tagmanager_DataLayer_zza : list) {
            arrayList.add(new zzb(com_google_android_gms_tagmanager_DataLayer_zza.zzaxp, m18263a(com_google_android_gms_tagmanager_DataLayer_zza.zzcnn)));
        }
        return arrayList;
    }

    private void m18269b(List<zzb> list, long j) {
        SQLiteDatabase b = m18265b("Error opening database for writeEntryToDatabase.");
        if (b != null) {
            for (zzb com_google_android_gms_tagmanager_zzw_zzb : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", com_google_android_gms_tagmanager_zzw_zzb.f12833a);
                contentValues.put("value", com_google_android_gms_tagmanager_zzw_zzb.f12834b);
                b.insert("datalayer", null, contentValues);
            }
        }
    }

    private List<zzb> m18270c() {
        SQLiteDatabase b = m18265b("Error opening database for loadSerialized.");
        List<zzb> arrayList = new ArrayList();
        if (b == null) {
            return arrayList;
        }
        Cursor query = b.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzb(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int m18271d() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase b = m18265b("Error opening database for getNumStoredEntries.");
        if (b != null) {
            try {
                cursor = b.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                zzbn.zzcx("Error getting numStoredEntries");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    private void m18272e() {
        try {
            this.f12838d.close();
        } catch (SQLiteException e) {
        }
    }

    public void zza(final com.google.android.gms.tagmanager.DataLayer.zzc.zza com_google_android_gms_tagmanager_DataLayer_zzc_zza) {
        this.f12836b.execute(new Runnable(this) {
            final /* synthetic */ zzw f12829b;

            public void run() {
                com_google_android_gms_tagmanager_DataLayer_zzc_zza.zzaf(this.f12829b.m18266b());
            }
        });
    }

    public void zza(List<zza> list, final long j) {
        final List b = m18268b((List) list);
        this.f12836b.execute(new Runnable(this) {
            final /* synthetic */ zzw f12827c;

            public void run() {
                this.f12827c.m18261a(b, j);
            }
        });
    }

    public void zzoo(final String str) {
        this.f12836b.execute(new Runnable(this) {
            final /* synthetic */ zzw f12831b;

            public void run() {
                this.f12831b.m18260a(str);
            }
        });
    }
}
