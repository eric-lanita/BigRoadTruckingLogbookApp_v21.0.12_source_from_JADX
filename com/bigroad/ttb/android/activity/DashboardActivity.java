package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0901j;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.ttb.android.C1792d;
import com.bigroad.ttb.android.C2098i;
import com.bigroad.ttb.android.C2098i.C1320a;
import com.bigroad.ttb.android.C2103j;
import com.bigroad.ttb.android.C2103j.C1337a;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2315v.C1428a;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.ConnectivityTracker;
import com.bigroad.ttb.android.ConnectivityTracker.C1198a;
import com.bigroad.ttb.android.DrivingModeManager;
import com.bigroad.ttb.android.DrivingModeManager.C1209a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.PowerStatus;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.DutyStatusChoice;
import com.bigroad.ttb.android.ak;
import com.bigroad.ttb.android.dialog.ConfirmSelectTruckDialogFragment;
import com.bigroad.ttb.android.dialog.ConfirmSelectTruckDialogFragment.C1357a;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.dialog.PotentialAobrdMalfunctionDialogFragment;
import com.bigroad.ttb.android.dialog.ProminentDisclosureDialogFragment;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.event.EventSource;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p037f.C2028d;
import com.bigroad.ttb.android.p037f.C2029a;
import com.bigroad.ttb.android.p037f.C2030b;
import com.bigroad.ttb.android.status.p031a.C2260d;
import com.bigroad.ttb.android.util.C2287h;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.Permission;
import com.bigroad.ttb.android.util.Permission.C1464a;
import com.bigroad.ttb.android.util.UIBehaviourUtils;
import com.bigroad.ttb.android.util.UIBehaviourUtils.ManualDutySelectionResponse;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.widget.C1386p;
import com.bigroad.ttb.android.widget.DashboardMapFragment;
import com.bigroad.ttb.android.widget.DutyStatusWidget;
import com.bigroad.ttb.android.widget.LauncherItemPagerLayout;
import com.bigroad.ttb.android.widget.OurSpinner.C1471b;
import com.bigroad.ttb.android.widget.p043a.C2443c;
import com.bigroad.ttb.android.widget.p043a.C2446d;
import com.bigroad.ttb.android.widget.p043a.C2448e;
import com.bigroad.ttb.android.widget.p043a.C2450f;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;

