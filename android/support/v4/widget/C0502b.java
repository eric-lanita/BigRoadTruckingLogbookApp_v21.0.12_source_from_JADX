package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class C0502b extends ImageView {
    private AnimationListener f1195a;
    private int f1196b;

    private class C0501a extends OvalShape {
        final /* synthetic */ C0502b f1191a;
        private RadialGradient f1192b;
        private Paint f1193c = new Paint();
        private int f1194d;

        public C0501a(C0502b c0502b, int i, int i2) {
            this.f1191a = c0502b;
            c0502b.f1196b = i;
            this.f1194d = i2;
            this.f1192b = new RadialGradient((float) (this.f1194d / 2), (float) (this.f1194d / 2), (float) c0502b.f1196b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f1193c.setShader(this.f1192b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f1191a.getWidth();
            int height = this.f1191a.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f1194d / 2) + this.f1191a.f1196b), this.f1193c);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f1194d / 2), paint);
        }
    }

    public C0502b(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f1196b = (int) (3.5f * f2);
        if (m2341a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ag.m1804e((View) this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C0501a(this, this.f1196b, i2));
            ag.m1782a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f1196b, (float) i4, (float) i3, 503316480);
            int i5 = this.f1196b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean m2341a() {
        return VERSION.SDK_INT >= 21;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m2341a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f1196b * 2), getMeasuredHeight() + (this.f1196b * 2));
        }
    }

    public void m2342a(AnimationListener animationListener) {
        this.f1195a = animationListener;
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f1195a != null) {
            this.f1195a.onAnimationStart(getAnimation());
        }
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f1195a != null) {
            this.f1195a.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
