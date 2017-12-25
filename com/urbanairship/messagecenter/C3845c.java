package com.urbanairship.messagecenter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.support.v4.content.C0126a;
import android.support.v4.p008d.C0275f;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import com.urbanairship.C3783j;
import com.urbanairship.util.C3946a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@TargetApi(14)
class C3845c {
    private final Executor f13718a = Executors.newFixedThreadPool(2);
    private final Context f13719b;
    private final Map<ImageView, C3842b> f13720c = new WeakHashMap();
    private final C0275f<String, BitmapDrawable> f13721d = new C0275f<String, BitmapDrawable>(this, (int) Math.min(10485760, Runtime.getRuntime().maxMemory() / 8)) {
        final /* synthetic */ C3845c f13707a;

        protected int m19990a(String str, BitmapDrawable bitmapDrawable) {
            return bitmapDrawable.getBitmap().getByteCount();
        }
    };

    private abstract class C3842b implements OnPreDrawListener {
        private final String f13708a;
        final /* synthetic */ C3845c f13709b;
        private final int f13710c;
        private C3844a f13711d;
        private int f13712e;
        private int f13713f;
        private final WeakReference<ImageView> f13714g;

        abstract void mo2806a();

        C3842b(C3845c c3845c, String str, int i, ImageView imageView) {
            this.f13709b = c3845c;
            this.f13710c = i;
            this.f13708a = str;
            this.f13714g = new WeakReference(imageView);
            this.f13712e = imageView.getWidth();
            this.f13713f = imageView.getHeight();
        }

        void m19995b() {
            ImageView c = m19996c();
            if (c != null) {
                c.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f13714g.clear();
            }
            if (this.f13711d != null) {
                this.f13711d.cancel(true);
                this.f13711d = null;
            }
        }

        ImageView m19996c() {
            return (ImageView) this.f13714g.get();
        }

        void m19997d() {
            ImageView c = m19996c();
            if (c == null) {
                mo2806a();
                return;
            }
            if (this.f13712e == 0 && this.f13713f == 0) {
                if (c.getWidth() == 0 && c.getHeight() == 0) {
                    c.getViewTreeObserver().addOnPreDrawListener(this);
                    return;
                } else {
                    this.f13712e = c.getWidth();
                    this.f13713f = c.getHeight();
                }
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) this.f13709b.f13721d.get(m19998e());
            if (bitmapDrawable != null) {
                c.setImageDrawable(bitmapDrawable);
                mo2806a();
                return;
            }
            if (this.f13710c > 0) {
                c.setImageResource(this.f13710c);
            } else {
                c.setImageDrawable(null);
            }
            this.f13711d = new C3844a(this.f13709b, this);
            this.f13711d.executeOnExecutor(this.f13709b.f13718a, new Void[0]);
        }

        public boolean onPreDraw() {
            ImageView c = m19996c();
            if (c != null) {
                c.getViewTreeObserver().removeOnPreDrawListener(this);
                if (c.getViewTreeObserver().isAlive()) {
                    this.f13713f = c.getHeight();
                    this.f13712e = c.getWidth();
                    m19997d();
                }
            }
            return true;
        }

        String m19998e() {
            return this.f13708a + ",size(" + this.f13712e + "x" + this.f13713f + ")";
        }
    }

    private class C3844a extends AsyncTask<Void, Void, BitmapDrawable> {
        final /* synthetic */ C3845c f13716a;
        private final C3842b f13717b;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m20001a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m20002a((BitmapDrawable) obj);
        }

        C3844a(C3845c c3845c, C3842b c3842b) {
            this.f13716a = c3845c;
            this.f13717b = c3842b;
        }

        protected BitmapDrawable m20001a(Void... voidArr) {
            m20000a();
            if (this.f13717b.f13708a == null) {
                return null;
            }
            try {
                Bitmap a = C3946a.m20488a(this.f13716a.f13719b, new URL(this.f13717b.f13708a), this.f13717b.f13712e, this.f13717b.f13713f);
                if (a == null) {
                    return null;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f13716a.f13719b.getResources(), a);
                this.f13716a.f13721d.put(this.f13717b.m19998e(), bitmapDrawable);
                return bitmapDrawable;
            } catch (IOException e) {
                C3783j.m19725c("Unable to fetch bitmap: " + this.f13717b.f13708a);
                return null;
            }
        }

        protected void m20002a(BitmapDrawable bitmapDrawable) {
            ImageView c = this.f13717b.m19996c();
            if (bitmapDrawable != null && c != null) {
                Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(C0126a.m584b(this.f13716a.f13719b, 17170445)), bitmapDrawable});
                c.setImageDrawable(transitionDrawable);
                transitionDrawable.startTransition(200);
            }
        }

        private void m20000a() {
            File file = new File(this.f13716a.f13719b.getApplicationContext().getCacheDir(), "urbanairship-cache");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (HttpResponseCache.getInstalled() == null) {
                try {
                    HttpResponseCache.install(file, 52428800);
                } catch (IOException e) {
                    C3783j.m19728e("Unable to install image loader cache");
                }
            }
        }
    }

    C3845c(Context context) {
        this.f13719b = context.getApplicationContext();
    }

    void m20007a(ImageView imageView) {
        if (imageView != null) {
            C3842b c3842b = (C3842b) this.f13720c.remove(imageView);
            if (c3842b != null) {
                c3842b.m19995b();
            }
        }
    }

    void m20008a(String str, int i, ImageView imageView) {
        m20007a(imageView);
        C3842b c38432 = new C3842b(this, str, i, imageView) {
            final /* synthetic */ C3845c f13715a;

            void mo2806a() {
                ImageView c = m19996c();
                if (c != null) {
                    this.f13715a.f13720c.remove(c);
                }
            }
        };
        this.f13720c.put(imageView, c38432);
        c38432.m19997d();
    }
}
