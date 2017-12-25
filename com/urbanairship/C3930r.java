package com.urbanairship;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;

public class C3930r {
    private final Context f13955a;

    public C3930r(Context context) {
        this.f13955a = context;
    }

    protected Cursor m20404a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return mo2847a().query(uri, strArr, str, strArr2, str2);
        } catch (Throwable e) {
            C3783j.m19726c("Failed to query the UrbanAirshipProvider.", e);
            return null;
        }
    }

    protected int m20402a(Uri uri, String str, String[] strArr) {
        try {
            return mo2847a().delete(uri, str, strArr);
        } catch (Throwable e) {
            C3783j.m19726c("Failed to perform a delete in UrbanAirshipProvider.", e);
            return -1;
        }
    }

    protected int m20401a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return mo2847a().update(uri, contentValues, str, strArr);
        } catch (Throwable e) {
            C3783j.m19726c("Failed to perform an update in UrbanAirshipProvider.", e);
            return 0;
        }
    }

    protected Uri m20405a(Uri uri, ContentValues contentValues) {
        try {
            return mo2847a().insert(uri, contentValues);
        } catch (Throwable e) {
            C3783j.m19726c("Failed to insert in UrbanAirshipProvider.", e);
            return null;
        }
    }

    protected int m20403a(Uri uri, ContentValues[] contentValuesArr) {
        try {
            return mo2847a().bulkInsert(uri, contentValuesArr);
        } catch (Throwable e) {
            C3783j.m19726c("Failed to bulk insert in UrbanAirshipProvider.", e);
            return 0;
        }
    }

    public void m20407a(Uri uri, boolean z, ContentObserver contentObserver) {
        try {
            mo2847a().registerContentObserver(uri, z, contentObserver);
        } catch (IllegalArgumentException e) {
            C3783j.m19721a("Unable to register content observer for uri: " + uri);
        }
    }

    public void m20406a(Uri uri, ContentObserver contentObserver) {
        try {
            mo2847a().notifyChange(uri, contentObserver);
        } catch (IllegalArgumentException e) {
            C3783j.m19721a("Unable to notify observers of change for uri: " + uri);
        }
    }

    private ContentResolver mo2847a() {
        return this.f13955a.getContentResolver();
    }
}
