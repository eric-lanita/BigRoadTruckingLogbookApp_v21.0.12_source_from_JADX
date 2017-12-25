package com.urbanairship.push.iam.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import com.urbanairship.C3860o.C3849b;
import com.urbanairship.C3860o.C3857j;
import com.urbanairship.C3860o.C3858k;
import com.urbanairship.push.iam.view.C3912a.C3893b;
import com.urbanairship.push.iam.view.C3912a.C3895a;
import com.urbanairship.push.p033a.C3872d;

public class BannerCardView extends CardView implements C3912a {
    private final C3918b f13875a;

    public BannerCardView(Context context) {
        this(context, null, C3849b.inAppMessageBannerStyle);
    }

    public BannerCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3849b.inAppMessageBannerStyle);
    }

    public BannerCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13875a = new C3918b(context, this, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3858k.CardView, i, C3857j.InAppMessage_Banner);
            if (!obtainStyledAttributes.hasValue(C3858k.CardView_cardBackgroundColor) && obtainStyledAttributes.hasValue(C3858k.CardView_optCardBackgroundColor)) {
                setCardBackgroundColor(obtainStyledAttributes.getInteger(C3858k.CardView_optCardBackgroundColor, 0));
            }
            if (!obtainStyledAttributes.hasValue(C3858k.CardView_cardElevation) && obtainStyledAttributes.hasValue(C3858k.CardView_optCardElevation)) {
                float dimension = obtainStyledAttributes.getDimension(C3858k.CardView_optCardElevation, 0.0f);
                if (dimension > getMaxCardElevation()) {
                    setMaxCardElevation(dimension);
                }
                setCardElevation(dimension);
            }
            if (!obtainStyledAttributes.hasValue(C3858k.CardView_cardCornerRadius) && obtainStyledAttributes.hasValue(C3858k.CardView_optCardCornerRadius)) {
                setRadius(obtainStyledAttributes.getDimension(C3858k.CardView_optCardCornerRadius, 0.0f));
            }
            obtainStyledAttributes.recycle();
        }
        setCardBackgroundColor(this.f13875a.m20297a());
    }

    public void setOnDismissClickListener(C3893b c3893b) {
        this.f13875a.setOnDismissClickListener(c3893b);
    }

    public void setOnActionClickListener(C3895a c3895a) {
        this.f13875a.setOnActionClickListener(c3895a);
    }

    public void setText(CharSequence charSequence) {
        this.f13875a.setText(charSequence);
    }

    public void setNotificationActionButtonGroup(C3872d c3872d) {
        this.f13875a.setNotificationActionButtonGroup(c3872d);
    }

    public void setPrimaryColor(int i) {
        setCardBackgroundColor(i);
        this.f13875a.setPrimaryColor(i);
    }

    public void setSecondaryColor(int i) {
        this.f13875a.setSecondaryColor(i);
    }
}
