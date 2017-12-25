package com.urbanairship.preference;

import android.os.Build.VERSION;
import android.support.v4.content.C0126a;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.actions.C3681c;
import com.urbanairship.actions.C3690a;
import com.urbanairship.actions.C3694b;
import com.urbanairship.actions.C3701e;
import com.urbanairship.actions.C3704f;

public class LocationUpdatesEnabledPreference extends UACheckBoxPreference {

    class C38631 implements C3681c {
        final /* synthetic */ LocationUpdatesEnabledPreference f13735a;

        C38631(LocationUpdatesEnabledPreference locationUpdatesEnabledPreference) {
            this.f13735a = locationUpdatesEnabledPreference;
        }

        public void mo2766a(C3694b c3694b, C3701e c3701e) {
            if (c3701e.m19376b().m19317b(false)) {
                this.f13735a.setChecked(true);
            }
        }
    }

    class C38642 extends C3690a {
        final /* synthetic */ LocationUpdatesEnabledPreference f13736a;

        C38642(LocationUpdatesEnabledPreference locationUpdatesEnabledPreference) {
            this.f13736a = locationUpdatesEnabledPreference;
        }

        public C3701e mo2770d(C3694b c3694b) {
            int[] a = m19348a("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
            for (int i : a) {
                if (i == 0) {
                    return C3701e.m19374a(ActionValue.m19313a(true));
                }
            }
            return C3701e.m19374a(ActionValue.m19313a(false));
        }
    }

    public void setChecked(boolean z) {
        if (this.a != z && z && m20027a()) {
            C3704f.m19381a(new C38642(this)).m19389a(new C38631(this));
        } else {
            super.setChecked(z);
        }
    }

    private boolean m20027a() {
        if (VERSION.SDK_INT >= 23 && C0126a.m581a(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == -1 && C0126a.m581a(getContext(), "android.permission.ACCESS_FINE_LOCATION") == -1) {
            return true;
        }
        return false;
    }
}
