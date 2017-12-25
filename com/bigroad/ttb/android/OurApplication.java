package com.bigroad.ttb.android;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.support.v4.content.FileProvider;
import android.text.format.Formatter;
import android.widget.Toast;
import com.bigroad.shared.C1145t;
import com.bigroad.shared.C1181z;
import com.bigroad.shared.MobileAppDiagnosticFlags;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.eobr.genx.GenxManager;
import com.bigroad.ttb.android.eobr.turbo.C1976f;
import com.bigroad.ttb.android.eobr.turbo.TurboFirmwareUpdateManager;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.location.C2119a;
import com.bigroad.ttb.android.location.C2122b;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.logging.C2127h;
import com.bigroad.ttb.android.logging.C2128b;
import com.bigroad.ttb.android.logging.C2129c;
import com.bigroad.ttb.android.logging.C2133d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.logging.C2135f;
import com.bigroad.ttb.android.logging.C2139j;
import com.bigroad.ttb.android.logging.C2146k;
import com.bigroad.ttb.android.logging.C2147l;
import com.bigroad.ttb.android.logging.LogFilter;
import com.bigroad.ttb.android.logging.LogFilter.FilterMode;
import com.bigroad.ttb.android.notification.C2208c;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1739d;
import com.bigroad.ttb.android.p029c.C1741f;
import com.bigroad.ttb.android.p030a.C1257b;
import com.bigroad.ttb.android.p032e.C1851a;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p037f.C2031c;
import com.bigroad.ttb.android.receiver.BatteryStatusReceiver;
import com.bigroad.ttb.android.status.p031a.C2242a;
import com.bigroad.ttb.android.status.p031a.C2250b;
import com.bigroad.ttb.android.status.p031a.C2256c;
import com.bigroad.ttb.android.status.p031a.C2260d;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.crashlytics.android.C2834a;
import com.facebook.internal.NativeProtocol;
import com.urbanairship.C1187d;
import io.fabric.sdk.android.C3969c;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Locale;

public class OurApplication extends Application {
    public static final C2128b f4123a = new C2128b(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, new LogFilter(new String[]{"TT-LocTracker"}, FilterMode.f7435b));
    private static OurApplication f4124b;
    private static C2032f f4125c;
    private boolean f4126d = false;
    private C1729b f4127e = null;
    private Locale f4128f = null;

    class C12122 implements Runnable {
        final /* synthetic */ OurApplication f4120a;

        C12122(OurApplication ourApplication) {
            this.f4120a = ourApplication;
        }

        public void run() {
            this.f4120a.f4127e = new C1729b();
            this.f4120a.f4127e.start();
        }
    }

    private interface C1213a {
        void mo903a(OutputStream outputStream);
    }

    private void ar() {
        boolean z;
        Throwable e;
        try {
            z = (getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.flags & 2) != 0;
        } catch (NameNotFoundException e2) {
            z = false;
            if (z) {
                C2134e.m10678c("TT-App", "Is debug build");
            }
            this.f4126d = false;
            if (z) {
                try {
                    this.f4126d = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getBoolean("com.bigroad.ttb.ReleaseBuild", false);
                    return;
                } catch (NameNotFoundException e3) {
                    e = e3;
                } catch (NullPointerException e4) {
                    e = e4;
                }
            } else {
                return;
            }
        } catch (NullPointerException e5) {
            z = false;
            if (z) {
                C2134e.m10678c("TT-App", "Is debug build");
            }
            this.f4126d = false;
            if (z) {
                this.f4126d = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getBoolean("com.bigroad.ttb.ReleaseBuild", false);
                return;
            }
            return;
        }
        if (z) {
            C2134e.m10678c("TT-App", "Is debug build");
        }
        this.f4126d = false;
        if (z) {
            this.f4126d = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData.getBoolean("com.bigroad.ttb.ReleaseBuild", false);
            return;
        }
        return;
        C2134e.m10679c("TT-App", "Unable to read release meta-data", e);
        this.f4126d = false;
    }

    public boolean m6306a() {
        return this.f4126d;
    }

