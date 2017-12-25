package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.aq;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.util.C2303v;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class C2452b extends LinearLayout {
    private LayoutInflater f8738a;
    private TextView f8739b;
    private LinearLayout f8740c;

    public C2452b(Context context) {
        super(context);
        m12082a(context);
    }

    private void m12082a(Context context) {
        setOrientation(1);
        int round = Math.round(getResources().getDimension(R.dimen.border_padding));
        setPadding(round, round, round, round);
        this.f8738a = LayoutInflater.from(context);
        this.f8738a.inflate(R.layout.certification_list_view, this);
        this.f8739b = (TextView) findViewById(R.id.certificationList_emptyMessage);
        this.f8740c = (LinearLayout) findViewById(R.id.certificationList);
        C2303v c = C2303v.m11258c();
        c.m11267b(context.getString(R.string.certificationList_emptyMessage));
        this.f8739b.setText(c.m11270e());
    }

    private View m12081a(TimeZone timeZone, boolean z, Event event) {
        TextView textView = (TextView) this.f8738a.inflate(R.layout.certification_list_item, null);
        Context context = getContext();
        Resources resources = context.getResources();
        Locale locale = resources.getConfiguration().locale;
        Calendar a = aq.m4224a(timeZone, event.getOccurredAt());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd", locale);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(a.getTime());
        DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(context);
        timeFormat.setTimeZone(timeZone);
        StringBuilder stringBuilder = new StringBuilder(timeFormat.format(Long.valueOf(event.getOccurredAt())));
        if (z) {
            stringBuilder.append(" ").append(timeZone.getDisplayName(timeZone.inDaylightTime(a.getTime()), 0));
        }
        String stringBuilder2 = stringBuilder.toString();
        textView.setText(resources.getString(R.string.certificationList_item, new Object[]{format, stringBuilder2}));
        return textView;
    }

    public void m12083a(TimeZone timeZone, boolean z, List<Event> list) {
        this.f8740c.removeAllViews();
        if (list.isEmpty()) {
            this.f8739b.setVisibility(0);
            this.f8740c.setVisibility(8);
        } else {
            this.f8739b.setVisibility(8);
            this.f8740c.setVisibility(0);
        }
        List arrayList = new ArrayList(list);
        Collections.sort(arrayList, C1144s.f3800a);
        for (Event a : C0831a.m4105a(arrayList)) {
            this.f8740c.addView(m12081a(timeZone, z, a));
        }
    }
}
