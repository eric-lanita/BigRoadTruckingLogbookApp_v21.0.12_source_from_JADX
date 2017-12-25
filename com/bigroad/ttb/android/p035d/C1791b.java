package com.bigroad.ttb.android.p035d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bigroad.ttb.android.logging.C2134e;

class C1791b extends SQLiteOpenHelper {
    private static final String[] f6122A = new String[]{"DROP TABLE IF EXISTS stored_var_page", "CREATE TABLE stored_var_page (dash_link_id BLOB NOT NULL,page_number INTEGER NOT NULL,data BLOB NOT NULL,was_synced BOOLEAN NOT NULL,is_complete BOOLEAN NOT NULL,is_carry_over_complete BOOLEAN NOT NULL,start_utc_timestamp DATETIME NULL,first_timestamped_entry_index INTEGER NULL,last_uptime_to_utc_offset INTEGER NULL,last_event_sequence_number INTEGER NULL,last_eobr_event_position INTEGER NULL,last_cursor_reset_position INTEGER NULL,reset_cause INTEGER NULL,reset_sub_code INTEGER NULL,PRIMARY KEY (dash_link_id, page_number))"};
    private static final String[] f6123B = new String[]{"DROP TABLE IF EXISTS stored_correction", "CREATE TABLE stored_correction (id INTEGER NOT NULL PRIMARY KEY,data BLOB NOT NULL)"};
    private static final String[] f6124C = new String[]{"DROP TABLE IF EXISTS stored_mgs_entry", "CREATE TABLE stored_mgs_entry ( mgs_serial_number VARCHAR NOT NULL, entry_id INTEGER NOT NULL, data BLOB NULL, was_synced BOOLEAN NOT NULL, PRIMARY KEY (mgs_serial_number, entry_id) )"};
    private static final String[] f6125D = new String[]{"DROP TABLE IF EXISTS speculative_event", "CREATE TABLE speculative_event (event BLOB NOT NULL PRIMARY KEY,request BLOB NOT NULL )"};
    private static final String[][] f6126E = new String[][]{f6128b, f6129c, f6130d, f6131e, f6132f, f6133g, f6134h, f6135i, f6136j, f6137k, f6138l, f6139m, f6140n, f6141o, f6142p, f6143q, f6144r, f6145s, f6146t, f6147u, f6148v, f6149w, f6150x, f6151y, f6152z, f6122A, f6123B, f6124C, f6127a, f6125D};
    public static final String[] f6127a = new String[]{"DROP TABLE IF EXISTS mgs_sync_progress", "CREATE TABLE mgs_sync_progress ( associated_serial_number VARCHAR NOT NULL PRIMARY KEY, server_min_expected_entry_id INTEGER NULL, highest_fetched_entry_id INTEGER NULL, last_cursor_position INTEGER NULL )"};
    private static final String[] f6128b = new String[]{"DROP TABLE IF EXISTS file_upload", "DROP TABLE IF EXISTS queued_request", "CREATE TABLE file_upload (id INTEGER NOT NULL PRIMARY KEY,file_hash TEXT NOT NULL UNIQUE,content_type TEXT)", "CREATE TABLE queued_request (id INTEGER NOT NULL PRIMARY KEY,request BLOB NOT NULL,frozen BOOLEAN NOT NULL DEFAULT false)"};
    private static final String[] f6129c = new String[]{"DROP TABLE IF EXISTS stored_person", "CREATE TABLE stored_person (id INTEGER NOT NULL PRIMARY KEY,data BLOB NOT NULL)"};
    private static final String[] f6130d = new String[]{"DROP TABLE IF EXISTS stored_conversation", "DROP TABLE IF EXISTS stored_message", "CREATE TABLE stored_conversation (id INTEGER NOT NULL PRIMARY KEY,modified_seq INTEGER NOT NULL,data BLOB NOT NULL)", "CREATE TABLE stored_message (id BLOB NOT NULL PRIMARY KEY,conversation_id INTEGER NOT NULL,message_seq INTEGER NOT NULL,data BLOB NOT NULL)", "CREATE INDEX stored_message_conversation_seq ON stored_message(conversation_id, message_seq)"};
    private static final String[] f6131e = new String[]{"DROP TABLE IF EXISTS stored_event", "CREATE TABLE stored_event (id BLOB NOT NULL PRIMARY KEY,occurred_at INTEGER NOT NULL,data BLOB NOT NULL)", "CREATE INDEX stored_event_occurred_at ON stored_event(occurred_at)"};
    private static final String[] f6132f = new String[]{"DROP TABLE IF EXISTS contact", "CREATE TABLE contact (email_address VARCHAR NOT NULL PRIMARY KEY)"};
    private static final String[] f6133g = new String[]{"DROP TABLE IF EXISTS stored_daily_log", "CREATE TABLE stored_daily_log (log_day INTEGER NOT NULL PRIMARY KEY,data BLOB NOT NULL)"};
    private static final String[] f6134h = new String[]{"DROP TABLE IF EXISTS stored_dvir", "CREATE TABLE stored_dvir (id BLOB NOT NULL PRIMARY KEY,data BLOB NOT NULL)"};
    private static final String[] f6135i = new String[]{"DROP TABLE IF EXISTS user_text_history", "CREATE TABLE user_text_history (text_type INTEGER NOT NULL,owning_person_id INTEGER NOT NULL,text VARCHAR NOT NULL,use_count INTEGER NOT NULL DEFAULT 0,last_used_at DATETIME NOT NULL,PRIMARY KEY (text_type, owning_person_id, text))"};
    private static final String[] f6136j = new String[]{"DROP TABLE IF EXISTS stored_truck", "CREATE TABLE stored_truck (data BLOB NOT NULL)"};
    private static final String[] f6137k = new String[]{"DROP TABLE IF EXISTS stored_person_group", "CREATE TABLE stored_person_group (group_id INTEGER NOT NULL PRIMARY KEY,data BLOB NOT NULL)"};
    private static final String[] f6138l = new String[]{"DROP TABLE IF EXISTS aobrd_malfunction", "CREATE TABLE aobrd_malfunction (associated_person_id INTEGER NOT NULL,associated_truck_id INTEGER NOT NULL,occurred_at DATETIME NOT NULL,PRIMARY KEY (associated_person_id, associated_truck_id))"};
    private static final String[] f6139m = new String[]{"DROP TABLE IF EXISTS stored_auto_daily_log_truck", "CREATE TABLE stored_auto_daily_log_truck (owner_person_id INTEGER NOT NULL,log_day INTEGER NOT NULL,data BLOB NOT NULL,PRIMARY KEY (owner_person_id, log_day))"};
    private static final String[] f6140n = new String[]{"ALTER TABLE aobrd_malfunction ADD COLUMN event_type INTEGER NULL"};
    private static final String[] f6141o = new String[]{"CREATE TABLE diagnostics (diagnostics_key INTEGER NOT NULL PRIMARY KEY, data BLOB)"};
    private static final String[] f6142p = new String[]{"DROP TABLE IF EXISTS diagnostics", "CREATE TABLE stored_key_values (key STRING NOT NULL PRIMARY KEY, data BLOB)"};
    private static final String[] f6143q = new String[]{"ALTER TABLE aobrd_malfunction ADD COLUMN event_subtype STRING NULL"};
    private static final String[] f6144r = new String[]{"DROP TABLE IF EXISTS stored_fleet", "CREATE TABLE stored_fleet (id INTEGER NOT NULL PRIMARY KEY,data BLOB NOT NULL)"};
    private static final String[] f6145s = new String[]{"DROP TABLE IF EXISTS stored_truck_gap", "CREATE TABLE stored_truck_gap (data BLOB NOT NULL)"};
    private static final String[] f6146t = new String[]{"DROP TABLE IF EXISTS stored_var_page", "CREATE TABLE stored_var_page (dash_link_id BLOB NOT NULL,page_number INTEGER NOT NULL,data BLOB NOT NULL,was_synced BOOLEAN NOT NULL,is_full BOOLEAN NOT NULL,PRIMARY KEY (dash_link_id, page_number))", "CREATE TABLE var_sync_progress (dash_link_id BLOB NOT NULL PRIMARY KEY,server_min_expected_var_page_number INTEGER,highest_fetched_page_number INTEGER)"};
    private static final String[] f6147u = new String[]{"DROP TABLE IF EXISTS firmware_upload_time", "CREATE TABLE firmware_upload_time (dash_link_id BLOB NOT NULL PRIMARY KEY,time INTEGER NOT NULL)"};
    private static final String[] f6148v = new String[]{"DROP TABLE IF EXISTS stored_remote_log_requests", "CREATE TABLE stored_remote_log_requests (request_seq INTEGER PRIMARY KEY AUTOINCREMENT,data BLOB NOT NULL)"};
    private static final String[] f6149w = new String[]{"DROP TABLE IF EXISTS stored_dash_link_firmware_version", "CREATE TABLE stored_dash_link_firmware_version (version_number TEXT NOT NULL PRIMARY KEY,is_valid BOOLEAN NOT NULL,crc INTEGER NOT NULL)"};
    private static final String[] f6150x = new String[]{"DROP TABLE IF EXISTS stored_var_page", "CREATE TABLE stored_var_page (dash_link_id BLOB NOT NULL,page_number INTEGER NOT NULL,data BLOB NOT NULL,was_synced BOOLEAN NOT NULL,is_complete BOOLEAN NOT NULL,is_carry_over_complete BOOLEAN NOT NULL,has_reset BOOLEAN NOT NULL,start_utc_timestamp DATETIME NULL,first_timestamped_entry_index INTEGER NULL,last_uptime_to_utc_offset INTEGER NULL,last_eobr_event_position INTEGER NULL,PRIMARY KEY (dash_link_id, page_number))", "ALTER TABLE var_sync_progress ADD COLUMN last_cursor_position INTEGER NULL", "ALTER TABLE var_sync_progress ADD COLUMN last_event_sequence_number INTEGER NULL"};
    private static final String[] f6151y = new String[]{"DROP TABLE IF EXISTS stored_unclaimed_event", "CREATE TABLE stored_unclaimed_event (id BLOB NOT NULL PRIMARY KEY,device_id BLOB NOT NULL,occurred_at INTEGER NOT NULL,data BLOB NOT NULL,is_ignored BOOLEAN NOT NULL)", "CREATE INDEX stored_unclaimed_event_device_id ON stored_unclaimed_event(device_id)"};
    private static final String[] f6152z = new String[]{"DROP TABLE IF EXISTS stored_var_page", "CREATE TABLE stored_var_page (dash_link_id BLOB NOT NULL,page_number INTEGER NOT NULL,data BLOB NOT NULL,was_synced BOOLEAN NOT NULL,is_complete BOOLEAN NOT NULL,is_carry_over_complete BOOLEAN NOT NULL,has_reset BOOLEAN NOT NULL,start_utc_timestamp DATETIME NULL,first_timestamped_entry_index INTEGER NULL,last_uptime_to_utc_offset INTEGER NULL,last_eobr_event_position INTEGER NULL,last_cursor_reset_position INTEGER NULL,PRIMARY KEY (dash_link_id, page_number))"};

    public C1791b(Context context) {
        super(context.getApplicationContext(), "maindb", null, 30);
    }

    private static void m8816a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
        for (String execSQL : strArr) {
            sQLiteDatabase.execSQL(execSQL);
        }
    }

    private static void m8815a(SQLiteDatabase sQLiteDatabase) {
        for (String[] a : f6126E) {
            C1791b.m8816a(sQLiteDatabase, a);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        C2134e.m10678c("TT-DbOpen", "Creating DB v30");
        try {
            C1791b.m8815a(sQLiteDatabase);
        } catch (Throwable e) {
            C2134e.m10681d("TT-DbOpen", "Exception while creating database", e);
            throw e;
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C2134e.m10678c("TT-DbOpen", "Updating DB from v" + i + " to v" + i2);
        while (i < i2) {
            if (i >= f6126E.length) {
                throw new IllegalArgumentException("Can't upgrade to DB version" + i2);
            }
            C1791b.m8816a(sQLiteDatabase, f6126E[i]);
            i++;
        }
    }
}
