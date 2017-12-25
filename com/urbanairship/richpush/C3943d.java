package com.urbanairship.richpush;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3783j;
import com.urbanairship.C3930r;
import com.urbanairship.UrbanAirshipProvider;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class C3943d extends C3930r {
    private final Uri f13998a;

    C3943d(Context context) {
        super(context);
        this.f13998a = UrbanAirshipProvider.m19286a(context);
    }

    List<C3942c> mo2847a() {
        List<C3942c> arrayList = new ArrayList();
        Cursor a = m20404a(this.f13998a, null, null, null, null);
        if (a == null) {
            return arrayList;
        }
        while (a.moveToNext()) {
            try {
                boolean z;
                String string = a.getString(a.getColumnIndex("raw_message_object"));
                boolean z2 = a.getInt(a.getColumnIndex("unread")) == 1;
                if (a.getInt(a.getColumnIndex("deleted")) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                C3942c a2 = C3942c.m20444a(JsonValue.m19740b(string), z2, z);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            } catch (Throwable e) {
                C3783j.m19726c("RichPushResolver - Failed to parse message from the database.", e);
            }
        }
        a.close();
        return arrayList;
    }

    Set<String> m20465b() {
        return m20459a(m20404a(this.f13998a, null, null, null, null));
    }

    Set<String> m20467c() {
        return m20459a(m20404a(this.f13998a, null, "unread = ? AND unread <> unread_orig", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}, null));
    }

    Set<String> m20469d() {
        return m20459a(m20404a(this.f13998a, null, "deleted = ?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_YES}, null));
    }

    int m20462a(Set<String> set) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread", Boolean.valueOf(false));
        return m20457a((Set) set, contentValues);
    }

    int m20464b(Set<String> set) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("deleted", Boolean.valueOf(true));
        return m20457a((Set) set, contentValues);
    }

    int m20466c(Set<String> set) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("unread_orig", Boolean.valueOf(false));
        return m20457a((Set) set, contentValues);
    }

    int m20468d(Set<String> set) {
        return m20402a(this.f13998a, "message_id IN ( " + C3954i.m20511a("?", set.size(), ", ") + " )", (String[]) set.toArray(new String[set.size()]));
    }

    int m20461a(List<JsonValue> list) {
        List arrayList = new ArrayList();
        for (JsonValue a : list) {
            ContentValues a2 = m20458a(a);
            if (a2 != null) {
                a2.put("unread", a2.getAsBoolean("unread_orig"));
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        return m20403a(this.f13998a, (ContentValues[]) arrayList.toArray(new ContentValues[arrayList.size()]));
    }

    int m20460a(String str, JsonValue jsonValue) {
        ContentValues a = m20458a(jsonValue);
        if (a == null) {
            return -1;
        }
        return m20401a(Uri.withAppendedPath(this.f13998a, str), a, "message_id = ?", new String[]{str});
    }

    private int m20457a(Set<String> set, ContentValues contentValues) {
        return m20401a(this.f13998a, contentValues, "message_id IN ( " + C3954i.m20511a("?", set.size(), ", ") + " )", (String[]) set.toArray(new String[set.size()]));
    }

    private Set<String> m20459a(Cursor cursor) {
        if (cursor == null) {
            return new HashSet();
        }
        Set<String> hashSet = new HashSet(cursor.getCount());
        int i = -1;
        while (cursor.moveToNext()) {
            if (i == -1) {
                i = cursor.getColumnIndex("message_id");
            }
            hashSet.add(cursor.getString(i));
        }
        cursor.close();
        return hashSet;
    }

    private ContentValues m20458a(JsonValue jsonValue) {
        ContentValues contentValues = null;
        if (jsonValue == null || !jsonValue.m19764o()) {
            C3783j.m19728e("RichPushResolver - Unexpected message: " + jsonValue);
        } else {
            C3788b f = jsonValue.m19755f();
            if (C3954i.m20512a(f.m19782c("message_id").m19747a())) {
                C3783j.m19728e("RichPushResolver - Message is missing an ID: " + jsonValue);
            } else {
                contentValues = new ContentValues();
                contentValues.put("timestamp", f.m19782c("message_sent").m19747a());
                contentValues.put("message_id", f.m19782c("message_id").m19747a());
                contentValues.put("message_url", f.m19782c("message_url").m19747a());
                contentValues.put("message_body_url", f.m19782c("message_body_url").m19747a());
                contentValues.put("message_read_url", f.m19782c("message_read_url").m19747a());
                contentValues.put(ShareConstants.WEB_DIALOG_PARAM_TITLE, f.m19782c(ShareConstants.WEB_DIALOG_PARAM_TITLE).m19747a());
                contentValues.put("unread_orig", Boolean.valueOf(f.m19782c("unread").m19750a(true)));
                contentValues.put("extra", f.m19782c("extra").toString());
                contentValues.put("raw_message_object", f.toString());
                if (f.m19779a("message_expiry")) {
                    contentValues.put("expiration_timestamp", f.m19782c("message_expiry").m19747a());
                }
            }
        }
        return contentValues;
    }
}
