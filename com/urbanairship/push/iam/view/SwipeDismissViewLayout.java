package com.urbanairship.push.iam.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.support.v4.view.C0474s;
import android.support.v4.view.ag;
import android.support.v4.widget.aa;
import android.support.v4.widget.aa.C0500a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.urbanairship.C3783j;

public class SwipeDismissViewLayout extends FrameLayout {
    private aa f13887a;
    private float f13888b;
    private C3890a f13889c;

    public interface C3890a {
        void mo2822a(View view);

        void mo2823a(View view, int i);
    }

    private class C3915b extends C0500a {
        final /* synthetic */ SwipeDismissViewLayout f13881a;
        private int f13882b;
        private int f13883c;
        private float f13884d;
        private View f13885e;
        private boolean f13886f;

        private C3915b(SwipeDismissViewLayout swipeDismissViewLayout) {
            this.f13881a = swipeDismissViewLayout;
            this.f13884d = 0.0f;
            this.f13886f = false;
        }

        public boolean mo2844b(View view, int i) {
            return this.f13885e == null;
        }

        public int mo2838a(View view, int i, int i2) {
            return i;
        }

        public int mo2843b(View view, int i, int i2) {
            return view.getTop();
        }

        public void mo2841a(View view, int i) {
            this.f13885e = view;
            this.f13882b = view.getTop();
            this.f13883c = view.getLeft();
            this.f13884d = 0.0f;
            this.f13886f = false;
        }

        @SuppressLint({"NewApi"})
        public void mo2842a(View view, int i, int i2, int i3, int i4) {
            int width = this.f13881a.getWidth() / 2;
            int abs = Math.abs(i - this.f13883c);
            if (width > 0) {
                this.f13884d = ((float) abs) / ((float) width);
            }
            if (VERSION.SDK_INT > 11) {
                view.setAlpha(1.0f - this.f13884d);
                this.f13881a.invalidate();
            }
        }

        public void mo2839a(int i) {
            if (this.f13885e != null) {
                synchronized (this) {
                    if (this.f13881a.f13889c != null) {
                        this.f13881a.f13889c.mo2823a(this.f13885e, i);
                    }
                    if (i == 0) {
                        if (this.f13886f) {
                            if (this.f13881a.f13889c != null) {
                                this.f13881a.f13889c.mo2822a(this.f13885e);
                            }
                            this.f13881a.removeView(this.f13885e);
                        }
                        this.f13885e = null;
                    }
                }
            }
        }

        public void mo2840a(View view, float f, float f2) {
            boolean z = false;
            boolean z2 = Math.abs(f) > this.f13881a.f13888b ? f > 0.0f : this.f13883c < view.getLeft();
            if (this.f13884d >= 0.75f || (Math.abs(f) > this.f13881a.f13888b && this.f13884d > 0.1f)) {
                z = true;
            }
            this.f13886f = z;
            if (this.f13886f) {
                this.f13881a.f13887a.m2325a(this.f13883c - (z2 ? -view.getWidth() : view.getWidth()), this.f13882b);
            } else {
                this.f13881a.f13887a.m2325a(this.f13883c, this.f13882b);
            }
            this.f13881a.invalidate();
        }
    }

    public SwipeDismissViewLayout(Context context) {
        super(context);
        m20291a(context);
    }

    public SwipeDismissViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20291a(context);
    }

    public SwipeDismissViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20291a(context);
    }

    @TargetApi(21)
    public SwipeDismissViewLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20291a(context);
    }

    private void m20291a(Context context) {
        if (!isInEditMode()) {
            this.f13888b = (float) ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
            this.f13887a = aa.m2306a((ViewGroup) this, new C3915b());
        }
    }

    public void setMinFlingVelocity(float f) {
        this.f13888b = f;
    }

    public float getMinFlingVelocity() {
        return this.f13888b;
    }

    public void setListener(C3890a c3890a) {
        synchronized (this) {
            this.f13889c = c3890a;
        }
    }

    @Keep
    @TargetApi(11)
    public float getYFraction() {
        int height = getHeight();
        if (height == 0) {
            return 0.0f;
        }
        return getTranslationY() / ((float) height);
    }

    @Keep
    @TargetApi(11)
    public void setYFraction(final float f) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ SwipeDismissViewLayout f13878b;

                public boolean onPreDraw() {
                    this.f13878b.setYFraction(f);
                    this.f13878b.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
            return;
        }
        setTranslationY(((float) getHeight()) * f);
    }

    @Keep
    @TargetApi(11)
    public float getXFraction() {
        int width = getWidth();
        if (width == 0) {
            return 0.0f;
        }
        return getTranslationX() / ((float) width);
    }

    @Keep
    @TargetApi(11)
    public void setXFraction(final float f) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ SwipeDismissViewLayout f13880b;

                public boolean onPreDraw() {
                    this.f13880b.setXFraction(f);
                    this.f13880b.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
            return;
        }
        setTranslationX(((float) getWidth()) * f);
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.f13887a != null && this.f13887a.m2328a(true)) {
            ag.m1793b(this);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f13887a.m2326a(motionEvent) || super.onInterceptTouchEvent(motionEvent)) {
            C3783j.m19728e("onInterceptTouchEvent " + motionEvent);
            return true;
        }
        if (this.f13887a.m2322a() == 0 && C0474s.m2141a(motionEvent) == 2 && this.f13887a.m2335c(1)) {
            View d = this.f13887a.m2337d((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(d == null || ag.m1791a(d, this.f13887a.m2334c()))) {
                this.f13887a.m2323a(d, C0474s.m2144b(motionEvent, 0));
                if (this.f13887a.m2322a() != 1) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f13887a.m2331b(motionEvent);
        return this.f13887a.m2329b() != null;
    }
}
