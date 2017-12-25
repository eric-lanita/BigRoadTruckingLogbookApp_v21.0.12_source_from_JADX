package com.bigroad.ttb.android.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;
import com.p017a.p018a.p019a.C0816a;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ac {
    private static final AtomicInteger f7917a = new AtomicInteger(1);

    public static void m11179a(EditText editText, CharSequence charSequence) {
        editText.setText(charSequence);
        editText.setSelection(editText.length());
    }

    public static void m11181a(TextView textView, Typeface typeface, int i) {
        textView.setTypeface(Typeface.create(typeface, i));
    }

    public static int m11172a(Context context) {
        return new EditText(context).getTextColors().getDefaultColor();
    }

    public static Integer m11173a(EditText editText) {
        String trim = editText.getText().toString().trim();
        if (trim != null) {
            try {
                return Integer.valueOf(Integer.parseInt(trim));
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }

    public static int m11171a() {
        int i;
        int i2;
        do {
            i = f7917a.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f7917a.compareAndSet(i, i2));
        return i;
    }

    public static void m11177a(View view, C0816a c0816a) {
        view.setBackgroundColor(0);
        view.setOnClickListener(null);
        c0816a.m4026a(view, true);
    }

    public static void m11176a(Context context, TextView textView) {
        textView.setTextAppearance(context, 16973894);
        textView.setTextColor(context.getResources().getColor(R.color.gray));
    }

    public static String m11175a(long j, Resources resources) {
        if (j < 60000) {
            return resources.getQuantityString(R.plurals.eventItem_durationMinutes, 0, new Object[]{Integer.valueOf(0)});
        }
        int i = (int) (j / 3600000);
        int i2 = (int) ((j % 3600000) / 60000);
        StringBuilder stringBuilder = new StringBuilder();
        if (i > 0) {
            stringBuilder.append(resources.getQuantityString(R.plurals.eventItem_durationHours, i, new Object[]{Integer.valueOf(i)}));
        }
        if (i > 0 && i2 > 0) {
            stringBuilder.append(" ");
        }
        if (i2 > 0) {
            stringBuilder.append(resources.getQuantityString(R.plurals.eventItem_durationMinutes, i2, new Object[]{Integer.valueOf(i2)}));
        }
        return stringBuilder.toString();
    }

    public static void m11184a(TextView... textViewArr) {
        int i = 0;
        int i2 = -1;
        for (TextView width : textViewArr) {
            i2 = Math.max(i2, width.getWidth());
        }
        int length = textViewArr.length;
        while (i < length) {
            textViewArr[i].setWidth(i2);
            i++;
        }
    }

    public static void m11180a(TextView textView, int i) {
        textView.setFilters(new InputFilter[]{new LengthFilter(i)});
    }

    public static Integer m11174a(TruckLogType truckLogType, boolean z) {
        switch (truckLogType) {
            case AOBRD:
                return Integer.valueOf(z ? R.drawable.ic_dashlink_aobrd_light_small : R.drawable.ic_dashlink_aobrd_small);
            case ELD:
                return Integer.valueOf(z ? R.drawable.ic_dashlink_eld_light_small : R.drawable.ic_dashlink_eld_small);
            default:
                return null;
        }
    }

    public static void m11182a(TextView textView, String str) {
        m11183a(textView, str, (int) R.string.none);
    }

    public static void m11183a(TextView textView, String str, int i) {
        if (textView != null) {
            C2303v c = C2303v.m11258c();
            if (am.m4188a((CharSequence) str)) {
                c.m11267b(textView.getResources().getString(i));
            } else {
                c.m11268c(str);
            }
            textView.setText(c.m11270e());
        }
    }

    public static void m11178a(Button button, boolean z) {
        if (button != null) {
            button.setEnabled(z);
            button.setAlpha(z ? 1.0f : 0.5f);
        }
    }
}
