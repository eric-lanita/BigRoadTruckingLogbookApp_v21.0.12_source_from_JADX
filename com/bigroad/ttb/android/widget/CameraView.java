package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.bigroad.ttb.android.logging.C2134e;
import java.util.List;

public class CameraView extends ViewGroup implements Callback {
    private SurfaceView f8309a;
    private SurfaceHolder f8310b;
    private Size f8311c;
    private List<Size> f8312d;
    private Camera f8313e;

    private void m11765a(Context context) {
        this.f8309a = new SurfaceView(context);
        addView(this.f8309a);
        this.f8310b = this.f8309a.getHolder();
        this.f8310b.addCallback(this);
        this.f8310b.setType(3);
    }

    public CameraView(Context context) {
        super(context);
        m11765a(context);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11765a(context);
    }

    public void setCamera(Camera camera) {
        this.f8313e = camera;
        if (this.f8313e != null) {
            this.f8312d = this.f8313e.getParameters().getSupportedPreviewSizes();
            requestLayout();
        }
    }

    protected void onMeasure(int i, int i2) {
        int resolveSize = resolveSize(getSuggestedMinimumWidth(), i);
        int resolveSize2 = resolveSize(getSuggestedMinimumHeight(), i2);
        setMeasuredDimension(resolveSize, resolveSize2);
        if (this.f8312d != null) {
            this.f8311c = m11764a(this.f8312d, resolveSize, resolveSize2);
            C2134e.m10676b("TT-CameraView", "Optimal preview size of " + this.f8311c.width + "x" + this.f8311c.height + " selected for window " + resolveSize + "x" + resolveSize2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z && getChildCount() > 0) {
            int i5;
            int i6;
            View childAt = getChildAt(0);
            int i7 = i3 - i;
            int i8 = i4 - i2;
            if (this.f8311c != null) {
                i5 = this.f8311c.width;
                i6 = this.f8311c.height;
            } else {
                i6 = i8;
                i5 = i7;
            }
            if (i7 * i6 > i8 * i5) {
                i6 = (i5 * i8) / i6;
                childAt.layout((i7 - i6) / 2, 0, (i6 + i7) / 2, i8);
                return;
            }
            i6 = (i6 * i7) / i5;
            childAt.layout(0, (i8 - i6) / 2, i7, (i6 + i8) / 2);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            if (this.f8313e != null) {
                this.f8313e.setPreviewDisplay(surfaceHolder);
            }
        } catch (Throwable e) {
            C2134e.m10681d("TT-CameraView", "Exception caused by setPreviewDisplay()", e);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if (this.f8313e != null) {
            this.f8313e.stopPreview();
        }
    }

    private Size m11764a(List<Size> list, int i, int i2) {
        double d = ((double) i) / ((double) i2);
        if (list == null) {
            return null;
        }
        Size size = null;
        double d2 = Double.MAX_VALUE;
        for (Size size2 : list) {
            Size size3;
            double abs;
            if (Math.abs((((double) size2.width) / ((double) size2.height)) - d) <= 0.1d) {
                if (((double) Math.abs(size2.height - i2)) < d2) {
                    size3 = size2;
                    abs = (double) Math.abs(size2.height - i2);
                } else {
                    double d3 = d2;
                    size3 = size;
                    abs = d3;
                }
                size = size3;
                d2 = abs;
            }
        }
        if (size != null) {
            return size;
        }
        d2 = Double.MAX_VALUE;
        for (Size size22 : list) {
            if (((double) Math.abs(size22.height - i2)) < d2) {
                size3 = size22;
                abs = (double) Math.abs(size22.height - i2);
            } else {
                d3 = d2;
                size3 = size;
                abs = d3;
            }
            size = size3;
            d2 = abs;
        }
        return size;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.f8313e != null) {
            Parameters parameters = this.f8313e.getParameters();
            parameters.setPreviewSize(this.f8311c.width, this.f8311c.height);
            requestLayout();
            this.f8313e.setParameters(parameters);
            try {
                this.f8313e.startPreview();
            } catch (Throwable e) {
                C2134e.m10681d("TT-CameraView", "Exception caused by startPreview()", e);
            }
        }
    }
}
