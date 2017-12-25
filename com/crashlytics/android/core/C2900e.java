package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import io.fabric.sdk.android.services.settings.C4067o;
import java.util.concurrent.CountDownLatch;

class C2900e {
    private final C2899b f9988a;
    private final Builder f9989b;

    interface C2898a {
        void mo1470a(boolean z);
    }

    private static class C2899b {
        private boolean f9986a;
        private final CountDownLatch f9987b;

        private C2899b() {
            this.f9986a = false;
            this.f9987b = new CountDownLatch(1);
        }

        void m16264a(boolean z) {
            this.f9986a = z;
            this.f9987b.countDown();
        }

        boolean m16265a() {
            return this.f9986a;
        }

        void m16266b() {
            try {
                this.f9987b.await();
            } catch (InterruptedException e) {
            }
        }
    }

    public static C2900e m16269a(Activity activity, C4067o c4067o, final C2898a c2898a) {
        final C2899b c2899b = new C2899b();
        C2950q c2950q = new C2950q(activity, c4067o);
        Builder builder = new Builder(activity);
        View a = C2900e.m16268a(activity, c2950q.m16436b());
        builder.setView(a).setTitle(c2950q.m16435a()).setCancelable(false).setNeutralButton(c2950q.m16437c(), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                c2899b.m16264a(true);
                dialogInterface.dismiss();
            }
        });
        if (c4067o.f14319d) {
            builder.setNegativeButton(c2950q.m16439e(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    c2899b.m16264a(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (c4067o.f14321f) {
            builder.setPositiveButton(c2950q.m16438d(), new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    c2898a.mo1470a(true);
                    c2899b.m16264a(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new C2900e(builder, c2899b);
    }

    private static ScrollView m16268a(Activity activity, String str) {
        float f = activity.getResources().getDisplayMetrics().density;
        int a = C2900e.m16267a(f, 5);
        View textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, 16973892);
        textView.setPadding(a, a, a, a);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(C2900e.m16267a(f, 14), C2900e.m16267a(f, 2), C2900e.m16267a(f, 10), C2900e.m16267a(f, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private static int m16267a(float f, int i) {
        return (int) (((float) i) * f);
    }

    private C2900e(Builder builder, C2899b c2899b) {
        this.f9988a = c2899b;
        this.f9989b = builder;
    }

    public void m16270a() {
        this.f9989b.show();
    }

    public void m16271b() {
        this.f9988a.m16266b();
    }

    public boolean m16272c() {
        return this.f9988a.m16265a();
    }
}
