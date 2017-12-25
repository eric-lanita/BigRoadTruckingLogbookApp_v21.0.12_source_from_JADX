package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0901j;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.TimeWindow;
import com.bigroad.shared.duty.TimeWindow.Condition;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.DrivingModeManager;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.widget.C2462j;
import com.bigroad.ttb.android.widget.OurSpinner;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DutyStatusAdapter extends BaseAdapter {
    boolean f5700a = false;
    boolean f5701b = false;
    private final Context f5702c;
    private final LayoutInflater f5703d;
    private final ArrayList<C1639a> f5704e = new ArrayList();
    private final Set<Option> f5705f;
    private final C2474y f5706g;
    private final DrivingModeManager f5707h;
    private final C2230r f5708i;
    private C0901j f5709j = null;
    private DutyStatus f5710k = null;
    private DutyLimits f5711l = null;
    private EditMode f5712m = null;

    public enum DutyStatusChoice {
        OFF_DUTY((String) DutyStatus.OFF_DUTY),
        SLEEPER((String) DutyStatus.SLEEPER),
        DRIVING((String) DutyStatus.DRIVING),
        ON_DUTY_NOT_DRIVING((String) DutyStatus.ON_DUTY_NOT_DRIVING),
        OFF_DUTY_WAITING((String) DutyStatus.OFF_DUTY_WAITING),
        OFF_DUTY_DRIVING((String) DutyStatus.OFF_DUTY_DRIVING),
        ELD_YARD_MOVE((String) DutyStatus.ELD_YARD_MOVE),
        ENABLE_PERSONAL_USE_MODE((String) true),
        DISABLE_PERSONAL_USE_MODE((String) true),
        START_YARD_MOVE((String) true),
        STOP_YARD_MOVE((String) true),
        DUTY_STATUS_WITH_NOTE((String) false);
        
        private final DutyStatus m_dutyStatus;
        private final boolean m_isDrivingModeChange;

        private DutyStatusChoice(DutyStatus dutyStatus) {
            this.m_dutyStatus = dutyStatus;
            this.m_isDrivingModeChange = false;
        }

        private DutyStatusChoice(boolean z) {
            this.m_dutyStatus = null;
            this.m_isDrivingModeChange = z;
        }

        public DutyStatus m8045a() {
            return this.m_dutyStatus;
        }

        public boolean m8046b() {
            return this.m_isDrivingModeChange;
        }

        public static DutyStatusChoice m8044a(DutyStatus dutyStatus) {
            switch (dutyStatus) {
                case OFF_DUTY:
                    return OFF_DUTY;
                case SLEEPER:
                    return SLEEPER;
                case DRIVING:
                    return DRIVING;
                case ON_DUTY_NOT_DRIVING:
                    return ON_DUTY_NOT_DRIVING;
                case OFF_DUTY_WAITING:
                    return OFF_DUTY_WAITING;
                case OFF_DUTY_DRIVING:
                    return OFF_DUTY_DRIVING;
                case ELD_YARD_MOVE:
                    return ELD_YARD_MOVE;
                default:
                    return null;
            }
        }
    }

    public enum EditMode {
        ADD_OR_EDIT_EVENT,
        EDIT_DRIVE_TIME_AOBRD,
        EDIT_DRIVE_TIME_ELD
    }

    public enum Option {
        HIDE_AVAILABILITY,
        HIDE_MAIN_VIEW_ITEMS,
        HIDE_CUSTOM_CHOICES
    }

    private interface C1639a {
        long mo1030a();

        View mo1031a(View view, ViewGroup viewGroup);

        View mo1032a(View view, ViewGroup viewGroup, DutyStatus dutyStatus);

        void mo1033a(DutyLimits dutyLimits);

        DutyStatusChoice mo1034b();
    }

    private final class C1640b implements C1639a {
        static final /* synthetic */ boolean f5685a = (!DutyStatusAdapter.class.desiredAssertionStatus());
        final /* synthetic */ DutyStatusAdapter f5686b;
        private final int f5687c;
        private final DutyStatusChoice f5688d;

        public C1640b(DutyStatusAdapter dutyStatusAdapter, int i, DutyStatusChoice dutyStatusChoice) {
            this.f5686b = dutyStatusAdapter;
            if (f5685a || dutyStatusChoice.m8045a() == null) {
                this.f5687c = i;
                this.f5688d = dutyStatusChoice;
                return;
            }
            throw new AssertionError();
        }

        public View mo1031a(View view, ViewGroup viewGroup) {
            return this.f5686b.m8062a(view, viewGroup, C2462j.m12108a(viewGroup.getResources(), this.f5686b.f5710k), null);
        }

        public long mo1030a() {
            return (long) this.f5688d.ordinal();
        }

        public DutyStatusChoice mo1034b() {
            return this.f5688d;
        }

        public View mo1032a(View view, ViewGroup viewGroup, DutyStatus dutyStatus) {
            if (view == null) {
                view = this.f5686b.f5703d.inflate(R.layout.duty_status_spinner_item, viewGroup, false);
            }
            View findViewById = view.findViewById(R.id.dutyStatusItem_container);
            findViewById.setVisibility(0);
            view.findViewById(R.id.dutyStatusItem_basic).setVisibility(8);
            view.findViewById(R.id.dutyStatusItem_custom).setVisibility(0);
            ((TextView) view.findViewById(R.id.dutyStatusItem_custom)).setText(this.f5687c);
            findViewById.getBackground().setLevel(0);
            return view;
        }

        public void mo1033a(DutyLimits dutyLimits) {
        }
    }

    private final class C1641c implements C1639a {
        static final /* synthetic */ boolean f5689a = (!DutyStatusAdapter.class.desiredAssertionStatus());
        final /* synthetic */ DutyStatusAdapter f5690b;
        private final Resources f5691c;
        private final CharSequence f5692d;
        private final CharSequence f5693e;
        private final DutyStatusChoice f5694f;
        private final boolean f5695g;
        private String f5696h;
        private Condition f5697i;
        private boolean f5698j;
        private boolean f5699k;

        public C1641c(DutyStatusAdapter dutyStatusAdapter, Resources resources, DutyStatusChoice dutyStatusChoice, boolean z, boolean z2, boolean z3) {
            this.f5690b = dutyStatusAdapter;
            if (f5689a || dutyStatusChoice.m8045a() != null) {
                this.f5691c = resources;
                if (dutyStatusAdapter.f5712m == null && dutyStatusAdapter.f5700a) {
                    this.f5692d = C2462j.m12108a(resources, dutyStatusChoice.m8045a());
                } else {
                    this.f5692d = C2462j.m12111b(resources, dutyStatusChoice.m8045a());
                }
                this.f5694f = dutyStatusChoice;
                this.f5695g = z;
                this.f5698j = z2;
                this.f5699k = z3;
                ActiveDrivingMode a = dutyStatusAdapter.f5707h.m6187a();
                if (a == ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE && dutyStatusAdapter.f5712m == null) {
                    this.f5693e = resources.getString(R.string.dutyStatus_subtitle_personalConveyance);
                    return;
                } else if (a == ActiveDrivingMode.ELD_YARD_MOVE_MODE && dutyStatusAdapter.f5712m == null) {
                    this.f5693e = resources.getString(R.string.dutyStatus_subtitle_yardMove);
                    return;
                } else {
                    this.f5693e = null;
                    return;
                }
            }
            throw new AssertionError();
        }

        public View mo1031a(View view, ViewGroup viewGroup) {
            return this.f5690b.m8062a(view, viewGroup, this.f5692d, this.f5693e);
        }

        public long mo1030a() {
            return (long) this.f5694f.ordinal();
        }

        public View mo1032a(View view, ViewGroup viewGroup, DutyStatus dutyStatus) {
            int i = 1;
            if (view == null) {
                view = this.f5690b.f5703d.inflate(R.layout.duty_status_spinner_item, viewGroup, false);
            }
            View findViewById = view.findViewById(R.id.dutyStatusItem_container);
            findViewById.setVisibility(this.f5699k ? 8 : 0);
            if (!this.f5699k) {
                view.findViewById(R.id.dutyStatusItem_custom).setVisibility(8);
                View findViewById2 = view.findViewById(R.id.dutyStatusItem_basic);
                findViewById2.setVisibility(0);
                int dimensionPixelSize = view.getResources().getDimensionPixelSize(this.f5698j ? R.dimen.widget_spacing : R.dimen.big_padding);
                findViewById2.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                TextView textView = (TextView) view.findViewById(R.id.dutyStatusItem_warning);
                if (textView != null) {
                    if (this.f5698j) {
                        if (this.f5694f.m8045a() == DutyStatus.DRIVING) {
                            textView.setText(R.string.dutyStatus_aobrdDrivingWarning);
                        } else if (this.f5694f.m8045a() == DutyStatus.OFF_DUTY_DRIVING) {
                            textView.setText(R.string.dutyStatus_aobrdOffDutyDrivingWarning);
                        } else if (this.f5694f.m8045a() == DutyStatus.ELD_YARD_MOVE) {
                            textView.setText(R.string.dutyStatus_eldYardMoveDrivingWarning);
                        }
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                textView = (TextView) view.findViewById(R.id.dutyStatusItem_label);
                textView.setText(this.f5692d);
                if (this.f5694f.m8045a() == dutyStatus) {
                    findViewById.getBackground().setLevel(1);
                } else {
                    findViewById.getBackground().setLevel(0);
                    i = 0;
                }
                ac.m11181a(textView, textView.getTypeface(), i);
                textView = (TextView) view.findViewById(R.id.dutyStatusItem_basic_subtitle);
                if (am.m4188a(this.f5693e)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(this.f5693e);
                    textView.setVisibility(0);
                }
                textView = (TextView) view.findViewById(R.id.dutyStatusItem_availability);
                if (this.f5695g) {
                    textView.setText(this.f5696h);
                    if (this.f5697i != null) {
                        textView.setTextColor(C2462j.m12107a(viewGroup.getResources(), this.f5697i));
                    }
                } else {
                    textView.setText("");
                }
            }
            return view;
        }

        public DutyStatusChoice mo1034b() {
            return this.f5694f;
        }

        public void mo1033a(DutyLimits dutyLimits) {
            if (!this.f5695g || dutyLimits == null) {
                this.f5696h = null;
                this.f5697i = null;
                return;
            }
            TimeWindow g;
            String string;
            if (this.f5694f.m8045a().m4396d()) {
                g = dutyLimits.m4371g();
                string = this.f5691c.getString(R.string.legacyAvailability_shiftReset);
                if (g.mo727a() == Condition.FINE) {
                    g = dutyLimits.m4372h();
                    string = this.f5691c.getString(R.string.legacyAvailability_cycleReset);
                }
                if (g.m4402b() <= 0) {
                    this.f5696h = this.f5691c.getString(R.string.legacyAvailability_resetComplete);
                } else {
                    this.f5696h = String.format(this.f5691c.getString(R.string.legacyAvailability_resetText), new Object[]{string, aq.m4232d(g.m4402b())});
                }
            } else {
                if (this.f5694f.m8045a() != DutyStatus.DRIVING) {
                    g = dutyLimits.m4369e();
                    string = this.f5691c.getString(R.string.legacyAvailability_dutyText);
                } else if (dutyLimits.m4380p()) {
                    g = dutyLimits.m4366b();
                    string = this.f5691c.getString(R.string.legacyAvailability_drivingBeforeBreakText);
                } else {
                    g = dutyLimits.m4364a();
                    string = this.f5691c.getString(R.string.legacyAvailability_drivingText);
                }
                this.f5696h = String.format(string, new Object[]{aq.m4232d(g.m4402b())});
            }
            this.f5697i = g.mo727a();
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m8072a(i);
    }

    private View m8062a(View view, ViewGroup viewGroup, CharSequence charSequence, CharSequence charSequence2) {
        if (view == null) {
            view = this.f5703d.inflate(R.layout.duty_status_spinner_prompt, viewGroup, false);
        }
        if (this.f5705f.contains(Option.HIDE_MAIN_VIEW_ITEMS)) {
            view.setVisibility(8);
        } else {
            ((TextView) view.findViewById(R.id.dutyStatusSpinner_dutyStatus)).setText(charSequence);
            TextView textView = (TextView) view.findViewById(R.id.dutyStatusSpinner_dutyStatusSubtitle);
            if (am.m4188a(charSequence2)) {
                textView.setVisibility(8);
            } else {
                textView.setText(charSequence2);
                textView.setVisibility(0);
            }
        }
        return view;
    }

    public DutyStatusAdapter(Context context, Set<Option> set, boolean z) {
        this.f5702c = context;
        this.f5703d = LayoutInflater.from(context);
        this.f5705f = set;
        if (z) {
            this.f5706g = null;
        } else {
            this.f5706g = OurApplication.m6285g();
        }
        this.f5707h = OurApplication.ah();
        this.f5710k = OurApplication.m6295q().m10060j();
        this.f5708i = OurApplication.m6292n();
    }

    public int getCount() {
        return this.f5704e.size();
    }

    public C1639a m8072a(int i) {
        return (i < 0 || i >= this.f5704e.size()) ? null : (C1639a) this.f5704e.get(i);
    }

    public long getItemId(int i) {
        C1639a a = m8072a(i);
        if (a == null) {
            return Long.MIN_VALUE;
        }
        return a.mo1030a();
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (C2291k.m11225d() < 11) {
            viewGroup.setBackgroundColor(viewGroup.getResources().getColor(R.color.listItemBg));
        }
        return m8072a(i).mo1032a(view, viewGroup, this.f5710k);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return ((C1639a) this.f5704e.get(i)).mo1031a(view, viewGroup);
    }

    public DutyStatusChoice m8079b(int i) {
        C1639a a = m8072a(i);
        return a == null ? null : a.mo1034b();
    }

    public int m8071a(DutyStatus dutyStatus) {
        for (int i = 0; i < this.f5704e.size(); i++) {
            if (((C1639a) this.f5704e.get(i)).mo1034b().m8045a() == dutyStatus) {
                return i;
            }
        }
        return -1;
    }

    private void m8065a(Resources resources, DutyStatus dutyStatus) {
        m8067a(resources, dutyStatus, false, false, this.f5700a);
    }

    private void m8066a(Resources resources, DutyStatus dutyStatus, boolean z) {
        boolean z2;
        if (this.f5700a && dutyStatus.m4397e()) {
            z2 = true;
        } else {
            z2 = false;
        }
        m8067a(resources, dutyStatus, z, z2, false);
    }

    private void m8067a(Resources resources, DutyStatus dutyStatus, boolean z, boolean z2, boolean z3) {
        DutyStatusChoice a = DutyStatusChoice.m8044a(dutyStatus);
        boolean z4 = z && dutyStatus.m4395c();
        C1639a c1641c = new C1641c(this, resources, a, z4, z2, z3);
        c1641c.mo1033a(this.f5711l);
        this.f5704e.add(c1641c);
    }

    public void m8073a() {
        boolean z = true;
        Resources resources = this.f5702c.getResources();
        boolean z2 = !this.f5705f.contains(Option.HIDE_AVAILABILITY);
        if (this.f5705f.contains(Option.HIDE_CUSTOM_CHOICES)) {
            z = false;
        }
        this.f5704e.clear();
        ActiveDrivingMode a = this.f5707h.m6187a();
        if (this.f5712m == EditMode.EDIT_DRIVE_TIME_AOBRD || this.f5712m == EditMode.EDIT_DRIVE_TIME_ELD) {
            m8067a(resources, DutyStatus.DRIVING, z2, false, false);
            if (this.f5707h.m6197c()) {
                m8067a(resources, DutyStatus.OFF_DUTY_DRIVING, z2, false, false);
            }
            if (this.f5712m == EditMode.EDIT_DRIVE_TIME_ELD && this.f5708i.m11019e()) {
                m8067a(resources, DutyStatus.ELD_YARD_MOVE, z2, false, false);
            }
        } else if (this.f5712m == EditMode.ADD_OR_EDIT_EVENT) {
            Iterator it = this.f5709j.iterator();
            while (it.hasNext()) {
                m8066a(resources, (DutyStatus) it.next(), z2);
            }
        } else if (a == ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE) {
            m8065a(resources, DutyStatus.OFF_DUTY);
            m8065a(resources, DutyStatus.OFF_DUTY_DRIVING);
            if (z) {
                this.f5704e.add(new C1640b(this, R.string.dutyStatus_endPersonalUse, DutyStatusChoice.DISABLE_PERSONAL_USE_MODE));
                this.f5704e.add(new C1640b(this, R.string.dutyStatus_dutyStatusWithNote, DutyStatusChoice.DUTY_STATUS_WITH_NOTE));
            }
        } else if (a == ActiveDrivingMode.ELD_YARD_MOVE_MODE) {
            m8065a(resources, DutyStatus.ON_DUTY_NOT_DRIVING);
            m8065a(resources, DutyStatus.ELD_YARD_MOVE);
            if (z) {
                this.f5704e.add(new C1640b(this, R.string.dutyStatus_endYardMove, DutyStatusChoice.STOP_YARD_MOVE));
                this.f5704e.add(new C1640b(this, R.string.dutyStatus_dutyStatusWithNote, DutyStatusChoice.DUTY_STATUS_WITH_NOTE));
            }
        } else {
            m8066a(resources, DutyStatus.OFF_DUTY, z2);
            m8066a(resources, DutyStatus.SLEEPER, z2);
            m8066a(resources, DutyStatus.DRIVING, z2);
            m8066a(resources, DutyStatus.ON_DUTY_NOT_DRIVING, z2);
            if (this.f5709j.m4572b()) {
                m8066a(resources, DutyStatus.OFF_DUTY_WAITING, z2);
            }
            if (z) {
                if (this.f5707h.m6197c()) {
                    this.f5704e.add(new C1640b(this, R.string.dutyStatus_beginPersonalUse, DutyStatusChoice.ENABLE_PERSONAL_USE_MODE));
                }
                if (OurApplication.m6292n().m11019e() && this.f5701b && (C1130o.m5714a(OurApplication.m6252I().m11407e()) || !DutyStatus.m4388b(this.f5710k))) {
                    this.f5704e.add(new C1640b(this, R.string.dutyStatus_startYardMove, DutyStatusChoice.START_YARD_MOVE));
                }
                this.f5704e.add(new C1640b(this, R.string.dutyStatus_dutyStatusWithNote, DutyStatusChoice.DUTY_STATUS_WITH_NOTE));
            }
        }
        notifyDataSetChanged();
    }

    public boolean m8077a(C0901j c0901j) {
        if (c0901j.equals(this.f5709j)) {
            return false;
        }
        this.f5709j = c0901j;
        m8073a();
        return true;
    }

    public boolean m8078a(C2338a c2338a) {
        boolean a = c2338a.m11451a(ConnectionSetupFlag.REQUIRED);
        boolean a2 = c2338a.m11450a(ConnectionFlag.CONNECTED);
        if (this.f5700a == a && this.f5701b == a2) {
            return false;
        }
        this.f5700a = a;
        this.f5701b = a2;
        m8073a();
        return true;
    }

    public void m8080b(DutyStatus dutyStatus) {
        if (dutyStatus != null) {
            this.f5710k = dutyStatus;
            m8073a();
        }
    }

    public void m8076a(OurSpinner ourSpinner) {
        int a = m8071a(this.f5710k);
        if (a != -1) {
            ourSpinner.setNonUserSelection(a);
        }
    }

    public void m8074a(DutyLimits dutyLimits) {
        this.f5711l = dutyLimits;
        Iterator it = this.f5704e.iterator();
        while (it.hasNext()) {
            ((C1639a) it.next()).mo1033a(dutyLimits);
        }
        notifyDataSetChanged();
    }

    public void m8075a(EditMode editMode) {
        this.f5712m = editMode;
        m8073a();
    }
}
