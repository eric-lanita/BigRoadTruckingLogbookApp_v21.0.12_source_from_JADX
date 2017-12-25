package com.bigroad.ttb.android.widget.p043a;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.widget.C2463l;

public abstract class C2443c implements OnClickListener {
    protected final Activity f8682a;
    protected final C2446d f8683b;
    protected final int f8684c;
    protected final CharSequence f8685d;
    protected final boolean f8686e;
    protected C2463l f8687f = null;

    public abstract boolean mo1341a();

    protected C2443c(Activity activity, C2446d c2446d, int i, CharSequence charSequence, boolean z) {
        this.f8682a = activity;
        this.f8683b = c2446d;
        this.f8684c = i;
        this.f8685d = charSequence;
        this.f8686e = z;
    }

    public int mo1342b() {
        return this.f8684c;
    }

    public boolean m12052d() {
        return this.f8686e;
    }

    public View mo1343c() {
        return this.f8687f;
    }

    protected void m12053e() {
        if (this.f8683b != null) {
            OurApplication.m6282d().m8296a(this.f8683b.m12059a());
        }
    }
}
