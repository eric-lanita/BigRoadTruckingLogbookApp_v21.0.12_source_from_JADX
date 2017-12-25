package com.bigroad.ttb.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0195t;
import android.support.v4.app.FragmentActivity;
import com.bigroad.shared.C0906x;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.fragment.DailyLogFragment.C1294a;
import com.bigroad.ttb.android.fragment.DailyLogFragment.C1295b;
import com.bigroad.ttb.android.fragment.DailyLogNavigator;
import com.bigroad.ttb.android.fragment.DailyLogNavigator.C1296b;
import com.bigroad.ttb.android.fragment.UnassignedDrivingClaimer;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import java.util.EnumSet;

public class ClaimUnassignedDrivingActivity extends LogDownloadTaskActivity implements C0906x, C1294a, C1295b, C1296b {
    private DailyLogNavigator f4421a;
    private UnassignedDrivingClaimer f4422b;
    private int[] f4423c;
    private final Runnable f4424d = new C12911(this);

    class C12911 implements Runnable {
        final /* synthetic */ ClaimUnassignedDrivingActivity f4414a;

        C12911(ClaimUnassignedDrivingActivity claimUnassignedDrivingActivity) {
            this.f4414a = claimUnassignedDrivingActivity;
        }

        public void run() {
            if (this.f4414a.f4422b.isResumed()) {
                this.f4414a.f4422b.mo1207s();
            }
            if (this.f4414a.f4421a.isResumed()) {
                this.f4414a.f4421a.m10352f();
            }
        }
    }

    public ClaimUnassignedDrivingActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.ALLOW_TRIAL_USER_CONVERSION));
    }

    public void mo945a(Runnable runnable) {
        m6701T().post(runnable);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.claim_unassigned_driving);
        this.f4423c = getIntent().getIntArrayExtra("com.bigroad.ttb.logDaysWithUnclaimedEvents");
        this.f4422b = UnassignedDrivingClaimer.m10402a((FragmentActivity) this);
        if (!this.f4422b.isAdded()) {
            C0195t a = getSupportFragmentManager().mo150a();
            a.mo140a(R.id.claimUnassignedDriving_fragmentContainer, this.f4422b, UnassignedDrivingClaimer.f7252a);
            a.mo138a();
        }
        this.f4421a = DailyLogNavigator.m10338a(getSupportFragmentManager(), false, true, this.f4423c, true);
        m6710a(60000, this.f4424d);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f4422b.onActivityResult(i, i2, intent);
    }

    public void mo944a(DailyLog dailyLog, boolean z) {
        this.f4422b.mo1193a(dailyLog, z);
    }

    public int a_() {
        return this.f4421a.m10348b();
    }

    public DailyLog mo930f() {
        return this.f4421a.m10347a();
    }

    public int mo946g() {
        if (this.f4423c.length > 0) {
            return this.f4423c[this.f4423c.length - 1];
        }
        return Integer.MAX_VALUE;
    }
}
