package com.bigroad.ttb.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.C0126a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.ClaimUnassignedDrivingActivity;
import com.bigroad.ttb.android.adapter.EventListAdapter.DisplayedRow;
import com.bigroad.ttb.android.fragment.UnassignedDrivingClaimer;
import com.bigroad.ttb.android.fragment.UnassignedDrivingClaimer.ClaimState;
import com.bigroad.ttb.android.util.ac;
import com.bigroad.ttb.android.widget.C1643q;
import java.util.TimeZone;

public class C1653a extends C1652g {
    private final UnassignedDrivingClaimer f5763a;

    public C1653a(ClaimUnassignedDrivingActivity claimUnassignedDrivingActivity, UnassignedDrivingClaimer unassignedDrivingClaimer) {
        super(claimUnassignedDrivingActivity);
        this.f5763a = unassignedDrivingClaimer;
    }

    public DisplayedRow m8160c() {
        return m8157b(-1);
    }

    private DisplayedRow m8157b(int i) {
        for (int i2 = i + 1; i2 < getCount(); i2++) {
            DisplayedRow a = m7196a(i2);
            if (a != null && a.m8090a()) {
                C0890f b = a.m8092b();
                if (!mo1037a(b) && b.m4531z() && this.f5763a.m10417d(b) == ClaimState.UNKNOWN && this.f5763a.m10414a(b)) {
                    return a;
                }
            }
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        final C1643q a = m7196a(i);
        if (a.m8090a()) {
            long j;
            final C0890f b = a.m8092b();
            Context context = view2.getContext();
            Resources resources = context.getResources();
            boolean z = this.f5763a.mo930f() != null && this.f5763a.mo930f().mo1036a(a);
            boolean a2 = this.f5763a.m10414a(b);
            boolean z2 = !mo1037a(b);
            m8153d(view2, z2 ? 8 : 0);
            TextView textView = (TextView) view2.findViewById(R.id.eventItem_time);
            m8156a(textView, context, z, z2);
            textView.setText(m7223a(context, b.m4508c()));
            m8156a((TextView) view2.findViewById(R.id.eventItem_dutyStatus), context, z, z2);
            TextView textView2 = (TextView) view2.findViewById(R.id.eventItem_duration);
            m8156a(textView2, context, z, z2);
            View a3 = m8154a(view2, context, R.id.eventItem_locationRow, R.id.eventItem_locationLabel, R.id.eventItem_location, z, z2);
            View a4 = m8154a(view2, context, R.id.eventItem_odometerRow, R.id.eventItem_odometerLabel, R.id.eventItem_odometer, z, z2);
            View a5 = m8154a(view2, context, R.id.eventItem_engineHoursRow, R.id.eventItem_engineHoursLabel, R.id.eventItem_engineHours, z, z2);
            m8154a(view2, context, R.id.eventItem_originRow, R.id.eventItem_originLabel, R.id.eventItem_origin, z, z2);
            if (a.m8100j()) {
                a4.setVisibility(0);
                a5.setVisibility(0);
            } else {
                a4.setVisibility(8);
                a5.setVisibility(8);
            }
            m7226a(a3, z2);
            if (mo1037a(b) || b.mo702m() != DutyStatus.DRIVING) {
                j = b.m4515j();
            } else {
                j = b.m4514i();
            }
            textView2.setText(ac.m11175a(aq.m4214a(j), resources));
            textView = (TextView) view2.findViewById(R.id.eventItem_note);
            m8156a(textView, context, z, z2);
            textView.setText(b.m4529x());
            if (am.m4188a(b.m4529x())) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            Button button = (Button) view2.findViewById(R.id.eventItem_claimButton);
            Button button2 = (Button) view2.findViewById(R.id.eventItem_ignoreButton);
            TextView textView3 = (TextView) view2.findViewById(R.id.eventItem_question);
            m8156a(textView3, context, z, z2);
            if (mo1037a(b) || b.mo702m() != DutyStatus.DRIVING) {
                textView3.setVisibility(8);
                button.setVisibility(8);
                button2.setVisibility(8);
            } else {
                final DisplayedRow b2 = m8157b(i);
                textView3.setVisibility(0);
                button2.setVisibility(0);
                button2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1653a f5755c;

                    public void onClick(View view) {
                        this.f5755c.f5763a.m10412a(b, ClaimState.IGNORED);
                        if (b2 != null) {
                            this.f5755c.f5763a.mo957a(b2);
                        }
                    }
                });
                if (a2) {
                    textView3.setText(R.string.claimUnassignedDriving_selectionPrompt);
                    textView3.setTextSize(16.0f);
                    button.setVisibility(0);
                    button.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ C1653a f5758c;

                        public void onClick(View view) {
                            this.f5758c.f5763a.m10412a(b, ClaimState.CLAIMED);
                            if (b2 != null) {
                                this.f5758c.f5763a.mo957a(b2);
                            }
                        }
                    });
                } else {
                    textView3.setText(R.string.claimUnassignedDriving_unclaimableSelectionPrompt);
                    textView3.setTextSize(14.0f);
                    button.setVisibility(8);
                    button2.setVisibility(0);
                }
            }
            if (z) {
                view2.setBackgroundResource(R.drawable.list_highlight);
                view2.setOnClickListener(null);
                textView.setMaxLines(Integer.MAX_VALUE);
                if (z2) {
                    textView3.setCompoundDrawablesWithIntrinsicBounds(C0126a.m582a(context, (int) R.drawable.ic_alert_unassdriving_regular), null, null, null);
                }
            } else {
                if (z2) {
                    view2.setBackgroundResource(R.color.white);
                    textView3.setCompoundDrawablesWithIntrinsicBounds(C0126a.m582a(context, (int) R.drawable.ic_alert_unclaimed_drivers_events), null, null, null);
                } else {
                    view2.setBackgroundResource(R.drawable.list_selector_background);
                }
                view2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ C1653a f5760b;

                    public void onClick(View view) {
                        this.f5760b.f5763a.mo957a(a);
                    }
                });
                if (b.m8116C()) {
                    textView.setMaxLines(Integer.MAX_VALUE);
                } else {
                    textView.setMaxLines(1);
                }
            }
        }
        return view2;
    }

    private View m8154a(View view, Context context, int i, int i2, int i3, boolean z, boolean z2) {
        m8156a((TextView) view.findViewById(i2), context, z, z2);
        m8156a((TextView) view.findViewById(i3), context, z, z2);
        return view.findViewById(i);
    }

    private void m8156a(TextView textView, Context context, boolean z, boolean z2) {
        if (!z2 || z) {
            textView.setTextColor(C0126a.m584b(context, R.color.white));
        } else {
            textView.setTextColor(C0126a.m584b(context, R.color.black));
        }
    }

    protected TimeZone mo989a() {
        return this.f5763a.m10232b();
    }

    protected boolean mo1037a(C0890f c0890f) {
        return this.f5763a.m10416c(c0890f);
    }
}
