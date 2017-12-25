package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.ai;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.android.util.ac;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1695r extends C1312m<String> {
    private final Map<String, List<String>> f5867a = new HashMap();
    private final int f5868b;
    private final long f5869c;
    private boolean f5870d = true;

    public C1695r(Context context, List<String> list, int i, long j) {
        super(context, R.layout.deletable_list_item, list);
        for (String str : list) {
            this.f5867a.put(str, am.m4192c(str));
        }
        this.f5868b = i;
        this.f5869c = j;
    }

    protected boolean m8266a(String str, CharSequence charSequence) {
        if (this.f5867a.isEmpty()) {
            return false;
        }
        if (am.m4188a(charSequence)) {
            return true;
        }
        String charSequence2 = charSequence.toString();
        return am.m4190a(str, charSequence2, (List) this.f5867a.get(str), am.m4192c(charSequence2));
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (view2 == null) {
            return null;
        }
        TextView textView = (TextView) view2.findViewById(16908308);
        ImageView imageView = (ImageView) view2.findViewById(R.id.deletable_button);
        if (this.f5870d) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1695r f5866b;

                public void onClick(View view) {
                    String str = (String) this.f5866b.getItem(i);
                    if (str != null) {
                        ai.m8368a().m8378a(str, this.f5866b.f5868b, this.f5866b.f5869c);
                        this.f5866b.f5867a.remove(str);
                        this.f5866b.m6820b((Object) str);
                    }
                }
            });
        } else {
            imageView.setVisibility(8);
        }
        if (C2291k.m11225d() <= 10) {
            imageView.setImageResource(R.drawable.remove_icon_black);
        }
        String str = (String) getItem(i);
        if (str == null) {
            return null;
        }
        textView.setText(str);
        if (C2291k.m11225d() <= 10) {
            textView.setTextColor(ac.m11172a(textView.getContext()));
        }
        return view2;
    }
}
