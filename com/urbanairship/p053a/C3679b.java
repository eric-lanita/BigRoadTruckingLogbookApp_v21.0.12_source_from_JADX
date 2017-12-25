package com.urbanairship.p053a;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.amazon.device.messaging.development.ADMManifest;
import com.urbanairship.C3783j;
import com.urbanairship.C3929q;

class C3679b {
    public static void m19295a() {
        try {
            ADMManifest.checkManifestAuthoredProperly(C3929q.m20382h());
        } catch (Throwable e) {
            C3783j.m19726c("AndroidManifest invalid ADM setup.", e);
        }
    }

    public static boolean m19298b() {
        try {
            return new ADM(C3929q.m20382h()).isSupported();
        } catch (RuntimeException e) {
            C3783j.m19728e("Failed to call ADM. Make sure ADM jar is not bundled with the APK.");
            return false;
        }
    }

    public static void m19296a(Context context) {
        new ADM(context).startRegister();
    }

    public static String m19297b(Context context) {
        return new ADM(context).getRegistrationId();
    }
}
