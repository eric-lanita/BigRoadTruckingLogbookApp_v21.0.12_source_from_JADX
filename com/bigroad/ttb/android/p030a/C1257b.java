package com.bigroad.ttb.android.p030a;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.StatFs;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.bigroad.ttb.android.util.C2291k;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;

@SuppressLint({"NewApi"})
public abstract class C1257b {
    public static void m6613a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        if (C2291k.m11225d() >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static long m6606a(StatFs statFs) {
        if (C2291k.m11225d() >= 18) {
            return statFs.getAvailableBytes();
        }
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static void m6612a(Notification notification, int i) {
        if (C2291k.m11225d() < 21) {
        }
    }

    public static void m6614a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }

    public static Long m6609a(Location location) {
        if (location != null && C2291k.m11225d() >= 17) {
            return Long.valueOf(location.getElapsedRealtimeNanos() / 1000000);
        }
        return null;
    }

    public static void m6610a(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        if (C2291k.m11225d() >= 23) {
            alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
        } else if (C2291k.m11225d() >= 19) {
            alarmManager.setExact(i, j, pendingIntent);
        } else {
            alarmManager.set(i, j, pendingIntent);
        }
    }

    public static Notification m6607a(Builder builder) {
        if (C2291k.m11225d() >= 16) {
            return builder.build();
        }
        return builder.getNotification();
    }

    public static ContextWrapper m6608a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (C2291k.m11225d() >= 17) {
            configuration.setLocale(locale);
            context = context.createConfigurationContext(configuration);
        } else {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return new ContextWrapper(context);
    }

    public static void m6611a(Builder builder, String str) {
        if (C2291k.m11225d() >= 16) {
            builder.setStyle(new BigTextStyle().bigText(str));
        }
    }
}
