package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C1312m<T> extends BaseAdapter implements Filterable {
    private final Object f4453a = new Object();
    private final int f4454b;
    private final LayoutInflater f4455c;
    private final List<T> f4456d;
    private List<T> f4457e;
    private C1687a f4458f = null;

    private class C1687a extends Filter {
        final /* synthetic */ C1312m f5843a;
        private CharSequence f5844b;

        private C1687a(C1312m c1312m) {
            this.f5843a = c1312m;
            this.f5844b = null;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            List arrayList;
            this.f5844b = charSequence;
            if (TextUtils.isEmpty(charSequence)) {
                synchronized (this.f5843a.f4453a) {
                    arrayList = new ArrayList(this.f5843a.f4456d);
                }
            } else {
                arrayList = new ArrayList();
                synchronized (this.f5843a.f4453a) {
                    for (Object next : this.f5843a.f4456d) {
                        if (this.f5843a.mo950a(next, charSequence)) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults == null || filterResults.values == null) {
                this.f5843a.f4457e = new ArrayList();
            } else {
                this.f5843a.f4457e = (List) filterResults.values;
            }
            this.f5843a.notifyDataSetChanged();
        }

        public void m8242a() {
            if (TextUtils.isEmpty(this.f5844b)) {
                this.f5843a.f4457e = this.f5843a.f4456d;
                this.f5843a.notifyDataSetChanged();
                return;
            }
            filter(this.f5844b);
        }
    }

    public C1312m(Context context, int i, List<T> list) {
        this.f4454b = i;
        this.f4456d = list != null ? new ArrayList(list) : new ArrayList();
        this.f4457e = this.f4456d;
        this.f4455c = LayoutInflater.from(context);
    }

    protected View mo949a(int i, ViewGroup viewGroup, boolean z) {
        return this.f4455c.inflate(i, viewGroup, z);
    }

    public int getCount() {
        return this.f4457e.size();
    }

    public T getItem(int i) {
        return i < this.f4457e.size() ? this.f4457e.get(i) : null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f4455c.inflate(this.f4454b, viewGroup, false);
        }
        return view;
    }

    public Filter getFilter() {
        if (this.f4458f == null) {
            this.f4458f = new C1687a();
        }
        return this.f4458f;
    }

    private void m6814b() {
        m6812a(false);
    }

    private void m6812a(boolean z) {
        if (this.f4458f == null || z) {
            notifyDataSetChanged();
        }
        if (this.f4458f != null) {
            this.f4458f.m8242a();
        }
    }

    public void m6817a(T t) {
        synchronized (this.f4453a) {
            this.f4456d.add(t);
        }
        m6814b();
    }

    public void m6821b(List<T> list) {
        synchronized (this.f4453a) {
            this.f4456d.clear();
            this.f4456d.addAll(list);
        }
        m6812a(true);
    }

    public void m6820b(T t) {
        synchronized (this.f4453a) {
            this.f4456d.remove(t);
            this.f4457e.remove(t);
        }
        m6812a(true);
    }

    public void m6816a() {
        synchronized (this.f4453a) {
            this.f4456d.clear();
            this.f4457e.clear();
        }
        m6812a(true);
    }

    public void m6818a(Comparator<? super T> comparator) {
        synchronized (this.f4453a) {
            Collections.sort(this.f4456d, comparator);
        }
        m6814b();
    }

    protected boolean mo950a(T t, CharSequence charSequence) {
        return true;
    }
}
