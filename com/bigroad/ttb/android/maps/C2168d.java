package com.bigroad.ttb.android.maps;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bigroad.ttb.android.R;

public class C2168d extends BaseAdapter {
    private final LayoutInflater f7540a;

    public C2168d(Context context) {
        this.f7540a = LayoutInflater.from(new ContextThemeWrapper(context, R.style.OurMapTheme));
    }

    public int m10777a(MapType mapType) {
        return mapType.ordinal();
    }

    public MapType m10778a(int i) {
        return MapType.values()[i];
    }

    public int getCount() {
        return MapType.values().length;
    }

    public Object getItem(int i) {
        return m10778a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7540a.inflate(17367048, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(m10778a(i).m10743b());
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7540a.inflate(17367049, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(m10778a(i).m10742a());
        return view;
    }
}
