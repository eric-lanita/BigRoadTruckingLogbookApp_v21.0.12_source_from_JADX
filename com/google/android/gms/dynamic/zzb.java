package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

@SuppressLint({"NewApi"})
public final class zzb extends zza {
    private Fragment f10947a;

    private zzb(Fragment fragment) {
        this.f10947a = fragment;
    }

    public static zzb zza(Fragment fragment) {
        return fragment != null ? new zzb(fragment) : null;
    }

    public Bundle getArguments() {
        return this.f10947a.getArguments();
    }

    public int getId() {
        return this.f10947a.getId();
    }

    public boolean getRetainInstance() {
        return this.f10947a.getRetainInstance();
    }

    public String getTag() {
        return this.f10947a.getTag();
    }

    public int getTargetRequestCode() {
        return this.f10947a.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f10947a.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzac(this.f10947a.getView());
    }

    public boolean isAdded() {
        return this.f10947a.isAdded();
    }

    public boolean isDetached() {
        return this.f10947a.isDetached();
    }

    public boolean isHidden() {
        return this.f10947a.isHidden();
    }

    public boolean isInLayout() {
        return this.f10947a.isInLayout();
    }

    public boolean isRemoving() {
        return this.f10947a.isRemoving();
    }

    public boolean isResumed() {
        return this.f10947a.isResumed();
    }

    public boolean isVisible() {
        return this.f10947a.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f10947a.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f10947a.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f10947a.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f10947a.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f10947a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f10947a.startActivityForResult(intent, i);
    }

    public void zzab(zzd com_google_android_gms_dynamic_zzd) {
        this.f10947a.registerForContextMenu((View) zze.zzad(com_google_android_gms_dynamic_zzd));
    }

    public void zzac(zzd com_google_android_gms_dynamic_zzd) {
        this.f10947a.unregisterForContextMenu((View) zze.zzad(com_google_android_gms_dynamic_zzd));
    }

    public zzd zzbbu() {
        return zze.zzac(this.f10947a.getActivity());
    }

    public zzc zzbbv() {
        return zza(this.f10947a.getParentFragment());
    }

    public zzd zzbbw() {
        return zze.zzac(this.f10947a.getResources());
    }

    public zzc zzbbx() {
        return zza(this.f10947a.getTargetFragment());
    }
}
