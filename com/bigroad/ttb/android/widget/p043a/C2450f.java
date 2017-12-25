package com.bigroad.ttb.android.widget.p043a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.widget.C2463l;

public class C2450f extends C2443c {
    private final int f8724g;
    private final String f8725h;
    private final String f8726i;
    private final String f8727j;
    private final String f8728k;

    public C2450f(Activity activity, C2446d c2446d, int i, int i2, CharSequence charSequence, String str, String str2, String str3, String str4) {
        super(activity, c2446d, i2, charSequence, false);
        this.f8724g = i;
        this.f8725h = str;
        this.f8726i = str2;
        this.f8727j = str3;
        this.f8728k = str4;
    }

    public boolean mo1341a() {
        if (this.f == null) {
            this.f = new C2463l(this.a);
            this.f.setOnClickListener(this);
        }
        this.f.setIcon(this.f8725h);
        this.f.setLabel(this.d);
        if (!OurApplication.m6245B().m10548c()) {
            this.f.m12115a();
        }
        return true;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("appName", this.d.toString());
        bundle.putString("packageName", this.f8726i);
        bundle.putString("referral", this.f8727j);
        bundle.putString("appDescription", this.f8728k);
        bundle.putInt("requestCode", mo1342b());
        this.a.showDialog(this.f8724g, bundle);
    }

    public static Dialog m12075a(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.launcher_install, null);
        C0584a c0584a = new C0584a(activity);
        c0584a.m2674b(inflate).m2678c(R.drawable.ic_dialog_info_light).m2668a((CharSequence) "Install Application").m2661a((int) R.string.launcherInstall_installButton, null).m2673b(17039360, C1843a.f6286a);
        return c0584a.m2677b();
    }

    public static void m12076a(Dialog dialog, final Activity activity, final Bundle bundle) {
        Resources resources = activity.getResources();
        C0586c c0586c = (C0586c) dialog;
        c0586c.setTitle(resources.getString(R.string.launcherInstall_title, new Object[]{bundle.getString("appName")}));
        ((TextView) c0586c.findViewById(R.id.launcherInstall_descriptionText)).setText(bundle.getString("appDescription"));
        c0586c.m2691a(-1, resources.getString(R.string.launcherInstall_installButton), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    activity.startActivityForResult(new Intent("android.intent.action.VIEW").setData(Uri.parse("market://details?id=" + bundle.getString("packageName") + am.m4185a(bundle.getString("referral")))), bundle.getInt("requestCode"));
                    OurApplication.m6272a(activity).show();
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(activity, R.string.dashboard_noPlayStoreNote, 1).show();
                }
                dialogInterface.dismiss();
            }
        });
    }
}
