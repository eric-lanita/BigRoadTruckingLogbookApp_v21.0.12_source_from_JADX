package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.TruckManager.ChangeListener;
import com.bigroad.ttb.android.TruckManager.ChangeListener.Priority;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public class C2451a extends RelativeLayout {
    private final C2474y f8729a = OurApplication.m6285g();
    private final AuthMonitor f8730b = OurApplication.m6249F();
    private final C2230r f8731c = OurApplication.m6292n();
    private final TruckManager f8732d = OurApplication.m6294p();
    private TextView f8733e;
    private TextView f8734f;
    private final C1182a f8735g = new C24401(this);
    private final ChangeListener f8736h = new C24412(this);
    private final C1332b f8737i = new C24423(this);

    class C24401 extends C1183b {
        final /* synthetic */ C2451a f8679a;

        C24401(C2451a c2451a) {
            this.f8679a = c2451a;
        }

        public void mo869f(C2474y c2474y) {
            this.f8679a.m12078a();
        }

        public void mo863a(C2474y c2474y) {
            this.f8679a.m12078a();
        }

        public void mo868e(C2474y c2474y) {
            this.f8679a.m12078a();
        }
    }

    class C24412 extends C1203b {
        final /* synthetic */ C2451a f8680a;

        C24412(C2451a c2451a) {
            this.f8680a = c2451a;
        }

        public void mo894a(Truck truck) {
            this.f8680a.m12078a();
        }
    }

    class C24423 extends C1332b {
        final /* synthetic */ C2451a f8681a;

        C24423(C2451a c2451a) {
            this.f8681a = c2451a;
        }

        public void mo954a(C2230r c2230r) {
            this.f8681a.m12078a();
        }
    }

    public C2451a(Context context) {
        super(context);
        m12079a(context);
    }

    private void m12079a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_title_ident, this);
        this.f8733e = (TextView) findViewById(R.id.actionBar_person);
        this.f8734f = (TextView) findViewById(R.id.actionBar_truck);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8729a.m12184a(this.f8735g);
        this.f8731c.m11009a(this.f8737i);
        this.f8732d.m6560a(this.f8736h, Priority.DEFAULT);
        m12078a();
    }

    protected void onDetachedFromWindow() {
        this.f8729a.m12194b(this.f8735g);
        this.f8731c.m11015b(this.f8737i);
        this.f8732d.m6568b(this.f8736h);
        super.onDetachedFromWindow();
    }

    private void setPersonName(String str) {
        ac.m11183a(this.f8733e, str, (int) R.string.actionBar_noPerson);
    }

    private void setTruckNumber(String str) {
        ac.m11183a(this.f8734f, str, (int) R.string.actionBar_noTruck);
    }

    private void m12078a() {
        String str = null;
        setPersonName(this.f8730b.m6030c() ? null : this.f8729a.m12225o());
        Truck f = this.f8732d.m6578f();
        if (f != null) {
            str = f.getTruckNumber();
        }
        setTruckNumber(str);
    }
}
