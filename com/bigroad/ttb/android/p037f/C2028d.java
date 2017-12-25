package com.bigroad.ttb.android.p037f;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.dialog.HelpDialogFragment;
import com.bigroad.ttb.android.logging.C2134e;

public abstract class C2028d {
    private int f7002a = 0;
    private OurActivity f7003b;

    protected abstract void mo1178a(int i, Activity activity, View view);

    protected abstract void mo1179a(int i, HelpDialogFragment helpDialogFragment, View view);

    protected abstract boolean mo1180a(int i, HelpDialogFragment helpDialogFragment);

    protected abstract int mo1182c();

    protected OurActivity m10124d() {
        return this.f7003b;
    }

    public void m10115a(View view) {
        mo1178a(this.f7002a, this.f7003b, view);
    }

    public void m10116a(OurActivity ourActivity, Bundle bundle) {
        if (ourActivity != null) {
            this.f7003b = ourActivity;
            if (bundle != null) {
                this.f7002a = bundle.getInt("currentPageId");
            } else {
                this.f7002a = mo1182c();
            }
        }
    }

    public void m10114a(Bundle bundle) {
        bundle.putInt("currentPageId", this.f7002a);
    }

    public final void m10117a(HelpDialogFragment helpDialogFragment) {
        helpDialogFragment.m8875c();
        if (!mo1180a(this.f7002a, helpDialogFragment)) {
            C2134e.m10680d("TT-HelpOverlay", "Unable to show help page: " + this);
        }
    }

    public final void m10118a(HelpDialogFragment helpDialogFragment, View view) {
        mo1179a(this.f7002a, helpDialogFragment, view);
    }

    protected final void m10125e() {
        m10111a(this.f7002a + 1);
    }

    protected final void m10111a(int i) {
        this.f7002a = i;
    }

    final void m10126f() {
        OurApplication.m6246C().m10148c(null);
    }

    protected void m10127g() {
        OurApplication.m6246C().m10147c();
    }

    protected View m10120b(int i) {
        if (this.f7003b != null) {
            return this.f7003b.findViewById(i);
        }
        return null;
    }

    protected void m10123c(int i) {
        View b = m10120b(i);
        if (b == null) {
            C2134e.m10682e("TT-HelpOverlay", "Could not find matching view to highlight for help page: " + this);
        } else {
            OurApplication.m6246C().m10146b(b);
        }
    }

    protected HelpDialogFragment mo1181b() {
        return new HelpDialogFragment();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(";page(");
        stringBuilder.append(this.f7002a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
