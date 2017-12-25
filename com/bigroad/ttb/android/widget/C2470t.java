package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

public class C2470t extends ViewPager {
    public C2470t(Context context) {
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
