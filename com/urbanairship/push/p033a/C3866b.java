package com.urbanairship.push.p033a;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ao;
import android.support.v4.app.ao.C0169a;

public class C3866b {
    private final String f13742a;
    private final int f13743b;
    private final int[] f13744c;
    private final Bundle f13745d;
    private final boolean f13746e;
    private final int f13747f;

    public ao m20064a(Context context) {
        C0169a a = new C0169a(this.f13742a).m749a(this.f13746e).m747a(this.f13745d);
        if (this.f13744c != null) {
            CharSequence[] charSequenceArr = new CharSequence[this.f13744c.length];
            for (int i = 0; i < this.f13744c.length; i++) {
                charSequenceArr[i] = context.getText(this.f13744c[i]);
            }
            a.m750a(charSequenceArr);
        }
        if (this.f13747f != 0) {
            a.m750a(context.getResources().getStringArray(this.f13747f));
        }
        if (this.f13743b != 0) {
            a.m748a(context.getText(this.f13743b));
        }
        return a.m751a();
    }
}
