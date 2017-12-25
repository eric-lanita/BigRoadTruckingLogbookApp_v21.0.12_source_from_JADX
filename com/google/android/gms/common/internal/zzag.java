package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C3176R;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Scope;

public final class zzag extends Button {
    public zzag(Context context) {
        this(context, null);
    }

    public zzag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private int m16878a(int i, int i2, int i3) {
        switch (i) {
            case 0:
            case 1:
                return i3;
            case 2:
                return i2;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    private int m16879a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void m16880a(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void m16881a(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? m16878a(i, m16879a(i2, C3176R.drawable.common_plus_signin_btn_icon_dark, C3176R.drawable.common_plus_signin_btn_icon_light, C3176R.drawable.common_plus_signin_btn_icon_dark), m16879a(i2, C3176R.drawable.common_plus_signin_btn_text_dark, C3176R.drawable.common_plus_signin_btn_text_light, C3176R.drawable.common_plus_signin_btn_text_dark)) : m16878a(i, m16879a(i2, C3176R.drawable.common_google_signin_btn_icon_dark, C3176R.drawable.common_google_signin_btn_icon_light, C3176R.drawable.common_google_signin_btn_icon_light), m16879a(i2, C3176R.drawable.common_google_signin_btn_text_dark, C3176R.drawable.common_google_signin_btn_text_light, C3176R.drawable.common_google_signin_btn_text_light))));
    }

    private boolean m16882a(Scope[] scopeArr) {
        if (scopeArr == null) {
            return false;
        }
        for (Scope zzaok : scopeArr) {
            String zzaok2 = zzaok.zzaok();
            if (zzaok2.contains("/plus.") && !zzaok2.equals(Scopes.PLUS_ME)) {
                return true;
            }
            if (zzaok2.equals(Scopes.GAMES)) {
                return true;
            }
        }
        return false;
    }

    private void m16883b(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) zzab.zzy(resources.getColorStateList(z ? m16879a(i2, C3176R.color.common_plus_signin_btn_text_dark, C3176R.color.common_plus_signin_btn_text_light, C3176R.color.common_plus_signin_btn_text_dark) : m16879a(i2, C3176R.color.common_google_signin_btn_text_dark, C3176R.color.common_google_signin_btn_text_light, C3176R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C3176R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C3176R.string.common_signin_button_text_long));
                break;
            case 2:
                setText(null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
    }

    public void zza(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean a = m16882a(scopeArr);
        m16880a(resources);
        m16881a(resources, i, i2, a);
        m16883b(resources, i, i2, a);
    }
}
