package com.urbanairship;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.urbanairship.util.C3746b;
import java.util.List;

public final class UrbanAirshipProvider extends ContentProvider {
    private static String f13298d;
    private final UriMatcher f13299a = new UriMatcher(-1);
    private C3677a f13300b;
    private C3677a f13301c;

    private static class C3677a {
        final C3746b f13295a;
        final String f13296b;
        private final String f13297c;

        private C3677a(C3746b c3746b, String str, String str2) {
            this.f13295a = c3746b;
            this.f13296b = str;
            this.f13297c = str2;
        }

        static C3677a m19283a(Context context, String str) {
            return new C3677a(new C3861p(context, str), "richpush", "message_id");
        }

        static C3677a m19285b(Context context, String str) {
            return new C3677a(new C3822m(context, str), "preferences", "_id");
        }
    }

    public static Uri m19286a(Context context) {
        return Uri.parse("content://" + m19289c(context) + "/richpush");
    }

    public static Uri m19288b(Context context) {
        return Uri.parse("content://" + m19289c(context) + "/preferences");
    }

    public static String m19289c(Context context) {
        if (f13298d == null) {
            f13298d = context.getPackageName() + ".urbanairship.provider";
        }
        return f13298d;
    }

    public boolean onCreate() {
        if (getContext() == null) {
            return false;
        }
        this.f13299a.addURI(m19289c(getContext()), "richpush", 0);
        this.f13299a.addURI(m19289c(getContext()), "richpush/*", 1);
        this.f13299a.addURI(m19289c(getContext()), "preferences", 2);
        this.f13299a.addURI(m19289c(getContext()), "preferences/*", 3);
        C1187d.m6034a((Application) getContext().getApplicationContext(), true);
        return true;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        C3677a a = m19287a(uri);
        if (a == null || getContext() == null) {
            return -1;
        }
        return a.f13295a.m19543a(a.f13296b, str, strArr);
    }

    public String getType(Uri uri) {
        switch (this.f13299a.match(uri)) {
            case 0:
                return "vnd.urbanairship.cursor.dir/richpush";
            case 1:
                return "vnd.urbanairship.cursor.item/richpush";
            case 2:
                return "vnd.urbanairship.cursor.dir/preference";
            case 3:
                return "vnd.urbanairship.cursor.item/preference";
            default:
                throw new IllegalArgumentException("Invalid Uri: " + uri);
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        C3677a a = m19287a(uri);
        if (a == null || getContext() == null) {
            return -1;
        }
        List a2 = a.f13295a.m19549a(a.f13296b, contentValuesArr);
        if (a2 != null) {
            return a2.size();
        }
        return -1;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        C3677a a = m19287a(uri);
        if (a == null || getContext() == null || a.f13295a.m19544a(a.f13296b, contentValues) == -1) {
            return null;
        }
        return Uri.withAppendedPath(uri, contentValues.getAsString(a.f13297c));
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C3677a a = m19287a(uri);
        if (a == null || getContext() == null) {
            return null;
        }
        Cursor a2 = a.f13295a.m19545a(a.f13296b, strArr, str, strArr2, str2);
        if (a2 == null) {
            return a2;
        }
        a2.setNotificationUri(getContext().getContentResolver(), uri);
        return a2;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C3677a a = m19287a(uri);
        if (a == null || getContext() == null) {
            return -1;
        }
        return a.f13295a.m19542a(a.f13296b, contentValues, str, strArr);
    }

    public void shutdown() {
        if (this.f13300b != null) {
            this.f13300b.f13295a.m19560g();
            this.f13300b = null;
        }
        if (this.f13301c != null) {
            this.f13301c.f13295a.m19560g();
            this.f13301c = null;
        }
    }

    private C3677a m19287a(Uri uri) {
        if (getContext() == null) {
            return null;
        }
        if (!C3929q.m20383i() && !C3929q.m20384j()) {
            return null;
        }
        C3929q c3929q = C3929q.f13938d;
        if (c3929q == null || c3929q.m20388l() == null || c3929q.m20388l().m19664a() == null) {
            return null;
        }
        String a = c3929q.m20388l().m19664a();
        switch (this.f13299a.match(uri)) {
            case 0:
            case 1:
                if (this.f13300b == null) {
                    this.f13300b = C3677a.m19283a(getContext(), a);
                }
                return this.f13300b;
            case 2:
            case 3:
                if (this.f13301c == null) {
                    this.f13301c = C3677a.m19285b(getContext(), a);
                }
                return this.f13301c;
            default:
                throw new IllegalArgumentException("Invalid URI: " + uri);
        }
    }
}
