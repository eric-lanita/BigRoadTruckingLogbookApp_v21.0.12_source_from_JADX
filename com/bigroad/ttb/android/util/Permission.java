package com.bigroad.ttb.android.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.C0127a;
import android.support.v4.content.C0126a;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.activity.OurActivity.C1549b;
import com.bigroad.ttb.android.logging.C2134e;

public enum Permission {
    LOCATION(1, R.string.permission_prerequest_location, R.string.permission_denied_location, null, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}),
    CAMERA(2, R.string.permission_prerequest_camera, R.string.permission_denied_camera, null, new String[]{"android.permission.CAMERA"}),
    READ_CONTACTS(4, R.string.permission_prerequest_contacts, R.string.permission_denied_contacts, null, new String[]{"android.permission.READ_CONTACTS"});
    
    private int m_deniedPermanentlyMessage;
    private int m_id;
    private Integer m_maxSdkVersion;
    private String[] m_permissions;
    private int m_preRequestMessage;

    public interface C1464a {
        void mo1003a();

        void mo1004b();
    }

    private Permission(int i, int i2, int i3, Integer num, String[] strArr) {
        this.m_id = i;
        this.m_preRequestMessage = i2;
        this.m_deniedPermanentlyMessage = i3;
        this.m_maxSdkVersion = num;
        this.m_permissions = strArr;
    }

    public boolean m11151a(Context context) {
        for (String a : this.m_permissions) {
            if (C0126a.m581a(context, a) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean m11146a(Activity activity) {
        for (String a : this.m_permissions) {
            if (C0127a.m591a(activity, a)) {
                return true;
            }
        }
        return false;
    }

    private void m11144a(final OurActivity ourActivity, final C1464a c1464a) {
        ourActivity.m6711a(new C1549b(this) {
            final /* synthetic */ Permission f7901c;

            public void mo1271a(int i, boolean z) {
                if (i == this.f7901c.m_id) {
                    if (z) {
                        c1464a.mo1003a();
                    } else if (this.f7901c.m11146a(ourActivity)) {
                        c1464a.mo1004b();
                    } else {
                        new C0584a(ourActivity).m2672b(this.f7901c.m_deniedPermanentlyMessage).m2661a(17039370, null).m2680c();
                    }
                    ourActivity.m6713b((C1549b) this);
                }
            }
        });
        C0127a.m590a((Activity) ourActivity, this.m_permissions, this.m_id);
    }

    public void m11149a(final Activity activity, final C1464a c1464a) {
        if (this.m_maxSdkVersion != null && C2291k.m11225d() > this.m_maxSdkVersion.intValue()) {
            C2134e.m10676b(toString(), "Permission not required in current SDK version");
            c1464a.mo1003a();
        } else if (activity == null || !(activity instanceof OurActivity)) {
            C2134e.m10680d(toString(), "Cannot request permission from an activity that isn't an instance of OurActivity");
        } else if (m11151a((Context) activity)) {
            c1464a.mo1003a();
        } else if (m11146a(activity)) {
            new C0584a(activity).m2672b(this.m_preRequestMessage).m2661a(17039370, new OnClickListener(this) {
                final /* synthetic */ Permission f7904c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f7904c.m11144a((OurActivity) activity, c1464a);
                }
            }).m2680c();
        } else {
            m11144a((OurActivity) activity, c1464a);
        }
    }

    public void m11150a(C1464a c1464a) {
        m11149a(OurApplication.m6284f().m10451c(), c1464a);
    }
}
