package com.bigroad.ttb.android.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.TypedArray;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.C0586c.C0584a;
import android.support.v7.widget.am;
import android.support.v7.widget.am.C0729b;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.UserAuthenticationChangeBits;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ap;
import com.bigroad.shared.ap.C0842a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C1792d;
import com.bigroad.ttb.android.C2081g;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.C2224p;
import com.bigroad.ttb.android.C2272u;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.DrivingModeManager;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.activity.C1635b.C1266a;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.ad;
import com.bigroad.ttb.android.ak;
import com.bigroad.ttb.android.ak.C1536a;
import com.bigroad.ttb.android.ak.C1722b;
import com.bigroad.ttb.android.dialog.C1843a;
import com.bigroad.ttb.android.dialog.C1847e;
import com.bigroad.ttb.android.dialog.C1847e.C1537a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventSource;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p030a.C1257b;
import com.bigroad.ttb.android.util.C2287h;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.android.util.LockOutScreen;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.android.widget.C2451a;
import com.bigroad.ttb.android.widget.CustomTitleBar;
import com.bigroad.ttb.android.widget.CustomTitleBar.C1547a;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import java.util.EnumSet;
import java.util.Locale;

public abstract class OurActivity extends AppCompatActivity implements C1266a {
    private static int f4323a = 475;
    private static final String f4324b = (OurActivity.class.getName() + ".titleStyle");
    private static final String f4325c = (OurActivity.class.getName() + ".isDrawerOpen");
    private static final long[] f4326d = new long[]{0, 250, 200, 250, 200};
    private final OnDismissListener f4327A;
    private final ChangeListener f4328B;
    private final C1230a f4329C;
    private final C1536a f4330D;
    private ag<C1549b> f4331E;
    private final com.bigroad.ttb.android.ag f4332e;
    private final EnumSet<Feature> f4333f;
    private final TitleStyle f4334g;
    private TitleStyle f4335h;
    private C1635b f4336i;
    private final ad f4337j;
    private final C2474y f4338k;
    private final AuthMonitor f4339l;
    private final EventManager f4340m;
    private final ap f4341n;
    private final VehicleConnectionManager f4342o;
    private final C2081g f4343p;
    private final DrivingModeManager f4344q;
    private final ak f4345r;
    private final TruckManager f4346s;
    private Handler f4347t;
    private C2272u f4348u;
    private C1551c f4349v;
    private boolean f4350w;
    private boolean f4351x;
    private final C1185a f4352y;
    private final C1182a f4353z;

    class C15381 implements C1185a {
        final /* synthetic */ OurActivity f5369a;

        C15381(OurActivity ourActivity) {
            this.f5369a = ourActivity;
        }

        public void mo912a(AuthStatus authStatus) {
            this.f5369a.mo931l();
        }
    }

    class C15392 implements OnGlobalLayoutListener {
        final /* synthetic */ OurActivity f5370a;

        C15392(OurActivity ourActivity) {
            this.f5370a = ourActivity;
        }

        public void onGlobalLayout() {
            if (this.f5370a.m6692K() != null) {
                this.f5370a.f4336i.m8024b(this.f5370a.m6692K().getCustomViewXOnScreen());
            }
        }
    }

    class C15403 implements OnClickListener {
        final /* synthetic */ OurActivity f5371a;

        C15403(OurActivity ourActivity) {
            this.f5371a = ourActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5371a.f4344q.m6188a(Reason.USER_SIGN_OUT_AND_OFF_DUTY);
            C2287h.m11214a(DutyStatus.OFF_DUTY, DutyStatusChangeBits.Reason.OFF_DUTY_AND_SIGN_OUT, EventSource.USER, true);
        }
    }

    class C15414 implements OnClickListener {
        final /* synthetic */ OurActivity f5372a;

        C15414(OurActivity ourActivity) {
            this.f5372a = ourActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5372a.f4344q.m6188a(Reason.USER_SIGN_OUT);
            this.f5372a.f4337j.m8038a(this.f5372a, UserAuthenticationChangeBits.Reason.EXPLICIT_SIGN_OUT);
        }
    }

