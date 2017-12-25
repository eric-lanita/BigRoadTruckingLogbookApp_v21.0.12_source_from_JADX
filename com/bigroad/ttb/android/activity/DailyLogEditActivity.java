package com.bigroad.ttb.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0195t;
import android.support.v4.app.FragmentActivity;
import com.bigroad.shared.C0906x;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.fragment.DailyLogEditor;
import com.bigroad.ttb.android.fragment.DailyLogFragment.C1294a;
import com.bigroad.ttb.android.fragment.DailyLogFragment.C1295b;
import com.bigroad.ttb.android.fragment.DailyLogNavigator;
import com.bigroad.ttb.android.fragment.DailyLogNavigator.C1296b;
import com.bigroad.ttb.android.fragment.DailyLogNavigator.C1359a;
import com.bigroad.ttb.android.fragment.ViewMoreLogs;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import java.util.EnumSet;

public class DailyLogEditActivity extends LogDownloadTaskActivity implements C0906x, C1294a, C1295b, C1359a, C1296b {
    private DailyLogNavigator f4622a;
    private DailyLogEditor f4623b;
    private ViewMoreLogs f4624c;
    private final Runnable f4625d = new C13581(this);

    class C13581 implements Runnable {
        final /* synthetic */ DailyLogEditActivity f4621a;

        C13581(DailyLogEditActivity dailyLogEditActivity) {
            this.f4621a = dailyLogEditActivity;
        }

        public void run() {
            if (this.f4621a.f4623b.isResumed()) {
                this.f4621a.f4623b.mo1207s();
            }
            if (this.f4621a.f4622a.isResumed()) {
                this.f4621a.f4622a.m10352f();
            }
        }
    }

    public int a_() {
        return this.f4622a.m10348b();
    }

    public DailyLogEditActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.ALLOW_TRIAL_USER_CONVERSION));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_details);
        this.f4624c = ViewMoreLogs.m10426a(getSupportFragmentManager());
        this.f4623b = DailyLogEditor.m10278a((FragmentActivity) this);
        this.f4622a = DailyLogNavigator.m10335a(getSupportFragmentManager(), false, true, getIntent().getIntExtra("com.bigroad.ttb.logDay", -1));
        m6710a(60000, this.f4625d);
    }

    public void mo945a(Runnable runnable) {
        m6701T().post(runnable);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f4623b.onActivityResult(i, i2, intent);
    }

    public void mo944a(DailyLog dailyLog, boolean z) {
        if (this.f4624c.isAdded() || !this.f4623b.isAdded()) {
            C0195t a = getSupportFragmentManager().mo150a();
            if (this.f4624c.isAdded()) {
                a.mo144b(R.id.dailyLogDetails_fragmentContainer, this.f4623b, DailyLogEditor.f7109a);
            } else {
                a.mo140a(R.id.dailyLogDetails_fragmentContainer, this.f4623b, DailyLogEditor.f7109a);
            }
            a.mo138a();
            this.f4623b.mo1193a(dailyLog, z);
            return;
        }
        this.f4623b.mo1193a(dailyLog, z);
    }

    public void mo974h() {
        if (!this.f4624c.isAdded() || this.f4623b.isAdded()) {
            C0195t a = getSupportFragmentManager().mo150a();
            if (this.f4623b.isAdded()) {
                a.mo144b(R.id.dailyLogDetails_fragmentContainer, this.f4624c, ViewMoreLogs.f7269a);
            } else {
                a.mo140a(R.id.dailyLogDetails_fragmentContainer, this.f4624c, ViewMoreLogs.f7269a);
            }
            a.mo138a();
        }
    }

    public DailyLog mo930f() {
        return this.f4622a.m10347a();
    }

    public int mo946g() {
        throw new UnsupportedOperationException();
    }
}
