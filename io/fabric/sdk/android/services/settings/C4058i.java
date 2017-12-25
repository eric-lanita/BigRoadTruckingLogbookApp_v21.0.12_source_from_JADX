package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.C2822h;
import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.p057c.C3988b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

class C4058i implements C4056g {
    private final C2822h f14300a;

    public C4058i(C2822h c2822h) {
        this.f14300a = c2822h;
    }

    public JSONObject mo2891a() {
        Closeable fileInputStream;
        Throwable e;
        Closeable closeable = null;
        C3969c.m20576h().mo2849a("Fabric", "Reading cached settings...");
        try {
            JSONObject jSONObject;
            File file = new File(new C3988b(this.f14300a).mo2877a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(CommonUtils.m20693a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C3969c.m20576h().mo2857e("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.m20704a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        CommonUtils.m20704a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            C3969c.m20576h().mo2849a("Fabric", "No cached settings found.");
            jSONObject = null;
            CommonUtils.m20704a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C3969c.m20576h().mo2857e("Fabric", "Failed to fetch cached settings", e);
            CommonUtils.m20704a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.m20704a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void mo2892a(long j, JSONObject jSONObject) {
        Closeable fileWriter;
        Throwable e;
        C3969c.m20576h().mo2849a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new C3988b(this.f14300a).mo2877a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    CommonUtils.m20704a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C3969c.m20576h().mo2857e("Fabric", "Failed to cache settings", e);
                        CommonUtils.m20704a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileWriter;
                        CommonUtils.m20704a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                C3969c.m20576h().mo2857e("Fabric", "Failed to cache settings", e);
                CommonUtils.m20704a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.m20704a(closeable, "Failed to close settings writer.");
                throw e;
            }
        }
    }
}
