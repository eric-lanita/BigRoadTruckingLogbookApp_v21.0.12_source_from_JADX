package com.bigroad.ttb.android.p037f;

import android.os.Bundle;
import android.view.View;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.dialog.HelpDialogFragment;
import com.bigroad.ttb.android.logging.C2134e;

public class C2031c {
    private static C2031c f7004a;
    private C2028d f7005b;
    private HelpDialogFragment f7006c;
    private boolean f7007d = false;

    public static C2031c m10140a() {
        if (f7004a == null) {
            f7004a = new C2031c();
        }
        return f7004a;
    }

    private C2031c() {
    }

    public void m10142a(View view) {
        if (this.f7005b != null) {
            this.f7005b.m10115a(view);
        }
    }

    public void m10144a(HelpDialogFragment helpDialogFragment, Bundle bundle) {
        this.f7006c = helpDialogFragment;
        if (bundle != null) {
            CharSequence string = bundle.getString("overlayClass");
            if (am.m4188a(string)) {
                C2134e.m10682e("TT-HelpManager", "initFromFragment: Could not get overlay class name from Bundle state");
                return;
            }
            C2134e.m10676b("TT-HelpManager", "Creating new class for overlay: " + string);
            try {
                this.f7005b = (C2028d) Class.forName(string).newInstance();
                this.f7005b.m10116a((OurActivity) helpDialogFragment.getActivity(), bundle);
                this.f7007d = true;
                C2134e.m10678c("TT-HelpManager", "Overlay initialized from fragment state: " + this.f7005b);
            } catch (InstantiationException e) {
                C2134e.m10682e("TT-HelpManager", "InstantiationException: " + e.getMessage());
            } catch (IllegalAccessException e2) {
                C2134e.m10682e("TT-HelpManager", "IllegalAccessException: " + e2.getMessage());
            } catch (ClassNotFoundException e3) {
                C2134e.m10682e("TT-HelpManager", "ClassNotFoundException: " + e3.getMessage());
            }
        }
    }

    public void m10141a(Bundle bundle) {
        if (this.f7005b != null) {
            bundle.putString("overlayClass", this.f7005b.getClass().getName());
            this.f7005b.m10114a(bundle);
        }
    }

    public void m10143a(OurActivity ourActivity, C2028d c2028d) {
        if (c2028d != null) {
            if (this.f7007d && this.f7005b != null && this.f7005b.getClass() == c2028d.getClass()) {
                C2134e.m10676b("TT-HelpManager", "Already showing help page: " + c2028d);
                return;
            }
            this.f7005b = c2028d;
            this.f7005b.m10116a(ourActivity, null);
            if (this.f7006c == null) {
                this.f7006c = this.f7005b.mo1181b();
                this.f7006c.show(ourActivity.getSupportFragmentManager(), "dialog");
                this.f7007d = true;
                C2134e.m10676b("TT-HelpManager", "Overlay shown via explicit showHelp call: " + c2028d);
                return;
            }
            C2134e.m10678c("TT-HelpManager", "Trying to re-show help with a fragment already in use");
        }
    }

    public void m10146b(View view) {
        if (this.f7006c == null) {
            C2134e.m10682e("TT-HelpManager", "Attempt to highlight a view without a HelpDialogFragment; Ignored");
        } else {
            this.f7006c.m8870a(view);
        }
    }

    public void m10145b() {
        if (this.f7005b == null) {
            C2134e.m10682e("TT-HelpManager", "Unable to start showing help because m_currentOverlay is null");
        } else {
            this.f7005b.m10117a(this.f7006c);
        }
    }

    public void m10148c(View view) {
        if (this.f7005b == null) {
            C2134e.m10682e("TT-HelpManager", "Unable to continue showing help because m_currentOverlay is null");
            return;
        }
        this.f7005b.m10118a(this.f7006c, view);
        if (this.f7005b != null) {
            this.f7005b.m10117a(this.f7006c);
        }
    }

    public void m10147c() {
        if (this.f7006c != null) {
            this.f7006c.dismiss();
        }
        m10149d();
    }

    public void m10149d() {
        this.f7006c = null;
        this.f7005b = null;
        this.f7007d = false;
    }
}
