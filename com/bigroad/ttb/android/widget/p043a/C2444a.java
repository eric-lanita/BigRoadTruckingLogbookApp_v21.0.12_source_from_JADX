package com.bigroad.ttb.android.widget.p043a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.widget.Toast;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.widget.C2463l;
import com.facebook.internal.NativeProtocol;

public class C2444a extends C2443c {
    private final Intent f8688g;
    private final ComponentName f8689h;
    private ResolveInfo f8690i;
    private boolean f8691j = false;

    public C2444a(Activity activity, C2446d c2446d, Intent intent, int i, ComponentName componentName, CharSequence charSequence) {
        super(activity, c2446d, i, charSequence, true);
        this.f8688g = intent;
        this.f8689h = componentName;
    }

    public void m12054a(boolean z) {
        this.f8691j = z;
    }

    public void onClick(View view) {
        Toast a = OurApplication.m6272a(this.a);
        this.a.startActivityForResult(this.f8688g, this.c);
        a.show();
        m12053e();
    }

    public boolean mo1341a() {
        PackageManager e = OurApplication.m6283e();
        if (e == null) {
            return false;
        }
        if (this.f8688g != null) {
            this.f8690i = e.resolveActivity(this.f8688g, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (this.f8690i != null) {
                if (this.f == null) {
                    this.f = new C2463l(this.a);
                    this.f.setOnClickListener(this);
                }
                ResolveInfo a = C1632a.m7923a(e, this.f8688g, this.f8690i, this.f8689h);
                this.f.setIcon(a.loadIcon(e));
                this.f.setLabel(a == this.f8690i ? this.f8690i.loadLabel(e) : this.d);
                if (!this.f8691j || this.f8690i.priority >= 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int mo1342b() {
        return this.c;
    }

    public View mo1343c() {
        return this.f;
    }
}
