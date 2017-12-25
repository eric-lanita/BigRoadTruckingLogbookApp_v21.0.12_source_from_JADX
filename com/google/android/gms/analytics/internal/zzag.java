package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzab;

class zzag extends BroadcastReceiver {
    static final String f10245a = zzag.class.getName();
    private final zzf f10246b;
    private boolean f10247c;
    private boolean f10248d;

    zzag(zzf com_google_android_gms_analytics_internal_zzf) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzf);
        this.f10246b = com_google_android_gms_analytics_internal_zzf;
    }

    private void m16596b() {
        m16598d();
        m16599e();
    }

    private Context m16597c() {
        return this.f10246b.getContext();
    }

    private zzaf m16598d() {
        return this.f10246b.zzyx();
    }

    private zzb m16599e() {
        return this.f10246b.zzwd();
    }

    protected boolean m16600a() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) m16597c().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public boolean isConnected() {
        if (!this.f10247c) {
            this.f10246b.zzyx().zzek("Connectivity unknown. Receiver not registered");
        }
        return this.f10248d;
    }

    public boolean isRegistered() {
        return this.f10247c;
    }

    public void onReceive(Context context, Intent intent) {
        m16596b();
        String action = intent.getAction();
        this.f10246b.zzyx().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean a = m16600a();
            if (this.f10248d != a) {
                this.f10248d = a;
                m16599e().zzas(a);
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f10246b.zzyx().zzd("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(f10245a)) {
            m16599e().zzys();
        }
    }

    public void unregister() {
        if (isRegistered()) {
            this.f10246b.zzyx().zzeh("Unregistering connectivity change receiver");
            this.f10247c = false;
            this.f10248d = false;
            try {
                m16597c().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                m16598d().zze("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void zzadg() {
        m16596b();
        if (!this.f10247c) {
            Context c = m16597c();
            c.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(c.getPackageName());
            c.registerReceiver(this, intentFilter);
            this.f10248d = m16600a();
            this.f10246b.zzyx().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f10248d));
            this.f10247c = true;
        }
    }

    public void zzadi() {
        if (VERSION.SDK_INT > 10) {
            Context c = m16597c();
            Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
            intent.addCategory(c.getPackageName());
            intent.putExtra(f10245a, true);
            c.sendOrderedBroadcast(intent, null);
        }
    }
}
