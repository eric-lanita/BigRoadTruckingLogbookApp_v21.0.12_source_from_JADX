package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Interpolator;

class ay {
    public static void m1992a(View view, long j) {
        view.animate().setDuration(j);
    }

    public static void m1991a(View view, float f) {
        view.animate().alpha(f);
    }

    public static void m1996b(View view, float f) {
        view.animate().translationY(f);
    }

    public static long m1990a(View view) {
        return view.animate().getDuration();
    }

    public static void m1994a(View view, Interpolator interpolator) {
        view.animate().setInterpolator(interpolator);
    }

    public static void m1997b(View view, long j) {
        view.animate().setStartDelay(j);
    }

    public static void m1995b(View view) {
        view.animate().cancel();
    }

    public static void m1998c(View view) {
        view.animate().start();
    }

    public static void m1993a(final View view, final bb bbVar) {
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
