package bolts;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;

public final class C0791c {
    public static Bundle m3968a(Intent intent) {
        return intent.getBundleExtra("al_applink_data");
    }

    public static Bundle m3969b(Intent intent) {
        Bundle a = C0791c.m3968a(intent);
        if (a == null) {
            return null;
        }
        return a.getBundle(AppLinkData.ARGUMENTS_EXTRAS_KEY);
    }
}
