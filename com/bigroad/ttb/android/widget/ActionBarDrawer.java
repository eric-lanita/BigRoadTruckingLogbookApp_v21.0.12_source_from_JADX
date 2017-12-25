package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.aj;
import com.bigroad.ttb.android.aj.C1716a;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1736b.C1219a;
import com.bigroad.ttb.android.util.ac;

public class ActionBarDrawer extends RelativeLayout {
    C1219a f8281a = new C23951(this);
    C1716a f8282b = new C23962(this);
    private final C1736b f8283c = OurApplication.m6296r();
    private final aj f8284d = OurApplication.ai();
    private View f8285e;
    private LinearLayout f8286f;
    private TextView f8287g;
    private TextView f8288h;
    private Button f8289i;

    class C23951 implements C1219a {
        final /* synthetic */ ActionBarDrawer f8277a;

        C23951(ActionBarDrawer actionBarDrawer) {
            this.f8277a = actionBarDrawer;
        }

        public void mo904a(C1736b c1736b) {
            this.f8277a.m11747a();
        }
    }

    class C23962 implements C1716a {
        final /* synthetic */ ActionBarDrawer f8278a;

        C23962(ActionBarDrawer actionBarDrawer) {
            this.f8278a = actionBarDrawer;
        }

        public void mo1055a(String str) {
            this.f8278a.m11747a();
        }

        public void mo1056b(String str) {
            this.f8278a.m11747a();
        }
    }

    public ActionBarDrawer(Context context) {
        super(context);
        m11748a(context);
    }

    public ActionBarDrawer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11748a(context);
    }

    private void m11748a(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_title_bar_drawer, this);
        this.f8285e = findViewById(R.id.drawer_filler);
        this.f8286f = (LinearLayout) findViewById(R.id.drawer_content_wrapper);
        this.f8287g = (TextView) findViewById(R.id.drawer_trailer);
        this.f8288h = (TextView) findViewById(R.id.drawer_shippingDoc);
        this.f8289i = (Button) findViewById(R.id.drawer_updateButton);
        this.f8289i.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarDrawer f8280b;

            public void onClick(View view) {
                C1632a.m8004l(context);
            }
        });
    }

    public void setOnClickFillerView(OnClickListener onClickListener) {
        this.f8285e.setOnClickListener(onClickListener);
        this.f8285e.setClickable(true);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8283c.m8474a(this.f8281a);
        this.f8284d.m8385a(this.f8282b);
        m11747a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8283c.m8483b(this.f8281a);
        this.f8284d.m8388b(this.f8282b);
    }

    private void setTrailer(String str) {
        ac.m11183a(this.f8287g, str, (int) R.string.none);
    }

    private void setShippingDoc(String str) {
        ac.m11183a(this.f8288h, str, (int) R.string.none);
    }

    private void m11747a() {
        setTrailer(this.f8284d.m8384a());
        setShippingDoc(this.f8284d.m8387b());
    }

    public void setContentLeft(int i) {
        this.f8286f.setLeft(i);
    }
}
