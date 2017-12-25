package android.support.v4.content;

import android.support.v4.p008d.C0272c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0261h<D> {
    int f765a;
    C0224b<D> f766b;
    C0223a<D> f767c;
    boolean f768d;
    boolean f769e;
    boolean f770f;
    boolean f771g;
    boolean f772h;

    public interface C0223a<D> {
    }

    public interface C0224b<D> {
    }

    public void m1095a(int i, C0224b<D> c0224b) {
        if (this.f766b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f766b = c0224b;
        this.f765a = i;
    }

    public void m1097a(C0224b<D> c0224b) {
        if (this.f766b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f766b != c0224b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f766b = null;
        }
    }

    public void m1096a(C0223a<D> c0223a) {
        if (this.f767c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f767c = c0223a;
    }

    public void m1100b(C0223a<D> c0223a) {
        if (this.f767c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f767c != c0223a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f767c = null;
        }
    }

    public final void m1094a() {
        this.f768d = true;
        this.f770f = false;
        this.f769e = false;
        m1099b();
    }

    protected void m1099b() {
    }

    public void m1101c() {
        this.f768d = false;
        m1102d();
    }

    protected void m1102d() {
    }

    public void m1103e() {
        m1104f();
        this.f770f = true;
        this.f768d = false;
        this.f769e = false;
        this.f771g = false;
        this.f772h = false;
    }

    protected void m1104f() {
    }

    public String m1093a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0272c.m1160a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0272c.m1160a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f765a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m1098a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f765a);
        printWriter.print(" mListener=");
        printWriter.println(this.f766b);
        if (this.f768d || this.f771g || this.f772h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f768d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f771g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f772h);
        }
        if (this.f769e || this.f770f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f769e);
            printWriter.print(" mReset=");
            printWriter.println(this.f770f);
        }
    }
}
