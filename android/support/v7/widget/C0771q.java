package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.C0539q;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class C0771q extends PopupWindow {
    private static final boolean f2321a = (VERSION.SDK_INT < 21);
    private boolean f2322b;

    public C0771q(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ay a = ay.m3733a(context, attributeSet, C0563k.PopupWindow, i, 0);
        if (a.m3748f(C0563k.PopupWindow_overlapAnchor)) {
            m3932a(a.m3738a(C0563k.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m3736a(C0563k.PopupWindow_android_popupBackground));
        a.m3737a();
        if (VERSION.SDK_INT < 14) {
            C0771q.m3931a((PopupWindow) this);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2321a && this.f2322b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2321a && this.f2322b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height;
        if (f2321a && this.f2322b) {
            height = i2 - view.getHeight();
        } else {
            height = i2;
        }
        super.update(view, i, height, i3, i4);
    }

    private static void m3931a(final PopupWindow popupWindow) {
        try {
            final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
            declaredField2.set(popupWindow, new OnScrollChangedListener() {
                public void onScrollChanged() {
                    try {
                        WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                        if (weakReference != null && weakReference.get() != null) {
                            onScrollChangedListener.onScrollChanged();
                        }
                    } catch (IllegalAccessException e) {
                    }
                }
            });
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m3932a(boolean z) {
        if (f2321a) {
            this.f2322b = z;
        } else {
            C0539q.m2491a((PopupWindow) this, z);
        }
    }
}
