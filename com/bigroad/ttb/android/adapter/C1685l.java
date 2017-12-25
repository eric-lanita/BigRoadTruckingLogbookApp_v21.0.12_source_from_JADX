package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bigroad.shared.C1131p;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.p035d.p036a.C1763a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1685l extends C1312m<C1763a> {
    private final Map<String, List<String>> f5842a = new HashMap();

    public C1685l(Context context, List<C1763a> list) {
        super(context, 17367043, list);
        for (C1763a a : list) {
            m8239a(a);
        }
    }

    protected boolean m8240a(C1763a c1763a, CharSequence charSequence) {
        String b = c1763a.m8560b();
        String charSequence2 = charSequence.toString();
        return am.m4190a(b, charSequence2, (List) this.f5842a.get(b), am.m4192c(charSequence2));
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        C1763a c1763a = (C1763a) getItem(i);
        TextView textView = view2 != null ? (TextView) view2.findViewById(16908308) : null;
        if (!(textView == null || c1763a == null)) {
            textView.setText(c1763a.m8560b());
        }
        return view2;
    }

    public void m8239a(C1763a c1763a) {
        String b = c1763a.m8560b();
        this.f5842a.put(b, C1131p.m5720c(b));
    }
}
