package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ag.C0133a;
import android.support.v4.app.aq.C0174a;
import android.widget.RemoteViews;
import java.util.ArrayList;

class ae {

    public static class C0152a implements ab, ac {
        private Builder f544a;
        private Bundle f545b;

        public C0152a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
            boolean z6;
            Builder lights = new Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOngoing(z6);
            if ((notification.flags & 8) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setOnlyAlertOnce(z6);
            if ((notification.flags & 16) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            lights = lights.setAutoCancel(z6).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.f544a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f545b = new Bundle();
            if (bundle != null) {
                this.f545b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f545b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        public void mo123a(C0133a c0133a) {
            ae.m690a(this.f544a, c0133a);
        }

        public Builder mo122a() {
            return this.f544a;
        }

        public Notification mo124b() {
            this.f544a.setExtras(this.f545b);
            return this.f544a.build();
        }
    }

    public static void m690a(Builder builder, C0133a c0133a) {
        Action.Builder builder2 = new Action.Builder(c0133a.mo113a(), c0133a.mo114b(), c0133a.mo115c());
        if (c0133a.mo117f() != null) {
            for (RemoteInput addRemoteInput : ap.m768a(c0133a.mo117f())) {
                builder2.addRemoteInput(addRemoteInput);
            }
        }
        if (c0133a.mo116d() != null) {
            builder2.addExtras(c0133a.mo116d());
        }
        builder.addAction(builder2.build());
    }

    private static Action m688a(C0133a c0133a) {
        Action.Builder addExtras = new Action.Builder(c0133a.mo113a(), c0133a.mo114b(), c0133a.mo115c()).addExtras(c0133a.mo116d());
        C0174a[] f = c0133a.mo117f();
        if (f != null) {
            for (RemoteInput addRemoteInput : ap.m768a(f)) {
                addExtras.addRemoteInput(addRemoteInput);
            }
        }
        return addExtras.build();
    }

    public static ArrayList<Parcelable> m689a(C0133a[] c0133aArr) {
        if (c0133aArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(c0133aArr.length);
        for (C0133a a : c0133aArr) {
            arrayList.add(m688a(a));
        }
        return arrayList;
    }
}
