package com.urbanairship.preference;

import android.os.Handler;
import android.preference.CheckBoxPreference;
import android.view.View;
import android.view.ViewGroup;
import com.urbanairship.C3731i;

public abstract class UACheckBoxPreference extends CheckBoxPreference {
    protected boolean f13727a;
    private C3731i f13728b;
    private Runnable f13729c;
    private Handler f13730d;

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        onCreateView.setContentDescription(getClass().getSimpleName());
        return onCreateView;
    }

    protected boolean shouldPersist() {
        return false;
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        this.f13727a = z;
        if (this.f13728b != null) {
            this.f13728b.m19431a();
        }
        this.f13730d.removeCallbacks(this.f13729c);
        this.f13730d.postDelayed(this.f13729c, 1000);
    }
}
