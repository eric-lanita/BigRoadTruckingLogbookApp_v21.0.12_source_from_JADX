package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class C3971e implements Callable<Map<String, C3976j>> {
    final String f14057a;

    public /* synthetic */ Object call() {
        return m20593a();
    }

    C3971e(String str) {
        this.f14057a = str;
    }

    public Map<String, C3976j> m20593a() {
        Map<String, C3976j> hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        hashMap.putAll(m20591c());
        hashMap.putAll(m20592d());
        C3969c.m20576h().mo2852b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return hashMap;
    }

    private Map<String, C3976j> m20591c() {
        Map<String, C3976j> hashMap = new HashMap();
        try {
            Class.forName("com.google.android.gms.ads.AdView");
            C3976j c3976j = new C3976j("com.google.firebase.firebase-ads", "0.0.0", "binary");
            hashMap.put(c3976j.m20629a(), c3976j);
            C3969c.m20576h().mo2852b("Fabric", "Found kit: com.google.firebase.firebase-ads");
        } catch (Exception e) {
        }
        return hashMap;
    }

    private Map<String, C3976j> m20592d() {
        Map<String, C3976j> hashMap = new HashMap();
        ZipFile b = m20594b();
        Enumeration entries = b.entries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > "fabric/".length()) {
                C3976j a = m20590a(zipEntry, b);
                if (a != null) {
                    hashMap.put(a.m20629a(), a);
                    C3969c.m20576h().mo2852b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.m20629a(), a.m20630b()}));
                }
            }
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException e) {
            }
        }
        return hashMap;
    }

    private C3976j m20590a(ZipEntry zipEntry, ZipFile zipFile) {
        Closeable inputStream;
        Throwable e;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                C3976j c3976j = new C3976j(property, property2, property3);
                CommonUtils.m20703a(inputStream);
                return c3976j;
            } catch (IOException e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    CommonUtils.m20703a(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m20703a(inputStream);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            C3969c.m20576h().mo2857e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            CommonUtils.m20703a(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            inputStream = null;
            CommonUtils.m20703a(inputStream);
            throw e;
        }
    }

    protected ZipFile m20594b() {
        return new ZipFile(this.f14057a);
    }
}
