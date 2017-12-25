package com.bigroad.ttb.android.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import com.bigroad.ttb.android.R;

public class C1845d extends ProgressDialog {
    public C1845d(Context context, int i) {
        super(context);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setIndeterminate(true);
        setMessage(context.getText(i));
        setButton(-2, context.getResources().getString(17039360), C1843a.f6286a);
    }

    public C1845d(Context context) {
        this(context, R.string.signingInDialog_signingIn);
    }
}
