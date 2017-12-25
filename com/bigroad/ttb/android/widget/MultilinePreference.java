package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class MultilinePreference extends Preference {
    public MultilinePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MultilinePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MultilinePreference(Context context) {
        super(context);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setSingleLine(false);
        }
    }
}
