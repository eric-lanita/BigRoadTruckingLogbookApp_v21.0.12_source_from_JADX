package com.bigroad.ttb.android.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.C0202r;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.util.aa;
import com.bigroad.ttb.android.widget.OurLinearLayout;
import java.net.URLEncoder;
import java.util.Date;
import java.util.TimeZone;

public class ViewMoreLogs extends Fragment {
    public static final String f7269a = ViewMoreLogs.class.getName();
    private TextView f7270b;
    private OurLinearLayout f7271c;
    private OurLinearLayout f7272d;
    private C2474y f7273e;
    private final C1182a f7274f = new C20741(this);

    class C20741 extends C1183b {
        final /* synthetic */ ViewMoreLogs f7267a;

        C20741(ViewMoreLogs viewMoreLogs) {
            this.f7267a = viewMoreLogs;
        }

        public void mo868e(C2474y c2474y) {
            this.f7267a.m10428a();
        }

        public void mo866c(C2474y c2474y) {
            this.f7267a.m10428a();
        }

        public void mo867d(C2474y c2474y) {
            this.f7267a.m10428a();
        }
    }

    class C20752 implements OnClickListener {
        final /* synthetic */ ViewMoreLogs f7268a;

        C20752(ViewMoreLogs viewMoreLogs) {
            this.f7268a = viewMoreLogs;
        }

        public void onClick(View view) {
            C1632a.m7999j(this.f7268a.getActivity());
        }
    }

    public static ViewMoreLogs m10426a(C0202r c0202r) {
        ViewMoreLogs viewMoreLogs = (ViewMoreLogs) c0202r.mo149a(f7269a);
        if (viewMoreLogs != null) {
            return viewMoreLogs;
        }
        Bundle bundle = new Bundle();
        viewMoreLogs = new ViewMoreLogs();
        viewMoreLogs.setArguments(bundle);
        return viewMoreLogs;
    }

    public static String m10427a(Resources resources) {
        String str;
        C2474y g = OurApplication.m6285g();
        long d = g.m12202d();
        long g2 = g.m12213g();
        int b = OurApplication.m6296r().m8479b() - 1;
        int offset = TimeZone.getDefault().getOffset(new Date().getTime());
        String str2 = "https://" + OurApplication.m6245B().m10547b();
        if (g2 == -1) {
            str = str2 + "/sign-up/create-fleet?personId=" + d + "&timezoneOffset=" + offset + aa.m11165a() + "&hasDevice=true&isExtraLogsSignup=true" + aa.m11166a("InAppMarketing", "view-more-logs", "mobile", "bigroad") + "&referrerPath=" + URLEncoder.encode("/person#tabId=tabs-dailyLog&logDay=" + b);
        } else {
            str = str2 + "/person?personId=" + d + "&fleetId=" + g2 + "&timezoneOffset=" + offset + aa.m11165a() + aa.m11166a("InAppMarketing", "view-more-logs", "mobile", "bigroad") + "#tabId=tabs-dailyLog&logDay=" + b;
        }
        return "<a href='" + str + "'>" + resources.getString(R.string.viewMoreLogs_authenticatedLink) + "</a>";
    }

    private void m10428a() {
        if (this.f7273e.m12226p()) {
            this.f7272d.setVisibility(8);
            this.f7271c.setVisibility(0);
            this.f7270b.setText(Html.fromHtml(m10427a(getResources())));
            return;
        }
        this.f7271c.setVisibility(8);
        this.f7272d.setVisibility(0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_more_logs, viewGroup, false);
        this.f7271c = (OurLinearLayout) inflate.findViewById(R.id.viewMoreLogs_authenticatedGroup);
        this.f7270b = (TextView) this.f7271c.findViewById(R.id.viewMoreLogs_link);
        this.f7270b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f7272d = (OurLinearLayout) inflate.findViewById(R.id.viewMoreLogs_unauthenticatedGroup);
        Button button = (Button) this.f7272d.findViewById(R.id.viewMoreLogs_createAccountButton);
        m10428a();
        button.setOnClickListener(new C20752(this));
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f7273e = OurApplication.m6285g();
        this.f7273e.m12184a(this.f7274f);
    }

    public void onDetach() {
        this.f7273e.m12194b(this.f7274f);
        super.onDetach();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        m10428a();
    }
}
