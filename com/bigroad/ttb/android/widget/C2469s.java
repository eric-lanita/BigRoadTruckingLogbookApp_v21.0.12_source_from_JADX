package com.bigroad.ttb.android.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class C2469s implements OnTouchListener, Runnable {
    private final OnClickListener f8803a;
    private final long f8804b;
    private View f8805c = null;

    public C2469s(OnClickListener onClickListener, long j) {
        this.f8803a = onClickListener;
        this.f8804b = j;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.f8805c == null) {
                    this.f8805c = view;
                    this.f8805c.playSoundEffect(0);
                    this.f8805c.post(this);
                    break;
                }
                return true;
            case 1:
            case 3:
            case 4:
                if (this.f8805c != null) {
                    this.f8805c.removeCallbacks(this);
                    this.f8805c = null;
                    break;
                }
                return true;
        }
        return false;
    }

    public void run() {
        this.f8803a.onClick(this.f8805c);
        this.f8805c.postDelayed(this, this.f8804b);
    }
}
