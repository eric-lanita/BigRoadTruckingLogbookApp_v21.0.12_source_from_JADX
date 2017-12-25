package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.internal.zzqk;

public abstract class zzi implements OnClickListener {

    class C32241 extends zzi {
        final /* synthetic */ Intent f10755a;
        final /* synthetic */ Activity f10756b;
        final /* synthetic */ int f10757c;

        C32241(Intent intent, Activity activity, int i) {
            this.f10755a = intent;
            this.f10756b = activity;
            this.f10757c = i;
        }

        public void zzasr() {
            if (this.f10755a != null) {
                this.f10756b.startActivityForResult(this.f10755a, this.f10757c);
            }
        }
    }

    class C32252 extends zzi {
        final /* synthetic */ Intent f10758a;
        final /* synthetic */ Fragment f10759b;
        final /* synthetic */ int f10760c;

        C32252(Intent intent, Fragment fragment, int i) {
            this.f10758a = intent;
            this.f10759b = fragment;
            this.f10760c = i;
        }

        public void zzasr() {
            if (this.f10758a != null) {
                this.f10759b.startActivityForResult(this.f10758a, this.f10760c);
            }
        }
    }

    class C32263 extends zzi {
        final /* synthetic */ Intent f10761a;
        final /* synthetic */ zzqk f10762b;
        final /* synthetic */ int f10763c;

        C32263(Intent intent, zzqk com_google_android_gms_internal_zzqk, int i) {
            this.f10761a = intent;
            this.f10762b = com_google_android_gms_internal_zzqk;
            this.f10763c = i;
        }

        @TargetApi(11)
        public void zzasr() {
            if (this.f10761a != null) {
                this.f10762b.startActivityForResult(this.f10761a, this.f10763c);
            }
        }
    }

    public static zzi zza(Activity activity, Intent intent, int i) {
        return new C32241(intent, activity, i);
    }

    public static zzi zza(Fragment fragment, Intent intent, int i) {
        return new C32252(intent, fragment, i);
    }

    public static zzi zza(zzqk com_google_android_gms_internal_zzqk, Intent intent, int i) {
        return new C32263(intent, com_google_android_gms_internal_zzqk, i);
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            zzasr();
            dialogInterface.dismiss();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services", e);
        }
    }

    public abstract void zzasr();
}
