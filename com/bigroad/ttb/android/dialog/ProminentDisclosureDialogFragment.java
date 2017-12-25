package com.bigroad.ttb.android.dialog;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.C0202r;
import android.support.v4.app.DialogFragment;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;

public class ProminentDisclosureDialogFragment extends DialogFragment {
    public static final String f6267a = ProminentDisclosureDialogFragment.class.getName();
    private final C2474y f6268b = OurApplication.m6285g();

    public interface C1293a {
        void mo942a(boolean z);
    }

    class C18341 implements OnClickListener {
        final /* synthetic */ ProminentDisclosureDialogFragment f6265a;

        C18341(ProminentDisclosureDialogFragment prominentDisclosureDialogFragment) {
            this.f6265a = prominentDisclosureDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6265a.f6268b.m12208e(false);
            this.f6265a.m8899a(false);
        }
    }

    class C18352 implements OnClickListener {
        final /* synthetic */ ProminentDisclosureDialogFragment f6266a;

        C18352(ProminentDisclosureDialogFragment prominentDisclosureDialogFragment) {
            this.f6266a = prominentDisclosureDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f6266a.f6268b.m12208e(true);
            this.f6266a.m8899a(true);
        }
    }

    public void m8900a(C0202r c0202r) {
        show(c0202r, f6267a);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        m8899a(false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Builder(getActivity()).setIcon(R.drawable.ic_dialog_info_light).setTitle(R.string.prominentDisclosureDialog_title).setMessage(R.string.prominentDisclosureDialog_body).setPositiveButton(R.string.prominentDisclosureDialog_accept, new C18352(this)).setNegativeButton(R.string.prominentDisclosureDialog_reject, new C18341(this)).setCancelable(true).create();
    }

    private void m8899a(boolean z) {
        if (getTargetFragment() instanceof C1293a) {
            ((C1293a) getTargetFragment()).mo942a(z);
        } else if (getActivity() instanceof C1293a) {
            ((C1293a) getActivity()).mo942a(z);
        }
    }
}
