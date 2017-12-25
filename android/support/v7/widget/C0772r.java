package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.p002a.p003a.C0093i;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class C0772r {
    private static final int[] f2323b = new int[]{16843067, 16843068};
    final C0765l f2324a;
    private final ProgressBar f2325c;
    private Bitmap f2326d;

    C0772r(ProgressBar progressBar, C0765l c0765l) {
        this.f2325c = progressBar;
        this.f2324a = c0765l;
    }

    void mo676a(AttributeSet attributeSet, int i) {
        ay a = ay.m3733a(this.f2325c.getContext(), attributeSet, f2323b, i, 0);
        Drawable b = a.m3740b(0);
        if (b != null) {
            this.f2325c.setIndeterminateDrawable(m3933a(b));
        }
        b = a.m3740b(1);
        if (b != null) {
            this.f2325c.setProgressDrawable(m3934a(b, false));
        }
        a.m3737a();
    }

    private Drawable m3934a(Drawable drawable, boolean z) {
        int i = 0;
        Drawable a;
        if (drawable instanceof C0093i) {
            a = ((C0093i) drawable).mo70a();
            if (a != null) {
                ((C0093i) drawable).mo71a(m3934a(a, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                boolean z2;
                int id = layerDrawable.getId(i2);
                Drawable drawable2 = layerDrawable.getDrawable(i2);
                if (id == 16908301 || id == 16908303) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawableArr[i2] = m3934a(drawable2, z2);
            }
            a = new LayerDrawable(drawableArr);
            while (i < numberOfLayers) {
                a.setId(i, layerDrawable.getId(i));
                i++;
            }
            return a;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f2326d == null) {
                this.f2326d = bitmap;
            }
            Drawable shapeDrawable = new ShapeDrawable(m3935b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable m3933a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        Drawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable a = m3934a(animationDrawable.getFrame(i), true);
            a.setLevel(10000);
            animationDrawable2.addFrame(a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    private Shape m3935b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap m3936a() {
        return this.f2326d;
    }
}
