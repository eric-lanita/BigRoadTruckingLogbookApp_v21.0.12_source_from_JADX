package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class IdManager {
    private static final Pattern f14136d = Pattern.compile("[^\\p{Alnum}]");
    private static final String f14137e = Pattern.quote("/");
    C3994c f14138a;
    C3992b f14139b;
    boolean f14140c;
    private final ReentrantLock f14141f = new ReentrantLock();
    private final C4010m f14142g;
    private final boolean f14143h;
    private final boolean f14144i;
    private final Context f14145j;
    private final String f14146k;
    private final String f14147l;
    private final Collection<C2822h> f14148m;

    public enum DeviceIdentifierType {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        public final int protobufIndex;

        private DeviceIdentifierType(int i) {
            this.protobufIndex = i;
        }
    }

    public IdManager(Context context, String str, String str2, Collection<C2822h> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        } else {
            this.f14145j = context;
            this.f14146k = str;
            this.f14147l = str2;
            this.f14148m = collection;
            this.f14142g = new C4010m();
            this.f14138a = new C3994c(context);
            this.f14143h = CommonUtils.m20707a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (!this.f14143h) {
                C3969c.m20576h().mo2849a("Fabric", "Device ID collection disabled for " + context.getPackageName());
            }
            this.f14144i = CommonUtils.m20707a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (!this.f14144i) {
                C3969c.m20576h().mo2849a("Fabric", "User information collection disabled for " + context.getPackageName());
            }
        }
    }

    public boolean m20734a() {
        return this.f14144i;
    }

    private String m20731a(String str) {
        return str == null ? null : f14136d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    public String m20735b() {
        String str = this.f14147l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = CommonUtils.m20690a(this.f14145j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m20730a(a);
        }
        return str;
    }

    public String m20736c() {
        return this.f14146k;
    }

    public String m20737d() {
        return m20738e() + "/" + m20739f();
    }

    public String m20738e() {
        return m20733b(VERSION.RELEASE);
    }

    public String m20739f() {
        return m20733b(VERSION.INCREMENTAL);
    }

    public String m20740g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m20733b(Build.MANUFACTURER), m20733b(Build.MODEL)});
    }

    private String m20733b(String str) {
        return str.replaceAll(f14137e, "");
    }

    public String m20741h() {
        String str = "";
        if (!this.f14143h) {
            return str;
        }
        str = m20747n();
        if (str != null) {
            return str;
        }
        SharedPreferences a = CommonUtils.m20690a(this.f14145j);
        str = a.getString("crashlytics.installation.id", null);
        if (str == null) {
            return m20730a(a);
        }
        return str;
    }

    private String m20730a(SharedPreferences sharedPreferences) {
        this.f14141f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m20731a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f14141f.unlock();
            return string;
        } catch (Throwable th) {
            this.f14141f.unlock();
        }
    }

    public Map<DeviceIdentifierType, String> m20742i() {
        Map hashMap = new HashMap();
        for (C2822h c2822h : this.f14148m) {
            if (c2822h instanceof C2823k) {
                for (Entry entry : ((C2823k) c2822h).mo1428e().entrySet()) {
                    m20732a(hashMap, (DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m20732a(hashMap, DeviceIdentifierType.ANDROID_ID, m20747n());
        m20732a(hashMap, DeviceIdentifierType.ANDROID_ADVERTISING_ID, m20746m());
        return Collections.unmodifiableMap(hashMap);
    }

    public String m20743j() {
        return this.f14142g.m20786a(this.f14145j);
    }

    synchronized C3992b m20744k() {
        if (!this.f14140c) {
            this.f14139b = this.f14138a.m20755a();
            this.f14140c = true;
        }
        return this.f14139b;
    }

    public Boolean m20745l() {
        if (!this.f14143h) {
            return null;
        }
        C3992b k = m20744k();
        if (k != null) {
            return Boolean.valueOf(k.f14150b);
        }
        return null;
    }

    public String m20746m() {
        if (!this.f14143h) {
            return null;
        }
        C3992b k = m20744k();
        if (k != null) {
            return k.f14149a;
        }
        return null;
    }

    private void m20732a(Map<DeviceIdentifierType, String> map, DeviceIdentifierType deviceIdentifierType, String str) {
        if (str != null) {
            map.put(deviceIdentifierType, str);
        }
    }

    public String m20747n() {
        if (!this.f14143h) {
            return null;
        }
        String string = Secure.getString(this.f14145j.getContentResolver(), "android_id");
        if ("9774d56d682e549c".equals(string)) {
            return null;
        }
        return m20731a(string);
    }
}
