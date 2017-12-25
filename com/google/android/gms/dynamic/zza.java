package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.zze;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T f10943a;
    private Bundle f10944b;
    private LinkedList<zza> f10945c;
    private final zzf<T> f10946d = new C32311(this);

    class C32311 implements zzf<T> {
        final /* synthetic */ zza f10927a;

        C32311(zza com_google_android_gms_dynamic_zza) {
            this.f10927a = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.f10927a.f10943a = t;
            Iterator it = this.f10927a.f10945c.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.f10927a.f10943a);
            }
            this.f10927a.f10945c.clear();
            this.f10927a.f10944b = null;
        }
    }

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    class C32355 implements OnClickListener {
        final /* synthetic */ Context f10939a;
        final /* synthetic */ int f10940b;

        C32355(Context context, int i) {
            this.f10939a = context;
            this.f10940b = i;
        }

        public void onClick(View view) {
            this.f10939a.startActivity(GooglePlayServicesUtil.zzfd(this.f10940b));
        }
    }

    class C32366 implements zza {
        final /* synthetic */ zza f10941a;

        C32366(zza com_google_android_gms_dynamic_zza) {
            this.f10941a = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.f10941a.f10943a.onStart();
        }
    }

    class C32377 implements zza {
        final /* synthetic */ zza f10942a;

        C32377(zza com_google_android_gms_dynamic_zza) {
            this.f10942a = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.f10942a.f10943a.onResume();
        }
    }

    private void m17033a(int i) {
        while (!this.f10945c.isEmpty() && ((zza) this.f10945c.getLast()).getState() >= i) {
            this.f10945c.removeLast();
        }
    }

    private void m17034a(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.f10943a != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.f10943a);
            return;
        }
        if (this.f10945c == null) {
            this.f10945c = new LinkedList();
        }
        this.f10945c.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.f10944b == null) {
                this.f10944b = (Bundle) bundle.clone();
            } else {
                this.f10944b.putAll(bundle);
            }
        }
        mo2038a(this.f10946d);
    }

    public static void zzb(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zzc = zzh.zzc(context, isGooglePlayServicesAvailable, zze.zzbv(context));
        CharSequence zzh = zzh.zzh(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzc);
        linearLayout.addView(textView);
        if (zzh != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new C32355(context, isGooglePlayServicesAvailable));
        }
    }

    protected void m17036a(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void mo2038a(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public void onCreate(final Bundle bundle) {
        m17034a(bundle, new zza(this) {
            final /* synthetic */ zza f10933b;

            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.f10933b.f10943a.onCreate(bundle);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        m17034a(bundle, new zza(this) {
            final /* synthetic */ zza f10938e;

            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.f10938e.f10943a.onCreateView(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.f10943a == null) {
            m17036a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f10943a != null) {
            this.f10943a.onDestroy();
        } else {
            m17033a(1);
        }
    }

    public void onDestroyView() {
        if (this.f10943a != null) {
            this.f10943a.onDestroyView();
        } else {
            m17033a(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        m17034a(bundle2, new zza(this) {
            final /* synthetic */ zza f10931d;

            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                this.f10931d.f10943a.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        if (this.f10943a != null) {
            this.f10943a.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f10943a != null) {
            this.f10943a.onPause();
        } else {
            m17033a(5);
        }
    }

    public void onResume() {
        m17034a(null, new C32377(this));
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f10943a != null) {
            this.f10943a.onSaveInstanceState(bundle);
        } else if (this.f10944b != null) {
            bundle.putAll(this.f10944b);
        }
    }

    public void onStart() {
        m17034a(null, new C32366(this));
    }

    public void onStop() {
        if (this.f10943a != null) {
            this.f10943a.onStop();
        } else {
            m17033a(4);
        }
    }

    public T zzbbt() {
        return this.f10943a;
    }
}
