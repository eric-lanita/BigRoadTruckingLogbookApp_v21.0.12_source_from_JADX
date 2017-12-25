package com.urbanairship.analytics;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import com.urbanairship.C3761b;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;
import com.urbanairship.json.C3785a;
import com.urbanairship.json.JsonValue;
import com.urbanairship.p055b.C3756a;
import com.urbanairship.p055b.C3757b;
import com.urbanairship.p055b.C3760c;
import com.urbanairship.util.C3949d;
import com.urbanairship.util.C3950e;
import com.urbanairship.util.C3954i;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

class C3745j {
    private final C3757b f13436a;

    C3745j() {
        this(new C3757b());
    }

    C3745j(C3757b c3757b) {
        this.f13436a = c3757b;
    }

    C3748l m19539a(Collection<String> collection) {
        if (collection.size() == 0) {
            C3783j.m19723b("EventApiClient - No events to send.");
            return null;
        } else if (C3950e.m20503a()) {
            URL url;
            boolean z;
            List arrayList = new ArrayList();
            for (String b : collection) {
                try {
                    arrayList.add(JsonValue.m19740b(b));
                } catch (Throwable e) {
                    C3783j.m19726c("EventApiClient - Invalid eventPayload.", e);
                }
            }
            String c3785a = new C3785a(arrayList).toString();
            String str = C3929q.m20372a().m20388l().f13506f + "warp9/";
            try {
                url = new URL(str);
            } catch (Throwable e2) {
                C3783j.m19726c("EventApiClient - Invalid analyticsServer: " + str, e2);
                url = null;
            }
            if (C3929q.m20372a().m20399w() == 1) {
                str = "amazon";
            } else {
                str = "android";
            }
            double currentTimeMillis = ((double) System.currentTimeMillis()) / 1000.0d;
            C3761b l = C3929q.m20372a().m20388l();
            C3756a c = this.f13436a.m19648a("POST", url).m19646b(c3785a, "application/json").m19644a(true).m19647c("X-UA-Device-Family", str).m19647c("X-UA-Sent-At", String.format(Locale.US, "%.3f", new Object[]{Double.valueOf(currentTimeMillis)})).m19647c("X-UA-Package-Name", C3929q.m20374b()).m19647c("X-UA-Package-Version", C3929q.m20379e().versionName).m19647c("X-UA-App-Key", l.m19664a()).m19647c("X-UA-In-Production", Boolean.toString(l.f13511k)).m19647c("X-UA-Device-Model", Build.MODEL).m19647c("X-UA-Android-Version-Code", String.valueOf(VERSION.SDK_INT)).m19647c("X-UA-Lib-Version", C3929q.m20385k()).m19647c("X-UA-Timezone", TimeZone.getDefault().getID()).m19647c("X-UA-Channel-Opted-In", Boolean.toString(C3929q.m20372a().m20390n().m20314f()));
            c3785a = "X-UA-Channel-Background-Enabled";
            if (C3929q.m20372a().m20390n().m20308b() && C3929q.m20372a().m20390n().m20313e()) {
                z = true;
            } else {
                z = false;
            }
            C3756a c2 = c.m19647c(c3785a, Boolean.toString(z)).m19647c("X-UA-Location-Permission", C3745j.m19537b()).m19647c("X-UA-Location-Service-Enabled", Boolean.toString(C3929q.m20372a().m20392p().m19907b())).m19647c("X-UA-Bluetooth-Status", Boolean.toString(C3745j.m19538c())).m19647c("X-UA-User-ID", C3929q.m20372a().m20391o().m20439b().m20478b());
            Locale locale = Locale.getDefault();
            if (!C3954i.m20512a(locale.getLanguage())) {
                c2.m19647c("X-UA-Locale-Language", locale.getLanguage());
                if (!C3954i.m20512a(locale.getCountry())) {
                    c2.m19647c("X-UA-Locale-Country", locale.getCountry());
                }
                if (!C3954i.m20512a(locale.getVariant())) {
                    c2.m19647c("X-UA-Locale-Variant", locale.getVariant());
                }
            }
            str = C3929q.m20372a().m20390n().m20329u();
            if (!C3954i.m20512a(str)) {
                c2.m19647c("X-UA-Channel-ID", str);
                c2.m19647c("X-UA-Push-Address", str);
            }
            C3783j.m19725c("EventApiClient - Sending analytic events. Request:  " + c2 + " Events: " + collection);
            C3760c a = c2.m19645a();
            C3783j.m19725c("EventApiClient - Analytic event send response: " + a);
            if (a != null) {
                return new C3748l(a);
            }
            return null;
        } else {
            C3783j.m19723b("EventApiClient - No network connectivity available. Unable to send events.");
            return null;
        }
    }

    static String m19536a() {
        if (C3949d.m20499b("android.permission.ACCESS_COARSE_LOCATION") || C3949d.m20499b("android.permission.ACCESS_FINE_LOCATION")) {
            return "ALWAYS_ALLOWED";
        }
        return "NOT_ALLOWED";
    }

    static String m19537b() {
        if (VERSION.SDK_INT >= 23) {
            if (C3929q.m20382h().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || C3929q.m20382h().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                return "ALWAYS_ALLOWED";
            }
            return "NOT_ALLOWED";
        } else if (VERSION.SDK_INT >= 19) {
            int i = 0;
            try {
                i = Secure.getInt(C3929q.m20382h().getContentResolver(), "location_mode");
            } catch (SettingNotFoundException e) {
                C3783j.m19725c("EventApiClient - Settings not found.");
            }
            if (i != 0) {
                return C3745j.m19536a();
            }
            return "SYSTEM_LOCATION_DISABLED";
        } else if (C3954i.m20512a(Secure.getString(C3929q.m20382h().getContentResolver(), "location_providers_allowed"))) {
            return "SYSTEM_LOCATION_DISABLED";
        } else {
            return C3745j.m19536a();
        }
    }

    static boolean m19538c() {
        if (!C3949d.m20499b("android.permission.BLUETOOTH")) {
            return false;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            return false;
        }
        return true;
    }
}
