package com.urbanairship.preference;

import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import com.urbanairship.C3929q;

public class UserIdPreference extends Preference {
    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.setContentDescription("USER_ID");
        setSummary(C3929q.m20372a().m20391o().m20439b().m20478b());
        return onCreateView;
    }
}
