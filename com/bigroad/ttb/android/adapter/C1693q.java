package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bigroad.shared.aq;
import com.bigroad.ttb.android.af;
import java.util.TimeZone;

public class C1693q extends BaseAdapter {
    private final LayoutInflater f5864a;

    public C1693q(Context context) {
        this.f5864a = LayoutInflater.from(context);
    }

    public int m8260a(String str) {
        int length = aq.f2639c.length;
        for (int i = 0; i < length; i++) {
            if (aq.f2639c[i].getID().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public TimeZone m8261a(int i) {
        return aq.f2639c[i];
    }

    public int getCount() {
        return aq.f2639c.length;
    }

    public Object getItem(int i) {
        return aq.f2639c[i];
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5864a.inflate(17367048, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(af.m8283a((TimeZone) getItem(i), this.f5864a.getContext()));
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5864a.inflate(17367049, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(af.m8283a(m8261a(i), this.f5864a.getContext()));
        return view;
    }
}
