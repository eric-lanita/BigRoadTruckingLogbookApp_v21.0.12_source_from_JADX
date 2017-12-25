package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C2304w;

public class SettingsActivity extends OurPreferenceActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        findPreference(getString(R.string.support_key)).setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SettingsActivity f5479b;

            public boolean onPreferenceClick(Preference preference) {
                C2304w.m11272a(this, "TT-SettingsAct");
                return true;
            }
        });
        Preference findPreference = findPreference(getString(R.string.rate_key));
        if (C1632a.m8010o((Context) this)) {
            findPreference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
                final /* synthetic */ SettingsActivity f5481b;

                public boolean onPreferenceClick(Preference preference) {
                    C1632a.m8008n(this);
                    return true;
                }
            });
        } else {
            m7748a(findPreference);
        }
    }

    protected boolean isValidFragment(String str) {
        return false;
    }
}
