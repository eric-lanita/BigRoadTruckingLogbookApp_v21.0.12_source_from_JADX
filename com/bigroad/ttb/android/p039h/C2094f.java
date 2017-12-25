package com.bigroad.ttb.android.p039h;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.C3512o;
import java.util.List;
import java.util.Map.Entry;

public class C2094f<FIELD_ENUM extends Enum<FIELD_ENUM>> {
    private final Activity f7307a;
    private final C3512o<FIELD_ENUM, C2093a> f7308b = ArrayListMultimap.m18434q();

    private static class C2093a {
        private final ImageView f7305a;
        private final TextView f7306b;

        private C2093a(ImageView imageView, TextView textView) {
            this.f7305a = imageView;
            this.f7306b = textView;
        }

        private void m10485a(List<ValidationError> list, Context context) {
            C2091e.m10477a(list, this.f7305a, this.f7306b, context);
        }
    }

    public C2094f(Activity activity) {
        this.f7307a = activity;
    }

    public void m10486a() {
        this.f7308b.mo2623f();
    }

    public void m10488a(FIELD_ENUM field_enum, int i, int i2) {
        this.f7308b.mo2614a(field_enum, new C2093a((ImageView) this.f7307a.findViewById(i), (TextView) this.f7307a.findViewById(i2)));
    }

    public void m10487a(C1176p<FIELD_ENUM> c1176p, Context context) {
        for (Entry entry : this.f7308b.mo2619j()) {
            List list;
            if (c1176p == null) {
                list = null;
            } else {
                list = c1176p.m5961b((Enum) entry.getKey());
            }
            ((C2093a) entry.getValue()).m10485a(list, context);
        }
    }
}
