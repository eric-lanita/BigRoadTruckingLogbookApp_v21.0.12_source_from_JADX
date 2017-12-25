package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.ap;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0901j;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.TimeWindow;
import com.bigroad.shared.duty.TimeWindow.Condition;
import com.bigroad.shared.p023c.C0854a;
import com.bigroad.ttb.android.C2103j;
import com.bigroad.ttb.android.C2103j.C1337a;
import com.bigroad.ttb.android.C2226q;
import com.bigroad.ttb.android.C2226q.C1221a;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2315v.C1428a;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.ConnectivityTracker.Connectivity;
import com.bigroad.ttb.android.DrivingModeManager;
import com.bigroad.ttb.android.DrivingModeManager.C1209a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.adapter.DailyLogListFilterAdapter.DailyLogListFilter;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.DutyStatusChoice;
import com.bigroad.ttb.android.ak;
import com.bigroad.ttb.android.dialog.ConfirmSelectTruckDialogFragment;
import com.bigroad.ttb.android.dialog.ConfirmSelectTruckDialogFragment.C1357a;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.dialog.InspectionLogDaysChooserDialogFragment;
import com.bigroad.ttb.android.dialog.InspectionLogDaysChooserDialogFragment.C1524a;
import com.bigroad.ttb.android.dialog.InspectionTypeChooserDialogFragment;
import com.bigroad.ttb.android.dialog.InspectionTypeChooserDialogFragment.C1525a;
import com.bigroad.ttb.android.dialog.InspectionTypeChooserDialogFragment.InspectionOption;
import com.bigroad.ttb.android.dialog.PotentialAobrdMalfunctionDialogFragment;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.event.EventSource;
import com.bigroad.ttb.android.model.C2186g;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.status.p031a.C2260d;
import com.bigroad.ttb.android.util.C2287h;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.util.UIBehaviourUtils;
import com.bigroad.ttb.android.util.UIBehaviourUtils.ManualDutySelectionResponse;
import com.bigroad.ttb.android.util.ab;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.widget.C1386p;
import com.bigroad.ttb.android.widget.C2462j;
import com.bigroad.ttb.android.widget.DailyLogGraphView;
import com.bigroad.ttb.android.widget.DutyStatusView;
import com.bigroad.ttb.android.widget.HosSettingsView;
import com.bigroad.ttb.android.widget.OurSpinner.C1471b;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogShareType;
import com.bigroad.ttb.protocol.TTProtocol.Dvir;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

