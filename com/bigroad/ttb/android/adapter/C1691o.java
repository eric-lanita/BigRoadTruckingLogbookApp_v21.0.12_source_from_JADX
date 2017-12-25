package com.bigroad.ttb.android.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class C1691o extends BaseAdapter {
    private static final String[] f5856a = new String[]{"com.android.bluetooth", "com.android.email", "com.google.android.gm", "com.skype.raider", "org.kman.AquaMail", "com.yahoo.mobile.client.android.mail", "com.hotmail.Z7", "com.mail.mobile.android.mail", "com.google.android.apps.docs", "com.box.android", "com.dropbox.android", "com.sec.android.app.FileTransferClient"};
    private final PackageManager f5857b;
    private final LayoutInflater f5858c;
    private final Uri f5859d;
    private final String f5860e;
    private List<C1690a> f5861f = m8257a();

    private class C1690a {
        final /* synthetic */ C1691o f5850a;
        private final String f5851b;
        private final String f5852c;
        private final String f5853d;
        private final CharSequence f5854e;
        private final Drawable f5855f;

        public C1690a(C1691o c1691o, String str, ResolveInfo resolveInfo) {
            this.f5850a = c1691o;
            this.f5851b = str;
            this.f5852c = resolveInfo.activityInfo.packageName;
            this.f5853d = resolveInfo.activityInfo.name;
            this.f5854e = resolveInfo.loadLabel(c1691o.f5857b);
            this.f5855f = resolveInfo.loadIcon(c1691o.f5857b);
        }

        public String m8251a() {
            return this.f5851b;
        }

        public String m8252b() {
            return this.f5852c;
        }

        public String m8253c() {
            return this.f5853d;
        }

        public CharSequence m8254d() {
            return this.f5854e;
        }

        public Drawable m8255e() {
            return this.f5855f;
        }
    }

    public C1691o(Context context, Uri uri, String str) {
        this.f5857b = context.getPackageManager();
        this.f5858c = LayoutInflater.from(context);
        this.f5859d = uri;
        this.f5860e = str;
    }

    public int getCount() {
        return this.f5861f.size();
    }

    public Object getItem(int i) {
        return this.f5861f.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public Intent m8258a(int i) {
        C1690a c1690a = (C1690a) this.f5861f.get(i);
        if (c1690a == null) {
            return null;
        }
        OurApplication.m6282d().m8299b(c1690a.m8254d().toString());
        Intent intent = new Intent(c1690a.m8251a());
        intent.setType(this.f5860e);
        intent.putExtra("android.intent.extra.STREAM", this.f5859d);
        intent.setClassName(c1690a.m8252b(), c1690a.m8253c());
        return intent;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5858c.inflate(R.layout.app_chooser_item, viewGroup, false);
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.app_chooser_item_icon);
        ((TextView) view.findViewById(R.id.app_chooser_item_text)).setText(((C1690a) this.f5861f.get(i)).m8254d());
        imageView.setImageDrawable(((C1690a) this.f5861f.get(i)).m8255e());
        return view;
    }

    @SuppressLint({"DefaultLocale"})
    private List<C1690a> m8257a() {
        String str = "android.intent.action.SEND";
        Intent intent = new Intent(str);
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", this.f5859d);
        List<ResolveInfo> queryIntentActivities = this.f5857b.queryIntentActivities(intent, 0);
        List<C1690a> linkedList = new LinkedList();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            int i;
            if (resolveInfo.activityInfo.exported) {
                for (Object equals : f5856a) {
                    if (resolveInfo.activityInfo.packageName.equals(equals)) {
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i == 0) {
                    linkedList.add(new C1690a(this, str, resolveInfo));
                }
            }
        }
        str = "android.intent.action.VIEW";
        intent.setAction(str);
        queryIntentActivities = this.f5857b.queryIntentActivities(intent, 0);
        Collection linkedList2 = new LinkedList();
        for (ResolveInfo resolveInfo2 : queryIntentActivities) {
            String str2 = resolveInfo2.activityInfo.packageName;
            String toLowerCase = resolveInfo2.activityInfo.name.toLowerCase();
            if (toLowerCase != null && toLowerCase.contains("print")) {
                for (C1690a b : linkedList) {
                    if (b.m8252b().equals(str2)) {
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i == 0) {
                    linkedList2.add(new C1690a(this, str, resolveInfo2));
                }
            }
        }
        linkedList.addAll(linkedList2);
        return linkedList;
    }
}
