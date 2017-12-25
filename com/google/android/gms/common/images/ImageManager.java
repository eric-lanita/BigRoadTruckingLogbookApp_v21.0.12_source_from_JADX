package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.p008d.C0275f;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzrc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object f10625a = new Object();
    private static HashSet<Uri> f10626b = new HashSet();
    private static ImageManager f10627c;
    private static ImageManager f10628d;
    private final Context f10629e;
    private final Handler f10630f = new Handler(Looper.getMainLooper());
    private final ExecutorService f10631g = Executors.newFixedThreadPool(4);
    private final zzb f10632h;
    private final zzrc f10633i;
    private final Map<zza, ImageReceiver> f10634j;
    private final Map<Uri, ImageReceiver> f10635k;
    private final Map<Uri, Long> f10636l;

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        final /* synthetic */ ImageManager f10611a;
        private final Uri f10612b;
        private final ArrayList<zza> f10613c = new ArrayList();

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.f10611a = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.f10612b = uri;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            this.f10611a.f10631g.execute(new zzc(this.f10611a, this.f10612b, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzarp() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.f10612b);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.f10611a.f10629e.sendBroadcast(intent);
        }

        public void zzb(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzhi("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f10613c.add(com_google_android_gms_common_images_zza);
        }

        public void zzc(zza com_google_android_gms_common_images_zza) {
            com.google.android.gms.common.internal.zzb.zzhi("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f10613c.remove(com_google_android_gms_common_images_zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int m16832a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends C0275f<zza, Bitmap> {
        public zzb(Context context) {
            super(m16833a(context));
        }

        @TargetApi(11)
        private static int m16833a(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || !zzs.zzavn()) ? activityManager.getMemoryClass() : zza.m16832a(activityManager);
            return (int) (((float) (memoryClass * 1048576)) * 0.33f);
        }

        protected int m16834a(zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected /* synthetic */ int mo1665a(Object obj, Object obj2) {
            return m16834a((zza) obj, (Bitmap) obj2);
        }

        protected void m16836a(boolean z, zza com_google_android_gms_common_images_zza_zza, Bitmap bitmap, Bitmap bitmap2) {
            super.mo1666a(z, com_google_android_gms_common_images_zza_zza, bitmap, bitmap2);
        }

        protected /* synthetic */ void mo1666a(boolean z, Object obj, Object obj2, Object obj3) {
            m16836a(z, (zza) obj, (Bitmap) obj2, (Bitmap) obj3);
        }
    }

    private final class zzc implements Runnable {
        final /* synthetic */ ImageManager f10614a;
        private final Uri f10615b;
        private final ParcelFileDescriptor f10616c;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f10614a = imageManager;
            this.f10615b = uri;
            this.f10616c = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhj("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f10616c != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f10616c.getFileDescriptor());
                } catch (Throwable e) {
                    String valueOf = String.valueOf(this.f10615b);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.f10616c.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f10614a.f10630f.post(new zzf(this.f10614a, this.f10615b, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.f10615b);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class zzd implements Runnable {
        final /* synthetic */ ImageManager f10617a;
        private final zza f10618b;

        public zzd(ImageManager imageManager, zza com_google_android_gms_common_images_zza) {
            this.f10617a = imageManager;
            this.f10618b = com_google_android_gms_common_images_zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhi("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.f10617a.f10634j.get(this.f10618b);
            if (imageReceiver != null) {
                this.f10617a.f10634j.remove(this.f10618b);
                imageReceiver.zzc(this.f10618b);
            }
            zza com_google_android_gms_common_images_zza_zza = this.f10618b.f10643a;
            if (com_google_android_gms_common_images_zza_zza.uri == null) {
                this.f10618b.m16859a(this.f10617a.f10629e, this.f10617a.f10633i, true);
                return;
            }
            Bitmap a = this.f10617a.m16840a(com_google_android_gms_common_images_zza_zza);
            if (a != null) {
                this.f10618b.m16857a(this.f10617a.f10629e, a, true);
                return;
            }
            Long l = (Long) this.f10617a.f10636l.get(com_google_android_gms_common_images_zza_zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.f10618b.m16859a(this.f10617a.f10629e, this.f10617a.f10633i, true);
                    return;
                }
                this.f10617a.f10636l.remove(com_google_android_gms_common_images_zza_zza.uri);
            }
            this.f10618b.m16858a(this.f10617a.f10629e, this.f10617a.f10633i);
            imageReceiver = (ImageReceiver) this.f10617a.f10635k.get(com_google_android_gms_common_images_zza_zza.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.f10617a, com_google_android_gms_common_images_zza_zza.uri);
                this.f10617a.f10635k.put(com_google_android_gms_common_images_zza_zza.uri, imageReceiver);
            }
            imageReceiver.zzb(this.f10618b);
            if (!(this.f10618b instanceof com.google.android.gms.common.images.zza.zzc)) {
                this.f10617a.f10634j.put(this.f10618b, imageReceiver);
            }
            synchronized (ImageManager.f10625a) {
                if (!ImageManager.f10626b.contains(com_google_android_gms_common_images_zza_zza.uri)) {
                    ImageManager.f10626b.add(com_google_android_gms_common_images_zza_zza.uri);
                    imageReceiver.zzarp();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {
        private final zzb f10619a;

        public zze(zzb com_google_android_gms_common_images_ImageManager_zzb) {
            this.f10619a = com_google_android_gms_common_images_ImageManager_zzb;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.f10619a.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.f10619a.evictAll();
            } else if (i >= 20) {
                this.f10619a.trimToSize(this.f10619a.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        final /* synthetic */ ImageManager f10620a;
        private final Uri f10621b;
        private final Bitmap f10622c;
        private final CountDownLatch f10623d;
        private boolean f10624e;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f10620a = imageManager;
            this.f10621b = uri;
            this.f10622c = bitmap;
            this.f10624e = z;
            this.f10623d = countDownLatch;
        }

        private void m16838a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.f10613c;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                zza com_google_android_gms_common_images_zza = (zza) a.get(i);
                if (z) {
                    com_google_android_gms_common_images_zza.m16857a(this.f10620a.f10629e, this.f10622c, false);
                } else {
                    this.f10620a.f10636l.put(this.f10621b, Long.valueOf(SystemClock.elapsedRealtime()));
                    com_google_android_gms_common_images_zza.m16859a(this.f10620a.f10629e, this.f10620a.f10633i, false);
                }
                if (!(com_google_android_gms_common_images_zza instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.f10620a.f10634j.remove(com_google_android_gms_common_images_zza);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzhi("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f10622c != null;
            if (this.f10620a.f10632h != null) {
                if (this.f10624e) {
                    this.f10620a.f10632h.evictAll();
                    System.gc();
                    this.f10624e = false;
                    this.f10620a.f10630f.post(this);
                    return;
                } else if (z) {
                    this.f10620a.f10632h.put(new zza(this.f10621b), this.f10622c);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.f10620a.f10635k.remove(this.f10621b);
            if (imageReceiver != null) {
                m16838a(imageReceiver, z);
            }
            this.f10623d.countDown();
            synchronized (ImageManager.f10625a) {
                ImageManager.f10626b.remove(this.f10621b);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.f10629e = context.getApplicationContext();
        if (z) {
            this.f10632h = new zzb(this.f10629e);
            if (zzs.zzavq()) {
                m16846c();
            }
        } else {
            this.f10632h = null;
        }
        this.f10633i = new zzrc();
        this.f10634j = new HashMap();
        this.f10635k = new HashMap();
        this.f10636l = new HashMap();
    }

    private Bitmap m16840a(zza com_google_android_gms_common_images_zza_zza) {
        return this.f10632h == null ? null : (Bitmap) this.f10632h.get(com_google_android_gms_common_images_zza_zza);
    }

    @TargetApi(14)
    private void m16846c() {
        this.f10629e.registerComponentCallbacks(new zze(this.f10632h));
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (f10628d == null) {
                f10628d = new ImageManager(context, true);
            }
            return f10628d;
        }
        if (f10627c == null) {
            f10627c = new ImageManager(context, false);
        }
        return f10627c;
    }

    public void loadImage(ImageView imageView, int i) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza com_google_android_gms_common_images_zza_zzb = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        com_google_android_gms_common_images_zza_zzb.zzfy(i);
        zza(com_google_android_gms_common_images_zza_zzb);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza(new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza com_google_android_gms_common_images_zza_zzc = new com.google.android.gms.common.images.zza.zzc(onImageLoadedListener, uri);
        com_google_android_gms_common_images_zza_zzc.zzfy(i);
        zza(com_google_android_gms_common_images_zza_zzc);
    }

    public void zza(zza com_google_android_gms_common_images_zza) {
        com.google.android.gms.common.internal.zzb.zzhi("ImageManager.loadImage() must be called in the main thread");
        new zzd(this, com_google_android_gms_common_images_zza).run();
    }
}
