package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.ad.C0137c;
import android.support.v4.app.ad.C0138d;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.iid.FirebaseInstanceIdInternalReceiver;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

class C3626a {
    static C3626a f13156a;
    private final Context f13157b;
    private final AtomicInteger f13158c = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private C3626a(Context context) {
        this.f13157b = context.getApplicationContext();
    }

    private int m18954a() {
        return this.f13158c.incrementAndGet();
    }

    private PendingIntent m18955a(Bundle bundle, PendingIntent pendingIntent) {
        Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
        m18959a(intent, bundle);
        intent.putExtra("pending_intent", pendingIntent);
        return PendingIntent.getBroadcast(this.f13157b, m18954a(), FirebaseInstanceIdInternalReceiver.m18899b(this.f13157b, intent), 1073741824);
    }

    static synchronized C3626a m18956a(Context context) {
        C3626a c3626a;
        synchronized (C3626a.class) {
            if (f13156a == null) {
                f13156a = new C3626a(context);
            }
            c3626a = f13156a;
        }
        return c3626a;
    }

    static String m18957a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private static String m18958a(String str) {
        return str.substring("gcm.n.".length());
    }

    private void m18959a(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private void m18960a(String str, Notification notification) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.f13157b.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static boolean m18961a(Bundle bundle) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(C3626a.m18957a(bundle, "gcm.n.e")) || C3626a.m18957a(bundle, "gcm.n.icon") != null;
    }

    private int m18962b(String str) {
        int identifier;
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.f13157b.getResources();
            identifier = resources.getIdentifier(str, "drawable", this.f13157b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            identifier = resources.getIdentifier(str, "mipmap", this.f13157b.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(str).length() + 57).append("Icon resource ").append(str).append(" not found. Notification will use app icon.").toString());
        }
        identifier = this.f13157b.getApplicationInfo().icon;
        return identifier == 0 ? 17301651 : identifier;
    }

    static String m18963b(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        return C3626a.m18957a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    static boolean m18964b(Context context) {
        if (((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    private Uri m18965c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str) || this.f13157b.getResources().getIdentifier(str, "raw", this.f13157b.getPackageName()) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        String valueOf = String.valueOf("android.resource://");
        String valueOf2 = String.valueOf(this.f13157b.getPackageName());
        return Uri.parse(new StringBuilder(((String.valueOf(valueOf).length() + 5) + String.valueOf(valueOf2).length()) + String.valueOf(str).length()).append(valueOf).append(valueOf2).append("/raw/").append(str).toString());
    }

    static String m18966c(Bundle bundle) {
        Object a = C3626a.m18957a(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(a) ? C3626a.m18957a(bundle, "gcm.n.sound") : a;
    }

    static Object[] m18967c(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_args");
        String a = C3626a.m18957a(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(a);
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jSONArray.opt(i);
            }
            return strArr;
        } catch (JSONException e) {
            valueOf = "FirebaseMessaging";
            String valueOf3 = String.valueOf(str);
            valueOf2 = String.valueOf("_loc_args");
            valueOf2 = String.valueOf(C3626a.m18958a(valueOf2.length() != 0 ? valueOf3.concat(valueOf2) : new String(valueOf3)));
            Log.w(valueOf, new StringBuilder((String.valueOf(valueOf2).length() + 41) + String.valueOf(a).length()).append("Malformed ").append(valueOf2).append(": ").append(a).append("  Default value will be used.").toString());
            return null;
        }
    }

    private Notification m18968d(Bundle bundle) {
        CharSequence d = m18969d(bundle, "gcm.n.title");
        CharSequence d2 = m18969d(bundle, "gcm.n.body");
        int b = m18962b(C3626a.m18957a(bundle, "gcm.n.icon"));
        Object a = C3626a.m18957a(bundle, "gcm.n.color");
        Uri c = m18965c(C3626a.m18966c(bundle));
        PendingIntent e = m18970e(bundle);
        PendingIntent pendingIntent = null;
        if (FirebaseMessagingService.m6225b(bundle)) {
            e = m18955a(bundle, e);
            pendingIntent = m18971f(bundle);
        }
        C0138d a2 = new C0138d(this.f13157b).m646c(true).m626a(b);
        if (TextUtils.isEmpty(d)) {
            a2.m636a(this.f13157b.getApplicationInfo().loadLabel(this.f13157b.getPackageManager()));
        } else {
            a2.m636a(d);
        }
        if (!TextUtils.isEmpty(d2)) {
            a2.m642b(d2);
            a2.m635a(new C0137c().m622c(d2));
        }
        if (!TextUtils.isEmpty(a)) {
            a2.m648d(Color.parseColor(a));
        }
        if (c != null) {
            a2.m632a(c);
        }
        if (e != null) {
            a2.m630a(e);
        }
        if (pendingIntent != null) {
            a2.m641b(pendingIntent);
        }
        return a2.m639b();
    }

    private String m18969d(Bundle bundle, String str) {
        Object a = C3626a.m18957a(bundle, str);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String b = C3626a.m18963b(bundle, str);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        Resources resources = this.f13157b.getResources();
        int identifier = resources.getIdentifier(b, "string", this.f13157b.getPackageName());
        if (identifier == 0) {
            String str2 = "FirebaseMessaging";
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf("_loc_key");
            valueOf2 = String.valueOf(C3626a.m18958a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
            Log.w(str2, new StringBuilder((String.valueOf(valueOf2).length() + 49) + String.valueOf(b).length()).append(valueOf2).append(" resource not found: ").append(b).append(" Default value will be used.").toString());
            return null;
        }
        Object[] c = C3626a.m18967c(bundle, str);
        if (c == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, c);
        } catch (Throwable e) {
            valueOf = String.valueOf(Arrays.toString(c));
            Log.w("FirebaseMessaging", new StringBuilder((String.valueOf(b).length() + 58) + String.valueOf(valueOf).length()).append("Missing format argument for ").append(b).append(": ").append(valueOf).append(" Default value will be used.").toString(), e);
            return null;
        }
    }

    private PendingIntent m18970e(Bundle bundle) {
        Intent intent;
        Object a = C3626a.m18957a(bundle, "gcm.n.click_action");
        Intent launchIntentForPackage;
        if (TextUtils.isEmpty(a)) {
            launchIntentForPackage = this.f13157b.getPackageManager().getLaunchIntentForPackage(this.f13157b.getPackageName());
            if (launchIntentForPackage == null) {
                Log.w("FirebaseMessaging", "No activity found to launch app");
                return null;
            }
            intent = launchIntentForPackage;
        } else {
            launchIntentForPackage = new Intent(a);
            launchIntentForPackage.setPackage(this.f13157b.getPackageName());
            launchIntentForPackage.setFlags(268435456);
            intent = launchIntentForPackage;
        }
        Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.m6224a(bundle2);
        intent.putExtras(bundle2);
        for (String str : bundle2.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.f13157b, m18954a(), intent, 1073741824);
    }

    private PendingIntent m18971f(Bundle bundle) {
        Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
        m18959a(intent, bundle);
        return PendingIntent.getBroadcast(this.f13157b, m18954a(), FirebaseInstanceIdInternalReceiver.m18899b(this.f13157b, intent), 1073741824);
    }

    void m18972b(Bundle bundle) {
        m18960a(C3626a.m18957a(bundle, "gcm.n.tag"), m18968d(bundle));
    }
}
