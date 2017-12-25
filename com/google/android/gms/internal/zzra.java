package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import com.google.android.gms.common.util.zzs;

public final class zzra extends Drawable implements Callback {
    private int f11704a;
    private long f11705b;
    private int f11706c;
    private int f11707d;
    private int f11708e;
    private int f11709f;
    private int f11710g;
    private boolean f11711h;
    private boolean f11712i;
    private zzb f11713j;
    private Drawable f11714k;
    private Drawable f11715l;
    private boolean f11716m;
    private boolean f11717n;
    private boolean f11718o;
    private int f11719p;

    private static final class zza extends Drawable {
        private static final zza f11700a = new zza();
        private static final zza f11701b = new zza();

        private static final class zza extends ConstantState {
            private zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.f11700a;
            }
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return f11701b;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    static final class zzb extends ConstantState {
        int f11702a;
        int f11703b;

        zzb(zzb com_google_android_gms_internal_zzra_zzb) {
            if (com_google_android_gms_internal_zzra_zzb != null) {
                this.f11702a = com_google_android_gms_internal_zzra_zzb.f11702a;
                this.f11703b = com_google_android_gms_internal_zzra_zzb.f11703b;
            }
        }

        public int getChangingConfigurations() {
            return this.f11702a;
        }

        public Drawable newDrawable() {
            return new zzra(this);
        }
    }

    public zzra(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = zza.f11700a;
        }
        this.f11714k = drawable;
        drawable.setCallback(this);
        zzb com_google_android_gms_internal_zzra_zzb = this.f11713j;
        com_google_android_gms_internal_zzra_zzb.f11703b |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = zza.f11700a;
        }
        this.f11715l = drawable2;
        drawable2.setCallback(this);
        com_google_android_gms_internal_zzra_zzb = this.f11713j;
        com_google_android_gms_internal_zzra_zzb.f11703b |= drawable2.getChangingConfigurations();
    }

    zzra(zzb com_google_android_gms_internal_zzra_zzb) {
        this.f11704a = 0;
        this.f11708e = 255;
        this.f11710g = 0;
        this.f11711h = true;
        this.f11713j = new zzb(com_google_android_gms_internal_zzra_zzb);
    }

    public boolean canConstantState() {
        if (!this.f11716m) {
            boolean z = (this.f11714k.getConstantState() == null || this.f11715l.getConstantState() == null) ? false : true;
            this.f11717n = z;
            this.f11716m = true;
        }
        return this.f11717n;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.f11704a) {
            case 1:
                this.f11705b = SystemClock.uptimeMillis();
                this.f11704a = 2;
                break;
            case 2:
                if (this.f11705b >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f11705b)) / ((float) this.f11709f);
                    if (uptimeMillis < 1.0f) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.f11704a = 0;
                    }
                    this.f11710g = (int) ((Math.min(uptimeMillis, 1.0f) * ((float) (this.f11707d + 0))) + 0.0f);
                    break;
                }
                break;
        }
        i2 = i;
        i = this.f11710g;
        boolean z = this.f11711h;
        Drawable drawable = this.f11714k;
        Drawable drawable2 = this.f11715l;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.f11708e) {
                drawable2.setAlpha(this.f11708e);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.f11708e - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.f11708e);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f11708e);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.f11713j.f11702a) | this.f11713j.f11703b;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.f11713j.f11702a = getChangingConfigurations();
        return this.f11713j;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.f11714k.getIntrinsicHeight(), this.f11715l.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.f11714k.getIntrinsicWidth(), this.f11715l.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.f11718o) {
            this.f11719p = Drawable.resolveOpacity(this.f11714k.getOpacity(), this.f11715l.getOpacity());
            this.f11718o = true;
        }
        return this.f11719p;
    }

    @TargetApi(11)
    public void invalidateDrawable(Drawable drawable) {
        if (zzs.zzavn()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.f11712i && super.mutate() == this) {
            if (canConstantState()) {
                this.f11714k.mutate();
                this.f11715l.mutate();
                this.f11712i = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.f11714k.setBounds(rect);
        this.f11715l.setBounds(rect);
    }

    @TargetApi(11)
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (zzs.zzavn()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, runnable, j);
            }
        }
    }

    public void setAlpha(int i) {
        if (this.f11710g == this.f11708e) {
            this.f11710g = i;
        }
        this.f11708e = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11714k.setColorFilter(colorFilter);
        this.f11715l.setColorFilter(colorFilter);
    }

    public void startTransition(int i) {
        this.f11706c = 0;
        this.f11707d = this.f11708e;
        this.f11710g = 0;
        this.f11709f = i;
        this.f11704a = 1;
        invalidateSelf();
    }

    @TargetApi(11)
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (zzs.zzavn()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, runnable);
            }
        }
    }

    public Drawable zzarq() {
        return this.f11715l;
    }
}
