package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class C0183e {
    public static void m798a(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void m797a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }

    public static void m796a(Activity activity) {
        activity.finishAffinity();
    }
}
