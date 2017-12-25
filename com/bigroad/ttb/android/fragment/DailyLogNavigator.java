package com.bigroad.ttb.android.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.C0202r;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bigroad.shared.InspectionTerm;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2315v.C1428a;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.model.DutyCycle;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.util.C2293m;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DailyLogNavigator extends Fragment {
    private static final String f7164a = DailyLogNavigator.class.getName();
    private static final String f7165b = (DailyLogNavigator.class.getName() + ".showLogStatusIcons");
    private static final String f7166c = (DailyLogNavigator.class.getName() + ".useFullDate");
    private static final String f7167d = (DailyLogNavigator.class.getName() + ".requestLogDay");
    private static final String f7168e = (DailyLogNavigator.class.getName() + ".currentLogDay");
    private static final String f7169f = (DailyLogNavigator.class.getName() + ".inspectionTermOrdinal");
    private static final String f7170g = (DailyLogNavigator.class.getName() + ".logDayListArg");
    private static final String f7171h = (DailyLogNavigator.class.getName() + ".logDayListKey");
    private static final String f7172i = (DailyLogNavigator.class.getName() + ".logDayListIndex");
    private static final String f7173j = (DailyLogNavigator.class.getName() + ".hideNavigationButtons");
    private int f7174A;
    private final C1736b f7175B = OurApplication.m6296r();
    private final C2315v f7176C = OurApplication.m6298t();
    private final C2474y f7177D = OurApplication.m6285g();
    private final C1219a f7178E = new C20531(this);
    private final C1428a f7179F = new C20542(this);
    private final C1182a f7180G = new C20553(this);
    private DailyLog f7181k = null;
    private int f7182l = -1;
    private int[] f7183m = null;
    private int f7184n = -1;
    private TextView f7185o;
    private TextView f7186p;
    private TextView f7187q;
    private ImageButton f7188r;
    private ImageButton f7189s;
    private ImageView f7190t;
    private boolean f7191u;
    private boolean f7192v;
    private boolean f7193w = false;
    private boolean f7194x = false;
    private C1296b f7195y;
    private C1359a f7196z;

    public interface C1296b {
        void mo944a(DailyLog dailyLog, boolean z);
    }

    public interface C1359a {
        void mo974h();
    }

    class C20531 implements C1219a {
        final /* synthetic */ DailyLogNavigator f7159a;

        C20531(DailyLogNavigator dailyLogNavigator) {
            this.f7159a = dailyLogNavigator;
        }

        public void mo904a(C1736b c1736b) {
            this.f7159a.m10344g();
        }
    }

    class C20542 implements C1428a {
        final /* synthetic */ DailyLogNavigator f7160a;

        C20542(DailyLogNavigator dailyLogNavigator) {
            this.f7160a = dailyLogNavigator;
        }

        public void mo994a(C2315v c2315v) {
            this.f7160a.m10351e();
        }
    }

    class C20553 extends C1183b {
        final /* synthetic */ DailyLogNavigator f7161a;

        C20553(DailyLogNavigator dailyLogNavigator) {
            this.f7161a = dailyLogNavigator;
        }

        public void mo868e(C2474y c2474y) {
            this.f7161a.m10342a(c2474y.m12222l());
        }
    }

    class C20564 implements OnClickListener {
        final /* synthetic */ DailyLogNavigator f7162a;

        C20564(DailyLogNavigator dailyLogNavigator) {
            this.f7162a = dailyLogNavigator;
        }

        public void onClick(View view) {
            this.f7162a.m10350d();
        }
    }

    class C20575 implements OnClickListener {
        final /* synthetic */ DailyLogNavigator f7163a;

        C20575(DailyLogNavigator dailyLogNavigator) {
            this.f7163a = dailyLogNavigator;
        }

        public void onClick(View view) {
            this.f7163a.f7193w = false;
            this.f7163a.m10349c();
        }
    }

    public static DailyLogNavigator m10335a(C0202r c0202r, boolean z, boolean z2, int i) {
        return m10336a(c0202r, z, z2, i, null);
    }

    public static DailyLogNavigator m10337a(C0202r c0202r, boolean z, boolean z2, boolean z3, int i) {
        DailyLogNavigator dailyLogNavigator = (DailyLogNavigator) c0202r.mo149a(f7164a);
        if (dailyLogNavigator != null) {
            return dailyLogNavigator;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(f7166c, z);
        bundle.putBoolean(f7165b, z2);
        bundle.putBoolean(f7173j, z3);
        if (i > 0) {
            bundle.putInt(f7167d, i);
        }
        Fragment dailyLogNavigator2 = new DailyLogNavigator();
        dailyLogNavigator2.setArguments(bundle);
        c0202r.mo150a().mo142a(dailyLogNavigator2, f7164a).mo138a();
        return dailyLogNavigator2;
    }

    public static DailyLogNavigator m10336a(C0202r c0202r, boolean z, boolean z2, int i, InspectionTerm inspectionTerm) {
        DailyLogNavigator dailyLogNavigator = (DailyLogNavigator) c0202r.mo149a(f7164a);
        if (dailyLogNavigator != null) {
            return dailyLogNavigator;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(f7166c, z);
        bundle.putBoolean(f7165b, z2);
        if (i > 0) {
            bundle.putInt(f7167d, i);
        }
        if (inspectionTerm != null) {
            bundle.putInt(f7169f, inspectionTerm.ordinal());
        }
        Fragment dailyLogNavigator2 = new DailyLogNavigator();
        dailyLogNavigator2.setArguments(bundle);
        c0202r.mo150a().mo142a(dailyLogNavigator2, f7164a).mo138a();
        return dailyLogNavigator2;
    }

    public static DailyLogNavigator m10338a(C0202r c0202r, boolean z, boolean z2, int[] iArr, boolean z3) {
        DailyLogNavigator dailyLogNavigator = (DailyLogNavigator) c0202r.mo149a(f7164a);
        if (dailyLogNavigator != null) {
            return dailyLogNavigator;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(f7166c, z);
        bundle.putBoolean(f7165b, z2);
        bundle.putBoolean(f7173j, z3);
        if (iArr != null && iArr.length > 0) {
            bundle.putSerializable(f7170g, iArr);
        }
        Fragment dailyLogNavigator2 = new DailyLogNavigator();
        dailyLogNavigator2.setArguments(bundle);
        c0202r.mo150a().mo142a(dailyLogNavigator2, f7164a).mo138a();
        return dailyLogNavigator2;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f7191u = getArguments().getBoolean(f7166c);
        this.f7192v = getArguments().getBoolean(f7165b);
        this.f7194x = getArguments().getBoolean(f7173j);
        try {
            this.f7195y = (C1296b) activity;
            try {
                this.f7196z = (C1359a) activity;
            } catch (ClassCastException e) {
                this.f7196z = null;
            }
        } catch (ClassCastException e2) {
            throw new ClassCastException(activity.toString() + " must implement " + C1296b.class.getSimpleName() + " to use " + DailyLogNavigator.class.getSimpleName() + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7175B.m8474a(this.f7178E);
        this.f7176C.m11301a(this.f7179F);
        this.f7177D.m12184a(this.f7180G);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        if (bundle != null && bundle.containsKey(f7171h) && bundle.containsKey(f7172i)) {
            this.f7183m = bundle.getIntArray(f7171h);
            this.f7184n = bundle.getInt(f7172i);
            this.f7182l = this.f7183m[this.f7184n];
        } else if (bundle != null && bundle.containsKey(f7168e)) {
            this.f7182l = bundle.getInt(f7168e);
        } else if (arguments.containsKey(f7170g)) {
            this.f7183m = arguments.getIntArray(f7170g);
            this.f7184n = 0;
            this.f7182l = this.f7183m[this.f7184n];
        } else if (arguments.containsKey(f7167d)) {
            this.f7182l = arguments.getInt(f7167d);
        } else {
            this.f7182l = DailyLogUtils.m4284a(this.f7177D.m12228r().m4879m());
        }
        if (arguments.containsKey(f7169f)) {
            this.f7174A = InspectionTerm.values()[arguments.getInt(f7169f)].m4085a();
        } else {
            this.f7174A = -1;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OurActivity ourActivity = (OurActivity) getActivity();
        View inflate = ourActivity.getLayoutInflater().inflate(R.layout.daily_log_navigator, null);
        this.f7185o = (TextView) inflate.findViewById(R.id.dailyLog_currentDateLabel);
        int b = C2293m.m11240b(getActivity());
        this.f7186p = (TextView) inflate.findViewById(R.id.dailyLog_homeTimeZoneLabel);
        if (this.f7191u && b < C2293m.f7934b) {
            ((LayoutParams) this.f7186p.getLayoutParams()).addRule(7, R.id.dailyLog_currentDateLabel);
            ((LayoutParams) this.f7186p.getLayoutParams()).addRule(4, R.id.dailyLog_dutyCycle);
            ((LayoutParams) this.f7186p.getLayoutParams()).addRule(1, 0);
        }
        this.f7187q = (TextView) inflate.findViewById(R.id.dailyLog_dutyCycle);
        this.f7188r = (ImageButton) inflate.findViewById(R.id.dailyLog_prevDayButton);
        this.f7189s = (ImageButton) inflate.findViewById(R.id.dailyLog_nextDayButton);
        this.f7188r.setOnClickListener(new C20564(this));
        this.f7189s.setOnClickListener(new C20575(this));
        this.f7190t = (ImageView) inflate.findViewById(R.id.dailyLog_statusIndicator);
        m10339a(this.f7182l);
        ourActivity.m6692K().setCustomView(inflate);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f7183m == null) {
            bundle.putInt(f7168e, this.f7182l);
            return;
        }
        bundle.putSerializable(f7171h, this.f7183m);
        bundle.putInt(f7172i, this.f7184n);
    }

    public void onDestroy() {
        this.f7175B.m8483b(this.f7178E);
        this.f7177D.m12194b(this.f7180G);
        this.f7176C.m11303b(this.f7179F);
        super.onDestroy();
    }

    public void onDetach() {
        this.f7195y = null;
        super.onDetach();
    }

    public DailyLog m10347a() {
        return this.f7181k;
    }

    public int m10348b() {
        return this.f7182l;
    }

    private void m10344g() {
        if (this.f7182l >= 0) {
            m10339a(this.f7182l);
        }
    }

    public void m10349c() {
        if (this.f7183m != null) {
            int i = this.f7184n + 1;
            this.f7184n = i;
            this.f7184n = Math.min(i, this.f7183m.length - 1);
            this.f7182l = this.f7183m[this.f7184n];
            m10339a(this.f7182l);
            return;
        }
        m10339a(m10348b() + 1);
    }

    public void m10350d() {
        if (this.f7183m != null) {
            int i = this.f7184n - 1;
            this.f7184n = i;
            this.f7184n = Math.max(i, 0);
            this.f7182l = this.f7183m[this.f7184n];
            m10339a(this.f7182l);
            return;
        }
        m10339a(m10348b() - 1);
    }

    private void m10339a(int i) {
        boolean z;
        int h = m10345h();
        if (this.f7196z != null && i < h) {
            this.f7193w = true;
        } else if (i < h) {
            i = h;
        }
        h = m10346i();
        if (i > h) {
            i = h;
        }
        DailyLog b = this.f7175B.m8480b(i);
        if (b == null) {
            b = this.f7175B.m8490e(i);
            z = false;
        } else {
            z = true;
        }
        if (b != null) {
            this.f7181k = b;
            this.f7182l = b.getLogDay();
            Calendar c = DailyLogUtils.m4306c(this.f7181k);
            C0874m c0956v = new C0956v(this.f7181k);
            Locale locale = getResources().getConfiguration().locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f7191u ? "E MMM d, yyyy" : "E MMM d", locale);
            simpleDateFormat.setTimeZone(c.getTimeZone());
            this.f7185o.setText(simpleDateFormat.format(c.getTime()));
            this.f7186p.setText(aq.m4218a(c, 0, locale));
            this.f7187q.setText(DutyCycle.m10790a(c0956v).m10791a(true));
            m10352f();
            m10351e();
            if (this.f7193w && this.f7196z != null) {
                this.f7196z.mo974h();
            } else if (this.f7195y != null) {
                this.f7195y.mo944a(this.f7181k, z);
            }
        }
    }

    public void m10351e() {
        Severity severity = null;
        if (this.f7192v) {
            severity = this.f7176C.m11302b(this.f7182l);
        }
        int b = C2091e.m10482b(severity);
        if (b == 0) {
            this.f7190t.setVisibility(8);
            return;
        }
        this.f7190t.setImageResource(b);
        this.f7190t.setContentDescription(getString(R.string.dailyLog_notApprovedIndicator));
        this.f7190t.setVisibility(0);
    }

    public void m10352f() {
        int h = m10345h();
        if (this.f7196z != null) {
            h--;
        }
        int i = m10346i();
        if (this.f7194x || m10348b() <= r0) {
            this.f7188r.setVisibility(4);
        } else {
            this.f7188r.setVisibility(0);
        }
        if (this.f7194x || m10348b() >= i) {
            this.f7189s.setVisibility(4);
        } else {
            this.f7189s.setVisibility(0);
        }
    }

    private int m10345h() {
        if (this.f7183m != null) {
            return this.f7183m[0];
        }
        return this.f7175B.m8469a(this.f7174A);
    }

    private int m10346i() {
        if (this.f7183m != null) {
            return this.f7183m[this.f7183m.length - 1];
        }
        return this.f7175B.m8485c();
    }

    private void m10342a(Person person) {
        m10344g();
    }
}
