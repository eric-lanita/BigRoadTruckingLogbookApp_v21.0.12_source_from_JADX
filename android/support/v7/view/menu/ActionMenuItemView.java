package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v7.p011a.C0564a.C0554b;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.menu.C0658m.C0655a;
import android.support.v7.view.menu.C0666f.C0657b;
import android.support.v7.widget.ActionMenuView.C0656a;
import android.support.v7.widget.C0654z;
import android.support.v7.widget.ak;
import android.support.v7.widget.ak.C0651b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends C0654z implements C0655a, C0656a, OnClickListener, OnLongClickListener {
    private C0669h f1625a;
    private CharSequence f1626b;
    private Drawable f1627c;
    private C0657b f1628d;
    private C0651b f1629e;
    private C0653b f1630f;
    private boolean f1631g;
    private boolean f1632h;
    private int f1633i;
    private int f1634j;
    private int f1635k;

    private class C0652a extends C0651b {
        final /* synthetic */ ActionMenuItemView f1621a;

        public C0652a(ActionMenuItemView actionMenuItemView) {
            this.f1621a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public ak mo517a() {
            if (this.f1621a.f1630f != null) {
                return this.f1621a.f1630f.mo665a();
            }
            return null;
        }

        protected boolean mo518b() {
            if (this.f1621a.f1628d == null || !this.f1621a.f1628d.mo529a(this.f1621a.f1625a)) {
                return false;
            }
            ak a = mo517a();
            if (a == null || !a.m3641k()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class C0653b {
        public abstract ak mo665a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1631g = resources.getBoolean(C0554b.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.ActionMenuItemView, i, 0);
        this.f1633i = obtainStyledAttributes.getDimensionPixelSize(C0563k.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1635k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1634j = -1;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f1631g = getContext().getResources().getBoolean(C0554b.abc_config_allowActionMenuItemTextWithIcon);
        m3072e();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1634j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public C0669h getItemData() {
        return this.f1625a;
    }

    public void mo523a(C0669h c0669h, int i) {
        this.f1625a = c0669h;
        setIcon(c0669h.getIcon());
        setTitle(c0669h.m3199a((C0655a) this));
        setId(c0669h.getItemId());
        setVisibility(c0669h.isVisible() ? 0 : 8);
        setEnabled(c0669h.isEnabled());
        if (c0669h.hasSubMenu() && this.f1629e == null) {
            this.f1629e = new C0652a(this);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1625a.hasSubMenu() && this.f1629e != null && this.f1629e.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        if (this.f1628d != null) {
            this.f1628d.mo529a(this.f1625a);
        }
    }

    public void setItemInvoker(C0657b c0657b) {
        this.f1628d = c0657b;
    }

    public void setPopupCallback(C0653b c0653b) {
        this.f1630f = c0653b;
    }

    public boolean mo524a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1632h != z) {
            this.f1632h = z;
            if (this.f1625a != null) {
                this.f1625a.m3214h();
            }
        }
    }

    private void m3072e() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f1626b) ? 1 : 0;
        if (this.f1627c == null || (this.f1625a.m3219m() && (this.f1631g || this.f1632h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f1626b : null);
    }

    public void setIcon(Drawable drawable) {
        this.f1627c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1635k) {
                f = ((float) this.f1635k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1635k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1635k) {
                f = ((float) this.f1635k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1635k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m3072e();
    }

    public boolean m3075b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f1626b = charSequence;
        setContentDescription(this.f1626b);
        m3072e();
    }

    public boolean mo525c() {
        return m3075b() && this.f1625a.getIcon() == null;
    }

    public boolean mo526d() {
        return m3075b();
    }

    public boolean onLongClick(View view) {
        if (m3075b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (ag.m1803e(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f1625a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m3075b();
        if (b && this.f1634j >= 0) {
            super.setPadding(this.f1634j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f1633i) : this.f1633i;
        if (mode != 1073741824 && this.f1633i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1627c != null) {
            super.setPadding((getMeasuredWidth() - this.f1627c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
