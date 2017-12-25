package com.urbanairship.analytics;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3788b;
import com.urbanairship.json.C3788b.C3787a;
import com.urbanairship.push.C3919j;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public abstract class C3737i {
    private final String f13414a;
    private final String f13415b;

    public abstract String mo2778a();

    protected abstract C3788b mo2779b();

    public C3737i(long j) {
        this.f13414a = UUID.randomUUID().toString();
        this.f13415b = C3737i.m19485a(j);
    }

    public C3737i() {
        this(System.currentTimeMillis());
    }

    public String m19490d() {
        return this.f13414a;
    }

    public String m19491e() {
        return this.f13415b;
    }

    String m19487a(String str) {
        C3787a a = C3788b.m19777a();
        a.m19774a(ShareConstants.MEDIA_TYPE, mo2778a()).m19774a("event_id", this.f13414a).m19774a("time", this.f13415b).m19772a(ShareConstants.WEB_DIALOG_PARAM_DATA, C3788b.m19777a().m19770a(mo2779b()).m19774a("session_id", str).m19776a());
        return a.m19776a().toString();
    }

    public ArrayList<String> m19492f() {
        ArrayList<String> arrayList = new ArrayList();
        C3919j n = C3929q.m20372a().m20390n();
        if (n.m20308b()) {
            if (n.m20322n()) {
                arrayList.add("sound");
            }
            if (n.m20323o()) {
                arrayList.add("vibrate");
            }
        }
        return arrayList;
    }

    public String m19493g() {
        int type;
        ConnectivityManager connectivityManager = (ConnectivityManager) C3929q.m20382h().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                type = activeNetworkInfo.getType();
                switch (type) {
                    case 0:
                        return "cell";
                    case 1:
                        return "wifi";
                    case 6:
                        return "wimax";
                    default:
                        return "none";
                }
            }
        }
        type = -1;
        switch (type) {
            case 0:
                return "cell";
            case 1:
                return "wifi";
            case 6:
                return "wimax";
            default:
                return "none";
        }
    }

    public String m19494h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) C3929q.m20382h().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getSubtypeName();
            }
        }
        return "";
    }

    protected String m19495i() {
        return ((TelephonyManager) C3929q.m20382h().getSystemService("phone")).getNetworkOperatorName();
    }

    protected long m19496j() {
        return (long) (Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
    }

    protected boolean m19497k() {
        return Calendar.getInstance().getTimeZone().inDaylightTime(new Date());
    }

    public boolean mo2780c() {
        return true;
    }

    protected static String m19485a(long j) {
        return String.format(Locale.US, "%.3f", new Object[]{Double.valueOf(((double) j) / 1000.0d)});
    }

    protected int mo2786l() {
        return 1;
    }
}
