package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class zzaeo {
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    static HashMap<String, String> f11131a;
    public static final Uri aLH = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern aLI = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern aLJ = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    static HashSet<String> f11132b = new HashSet();
    private static Object f11133c;

    class C32571 extends Thread {
        final /* synthetic */ ContentResolver f11130a;

        C32571(String str, ContentResolver contentResolver) {
            this.f11130a = contentResolver;
            super(str);
        }

        public void run() {
            Looper.prepare();
            this.f11130a.registerContentObserver(zzaeo.CONTENT_URI, true, new ContentObserver(this, new Handler(Looper.myLooper())) {
                final /* synthetic */ C32571 f11129a;

                public void onChange(boolean z) {
                    synchronized (zzaeo.class) {
                        zzaeo.f11131a.clear();
                        zzaeo.f11133c = new Object();
                        if (!zzaeo.f11132b.isEmpty()) {
                            zzaeo.zzb(this.f11129a.f11130a, (String[]) zzaeo.f11132b.toArray(new String[zzaeo.f11132b.size()]));
                        }
                    }
                }
            });
            Looper.loop();
        }
    }

    private static void m17165a(ContentResolver contentResolver) {
        if (f11131a == null) {
            f11131a = new HashMap();
            f11133c = new Object();
            new C32571("Gservices", contentResolver).start();
        }
    }

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        String string = getString(contentResolver, str);
        if (string != null) {
            try {
                j = Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static String getString(ContentResolver contentResolver, String str) {
        return zza(contentResolver, str, null);
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzaeo.class) {
            m17165a(contentResolver);
            Object obj = f11133c;
            String str3;
            if (f11131a.containsKey(str)) {
                str3 = (String) f11131a.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            } else {
                Iterator it = f11132b.iterator();
                while (it.hasNext()) {
                    if (str.startsWith((String) it.next())) {
                        break;
                    }
                }
                Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str3 = query.getString(1);
                            synchronized (zzaeo.class) {
                                if (obj == f11133c) {
                                    f11131a.put(str, str3);
                                }
                            }
                            if (str3 != null) {
                                str2 = str3;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                f11131a.put(str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str2;
    }

    public static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(aLH, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    public static void zzb(ContentResolver contentResolver, String... strArr) {
        Map zza = zza(contentResolver, strArr);
        synchronized (zzaeo.class) {
            m17165a(contentResolver);
            f11132b.addAll(Arrays.asList(strArr));
            for (Entry entry : zza.entrySet()) {
                f11131a.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }
}
