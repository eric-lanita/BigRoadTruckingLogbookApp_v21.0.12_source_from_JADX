package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ax {
    static final C0415g f1022a;
    private WeakReference<View> f1023b;
    private Runnable f1024c = null;
    private Runnable f1025d = null;
    private int f1026e = -1;

    interface C0415g {
        long mo316a(ax axVar, View view);

        void mo317a(ax axVar, View view, float f);

        void mo318a(ax axVar, View view, long j);

        void mo319a(ax axVar, View view, bb bbVar);

        void mo320a(ax axVar, View view, bd bdVar);

        void mo321a(ax axVar, View view, Interpolator interpolator);

        void mo322b(ax axVar, View view);

        void mo323b(ax axVar, View view, float f);

        void mo324b(ax axVar, View view, long j);

        void mo325c(ax axVar, View view);
    }

    static class C0416a implements C0415g {
        WeakHashMap<View, Runnable> f1018a = null;

        class C0414a implements Runnable {
            WeakReference<View> f1015a;
            ax f1016b;
            final /* synthetic */ C0416a f1017c;

            private C0414a(C0416a c0416a, ax axVar, View view) {
                this.f1017c = c0416a;
                this.f1015a = new WeakReference(view);
                this.f1016b = axVar;
            }

            public void run() {
                View view = (View) this.f1015a.get();
                if (view != null) {
                    this.f1017c.m1945d(this.f1016b, view);
                }
            }
        }

        C0416a() {
        }

        public void mo318a(ax axVar, View view, long j) {
        }

        public void mo317a(ax axVar, View view, float f) {
            m1946e(axVar, view);
        }

        public void mo323b(ax axVar, View view, float f) {
            m1946e(axVar, view);
        }

        public long mo316a(ax axVar, View view) {
            return 0;
        }

        public void mo321a(ax axVar, View view, Interpolator interpolator) {
        }

        public void mo324b(ax axVar, View view, long j) {
        }

        public void mo322b(ax axVar, View view) {
            m1946e(axVar, view);
        }

        public void mo325c(ax axVar, View view) {
            m1944a(view);
            m1945d(axVar, view);
        }

        public void mo319a(ax axVar, View view, bb bbVar) {
            view.setTag(2113929216, bbVar);
        }

        public void mo320a(ax axVar, View view, bd bdVar) {
        }

        private void m1945d(ax axVar, View view) {
            bb bbVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof bb) {
                bbVar = (bb) tag;
            } else {
                bbVar = null;
            }
            Runnable a = axVar.f1024c;
            Runnable b = axVar.f1025d;
            axVar.f1024c = null;
            axVar.f1025d = null;
            if (a != null) {
                a.run();
            }
            if (bbVar != null) {
                bbVar.mo326a(view);
                bbVar.mo327b(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.f1018a != null) {
                this.f1018a.remove(view);
            }
        }

        private void m1944a(View view) {
            if (this.f1018a != null) {
                Runnable runnable = (Runnable) this.f1018a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void m1946e(ax axVar, View view) {
            Runnable runnable;
            if (this.f1018a != null) {
                runnable = (Runnable) this.f1018a.get(view);
            } else {
                runnable = null;
            }
            if (runnable == null) {
                runnable = new C0414a(axVar, view);
                if (this.f1018a == null) {
                    this.f1018a = new WeakHashMap();
                }
                this.f1018a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class C0418b extends C0416a {
        WeakHashMap<View, Integer> f1021b = null;

        static class C0417a implements bb {
            ax f1019a;
            boolean f1020b;

            C0417a(ax axVar) {
                this.f1019a = axVar;
            }

            public void mo326a(View view) {
                bb bbVar;
                this.f1020b = false;
                if (this.f1019a.f1026e >= 0) {
                    ag.m1782a(view, 2, null);
                }
                if (this.f1019a.f1024c != null) {
                    Runnable a = this.f1019a.f1024c;
                    this.f1019a.f1024c = null;
                    a.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof bb) {
                    bbVar = (bb) tag;
                } else {
                    bbVar = null;
                }
                if (bbVar != null) {
                    bbVar.mo326a(view);
                }
            }

            public void mo327b(View view) {
                if (this.f1019a.f1026e >= 0) {
                    ag.m1782a(view, this.f1019a.f1026e, null);
                    this.f1019a.f1026e = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.f1020b) {
                    bb bbVar;
                    if (this.f1019a.f1025d != null) {
                        Runnable b = this.f1019a.f1025d;
                        this.f1019a.f1025d = null;
                        b.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof bb) {
                        bbVar = (bb) tag;
                    } else {
                        bbVar = null;
                    }
                    if (bbVar != null) {
                        bbVar.mo327b(view);
                    }
                    this.f1020b = true;
                }
            }

            public void mo328c(View view) {
                bb bbVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof bb) {
                    bbVar = (bb) tag;
                } else {
                    bbVar = null;
                }
                if (bbVar != null) {
                    bbVar.mo328c(view);
                }
            }
        }

        C0418b() {
        }

        public void mo318a(ax axVar, View view, long j) {
            ay.m1992a(view, j);
        }

        public void mo317a(ax axVar, View view, float f) {
            ay.m1991a(view, f);
        }

        public void mo323b(ax axVar, View view, float f) {
            ay.m1996b(view, f);
        }

        public long mo316a(ax axVar, View view) {
            return ay.m1990a(view);
        }

        public void mo321a(ax axVar, View view, Interpolator interpolator) {
            ay.m1994a(view, interpolator);
        }

        public void mo324b(ax axVar, View view, long j) {
            ay.m1997b(view, j);
        }

        public void mo322b(ax axVar, View view) {
            ay.m1995b(view);
        }

        public void mo325c(ax axVar, View view) {
            ay.m1998c(view);
        }

        public void mo319a(ax axVar, View view, bb bbVar) {
            view.setTag(2113929216, bbVar);
            ay.m1993a(view, new C0417a(axVar));
        }
    }

    static class C0419d extends C0418b {
        C0419d() {
        }

        public void mo319a(ax axVar, View view, bb bbVar) {
            az.m1999a(view, bbVar);
        }
    }

    static class C0420c extends C0419d {
        C0420c() {
        }
    }

    static class C0421e extends C0420c {
        C0421e() {
        }

        public void mo320a(ax axVar, View view, bd bdVar) {
            ba.m2009a(view, bdVar);
        }
    }

    static class C0422f extends C0421e {
        C0422f() {
        }
    }

    ax(View view) {
        this.f1023b = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1022a = new C0422f();
        } else if (i >= 19) {
            f1022a = new C0421e();
        } else if (i >= 18) {
            f1022a = new C0420c();
        } else if (i >= 16) {
            f1022a = new C0419d();
        } else if (i >= 14) {
            f1022a = new C0418b();
        } else {
            f1022a = new C0416a();
        }
    }

    public ax m1982a(long j) {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo318a(this, view, j);
        }
        return this;
    }

    public ax m1981a(float f) {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo317a(this, view, f);
        }
        return this;
    }

    public ax m1986b(float f) {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo323b(this, view, f);
        }
        return this;
    }

    public long m1980a() {
        View view = (View) this.f1023b.get();
        if (view != null) {
            return f1022a.mo316a(this, view);
        }
        return 0;
    }

    public ax m1985a(Interpolator interpolator) {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo321a(this, view, interpolator);
        }
        return this;
    }

    public ax m1987b(long j) {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo324b(this, view, j);
        }
        return this;
    }

    public void m1988b() {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo322b(this, view);
        }
    }

    public void m1989c() {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo325c(this, view);
        }
    }

    public ax m1983a(bb bbVar) {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo319a(this, view, bbVar);
        }
        return this;
    }

    public ax m1984a(bd bdVar) {
        View view = (View) this.f1023b.get();
        if (view != null) {
            f1022a.mo320a(this, view, bdVar);
        }
        return this;
    }
}
