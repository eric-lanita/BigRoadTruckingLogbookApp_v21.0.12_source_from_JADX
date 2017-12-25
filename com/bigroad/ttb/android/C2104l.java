package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.logging.C2134e;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.io.FileNotFoundException;
import java.util.Properties;

public class C2104l {
    private static C2104l f7347a;
    private boolean f7348b;
    private String f7349c;
    private final Properties f7350d = new Properties();

    public static C2104l m10542a(Context context) {
        if (f7347a == null) {
            f7347a = new C2104l(context);
        }
        return f7347a;
    }

    private C2104l(Context context) {
        try {
            this.f7350d.load(context.getResources().getAssets().open("developer.properties"));
        } catch (FileNotFoundException e) {
            C2134e.m10678c("TT-DeveloperProperties", "No developer.properties asset found. Ignoring.");
        } catch (Throwable e2) {
            C2134e.m10679c("TT-DeveloperProperties", "Failed to open developer properties file: developer.properties", e2);
        }
        this.f7348b = OurApplication.m6285g().m12175T();
        if (this.f7348b) {
            this.f7349c = OurApplication.m6285g().m12176U();
        }
    }

    private String m10544g() {
        if (this.f7348b) {
            return this.f7349c;
        }
        if (!this.f7350d.containsKey("bigroad.server")) {
            return "app.bigroad.com";
        }
        String[] split = this.f7350d.getProperty("bigroad.server").split(";");
        if (split.length < 1) {
            return "app.bigroad.com";
        }
        return split[0];
    }

    public String m10545a() {
        String g = m10544g();
        CharSequence trim = am.m4185a(this.f7350d.getProperty("bigroad.serverHttpPort")).trim();
        return am.m4188a(trim) ? g : g + ":" + trim;
    }

    public String m10547b() {
        String g = m10544g();
        CharSequence trim = am.m4185a(this.f7350d.getProperty("bigroad.serverHttpsPort")).trim();
        return am.m4188a(trim) ? g : g + ":" + trim;
    }

    public boolean m10548c() {
        return C2104l.m10543b(this.f7350d.getProperty("bigroad.fakeLauncher", "false"));
    }

    public boolean m10549d() {
        return C2104l.m10543b(this.f7350d.getProperty("bigroad.motionLock", "false"));
    }

    public boolean m10550e() {
        return C2104l.m10543b(this.f7350d.getProperty("bigroad.frequentIntermediateDrivingEvents", "false"));
    }

    private static boolean m10543b(String str) {
        if (str == null) {
            return false;
        }
        if (str.equalsIgnoreCase("enabled") || str.equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            return true;
        }
        return false;
    }

    public void m10546a(String str) {
        this.f7348b = true;
        this.f7349c = str;
        C1263c.m6651f();
    }

    public void m10551f() {
        this.f7348b = false;
        this.f7349c = null;
        C1263c.m6651f();
    }
}
