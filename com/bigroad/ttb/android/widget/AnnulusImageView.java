package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import com.bigroad.shared.duty.TimeWindow.Condition;

public class AnnulusImageView extends AppCompatImageView {
    private final Path f8292a = new Path();
    private final Paint f8293b = new Paint();
    private Bitmap f8294c = null;
    private float f8295d = 1.0f;
    private Condition f8296e = Condition.WARN;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C23991();
        float f8290a;
        Condition f8291b;

        static class C23991 implements Creator<SavedState> {
            C23991() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m11750a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m11751a(i);
            }

            public SavedState m11750a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m11751a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f8290a = parcel.readFloat();
            this.f8291b = Condition.valueOf(parcel.readString());
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f8290a);
            parcel.writeString(this.f8291b.toString());
        }
    }

    public AnnulusImageView(Context context) {
        super(context);
        m11752a();
    }

    public AnnulusImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11752a();
    }

    private void m11752a() {
        this.f8293b.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.f8293b.setColor(0);
        this.f8293b.setStyle(Style.FILL);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = i3 - i;
        int i6 = i4 - i2;
        float f = ((float) i5) / 2.0f;
        float f2 = ((float) i6) / 2.0f;
        this.f8292a.reset();
        this.f8292a.moveTo(f, f2);
        this.f8292a.arcTo(new RectF(0.0f, 0.0f, (float) i5, (float) i6), -90.0f, getTimeAngle());
        this.f8292a.close();
        if (!(this.f8294c != null && this.f8294c.getWidth() == i5 && this.f8294c.getHeight() == i6)) {
            if (this.f8294c != null) {
                this.f8294c.recycle();
                this.f8294c = null;
            }
            if (i5 != 0 && i6 != 0) {
                this.f8294c = Bitmap.createBitmap(i5, i6, Config.ARGB_8888);
            } else {
                return;
            }
        }
        Canvas canvas = new Canvas(this.f8294c);
        canvas.drawColor(0, Mode.CLEAR);
        getDrawable().draw(canvas);
        canvas.drawPath(this.f8292a, this.f8293b);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f8294c != null) {
            canvas.drawBitmap(this.f8294c, 0.0f, 0.0f, null);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f8290a = this.f8295d;
        savedState.f8291b = this.f8296e;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            m11753a(savedState.f8291b, savedState.f8290a);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDetachedFromWindow() {
        if (this.f8294c != null) {
            this.f8294c.recycle();
            this.f8294c = null;
        }
        super.onDetachedFromWindow();
    }

    public void m11753a(Condition condition, float f) {
        this.f8295d = f;
        this.f8296e = condition;
        getDrawable().setLevel(C2462j.m12106a(condition));
        requestLayout();
        invalidate();
    }

    private float getTimeAngle() {
        return 360.0f * (Math.max(0.0055555557f, this.f8295d) - 1.0f);
    }
}
