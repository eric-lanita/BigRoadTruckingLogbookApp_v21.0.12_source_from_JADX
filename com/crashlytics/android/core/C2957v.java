package com.crashlytics.android.core;

import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

class C2957v {
    private static final Charset f10105a = Charset.forName("UTF-8");
    private final File f10106b;

    public C2957v(File file) {
        this.f10106b = file;
    }

    public void m16466a(String str, ak akVar) {
        Closeable bufferedWriter;
        Throwable e;
        File c = m16461c(str);
        Closeable closeable = null;
        try {
            String a = C2957v.m16459a(akVar);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c), f10105a));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                CommonUtils.m20704a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("CrashlyticsCore", "Error serializing user metadata.", e);
                    CommonUtils.m20704a(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    CommonUtils.m20704a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Error serializing user metadata.", e);
            CommonUtils.m20704a(bufferedWriter, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.m20704a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    public ak m16465a(String str) {
        Throwable e;
        File c = m16461c(str);
        if (!c.exists()) {
            return ak.f9963a;
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(c);
            try {
                ak e2 = C2957v.m16463e(CommonUtils.m20693a((InputStream) fileInputStream));
                CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
                return e2;
            } catch (Exception e3) {
                e = e3;
                try {
                    C3969c.m20576h().mo2857e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
                    return ak.f9963a;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Error deserializing user metadata.", e);
            CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
            return ak.f9963a;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    public Map<String, String> m16467b(String str) {
        Closeable fileInputStream;
        Throwable e;
        File d = m16462d(str);
        if (!d.exists()) {
            return Collections.emptyMap();
        }
        try {
            fileInputStream = new FileInputStream(d);
            try {
                Map<String, String> f = C2957v.m16464f(CommonUtils.m20693a((InputStream) fileInputStream));
                CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
                return f;
            } catch (Exception e2) {
                e = e2;
                try {
                    C3969c.m20576h().mo2857e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Error deserializing user metadata.", e);
            CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            CommonUtils.m20704a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    private File m16461c(String str) {
        return new File(this.f10106b, str + "user" + ".meta");
    }

    private File m16462d(String str) {
        return new File(this.f10106b, str + "keys" + ".meta");
    }

    private static ak m16463e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return new ak(C2957v.m16460a(jSONObject, "userId"), C2957v.m16460a(jSONObject, "userName"), C2957v.m16460a(jSONObject, "userEmail"));
    }

    private static String m16459a(final ak akVar) {
        return new JSONObject() {
        }.toString();
    }

    private static Map<String, String> m16464f(String str) {
        JSONObject jSONObject = new JSONObject(str);
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, C2957v.m16460a(jSONObject, str2));
        }
        return hashMap;
    }

    private static String m16460a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
