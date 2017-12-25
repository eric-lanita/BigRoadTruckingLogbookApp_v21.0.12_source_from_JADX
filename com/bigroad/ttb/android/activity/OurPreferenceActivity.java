package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.widget.TextView;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2272u;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.ag;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p030a.C1257b;
import java.util.Locale;

public abstract class OurPreferenceActivity extends AppCompatPreferenceActivity {
    private final ag f5400a = OurApplication.m6282d();
    private final AuthMonitor f5401b = OurApplication.m6249F();
    private C2272u f5402c;
    private TextView f5403d;
    private final C1185a f5404e = new C15521(this);

    class C15521 implements C1185a {
        final /* synthetic */ OurPreferenceActivity f5399a;

        C15521(OurPreferenceActivity ourPreferenceActivity) {
            this.f5399a = ourPreferenceActivity;
        }

        public void mo912a(AuthStatus authStatus) {
            this.f5399a.m7746c();
        }
    }

    protected abstract boolean isValidFragment(String str);

    protected void m7748a(Preference preference) {
        if (preference != null) {
            PreferenceScreen preferenceScreen = getPreferenceScreen();
            if (!preferenceScreen.removePreference(preference)) {
                int i = 0;
                while (i < preferenceScreen.getPreferenceCount()) {
                    Preference preference2 = preferenceScreen.getPreference(i);
                    if (!(preference2 instanceof PreferenceCategory) || !((PreferenceCategory) preference2).removePreference(preference)) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    protected ag mo1017a() {
        return this.f5400a;
    }

    protected Locale m7749b() {
        return null;
    }

    protected void attachBaseContext(Context context) {
        Locale b = m7749b();
        if (b == null) {
            b = OurApplication.aj();
        }
        super.attachBaseContext(C1257b.m6608a(context, b));
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(7);
        super.onCreate(bundle);
        getPreferenceManager().setSharedPreferencesName("globalPreferences");
        this.f5402c = new C2272u(this);
        this.f5402c.m11136a();
        this.f5401b.m6027a(this.f5404e);
        m7746c();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getWindow().setFeatureInt(7, R.layout.custom_title_bar_header);
        this.f5403d = (TextView) findViewById(R.id.customTitle_title);
        this.f5403d.setText(getTitle());
    }

    protected void onStart() {
        super.onStart();
        this.f5400a.m8292a((Activity) this);
        this.f5402c.m11138c();
    }

    protected void onResume() {
        super.onResume();
        OurApplication.m6284f().m10448b((Activity) this);
    }

    protected void onPause() {
        OurApplication.m6284f().m10445a((Activity) this);
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        this.f5400a.m8298b((Activity) this);
    }

    protected void onDestroy() {
        this.f5401b.m6029b(this.f5404e);
        this.f5402c.m11137b();
        super.onDestroy();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        if (this.f5403d != null) {
            this.f5403d.setText(charSequence);
        }
    }

    private void m7746c() {
        if (this.f5401b.m6030c()) {
            C2134e.m10678c("TT-OurPrefAct", "Signed out; finishing " + getClass().getSimpleName());
            setResult(2);
            finish();
        }
    }
}
