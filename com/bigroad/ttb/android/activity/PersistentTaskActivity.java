package com.bigroad.ttb.android.activity;

import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.dialog.AsyncTaskDialogFragment.C1292a;
import com.bigroad.ttb.android.dialog.C1830c;
import java.util.EnumSet;

public abstract class PersistentTaskActivity extends OurActivity implements C1292a {
    private boolean f4415a = false;
    private boolean f4416b = false;
    private C1830c f4417c;

    protected abstract void mo941a(C1830c c1830c);

    protected abstract void mo943b(C1830c c1830c);

    public PersistentTaskActivity(Feature feature) {
        super(feature);
    }

    public PersistentTaskActivity(EnumSet<Feature> enumSet) {
        super((EnumSet) enumSet);
    }

    public PersistentTaskActivity(EnumSet<Feature> enumSet, TitleStyle titleStyle) {
        super((EnumSet) enumSet, titleStyle);
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        this.f4416b = false;
        if (this.f4415a) {
            mo939c(this.f4417c);
        }
    }

    protected void onPause() {
        super.onPause();
        this.f4416b = true;
    }

    public void mo939c(C1830c c1830c) {
        if (this.f4416b) {
            this.f4415a = true;
            this.f4417c = c1830c;
            return;
        }
        this.f4415a = false;
        if (c1830c.m8889d() == -1) {
            mo941a(c1830c);
        } else if (c1830c.m8889d() == 0) {
            mo943b(c1830c);
        }
    }
}
