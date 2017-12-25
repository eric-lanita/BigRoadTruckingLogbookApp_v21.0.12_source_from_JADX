package com.urbanairship.push.iam;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.share.internal.ShareConstants;
import com.urbanairship.C3783j;
import com.urbanairship.C3860o.C3852e;
import com.urbanairship.C3860o.C3853f;
import com.urbanairship.C3929q;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.actions.C3704f;
import com.urbanairship.push.iam.view.C3912a;
import com.urbanairship.push.iam.view.C3912a.C3893b;
import com.urbanairship.push.iam.view.C3912a.C3895a;
import com.urbanairship.push.iam.view.SwipeDismissViewLayout;
import com.urbanairship.push.iam.view.SwipeDismissViewLayout.C3890a;
import com.urbanairship.push.p033a.C3869c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@TargetApi(14)
public class InAppMessageFragment extends Fragment {
    private static Boolean f13839a;
    private InAppMessage f13840b;
    private boolean f13841c;
    private C3888e f13842d;
    private final List<C3898a> f13843e = new ArrayList();
    private boolean f13844f;

    class C38912 implements C3890a {
        final /* synthetic */ InAppMessageFragment f13834a;

        C38912(InAppMessageFragment inAppMessageFragment) {
            this.f13834a = inAppMessageFragment;
        }

        public void mo2822a(View view) {
            this.f13834a.m20220a(false);
            C3929q.m20372a().m20394r().m19455a(C3910d.m20279b(this.f13834a.f13840b, this.f13834a.f13842d.m20200d()));
        }

        public void mo2823a(View view, int i) {
            switch (i) {
                case 0:
                    if (this.f13834a.isResumed()) {
                        this.f13834a.f13842d.m20198b();
                        return;
                    }
                    return;
                case 1:
                    this.f13834a.f13842d.m20199c();
                    return;
                default:
                    return;
            }
        }
    }

    class C38923 implements OnClickListener {
        final /* synthetic */ InAppMessageFragment f13835a;

        C38923(InAppMessageFragment inAppMessageFragment) {
            this.f13835a = inAppMessageFragment;
        }

        public void onClick(View view) {
            this.f13835a.m20220a(true);
            this.f13835a.m20216a(this.f13835a.f13840b.m20190f(), 4);
            C3929q.m20372a().m20394r().m19455a(C3910d.m20276a(this.f13835a.f13840b, this.f13835a.f13842d.m20200d()));
        }
    }

    class C38944 implements C3893b {
        final /* synthetic */ InAppMessageFragment f13836a;

        C38944(InAppMessageFragment inAppMessageFragment) {
            this.f13836a = inAppMessageFragment;
        }

        public void mo2824a() {
            this.f13836a.m20220a(true);
            C3929q.m20372a().m20394r().m19455a(C3910d.m20279b(this.f13836a.f13840b, this.f13836a.f13842d.m20200d()));
        }
    }

    class C38965 implements C3895a {
        final /* synthetic */ InAppMessageFragment f13837a;

        C38965(InAppMessageFragment inAppMessageFragment) {
            this.f13837a = inAppMessageFragment;
        }

        public void mo2825a(C3869c c3869c) {
            C3783j.m19727d("In-app message button clicked: " + c3869c.m20072b());
            this.f13837a.m20220a(true);
            this.f13837a.m20216a(this.f13837a.f13840b.m20185a(c3869c.m20072b()), c3869c.m20075e() ? 4 : 5);
            C3929q.m20372a().m20394r().m19455a(C3910d.m20274a(this.f13837a.getActivity(), this.f13837a.f13840b, c3869c, this.f13837a.f13842d.m20200d()));
        }
    }

    class C38976 implements OnAttachStateChangeListener {
        final /* synthetic */ InAppMessageFragment f13838a;

        C38976(InAppMessageFragment inAppMessageFragment) {
            this.f13838a = inAppMessageFragment;
        }