public class DashboardActivity extends OurActivity implements C1357a {
    private static final C2028d f5037a = new C2030b();
    private static final C2028d f5038b = new C2029a();
    private C2260d f5039A;
    private C2103j f5040B;
    private ak f5041C;
    private DrivingModeManager f5042D;
    private Notice f5043E = null;
    private boolean f5044F = false;
    private boolean f5045G;
    private boolean f5046H;
    private boolean f5047I;
    private final ChangeListener f5048J = new C14651(this);
    private final C1332b f5049K = new C1332b(this) {
        final /* synthetic */ DashboardActivity f5010a;

        {
            this.f5010a = r1;
        }

        public void mo954a(C2230r c2230r) {
            this.f5010a.f5061c.m11946a();
        }
    };
    private final C1428a f5050L = new C1428a(this) {
        final /* synthetic */ DashboardActivity f5016a;

        {
            this.f5016a = r1;
        }

        public void mo994a(C2315v c2315v) {
            this.f5016a.m7450m();
        }
    };
    private final C1182a f5051M = new C1183b(this) {
        final /* synthetic */ DashboardActivity f5017a;

        {
            this.f5017a = r1;
        }

        public void mo868e(C2474y c2474y) {
            this.f5017a.m7428a(false);
        }

        public void mo867d(C2474y c2474y) {
            this.f5017a.f5061c.m11946a();
        }

        public void mo871h(C2474y c2474y) {
            this.f5017a.mo963k();
        }
    };
    private final TruckManager.ChangeListener f5052N = new C1203b(this) {
        final /* synthetic */ DashboardActivity f5018a;

        {
            this.f5018a = r1;
        }

        public void mo894a(Truck truck) {
            this.f5018a.mo962j();
        }
    };
    private final C1320a f5053O = new C1320a(this) {
        final /* synthetic */ DashboardActivity f5019a;

        {
            this.f5019a = r1;
        }

        public void mo952a(C2098i c2098i, long[] jArr) {
            this.f5019a.m7448l();
        }
    };
    private final C1191c f5054P = new C1192d(this) {
        final /* synthetic */ DashboardActivity f5021a;

        {
            this.f5021a = r1;
        }

        public void mo879a() {
            this.f5021a.m7456q();
        }
    };
    private final C1191c f5055Q = new C1192d(this) {
        final /* synthetic */ DashboardActivity f5022a;

        {
            this.f5022a = r1;
        }

        public void mo880a(Location location) {
            m7412c(location);
        }

        public void mo881b(Location location) {
            m7412c(location);
        }

        private void m7412c(Location location) {
            if (location != null && !this.f5022a.f5044F && this.f5022a.m7457r() != null && this.f5022a.m7457r().m11918c()) {
                this.f5022a.f5044F = true;
                this.f5022a.m7457r().m11915a(true, location);
                this.f5022a.f5073o.m10602b(this.f5022a.f5055Q);
            }
        }
    };
    private final C1198a f5056R = new C1198a(this) {
        final /* synthetic */ DashboardActivity f5023a;

        {
            this.f5023a = r1;
        }

        public void mo1005a(ConnectivityTracker connectivityTracker) {
            this.f5023a.m7456q();
        }
    };
    private final VehicleConnectionManager.ChangeListener f5057S = new C14662(this);
    private final C1216a f5058T = new C14673(this);
    private final C1337a f5059U = new C14684(this);
    private final C1209a f5060V = new C14695(this);
    private DutyStatusWidget f5061c;
    private ViewGroup f5062d;
    private Button f5063e;
    private Button f5064f;
    private ImageView f5065g;
    private Button f5066h;
    private ImageView f5067i;
    private ImageView f5068j;
    private ImageView f5069k;
    private LauncherItemPagerLayout f5070l;
    private BroadcastReceiver f5071m;
    private TextView f5072n;
    private LocationTracker f5073o;
    private ConnectivityTracker f5074p;
    private C2098i f5075q;
    private C1736b f5076r;
    private EventManager f5077s;
    private C2230r f5078t;
    private C2315v f5079u;
    private TruckManager f5080v;
    private VehicleConnectionManager f5081w;
    private PowerStatus f5082x;
    private C2474y f5083y;
    private ap f5084z;

    class C14651 extends C1199e {
        final /* synthetic */ DashboardActivity f5020a;

        C14651(DashboardActivity dashboardActivity) {
            this.f5020a = dashboardActivity;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f5020a.m7428a(false);
        }

        public void mo882a() {
            this.f5020a.m7452n();
        }

        public void mo885b() {
            this.f5020a.m7452n();
        }
    }

    class C14662 extends C1201a {
        final /* synthetic */ DashboardActivity f5024a;

        C14662(DashboardActivity dashboardActivity) {
            this.f5024a = dashboardActivity;
        }

        public void mo888a(C2338a c2338a) {
            this.f5024a.m7456q();
            this.f5024a.m7428a(true);
        }

        public void mo891a(MotionType motionType) {
            this.f5024a.m7428a(false);
        }
    }

    class C14673 implements C1216a {
        final /* synthetic */ DashboardActivity f5025a;

        C14673(DashboardActivity dashboardActivity) {
            this.f5025a = dashboardActivity;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f5025a.m7456q();
        }
    }

    class C14684 implements C1337a {
        final /* synthetic */ DashboardActivity f5026a;

        C14684(DashboardActivity dashboardActivity) {
            this.f5026a = dashboardActivity;
        }

        public void mo956a(C2103j c2103j) {
            this.f5026a.m7453o();
        }
    }

    class C14695 implements C1209a {
        final /* synthetic */ DashboardActivity f5027a;

        C14695(DashboardActivity dashboardActivity) {
            this.f5027a = dashboardActivity;
        }

