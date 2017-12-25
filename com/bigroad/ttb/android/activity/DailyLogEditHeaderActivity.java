package com.bigroad.ttb.android.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.shared.C0906x;
import com.bigroad.shared.ah;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogOdometerSearchType;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.dailylog.DailyLogUtils.C0859a;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.gaps.model.C1072a;
import com.bigroad.shared.gaps.p026a.C1074b;
import com.bigroad.shared.gaps.p027b.C1078a;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.model.C1116d;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.shared.validation.C1162b;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.DailyLogHeader.Field;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.p024b.C1150a;
import com.bigroad.shared.validation.p028a.C1149a;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2472x;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.af;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.aj;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.dialog.ConfirmUsingTruckDialogFragment;
import com.bigroad.ttb.android.dialog.ConfirmUsingTruckDialogFragment.C1378a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2177b;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.p029c.C1738c;
import com.bigroad.ttb.android.p039h.C2085a;
import com.bigroad.ttb.android.p039h.C2088c;
import com.bigroad.ttb.android.p039h.C2091e;
import com.bigroad.ttb.android.p039h.C2094f;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.util.C2300s;
import com.bigroad.ttb.android.util.C2302u;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C2458h;
import com.bigroad.ttb.android.widget.C2466o;
import com.bigroad.ttb.android.widget.C2466o.C1379a;
import com.bigroad.ttb.android.widget.DailyLogEditHeaderTruckView;
import com.bigroad.ttb.android.widget.DailyLogEditHeaderTruckView.ParcelableTruckSection;
import com.bigroad.ttb.android.widget.InstantAutoComplete;
import com.bigroad.ttb.protocol.TTProtocol;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck.C2602a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruckList;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruckList.C2604a;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class DailyLogEditHeaderActivity extends OurActivity implements C0906x, C1378a, C1379a {
    private static final String f4659a = DailyLogEditHeaderActivity.class.getName();
    private static final String f4660b = (f4659a + ".legacyCoDriver");
    private static final String f4661c = (f4659a + ".coDriverId");
    private static final String f4662d = (f4659a + ".dailyLogTruckList");
    private static final String f4663e = (f4659a + ".shippingDocList");
    private static final String f4664f = (f4659a + ".trailerList");
    private InstantAutoComplete f4665A;
    private Button f4666B;
    private LinearLayout f4667C;
    private InstantAutoComplete f4668D;
    private Button f4669E;
    private TextView f4670F;
    private TextView f4671G;
    private TextView f4672H;
    private LinearLayout f4673I;
    private LinearLayout f4674J;
    private View f4675K;
    private InstantAutoComplete f4676L;
    private TextView f4677M;
    private View f4678N;
    private TextView f4679O;
    private InstantAutoComplete f4680P;
    private Button f4681Q;
    private TextView f4682R;
    private Button f4683S;
    private TextView f4684T;
    private Button f4685U;
    private TextView f4686V;
    private Button f4687W;
    private InstantAutoComplete f4688X;
    private Button f4689Y;
    private DailyLog f4690Z;
    private final C1736b aa = OurApplication.m6296r();
    private final EventManager ab = OurApplication.m6295q();
    private final TruckManager ac = OurApplication.m6294p();
    private final C2315v ad = OurApplication.m6298t();
    private final ai ae = OurApplication.m6256M();
    private final C2474y af = OurApplication.m6285g();
    private final ap ag = OurApplication.m6269Z();
    private final C2472x ah = OurApplication.m6293o();
    private final C2230r ai = OurApplication.m6292n();
    private final aj aj = OurApplication.ai();
    private com.bigroad.shared.validation.model.DailyLog ak = null;
    private C2094f<Field> al = new C2094f(this);
    private List<DailyLogEditHeaderTruckView> am = null;
    private List<DailyLogEditHeaderTruckView> an = null;
    private TextWatcher ao;
    private final C1219a ap = new C13671(this);
    private final ChangeListener aq = new C1199e(this) {
        final /* synthetic */ DailyLogEditHeaderActivity f4633a;

        {
            this.f4633a = r1;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f4633a.m7135u();
            this.f4633a.mo933n();
        }
    };
    private final TruckManager.ChangeListener ar = new C1203b(this) {
        final /* synthetic */ DailyLogEditHeaderActivity f4634a;

        {
            this.f4634a = r1;
        }

        public void mo895b() {
            this.f4634a.m7133t();
        }
    };
    private final OnEditorActionListener as = new OnEditorActionListener(this) {
        final /* synthetic */ DailyLogEditHeaderActivity f4635a;

        {
            this.f4635a = r1;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 0) {
                return false;
            }
            if (keyEvent.getAction() == 1 && (textView.getImeOptions() & 255) == 6) {
                ((InputMethodManager) this.f4635a.getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 2);
            }
            return true;
        }
    };
    private int f4691g;
    private boolean f4692h;
    private boolean f4693i;
    private boolean f4694j;
    private OdometerUnit f4695k;
    private String f4696l;
    private Long f4697m;
    private ArrayList<String> f4698n = new ArrayList();
    private ArrayList<String> f4699o = new ArrayList();
    private C2466o f4700p;
    private LayoutInflater f4701q;
    private InstantAutoComplete f4702r;
    private TextView f4703s;
    private Button f4704t;
    private Button f4705u;
    private InstantAutoComplete f4706v;
    private InstantAutoComplete f4707w;
    private InstantAutoComplete f4708x;
    private InstantAutoComplete f4709y;
    private LinearLayout f4710z;

    class C13671 implements C1219a {
        final /* synthetic */ DailyLogEditHeaderActivity f4641a;

        C13671(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4641a = dailyLogEditHeaderActivity;
        }

        public void mo904a(C1736b c1736b) {
            this.f4641a.f4690Z = c1736b.m8491f(this.f4641a.f4690Z.getLogDay());
            if (this.f4641a.f4690Z != null) {
                this.f4641a.m7135u();
                this.f4641a.m7123o();
                this.f4641a.mo933n();
                this.f4641a.m7127q();
            }
        }
    }

    class C13682 implements OnClickListener {
        final /* synthetic */ DailyLogEditHeaderActivity f4642a;

        C13682(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4642a = dailyLogEditHeaderActivity;
        }

        public void onClick(View view) {
            this.f4642a.m7138w();
        }
    }

    class C13693 implements OnClickListener {
        final /* synthetic */ DailyLogEditHeaderActivity f4643a;

        C13693(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4643a = dailyLogEditHeaderActivity;
        }

        public void onClick(View view) {
            if (this.f4643a.am.isEmpty()) {
                C1632a.m7967b(this.f4643a, this.f4643a.f4691g);
            } else {
                CantEditAobrdTimeZoneDialogFragment.m7067a(this.f4643a);
            }
        }
    }

    class C13704 implements OnClickListener {
        final /* synthetic */ DailyLogEditHeaderActivity f4644a;

        C13704(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4644a = dailyLogEditHeaderActivity;
        }

        public void onClick(View view) {
            C1632a.m7980c(this.f4644a, this.f4644a.f4691g);
        }
    }

    class C13715 implements OnClickListener {
        final /* synthetic */ DailyLogEditHeaderActivity f4645a;

        C13715(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4645a = dailyLogEditHeaderActivity;
        }

        public void onClick(View view) {
            C1632a.m7985d(this.f4645a, this.f4645a.f4691g);
        }
    }

    class C13726 implements OnClickListener {
        final /* synthetic */ DailyLogEditHeaderActivity f4646a;

        C13726(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4646a = dailyLogEditHeaderActivity;
        }

        public void onClick(View view) {
            C1632a.m7962a(this.f4646a, EnumSet.of(Option.WITHOUT_EOBR_TRUCKS));
        }
    }

    class C13759 extends ClickableSpan {
        final /* synthetic */ DailyLogEditHeaderActivity f4651a;

        C13759(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4651a = dailyLogEditHeaderActivity;
        }

        public void onClick(View view) {
            this.f4651a.f4698n.add("N/A");
            this.f4651a.m7129r();
        }
    }

    public static class CantEditAobrdTimeZoneDialogFragment extends DialogFragment {
        public static void m7067a(OurActivity ourActivity) {
            new CantEditAobrdTimeZoneDialogFragment().show(ourActivity.getSupportFragmentManager(), "dialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2659a((int) R.string.dailyLogEditHeader_cantEditAobrdTimeZoneTitle).m2672b((int) R.string.dailyLogEditHeader_cantEditAobrdTimeZoneMessage).m2661a(17039370, C1843a.f6286a).m2670a(true).m2677b();
        }
    }

    public static class ConfirmRemoveTruckDialogFragment extends DialogFragment {

        class C13761 implements DialogInterface.OnClickListener {
            final /* synthetic */ ConfirmRemoveTruckDialogFragment f4652a;

            C13761(ConfirmRemoveTruckDialogFragment confirmRemoveTruckDialogFragment) {
                this.f4652a = confirmRemoveTruckDialogFragment;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                int i2 = this.f4652a.getArguments().getInt(ShareConstants.WEB_DIALOG_PARAM_TITLE, -1);
                if (i2 >= 0 && (this.f4652a.getActivity() instanceof DailyLogEditHeaderActivity)) {
                    ((DailyLogEditHeaderActivity) this.f4652a.getActivity()).m7110d(i2);
                }
            }
        }

        public static void m7068a(OurActivity ourActivity, int i) {
            ConfirmRemoveTruckDialogFragment confirmRemoveTruckDialogFragment = new ConfirmRemoveTruckDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ShareConstants.WEB_DIALOG_PARAM_TITLE, i);
            confirmRemoveTruckDialogFragment.setArguments(bundle);
            confirmRemoveTruckDialogFragment.show(ourActivity.getSupportFragmentManager(), "dialog");
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dailyLogEditHeader_confirmRemoveTruckTitle).m2672b((int) R.string.dailyLogEditHeader_confirmRemoveTruckMessage).m2661a((int) R.string.dailyLogEditHeader_removeTruck, new C13761(this)).m2673b(17039360, C1843a.f6286a).m2677b();
        }
    }

    private class C1377a extends C1150a {
        final /* synthetic */ DailyLogEditHeaderActivity f4653a;
        private C0956v f4654b;
        private List<DailyLogTruck> f4655c;
        private List<DailyLogTruck> f4656d;
        private List<DailyLogTruck> f4657e;
        private List<C1072a> f4658f;

        public C1377a(DailyLogEditHeaderActivity dailyLogEditHeaderActivity) {
            this.f4653a = dailyLogEditHeaderActivity;
            this.f4654b = new C0956v(dailyLogEditHeaderActivity.f4690Z);
            this.f4655c = new ArrayList(dailyLogEditHeaderActivity.an);
            this.f4656d = new ArrayList(dailyLogEditHeaderActivity.am);
            this.f4658f = new ArrayList(dailyLogEditHeaderActivity.an.size() + dailyLogEditHeaderActivity.am.size());
            for (DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView : dailyLogEditHeaderActivity.an) {
                if (dailyLogEditHeaderTruckView.m11823o() == null) {
                    throw new IllegalStateException("No. " + dailyLogEditHeaderTruckView.m11818j());
                }
                this.f4658f.add(new C1074b(dailyLogEditHeaderTruckView.m11823o(), dailyLogEditHeaderTruckView.a_(), dailyLogEditHeaderActivity.af.m12202d()));
            }
            for (DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView2 : dailyLogEditHeaderActivity.am) {
                this.f4658f.add(new C1078a(dailyLogEditHeaderTruckView2.m11824p(), dailyLogEditHeaderTruckView2.a_(), dailyLogEditHeaderActivity.af.m12202d()));
            }
            this.f4657e = C1149a.m5792a(C1108a.m5497a(dailyLogEditHeaderActivity.f4690Z.getLogDay(), dailyLogEditHeaderActivity.f4690Z.getTimezoneId(), dailyLogEditHeaderActivity.f4690Z.hasDriverApproval(), OurApplication.af(), dailyLogEditHeaderActivity.ag.mo914b()), dailyLogEditHeaderActivity.f4690Z.getLogDay());
        }

        public boolean mo842s() {
            return C2292l.m11231a(this.f4653a.f4690Z);
        }

        public boolean mo843t() {
            return this.f4653a.f4690Z.hasAmendedBy();
        }

        public String mo824a() {
            return this.f4653a.f4702r.getText().toString().trim();
        }

        public String mo837n() {
            return null;
        }

        public String mo825b() {
            return null;
        }

        public String mo826c() {
            return this.f4653a.f4706v.getText().toString();
        }

        public String mo827d() {
            return this.f4653a.f4708x.getText().toString();
        }

        public String mo828e() {
            return this.f4653a.f4709y.getText().toString();
        }

        public String mo829f() {
            return null;
        }

        public Integer mo838o() {
            return null;
        }

        public Integer mo839p() {
            return null;
        }

        public Integer mo830g() {
            if (this.f4653a.am.isEmpty() && this.f4653a.an.size() == 1) {
                return ((DailyLogEditHeaderTruckView) this.f4653a.an.get(0)).mo781i();
            }
            if (this.f4653a.am.size() + this.f4653a.an.size() > 1) {
                return ac.m11173a(this.f4653a.f4676L);
            }
            return null;
        }

        public OdometerUnit mo831h() {
            return this.f4653a.f4695k;
        }

        public List<DailyLogTruck> mo832i() {
            return this.f4655c;
        }

        public List<DailyLogTruck> mo833j() {
            return this.f4656d;
        }

        public List<DailyLogTruck> mo834k() {
            return this.f4657e;
        }

        public List<String> mo835l() {
            return m7069a(this.f4653a.f4699o, this.f4653a.f4668D);
        }

        public List<String> mo836m() {
            return m7069a(this.f4653a.f4698n, this.f4653a.f4665A);
        }

        private List<String> m7069a(List<String> list, TextView textView) {
            List<String> arrayList = new ArrayList(list);
            CharSequence charSequence = textView.getText().toString();
            if (!am.m4188a(charSequence)) {
                arrayList.add(charSequence);
            }
            return arrayList;
        }

        public boolean mo840q() {
            return this.f4654b.m4878l();
        }

        public boolean mo841r() {
            return this.f4654b.mo706e();
        }

        public C2085a m7090u() {
            return new C2085a(C2088c.m10470a(this.f4653a.a_(), this.f4658f));
        }
    }

    private void m7123o() {
        C0874m c0956v = new C0956v(this.f4690Z);
        this.f4682R.setText(af.m8282a(c0956v.mo703a(), (Context) this));
        this.f4684T.setText(C1738c.m8505a(c0956v, (Context) this));
        this.f4686V.setText(C2300s.m11250a(getResources(), this.f4690Z.getRecapType()));
    }

    public DailyLogEditHeaderActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    public void onCreate(Bundle bundle) {
        String str = null;
        super.onCreate(bundle);
        this.f4701q = LayoutInflater.from(this);
        setContentView((int) R.layout.daily_log_header_edit);
        this.ao = new C2458h(m6701T(), new Runnable(this) {
            final /* synthetic */ DailyLogEditHeaderActivity f4636a;

            {
                this.f4636a = r1;
            }

            public void run() {
                this.f4636a.mo933n();
            }
        });
        findViewById(R.id.dailyLogEditHeader_scrollView).setVerticalFadingEdgeEnabled(true);
        this.f4702r = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_driverName);
        this.f4703s = (TextView) findViewById(R.id.dailyLogEditHeader_coDriverName);
        this.f4704t = (Button) findViewById(R.id.dailyLogEditHeader_pickCoDriverButton);
        this.f4705u = (Button) findViewById(R.id.dailyLogEditHeader_removeCoDriverButton);
        this.f4706v = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_carrierName);
        this.f4707w = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_carrierDotNo);
        this.f4708x = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_carrierAddress);
        this.f4709y = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_carrierHomeTerminal);
        this.f4710z = (LinearLayout) findViewById(R.id.dailyLogEditHeader_carrierShippingDocList);
        this.f4665A = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_carrierShippingDocAddField);
        this.f4666B = (Button) findViewById(R.id.dailyLogEditHeader_carrierShippingDocAddButton);
        this.f4667C = (LinearLayout) findViewById(R.id.dailyLogEditHeader_carrierTrailerList);
        this.f4668D = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_carrierTrailerAddField);
        this.f4669E = (Button) findViewById(R.id.dailyLogEditHeader_carrierTrailerAddButton);
        this.f4670F = (TextView) findViewById(R.id.dailyLogEditHeader_noTrucks);
        this.f4671G = (TextView) findViewById(R.id.dailyLogEditHeader_noTrucksDashLink);
        this.f4672H = (TextView) findViewById(R.id.dailyLogEditHeader_noTrucksErrorText);
        this.f4673I = (LinearLayout) findViewById(R.id.dailyLogEditHeader_autoTruckList);
        this.f4674J = (LinearLayout) findViewById(R.id.dailyLogEditHeader_truckList);
        this.f4675K = findViewById(R.id.dailyLogEditHeader_truckTotalDistanceGroup);
        this.f4676L = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_truckTotalDistance);
        this.f4677M = (TextView) findViewById(R.id.dailyLogEditHeader_truckTotalDistanceUnit);
        this.f4678N = findViewById(R.id.dailyLogEditHeader_truckTotalDistanceLocked);
        this.f4679O = (TextView) findViewById(R.id.dailyLogEditHeader_truckTotalDistanceReadOnlyErrorText);
        this.f4680P = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_truckTotalEngineHours);
        this.f4681Q = (Button) findViewById(R.id.dailyLogEditHeader_addTruckButton);
        this.f4682R = (TextView) findViewById(R.id.dailyLogEditHeader_timeZoneSettingsValue);
        this.f4683S = (Button) findViewById(R.id.dailyLogEditHeader_timeZoneChangeButton);
        this.f4684T = (TextView) findViewById(R.id.dailyLogEditHeader_hosSettingsValue);
        this.f4685U = (Button) findViewById(R.id.dailyLogEditHeader_hosChangeButton);
        this.f4686V = (TextView) findViewById(R.id.dailyLogEditHeader_recapSettingsValue);
        this.f4687W = (Button) findViewById(R.id.dailyLogEditHeader_recapChangeButton);
        this.f4688X = (InstantAutoComplete) findViewById(R.id.dailyLogEditHeader_remarks);
        this.f4689Y = (Button) findViewById(R.id.dailyLogEditHeader_doneButton);
        this.f4702r.setAdapter(this.ae.m8372a((Context) this, 7));
        this.f4704t.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditHeaderActivity f4637a;

            {
                this.f4637a = r1;
            }

            public void onClick(View view) {
                C1632a.m8007n(this.f4637a);
            }
        });
        this.f4705u.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditHeaderActivity f4638a;

            {
                this.f4638a = r1;
            }

            public void onClick(View view) {
                this.f4638a.f4696l = null;
                this.f4638a.f4697m = null;
                this.f4638a.m7125p();
            }
        });
        this.f4666B.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditHeaderActivity f4639a;

            {
                this.f4639a = r1;
            }

            public void onClick(View view) {
                if (!am.m4188a(this.f4639a.f4665A.getText())) {
                    this.f4639a.f4698n.add(0, this.f4639a.f4665A.getText().toString());
                    this.f4639a.f4665A.setText("");
                    this.f4639a.m7104a(true);
                }
            }
        });
        this.f4669E.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ DailyLogEditHeaderActivity f4640a;

            {
                this.f4640a = r1;
            }

            public void onClick(View view) {
                if (!am.m4188a(this.f4640a.f4668D.getText())) {
                    this.f4640a.f4699o.add(0, this.f4640a.f4668D.getText().toString());
                    this.f4640a.f4668D.setText("");
                    this.f4640a.m7108b(true);
                }
            }
        });
        ListAdapter a = this.ae.m8372a((Context) this, 11);
        this.f4708x.setAdapter(a);
        this.f4709y.setAdapter(a);
        this.f4688X.setAdapter(this.ae.m8372a((Context) this, 13));
        this.f4668D.setAdapter(this.ae.m8372a((Context) this, 4));
        this.f4706v.setAdapter(this.ae.m8372a((Context) this, 6));
        this.f4665A.setAdapter(this.ae.m8372a((Context) this, 12));
        this.f4691g = getIntent().getIntExtra("com.bigroad.ttb.logDay", -1);
        if (this.f4691g < 0) {
            C2134e.m10682e("TT-LogEditHeader", "No log day");
            finish();
            return;
        }
        String string;
        Long valueOf;
        CharSequence charSequence;
        Collection stringArrayList;
        List list;
        Collection stringArrayList2;
        this.f4708x.setOnEditorActionListener(this.as);
        this.f4709y.setOnEditorActionListener(this.as);
        this.f4688X.setOnEditorActionListener(this.as);
        this.f4665A.setOnEditorActionListener(this.as);
        this.f4689Y.setOnClickListener(new C13682(this));
        this.f4683S.setOnClickListener(new C13693(this));
        this.f4685U.setOnClickListener(new C13704(this));
        this.f4687W.setOnClickListener(new C13715(this));
        this.f4690Z = this.aa.m8480b(this.f4691g);
        if (this.f4690Z == null) {
            this.f4690Z = this.aa.m8488d(this.f4691g);
            if (this.f4690Z == null) {
                C2134e.m10682e("TT-LogEditHeader", "Unable to build default log");
                finish();
                return;
            }
            this.aa.m8484b(this.f4690Z);
        }
        this.f4692h = this.f4691g == DailyLogUtils.m4285a(TimeZone.getTimeZone(this.f4690Z.getTimezoneId()));
        this.f4681Q.setOnClickListener(new C13726(this));
        m7133t();
        OurApplication.m6289k().m6504i();
        OurApplication.m6289k().m6502g();
        setTitle(getString(R.string.dailyLogEditHeader_title, new Object[]{C1738c.m8514c(this.f4691g)}));
        C1116d a2 = C1114a.m5598a(this.f4690Z, OurApplication.af(), this.ag.mo913a()).m5635a();
        if (a2.m5665q()) {
            this.f4680P.setText(DailyLogUtils.m4296a(a2.m5659I()));
        } else {
            findViewById(R.id.dailyLogEditHeader_truckTotalEngineHoursSection).setVisibility(8);
            findViewById(R.id.dailyLogEditHeader_truckTotalEngineHoursTitle).setVisibility(8);
        }
        ac.m11179a(this.f4702r, this.f4690Z.getDriverName());
        if (bundle != null && bundle.containsKey(f4660b)) {
            string = bundle.getString(f4660b);
        } else if (this.f4690Z.hasCodriversDeprecated()) {
            string = this.f4690Z.getCodriversDeprecated();
        } else {
            string = null;
        }
        this.f4696l = string;
        if (bundle != null && bundle.containsKey(f4661c)) {
            valueOf = Long.valueOf(bundle.getLong(f4661c));
        } else if (this.f4690Z.hasCodriverId()) {
            valueOf = Long.valueOf(this.f4690Z.getCodriverId());
        } else {
            valueOf = null;
        }
        this.f4697m = valueOf;
        m7125p();
        Fleet b = this.ai.m11013b();
        InstantAutoComplete instantAutoComplete = this.f4707w;
        if (b == null || !b.hasDotNumber()) {
            charSequence = "";
        } else {
            charSequence = String.valueOf(b.getDotNumber());
        }
        instantAutoComplete.setText(charSequence);
        ac.m11179a(this.f4709y, this.f4690Z.getHomeTerminalAddress());
        EditText editText = this.f4676L;
        if (this.f4690Z.hasTotalDistance()) {
            charSequence = Integer.toString(this.f4690Z.getTotalDistance());
        } else {
            charSequence = null;
        }
        ac.m11179a(editText, charSequence);
        if (this.f4690Z.hasTotalDistanceUnit()) {
            this.f4695k = OdometerUnit.m14668a(this.f4690Z.getTotalDistanceUnit());
            this.f4677M.setText(com.bigroad.shared.af.m4153a(this.f4695k));
            this.f4677M.setVisibility(0);
        } else {
            this.f4677M.setVisibility(8);
        }
        ac.m11179a(this.f4688X, this.f4690Z.getRemarks());
        if (getIntent().getBooleanExtra("com.bigroad.ttb.isFixing", false)) {
            findViewById(R.id.dailyLogEditHeader_nextValidationText).setVisibility(0);
        }
        this.aa.m8474a(this.ap);
        this.ab.m10012a(this.aq);
        this.ac.m6559a(this.ar);
        this.ak = this.ad.m11297a(this.f4691g);
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(f4662d);
            stringArrayList = bundle.getStringArrayList(f4663e);
            list = parcelableArrayList;
            stringArrayList2 = bundle.getStringArrayList(f4664f);
        } else {
            stringArrayList2 = null;
            stringArrayList = null;
            list = null;
        }
        if (list == null && this.f4690Z.hasDailyLogTruckList()) {
            ArrayList arrayList = new ArrayList();
            for (TTProtocol.DailyLogTruck parcelableTruckSection : this.f4690Z.getDailyLogTruckList().getDailyLogTruckList()) {
                arrayList.add(new ParcelableTruckSection(parcelableTruckSection));
            }
            list = arrayList;
        }
        if (stringArrayList == null) {
            this.f4698n = new ArrayList(this.f4690Z.getShipmentsList());
        } else {
            this.f4698n = new ArrayList(stringArrayList);
        }
        if (stringArrayList2 == null) {
            this.f4699o = new ArrayList(this.f4690Z.getTrailersList());
        } else {
            this.f4699o = new ArrayList(stringArrayList2);
        }
        this.an = new ArrayList();
        this.am = new ArrayList();
        this.f4700p = new C2466o(this);
        m7103a(list);
        if (this.am.isEmpty()) {
            ac.m11179a(this.f4706v, this.f4690Z.getCarrierName());
            ac.m11179a(this.f4708x, this.f4690Z.getCarrierAddress());
        } else {
            this.f4706v.setEnabled(false);
            this.f4708x.setEnabled(false);
            if (b != null) {
                this.f4706v.setText(b.getName());
                instantAutoComplete = this.f4708x;
                String str2 = ", ";
                Object[] objArr = new Object[5];
                if (b.hasAddress1()) {
                    string = b.getAddress1();
                } else {
                    string = null;
                }
                objArr[0] = string;
                if (b.hasAddress2()) {
                    string = b.getAddress2();
                } else {
                    string = null;
                }
                objArr[1] = string;
                if (b.hasCity()) {
                    string = b.getCity();
                } else {
                    string = null;
                }
                objArr[2] = string;
                if (b.hasState()) {
                    string = b.getState();
                } else {
                    string = null;
                }
                objArr[3] = string;
                if (b.hasPostalCode()) {
                    str = b.getPostalCode();
                }
                objArr[4] = str;
                instantAutoComplete.setText(am.m4187a(str2, objArr));
            }
        }
        mo932m();
        this.f4693i = m7129r();
        this.f4694j = m7131s();
        m7123o();
        mo933n();
        setResult(-1);
    }

    protected void onResume() {
        super.onResume();
        m7129r();
        m7131s();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ac.m11184a(this.f4683S, this.f4685U, this.f4687W);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!am.m4188a(this.f4696l)) {
            bundle.putString(f4660b, this.f4696l);
        }
        if (this.f4697m != null) {
            bundle.putLong(f4661c, this.f4697m.longValue());
        }
        ArrayList arrayList = new ArrayList(this.an.size());
        for (DailyLogEditHeaderTruckView parcelableTruckSection : this.an) {
            arrayList.add(new ParcelableTruckSection(parcelableTruckSection));
        }
        bundle.putParcelableArrayList(f4662d, arrayList);
        bundle.putStringArrayList(f4663e, this.f4698n);
        bundle.putStringArrayList(f4664f, this.f4699o);
    }

    public int a_() {
        return this.f4691g;
    }

    public void onBackPressed() {
        setResult(0);
        m7138w();
    }

    protected void onDestroy() {
        this.aa.m8483b(this.ap);
        this.ab.m10029b(this.aq);
        this.ac.m6568b(this.ar);
        this.f4700p = null;
        if (this.an != null) {
            for (DailyLogEditHeaderTruckView c : this.an) {
                c.m11811c();
            }
        }
        super.onDestroy();
    }

    private void m7125p() {
        ct ctVar = null;
        if (this.f4697m != null) {
            this.f4696l = null;
        }
        if (this.f4696l != null) {
            this.f4703s.setText(this.f4696l);
        } else {
            if (this.f4697m != null) {
                ctVar = this.ah.m12138a(this.f4697m.longValue());
            }
            if (ctVar == null) {
                this.f4703s.setText("");
            } else {
                this.f4703s.setText(ah.m4160a(ctVar));
            }
        }
        if (this.f4697m == null && this.f4696l == null) {
            this.f4705u.setVisibility(8);
        } else {
            this.f4705u.setVisibility(0);
        }
    }

    private void m7127q() {
        for (int i = 0; i < this.an.size(); i++) {
            ((DailyLogEditHeaderTruckView) this.an.get(i)).m11807a(i);
        }
        if (this.an.isEmpty() && this.am.isEmpty()) {
            this.f4670F.setVisibility(0);
            this.f4671G.setVisibility(!OurApplication.m6252I().m11405c() ? 8 : 0);
        } else {
            this.f4670F.setVisibility(8);
            this.f4671G.setVisibility(8);
        }
        if (this.am.size() + this.an.size() > 1) {
            this.f4675K.setVisibility(0);
            if (this.am.size() > 0) {
                this.f4676L.setEnabled(false);
                this.f4678N.setVisibility(0);
                this.f4679O.setVisibility(0);
            } else {
                this.f4676L.setEnabled(true);
                this.f4678N.setVisibility(8);
                this.f4679O.setVisibility(8);
            }
        } else {
            this.f4675K.setVisibility(8);
        }
        if (!this.am.isEmpty()) {
            this.f4700p.m12119a();
        }
    }

    private void m7104a(boolean z) {
        boolean r = m7129r();
        if (!this.f4692h) {
            return;
        }
        if (z || (this.f4693i && !r)) {
            mo930f();
            if (z) {
                this.f4693i = true;
            }
            m7129r();
        }
    }

    private void m7108b(boolean z) {
        boolean s = m7131s();
        if (!this.f4692h) {
            return;
        }
        if (z || (this.f4694j && !s)) {
            m7145g();
            if (z) {
                this.f4694j = true;
            }
            m7131s();
        }
    }

    private boolean m7129r() {
        this.f4710z.removeAllViews();
        String string = getResources().getString(R.string.dailyLogHeader_currentSuffix);
        String b = this.aj.m8387b();
        boolean z = false;
        for (int i = 0; i < this.f4698n.size(); i++) {
            CharSequence charSequence;
            String str = (String) this.f4698n.get(i);
            if (this.f4692h && am.m4189a(str, b)) {
                z = true;
                charSequence = str + " " + string;
            } else {
                Object obj = str;
            }
            View inflate = this.f4701q.inflate(R.layout.daily_log_edit_removable_entry, null);
            ((EditText) inflate.findViewById(R.id.dailyLogEditHeader_removableEntryValue)).setText(charSequence);
            inflate.findViewById(R.id.dailyLogEditHeader_removableEntryButton).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ DailyLogEditHeaderActivity f4648b;

                public void onClick(View view) {
                    this.f4648b.f4698n.remove(i);
                    this.f4648b.m7104a(false);
                }
            });
            this.f4710z.addView(inflate);
        }
        mo933n();
        return z;
    }

    private boolean m7131s() {
        this.f4667C.removeAllViews();
        String string = getResources().getString(R.string.dailyLogHeader_currentSuffix);
        String a = this.aj.m8384a();
        boolean z = false;
        for (int i = 0; i < this.f4699o.size(); i++) {
            CharSequence charSequence;
            String str = (String) this.f4699o.get(i);
            if (this.f4692h && am.m4189a(str, a)) {
                z = true;
                charSequence = str + " " + string;
            } else {
                Object obj = str;
            }
            View inflate = this.f4701q.inflate(R.layout.daily_log_edit_removable_entry, null);
            ((EditText) inflate.findViewById(R.id.dailyLogEditHeader_removableEntryValue)).setText(charSequence);
            inflate.findViewById(R.id.dailyLogEditHeader_removableEntryButton).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ DailyLogEditHeaderActivity f4650b;

                public void onClick(View view) {
                    this.f4650b.f4699o.remove(i);
                    this.f4650b.m7108b(false);
                }
            });
            this.f4667C.addView(inflate);
        }
        if (this.f4699o.size() >= 50) {
            this.f4668D.setVisibility(8);
            this.f4669E.setVisibility(8);
        } else {
            this.f4668D.setVisibility(0);
            this.f4669E.setVisibility(0);
        }
        mo933n();
        return z;
    }

    protected void mo930f() {
        if (this.f4698n.isEmpty()) {
            this.aj.m8389b("");
        } else {
            this.aj.m8389b((String) this.f4698n.get(0));
        }
    }

    protected void m7145g() {
        if (this.f4699o.isEmpty()) {
            this.aj.m8386a("");
        } else {
            this.aj.m8386a((String) this.f4699o.get(0));
        }
    }

    private void m7103a(List<ParcelableTruckSection> list) {
        this.an.clear();
        if (list != null) {
            for (ParcelableTruckSection a : list) {
                DailyLogEditHeaderTruckView a2 = DailyLogEditHeaderTruckView.m11805a(this, a);
                if (a2 != null) {
                    m7107b(a2);
                }
            }
        }
        m7135u();
        m7127q();
    }

    private void m7133t() {
        int i;
        int i2 = 0;
        if (this.ai.m11021g()) {
            i = 1;
        } else {
            for (Truck truckLogType : this.ac.m6573c()) {
                TruckLogType a = TruckLogType.m15634a(truckLogType.getTruckLogType());
                if (a != TruckLogType.ELD && a != TruckLogType.AOBRD) {
                    i = 1;
                    break;
                }
            }
            i = 0;
        }
        Button button = this.f4681Q;
        if (i == 0) {
            i2 = 8;
        }
        button.setVisibility(i2);
    }

    private void m7135u() {
        this.am.clear();
        this.f4673I.removeAllViews();
        List<C1108a> arrayList = new ArrayList(C1108a.m5498a(this.f4690Z.getAutoDailyLogTruckList()));
        arrayList.addAll(C1108a.m5497a(this.f4690Z.getLogDay(), this.f4690Z.getTimezoneId(), this.f4690Z.hasDriverApproval(), OurApplication.af(), this.ag.mo914b()));
        Collections.sort(arrayList, C1108a.f3622a);
        for (C1108a dailyLogEditHeaderTruckView : arrayList) {
            m7107b(new DailyLogEditHeaderTruckView(this, dailyLogEditHeaderTruckView));
        }
        this.f4673I.requestLayout();
    }

    private DailyLogEditHeaderTruckView m7096a(Truck truck) {
        DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView;
        C2602a a = TTProtocol.DailyLogTruck.newBuilder().m13319a(truck.getTruckNumber());
        if (truck.hasTruckLicense()) {
            a.m13322b(truck.getTruckLicense());
        }
        if (truck.hasOdometerUnit()) {
            a.m13327d(truck.getOdometerUnit());
        }
        Integer num = null;
        Truck f = this.ac.m6578f();
        if (f != null && f.getHasAobrd() && am.m4189a(f.getTruckNumber(), truck.getTruckNumber())) {
            C2177b l = OurApplication.m6252I().m11414l();
            if (l != null) {
                num = Integer.valueOf(l.m10801a(f));
            }
        } else {
            int size = this.an.size() - 1;
            Integer num2 = null;
            while (size >= 0) {
                dailyLogEditHeaderTruckView = (DailyLogEditHeaderTruckView) this.an.get(size);
                if (am.m4189a(truck.getTruckNumber(), dailyLogEditHeaderTruckView.mo823b())) {
                    num2 = dailyLogEditHeaderTruckView.mo780g();
                    if (num2 == null) {
                        num = dailyLogEditHeaderTruckView.mo779f();
                    } else {
                        num = num2;
                    }
                    if (num != null) {
                        break;
                    }
                } else {
                    num = num2;
                }
                size--;
                num2 = num;
            }
            num = num2;
            if (num == null) {
                DailyLog c = this.aa.m8486c(this.f4690Z.getLogDay());
                if (c != null) {
                    num = DailyLogUtils.m4295a(DailyLogOdometerSearchType.START_OR_END_ODOMETER, C1114a.m5598a(c, OurApplication.af(), this.ag.mo914b()).m5635a(), truck.getTruckNumber());
                }
            }
        }
        if (num != null) {
            a.m13316a(num.intValue());
        }
        dailyLogEditHeaderTruckView = new DailyLogEditHeaderTruckView(this, a.m13325c());
        dailyLogEditHeaderTruckView.m11810b(true);
        m7107b(dailyLogEditHeaderTruckView);
        m7127q();
        mo933n();
        return dailyLogEditHeaderTruckView;
    }

    private void m7107b(DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView) {
        View d = dailyLogEditHeaderTruckView.m11812d();
        d.setLayoutParams(new LayoutParams(-1, -2));
        if (dailyLogEditHeaderTruckView.m11818j() == TruckLogType.ELECTRONIC) {
            this.an.add(dailyLogEditHeaderTruckView);
            this.f4674J.addView(d);
            return;
        }
        this.am.add(dailyLogEditHeaderTruckView);
        this.f4673I.addView(d);
    }

    public void m7142a(DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView) {
        ConfirmRemoveTruckDialogFragment.m7068a(this, dailyLogEditHeaderTruckView.m11813e());
    }

    private void m7110d(int i) {
        if (i >= 0 && i < this.an.size()) {
            DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView = (DailyLogEditHeaderTruckView) this.an.get(i);
            this.an.remove(i);
            this.f4674J.removeView(dailyLogEditHeaderTruckView.m11812d());
            dailyLogEditHeaderTruckView.m11811c();
            if (this.an.size() == 1) {
                ((DailyLogEditHeaderTruckView) this.an.get(0)).m11822n();
            }
            m7127q();
            mo933n();
        }
    }

    private void m7137v() {
        C2582a newBuilder = DailyLog.newBuilder(this.f4690Z);
        String trim = this.f4702r.getText().toString().trim();
        if (am.m4188a((CharSequence) trim)) {
            newBuilder.m13096m();
        } else {
            newBuilder.m13061b(trim);
        }
        if (this.f4696l == null && this.f4697m == null) {
            newBuilder.m13036N().m13099p();
        } else if (this.f4697m != null) {
            newBuilder.m13099p().m13088h(this.f4697m.longValue());
        } else {
            newBuilder.m13036N().m13067c(this.f4696l);
        }
        trim = this.f4688X.getText().toString();
        if (am.m4188a((CharSequence) trim)) {
            newBuilder.m13106w();
        } else {
            newBuilder.m13082f(trim);
        }
        newBuilder.m13098o().m13038P().m13060b(this.f4699o);
        trim = this.f4706v.getText().toString();
        if (am.m4188a((CharSequence) trim)) {
            newBuilder.m13103t();
        } else {
            newBuilder.m13073d(trim);
        }
        trim = this.f4708x.getText().toString();
        if (am.m4188a((CharSequence) trim)) {
            newBuilder.m13104u();
        } else {
            newBuilder.m13078e(trim);
        }
        trim = this.f4709y.getText().toString();
        if (am.m4188a((CharSequence) trim)) {
            newBuilder.m13107x();
        } else {
            newBuilder.m13086g(trim);
        }
        newBuilder.m13105v().m13040R().m13066c(this.f4698n);
        C2604a newBuilder2 = DailyLogTruckList.newBuilder();
        for (DailyLogEditHeaderTruckView o : this.an) {
            TTProtocol.DailyLogTruck o2 = o.m11823o();
            newBuilder2.m13347a(o2);
            this.ac.m6562a(o2);
        }
        newBuilder.m13097n();
        newBuilder.m13047a(newBuilder2);
        newBuilder.m13100q();
        newBuilder.m13101r();
        newBuilder.m13102s();
        newBuilder.m13028F();
        if (this.am.isEmpty()) {
            Integer i;
            if (this.an.size() == 1) {
                i = ((DailyLogEditHeaderTruckView) this.an.get(0)).mo781i();
                if (i != null) {
                    newBuilder.m13071d(i.intValue());
                }
                OdometerUnit t = ((DailyLogEditHeaderTruckView) this.an.get(0)).mo782t();
                if (t != null) {
                    newBuilder.m13080f(t.m14669a());
                }
            } else if (this.an.size() > 1) {
                i = ac.m11173a(this.f4676L);
                if (i != null) {
                    newBuilder.m13071d(i.intValue());
                }
                if (this.f4695k != null) {
                    newBuilder.m13080f(this.f4695k.m14669a());
                }
            }
        }
        this.f4690Z = newBuilder.m13069c();
        this.aa.m8484b(this.f4690Z);
    }

    private void m7138w() {
        CharSequence obj = this.f4665A.getText().toString();
        if (!am.m4188a(obj)) {
            this.f4698n.add(obj);
        }
        obj = this.f4668D.getText().toString();
        if (!am.m4188a(obj)) {
            this.f4699o.add(obj);
        }
        this.ae.m8374a(this.f4702r, 7);
        this.ae.m8374a(this.f4688X, 13);
        this.ae.m8374a(this.f4706v, 6);
        this.ae.m8374a(this.f4708x, 11);
        this.ae.m8374a(this.f4709y, 11);
        Iterator it = this.f4698n.iterator();
        while (it.hasNext()) {
            this.ae.m8377a((String) it.next(), 12);
        }
        it = this.f4699o.iterator();
        while (it.hasNext()) {
            this.ae.m8377a((String) it.next(), 4);
        }
        for (DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView : this.an) {
            this.ae.m8377a(dailyLogEditHeaderTruckView.mo823b(), 1);
            this.ae.m8377a(dailyLogEditHeaderTruckView.m11819k(), 8);
        }
        m7137v();
        m7140x();
    }

    private void m7140x() {
        String str = null;
        if (this.f4691g == C1738c.m8516e(this.f4690Z)) {
            Truck f = this.ac.m6578f();
            String truckNumber = f != null ? f.getTruckNumber() : null;
            for (int size = this.an.size() - 1; size >= 0; size--) {
                DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView = (DailyLogEditHeaderTruckView) this.an.get(size);
                if (dailyLogEditHeaderTruckView.m11816h()) {
                    str = dailyLogEditHeaderTruckView.mo823b();
                    break;
                }
            }
            f = this.ac.m6572c(str);
            if (f == null || !f.getHasAobrd()) {
                if (truckNumber == null && str != null) {
                    this.ac.m6577e(str);
                } else if (!(str == null || am.m4189a(str, truckNumber))) {
                    ConfirmUsingTruckDialogFragment.m8829a(this, str);
                    return;
                }
            }
        }
        finish();
    }

    public void mo980a(String str) {
        finish();
    }

    public TextWatcher mo974h() {
        return this.ao;
    }

    public C2466o mo961i() {
        return this.f4700p;
    }

    public List<DailyLogEditHeaderTruckView> mo962j() {
        return this.an;
    }

    public List<DailyLogEditHeaderTruckView> mo963k() {
        return this.am;
    }

    public OdometerUnit mo931l() {
        return this.f4695k;
    }

    public void mo979a(C0859a c0859a) {
        if (c0859a.m4282f()) {
            int i;
            this.f4695k = c0859a.m4280d();
            if (c0859a.m4277a()) {
                CharSequence num = Integer.toString(c0859a.m4279c().intValue());
                if (!am.m4189a(this.f4676L.getText().toString().trim(), (String) num)) {
                    ac.m11179a(this.f4676L, num);
                }
            } else {
                this.f4676L.setText("");
            }
            if (this.f4695k != null) {
                this.f4677M.setText(com.bigroad.shared.af.m4153a(this.f4695k));
            }
            TextView textView = this.f4677M;
            if (this.f4695k != null) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    protected void mo932m() {
        this.f4702r.addTextChangedListener(this.ao);
        this.f4668D.addTextChangedListener(this.ao);
        this.f4706v.addTextChangedListener(this.ao);
        this.f4708x.addTextChangedListener(this.ao);
        this.f4709y.addTextChangedListener(this.ao);
        this.f4665A.addTextChangedListener(this.ao);
        this.al.m10486a();
        this.al.m10488a(Field.DRIVER_NAME, R.id.dailyLogEditHeader_driverNameError, R.id.dailyLogEditHeader_driverNameErrorText);
        this.al.m10488a(Field.TRAILERS, R.id.dailyLogEditHeader_trailersError, R.id.dailyLogEditHeader_trailersErrorText);
        this.al.m10488a(Field.CARRIER_NAME, R.id.dailyLogEditHeader_carrierNameError, R.id.dailyLogEditHeader_carrierNameErrorText);
        this.al.m10488a(Field.CARRIER_ADDRESS, R.id.dailyLogEditHeader_carrierAddressError, R.id.dailyLogEditHeader_carrierAddressErrorText);
        this.al.m10488a(Field.HOME_TERMINAL, R.id.dailyLogEditHeader_homeTerminalError, R.id.dailyLogEditHeader_homeTerminalErrorText);
        this.al.m10488a(Field.SHIPMENTS, R.id.dailyLogEditHeader_shipmentsError, R.id.dailyLogEditHeader_shipmentsErrorText);
        this.f4676L.addTextChangedListener(this.ao);
        this.al.m10488a(Field.TOTAL_DISTANCE, R.id.dailyLogEditHeader_truckTotalDistanceError, R.id.dailyLogEditHeader_truckTotalDistanceErrorText);
    }

    protected void mo933n() {
        int i;
        int i2 = 1;
        DailyLogHeader c1377a = new C1377a(this);
        new C1162b(this.ak).m5925a(c1377a, c1377a.m7090u(), a_());
        this.al.m10487a(c1377a.mo716A(), this);
        List i3 = c1377a.mo832i();
        if (i3.size() != this.an.size()) {
            i = 1;
        } else {
            DailyLogTruck dailyLogTruck;
            DailyLogEditHeaderTruckView dailyLogEditHeaderTruckView;
            Iterator it = i3.iterator();
            Iterator it2 = this.an.iterator();
            while (it.hasNext() && it2.hasNext()) {
                dailyLogTruck = (DailyLogTruck) it.next();
                dailyLogEditHeaderTruckView = (DailyLogEditHeaderTruckView) it2.next();
                if (!am.m4189a(dailyLogTruck.mo823b(), dailyLogEditHeaderTruckView.mo823b())) {
                    break;
                }
                dailyLogEditHeaderTruckView.m11808a(dailyLogTruck.mo716A(), (Context) this);
            }
            i2 = 0;
            i3 = new ArrayList(c1377a.mo833j());
            i3.addAll(c1377a.mo834k());
            it = i3.iterator();
            it2 = this.am.iterator();
            while (it.hasNext() && it2.hasNext()) {
                dailyLogTruck = (DailyLogTruck) it.next();
                dailyLogEditHeaderTruckView = (DailyLogEditHeaderTruckView) it2.next();
                if (!am.m4189a(dailyLogTruck.mo823b(), dailyLogEditHeaderTruckView.mo823b())) {
                    dailyLogEditHeaderTruckView.m11808a(new C1176p(), (Context) this);
                    i = i2;
                    break;
                }
                dailyLogEditHeaderTruckView.m11808a(dailyLogTruck.mo716A(), (Context) this);
                dailyLogEditHeaderTruckView.m11808a(dailyLogTruck.mo716A(), (Context) this);
            }
            i = i2;
        }
        C2091e.m10480a(Field.TRUCKS, c1377a.mo716A(), this.f4670F, this.f4672H, this);
        C2091e.m10480a(Field.TOTAL_DISTANCE, c1377a.mo716A(), this.f4676L, this.f4679O, this);
        List b = c1377a.mo716A().m5961b(Field.SHIPMENTS);
        if (C1178r.m5980a(b, ErrorCode.IS_EMPTY)) {
            TextView textView = (TextView) findViewById(R.id.dailyLogEditHeader_shipmentsErrorText);
            CharSequence string = getResources().getString(R.string.dailyLogEditHeader_shippingRequired1);
            String string2 = getResources().getString(R.string.dailyLogEditHeader_shippingRequired2);
            CharSequence newSpannable = Factory.getInstance().newSpannable(string2);
            newSpannable.setSpan(new C13759(this), 0, string2.length(), 33);
            newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.validationError)), 0, string2.length(), 33);
            b = C1178r.m5985c(b, ErrorCode.IS_EMPTY);
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(string).append(" ").append(newSpannable).append(".");
            if (!b.isEmpty()) {
                spannableStringBuilder.append(System.getProperty("line.separator"));
                spannableStringBuilder.append(C2091e.m10476a(b, (Context) this));
            }
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        i3 = c1377a.mo716A().m5961b(Field.TOTAL_DISTANCE);
        if (C1178r.m5980a(i3, ErrorCode.DAILY_LOG_HEADER_TOTAL_DISTANCE_INCORRECT)) {
            C0859a a = DailyLogUtils.m4290a(this.f4695k, this.an, this.am, Collections.emptyList());
            if (a.m4277a()) {
                C2466o.m12118a(i3, ErrorCode.DAILY_LOG_HEADER_TOTAL_DISTANCE_INCORRECT, this.f4676L, (TextView) findViewById(R.id.dailyLogEditHeader_truckTotalDistanceErrorText), Integer.toString(a.m4279c().intValue()), this.f4695k, this);
            }
        }
        if (i != 0) {
            C2134e.m10682e("TT-LogEditHeader", "Validated truck list didn't match managed truck views");
            finish();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            if (i == 13) {
                Truck a = TruckManager.m6538a(intent.getByteArrayExtra("com.bigroad.ttb.truck"));
                if (a != null) {
                    DailyLogEditHeaderTruckView a2 = m7096a(a);
                    a2.m11820l();
                    new C2302u(this).m11254a(a2.m11821m());
                    return;
                }
                C2134e.m10682e("TT-LogEditHeader", "Unexpected empty truck from SelectTruckActivity");
            } else if (i == 9) {
                long longExtra = intent.getLongExtra("com.bigroad.ttb.personId", -1);
                if (longExtra >= 0) {
                    this.f4697m = Long.valueOf(longExtra);
                    m7125p();
                }
            }
        }
    }
}
