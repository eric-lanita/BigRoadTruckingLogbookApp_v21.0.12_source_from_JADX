package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bigroad.ttb.android.R;
import java.util.ArrayList;
import java.util.Arrays;

public class DailyLogListFilterAdapter extends BaseAdapter {
    private final LayoutInflater f5661a;
    private final ArrayList<DailyLogListFilter> f5662b = new ArrayList(Arrays.asList(DailyLogListFilter.values()));

    public enum DailyLogListFilter {
        ALL(R.string.dailyLogList_filterAll),
        WARNINGS(R.string.dailyLogList_filterWarnings),
        UNIDENTIFIED_DRIVING(R.string.dailyLogList_filterUnassignedDriving),
        CORRECTIONS(R.string.dailyLogList_filterCorrections);
        
        private int m_displayResId;

        private DailyLogListFilter(int i) {
            this.m_displayResId = i;
        }

        public int m8042a() {
            return this.m_displayResId;
        }
    }

    public DailyLogListFilterAdapter(Context context, boolean z, boolean z2) {
        this.f5661a = LayoutInflater.from(context);
        if (!z) {
            this.f5662b.remove(DailyLogListFilter.UNIDENTIFIED_DRIVING);
        }
        if (!z2) {
            this.f5662b.remove(DailyLogListFilter.CORRECTIONS);
        }
    }

    public int m8043a(DailyLogListFilter dailyLogListFilter) {
        if (this.f5662b.contains(dailyLogListFilter)) {
            return this.f5662b.indexOf(dailyLogListFilter);
        }
        return 0;
    }

    public int getCount() {
        return this.f5662b.size();
    }

    public Object getItem(int i) {
        return this.f5662b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5661a.inflate(17367048, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(((DailyLogListFilter) getItem(i)).m8042a());
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5661a.inflate(17367049, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(((DailyLogListFilter) getItem(i)).m8042a());
        return view;
    }
}
