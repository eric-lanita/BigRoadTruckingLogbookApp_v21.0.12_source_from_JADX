package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ag.C0133a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

class al {

    public static class C0156a implements ab, ac {
        private Builder f555a;
        private Bundle f556b;
        private List<Bundle> f557c = new ArrayList();

        public C0156a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, boolean z3, int i4, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2) {
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
            this.f555a = lights.setFullScreenIntent(pendingIntent2, z6).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z3).setPriority(i4).setProgress(i2, i3, z);
            this.f556b = new Bundle();
            if (bundle != null) {
                this.f556b.putAll(bundle);
            }
            if (!(arrayList == null || arrayList.isEmpty())) {
                this.f556b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f556b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f556b.putString("android.support.groupKey", str);
                if (z5) {
                    this.f556b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f556b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f556b.putString("android.support.sortKey", str2);
            }
        }

        public void mo123a(C0133a c0133a) {
            this.f557c.add(ak.m702a(this.f555a, c0133a));
        }

        public Builder mo122a() {
            return this.f555a;
        }

        public Notification mo124b() {
            SparseArray a = ak.m705a(this.f557c);
            if (a != null) {
                this.f556b.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f555a.setExtras(this.f556b);
            return this.f555a.build();
        }
    }

    public static Bundle m713a(Notification notification) {
        return notification.extras;
    }
}
