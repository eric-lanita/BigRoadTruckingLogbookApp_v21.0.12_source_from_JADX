package com.bigroad.ttb.android.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.C0586c.C0584a;
import com.bigroad.ttb.android.C1263c;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.ac;
import com.bigroad.ttb.android.ac.C1240a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.C1767f;
import com.bigroad.ttb.protocol.TTProtocol.RequestType;
import com.bigroad.ttb.protocol.TTProtocol.RequestUnion.C2742a;
import com.bigroad.ttb.protocol.TTProtocol.Response;
import com.bigroad.ttb.protocol.TTProtocol.ResponseStatus;
import com.bigroad.ttb.protocol.TTProtocol.ResponseUnion;

public class AsyncApiRequestDialogFragment extends DialogFragment implements C1240a {
    private String f6164a;
    private String f6165b;
    private boolean f6166c;
    private RequestType f6167d;
    private C2742a f6168e;
    private boolean f6169f;
    private C1398a f6170g;
    private Handler f6171h;
    private ac f6172i;
    private int f6173j;
    private final Runnable f6174k = new C17931(this);

    public interface C1398a {
        void mo984a(FinishedResponse finishedResponse);
    }

    class C17931 implements Runnable {
        final /* synthetic */ AsyncApiRequestDialogFragment f6153a;

        C17931(AsyncApiRequestDialogFragment asyncApiRequestDialogFragment) {
            this.f6153a = asyncApiRequestDialogFragment;
        }

        public void run() {
            this.f6153a.m8823a(true);
        }
    }

    public static class FinishedResponse {
        public Status f6161a;
        public ResponseStatus f6162b;
        public ResponseUnion f6163c;

        public enum Status {
            SUCCESS,
            ERROR,
            CANCELED,
            AUTHENTICATION_FAILURE,
            TRANSPORT_FAILURE
        }

        public FinishedResponse(Status status) {
            this.f6161a = status;
            this.f6162b = null;
            this.f6163c = null;
        }

        public FinishedResponse(Status status, ResponseStatus responseStatus, ResponseUnion responseUnion) {
            this.f6161a = status;
            this.f6162b = responseStatus;
            this.f6163c = responseUnion;
        }
    }

    public static AsyncApiRequestDialogFragment m8819a(RequestType requestType, C2742a c2742a, String str, String str2, boolean z) {
        C1240a asyncApiRequestDialogFragment = new AsyncApiRequestDialogFragment();
        asyncApiRequestDialogFragment.f6171h = new Handler();
        asyncApiRequestDialogFragment.f6172i = new ac();
        asyncApiRequestDialogFragment.f6172i.m6663a(asyncApiRequestDialogFragment);
        asyncApiRequestDialogFragment.f6167d = requestType;
        asyncApiRequestDialogFragment.f6168e = c2742a;
        asyncApiRequestDialogFragment.f6164a = str;
        asyncApiRequestDialogFragment.f6165b = str2;
        asyncApiRequestDialogFragment.f6166c = z;
        asyncApiRequestDialogFragment.f6169f = false;
        return asyncApiRequestDialogFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C1398a) {
            this.f6170g = (C1398a) activity;
            return;
        }
        throw new IllegalStateException("Activity must implement FinishedCallback.");
    }

    public void onDetach() {
        super.onDetach();
        this.f6170g = null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        m8823a(false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog b = new C0584a(getActivity()).m2678c(R.drawable.ic_dialog_info_light).m2668a(this.f6164a).m2675b(this.f6165b).m2677b();
        if (this.f6166c) {
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
        m8820a();
        if (this.f6170g != null) {
            this.f6170g.mo984a(new FinishedResponse(Status.CANCELED));
        }
        this.f6170g = null;
    }

    public void onResume() {
        super.onResume();
        if (this.f6169f) {
            dismiss();
        }
    }

    private void m8821a(FinishedResponse finishedResponse) {
        if (isResumed()) {
            dismiss();
        }
        this.f6169f = true;
        if (this.f6170g != null) {
            this.f6170g.mo984a(finishedResponse);
            this.f6170g = null;
        }
    }

    private void m8823a(boolean z) {
        if (this.f6172i != null) {
            m8820a();
            if (z) {
                this.f6173j++;
            } else {
                this.f6173j = 1;
            }
            this.f6172i.m6664a(new C1767f(SyncManager.m6378a(this.f6167d, this.f6168e).toByteArray()));
        }
    }

    private void m8820a() {
        if (this.f6172i != null) {
            this.f6172i.m6667b();
            this.f6171h.removeCallbacks(this.f6174k);
        }
    }

    public void mo909a(C1263c c1263c) {
        ResponseStatus b = c1263c.m6655b();
        Response c = c1263c.m6656c();
        if (c != null && c.getResponseCount() == 1 && c.getResponse(0).getRequestType() == this.f6167d) {
            ResponseUnion response = c.getResponse(0);
            switch (b) {
                case RS_REQUEST_CANCELLED:
                    return;
                case RS_SUCCESS:
                    m8821a(new FinishedResponse(Status.SUCCESS, b, response));
                    return;
                case RS_DUPLICATE_REQUEST_IGNORED:
                case RS_NOT_AUTHORIZED:
                case RS_INVALID_REQUEST:
                case RS_ERROR_SENDING_ERODS_TO_FMCSA:
                    m8821a(new FinishedResponse(Status.ERROR, b, response));
                    return;
                case RS_LOGIN_NOT_FOUND:
                case RS_INCORRECT_PASSWORD:
                case RS_AUTHENTICATION_REQUIRED:
                    C2134e.m10680d("TT-AsyncApiRequestDF", "Request failed - authentication required; aborting");
                    m8821a(new FinishedResponse(Status.AUTHENTICATION_FAILURE, b, null));
                    return;
                default:
                    C2134e.m10678c("TT-AsyncApiRequestDF", "Request failed with status " + b + "; retrying");
                    if (this.f6173j >= 5) {
                        m8821a(new FinishedResponse(Status.TRANSPORT_FAILURE, b, null));
                        return;
                    } else {
                        this.f6171h.postDelayed(this.f6174k, 5000);
                        return;
                    }
            }
        }
        C2134e.m10682e("TT-AsyncApiRequestDF", "Response did not contain proper type for request");
        m8821a(new FinishedResponse(Status.ERROR, b, null));
    }
}
