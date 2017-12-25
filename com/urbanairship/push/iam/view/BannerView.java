package com.urbanairship.push.iam.view;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.urbanairship.C3860o.C3849b;
import com.urbanairship.push.iam.view.C3912a.C3893b;
import com.urbanairship.push.iam.view.C3912a.C3895a;
import com.urbanairship.push.p033a.C3872d;

public class BannerView extends FrameLayout implements C3912a {
    private final C3918b f13876a;

    public BannerView(Context context) {
        this(context, null, C3849b.inAppMessageBannerStyle);
    }

    public BannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3849b.inAppMessageBannerStyle);
    }

    public BannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13876a = new C3918b(context, this, attributeSet, i);
        if (getBackground() != null) {
            getBackground().setColorFilter(this.f13876a.m20297a(), Mode.MULTIPLY);
        } else {
            setBackgroundColor(this.f13876a.m20297a());
        }
    }

    public void setOnDismissClickListener(C3893b c3893b) {
        this.f13876a.setOnDismissClickListener(c3893b);
    }

    public void setOnActionClickListener(C3895a c3895a) {
        this.f13876a.setOnActionClickListener(c3895a);
    }

    public void setText(CharSequence charSequence) {
        this.f13876a.setText(charSequence);
    }

    public void setNotificationActionButtonGroup(C3872d c3872d) {
        this.f13876a.setNotificationActionButtonGroup(c3872d);
    }

    public void setPrimaryColor(int i) {
        if (getBackground() != null) {
            getBackground().setColorFilter(i, Mode.MULTIPLY);
        } else {
            setBackgroundColor(i);
        }
        this.f13876a.setPrimaryColor(i);
    }

    public void setSecondaryColor(int i) {
        this.f13876a.setSecondaryColor(i);
    }
}
