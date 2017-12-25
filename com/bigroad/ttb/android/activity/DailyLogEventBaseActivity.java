package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.C0195t;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.C0586c.C0584a;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.DutyStatusEventMerger;
import com.bigroad.shared.DutyStatusEventMerger.Policy;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.aa;
import com.bigroad.shared.ab;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.ao;
import com.bigroad.shared.ap;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0890f.C0886a;
import com.bigroad.shared.duty.C0901j;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.model.C1127k;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.shared.validation.C1157a;
import com.bigroad.shared.validation.C1164d;
import com.bigroad.shared.validation.C1167g;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.model.Event.Field;
import com.bigroad.shared.validation.p024b.C0888e;
import com.bigroad.shared.validation.p024b.C1161f.C1160a;
import com.bigroad.ttb.android.C2103j;
import com.bigroad.ttb.android.C2224p;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.DrivingModeManager;
import com.bigroad.ttb.android.DrivingModeManager.C1209a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.DutyStatusChoice;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.EditMode;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.dialog.EndTimePickerDialogFragment;
import com.bigroad.ttb.android.dialog.EndTimePickerDialogFragment.C1353a;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.dialog.ModalAlertDialogFragment;
import com.bigroad.ttb.android.dialog.ModalAlertDialogFragment.C1354a;
import com.bigroad.ttb.android.dialog.StartTimePickerDialogFragment;
import com.bigroad.ttb.android.dialog.StartTimePickerDialogFragment.C1355a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.fragment.LocationLookupEditText;
import com.bigroad.ttb.android.fragment.LocationLookupEditText.C1356a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p039h.C2085a;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.widget.C1386p;
import com.bigroad.ttb.android.widget.C2457g;
import com.bigroad.ttb.android.widget.C2458h;
import com.bigroad.ttb.android.widget.C2462j;
import com.bigroad.ttb.android.widget.C2469s;
import com.bigroad.ttb.android.widget.DailyLogGraphView;
import com.bigroad.ttb.android.widget.DutyStatusView;
import com.bigroad.ttb.android.widget.InstantAutoComplete;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.google.common.base.Predicate;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public abstract class DailyLogEventBaseActivity extends OurActivity implements C0906x, C1353a, C1354a, C1355a, C1356a {
    private static final String aa = DailyLogEventBaseActivity.class.getName();
    private static final String ab = (aa + ".movingAlert");
    private static final String ac = (aa + ".currentTz");
    private static final String ad = (aa + ".currentLogDay");
    private static final String ae = (aa + ".endTime");
    private static final String af = (aa + ".originalEndTime");
    protected TextView f4569A;
    protected TextView f4570B;
    protected TextView f4571C;
    protected View f4572D;
    protected TextView f4573E;
    protected View f4574F;
    protected TextView f4575G;
    protected View f4576H;
    protected TextView f4577I;
    protected View f4578J;
    protected LocationLookupEditText f4579K;
    protected InstantAutoComplete f4580L;
    protected InstantAutoComplete f4581M;
    protected TextView f4582N;
    protected ImageView f4583O;
    protected TextView f4584P;
    protected Button f4585Q;
    protected int f4586R;
    protected TimeZone f4587S;
    protected long f4588T;
    protected long f4589U;
    protected boolean f4590V;
    protected List<ab> f4591W = Collections.emptyList();
    protected boolean f4592X;
    protected ModalAlertDialogFragment f4593Y;
    protected C2457g f4594Z;
    protected final C1736b f4595a = OurApplication.m6296r();
    private final C1219a ag = new C13801(this);
    private final ChangeListener ah = new C13888(this);
    private final VehicleConnectionManager.ChangeListener ai = new C13899(this);
    private final C1209a aj = new C1209a(this) {
        final /* synthetic */ DailyLogEventBaseActivity f4711a;

        {
            this.f4711a = r1;
        }

        public void mo981a() {
            if (this.f4711a.f4618x != null) {
                this.f4711a.f4618x.m11932a();
            }
        }
    };
    protected final EventManager f4596b = OurApplication.m6295q();
    protected final VehicleConnectionManager f4597c = OurApplication.m6252I();
    protected final ai f4598d = OurApplication.m6256M();
    protected final ap f4599e = OurApplication.m6269Z();
    protected final C2103j f4600f = OurApplication.ae();
    protected final DrivingModeManager f4601g = OurApplication.ah();
    protected final TruckManager f4602h = OurApplication.m6294p();
    protected final C2230r f4603i = OurApplication.m6292n();
    protected DailyLogGraphView f4604j;
    protected List<C0890f> f4605k;
    protected TextView f4606l;
    protected TextView f4607m;
    protected EditText f4608n;
    protected ImageButton f4609o;
    protected ImageButton f4610p;
    protected View f4611q;
    protected View f4612r;
    protected EditText f4613s;
    protected ImageButton f4614t;
    protected ImageButton f4615u;
    protected View f4616v;
    protected TextView f4617w;
    protected DutyStatusView f4618x;
    protected TextView f4619y;
    protected View f4620z;

    class C13801 implements C1219a {
        final /* synthetic */ DailyLogEventBaseActivity f4717a;

        C13801(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4717a = dailyLogEventBaseActivity;
        }

        public void mo904a(C1736b c1736b) {
            this.f4717a.m6920Z();
        }
    }

    class C13812 implements OnClickListener {
        final /* synthetic */ DailyLogEventBaseActivity f4718a;

        C13812(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4718a = dailyLogEventBaseActivity;
        }

        public void onClick(View view) {
            StartTimePickerDialogFragment.m8904a(this.f4718a, this.f4718a.mo930f());
        }
    }

    class C13823 implements OnClickListener {
        final /* synthetic */ DailyLogEventBaseActivity f4719a;

        C13823(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4719a = dailyLogEventBaseActivity;
        }

        public void onClick(View view) {
            if (this.f4719a.m6936c(TimeAdjustment.BACKWARD)) {
                this.f4719a.m6937d(TimeAdjustment.BACKWARD);
            }
        }
    }

    class C13834 implements OnClickListener {
        final /* synthetic */ DailyLogEventBaseActivity f4720a;

        C13834(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4720a = dailyLogEventBaseActivity;
        }

        public void onClick(View view) {
            if (this.f4720a.m6936c(TimeAdjustment.FORWARD)) {
                this.f4720a.m6937d(TimeAdjustment.FORWARD);
            }
        }
    }

    class C13845 implements OnTouchListener {
        final /* synthetic */ DailyLogEventBaseActivity f4721a;

        C13845(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4721a = dailyLogEventBaseActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 1) {
                return false;
            }
            view.requestFocus();
            EndTimePickerDialogFragment.m8857a(this.f4721a, this.f4721a.m6992z());
            return true;
        }
    }

    class C13856 implements OnClickListener {
        final /* synthetic */ DailyLogEventBaseActivity f4722a;

        C13856(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4722a = dailyLogEventBaseActivity;
        }

        public void onClick(View view) {
            EndTimePickerDialogFragment.m8857a(this.f4722a, this.f4722a.m6992z());
        }
    }

    class C13877 implements C1386p {
        final /* synthetic */ DailyLogEventBaseActivity f4723a;

        C13877(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4723a = dailyLogEventBaseActivity;
        }

        public boolean mo982a(DutyStatusChoice dutyStatusChoice) {
            DutyStatus a = dutyStatusChoice.m8045a();
            if (a != null) {
                if (this.f4723a.mo967a(a)) {
                    this.f4723a.mo969b(a);
                    return true;
                }
                int i = R.string.aobrdManualOffDutyDrivingAttempt_message;
                if (a == DutyStatus.DRIVING) {
                    i = R.string.aobrdManualDrivingAttempt_message;
                }
                ErrorDialogFragment.m8860a(this.f4723a, (int) R.string.aobrdManualDrivingAttempt_title, i);
            }
            return false;
        }
    }

    class C13888 extends C1199e {
        final /* synthetic */ DailyLogEventBaseActivity f4724a;

        C13888(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4724a = dailyLogEventBaseActivity;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f4724a.mo975o();
        }
    }

    class C13899 extends C1201a {
        final /* synthetic */ DailyLogEventBaseActivity f4725a;

        C13899(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4725a = dailyLogEventBaseActivity;
        }

        public void mo888a(C2338a c2338a) {
            this.f4725a.aa();
        }

        public void mo891a(MotionType motionType) {
            this.f4725a.ac();
        }
    }

    protected enum FailReason {
        NOT_FOUND(4),
        NO_FREE_SPACE(6);
        
        private final int m_activityResultCode;

        private FailReason(int i) {
            this.m_activityResultCode = i;
        }

        public int m7160a() {
            return this.m_activityResultCode;
        }
    }

    public static class SignedAlertDialogFragment extends DialogFragment {

        class C13901 implements DialogInterface.OnClickListener {
            final /* synthetic */ SignedAlertDialogFragment f4729a;

            C13901(SignedAlertDialogFragment signedAlertDialogFragment) {
                this.f4729a = signedAlertDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f4729a.getActivity() instanceof DailyLogEventBaseActivity) {
                    ((DailyLogEventBaseActivity) this.f4729a.getActivity()).mo933n();
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogEdit_save).m2672b((int) R.string.dailyLogEdit_signedLogsAffectedMessage).m2670a(false).m2661a((int) R.string.dailyLogEdit_saveButton, new C13901(this)).m2673b(17039360, C1843a.f6286a).m2677b();
        }

        public void m7161a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    private enum TimeAdjustment {
        FORWARD {
            public long mo983a(long j, long j2) {
                return aa.m4139b(j, j2) + j2;
            }
        },
        BACKWARD {
            public long mo983a(long j, long j2) {
                return aa.m4134a(j, j2) - j2;
            }
        };

        public abstract long mo983a(long j, long j2);
    }

    private class C1393a extends C0888e {
        static final /* synthetic */ boolean f4733a = (!DailyLogEventBaseActivity.class.desiredAssertionStatus());
        final /* synthetic */ DailyLogEventBaseActivity f4734b;

        private C1393a(DailyLogEventBaseActivity dailyLogEventBaseActivity) {
            this.f4734b = dailyLogEventBaseActivity;
        }

        public String mo724t() {
            return LocationLookupEditText.m10365d(this.f4734b, R.id.dailyLogEdit_locationFragment);
        }

        public String mo725u() {
            return this.f4734b.f4581M.getText().toString();
        }

        public boolean mo726y() {
            return false;
        }

        public DutyStatus mo702m() {
            DutyStatusChoice selection = this.f4734b.f4618x.getSelection();
            if (f4733a || (selection != null && selection.m8045a() != null)) {
                return selection.m8045a();
            }
            throw new AssertionError();
        }
    }

    protected abstract void mo966a(Calendar calendar);

    protected abstract boolean mo967a(DutyStatus dutyStatus);

    protected abstract void mo969b(DutyStatus dutyStatus);

    protected abstract Calendar mo930f();

    protected abstract boolean mo973g();

    protected abstract boolean mo961i();

    protected abstract Event mo931l();

    protected abstract boolean mo932m();

    protected abstract void mo933n();

    private void m6920Z() {
        al b = this.f4595a.m8480b(this.f4586R);
        C0956v r = b == null ? m6699R().m12228r() : new C0956v(b);
        this.f4604j.setHosSettings(r);
        this.f4618x.m11934a(C0901j.m4568a().m4564a(r).m4563a(this.f4618x.getSelection().m8045a()).m4566a(this.f4601g.m6197c()).m4567a());
    }

    private void aa() {
        this.f4618x.m11935a(this.f4597c.m11406d());
    }

    private boolean ab() {
        return !this.f4597c.m11413k();
    }

    private void ac() {
        if (ab() && this.f4593Y != null) {
            this.f4593Y.dismiss();
            this.f4593Y = null;
            mo975o();
        } else if (!ab() && this.f4593Y == null) {
            this.f4593Y = ModalAlertDialogFragment.m8893a(this, ab, R.string.dutyStatusDialog_cantEditDutyStatusTitle, R.string.dutyStatusDialog_cantEditDutyStatusMessage, R.string.dutyStatusDialog_cantEditDutyStatusAlertButton);
        }
    }

    public void mo964q() {
        if (this.f4593Y != null) {
            this.f4593Y.dismiss();
            this.f4593Y = null;
            mo975o();
        }
        finish();
    }

    public DailyLogEventBaseActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0956v r = m6699R().m12228r();
        this.f4588T = -1;
        this.f4589U = -1;
        if (bundle != null) {
            this.f4587S = TimeZone.getTimeZone(bundle.getString(ac));
            this.f4586R = bundle.getInt(ad);
        } else {
            this.f4586R = getIntent().getIntExtra("com.bigroad.ttb.logDay", DailyLogUtils.m4284a(r.m4879m()));
            DailyLog b = this.f4595a.m8480b(this.f4586R);
            this.f4587S = r.m4868b();
            if (b != null) {
                this.f4587S = DailyLogUtils.m4305b(b);
            }
        }
        this.f4593Y = (ModalAlertDialogFragment) getSupportFragmentManager().mo149a(ab);
    }

    protected void onStart() {
        super.onStart();
        am();
    }

    protected void onDestroy() {
        m6984r();
        super.onDestroy();
    }

    protected void m6984r() {
        this.f4596b.m10029b(this.ah);
        this.f4595a.m8483b(this.ag);
        this.f4597c.m11404b(this.ai);
        this.f4601g.m6195b(this.aj);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(ad, this.f4586R);
        bundle.putString(ac, this.f4587S.getID());
        bundle.putLong(ae, this.f4588T);
        bundle.putLong(af, this.f4589U);
    }

    public int a_() {
        return this.f4586R;
    }

    public TimeZone m6985s() {
        return this.f4587S;
    }

    protected boolean m6986t() {
        return C1130o.m5712a(mo931l());
    }

    protected boolean m6987u() {
        Event l = mo931l();
        if (l == null) {
            return false;
        }
        return C1130o.m5710a(l.getEventType());
    }

    protected void m6988v() {
        this.f4604j = (DailyLogGraphView) findViewById(R.id.dailyLogEdit_log);
        this.f4618x = (DutyStatusView) findViewById(R.id.dailyLogEdit_dutyStatus);
        this.f4618x.setEditMode(EditMode.ADD_OR_EDIT_EVENT);
        this.f4619y = (TextView) findViewById(R.id.dailyLogEdit_dutyStatusReadOnly);
        this.f4619y.setEnabled(false);
        this.f4606l = (TextView) findViewById(R.id.dailyLogEdit_occurredAtLabel);
        this.f4607m = (TextView) findViewById(R.id.dailyLogEdit_startLabel);
        this.f4608n = (EditText) findViewById(R.id.dailyLogEdit_start);
        this.f4609o = (ImageButton) findViewById(R.id.dailyLogEdit_adjustStartForward);
        this.f4610p = (ImageButton) findViewById(R.id.dailyLogEdit_adjustStartBackward);
        this.f4616v = findViewById(R.id.dailyLogEdit_durationRow);
        this.f4617w = (TextView) findViewById(R.id.dailyLogEdit_duration);
        this.f4611q = findViewById(R.id.dailyLogEdit_startRow);
        this.f4612r = findViewById(R.id.dailyLogEdit_endRow);
        this.f4613s = (EditText) findViewById(R.id.dailyLogEdit_end);
        this.f4614t = (ImageButton) findViewById(R.id.dailyLogEdit_adjustEndForward);
        this.f4615u = (ImageButton) findViewById(R.id.dailyLogEdit_adjustEndBackward);
        this.f4620z = findViewById(R.id.dailyLogEdit_odometerGroup);
        this.f4569A = (TextView) findViewById(R.id.dailyLogEdit_odometer);
        this.f4570B = (TextView) findViewById(R.id.dailyLogEdit_odometerUnit);
        this.f4571C = (TextView) findViewById(R.id.dailyLogEdit_accumulatedOdometer);
        this.f4572D = findViewById(R.id.dailyLogEdit_accumulatedOdometerRow);
        this.f4573E = (TextView) findViewById(R.id.dailyLogEdit_accumulatedOdometerUnit);
        this.f4574F = findViewById(R.id.dailyLogEdit_engineHoursGroup);
        this.f4575G = (TextView) findViewById(R.id.dailyLogEdit_engineHours);
        this.f4576H = findViewById(R.id.dailyLogEdit_engineHoursUnit);
        this.f4577I = (TextView) findViewById(R.id.dailyLogEdit_accumulatedEngineHours);
        this.f4578J = findViewById(R.id.dailyLogEdit_accumulatedEngineHoursRow);
        this.f4579K = (LocationLookupEditText) getSupportFragmentManager().mo148a((int) R.id.dailyLogEdit_locationFragment);
        this.f4580L = (InstantAutoComplete) findViewById(R.id.dailyLogEdit_locationReadOnly);
        this.f4581M = (InstantAutoComplete) findViewById(R.id.dailyLogEdit_note);
        this.f4582N = (TextView) findViewById(R.id.dailyLogEdit_noteErrorMessage);
        this.f4583O = (ImageView) findViewById(R.id.dailyLogEdit_noteErrorIcon);
        this.f4584P = (TextView) findViewById(R.id.dailyLogEdit_graphCaption);
        this.f4620z = findViewById(R.id.dailyLogEdit_odometerGroup);
        this.f4569A = (TextView) findViewById(R.id.dailyLogEdit_odometer);
        this.f4574F = findViewById(R.id.dailyLogEdit_engineHoursGroup);
        this.f4575G = (TextView) findViewById(R.id.dailyLogEdit_engineHours);
        findViewById(R.id.dailyLogEdit_scroll).setVerticalFadingEdgeEnabled(true);
        this.f4594Z = new C2457g(m6701T(), new Runnable(this) {
            final /* synthetic */ DailyLogEventBaseActivity f4712a;

            {
                this.f4712a = r1;
            }

            public void run() {
                this.f4712a.am();
            }
        }, 500);
        ad();
        ae();
        af();
        ag();
        this.f4595a.m8474a(this.ag);
        this.f4596b.m10012a(this.ah);
        this.f4597c.m11399a(this.ai);
        this.f4601g.m6190a(this.aj);
        aa();
        m6920Z();
    }

    private void ad() {
        this.f4581M.setAdapter(this.f4598d.m8372a((Context) this, 5));
        this.f4581M.addTextChangedListener(new C2458h(m6701T(), new Runnable(this) {
            final /* synthetic */ DailyLogEventBaseActivity f4713a;

            {
                this.f4713a = r1;
            }

            public void run() {
                this.f4713a.am();
            }
        }));
        this.f4583O.setVisibility(8);
        this.f4582N.setVisibility(8);
        ac.m11180a(this.f4581M, 60);
    }

    private void ae() {
        this.f4610p.setOnTouchListener(new C2469s(new OnClickListener(this) {
            final /* synthetic */ DailyLogEventBaseActivity f4714a;

            {
                this.f4714a = r1;
            }

            public void onClick(View view) {
                if (this.f4714a.m6929b(TimeAdjustment.BACKWARD)) {
                    this.f4714a.m6957a(TimeAdjustment.BACKWARD);
                }
            }
        }, 300));
        this.f4609o.setOnTouchListener(new C2469s(new OnClickListener(this) {
            final /* synthetic */ DailyLogEventBaseActivity f4715a;

            {
                this.f4715a = r1;
            }

            public void onClick(View view) {
                if (this.f4715a.m6929b(TimeAdjustment.FORWARD)) {
                    this.f4715a.m6957a(TimeAdjustment.FORWARD);
                }
            }
        }, 300));
        this.f4608n.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ DailyLogEventBaseActivity f4716a;

            {
                this.f4716a = r1;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() != 1) {
                    return false;
                }
                view.requestFocus();
                StartTimePickerDialogFragment.m8904a(this.f4716a, this.f4716a.mo930f());
                return true;
            }
        });
        this.f4608n.setOnClickListener(new C13812(this));
    }

    private void af() {
        this.f4615u.setOnTouchListener(new C2469s(new C13823(this), 300));
        this.f4614t.setOnTouchListener(new C2469s(new C13834(this), 300));
        this.f4613s.setOnTouchListener(new C13845(this));
        this.f4613s.setOnClickListener(new C13856(this));
    }

    private void ag() {
        this.f4618x.setOnDutyStatusSelectedListener(new C13877(this));
    }

    protected boolean m6959a(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(ae) || !bundle.containsKey(af)) {
            return false;
        }
        this.f4588T = bundle.getLong(ae);
        this.f4589U = bundle.getLong(af);
        return true;
    }

    protected void m6989w() {
        Event d = this.f4596b.m10044d(mo930f().getTimeInMillis());
        if (d == null || d.getOccurredAt() >= m6944B().getTimeInMillis()) {
            this.f4589U = -1;
        } else {
            this.f4589U = d.getOccurredAt();
        }
        this.f4588T = this.f4589U;
    }

    protected boolean m6990x() {
        return m6991y() && this.f4589U < m6944B().getTimeInMillis();
    }

    protected boolean m6991y() {
        return this.f4589U > 0;
    }

    protected Calendar m6992z() {
        if (m6991y()) {
            return m6969c(this.f4588T);
        }
        Calendar B = m6944B();
        if (m6986t()) {
            Calendar c = m6969c(aq.m4226b(this.f4599e.mo914b()));
            if (c.getTimeInMillis() < B.getTimeInMillis()) {
                return c;
            }
        }
        return B;
    }

    protected final Calendar m6943A() {
        return DailyLogUtils.m4298a(this.f4586R, this.f4587S);
    }

    protected final Calendar m6944B() {
        return DailyLogUtils.m4304b(this.f4586R, this.f4587S);
    }

    private boolean m6929b(TimeAdjustment timeAdjustment) {
        if (mo973g() || this.f4591W.isEmpty()) {
            return false;
        }
        Calendar f = mo930f();
        ab abVar;
        if (timeAdjustment != TimeAdjustment.FORWARD) {
            abVar = (ab) aq.m4215a(this.f4591W, f.getTimeInMillis());
            if (!m6991y() && abVar != null && abVar.m4145b()) {
                return true;
            }
            if (abVar == null || f.getTimeInMillis() <= abVar.mo697f()) {
                return false;
            }
            return true;
        } else if (m6991y() && f.getTimeInMillis() + 60000 >= m6992z().getTimeInMillis()) {
            return false;
        } else {
            abVar = (ab) aq.m4215a(this.f4591W, f.getTimeInMillis());
            if (!m6991y() && abVar != null && abVar.m4146c()) {
                return true;
            }
            boolean z;
            if (abVar == null || f.getTimeInMillis() + 60000 > abVar.mo698g()) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m6936c(TimeAdjustment timeAdjustment) {
        if (mo973g() || !m6990x() || this.f4591W.isEmpty()) {
            return false;
        }
        Calendar z = m6992z();
        if (timeAdjustment != TimeAdjustment.BACKWARD) {
            ao a = aq.m4215a(this.f4591W, z.getTimeInMillis());
            if (a == null || z.getTimeInMillis() > a.mo698g()) {
                return false;
            }
            return true;
        } else if (z.getTimeInMillis() - 60000 <= mo930f().getTimeInMillis()) {
            return false;
        } else {
            return true;
        }
    }

    protected Calendar m6953a(Calendar calendar, TimeAdjustment timeAdjustment) {
        long a = timeAdjustment.mo983a(calendar.getTimeInMillis(), 900000);
        Calendar a2 = aq.m4222a(calendar);
        a2.setTimeInMillis(a);
        return a2;
    }

    protected final void m6957a(TimeAdjustment timeAdjustment) {
        m6967b(m6953a(mo930f(), timeAdjustment), timeAdjustment);
    }

    protected void m6967b(Calendar calendar, TimeAdjustment timeAdjustment) {
        long j;
        Calendar f = mo930f();
        ab abVar = (ab) aq.m4215a(this.f4591W, f.getTimeInMillis());
        long min = Math.min(calendar.getTimeInMillis(), this.f4599e.mo914b());
        if (abVar == null) {
            j = min;
        } else if (timeAdjustment == TimeAdjustment.BACKWARD) {
            j = (!m6991y() && abVar.m4145b() && f.getTimeInMillis() == abVar.mo697f()) ? abVar.m4147d().mo698g() - 60000 : Math.max(min, abVar.mo697f());
        } else {
            long timeInMillis = m6992z().getTimeInMillis();
            j = min + 60000 >= timeInMillis ? timeInMillis - 60000 : (m6991y() || !abVar.m4146c() || f.getTimeInMillis() + 60000 < abVar.mo698g()) ? Math.min(min, abVar.mo698g() - 60000) : abVar.m4148e().mo697f();
        }
        calendar.setTimeInMillis(j);
        mo966a(calendar);
    }

    private void m6937d(TimeAdjustment timeAdjustment) {
        Calendar a = m6953a(m6992z(), timeAdjustment);
        a.setTimeInMillis(m6963b(a.getTimeInMillis()));
        m6966b(a);
    }

    protected long m6963b(long j) {
        if (j <= 0) {
            return j;
        }
        long min = Math.min(j, this.f4599e.mo914b());
        long timeInMillis = mo930f().getTimeInMillis();
        if (min - 60000 < timeInMillis) {
            min = timeInMillis + 60000;
        }
        return Math.min(min, m6944B().getTimeInMillis());
    }

    protected Calendar m6952a(int i, int i2) {
        Calendar A = m6943A();
        aq.m4223a(A, i, i2);
        return A;
    }

    protected Calendar m6969c(long j) {
        Calendar A = m6943A();
        A.setTimeInMillis(j);
        return A;
    }

    public void mo959b(int i, int i2) {
        Calendar f = mo930f();
        Calendar a = m6952a(i, i2);
        m6967b(a, f.getTimeInMillis() < a.getTimeInMillis() ? TimeAdjustment.FORWARD : TimeAdjustment.BACKWARD);
    }

    public void mo960c(int i, int i2) {
        Calendar B;
        if (i == 0 && i2 == 0) {
            B = m6944B();
        } else {
            B = m6952a(i, i2);
        }
        B.setTimeInMillis(m6963b(B.getTimeInMillis()));
        m6966b(B);
    }

    protected void m6966b(Calendar calendar) {
        this.f4588T = calendar.getTimeInMillis();
        mo975o();
    }

    protected final void m6973f(DutyStatus dutyStatus) {
        this.f4618x.setSelection(dutyStatus);
        this.f4619y.setText(C2224p.m10960c(this, dutyStatus));
    }

    protected final DutyStatus m6945C() {
        DutyStatusChoice selection = this.f4618x.getSelection();
        return selection != null ? selection.m8045a() : null;
    }

    protected boolean m6946D() {
        return this.f4592X;
    }

    private void m6921a(C0890f c0890f, List<Event> list) {
        if (c0890f == null) {
            this.f4592X = false;
            return;
        }
        byte[] s = c0890f.mo719s();
        Predicate E = m6947E();
        Iterator it = list.iterator();
        boolean z = false;
        Event event = it.hasNext() ? (Event) it.next() : null;
        while (event != null) {
            Event event2;
            if (it.hasNext()) {
                event2 = (Event) it.next();
            } else {
                event2 = null;
            }
            if (!Arrays.equals(event.getEventId().m19091d(), s)) {
                z = E.apply(event);
                event = event2;
            } else if (!z) {
                return;
            } else {
                if (event2 == null || E.apply(event2)) {
                    this.f4592X = true;
                    return;
                }
                return;
            }
        }
    }

    protected boolean mo963k() {
        return m6986t() && !f_();
    }

    protected Policy mo962j() {
        return Policy.PROTECT_ELD_AND_IMMUTABLE_SEGMENTS;
    }

    protected Predicate<Event> m6947E() {
        return DutyStatusEventMerger.m4045a(mo962j());
    }

    protected FailReason mo975o() {
        FailReason failReason;
        this.f4588T = m6963b(this.f4588T);
        Event l = mo931l();
        if (l == null) {
            failReason = null;
        } else if (m6987u()) {
            ah();
            failReason = null;
        } else {
            failReason = m6926b(l);
        }
        if (failReason == null) {
            return null;
        }
        if (failReason == FailReason.NOT_FOUND) {
            C2134e.m10682e("TT-DailyLogEventBaseActivity", "Unable to find matching displayed event in handleEventUpdate");
        }
        return failReason;
    }

    private FailReason m6926b(Event event) {
        DutyStatusEventMerger dutyStatusEventMerger = new DutyStatusEventMerger(mo962j(), this.f4596b.m10039c(), a_(), m6985s(), this.f4599e.mo914b());
        List a = dutyStatusEventMerger.m4060a(event, this.f4588T);
        this.f4591W = Collections.unmodifiableList(ab.m4144a(dutyStatusEventMerger.m4061b()));
        if (this.f4591W.isEmpty() && !mo973g()) {
            return FailReason.NO_FREE_SPACE;
        }
        this.f4605k = new C0886a(a, a_(), m6985s()).m4479a(this.f4599e.mo914b());
        C0890f a2 = DailyLogUtils.m4293a(this.f4605k, event.getEventId().m19091d());
        mo965a(a2);
        m6921a(a2, a);
        this.f4604j.m11849a(this.f4605k, m6931c(a));
        this.f4590V = dutyStatusEventMerger.m4063c();
        if (a2 != null) {
            m6973f(a2.mo702m());
            this.f4604j.setSelection(Long.valueOf(a2.m4522q()));
            mo976a(a2.m4514i());
        } else {
            mo976a(0);
        }
        mo978p();
        m6923a(mo961i());
        al();
        ak();
        aj();
        if (a2 == null) {
            return FailReason.NOT_FOUND;
        }
        return null;
    }

    private void ah() {
        List c = this.f4596b.m10039c();
        this.f4605k = new C0886a(c, a_(), m6985s()).m4479a(this.f4599e.mo914b());
        this.f4604j.m11849a(this.f4605k, m6931c(c));
        mo976a(0);
        mo978p();
        ai();
        al();
        ak();
        aj();
    }

    protected void mo965a(C0890f c0890f) {
        if (c0890f != null && m6991y()) {
            this.f4588T = c0890f.m4510e();
        }
    }

    private List<C1168m> m6931c(List<Event> list) {
        C1157a c2085a = new C2085a((List) list);
        com.bigroad.shared.validation.model.DailyLog a = new C1160a(a_()).m5901a();
        new C1164d(c2085a).m5930a(a, this.f4599e.mo914b());
        return a.mo716A().m5963c(Category.DRIVE_TIME);
    }

    private void ai() {
        m6923a(true);
        Event l = mo931l();
        CharSequence charSequence = "";
        if (l != null) {
            CharSequence a = C2462j.m12109a(getResources(), l);
            if (!am.m4188a(a)) {
                charSequence = a.toString();
            }
        }
        this.f4619y.setText(charSequence);
    }

    private void m6923a(boolean z) {
        int i;
        int i2 = 0;
        DutyStatusView dutyStatusView = this.f4618x;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        dutyStatusView.setVisibility(i);
        TextView textView = this.f4619y;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    protected void mo976a(long j) {
        boolean g = mo973g();
        m6928b(g);
        m6948F();
        if (!m6991y() || m6987u()) {
            this.f4612r.setVisibility(8);
        } else {
            m6935c(g);
            m6949G();
        }
        this.f4616v.setVisibility(8);
        if (mo932m()) {
            this.f4616v.setVisibility(0);
            m6971d(j);
        }
    }

    private void aj() {
        Event l = mo931l();
        if (l != null && l.hasNotes()) {
            this.f4581M.setText(l.getNotes());
        }
    }

    private void ak() {
        Event l = mo931l();
        if (l == null) {
            m6940d(false);
        } else if (mo968a(l)) {
            CharSequence b = C1127k.m5707b(l);
            if (am.m4188a(b)) {
                this.f4580L.setText(LocationLookupEditText.m10365d(this, R.id.dailyLogEdit_locationFragment));
            } else {
                this.f4580L.setText(b);
            }
            m6940d(true);
        } else {
            m6934c(l);
            m6940d(false);
        }
    }

    private void m6934c(Event event) {
        if (event != null && event.hasLocationName()) {
            LocationLookupEditText.m10357a(this, R.id.dailyLogEdit_locationFragment, event.getLocationName(), EventStatusMaskBits.m4082c(event.getStatusMask()));
        }
    }

    private void al() {
        String str = null;
        if (mo963k()) {
            String a;
            CharSequence charSequence;
            CharSequence string;
            this.f4620z.setVisibility(0);
            this.f4574F.setVisibility(0);
            Event l = mo931l();
            String str2 = "";
            String str3 = "";
            Object obj;
            Object obj2;
            if (l != null) {
                String num;
                a = CanonicalOdometerUnit.m5466a(af.m4151a(this.f4602h.m6552a(l.getTruckId()))).m5470a();
                if (l.hasOdometer()) {
                    num = Integer.toString(l.getOdometer());
                    str2 = a;
                } else {
                    num = null;
                }
                if (l.hasEngineCycleDistance()) {
                    str3 = Integer.toString(l.getEngineCycleDistance());
                    a = str3;
                    str3 = num;
                    charSequence = str2;
                    string = getResources().getString(R.string.dailyLogEdit_accumulatedOdometerUnit, new Object[]{a});
                } else {
                    a = null;
                    String str4 = str3;
                    str3 = num;
                    obj = str2;
                    obj2 = str4;
                }
            } else {
                a = null;
                obj = str2;
                obj2 = str3;
                str3 = null;
            }
            ac.m11182a(this.f4569A, str3);
            this.f4570B.setText(charSequence);
            if (str3 == null) {
                this.f4572D.setVisibility(8);
            } else {
                this.f4572D.setVisibility(0);
                ac.m11182a(this.f4571C, a);
                this.f4573E.setText(string);
            }
            if (l != null) {
                if (l.hasEngineTotalUptime()) {
                    str2 = DailyLogUtils.m4296a(Long.valueOf(l.getEngineTotalUptime()));
                } else {
                    str2 = null;
                }
                if (l.hasEngineCycleUptime()) {
                    str = DailyLogUtils.m4296a(Long.valueOf(l.getEngineCycleUptime()));
                }
            } else {
                str2 = null;
            }
            ac.m11182a(this.f4575G, str2);
            if (str2 == null) {
                this.f4578J.setVisibility(8);
                this.f4576H.setVisibility(8);
                return;
            }
            this.f4578J.setVisibility(0);
            this.f4576H.setVisibility(0);
            ac.m11182a(this.f4577I, str);
            return;
        }
        this.f4620z.setVisibility(8);
        this.f4574F.setVisibility(8);
    }

    protected void m6948F() {
        int i = 0;
        Calendar f = mo930f();
        this.f4610p.setVisibility(m6929b(TimeAdjustment.BACKWARD) ? 0 : 4);
        ImageButton imageButton = this.f4609o;
        if (!m6929b(TimeAdjustment.FORWARD)) {
            i = 4;
        }
        imageButton.setVisibility(i);
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(this);
        timeFormat.setTimeZone(f.getTimeZone());
        this.f4608n.setText(timeFormat.format(f.getTime()));
    }

    protected void m6949G() {
        int i = 0;
        Calendar z = m6992z();
        this.f4615u.setVisibility(m6936c(TimeAdjustment.BACKWARD) ? 0 : 4);
        ImageButton imageButton = this.f4614t;
        if (!m6936c(TimeAdjustment.FORWARD)) {
            i = 4;
        }
        imageButton.setVisibility(i);
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(this);
        timeFormat.setTimeZone(z.getTimeZone());
        this.f4613s.setText(timeFormat.format(z.getTime()));
    }

    protected void m6971d(long j) {
        this.f4617w.setText(ac.m11175a(j, getResources()));
    }

    protected void mo978p() {
        DailyLog b = this.f4595a.m8480b(this.f4586R);
        if (this.f4597c.m11405c()) {
            this.f4584P.setVisibility(0);
            this.f4584P.setText(R.string.dailyLogEdit_aobrdTruck);
        } else if (m6987u() || C1738c.m8511a(b, this.f4605k)) {
            this.f4584P.setVisibility(0);
            this.f4584P.setText(R.string.dailyLogEdit_aobrdLogDay);
        } else {
            this.f4584P.setVisibility(8);
        }
    }

    private void m6928b(boolean z) {
        boolean z2;
        int i;
        int i2 = 4;
        if (m6987u()) {
            this.f4606l.setVisibility(0);
            this.f4607m.setVisibility(8);
        } else {
            this.f4606l.setVisibility(8);
            this.f4607m.setVisibility(0);
        }
        EditText editText = this.f4608n;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        editText.setEnabled(z2);
        ImageButton imageButton = this.f4609o;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        imageButton.setVisibility(i);
        ImageButton imageButton2 = this.f4610p;
        if (!z) {
            i2 = 0;
        }
        imageButton2.setVisibility(i2);
    }

    private void m6935c(boolean z) {
        boolean z2;
        int i;
        int i2 = 4;
        this.f4612r.setVisibility(0);
        EditText editText = this.f4613s;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        editText.setEnabled(z2);
        ImageButton imageButton = this.f4614t;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        imageButton.setVisibility(i);
        ImageButton imageButton2 = this.f4615u;
        if (!z) {
            i2 = 0;
        }
        imageButton2.setVisibility(i2);
    }

    private void m6940d(boolean z) {
        int i = 0;
        if (!f_()) {
            boolean z2;
            if (z) {
                z2 = false;
            } else {
                z2 = true;
            }
            m6942e(z2);
            InstantAutoComplete instantAutoComplete = this.f4580L;
            if (!z) {
                i = 8;
            }
            instantAutoComplete.setVisibility(i);
        }
    }

    private void m6942e(boolean z) {
        C0195t a = getSupportFragmentManager().mo150a();
        if (z) {
            a.mo146c(this.f4579K);
        } else {
            a.mo145b(this.f4579K);
        }
        a.mo138a();
    }

    public void mo958H() {
        if (this.f4594Z != null) {
            this.f4594Z.m12102b();
        }
    }

    private void am() {
        int size;
        boolean z = false;
        Object c1393a = new C1393a();
        C1167g.m5936b(c1393a, new C2085a(), a_());
        C1176p A = c1393a.mo716A();
        List b = A.m5961b(Field.LOCATION_NAME);
        List b2 = A.m5961b(Field.EVENT_NOTE);
        if (this.f4580L.getVisibility() == 8) {
            m6939d(b);
            size = b.size() + 0;
        } else {
            size = 0;
        }
        if (C1130o.m5712a(mo931l())) {
            m6941e(b2);
            size += b2.size();
        } else {
            m6941e(null);
        }
        if (this.f4585Q != null) {
            Button button = this.f4585Q;
            if (size == 0) {
                z = true;
            }
            ac.m11178a(button, z);
        }
    }

    private void m6939d(List<ValidationError> list) {
        LocationLookupEditText.m10358a((OurActivity) this, (int) R.id.dailyLogEdit_locationFragment, (List) list);
    }

    private void m6941e(List<ValidationError> list) {
        C2091e.m10477a(list, this.f4583O, this.f4582N, this);
    }

    protected void m6955a(DutyStatusEventMerger dutyStatusEventMerger) {
        this.f4596b.m10028b(dutyStatusEventMerger.m4058a(), m6943A().getTimeInMillis());
    }

    protected boolean m6962a(List<DailyLog> list) {
        for (DailyLog dailyLog : list) {
            if (C1738c.m8517f(dailyLog) || dailyLog.getAutoDailyLogTruckCount() > 0) {
                return true;
            }
            if (C0890f.m4502a(new C0886a(this.f4596b.m10061k(), dailyLog.getLogDay(), DailyLogUtils.m4305b(dailyLog)).m4479a(this.f4599e.mo914b()))) {
                return true;
            }
        }
        return false;
    }

    protected boolean m6968b(List<DailyLog> list) {
        for (DailyLog logDay : list) {
            if (this.f4600f.m10540c(logDay.getLogDay())) {
                return true;
            }
        }
        return false;
    }

    protected List<DailyLog> m6951I() {
        List<DailyLog> arrayList = new ArrayList();
        Event d = this.f4596b.m10044d(m6944B().getTimeInMillis() - 1);
        Long valueOf = d != null ? Long.valueOf(d.getOccurredAt()) : null;
        for (int a_ = a_(); a_ <= this.f4595a.m8485c(); a_++) {
            DailyLog b = this.f4595a.m8480b(a_);
            if (valueOf != null) {
                long timeInMillis = C1738c.m8509a(a_, b).getTimeInMillis();
                if (valueOf.longValue() < timeInMillis) {
                    break;
                } else if (timeInMillis != valueOf.longValue()) {
                    if (m6925a(b)) {
                        arrayList.add(b);
                    } else if (C2292l.m11231a(b)) {
                        arrayList.add(b);
                    }
                }
            } else if (C2292l.m11231a(b)) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    private boolean m6925a(DailyLog dailyLog) {
        return dailyLog != null && this.f4600f.m10540c(dailyLog.getLogDay());
    }

    protected boolean mo968a(Event event) {
        return C1130o.m5712a(event) && event.hasRelativeLocation();
    }

    protected boolean f_() {
        return false;
    }
}
