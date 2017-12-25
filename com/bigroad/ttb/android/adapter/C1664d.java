package com.bigroad.ttb.android.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.bigroad.ttb.android.C2047k;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.activity.DailyLogEditActivity;
import com.bigroad.ttb.android.adapter.C1402k.C1679c;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.widget.C1643q;
import java.util.TimeZone;

public class C1664d extends C1402k {
    private final DailyLogEditActivity f5796a;
    private final C2047k f5797b;

    public C1664d(DailyLogEditActivity dailyLogEditActivity, C2047k c2047k) {
        super(dailyLogEditActivity, c2047k);
        this.f5796a = dailyLogEditActivity;
        this.f5797b = c2047k;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Button button;
        View view2 = super.getView(i, view, viewGroup);
        final C1643q a = m7185a(i);
        Button button2;
        switch (getItemViewType(i)) {
            case 0:
                button2 = (Button) view2.findViewById(R.id.dvirItem_editButton);
                button2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1664d f5789b;

                    public void onClick(View view) {
                        C1632a.m7936a(this.f5789b.f5796a, a.mo1043b(), false);
                    }
                });
                button = button2;
                break;
            case 1:
                button2 = (Button) view2.findViewById(R.id.inspectionItem_editButton);
                button2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1664d f5791b;

                    public void onClick(View view) {
                        this.f5791b.f5797b.mo1191a((C1679c) a);
                    }
                });
                button = button2;
                break;
            case 2:
                button = null;
                break;
            case 3:
                view2.setBackgroundColor(0);
                view2.setOnClickListener(null);
                button = null;
                break;
            case 4:
                button = null;
                break;
            default:
                C2134e.m10682e("TT-DailyLogEditDvirListAdapter", "Bad view type");
                return view2;
        }
        if (button != null) {
            boolean a2 = C2292l.m11232a(OurApplication.m6297s().m10971a(a.mo1043b()));
            int i2 = (this.f5797b.mo930f() == null || !this.f5797b.mo930f().mo1036a(a)) ? 0 : 1;
            if (a2) {
                view2.setBackgroundColor(0);
                view2.setOnClickListener(null);
                button.setVisibility(8);
            } else if (i2 != 0) {
                view2.setBackgroundResource(R.drawable.list_highlight);
                view2.setOnClickListener(null);
                button.setVisibility(0);
            } else {
                view2.setBackgroundResource(R.drawable.list_selector_background);
                view2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1664d f5793b;

                    public void onClick(View view) {
                        this.f5793b.f5797b.mo957a(a);
                    }
                });
                button.setVisibility(8);
            }
            view2.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ C1664d f5795b;

                public void onFocusChange(View view, boolean z) {
                    if (z && button.getVisibility() == 0) {
                        button.requestFocus();
                    }
                }
            });
        }
        return view2;
    }

    protected TimeZone mo985a() {
        return this.f5797b.m10252b();
    }

    public boolean mo986b() {
        return true;
    }
}
