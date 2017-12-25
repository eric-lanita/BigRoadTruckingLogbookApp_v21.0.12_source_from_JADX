package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.aq.C0174a;

public class ag {

    public static abstract class C0133a {

        public interface C0129a {
        }

        public abstract int mo113a();

        public abstract CharSequence mo114b();

        public abstract PendingIntent mo115c();

        public abstract Bundle mo116d();

        public abstract C0174a[] mo117f();
    }

    public static Notification m694a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        return notification;
    }
}
