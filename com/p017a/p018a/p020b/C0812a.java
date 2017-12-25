package com.p017a.p018a.p020b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class C0812a extends BaseAdapter {
    private List<View> f2439a = null;

    public C0812a(List<View> list) {
        this.f2439a = list;
    }

    public Object getItem(int i) {
        return this.f2439a.get(i);
    }

    public int getCount() {
        return this.f2439a.size();
    }

    public int getViewTypeCount() {
        return getCount();
    }

    public int getItemViewType(int i) {
        return i;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int i) {
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = (View) this.f2439a.get(i);
        if (view2 != null) {
            return view2;
        }
        view2 = m4017a(i, viewGroup);
        this.f2439a.set(i, view2);
        return view2;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean m4018a(View view) {
        return this.f2439a.contains(view);
    }

    protected View m4017a(int i, ViewGroup viewGroup) {
        throw new RuntimeException("You must override newView()!");
    }
}
