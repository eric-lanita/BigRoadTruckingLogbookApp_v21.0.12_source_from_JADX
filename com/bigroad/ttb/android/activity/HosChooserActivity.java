package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.C0586c.C0584a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0879c;
import com.bigroad.shared.duty.C0881d;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.C0960w;
import com.bigroad.shared.duty.C0962x;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.adapter.C1676j;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.model.DutyCycle;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.widget.OurSpinner;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.al;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class HosChooserActivity extends OurActivity {
    private OurSpinner f5221a;
    private RadioGroup f5222b;
    private CheckBox f5223c;
    private CheckBox f5224d;
    private CheckBox f5225e;
    private List<CheckBox> f5226f;
    private CheckBox f5227g;
    private CheckBox f5228h;
    private CheckBox f5229i;
    private CheckBox f5230j;
    private CheckBox f5231k;
    private Button f5232l;
    private C1676j f5233m;

    class C15111 implements OnCheckedChangeListener {
        final /* synthetic */ HosChooserActivity f5217a;

        C15111(HosChooserActivity hosChooserActivity) {
            this.f5217a = hosChooserActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                for (CheckBox checkBox : this.f5217a.f5226f) {
                    if (!compoundButton.equals(checkBox)) {
                        checkBox.setChecked(false);
                    }
                }
            }
        }
    }

    class C15122 implements OnClickListener {
        final /* synthetic */ HosChooserActivity f5218a;

        C15122(HosChooserActivity hosChooserActivity) {
            this.f5218a = hosChooserActivity;
        }

        public void onClick(View view) {
            this.f5218a.m7613i();
        }
    }

    public static class BigDayAlertDialogFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.hosChooser_bigDayTitle).m2672b((int) R.string.hosChooser_bigDayMessage).m2673b(17039360, C1843a.f6286a).m2677b();
        }

        public void m7601a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    public static class CalifornaFarmPassengerAlertDialogFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.hosChooser_californiaFarmPassengerTitle).m2672b((int) R.string.hosChooser_californiaFarmPassengerMessage).m2673b(17039360, C1843a.f6286a).m2677b();
        }

        public void m7602a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    public static class CalifornaMotionPictureAlertDialogFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.hosChooser_californiaMotionPictureTitle).m2672b((int) R.string.hosChooser_californiaMotionPictureMessage).m2673b(17039360, C1843a.f6286a).m2677b();
        }

        public void m7603a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    public static class ShortHaulOilfieldAlertDialogFragment extends DialogFragment {
        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.hosChooser_shortHaulOilfieldTitle).m2672b((int) R.string.hosChooser_shortHaulOilfieldMessage).m2673b(17039360, C1843a.f6286a).m2677b();
        }

        public void m7604a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    public static class TexasShortHaulAlertDialogFragment extends DialogFragment {

        class C15131 implements DialogInterface.OnClickListener {
            final /* synthetic */ TexasShortHaulAlertDialogFragment f5219a;

            C15131(TexasShortHaulAlertDialogFragment texasShortHaulAlertDialogFragment) {
                this.f5219a = texasShortHaulAlertDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f5219a.getActivity() instanceof HosChooserActivity) {
                    ((HosChooserActivity) this.f5219a.getActivity()).m7608a(true);
                }
            }
        }

        class C15142 implements DialogInterface.OnClickListener {
            final /* synthetic */ TexasShortHaulAlertDialogFragment f5220a;

            C15142(TexasShortHaulAlertDialogFragment texasShortHaulAlertDialogFragment) {
                this.f5220a = texasShortHaulAlertDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f5220a.getActivity() instanceof HosChooserActivity) {
                    HosChooserActivity hosChooserActivity = (HosChooserActivity) this.f5220a.getActivity();
                    hosChooserActivity.f5231k.setChecked(true);
                    hosChooserActivity.m7613i();
                }
            }
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.hosChooser_texasAirMileConfusionTitle).m2672b((int) R.string.hosChooser_texasAirMileConfusionMessage).m2661a((int) R.string.yes, new C15142(this)).m2673b((int) R.string.no, new C15131(this)).m2677b();
        }

        public void m7605a(FragmentActivity fragmentActivity) {
            show(fragmentActivity.getSupportFragmentManager(), getClass().getName());
        }
    }

    public HosChooserActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private int m7611f() {
        return getIntent().getIntExtra("com.bigroad.ttb.logDay", -1);
    }

    private void m7612h() {
        C0874m r;
        boolean z;
        boolean z2 = false;
        int f = m7611f();
        if (f < 0) {
            r = m6699R().m12228r();
        } else {
            al f2 = OurApplication.m6296r().m8491f(f);
            if (f2 != null) {
                r = new C0956v(f2);
            } else {
                r = m6699R().m12228r();
            }
        }
        this.f5221a.setNonUserSelection(this.f5233m.m8199a(DutyCycle.m10790a(r)));
        C0960w h = r.mo709h();
        C0962x i = r.mo710i();
        if (h.m4899b() || i.m4899b()) {
            z = true;
        } else {
            z = false;
        }
        this.f5222b.check(z ? R.id.hosChooser_passengerButton : R.id.hosChooser_propertyButton);
        if (h.m4910l() || i.m4910l()) {
            z = true;
        } else {
            z = false;
        }
        this.f5223c.setChecked(z);
        if (h.m4902d() || i.m4902d()) {
            z = true;
        } else {
            z = false;
        }
        this.f5224d.setChecked(z);
        if (h.m4903e() || i.m4903e()) {
            z = true;
        } else {
            z = false;
        }
        this.f5225e.setChecked(z);
        if (h.m4904f() || i.m4904f()) {
            z = true;
        } else {
            z = false;
        }
        this.f5227g.setChecked(z);
        if (h.m4911m() || i.m4911m()) {
            z = true;
        } else {
            z = false;
        }
        this.f5228h.setChecked(z);
        if (h.m4912n() || i.m4912n()) {
            z2 = true;
        }
        this.f5229i.setChecked(z2);
        for (CheckBox onCheckedChangeListener : this.f5226f) {
            onCheckedChangeListener.setOnCheckedChangeListener(new C15111(this));
        }
        this.f5230j.setChecked(i.m4908j());
        this.f5231k.setChecked(h.m4906h());
    }

    private void m7613i() {
        m7608a(false);
    }

    private void m7608a(boolean z) {
        DutyCycle dutyCycle;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        C1736b r = OurApplication.m6296r();
        Person l = m6699R().m12222l();
        DutyCycle dutyCycle2 = (DutyCycle) this.f5221a.getSelectedItem();
        if (dutyCycle2 == DutyCycle.ALASKAN_7DAY) {
            dutyCycle = DutyCycle.US_7DAY;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = true;
            z6 = false;
        } else if (dutyCycle2 == DutyCycle.ALASKAN_8DAY) {
            dutyCycle = DutyCycle.US_8DAY;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = true;
            z6 = false;
        } else if (dutyCycle2 == DutyCycle.CALIFORNIA_8DAY) {
            z2 = false;
            z3 = false;
            z4 = true;
            z6 = false;
            dutyCycle = DutyCycle.US_8DAY;
            z5 = false;
        } else if (dutyCycle2 == DutyCycle.CALIFORNIA_8DAY_FARM) {
            z2 = false;
            z3 = true;
            z6 = false;
            z5 = false;
            dutyCycle = DutyCycle.US_8DAY;
            z4 = false;
        } else if (dutyCycle2 == DutyCycle.TEXAS_7DAY) {
            z2 = true;
            z6 = false;
            z4 = false;
            z5 = false;
            dutyCycle = DutyCycle.US_7DAY;
            z3 = false;
        } else if (dutyCycle2 == DutyCycle.CANADIAN_NORTH_OF_60_CYCLE_1) {
            z6 = true;
            z3 = false;
            z4 = false;
            z5 = false;
            dutyCycle = DutyCycle.CANADIAN_CYCLE_1;
            z2 = false;
        } else if (dutyCycle2 == DutyCycle.CANADIAN_NORTH_OF_60_CYCLE_2) {
            z6 = true;
            z3 = false;
            z4 = false;
            z5 = false;
            dutyCycle = DutyCycle.CANADIAN_CYCLE_2;
            z2 = false;
        } else {
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            dutyCycle = dutyCycle2;
            z6 = false;
        }
        boolean z7 = this.f5222b.getCheckedRadioButtonId() == R.id.hosChooser_passengerButton;
        boolean isChecked = this.f5223c.isChecked();
        boolean isChecked2 = this.f5224d.isChecked();
        boolean isChecked3 = this.f5225e.isChecked();
        boolean isChecked4 = this.f5227g.isChecked();
        boolean isChecked5 = this.f5228h.isChecked();
        boolean isChecked6 = this.f5229i.isChecked();
        boolean isChecked7 = this.f5230j.isChecked();
        boolean isChecked8 = this.f5231k.isChecked();
        if (isChecked5 && (z7 || z5 || z4 || z3 || z2)) {
            new BigDayAlertDialogFragment().m7601a(this);
        } else if (isChecked3 && isChecked4) {
            new ShortHaulOilfieldAlertDialogFragment().m7604a(this);
        } else if (!z && z2 && isChecked4 && !isChecked8) {
            new TexasShortHaulAlertDialogFragment().m7605a(this);
        } else if (z3 && z7) {
            new CalifornaFarmPassengerAlertDialogFragment().m7602a(this);
        } else if (z4 && isChecked6 && z7) {
            new CalifornaMotionPictureAlertDialogFragment().m7603a(this);
        } else {
            DailyLog b;
            C0960w a = C0960w.m4913a(l.getHosUs7DayCycleFlags()).m4887a(z7).m4889b(z5).m4890c(isChecked).m4891d(isChecked2).m4892e(isChecked3).m4893f(isChecked4).m4894g(z2).m4895h(isChecked8).m4896i(isChecked5).m4897j(isChecked6).m4888a();
            C0962x a2 = C0962x.m4926a(l.getHosUs8DayCycleFlags()).m4914a(z7).m4916b(z5).m4917c(isChecked).m4918d(isChecked2).m4919e(isChecked3).m4920f(isChecked4).m4921g(z4).m4922h(isChecked7).m4923i(z3).m4924j(isChecked5).m4925k(isChecked6).m4915a();
            C0879c a3 = C0879c.m4440b(l.getHosCanadianCycle1Flags()).m4438a(z6).m4439a();
            C0881d a4 = C0881d.m4443b(l.getHosCanadianCycle2Flags()).m4441a(z6).m4442a();
            int f = m7611f();
            if (f < 0) {
                OurApplication.m6289k().m6473a(Person.newBuilder().m14718a(l.getPersonId()).m14731c("").m14728b(dutyCycle == DutyCycle.US_7DAY).m14724a(dutyCycle == DutyCycle.US_8DAY).m14732c(dutyCycle == DutyCycle.CANADIAN_CYCLE_1).m14737d(dutyCycle == DutyCycle.CANADIAN_CYCLE_2).m14730c(a.m4898a()).m14726b(a2.m4898a()).m14735d(a3.m4435a()).m14739e(a4.m4435a()).m14733c());
                b = r.m8480b(DailyLogUtils.m4285a(TimeZone.getTimeZone(l.getHosHomeTimezoneId())));
            } else {
                b = r.m8480b(f);
            }
            if (!(b == null || C2292l.m11231a(b))) {
                r.m8484b(DailyLog.newBuilder(b).m13062b(dutyCycle == DutyCycle.US_7DAY).m13054a(dutyCycle == DutyCycle.US_8DAY).m13068c(dutyCycle == DutyCycle.CANADIAN_CYCLE_1).m13074d(dutyCycle == DutyCycle.CANADIAN_CYCLE_2).m13065c(a.m4898a()).m13057b(a2.m4898a()).m13072d(a3.m4435a()).m13077e(a4.m4435a()).m13069c());
            }
            setResult(-1);
            finish();
        }
    }

    public void onBackPressed() {
        m7613i();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.hos_chooser);
        m6692K().setStatusMessageVisible(false);
        this.f5221a = (OurSpinner) findViewById(R.id.cycle_spinner);
        this.f5222b = (RadioGroup) findViewById(R.id.hosChooser_vehicleTypeGroup);
        this.f5223c = (CheckBox) findViewById(R.id.hosChooser_restBreakExempt);
        this.f5224d = (CheckBox) findViewById(R.id.hosChooser_24HrReset);
        this.f5225e = (CheckBox) findViewById(R.id.hosChooser_oilfieldSpecialist);
        this.f5227g = (CheckBox) findViewById(R.id.hosChooser_100AirMileShortHaul);
        this.f5228h = (CheckBox) findViewById(R.id.hosChooser_bigDay);
        this.f5229i = (CheckBox) findViewById(R.id.hosChooser_motionPicture);
        this.f5226f = new ArrayList();
        this.f5226f.add(this.f5227g);
        this.f5226f.add(this.f5228h);
        this.f5226f.add(this.f5229i);
        this.f5230j = (CheckBox) findViewById(R.id.hosChooser_california500Gallon);
        this.f5231k = (CheckBox) findViewById(R.id.hosChooser_texas150AirMileShortHaul);
        this.f5232l = (Button) findViewById(R.id.hosChooser_done);
        this.f5233m = new C1676j(this, false);
        this.f5221a.setAdapter(this.f5233m);
        this.f5232l.setOnClickListener(new C15122(this));
        if (bundle == null) {
            m7612h();
        }
    }
}
