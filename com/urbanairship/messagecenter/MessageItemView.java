package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.urbanairship.C3860o.C3849b;
import com.urbanairship.C3860o.C3852e;
import com.urbanairship.C3860o.C3853f;
import com.urbanairship.C3860o.C3857j;
import com.urbanairship.C3860o.C3858k;
import com.urbanairship.richpush.C3942c;
import com.urbanairship.util.C3956k;

@TargetApi(14)
class MessageItemView extends FrameLayout {
    private static final int[] f13674a = new int[]{C3849b.ua_state_highlighted};
    private TextView f13675b;
    private TextView f13676c;
    private ImageView f13677d;
    private CheckBox f13678e;
    private boolean f13679f;
    private OnClickListener f13680g;
    private Typeface f13681h;
    private Typeface f13682i;
    private Typeface f13683j;
    private Typeface f13684k;

    class C38291 implements OnClickListener {
        final /* synthetic */ MessageItemView f13672a;

        C38291(MessageItemView messageItemView) {
            this.f13672a = messageItemView;
        }

        public void onClick(View view) {
            if (this.f13672a.f13680g != null) {
                this.f13672a.f13680g.onClick(this.f13672a);
            }
        }
    }

    class C38302 implements OnClickListener {
        final /* synthetic */ MessageItemView f13673a;

        C38302(MessageItemView messageItemView) {
            this.f13673a = messageItemView;
        }

        public void onClick(View view) {
            if (this.f13673a.f13680g != null) {
                this.f13673a.f13680g.onClick(this.f13673a);
            }
        }
    }

    public MessageItemView(Context context) {
        this(context, null, C3849b.messageCenterStyle);
    }

    public MessageItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3849b.messageCenterStyle);
    }

    public MessageItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19946a(context, attributeSet, i, C3857j.MessageCenter);
    }

    @TargetApi(21)
    public MessageItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m19946a(context, attributeSet, i, i2);
    }

    private void m19946a(Context context, AttributeSet attributeSet, int i, int i2) {
        int i3 = C3853f.ua_item_mc_content;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C3858k.MessageCenter, i, i2);
        if (obtainStyledAttributes.getBoolean(C3858k.MessageCenter_messageCenterItemIconEnabled, false)) {
            i3 = C3853f.ua_item_mc_icon_content;
        }
        int resourceId = obtainStyledAttributes.getResourceId(C3858k.MessageCenter_messageCenterItemDateTextAppearance, -1);
        this.f13682i = C3956k.m20516a(context, resourceId);
        int resourceId2 = obtainStyledAttributes.getResourceId(C3858k.MessageCenter_messageCenterItemTitleTextAppearance, -1);
        this.f13681h = C3956k.m20516a(context, resourceId2);
        int resourceId3 = obtainStyledAttributes.getResourceId(C3858k.MessageCenter_messageCenterItemBackground, -1);
        if (resourceId3 > 0) {
            setBackgroundResource(resourceId3);
        }
        obtainStyledAttributes.recycle();
        View inflate = View.inflate(context, i3, this);
        this.f13675b = (TextView) inflate.findViewById(C3852e.title);
        C3956k.m20517a(context, this.f13675b, resourceId2, this.f13681h);
        if (this.f13675b.getTypeface() != null) {
            this.f13684k = this.f13675b.getTypeface();
            this.f13683j = Typeface.create(this.f13675b.getTypeface(), this.f13675b.getTypeface().getStyle() | 1);
        } else {
            this.f13684k = Typeface.DEFAULT;
            this.f13683j = Typeface.DEFAULT_BOLD;
        }
        this.f13676c = (TextView) inflate.findViewById(C3852e.date);
        C3956k.m20517a(context, this.f13676c, resourceId, this.f13682i);
        this.f13677d = (ImageView) inflate.findViewById(C3852e.image);
        if (this.f13677d != null) {
            this.f13677d.setOnClickListener(new C38291(this));
        }
        this.f13678e = (CheckBox) inflate.findViewById(C3852e.checkbox);
        if (this.f13678e != null) {
            this.f13678e.setOnClickListener(new C38302(this));
        }
    }

    void m19948a(C3942c c3942c, int i, C3845c c3845c) {
        this.f13675b.setText(c3942c.m20448c());
        this.f13676c.setText(DateFormat.getDateFormat(getContext()).format(c3942c.m20450e()));
        if (c3942c.m20449d()) {
            this.f13675b.setTypeface(this.f13684k);
        } else {
            this.f13675b.setTypeface(this.f13683j);
        }
        if (this.f13678e != null) {
            this.f13678e.setChecked(isActivated());
        }
        if (this.f13677d != null) {
            c3845c.m20008a(c3942c.m20456k(), i, this.f13677d);
        }
    }

    public void setActivated(boolean z) {
        super.setActivated(z);
        if (this.f13678e != null) {
            this.f13678e.setChecked(z);
        }
    }

    void m19949a(boolean z) {
        if (this.f13679f != z) {
            this.f13679f = z;
            refreshDrawableState();
        }
    }

    void m19947a(OnClickListener onClickListener) {
        this.f13680g = onClickListener;
    }

    protected int[] onCreateDrawableState(int i) {
        if (!this.f13679f) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        mergeDrawableStates(onCreateDrawableState, f13674a);
        return onCreateDrawableState;
    }
}