public class HosSummaryActivity extends LogDownloadTaskActivity implements C1357a, C1524a, C1525a {
    private DailyLogGraphView f5254A;
    private View f5255B;
    private TextView f5256C;
    private TextView f5257D;
    private TextView f5258E;
    private TextView f5259F;
    private View f5260G;
    private TextView f5261H;
    private TextView f5262I;
    private TextView f5263J;
    private TextView f5264K;
    private TextView f5265L;
    private TextView f5266M;
    private Button f5267N;
    private Button f5268O;
    private ViewGroup f5269P;
    private C0956v f5270Q;
    private boolean f5271R = false;
    private final ChangeListener f5272S = new C15151(this);
    private final C1332b f5273T = new C1332b(this) {
        final /* synthetic */ HosSummaryActivity f5237a;

        {
            this.f5237a = r1;
        }

        public void mo954a(C2230r c2230r) {
            this.f5237a.m7652k();
        }
    };
    private final C1428a f5274U = new C1428a(this) {
        final /* synthetic */ HosSummaryActivity f5238a;

        {
            this.f5238a = r1;
        }

        public void mo994a(C2315v c2315v) {
            this.f5238a.m7660o();
        }
    };
    private final C1182a f5275V = new C1183b(this) {
        final /* synthetic */ HosSummaryActivity f5239a;

        {
            this.f5239a = r1;
        }

        public void mo868e(C2474y c2474y) {
            this.f5239a.m7654l();
            this.f5239a.m7656m();
            this.f5239a.m7658n();
            this.f5239a.m7660o();
        }

        public void mo867d(C2474y c2474y) {
            this.f5239a.f5293n.m11932a();
        }
    };
    private final C1221a f5276W = new C1221a(this) {
        final /* synthetic */ HosSummaryActivity f5240a;

        {
            this.f5240a = r1;
        }

        public void mo905a(C2226q c2226q) {
            this.f5240a.m7658n();
        }
    };
    private final VehicleConnectionManager.ChangeListener f5277X = new C1201a(this) {
        final /* synthetic */ HosSummaryActivity f5241a;

        {
            this.f5241a = r1;
        }

        public void mo888a(C2338a c2338a) {
            this.f5241a.m7652k();
        }

        public void mo891a(MotionType motionType) {
            this.f5241a.m7664r();
        }
    };
    private final C1337a f5278Y = new C1337a(this) {
        final /* synthetic */ HosSummaryActivity f5242a;

        {
            this.f5242a = r1;
        }

        public void mo956a(C2103j c2103j) {
            this.f5242a.m7663q();
        }
    };
    private final C1209a f5279Z = new C1209a(this) {
        final /* synthetic */ HosSummaryActivity f5243a;

        {
            this.f5243a = r1;
        }

        public void mo981a() {
            this.f5243a.f5293n.m11932a();
        }
    };
    private final EventManager f5280a = OurApplication.m6295q();
    private final C2230r f5281b = OurApplication.m6292n();
    private final C2226q f5282c = OurApplication.m6297s();
    private final C2315v f5283d = OurApplication.m6298t();
    private final C1736b f5284e = OurApplication.m6296r();
    private final TruckManager f5285f = OurApplication.m6294p();
    private final VehicleConnectionManager f5286g = OurApplication.m6252I();
    private final C2474y f5287h = OurApplication.m6285g();
    private final ap f5288i = OurApplication.m6269Z();
    private final C2260d f5289j = OurApplication.m6254K();
    private final C2103j f5290k = OurApplication.ae();
    private final ak f5291l = OurApplication.ag();
    private final DrivingModeManager f5292m = OurApplication.ah();
    private DutyStatusView f5293n;
    private HosSettingsView f5294o;
    private TextView f5295p;
    private TextView f5296q;
    private TextView f5297r;
    private TextView f5298s;
    private View f5299t;
    private TextView f5300u;
    private TextView f5301v;
    private TextView f5302w;
    private TextView f5303x;
    private TextView f5304y;
    private TextView f5305z;

    class C15151 extends C1199e {
        final /* synthetic */ HosSummaryActivity f5245a;

        C15151(HosSummaryActivity hosSummaryActivity) {
            this.f5245a = hosSummaryActivity;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f5245a.m7656m();
            this.f5245a.m7649j();
        }

        public void mo882a() {
            this.f5245a.m7662p();
        }

        public void mo885b() {
            this.f5245a.m7662p();
        }
    }

    class C15162 implements OnClickListener {
        final /* synthetic */ HosSummaryActivity f5246a;

        C15162(HosSummaryActivity hosSummaryActivity) {
            this.f5246a = hosSummaryActivity;
        }

        public void onClick(View view) {
            C1632a.m7955a(this.f5246a, DailyLogListFilter.UNIDENTIFIED_DRIVING);
        }
    }

    class C15173 implements OnClickListener {
        final /* synthetic */ HosSummaryActivity f5247a;

        C15173(HosSummaryActivity hosSummaryActivity) {
            this.f5247a = hosSummaryActivity;
        }

        public void onClick(View view) {
            C1632a.m7955a(this.f5247a, DailyLogListFilter.CORRECTIONS);
        }
    }

    class C15184 implements C1386p {
        final /* synthetic */ HosSummaryActivity f5248a;

        C15184(HosSummaryActivity hosSummaryActivity) {
            this.f5248a = hosSummaryActivity;
        }

