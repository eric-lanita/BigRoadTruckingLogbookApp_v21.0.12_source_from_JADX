package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.urbanairship.richpush.C3942c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@TargetApi(14)
public abstract class C3835e extends BaseAdapter {
    private final List<C3942c> f13690a = new ArrayList();
    private final Context f13691b;
    private final int f13692c;

    protected abstract void mo2804a(View view, C3942c c3942c, int i);

    public C3835e(Context context, int i) {
        this.f13691b = context;
        this.f13692c = i;
    }

    public int getCount() {
        return this.f13690a.size();
    }

    public Object getItem(int i) {
        if (i > this.f13690a.size()) {
            return null;
        }
        return this.f13690a.get(i);
    }

    public long getItemId(int i) {
        if (i > this.f13690a.size()) {
            return -1;
        }
        return (long) ((C3942c) this.f13690a.get(i)).m20446a().hashCode();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f13691b.getSystemService("layout_inflater")).inflate(this.f13692c, viewGroup, false);
        }
        if (i <= this.f13690a.size()) {
            mo2804a(view, (C3942c) this.f13690a.get(i), i);
        }
        return view;
    }

    public void m19953a(Collection<C3942c> collection) {
        synchronized (this.f13690a) {
            this.f13690a.clear();
            this.f13690a.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public boolean hasStableIds() {
        return true;
    }
}
