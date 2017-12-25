package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc.zza;

public final class zzh extends zza {
    private Fragment f10951a;

    private zzh(Fragment fragment) {
        this.f10951a = fragment;
    }

    public static zzh zza(Fragment fragment) {
        return fragment != null ? new zzh(fragment) : null;
    }

    public Bundle getArguments() {
        return this.f10951a.getArguments();
    }

    public int getId() {
        return this.f10951a.getId();
    }

    public boolean getRetainInstance() {
        return this.f10951a.getRetainInstance();
    }

    public String getTag() {
        return this.f10951a.getTag();
    }

    public int getTargetRequestCode() {
        return this.f10951a.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f10951a.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzac(this.f10951a.getView());
    }

    public boolean isAdded() {
        return this.f10951a.isAdded();
    }

    public boolean isDetached() {
        return this.f10951a.isDetached();
    }

    public boolean isHidden() {
        return this.f10951a.isHidden();
    }

    public boolean isInLayout() {
        return this.f10951a.isInLayout();
    }

    public boolean isRemoving() {
        return this.f10951a.isRemoving();
    }

    public boolean isResumed() {
        return this.f10951a.isResumed();
    }

    public boolean isVisible() {
        return this.f10951a.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f10951a.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f10951a.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f10951a.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f10951a.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f10951a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f10951a.startActivityForResult(intent, i);
    }

    public void zzab(zzd com_google_android_gms_dynamic_zzd) {
        this.f10951a.registerForContextMenu((View) zze.zzad(com_google_android_gms_dynamic_zzd));
    }

    public void zzac(zzd com_google_android_gms_dynamic_zzd) {
        this.f10951a.unregisterForContextMenu((View) zze.zzad(com_google_android_gms_dynamic_zzd));
    }

    public zzd zzbbu() {
        return zze.zzac(this.f10951a.getActivity());
    }

    public zzc zzbbv() {
        return zza(this.f10951a.getParentFragment());
    }

    public zzd zzbbw() {
        return zze.zzac(this.f10951a.getResources());
    }

    public zzc zzbbx() {
        return zza(this.f10951a.getTargetFragment());
    }
}
