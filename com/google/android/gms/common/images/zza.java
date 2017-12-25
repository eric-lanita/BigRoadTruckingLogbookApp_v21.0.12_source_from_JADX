package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzrc;
import java.lang.ref.WeakReference;

public abstract class zza {
    final zza f10643a;
    protected int f10644b = 0;
    protected int f10645c = 0;
    protected boolean f10646d = false;
    private boolean f10647e = true;
    private boolean f10648f = false;
    private boolean f10649g = true;

    static final class zza {
        public final Uri uri;

        public zza(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            return !(obj instanceof zza) ? false : this == obj ? true : zzaa.equal(((zza) obj).uri, this.uri);
        }

        public int hashCode() {
            return zzaa.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> f10650e;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.f10650e = new WeakReference(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(imageView);
            this.f10650e = new WeakReference(imageView);
        }

        private void m16862a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof zzrb)) {
                int zzars = ((zzrb) imageView).zzars();
                if (this.c != 0 && zzars == this.c) {
                    return;
                }
            }
            boolean a = m16861a(z, z2);
            Drawable a2 = a ? m16856a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a2);
            if (imageView instanceof zzrb) {
                zzrb com_google_android_gms_internal_zzrb = (zzrb) imageView;
                com_google_android_gms_internal_zzrb.zzp(z3 ? this.a.uri : null);
                com_google_android_gms_internal_zzrb.zzga(obj != null ? this.c : 0);
            }
            if (a) {
                ((zzra) a2).startTransition(250);
            }
        }

        protected void mo1667a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.f10650e.get();
            if (imageView != null) {
                m16862a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.f10650e.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).f10650e.get();
            boolean z = (imageView2 == null || imageView == null || !zzaa.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class zzc extends zza {
        private WeakReference<OnImageLoadedListener> f10651e;

        public zzc(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzu(onImageLoadedListener);
            this.f10651e = new WeakReference(onImageLoadedListener);
        }

        protected void mo1667a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.f10651e.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.a.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_common_images_zza_zzc = (zzc) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.f10651e.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) com_google_android_gms_common_images_zza_zzc.f10651e.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && zzaa.equal(onImageLoadedListener2, onImageLoadedListener) && zzaa.equal(com_google_android_gms_common_images_zza_zzc.a, this.a);
            return z;
        }

        public int hashCode() {
            return zzaa.hashCode(this.a);
        }
    }

    public zza(Uri uri, int i) {
        this.f10643a = new zza(uri);
        this.f10645c = i;
    }

    private Drawable m16855a(Context context, zzrc com_google_android_gms_internal_zzrc, int i) {
        return context.getResources().getDrawable(i);
    }

    protected zzra m16856a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzra) {
            drawable = ((zzra) drawable).zzarq();
        }
        return new zzra(drawable, drawable2);
    }

    void m16857a(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzu(bitmap);
        mo1667a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    void m16858a(Context context, zzrc com_google_android_gms_internal_zzrc) {
        if (this.f10649g) {
            mo1667a(null, false, true, false);
        }
    }

    void m16859a(Context context, zzrc com_google_android_gms_internal_zzrc, boolean z) {
        Drawable drawable = null;
        if (this.f10645c != 0) {
            drawable = m16855a(context, com_google_android_gms_internal_zzrc, this.f10645c);
        }
        mo1667a(drawable, z, false, false);
    }

    protected abstract void mo1667a(Drawable drawable, boolean z, boolean z2, boolean z3);

    protected boolean m16861a(boolean z, boolean z2) {
        return (!this.f10647e || z2 || z) ? false : true;
    }

    public void zzfy(int i) {
        this.f10645c = i;
    }
}
