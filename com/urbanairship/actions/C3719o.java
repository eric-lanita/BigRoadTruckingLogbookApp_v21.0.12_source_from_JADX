package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.urbanairship.C3860o.C3856i;
import com.urbanairship.C3929q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C3719o extends C3690a {
    private static final List<String> f13369a = new ShareAction$1();

    public boolean mo2769b(C3694b c3694b) {
        switch (c3694b.m19358b()) {
            case 0:
            case 2:
            case 3:
            case 4:
                return c3694b.m19357a().m19314a() != null;
            default:
                return false;
        }
    }

    public C3701e mo2770d(C3694b c3694b) {
        Intent flags;
        final Context h = C3929q.m20382h();
        Intent putExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", c3694b.m19357a().m19314a());
        List<ResolveInfo> arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : C3929q.m20378d().queryIntentActivities(putExtra, 0)) {
            if (!(resolveInfo.activityInfo == null || m19406a(resolveInfo.activityInfo.packageName))) {
                arrayList.add(resolveInfo);
            }
        }
        Collections.sort(arrayList, new DisplayNameComparator(C3929q.m20378d()));
        List arrayList2 = new ArrayList();
        for (ResolveInfo resolveInfo2 : arrayList) {
            String str = resolveInfo2.resolvePackageName == null ? resolveInfo2.activityInfo.packageName : resolveInfo2.resolvePackageName;
            arrayList2.add(new LabeledIntent(putExtra, str, resolveInfo2.labelRes, resolveInfo2.icon).setPackage(str).setClassName(str, resolveInfo2.activityInfo.name));
        }
        if (arrayList.isEmpty()) {
            flags = Intent.createChooser(putExtra.setPackage(""), h.getString(C3856i.ua_share_dialog_title)).setFlags(268435456);
        } else {
            flags = Intent.createChooser((Intent) arrayList2.remove(arrayList2.size() - 1), h.getString(C3856i.ua_share_dialog_title)).putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList2.toArray(new Intent[arrayList2.size()])).setFlags(268435456);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ C3719o f13368c;

            public void run() {
                h.startActivity(flags);
            }
        });
        return C3701e.m19372a();
    }

    protected boolean m19406a(String str) {
        return f13369a.contains(str);
    }
}