        public void mo981a() {
            this.f5027a.f5061c.m11946a();
        }
    }

    class C14706 implements C1386p {
        final /* synthetic */ DashboardActivity f5028a;

        C14706(DashboardActivity dashboardActivity) {
            this.f5028a = dashboardActivity;
        }

        public boolean mo982a(DutyStatusChoice dutyStatusChoice) {
            int k = this.f5028a.m7458s();
            DailyLog b = this.f5028a.f5076r.m8480b(k);
            ManualDutySelectionResponse a = UIBehaviourUtils.m11152a(b, OurApplication.ac());
            switch (a) {
                case DRIVE_TIME_MANAGED_BY_EOBR:
                    this.f5028a.m7432a(a);
                    return false;
                case ALLOWED:
                    DutyStatus a2 = dutyStatusChoice.m8045a();
                    if (a2 != null && a2.m4397e() && this.f5028a.f5081w.m11405c()) {
                        if (this.f5028a.f5081w.m11411i() || this.f5028a.f5039A.m11102e()) {
                            if (a2 == DutyStatus.DRIVING) {
                                k = R.string.aobrdManualDrivingAttempt_message;
                            } else {
                                k = R.string.aobrdManualOffDutyDrivingAttempt_message;
                            }
                            ErrorDialogFragment.m8860a(this.f5028a, (int) R.string.aobrdManualDrivingAttempt_title, k);
                        } else {
                            new PotentialAobrdMalfunctionDialogFragment().m8894a(this.f5028a);
                        }
                        return false;
                    }
                    this.f5028a.m6702U().m8295a(dutyStatusChoice, "Dashboard");
                    if (C2292l.m11230a(k)) {
                        C2292l.m11227a(b, false, OurApplication.ac());
                    }
                    return this.f5028a.m7431a(dutyStatusChoice);
                default:
                    return false;
            }
        }
    }

    class C14727 implements C1471b {
        final /* synthetic */ DashboardActivity f5029a;

        C14727(DashboardActivity dashboardActivity) {
            this.f5029a = dashboardActivity;
        }

        public boolean mo1006a(View view) {
            return this.f5029a.m7432a(UIBehaviourUtils.m11152a(this.f5029a.f5076r.m8480b(this.f5029a.m7458s()), OurApplication.ac()));
        }
    }

    class C14738 implements OnClickListener {
        final /* synthetic */ DashboardActivity f5030a;

        C14738(DashboardActivity dashboardActivity) {
            this.f5030a = dashboardActivity;
        }

        public void onClick(View view) {
            C1632a.m7982c(this.f5030a);
        }
    }

    class C14749 implements OnClickListener {
        final /* synthetic */ DashboardActivity f5031a;

        C14749(DashboardActivity dashboardActivity) {
            this.f5031a = dashboardActivity;
        }

        public void onClick(View view) {
            C1632a.m7998i(this.f5031a);
        }
    }

    private enum Notice {
        GPS_NOT_FOUND(R.string.notice_gpsNotFound, R.drawable.notice_map_error_bg),
        GPS_DISABLED(R.string.notice_gpsDisabled, R.drawable.notice_map_error_bg),
        NET_NOT_CONNECTED(R.string.notice_netNotConnected, R.drawable.notice_map_warn_bg),
        NET_CONNECTING(R.string.notice_netConnecting, R.drawable.notice_map_warn_bg);
        
        private final int m_backgroundResId;
        private final int m_textResId;

        private Notice(int i, int i2) {
            this.m_textResId = i;
            this.m_backgroundResId = i2;
        }

        public int m7424a() {
            return this.m_textResId;
        }

        public int m7425b() {
            return this.m_backgroundResId;
        }
    }

    public boolean mo930f() {
        return this.f5045G;
    }

    public boolean mo974h() {
        return this.f5046H;
    }

    public boolean mo961i() {
        return this.f5047I;
    }

