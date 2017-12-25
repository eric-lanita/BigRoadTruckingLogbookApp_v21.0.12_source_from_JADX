package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.C0217u.C0189b;
import android.support.v4.app.C0217u.C0216a;
import android.support.v4.p008d.C0270a;
import android.support.v4.p008d.C0273d;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class C0196h extends C0195t implements Runnable {
    static final boolean f635a = (VERSION.SDK_INT >= 21);
    final C0211s f636b;
    C0193a f637c;
    C0193a f638d;
    int f639e;
    int f640f;
    int f641g;
    int f642h;
    int f643i;
    int f644j;
    int f645k;
    boolean f646l;
    boolean f647m = true;
    String f648n;
    boolean f649o;
    int f650p = -1;
    int f651q;
    CharSequence f652r;
    int f653s;
    CharSequence f654t;
    ArrayList<String> f655u;
    ArrayList<String> f656v;

    static final class C0193a {
        C0193a f621a;
        C0193a f622b;
        int f623c;
        Fragment f624d;
        int f625e;
        int f626f;
        int f627g;
        int f628h;
        ArrayList<Fragment> f629i;

        C0193a() {
        }
    }

    public class C0194b {
        public C0270a<String, String> f630a = new C0270a();
        public ArrayList<View> f631b = new ArrayList();
        public C0216a f632c = new C0216a();
        public View f633d;
        final /* synthetic */ C0196h f634e;

        public C0194b(C0196h c0196h) {
            this.f634e = c0196h;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f650p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f650p);
        }
        if (this.f648n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f648n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m855a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m856a(str, printWriter, true);
    }

    public void m856a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f648n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f650p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f649o);
            if (this.f644j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f644j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f645k));
            }
            if (!(this.f640f == 0 && this.f641g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f640f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f641g));
            }
            if (!(this.f642h == 0 && this.f643i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f642h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f643i));
            }
            if (!(this.f651q == 0 && this.f652r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f651q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f652r);
            }
            if (!(this.f653s == 0 && this.f654t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f653s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f654t);
            }
        }
        if (this.f637c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0193a c0193a = this.f637c;
            while (c0193a != null) {
                String str3;
                switch (c0193a.f623c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0193a.f623c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0193a.f624d);
                if (z) {
                    if (!(c0193a.f625e == 0 && c0193a.f626f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0193a.f625e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0193a.f626f));
                    }
                    if (!(c0193a.f627g == 0 && c0193a.f628h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0193a.f627g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0193a.f628h));
                    }
                }
                if (c0193a.f629i != null && c0193a.f629i.size() > 0) {
                    for (int i2 = 0; i2 < c0193a.f629i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0193a.f629i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0193a.f629i.get(i2));
                    }
                }
                c0193a = c0193a.f621a;
                i++;
            }
        }
    }

    public C0196h(C0211s c0211s) {
        this.f636b = c0211s;
    }

    void m853a(C0193a c0193a) {
        if (this.f637c == null) {
            this.f638d = c0193a;
            this.f637c = c0193a;
        } else {
            c0193a.f622b = this.f638d;
            this.f638d.f621a = c0193a;
            this.f638d = c0193a;
        }
        c0193a.f625e = this.f640f;
        c0193a.f626f = this.f641g;
        c0193a.f627g = this.f642h;
        c0193a.f628h = this.f643i;
        this.f639e++;
    }

    public C0195t mo142a(Fragment fragment, String str) {
        m826a(0, fragment, str, 1);
        return this;
    }

    public C0195t mo139a(int i, Fragment fragment) {
        m826a(i, fragment, null, 1);
        return this;
    }

    public C0195t mo140a(int i, Fragment fragment, String str) {
        m826a(i, fragment, str, 1);
        return this;
    }

    private void m826a(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.f636b;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.mFragmentId == 0 || fragment.mFragmentId == i) {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
        }
        C0193a c0193a = new C0193a();
        c0193a.f623c = i2;
        c0193a.f624d = fragment;
        m853a(c0193a);
    }

    public C0195t mo144b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m826a(i, fragment, str, 2);
        return this;
    }

    public C0195t mo141a(Fragment fragment) {
        C0193a c0193a = new C0193a();
        c0193a.f623c = 3;
        c0193a.f624d = fragment;
        m853a(c0193a);
        return this;
    }

    public C0195t mo145b(Fragment fragment) {
        C0193a c0193a = new C0193a();
        c0193a.f623c = 4;
        c0193a.f624d = fragment;
        m853a(c0193a);
        return this;
    }

    public C0195t mo146c(Fragment fragment) {
        C0193a c0193a = new C0193a();
        c0193a.f623c = 5;
        c0193a.f624d = fragment;
        m853a(c0193a);
        return this;
    }

    void m852a(int i) {
        if (this.f646l) {
            if (C0211s.f676a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0193a c0193a = this.f637c; c0193a != null; c0193a = c0193a.f621a) {
                Fragment fragment;
                if (c0193a.f624d != null) {
                    fragment = c0193a.f624d;
                    fragment.mBackStackNesting += i;
                    if (C0211s.f676a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0193a.f624d + " to " + c0193a.f624d.mBackStackNesting);
                    }
                }
                if (c0193a.f629i != null) {
                    for (int size = c0193a.f629i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0193a.f629i.get(size);
                        fragment.mBackStackNesting += i;
                        if (C0211s.f676a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public int mo138a() {
        return m846a(false);
    }

    public int mo143b() {
        return m846a(true);
    }

    int m846a(boolean z) {
        if (this.f649o) {
            throw new IllegalStateException("commit already called");
        }
        if (C0211s.f676a) {
            Log.v("FragmentManager", "Commit: " + this);
            m855a("  ", null, new PrintWriter(new C0273d("FragmentManager")), null);
        }
        this.f649o = true;
        if (this.f646l) {
            this.f650p = this.f636b.m917a(this);
        } else {
            this.f650p = -1;
        }
        this.f636b.m936a((Runnable) this, z);
        return this.f650p;
    }

    public void run() {
        if (C0211s.f676a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f646l || this.f650p >= 0) {
            C0194b c0194b;
            m852a(1);
            if (!f635a || this.f636b.f690n < 1) {
                c0194b = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m843b(sparseArray, sparseArray2);
                c0194b = m818a(sparseArray, sparseArray2, false);
            }
            int i = c0194b != null ? 0 : this.f645k;
            int i2 = c0194b != null ? 0 : this.f644j;
            C0193a c0193a = this.f637c;
            while (c0193a != null) {
                int i3 = c0194b != null ? 0 : c0193a.f625e;
                int i4 = c0194b != null ? 0 : c0193a.f626f;
                Fragment fragment;
                switch (c0193a.f623c) {
                    case 1:
                        fragment = c0193a.f624d;
                        fragment.mNextAnim = i3;
                        this.f636b.m934a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = c0193a.f624d;
                        int i5 = fragment2.mContainerId;
                        if (this.f636b.f683g != null) {
                            int size = this.f636b.f683g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.f636b.f683g.get(size);
                                if (C0211s.f676a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.mContainerId == i5) {
                                    if (fragment == fragment2) {
                                        fragment = null;
                                        c0193a.f624d = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (c0193a.f629i == null) {
                                            c0193a.f629i = new ArrayList();
                                        }
                                        c0193a.f629i.add(fragment);
                                        fragment.mNextAnim = i4;
                                        if (this.f646l) {
                                            fragment.mBackStackNesting++;
                                            if (C0211s.f676a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                                            }
                                        }
                                        this.f636b.m932a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.mNextAnim = i3;
                        this.f636b.m934a(fragment2, false);
                        break;
                    case 3:
                        fragment = c0193a.f624d;
                        fragment.mNextAnim = i4;
                        this.f636b.m932a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = c0193a.f624d;
                        fragment.mNextAnim = i4;
                        this.f636b.m945b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = c0193a.f624d;
                        fragment.mNextAnim = i3;
                        this.f636b.m951c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = c0193a.f624d;
                        fragment.mNextAnim = i4;
                        this.f636b.m955d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = c0193a.f624d;
                        fragment.mNextAnim = i3;
                        this.f636b.m957e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0193a.f623c);
                }
                c0193a = c0193a.f621a;
            }
            this.f636b.m925a(this.f636b.f690n, i2, i, true);
            if (this.f646l) {
                this.f636b.m946b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m837a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0 && !fragment.isHidden()) {
                if (fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m844b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.mContainerId;
            if (i != 0) {
                if (!fragment.isAdded()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.mState < 1 && this.f636b.f690n >= 1) {
                this.f636b.m950c(fragment);
                this.f636b.m933a(fragment, 1, 0, 0, false);
            }
        }
    }

    private void m843b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f636b.f692p.mo86a()) {
            for (C0193a c0193a = this.f637c; c0193a != null; c0193a = c0193a.f621a) {
                switch (c0193a.f623c) {
                    case 1:
                        m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 2:
                        Fragment fragment = c0193a.f624d;
                        if (this.f636b.f683g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.f636b.f683g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f636b.f683g.get(i);
                                if (fragment2 == null || fragment3.mContainerId == fragment2.mContainerId) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.mContainerId);
                                    } else {
                                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 3:
                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 4:
                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 5:
                        m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 6:
                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 7:
                        m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m854a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f636b.f692p.mo86a()) {
            for (C0193a c0193a = this.f638d; c0193a != null; c0193a = c0193a.f622b) {
                switch (c0193a.f623c) {
                    case 1:
                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 2:
                        if (c0193a.f629i != null) {
                            for (int size = c0193a.f629i.size() - 1; size >= 0; size--) {
                                m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) c0193a.f629i.get(size));
                            }
                        }
                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 3:
                        m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 4:
                        m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 5:
                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 6:
                        m844b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    case 7:
                        C0196h.m837a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0193a.f624d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public C0194b m847a(boolean z, C0194b c0194b, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (C0211s.f676a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m855a("  ", null, new PrintWriter(new C0273d("FragmentManager")), null);
        }
        if (f635a && this.f636b.f690n >= 1) {
            if (c0194b == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0194b = m818a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0196h.m831a(c0194b, this.f656v, this.f655u);
            }
        }
        m852a(-1);
        int i = c0194b != null ? 0 : this.f645k;
        int i2 = c0194b != null ? 0 : this.f644j;
        C0193a c0193a = this.f638d;
        while (c0193a != null) {
            int i3 = c0194b != null ? 0 : c0193a.f627g;
            int i4 = c0194b != null ? 0 : c0193a.f628h;
            Fragment fragment;
            Fragment fragment2;
            switch (c0193a.f623c) {
                case 1:
                    fragment = c0193a.f624d;
                    fragment.mNextAnim = i4;
                    this.f636b.m932a(fragment, C0211s.m915c(i2), i);
                    break;
                case 2:
                    fragment = c0193a.f624d;
                    if (fragment != null) {
                        fragment.mNextAnim = i4;
                        this.f636b.m932a(fragment, C0211s.m915c(i2), i);
                    }
                    if (c0193a.f629i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0193a.f629i.size(); i5++) {
                        fragment2 = (Fragment) c0193a.f629i.get(i5);
                        fragment2.mNextAnim = i3;
                        this.f636b.m934a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = c0193a.f624d;
                    fragment2.mNextAnim = i3;
                    this.f636b.m934a(fragment2, false);
                    break;
                case 4:
                    fragment2 = c0193a.f624d;
                    fragment2.mNextAnim = i3;
                    this.f636b.m951c(fragment2, C0211s.m915c(i2), i);
                    break;
                case 5:
                    fragment = c0193a.f624d;
                    fragment.mNextAnim = i4;
                    this.f636b.m945b(fragment, C0211s.m915c(i2), i);
                    break;
                case 6:
                    fragment2 = c0193a.f624d;
                    fragment2.mNextAnim = i3;
                    this.f636b.m957e(fragment2, C0211s.m915c(i2), i);
                    break;
                case 7:
                    fragment2 = c0193a.f624d;
                    fragment2.mNextAnim = i3;
                    this.f636b.m955d(fragment2, C0211s.m915c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0193a.f623c);
            }
            c0193a = c0193a.f622b;
        }
        if (z) {
            this.f636b.m925a(this.f636b.f690n, C0211s.m915c(i2), i, true);
            c0194b = null;
        }
        if (this.f650p >= 0) {
            this.f636b.m943b(this.f650p);
            this.f650p = -1;
        }
        return c0194b;
    }

    public String m861c() {
        return this.f648n;
    }

    private C0194b m818a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i;
        int i2 = 0;
        C0194b c0194b = new C0194b(this);
        c0194b.f633d = new View(this.f636b.f691o.m537i());
        int i3 = 0;
        int i4 = 0;
        while (i3 < sparseArray.size()) {
            if (m839a(sparseArray.keyAt(i3), c0194b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i = 1;
            } else {
                i = i4;
            }
            i3++;
            i4 = i;
        }
        while (i2 < sparseArray2.size()) {
            i = sparseArray2.keyAt(i2);
            if (sparseArray.get(i) == null && m839a(i, c0194b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i4 = 1;
            }
            i2++;
        }
        if (i4 == 0) {
            return null;
        }
        return c0194b;
    }

    private static Object m824a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0217u.m975a(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object m841b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0217u.m975a(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static Object m823a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return C0217u.m994b(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    private static Object m825a(Object obj, Fragment fragment, ArrayList<View> arrayList, C0270a<String, View> c0270a, View view) {
        if (obj != null) {
            return C0217u.m976a(obj, fragment.getView(), arrayList, c0270a, view);
        }
        return obj;
    }

    private C0270a<String, View> m819a(C0194b c0194b, Fragment fragment, boolean z) {
        C0270a c0270a = new C0270a();
        if (this.f655u != null) {
            C0217u.m989a((Map) c0270a, fragment.getView());
            if (z) {
                c0270a.m1153a(this.f656v);
            } else {
                c0270a = C0196h.m822a(this.f655u, this.f656v, c0270a);
            }
        }
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.m777a(this.f656v, (Map) c0270a);
            }
            m829a(c0194b, c0270a, false);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.m777a(this.f656v, (Map) c0270a);
            }
            m842b(c0194b, c0270a, false);
        }
        return c0270a;
    }

    private boolean m839a(int i, C0194b c0194b, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f636b.f692p.mo85a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        C0189b c01901;
        ArrayList arrayList2;
        Map c0270a;
        boolean z2;
        Object a2;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = C0196h.m824a(fragment, z);
        Object a4 = C0196h.m823a(fragment, fragment2, z);
        Object b = C0196h.m841b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m819a(c0194b, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0196h.m825a(b, fragment2, arrayList, (C0270a) map, c0194b.f633d);
                if (!(this.f656v == null || map == null)) {
                    view2 = (View) map.get(this.f656v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            C0217u.m982a(a, view2);
                        }
                        if (obj != null) {
                            C0217u.m982a(obj, view2);
                        }
                    }
                }
                c01901 = new C0189b(this) {
                    final /* synthetic */ C0196h f607b;

                    public View mo137a() {
                        return fragment.getView();
                    }
                };
                arrayList2 = new ArrayList();
                c0270a = new C0270a();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
                }
                a2 = C0217u.m977a(a3, a, obj, z2);
                if (a2 != null) {
                    C0217u.m985a(a3, obj, view, c01901, c0194b.f633d, c0194b.f632c, (Map) c0194b.f630a, arrayList2, map, c0270a, arrayList3);
                    m838a(view, c0194b, i, a2);
                    C0217u.m984a(a2, c0194b.f633d, true);
                    m827a(c0194b, i, a2);
                    C0217u.m981a((ViewGroup) view, a2);
                    C0217u.m980a(view, c0194b.f633d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0194b.f631b, c0270a);
                }
                if (a2 == null) {
                    return true;
                }
                return false;
            }
            as asVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
            if (asVar != null) {
                asVar.m776a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
            }
            m830a(c0194b, view, a4, fragment, fragment2, z, arrayList3);
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0196h.m825a(b, fragment2, arrayList, (C0270a) map, c0194b.f633d);
        view2 = (View) map.get(this.f656v.get(0));
        if (view2 != null) {
            if (a != null) {
                C0217u.m982a(a, view2);
            }
            if (obj != null) {
                C0217u.m982a(obj, view2);
            }
        }
        c01901 = /* anonymous class already generated */;
        arrayList2 = new ArrayList();
        c0270a = new C0270a();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        a2 = C0217u.m977a(a3, a, obj, z2);
        if (a2 != null) {
            C0217u.m985a(a3, obj, view, c01901, c0194b.f633d, c0194b.f632c, (Map) c0194b.f630a, arrayList2, map, c0270a, arrayList3);
            m838a(view, c0194b, i, a2);
            C0217u.m984a(a2, c0194b.f633d, true);
            m827a(c0194b, i, a2);
            C0217u.m981a((ViewGroup) view, a2);
            C0217u.m980a(view, c0194b.f633d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0194b.f631b, c0270a);
        }
        if (a2 == null) {
            return false;
        }
        return true;
    }

    private void m830a(C0194b c0194b, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        final View view2 = view;
        final Object obj2 = obj;
        final ArrayList<View> arrayList2 = arrayList;
        final C0194b c0194b2 = c0194b;
        final boolean z2 = z;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ C0196h f615h;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj2 != null) {
                    C0217u.m986a(obj2, arrayList2);
                    arrayList2.clear();
                    C0270a a = this.f615h.m820a(c0194b2, z2, fragment3);
                    C0217u.m983a(obj2, c0194b2.f633d, (Map) a, arrayList2);
                    this.f615h.m835a(a, c0194b2);
                    this.f615h.m828a(c0194b2, fragment3, fragment4, z2, a);
                }
                return true;
            }
        });
    }

    private void m828a(C0194b c0194b, Fragment fragment, Fragment fragment2, boolean z, C0270a<String, View> c0270a) {
        as asVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (asVar != null) {
            asVar.m778b(new ArrayList(c0270a.keySet()), new ArrayList(c0270a.values()), null);
        }
    }

    private void m835a(C0270a<String, View> c0270a, C0194b c0194b) {
        if (this.f656v != null && !c0270a.isEmpty()) {
            View view = (View) c0270a.get(this.f656v.get(0));
            if (view != null) {
                c0194b.f632c.f723a = view;
            }
        }
    }

    private C0270a<String, View> m820a(C0194b c0194b, boolean z, Fragment fragment) {
        C0270a b = m840b(c0194b, fragment, z);
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.m777a(this.f656v, (Map) b);
            }
            m829a(c0194b, b, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.m777a(this.f656v, (Map) b);
            }
            m842b(c0194b, b, true);
        }
        return b;
    }

    private static C0270a<String, View> m822a(ArrayList<String> arrayList, ArrayList<String> arrayList2, C0270a<String, View> c0270a) {
        if (c0270a.isEmpty()) {
            return c0270a;
        }
        C0270a<String, View> c0270a2 = new C0270a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0270a.get(arrayList.get(i));
            if (view != null) {
                c0270a2.put(arrayList2.get(i), view);
            }
        }
        return c0270a2;
    }

    private C0270a<String, View> m840b(C0194b c0194b, Fragment fragment, boolean z) {
        C0270a c0270a = new C0270a();
        View view = fragment.getView();
        if (view == null || this.f655u == null) {
            return c0270a;
        }
        C0217u.m989a((Map) c0270a, view);
        if (z) {
            return C0196h.m822a(this.f655u, this.f656v, c0270a);
        }
        c0270a.m1153a(this.f656v);
        return c0270a;
    }

    private void m838a(View view, C0194b c0194b, int i, Object obj) {
        final View view2 = view;
        final C0194b c0194b2 = c0194b;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ C0196h f620e;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f620e.m827a(c0194b2, i2, obj2);
                return true;
            }
        });
    }

    private void m827a(C0194b c0194b, int i, Object obj) {
        if (this.f636b.f683g != null) {
            for (int i2 = 0; i2 < this.f636b.f683g.size(); i2++) {
                Fragment fragment = (Fragment) this.f636b.f683g.get(i2);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != i)) {
                    if (!fragment.mHidden) {
                        C0217u.m984a(obj, fragment.mView, false);
                        c0194b.f631b.remove(fragment.mView);
                    } else if (!c0194b.f631b.contains(fragment.mView)) {
                        C0217u.m984a(obj, fragment.mView, true);
                        c0194b.f631b.add(fragment.mView);
                    }
                }
            }
        }
    }

    private static void m836a(C0270a<String, String> c0270a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0270a.size(); i++) {
                if (str.equals(c0270a.m1150c(i))) {
                    c0270a.m1145a(i, (Object) str2);
                    return;
                }
            }
            c0270a.put(str, str2);
        }
    }

    private static void m831a(C0194b c0194b, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0196h.m836a(c0194b.f630a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m829a(C0194b c0194b, C0270a<String, View> c0270a, boolean z) {
        int size = this.f656v == null ? 0 : this.f656v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f655u.get(i);
            View view = (View) c0270a.get((String) this.f656v.get(i));
            if (view != null) {
                String a = C0217u.m978a(view);
                if (z) {
                    C0196h.m836a(c0194b.f630a, str, a);
                } else {
                    C0196h.m836a(c0194b.f630a, a, str);
                }
            }
        }
    }

    private void m842b(C0194b c0194b, C0270a<String, View> c0270a, boolean z) {
        int size = c0270a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0270a.m1149b(i);
            String a = C0217u.m978a((View) c0270a.m1150c(i));
            if (z) {
                C0196h.m836a(c0194b.f630a, str, a);
            } else {
                C0196h.m836a(c0194b.f630a, a, str);
            }
        }
    }
}
