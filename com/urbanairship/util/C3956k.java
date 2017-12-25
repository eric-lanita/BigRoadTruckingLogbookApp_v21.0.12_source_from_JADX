package com.urbanairship.util;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.urbanairship.C3783j;
import com.urbanairship.C3860o.C3858k;

public final class C3956k {
    public static void m20517a(Context context, TextView textView, int i, Typeface typeface) {
        int i2 = -1;
        if (i != -1) {
            if (VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i);
            } else {
                textView.setTextAppearance(context, i);
            }
        }
        if (typeface != null) {
            if (textView.getTypeface() != null) {
                i2 = textView.getTypeface().getStyle();
            }
            textView.setPaintFlags((textView.getPaintFlags() | 1) | 128);
            if (i2 >= 0) {
                textView.setTypeface(typeface, i2);
            } else {
                textView.setTypeface(typeface);
            }
        }
    }

    public static Typeface m20516a(Context context, int i) {
        String string = context.getTheme().obtainStyledAttributes(i, C3858k.TextAppearance).getString(C3858k.TextAppearance_urbanAirshipFontPath);
        if (!C3954i.m20512a(string)) {
            try {
                return Typeface.createFromAsset(context.getAssets(), string);
            } catch (RuntimeException e) {
                C3783j.m19728e("Failed to load font path: " + string);
            }
        }
        return null;
    }
}
