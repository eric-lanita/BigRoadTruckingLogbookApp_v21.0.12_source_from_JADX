package com.bigroad.ttb.android.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.widget.ActionBarDrawer;
import com.bigroad.ttb.android.widget.CustomTitleBar;

public class C1635b {
    private final C1266a f5639a;
    private CustomTitleBar f5640b;
    private ActionBarDrawer f5641c;
    private boolean f5642d = false;
    private boolean f5643e = false;

    public interface C1266a {
        void mo917a(int i);

        View findViewById(int i);

        LayoutInflater getLayoutInflater();

        CharSequence getTitle();
    }

    class C16331 implements OnClickListener {
        final /* synthetic */ C1635b f5637a;

        C16331(C1635b c1635b) {
            this.f5637a = c1635b;
        }

        public void onClick(View view) {
            this.f5637a.m8030e();
        }
    }

    class C16342 implements OnClickListener {
        final /* synthetic */ C1635b f5638a;

        C16342(C1635b c1635b) {
            this.f5638a = c1635b;
        }

        public void onClick(View view) {
            this.f5638a.m8017g();
        }
    }

    public C1635b(C1266a c1266a) {
        this.f5639a = c1266a;
    }

    public CustomTitleBar m8018a() {
        return this.f5640b;
    }

    public void m8020a(View view) {
        ViewGroup f = m8016f();
        f.removeAllViews();
        f.addView(view);
    }

    public void m8019a(int i) {
        ViewGroup f = m8016f();
        f.removeAllViews();
        this.f5639a.getLayoutInflater().inflate(i, f);
    }

    public void m8021a(View view, LayoutParams layoutParams) {
        ViewGroup f = m8016f();
        f.removeAllViews();
        f.addView(view, layoutParams);
    }

    public void m8025b(View view, LayoutParams layoutParams) {
        m8016f().addView(view, layoutParams);
    }

    private ViewGroup m8016f() {
        if (this.f5640b != null) {
            return (ViewGroup) this.f5639a.findViewById(16908290);
        }
        this.f5639a.mo917a(R.layout.custom_title_bar_wrapper);
        this.f5641c = (ActionBarDrawer) this.f5639a.findViewById(R.id.action_bar_drawer);
        this.f5641c.setOnClickFillerView(new C16331(this));
        this.f5640b = (CustomTitleBar) this.f5639a.findViewById(R.id.custom_title_bar);
        this.f5640b.setTitle(this.f5639a.getTitle());
        this.f5640b.setOnClickListener(new C16342(this));
        this.f5639a.findViewById(16908290).setId(-1);
        ViewGroup viewGroup = (ViewGroup) this.f5639a.findViewById(R.id.custom_title_bar_content_wrapper);
        viewGroup.setId(16908290);
        return viewGroup;
    }

    protected void m8022a(CharSequence charSequence, int i) {
        if (this.f5640b != null) {
            this.f5640b.setTitle(charSequence);
        }
    }

    boolean m8027b() {
        if (this.f5640b == null || !this.f5640b.m11790g()) {
            return false;
        }
        this.f5640b.m11791h();
        return true;
    }

    public void m8028c() {
        if (this.f5640b != null) {
            this.f5640b.m11792i();
        }
    }

    void m8024b(int i) {
        this.f5641c.setContentLeft(i);
    }

    boolean m8029d() {
        return this.f5643e;
    }

    void m8023a(boolean z) {
        if (this.f5640b != null) {
            this.f5642d = z;
            if (this.f5642d) {
                this.f5640b.m11796m();
                return;
            }
            this.f5640b.m11795l();
            m8030e();
        }
    }

    void m8026b(boolean z) {
        if (this.f5640b != null && this.f5641c != null && this.f5643e != z) {
            this.f5643e = z;
            if (this.f5643e) {
                this.f5640b.m11793j();
                this.f5641c.setVisibility(0);
                return;
            }
            this.f5640b.m11794k();
            this.f5641c.setVisibility(8);
        }
    }

    private void m8017g() {
        if (this.f5642d) {
            m8026b(!this.f5643e);
        }
    }

    void m8030e() {
        m8026b(false);
    }
}
