package com.bigroad.ttb.android.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.at;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.SelectTruckActivity.Option;
import com.bigroad.ttb.android.activity.UpdateOdometerActivity.OdometerSetConfirmMode;
import com.bigroad.ttb.android.ag;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.eobr.EobrManager.C1449b;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2177b;
import com.bigroad.ttb.android.model.C2178c;
import com.bigroad.ttb.android.model.C2179d;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.status.C2263a;
import com.bigroad.ttb.android.status.C2265b;
import com.bigroad.ttb.android.status.C2267d;
import com.bigroad.ttb.android.status.messages.DashLinkStatusMessages;
import com.bigroad.ttb.android.status.p031a.C2241e;
import com.bigroad.ttb.android.status.p031a.C2241e.C1441a;
import com.bigroad.ttb.android.status.p031a.C2242a;
import com.bigroad.ttb.android.status.p031a.C2260d;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public class DashLinkActivity extends OurActivity {
    private final C1182a f4915A = new C14391(this);
    private final ChangeListener f4916B = new C14488(this);
    private final EobrManager.ChangeListener f4917C = new C14509(this);
    private final EventManager.ChangeListener f4918D = new C1199e(this) {
        final /* synthetic */ DashLinkActivity f4896a;

        {
            this.f4896a = r1;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f4896a.m7341f();
        }
    };
    private final OnClickListener f4919E = new OnClickListener(this) {
        final /* synthetic */ DashLinkActivity f4897a;

        {
            this.f4897a = r1;
        }

        public void onClick(View view) {
            C1632a.m7949a(this.f4897a, Uri.parse("http://www.bigroad.com/"));
        }
    };
    private final OnClickListener f4920F = new OnClickListener(this) {
        final /* synthetic */ DashLinkActivity f4898a;

        {
            this.f4898a = r1;
        }

        public void onClick(View view) {
            C1632a.m7977b(this.f4898a, EnumSet.of(Option.LOAD_TRUCK_LIST, Option.ALLOW_UNKNOWN_TRUCK));
        }
    };
    private final OnClickListener f4921G = new OnClickListener(this) {
        final /* synthetic */ DashLinkActivity f4899a;

        {
            this.f4899a = r1;
        }

        public void onClick(View view) {
            Truck f = this.f4899a.f4927c.m6578f();
            if (f != null) {
                C1632a.m7940a(this.f4899a, f.getTruckNumber(), OdometerUnit.m14668a(f.getOdometerUnit()));
            }
        }
    };
    private final OnClickListener f4922H = new OnClickListener(this) {
        final /* synthetic */ DashLinkActivity f4900a;

        {
            this.f4900a = r1;
        }

        public void onClick(View view) {
            C1632a.m8009o(this.f4900a);
        }
    };
    private final OnClickListener f4923I = new OnClickListener(this) {
        final /* synthetic */ DashLinkActivity f4901a;

        {
            this.f4901a = r1;
        }

        public void onClick(View view) {
            this.f4901a.m7344h();
        }
    };
    private final C1441a f4924J = new C14423(this);
    public final VehicleConnectionManager.ChangeListener f4925a = new C14402(this);
    private final EobrManager f4926b = OurApplication.m6251H();
    private final TruckManager f4927c = OurApplication.m6294p();
    private final EventManager f4928d = OurApplication.m6295q();
    private final VehicleConnectionManager f4929e = OurApplication.m6252I();
    private final C2242a f4930f = OurApplication.m6253J();
    private final C2260d f4931g = OurApplication.m6254K();
    private final ag f4932h = OurApplication.m6282d();
    private ImageView f4933i;
    private TextView f4934j;
    private TextView f4935k;
    private TextView f4936l;
    private TextView f4937m;
    private Button f4938n;
    private View f4939o;
    private TextView f4940p;
    private TextView f4941q;
    private TextView f4942r;
    private TextView f4943s;
    private TextView f4944t;
    private TextView f4945u;
    private TextView f4946v;
    private TextView f4947w;
    private TextView f4948x;
    private Button f4949y;
    private int f4950z;

    class C14391 extends C1183b {
        final /* synthetic */ DashLinkActivity f4902a;

        C14391(DashLinkActivity dashLinkActivity) {
            this.f4902a = dashLinkActivity;
        }

        public void mo866c(C2474y c2474y) {
            this.f4902a.m7341f();
        }
    }

    class C14402 extends C1201a {
        final /* synthetic */ DashLinkActivity f4903a;

        C14402(DashLinkActivity dashLinkActivity) {
            this.f4903a = dashLinkActivity;
        }

        public void mo890a(C2369i c2369i) {
            this.f4903a.m7341f();
        }
    }

    class C14423 implements C1441a {
        final /* synthetic */ DashLinkActivity f4904a;

        C14423(DashLinkActivity dashLinkActivity) {
            this.f4904a = dashLinkActivity;
        }

        public void mo996a(C2241e c2241e) {
            if (c2241e == this.f4904a.f4930f || c2241e == this.f4904a.f4931g) {
                this.f4904a.m7341f();
            }
        }
    }

    class C14455 implements OnTouchListener {
        Handler f4908a = new Handler();
        Runnable f4909b = new C14441(this);
        final /* synthetic */ DashLinkActivity f4910c;

        class C14441 implements Runnable {
            final /* synthetic */ C14455 f4907a;

            C14441(C14455 c14455) {
                this.f4907a = c14455;
            }

            public void run() {
                try {
                    int i;
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                        if (bondedDevices != null) {
                            i = 0;
                            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                                int i2;
                                if (EobrManager.m9103a(bluetoothDevice)) {
                                    try {
                                        bluetoothDevice.getClass().getMethod("removeBond", (Class[]) null).invoke(bluetoothDevice, (Object[]) null);
                                        i2 = i + 1;
                                    } catch (Exception e) {
                                        C2134e.m10682e("TT-DashLink", e.getMessage());
                                    }
                                    i = i2;
                                }
                                i2 = i;
                                i = i2;
                            }
                            Toast.makeText(this.f4907a.f4910c.getApplicationContext(), this.f4907a.f4910c.getString(R.string.dashLink_devicesUnpaired, new Object[]{Integer.valueOf(i)}), 0).show();
                        }
                    }
                    i = 0;
                    Toast.makeText(this.f4907a.f4910c.getApplicationContext(), this.f4907a.f4910c.getString(R.string.dashLink_devicesUnpaired, new Object[]{Integer.valueOf(i)}), 0).show();
                } catch (Throwable e2) {
                    C2134e.m10679c("TT-DashLink", "Exception forgetting devices", e2);
                    Toast.makeText(this.f4907a.f4910c.getApplicationContext(), "SecurityException unpairing devices", 0).show();
                }
            }
        }

        C14455(DashLinkActivity dashLinkActivity) {
            this.f4910c = dashLinkActivity;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f4908a.postDelayed(this.f4909b, 5000);
            } else if (motionEvent.getAction() == 1) {
                this.f4908a.removeCallbacks(this.f4909b);
            }
            return true;
        }
    }

    class C14466 implements OnClickListener {
        final /* synthetic */ DashLinkActivity f4911a;

        C14466(DashLinkActivity dashLinkActivity) {
            this.f4911a = dashLinkActivity;
        }

        public void onClick(View view) {
            Truck f = this.f4911a.f4927c.m6578f();
            if (f == null) {
                C2134e.m10680d("TT-DashLink", "Ignoring attempt to confirm odometer with no active truck");
                return;
            }
            EobrDevice j = this.f4911a.f4929e.m11412j();
            if (j == null) {
                C2134e.m10680d("TT-DashLink", "Ignoring attempt to confirm odometer with no active EOBR device");
            } else if (j.mo1121o() == EobrType.GENX) {
                C2134e.m10682e("TT-DashLink", "This should never happen. The UI should not allow odometer calibration for Gen devices.");
            } else {
                C2178c a = j.m8979a(f.hasOdometerOffsets() ? f.getOdometerOffsets() : null);
                if (a == null) {
                    C2134e.m10680d("TT-DashLink", "Ignoring attempt to confirm odometer with no current readings");
                    return;
                }
                C2177b b = a.m10809b();
                if (b == null) {
                    C2134e.m10680d("TT-DashLink", "Ignoring attempt to confirm odometer with no best reading");
                } else {
                    C1632a.m7932a(this.f4911a, OdometerSetConfirmMode.SET, f.getTruckNumber(), OdometerUnit.m14668a(f.getOdometerUnit()), b.m10802a(), R.string.setOdometerDialog_adjustmentWarning);
                }
            }
        }
    }

    class C14477 implements OnClickListener {
        final /* synthetic */ DashLinkActivity f4912a;

        C14477(DashLinkActivity dashLinkActivity) {
            this.f4912a = dashLinkActivity;
        }

        public void onClick(View view) {
            this.f4912a.f4932h.m8308j();
            C1632a.m8012p(this.f4912a);
        }
    }

    class C14488 extends C1203b {
        final /* synthetic */ DashLinkActivity f4913a;

        C14488(DashLinkActivity dashLinkActivity) {
            this.f4913a = dashLinkActivity;
        }

        public void mo894a(Truck truck) {
            this.f4913a.m7341f();
        }
    }

    class C14509 extends C1449b {
        final /* synthetic */ DashLinkActivity f4914a;

        C14509(DashLinkActivity dashLinkActivity) {
            this.f4914a = dashLinkActivity;
        }

        public void mo1000b(EobrDevice eobrDevice) {
            if (eobrDevice == this.f4914a.f4929e.m11412j()) {
                this.f4914a.m7341f();
            }
        }
    }

    public DashLinkActivity() {
        super(Feature.FINISH_ON_SIGN_OUT);
    }

    private void m7330a(Truck truck) {
        C2177b b;
        String str = null;
        EobrDevice j = this.f4929e.m11412j();
        String l = j == null ? null : j.m9000l();
        at atVar = new at(l);
        String b2 = atVar.m4252b();
        String c = atVar.m4253c();
        OdometerUnit a = af.m4151a(truck);
        String f = j == null ? null : j.mo1118f();
        String a2 = j == null ? null : j.m8980a();
        if (j != null) {
            C2178c a3 = j.m8979a(truck.getOdometerOffsets());
            if (a3 != null) {
                b = a3.m10809b();
                if (b != null) {
                    str = af.m4152a(b.m10802a(), a);
                }
                m7326a(this.f4940p, (int) R.string.dashLink_truckNumberLabel, truck.getTruckNumber());
                m7326a(this.f4941q, (int) R.string.dashLink_modelYearLabel, b2);
                m7326a(this.f4942r, (int) R.string.dashLink_manufacturerLabel, c);
                m7326a(this.f4943s, (int) R.string.dashLink_odometerLabel, str);
                m7326a(this.f4945u, (int) R.string.dashLink_vinLabel, l);
                m7326a(this.f4946v, (int) R.string.dashLink_dashLinkIdLabel, f);
                m7326a(this.f4947w, (int) R.string.dashLink_dashLinkVersionLabel, a2);
            }
        }
        b = null;
        if (b != null) {
            str = af.m4152a(b.m10802a(), a);
        }
        m7326a(this.f4940p, (int) R.string.dashLink_truckNumberLabel, truck.getTruckNumber());
        m7326a(this.f4941q, (int) R.string.dashLink_modelYearLabel, b2);
        m7326a(this.f4942r, (int) R.string.dashLink_manufacturerLabel, c);
        m7326a(this.f4943s, (int) R.string.dashLink_odometerLabel, str);
        m7326a(this.f4945u, (int) R.string.dashLink_vinLabel, l);
        m7326a(this.f4946v, (int) R.string.dashLink_dashLinkIdLabel, f);
        m7326a(this.f4947w, (int) R.string.dashLink_dashLinkVersionLabel, a2);
    }

    private void m7341f() {
        int i = 0;
        Truck f = this.f4927c.m6578f();
        C2338a d = this.f4929e.m11406d();
        EobrDevice j = this.f4929e.m11412j();
        int i2 = j != null ? j.mo1121o() != EobrType.GENX ? 1 : 0 : 0;
        this.f4937m.setVisibility(8);
        this.f4934j.setVisibility(8);
        this.f4936l.setVisibility(8);
        this.f4938n.setVisibility(8);
        this.f4939o.setVisibility(8);
        this.f4935k.setVisibility(8);
        if (m6699R().m12213g() <= 0) {
            this.f4936l.setVisibility(8);
            this.f4938n.setVisibility(8);
        } else if (f == null) {
            m7339e((int) R.string.dashLink_noTruckText);
            m7322a((int) R.string.dashLink_selectTruck, this.f4920F);
        } else {
            int i3;
            int i4;
            int i5;
            if (d.m11451a(ConnectionSetupFlag.REQUIRED)) {
                C2265b b = this.f4930f.m11064b();
                C2263a c2263a = null;
                if (b != null) {
                    c2263a = b.m11112a();
                }
                if (c2263a == null) {
                    c2263a = DashLinkStatusMessages.DISCONNECTED;
                }
                m7331a(c2263a.mo1267a(getApplicationContext()));
                m7334b(c2263a.mo1268b(getApplicationContext()));
                if (c2263a == DashLinkStatusMessages.UNCALIBRATED_ODOMETER) {
                    if (i2 != 0) {
                        m7322a((int) R.string.dashLink_calibrateOdometerButton, this.f4923I);
                        i3 = 1;
                        i4 = 1;
                        i5 = 1;
                    } else {
                        i3 = 1;
                        i4 = 1;
                        i5 = 1;
                    }
                } else if (c2263a == DashLinkStatusMessages.NO_VIN_SPECIFIED) {
                    m7322a((int) R.string.dashLink_connect, this.f4921G);
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                } else if (c2263a == DashLinkStatusMessages.BLUETOOTH_DISABLED) {
                    m7322a((int) R.string.dashLink_enableBluetooth, this.f4922H);
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                } else if (c2263a == DashLinkStatusMessages.CONNECTED_NOT_PLUGGED_IN || c2263a == DashLinkStatusMessages.RECONNECTING || c2263a == DashLinkStatusMessages.CONNECTED) {
                    i3 = 0;
                    i4 = 1;
                    i5 = 1;
                } else {
                    if (c2263a == DashLinkStatusMessages.DISCONNECTED) {
                        m7342f((int) R.string.dashLink_disconnectedSuggestionText);
                    }
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                }
            } else if (f.getTruckLogType() == 1) {
                m7323a((int) R.string.dashLink_noAobrdTextELog, f.getTruckNumber());
                i3 = 0;
                i4 = 0;
                i5 = 0;
            } else {
                m7323a((int) R.string.dashLink_noAobrdText, f.getTruckNumber());
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (i5 != 0) {
                m7330a(f);
                if (i3 != 0) {
                    this.f4943s.setVisibility(8);
                    this.f4944t.setVisibility(8);
                    this.f4949y.setVisibility(8);
                } else {
                    this.f4943s.setVisibility(0);
                    if (j == null || j.mo1121o() != EobrType.GENX) {
                        this.f4944t.setVisibility(8);
                    } else {
                        this.f4944t.setVisibility(0);
                    }
                    if (i2 == 0) {
                        this.f4949y.setVisibility(8);
                    } else if (this.f4929e.m11413k()) {
                        this.f4949y.setVisibility(8);
                    } else {
                        this.f4949y.setVisibility(0);
                    }
                }
            }
            if (i4 != 0) {
                this.f4939o.setVisibility(0);
            }
        }
        C2267d b2 = this.f4931g.m11099b();
        if (b2 != null) {
            m7336d((int) R.string.dashLink_statusTitle_notAvailable);
            this.f4935k.setText(b2.m11114a().mo1269a(getApplicationContext()));
            this.f4935k.setVisibility(0);
        }
        if (d.m11449a() || d.m11451a(ConnectionSetupFlag.SEARCHING)) {
            i = 1;
        }
        i2 = this.f4931g.m11102e() ? i != 0 ? R.drawable.ic_dashlink_scanning_bad_large : R.drawable.ic_dashlink_bad_large : (!d.m11451a(ConnectionSetupFlag.REQUIRED) || d.m11450a(ConnectionFlag.CURRENT)) ? i != 0 ? R.drawable.ic_dashlink_scanning_good_large : R.drawable.ic_dashlink_good_large : i != 0 ? R.drawable.ic_dashlink_scanning_warn_large : R.drawable.ic_dashlink_warn_large;
        this.f4933i.setImageResource(i2);
        final Drawable drawable = this.f4933i.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ DashLinkActivity f4906b;

                public void run() {
                    ((AnimationDrawable) drawable).start();
                }
            });
        }
    }

    private void m7336d(int i) {
        if (i != 0) {
            this.f4934j.setText(i);
            this.f4934j.setVisibility(0);
        }
    }

    private void m7331a(String str) {
        if (!am.m4188a((CharSequence) str)) {
            this.f4934j.setText(str);
            this.f4934j.setVisibility(0);
        }
    }

    private void m7339e(int i) {
        if (i != 0) {
            this.f4936l.setText(i);
            this.f4936l.setVisibility(0);
        }
    }

    private void m7334b(String str) {
        if (!am.m4188a((CharSequence) str)) {
            this.f4936l.setText(str);
            this.f4936l.setVisibility(0);
        }
    }

    private void m7323a(int i, Object... objArr) {
        if (i != 0) {
            this.f4936l.setText(getString(i, objArr));
            this.f4936l.setVisibility(0);
        }
    }

    private void m7342f(int i) {
        if (i != 0) {
            this.f4937m.setText(i);
            this.f4937m.setVisibility(0);
        }
    }

    private void m7322a(int i, OnClickListener onClickListener) {
        this.f4938n.setText(i);
        this.f4938n.setOnClickListener(onClickListener);
        this.f4938n.setVisibility(0);
    }

    private void m7326a(TextView textView, int i, String str) {
        C2303v b = C2303v.m11257b(this.f4950z);
        b.m11262a(getString(i)).m11260a(' ');
        if (am.m4188a((CharSequence) str)) {
            b.m11267b(getString(R.string.dashLink_unknownValue));
        } else {
            b.m11268c(str);
        }
        textView.setText(b.m11270e());
    }

    private void m7344h() {
        Truck f = this.f4927c.m6578f();
        if (f != null) {
            EobrDevice j = this.f4929e.m11412j();
            if (j == null) {
                return;
            }
            if (j.mo1121o() == EobrType.GENX) {
                C2134e.m10682e("TT-DashLink", "This should never happen. The UI should not allow odometer calibration for Gen devices.");
                return;
            }
            C2182e m = j.m9001m();
            if (m == null) {
                C2134e.m10680d("TT-DashLink", "Ignoring attempt to confirm odometer with no readings");
                return;
            }
            C2179d b = m.m10821b();
            if (b == null) {
                C2134e.m10680d("TT-DashLink", "Ignoring attempt to confirm odometer with no best reading");
            } else if (!b.m10812b().m5465a()) {
                C2134e.m10678c("TT-DashLink", "Ignoring attempt to calibrate " + b.m10812b() + " odometer");
            } else if (b.m10812b() == CanonicalOdometerSource.DASHLINK_FIRMWARE) {
                C1632a.m7932a(this, OdometerSetConfirmMode.SET, f.getTruckNumber(), af.m4151a(f), -1, -1);
            } else {
                C1632a.m7932a(this, OdometerSetConfirmMode.CONFIRM, f.getTruckNumber(), af.m4151a(f), b.m10811a(), -1);
            }
        }
    }

    private void m7325a(long j, OdometerUnit odometerUnit) {
        byte[] bArr = null;
        Truck f = this.f4927c.m6578f();
        if (f != null) {
            EobrDevice j2 = this.f4929e.m11412j();
            if (j2 != null) {
                C2182e m = j2.m9001m();
                if (m != null) {
                    OdometerUnit a;
                    C2177b b = m.m10818a(f.getOdometerOffsets()).m10809b();
                    long a2 = b == null ? 0 : b.m10802a();
                    if (f.hasOdometerUnit()) {
                        a = OdometerUnit.m14668a(f.getOdometerUnit());
                    } else {
                        a = odometerUnit;
                    }
                    int b2 = (int) CanonicalOdometerUnit.m5466a(a).m5471b(a2);
                    int b3 = (int) CanonicalOdometerUnit.m5466a(odometerUnit).m5471b(j);
                    C2179d b4 = m.m10821b();
                    byte[] bArr2;
                    if (b4 == null || b4.m10812b() != CanonicalOdometerSource.DASHLINK_FIRMWARE) {
                        bArr2 = null;
                    } else {
                        bArr2 = j2.m8992d();
                    }
                    if (f.hasFirmwareOdometerAssociatedDashLink()) {
                        bArr = f.getFirmwareOdometerAssociatedDashLink().m19091d();
                    }
                    if (odometerUnit != a || b2 != b3 || !Arrays.equals(r0, r4)) {
                        this.f4928d.m10030b(C2022a.m10089a(OurApplication.ac(), b2, b3, a, odometerUnit, j2.m8992d()));
                    }
                }
            }
        }
    }

    private void m7324a(long j) {
        Truck f = this.f4927c.m6578f();
        if (f != null) {
            C1632a.m7932a(this, OdometerSetConfirmMode.SET, f.getTruckNumber(), af.m4151a(f), j, -1);
        }
    }

    private void m7333b(long j) {
        m7329a(null, j, true);
    }

    private void m7328a(OdometerUnit odometerUnit, long j) {
        m7329a(odometerUnit, j, false);
    }

    private void m7329a(OdometerUnit odometerUnit, long j, boolean z) {
        Truck f = this.f4927c.m6578f();
        if (f == null || (z && f.getFleetId() <= 0)) {
            C2134e.m10682e("TT-DashLink", "Ignoring attempt to confirm odometer with no active truck");
            return;
        }
        EobrDevice j2 = this.f4929e.m11412j();
        if (j2 == null) {
            C2134e.m10682e("TT-DashLink", "Ignoring attempt to confirm odometer with no current EobrDevice");
            return;
        }
        C2182e m = j2.m9001m();
        if (m == null) {
            C2134e.m10682e("TT-DashLink", "Ignoring attempt to confirm odometer with no current readings.");
            return;
        }
        byte[] d;
        if (m.m10821b().m10812b() == CanonicalOdometerSource.DASHLINK_FIRMWARE) {
            d = j2.m8992d();
        } else {
            d = null;
        }
        if (CanonicalOdometerSource.m5462a(f.getOdometerOffsets())) {
            m7325a(j, odometerUnit == null ? OdometerUnit.m14668a(f.getOdometerUnit()) : odometerUnit);
        }
        OdometerOffsets a = m.m10819a(j);
        j2.m8983a(f.getTruckId(), a);
        if (d != null) {
            this.f4928d.m10050e(C2022a.m10081a(OurApplication.ac(), f, d));
        }
        this.f4927c.m6554a(f.getTruckNumber(), null, odometerUnit, null, null, true, a, d);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.dashlink);
        m6692K().setStatusMessageVisible(false);
        this.f4933i = (ImageView) findViewById(R.id.dashLink_icon);
        this.f4934j = (TextView) findViewById(R.id.dashLink_statusTitle);
        this.f4935k = (TextView) findViewById(R.id.dashLink_malfunctionText);
        this.f4936l = (TextView) findViewById(R.id.dashLink_statusText);
        this.f4937m = (TextView) findViewById(R.id.dashLink_statusSuggestionText);
        this.f4938n = (Button) findViewById(R.id.dashLink_statusActionButton);
        this.f4939o = findViewById(R.id.dashLink_connectedView);
        this.f4940p = (TextView) findViewById(R.id.dashLink_truckNumber);
        this.f4941q = (TextView) findViewById(R.id.dashLink_modelYear);
        this.f4942r = (TextView) findViewById(R.id.dashLink_manufacturer);
        this.f4943s = (TextView) findViewById(R.id.dashLink_odometer);
        this.f4944t = (TextView) findViewById(R.id.dashLink_genx_odometer_note);
        this.f4945u = (TextView) findViewById(R.id.dashLink_vin);
        this.f4946v = (TextView) findViewById(R.id.dashLink_dashLinkId);
        this.f4947w = (TextView) findViewById(R.id.dashLink_dashLinkVersion);
        this.f4948x = (TextView) findViewById(R.id.dashLink_learnMoreTextView);
        this.f4949y = (Button) findViewById(R.id.dashLink_setOdometerButton);
        this.f4950z = getResources().getDimensionPixelSize(R.dimen.text_wrap_indent);
        this.f4933i.setOnTouchListener(new C14455(this));
        this.f4949y.setOnClickListener(new C14466(this));
        m6699R().m12184a(this.f4915A);
        this.f4926b.m9118a(this.f4917C);
        this.f4927c.m6559a(this.f4916B);
        this.f4928d.m10012a(this.f4918D);
        this.f4929e.m11399a(this.f4925a);
        this.f4930f.m11048a(this.f4924J);
        this.f4931g.m11048a(this.f4924J);
        this.f4948x.setClickable(true);
        this.f4948x.setPaintFlags(8);
        this.f4948x.setOnClickListener(new C14477(this));
        m7341f();
    }

    protected void onDestroy() {
        m6699R().m12194b(this.f4915A);
        this.f4926b.m9122b(this.f4917C);
        this.f4927c.m6568b(this.f4916B);
        this.f4928d.m10029b(this.f4918D);
        this.f4929e.m11404b(this.f4925a);
        this.f4930f.m11049b(this.f4924J);
        this.f4931g.m11049b(this.f4924J);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 27:
                if (i2 == -1) {
                    CharSequence stringExtra = intent.getStringExtra("com.bigroad.ttb.vin");
                    byte[] byteArrayExtra = intent.getByteArrayExtra("com.bigroad.ttb.macAddress");
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("com.bigroad.ttb.firmwareOdometerId");
                    if (!am.m4188a(stringExtra) || byteArrayExtra != null) {
                        Truck f = this.f4927c.m6578f();
                        if (f != null && f.getFleetId() > 0) {
                            OdometerOffsets odometerOffsets = (OdometerOffsets) intent.getSerializableExtra("com.bigroad.ttb.odometerOffsets");
                            this.f4928d.m10050e(C2022a.m10081a(OurApplication.ac(), f, byteArrayExtra2));
                            this.f4927c.m6554a(f.getTruckNumber(), null, null, stringExtra, byteArrayExtra, true, odometerOffsets, byteArrayExtra2);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (i2 == 5) {
                    this.f4927c.m6577e(intent.getStringExtra("com.bigroad.ttb.truckNumber"));
                    return;
                } else {
                    return;
                }
            case 32:
                OdometerUnit odometerUnit = null;
                long j = -1;
                if (intent != null) {
                    OdometerUnit odometerUnit2 = (OdometerUnit) intent.getSerializableExtra("com.bigroad.ttb.odometerUnit");
                    odometerUnit = odometerUnit2;
                    j = intent.getLongExtra("com.bigroad.ttb.odometerValue", -1);
                } else {
                    C2134e.m10680d("TT-DashLink", "Odometer data are not specified when setting or confirming odometer.");
                }
                if (i2 == 8) {
                    m7328a(odometerUnit, j);
                    return;
                } else if (i2 == 0) {
                    return;
                } else {
                    if (i2 == 9) {
                        m7333b(j);
                        return;
                    } else if (i2 == 10) {
                        m7324a(j);
                        return;
                    } else {
                        return;
                    }
                }
            default:
                return;
        }
    }
}
