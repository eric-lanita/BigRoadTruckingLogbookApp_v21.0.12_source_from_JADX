package com.urbanairship;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.urbanairship.C3929q.C1186a;

public class C1187d implements C1186a {
    private static boolean f4008a;
    private static C1187d f4009b;

    public static void m6035c(Context context) {
        C1187d.m6034a((Application) context.getApplicationContext(), false);
    }

    public static synchronized void m6033a(Application application) {
        synchronized (C1187d.class) {
            C1187d.m6034a(application, false);
        }
    }

    static synchronized void m6034a(Application application, boolean z) {
        synchronized (C1187d.class) {
            if (!(C3929q.m20383i() || C3929q.m20384j())) {
                if (!f4008a && f4009b == null) {
                    f4009b = C1187d.m6036d(application);
                    f4008a = true;
                }
                if (f4009b != null) {
                    if (!z || f4009b.mo873a((Context) application)) {
                        C3761b b = f4009b.mo874b(application);
                        if (C3929q.m20383i() || C3929q.m20384j()) {
                            Log.e("Urban Airship Autopilot", "Airship is flying before autopilot is able to take off. Make sureAutoPilot.onCreateAirshipConfig is not calling takeOff directly.");
                        }
                        C3929q.m20373a(application, b, f4009b);
                        f4009b = null;
                    } else {
                        Log.i("Urban Airship Autopilot", "Skipping early takeoff.");
                    }
                }
            }
        }
    }

    private static C1187d m6036d(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                Log.e("Urban Airship Autopilot", "Unable to load app bundle.");
                return null;
            }
            String string = applicationInfo.metaData.getString("com.urbanairship.autopilot");
            if (string == null) {
                return null;
            }
            try {
                return (C1187d) Class.forName(string).newInstance();
            } catch (ClassNotFoundException e) {
                Log.e("Urban Airship Autopilot", "Class not found: " + string);
                return null;
            } catch (InstantiationException e2) {
                Log.e("Urban Airship Autopilot", "Unable to create class: " + string);
                return null;
            } catch (IllegalAccessException e3) {
                Log.e("Urban Airship Autopilot", "Unable to access class: " + string);
                return null;
            }
        } catch (Throwable e4) {
            Log.e("Urban Airship Autopilot", "Failed to get app' metadata.", e4);
            return null;
        }
    }

    public C3761b mo874b(Context context) {
        return null;
    }

    public boolean mo873a(Context context) {
        return true;
    }

    public void mo872a(C3929q c3929q) {
        C3783j.m19727d("Autopilot - Airship ready!");
    }
}
