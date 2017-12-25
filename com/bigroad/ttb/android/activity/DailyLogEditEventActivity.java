package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.DutyStatusEventMerger;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogEventBaseActivity.SignedAlertDialogFragment;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.EditMode;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.fragment.LocationLookupEditText;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class DailyLogEditEventActivity extends DailyLogEventBaseActivity {
    private static final String aa = DailyLogEditEventActivity.class.getName();
    private static final String ab = (aa + ".event");
    private static final String ac = (aa + ".originalOccurredAt");
    private Event ad;
    private long ae;
    private boolean af;
    private Button ag;

    class C13601 implements OnClickListener {
        final /* synthetic */ DailyLogEditEventActivity f4626a;

        C13601(DailyLogEditEventActivity dailyLogEditEventActivity) {
            this.f4626a = dailyLogEditEventActivity;
        }

        public void onClick(View view) {
            if (this.f4626a.ad != null) {
                this.f4626a.setResult(0, new Intent().putExtra("com.bigroad.ttb.eventId", this.f4626a.ad.getEventId().m19091d()));
            }
            this.f4626a.ad = null;
            this.f4626a.finish();
        }
    }

    class C13612 implements OnClickListener {
        final /* synthetic */ DailyLogEditEventActivity f4627a;

        C13612(DailyLogEditEventActivity dailyLogEditEventActivity) {
            this.f4627a = dailyLogEditEventActivity;
        }

        public void onClick(View view) {
            this.f4627a.m7028Z();
        }
    }

    class C13623 implements OnClickListener {
        final /* synthetic */ DailyLogEditEventActivity f4628a;

        C13623(DailyLogEditEventActivity dailyLogEditEventActivity) {
            this.f4628a = dailyLogEditEventActivity;
        }

        public void onClick(View view) {
            this.f4628a.ab();
        }
    }

    public static class DeleteAffectingSignedDaysDialogFragment extends DialogFragment {

        class C13631 implements DialogInterface.OnClickListener {
            final /* synthetic */ DeleteAffectingSignedDaysDialogFragment f4629a;

            C13631(DeleteAffectingSignedDaysDialogFragment deleteAffectingSignedDaysDialogFragment) {
                this.f4629a = deleteAffectingSignedDaysDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f4629a.getActivity() instanceof DailyLogEditEventActivity) {
                    ((DailyLogEditEventActivity) this.f4629a.getActivity()).aa();
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogEdit_deleteEventTitle).m2672b((int) R.string.dailyLogEdit_signedLogsDeleteMessage).m2670a(false).m2661a((int) R.string.dailyLogEdit_deleteButton, new C13631(this)).m2673b(17039360, C1843a.f6286a).m2677b();
        }

        public void m7026a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    public static class DeleteDialogFragment extends DialogFragment {

        class C13641 implements DialogInterface.OnClickListener {
            final /* synthetic */ DeleteDialogFragment f4630a;

            C13641(DeleteDialogFragment deleteDialogFragment) {
                this.f4630a = deleteDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f4630a.getActivity() instanceof DailyLogEditEventActivity) {
                    ((DailyLogEditEventActivity) this.f4630a.getActivity()).aa();
                }
                dialogInterface.dismiss();
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogEdit_deleteEventTitle).m2672b((int) R.string.dailyLogEdit_deleteMessage).m2670a(false).m2661a((int) R.string.dailyLogEdit_deleteButton, new C13641(this)).m2673b(17039360, C1843a.f6286a).m2677b();
        }

        public void m7027a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.daily_log_edit);
        if (bundle != null) {
            try {
                this.ad = bundle.containsKey(ab) ? Event.parseFrom(bundle.getByteArray(ab)) : null;
                if (bundle.containsKey(ac)) {
                    this.ae = bundle.getLong(ac);
                }
            } catch (InvalidProtocolBufferException e) {
            }
        }
        if (this.ad == null) {
            this.ad = this.b.m10005a(getIntent().getByteArrayExtra("com.bigroad.ttb.eventId"));
            if (this.ad != null) {
                this.ae = this.ad.getOccurredAt();
            }
        }
        if (this.ad == null) {
            setResult(4);
            finish();
            return;
        }
        m6988v();
        setTitle(getString(R.string.dailyLogEdit_title, new Object[]{C1738c.m8514c(a_())}));
        ((Button) findViewById(R.id.dailyLogEdit_cancel)).setOnClickListener(new C13601(this));
        this.ag = (Button) findViewById(R.id.dailyLogEdit_delete);
        this.ag.setOnClickListener(new C13612(this));
        this.Q = (Button) findViewById(R.id.dailyLogEdit_done);
        this.Q.setOnClickListener(new C13623(this));
        this.M.setNextFocusDownId(R.id.dailyLogEdit_done);
        if (!m6959a(bundle)) {
            m6989w();
        }
        this.af = getIntent().getBooleanExtra("com.bigroad.ttb.isFixing", false);
        if (this.af) {
            findViewById(R.id.dailyLogEdit_nextValidationText).setVisibility(0);
        }
        if (!mo973g()) {
            if (this.n.isEnabled()) {
                this.n.requestFocus();
            } else if (this.s.isEnabled()) {
                this.s.requestFocus();
            }
        }
        if (!mo961i() && DutyStatus.m4391c(mo931l()) && mo931l().getImmutableDutySegment()) {
            EditMode editMode = EditMode.EDIT_DRIVE_TIME_AOBRD;
            if (C1130o.m5712a(this.ad)) {
                editMode = EditMode.EDIT_DRIVE_TIME_ELD;
            }
            this.x.setEditMode(editMode);
        }
        FailReason o = mo975o();
        if (o != null) {
            setResult(o.m7160a());
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ad != null) {
            bundle.putByteArray(ab, this.ad.toByteArray());
        }
        bundle.putLong(ac, this.ae);
    }

    protected Calendar mo930f() {
        Calendar A = m6943A();
        if (this.ad != null) {
            A.setTimeInMillis(this.ad.getOccurredAt());
        }
        return A;
    }

    protected boolean mo973g() {
        return this.ad == null || m6947E().apply(this.ad) || this.af;
    }

    protected boolean mo932m() {
        return !m6987u();
    }

    protected boolean mo961i() {
        if (this.ad == null || m6987u()) {
            return true;
        }
        if (!DutyStatus.m4391c(this.ad)) {
            return false;
        }
        if (!this.ad.getImmutableDutySegment()) {
            return false;
        }
        if (this.ad.getEventType() != 5) {
            return false;
        }
        if (this.g.m6197c()) {
            return false;
        }
        if (C1130o.m5712a(this.ad) && this.i.m11019e()) {
            return false;
        }
        return true;
    }

    protected boolean mo967a(DutyStatus dutyStatus) {
        if (!DutyStatus.m4387b(this.ad.getEventType())) {
            return false;
        }
        DutyStatus a = DutyStatus.m4383a(this.ad.getEventType());
        if (this.ad.getImmutableDutySegment()) {
            return dutyStatus.m4397e();
        }
        TruckLogType a2 = this.h.m6557a(this.ad);
        if (a2 == TruckLogType.ELECTRONIC || a2 == TruckLogType.UNKNOWN_LOG_TYPE || a.m4397e() == dutyStatus.m4397e()) {
            return true;
        }
        return false;
    }

    protected boolean mo974h() {
        return (this.ad == null || m6947E().apply(this.ad) || m6946D() || m6986t()) ? false : true;
    }

    protected FailReason mo975o() {
        FailReason o = super.mo975o();
        if (o != null) {
            this.ad = null;
        }
        if (mo974h()) {
            this.ag.setVisibility(0);
        } else {
            this.ag.setVisibility(8);
        }
        return o;
    }

    protected Event mo931l() {
        return this.ad;
    }

    private void m7032a(C2647a c2647a) {
        m7033a(c2647a, false);
    }

    private void m7035b(C2647a c2647a) {
        m7033a(c2647a, true);
    }

    private void m7033a(C2647a c2647a, boolean z) {
        Long l = null;
        if (this.ad != null) {
            C2647a newBuilder = Event.newBuilder(this.ad);
            if (c2647a != null) {
                newBuilder.m13844a(c2647a.m13868d());
            }
            if (z) {
                newBuilder.m13886j(EventStatusMaskBits.m4071a(newBuilder.m13828E(), RecordOrigin.UNKNOWN));
                Long valueOf = newBuilder.m13892m() ? Long.valueOf(newBuilder.m13893n()) : null;
                if (newBuilder.getOccurredAt() != this.ae) {
                    Event a = this.b.m10004a(this.ad);
                    if (a != null && a.hasTruckId()) {
                        l = Long.valueOf(a.getTruckId());
                    }
                    newBuilder.m13835L().m13836M().m13837N().m13838O();
                } else {
                    l = valueOf;
                }
                if (l != null) {
                    C2022a.m10091a(newBuilder, l, OurApplication.ac());
                } else {
                    newBuilder.m13894o();
                }
            }
            String d = LocationLookupEditText.m10365d(this, R.id.dailyLogEdit_locationFragment);
            if (d != null) {
                newBuilder.m13861c(d);
                newBuilder.m13886j(EventStatusMaskBits.m4074a(newBuilder.m13828E(), false));
            }
            newBuilder.m13856b(this.M.getText().toString());
            newBuilder.m13903x().m13904y();
            if (DutyStatus.m4389b(this.ad)) {
                long contextualData;
                if (this.ad.hasContextualData()) {
                    contextualData = this.ad.getContextualData();
                } else {
                    contextualData = DutyStatusChangeBits.m4034a(Reason.USER_SELECTED_EDIT, EventType.m13979a(this.ad.getEventType()));
                }
                newBuilder.m13879g(DutyStatusChangeBits.m4035a(Long.valueOf(contextualData)));
            }
            this.ad = newBuilder.m13862c();
            this.T = m6963b(this.T);
        }
    }

    protected void mo965a(C0890f c0890f) {
        super.mo965a(c0890f);
        if (c0890f != null && this.ad != null && c0890f.mo721a() != this.ad.getOccurredAt()) {
            this.ad = Event.newBuilder(this.ad).m13859c(c0890f.mo721a()).m13862c();
            this.T = m6963b(this.T);
        }
    }

    public void mo966a(Calendar calendar) {
        m7032a(Event.newBuilder().m13859c(calendar.getTimeInMillis()));
        mo975o();
    }

    private List<DailyLog> m7031a(boolean z) {
        if (this.ad != null) {
            if (z) {
                DutyStatusEventMerger dutyStatusEventMerger = new DutyStatusEventMerger(mo962j(), this.b.m10061k().mo822a(a_(), m6985s()), a_(), m6985s(), this.e.mo914b());
                dutyStatusEventMerger.m4062b(this.ad);
                if (dutyStatusEventMerger.m4063c()) {
                    return m6951I();
                }
            } else if (this.V) {
                return m6951I();
            }
        }
        return Collections.emptyList();
    }

    private void m7028Z() {
        List a = m7031a(true);
        if (a.isEmpty()) {
            new DeleteDialogFragment().m7027a(this);
        } else if (m6968b(a)) {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogEdit_deleteEventTitle, (int) R.string.dailyLogEdit_correctionAffectedMessage);
        } else if (m6962a(a)) {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogEdit_deleteEventTitle, (int) R.string.dailyLogEdit_aobrdLogsAffectedMessage);
        } else {
            new DeleteAffectingSignedDaysDialogFragment().m7026a(this);
        }
    }

    private void aa() {
        if (this.ad != null) {
            DutyStatusEventMerger dutyStatusEventMerger = new DutyStatusEventMerger(mo962j(), this.b.m10061k().mo822a(a_(), m6985s()), a_(), m6985s(), this.e.mo914b());
            dutyStatusEventMerger.m4062b(this.ad);
            List emptyList = Collections.emptyList();
            if (dutyStatusEventMerger.m4063c()) {
                emptyList = m6951I();
            }
            if (!r0.isEmpty()) {
                if (m6962a((List) r0)) {
                    this.ad = null;
                    setResult(0);
                    finish();
                    return;
                }
                for (DailyLog logDay : r0) {
                    C2292l.m11227a(this.a.m8480b(logDay.getLogDay()), false, OurApplication.ac());
                }
            }
            m6955a(dutyStatusEventMerger);
            this.ad = null;
            setResult(3);
            finish();
        }
    }

    public void onBackPressed() {
        if (this.ad != null) {
            setResult(0, new Intent().putExtra("com.bigroad.ttb.eventId", this.ad.getEventId().m19091d()));
        }
        this.ad = null;
        finish();
    }

    private void ab() {
        List a = m7031a(false);
        if (a.isEmpty()) {
            ae();
        } else if (m6968b(a)) {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogEdit_save, (int) R.string.dailyLogEdit_correctionAffectedMessage);
        } else if (m6962a(a)) {
            ErrorDialogFragment.m8860a((OurActivity) this, (int) R.string.dailyLogEdit_save, (int) R.string.dailyLogEdit_aobrdLogsAffectedMessage);
        } else {
            new SignedAlertDialogFragment().m7161a(this);
        }
    }

    protected void mo933n() {
        List<DailyLog> a = m7031a(false);
        if (m6962a((List) a)) {
            this.ad = null;
            setResult(0);
            finish();
            return;
        }
        for (DailyLog logDay : a) {
            C2292l.m11227a(this.a.m8480b(logDay.getLogDay()), false, OurApplication.ac());
        }
        ae();
    }

    private void ac() {
        if (this.ad != null) {
            m7035b(null);
            if (m6987u()) {
                ad();
                return;
            }
            DutyStatusEventMerger dutyStatusEventMerger = new DutyStatusEventMerger(mo962j(), this.b.m10061k().mo822a(a_(), m6985s()), a_(), m6985s(), this.e.mo914b());
            dutyStatusEventMerger.m4060a(this.ad, this.T);
            m6955a(dutyStatusEventMerger);
        }
    }

    private void ad() {
        this.b.m10028b(new C1142r().m5746a(this.ad), this.ad.getOccurredAt());
    }

    private void ae() {
        this.d.m8374a(this.M, 5);
        m6984r();
        ac();
        if (this.ad != null) {
            setResult(-1, new Intent().putExtra("com.bigroad.ttb.eventId", this.ad.getEventId().m19091d()));
        }
        this.ad = null;
        finish();
    }

    protected void mo969b(DutyStatus dutyStatus) {
        if (dutyStatus != null) {
            m7032a(Event.newBuilder().m13842a(dutyStatus.m4394b()));
            mo975o();
        }
    }
}
