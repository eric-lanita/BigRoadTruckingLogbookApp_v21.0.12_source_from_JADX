package com.bigroad.ttb.android.widget;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;

public class ProminentDisclosureCheckboxPreference extends CheckBoxPreference {
    public ProminentDisclosureCheckboxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnPreferenceChangeListener(null);
        setOnPreferenceClickListener(null);
    }

    protected void onClick() {
        final C2474y g = OurApplication.m6285g();
        new Builder(getContext()).setIcon(R.drawable.ic_dialog_info_light).setTitle(R.string.prominentDisclosureDialog_title).setMessage(R.string.prominentDisclosureDialog_body).setPositiveButton(R.string.prominentDisclosureDialog_accept, new OnClickListener(this) {
            final /* synthetic */ ProminentDisclosureCheckboxPreference f8596b;

            public void onClick(DialogInterface dialogInterface, int i) {
                g.m12208e(true);
                this.f8596b.setChecked(true);
            }
        }).setNegativeButton(R.string.prominentDisclosureDialog_reject, new OnClickListener(this) {
            final /* synthetic */ ProminentDisclosureCheckboxPreference f8594b;

            public void onClick(DialogInterface dialogInterface, int i) {
                g.m12208e(false);
                this.f8594b.setChecked(false);
            }
        }).setCancelable(true).create().show();
    }
}
