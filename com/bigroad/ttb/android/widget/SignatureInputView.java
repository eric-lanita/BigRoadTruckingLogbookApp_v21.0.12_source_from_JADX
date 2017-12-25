package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SignatureInputView extends View {
    private final RectF f8653a = new RectF();
    private final RectF f8654b = new RectF();
    private final Paint f8655c;
    private final Paint f8656d;
    private final Paint f8657e;
    private boolean f8658f = false;
    private float f8659g = 0.0f;
    private float f8660h = 0.0f;
    private Path f8661i = new Path();
    private Path f8662j = new Path();
    private Path f8663k = new Path();

    public SignatureInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        this.f8655c = new Paint();
        this.f8655c.setAntiAlias(true);
        this.f8655c.setStrokeWidth(4.0f);
        this.f8655c.setStrokeCap(Cap.ROUND);
        this.f8655c.setStrokeJoin(Join.ROUND);
        this.f8655c.setColor(-16777216);
        this.f8655c.setStyle(Style.STROKE);
        this.f8657e = new Paint(this.f8655c);
        this.f8657e.setStyle(Style.FILL);
        this.f8656d = new Paint(this.f8655c);
        this.f8656d.setColor(-7829368);
        this.f8656d.setStrokeCap(Cap.SQUARE);
        this.f8656d.setStrokeWidth(2.0f);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8662j.rewind();
        float f = ((float) i2) * 0.9f;
        float f2 = ((float) i) * 0.1f;
        this.f8662j.moveTo(f2, f);
        this.f8662j.lineTo(((float) getWidth()) - f2, f);
    }

    public void m12034a() {
        this.f8661i.rewind();
        this.f8663k.rewind();
        this.f8654b.setEmpty();
        invalidate();
    }

    public boolean m12035b() {
        return (this.f8661i.isEmpty() && this.f8663k.isEmpty()) ? false : true;
    }

    public Bitmap m12036c() {
        if (!m12035b()) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setTranslate(-this.f8654b.left, -this.f8654b.top);
        this.f8661i.transform(matrix);
        this.f8663k.transform(matrix);
        Bitmap createBitmap = Bitmap.createBitmap((int) Math.ceil((double) (this.f8654b.right - this.f8654b.left)), (int) Math.ceil((double) (this.f8654b.bottom - this.f8654b.top)), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawPath(this.f8661i, this.f8655c);
        canvas.drawPath(this.f8663k, this.f8657e);
        return createBitmap;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f8662j, this.f8656d);
        canvas.drawPath(this.f8661i, this.f8655c);
        canvas.drawPath(this.f8663k, this.f8657e);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8658f = true;
            this.f8661i.moveTo(x, y);
        } else if (actionMasked != 2 && actionMasked != 1) {
            return false;
        } else {
            if (actionMasked == 2 && x == this.f8659g && y == this.f8660h) {
                return true;
            }
            this.f8653a.setEmpty();
            m12031a(this.f8659g, this.f8660h);
            m12031a(x, y);
            int historySize = motionEvent.getHistorySize();
            for (int i = 0; i < historySize; i++) {
                float historicalX = motionEvent.getHistoricalX(0, i);
                float historicalY = motionEvent.getHistoricalY(0, i);
                this.f8661i.lineTo(historicalX, historicalY);
                this.f8658f = false;
                m12031a(historicalX, historicalY);
            }
            if (actionMasked == 1 && this.f8658f) {
                this.f8663k.addCircle(x, y, 4.0f, Direction.CW);
            } else {
                this.f8661i.lineTo(x, y);
                this.f8658f = false;
            }
            m12033d();
        }
        this.f8659g = x;
        this.f8660h = y;
        return true;
    }

    private void m12033d() {
        invalidate((int) Math.floor((double) this.f8653a.left), (int) Math.floor((double) this.f8653a.top), (int) Math.ceil((double) this.f8653a.right), (int) Math.ceil((double) this.f8653a.bottom));
    }

    private void m12031a(float f, float f2) {
        m12032a(this.f8653a, f, f2);
        m12032a(this.f8654b, f, f2);
    }

    private void m12032a(RectF rectF, float f, float f2) {
        float f3 = f - 8.0f;
        float f4 = f + 8.0f;
        float f5 = f2 - 8.0f;
        float f6 = 8.0f + f2;
        if (!rectF.isEmpty()) {
            f3 = Math.min(f3, rectF.left);
        }
        rectF.left = f3;
        rectF.right = rectF.isEmpty() ? f4 : Math.max(f4, rectF.right);
        rectF.top = rectF.isEmpty() ? f5 : Math.min(f5, rectF.top);
        rectF.bottom = rectF.isEmpty() ? f6 : Math.max(f6, rectF.bottom);
    }
}
