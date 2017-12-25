package com.crashlytics.android.core;

import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.common.C4014n;
import io.fabric.sdk.android.services.common.C4014n.C2881c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;

class ab implements C2883r {
    private final File f9939a;
    private final int f9940b;
    private C4014n f9941c;

    public ab(File file, int i) {
        this.f9939a = file;
        this.f9940b = i;
    }

    public void mo1456a(long j, String str) {
        m16181d();
        m16180b(j, str);
    }

    public C2891b mo1455a() {
        if (!this.f9939a.exists()) {
            return null;
        }
        m16181d();
        if (this.f9941c == null) {
            return null;
        }
        final int[] iArr = new int[]{0};
        final byte[] bArr = new byte[this.f9941c.m20807a()];
        try {
            this.f9941c.m20808a(new C2881c(this) {
                final /* synthetic */ ab f9938c;

                public void mo1454a(InputStream inputStream, int i) {
                    try {
                        inputStream.read(bArr, iArr[0], i);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return C2891b.m16253a(bArr, 0, iArr[0]);
    }

    public void mo1457b() {
        CommonUtils.m20704a(this.f9941c, "There was a problem closing the Crashlytics log file.");
        this.f9941c = null;
    }

    public void mo1458c() {
        mo1457b();
        this.f9939a.delete();
    }

    private void m16181d() {
        if (this.f9941c == null) {
            try {
                this.f9941c = new C4014n(this.f9939a);
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "Could not open log file: " + this.f9939a, e);
            }
        }
    }

    private void m16180b(long j, String str) {
        if (this.f9941c != null) {
            String str2;
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            try {
                int i = this.f9940b / 4;
                if (str2.length() > i) {
                    str2 = "..." + str2.substring(str2.length() - i);
                }
                str2 = str2.replaceAll("\r", " ").replaceAll("\n", " ");
                this.f9941c.m20809a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str2}).getBytes("UTF-8"));
                while (!this.f9941c.m20812b() && this.f9941c.m20807a() > this.f9940b) {
                    this.f9941c.m20813c();
                }
            } catch (Throwable e) {
                C3969c.m20576h().mo2857e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
