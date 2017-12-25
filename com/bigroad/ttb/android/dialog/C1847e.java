package com.bigroad.ttb.android.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.C0586c;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.widget.C2468r;
import com.bigroad.ttb.android.widget.C2468r.C1303a;

public class C1847e extends C0586c {
    private C2468r f6288a;
    private C1537a f6289b;

    public interface C1537a {
        void mo1012a(DialogInterface dialogInterface);
    }

    class C18461 implements C1303a {
        final /* synthetic */ C1847e f6287a;

        C18461(C1847e c1847e) {
            this.f6287a = c1847e;
        }

        public void mo947a() {
            if (this.f6287a.f6289b != null) {
                this.f6287a.f6289b.mo1012a(this.f6287a);
            }
        }
    }

    public C1847e(Context context) {
        super(context);
    }

    protected void onCreate(Bundle bundle) {
        ProgressBar progressBar = (ProgressBar) LayoutInflater.from(getContext()).inflate(R.layout.timed_progress_bar, null);
        this.f6288a = new C2468r(progressBar);
        this.f6288a.m12130a(new C18461(this));
        m2692a((View) progressBar);
        super.onCreate(bundle);
    }

    protected void onStart() {
        super.onStart();
        this.f6288a.m12132c();
    }

    protected void onStop() {
        this.f6288a.m12131b();
        super.onStop();
    }

    public void m8919a(C1537a c1537a) {
        this.f6289b = c1537a;
    }
}
