package com.bigroad.ttb.android.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.util.C2302u;
import java.util.EnumSet;

public abstract class OurKeyboardActivity extends OurActivity {
    private C2302u f4363a;

    protected abstract TextView mo930f();

    public OurKeyboardActivity(Feature feature) {
        super(feature);
    }

    public OurKeyboardActivity(EnumSet<Feature> enumSet) {
        super((EnumSet) enumSet);
    }

    public OurKeyboardActivity(TitleStyle titleStyle) {
        super(titleStyle);
    }

    public OurKeyboardActivity(Feature feature, TitleStyle titleStyle) {
        super(feature, titleStyle);
    }

    public OurKeyboardActivity(EnumSet<Feature> enumSet, TitleStyle titleStyle) {
        super((EnumSet) enumSet, titleStyle);
    }

    protected void mo931l() {
        m6719a(mo930f());
    }

    protected void m6719a(TextView textView) {
        if (textView != null) {
            this.f4363a.m11254a(textView);
        }
    }

    protected void mo932m() {
        this.f4363a.m11256b(mo930f());
    }

    protected C2302u mo933n() {
        return this.f4363a;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        this.f4363a = new C2302u(this);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (bundle == null) {
            mo931l();
        }
    }

    public void finish() {
        super.finish();
        TextView f = mo930f();
        if (f != null) {
            this.f4363a.m11256b(f);
        }
    }
}
