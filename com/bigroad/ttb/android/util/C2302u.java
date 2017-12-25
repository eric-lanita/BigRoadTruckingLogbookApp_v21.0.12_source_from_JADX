package com.bigroad.ttb.android.util;

import android.content.Context;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.bigroad.ttb.android.logging.C2134e;

public class C2302u {
    private final Handler f7944a = new Handler();
    private final InputMethodManager f7945b;

    public C2302u(Context context) {
        this.f7945b = (InputMethodManager) context.getSystemService("input_method");
    }

    public void m11254a(final TextView textView) {
        if (textView != null) {
            textView.requestFocus();
            if (this.f7945b != null) {
                this.f7944a.post(new Runnable(this) {
                    final /* synthetic */ C2302u f7942b;
                    private int f7943c = 0;

                    public void run() {
                        if (!this.f7942b.f7945b.showSoftInput(textView, 0)) {
                            if (this.f7943c >= 30) {
                                C2134e.m10676b("TT-SoftKeyboard", "Could not open soft keyboard; giving up");
                                return;
                            }
                            this.f7943c++;
                            C2134e.m10676b("TT-SoftKeyboard", "showSoftInput failed, retrying");
                            this.f7942b.f7944a.postDelayed(this, 100);
                        }
                    }
                });
            }
        }
    }

    public void m11256b(TextView textView) {
        if (this.f7945b != null && textView != null && !this.f7945b.hideSoftInputFromWindow(textView.getWindowToken(), 0)) {
            C2134e.m10680d("TT-SoftKeyboard", "hideSoftInputFromWindow() failed");
        }
    }

    public boolean m11255a() {
        return this.f7945b.isFullscreenMode();
    }
}
