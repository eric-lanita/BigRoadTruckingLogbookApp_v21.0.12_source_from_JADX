package com.crashlytics.android.p044a;

import android.content.Context;
import io.fabric.sdk.android.services.p045a.C2830d;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class C2831h implements C2830d<String> {
    public /* synthetic */ Object mo1431b(Context context) {
        return m15999a(context);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m15999a(android.content.Context r10) {
        /*
        r9 = this;
        r4 = java.lang.System.nanoTime();
        r0 = "";
        r1 = 0;
        r2 = "io.crash.air";
        r1 = r9.m16001a(r10, r2);	 Catch:{ NameNotFoundException -> 0x0052, FileNotFoundException -> 0x0071, IOException -> 0x0093, all -> 0x00b7 }
        r0 = r9.m16000a(r1);	 Catch:{ NameNotFoundException -> 0x0052, FileNotFoundException -> 0x00d6, IOException -> 0x00d1 }
        if (r1 == 0) goto L_0x0016;
    L_0x0013:
        r1.close();	 Catch:{ IOException -> 0x0045 }
    L_0x0016:
        r2 = java.lang.System.nanoTime();
        r2 = r2 - r4;
        r2 = (double) r2;
        r4 = 4696837146684686336; // 0x412e848000000000 float:0.0 double:1000000.0;
        r2 = r2 / r4;
        r1 = io.fabric.sdk.android.C3969c.m20576h();
        r4 = "Beta";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Beta device token load took ";
        r5 = r5.append(r6);
        r2 = r5.append(r2);
        r3 = "ms";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.mo2849a(r4, r2);
        return r0;
    L_0x0045:
        r1 = move-exception;
        r2 = io.fabric.sdk.android.C3969c.m20576h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2857e(r3, r6, r1);
        goto L_0x0016;
    L_0x0052:
        r2 = move-exception;
        r2 = io.fabric.sdk.android.C3969c.m20576h();	 Catch:{ all -> 0x00cc }
        r3 = "Beta";
        r6 = "Beta by Crashlytics app is not installed";
        r2.mo2849a(r3, r6);	 Catch:{ all -> 0x00cc }
        if (r1 == 0) goto L_0x0016;
    L_0x0060:
        r1.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0016;
    L_0x0064:
        r1 = move-exception;
        r2 = io.fabric.sdk.android.C3969c.m20576h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2857e(r3, r6, r1);
        goto L_0x0016;
    L_0x0071:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0075:
        r3 = io.fabric.sdk.android.C3969c.m20576h();	 Catch:{ all -> 0x00cf }
        r6 = "Beta";
        r7 = "Failed to find the APK file";
        r3.mo2857e(r6, r7, r1);	 Catch:{ all -> 0x00cf }
        if (r2 == 0) goto L_0x0016;
    L_0x0082:
        r2.close();	 Catch:{ IOException -> 0x0086 }
        goto L_0x0016;
    L_0x0086:
        r1 = move-exception;
        r2 = io.fabric.sdk.android.C3969c.m20576h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2857e(r3, r6, r1);
        goto L_0x0016;
    L_0x0093:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0097:
        r3 = io.fabric.sdk.android.C3969c.m20576h();	 Catch:{ all -> 0x00cf }
        r6 = "Beta";
        r7 = "Failed to read the APK file";
        r3.mo2857e(r6, r7, r1);	 Catch:{ all -> 0x00cf }
        if (r2 == 0) goto L_0x0016;
    L_0x00a4:
        r2.close();	 Catch:{ IOException -> 0x00a9 }
        goto L_0x0016;
    L_0x00a9:
        r1 = move-exception;
        r2 = io.fabric.sdk.android.C3969c.m20576h();
        r3 = "Beta";
        r6 = "Failed to close the APK file";
        r2.mo2857e(r3, r6, r1);
        goto L_0x0016;
    L_0x00b7:
        r0 = move-exception;
        r2 = r1;
    L_0x00b9:
        if (r2 == 0) goto L_0x00be;
    L_0x00bb:
        r2.close();	 Catch:{ IOException -> 0x00bf }
    L_0x00be:
        throw r0;
    L_0x00bf:
        r1 = move-exception;
        r2 = io.fabric.sdk.android.C3969c.m20576h();
        r3 = "Beta";
        r4 = "Failed to close the APK file";
        r2.mo2857e(r3, r4, r1);
        goto L_0x00be;
    L_0x00cc:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00b9;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x00b9;
    L_0x00d1:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0097;
    L_0x00d6:
        r2 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0075;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.a.h.a(android.content.Context):java.lang.String");
    }

    ZipInputStream m16001a(Context context, String str) {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(str, 0).sourceDir));
    }

    String m16000a(ZipInputStream zipInputStream) {
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        if (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token=")) {
                return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
            }
        }
        return "";
    }
}
