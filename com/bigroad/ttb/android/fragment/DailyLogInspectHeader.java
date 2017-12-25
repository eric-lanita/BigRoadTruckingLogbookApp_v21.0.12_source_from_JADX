package com.bigroad.ttb.android.fragment;

import android.os.Bundle;
import android.support.v4.app.C0202r;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailyLogInspectHeader extends Fragment {
    private static final String f7149a = DailyLogInspectHeader.class.getName();
    private static final String f7150b = (DailyLogInspectHeader.class.getName() + ".inspectingContentSubtitle");
    private static final String f7151c = (DailyLogInspectHeader.class.getName() + ".requestLogDay");
    private DailyLog f7152d = null;
    private int f7153e = -1;
    private TextView f7154f;
    private TextView f7155g;
    private String f7156h;
    private final C1736b f7157i = OurApplication.m6296r();
    private final C2474y f7158j = OurApplication.m6285g();

    public static DailyLogInspectHeader m10330a(C0202r c0202r, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString(f7150b, str);
        if (i > 0) {
            bundle.putInt(f7151c, i);
        }
        Fragment dailyLogInspectHeader = new DailyLogInspectHeader();
        dailyLogInspectHeader.setArguments(bundle);
        c0202r.mo150a().mo142a(dailyLogInspectHeader, f7149a).mo138a();
        return dailyLogInspectHeader;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.f7153e = getArguments().getInt(f7151c);
        this.f7156h = getArguments().getString(f7150b);
        if (this.f7153e <= 0) {
            this.f7153e = DailyLogUtils.m4285a(this.f7158j.m12228r().m4868b());
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        OurActivity ourActivity = (OurActivity) getActivity();
        View inflate = ourActivity.getLayoutInflater().inflate(R.layout.daily_log_list_inspect_header, null);
        this.f7154f = (TextView) inflate.findViewById(R.id.dailyLogListInspect_currentDateLabel);
        this.f7155g = (TextView) inflate.findViewById(R.id.dailyLogListInspect_inspectingSubtitle);
        this.f7155g.setText(this.f7156h);
        m10331a(this.f7153e);
        ourActivity.m6692K().setCustomView(inflate);
    }

    private void m10331a(int i) {
        DailyLog b = this.f7157i.m8480b(i);
        if (b == null) {
            b = this.f7157i.m8490e(i);
        }
        if (b != null) {
            this.f7152d = b;
            this.f7153e = b.getLogDay();
            Calendar c = DailyLogUtils.m4306c(this.f7152d);
            this.f7154f.setText(new SimpleDateFormat("EEEE MMM d", getResources().getConfiguration().locale).format(c.getTime()));
        }
    }
}
