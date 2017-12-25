package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C2303v;

public class TimeZoneSettingsView extends RelativeLayout {
    private Button f8666a;
    private TextView f8667b;

    public TimeZoneSettingsView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.timezone_settings_view, this);
    }

    public TimeZoneSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.timezone_settings_view, this);
    }

    public void setOnEditClickListener(OnClickListener onClickListener) {
        this.f8666a.setOnClickListener(onClickListener);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8666a = (Button) findViewById(R.id.timeZoneSettingsView_changeTimeZoneButton);
        this.f8667b = (TextView) findViewById(R.id.timeZoneSettingsView_label);
    }

    public void setTimeZoneText(String str) {
        C2303v c = C2303v.m11258c();
        c.m11262a(getResources().getString(R.string.timeZoneSettings_title)).m11260a(' ').m11268c(str);
        this.f8667b.setText(c.m11270e());
    }
}
