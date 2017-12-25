package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.C0202r;
import android.support.v4.app.DialogFragment;
import com.google.android.gms.common.internal.zzab;

public class SupportErrorDialogFragment extends DialogFragment {
    private Dialog f10495a = null;
    private OnCancelListener f10496b = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) zzab.zzb((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.f10495a = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.f10496b = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f10496b != null) {
            this.f10496b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f10495a == null) {
            setShowsDialog(false);
        }
        return this.f10495a;
    }

    public void show(C0202r c0202r, String str) {
        super.show(c0202r, str);
    }
}
