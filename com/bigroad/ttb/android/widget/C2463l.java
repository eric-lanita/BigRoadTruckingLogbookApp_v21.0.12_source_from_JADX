package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.logging.C2134e;
import java.io.IOException;

public class C2463l extends LinearLayout {
    private static final LayoutParams f8789a = new LayoutParams(-2, -2);
    private ImageView f8790b;
    private ImageView f8791c;
    private TextView f8792d;

    static {
        f8789a.weight = 1.0f;
    }

    public C2463l(Context context) {
        super(context);
        m12113a(context);
    }

    private void m12113a(Context context) {
        setLayoutParams(f8789a);
        setOrientation(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.border_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackgroundResource(R.drawable.launcher_background);
        setGravity(17);
        LayoutInflater.from(context).inflate(R.layout.launcher_item, this);
        this.f8790b = (ImageView) findViewById(16908294);
        this.f8792d = (TextView) findViewById(16908310);
        this.f8791c = (ImageView) findViewById(R.id.badge);
        this.f8791c.setVisibility(4);
    }

    public void setIcon(Drawable drawable) {
        this.f8790b.setImageDrawable(drawable);
    }

    public void setIcon(String str) {
        try {
            this.f8790b.setImageBitmap(BitmapFactory.decodeStream(getContext().getAssets().open("app_icons/" + str)));
        } catch (IOException e) {
            C2134e.m10682e("TT-LauncherItem", "Icon (" + str + ") not found.");
        }
    }

    public void m12115a() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(17104896);
        int i = (int) (5.0f * getResources().getDisplayMetrics().density);
        int i2 = (int) (10.0f * getResources().getDisplayMetrics().density);
        if (dimensionPixelSize - i2 < i2) {
            i2 = 0;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.2f);
        this.f8790b.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        this.f8790b.getLayoutParams().height = dimensionPixelSize - i2;
        this.f8790b.getLayoutParams().width = dimensionPixelSize - i2;
        this.f8790b.setPadding(0, 0, i, i);
        this.f8791c.setVisibility(0);
        invalidate();
    }

    public void setLabel(CharSequence charSequence) {
        this.f8790b.setContentDescription(charSequence);
        this.f8792d.setText(charSequence);
    }

    public static int m12112a(View view) {
        return (view.getResources().getDimensionPixelSize(17104896) + (view.getResources().getDimensionPixelSize(R.dimen.border_padding) * 3)) + ((int) (16.0f * view.getResources().getDisplayMetrics().density));
    }

    public static int m12114b(View view) {
        return C2463l.m12112a(view);
    }
}
