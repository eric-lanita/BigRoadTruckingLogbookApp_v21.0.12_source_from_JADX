package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.menu.C0658m.C0655a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0655a {
    private C0669h f1639a;
    private ImageView f1640b;
    private RadioButton f1641c;
    private TextView f1642d;
    private CheckBox f1643e;
    private TextView f1644f;
    private Drawable f1645g;
    private int f1646h;
    private Context f1647i;
    private boolean f1648j;
    private int f1649k;
    private Context f1650l;
    private LayoutInflater f1651m;
    private boolean f1652n;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1650l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.MenuView, i, 0);
        this.f1645g = obtainStyledAttributes.getDrawable(C0563k.MenuView_android_itemBackground);
        this.f1646h = obtainStyledAttributes.getResourceId(C0563k.MenuView_android_itemTextAppearance, -1);
        this.f1648j = obtainStyledAttributes.getBoolean(C0563k.MenuView_preserveIconSpacing, false);
        this.f1647i = context;
        obtainStyledAttributes.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1645g);
        this.f1642d = (TextView) findViewById(C0558f.title);
        if (this.f1646h != -1) {
            this.f1642d.setTextAppearance(this.f1647i, this.f1646h);
        }
        this.f1644f = (TextView) findViewById(C0558f.shortcut);
    }

    public void mo523a(C0669h c0669h, int i) {
        this.f1639a = c0669h;
        this.f1649k = i;
        setVisibility(c0669h.isVisible() ? 0 : 8);
        setTitle(c0669h.m3199a((C0655a) this));
        setCheckable(c0669h.isCheckable());
        m3086a(c0669h.m3212f(), c0669h.m3208d());
        setIcon(c0669h.getIcon());
        setEnabled(c0669h.isEnabled());
    }

    public void setForceShowIcon(boolean z) {
        this.f1652n = z;
        this.f1648j = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1642d.setText(charSequence);
            if (this.f1642d.getVisibility() != 0) {
                this.f1642d.setVisibility(0);
            }
        } else if (this.f1642d.getVisibility() != 8) {
            this.f1642d.setVisibility(8);
        }
    }

    public C0669h getItemData() {
        return this.f1639a;
    }

    public void setCheckable(boolean z) {
        if (z || this.f1641c != null || this.f1643e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1639a.m3213g()) {
                if (this.f1641c == null) {
                    m3083c();
                }
                compoundButton = this.f1641c;
                compoundButton2 = this.f1643e;
            } else {
                if (this.f1643e == null) {
                    m3084d();
                }
                compoundButton = this.f1643e;
                compoundButton2 = this.f1641c;
            }
            if (z) {
                int i;
                compoundButton.setChecked(this.f1639a.isChecked());
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1643e != null) {
                this.f1643e.setVisibility(8);
            }
            if (this.f1641c != null) {
                this.f1641c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1639a.m3213g()) {
            if (this.f1641c == null) {
                m3083c();
            }
            compoundButton = this.f1641c;
        } else {
            if (this.f1643e == null) {
                m3084d();
            }
            compoundButton = this.f1643e;
        }
        compoundButton.setChecked(z);
    }

    public void m3086a(boolean z, char c) {
        int i = (z && this.f1639a.m3212f()) ? 0 : 8;
        if (i == 0) {
            this.f1644f.setText(this.f1639a.m3210e());
        }
        if (this.f1644f.getVisibility() != i) {
            this.f1644f.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1639a.m3215i() || this.f1652n) ? 1 : 0;
        if (i == 0 && !this.f1648j) {
            return;
        }
        if (this.f1640b != null || drawable != null || this.f1648j) {
            if (this.f1640b == null) {
                m3082b();
            }
            if (drawable != null || this.f1648j) {
                ImageView imageView = this.f1640b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1640b.getVisibility() != 0) {
                    this.f1640b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1640b.setVisibility(8);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1640b != null && this.f1648j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1640b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    private void m3082b() {
        this.f1640b = (ImageView) getInflater().inflate(C0560h.abc_list_menu_item_icon, this, false);
        addView(this.f1640b, 0);
    }

    private void m3083c() {
        this.f1641c = (RadioButton) getInflater().inflate(C0560h.abc_list_menu_item_radio, this, false);
        addView(this.f1641c);
    }

    private void m3084d() {
        this.f1643e = (CheckBox) getInflater().inflate(C0560h.abc_list_menu_item_checkbox, this, false);
        addView(this.f1643e);
    }

    public boolean mo524a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f1651m == null) {
            this.f1651m = LayoutInflater.from(this.f1650l);
        }
        return this.f1651m;
    }
}
