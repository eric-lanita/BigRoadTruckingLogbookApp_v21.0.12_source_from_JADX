package com.google.android.gms.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzpk extends zzpn {
    private final SparseArray<zza> f11467e = new SparseArray();

    private class zza implements OnConnectionFailedListener {
        final /* synthetic */ zzpk f11459a;
        public final int sD;
        public final GoogleApiClient sE;
        public final OnConnectionFailedListener sF;

        public zza(zzpk com_google_android_gms_internal_zzpk, int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.f11459a = com_google_android_gms_internal_zzpk;
            this.sD = i;
            this.sE = googleApiClient;
            this.sF = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.sD);
            printWriter.println(":");
            this.sE.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            this.f11459a.zzb(connectionResult, this.sD);
        }

        public void zzaop() {
            this.sE.unregisterConnectionFailedListener(this);
            this.sE.disconnect();
        }
    }

    private zzpk(zzqk com_google_android_gms_internal_zzqk) {
        super(com_google_android_gms_internal_zzqk);
        this.d.zza("AutoManageHelper", (zzqj) this);
    }

    public static zzpk zza(zzqi com_google_android_gms_internal_zzqi) {
        zzqk a = zzqj.m17360a(com_google_android_gms_internal_zzqi);
        zzpk com_google_android_gms_internal_zzpk = (zzpk) a.zza("AutoManageHelper", zzpk.class);
        return com_google_android_gms_internal_zzpk != null ? com_google_android_gms_internal_zzpk : new zzpk(a);
    }

    protected void mo1889a() {
        for (int i = 0; i < this.f11467e.size(); i++) {
            ((zza) this.f11467e.valueAt(i)).sE.connect();
        }
    }

    protected void mo1890a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza com_google_android_gms_internal_zzpk_zza = (zza) this.f11467e.get(i);
        if (com_google_android_gms_internal_zzpk_zza != null) {
            zzfh(i);
            OnConnectionFailedListener onConnectionFailedListener = com_google_android_gms_internal_zzpk_zza.sF;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f11467e.size(); i++) {
            ((zza) this.f11467e.valueAt(i)).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void onStart() {
        super.onStart();
        boolean z = this.a;
        String valueOf = String.valueOf(this.f11467e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.b) {
            for (int i = 0; i < this.f11467e.size(); i++) {
                ((zza) this.f11467e.valueAt(i)).sE.connect();
            }
        }
    }

    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.f11467e.size(); i++) {
            ((zza) this.f11467e.valueAt(i)).sE.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzab.zzb((Object) googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzab.zza(this.f11467e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.a + " " + this.b);
        this.f11467e.put(i, new zza(this, i, googleApiClient, onConnectionFailedListener));
        if (this.a && !this.b) {
            String valueOf = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            googleApiClient.connect();
        }
    }

    public void zzfh(int i) {
        zza com_google_android_gms_internal_zzpk_zza = (zza) this.f11467e.get(i);
        this.f11467e.remove(i);
        if (com_google_android_gms_internal_zzpk_zza != null) {
            com_google_android_gms_internal_zzpk_zza.zzaop();
        }
    }
}
