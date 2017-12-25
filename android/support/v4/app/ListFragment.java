package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {
    ListAdapter f467a;
    ListView f468b;
    View f469c;
    TextView f470d;
    View f471e;
    View f472f;
    CharSequence f473g;
    boolean f474h;
    private final Handler f475i = new Handler();
    private final Runnable f476j = new C01211(this);
    private final OnItemClickListener f477k = new C01222(this);

    class C01211 implements Runnable {
        final /* synthetic */ ListFragment f465a;

        C01211(ListFragment listFragment) {
            this.f465a = listFragment;
        }

        public void run() {
            this.f465a.f468b.focusableViewAvailable(this.f465a.f468b);
        }
    }

    class C01222 implements OnItemClickListener {
        final /* synthetic */ ListFragment f466a;

        C01222(ListFragment listFragment) {
            this.f466a = listFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f466a.m568a((ListView) adapterView, view, i, j);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context activity = getActivity();
        View frameLayout = new FrameLayout(activity);
        View linearLayout = new LinearLayout(activity);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(activity, null, 16842874), new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        linearLayout = new FrameLayout(activity);
        linearLayout.setId(16711683);
        View textView = new TextView(getActivity());
        textView.setId(16711681);
        textView.setGravity(17);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        textView = new ListView(getActivity());
        textView.setId(16908298);
        textView.setDrawSelectorOnTop(false);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m565a();
    }

    public void onDestroyView() {
        this.f475i.removeCallbacks(this.f476j);
        this.f468b = null;
        this.f474h = false;
        this.f472f = null;
        this.f471e = null;
        this.f469c = null;
        this.f470d = null;
        super.onDestroyView();
    }

    public void m568a(ListView listView, View view, int i, long j) {
    }

    public void m567a(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f467a != null;
        this.f467a = listAdapter;
        if (this.f468b != null) {
            this.f468b.setAdapter(listAdapter);
            if (!this.f474h && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                m566a(true, z);
            }
        }
    }

    private void m566a(boolean z, boolean z2) {
        m565a();
        if (this.f471e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f474h != z) {
            this.f474h = z;
            if (z) {
                if (z2) {
                    this.f471e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
                    this.f472f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                } else {
                    this.f471e.clearAnimation();
                    this.f472f.clearAnimation();
                }
                this.f471e.setVisibility(8);
                this.f472f.setVisibility(0);
                return;
            }
            if (z2) {
                this.f471e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
                this.f472f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
            } else {
                this.f471e.clearAnimation();
                this.f472f.clearAnimation();
            }
            this.f471e.setVisibility(0);
            this.f472f.setVisibility(8);
        }
    }

    private void m565a() {
        if (this.f468b == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.f468b = (ListView) view;
            } else {
                this.f470d = (TextView) view.findViewById(16711681);
                if (this.f470d == null) {
                    this.f469c = view.findViewById(16908292);
                } else {
                    this.f470d.setVisibility(8);
                }
                this.f471e = view.findViewById(16711682);
                this.f472f = view.findViewById(16711683);
                view = view.findViewById(16908298);
                if (view instanceof ListView) {
                    this.f468b = (ListView) view;
                    if (this.f469c != null) {
                        this.f468b.setEmptyView(this.f469c);
                    } else if (this.f473g != null) {
                        this.f470d.setText(this.f473g);
                        this.f468b.setEmptyView(this.f470d);
                    }
                } else if (view == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.f474h = true;
            this.f468b.setOnItemClickListener(this.f477k);
            if (this.f467a != null) {
                ListAdapter listAdapter = this.f467a;
                this.f467a = null;
                m567a(listAdapter);
            } else if (this.f471e != null) {
                m566a(false, false);
            }
            this.f475i.post(this.f476j);
        }
    }
}
