package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.WebView;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.maps.C2165f;

public class CheckInMapView extends C2165f {
    private Location f8314b;
    private boolean f8315c = false;
    private boolean f8316d = false;

    public CheckInMapView(Context context) {
        super(context);
    }

    public CheckInMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.CheckInMapView);
        this.f8315c = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    protected String getMapURL() {
        return "file:///android_asset/check_in_map.html";
    }

    public void setLocation(Location location) {
        this.f8314b = location;
        if (this.f8316d) {
            loadUrl("javascript:setLocation(" + this.f8314b.getLatitude() + "," + this.f8314b.getLongitude() + ");");
        }
    }

    protected void mo1256a(WebView webView, String str) {
        super.mo1256a(webView, str);
        this.f8316d = true;
        if (this.f8314b != null) {
            setLocation(this.f8314b);
        }
    }

    protected void onMeasure(int i, int i2) {
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (!this.f8315c || windowManager == null) {
            super.onMeasure(i, i2);
            return;
        }
        int height = (int) (((double) windowManager.getDefaultDisplay().getHeight()) * 0.4d);
        int mode = MeasureSpec.getMode(i2);
        if (mode != 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i2), height), mode));
        } else {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(height, 1073741824));
        }
    }
}
