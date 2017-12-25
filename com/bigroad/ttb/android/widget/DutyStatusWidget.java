package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0901j;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.TimeWindow;
import com.bigroad.shared.duty.TimeWindow.Condition;
import com.bigroad.shared.duty.UpcomingDutyLimit;
import com.bigroad.ttb.android.C2188n;
import com.bigroad.ttb.android.DrivingModeManager.C1209a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.DutyStatusChoice;
import com.bigroad.ttb.android.adapter.DutyStatusAdapter.Option;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.widget.OurSpinner.C1435a;
import com.bigroad.ttb.android.widget.OurSpinner.C1471b;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import java.util.EnumSet;
import java.util.Locale;

public class DutyStatusWidget extends RelativeLayout {
    private OurSpinner f8542a;
    private AnnulusImageView f8543b;
    private TextView f8544c;
    private TextView f8545d;
    private TextView f8546e;
    private TextView f8547f;
    private TextView f8548g;
    private boolean f8549h = false;
    private ImageView f8550i;
    private boolean f8551j = false;
    private DutyLimits f8552k = null;
    private DutyStatus f8553l = DutyStatus.OFF_DUTY;
    private DutyStatusAdapter f8554m;
    private C1386p f8555n;

    class C24241 implements C1435a {
        final /* synthetic */ DutyStatusWidget f8538a;

        C24241(DutyStatusWidget dutyStatusWidget) {
            this.f8538a = dutyStatusWidget;
        }

        public void mo995a(int i) {
            if (i != -1) {
                DutyStatusChoice b = this.f8538a.f8554m.m8079b(i);
                if (b != null) {
                    Object obj = (this.f8538a.f8555n == null || this.f8538a.f8555n.mo982a(b)) ? 1 : null;
                    if (obj != null) {
                        this.f8538a.f8554m.m8080b(b.m8045a());
                    }
                    if (obj == null || b.m8046b()) {
                        this.f8538a.f8554m.m8076a(this.f8538a.f8542a);
                    }
                }
            }
        }
    }

    class C24252 implements C1209a {
        final /* synthetic */ DutyStatusWidget f8539a;

        C24252(DutyStatusWidget dutyStatusWidget) {
            this.f8539a = dutyStatusWidget;
        }

        public void mo981a() {
            this.f8539a.m11943b();
        }
    }

    public DutyStatusWidget(Context context) {
        super(context);
        m11941a(context);
    }