    class C15425 implements OnClickListener {
        final /* synthetic */ OurActivity f5373a;

        C15425(OurActivity ourActivity) {
            this.f5373a = ourActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C1632a.m7944a(this.f5373a);
        }
    }

    class C15447 extends C1183b {
        final /* synthetic */ OurActivity f5377a;

        C15447(OurActivity ourActivity) {
            this.f5377a = ourActivity;
        }

        public void mo866c(C2474y c2474y) {
            this.f5377a.mo932m();
        }
    }

    class C15458 implements OnDismissListener {
        final /* synthetic */ OurActivity f5378a;

        C15458(OurActivity ourActivity) {
            this.f5378a = ourActivity;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5378a.f4350w = false;
        }
    }

    class C15469 extends C1201a {
        final /* synthetic */ OurActivity f5379a;

        C15469(OurActivity ourActivity) {
            this.f5379a = ourActivity;
        }

        public void mo891a(MotionType motionType) {
            this.f5379a.mo933n();
            C1635b f = this.f5379a.f4336i;
            boolean z = this.f5379a.f4335h == TitleStyle.IDENTITY && motionType != MotionType.MOVING;
            f.m8023a(z);
        }
    }

    public enum Feature {
        FINISH_ON_SIGN_OUT,
        DEFAULT_MENU,
        FINISH_ON_FLEET_LOSS,
        DASH_LINK_STATE,
        ALLOW_TRIAL_USER_CONVERSION,
        PORTRAIT_ONLY_ON_SMALL_DEVICES
    }

    public enum TitleStyle {
        DEFAULT,
        IDENTITY,
        NONE
    }

    private class C1548a implements C0729b, C1547a {
        final /* synthetic */ OurActivity f5391a;

        private C1548a(OurActivity ourActivity) {
            this.f5391a = ourActivity;
        }

        public void mo1014a(am amVar, boolean z) {
            if (amVar != null) {
                Menu a = amVar.m3647a();
                for (int i = 0; i < a.size(); i++) {
                    if (a.getItem(i).getItemId() != R.id.menu_signOut) {
                        a.getItem(i).setEnabled(z);
                    }
                }
            }
        }

        public void mo1013a(am amVar) {
            amVar.m3648a((int) R.menu.default_menu);
            amVar.m3651a((C0729b) this);
        }