        @SuppressLint({"NewApi"})
        public void onViewAttachedToWindow(View view) {
            if (ag.m1814n(view)) {
                switch (this.f13838a.f13840b.m20193i()) {
                    case 0:
                        if (VERSION.SDK_INT >= 23 && (this.f13838a.getActivity().getWindow().getAttributes().flags & 134217728) > 0) {
                            view.dispatchApplyWindowInsets(view.getRootWindowInsets());
                            return;
                        }
                        return;
                    case 1:
                        if ((this.f13838a.getActivity().getWindow().getAttributes().flags & 67108864) <= 0) {
                            return;
                        }
                        if (VERSION.SDK_INT >= 23) {
                            view.dispatchApplyWindowInsets(view.getRootWindowInsets());
                            return;
                        }
                        int identifier = this.f13838a.getResources().getIdentifier("status_bar_height", "dimen", "android");
                        if (identifier > 0) {
                            view.setPadding(view.getPaddingLeft(), this.f13838a.getResources().getDimensionPixelSize(identifier) + view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface C3898a {
        void mo2827a(InAppMessageFragment inAppMessageFragment);

        void mo2828b(InAppMessageFragment inAppMessageFragment);

        void mo2829c(InAppMessageFragment inAppMessageFragment);
    }

    public static Bundle m20213a(InAppMessage inAppMessage, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, inAppMessage);
        bundle.putInt("dismiss_animation", i);
        return bundle;
    }

    public final void m20219a(C3898a c3898a) {
        synchronized (this.f13843e) {
            this.f13843e.add(c3898a);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f13840b = (InAppMessage) getArguments().getParcelable(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        if (this.f13840b == null) {
            m20220a(false);
            return;
        }
        boolean z = bundle != null && bundle.getBoolean("dismissed", false);
        this.f13841c = z;
        this.f13842d = new C3888e(this, this.f13840b.m20192h() == null ? 15000 : this.f13840b.m20192h().longValue()) {
            final /* synthetic */ InAppMessageFragment f13833a;

            protected void mo2821a() {
                if (this.f13833a.isResumed()) {
                    this.f13833a.m20220a(true);
                    C3929q.m20372a().m20394r().m19455a(C3910d.m20280c(this.f13833a.f13840b, this.f13833a.f13842d.m20200d()));
                }
            }
        };
        if (bundle != null && bundle.getBoolean("dismiss_on_recreate", false) != this.f13844f) {
            C3783j.m19725c("InAppMessageFragment - Dismissing on recreate.");
            m20220a(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("dismissed", this.f13841c);
        bundle.putBoolean("dismiss_on_recreate", this.f13844f);
    }

    public void onResume() {
        super.onResume();
        this.f13842d.m20198b();
        synchronized (this.f13843e) {
            Iterator it = new ArrayList(this.f13843e).iterator();
            while (it.hasNext()) {
                ((C3898a) it.next()).mo2827a(this);
            }
        }
    }

    public void onPause() {
        super.onPause();
        this.f13842d.m20199c();
        synchronized (this.f13843e) {
            Iterator it = new ArrayList(this.f13843e).iterator();
            while (it.hasNext()) {
                ((C3898a) it.next()).mo2828b(this);
            }
        }
    }

    @SuppressLint({"NewAPI"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f13840b == null || this.f13840b.m20188d() == null) {
            m20220a(false);
            return null;
        }
        SwipeDismissViewLayout swipeDismissViewLayout = (SwipeDismissViewLayout) layoutInflater.inflate(m20218c() ? C3853f.ua_fragment_iam_card : C3853f.ua_fragment_iam, viewGroup, false);
        if (viewGroup != null && (viewGroup instanceof FrameLayout)) {
            LayoutParams layoutParams = (LayoutParams) swipeDismissViewLayout.getLayoutParams();
            layoutParams.gravity = this.f13840b.m20193i() == 1 ? 48 : 80;
            swipeDismissViewLayout.setLayoutParams(layoutParams);
        }
        swipeDismissViewLayout.setListener(new C38912(this));
        FrameLayout frameLayout = (FrameLayout) swipeDismissViewLayout.findViewById(C3852e.in_app_message);
        if (this.f13840b.m20190f().isEmpty()) {
            frameLayout.setClickable(false);
            frameLayout.setForeground(null);
        } else {
            frameLayout.setOnClickListener(new C38923(this));
        }
        C3912a c3912a = (C3912a) frameLayout;
        c3912a.setOnDismissClickListener(new C38944(this));
        c3912a.setOnActionClickListener(new C38965(this));
        if (this.f13840b.m20194j() != null) {
            c3912a.setPrimaryColor(this.f13840b.m20194j().intValue());
        }
        if (this.f13840b.m20195k() != null) {
            c3912a.setSecondaryColor(this.f13840b.m20195k().intValue());
        }
        c3912a.setText(this.f13840b.m20188d());
        c3912a.setNotificationActionButtonGroup(C3929q.m20372a().m20390n().m20307b(this.f13840b.m20191g()));
        if (VERSION.SDK_INT < 19 || viewGroup == null || viewGroup.getId() != 16908290) {
            return swipeDismissViewLayout;
        }
        swipeDismissViewLayout.addOnAttachStateChangeListener(new C38976(this));
        return swipeDismissViewLayout;
    }

    public void m20220a(boolean z) {
        this.f13842d.m20199c();
        if (!this.f13841c) {
            this.f13841c = true;
            synchronized (this.f13843e) {
                Iterator it = new ArrayList(this.f13843e).iterator();
                while (it.hasNext()) {
                    ((C3898a) it.next()).mo2829c(this);
                }
            }
            if (getActivity() != null) {
                getActivity().getFragmentManager().beginTransaction().setCustomAnimations(0, z ? getArguments().getInt("dismiss_animation", 0) : 0).remove(this).commitAllowingStateLoss();
            }
        }
    }

    public boolean m20221a() {
        return this.f13841c;
    }

    public InAppMessage m20222b() {
        return this.f13840b;
    }

    void m20223b(boolean z) {
        this.f13844f = z;
    }

    private static boolean m20218c() {
        if (f13839a == null) {
            try {
                Class.forName("android.support.v7.widget.CardView");
                f13839a = Boolean.valueOf(true);
            } catch (ClassNotFoundException e) {
                f13839a = Boolean.valueOf(false);
            }
        }
        return f13839a.booleanValue();
    }

    private void m20216a(Map<String, ActionValue> map, int i) {
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                C3704f.m19382a((String) entry.getKey()).m19387a((ActionValue) entry.getValue()).m19385a(i).m19388a();
            }
        }
    }
}
