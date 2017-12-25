package io.fabric.sdk.android.services.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import io.fabric.sdk.android.C3969c;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommonUtils {
    public static final Comparator<File> f14119a = new C39911();
    private static Boolean f14120b = null;
    private static final char[] f14121c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static long f14122d = -1;

    static class C39911 implements Comparator<File> {
        C39911() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m20683a((File) obj, (File) obj2);
        }

        public int m20683a(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    enum Architecture {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        
        private static final Map<String, Architecture> f14117k = null;

        static {
            f14117k = new HashMap(4);
            f14117k.put("armeabi-v7a", ARMV7);
            f14117k.put("armeabi", ARMV6);
            f14117k.put("arm64-v8a", ARM64);
            f14117k.put("x86", X86_32);
        }

        static Architecture m20684a() {
            Object obj = Build.CPU_ABI;
            if (TextUtils.isEmpty(obj)) {
                C3969c.m20576h().mo2849a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            Architecture architecture = (Architecture) f14117k.get(obj.toLowerCase(Locale.US));
            if (architecture == null) {
                return UNKNOWN;
            }
            return architecture;
        }
    }

    public static SharedPreferences m20690a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String m20692a(File file, String str) {
        Throwable e;
        Throwable th;
        String str2 = null;
        if (file.exists()) {
            Closeable bufferedReader;
            try {
                String[] split;
                bufferedReader = new BufferedReader(new FileReader(file), 1024);
                while (true) {
                    try {
                        CharSequence readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        split = Pattern.compile("\\s*:\\s*").split(readLine, 2);
                        if (split.length > 1 && split[0].equals(str)) {
                            break;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                str2 = split[1];
                m20704a(bufferedReader, "Failed to close system file reader.");
            } catch (Exception e3) {
                e = e3;
                bufferedReader = null;
                try {
                    C3969c.m20576h().mo2857e("Fabric", "Error parsing " + file, e);
                    m20704a(bufferedReader, "Failed to close system file reader.");
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    m20704a(bufferedReader, "Failed to close system file reader.");
                    throw th;
                }
            } catch (Throwable e4) {
                bufferedReader = null;
                th = e4;
                m20704a(bufferedReader, "Failed to close system file reader.");
                throw th;
            }
        }
        return str2;
    }

    public static int m20685a() {
        return Architecture.m20684a().ordinal();
    }

    public static synchronized long m20708b() {
        long j;
        synchronized (CommonUtils.class) {
            if (f14122d == -1) {
                j = 0;
                Object a = m20692a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(a)) {
                    String toUpperCase = a.toUpperCase(Locale.US);
                    try {
                        if (toUpperCase.endsWith("KB")) {
                            j = m20688a(toUpperCase, "KB", 1024);
                        } else if (toUpperCase.endsWith("MB")) {
                            j = m20688a(toUpperCase, "MB", 1048576);
                        } else if (toUpperCase.endsWith("GB")) {
                            j = m20688a(toUpperCase, "GB", 1073741824);
                        } else {
                            C3969c.m20576h().mo2849a("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase);
                        }
                    } catch (Throwable e) {
                        C3969c.m20576h().mo2857e("Fabric", "Unexpected meminfo format while computing RAM: " + toUpperCase, e);
                    }
                }
                f14122d = j;
            }
            j = f14122d;
        }
        return j;
    }

    static long m20688a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    public static RunningAppProcessInfo m20689a(String str, Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    public static String m20693a(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    public static String m20695a(String str) {
        return m20696a(str, "SHA-1");
    }

    public static String m20712b(InputStream inputStream) {
        return m20694a(inputStream, "SHA-1");
    }

    private static String m20694a(InputStream inputStream, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return m20697a(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    private static String m20698a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return m20697a(instance.digest());
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    private static String m20696a(String str, String str2) {
        return m20698a(str.getBytes(), str2);
    }

    public static String m20699a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : arrayList) {
            stringBuilder.append(append);
        }
        String append2 = stringBuilder.toString();
        return append2.length() > 0 ? m20695a(append2) : null;
    }

    public static long m20709b(Context context) {
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long m20710b(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (((long) statFs.getAvailableBlocks()) * blockSize);
    }

    public static Float m20713c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    public static boolean m20717d(Context context) {
        if (m20719f(context)) {
            return false;
        }
        return ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null;
    }

    public static void m20701a(Context context, String str) {
        if (m20718e(context)) {
            C3969c.m20576h().mo2849a("Fabric", str);
        }
    }

    public static void m20702a(Context context, String str, Throwable th) {
        if (m20718e(context)) {
            C3969c.m20576h().mo2856e("Fabric", str);
        }
    }

    public static void m20700a(Context context, int i, String str, String str2) {
        if (m20718e(context)) {
            C3969c.m20576h().mo2848a(i, "Fabric", str2);
        }
    }

    public static boolean m20718e(Context context) {
        if (f14120b == null) {
            f14120b = Boolean.valueOf(m20707a(context, "com.crashlytics.Trace", false));
        }
        return f14120b.booleanValue();
    }

    public static boolean m20707a(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return z;
        }
        int a = m20686a(context, str, "bool");
        if (a > 0) {
            return resources.getBoolean(a);
        }
        int a2 = m20686a(context, str, "string");
        if (a2 > 0) {
            return Boolean.parseBoolean(context.getString(a2));
        }
        return z;
    }

    public static int m20686a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m20723j(context));
    }

    public static boolean m20719f(Context context) {
        return ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    public static boolean m20720g(Context context) {
        boolean f = m20719f(context);
        String str = Build.TAGS;
        if ((!f && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (f || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean m20714c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    public static int m20721h(Context context) {
        int i = 0;
        if (m20719f(context)) {
            i = 1;
        }
        if (m20720g(context)) {
            i |= 2;
        }
        if (m20714c()) {
            return i | 4;
        }
        return i;
    }

    public static int m20687a(Context context, boolean z) {
        Float c = m20713c(context);
        if (!z || c == null) {
            return 1;
        }
        if (((double) c.floatValue()) >= 99.0d) {
            return 3;
        }
        if (((double) c.floatValue()) < 99.0d) {
            return 2;
        }
        return 0;
    }

    public static String m20697a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f14121c[i2 >>> 4];
            cArr[(i * 2) + 1] = f14121c[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean m20722i(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static String m20711b(Context context, String str) {
        int a = m20686a(context, str, "string");
        if (a > 0) {
            return context.getString(a);
        }
        return "";
    }

    public static void m20704a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Fabric", str, e);
            }
        }
    }

    public static void m20705a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("Fabric", str, e);
            }
        }
    }

    public static boolean m20716c(String str) {
        return str == null || str.length() == 0;
    }

    public static String m20723j(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    public static void m20706a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String m20691a(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    public static String m20724k(Context context) {
        Closeable openRawResource;
        Throwable e;
        Throwable th;
        String str = null;
        try {
            openRawResource = context.getResources().openRawResource(m20725l(context));
            try {
                String b = m20712b((InputStream) openRawResource);
                if (!m20716c(b)) {
                    str = b;
                }
                m20704a(openRawResource, "Failed to close icon input stream.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("Fabric", "Could not calculate hash for app icon.", e);
                    m20704a(openRawResource, "Failed to close icon input stream.");
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    m20704a(openRawResource, "Failed to close icon input stream.");
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            openRawResource = null;
            C3969c.m20576h().mo2857e("Fabric", "Could not calculate hash for app icon.", e);
            m20704a(openRawResource, "Failed to close icon input stream.");
            return str;
        } catch (Throwable e4) {
            openRawResource = null;
            th = e4;
            m20704a(openRawResource, "Failed to close icon input stream.");
            throw th;
        }
        return str;
    }

    public static int m20725l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m20726m(Context context) {
        int a = m20686a(context, "io.fabric.android.build_id", "string");
        if (a == 0) {
            a = m20686a(context, "com.crashlytics.android.build_id", "string");
        }
        if (a == 0) {
            return null;
        }
        String string = context.getResources().getString(a);
        C3969c.m20576h().mo2849a("Fabric", "Build ID is: " + string);
        return string;
    }

    public static void m20703a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean m20715c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean m20727n(Context context) {
        if (!m20715c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
