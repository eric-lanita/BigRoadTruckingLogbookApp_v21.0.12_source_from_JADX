package com.urbanairship.push.iam.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.C0126a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.urbanairship.C3783j;
import com.urbanairship.C3860o.C3850c;
import com.urbanairship.C3860o.C3852e;
import com.urbanairship.C3860o.C3853f;
import com.urbanairship.C3860o.C3857j;
import com.urbanairship.C3860o.C3858k;
import com.urbanairship.push.iam.view.C3912a.C3893b;
import com.urbanairship.push.iam.view.C3912a.C3895a;
import com.urbanairship.push.p033a.C3869c;
import com.urbanairship.push.p033a.C3872d;
import com.urbanairship.util.C3954i;
import com.urbanairship.util.C3956k;

class C3918b implements C3912a {
    private final Context f13893a;
    private final TextView f13894b;
    private final View f13895c;
    private final ImageButton f13896d;
    private final ViewGroup f13897e;
    private int f13898f;
    private int f13899g;
    private int f13900h;
    private Typeface f13901i;
    private C3893b f13902j;
    private C3895a f13903k;

    class C39161 implements OnClickListener {
        final /* synthetic */ C3918b f13890a;

        C39161(C3918b c3918b) {
            this.f13890a = c3918b;
        }

        public void onClick(View view) {
            if (this.f13890a.f13902j != null) {
                this.f13890a.f13902j.mo2824a();
            }
        }
    }

    C3918b(Context context, ViewGroup viewGroup, AttributeSet attributeSet, int i) {
        this.f13893a = context;
        View inflate = BannerView.inflate(context, C3853f.ua_iam_content, viewGroup);
        this.f13894b = (TextView) inflate.findViewById(C3852e.alert);
        this.f13895c = inflate.findViewById(C3852e.action_divider);
        this.f13897e = (ViewGroup) inflate.findViewById(C3852e.action_buttons);
        this.f13896d = (ImageButton) inflate.findViewById(C3852e.close);
        this.f13897e.setVisibility(8);
        this.f13895c.setVisibility(8);
        this.f13896d.setOnClickListener(new C39161(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3858k.BannerView, i, C3857j.InAppMessage_Banner);
            Typeface typeface = null;
            String string = obtainStyledAttributes.getString(C3858k.BannerView_bannerFontPath);
            if (!C3954i.m20512a(string)) {
                try {
                    typeface = Typeface.createFromAsset(context.getAssets(), string);
                } catch (RuntimeException e) {
                    C3783j.m19728e("Failed to load font path: " + string);
                }
            }
            int color = context.getResources().getColor(C3850c.ua_iam_primary);
            int color2 = context.getResources().getColor(C3850c.ua_iam_secondary);
            setPrimaryColor(obtainStyledAttributes.getColor(C3858k.BannerView_bannerPrimaryColor, color));
            setSecondaryColor(obtainStyledAttributes.getColor(C3858k.BannerView_bannerSecondaryColor, color2));
            if (obtainStyledAttributes.getBoolean(C3858k.BannerView_bannerNoDismissButton, false)) {
                this.f13896d.setVisibility(8);
            } else {
                Drawable drawable = obtainStyledAttributes.getDrawable(C3858k.BannerView_bannerDismissButtonDrawable);
                if (drawable != null) {
                    this.f13896d.setImageDrawable(drawable);
                }
            }
            this.f13900h = obtainStyledAttributes.getResourceId(C3858k.BannerView_bannerActionButtonTextAppearance, -1);
            this.f13901i = C3956k.m20516a(context, this.f13900h);
            if (this.f13901i == null) {
                this.f13901i = typeface;
            }
            color2 = obtainStyledAttributes.getResourceId(C3858k.BannerView_bannerTextAppearance, -1);
            Typeface a = C3956k.m20516a(context, color2);
            if (a != null) {
                typeface = a;
            }
            m20295a(context, this.f13894b, color2, typeface);
            obtainStyledAttributes.recycle();
        }
    }

    public void setText(CharSequence charSequence) {
        this.f13894b.setText(charSequence);
    }

    public void setNotificationActionButtonGroup(C3872d c3872d) {
        this.f13897e.removeAllViewsInLayout();
        if (c3872d == null) {
            this.f13897e.setVisibility(8);
            this.f13895c.setVisibility(8);
            return;
        }
        this.f13897e.setVisibility(0);
        this.f13895c.setVisibility(0);
        LayoutInflater from = LayoutInflater.from(this.f13893a);
        int applyDimension = (int) TypedValue.applyDimension(1, 32.0f, this.f13893a.getResources().getDisplayMetrics());
        for (final C3869c c3869c : c3872d.m20078a()) {
            Button button = (Button) from.inflate(C3853f.ua_iam_button, this.f13897e, false);
            if (c3869c.m20073c() > 0) {
                button.setText(c3869c.m20073c());
            }
            if (c3869c.m20074d() > 0) {
                Drawable a = C0126a.m582a(this.f13893a, c3869c.m20074d());
                a.setBounds(0, 0, applyDimension, applyDimension);
                a.setColorFilter(this.f13899g, Mode.MULTIPLY);
                button.setCompoundDrawables(a, null, null, null);
            }
            m20295a(this.f13893a, button, this.f13900h, this.f13901i);
            button.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C3918b f13892b;

                public void onClick(View view) {
                    if (this.f13892b.f13903k != null) {
                        this.f13892b.f13903k.mo2825a(c3869c);
                    }
                }
            });
            this.f13897e.addView(button);
        }
    }

    public void setOnDismissClickListener(C3893b c3893b) {
        this.f13902j = c3893b;
    }

    public void setOnActionClickListener(C3895a c3895a) {
        this.f13903k = c3895a;
    }

    public void setSecondaryColor(int i) {
        this.f13899g = i;
        this.f13895c.setBackgroundColor(this.f13899g);
        this.f13896d.setColorFilter(this.f13899g, Mode.MULTIPLY);
        this.f13894b.setTextColor(this.f13899g);
        for (int i2 = 0; i2 < this.f13897e.getChildCount(); i2++) {
            View childAt = this.f13897e.getChildAt(i2);
            if (childAt instanceof Button) {
                Button button = (Button) childAt;
                for (Drawable drawable : button.getCompoundDrawables()) {
                    if (drawable != null) {
                        drawable.setColorFilter(this.f13899g, Mode.MULTIPLY);
                    }
                }
                button.setTextColor(this.f13899g);
            }
        }
    }

    public void setPrimaryColor(int i) {
        this.f13898f = i;
    }

    int m20297a() {
        return this.f13898f;
    }

    private void m20295a(Context context, TextView textView, int i, Typeface typeface) {
        C3956k.m20517a(context, textView, i, typeface);
        textView.setTextColor(this.f13899g);
    }
}
