package com.urbanairship.richpush;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.urbanairship.C3783j;
import com.urbanairship.C3796l;
import com.urbanairship.C3929q;
import com.urbanairship.util.C3954i;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class C3944e {
    private final List<C3932a> f13999a = new ArrayList();
    private final C3796l f14000b;

    public interface C3932a {
        void mo2846a(boolean z);
    }

    C3944e(C3796l c3796l) {
        this.f14000b = c3796l;
        String a = this.f14000b.m19810a("com.urbanairship.user.PASSWORD", null);
        if (!C3954i.m20512a(a)) {
            if (this.f14000b.m19821c("com.urbanairship.user.USER_TOKEN", C3944e.m20473b(a, this.f14000b.m19810a("com.urbanairship.user.ID", null)))) {
                this.f14000b.m19816b("com.urbanairship.user.PASSWORD");
            }
        }
    }

    public void m20475a(C3932a c3932a) {
        synchronized (this.f13999a) {
            this.f13999a.add(c3932a);
        }
    }

    public void m20479b(C3932a c3932a) {
        synchronized (this.f13999a) {
            this.f13999a.remove(c3932a);
        }
    }

    public void m20477a(boolean z) {
        Parcelable richPushUser$1 = new RichPushUser$1(this, new Handler(Looper.getMainLooper()));
        C3783j.m19725c("RichPushUser - Starting update service.");
        Context h = C3929q.m20382h();
        h.startService(new Intent(h, RichPushUpdateService.class).setAction("com.urbanairship.richpush.USER_UPDATE").putExtra("com.urbanairship.richpush.RESULT_RECEIVER", richPushUser$1).putExtra("com.urbanairship.richpush.EXTRA_FORCEFULLY", z));
    }

    public static boolean m20471a() {
        C3929q a = C3929q.m20372a();
        return (C3954i.m20512a(a.m20391o().m20439b().m20478b()) || C3954i.m20512a(a.m20391o().m20439b().m20480c())) ? false : true;
    }

    void m20476a(String str, String str2) {
        C3783j.m19725c("RichPushUser - Setting Rich Push user: " + str);
        this.f14000b.m19819b("com.urbanairship.user.ID", str);
        this.f14000b.m19819b("com.urbanairship.user.USER_TOKEN", C3944e.m20473b(str2, str));
    }

    public String m20478b() {
        if (this.f14000b.m19810a("com.urbanairship.user.USER_TOKEN", null) != null) {
            return this.f14000b.m19810a("com.urbanairship.user.ID", null);
        }
        return null;
    }

    public String m20480c() {
        if (this.f14000b.m19810a("com.urbanairship.user.ID", null) != null) {
            return C3944e.m20474c(this.f14000b.m19810a("com.urbanairship.user.USER_TOKEN", null), m20478b());
        }
        return null;
    }

    private static String m20473b(String str, String str2) {
        if (C3954i.m20512a(str) || C3954i.m20512a(str2)) {
            return null;
        }
        byte[] a = C3944e.m20472a(str.getBytes(), str2.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        int length = a.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02x", new Object[]{Byte.valueOf(a[i])}));
        }
        return stringBuilder.toString();
    }

    private static String m20474c(String str, String str2) {
        if (C3954i.m20512a(str) || C3954i.m20512a(str2)) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[(length / 2)];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = Byte.parseByte(str.substring(i, i + 2), 16);
            }
            return new String(C3944e.m20472a(bArr, str2.getBytes()), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C3783j.m19728e("RichPushUser - Unable to decode string. " + e.getMessage());
            return null;
        } catch (NumberFormatException e2) {
            C3783j.m19728e("RichPushUser - String contains invalid hex numbers. " + e2.getMessage());
            return null;
        }
    }

    private static byte[] m20472a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i % bArr2.length]);
        }
        return bArr3;
    }
}
