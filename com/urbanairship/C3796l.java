package com.urbanairship;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.urbanairship.json.C3684c;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.C3954i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class C3796l extends C3680a {
    Executor f13584a;
    private final Map<String, C3794a> f13585b;
    private final C3930r f13586c;
    private final Context f13587d;
    private final List<C3795b> f13588e;

    private class C3794a {
        final /* synthetic */ C3796l f13579a;
        private ContentObserver f13580b = new ContentObserver(this, null) {
            final /* synthetic */ C3794a f13576a;

            class C37911 implements Runnable {
                final /* synthetic */ C37921 f13575a;

                C37911(C37921 c37921) {
                    this.f13575a = c37921;
                }

                public void run() {
                    this.f13575a.f13576a.m19798b();
                }
            }

            public boolean deliverSelfNotifications() {
                return false;
            }

            public void onChange(boolean z) {
                C3783j.m19723b("PreferenceDataStore - Preference updated: " + this.f13576a.f13581c);
                this.f13576a.f13579a.f13584a.execute(new C37911(this));
            }
        };
        private final String f13581c;
        private String f13582d;
        private Uri f13583e;

        C3794a(C3796l c3796l, String str, String str2) {
            this.f13579a = c3796l;
            this.f13581c = str;
            this.f13582d = str2;
            this.f13583e = Uri.withAppendedPath(UrbanAirshipProvider.m19288b(c3796l.f13587d), str);
        }

        String m19796a() {
            String str;
            synchronized (this) {
                str = this.f13582d;
            }
            return str;
        }

        void m19797a(final String str) {
            if (m19794c(str)) {
                this.f13579a.f13584a.execute(new Runnable(this) {
                    final /* synthetic */ C3794a f13578b;

                    public void run() {
                        this.f13578b.m19795d(str);
                    }
                });
            }
        }

        boolean m19799b(String str) {
            boolean z;
            synchronized (this) {
                if (m19795d(str)) {
                    m19794c(str);
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        }

        private boolean m19794c(String str) {
            synchronized (this) {
                if (C3954i.m20513a(str, this.f13582d)) {
                    return false;
                }
                this.f13582d = str;
                this.f13579a.m19805c(this.f13581c);
                return true;
            }
        }

        private boolean m19795d(String str) {
            synchronized (this) {
                if (str == null) {
                    C3783j.m19723b("PreferenceDataStore - Removing preference: " + this.f13581c);
                    if (this.f13579a.f13586c.m20402a(UrbanAirshipProvider.m19288b(this.f13579a.f13587d), "_id = ?", new String[]{this.f13581c}) == 1) {
                        this.f13579a.f13586c.m20406a(this.f13583e, this.f13580b);
                        return true;
                    }
                    return false;
                }
                C3783j.m19723b("PreferenceDataStore - Saving preference: " + this.f13581c + " value: " + str);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", this.f13581c);
                contentValues.put("value", str);
                if (this.f13579a.f13586c.m20405a(UrbanAirshipProvider.m19288b(this.f13579a.f13587d), contentValues) != null) {
                    this.f13579a.f13586c.m20406a(this.f13583e, this.f13580b);
                    return true;
                }
                return false;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        void m19798b() {
            /*
            r8 = this;
            r6 = 0;
            monitor-enter(r8);	 Catch:{ all -> 0x0070 }
            r0 = r8.f13579a;	 Catch:{ all -> 0x0040 }
            r0 = r0.f13586c;	 Catch:{ all -> 0x0040 }
            r1 = r8.f13579a;	 Catch:{ all -> 0x0040 }
            r1 = r1.f13587d;	 Catch:{ all -> 0x0040 }
            r1 = com.urbanairship.UrbanAirshipProvider.m19288b(r1);	 Catch:{ all -> 0x0040 }
            r2 = 1;
            r2 = new java.lang.String[r2];	 Catch:{ all -> 0x0040 }
            r3 = 0;
            r4 = "value";
            r2[r3] = r4;	 Catch:{ all -> 0x0040 }
            r3 = "_id = ?";
            r4 = 1;
            r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0040 }
            r5 = 0;
            r7 = r8.f13581c;	 Catch:{ all -> 0x0040 }
            r4[r5] = r7;	 Catch:{ all -> 0x0040 }
            r5 = 0;
            r1 = r0.m20404a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x0040 }
            monitor-exit(r8);	 Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x004b;
        L_0x002c:
            r0 = r1.moveToFirst();	 Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0037;
        L_0x0032:
            r0 = 0;
            r6 = r1.getString(r0);	 Catch:{ all -> 0x0044 }
        L_0x0037:
            r8.m19794c(r6);	 Catch:{ all -> 0x0044 }
        L_0x003a:
            if (r1 == 0) goto L_0x003f;
        L_0x003c:
            r1.close();
        L_0x003f:
            return;
        L_0x0040:
            r0 = move-exception;
            r1 = r6;
        L_0x0042:
            monitor-exit(r8);	 Catch:{ all -> 0x0073 }
            throw r0;	 Catch:{ all -> 0x0044 }
        L_0x0044:
            r0 = move-exception;
        L_0x0045:
            if (r1 == 0) goto L_0x004a;
        L_0x0047:
            r1.close();
        L_0x004a:
            throw r0;
        L_0x004b:
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0044 }
            r0.<init>();	 Catch:{ all -> 0x0044 }
            r2 = "PreferenceDataStore - Unable to get preference ";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0044 }
            r2 = r8.f13581c;	 Catch:{ all -> 0x0044 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0044 }
            r2 = " from";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0044 }
            r2 = " database. Falling back to cached value.";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0044 }
            r0 = r0.toString();	 Catch:{ all -> 0x0044 }
            com.urbanairship.C3783j.m19725c(r0);	 Catch:{ all -> 0x0044 }
            goto L_0x003a;
        L_0x0070:
            r0 = move-exception;
            r1 = r6;
            goto L_0x0045;
        L_0x0073:
            r0 = move-exception;
            goto L_0x0042;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.l.a.b():void");
        }

        void m19800c() {
            this.f13579a.f13586c.m20407a(this.f13583e, true, this.f13580b);
        }
    }

    public interface C3795b {
        void mo2801a(String str);
    }

    C3796l(Context context) {
        this(context, new C3930r(context));
    }

    C3796l(Context context, C3930r c3930r) {
        this.f13584a = Executors.newSingleThreadExecutor();
        this.f13585b = new HashMap();
        this.f13588e = new ArrayList();
        this.f13587d = context;
        this.f13586c = c3930r;
    }

    public void m19812a(C3795b c3795b) {
        synchronized (this.f13588e) {
            this.f13588e.add(c3795b);
        }
    }

    protected void mo2777a() {
        Cursor a = this.f13586c.m20404a(UrbanAirshipProvider.m19288b(this.f13587d), null, null, null, null);
        if (a != null) {
            int columnIndex = a.getColumnIndex("_id");
            int columnIndex2 = a.getColumnIndex("value");
            while (a.moveToNext()) {
                String string = a.getString(columnIndex);
                C3794a c3794a = new C3794a(this, string, a.getString(columnIndex2));
                c3794a.m19800c();
                this.f13585b.put(string, c3794a);
            }
            a.close();
        }
    }

    public boolean m19815a(String str, boolean z) {
        String a = m19806d(str).m19796a();
        return a == null ? z : Boolean.valueOf(a).booleanValue();
    }

    public String m19810a(String str, String str2) {
        String a = m19806d(str).m19796a();
        return a == null ? str2 : a;
    }

    public long m19808a(String str, long j) {
        String a = m19806d(str).m19796a();
        if (a != null) {
            try {
                j = Long.parseLong(a);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public int m19807a(String str, int i) {
        String a = m19806d(str).m19796a();
        if (a != null) {
            try {
                i = Integer.parseInt(a);
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public JsonValue m19809a(String str) {
        try {
            return JsonValue.m19740b(m19806d(str).m19796a());
        } catch (Throwable e) {
            C3783j.m19724b("Unable to parse preference value: " + str, e);
            return JsonValue.f13565a;
        }
    }

    public void m19816b(String str) {
        m19806d(str).m19797a(null);
    }

    public void m19819b(String str, String str2) {
        m19806d(str).m19797a(str2);
    }

    public void m19818b(String str, long j) {
        m19806d(str).m19797a(String.valueOf(j));
    }

    public void m19817b(String str, int i) {
        m19806d(str).m19797a(String.valueOf(i));
    }

    public void m19820b(String str, boolean z) {
        m19806d(str).m19797a(String.valueOf(z));
    }

    public void m19813a(String str, JsonValue jsonValue) {
        if (jsonValue == null) {
            m19816b(str);
        } else {
            m19806d(str).m19797a(jsonValue.toString());
        }
    }

    public void m19814a(String str, C3684c c3684c) {
        if (c3684c == null) {
            m19816b(str);
        } else {
            m19813a(str, c3684c.mo2767e());
        }
    }

    public boolean m19821c(String str, String str2) {
        return m19806d(str).m19799b(str2 == null ? null : String.valueOf(str2));
    }

    private void m19805c(String str) {
        synchronized (this.f13588e) {
            for (C3795b a : this.f13588e) {
                a.mo2801a(str);
            }
        }
    }

    private C3794a m19806d(String str) {
        C3794a c3794a;
        synchronized (this.f13585b) {
            if (this.f13585b.containsKey(str)) {
                c3794a = (C3794a) this.f13585b.get(str);
            } else {
                c3794a = new C3794a(this, str, null);
                c3794a.m19800c();
                this.f13585b.put(str, c3794a);
            }
        }
        return c3794a;
    }
}