    public DashboardActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.DEFAULT_MENU, Feature.DASH_LINK_STATE, Feature.ALLOW_TRIAL_USER_CONVERSION), TitleStyle.IDENTITY);
    }

    public void mo962j() {
        Truck f = this.f5080v.m6578f();
        if (f == null || f.getHasAobrd()) {
            this.f5062d.setVisibility(8);
            return;
        }
        this.f5062d.setVisibility(0);
        this.f5063e.setEnabled(true);
        if (f.hasOdometer()) {
            this.f5063e.setText(Integer.toString(f.getOdometer()));
        } else {
            this.f5063e.setText(R.string.dashboard_odometerTextHint);
        }
    }

    private void m7448l() {
        this.f5065g.setVisibility(this.f5075q.m10507a() == 0 ? 4 : 0);
    }

    private void m7450m() {
        if (this.f5079u.m11296a() > 0) {
            this.f5067i.setVisibility(0);
        } else {
            this.f5067i.setVisibility(8);
        }
    }

    private void m7452n() {
        long m = this.f5077s.m10063m();
        if (!this.f5077s.m10064n() || m <= 0) {
            this.f5068j.setVisibility(8);
        } else {
            this.f5068j.setVisibility(0);
        }
    }

    private void m7453o() {
        if (this.f5040B.m10536b() > 0) {
            this.f5069k.setVisibility(0);
        } else {
            this.f5069k.setVisibility(8);
        }
    }

    private void m7455p() {
        Collection arrayList = new ArrayList();
        this.f5045G = C0831a.m4107a(arrayList, C2448e.m12066a((Activity) this, (int) R.string.dashboard_launcherPhoneLabel));
        this.f5046H = C0831a.m4107a(arrayList, C2448e.m12073b((Activity) this, (int) R.string.dashboard_launcherCalcLabel));
        C0831a.m4107a(arrayList, C2448e.m12074c(this, R.string.dashboard_launcherClockLabel));
        this.f5047I = m7433a(arrayList, 102, C2448e.f8701a, R.string.dashboard_launcherMapsLabel, R.string.dashboard_launcherMapsIcon, R.string.dashboard_launcherMapsDescription);
        if (OurApplication.m6245B().m10548c()) {
            m7438c(arrayList, 205, C2448e.f8705e, R.string.dashboard_launcherGasBuddyLabel, R.string.dashboard_launcherGasBuddyIcon, R.string.dashboard_launcherGasBuddyDescription);
            m7438c(arrayList, 206, C2448e.f8703c, R.string.dashboard_launcherCatscaleLabel, R.string.dashboard_launcherCatscaleIcon, R.string.dashboard_launcherCatscaleDescription);
            m7438c(arrayList, 208, C2448e.f8708h, R.string.dashboard_launcherMyPilotLabel, R.string.dashboard_launcherMyPilotIcon, R.string.dashboard_launcherMyPilotDescription);
        } else {
            arrayList.add(C2448e.m12067a(this, 0, 203, C2448e.f8702b, R.string.dashboard_launcherTruckroutesLabel, R.string.dashboard_launcherTruckroutesIcon, R.string.dashboard_launcherTruckroutesDescription));
            m7436b(arrayList, 206, C2448e.f8703c, R.string.dashboard_launcherCatscaleLabel, R.string.dashboard_launcherCatscaleIcon, R.string.dashboard_launcherCatscaleDescription);
            m7436b(arrayList, 205, C2448e.f8705e, R.string.dashboard_launcherGasBuddyLabel, R.string.dashboard_launcherGasBuddyIcon, R.string.dashboard_launcherGasBuddyDescription);
            m7436b(arrayList, 207, C2448e.f8706f, R.string.dashboard_launcherTAPetroLabel, R.string.dashboard_launcherTAPetroIcon, R.string.dashboard_launcherTAPetroDescription);
            m7436b(arrayList, 215, C2448e.f8707g, R.string.dashboard_launcherWifiLabel, R.string.dashboard_launcherWifiIcon, R.string.dashboard_launcherWifiDescription);
            m7436b(arrayList, 208, C2448e.f8708h, R.string.dashboard_launcherMyPilotLabel, R.string.dashboard_launcherMyPilotIcon, R.string.dashboard_launcherMyPilotDescription);
            m7436b(arrayList, 209, C2448e.f8709i, R.string.dashboard_launcherLovesConnectLabel, R.string.dashboard_launcherLovesConnectIcon, R.string.dashboard_launcherLovesConnectDescription);
            m7436b(arrayList, 210, C2448e.f8710j, R.string.dashboard_launcherBlueBeaconLabel, R.string.dashboard_launcherBlueBeaconIcon, R.string.dashboard_launcherBlueBeaconDescription);
            m7436b(arrayList, 213, C2448e.f8711k, R.string.dashboard_launcherMackDealerLabel, R.string.dashboard_launcherMackDealerIcon, R.string.dashboard_launcherMackDealerDescription);
            m7436b(arrayList, 214, C2448e.f8712l, R.string.dashboard_launcherVolvoDealerLabel, R.string.dashboard_launcherVolvoDealerIcon, R.string.dashboard_launcherVolvoDealerDescription);
            m7436b(arrayList, 212, C2448e.f8713m, R.string.dashboard_launcherTruckerNetLabel, R.string.dashboard_launcherTruckerNetIcon, R.string.dashboard_launcherTruckerNetDescription);
            m7436b(arrayList, 211, C2448e.f8714n, R.string.dashboard_launcherLoseItLabel, R.string.dashboard_launcherLoseItIcon, R.string.dashboard_launcherLoseItDescription);
            m7436b(arrayList, 201, C2448e.f8715o, R.string.dashboard_launcherDrivewyzeLabel, R.string.dashboard_launcherDrivewyzeIcon, R.string.dashboard_launcherDrivewyzeDescription);
            m7436b(arrayList, 202, C2448e.f8716p, R.string.dashboard_launcherDatTruckerServicesLabel, R.string.dashboard_launcherDatTruckerServicesIcon, R.string.dashboard_launcherDatTruckerServicesDescription);
            C2443c a = C2448e.m12067a(this, 0, 216, C2448e.f8718r, R.string.dashboard_launcherAxleCalcLabel, R.string.dashboard_launcherAxleCalcIcon, R.string.dashboard_launcherAxleCalcDescription);
            C2443c a2 = C2448e.m12067a(this, 0, 217, C2448e.f8717q, R.string.dashboard_launcherTruckScaleLabel, R.string.dashboard_launcherTruckScaleIcon, R.string.dashboard_launcherTruckScaleDescription);
            if (a == null) {
                C0831a.m4107a(arrayList, a2);
            } else if (a2 == null) {
                C0831a.m4107a(arrayList, a);
            } else if (!a.m12052d() || a2.m12052d()) {
                arrayList.add(a2);
            } else {
                arrayList.add(a);
            }
        }
        this.f5070l.setLaunchers(arrayList);
    }

    private boolean m7433a(Collection<C2443c> collection, int i, C2446d c2446d, int i2, int i3, int i4) {
        return C0831a.m4107a(collection, C2448e.m12068a(this, 0, i, c2446d, i2, i3, i4, true));
    }

    private boolean m7436b(Collection<C2443c> collection, int i, C2446d c2446d, int i2, int i3, int i4) {
        return C0831a.m4107a(collection, C2448e.m12067a(this, 0, i, c2446d, i2, i3, i4));
    }

    private void m7438c(Collection<C2443c> collection, int i, C2446d c2446d, int i2, int i3, int i4) {
        C0831a.m4107a(collection, C2448e.m12069a(this, i, c2446d, i2, i3, i4));
    }

    private void m7456q() {
        ArrayList arrayList = new ArrayList();
        switch (this.f5073o.m10606f()) {
            case DISABLED:
                arrayList.add(Notice.GPS_DISABLED);
                break;
            case NOT_FOUND:
                arrayList.add(Notice.GPS_NOT_FOUND);
                break;
        }
        switch (this.f5074p.m6111b()) {
            case CONNECTING:
                arrayList.add(Notice.NET_CONNECTING);
                break;
            case NOT_CONNECTED:
                arrayList.add(Notice.NET_NOT_CONNECTED);
                break;
        }
        Notice notice = arrayList.isEmpty() ? null : (Notice) Collections.min(arrayList);
        if (notice != this.f5043E) {
            this.f5043E = notice;
            if (notice == null) {
                this.f5072n.setVisibility(8);
                return;
            }
            this.f5072n.setText(notice.m7424a());
            this.f5072n.setBackgroundResource(notice.m7425b());
            this.f5072n.setVisibility(0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dashboard);
        this.f5073o = OurApplication.m6302x();
        this.f5074p = OurApplication.m6244A();
        this.f5075q = OurApplication.m6299u();
        this.f5077s = OurApplication.m6295q();
        this.f5078t = OurApplication.m6292n();
        this.f5076r = OurApplication.m6296r();
        this.f5079u = OurApplication.m6298t();
        this.f5080v = OurApplication.m6294p();
        this.f5081w = OurApplication.m6252I();
        this.f5082x = OurApplication.m6286h();
        this.f5083y = OurApplication.m6285g();
        this.f5084z = OurApplication.m6269Z();
        this.f5039A = OurApplication.m6254K();
        this.f5040B = OurApplication.ae();
        this.f5041C = OurApplication.ag();
        this.f5042D = OurApplication.ah();
        this.f5061c = (DutyStatusWidget) findViewById(R.id.dashboard_dutyStatusWidget);
        this.f5061c.setOnDutyStatusSelectedListener(new C14706(this));
        this.f5061c.setOverrideClickListener(new C14727(this));
        this.f5070l = (LauncherItemPagerLayout) findViewById(R.id.launcherItemPagerLayout);
        this.f5070l.m11985a((Activity) this);
        this.f5072n = (TextView) findViewById(R.id.dashboard_notice);
        this.f5072n.setVisibility(8);
        this.f5062d = (ViewGroup) findViewById(R.id.dashboard_updateOdometerGroup);
        this.f5063e = (Button) findViewById(R.id.dashboard_updateOdometerButton);
        this.f5063e.setOnClickListener(new C14738(this));
        this.f5064f = (Button) findViewById(R.id.dashboard_messagesButton);
        this.f5064f.setOnClickListener(new C14749(this));
        this.f5064f.setLongClickable(false);
        this.f5065g = (ImageView) findViewById(R.id.dashboard_messageWaitingBadge);
        this.f5066h = (Button) findViewById(R.id.dashboard_dailyLogButton);
        this.f5066h.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DashboardActivity f5008a;

            {
                this.f5008a = r1;
            }

            public void onClick(View view) {
                C1632a.m7992f(this.f5008a);
            }
        });
        this.f5067i = (ImageView) findViewById(R.id.dashboard_dailyLogWarningBadge);
        this.f5068j = (ImageView) findViewById(R.id.dashboard_unclaimedDriversEventWarningBadge);
        this.f5069k = (ImageView) findViewById(R.id.dashboard_CarrierWarningBadge);
        mo963k();
        this.f5077s.m10012a(this.f5048J);
        this.f5078t.m11009a(this.f5049K);
        this.f5079u.m11301a(this.f5050L);
        this.f5040B.m10534a(this.f5059U);
        this.f5042D.m6190a(this.f5060V);
        m6709a(0, 60000, new Runnable(this) {
            final /* synthetic */ DashboardActivity f5009a;

            {
                this.f5009a = r1;
            }

            public void run() {
                this.f5009a.m7428a(false);
            }
        });
        m6699R().m12184a(this.f5051M);
        this.f5080v.m6560a(this.f5052N, Priority.DEFAULT);
        mo962j();
        this.f5075q.m10511a(this.f5053O);
        m7448l();
        m7428a(true);
        m7450m();
        m7452n();
        m7453o();
        if (bundle == null) {
            C1632a.m8011p((Activity) this);
        }
        this.f5071m = new BroadcastReceiver(this) {
            final /* synthetic */ DashboardActivity f5011a;

            {
                this.f5011a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                this.f5011a.m7455p();
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addDataScheme("package");
        Intent registerReceiver = registerReceiver(this.f5071m, intentFilter);
        if (registerReceiver != null) {
            this.f5071m.onReceive(this, registerReceiver);
        }
        if (bundle == null) {
            C1792d.m8818a((OurActivity) this);
        }
    }

    private boolean m7432a(ManualDutySelectionResponse manualDutySelectionResponse) {
        switch (manualDutySelectionResponse) {
            case DRIVE_TIME_MANAGED_BY_EOBR:
                m6697P();
                return true;
            default:
                return false;
        }
    }

    private boolean m7431a(DutyStatusChoice dutyStatusChoice) {
        if (dutyStatusChoice == DutyStatusChoice.DUTY_STATUS_WITH_NOTE) {
            C1632a.m7926a((Activity) this, OurApplication.m6296r().m8485c(), this.f5084z.mo914b(), true, C1130o.m5714a(this.f5080v.m6578f()));
            return true;
        } else if (dutyStatusChoice == DutyStatusChoice.START_YARD_MOVE || dutyStatusChoice == DutyStatusChoice.STOP_YARD_MOVE) {
            if (dutyStatusChoice == DutyStatusChoice.START_YARD_MOVE) {
                this.f5041C.m8423a(this, Reason.USER_SELECTED_DASHBOARD, DutyStatusChangeBits.Reason.USER_SELECTED_DASHBOARD);
                return true;
            }
            this.f5041C.m8422a(Reason.USER_SELECTED_DASHBOARD, DutyStatusChangeBits.Reason.USER_SELECTED_DASHBOARD);
            return true;
        } else if (dutyStatusChoice == DutyStatusChoice.ENABLE_PERSONAL_USE_MODE || dutyStatusChoice == DutyStatusChoice.DISABLE_PERSONAL_USE_MODE) {
            this.f5042D.m6192a(dutyStatusChoice == DutyStatusChoice.ENABLE_PERSONAL_USE_MODE ? ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE : ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE, Reason.USER_SELECTED_DASHBOARD, DutyStatusChangeBits.Reason.USER_SELECTED_DASHBOARD, null);
            return true;
        } else if (dutyStatusChoice.m8045a() == null) {
            return false;
        } else {
            if (this.f5080v.m6578f() == null && dutyStatusChoice.m8045a().m4397e()) {
                ConfirmSelectTruckDialogFragment.m8828a(this, dutyStatusChoice.m8045a());
                return false;
            }
            C2287h.m11213a(dutyStatusChoice.m8045a(), DutyStatusChangeBits.Reason.USER_SELECTED_DASHBOARD, EventSource.USER);
            return true;
        }
    }

    public void mo970c(DutyStatus dutyStatus) {
        C1632a.m7963a((OurActivity) this, EnumSet.of(Option.ALLOW_UNKNOWN_TRUCK), dutyStatus);
    }

    public void mo971d(DutyStatus dutyStatus) {
        mo972e(dutyStatus);
    }

    public void mo972e(DutyStatus dutyStatus) {
        if (dutyStatus != null) {
            this.f5077s.m10019a(dutyStatus, EventSource.USER, DutyStatusChangeBits.m4033a(DutyStatusChangeBits.Reason.USER_SELECTED_DASHBOARD));
        }
    }

    protected void onStart() {
        super.onStart();
        OurApplication.m6300v().m10901a(true);
        this.f5073o.m10599a(this.f5054P);
        this.f5074p.m6110a(this.f5056R);
        this.f5081w.m11399a(this.f5057S);
        this.f5082x.m6311a(this.f5058T);
        m7456q();
        Permission.LOCATION.m11149a((Activity) this, new C1464a(this) {
            final /* synthetic */ DashboardActivity f5012a;

            {
                this.f5012a = r1;
            }

            public void mo1003a() {
                this.f5012a.f5073o.m10601b();
                this.f5012a.f5073o.m10599a(this.f5012a.f5055Q);
            }

            public void mo1004b() {
                C2134e.m10676b("TT-Dashboard", "User denied location request");
            }
        });
    }

    protected void onResume() {
        super.onResume();
        PackageInfo packageInfo = null;
        long E = this.f5083y.m12160E();
        long j = 0;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            j = packageInfo.lastUpdateTime;
            this.f5083y.m12203d(j);
        } catch (NameNotFoundException e) {
            C2134e.m10682e("TT-Dashboard", "App package name not found.");
        }
        if (!m6699R().m12169N()) {
            OurApplication.m6246C().m10143a((OurActivity) this, f5037a);
        } else if (C2029a.m10128a() && r2 != null && r0 > E) {
            OurApplication.m6246C().m10143a((OurActivity) this, f5038b);
        } else if (!this.f5083y.m12178W() && this.f5083y.m12169N()) {
            new ProminentDisclosureDialogFragment().m8900a(getSupportFragmentManager());
        }
        OurApplication.ad().m8359a();
    }

    private DashboardMapFragment m7457r() {
        return (DashboardMapFragment) getSupportFragmentManager().mo148a((int) R.id.dashboard_mapFragment);
    }

    protected void onResumeFragments() {
        super.onResumeFragments();
        DashboardMapFragment r = m7457r();
        if (r != null) {
            r.m11919d();
        }
    }

    protected void onPause() {
        DashboardMapFragment r = m7457r();
        if (r != null) {
            r.m11920e();
        }
        super.onPause();
    }

    protected void onStop() {
        this.f5073o.m10602b(this.f5054P);
        this.f5074p.m6112b(this.f5056R);
        this.f5081w.m11404b(this.f5057S);
        this.f5082x.m6314b(this.f5058T);
        super.onStop();
    }

    protected void onDestroy() {
        this.f5075q.m10514b(this.f5053O);
        this.f5077s.m10029b(this.f5048J);
        this.f5078t.m11015b(this.f5049K);
        this.f5079u.m11303b(this.f5050L);
        this.f5080v.m6568b(this.f5052N);
        this.f5040B.m10539b(this.f5059U);
        this.f5042D.m6195b(this.f5060V);
        m6699R().m12194b(this.f5051M);
        unregisterReceiver(this.f5071m);
        super.onDestroy();
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 0:
                return C2450f.m12075a(this);
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        switch (i) {
            case 0:
                C2450f.m12076a(dialog, this, bundle);
                break;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f5070l.m11984a(i);
        switch (i) {
            case 26:
                if (intent != null && intent.hasExtra("com.bigroad.ttb.pendingDutyStatus")) {
                    DutyStatus a = DutyStatus.m4383a(intent.getIntExtra("com.bigroad.ttb.pendingDutyStatus", -1));
                    Truck f = this.f5080v.m6578f();
                    if (f == null || !f.getHasAobrd()) {
                        mo972e(a);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mo963k() {
        m7455p();
        if (this.f5083y.m12177V()) {
            this.f5070l.setVisibility(0);
        } else {
            this.f5070l.setVisibility(8);
        }
    }

    private void m7428a(boolean z) {
        C0956v r = m6699R().m12228r();
        boolean a = this.f5061c.m11948a(C0901j.m4568a().m4564a(r).m4567a());
        this.f5061c.m11947a(DutyLimits.m4362a(r.m4881o(), new C0898i(OurApplication.m6296r().m8493g(), this.f5077s.m10025b(), this.f5084z.mo914b(), r.m4868b())), this.f5077s.m10060j());
        if (this.f5061c.m11949a(this.f5081w.m11406d())) {
            a = true;
        }
        if (!a && z) {
            this.f5061c.m11946a();
        }
        this.f5061c.setLocked(this.f5081w.m11413k());
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_sendNote:
                C1632a.m7986d((Context) this);
                return true;
            case R.id.menu_checkIn:
                C1632a.m7989e((Context) this);
                return true;
            case R.id.menu_share:
                C1632a.m8000j((Context) this);
                return true;
            default:
                return super.onContextItemSelected(menuItem);
        }
    }

    private int m7458s() {
        return DailyLogUtils.m4284a(m6699R().m12228r().m4879m());
    }
}
