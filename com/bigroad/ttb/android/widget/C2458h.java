package com.bigroad.ttb.android.widget;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

public class C2458h extends C2457g implements TextWatcher {
    public C2458h(Handler handler, Runnable runnable) {
        super(handler, runnable, 500);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        m12102b();
    }
}
