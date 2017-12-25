package com.bigroad.ttb.android.dialog;

import android.support.v4.app.C0202r;
import android.support.v4.app.DialogFragment;

public class C1844b {
    public static void m8915a(DialogFragment dialogFragment, C0202r c0202r) {
        C1844b.m8916a(dialogFragment.getClass(), c0202r);
        dialogFragment.show(c0202r, dialogFragment.getClass().getName());
    }

    public static void m8916a(Class<? extends DialogFragment> cls, C0202r c0202r) {
        DialogFragment dialogFragment = (DialogFragment) c0202r.mo149a(cls.getName());
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }
}
