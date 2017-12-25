package com.bigroad.ttb.android.widget.p043a;

import android.app.Activity;
import android.view.View;
import com.bigroad.ttb.android.widget.C2463l;

public class C2445b extends C2443c {
    private final String f8692g;
    private final String f8693h;

    public C2445b(Activity activity, C2446d c2446d, int i, CharSequence charSequence, String str, String str2) {
        super(activity, c2446d, i, charSequence, false);
        this.f8692g = str;
        this.f8693h = str2;
    }

    public boolean mo1341a() {
        if (this.f == null) {
            this.f = new C2463l(this.a);
            this.f.setOnClickListener(this);
        }
        this.f.setIcon(this.f8692g);
        this.f.setLabel(this.d);
        return true;
    }

    public void onClick(View view) {
    }
}
