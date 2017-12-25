package com.bigroad.ttb.android.activity;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bigroad.shared.C1179w;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity.Feature;
import com.bigroad.ttb.android.activity.OurActivity.TitleStyle;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.fragment.AbstractNoteInput;
import com.bigroad.ttb.android.fragment.AbstractNoteInput.C1289a;
import com.bigroad.ttb.android.fragment.AutoCompleteNoteInput;
import com.bigroad.ttb.android.fragment.SelectRecipients;
import com.bigroad.ttb.android.fragment.SelectRecipients.C1290a;
import com.bigroad.ttb.android.location.C2119a;
import com.bigroad.ttb.android.location.C2119a.C1285a;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.widget.CheckInMapView;
import com.bigroad.ttb.protocol.TTProtocol.Geocode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.TimeZone;

public class CheckInActivity extends OurActivity implements C1289a, C1290a {
    private CheckInMapView f4405a;
    private Location f4406b;
    private String f4407c;
    private TextView f4408d;
    private LocationTracker f4409e = OurApplication.m6302x();
    private ViewGroup f4410f;
    private ViewGroup f4411g;
    private final C1285a f4412h = new C12861(this);
    private final C1191c f4413i = new C12872(this);

    class C12861 implements C1285a {
        final /* synthetic */ CheckInActivity f4402a;

        C12861(CheckInActivity checkInActivity) {
            this.f4402a = checkInActivity;
        }

        public void mo936a(C2119a c2119a) {
            if (this.f4402a.f4406b != null) {
                this.f4402a.m6771a(c2119a.m10615a(new com.bigroad.ttb.android.location.Location(this.f4402a.f4406b)));
            }
        }
    }

    class C12872 extends C1192d {
        final /* synthetic */ CheckInActivity f4403a;

        C12872(CheckInActivity checkInActivity) {
            this.f4403a = checkInActivity;
        }

        public void mo881b(Location location) {
            if (location != null) {
                this.f4403a.m6764a(location);
            }
        }
    }

    class C12883 implements Runnable {
        final /* synthetic */ CheckInActivity f4404a;

        C12883(CheckInActivity checkInActivity) {
            this.f4404a = checkInActivity;
        }

        public void run() {
            this.f4404a.m6764a(this.f4404a.f4409e.m10603c());
            this.f4404a.m6769h();
        }
    }

    public CheckInActivity() {
        super(EnumSet.of(Feature.FINISH_ON_SIGN_OUT, Feature.DEFAULT_MENU), TitleStyle.IDENTITY);
    }

    private void m6766a(boolean z) {
        if (z) {
            this.f4409e.m10599a(this.f4413i);
        } else {
            this.f4409e.m10602b(this.f4413i);
        }
        this.f4409e.m10600a((Object) this, z);
    }

    private void m6769h() {
        if (this.f4408d != null) {
            this.f4408d.setText(m6763a(this.f4407c));
        }
    }

    private String m6763a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE MMMM d", Locale.getDefault());
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(this);
        Date date = new Date();
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        simpleDateFormat.setCalendar(instance);
        timeFormat.setCalendar(instance);
        String format = simpleDateFormat.format(Long.valueOf(date.getTime()));
        String format2 = timeFormat.format(Long.valueOf(date.getTime()));
        if (am.m4188a((CharSequence) str) || str.equals("Unknown location")) {
            str = getResources().getString(R.string.checkIn_unknownLocation);
        }
        return getResources().getString(R.string.checkIn_locationText, new Object[]{str, format, format2});
    }

    public void m6771a(Geocode geocode) {
        if (geocode != null) {
            this.f4407c = C1179w.m5986a(geocode);
            m6769h();
        }
    }

    public void mo930f() {
        m6770i();
        m6702U().m8290a();
        finish();
        OurApplication.m6278b((Context) this).show();
    }

    public boolean c_() {
        return false;
    }

    private void m6770i() {
        OurApplication.m6295q().m10014a(C2022a.m10078a(OurApplication.ac(), com.bigroad.ttb.android.location.Location.m10552a(this.f4406b), AbstractNoteInput.m10179a(this, R.id.noteInput_fragment), SelectRecipients.m10386a((OurActivity) this, (int) R.id.selectRecipients_fragment)), Collections.emptyList());
        AutoCompleteNoteInput.m10186b(this, R.id.noteInput_fragment, 14);
    }

    public boolean mo937a(TextView textView) {
        return false;
    }

    private void m6764a(Location location) {
        if (this.f4406b == null && location != null) {
            this.f4411g.setVisibility(8);
            this.f4410f.setVisibility(0);
            m6766a(false);
        }
        this.f4406b = location;
        if (this.f4405a != null && this.f4406b != null) {
            this.f4405a.setLocation(this.f4406b);
            this.f4412h.mo936a(OurApplication.m6291m());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.check_in);
        this.f4410f = (ViewGroup) findViewById(R.id.checkIn_contentView);
        this.f4411g = (ViewGroup) findViewById(R.id.checkIn_waitForLocation);
        AutoCompleteNoteInput.m10185a(this, R.id.noteInput_fragment, 14);
        if (this.f4409e.m10603c() == null) {
            this.f4410f.setVisibility(8);
        } else {
            this.f4411g.setVisibility(8);
        }
        this.f4405a = (CheckInMapView) findViewById(R.id.checkIn_map);
        this.f4408d = (TextView) findViewById(R.id.checkIn_message);
        m6710a(60000, new C12883(this));
        AbstractNoteInput.m10180b(this, R.id.noteInput_fragment);
    }

    protected void onResume() {
        super.onResume();
        OurApplication.m6291m().m10616a(this.f4412h);
        if (this.f4406b == null) {
            m6766a(true);
        }
    }

    protected void onPause() {
        OurApplication.m6291m().m10618b(this.f4412h);
        m6766a(false);
        super.onPause();
    }
}
