package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.bigroad.ttb.android.model.C2184f;
import java.util.ArrayList;
import java.util.List;

public class C1692p extends ArrayAdapter<C2184f> {
    private final LayoutInflater f5862a;
    private final List<C2184f> f5863b;

    public C1692p(Context context) {
        this(context, new ArrayList());
    }

    private C1692p(Context context, ArrayList<C2184f> arrayList) {
        super(context, 17367043, arrayList);
        this.f5862a = LayoutInflater.from(context);
        this.f5863b = arrayList;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        C2184f c2184f = (C2184f) getItem(i);
        if (view == null) {
            inflate = this.f5862a.inflate(17367043, null);
        } else {
            inflate = view;
        }
        ((TextView) inflate).setText(c2184f.m10829a(getContext()));
        return inflate;
    }

    public void m8259a(List<C2184f> list) {
        this.f5863b.clear();
        this.f5863b.addAll(list);
        notifyDataSetChanged();
    }
}
