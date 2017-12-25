package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class az {
    public static void m1999a(final View view, final bb bbVar) {
        if (bbVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    bbVar.mo328c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    bbVar.mo327b(view);
                }

                public void onAnimationStart(Animator animator) {
                    bbVar.mo326a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }
}
