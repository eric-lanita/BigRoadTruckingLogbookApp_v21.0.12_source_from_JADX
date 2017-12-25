package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

public abstract class zzpn extends zzqj implements OnCancelListener {
    protected boolean f11461a;
    protected boolean f11462b;
    protected final GoogleApiAvailability f11463c;
    private ConnectionResult f11464e;
    private int f11465f;
    private final Handler f11466g;

    private class zza implements Runnable {
        final /* synthetic */ zzpn f11475a;

        private zza(zzpn com_google_android_gms_internal_zzpn) {
            this.f11475a = com_google_android_gms_internal_zzpn;
        }

        public void run() {
            if (!this.f11475a.f11461a) {
                return;
            }
            if (this.f11475a.f11464e.hasResolution()) {
                this.f11475a.d.startActivityForResult(GoogleApiActivity.zzb(this.f11475a.getActivity(), this.f11475a.f11464e.getResolution(), this.f11475a.f11465f, false), 1);
            } else if (this.f11475a.f11463c.isUserResolvableError(this.f11475a.f11464e.getErrorCode())) {
                this.f11475a.f11463c.zza(this.f11475a.getActivity(), this.f11475a.d, this.f11475a.f11464e.getErrorCode(), 2, this.f11475a);
            } else if (this.f11475a.f11464e.getErrorCode() == 18) {
                final Dialog zza = this.f11475a.f11463c.zza(this.f11475a.getActivity(), this.f11475a);
                this.f11475a.f11463c.zza(this.f11475a.getActivity().getApplicationContext(), new com.google.android.gms.internal.zzqe.zza(this) {
                    final /* synthetic */ zza f11474b;

                    public void zzaou() {
                        this.f11474b.f11475a.m17365b();
                        if (zza.isShowing()) {
                            zza.dismiss();
                        }
                    }
                });
            } else {
                this.f11475a.mo1890a(this.f11475a.f11464e, this.f11475a.f11465f);
            }
        }
    }

    protected zzpn(zzqk com_google_android_gms_internal_zzqk) {
        this(com_google_android_gms_internal_zzqk, GoogleApiAvailability.getInstance());
    }

    zzpn(zzqk com_google_android_gms_internal_zzqk, GoogleApiAvailability googleApiAvailability) {
        super(com_google_android_gms_internal_zzqk);
        this.f11465f = -1;
        this.f11466g = new Handler(Looper.getMainLooper());
        this.f11463c = googleApiAvailability;
    }

    protected abstract void mo1889a();

    protected abstract void mo1890a(ConnectionResult connectionResult, int i);

    protected void m17365b() {
        this.f11465f = -1;
        this.f11462b = false;
        this.f11464e = null;
        mo1889a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
        r5 = this;
        r4 = 18;
        r2 = 13;
        r0 = 1;
        r1 = 0;
        switch(r6) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0010;
            default: goto L_0x0009;
        };
    L_0x0009:
        r0 = r1;
    L_0x000a:
        if (r0 == 0) goto L_0x003d;
    L_0x000c:
        r5.m17365b();
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.f11463c;
        r3 = r5.getActivity();
        r2 = r2.isGooglePlayServicesAvailable(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x001c:
        r1 = r5.f11464e;
        r1 = r1.getErrorCode();
        if (r1 != r4) goto L_0x000a;
    L_0x0024:
        if (r2 != r4) goto L_0x000a;
    L_0x0026:
        goto L_0x000f;
    L_0x0027:
        r3 = -1;
        if (r7 == r3) goto L_0x000a;
    L_0x002a:
        if (r7 != 0) goto L_0x0009;
    L_0x002c:
        if (r8 == 0) goto L_0x0045;
    L_0x002e:
        r0 = "<<ResolutionFailureErrorDetail>>";
        r0 = r8.getIntExtra(r0, r2);
    L_0x0034:
        r2 = new com.google.android.gms.common.ConnectionResult;
        r3 = 0;
        r2.<init>(r0, r3);
        r5.f11464e = r2;
        goto L_0x0009;
    L_0x003d:
        r0 = r5.f11464e;
        r1 = r5.f11465f;
        r5.mo1890a(r0, r1);
        goto L_0x000f;
    L_0x0045:
        r0 = r2;
        goto L_0x0034;
    L_0x0047:
        r0 = r1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpn.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        mo1890a(new ConnectionResult(13, null), this.f11465f);
        m17365b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f11462b = bundle.getBoolean("resolving_error", false);
            if (this.f11462b) {
                this.f11465f = bundle.getInt("failed_client_id", -1);
                this.f11464e = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f11462b);
        if (this.f11462b) {
            bundle.putInt("failed_client_id", this.f11465f);
            bundle.putInt("failed_status", this.f11464e.getErrorCode());
            bundle.putParcelable("failed_resolution", this.f11464e.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.f11461a = true;
    }

    public void onStop() {
        super.onStop();
        this.f11461a = false;
    }

    public void zzb(ConnectionResult connectionResult, int i) {
        if (!this.f11462b) {
            this.f11462b = true;
            this.f11465f = i;
            this.f11464e = connectionResult;
            this.f11466g.post(new zza());
        }
    }
}
