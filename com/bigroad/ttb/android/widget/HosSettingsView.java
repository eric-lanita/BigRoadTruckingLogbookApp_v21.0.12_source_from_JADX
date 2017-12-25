package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2303v;

public class HosSettingsView extends RelativeLayout {
    private int f8570a;
    private TextView f8571b;
    private Button f8572c;

    private void m11972a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hos_settings_view, this);
    }

    public HosSettingsView(Context context) {
        super(context);
        m11972a(context);
    }

    public HosSettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11972a(context);
    }

    public void setOnEditClickListener(OnClickListener onClickListener) {
        this.f8572c.setOnClickListener(onClickListener);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8570a = getResources().getDimensionPixelSize(R.dimen.text_wrap_indent);
        this.f8571b = (TextView) findViewById(R.id.hosSettings_rulesSummary);
        this.f8572c = (Button) findViewById(R.id.hosSettings_rulesButton);
    }

    public void setHosSettings(C0874m c0874m) {
        C2303v b = C2303v.m11257b(this.f8570a);
        b.m11262a(getResources().getString(R.string.hosSettings_cycleHeading)).m11260a(' ').m11268c(C1738c.m8505a(c0874m, getContext()));
        this.f8571b.setText(b.m11270e());
    }

    public void m11973a(boolean z) {
        this.f8571b.setEnabled(z);
        this.f8572c.setEnabled(z);
    }
}
