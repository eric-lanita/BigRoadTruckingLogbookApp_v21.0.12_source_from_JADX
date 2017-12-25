package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ag.C0133a;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.facebook.applinks.AppLinkData;
import com.facebook.share.internal.ShareConstants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ak {
    private static final Object f551a = new Object();
    private static Field f552b;
    private static boolean f553c;
    private static final Object f554d = new Object();

    public static class C0155a implements ab, ac {
        private Builder f548a;
        private final Bundle f549b;
        private List<Bundle> f550c = new ArrayList();

        public C0155a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i2, int i3, boolean z, boolean z2, int i4, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2) {
            boolean z5;
            Builder lights = new Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
            if ((notification.flags & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOngoing(z5);
            if ((notification.flags & 8) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setOnlyAlertOnce(z5);
            if ((notification.flags & 16) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            lights = lights.setAutoCancel(z5).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f548a = lights.setFullScreenIntent(pendingIntent2, z5).setLargeIcon(bitmap).setNumber(i).setUsesChronometer(z2).setPriority(i4).setProgress(i2, i3, z);
            this.f549b = new Bundle();
            if (bundle != null) {
                this.f549b.putAll(bundle);
            }
            if (z3) {
                this.f549b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f549b.putString("android.support.groupKey", str);
                if (z4) {
                    this.f549b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f549b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (str2 != null) {
                this.f549b.putString("android.support.sortKey", str2);
            }
        }

        public void mo123a(C0133a c0133a) {
            this.f550c.add(ak.m702a(this.f548a, c0133a));
        }

        public Builder mo122a() {
            return this.f548a;
        }

        public Notification mo124b() {
            Notification build = this.f548a.build();
            Bundle a = ak.m703a(build);
            Bundle bundle = new Bundle(this.f549b);
            for (String str : this.f549b.keySet()) {
                if (a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a.putAll(bundle);
            SparseArray a2 = ak.m705a(this.f550c);
            if (a2 != null) {
                ak.m703a(build).putSparseParcelableArray("android.support.actionExtras", a2);
            }
            return build;
        }
    }

    public static void m708a(ac acVar, CharSequence charSequence, boolean z, CharSequence charSequence2, CharSequence charSequence3) {
        BigTextStyle bigText = new BigTextStyle(acVar.mo122a()).setBigContentTitle(charSequence).bigText(charSequence3);
        if (z) {
            bigText.setSummaryText(charSequence2);
        }
    }

    public static void m707a(ac acVar, CharSequence charSequence, boolean z, CharSequence charSequence2, Bitmap bitmap, Bitmap bitmap2, boolean z2) {
        BigPictureStyle bigPicture = new BigPictureStyle(acVar.mo122a()).setBigContentTitle(charSequence).bigPicture(bitmap);
        if (z2) {
            bigPicture.bigLargeIcon(bitmap2);
        }
        if (z) {
            bigPicture.setSummaryText(charSequence2);
        }
    }

    public static void m709a(ac acVar, CharSequence charSequence, boolean z, CharSequence charSequence2, ArrayList<CharSequence> arrayList) {
        InboxStyle bigContentTitle = new InboxStyle(acVar.mo122a()).setBigContentTitle(charSequence);
        if (z) {
            bigContentTitle.setSummaryText(charSequence2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine((CharSequence) it.next());
        }
    }

    public static SparseArray<Bundle> m705a(List<Bundle> list) {
        SparseArray<Bundle> sparseArray = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Bundle bundle = (Bundle) list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle m703a(Notification notification) {
        synchronized (f551a) {
            if (f553c) {
                return null;
            }
            try {
                if (f552b == null) {
                    Field declaredField = Notification.class.getDeclaredField(AppLinkData.ARGUMENTS_EXTRAS_KEY);
                    if (Bundle.class.isAssignableFrom(declaredField.getType())) {
                        declaredField.setAccessible(true);
                        f552b = declaredField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f553c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f552b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f552b.set(notification, bundle);
                }
                return bundle;
            } catch (Throwable e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f553c = true;
                return null;
            } catch (Throwable e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f553c = true;
                return null;
            }
        }
    }

    public static Bundle m702a(Builder builder, C0133a c0133a) {
        builder.addAction(c0133a.mo113a(), c0133a.mo114b(), c0133a.mo115c());
        Bundle bundle = new Bundle(c0133a.mo116d());
        if (c0133a.mo117f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", ar.m771a(c0133a.mo117f()));
        }
        return bundle;
    }

    public static ArrayList<Parcelable> m706a(C0133a[] c0133aArr) {
        if (c0133aArr == null) {
            return null;
        }
        ArrayList<Parcelable> arrayList = new ArrayList(c0133aArr.length);
        for (C0133a a : c0133aArr) {
            arrayList.add(m704a(a));
        }
        return arrayList;
    }

    private static Bundle m704a(C0133a c0133a) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", c0133a.mo113a());
        bundle.putCharSequence(ShareConstants.WEB_DIALOG_PARAM_TITLE, c0133a.mo114b());
        bundle.putParcelable("actionIntent", c0133a.mo115c());
        bundle.putBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY, c0133a.mo116d());
        bundle.putParcelableArray("remoteInputs", ar.m771a(c0133a.mo117f()));
        return bundle;
    }
}