        public boolean mo982a(DutyStatusChoice dutyStatusChoice) {
            int k = this.f5248a.m7647i();
            DailyLog b = this.f5248a.f5284e.m8480b(k);
            ManualDutySelectionResponse a = UIBehaviourUtils.m11152a(b, OurApplication.ac());
            switch (a) {
                case DRIVE_TIME_MANAGED_BY_EOBR:
                    this.f5248a.m7637a(a);
                    return false;
                case ALLOWED:
                    DutyStatus a2 = dutyStatusChoice.m8045a();
                    if (a2 != null && a2.m4397e() && this.f5248a.f5286g.m11405c()) {
                        if (this.f5248a.f5286g.m11411i() || this.f5248a.f5289j.m11102e()) {
                            if (a2 == DutyStatus.DRIVING) {
                                k = R.string.aobrdManualDrivingAttempt_message;
                            } else {
                                k = R.string.aobrdManualOffDutyDrivingAttempt_message;
                            }
                            ErrorDialogFragment.m8860a(this.f5248a, (int) R.string.aobrdManualDrivingAttempt_title, k);
                        } else {
                            new PotentialAobrdMalfunctionDialogFragment().m8894a(this.f5248a);
                        }
                        return false;
                    }
                    this.f5248a.m6702U().m8295a(dutyStatusChoice, "DailyLog");
                    if (C2292l.m11230a(k)) {
                        C2292l.m11227a(b, false, OurApplication.ac());
                    }
                    return this.f5248a.m7636a(dutyStatusChoice);
                default:
                    return false;
            }
        }
    }

    class C15195 implements C1471b {
        final /* synthetic */ HosSummaryActivity f5249a;

        C15195(HosSummaryActivity hosSummaryActivity) {
            this.f5249a = hosSummaryActivity;
        }

        public boolean mo1006a(View view) {
            return this.f5249a.m7637a(UIBehaviourUtils.m11152a(this.f5249a.f5284e.m8480b(this.f5249a.m7647i()), OurApplication.ac()));
        }
    }

    class C15206 implements OnClickListener {
        final /* synthetic */ HosSummaryActivity f5250a;

        C15206(HosSummaryActivity hosSummaryActivity) {
            this.f5250a = hosSummaryActivity;
        }

        public void onClick(View view) {
            C1632a.m8006m(this.f5250a);
        }
    }

    class C15217 implements OnClickListener {
        final /* synthetic */ HosSummaryActivity f5251a;

        C15217(HosSummaryActivity hosSummaryActivity) {
            this.f5251a = hosSummaryActivity;
        }

        public void onClick(View view) {
            DailyLog f = this.f5251a.f5284e.m8491f(DailyLogUtils.m4284a(this.f5251a.f5287h.m12228r().m4879m()));
            if (f != null) {
                Object obj = (f.getHosUs7DayCycleEnabled() || f.getHosUs8DayCycleEnabled()) ? 1 : null;
                InspectionTerm inspectionTerm = obj != null ? InspectionTerm.SEVEN_DAYS : InspectionTerm.FOURTEEN_DAYS;
                InspectionLogDaysChooserDialogFragment inspectionLogDaysChooserDialogFragment = new InspectionLogDaysChooserDialogFragment();
                TruckLogType truckLogType = TruckLogType.UNKNOWN_LOG_TYPE;
                if (this.f5251a.f5285f.m6578f() != null) {
                    truckLogType = TruckLogType.m15634a(this.f5251a.f5285f.m6578f().getTruckLogType());
                }
                inspectionLogDaysChooserDialogFragment.m8877a(this.f5251a, inspectionTerm, truckLogType);
            }
        }
    }

    class C15228 implements OnClickListener {
        final /* synthetic */ HosSummaryActivity f5252a;

        C15228(HosSummaryActivity hosSummaryActivity) {
            this.f5252a = hosSummaryActivity;
        }

        public void onClick(View view) {
            C1632a.m7994g(this.f5252a);
        }
    }

    class C15239 implements Runnable {
        final /* synthetic */ HosSummaryActivity f5253a;

        C15239(HosSummaryActivity hosSummaryActivity) {
            this.f5253a = hosSummaryActivity;
        }

