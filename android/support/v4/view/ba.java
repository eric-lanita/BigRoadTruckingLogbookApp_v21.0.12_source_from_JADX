package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ba {
    public static void m2009a(final View view, final bd bdVar) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (bdVar != null) {
            animatorUpdateListener = new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    bdVar.mo493a(view);
                }
            };
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
