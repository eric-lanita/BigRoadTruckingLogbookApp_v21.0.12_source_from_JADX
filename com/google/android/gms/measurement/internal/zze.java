package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.support.v4.p008d.C0270a;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzapn;
import com.google.android.gms.internal.zzapo;
import com.google.android.gms.internal.zzuh.zzf;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zze extends zzaa {
    private static final Map<String, String> f12254a = new C0270a(16);
    private final zzc f12255c = new zzc(this, getContext(), m17867f());
    private final zzah f12256d = new zzah(zzyw());

    public static class zza {
        long f12249a;
        long f12250b;
        long f12251c;
        long f12252d;
    }

    interface zzb {
        boolean zza(long j, com.google.android.gms.internal.zzuh.zzb com_google_android_gms_internal_zzuh_zzb);

        void zzc(com.google.android.gms.internal.zzuh.zze com_google_android_gms_internal_zzuh_zze);
    }

    private class zzc extends SQLiteOpenHelper {
        final /* synthetic */ zze f12253a;

        zzc(zze com_google_android_gms_measurement_internal_zze, Context context, String str) {
            this.f12253a = com_google_android_gms_measurement_internal_zze;
            super(context, str, null, 1);
        }

        private void m17842a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) {
            if (!m17844a(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                m17843a(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                this.f12253a.zzbsd().zzbsv().zzj("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        private void m17843a(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) {
            Set b = m17845b(sQLiteDatabase, str);
            String[] split = str2.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String str3 = split[i];
                if (b.remove(str3)) {
                    i++;
                } else {
                    throw new SQLiteException(new StringBuilder((String.valueOf(str).length() + 35) + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
                }
            }
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (!b.remove(entry.getKey())) {
                        sQLiteDatabase.execSQL((String) entry.getValue());
                    }
                }
            }
            if (!b.isEmpty()) {
                throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 30).append("Table ").append(str).append(" table has extra columns").toString());
            }
        }

        private boolean m17844a(SQLiteDatabase sQLiteDatabase, String str) {
            Object e;
            Throwable th;
            Cursor cursor = null;
            Cursor query;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e2) {
                    e = e2;
                    try {
                        this.f12253a.zzbsd().zzbsx().zze("Error querying for table", str, e);
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (SQLiteException e3) {
                e = e3;
                query = null;
                this.f12253a.zzbsd().zzbsx().zze("Error querying for table", str, e);
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        private Set<String> m17845b(SQLiteDatabase sQLiteDatabase, String str) {
            Set<String> hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (this.f12253a.f12256d.zzx(this.f12253a.zzbsf().m17838h())) {
                SQLiteDatabase writableDatabase;
                try {
                    writableDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.f12253a.f12256d.start();
                    this.f12253a.zzbsd().zzbsv().log("Opening the database failed, dropping and recreating it");
                    this.f12253a.getContext().getDatabasePath(this.f12253a.m17867f()).delete();
                    try {
                        writableDatabase = super.getWritableDatabase();
                        this.f12253a.f12256d.clear();
                    } catch (SQLiteException e2) {
                        this.f12253a.zzbsd().zzbsv().zzj("Failed to open freshly created database", e2);
                        throw e2;
                    }
                }
                return writableDatabase;
            }
            throw new SQLiteException("Database open failed");
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                file.setReadable(false, false);
                file.setWritable(false, false);
                file.setReadable(true, true);
                file.setWritable(true, true);
            }
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
            m17842a(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", null);
            m17842a(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", null);
            m17842a(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.f12254a);
            m17842a(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", null);
            m17842a(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
            m17842a(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", null);
            m17842a(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
            m17842a(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
            m17842a(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        f12254a.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        f12254a.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        f12254a.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        f12254a.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        f12254a.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        f12254a.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        f12254a.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        f12254a.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        f12254a.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        f12254a.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        f12254a.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        f12254a.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        f12254a.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        f12254a.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        f12254a.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        f12254a.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
    }

    zze(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    @TargetApi(11)
    static int m17846a(Cursor cursor, int i) {
        if (VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        return window.isNull(position, i) ? 0 : window.isLong(position, i) ? 1 : window.isFloat(position, i) ? 2 : window.isString(position, i) ? 3 : window.isBlob(position, i) ? 4 : -1;
    }

    private long m17847a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = m17866e().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private long m17848a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            cursor = m17866e().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void m17850a(String str, com.google.android.gms.internal.zzuf.zza com_google_android_gms_internal_zzuf_zza) {
        Object obj = null;
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(com_google_android_gms_internal_zzuf_zza);
        zzab.zzy(com_google_android_gms_internal_zzuf_zza.amB);
        zzab.zzy(com_google_android_gms_internal_zzuf_zza.amA);
        if (com_google_android_gms_internal_zzuf_zza.amz == null) {
            zzbsd().zzbsx().log("Audience with no ID");
            return;
        }
        int intValue = com_google_android_gms_internal_zzuf_zza.amz.intValue();
        for (com.google.android.gms.internal.zzuf.zzb com_google_android_gms_internal_zzuf_zzb : com_google_android_gms_internal_zzuf_zza.amB) {
            if (com_google_android_gms_internal_zzuf_zzb.amD == null) {
                zzbsd().zzbsx().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", str, com_google_android_gms_internal_zzuf_zza.amz);
                return;
            }
        }
        for (com.google.android.gms.internal.zzuf.zze com_google_android_gms_internal_zzuf_zze : com_google_android_gms_internal_zzuf_zza.amA) {
            if (com_google_android_gms_internal_zzuf_zze.amD == null) {
                zzbsd().zzbsx().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", str, com_google_android_gms_internal_zzuf_zza.amz);
                return;
            }
        }
        Object obj2 = 1;
        for (com.google.android.gms.internal.zzuf.zzb a : com_google_android_gms_internal_zzuf_zza.amB) {
            if (!m17851a(str, intValue, a)) {
                obj2 = null;
                break;
            }
        }
        if (obj2 != null) {
            for (com.google.android.gms.internal.zzuf.zze a2 : com_google_android_gms_internal_zzuf_zza.amA) {
                if (!m17852a(str, intValue, a2)) {
                    break;
                }
            }
        }
        obj = obj2;
        if (obj == null) {
            m17858a(str, intValue);
        }
    }

    private boolean m17851a(String str, int i, com.google.android.gms.internal.zzuf.zzb com_google_android_gms_internal_zzuf_zzb) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(com_google_android_gms_internal_zzuf_zzb);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzuf_zzb.amE)) {
            zzbsd().zzbsx().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzuf_zzb.amD));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzuf_zzb.aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            com_google_android_gms_internal_zzuf_zzb.zza(zzbe);
            zzbe.az();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzuf_zzb.amD);
            contentValues.put("event_name", com_google_android_gms_internal_zzuf_zzb.amE);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (m17866e().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzbsd().zzbsv().log("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    private boolean m17852a(String str, int i, com.google.android.gms.internal.zzuf.zze com_google_android_gms_internal_zzuf_zze) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(com_google_android_gms_internal_zzuf_zze);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzuf_zze.amT)) {
            zzbsd().zzbsx().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(com_google_android_gms_internal_zzuf_zze.amD));
            return false;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzuf_zze.aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            com_google_android_gms_internal_zzuf_zze.zza(zzbe);
            zzbe.az();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", com_google_android_gms_internal_zzuf_zze.amD);
            contentValues.put("property_name", com_google_android_gms_internal_zzuf_zze.amT);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (m17866e().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                zzbsd().zzbsv().log("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    private boolean m17854j() {
        return getContext().getDatabasePath(m17867f()).exists();
    }

    Map<Integer, List<com.google.android.gms.internal.zzuf.zzb>> m17855a(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzhr(str2);
        Map<Integer, List<com.google.android.gms.internal.zzuf.zzb>> c0270a = new C0270a();
        try {
            query = m17866e().query("event_filters", new String[]{"audience_id", ShareConstants.WEB_DIALOG_PARAM_DATA}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        zzapn zzbd = zzapn.zzbd(query.getBlob(1));
                        com.google.android.gms.internal.zzuf.zzb com_google_android_gms_internal_zzuf_zzb = new com.google.android.gms.internal.zzuf.zzb();
                        try {
                            com.google.android.gms.internal.zzuf.zzb com_google_android_gms_internal_zzuf_zzb2 = (com.google.android.gms.internal.zzuf.zzb) com_google_android_gms_internal_zzuf_zzb.zzb(zzbd);
                            int i = query.getInt(0);
                            List list = (List) c0270a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c0270a.put(Integer.valueOf(i), list);
                            }
                            list.add(com_google_android_gms_internal_zzuf_zzb);
                        } catch (IOException e2) {
                            zzbsd().zzbsv().zze("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return c0270a;
            }
            Map<Integer, List<com.google.android.gms.internal.zzuf.zzb>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                zzbsd().zzbsv().zzj("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    void m17856a(ContentValues contentValues, String str, Object obj) {
        zzab.zzhr(str);
        zzab.zzy(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    void m17857a(String str) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        SQLiteDatabase e = m17866e();
        e.delete("property_filters", "app_id=?", new String[]{str});
        e.delete("event_filters", "app_id=?", new String[]{str});
    }

    void m17858a(String str, int i) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        SQLiteDatabase e = m17866e();
        e.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        e.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    void m17859a(String str, int i, zzf com_google_android_gms_internal_zzuh_zzf) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(com_google_android_gms_internal_zzuh_zzf);
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzuh_zzf.aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            com_google_android_gms_internal_zzuh_zzf.zza(zzbe);
            zzbe.az();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (m17866e().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzbsd().zzbsv().log("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing filter results", e);
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    void m17860a(String str, com.google.android.gms.internal.zzuf.zza[] com_google_android_gms_internal_zzuf_zzaArr) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzy(com_google_android_gms_internal_zzuf_zzaArr);
        SQLiteDatabase e = m17866e();
        e.beginTransaction();
        try {
            m17857a(str);
            for (com.google.android.gms.internal.zzuf.zza a : com_google_android_gms_internal_zzuf_zzaArr) {
                m17850a(str, a);
            }
            e.setTransactionSuccessful();
        } finally {
            e.endTransaction();
        }
    }

    Object m17861b(Cursor cursor, int i) {
        int a = m17846a(cursor, i);
        switch (a) {
            case 0:
                zzbsd().zzbsv().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzbsd().zzbsv().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzbsd().zzbsv().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(a));
                return null;
        }
    }

    Map<Integer, zzf> m17862b(String str) {
        Cursor query;
        Object e;
        Cursor cursor;
        Throwable th;
        m17715c();
        zzwu();
        zzab.zzhr(str);
        try {
            query = m17866e().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    Map<Integer, zzf> c0270a = new C0270a();
                    do {
                        int i = query.getInt(0);
                        zzapn zzbd = zzapn.zzbd(query.getBlob(1));
                        zzf com_google_android_gms_internal_zzuh_zzf = new zzf();
                        try {
                            zzf com_google_android_gms_internal_zzuh_zzf2 = (zzf) com_google_android_gms_internal_zzuh_zzf.zzb(zzbd);
                            c0270a.put(Integer.valueOf(i), com_google_android_gms_internal_zzuh_zzf);
                        } catch (IOException e2) {
                            zzbsd().zzbsv().zzd("Failed to merge filter results. appId, audienceId, error", str, Integer.valueOf(i), e2);
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return c0270a;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                zzbsd().zzbsv().zzj("Database error querying filter results", e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    Map<Integer, List<com.google.android.gms.internal.zzuf.zze>> m17863b(String str, String str2) {
        Cursor query;
        Object e;
        Throwable th;
        m17715c();
        zzwu();
        zzab.zzhr(str);
        zzab.zzhr(str2);
        Map<Integer, List<com.google.android.gms.internal.zzuf.zze>> c0270a = new C0270a();
        try {
            query = m17866e().query("property_filters", new String[]{"audience_id", ShareConstants.WEB_DIALOG_PARAM_DATA}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
            if (query.moveToFirst()) {
                do {
                    try {
                        zzapn zzbd = zzapn.zzbd(query.getBlob(1));
                        com.google.android.gms.internal.zzuf.zze com_google_android_gms_internal_zzuf_zze = new com.google.android.gms.internal.zzuf.zze();
                        try {
                            com.google.android.gms.internal.zzuf.zze com_google_android_gms_internal_zzuf_zze2 = (com.google.android.gms.internal.zzuf.zze) com_google_android_gms_internal_zzuf_zze.zzb(zzbd);
                            int i = query.getInt(0);
                            List list = (List) c0270a.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                c0270a.put(Integer.valueOf(i), list);
                            }
                            list.add(com_google_android_gms_internal_zzuf_zze);
                        } catch (IOException e2) {
                            zzbsd().zzbsv().zze("Failed to merge filter", str, e2);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return c0270a;
            }
            Map<Integer, List<com.google.android.gms.internal.zzuf.zze>> emptyMap = Collections.emptyMap();
            if (query == null) {
                return emptyMap;
            }
            query.close();
            return emptyMap;
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            try {
                zzbsd().zzbsv().zzj("Database error querying filters", e);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void beginTransaction() {
        m17715c();
        m17866e().beginTransaction();
    }

    void m17864c(String str) {
        m17715c();
        zzwu();
        zzab.zzhr(str);
        try {
            SQLiteDatabase e = m17866e();
            String[] strArr = new String[]{str};
            int delete = e.delete("audience_filter_values", "app_id=?", strArr) + (((((((e.delete("events", "app_id=?", strArr) + 0) + e.delete("user_attributes", "app_id=?", strArr)) + e.delete("apps", "app_id=?", strArr)) + e.delete("raw_events", "app_id=?", strArr)) + e.delete("raw_events_metadata", "app_id=?", strArr)) + e.delete("event_filters", "app_id=?", strArr)) + e.delete("property_filters", "app_id=?", strArr));
            if (delete > 0) {
                zzbsd().zzbtc().zze("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            zzbsd().zzbsv().zze("Error deleting application data. appId, error", str, e2);
        }
    }

    protected void mo2375d() {
    }

    SQLiteDatabase m17866e() {
        zzwu();
        try {
            return this.f12255c.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbsd().zzbsx().zzj("Error opening database", e);
            throw e;
        }
    }

    public void endTransaction() {
        m17715c();
        m17866e().endTransaction();
    }

    String m17867f() {
        if (!zzbsf().zzabc()) {
            return zzbsf().zzacc();
        }
        if (zzbsf().zzabd()) {
            return zzbsf().zzacc();
        }
        zzbsd().zzbsy().log("Using secondary database");
        return zzbsf().zzacd();
    }

    void m17868g() {
        zzwu();
        m17715c();
        if (m17854j()) {
            long j = zzbse().akb.get();
            long elapsedRealtime = zzyw().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzbsf().zzbrg()) {
                zzbse().akb.set(elapsedRealtime);
                m17869h();
            }
        }
    }

    void m17869h() {
        zzwu();
        m17715c();
        if (m17854j()) {
            int delete = m17866e().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzyw().currentTimeMillis()), String.valueOf(zzbsf().zzbrf())});
            if (delete > 0) {
                zzbsd().zzbtc().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public void setTransactionSuccessful() {
        m17715c();
        m17866e().setTransactionSuccessful();
    }

    public zza zza(long j, String str, boolean z, boolean z2, boolean z3) {
        Object e;
        Throwable th;
        zzab.zzhr(str);
        zzwu();
        m17715c();
        String[] strArr = new String[]{str};
        zza com_google_android_gms_measurement_internal_zze_zza = new zza();
        Cursor query;
        try {
            SQLiteDatabase e2 = m17866e();
            query = e2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    if (query.getLong(0) == j) {
                        com_google_android_gms_measurement_internal_zze_zza.f12250b = query.getLong(1);
                        com_google_android_gms_measurement_internal_zze_zza.f12249a = query.getLong(2);
                        com_google_android_gms_measurement_internal_zze_zza.f12251c = query.getLong(3);
                        com_google_android_gms_measurement_internal_zze_zza.f12252d = query.getLong(4);
                    }
                    com_google_android_gms_measurement_internal_zze_zza.f12250b++;
                    if (z) {
                        com_google_android_gms_measurement_internal_zze_zza.f12249a++;
                    }
                    if (z2) {
                        com_google_android_gms_measurement_internal_zze_zza.f12251c++;
                    }
                    if (z3) {
                        com_google_android_gms_measurement_internal_zze_zza.f12252d++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.f12249a));
                    contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.f12250b));
                    contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.f12251c));
                    contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zze_zza.f12252d));
                    e2.update("apps", contentValues, "app_id=?", strArr);
                    if (query != null) {
                        query.close();
                    }
                    return com_google_android_gms_measurement_internal_zze_zza;
                }
                zzbsd().zzbsx().zzj("Not updating daily counts, app is not known", str);
                if (query != null) {
                    query.close();
                }
                return com_google_android_gms_measurement_internal_zze_zza;
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    zzbsd().zzbsv().zzj("Error updating daily counts", e);
                    if (query != null) {
                        query.close();
                    }
                    return com_google_android_gms_measurement_internal_zze_zza;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            query = null;
            zzbsd().zzbsv().zzj("Error updating daily counts", e);
            if (query != null) {
                query.close();
            }
            return com_google_android_gms_measurement_internal_zze_zza;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void zza(com.google.android.gms.internal.zzuh.zze com_google_android_gms_internal_zzuh_zze) {
        zzwu();
        m17715c();
        zzab.zzy(com_google_android_gms_internal_zzuh_zze);
        zzab.zzhr(com_google_android_gms_internal_zzuh_zze.zzck);
        zzab.zzy(com_google_android_gms_internal_zzuh_zze.anz);
        m17868g();
        long currentTimeMillis = zzyw().currentTimeMillis();
        if (com_google_android_gms_internal_zzuh_zze.anz.longValue() < currentTimeMillis - zzbsf().zzbrf() || com_google_android_gms_internal_zzuh_zze.anz.longValue() > zzbsf().zzbrf() + currentTimeMillis) {
            zzbsd().zzbsx().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), com_google_android_gms_internal_zzuh_zze.anz);
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzuh_zze.aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            com_google_android_gms_internal_zzuh_zze.zza(zzbe);
            zzbe.az();
            bArr = zzbrz().zzj(bArr);
            zzbsd().zzbtc().zzj("Saving bundle, size", Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzuh_zze.zzck);
            contentValues.put("bundle_end_timestamp", com_google_android_gms_internal_zzuh_zze.anz);
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (m17866e().insert("queue", null, contentValues) == -1) {
                    zzbsd().zzbsv().log("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    public void zza(zza com_google_android_gms_measurement_internal_zza) {
        zzab.zzy(com_google_android_gms_measurement_internal_zza);
        zzwu();
        m17715c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zza.zzsh());
        contentValues.put("app_instance_id", com_google_android_gms_measurement_internal_zza.zzawo());
        contentValues.put("gmp_app_id", com_google_android_gms_measurement_internal_zza.zzbps());
        contentValues.put("resettable_device_id_hash", com_google_android_gms_measurement_internal_zza.zzbpt());
        contentValues.put("last_bundle_index", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqc()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbpv()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbpw()));
        contentValues.put("app_version", com_google_android_gms_measurement_internal_zza.zzxc());
        contentValues.put("app_store", com_google_android_gms_measurement_internal_zza.zzbpy());
        contentValues.put("gmp_version", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbpz()));
        contentValues.put("dev_cert_hash", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqa()));
        contentValues.put("measurement_enabled", Boolean.valueOf(com_google_android_gms_measurement_internal_zza.zzbqb()));
        contentValues.put("day", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqg()));
        contentValues.put("daily_public_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqh()));
        contentValues.put("daily_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqi()));
        contentValues.put("daily_conversions_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqj()));
        contentValues.put("config_fetched_time", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqd()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqe()));
        contentValues.put("app_version_int", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbpx()));
        contentValues.put("firebase_instance_id", com_google_android_gms_measurement_internal_zza.zzbpu());
        contentValues.put("daily_error_events_count", Long.valueOf(com_google_android_gms_measurement_internal_zza.zzbqk()));
        try {
            if (m17866e().insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzbsd().zzbsv().log("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing app", e);
        }
    }

    public void zza(zzh com_google_android_gms_measurement_internal_zzh, long j) {
        zzwu();
        m17715c();
        zzab.zzy(com_google_android_gms_measurement_internal_zzh);
        zzab.zzhr(com_google_android_gms_measurement_internal_zzh.f12261a);
        com.google.android.gms.internal.zzuh.zzb com_google_android_gms_internal_zzuh_zzb = new com.google.android.gms.internal.zzuh.zzb();
        com_google_android_gms_internal_zzuh_zzb.anp = Long.valueOf(com_google_android_gms_measurement_internal_zzh.f12265e);
        com_google_android_gms_internal_zzuh_zzb.ann = new com.google.android.gms.internal.zzuh.zzc[com_google_android_gms_measurement_internal_zzh.f12266f.size()];
        Iterator it = com_google_android_gms_measurement_internal_zzh.f12266f.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            com.google.android.gms.internal.zzuh.zzc com_google_android_gms_internal_zzuh_zzc = new com.google.android.gms.internal.zzuh.zzc();
            int i2 = i + 1;
            com_google_android_gms_internal_zzuh_zzb.ann[i] = com_google_android_gms_internal_zzuh_zzc;
            com_google_android_gms_internal_zzuh_zzc.name = str;
            zzbrz().zza(com_google_android_gms_internal_zzuh_zzc, com_google_android_gms_measurement_internal_zzh.f12266f.m17712a(str));
            i = i2;
        }
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzuh_zzb.aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            com_google_android_gms_internal_zzuh_zzb.zza(zzbe);
            zzbe.az();
            zzbsd().zzbtc().zze("Saving event, name, data size", com_google_android_gms_measurement_internal_zzh.f12262b, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_measurement_internal_zzh.f12261a);
            contentValues.put("name", com_google_android_gms_measurement_internal_zzh.f12262b);
            contentValues.put("timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzh.f12264d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bArr);
            try {
                if (m17866e().insert("raw_events", null, contentValues) == -1) {
                    zzbsd().zzbsv().log("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing raw event", e);
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Data loss. Failed to serialize event params/data", e2);
        }
    }

    public void zza(zzi com_google_android_gms_measurement_internal_zzi) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzi);
        zzwu();
        m17715c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzi.f12267a);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzi.f12268b);
        contentValues.put("lifetime_count", Long.valueOf(com_google_android_gms_measurement_internal_zzi.f12269c));
        contentValues.put("current_bundle_count", Long.valueOf(com_google_android_gms_measurement_internal_zzi.f12270d));
        contentValues.put("last_fire_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzi.f12271e));
        try {
            if (m17866e().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzbsd().zzbsv().log("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing event aggregates", e);
        }
    }

    public void zza(String str, long j, zzb com_google_android_gms_measurement_internal_zze_zzb) {
        Cursor cursor;
        Object e;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzy(com_google_android_gms_measurement_internal_zze_zzb);
        zzwu();
        m17715c();
        try {
            Object string;
            String str2;
            SQLiteDatabase e2 = m17866e();
            String string2;
            if (TextUtils.isEmpty(str)) {
                cursor2 = e2.rawQuery("select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", new String[]{String.valueOf(j)});
                if (cursor2.moveToFirst()) {
                    string = cursor2.getString(0);
                    string2 = cursor2.getString(1);
                    cursor2.close();
                    str2 = string2;
                    cursor = cursor2;
                } else if (cursor2 != null) {
                    cursor2.close();
                    return;
                } else {
                    return;
                }
            }
            cursor2 = e2.rawQuery("select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;", new String[]{str});
            if (cursor2.moveToFirst()) {
                string2 = cursor2.getString(0);
                cursor2.close();
                str2 = string2;
                cursor = cursor2;
            } else if (cursor2 != null) {
                cursor2.close();
                return;
            } else {
                return;
            }
            try {
                cursor = e2.query("raw_events_metadata", new String[]{"metadata"}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", "2");
                if (cursor.moveToFirst()) {
                    zzapn zzbd = zzapn.zzbd(cursor.getBlob(0));
                    com.google.android.gms.internal.zzuh.zze com_google_android_gms_internal_zzuh_zze = new com.google.android.gms.internal.zzuh.zze();
                    try {
                        com.google.android.gms.internal.zzuh.zze com_google_android_gms_internal_zzuh_zze2 = (com.google.android.gms.internal.zzuh.zze) com_google_android_gms_internal_zzuh_zze.zzb(zzbd);
                        if (cursor.moveToNext()) {
                            zzbsd().zzbsx().log("Get multiple raw event metadata records, expected one");
                        }
                        cursor.close();
                        com_google_android_gms_measurement_internal_zze_zzb.zzc(com_google_android_gms_internal_zzuh_zze);
                        cursor2 = e2.query("raw_events", new String[]{"rowid", "name", "timestamp", ShareConstants.WEB_DIALOG_PARAM_DATA}, "app_id=? and metadata_fingerprint=?", new String[]{string, str2}, null, null, "rowid", null);
                        if (cursor2.moveToFirst()) {
                            do {
                                long j2 = cursor2.getLong(0);
                                zzapn zzbd2 = zzapn.zzbd(cursor2.getBlob(3));
                                com.google.android.gms.internal.zzuh.zzb com_google_android_gms_internal_zzuh_zzb = new com.google.android.gms.internal.zzuh.zzb();
                                try {
                                    com.google.android.gms.internal.zzuh.zzb com_google_android_gms_internal_zzuh_zzb2 = (com.google.android.gms.internal.zzuh.zzb) com_google_android_gms_internal_zzuh_zzb.zzb(zzbd2);
                                    com_google_android_gms_internal_zzuh_zzb.name = cursor2.getString(1);
                                    com_google_android_gms_internal_zzuh_zzb.ano = Long.valueOf(cursor2.getLong(2));
                                    if (!com_google_android_gms_measurement_internal_zze_zzb.zza(j2, com_google_android_gms_internal_zzuh_zzb)) {
                                        if (cursor2 != null) {
                                            cursor2.close();
                                            return;
                                        }
                                        return;
                                    }
                                } catch (IOException e3) {
                                    try {
                                        zzbsd().zzbsv().zze("Data loss. Failed to merge raw event", string, e3);
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                    }
                                }
                            } while (cursor2.moveToNext());
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                        zzbsd().zzbsx().log("Raw event data disappeared while in transaction");
                        if (cursor2 != null) {
                            cursor2.close();
                            return;
                        }
                        return;
                    } catch (IOException e32) {
                        zzbsd().zzbsv().zze("Data loss. Failed to merge raw event metadata", string, e32);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                zzbsd().zzbsv().log("Raw event metadata record is missing");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e5) {
                e = e5;
                cursor2 = cursor;
                try {
                    zzbsd().zzbsv().zzj("Data loss. Error selecting raw event", e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e42) {
            e = e42;
        } catch (Throwable th4) {
            th = th4;
            cursor = cursor2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public boolean zza(zzak com_google_android_gms_measurement_internal_zzak) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzak);
        zzwu();
        m17715c();
        if (zzas(com_google_android_gms_measurement_internal_zzak.f12243a, com_google_android_gms_measurement_internal_zzak.f12244b) == null) {
            if (zzal.m17810a(com_google_android_gms_measurement_internal_zzak.f12244b)) {
                if (m17847a("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{com_google_android_gms_measurement_internal_zzak.f12243a}) >= ((long) zzbsf().m17836f())) {
                    return false;
                }
            }
            if (m17847a("select count(1) from user_attributes where app_id=?", new String[]{com_google_android_gms_measurement_internal_zzak.f12243a}) >= ((long) zzbsf().m17837g())) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", com_google_android_gms_measurement_internal_zzak.f12243a);
        contentValues.put("name", com_google_android_gms_measurement_internal_zzak.f12244b);
        contentValues.put("set_timestamp", Long.valueOf(com_google_android_gms_measurement_internal_zzak.f12245c));
        m17856a(contentValues, "value", com_google_android_gms_measurement_internal_zzak.f12246d);
        try {
            if (m17866e().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzbsd().zzbsv().log("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing user property", e);
        }
        return true;
    }

    public void zzac(List<Long> list) {
        zzab.zzy(list);
        zzwu();
        m17715c();
        StringBuilder stringBuilder = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(((Long) list.get(i)).longValue());
        }
        stringBuilder.append(")");
        int delete = m17866e().delete("raw_events", stringBuilder.toString(), null);
        if (delete != list.size()) {
            zzbsd().zzbsv().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public zzi zzaq(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzwu();
        m17715c();
        try {
            Cursor query = m17866e().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzi com_google_android_gms_measurement_internal_zzi = new zzi(str, str2, query.getLong(0), query.getLong(1), query.getLong(2));
                    if (query.moveToNext()) {
                        zzbsd().zzbsv().log("Got multiple records for event aggregates, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zzi;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zzi;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzbsd().zzbsv().zzd("Error querying events", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
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
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzbsd().zzbsv().zzd("Error querying events", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public void zzar(String str, String str2) {
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzwu();
        m17715c();
        try {
            zzbsd().zzbtc().zzj("Deleted user attribute rows:", Integer.valueOf(m17866e().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    public zzak zzas(String str, String str2) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzwu();
        m17715c();
        try {
            Cursor query = m17866e().query("user_attributes", new String[]{"set_timestamp", "value"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zzak com_google_android_gms_measurement_internal_zzak = new zzak(str, str2, query.getLong(0), m17861b(query, 1));
                    if (query.moveToNext()) {
                        zzbsd().zzbsv().log("Got multiple records for user property, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zzak;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zzak;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    zzbsd().zzbsv().zzd("Error querying user property", str, str2, e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
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
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            zzbsd().zzbsv().zzd("Error querying user property", str, str2, e);
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public long zzb(com.google.android.gms.internal.zzuh.zze com_google_android_gms_internal_zzuh_zze) {
        zzwu();
        m17715c();
        zzab.zzy(com_google_android_gms_internal_zzuh_zze);
        zzab.zzhr(com_google_android_gms_internal_zzuh_zze.zzck);
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzuh_zze.aM()];
            zzapo zzbe = zzapo.zzbe(bArr);
            com_google_android_gms_internal_zzuh_zze.zza(zzbe);
            zzbe.az();
            long zzy = zzbrz().zzy(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", com_google_android_gms_internal_zzuh_zze.zzck);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzy));
            contentValues.put("metadata", bArr);
            try {
                m17866e().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return zzy;
            } catch (SQLiteException e) {
                zzbsd().zzbsv().zzj("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            zzbsd().zzbsv().zzj("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    public void zzbh(long j) {
        zzwu();
        m17715c();
        if (m17866e().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzbsd().zzbsv().log("Deleted fewer rows from queue than expected");
        }
    }

    public String zzbi(long j) {
        Object e;
        Throwable th;
        String str = null;
        zzwu();
        m17715c();
        Cursor rawQuery;
        try {
            rawQuery = m17866e().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j)});
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else {
                    zzbsd().zzbtc().log("No expired configs for apps with pending events");
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsd().zzbsv().zzj("Error selecting expired configs", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = str;
            zzbsd().zzbsv().zzj("Error selecting expired configs", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = str;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public String zzbsg() {
        Cursor rawQuery;
        Object e;
        Throwable th;
        String str = null;
        try {
            rawQuery = m17866e().rawQuery("select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by rowid limit 1;", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsd().zzbsv().zzj("Database error getting next bundle app id", e);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            zzbsd().zzbsv().zzj("Database error getting next bundle app id", e);
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    public long zzbsj() {
        return m17848a("select max(bundle_end_timestamp) from queue", null, 0);
    }

    public long zzbsk() {
        return m17848a("select max(timestamp) from raw_events", null, 0);
    }

    public boolean zzbsl() {
        return m17847a("select count(1) > 0 from raw_events", null) != 0;
    }

    public void zzd(String str, byte[] bArr) {
        zzab.zzhr(str);
        zzwu();
        m17715c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) m17866e().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzbsd().zzbsv().log("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Error storing remote config", e);
        }
    }

    public List<zzak> zzlm(String str) {
        Object e;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        zzab.zzhr(str);
        zzwu();
        m17715c();
        List<zzak> arrayList = new ArrayList();
        try {
            Cursor query = m17866e().query("user_attributes", new String[]{"name", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzbsf().m17837g()));
            try {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(0);
                        long j = query.getLong(1);
                        Object b = m17861b(query, 2);
                        if (b == null) {
                            zzbsd().zzbsv().log("Read invalid user property value, ignoring it");
                        } else {
                            arrayList.add(new zzak(str, string, j, b));
                        }
                    } while (query.moveToNext());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
            try {
                zzbsd().zzbsv().zze("Error querying user properties", str, e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    public zza zzln(String str) {
        Cursor query;
        Object e;
        Throwable th;
        zzab.zzhr(str);
        zzwu();
        m17715c();
        try {
            query = m17866e().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    zza com_google_android_gms_measurement_internal_zza = new zza(this.b, str);
                    com_google_android_gms_measurement_internal_zza.zzky(query.getString(0));
                    com_google_android_gms_measurement_internal_zza.zzkz(query.getString(1));
                    com_google_android_gms_measurement_internal_zza.zzla(query.getString(2));
                    com_google_android_gms_measurement_internal_zza.zzaz(query.getLong(3));
                    com_google_android_gms_measurement_internal_zza.zzau(query.getLong(4));
                    com_google_android_gms_measurement_internal_zza.zzav(query.getLong(5));
                    com_google_android_gms_measurement_internal_zza.setAppVersion(query.getString(6));
                    com_google_android_gms_measurement_internal_zza.zzlc(query.getString(7));
                    com_google_android_gms_measurement_internal_zza.zzax(query.getLong(8));
                    com_google_android_gms_measurement_internal_zza.zzay(query.getLong(9));
                    com_google_android_gms_measurement_internal_zza.setMeasurementEnabled((query.isNull(10) ? 1 : query.getInt(10)) != 0);
                    com_google_android_gms_measurement_internal_zza.zzbc(query.getLong(11));
                    com_google_android_gms_measurement_internal_zza.zzbd(query.getLong(12));
                    com_google_android_gms_measurement_internal_zza.zzbe(query.getLong(13));
                    com_google_android_gms_measurement_internal_zza.zzbf(query.getLong(14));
                    com_google_android_gms_measurement_internal_zza.zzba(query.getLong(15));
                    com_google_android_gms_measurement_internal_zza.zzbb(query.getLong(16));
                    com_google_android_gms_measurement_internal_zza.zzaw(query.isNull(17) ? -2147483648L : (long) query.getInt(17));
                    com_google_android_gms_measurement_internal_zza.zzlb(query.getString(18));
                    com_google_android_gms_measurement_internal_zza.zzbg(query.getLong(19));
                    com_google_android_gms_measurement_internal_zza.zzbpr();
                    if (query.moveToNext()) {
                        zzbsd().zzbsv().log("Got multiple records for app, expected one");
                    }
                    if (query == null) {
                        return com_google_android_gms_measurement_internal_zza;
                    }
                    query.close();
                    return com_google_android_gms_measurement_internal_zza;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsd().zzbsv().zze("Error querying app", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
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
            zzbsd().zzbsv().zze("Error querying app", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public long zzlo(String str) {
        zzab.zzhr(str);
        zzwu();
        m17715c();
        try {
            SQLiteDatabase e = m17866e();
            String valueOf = String.valueOf(zzbsf().zzll(str));
            return (long) e.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, valueOf});
        } catch (SQLiteException e2) {
            zzbsd().zzbsv().zzj("Error deleting over the limit events", e2);
            return 0;
        }
    }

    public byte[] zzlp(String str) {
        Cursor query;
        Object e;
        Throwable th;
        zzab.zzhr(str);
        zzwu();
        m17715c();
        try {
            query = m17866e().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (query.moveToFirst()) {
                    byte[] blob = query.getBlob(0);
                    if (query.moveToNext()) {
                        zzbsd().zzbsv().log("Got multiple records for app config, expected one");
                    }
                    if (query == null) {
                        return blob;
                    }
                    query.close();
                    return blob;
                }
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzbsd().zzbsv().zze("Error querying remote config", str, e);
                    if (query != null) {
                        query.close();
                    }
                    return null;
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
            zzbsd().zzbsv().zze("Error querying remote config", str, e);
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void zzlt(String str) {
        try {
            m17866e().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zzj("Failed to remove unused event metadata", e);
        }
    }

    public long zzlu(String str) {
        zzab.zzhr(str);
        return m17848a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public List<Pair<com.google.android.gms.internal.zzuh.zze, Long>> zzn(String str, int i, int i2) {
        Object e;
        Cursor cursor;
        Throwable th;
        boolean z = true;
        zzwu();
        m17715c();
        zzab.zzbo(i > 0);
        if (i2 <= 0) {
            z = false;
        }
        zzab.zzbo(z);
        zzab.zzhr(str);
        Cursor query;
        List<Pair<com.google.android.gms.internal.zzuh.zze, Long>> emptyList;
        try {
            query = m17866e().query("queue", new String[]{"rowid", ShareConstants.WEB_DIALOG_PARAM_DATA}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
            try {
                if (query.moveToFirst()) {
                    List<Pair<com.google.android.gms.internal.zzuh.zze, Long>> arrayList = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        long j = query.getLong(0);
                        int length;
                        try {
                            byte[] zzw = zzbrz().zzw(query.getBlob(1));
                            if (!arrayList.isEmpty() && zzw.length + i3 > i2) {
                                break;
                            }
                            zzapn zzbd = zzapn.zzbd(zzw);
                            com.google.android.gms.internal.zzuh.zze com_google_android_gms_internal_zzuh_zze = new com.google.android.gms.internal.zzuh.zze();
                            try {
                                com.google.android.gms.internal.zzuh.zze com_google_android_gms_internal_zzuh_zze2 = (com.google.android.gms.internal.zzuh.zze) com_google_android_gms_internal_zzuh_zze.zzb(zzbd);
                                length = zzw.length + i3;
                                arrayList.add(Pair.create(com_google_android_gms_internal_zzuh_zze, Long.valueOf(j)));
                            } catch (IOException e2) {
                                zzbsd().zzbsv().zze("Failed to merge queued bundle", str, e2);
                                length = i3;
                            }
                            if (!query.moveToNext() || length > i2) {
                                break;
                            }
                            i3 = length;
                        } catch (IOException e22) {
                            zzbsd().zzbsv().zze("Failed to unzip queued bundle", str, e22);
                            length = i3;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                }
                emptyList = Collections.emptyList();
                if (query == null) {
                    return emptyList;
                }
                query.close();
                return emptyList;
            } catch (SQLiteException e3) {
                e = e3;
                cursor = query;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
            try {
                zzbsd().zzbsv().zze("Error querying bundles", str, e);
                emptyList = Collections.emptyList();
                if (cursor == null) {
                    return emptyList;
                }
                cursor.close();
                return emptyList;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public void zzy(String str, int i) {
        zzab.zzhr(str);
        zzwu();
        m17715c();
        try {
            m17866e().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            zzbsd().zzbsv().zze("Error pruning currencies", str, e);
        }
    }
}