        public void run() {
            this.f5253a.m7656m();
            this.f5253a.m7658n();
            this.f5253a.m7660o();
        }
    }

    private int m7647i() {
        return DailyLogUtils.m4285a(this.f5270Q.m4868b());
    }

    private String m7630a(Calendar calendar) {
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(this);
        timeFormat.setTimeZone(calendar.getTimeZone());
        return timeFormat.format(calendar.getTime());
    }

    public HosSummaryActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.DEFAULT_MENU, Feature.DASH_LINK_STATE, Feature.ALLOW_TRIAL_USER_CONVERSION), TitleStyle.IDENTITY);
    }

    protected void onStart() {
        super.onStart();
        OurApplication.m6300v().m10901a(true);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.hos_summary);
        this.f5293n = (DutyStatusView) findViewById(R.id.hosSummary_dutyStatus);
        this.f5294o = (HosSettingsView) findViewById(R.id.hosSummary_hosSettings);
        this.f5295p = (TextView) findViewById(R.id.hosSummary_homeTimeZone);
        this.f5296q = (TextView) findViewById(R.id.hosSummary_availableDrive);
        this.f5297r = (TextView) findViewById(R.id.hosSummary_availableDuty);
        this.f5298s = (TextView) findViewById(R.id.hosSummary_availableCycle);
        this.f5304y = (TextView) findViewById(R.id.hosSummary_resetDuty);
        this.f5305z = (TextView) findViewById(R.id.hosSummary_resetCycle);
        this.f5254A = (DailyLogGraphView) findViewById(R.id.hosSummary_log);
        this.f5255B = findViewById(R.id.hosSummary_splitSleeperGroup);
        this.f5256C = (TextView) findViewById(R.id.hosSummary_splitSleeperDutyStatus);
        this.f5257D = (TextView) findViewById(R.id.hosSummary_splitSleeperWaitUntil);
        this.f5258E = (TextView) findViewById(R.id.hosSummary_splitSleeperAvailableDrive);
        this.f5259F = (TextView) findViewById(R.id.hosSummary_splitSleeperAvailableDuty);
        this.f5260G = findViewById(R.id.hosSummary_splitSleeperResetGroup);
        this.f5261H = (TextView) findViewById(R.id.hosSummary_splitSleeperReady);
        this.f5262I = (TextView) findViewById(R.id.hosSummary_dvirSummary);
        this.f5263J = (TextView) findViewById(R.id.hosSummary_dvirDefectSummary);
        this.f5267N = (Button) findViewById(R.id.hosSummary_inspectLogs);
        this.f5268O = (Button) findViewById(R.id.hosSummary_viewLogDetails);
        this.f5264K = (TextView) findViewById(R.id.hosSummary_numLogDaysWithWarnings);
        this.f5264K.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ HosSummaryActivity f5244a;

            {
                this.f5244a = r1;
            }

            public void onClick(View view) {
                C1632a.m7955a(this.f5244a, DailyLogListFilter.WARNINGS);
            }
        });
        this.f5265L = (TextView) findViewById(R.id.hosSummary_numLogDaysWithUnclaimedDriversEventsWarnings);
        this.f5265L.setOnClickListener(new C15162(this));
        m7662p();
        this.f5266M = (TextView) findViewById(R.id.hosSummary_numCorrectionSuggestions);
        this.f5266M.setOnClickListener(new C15173(this));
        m7663q();
        this.f5254A.setHosSettings(m6699R().m12228r());
        this.f5299t = findViewById(R.id.hosSummary_restBreakGroup);
        this.f5300u = (TextView) findViewById(R.id.hosSummary_untilBreakLabel);
        this.f5301v = (TextView) findViewById(R.id.hosSummary_untilBreak);
        this.f5302w = (TextView) findViewById(R.id.hosSummary_breakRemainingLabel);
        this.f5303x = (TextView) findViewById(R.id.hosSummary_breakRemaining);
        this.f5269P = (LinearLayout) findViewById(R.id.lockApplicationWarningLayout);
        this.f5269P.setVisibility(8);
        this.f5293n.setOnDutyStatusSelectedListener(new C15184(this));
        this.f5293n.setOverrideClickListener(new C15195(this));
        this.f5294o.setOnEditClickListener(new C15206(this));
        this.f5267N.setOnClickListener(new C15217(this));
        this.f5268O.setOnClickListener(new C15228(this));
        m6699R().m12184a(this.f5275V);
        this.f5280a.m10012a(this.f5272S);
        this.f5281b.m11009a(this.f5273T);
        this.f5282c.m10974a(this.f5276W);
        this.f5286g.m11399a(this.f5277X);
        this.f5283d.m11301a(this.f5274U);
        this.f5290k.m10534a(this.f5278Y);
        this.f5292m.m6190a(this.f5279Z);
        m7654l();
        m7656m();
        m7649j();
        m7652k();
        m7658n();
        m7660o();
        m7664r();
        m6709a(0, 60000, new C15239(this));
    }

    protected void onResume() {
        super.onResume();
        OurApplication.ad().m8359a();
        m7664r();
    }

    private boolean m7637a(ManualDutySelectionResponse manualDutySelectionResponse) {
        switch (manualDutySelectionResponse) {
            case DRIVE_TIME_MANAGED_BY_EOBR:
                m6697P();
                return true;
            default:
                return false;
        }
    }

    private boolean m7636a(DutyStatusChoice dutyStatusChoice) {
        if (dutyStatusChoice == DutyStatusChoice.DUTY_STATUS_WITH_NOTE) {
            C1632a.m7926a((Activity) this, OurApplication.m6296r().m8485c(), this.f5288i.mo914b(), true, C1130o.m5714a(this.f5285f.m6578f()));
            return true;
        } else if (dutyStatusChoice == DutyStatusChoice.START_YARD_MOVE || dutyStatusChoice == DutyStatusChoice.STOP_YARD_MOVE) {
            if (dutyStatusChoice == DutyStatusChoice.START_YARD_MOVE) {
                this.f5291l.m8423a(this, Reason.USER_SELECTED_SUMMARY, DutyStatusChangeBits.Reason.USER_SELECTED_SUMMARY);
                return true;
            }
            this.f5291l.m8422a(Reason.USER_SELECTED_SUMMARY, DutyStatusChangeBits.Reason.USER_SELECTED_SUMMARY);
            return true;
        } else if (dutyStatusChoice == DutyStatusChoice.ENABLE_PERSONAL_USE_MODE || dutyStatusChoice == DutyStatusChoice.DISABLE_PERSONAL_USE_MODE) {
            this.f5292m.m6192a(dutyStatusChoice == DutyStatusChoice.ENABLE_PERSONAL_USE_MODE ? ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE : ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE, Reason.USER_SELECTED_SUMMARY, DutyStatusChangeBits.Reason.USER_SELECTED_SUMMARY, null);
            return true;
        } else if (dutyStatusChoice.m8045a() == null) {
            return false;
        } else {
            if (this.f5285f.m6578f() == null && dutyStatusChoice.m8045a().m4397e()) {
                ConfirmSelectTruckDialogFragment.m8828a(this, dutyStatusChoice.m8045a());
                return false;
            }
            C2287h.m11213a(dutyStatusChoice.m8045a(), DutyStatusChangeBits.Reason.USER_SELECTED_SUMMARY, EventSource.USER);
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
            OurApplication.m6295q().m10019a(dutyStatus, EventSource.USER, DutyStatusChangeBits.m4033a(DutyStatusChangeBits.Reason.USER_SELECTED_SUMMARY));
        }
    }

    protected void onDestroy() {
        this.f5286g.m11404b(this.f5277X);
        this.f5282c.m10982b(this.f5276W);
        this.f5280a.m10029b(this.f5272S);
        this.f5281b.m11015b(this.f5273T);
        this.f5283d.m11303b(this.f5274U);
        this.f5290k.m10539b(this.f5278Y);
        m6699R().m12194b(this.f5275V);
        this.f5292m.m6195b(this.f5279Z);
        super.onDestroy();
    }

    private void m7649j() {
        this.f5293n.setSelection(this.f5280a.m10060j());
    }

    private void m7652k() {
        if (!this.f5293n.m11935a(this.f5286g.m11406d())) {
            this.f5293n.m11932a();
        }
    }

    private void m7654l() {
        this.f5270Q = m6699R().m12228r();
        this.f5295p.setText(aq.m4217a(this.f5270Q.m4879m(), 0));
        this.f5293n.m11934a(C0901j.m4568a().m4564a(this.f5270Q).m4567a());
        this.f5294o.setHosSettings(this.f5270Q);
        this.f5254A.setHosSettings(this.f5270Q);
    }

    private void m7656m() {
        TimeZone b = this.f5270Q.m4868b();
        int a = DailyLogUtils.m4285a(b);
        this.f5254A.m11849a(new C0886a(this.f5280a.m10061k(), a, b).m4478a(C2292l.m11230a(a)).m4479a(this.f5288i.mo914b()), this.f5283d.m11305d(a));
        DutyLimits a2 = DutyLimits.m4362a(this.f5270Q.m4881o(), new C0898i(OurApplication.m6296r().m8493g(), this.f5280a.m10025b(), this.f5288i.mo914b(), b));
        this.f5293n.setAvailability(a2);
        m7631a(this.f5296q, a2.m4364a());
        m7631a(this.f5297r, a2.m4367c());
        m7631a(this.f5298s, a2.m4368d());
        m7638b(this.f5304y, a2.m4371g());
        m7638b(this.f5305z, a2.m4372h());
        if (a2.m4380p()) {
            m7632a(a2);
            this.f5299t.setVisibility(0);
        } else {
            this.f5299t.setVisibility(8);
        }
        if (a2.m4374j()) {
            m7639b(a2);
            this.f5255B.setVisibility(0);
            return;
        }
        this.f5255B.setVisibility(8);
    }

    private void m7632a(DutyLimits dutyLimits) {
        TimeWindow f = dutyLimits.m4370f();
        Object obj = (!this.f5280a.m10060j().m4396d() || f.mo727a() == Condition.FINE) ? null : 1;
        if (obj != null) {
            this.f5300u.setText(R.string.hosSummary_withoutRestBreak);
            this.f5302w.setText(R.string.hosSummary_breakRemaining);
            m7631a(this.f5303x, f);
        } else {
            this.f5300u.setText(R.string.hosSummary_untilRestBreak);
            this.f5302w.setText(R.string.hosSummary_breakMinimum);
            this.f5303x.setText(aq.m4232d(f.m4403c()));
            this.f5303x.setTextColor(getResources().getColorStateList(R.color.duty_status_warn));
        }
        m7631a(this.f5301v, dutyLimits.m4366b());
    }

    private void m7639b(DutyLimits dutyLimits) {
        if (dutyLimits.m4377m().m4402b() <= 0) {
            this.f5260G.setVisibility(8);
            this.f5261H.setVisibility(0);
        } else {
            this.f5260G.setVisibility(0);
            this.f5261H.setVisibility(8);
        }
        this.f5256C.setText("");
        switch (dutyLimits.m4376l()) {
            case OFF_DUTY_OR_SLEEPER:
                this.f5256C.setText(R.string.hosSummary_splitSleeperDutyStatusEither);
                break;
            case SLEEPER_ONLY:
                this.f5256C.setText(R.string.hosSummary_splitSleeperDutyStatusSleeper);
                break;
        }
        m7638b(this.f5257D, dutyLimits.m4377m());
        m7631a(this.f5258E, dutyLimits.m4378n());
        m7631a(this.f5259F, dutyLimits.m4379o());
    }

    private void m7631a(TextView textView, TimeWindow timeWindow) {
        textView.setText(aq.m4232d(timeWindow.m4402b()));
        C2462j.m12110a(getResources(), textView, timeWindow);
    }

    private void m7638b(TextView textView, TimeWindow timeWindow) {
        StringBuilder stringBuilder = new StringBuilder();
        if (timeWindow.m4402b() <= 0) {
            stringBuilder.append(getString(R.string.hosSummary_resetComplete));
        } else {
            Calendar b = aq.m4227b(this.f5270Q.m4879m());
            Calendar m = this.f5270Q.m4879m();
            m.add(14, (int) timeWindow.m4402b());
            aq.m4227b(m);
            Calendar m2 = this.f5270Q.m4879m();
            m2.add(14, (int) timeWindow.m4402b());
            if (b.equals(m)) {
                stringBuilder.append(getString(R.string.hosSummary_resetToday));
            } else {
                b.add(5, 1);
                if (b.equals(m)) {
                    stringBuilder.append(getString(R.string.hosSummary_resetTomorrow));
                } else {
                    stringBuilder.append(android.text.format.DateFormat.format("E MMM d", m2));
                }
            }
            stringBuilder.append(", ").append(m7630a(m2));
        }
        textView.setText(stringBuilder.toString());
        C2462j.m12110a(getResources(), textView, timeWindow);
    }

    private void m7658n() {
        Resources resources = getResources();
        List<Dvir> a = this.f5282c.m10973a(m7647i());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hosSummary_dvirIndent);
        SortedMap treeMap = new TreeMap();
        Set hashSet = new HashSet();
        for (Dvir inspectionList : a) {
            for (DvirInspection dvirInspection : inspectionList.getInspectionList()) {
                long occurredAt = dvirInspection.getOccurredAt();
                List list = (List) treeMap.get(Long.valueOf(occurredAt));
                if (list == null) {
                    list = new ArrayList();
                    treeMap.put(Long.valueOf(occurredAt), list);
                }
                list.add(dvirInspection);
                if (dvirInspection.getFoundDefects()) {
                    hashSet.add(C2186g.m10833a(dvirInspection));
                }
            }
        }
        Calendar m = this.f5270Q.m4879m();
        C2303v b = C2303v.m11257b(dimensionPixelSize);
        b.m11262a(getString(R.string.hosSummary_todaysInspections));
        for (List<DvirInspection> list2 : treeMap.values()) {
            Collections.sort(list2, C0854a.f2652c);
            m.setTimeInMillis(((DvirInspection) list2.get(0)).getOccurredAt());
            b.m11260a('\n').m11262a(m7630a(m)).m11260a(' ');
            Object obj = "";
            dimensionPixelSize = 1;
            for (DvirInspection dvirInspection2 : list2) {
                String a2 = ab.m11168a((Context) this, dvirInspection2.getVehicleType());
                if (dvirInspection2.hasVehicleNumber()) {
                    CharSequence charSequence = a2 + ' ' + dvirInspection2.getVehicleNumber();
                } else {
                    Object obj2 = a2;
                }
                if (!charSequence.equals(obj)) {
                    if (dimensionPixelSize == 0) {
                        b.m11268c(", ");
                    }
                    b.m11268c(charSequence);
                    obj = charSequence;
                    dimensionPixelSize = 0;
                }
            }
        }
        if (a.isEmpty()) {
            this.f5262I.setVisibility(8);
            this.f5263J.setText(R.string.hosSummary_noInspections);
            return;
        }
        this.f5262I.setVisibility(0);
        this.f5262I.setText(b.m11270e());
        if (hashSet.isEmpty()) {
            this.f5263J.setText(R.string.hosSummary_noVehicleDefects);
            return;
        }
        int size = hashSet.size();
        C2186g[] c2186gArr = (C2186g[]) hashSet.toArray(new C2186g[size]);
        Arrays.sort(c2186gArr, C2186g.f7576a);
        StringBuilder stringBuilder = new StringBuilder(size * 16);
        for (C2186g c2186g : c2186gArr) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(c2186g.m10837a((Context) this));
        }
        this.f5263J.setText(getString(R.string.hosSummary_vehicleDefects, new Object[]{stringBuilder.toString()}));
    }

    private void m7660o() {
        if (this.f5283d.m11296a() > 0) {
            this.f5264K.setVisibility(0);
            this.f5264K.setText(getString(R.string.hosSummary_numLogDaysWithWarnings, new Object[]{Integer.valueOf(r0)}));
            return;
        }
        this.f5264K.setVisibility(8);
    }

    private void m7662p() {
        if (this.f5280a.m10064n()) {
            int i = 0;
            for (Integer intValue : this.f5280a.m10062l().keySet()) {
                int i2;
                if (this.f5280a.m10036c(intValue.intValue()) > 0) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (i > 0) {
                this.f5265L.setText(getString(R.string.hosSummary_numLogDaysWithUnclaimedDriversEventsWarnings, new Object[]{Integer.valueOf(i)}));
                this.f5265L.setVisibility(0);
                return;
            }
            this.f5265L.setVisibility(8);
            return;
        }
        this.f5265L.setVisibility(8);
    }

    private void m7663q() {
        if (this.f5290k.m10536b() > 0) {
            this.f5266M.setVisibility(0);
            this.f5266M.setText(getString(R.string.hosSummary_numCorrectionSuggestions, new Object[]{Integer.valueOf(r0)}));
            return;
        }
        this.f5266M.setVisibility(8);
    }

    public void mo930f() {
        this.f5269P.setVisibility(8);
        this.f5264K.setEnabled(true);
        this.f5265L.setEnabled(true);
        this.f5266M.setEnabled(true);
        this.f5267N.setEnabled(true);
        this.f5268O.setEnabled(true);
        this.f5294o.m11973a(true);
        this.f5293n.m11933a(true);
    }

    public void mo974h() {
        this.f5269P.setVisibility(0);
        this.f5264K.setEnabled(false);
        this.f5265L.setEnabled(false);
        this.f5266M.setEnabled(false);
        this.f5267N.setEnabled(false);
        this.f5268O.setEnabled(false);
        this.f5294o.m11973a(false);
        this.f5293n.m11933a(false);
    }

    private void m7664r() {
        if (this.f5286g.m11413k()) {
            mo974h();
            this.f5271R = true;
            return;
        }
        mo930f();
        this.f5271R = false;
    }

    public void mo1008a(InspectionTerm inspectionTerm, TruckLogType truckLogType) {
        if (truckLogType == TruckLogType.AOBRD || truckLogType == TruckLogType.ELD) {
            C1632a.m7930a((Activity) this, inspectionTerm, truckLogType);
        } else {
            new InspectionTypeChooserDialogFragment().m8879a(this, inspectionTerm);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 26:
                if (intent != null && intent.hasExtra("com.bigroad.ttb.pendingDutyStatus")) {
                    DutyStatus a = DutyStatus.m4383a(intent.getIntExtra("com.bigroad.ttb.pendingDutyStatus", -1));
                    Truck f = this.f5285f.m6578f();
                    if (f == null || !f.getHasAobrd()) {
                        mo972e(a);
                        return;
                    }
                    return;
                }
                return;
            case 29:
                if (i2 == 7) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void mo1009a(InspectionOption inspectionOption, InspectionTerm inspectionTerm) {
        int a = DailyLogUtils.m4285a(this.f5270Q.m4868b());
        int a2 = a - (inspectionTerm.m4085a() - 1);
        switch (inspectionOption) {
            case VIEW_ON_SCREEN:
                C1632a.m7952a((Context) this, inspectionTerm, TruckLogType.ELECTRONIC, -1);
                finish();
                return;
            case PRINT:
                m6779a(a2, a);
                return;
            case SEND_EMAIL:
                C1632a.m7947a((Context) this, a2, a, DailyLogShareType.INSPECT_EMAIL_SHARE);
                return;
            case FAX:
                if (OurApplication.m6244A().m6111b() != Connectivity.CONNECTED) {
                    ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogFax_noConnectionTitle, (int) R.string.dailyLogFax_noConnection);
                    return;
                } else {
                    C1632a.m7946a((Context) this, a2, a);
                    return;
                }
            default:
                return;
        }
    }
}
