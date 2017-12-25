package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.aa;
import com.bigroad.shared.af;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.adapter.DailyLogListFilterAdapter.DailyLogListFilter;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.android.p029c.C1740e;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1669f extends C1312m<C1740e> {
    public static final Comparator<C1740e> f5802a = new C16671();
    private final LayoutInflater f5803b;
    private final C2303v f5804c;
    private final boolean f5805d;
    private final boolean f5806e;
    private final C2474y f5807f;
    private final C1736b f5808g;

    static class C16671 implements Comparator<C1740e> {
        C16671() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8188a((C1740e) obj, (C1740e) obj2);
        }

        public int m8188a(C1740e c1740e, C1740e c1740e2) {
            return aa.m4140c(c1740e2.m8525a(), c1740e.m8525a());
        }
    }

    public C1669f(Context context, List<C1740e> list, boolean z, boolean z2) {
        super(context, R.layout.daily_log_list_item, list);
        this.f5807f = OurApplication.m6285g();
        this.f5808g = OurApplication.m6296r();
        this.f5803b = LayoutInflater.from(context);
        this.f5804c = C2303v.m11258c();
        this.f5805d = z;
        this.f5806e = z2;
    }

    public C1669f(Context context, boolean z) {
        this(context, new ArrayList(), z, false);
    }

    public C1669f(Context context) {
        this(context, new ArrayList(), false, false);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Calendar a;
        int i2;
        int i3 = 0;
        Resources resources = viewGroup.getResources();
        if (view == null) {
            view = this.f5803b.inflate(R.layout.daily_log_list_item, viewGroup, false);
        }
        C1740e c1740e = (C1740e) getItem(i);
        int a2 = c1740e.m8525a();
        DailyLog b = c1740e.m8526b();
        TextView textView = (TextView) view.findViewById(R.id.dailyLogList_date);
        if (b == null) {
            a = DailyLogUtils.m4298a(a2, this.f5807f.m12229s());
        } else {
            a = DailyLogUtils.m4306c(b);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE MMMM d", resources.getConfiguration().locale);
        simpleDateFormat.setTimeZone(a.getTimeZone());
        textView.setText(simpleDateFormat.format(a.getTime()));
        this.f5804c.m11265a();
        CharSequence e = this.f5804c.m11267b(resources.getString(R.string.none)).m11270e();
        textView = (TextView) view.findViewById(R.id.dailyLogList_distance);
        if (c1740e.m8527c() == 0) {
            textView.setText(e);
        } else {
            textView.setText(c1740e.m8527c() + " " + af.m4153a(c1740e.m8528d()));
        }
        textView = (TextView) view.findViewById(R.id.dailyLogList_driveTime);
        if (c1740e.m8529e() == 0) {
            textView.setText(e);
        } else {
            textView.setText(ac.m11175a(c1740e.m8529e(), resources));
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.dailyLogList_dailyLogWarningBadge);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.dailyLogList_unclaimedDriversEventWarningBadge);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.dailyLogList_dailyLogCorrectionBadge);
        int i4 = (this.f5805d || !c1740e.m8530f()) ? 8 : 0;
        imageView.setVisibility(i4);
        if (this.f5805d || !c1740e.m8531g()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        imageView2.setVisibility(i2);
        if (this.f5805d || !c1740e.m8532h()) {
            i3 = 8;
        }
        imageView3.setVisibility(i3);
        return view;
    }

    public void m8190a(List<DailyLog> list, int i) {
        int a = this.f5808g.m8469a(i);
        Map hashMap = new HashMap();
        for (DailyLog dailyLog : list) {
            hashMap.put(Integer.valueOf(dailyLog.getLogDay()), dailyLog);
        }
        List arrayList = new ArrayList(list.size());
        for (int a2 = DailyLogUtils.m4284a(this.f5807f.m12228r().m4879m()); a2 >= a; a2--) {
            C1740e c1740e = new C1740e((DailyLog) hashMap.get(Integer.valueOf(a2)), a2, this.f5806e);
            if (!this.f5806e) {
                arrayList.add(c1740e);
            } else if (c1740e.m8531g()) {
                arrayList.add(c1740e);
            }
        }
        Collections.sort(arrayList, f5802a);
        m6821b(arrayList);
    }

    public void m8189a(List<DailyLog> list) {
        m8190a((List) list, -1);
    }

    protected boolean m8191a(C1740e c1740e, CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        switch (DailyLogListFilter.valueOf(charSequence.toString())) {
            case ALL:
                return true;
            case WARNINGS:
                return c1740e.m8530f();
            case UNIDENTIFIED_DRIVING:
                return c1740e.m8531g();
            case CORRECTIONS:
                return c1740e.m8532h();
            default:
                return true;
        }
    }
}
