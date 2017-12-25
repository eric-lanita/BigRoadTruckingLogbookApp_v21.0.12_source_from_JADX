package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.C0587e;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class AppCompatPreferenceActivity extends PreferenceActivity {
    private C0587e f4356a;

    protected void onCreate(Bundle bundle) {
        mo1017a().mo460g();
        mo1017a().mo444a(bundle);
        super.onCreate(bundle);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        mo1017a().mo452b(bundle);
    }

    public MenuInflater getMenuInflater() {
        return mo1017a().mo436b();
    }

    public void setContentView(int i) {
        mo1017a().mo451b(i);
    }

    public void setContentView(View view) {
        mo1017a().mo446a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        mo1017a().mo447a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        mo1017a().mo453b(view, layoutParams);
    }

    protected void onPostResume() {
        super.onPostResume();
        mo1017a().mo458d();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        mo1017a().mo435a(charSequence);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mo1017a().mo443a(configuration);
    }

    protected void onStop() {
        super.onStop();
        mo1017a().mo456c();
    }

    protected void onDestroy() {
        super.onDestroy();
        mo1017a().mo438f();
    }

    public void invalidateOptionsMenu() {
        mo1017a().mo459e();
    }

    private C0587e mo1017a() {
        if (this.f4356a == null) {
            this.f4356a = C0587e.m2695a((Activity) this, null);
        }
        return this.f4356a;
    }
}
