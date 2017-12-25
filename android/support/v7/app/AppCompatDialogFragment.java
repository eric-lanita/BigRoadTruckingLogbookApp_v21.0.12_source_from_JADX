package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle bundle) {
        return new C0585k(getActivity(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof C0585k) {
            C0585k c0585k = (C0585k) dialog;
            switch (i) {
                case 1:
                case 2:
                    break;
                case 3:
                    dialog.getWindow().addFlags(24);
                    break;
                default:
                    return;
            }
            c0585k.m2686c(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
