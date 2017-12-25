package com.urbanairship.push.p033a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ad.C0134a;
import android.support.v4.app.ad.C0134a.C0131a;
import android.support.v4.app.ad.C0134a.C0132b;
import com.urbanairship.CoreActivity;
import com.urbanairship.CoreReceiver;
import com.urbanairship.push.PushMessage;
import java.util.List;
import java.util.UUID;

public class C3869c {
    private final Bundle f13755a;
    private final String f13756b;
    private final int f13757c;
    private final boolean f13758d;
    private final int f13759e;
    private final String f13760f;
    private final List<C3866b> f13761g;

    public static class C3868a {
        private final String f13748a;
        private int f13749b = 0;
        private int f13750c = 0;
        private boolean f13751d = true;
        private List<C3866b> f13752e;
        private List<C0132b> f13753f;
        private String f13754g;

        public C3868a(String str) {
            this.f13748a = str;
        }

        public C3868a m20065a(int i) {
            this.f13749b = i;
            return this;
        }

        public C3868a m20066a(String str) {
            this.f13754g = str;
            return this;
        }

        public C3868a m20069b(int i) {
            this.f13750c = i;
            return this;
        }

        public C3868a m20067a(boolean z) {
            this.f13751d = z;
            return this;
        }

        public C3869c m20068a() {
            C0131a c0131a = new C0131a(this.f13750c, null, null);
            if (this.f13753f != null) {
                for (C0132b a : this.f13753f) {
                    c0131a.m601a(a);
                }
            }
            C0134a a2 = c0131a.m603a();
            return new C3869c(this.f13748a, a2.f488a, this.f13749b, this.f13754g, a2.mo116d(), this.f13751d, this.f13752e);
        }
    }

    private C3869c(String str, int i, int i2, String str2, Bundle bundle, boolean z, List<C3866b> list) {
        this.f13756b = str;
        this.f13757c = i2;
        this.f13759e = i;
        this.f13755a = bundle;
        this.f13760f = str2;
        this.f13758d = z;
        this.f13761g = list;
    }

    public String m20071a() {
        return this.f13760f;
    }

    public String m20072b() {
        return this.f13756b;
    }

    public int m20073c() {
        return this.f13757c;
    }

    public int m20074d() {
        return this.f13759e;
    }

    public boolean m20075e() {
        return this.f13758d;
    }

    C0134a m20070a(Context context, String str, PushMessage pushMessage, int i) {
        PendingIntent activity;
        CharSequence string = this.f13757c > 0 ? context.getString(this.f13757c) : "";
        Intent putExtra = new Intent("com.urbanairship.ACTION_NOTIFICATION_BUTTON_OPENED_PROXY").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", pushMessage.m20049h()).putExtra("com.urbanairship.push.NOTIFICATION_ID", i).putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID", this.f13756b).putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD", str).putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND", this.f13758d).putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION", this.f13760f == null ? string : this.f13760f);
        if (this.f13758d) {
            putExtra.setClass(context, CoreActivity.class);
            activity = PendingIntent.getActivity(context, 0, putExtra, 0);
        } else {
            putExtra.setClass(context, CoreReceiver.class);
            activity = PendingIntent.getBroadcast(context, 0, putExtra, 0);
        }
        C0131a a = new C0131a(this.f13759e, string, activity).m600a(this.f13755a);
        if (this.f13761g != null) {
            for (C3866b a2 : this.f13761g) {
                a.m602a(a2.m20064a(context));
            }
        }
        return a.m603a();
    }
}
