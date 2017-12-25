package android.support.customtabs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.C0127a;
import android.support.v4.app.C0197l;
import java.util.ArrayList;

public final class C0062b {
    public final Intent f393a;
    public final Bundle f394b;

    public static final class C0061a {
        private final Intent f389a;
        private ArrayList<Bundle> f390b;
        private Bundle f391c;
        private ArrayList<Bundle> f392d;

        public C0061a() {
            this(null);
        }

        public C0061a(C0063c c0063c) {
            IBinder iBinder = null;
            this.f389a = new Intent("android.intent.action.VIEW");
            this.f390b = null;
            this.f391c = null;
            this.f392d = null;
            if (c0063c != null) {
                this.f389a.setPackage(c0063c.m356b().getPackageName());
            }
            Bundle bundle = new Bundle();
            String str = "android.support.customtabs.extra.SESSION";
            if (c0063c != null) {
                iBinder = c0063c.m355a();
            }
            C0197l.m862a(bundle, str, iBinder);
            this.f389a.putExtras(bundle);
        }

        public C0062b m353a() {
            if (this.f390b != null) {
                this.f389a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.f390b);
            }
            if (this.f392d != null) {
                this.f389a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.f392d);
            }
            return new C0062b(this.f389a, this.f391c);
        }
    }

    public void m354a(Activity activity, Uri uri) {
        this.f393a.setData(uri);
        C0127a.m588a(activity, this.f393a, this.f394b);
    }

    private C0062b(Intent intent, Bundle bundle) {
        this.f393a = intent;
        this.f394b = bundle;
    }
}
