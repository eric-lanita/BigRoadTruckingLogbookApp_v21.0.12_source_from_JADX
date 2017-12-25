package com.urbanairship.util;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.CoreActivity;
import com.urbanairship.CoreReceiver;
import com.urbanairship.UrbanAirshipProvider;
import com.urbanairship.actions.ActionActivity;
import com.urbanairship.actions.ActionService;
import com.urbanairship.analytics.EventService;
import com.urbanairship.push.BaseIntentReceiver;
import com.urbanairship.push.PushService;
import com.urbanairship.richpush.RichPushUpdateService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class C3949d {
    private static final String[] f14007a = new String[]{"com.urbanairship.push.RECEIVED", "com.urbanairship.push.OPENED", "com.urbanairship.push.CHANNEL_UPDATED", "com.urbanairship.push.DISMISSED"};

    public static void m20497a(String str) {
        if (-1 == C3929q.m20378d().checkPermission(str, C3929q.m20374b())) {
            C3783j.m19728e("AndroidManifest.xml missing required permission: " + str);
        }
    }

    public static boolean m20499b(String str) {
        return C3929q.m20378d().checkPermission(str, C3929q.m20374b()) == 0;
    }

    public static ComponentInfo m20493a(Class cls) {
        try {
            return C3929q.m20378d().getServiceInfo(new ComponentName(C3929q.m20374b(), cls.getCanonicalName()), 128);
        } catch (Exception e) {
            return null;
        }
    }

    public static ActivityInfo m20498b(Class cls) {
        try {
            return C3929q.m20378d().getActivityInfo(new ComponentName(C3929q.m20374b(), cls.getCanonicalName()), 128);
        } catch (Exception e) {
            return null;
        }
    }

    public static ComponentInfo m20500c(Class cls) {
        try {
            return C3929q.m20378d().getReceiverInfo(new ComponentName(C3929q.m20374b(), cls.getCanonicalName()), 128);
        } catch (Exception e) {
            return null;
        }
    }

    public static ComponentInfo m20501c(String str) {
        return C3929q.m20378d().resolveContentProvider(str, 0);
    }

    public static boolean m20502d(String str) {
        try {
            C3929q.m20378d().getPermissionInfo(str, 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static void m20496a(C3761b c3761b) {
        ActivityInfo[] activityInfoArr = null;
        C3949d.m20497a("android.permission.INTERNET");
        C3949d.m20497a("android.permission.ACCESS_NETWORK_STATE");
        if (C3949d.m20502d(C3929q.m20376c())) {
            C3949d.m20497a(C3929q.m20376c());
        } else {
            C3783j.m19728e("AndroidManifest.xml does not define and require permission: " + C3929q.m20376c());
        }
        Map a = C3949d.m20494a();
        if (a.get(CoreReceiver.class) == null) {
            C3783j.m19728e("AndroidManifest.xml missing required receiver: " + CoreReceiver.class.getCanonicalName());
        } else {
            ComponentInfo componentInfo = (ComponentInfo) a.get(CoreReceiver.class);
            ResolveInfo resolveInfo = activityInfoArr;
            for (ResolveInfo resolveInfo2 : C3929q.m20378d().queryBroadcastReceivers(new Intent("com.urbanairship.push.OPENED").addCategory(C3929q.m20374b()), 0)) {
                ResolveInfo resolveInfo22;
                if (resolveInfo22.activityInfo == null || resolveInfo22.activityInfo.name == null || !resolveInfo22.activityInfo.name.equals(componentInfo.name)) {
                    resolveInfo22 = resolveInfo;
                }
                resolveInfo = resolveInfo22;
            }
            if (resolveInfo == null) {
                C3783j.m19728e("AndroidManifest.xml's " + CoreReceiver.class.getCanonicalName() + " declaration missing required intent-filter: <intent-filter android:priority=\"-999\">" + "<action android:name=\"" + "com.urbanairship.push.OPENED" + "\"/>" + "<category android:name=\"" + C3929q.m20374b() + "\"/></intent-filter>");
            } else if (resolveInfo.priority != -999) {
                C3783j.m19728e("CoreReceiver's intent filter priority should be set to -999 in order to let the application launch any activities before Urban Airship performs any actions or falls back to launching the application launch intent.");
            }
        }
        try {
            activityInfoArr = C3929q.m20378d().getPackageInfo(C3929q.m20374b(), 2).receivers;
        } catch (Throwable e) {
            C3783j.m19726c("Unable to query the application's receivers.", e);
        }
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                try {
                    if (BaseIntentReceiver.class.isAssignableFrom(Class.forName(activityInfo.name))) {
                        C3949d.m20495a(activityInfo);
                    }
                } catch (Throwable e2) {
                    C3783j.m19724b("ManifestUtils - Unable to find class: " + activityInfo.name, e2);
                }
            }
        }
        if (a.get(CoreActivity.class) == null) {
            C3783j.m19728e("AndroidManifest.xml missing required activity: " + CoreActivity.class.getCanonicalName());
        }
        if (c3761b.f13512l && a.get(EventService.class) == null) {
            C3783j.m19728e("AndroidManifest.xml missing required service: " + EventService.class.getCanonicalName());
        }
        if (a.get(PushService.class) == null) {
            C3783j.m19728e("AndroidManifest.xml missing required service: " + PushService.class.getCanonicalName());
        }
        if (a.get(RichPushUpdateService.class) == null) {
            C3783j.m19728e("AndroidManifest.xml missing required service: " + RichPushUpdateService.class.getCanonicalName());
        }
        if (a.get(ActionService.class) == null) {
            C3783j.m19728e("AndroidManifest.xml missing required service: " + ActionService.class.getCanonicalName());
        }
        if (a.get(ActionActivity.class) == null) {
            C3783j.m19721a("AndroidManifest.xml missing ActionActivity.  Action.startActivityForResult will not work.");
        }
        if (C3929q.m20378d().resolveActivity(new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", Uri.parse("http://")).setPackage(C3929q.m20374b()).addFlags(268435456).addCategory("android.intent.category.DEFAULT"), 0) == null) {
            C3783j.m19721a("AndroidManifest.xml missing activity with an intent filter for action com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION, category android.intent.category.DEFAULT, and data with scheme http.  Landing page action may not function properly.");
        }
        if (C3929q.m20378d().resolveActivity(new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", Uri.parse("https://")).setPackage(C3929q.m20374b()).addFlags(268435456).addCategory("android.intent.category.DEFAULT"), 0) == null) {
            C3783j.m19728e("AndroidManifest.xml missing activity with an intent filter for action com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION, category android.intent.category.DEFAULT, and data with scheme https. Landing page action may not function properly.");
        }
        if (C3929q.m20378d().resolveActivity(new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", Uri.parse("message://")).setPackage(C3929q.m20374b()).addFlags(268435456).addCategory("android.intent.category.DEFAULT"), 0) == null) {
            C3783j.m19728e("AndroidManifest.xml missing activity with an intent filter for action com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION, category android.intent.category.DEFAULT, and data with scheme message. Landing page action may not function properly.");
        }
        String b;
        if (C3929q.m20380f() == null) {
            b = C3929q.m20374b();
        } else {
            b = C3929q.m20380f().processName;
        }
        for (Class cls : a.keySet()) {
            ComponentInfo componentInfo2 = (ComponentInfo) a.get(cls);
            if (!(componentInfo2 == null || r2.equals(componentInfo2.processName))) {
                C3783j.m19721a("A separate process is detected for: " + cls.getCanonicalName() + ". In the " + "AndroidManifest.xml, remove the android:process attribute.");
            }
        }
        if (a.get(UrbanAirshipProvider.class) == null) {
            throw new IllegalStateException("Unable to resolve UrbanAirshipProvider. Please check that the provider is defined in your AndroidManifest.xml, and that the authority string is set to  \"" + UrbanAirshipProvider.m19289c(C3929q.m20382h()) + "\"");
        }
    }

    private static Map<Class, ComponentInfo> m20494a() {
        return new ManifestUtils$1();
    }

    private static void m20495a(ActivityInfo activityInfo) {
        int i;
        if (activityInfo.exported) {
            C3783j.m19728e("Receiver " + activityInfo.name + " is exported. This might " + "allow outside applications to message the receiver. Make sure the intent is protected by a " + "permission or prevent the receiver from being exported.");
        }
        List arrayList = new ArrayList();
        for (String str : f14007a) {
            for (ResolveInfo resolveInfo : C3929q.m20378d().queryBroadcastReceivers(new Intent(str).addCategory(C3929q.m20374b()), 0)) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.name != null && resolveInfo.activityInfo.name.equals(activityInfo.name)) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            C3783j.m19728e("Receiver " + activityInfo.name + " unable to receive intents for actions: " + arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Update the manifest entry for ").append(activityInfo.name).append(" to:").append("\n<receiver android:name=\"").append(activityInfo.name).append("\" exported=\"false\">").append("\n\t<intent-filter> ");
            for (String append : f14007a) {
                stringBuilder.append("\n\t\t<action android:name=\"").append(append).append("\" />");
            }
            stringBuilder.append("\n\t\t<!-- Replace ${applicationId} with ").append(C3929q.m20374b()).append(" if not using Android Gradle plugin -->").append("\n\t\t<category android:name=\"${applicationId}\" />").append("\n\t</intent-filter>").append("\n</receiver>");
            C3783j.m19728e(stringBuilder.toString());
        }
    }
}
