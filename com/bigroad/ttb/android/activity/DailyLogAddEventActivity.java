package com.bigroad.ttb.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.DutyStatusEventMerger;
import com.bigroad.shared.DutyStatusEventMerger.Policy;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.DailyLogEventBaseActivity.SignedAlertDialogFragment;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.dialog.ConfirmSelectTruckDialogFragment;
import com.bigroad.ttb.android.dialog.ConfirmSelectTruckDialogFragment.C1357a;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.fragment.LocationLookupEditText;
import com.bigroad.ttb.android.location.Location;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeLocation;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.Calendar;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class DailyLogAddEventActivity extends DailyLogEventBaseActivity implements C1357a {
    private static final String aa = DailyLogAddEventActivity.class.getName();
    private static final String ab = (aa + ".startTime");
    private static final String ac = (aa + ".isRealTime");
    private static final String ad = (aa + ".addingEldEvent");
    private final TruckManager ae = OurApplication.m6294p();
    private final VehicleConnectionManager af = OurApplication.m6252I();
    private final ap ag = OurApplication.m6269Z();
    private long ah;
    private boolean ai;
    private final ChangeListener aj = new C13491(this);

    class C13491 extends C1201a {
        final /* synthetic */ DailyLogAddEventActivity f4565a;

        C13491(DailyLogAddEventActivity dailyLogAddEventActivity) {
            this.f4565a = dailyLogAddEventActivity;
        }

        public void mo891a(MotionType motionType) {
            if (motionType == MotionType.MOVING) {
                this.f4565a.finish();
            }
        }
    }

    class C13502 implements OnClickListener {
        final /* synthetic */ DailyLogAddEventActivity f4566a;

        C13502(DailyLogAddEventActivity dailyLogAddEventActivity) {
            this.f4566a = dailyLogAddEventActivity;
        }

        public void onClick(View view) {
            this.f4566a.setResult(0);
            this.f4566a.finish();
        }
    }

    class C13513 implements OnClickListener {
        final /* synthetic */ DailyLogAddEventActivity f4567a;

        C13513(DailyLogAddEventActivity dailyLogAddEventActivity) {
            this.f4567a = dailyLogAddEventActivity;
        }

        public void onClick(View view) {
            this.f4567a.m6996Z();
        }
    }

    class C13524 implements Runnable {
        final /* synthetic */ DailyLogAddEventActivity f4568a;

        C13524(DailyLogAddEventActivity dailyLogAddEventActivity) {
            this.f4568a = dailyLogAddEventActivity;
        }

        public void run() {
            this.f4568a.m6948F();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.ah = bundle.getLong(ab);
            this.ai = bundle.getBoolean(ac);
        } else {
            this.ah = getIntent().getLongExtra("com.bigroad.ttb.eventStart", m6943A().getTimeInMillis());
            this.ai = getIntent().getBooleanExtra("com.bigroad.ttb.isRealTime", false);
            getIntent().putExtra("com.bigroad.ttb.useCurrentLoc", this.ai);
        }
        setContentView((int) R.layout.daily_log_add);
        m6988v();
        if (e_()) {
            setTitle(getString(R.string.dailyLogAdd_realTimeTitle));
        } else {
            setTitle(getString(R.string.dailyLogAdd_title, new Object[]{C1738c.m8514c(a_())}));
        }
        ((Button) findViewById(R.id.dailyLogAdd_cancel)).setOnClickListener(new C13502(this));
        this.Q = (Button) findViewById(R.id.dailyLogAdd_add);
        this.Q.setOnClickListener(new C13513(this));
        this.M.setNextFocusDownId(R.id.dailyLogAdd_add);
        this.T = -1;
        this.U = -1;
        FailReason o = mo975o();
        if (o != null) {
            setResult(o.m7160a());
            finish();
        }
        if (this.n.isEnabled()) {
            this.n.requestFocus();
        } else if (this.s.isEnabled()) {
            this.s.requestFocus();
        }
        this.af.m11399a(this.aj);
        if (e_()) {
            m6709a(0, 60000, new C13524(this));
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong(ab, this.ah);
        bundle.putBoolean(ac, this.ai);
    }

    protected void onDestroy() {
        this.af.m11404b(this.aj);
        super.onDestroy();
    }

    public Calendar mo930f() {
        Calendar instance = Calendar.getInstance(this.S);
        if (e_()) {
            this.ah = this.ag.mo914b();
        }
        instance.setTimeInMillis(this.ah);
        return instance;
    }

    protected boolean mo973g() {
        return this.ai;
    }

    protected boolean e_() {
        return this.ai;
    }

    protected boolean mo961i() {
        return false;
    }

    protected boolean mo967a(DutyStatus dutyStatus) {
        return (this.af.m11405c() && dutyStatus.m4397e()) ? false : true;
    }

    protected Policy mo962j() {
        return Policy.PROTECT_IMMUTABLE_SEGMENTS;
    }

    protected boolean mo963k() {
        return super.mo963k() && this.ai;
    }

    protected Event mo931l() {
        return aa();
    }

    protected void mo966a(Calendar calendar) {
        this.ah = calendar.getTimeInMillis();
        mo975o();
        if (this.Z != null) {
            this.Z.m12102b();
        }
    }

    protected void mo965a(C0890f c0890f) {
        super.mo965a(c0890f);
        if (c0890f != null) {
            this.ah = c0890f.mo721a();
        }
    }

    protected void mo969b(DutyStatus dutyStatus) {
        mo975o();
    }

    protected boolean mo932m() {
        return !this.ai;
    }

    private List<DailyLog> m6998b(Event event) {
        if (event == null || !this.V) {
            return Collections.emptyList();
        }
        return m6951I();
    }

    private void m6996Z() {
        Event aa = aa();
        if (aa != null) {
            List b = m6998b(aa);
            if (b.isEmpty()) {
                m7000d(aa);
            } else if (m6968b(b)) {
                ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogEdit_addEventTitle, (int) R.string.dailyLogEdit_correctionAffectedMessage);
            } else if (m6962a(b)) {
                ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogEdit_addEventTitle, (int) R.string.dailyLogEdit_aobrdLogsAffectedMessage);
            } else {
                new SignedAlertDialogFragment().m7161a(this);
            }
        }
    }

    private void m6999c(Event event) {
        DutyStatusEventMerger dutyStatusEventMerger = new DutyStatusEventMerger(mo962j(), this.b.m10061k().mo822a(a_(), m6985s()), a_(), m6985s(), this.ag.mo914b());
        dutyStatusEventMerger.m4060a(event, this.T);
        m6955a(dutyStatusEventMerger);
    }

    private void m7000d(Event event) {
        DutyStatus a = DutyStatus.m4384a(event);
        if (a.m4397e() && this.ae.m6578f() == null) {
            Event h = this.b.m10056h();
            if (h != null && h.getOccurredAt() < event.getOccurredAt() && event.getOccurredAt() < this.ag.mo914b()) {
                ConfirmSelectTruckDialogFragment.m8828a(this, a);
                return;
            }
        }
        this.d.m8374a(this.M, 5);
        if (e_() && this.af.m11411i()) {
            this.b.m10021a(this.af.m11412j(), a, event.getLocationName(), event.getNotes());
        } else {
            m6999c(event);
        }
        setResult(-1, new Intent().putExtra("com.bigroad.ttb.eventId", event.getEventId().m19091d()));
        finish();
    }

    public void mo970c(DutyStatus dutyStatus) {
        C1632a.m7963a((OurActivity) this, EnumSet.of(Option.ALLOW_UNKNOWN_TRUCK), dutyStatus);
    }

    public void mo971d(DutyStatus dutyStatus) {
        mo972e(dutyStatus);
    }

    public void mo972e(DutyStatus dutyStatus) {
        Event aa = aa();
        if (aa != null) {
            this.d.m8374a(this.M, 5);
            m6999c(aa);
            setResult(-1, new Intent().putExtra("com.bigroad.ttb.eventId", aa.getEventId().m19091d()));
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 26:
                if (i2 != 1 && intent != null && intent.hasExtra("com.bigroad.ttb.pendingDutyStatus")) {
                    DutyStatus a = DutyStatus.m4383a(intent.getIntExtra("com.bigroad.ttb.pendingDutyStatus", -1));
                    Truck f = this.ae.m6578f();
                    if (f == null || !f.getHasAobrd()) {
                        mo972e(a);
                        return;
                    }
                    this.x.setSelection(DutyStatus.OFF_DUTY);
                    mo978p();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void mo933n() {
        Event aa = aa();
        if (aa != null) {
            List<DailyLog> b = m6998b(aa);
            if (m6962a((List) b)) {
                setResult(0);
                finish();
                return;
            }
            for (DailyLog logDay : b) {
                C2292l.m11227a(this.a.m8480b(logDay.getLogDay()), false, OurApplication.ac());
            }
            m7000d(aa);
        }
    }

    protected boolean mo968a(Event event) {
        if (!C1130o.m5712a(event) || LocationLookupEditText.m10355a((OurActivity) this, (int) R.id.dailyLogEdit_locationFragment) == null) {
            return false;
        }
        return true;
    }

    private String m7001e(Event event) {
        if (mo968a(event)) {
            return this.L.getText().toString();
        }
        return am.m4191b(LocationLookupEditText.m10365d(this, R.id.dailyLogEdit_locationFragment));
    }

    private Event aa() {
        Location b = LocationLookupEditText.m10362b((OurActivity) this, (int) R.id.dailyLogEdit_locationFragment);
        DutyStatus C = m6945C();
        if (C == null) {
            C2134e.m10682e("TT-DailyLogAddEventActivity", "Selected duty status was null");
            return null;
        }
        Event a;
        if (e_() && this.af.m11411i()) {
            a = C2022a.m10087a(C.m4392a(), null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(OurApplication.m6285g().m12202d()), mo930f().getTimeInMillis(), null, this.af.m11410h().m11542e(), Long.valueOf(DutyStatusChangeBits.m4033a(Reason.USER_SELECTED_ADD)), OurApplication.ac());
        } else {
            Long valueOf;
            long timeInMillis = mo930f().getTimeInMillis();
            if (e_()) {
                if (this.ae.m6578f() != null) {
                    valueOf = Long.valueOf(this.ae.m6578f().getTruckId());
                }
                valueOf = null;
            } else {
                Event c = this.b.m10037c(timeInMillis);
                if (c != null && c.hasTruckId()) {
                    valueOf = Long.valueOf(c.getTruckId());
                }
                valueOf = null;
            }
            a = Event.newBuilder(C2022a.m10096b(C.m4392a(), timeInMillis, OurApplication.m6285g().m12202d(), valueOf, b, DutyStatusChangeBits.m4034a(Reason.USER_SELECTED_ADD, C.m4392a()), OurApplication.ac())).m13862c();
        }
        if (a != null) {
            C2647a newBuilder = Event.newBuilder(a);
            String b2 = am.m4191b(this.M.getText().toString());
            if (!am.m4188a((CharSequence) b2)) {
                newBuilder.m13856b(b2);
            }
            boolean e = LocationLookupEditText.m10366e(this, R.id.dailyLogEdit_locationFragment);
            RelativeLocation a2 = LocationLookupEditText.m10355a((OurActivity) this, (int) R.id.dailyLogEdit_locationFragment);
            if (a2 != null) {
                newBuilder.m13845a(a2);
            } else {
                newBuilder.m13834K();
            }
            if (e) {
                newBuilder.m13886j(EventStatusMaskBits.m4080b(EventStatusMaskBits.m4074a(a.getStatusMask(), true), true));
            }
            String e2 = m7001e(a);
            if (!am.m4188a((CharSequence) e2)) {
                newBuilder.m13861c(e2);
            }
            a = newBuilder.m13862c();
        }
        return a;
    }
}