        public boolean mo1015a(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_settings:
                    C1632a.m7990f(this.f5391a);
                    return true;
                case R.id.menu_switchTrucks:
                    C1632a.m7977b(this.f5391a, EnumSet.of(Option.LOAD_TRUCK_LIST, Option.ALLOW_UNKNOWN_TRUCK));
                    return true;
                case R.id.menu_signOut:
                    this.f5391a.f4337j.m8039a(this.f5391a);
                    return true;
                default:
                    return false;
            }
        }
    }

    public interface C1549b {
        void mo1271a(int i, boolean z);
    }

    private class C1551c implements Runnable {
        final /* synthetic */ OurActivity f5393a;
        private boolean f5394b;
        private long f5395c;
        private long f5396d;
        private Runnable f5397e;
        private final C0842a f5398f = new C15501(this);

        class C15501 implements C0842a {
            final /* synthetic */ C1551c f5392a;

            C15501(C1551c c1551c) {
                this.f5392a = c1551c;
            }

            public void mo1016a() {
                this.f5392a.m7740c();
            }
        }

        public C1551c(OurActivity ourActivity, long j, long j2, Runnable runnable) {
            this.f5393a = ourActivity;
            this.f5395c = j;
            this.f5396d = Math.max(1, j2);
            this.f5397e = runnable;
        }

        public void m7742a() {
            m7743b();
            this.f5393a.f4341n.m4201a(this.f5398f);
            this.f5394b = true;
            this.f5393a.m6701T().post(this);
        }

        public void m7743b() {
            this.f5393a.m6701T().removeCallbacks(this);
            this.f5394b = false;
            this.f5393a.f4341n.m4203b(this.f5398f);
        }

        private void m7740c() {
            if (this.f5394b) {
                this.f5393a.m6701T().removeCallbacks(this);
                m7741d();
            }
        }

        private void m7741d() {
            long a = this.f5393a.f4341n.mo913a();
            long b = this.f5393a.f4341n.mo914b();
            this.f5393a.m6701T().postDelayed(this, Math.min((((((this.f5395c + a) + this.f5396d) - 1) / this.f5396d) * this.f5396d) - a, (((((this.f5395c + b) + this.f5396d) - 1) / this.f5396d) * this.f5396d) - b) + 100);
        }

        public void run() {
            this.f5397e.run();
            m7741d();
        }
    }

    public OurActivity() {
        this(EnumSet.noneOf(Feature.class));
    }

    public OurActivity(Feature feature) {
        this(EnumSet.of(feature));
    }

    public OurActivity(EnumSet<Feature> enumSet) {
        this((EnumSet) enumSet, TitleStyle.DEFAULT);
    }

    public OurActivity(TitleStyle titleStyle) {
        this(EnumSet.noneOf(Feature.class), titleStyle);
    }

    public OurActivity(Feature feature, TitleStyle titleStyle) {
        this(EnumSet.of(feature), titleStyle);
    }

    public OurActivity(EnumSet<Feature> enumSet, TitleStyle titleStyle) {
        this.f4335h = null;
        this.f4336i = new C1635b(this);
        this.f4337j = OurApplication.ab();
        this.f4338k = OurApplication.m6285g();
        this.f4339l = OurApplication.m6249F();
        this.f4340m = OurApplication.m6295q();
        this.f4341n = OurApplication.m6269Z();
        this.f4342o = OurApplication.m6252I();
        this.f4343p = OurApplication.m6284f();
        this.f4344q = OurApplication.ah();
        this.f4345r = OurApplication.ag();
        this.f4346s = OurApplication.m6294p();
        this.f4350w = false;
        this.f4351x = false;
        this.f4352y = new C15381(this);
        this.f4353z = new C15447(this);
        this.f4327A = new C15458(this);
        this.f4328B = new C15469(this);
        this.f4329C = new C1231b(this) {
            final /* synthetic */ OurActivity f5360a;

            {
                this.f5360a = r1;
            }

            public void mo907a(boolean z) {
                this.f5360a.mo933n();
            }
        };
        this.f4330D = new C1536a(this) {
            final /* synthetic */ OurActivity f5361a;

            {
                this.f5361a = r1;
            }

            public void mo1011a(C1722b c1722b) {
                this.f5361a.mo933n();
            }
        };
        this.f4331E = new ag();
        this.f4333f = enumSet;
        this.f4334g = titleStyle;
        this.f4332e = OurApplication.m6282d();
    }

    public void m6691J() {
        if (C1632a.m8010o((Context) this)) {
            m6699R().m12211f(this.f4341n.mo913a());
            showDialog(1002);
        }
    }

    public CustomTitleBar m6692K() {
        return this.f4336i.m8018a();
    }

    public void m6693L() {
        m6712b(1011);
        m6712b(1004);
        m6712b(1012);
        mo1028d(1003);
    }

    public void m6694M() {
        m6712b(1003);
        m6712b(1004);
        m6712b(1012);
        mo1028d(1011);
    }

    public void m6695N() {
        m6712b(1003);
        m6712b(1011);
        m6712b(1012);
        mo1028d(1004);
    }

    public void m6696O() {
        m6712b(1003);
        m6712b(1011);
        m6712b(1004);
        mo1028d(1012);
    }

    public void m6697P() {
        showDialog(1006);
    }

    public void m6698Q() {
        showDialog(1001);
    }

    protected C2474y m6699R() {
        return this.f4338k;
    }

    protected AuthMonitor m6700S() {
        return this.f4339l;
    }

    protected Handler m6701T() {
        return this.f4347t;
    }

    protected com.bigroad.ttb.android.ag m6702U() {
        return this.f4332e;
    }

    private void mo1028d(int i) {
        if (!this.f4350w) {
            this.f4350w = true;
            showDialog(i);
            m6703V();
            m6704W();
        }
    }

    protected void m6703V() {
        ((Vibrator) getSystemService("vibrator")).vibrate(f4326d, -1);
    }

    protected void m6704W() {
        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(2));
        if (ringtone != null) {
            ringtone.play();
        }
    }

    protected void m6712b(int i) {
        try {
            dismissDialog(i);
        } catch (IllegalArgumentException e) {
            C2134e.m10676b("TT-OurActivity", "Ignoring request to dismiss dialog ID " + i + " (not showing)");
        }
    }

    private boolean mo930f() {
        return this.f4333f.contains(Feature.FINISH_ON_SIGN_OUT);
    }

    private boolean mo974h() {
        return this.f4333f.contains(Feature.DASH_LINK_STATE);
    }

    private boolean mo961i() {
        return this.f4333f.contains(Feature.DEFAULT_MENU);
    }

    private boolean mo962j() {
        return this.f4333f.contains(Feature.FINISH_ON_FLEET_LOSS);
    }

    public boolean m6705X() {
        return this.f4333f.contains(Feature.ALLOW_TRIAL_USER_CONVERSION);
    }

    private boolean mo963k() {
        return this.f4333f.contains(Feature.PORTRAIT_ONLY_ON_SMALL_DEVICES);
    }

    private void mo931l() {
        if (mo930f() && this.f4339l.m6030c()) {
            C2134e.m10678c("TT-OurActivity", "Signed out; finishing " + getClass().getSimpleName());
            setResult(2);
            finish();
        }
    }

    private void mo932m() {
        if (mo962j() && this.f4338k.m12213g() < 0) {
            C2134e.m10678c("TT-OurActivity", "No active fleet; finishing " + getClass().getSimpleName());
            setResult(1);
            finish();
        }
    }

    public int m6714c(int i) {
        TypedArray obtainStyledAttributes = obtainStyledAttributes(C2475a.CustomTheme);
        int resourceId = obtainStyledAttributes.getResourceId(i, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    protected void m6710a(long j, Runnable runnable) {
        m6709a(j, 1, runnable);
    }

    protected void m6709a(long j, long j2, Runnable runnable) {
        if (this.f4349v != null) {
            this.f4349v.m7743b();
        }
        this.f4349v = new C1551c(this, j, j2, runnable);
    }

    private Dialog m6676e(int i) {
        int i2;
        int i3;
        int i4;
        DutyStatus dutyStatus;
        boolean z = false;
        switch (i) {
            case 1003:
                i2 = R.string.dutyStatusDialog_startDrivingTitle;
                i3 = R.string.dutyStatusDialog_startDrivingMessage;
                i4 = R.string.dutyStatusDialog_startDrivingButton;
                dutyStatus = DutyStatus.DRIVING;
                z = true;
                break;
            case 1004:
                i2 = R.string.dutyStatusDialog_stopDrivingTitle;
                i3 = R.string.dutyStatusDialog_stopDrivingMessage;
                i4 = R.string.dutyStatusDialog_stopDrivingButton;
                dutyStatus = DutyStatus.ON_DUTY_NOT_DRIVING;
                break;
            case 1011:
                i2 = R.string.dutyStatusDialog_startOffDutyDrivingTitle;
                i3 = R.string.dutyStatusDialog_startOffDutyDrivingMessage;
                i4 = R.string.dutyStatusDialog_startOffDutyDrivingButton;
                dutyStatus = DutyStatus.OFF_DUTY_DRIVING;
                z = true;
                break;
            case 1012:
                i2 = R.string.dutyStatusDialog_stopOffDutyDrivingTitle;
                i3 = R.string.dutyStatusDialog_stopOffDutyDrivingMessage;
                i4 = R.string.dutyStatusDialog_stopOffDutyDrivingButton;
                dutyStatus = DutyStatus.OFF_DUTY;
                break;
            default:
                C2134e.m10682e("TT-OurActivity", "Unrecognized dialogId=" + i);
                return null;
        }
        OnClickListener anonymousClass12 = new OnClickListener(this) {
            final /* synthetic */ OurActivity f5363b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f5363b.f4340m.m10031b(dutyStatus, EventSource.GPS, DutyStatusChangeBits.m4034a(DutyStatusChangeBits.Reason.GPS_SELECTED_DIALOG, dutyStatus.m4392a()));
                dialogInterface.dismiss();
            }
        };
        OnCancelListener anonymousClass13 = new OnCancelListener(this) {
            final /* synthetic */ OurActivity f5366c;

            public void onCancel(DialogInterface dialogInterface) {
                if (z) {
                    this.f5366c.m6699R().m12214g(this.f5366c.f4341n.mo913a());
                } else {
                    this.f5366c.m6699R().m12217h(this.f5366c.f4341n.mo913a());
                }
                this.f5366c.f4332e.m8293a(dutyStatus);
            }
        };
        C1537a anonymousClass14 = new C1537a(this) {
            final /* synthetic */ OurActivity f5368b;

            public void mo1012a(DialogInterface dialogInterface) {
                this.f5368b.f4340m.m10031b(dutyStatus, EventSource.GPS, DutyStatusChangeBits.m4034a(DutyStatusChangeBits.Reason.GPS_AUTO_DIALOG, dutyStatus.m4392a()));
                dialogInterface.dismiss();
            }
        };
        Dialog c1847e = new C1847e(this);
        c1847e.m8919a(anonymousClass14);
        c1847e.setOnDismissListener(this.f4327A);
        c1847e.setCancelable(true);
        c1847e.m2694b(R.drawable.ic_dialog_alert_light);
        c1847e.setTitle(i2);
        c1847e.m2693a(getString(i3));
        c1847e.m2691a(-2, getString(17039360), C1843a.f6286a);
        c1847e.m2691a(-1, getString(i4), anonymousClass12);
        c1847e.setOnCancelListener(anonymousClass13);
        return c1847e;
    }

    public boolean m6706Y() {
        return getResources().getConfiguration().orientation == 2;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f4335h != null) {
            bundle.putSerializable(f4324b, this.f4335h);
            bundle.putBoolean(f4325c, this.f4336i.m8029d());
        }
    }

    protected TitleStyle mo1024a(TitleStyle titleStyle, Bundle bundle) {
        int d = C2291k.m11225d();
        if (bundle == null || !bundle.containsKey(f4324b) || d < 11 || d >= 17) {
            return titleStyle;
        }
        return (TitleStyle) bundle.getSerializable(f4324b);
    }

    protected Locale d_() {
        return null;
    }

    protected void attachBaseContext(Context context) {
        Locale d_ = d_();
        if (d_ == null) {
            d_ = OurApplication.aj();
        }
        super.attachBaseContext(C1257b.m6608a(context, d_));
    }

    protected void onCreate(Bundle bundle) {
        Integer num = null;
        super.onCreate(bundle);
        try {
            ActivityInfo activityInfo;
            PackageManager packageManager = getPackageManager();
            if (packageManager != null) {
                activityInfo = packageManager.getActivityInfo(getComponentName(), 0);
            } else {
                activityInfo = null;
            }
            if (activityInfo != null) {
                num = Integer.valueOf(activityInfo.labelRes);
            }
            if (num != null && num.intValue() > 0) {
                setTitle(getString(num.intValue()));
            }
        } catch (NameNotFoundException e) {
        }
        if (mo963k() && getResources().getConfiguration().smallestScreenWidthDp < f4323a) {
            setRequestedOrientation(7);
        }
        this.f4342o.m11399a(this.f4328B);
        this.f4343p.m10446a(this.f4329C);
        this.f4345r.m8424a(this.f4330D);
        this.f4335h = mo1024a(this.f4334g, bundle);
        this.f4347t = new Handler();
        this.f4348u = new C2272u(this);
        this.f4348u.m11136a();
        this.f4339l.m6027a(this.f4352y);
        mo931l();
        this.f4338k.m12184a(this.f4353z);
        mo932m();
        if (bundle != null) {
            this.f4351x = bundle.getBoolean(f4325c);
        }
    }

    protected void onPostCreate(Bundle bundle) {
        boolean z = false;
        super.onPostCreate(bundle);
        CustomTitleBar K = m6692K();
        if (K == null) {
            C2134e.m10678c("TT-OurActivity", "Skipping title bar init: no content view set for this activity.");
        } else if (this.f4335h == TitleStyle.NONE) {
            K.setVisibility(8);
        } else {
            boolean z2 = this.f4335h == TitleStyle.IDENTITY;
            boolean k = this.f4342o.m11413k();
            boolean z3;
            if (this.f4346s.m6578f() == null || this.f4346s.m6578f().getTruckLogType() == TruckLogType.ELECTRONIC.m15635a()) {
                z3 = true;
            } else {
                z3 = false;
            }
            C1635b c1635b = this.f4336i;
            if (z2 && (!k || r3)) {
                z = true;
            }
            c1635b.m8023a(z);
            if (z2) {
                View c2451a = new C2451a(this);
                K.setCustomView(c2451a);
                c2451a.getViewTreeObserver().addOnGlobalLayoutListener(new C15392(this));
            }
            if (mo961i()) {
                K.setMenuDelegate(new C1548a());
            }
            if (mo974h()) {
                K.setDashLinkButtonVisible(true);
            }
        }
    }

    public void setContentView(View view) {
        this.f4336i.m8020a(view);
    }

    public void setContentView(int i) {
        this.f4336i.m8019a(i);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        this.f4336i.m8021a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        this.f4336i.m8025b(view, layoutParams);
    }

    public void mo917a(int i) {
        super.setContentView(i);
    }

    protected void onStart() {
        super.onStart();
        this.f4332e.m8292a((Activity) this);
        this.f4348u.m11138c();
    }

    protected void onResume() {
        super.onResume();
        if (this.f4349v != null) {
            this.f4349v.m7742a();
        }
        this.f4343p.m10448b((Activity) this);
        this.f4336i.m8026b(this.f4351x);
    }

    protected void onPause() {
        if (this.f4349v != null) {
            this.f4349v.m7743b();
        }
        this.f4343p.m10445a((Activity) this);
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        this.f4336i.m8028c();
        this.f4332e.m8298b((Activity) this);
    }

    protected void onDestroy() {
        this.f4338k.m12194b(this.f4353z);
        this.f4339l.m6029b(this.f4352y);
        this.f4342o.m11404b(this.f4328B);
        this.f4343p.m10449b(this.f4329C);
        this.f4345r.m8425b(this.f4330D);
        this.f4348u.m11137b();
        if (this.f4349v != null) {
            this.f4349v.m7743b();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        setResult(1);
        super.onBackPressed();
    }

    protected Dialog onCreateDialog(int i) {
        C0584a c0584a;
        Dialog b;
        switch (i) {
            case 1001:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.signOutDialog_title).m2672b((int) R.string.signOutDialog_message).m2661a((int) R.string.signOutDialog_signOut, new C15414(this)).m2679c(R.string.signOutDialog_offDutySignOut, new C15403(this)).m2673b(17039360, C1843a.f6286a);
                return c0584a.m2677b();
            case 1002:
                return C1792d.m8817a((Context) this);
            case 1003:
            case 1004:
            case 1011:
            case 1012:
                return m6676e(i);
            case 1005:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.aobrdTransientMalfunctionDialog_title).m2672b((int) R.string.aobrdTransientMalfunctionDialog_message).m2661a(17039370, C1843a.f6286a);
                b = c0584a.m2677b();
                b.setOnDismissListener(this.f4327A);
                return b;
            case 1006:
                return new C0584a(this).m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.dutyStatusDialog_cantChangeDutyStatusTitle).m2672b((int) R.string.dutyStatusDialog_cantChangeDutyStatusMessage).m2661a(17039370, null).m2677b();
            case 1007:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.aobrdPermanentMalfunctionDialog_title).m2672b((int) R.string.aobrdPermanentMalfunctionDialog_message).m2661a(17039370, C1843a.f6286a);
                b = c0584a.m2677b();
                b.setOnDismissListener(this.f4327A);
                return b;
            case 1008:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.aobrdCalibrateOdometerDialog_title).m2672b((int) R.string.aobrdCalibrateOdometerDialog_message).m2661a(17039370, new C15425(this));
                b = c0584a.m2677b();
                b.setOnDismissListener(this.f4327A);
                return b;
            case 1009:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.aobrdSwitchedFirmwareOdometerDialog_title).m2672b((int) R.string.aobrdSwitchedFirmwareOdometerDialog_message).m2661a(17039370, C1843a.f6286a);
                b = c0584a.m2677b();
                b.setOnDismissListener(this.f4327A);
                return b;
            case 1010:
                c0584a = new C0584a(this);
                c0584a.m2678c(R.drawable.ic_dialog_alert_light).m2659a((int) R.string.aobrdOldDashLinkFirmwareDialog_title).m2672b((int) R.string.aobrdOldDashLinkFirmwareDialog_message).m2661a(17039370, C1843a.f6286a);
                b = c0584a.m2677b();
                b.setOnDismissListener(this.f4327A);
                return b;
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 1001:
                CharSequence string;
                if (this.f4340m.m10060j() == DutyStatus.SLEEPER) {
                    string = getString(R.string.signOutDialog_sleeperTitle);
                } else {
                    string = getString(R.string.signOutDialog_title, new Object[]{C2224p.m10959b(this, this.f4340m.m10060j()).toLowerCase()});
                }
                dialog.setTitle(string);
                break;
        }
        super.onPrepareDialog(i, dialog);
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        this.f4336i.m8022a(charSequence, i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 26:
                if (i2 == -1) {
                    TruckManager p = OurApplication.m6294p();
                    Truck a = TruckManager.m6538a(intent.getByteArrayExtra("com.bigroad.ttb.truck"));
                    if (a == null) {
                        return;
                    }
                    if (a.getTruckId() == -2) {
                        p.m6588k();
                        return;
                    } else if (p.m6577e(a.getTruckNumber())) {
                        OurApplication.m6256M().m8377a(a.getTruckNumber(), 1);
                        return;
                    } else {
                        C2134e.m10682e("TT-OurActivity", "Could not select truck: " + a.getTruckNumber());
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public static int m6669a(int i, Activity activity) {
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return this.f4336i.m8027b();
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void m6711a(C1549b c1549b) {
        this.f4331E.m4159a(c1549b, 0);
    }

    public void m6713b(C1549b c1549b) {
        this.f4331E.m4158a((Object) c1549b);
    }

    public void onRequestPermissionsResult(final int i, String[] strArr, final int[] iArr) {
        this.f4331E.m4157a(new C0837a<C1549b>(this) {
            final /* synthetic */ OurActivity f5376c;

            public void m7728a(C1549b c1549b) {
                boolean z = false;
                int i = i;
                if (iArr.length > 0 && iArr[0] == 0) {
                    z = true;
                }
                c1549b.mo1271a(i, z);
            }
        });
    }

    private void mo933n() {
        if (this.f4342o.m11413k() && this.f4343p.m10447a() && !this.f4345r.m8421a().m8398a()) {
            Class a = LockOutScreen.m11140a(this.f4338k.m12172Q(), getBaseContext());
            if (a != null) {
                C1632a.m7956a((Context) this, a);
            }
        }
    }
}