    public void onCreate() {
        super.onCreate();
        this.f4128f = Locale.getDefault();
        C2134e.m10678c("TT-App", "Phone locale initialized to " + this.f4128f.toString());
        ar();
        if (m6306a()) {
            C2134e.m10678c("TT-App", "Enabling Crashlytics");
            C3969c.m20566a((Context) this, new C2834a());
            if (C2291k.m11224c(this) != null) {
                C2834a.m16004e().f9785c.m16399b(C2291k.m11224c(this));
            }
        }
        final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(this) {
            final /* synthetic */ OurApplication f4119b;

            public synchronized void uncaughtException(Thread thread, Throwable th) {
                try {
                    C1790a i = OurApplication.m6287i();
                    Long d = i.m8769d("app.unhandledExceptionTimestamp");
                    if (d == null || d.longValue() > OurApplication.m6269Z().mo913a()) {
                        d = Long.valueOf(0);
                    }
                    if (d.longValue() + 300000 <= OurApplication.m6269Z().mo913a()) {
                        this.f4119b.as();
                        i.m8740a("app.unhandledExceptionTimestamp", Long.valueOf(OurApplication.m6269Z().mo913a()));
                        this.f4119b.m6305a(thread, th);
                        C2134e.m10666a();
                        defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                    }
                } finally {
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            }
        });
        f4124b = this;
        f4125c = new C2394w();
        at();
        C2134e.m10678c("TT-App", "BigRoad " + C2291k.m11220a(this) + " " + (this.f4126d ? "RELEASE VERSION" : "DEV VERSION"));
        C2134e.m10678c("TT-App", "Application starting");
        try {
            PackageManager packageManager = getPackageManager();
            try {
                C2134e.m10676b("TT-App", "Google Play version : " + packageManager.getPackageInfo("com.google.android.gms", 0).versionCode);
            } catch (NameNotFoundException e) {
                C2134e.m10676b("TT-App", "Google Play not available");
            }
            long a = m6269Z().mo913a();
            C1790a i = m6287i();
            Long d = i.m8769d("app.loggedInstalledApplicationsTimestamp");
            if (d == null || d.longValue() > a) {
                d = Long.valueOf(0);
            }
            if (d.longValue() + 86400000 < a) {
                i.m8740a("app.loggedInstalledApplicationsTimestamp", Long.valueOf(a));
                for (ApplicationInfo applicationInfo : packageManager.getInstalledApplications(128)) {
                    C2134e.m10676b("TT-App", "Installed package : " + applicationInfo.packageName + " Source dir : " + applicationInfo.sourceDir);
                }
            }
        } catch (Exception e2) {
            C2134e.m10676b("TT-App", "Exception thrown while logging Android device info: " + e2.toString());
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        registerReceiver(new BatteryStatusReceiver(), intentFilter);
        au();
        ap();
        av();
        new Handler(Looper.getMainLooper()).post(new C12122(this));
        m6289k();
        m6290l();
        m6288j();
        m6300v();
        m6304z();
        m6247D();
        m6248E();
        m6251H();
        m6252I();
        ai();
        m6255L();
        m6261R();
        m6263T();
        m6267X();
        m6268Y();
        C2250b.m11074a(m6264U(), m6269Z());
        C2250b.m11074a(m6265V(), m6269Z());
        m6304z();
        m6266W();
        ah();
        ag();
        m6293o();
        C1187d.m6033a((Application) this);
        ad();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Locale locale = configuration.locale;
        if (!this.f4128f.equals(locale)) {
            this.f4128f = locale;
            C2134e.m10678c("TT-App", "Phone language changed to " + this.f4128f.toString());
        }
    }

    private void as() {
        if (this.f4127e != null) {
            this.f4127e.interrupt();
            this.f4127e = null;
        }
    }

    public void onTerminate() {
        as();
        super.onTerminate();
    }

    public void m6305a(Thread thread, Throwable th) {
        C2134e.m10671a(MobileAppDiagnosticFlags.LOG_UNCAUGHT_EXCEPTION, 5, "TT-App", "UncaughtException (" + thread.getName() + ")", th);
    }

    private void at() {
        C2127h c2139j = new C2139j();
        c2139j.m10697a(new C2147l());
        c2139j.m10697a(f4123a);
        c2139j.m10697a(m6258O());
        if (m6306a()) {
            c2139j.m10697a(new C2129c());
        }
        C2134e.m10672a(c2139j);
        m6259P();
    }

    public static OurApplication m6279b() {
        return f4124b;
    }

    public static Context m6281c() {
        return f4124b.getApplicationContext();
    }

    public static ag m6282d() {
        return ag.m8285a(f4124b);
    }

    public static PackageManager m6283e() {
        if (m6285g().m12177V()) {
            return m6281c().getPackageManager();
        }
        return null;
    }

    public static C2081g m6284f() {
        return C2081g.m10438a(f4124b);
    }

    public static C2474y m6285g() {
        return C2474y.m12144a(f4124b);
    }

    public static PowerStatus m6286h() {
        return PowerStatus.m6308a(f4124b);
    }

    public static C1790a m6287i() {
        return C1790a.m8692a(f4124b);
    }

    public static C1851a m6288j() {
        return C1851a.m8920a(f4124b);
    }

    public static SyncManager m6289k() {
        return SyncManager.m6377a(f4124b);
    }

    public static C2095h m6290l() {
        return C2095h.m10489a(f4124b);
    }

    public static C2119a m6291m() {
        return C2119a.m10609a(f4124b);
    }

    public static C2230r m6292n() {
        return C2230r.m10998a(f4124b);
    }

    public static C2472x m6293o() {
        return C2472x.m12134a(f4124b);
    }

    public static TruckManager m6294p() {
        return TruckManager.m6536a(f4124b);
    }

    public static EventManager m6295q() {
        return EventManager.m9971a(f4124b, f4125c);
    }

    public static C1736b m6296r() {
        return C1736b.m8459a(f4124b);
    }

    public static C2226q m6297s() {
        return C2226q.m10963a(f4124b);
    }

    public static C2315v m6298t() {
        return C2315v.m11286a(f4124b);
    }

    public static C2098i m6299u() {
        return C2098i.m10497a(f4124b);
    }

    public static C2208c m6300v() {
        return C2208c.m10898a(f4124b);
    }

    public static FcmManager m6301w() {
        return FcmManager.m6238a(f4125c);
    }

    public static LocationTracker m6302x() {
        return LocationTracker.m10574a(f4124b);
    }

    public static C2122b m6303y() {
        return C2122b.m10621a(f4124b);
    }

    public static C2222o m6304z() {
        return C2222o.m10926a(f4124b, f4125c);
    }

    public static ConnectivityTracker m6244A() {
        return ConnectivityTracker.m6107a(f4124b);
    }

    public static C2104l m6245B() {
        return C2104l.m10542a(f4124b);
    }

    public static C2031c m6246C() {
        return C2031c.m10140a();
    }

    public static ae m6247D() {
        return ae.m8274a(f4124b);
    }

    public static C2154m m6248E() {
        return C2154m.m10732a();
    }

    public static AuthMonitor m6249F() {
        return AuthMonitor.m6020a(f4124b);
    }

    public static BluetoothMonitor m6250G() {
        return BluetoothMonitor.m6051a(f4124b);
    }

    public static EobrManager m6251H() {
        return EobrManager.m9097a(f4124b);
    }

    public static VehicleConnectionManager m6252I() {
        return VehicleConnectionManager.m11359a(f4124b, f4125c);
    }

    public static C2242a m6253J() {
        return C2242a.m11058a();
    }

    public static C2260d m6254K() {
        return C2260d.m11096a();
    }

    public static SignatureManager m6255L() {
        return SignatureManager.m6324a();
    }

    public static ai m6256M() {
        return ai.m8368a();
    }

    public static C2232s m6257N() {
        return C2232s.m11023a();
    }

    public static C2146k m6258O() {
        return C2146k.m10708b();
    }

    public static C2133d m6259P() {
        return C2133d.m10656a();
    }

    public static C1739d m6260Q() {
        return C1739d.m8519d();
    }

    public static C1853e m6261R() {
        return C1853e.m8943a();
    }

    public static ClockMonitor m6262S() {
        return ClockMonitor.m6079a();
    }

    public static ab m6263T() {
        return ab.m6637a();
    }

    public static C1976f m6264U() {
        return C1976f.m9730a(f4125c);
    }

    public static GenxManager m6265V() {
        return GenxManager.m9339a(f4125c);
    }

    public static UnassignedDrivingMonitor m6266W() {
        return UnassignedDrivingMonitor.m6592a(f4125c);
    }

    public static TurboFirmwareUpdateManager m6267X() {
        return TurboFirmwareUpdateManager.m9570a(f4124b);
    }

    public static TrialUserMonitor m6268Y() {
        return TrialUserMonitor.m6513a();
    }

    public static ap m6269Z() {
        return C1259a.m6621e();
    }

    public static C2256c aa() {
        return C2256c.m11089a(f4124b);
    }

    public static ad ab() {
        return ad.m8032a();
    }

    public static C2032f ac() {
        return f4125c;
    }

    public static ah ad() {
        return ah.m8346a(f4124b, f4125c);
    }

    public static C2103j ae() {
        return C2103j.m10520a(f4125c);
    }

    public static C1741f af() {
        return C1741f.m8534a(f4125c);
    }

    public static ak ag() {
        return ak.m8403a(f4125c);
    }

    public static DrivingModeManager ah() {
        return DrivingModeManager.m6167a(f4125c);
    }

    public static aj ai() {
        return aj.m8381a(f4124b);
    }

    public static Locale aj() {
        return f4124b.f4128f;
    }

    public static boolean ak() {
        if (f4124b.getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0).size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean al() {
        return am() != null;
    }

    public static PackageInfo am() {
        PackageInfo a = m6270a("com.android.vending");
        if (a == null) {
            return m6270a("com.google.market");
        }
        return a;
    }

    public static PackageInfo m6270a(String str) {
        try {
            return f4124b.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean an() {
        return f4124b.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public static Uri m6271a(File file) {
        return FileProvider.m1076a(m6281c(), "com.bigroad.fileprovider", file);
    }

    public static File ao() {
        File filesDir = m6279b().getFilesDir();
        if (filesDir == null) {
            return null;
        }
        File file = new File(filesDir, "tmp");
        if (file.exists()) {
            return file;
        }
        file.mkdir();
        return file;
    }

    private static File m6274a(C1213a c1213a, String str) {
        File file;
        Closeable closeable;
        File ao = ao();
        if (ao == null) {
            return null;
        }
        try {
            ao = File.createTempFile("tempFile", str, ao);
            try {
                OutputStream fileOutputStream = new FileOutputStream(ao);
                try {
                    c1213a.mo903a(fileOutputStream);
                    fileOutputStream.close();
                    return ao;
                } catch (IOException e) {
                    OutputStream outputStream = fileOutputStream;
                    file = ao;
                    Object obj = outputStream;
                    C1181z.m5999a(closeable);
                    if (file != null) {
                        return null;
                    }
                    file.delete();
                    return null;
                }
            } catch (IOException e2) {
                file = ao;
                closeable = null;
                C1181z.m5999a(closeable);
                if (file != null) {
                    return null;
                }
                file.delete();
                return null;
            }
        } catch (IOException e3) {
            closeable = null;
            file = null;
            C1181z.m5999a(closeable);
            if (file != null) {
                return null;
            }
            file.delete();
            return null;
        }
    }

    public static File m6276a(final byte[] bArr) {
        return m6274a(new C1213a() {
            public void mo903a(OutputStream outputStream) {
                outputStream.write(bArr);
            }
        }, null);
    }

    public static File m6275a(final InputStream inputStream) {
        return m6274a(new C1213a() {
            public void mo903a(OutputStream outputStream) {
                C1181z.m5998a(inputStream, outputStream);
            }
        }, null);
    }

    private static void au() {
        File externalFilesDir = m6279b().getExternalFilesDir(null);
        if (!C1145t.m5769b(externalFilesDir)) {
            File file = new File(externalFilesDir, "FileUploads");
            if (!C1145t.m5769b(file)) {
                File filesDir = m6279b().getFilesDir();
                if (filesDir != null) {
                    File file2 = new File(filesDir, "FileUploads");
                    if (!file2.exists()) {
                        filesDir.mkdirs();
                    }
                    try {
                        C1145t.m5768b(file, file2);
                    } catch (Throwable e) {
                        C2134e.m10679c("TT-App", "Failed to migrate external data.", e);
                    }
                } else {
                    C2134e.m10682e("TT-App", "Cannot migrate external upload queue to internal; internal directory was not found.");
                }
            }
            C1145t.m5765a(externalFilesDir);
        }
    }

    public static void ap() {
        C1145t.m5765a(ao());
    }

    private long av() {
        long a = C1257b.m6606a(new StatFs(Environment.getDataDirectory().getPath()));
        C2134e.m10678c("TT-App", "Free internal space: " + Formatter.formatFileSize(this, a));
        return a;
    }

    public static Uri aq() {
        return Uri.parse("mailto:support@bigroad.com?subject=" + C2135f.f7457a);
    }

    @SuppressLint({"ShowToast"})
    public static Toast m6272a(Context context) {
        return Toast.makeText(context, R.string.dashboard_launcherBackNote, 1);
    }

    @SuppressLint({"ShowToast"})
    public static Toast m6278b(Context context) {
        return Toast.makeText(context, R.string.message_sentText, 1);
    }
}
