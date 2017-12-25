package com.bigroad.ttb.android.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.ttb.android.C2047k;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DailyLogEditActivity;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.widget.C1643q;
import java.util.TimeZone;

public class C1675i extends C1652g {
    private final C2047k f5818a;

    class C16711 implements OnClickListener {
        final /* synthetic */ C1675i f5811a;

        C16711(C1675i c1675i) {
            this.f5811a = c1675i;
        }

        public void onClick(View view) {
            this.f5811a.f5818a.mo957a(null);
        }
    }

    public C1675i(DailyLogEditActivity dailyLogEditActivity, C2047k c2047k) {
        super(dailyLogEditActivity);
        this.f5818a = c2047k;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        DisplayedRow a = m7196a(i);
        return a.m8095e() ? view2 : m8196a(a, view2);
    }

    private View m8196a(final DisplayedRow displayedRow, View view) {
        TextView textView = (TextView) view.findViewById(R.id.eventItem_note);
        View findViewById = view.findViewById(R.id.eventItem_odometerRow);
        View findViewById2 = view.findViewById(R.id.eventItem_engineHoursRow);
        View findViewById3 = view.findViewById(R.id.eventItem_originRow);
        final Button button = (Button) view.findViewById(R.id.eventItem_editButton);
        if (this.f5818a.mo930f() == null || !this.f5818a.mo930f().mo1036a((C1643q) displayedRow)) {
            if (displayedRow.m8093c()) {
                view.setBackgroundResource(R.color.darker_gray);
            } else {
                view.setBackgroundResource(R.drawable.list_selector_background);
            }
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1675i f5815b;

                public void onClick(View view) {
                    this.f5815b.f5818a.mo957a(displayedRow);
                }
            });
            textView.setMaxLines(displayedRow.m8098h() ? Integer.MAX_VALUE : 1);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            button.setVisibility(8);
        } else {
            view.setBackgroundResource(R.drawable.list_highlight);
            view.setOnClickListener(new C16711(this));
            textView.setMaxLines(Integer.MAX_VALUE);
            if (displayedRow.m8100j()) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                findViewById3.setVisibility(0);
            }
            button.setVisibility(displayedRow.m8098h() ? 8 : 0);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C1675i f5813b;

                public void onClick(View view) {
                    this.f5813b.f5818a.mo1190a(displayedRow);
                }
            });
        }
        view.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ C1675i f5817b;

            public void onFocusChange(View view, boolean z) {
                if (z && button.getVisibility() == 0) {
                    button.requestFocus();
                }
            }
        });
        return view;
    }

    protected TimeZone mo989a() {
        return this.f5818a.m10252b();
    }
}
