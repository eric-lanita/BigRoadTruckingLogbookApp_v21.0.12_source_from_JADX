package com.p017a.p018a.p019a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import com.p017a.p018a.p020b.C0812a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C0816a extends BaseAdapter implements SectionIndexer {
    protected C0815d f2444a = new C0815d();

    private class C0811a extends DataSetObserver {
        final /* synthetic */ C0816a f2438a;

        private C0811a(C0816a c0816a) {
            this.f2438a = c0816a;
        }

        public void onChanged() {
            this.f2438a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f2438a.notifyDataSetInvalidated();
        }
    }

    private static class C0813b extends C0812a {
        public C0813b(List<View> list) {
            super(list);
        }

        public boolean areAllItemsEnabled() {
            return true;
        }

        public boolean isEnabled(int i) {
            return true;
        }
    }

    private static class C0814c {
        ListAdapter f2440a;
        boolean f2441b = true;

        C0814c(ListAdapter listAdapter, boolean z) {
            this.f2440a = listAdapter;
            this.f2441b = z;
        }
    }

    private static class C0815d {
        protected ArrayList<C0814c> f2442a;
        protected ArrayList<ListAdapter> f2443b;

        private C0815d() {
            this.f2442a = new ArrayList();
            this.f2443b = null;
        }

        void m4021a(ListAdapter listAdapter) {
            this.f2442a.add(new C0814c(listAdapter, true));
        }

        void m4022a(ListAdapter listAdapter, boolean z) {
            Iterator it = this.f2442a.iterator();
            while (it.hasNext()) {
                C0814c c0814c = (C0814c) it.next();
                if (c0814c.f2440a == listAdapter) {
                    c0814c.f2441b = z;
                    this.f2443b = null;
                    return;
                }
            }
        }

        void m4020a(View view, boolean z) {
            Iterator it = this.f2442a.iterator();
            while (it.hasNext()) {
                C0814c c0814c = (C0814c) it.next();
                if ((c0814c.f2440a instanceof C0812a) && ((C0812a) c0814c.f2440a).m4018a(view)) {
                    c0814c.f2441b = z;
                    this.f2443b = null;
                    return;
                }
            }
        }

        List<C0814c> m4019a() {
            return this.f2442a;
        }

        List<ListAdapter> m4023b() {
            if (this.f2443b == null) {
                this.f2443b = new ArrayList();
                Iterator it = this.f2442a.iterator();
                while (it.hasNext()) {
                    C0814c c0814c = (C0814c) it.next();
                    if (c0814c.f2441b) {
                        this.f2443b.add(c0814c.f2440a);
                    }
                }
            }
            return this.f2443b;
        }
    }

    public void m4027a(ListAdapter listAdapter) {
        this.f2444a.m4021a(listAdapter);
        listAdapter.registerDataSetObserver(new C0811a());
    }

    public void m4025a(View view) {
        m4026a(view, false);
    }

    public void m4026a(View view, boolean z) {
        List arrayList = new ArrayList(1);
        arrayList.add(view);
        m4029a(arrayList, z);
    }

    public void m4029a(List<View> list, boolean z) {
        if (z) {
            m4027a(new C0813b(list));
        } else {
            m4027a(new C0812a(list));
        }
    }

    public Object getItem(int i) {
        for (ListAdapter listAdapter : m4024a()) {
            int count = listAdapter.getCount();
            if (i < count) {
                return listAdapter.getItem(i);
            }
            i -= count;
        }
        return null;
    }

    public int getCount() {
        int i = 0;
        for (ListAdapter count : m4024a()) {
            i = count.getCount() + i;
        }
        return i;
    }

    public int getViewTypeCount() {
        int i = 0;
        for (C0814c c0814c : this.f2444a.m4019a()) {
            i = c0814c.f2440a.getViewTypeCount() + i;
        }
        return Math.max(i, 1);
    }

    public int getItemViewType(int i) {
        int i2 = 0;
        for (C0814c c0814c : this.f2444a.m4019a()) {
            if (c0814c.f2441b) {
                int count = c0814c.f2440a.getCount();
                if (i < count) {
                    return c0814c.f2440a.getItemViewType(i) + i2;
                }
                i -= count;
            }
            i2 = c0814c.f2440a.getViewTypeCount() + i2;
        }
        return -1;
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean isEnabled(int i) {
        for (ListAdapter listAdapter : m4024a()) {
            int count = listAdapter.getCount();
            if (i < count) {
                return listAdapter.isEnabled(i);
            }
            i -= count;
        }
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        for (ListAdapter listAdapter : m4024a()) {
            int count = listAdapter.getCount();
            if (i < count) {
                return listAdapter.getView(i, view, viewGroup);
            }
            i -= count;
        }
        return null;
    }

    public long getItemId(int i) {
        for (ListAdapter listAdapter : m4024a()) {
            int count = listAdapter.getCount();
            if (i < count) {
                return listAdapter.getItemId(i);
            }
            i -= count;
        }
        return -1;
    }

    public int getPositionForSection(int i) {
        int i2 = 0;
        for (ListAdapter listAdapter : m4024a()) {
            if (listAdapter instanceof SectionIndexer) {
                int length;
                Object[] sections = ((SectionIndexer) listAdapter).getSections();
                if (sections != null) {
                    length = sections.length;
                } else {
                    length = 0;
                }
                if (i < length) {
                    return i2 + ((SectionIndexer) listAdapter).getPositionForSection(i);
                }
                if (sections != null) {
                    i -= length;
                }
            }
            i2 = listAdapter.getCount() + i2;
        }
        return 0;
    }

    public int getSectionForPosition(int i) {
        int i2 = 0;
        for (ListAdapter listAdapter : m4024a()) {
            int count = listAdapter.getCount();
            if (i >= count) {
                int length;
                if (listAdapter instanceof SectionIndexer) {
                    Object[] sections = ((SectionIndexer) listAdapter).getSections();
                    if (sections != null) {
                        length = i2 + sections.length;
                        i -= count;
                        i2 = length;
                    }
                }
                length = i2;
                i -= count;
                i2 = length;
            } else if (listAdapter instanceof SectionIndexer) {
                return i2 + ((SectionIndexer) listAdapter).getSectionForPosition(i);
            } else {
                return 0;
            }
        }
        return 0;
    }

    public Object[] getSections() {
        ArrayList arrayList = new ArrayList();
        for (ListAdapter listAdapter : m4024a()) {
            if (listAdapter instanceof SectionIndexer) {
                Object[] sections = ((SectionIndexer) listAdapter).getSections();
                if (sections != null) {
                    for (Object add : sections) {
                        arrayList.add(add);
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            return new String[0];
        }
        return arrayList.toArray(new Object[0]);
    }

    public void m4028a(ListAdapter listAdapter, boolean z) {
        this.f2444a.m4022a(listAdapter, z);
        notifyDataSetChanged();
    }

    public void m4030b(View view, boolean z) {
        this.f2444a.m4020a(view, z);
        notifyDataSetChanged();
    }

    protected List<ListAdapter> m4024a() {
        return this.f2444a.m4023b();
    }
}
