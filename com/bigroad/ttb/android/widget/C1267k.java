package com.bigroad.ttb.android.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bigroad.ttb.android.logging.C2134e;

public abstract class C1267k implements OnEditorActionListener {
    public abstract boolean mo929a(TextView textView);

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        C2134e.m10676b("TT-EOEEActionListener", "actionId=" + i + "; event=" + keyEvent);
        if (i == 0 && keyEvent != null && keyEvent.getAction() == 0) {
            return true;
        }
        return mo929a(textView);
    }
}
