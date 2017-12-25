package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.R;

public class AsyncTaskDialogFragment extends DialogFragment {
    private String f6175a;
    private String f6176b;
    private boolean f6177c;
    private C1830c f6178d;
    private boolean f6179e;
    private C1292a f6180f;

    public interface C1292a {
        void mo939c(C1830c c1830c);
    }

    public static AsyncTaskDialogFragment m8825a(C1830c c1830c, String str, String str2, boolean z) {
        AsyncTaskDialogFragment asyncTaskDialogFragment = new AsyncTaskDialogFragment();
        asyncTaskDialogFragment.f6178d = c1830c;
        asyncTaskDialogFragment.f6178d.m8885a(asyncTaskDialogFragment);
        asyncTaskDialogFragment.f6175a = str;
        asyncTaskDialogFragment.f6176b = str2;
        asyncTaskDialogFragment.f6177c = z;
        asyncTaskDialogFragment.f6179e = false;
        return asyncTaskDialogFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C1292a) {
            this.f6180f = (C1292a) activity;
            return;
        }
        throw new IllegalStateException("Activity must implement FinishedCallback.");
    }

    public void onDetach() {
        super.onDetach();
        this.f6180f = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        if (this.f6178d != null) {
            this.f6178d.execute(new Void[0]);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog b = new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2668a(this.f6175a).m2675b(this.f6176b).m2677b();
        if (this.f6177c) {
            setCancelable(true);
            b.m2691a(-2, getString(17039360), C1843a.f6286a);
        } else {
            setCancelable(false);
        }
        b.setCanceledOnTouchOutside(false);
        return b;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f6178d != null) {
            this.f6178d.cancel(false);
            this.f6178d.m8884a(0);
            if (this.f6180f != null) {
                this.f6180f.mo939c(this.f6178d);
            }
        }
        this.f6180f = null;
    }

    public void onResume() {
        super.onResume();
        if (this.f6179e) {
            dismiss();
        }
    }

    public void m8826a() {
        if (isResumed()) {
            dismiss();
        }
        this.f6179e = true;
        if (this.f6180f != null) {
            if (this.f6178d.m8888c()) {
                this.f6178d.m8884a(0);
            } else {
                this.f6178d.m8884a(-1);
            }
            this.f6180f.mo939c(this.f6178d);
            this.f6180f = null;
        }
    }
}
