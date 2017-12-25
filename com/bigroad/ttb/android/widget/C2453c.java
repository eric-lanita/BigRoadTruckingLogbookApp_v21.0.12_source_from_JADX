package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.C0126a;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;

public class C2453c extends LinearLayout {
    private C2303v f8741a;
    private TextView f8742b;
    private TextView f8743c;
    private TextView f8744d;
    private TextView f8745e;
    private TextView f8746f;

    public C2453c(Context context) {
        super(context);
        m12084a(context);
    }

    private void m12084a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.correction_review_header_truck, this);
        this.f8741a = C2303v.m11257b(getResources().getDimensionPixelOffset(R.dimen.dailyLogHeader_indent));
        this.f8742b = (TextView) findViewById(R.id.correctionReviewHeader_truck);
        this.f8743c = (TextView) findViewById(R.id.correctionReviewHeader_license);
        this.f8744d = (TextView) findViewById(R.id.correctionReviewHeader_startOdometer);
        this.f8745e = (TextView) findViewById(R.id.correctionReviewHeader_endOdometer);
        this.f8746f = (TextView) findViewById(R.id.correctionReviewHeader_distance);
    }

    public void setTruck(DailyLogTruck dailyLogTruck) {
        CanonicalOdometerUnit a;
        String format;
        m12085a(this.f8742b, R.string.dailyLogHeaderTruck_truckLabel, dailyLogTruck.hasTruckNumber() ? dailyLogTruck.getTruckNumber() : null);
        m12085a(this.f8743c, R.string.dailyLogHeaderTruck_licenseLabel, dailyLogTruck.getTruckLicense());
        if (dailyLogTruck.hasOdometerUnit()) {
            a = CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(dailyLogTruck.getOdometerUnit()));
        } else {
            a = null;
        }
        if (a == null) {
            a = CanonicalOdometerUnit.MILES;
        }
        String str = "";
        if (dailyLogTruck.hasStartOdometer()) {
            str = String.format("%d %s", new Object[]{Integer.valueOf(dailyLogTruck.getStartOdometer()), a.m5470a()});
        }
        m12085a(this.f8744d, R.string.dailyLogHeaderTruck_startOdometerLabel, str);
        str = "";
        if (dailyLogTruck.hasEndOdometer()) {
            str = String.format("%d %s", new Object[]{Integer.valueOf(dailyLogTruck.getEndOdometer()), a.m5470a()});
        }
        m12085a(this.f8745e, R.string.dailyLogHeaderTruck_endOdometerLabel, str);
        str = "";
        if (dailyLogTruck.hasDistance()) {
            format = String.format("%d %s", new Object[]{Integer.valueOf(dailyLogTruck.getDistance()), a.m5470a()});
        } else {
            format = str;
        }
        m12085a(this.f8746f, R.string.dailyLogHeaderTruck_distanceLabel, format);
    }

    private void m12085a(TextView textView, int i, String str) {
        Resources resources = getResources();
        this.f8741a.m11268c(resources.getString(i)).m11268c(" ").m11261a(C0126a.m584b(getContext(), R.color.correctionReviewChanged));
        if (am.m4188a((CharSequence) str)) {
            this.f8741a.m11267b(resources.getString(R.string.none));
        } else {
            this.f8741a.m11268c(str);
        }
        this.f8741a.m11266b();
        textView.setText(this.f8741a.m11270e());
        textView.setVisibility(0);
    }
}
