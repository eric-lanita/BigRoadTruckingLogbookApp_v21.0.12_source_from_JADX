package com.bigroad.ttb.android.p037f;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DashboardActivity;
import com.bigroad.ttb.android.dialog.HelpDialogFragment;
import com.bigroad.ttb.android.dialog.ProminentDisclosureDialogFragment;

public class C2030b extends C2028d {
    protected int mo1182c() {
        return 1;
    }

    private void m10135d(int i) {
        ScrollView scrollView = (ScrollView) m10124d().findViewById(R.id.dashboard_scrollView);
        if (scrollView != null) {
            scrollView.fullScroll(i);
        }
    }

    public void mo1178a(int i, Activity activity, View view) {
        switch (i) {
            case 8:
                m10135d(130);
                return;
            default:
                m10135d(33);
                return;
        }
    }

    protected boolean mo1180a(int i, HelpDialogFragment helpDialogFragment) {
        switch (i) {
            case 1:
                m10135d(33);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpWelcomeTitle);
                helpDialogFragment.m8873b((int) R.string.dashboard_helpWelcomeText);
                return true;
            case 2:
                helpDialogFragment.m8871a((int) R.string.dashboard_helpTourTitle);
                helpDialogFragment.m8873b((int) R.string.dashboard_helpTourText);
                helpDialogFragment.m8876d((int) R.string.helpOverlay_continueButtonLearnText);
                return true;
            case 3:
                m10123c(R.id.dashboard_mapFragmentContainer);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpMapTitle);
                helpDialogFragment.m8873b((int) R.string.dashboard_helpMapText);
                return true;
            case 4:
                m10123c(R.id.dashboard_dutyStatusWidget);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpDutyStatusTitle);
                helpDialogFragment.m8873b((int) R.string.dashboard_helpDutyStatusText);
                return true;
            case 5:
                m10123c(R.id.dashboard_dailyLogButtonGroup);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpDailyLogTitle);
                helpDialogFragment.m8873b((int) R.string.dashboard_helpDailyLogText);
                return true;
            case 6:
                m10123c(R.id.dashboard_messagesButtonGroup);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpMessagesTitle);
                if (OurApplication.m6285g().m12213g() < 0) {
                    helpDialogFragment.m8873b((int) R.string.dashboard_helpMessagesTextNoFleet);
                } else {
                    helpDialogFragment.m8873b((int) R.string.dashboard_helpMessagesTextFleet);
                }
                return true;
            case 7:
                ((ViewGroup) m10120b(R.id.dashboard_updateOdometerGroup)).setVisibility(0);
                m10123c(R.id.dashboard_updateOdometerGroup);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpOdometerTitle);
                if (OurApplication.m6294p().m6578f() == null) {
                    helpDialogFragment.m8873b((int) R.string.dashboard_helpOdometerTextNoTruck);
                } else {
                    helpDialogFragment.m8873b((int) R.string.dashboard_helpOdometerText);
                }
                return true;
            case 8:
                ((ViewGroup) m10120b(R.id.launcherItemPagerLayout)).setVisibility(0);
                m10135d(130);
                m10123c(R.id.launcherItemPagerLayout);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpAppsTitle);
                DashboardActivity dashboardActivity = (DashboardActivity) m10124d();
                if (dashboardActivity.mo930f() && dashboardActivity.mo961i()) {
                    helpDialogFragment.m8873b((int) R.string.dashboard_helpAppsTextPhoneNav);
                } else if (dashboardActivity.mo961i() && dashboardActivity.mo974h()) {
                    helpDialogFragment.m8873b((int) R.string.dashboard_helpAppsTextNavCalc);
                } else {
                    helpDialogFragment.m8873b((int) R.string.dashboard_helpAppsText);
                }
                return true;
            case 9:
                if (!C2029a.m10129a((C2028d) this, helpDialogFragment)) {
                    m10126f();
                }
                return true;
            case 10:
                m10135d(33);
                helpDialogFragment.m8871a((int) R.string.dashboard_helpStartTitle);
                helpDialogFragment.m8873b((int) R.string.dashboard_helpStartText);
                helpDialogFragment.m8876d((int) R.string.helpOverlay_continueButtonStartText);
                return true;
            default:
                return false;
        }
    }

    protected void mo1179a(int i, HelpDialogFragment helpDialogFragment, View view) {
        switch (i) {
            case 7:
                ((DashboardActivity) m10124d()).mo962j();
                m10125e();
                return;
            case 8:
                ((DashboardActivity) m10124d()).mo963k();
                m10125e();
                if (!OurApplication.m6285g().m12177V()) {
                    new ProminentDisclosureDialogFragment().m8900a(m10124d().getSupportFragmentManager());
                    return;
                }
                return;
            case 10:
                OurApplication.m6285g().m12201c(true);
                m10127g();
                return;
            default:
                m10125e();
                return;
        }
    }
}
