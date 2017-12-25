package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;

class an {
    static void m745a(NotificationManager notificationManager, String str, int i) {
        notificationManager.cancel(str, i);
    }

    public static void m746a(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(str, i, notification);
    }
}
