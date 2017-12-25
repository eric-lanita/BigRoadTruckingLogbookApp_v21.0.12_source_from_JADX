package com.bigroad.ttb.android.p039h;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.C1178r;
import com.bigroad.shared.validation.ValidationError;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.ttb.android.C2226q;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.p029c.C1736b;
import com.google.common.collect.Range;
import java.util.Calendar;
import java.util.List;

public class C2091e extends C1178r {
    public static String m10476a(List<ValidationError> list, Context context) {
        String property = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ValidationError validationError = (ValidationError) list.get(i);
            if (i != 0) {
                stringBuilder.append(property);
            }
            stringBuilder.append(C2089d.m10473a(validationError, context));
        }
        return stringBuilder.toString();
    }

    public static boolean m10481a(List<ValidationError> list) {
        for (ValidationError d : list) {
            if (d.m5782d() != Severity.SUSPICIOUS) {
                return false;
            }
        }
        return true;
    }

    public static int m10475a(Severity severity) {
        if (severity != null) {
            switch (severity) {
                case SUSPICIOUS:
                    return R.drawable.ic_alert_flag_small;
                case WARNING:
                case ERROR:
                    return R.drawable.ic_alert_violation_small;
            }
        }
        return 0;
    }

    public static int m10482b(Severity severity) {
        if (severity != null) {
            switch (severity) {
                case SUSPICIOUS:
                    return R.drawable.ic_alert_flag;
                case WARNING:
                case ERROR:
                    return R.drawable.ic_alert_violation;
            }
        }
        return 0;
    }

    public static void m10477a(List<ValidationError> list, ImageView imageView, TextView textView, Context context) {
        if (list == null || list.isEmpty()) {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (C2091e.m10481a((List) list)) {
                imageView.setImageResource(R.drawable.ic_alert_flag);
            } else {
                imageView.setImageResource(R.drawable.ic_alert_violation);
            }
            imageView.setVisibility(0);
        }
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(C2091e.m10476a((List) list, context));
        }
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> boolean m10480a(FIELD_ENUM field_enum, C1176p<FIELD_ENUM> c1176p, TextView textView, TextView textView2, Context context) {
        int i = 0;
        boolean a = C2091e.m10479a(c1176p, textView, field_enum);
        if (textView2 != null) {
            if (!a) {
                i = 8;
            }
            textView2.setVisibility(i);
            if (c1176p != null) {
                List b = c1176p.m5961b((Enum) field_enum);
                if (!(b == null || b.isEmpty())) {
                    textView2.setText(C2091e.m10476a(b, context));
                }
            }
        }
        return a;
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> boolean m10479a(C1176p<FIELD_ENUM> c1176p, TextView textView, FIELD_ENUM... field_enumArr) {
        Severity severity = null;
        if (c1176p != null) {
            for (Enum a : field_enumArr) {
                Enum a2 = c1176p.m5954a(a2);
                if (a2 != null && (r0 == null || a2.compareTo(r0) > 0)) {
                    severity = a2;
                }
            }
        }
        return C2091e.m10478a(severity, textView);
    }

    public static boolean m10478a(Severity severity, TextView textView) {
        if (textView == null) {
            return false;
        }
        int a = C2091e.m10475a(severity);
        if (a == 0) {
            textView.setCompoundDrawables(null, null, null, null);
            return false;
        }
        int i = (int) (5.0f * textView.getResources().getDisplayMetrics().density);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a, 0);
        textView.setCompoundDrawablePadding(i);
        return true;
    }

    public static int m10474a() {
        EventManager q = OurApplication.m6295q();
        C1736b r = OurApplication.m6296r();
        C2226q s = OurApplication.m6297s();
        long b = OurApplication.m6269Z().mo914b();
        long F = OurApplication.m6285g().m12161F();
        if (F <= 0 || F >= b) {
            F = b;
        }
        b = q.m10051f();
        if (b < F) {
            F = b;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(F);
        int a = DailyLogUtils.m4284a(instance);
        int e = r.m8489e();
        if (e >= a) {
            e = a;
        }
        a = s.m10980b();
        if (a < e) {
            e = a;
        }
        a = r.m8479b();
        if (a > e) {
            return a;
        }
        return e;
    }

    public static Range<Integer> m10483b() {
        return Range.m18692a(Integer.valueOf(C2091e.m10474a()), Integer.valueOf(OurApplication.m6296r().m8485c()));
    }
}
