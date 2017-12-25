package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bigroad.ttb.android.C2476z.C2475a;

public class TriangleView extends View {
    private int f8668a = 1;
    private int f8669b = 0;
    private int f8670c = 1;
    private int f8671d = -1;
    private int f8672e = -16777216;

    public TriangleView(Context context) {
        super(context);
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.TriangleView);
        this.f8669b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f8670c = obtainStyledAttributes.getDimensionPixelSize(1, 1);
        this.f8671d = obtainStyledAttributes.getColor(3, -1);
        this.f8672e = obtainStyledAttributes.getColor(2, -16777216);
        obtainStyledAttributes.recycle();
    }

    public void setDirection(int i) {
        this.f8668a = i;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f8669b > 0) {
            Rect clipBounds = canvas.getClipBounds();
            int i = this.f8670c + ((int) getResources().getDisplayMetrics().density);
            clipBounds.inset(i, i);
            Point[] pointArr = new Point[3];
            switch (this.f8668a) {
                case 2:
                    pointArr[0] = new Point(clipBounds.left, clipBounds.top);
                    pointArr[1] = new Point(clipBounds.right, clipBounds.top);
                    pointArr[2] = new Point((clipBounds.left + clipBounds.right) / 2, (int) Math.floor((double) (clipBounds.top + this.f8669b)));
                    break;
                case 3:
                    pointArr[0] = new Point(clipBounds.right, clipBounds.top);
                    pointArr[1] = new Point(clipBounds.right, clipBounds.bottom);
                    pointArr[2] = new Point((int) Math.floor((double) (clipBounds.right - this.f8669b)), (clipBounds.bottom + clipBounds.top) / 2);
                    break;
                case 4:
                    pointArr[0] = new Point(clipBounds.left, clipBounds.top);
                    pointArr[1] = new Point(clipBounds.left, clipBounds.bottom);
                    pointArr[2] = new Point((int) Math.floor((double) (clipBounds.left + this.f8669b)), (clipBounds.bottom + clipBounds.top) / 2);
                    break;
                default:
                    pointArr[0] = new Point(clipBounds.left, clipBounds.bottom);
                    pointArr[1] = new Point(clipBounds.right, clipBounds.bottom);
                    pointArr[2] = new Point((clipBounds.left + clipBounds.right) / 2, (int) Math.floor((double) (clipBounds.bottom - this.f8669b)));
                    break;
            }
            Path path = new Path();
            path.moveTo((float) pointArr[0].x, (float) pointArr[0].y);
            path.lineTo((float) pointArr[1].x, (float) pointArr[1].y);
            path.lineTo((float) pointArr[2].x, (float) pointArr[2].y);
            path.close();
            Paint paint = new Paint();
            paint.setStyle(Style.FILL);
            paint.setColor(this.f8671d);
            paint.setAntiAlias(true);
            canvas.drawPath(path, paint);
            Point point = new Point(pointArr[0]);
            Point point2 = new Point(pointArr[1]);
            if (this.f8668a == 2 || this.f8668a == 1) {
                point.x += this.f8670c;
                point2.x -= this.f8670c;
            } else {
                point.y += this.f8670c;
                point2.y -= this.f8670c;
            }
            Path path2 = new Path();
            path2.moveTo((float) point.x, (float) point.y);
            path2.lineTo((float) point2.x, (float) point2.y);
            paint.setStrokeWidth((float) i);
            paint.setStyle(Style.STROKE);
            canvas.drawPath(path2, paint);
            path = new Path();
            path.moveTo((float) pointArr[0].x, (float) pointArr[0].y);
            path.lineTo((float) pointArr[2].x, (float) pointArr[2].y);
            path.lineTo((float) pointArr[1].x, (float) pointArr[1].y);
            Paint paint2 = new Paint();
            paint2.setStyle(Style.STROKE);
            paint2.setColor(this.f8672e);
            paint2.setStrokeWidth((float) this.f8670c);
            paint2.setStrokeJoin(Join.MITER);
            paint2.setAntiAlias(true);
            canvas.drawPath(path, paint2);
        }
    }
}
