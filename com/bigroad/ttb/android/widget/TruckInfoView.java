package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.support.v4.content.C0126a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;

public class TruckInfoView extends FrameLayout {
    private TextView f8673a;
    private boolean f8674b;
    private boolean f8675c;
    private boolean f8676d;
    private String f8677e;
    private boolean f8678f;

    public TruckInfoView(Context context) {
        super(context);
        m12039a(context);
    }

    public TruckInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12039a(context);
    }

    private void m12039a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.truck_number_view, this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8673a = (TextView) findViewById(R.id.truckNumber_value);
        m12042a(false, false, false);
    }

    public void m12042a(boolean z, boolean z2, boolean z3) {
        m12043a(z, z2, z3, true, null);
    }

    public void m12043a(boolean z, boolean z2, boolean z3, boolean z4, String str) {
        this.f8674b = z;
        this.f8675c = z2;
        this.f8676d = z3;
        this.f8678f = z4;
        this.f8677e = str;
        this.f8673a.setTextColor(C0126a.m584b(getContext(), this.f8674b ? R.color.black : R.color.white));
    }

    public void m12040a(Truck truck) {
        if (truck == null) {
            m12041a(null, null);
        } else {
            m12041a(truck.getTruckNumber(), TruckLogType.m15634a(truck.getTruckLogType()));
        }
    }

    public void m12041a(String str, TruckLogType truckLogType) {
        if (truckLogType == null) {
            truckLogType = TruckLogType.UNKNOWN_LOG_TYPE;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!am.m4188a((CharSequence) str)) {
            if (this.f8675c) {
                stringBuilder.append(getResources().getString(R.string.vehicleType_truck)).append(" ");
            }
            stringBuilder.append(str);
            if (!am.m4188a(this.f8677e)) {
                stringBuilder.append(" (").append(this.f8677e).append(")");
            }
        }
        ac.m11183a(this.f8673a, stringBuilder.toString(), this.f8676d ? R.string.selectTruck_noTruck : R.string.none);
        Integer a = ac.m11174a(truckLogType, this.f8674b);
        if (a == null || !this.f8678f) {
            this.f8673a.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            this.f8673a.setCompoundDrawablesWithIntrinsicBounds(null, null, C0126a.m582a(getContext(), a.intValue()), null);
        }
    }
}
