package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.C0222w.C0221a;
import android.support.v4.content.C0261h;
import android.support.v4.content.C0261h.C0223a;
import android.support.v4.content.C0261h.C0224b;
import android.support.v4.p008d.C0272c;
import android.support.v4.p008d.C0281i;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class C0226x extends C0222w {
    static boolean f740a = false;
    final C0281i<C0225a> f741b = new C0281i();
    final C0281i<C0225a> f742c = new C0281i();
    final String f743d;
    boolean f744e;
    boolean f745f;
    private C0111q f746g;

    final class C0225a implements C0223a<Object>, C0224b<Object> {
        final int f725a;
        final Bundle f726b;
        C0221a<Object> f727c;
        C0261h<Object> f728d;
        boolean f729e;
        boolean f730f;
        Object f731g;
        boolean f732h;
        boolean f733i;
        boolean f734j;
        boolean f735k;
        boolean f736l;
        boolean f737m;
        C0225a f738n;
        final /* synthetic */ C0226x f739o;

        void m1009a() {
            if (this.f733i && this.f734j) {
                this.f732h = true;
            } else if (!this.f732h) {
                this.f732h = true;
                if (C0226x.f740a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f728d == null && this.f727c != null) {
                    this.f728d = this.f727c.m1005a(this.f725a, this.f726b);
                }
                if (this.f728d == null) {
                    return;
                }
                if (!this.f728d.getClass().isMemberClass() || Modifier.isStatic(this.f728d.getClass().getModifiers())) {
                    if (!this.f737m) {
                        this.f728d.m1095a(this.f725a, this);
                        this.f728d.m1096a((C0223a) this);
                        this.f737m = true;
                    }
                    this.f728d.m1094a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f728d);
            }
        }

        void m1012b() {
            if (C0226x.f740a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f733i = true;
            this.f734j = this.f732h;
            this.f732h = false;
            this.f727c = null;
        }

        void m1013c() {
            if (this.f733i) {
                if (C0226x.f740a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f733i = false;
                if (!(this.f732h == this.f734j || this.f732h)) {
                    m1015e();
                }
            }
            if (this.f732h && this.f729e && !this.f735k) {
                m1010a(this.f728d, this.f731g);
            }
        }

        void m1014d() {
            if (this.f732h && this.f735k) {
                this.f735k = false;
                if (this.f729e) {
                    m1010a(this.f728d, this.f731g);
                }
            }
        }

        void m1015e() {
            if (C0226x.f740a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f732h = false;
            if (!this.f733i && this.f728d != null && this.f737m) {
                this.f737m = false;
                this.f728d.m1097a((C0224b) this);
                this.f728d.m1100b(this);
                this.f728d.m1101c();
            }
        }

        void m1016f() {
            String str;
            C0221a c0221a = null;
            if (C0226x.f740a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f736l = true;
            boolean z = this.f730f;
            this.f730f = false;
            if (this.f727c != null && this.f728d != null && this.f729e && z) {
                if (C0226x.f740a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f739o.f746g != null) {
                    String str2 = this.f739o.f746g.f440d.f697v;
                    this.f739o.f746g.f440d.f697v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f727c.m1006a(this.f728d);
                } finally {
                    c0221a = this.f739o.f746g;
                    if (c0221a != null) {
                        c0221a = this.f739o.f746g.f440d;
                        c0221a.f697v = str;
                    }
                }
            }
            this.f727c = c0221a;
            this.f731g = c0221a;
            this.f729e = false;
            if (this.f728d != null) {
                if (this.f737m) {
                    this.f737m = false;
                    this.f728d.m1097a((C0224b) this);
                    this.f728d.m1100b(this);
                }
                this.f728d.m1103e();
            }
            if (this.f738n != null) {
                this.f738n.m1016f();
            }
        }

        void m1010a(C0261h<Object> c0261h, Object obj) {
            String str;
            if (this.f727c != null) {
                if (this.f739o.f746g != null) {
                    String str2 = this.f739o.f746g.f440d.f697v;
                    this.f739o.f746g.f440d.f697v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (C0226x.f740a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0261h + ": " + c0261h.m1093a(obj));
                    }
                    this.f727c.m1007a((C0261h) c0261h, obj);
                    this.f730f = true;
                } finally {
                    if (this.f739o.f746g != null) {
                        this.f739o.f746g.f440d.f697v = str;
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f725a);
            stringBuilder.append(" : ");
            C0272c.m1160a(this.f728d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public void m1011a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f725a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f726b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f727c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f728d);
            if (this.f728d != null) {
                this.f728d.m1098a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f729e || this.f730f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f729e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f730f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f731g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f732h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f735k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f736l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f733i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f734j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f737m);
            if (this.f738n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f738n);
                printWriter.println(":");
                this.f738n.m1011a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }
    }

    C0226x(String str, C0111q c0111q, boolean z) {
        this.f743d = str;
        this.f746g = c0111q;
        this.f744e = z;
    }

    void m1018a(C0111q c0111q) {
        this.f746g = c0111q;
    }

    void m1021b() {
        if (f740a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f744e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f744e = true;
        for (int b = this.f741b.m1181b() - 1; b >= 0; b--) {
            ((C0225a) this.f741b.m1187e(b)).m1009a();
        }
    }

    void m1022c() {
        if (f740a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f744e) {
            for (int b = this.f741b.m1181b() - 1; b >= 0; b--) {
                ((C0225a) this.f741b.m1187e(b)).m1015e();
            }
            this.f744e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m1023d() {
        if (f740a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f744e) {
            this.f745f = true;
            this.f744e = false;
            for (int b = this.f741b.m1181b() - 1; b >= 0; b--) {
                ((C0225a) this.f741b.m1187e(b)).m1012b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m1024e() {
        if (this.f745f) {
            if (f740a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f745f = false;
            for (int b = this.f741b.m1181b() - 1; b >= 0; b--) {
                ((C0225a) this.f741b.m1187e(b)).m1013c();
            }
        }
    }

    void m1025f() {
        for (int b = this.f741b.m1181b() - 1; b >= 0; b--) {
            ((C0225a) this.f741b.m1187e(b)).f735k = true;
        }
    }

    void m1026g() {
        for (int b = this.f741b.m1181b() - 1; b >= 0; b--) {
            ((C0225a) this.f741b.m1187e(b)).m1014d();
        }
    }

    void m1027h() {
        int b;
        if (!this.f745f) {
            if (f740a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f741b.m1181b() - 1; b >= 0; b--) {
                ((C0225a) this.f741b.m1187e(b)).m1016f();
            }
            this.f741b.m1184c();
        }
        if (f740a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f742c.m1181b() - 1; b >= 0; b--) {
            ((C0225a) this.f742c.m1187e(b)).m1016f();
        }
        this.f742c.m1184c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0272c.m1160a(this.f746g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void m1019a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f741b.m1181b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f741b.m1181b(); i2++) {
                C0225a c0225a = (C0225a) this.f741b.m1187e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f741b.m1186d(i2));
                printWriter.print(": ");
                printWriter.println(c0225a.toString());
                c0225a.m1011a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f742c.m1181b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f742c.m1181b()) {
                c0225a = (C0225a) this.f742c.m1187e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f742c.m1186d(i));
                printWriter.print(": ");
                printWriter.println(c0225a.toString());
                c0225a.m1011a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo159a() {
        int b = this.f741b.m1181b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            int i2;
            C0225a c0225a = (C0225a) this.f741b.m1187e(i);
            if (!c0225a.f732h || c0225a.f730f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