    public DutyStatusWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11941a(context);
    }

    private void m11941a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.duty_status_widget, this);
        this.f8551j = OurApplication.m6245B().m10549d();
        Drawable drawable = context.getResources().getDrawable(R.drawable.duty_status_button_base);
        setLayoutParams(new LayoutParams(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8542a = getSpinner();
        this.f8543b = (AnnulusImageView) findViewById(R.id.dutyStatus_availabilityRing);
        this.f8544c = (TextView) findViewById(R.id.dutyStatus_availabilityDesc);
        this.f8545d = (TextView) findViewById(R.id.dutyStatus_availabilityTime);
        this.f8546e = (TextView) findViewById(R.id.dutyStatus_dutyStatus);
        this.f8547f = (TextView) findViewById(R.id.dutyStatus_dutyStatusCentered);
        this.f8548g = (TextView) findViewById(R.id.dutyStatus_dutyStatusSubtitle);
        this.f8550i = (ImageView) findViewById(R.id.dutyStatus_lock);
        this.f8554m = new DutyStatusAdapter(getContext(), EnumSet.of(Option.HIDE_MAIN_VIEW_ITEMS), isInEditMode());
        if (!isInEditMode()) {
            this.f8554m.m8077a(C0901j.m4568a().m4564a(OurApplication.m6285g().m12228r()).m4567a());
        }
        this.f8542a.setAdapter(this.f8554m);
        this.f8542a.setOnUserSelectedListener(new C24241(this));
        if (!isInEditMode()) {
            OurApplication.ah().m6190a(new C24252(this));
        }
    }

    private OurSpinner getSpinner() {
        OurSpinner ourSpinner = (OurSpinner) findViewById(R.id.dutyStatus_spinner);
        OurSpinner ourSpinner2 = (OurSpinner) findViewById(R.id.dutyStatus_spinner_dialog);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (((float) displayMetrics.heightPixels) / displayMetrics.scaledDensity < 620.0f) {
            ourSpinner.setVisibility(8);
            return ourSpinner2;
        }
        ourSpinner2.setVisibility(8);
        return ourSpinner;
    }

    public void setOnDutyStatusSelectedListener(C1386p c1386p) {
        this.f8555n = c1386p;
    }

    public void setOverrideClickListener(C1471b c1471b) {
        this.f8542a.setOverrideClickListener(c1471b);
    }

    public boolean m11948a(C0901j c0901j) {
        DutyStatusChoice selection = getSelection();
        boolean a = this.f8554m.m8077a(c0901j);
        setSelection(selection != null ? selection.m8045a() : null);
        return a;
    }

    private void setSelection(DutyStatus dutyStatus) {
        if (this.f8554m.m8071a(dutyStatus) == -1) {
            this.f8554m.m8077a(C0901j.m4568a().m4564a(OurApplication.m6285g().m12228r()).m4563a(dutyStatus).m4567a());
        }
        int a = this.f8554m.m8071a(dutyStatus);
        if (a != -1) {
            this.f8542a.setNonUserSelection(a);
            this.f8554m.m8080b(dutyStatus);
        }
    }

    private DutyStatusChoice getSelection() {
        int selectedItemPosition = this.f8542a.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            return null;
        }
        return this.f8554m.m8079b(selectedItemPosition);
    }

    public void m11947a(DutyLimits dutyLimits, DutyStatus dutyStatus) {
        this.f8552k = dutyLimits;
        this.f8553l = dutyStatus;
        this.f8554m.m8074a(this.f8552k);
        setSelection(dutyStatus);
        m11943b();
    }

    public boolean m11949a(C2338a c2338a) {
        return this.f8554m.m8078a(c2338a);
    }

    public void setLocked(boolean z) {
        if (this.f8549h != z) {
            this.f8549h = z;
            m11943b();
        }
    }

    public void m11946a() {
        this.f8554m.m8073a();
    }

    private void m11943b() {
        int i;
        TimeWindow timeWindow;
        int i2;
        boolean c;
        CharSequence string;
        int i3 = 4;
        int i4 = 0;
        UpcomingDutyLimit b = UpcomingDutyLimit.m4410b(this.f8552k, this.f8553l);
        if (b != null) {
            TimeWindow b2 = b.m4412b();
            switch (b.m4411a()) {
                case BREAK_COMPLETE:
                    i = R.string.availability_breakRemaining;
                    break;
                case SHIFT_COMPLETE:
                    i = R.string.availability_shiftReset;
                    break;
                case CYCLE_COMPLETE:
                    i = R.string.availability_cycleReset;
                    break;
                case DUTY_LIMIT:
                    i = R.string.availability_dutyText;
                    break;
                case DRIVE_LIMIT:
                    i = R.string.availability_drivingText;
                    break;
                case DRIVE_BEFORE_BREAK:
                    i = R.string.availability_untilBreakText;
                    break;
                case SLEEPER_SPLIT:
                    i = R.string.availability_sleeperSplit;
                    break;
                default:
                    i = 0;
                    break;
            }
            timeWindow = b2;
            i2 = i;
        } else if (this.f8553l == null || !this.f8553l.m4396d()) {
            r0 = new TimeWindow(this, 0, 0) {
                final /* synthetic */ DutyStatusWidget f8540a;

                public Condition mo727a() {
                    return Condition.WARN;
                }
            };
            i2 = R.string.availability_unknown;
            timeWindow = r0;
        } else {
            r0 = this.f8552k.m4372h();
            i2 = R.string.availability_resetComplete;
            timeWindow = r0;
        }
        if (b == null) {
            c = this.f8553l.m4395c();
        } else {
            c = b.m4411a().m4408a();
        }
        this.f8544c.setText(i2);
        this.f8543b.m11753a(timeWindow.mo727a(), m11939a(timeWindow, c));
        this.f8545d.setText(aq.m4232d(timeWindow.m4402b()));
        ActiveDrivingMode a = C2188n.m10839a(this.f8553l, OurApplication.ah().m6187a());
        if (a == ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE) {
            this.f8548g.setText(R.string.dutyStatus_subtitle_personalUse);
            string = getResources().getString(R.string.dutyStatus_offDuty);
            i2 = 1;
        } else if (a == ActiveDrivingMode.ELD_YARD_MOVE_MODE) {
            this.f8548g.setText(R.string.dutyStatus_subtitle_yardMove);
            string = getResources().getString(R.string.dutyStatus_notDriving);
            i2 = 1;
        } else {
            string = C2462j.m12108a(getResources(), this.f8553l);
            i2 = 0;
        }
        if (OurApplication.m6294p().m6584i() == TruckLogType.ELECTRONIC) {
            string = C2462j.m12111b(getResources(), this.f8553l);
        }
        string = string.toString().toUpperCase(Locale.ENGLISH);
        this.f8546e.setText(string);
        this.f8547f.setText(string);
        this.f8547f.setVisibility(i2 != 0 ? 4 : 0);
        TextView textView = this.f8546e;
        if (i2 != 0) {
            i = 0;
        } else {
            i = 4;
        }
        textView.setVisibility(i);
        TextView textView2 = this.f8548g;
        if (i2 != 0) {
            i3 = 0;
        }
        textView2.setVisibility(i3);
        if (timeWindow.mo727a() == Condition.BAD) {
            i = getResources().getColor(R.color.duty_status_bad);
        } else {
            i = getResources().getColor(R.color.duty_status_widget_fine);
        }
        this.f8544c.setTextColor(i);
        this.f8545d.setTextColor(i);
        this.f8546e.setTextColor(i);
        this.f8547f.setTextColor(i);
        this.f8548g.setTextColor(i);
        if (this.f8551j) {
            ImageView imageView = this.f8550i;
            if (!this.f8549h) {
                i4 = 8;
            }
            imageView.setVisibility(i4);
        }
    }

    private static float m11939a(TimeWindow timeWindow, boolean z) {
        if (!z) {
            return 1.0f - timeWindow.m4406f();
        }
        if (timeWindow.m4402b() == 0) {
            return 1.0f;
        }
        return timeWindow.m4406f();
    }
}
