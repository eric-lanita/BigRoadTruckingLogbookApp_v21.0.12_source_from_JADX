package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C3176R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.dynamic.zzg.zza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int f10490a;
    private int f10491b;
    private Scope[] f10492c;
    private View f10493d;
    private OnClickListener f10494e;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10494e = null;
        m16780a(context, attributeSet);
        setStyle(this.f10490a, this.f10491b, this.f10492c);
    }

    private static Button m16778a(Context context, int i, int i2, Scope[] scopeArr) {
        Button com_google_android_gms_common_internal_zzag = new zzag(context);
        com_google_android_gms_common_internal_zzag.zza(context.getResources(), i, i2, scopeArr);
        return com_google_android_gms_common_internal_zzag;
    }

    private void m16779a(Context context) {
        if (this.f10493d != null) {
            removeView(this.f10493d);
        }
        try {
            this.f10493d = zzaf.zzb(context, this.f10490a, this.f10491b, this.f10492c);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.f10493d = m16778a(context, this.f10490a, this.f10491b, this.f10492c);
        }
        addView(this.f10493d);
        this.f10493d.setEnabled(isEnabled());
        this.f10493d.setOnClickListener(this);
    }

    private void m16780a(Context context, AttributeSet attributeSet) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3176R.styleable.SignInButton, 0, 0);
        try {
            this.f10490a = obtainStyledAttributes.getInt(C3176R.styleable.SignInButton_buttonSize, 0);
            this.f10491b = obtainStyledAttributes.getInt(C3176R.styleable.SignInButton_colorScheme, 2);
            String string = obtainStyledAttributes.getString(C3176R.styleable.SignInButton_scopeUris);
            if (string == null) {
                this.f10492c = null;
            } else {
                String[] split = string.trim().split("\\s+");
                this.f10492c = new Scope[split.length];
                while (i < split.length) {
                    this.f10492c[i] = new Scope(split[i].toString());
                    i++;
                }
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void onClick(View view) {
        if (this.f10494e != null && view == this.f10493d) {
            this.f10494e.onClick(this);
        }
    }

    public void setColorScheme(int i) {
        setStyle(this.f10490a, i, this.f10492c);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f10493d.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f10494e = onClickListener;
        if (this.f10493d != null) {
            this.f10493d.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopeArr) {
        setStyle(this.f10490a, this.f10491b, scopeArr);
    }

    public void setSize(int i) {
        setStyle(i, this.f10491b, this.f10492c);
    }

    public void setStyle(int i, int i2) {
        setStyle(i, i2, this.f10492c);
    }

    public void setStyle(int i, int i2, Scope[] scopeArr) {
        this.f10490a = i;
        this.f10491b = i2;
        this.f10492c = scopeArr;
        m16779a(getContext());
    }
}
