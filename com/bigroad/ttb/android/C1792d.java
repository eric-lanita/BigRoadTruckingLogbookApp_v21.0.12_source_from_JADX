package com.bigroad.ttb.android;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.OurActivity;

public final class C1792d {
    public static void m8818a(OurActivity ourActivity) {
        C2474y g = OurApplication.m6285g();
        int J = g.m12165J();
        g.m12164I();
        long a = OurApplication.m6269Z().mo913a();
        switch (J) {
            case 1:
                return;
            case 2:
                if (a - g.m12162G() >= 259200000) {
                    ourActivity.m6691J();
                    return;
                }
                return;
            default:
                long F = g.m12161F();
                if (F == 0 || F > a) {
                    g.m12206e(a);
                    F = a;
                }
                if (g.m12163H() >= 21 && a - r0 >= 604800000) {
                    ourActivity.m6691J();
                    return;
                }
                return;
        }
    }

    public static C0586c m8817a(final Context context) {
        final C2474y g = OurApplication.m6285g();
        C0584a c0584a = new C0584a(context);
        c0584a.m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.rateApp_title).m2672b((int) R.string.rateApp_message).m2661a((int) R.string.rateApp_rate, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                C1632a.m8008n(context);
                g.m12182a(1);
                dialogInterface.dismiss();
            }
        }).m2679c(R.string.rateApp_later, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                g.m12182a(2);
                dialogInterface.dismiss();
            }
        }).m2673b((int) R.string.rateApp_no, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                g.m12182a(1);
                dialogInterface.dismiss();
            }
        }).m2662a(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                g.m12182a(2);
            }
        });
        return c0584a.m2677b();
    }
}
