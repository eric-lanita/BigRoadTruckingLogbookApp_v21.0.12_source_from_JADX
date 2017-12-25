package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.FleetList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C1689n extends BaseAdapter {
    private static final Comparator<Fleet> f5845a = new C16881();
    private final LayoutInflater f5846b;
    private final int f5847c;
    private List<Fleet> f5848d;
    private int f5849e = -1;

    static class C16881 implements Comparator<Fleet> {
        C16881() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8243a((Fleet) obj, (Fleet) obj2);
        }

        public int m8243a(Fleet fleet, Fleet fleet2) {
            return am.f2631d.compare(fleet.getName(), fleet2.getName());
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return m8250c(i);
    }

    public C1689n(Context context, int i) {
        this.f5846b = LayoutInflater.from(context);
        this.f5847c = i;
        this.f5848d = Collections.emptyList();
    }

    public void m8246a(int i) {
        this.f5849e = i;
    }

    public int m8244a() {
        return this.f5849e;
    }

    public void m8247a(FleetList fleetList) {
        this.f5848d = new ArrayList(fleetList.getFleetList());
        Collections.sort(this.f5848d, f5845a);
        notifyDataSetChanged();
    }

    public long m8249b(int i) {
        Fleet c = m8250c(i);
        return c == null ? -1 : c.getFleetId();
    }

    public int m8245a(long j) {
        for (int i = 0; i < this.f5848d.size(); i++) {
            if (((Fleet) this.f5848d.get(i)).getFleetId() == j) {
                return i;
            }
        }
        return -1;
    }

    public long m8248b() {
        return m8249b(this.f5849e);
    }

    public int getCount() {
        return this.f5848d.size();
    }

    public Fleet m8250c(int i) {
        return (i < 0 || i >= this.f5848d.size()) ? null : (Fleet) this.f5848d.get(i);
    }

    public long getItemId(int i) {
        return m8249b(i);
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5846b.inflate(this.f5847c, viewGroup, false);
        }
        ((TextView) view.findViewById(16908308)).setText(((Fleet) this.f5848d.get(i)).getName());
        return view;
    }
}
