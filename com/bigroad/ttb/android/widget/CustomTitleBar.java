package com.bigroad.ttb.android.widget;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.am;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2230r.C1332b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.ag;
import com.bigroad.ttb.android.status.C2262f;
import com.bigroad.ttb.android.status.C2264e;
import com.bigroad.ttb.android.status.Type;
import com.bigroad.ttb.android.status.messages.AppStatusMessages;
import com.bigroad.ttb.android.status.messages.SystemStatusMessages;
import com.bigroad.ttb.android.status.p031a.C2241e;
import com.bigroad.ttb.android.status.p031a.C2241e.C1441a;
import com.bigroad.ttb.android.status.p031a.C2256c;
import com.bigroad.ttb.android.status.p031a.C2260d;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class CustomTitleBar extends LinearLayout {
    private static final ag f8332g = OurApplication.m6282d();
    private static final C2230r f8333h = OurApplication.m6292n();
    private final C1441a f8334a = new C24021(this);
    private final ChangeListener f8335b = new C24032(this);
    private final C1332b f8336c = new C24043(this);
    private final C2256c f8337d = OurApplication.aa();
    private final VehicleConnectionManager f8338e = OurApplication.m6252I();
    private final C2260d f8339f = OurApplication.m6254K();
    private ImageView f8340i;
    private TextView f8341j;
    private ViewGroup f8342k;
    private ImageButton f8343l;
    private ImageButton f8344m;
    private TextView f8345n;
    private ImageView f8346o;
    private boolean f8347p = false;
    private boolean f8348q = true;
    private am f8349r = null;
    private C1547a f8350s = null;
    private C2369i f8351t = null;

    public interface C1547a {
        void mo1013a(am amVar);

        void mo1014a(am amVar, boolean z);
    }

    class C24021 implements C1441a {
        final /* synthetic */ CustomTitleBar f8323a;

        C24021(CustomTitleBar customTitleBar) {
            this.f8323a = customTitleBar;
        }

        public void mo996a(C2241e c2241e) {
            this.f8323a.m11786c();
            this.f8323a.m11785b();
        }
    }

    class C24032 extends C1201a {
        final /* synthetic */ CustomTitleBar f8324a;

        C24032(CustomTitleBar customTitleBar) {
            this.f8324a = customTitleBar;
        }

        public void mo888a(C2338a c2338a) {
            this.f8324a.m11785b();
        }

        public void mo890a(C2369i c2369i) {
            if (this.f8324a.f8350s == null) {
                this.f8324a.f8351t = c2369i;
                return;
            }
            this.f8324a.f8351t = null;
            if (c2369i == null) {
                this.f8324a.f8350s.mo1014a(this.f8324a.f8349r, true);
            } else if (c2369i.m11617p()) {
                this.f8324a.f8350s.mo1014a(this.f8324a.f8349r, false);
            } else {
                this.f8324a.f8350s.mo1014a(this.f8324a.f8349r, true);
            }
        }
    }

    class C24043 extends C1332b {
        final /* synthetic */ CustomTitleBar f8325a;

        C24043(CustomTitleBar customTitleBar) {
            this.f8325a = customTitleBar;
        }

        public void mo955b(C2230r c2230r) {
            this.f8325a.m11785b();
        }
    }

    class C24054 implements OnClickListener {
        final /* synthetic */ CustomTitleBar f8326a;

        C24054(CustomTitleBar customTitleBar) {
            this.f8326a = customTitleBar;
        }

        public void onClick(View view) {
            C1632a.m7944a(this.f8326a.getContext());
        }
    }

    class C24065 implements OnClickListener {
        final /* synthetic */ CustomTitleBar f8327a;

        C24065(CustomTitleBar customTitleBar) {
            this.f8327a = customTitleBar;
        }

        public void onClick(View view) {
            if (this.f8327a.m11790g()) {
                this.f8327a.m11791h();
            }
        }
    }

    public CustomTitleBar(Context context) {
        super(context);
        m11779b(context);
    }

    public CustomTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11779b(context);
    }

    @TargetApi(11)
    public CustomTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11779b(context);
    }

    private void m11779b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_title_bar, this);
        setOrientation(1);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f8340i = (ImageView) findViewById(R.id.customTitle_appIcon);
        this.f8341j = (TextView) findViewById(R.id.customTitle_title);
        this.f8342k = (ViewGroup) findViewById(R.id.customTitle_customViewHolder);
        this.f8343l = (ImageButton) findViewById(R.id.customTitle_dashLinkState);
        this.f8344m = (ImageButton) findViewById(R.id.customTitle_menu);
        this.f8345n = (TextView) findViewById(R.id.customTitle_statusMessage);
        this.f8346o = (ImageView) findViewById(R.id.customTitle_drawerToggle);
        this.f8343l.setOnClickListener(new C24054(this));
        this.f8344m.setOnClickListener(new C24065(this));
        m11784a();
        m11785b();
        m11786c();
        m11787d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8337d.m11048a(this.f8334a);
        this.f8338e.m11399a(this.f8335b);
        f8333h.m11009a(this.f8336c);
        m11785b();
        m11786c();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8337d.m11049b(this.f8334a);
        this.f8338e.m11404b(this.f8335b);
        f8333h.m11015b(this.f8336c);
    }

    public void m11784a() {
        this.f8340i.setVisibility(m11783p() ? 0 : 8);
        if (m11788e()) {
            this.f8341j.setVisibility(8);
            this.f8342k.setVisibility(0);
            return;
        }
        this.f8341j.setVisibility(0);
        this.f8342k.setVisibility(8);
    }

    public void m11785b() {
        C2338a d = this.f8338e.m11406d();
        boolean e = this.f8339f.m11102e();
        int i = (d.m11449a() || d.m11451a(ConnectionSetupFlag.SEARCHING)) ? 1 : 0;
        if (this.f8347p && d.m11451a(ConnectionSetupFlag.REQUIRED)) {
            i = e ? i != 0 ? R.drawable.ic_dashlink_scanning_bad : R.drawable.ic_dashlink_bad : d.m11450a(ConnectionFlag.CURRENT) ? i != 0 ? R.drawable.ic_dashlink_scanning_good : R.drawable.ic_dashlink_good : i != 0 ? R.drawable.ic_dashlink_scanning_warn : R.drawable.ic_dashlink_warn;
            this.f8343l.setImageResource(i);
            Drawable drawable = this.f8343l.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
            }
            this.f8343l.setVisibility(0);
        } else if (this.f8347p && f8333h.m11018d()) {
            this.f8343l.setImageResource(R.drawable.ic_dashlink_discover);
            this.f8343l.setVisibility(0);
        } else {
            this.f8343l.setVisibility(8);
        }
    }

    public void m11786c() {
        if (m11789f()) {
            C2264e i = this.f8337d.m11055i();
            if (i == null) {
                this.f8345n.setVisibility(8);
                return;
            }
            C2262f b = i.m11109b();
            Type a = b.mo1264a();
            this.f8345n.setText(b.mo1265c(getContext()));
            this.f8345n.setCompoundDrawablesWithIntrinsicBounds(a.m11037c(), 0, 0, 0);
            this.f8345n.setBackgroundResource(a.m11036b());
            OnClickListener a2 = m11774a(i, getContext());
            if (a2 != null) {
                this.f8345n.setOnClickListener(a2);
            }
            this.f8345n.setVisibility(0);
            return;
        }
        this.f8345n.setVisibility(8);
    }

    private static OnClickListener m11774a(C2264e c2264e, final Context context) {
        if (c2264e == null) {
            return null;
        }
        switch (c2264e.m11109b().mo1264a().m11035a()) {
            case DASHLINK:
                return new OnClickListener() {
                    public void onClick(View view) {
                        if (CustomTitleBar.f8333h.m11018d()) {
                            CustomTitleBar.f8332g.m8309k();
                        }
                        C1632a.m7944a(context);
                    }
                };
            case APP:
                if (c2264e.m11109b() == AppStatusMessages.OUT_OF_DATE) {
                    return new OnClickListener() {
                        public void onClick(View view) {
                            if (!CustomTitleBar.m11780c(context)) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.bigroad.com/faq#how-do-i-update-my-version-of-bigroad")));
                            }
                        }
                    };
                }
                return null;
            case SYSTEM:
                if (c2264e.m11109b() == SystemStatusMessages.CLOCK_SKEW) {
                    return new OnClickListener() {
                        public void onClick(View view) {
                            C1632a.m7970b(context);
                        }
                    };
                }
                return null;
            default:
                return null;
        }
    }

    public void m11787d() {
        this.f8344m.setVisibility(m11790g() ? 0 : 8);
    }

    public void setTitle(CharSequence charSequence) {
        this.f8341j.setText(charSequence);
    }

    public void setCustomView(View view) {
        this.f8342k.removeAllViews();
        if (view != null) {
            this.f8342k.addView(view);
        }
        m11784a();
    }

    public boolean m11788e() {
        return this.f8342k.getChildCount() > 0;
    }

    public int getCustomViewXOnScreen() {
        if (!m11788e()) {
            return 0;
        }
        int[] iArr = new int[2];
        this.f8342k.getLocationOnScreen(iArr);
        return iArr[0];
    }

    public void setDashLinkButtonVisible(boolean z) {
        this.f8347p = z;
        m11785b();
    }

    public void setStatusMessageVisible(boolean z) {
        this.f8348q = z;
        m11786c();
    }

    public boolean m11789f() {
        return this.f8348q;
    }

    public void setMenuDelegate(C1547a c1547a) {
        if (c1547a == null) {
            if (this.f8349r != null) {
                this.f8349r.m3655d();
            }
            this.f8349r = null;
            return;
        }
        if (this.f8349r == null) {
            this.f8349r = new am(getContext(), this.f8344m);
        }
        this.f8350s = c1547a;
        if (this.f8351t != null) {
            this.f8335b.mo890a(this.f8351t);
        }
        c1547a.mo1013a(this.f8349r);
        m11787d();
    }

    public boolean m11790g() {
        return this.f8349r != null;
    }

    public void m11791h() {
        if (this.f8349r != null) {
            this.f8349r.m3654c();
            if (this.f8338e.m11413k()) {
                this.f8350s.mo1014a(this.f8349r, false);
            }
        }
    }

    public void m11792i() {
        if (this.f8349r != null) {
            this.f8349r.m3655d();
        }
    }

    private boolean m11783p() {
        if (!m11788e()) {
            return true;
        }
        Configuration configuration = getResources().getConfiguration();
        int i = configuration.screenLayout & 15;
        if ((i == 1 || i == 2) && configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    private static boolean m11780c(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.applicationInfo.packageName;
            if (!str.equals("com.android.vending")) {
                if (str.equals("com.google.market")) {
                }
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent.setFlags(270532608);
            intent.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    public void m11793j() {
        this.f8346o.setRotation(90.0f);
        setStatusMessageVisible(false);
    }

    public void m11794k() {
        this.f8346o.setRotation(BitmapDescriptorFactory.HUE_VIOLET);
        setStatusMessageVisible(true);
    }

    public void m11795l() {
        this.f8346o.setVisibility(8);
        setClickable(false);
    }

    public void m11796m() {
        this.f8346o.setVisibility(0);
        setClickable(true);
    }
}
