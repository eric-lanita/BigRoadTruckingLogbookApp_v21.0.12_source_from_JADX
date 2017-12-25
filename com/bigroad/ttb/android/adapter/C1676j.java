package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bigroad.ttb.android.model.DutyCycle;

public class C1676j extends BaseAdapter {
    private final LayoutInflater f5819a;
    private final boolean f5820b;

    public C1676j(Context context, boolean z) {
        this.f5819a = LayoutInflater.from(context);
        this.f5820b = z;
    }

    public int m8199a(DutyCycle dutyCycle) {
        return dutyCycle.ordinal();
    }

    public DutyCycle m8200a(int i) {
        return DutyCycle.values()[i];
    }

    public int getCount() {
        return DutyCycle.values().length;
    }

    public Object getItem(int i) {
        return m8200a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5819a.inflate(17367048, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(m8200a(i).m10791a(this.f5820b));
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5819a.inflate(17367049, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(m8200a(i).m10791a(false));
        return view;
    }
}
