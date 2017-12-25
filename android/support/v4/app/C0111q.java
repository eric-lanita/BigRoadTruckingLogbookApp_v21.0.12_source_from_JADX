package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p008d.C0269h;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class C0111q<E> extends C0107o {
    private final Activity f437a;
    final Context f438b;
    final int f439c;
    final C0211s f440d;
    private final Handler f441e;
    private C0269h<String, C0222w> f442f;
    private boolean f443g;
    private C0226x f444h;
    private boolean f445i;
    private boolean f446j;

    public abstract E mo97g();

    C0111q(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler, 0);
    }

    C0111q(Activity activity, Context context, Handler handler, int i) {
        this.f440d = new C0211s();
        this.f437a = activity;
        this.f438b = context;
        this.f441e = handler;
        this.f439c = i;
    }

    public void mo89a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean mo90a(Fragment fragment) {
        return true;
    }

    public LayoutInflater mo92b() {
        return (LayoutInflater) this.f438b.getSystemService("layout_inflater");
    }

    public void mo94d() {
    }

    public void mo87a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f438b.startActivity(intent);
    }

    public void mo88a(Fragment fragment, String[] strArr, int i) {
    }

    public boolean mo91a(String str) {
        return false;
    }

    public boolean mo95e() {
        return true;
    }

    public int mo96f() {
        return this.f439c;
    }

    public View mo85a(int i) {
        return null;
    }

    public boolean mo86a() {
        return true;
    }

    Activity m536h() {
        return this.f437a;
    }

    Context m537i() {
        return this.f438b;
    }

    Handler m538j() {
        return this.f441e;
    }

    C0211s m539k() {
        return this.f440d;
    }

    C0226x m540l() {
        if (this.f444h != null) {
            return this.f444h;
        }
        this.f445i = true;
        this.f444h = m518a("(root)", this.f446j, true);
        return this.f444h;
    }

    void m530b(String str) {
        if (this.f442f != null) {
            C0226x c0226x = (C0226x) this.f442f.get(str);
            if (c0226x != null && !c0226x.f745f) {
                c0226x.m1027h();
                this.f442f.remove(str);
            }
        }
    }

    void mo93b(Fragment fragment) {
    }

    boolean m541m() {
        return this.f443g;
    }

    void m542n() {
        if (!this.f446j) {
            this.f446j = true;
            if (this.f444h != null) {
                this.f444h.m1021b();
            } else if (!this.f445i) {
                this.f444h = m518a("(root)", this.f446j, false);
                if (!(this.f444h == null || this.f444h.f744e)) {
                    this.f444h.m1021b();
                }
            }
            this.f445i = true;
        }
    }

    void m524a(boolean z) {
        this.f443g = z;
        if (this.f444h != null && this.f446j) {
            this.f446j = false;
            if (z) {
                this.f444h.m1023d();
            } else {
                this.f444h.m1022c();
            }
        }
    }

    void m543o() {
        if (this.f444h != null) {
            this.f444h.m1027h();
        }
    }

    void m544p() {
        if (this.f442f != null) {
            int size = this.f442f.size();
            C0226x[] c0226xArr = new C0226x[size];
            for (int i = size - 1; i >= 0; i--) {
                c0226xArr[i] = (C0226x) this.f442f.m1150c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0226x c0226x = c0226xArr[i2];
                c0226x.m1024e();
                c0226x.m1026g();
            }
        }
    }

    C0226x m518a(String str, boolean z, boolean z2) {
        if (this.f442f == null) {
            this.f442f = new C0269h();
        }
        C0226x c0226x = (C0226x) this.f442f.get(str);
        if (c0226x != null) {
            c0226x.m1018a(this);
            return c0226x;
        } else if (!z2) {
            return c0226x;
        } else {
            c0226x = new C0226x(str, this, z);
            this.f442f.put(str, c0226x);
            return c0226x;
        }
    }

    C0269h<String, C0222w> m545q() {
        int i;
        int i2 = 0;
        if (this.f442f != null) {
            int size = this.f442f.size();
            C0226x[] c0226xArr = new C0226x[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c0226xArr[i3] = (C0226x) this.f442f.m1150c(i3);
            }
            i = 0;
            while (i2 < size) {
                C0226x c0226x = c0226xArr[i2];
                if (c0226x.f745f) {
                    i = 1;
                } else {
                    c0226x.m1027h();
                    this.f442f.remove(c0226x.f743d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.f442f;
        }
        return null;
    }

    void m522a(C0269h<String, C0222w> c0269h) {
        this.f442f = c0269h;
    }

    void m531b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f446j);
        if (this.f444h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f444h)));
            printWriter.println(":");
            this.f444h.m1019a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }
}
