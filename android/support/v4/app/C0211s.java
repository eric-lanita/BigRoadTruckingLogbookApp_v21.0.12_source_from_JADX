package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.C0196h.C0194b;
import android.support.v4.app.C0202r.C0201a;
import android.support.v4.p008d.C0272c;
import android.support.v4.p008d.C0273d;
import android.support.v4.view.C0210m;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class C0211s extends C0202r implements C0210m {
    static final Interpolator f672A = new DecelerateInterpolator(2.5f);
    static final Interpolator f673B = new DecelerateInterpolator(1.5f);
    static final Interpolator f674C = new AccelerateInterpolator(2.5f);
    static final Interpolator f675D = new AccelerateInterpolator(1.5f);
    static boolean f676a = false;
    static final boolean f677b;
    static Field f678r = null;
    ArrayList<Runnable> f679c;
    Runnable[] f680d;
    boolean f681e;
    ArrayList<Fragment> f682f;
    ArrayList<Fragment> f683g;
    ArrayList<Integer> f684h;
    ArrayList<C0196h> f685i;
    ArrayList<Fragment> f686j;
    ArrayList<C0196h> f687k;
    ArrayList<Integer> f688l;
    ArrayList<C0201a> f689m;
    int f690n = 0;
    C0111q f691o;
    C0107o f692p;
    Fragment f693q;
    boolean f694s;
    boolean f695t;
    boolean f696u;
    String f697v;
    boolean f698w;
    Bundle f699x = null;
    SparseArray<Parcelable> f700y = null;
    Runnable f701z = new C02031(this);

    class C02031 implements Runnable {
        final /* synthetic */ C0211s f660a;

        C02031(C0211s c0211s) {
            this.f660a = c0211s;
        }

        public void run() {
            this.f660a.m958e();
        }
    }

    static class C0205a implements AnimationListener {
        private AnimationListener f664a = null;
        private boolean f665b = false;
        private View f666c = null;

        class C02071 implements Runnable {
            final /* synthetic */ C0205a f669a;

            C02071(C0205a c0205a) {
                this.f669a = c0205a;
            }

            public void run() {
                ag.m1782a(this.f669a.f666c, 2, null);
            }
        }

        class C02082 implements Runnable {
            final /* synthetic */ C0205a f670a;

            C02082(C0205a c0205a) {
                this.f670a = c0205a;
            }

            public void run() {
                ag.m1782a(this.f670a.f666c, 0, null);
            }
        }

        public C0205a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f666c = view;
            }
        }

        public C0205a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f664a = animationListener;
                this.f666c = view;
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.f666c != null) {
                this.f665b = C0211s.m911a(this.f666c, animation);
                if (this.f665b) {
                    this.f666c.post(new C02071(this));
                }
            }
            if (this.f664a != null) {
                this.f664a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f666c != null && this.f665b) {
                this.f666c.post(new C02082(this));
            }
            if (this.f664a != null) {
                this.f664a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f664a != null) {
                this.f664a.onAnimationRepeat(animation);
            }
        }
    }

    static class C0209b {
        public static final int[] f671a = new int[]{16842755, 16842960, 16842961};
    }

    C0211s() {
    }

    static {
        boolean z = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f677b = z;
    }

    static boolean m912a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    static boolean m911a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ag.m1800d(view) == 0 && ag.m1816p(view) && C0211s.m912a(animation);
    }

    private void m910a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0273d("FragmentManager"));
        if (this.f691o != null) {
            try {
                this.f691o.mo89a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo153a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public C0195t mo150a() {
        return new C0196h(this);
    }

    public boolean mo154b() {
        return m958e();
    }

    public boolean mo155c() {
        m916u();
        mo154b();
        return m938a(this.f691o.m538j(), null, -1, 0);
    }

    public void mo152a(final int i, final int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        m936a(new Runnable(this) {
            final /* synthetic */ C0211s f663c;

            public void run() {
                this.f663c.m938a(this.f663c.f691o.m538j(), null, i, i2);
            }
        }, false);
    }

    public void m929a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            m910a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public Fragment m919a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f682f.size()) {
            m910a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = (Fragment) this.f682f.get(i);
        if (fragment != null) {
            return fragment;
        }
        m910a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return fragment;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f693q != null) {
            C0272c.m1160a(this.f693q, stringBuilder);
        } else {
            C0272c.m1160a(this.f691o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public void mo153a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        Fragment fragment;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f682f != null) {
            size = this.f682f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f682f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f683g != null) {
            size = this.f683g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f683g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f686j != null) {
            size = this.f686j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    fragment = (Fragment) this.f686j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.f685i != null) {
            size = this.f685i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0196h c0196h = (C0196h) this.f685i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0196h.toString());
                    c0196h.m855a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f687k != null) {
                int size2 = this.f687k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0196h = (C0196h) this.f687k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0196h);
                    }
                }
            }
            if (this.f688l != null && this.f688l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f688l.toArray()));
            }
        }
        if (this.f679c != null) {
            i = this.f679c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f679c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f691o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f692p);
        if (this.f693q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f693q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f690n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f695t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f696u);
        if (this.f694s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f694s);
        }
        if (this.f697v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f697v);
        }
        if (this.f684h != null && this.f684h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f684h.toArray()));
        }
    }

    static Animation m909a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f672A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f673B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    static Animation m908a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f673B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    Animation m923a(Fragment fragment, int i, boolean z, int i2) {
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, fragment.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.mNextAnim != 0) {
            onCreateAnimation = AnimationUtils.loadAnimation(this.f691o.m537i(), fragment.mNextAnim);
            if (onCreateAnimation != null) {
                return onCreateAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0211s.m913b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return C0211s.m909a(this.f691o.m537i(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return C0211s.m909a(this.f691o.m537i(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return C0211s.m909a(this.f691o.m537i(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return C0211s.m909a(this.f691o.m537i(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return C0211s.m908a(this.f691o.m537i(), 0.0f, 1.0f);
            case 6:
                return C0211s.m908a(this.f691o.m537i(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f691o.mo95e()) {
                    i2 = this.f691o.mo96f();
                }
                if (i2 == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m931a(Fragment fragment) {
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.f681e) {
            this.f698w = true;
            return;
        }
        fragment.mDeferStart = false;
        m933a(fragment, this.f690n, 0, 0, false);
    }

    private void m914b(View view, Animation animation) {
        if (view != null && animation != null && C0211s.m911a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f678r == null) {
                    f678r = Animation.class.getDeclaredField("mListener");
                    f678r.setAccessible(true);
                }
                animationListener = (AnimationListener) f678r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            animation.setAnimationListener(new C0205a(view, animation, animationListener));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m933a(final android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r5 = 1;
        r3 = 0;
        r7 = 0;
        r0 = r11.mAdded;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.mDetached;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.mRemoving;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.mState;
    L_0x001a:
        r0 = r11.mDeferStart;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.mState;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.mState;
        if (r0 >= r12) goto L_0x02aa;
    L_0x0029:
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.mInLayout;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.mAnimatingAway = r7;
        r2 = r11.mStateAfterAnimating;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m933a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x0247;
            case 3: goto L_0x0247;
            case 4: goto L_0x0268;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.mState;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.mState;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.mState = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f676a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.mSavedFragmentState;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.mSavedFragmentState;
        r1 = r10.f691o;
        r1 = r1.m537i();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.mSavedViewState = r0;
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r10.m919a(r0, r1);
        r11.mTarget = r0;
        r0 = r11.mTarget;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.mTargetRequestCode = r0;
    L_0x00d1:
        r0 = r11.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.mUserVisibleHint = r0;
        r0 = r11.mUserVisibleHint;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.mDeferStart = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f691o;
        r11.mHost = r0;
        r0 = r10.f693q;
        r11.mParentFragment = r0;
        r0 = r10.f693q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f693q;
        r0 = r0.mChildFragmentManager;
    L_0x00f4:
        r11.mFragmentManager = r0;
        r11.mCalled = r3;
        r0 = r10.f691o;
        r0 = r0.m537i();
        r11.onAttach(r0);
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f691o;
        r0 = r0.m539k();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.mParentFragment;
        if (r0 != 0) goto L_0x0134;
    L_0x012f:
        r0 = r10.f691o;
        r0.mo93b(r11);
    L_0x0134:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x013d;
    L_0x0138:
        r0 = r11.mSavedFragmentState;
        r11.performCreate(r0);
    L_0x013d:
        r11.mRetaining = r3;
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.mSavedFragmentState;
        r0 = r11.getLayoutInflater(r0);
        r1 = r11.mSavedFragmentState;
        r0 = r11.performCreateView(r0, r7, r1);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0299;
    L_0x0155:
        r0 = r11.mView;
        r11.mInnerView = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x028f;
    L_0x015f:
        r0 = r11.mView;
        android.support.v4.view.ag.m1789a(r0, r3);
    L_0x0164:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x0247;
    L_0x0178:
        r0 = f676a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.mFromLayout;
        if (r0 != 0) goto L_0x0237;
    L_0x0198:
        r0 = r11.mContainerId;
        if (r0 == 0) goto L_0x0408;
    L_0x019c:
        r0 = r10.f692p;
        r1 = r11.mContainerId;
        r0 = r0.mo85a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x01eb;
    L_0x01a8:
        r1 = r11.mRestored;
        if (r1 != 0) goto L_0x01eb;
    L_0x01ac:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "No view found for id 0x";
        r2 = r2.append(r4);
        r4 = r11.mContainerId;
        r4 = java.lang.Integer.toHexString(r4);
        r2 = r2.append(r4);
        r4 = " (";
        r2 = r2.append(r4);
        r4 = r11.getResources();
        r8 = r11.mContainerId;
        r4 = r4.getResourceName(r8);
        r2 = r2.append(r4);
        r4 = ") for fragment ";
        r2 = r2.append(r4);
        r2 = r2.append(r11);
        r2 = r2.toString();
        r1.<init>(r2);
        r10.m910a(r1);
    L_0x01eb:
        r11.mContainer = r0;
        r1 = r11.mSavedFragmentState;
        r1 = r11.getLayoutInflater(r1);
        r2 = r11.mSavedFragmentState;
        r1 = r11.performCreateView(r1, r0, r2);
        r11.mView = r1;
        r1 = r11.mView;
        if (r1 == 0) goto L_0x02a7;
    L_0x01ff:
        r1 = r11.mView;
        r11.mInnerView = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x029d;
    L_0x0209:
        r1 = r11.mView;
        android.support.v4.view.ag.m1789a(r1, r3);
    L_0x020e:
        if (r0 == 0) goto L_0x0225;
    L_0x0210:
        r1 = r10.m923a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0220;
    L_0x0216:
        r2 = r11.mView;
        r10.m914b(r2, r1);
        r2 = r11.mView;
        r2.startAnimation(r1);
    L_0x0220:
        r1 = r11.mView;
        r0.addView(r1);
    L_0x0225:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x0230;
    L_0x0229:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0230:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x0237:
        r0 = r11.mSavedFragmentState;
        r11.performActivityCreated(r0);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0245;
    L_0x0240:
        r0 = r11.mSavedFragmentState;
        r11.restoreViewState(r0);
    L_0x0245:
        r11.mSavedFragmentState = r7;
    L_0x0247:
        if (r12 <= r6) goto L_0x0268;
    L_0x0249:
        r0 = f676a;
        if (r0 == 0) goto L_0x0265;
    L_0x024d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0265:
        r11.performStart();
    L_0x0268:
        if (r12 <= r9) goto L_0x0045;
    L_0x026a:
        r0 = f676a;
        if (r0 == 0) goto L_0x0286;
    L_0x026e:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0286:
        r11.performResume();
        r11.mSavedFragmentState = r7;
        r11.mSavedViewState = r7;
        goto L_0x0045;
    L_0x028f:
        r0 = r11.mView;
        r0 = android.support.v4.app.aa.m596a(r0);
        r11.mView = r0;
        goto L_0x0164;
    L_0x0299:
        r11.mInnerView = r7;
        goto L_0x0176;
    L_0x029d:
        r1 = r11.mView;
        r1 = android.support.v4.app.aa.m596a(r1);
        r11.mView = r1;
        goto L_0x020e;
    L_0x02a7:
        r11.mInnerView = r7;
        goto L_0x0237;
    L_0x02aa:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ae:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x02b5;
            case 2: goto L_0x0333;
            case 3: goto L_0x0312;
            case 4: goto L_0x02f1;
            case 5: goto L_0x02cf;
            default: goto L_0x02b3;
        };
    L_0x02b3:
        goto L_0x0045;
    L_0x02b5:
        if (r12 >= r5) goto L_0x0045;
    L_0x02b7:
        r0 = r10.f696u;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bb:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x02c6;
    L_0x02bf:
        r0 = r11.mAnimatingAway;
        r11.mAnimatingAway = r7;
        r0.clearAnimation();
    L_0x02c6:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x03a2;
    L_0x02ca:
        r11.mStateAfterAnimating = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x02cf:
        r0 = 5;
        if (r12 >= r0) goto L_0x02f1;
    L_0x02d2:
        r0 = f676a;
        if (r0 == 0) goto L_0x02ee;
    L_0x02d6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02ee:
        r11.performPause();
    L_0x02f1:
        if (r12 >= r9) goto L_0x0312;
    L_0x02f3:
        r0 = f676a;
        if (r0 == 0) goto L_0x030f;
    L_0x02f7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030f:
        r11.performStop();
    L_0x0312:
        if (r12 >= r6) goto L_0x0333;
    L_0x0314:
        r0 = f676a;
        if (r0 == 0) goto L_0x0330;
    L_0x0318:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0330:
        r11.performReallyStop();
    L_0x0333:
        r0 = 2;
        if (r12 >= r0) goto L_0x02b5;
    L_0x0336:
        r0 = f676a;
        if (r0 == 0) goto L_0x0352;
    L_0x033a:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0352:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0365;
    L_0x0356:
        r0 = r10.f691o;
        r0 = r0.mo90a(r11);
        if (r0 == 0) goto L_0x0365;
    L_0x035e:
        r0 = r11.mSavedViewState;
        if (r0 != 0) goto L_0x0365;
    L_0x0362:
        r10.m956e(r11);
    L_0x0365:
        r11.performDestroyView();
        r0 = r11.mView;
        if (r0 == 0) goto L_0x039a;
    L_0x036c:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x039a;
    L_0x0370:
        r0 = r10.f690n;
        if (r0 <= 0) goto L_0x0405;
    L_0x0374:
        r0 = r10.f696u;
        if (r0 != 0) goto L_0x0405;
    L_0x0378:
        r0 = r10.m923a(r11, r13, r3, r14);
    L_0x037c:
        if (r0 == 0) goto L_0x0393;
    L_0x037e:
        r1 = r11.mView;
        r11.mAnimatingAway = r1;
        r11.mStateAfterAnimating = r12;
        r1 = r11.mView;
        r2 = new android.support.v4.app.s$3;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.mView;
        r1.startAnimation(r0);
    L_0x0393:
        r0 = r11.mContainer;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x039a:
        r11.mContainer = r7;
        r11.mView = r7;
        r11.mInnerView = r7;
        goto L_0x02b5;
    L_0x03a2:
        r0 = f676a;
        if (r0 == 0) goto L_0x03be;
    L_0x03a6:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03be:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x03ed;
    L_0x03c2:
        r11.performDestroy();
    L_0x03c5:
        r11.mCalled = r3;
        r11.onDetach();
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x03f0;
    L_0x03ce:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03ed:
        r11.mState = r3;
        goto L_0x03c5;
    L_0x03f0:
        if (r15 != 0) goto L_0x0045;
    L_0x03f2:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x03fb;
    L_0x03f6:
        r10.m954d(r11);
        goto L_0x0045;
    L_0x03fb:
        r11.mHost = r7;
        r11.mParentFragment = r7;
        r11.mFragmentManager = r7;
        r11.mChildFragmentManager = r7;
        goto L_0x0045;
    L_0x0405:
        r0 = r7;
        goto L_0x037c;
    L_0x0408:
        r0 = r7;
        goto L_0x01eb;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.s.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m944b(Fragment fragment) {
        m933a(fragment, this.f690n, 0, 0, false);
    }

    void m927a(int i, boolean z) {
        m925a(i, 0, 0, z);
    }

    void m925a(int i, int i2, int i3, boolean z) {
        if (this.f691o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f690n != i) {
            this.f690n = i;
            if (this.f682f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f682f.size()) {
                    int a;
                    Fragment fragment = (Fragment) this.f682f.get(i4);
                    if (fragment != null) {
                        m933a(fragment, i, i2, i3, false);
                        if (fragment.mLoaderManager != null) {
                            a = i5 | fragment.mLoaderManager.mo159a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m953d();
                }
                if (this.f694s && this.f691o != null && this.f690n == 5) {
                    this.f691o.mo94d();
                    this.f694s = false;
                }
            }
        }
    }

    void m953d() {
        if (this.f682f != null) {
            for (int i = 0; i < this.f682f.size(); i++) {
                Fragment fragment = (Fragment) this.f682f.get(i);
                if (fragment != null) {
                    m931a(fragment);
                }
            }
        }
    }

    void m950c(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.f684h == null || this.f684h.size() <= 0) {
                if (this.f682f == null) {
                    this.f682f = new ArrayList();
                }
                fragment.setIndex(this.f682f.size(), this.f693q);
                this.f682f.add(fragment);
            } else {
                fragment.setIndex(((Integer) this.f684h.remove(this.f684h.size() - 1)).intValue(), this.f693q);
                this.f682f.set(fragment.mIndex, fragment);
            }
            if (f676a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void m954d(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (f676a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f682f.set(fragment.mIndex, null);
            if (this.f684h == null) {
                this.f684h = new ArrayList();
            }
            this.f684h.add(Integer.valueOf(fragment.mIndex));
            this.f691o.m530b(fragment.mWho);
            fragment.initState();
        }
    }

    public void m934a(Fragment fragment, boolean z) {
        if (this.f683g == null) {
            this.f683g = new ArrayList();
        }
        if (f676a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m950c(fragment);
        if (!fragment.mDetached) {
            if (this.f683g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f683g.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f694s = true;
            }
            if (z) {
                m944b(fragment);
            }
        }
    }

    public void m932a(Fragment fragment, int i, int i2) {
        if (f676a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            int i3;
            if (this.f683g != null) {
                this.f683g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f694s = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            if (z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            m933a(fragment, i3, i, i2, false);
        }
    }

    public void m945b(Fragment fragment, int i, int i2) {
        if (f676a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation a = m923a(fragment, i, false, i2);
                if (a != null) {
                    m914b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f694s = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public void m951c(Fragment fragment, int i, int i2) {
        if (f676a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation a = m923a(fragment, i, true, i2);
                if (a != null) {
                    m914b(fragment.mView, a);
                    fragment.mView.startAnimation(a);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f694s = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public void m955d(Fragment fragment, int i, int i2) {
        if (f676a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.f683g != null) {
                    if (f676a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f683g.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f694s = true;
                }
                fragment.mAdded = false;
                m933a(fragment, 1, i, i2, false);
            }
        }
    }

    public void m957e(Fragment fragment, int i, int i2) {
        if (f676a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.f683g == null) {
                    this.f683g = new ArrayList();
                }
                if (this.f683g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f676a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f683g.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f694s = true;
                }
                m933a(fragment, this.f690n, i, i2, false);
            }
        }
    }

    public Fragment mo148a(int i) {
        int size;
        Fragment fragment;
        if (this.f683g != null) {
            for (size = this.f683g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f683g.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.f682f != null) {
            for (size = this.f682f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f682f.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment mo149a(String str) {
        int size;
        Fragment fragment;
        if (!(this.f683g == null || str == null)) {
            for (size = this.f683g.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f683g.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.f682f == null || str == null)) {
            for (size = this.f682f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f682f.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public Fragment m942b(String str) {
        if (!(this.f682f == null || str == null)) {
            for (int size = this.f682f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f682f.get(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void m916u() {
        if (this.f695t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f697v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f697v);
        }
    }

    public void m936a(Runnable runnable, boolean z) {
        if (!z) {
            m916u();
        }
        synchronized (this) {
            if (this.f696u || this.f691o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f679c == null) {
                this.f679c = new ArrayList();
            }
            this.f679c.add(runnable);
            if (this.f679c.size() == 1) {
                this.f691o.m538j().removeCallbacks(this.f701z);
                this.f691o.m538j().post(this.f701z);
            }
        }
    }

    public int m917a(C0196h c0196h) {
        int size;
        synchronized (this) {
            if (this.f688l == null || this.f688l.size() <= 0) {
                if (this.f687k == null) {
                    this.f687k = new ArrayList();
                }
                size = this.f687k.size();
                if (f676a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0196h);
                }
                this.f687k.add(c0196h);
            } else {
                size = ((Integer) this.f688l.remove(this.f688l.size() - 1)).intValue();
                if (f676a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0196h);
                }
                this.f687k.set(size, c0196h);
            }
        }
        return size;
    }

    public void m926a(int i, C0196h c0196h) {
        synchronized (this) {
            if (this.f687k == null) {
                this.f687k = new ArrayList();
            }
            int size = this.f687k.size();
            if (i < size) {
                if (f676a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0196h);
                }
                this.f687k.set(i, c0196h);
            } else {
                while (size < i) {
                    this.f687k.add(null);
                    if (this.f688l == null) {
                        this.f688l = new ArrayList();
                    }
                    if (f676a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f688l.add(Integer.valueOf(size));
                    size++;
                }
                if (f676a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0196h);
                }
                this.f687k.add(c0196h);
            }
        }
    }

    public void m943b(int i) {
        synchronized (this) {
            this.f687k.set(i, null);
            if (this.f688l == null) {
                this.f688l = new ArrayList();
            }
            if (f676a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f688l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m958e() {
        /*
        r6 = this;
        r0 = 1;
        r2 = 0;
        r1 = r6.f681e;
        if (r1 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "Recursive entry to executePendingTransactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r1 = android.os.Looper.myLooper();
        r3 = r6.f691o;
        r3 = r3.m538j();
        r3 = r3.getLooper();
        if (r1 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of process";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r1 = r2;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f679c;	 Catch:{ all -> 0x009b }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f679c;	 Catch:{ all -> 0x009b }
        r3 = r3.size();	 Catch:{ all -> 0x009b }
        if (r3 != 0) goto L_0x005c;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r0 = r6.f698w;
        if (r0 == 0) goto L_0x00a9;
    L_0x0039:
        r3 = r2;
        r4 = r2;
    L_0x003b:
        r0 = r6.f682f;
        r0 = r0.size();
        if (r3 >= r0) goto L_0x00a2;
    L_0x0043:
        r0 = r6.f682f;
        r0 = r0.get(r3);
        r0 = (android.support.v4.app.Fragment) r0;
        if (r0 == 0) goto L_0x0058;
    L_0x004d:
        r5 = r0.mLoaderManager;
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r0 = r0.mLoaderManager;
        r0 = r0.mo159a();
        r4 = r4 | r0;
    L_0x0058:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x003b;
    L_0x005c:
        r1 = r6.f679c;	 Catch:{ all -> 0x009b }
        r3 = r1.size();	 Catch:{ all -> 0x009b }
        r1 = r6.f680d;	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r1 = r6.f680d;	 Catch:{ all -> 0x009b }
        r1 = r1.length;	 Catch:{ all -> 0x009b }
        if (r1 >= r3) goto L_0x006f;
    L_0x006b:
        r1 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x009b }
        r6.f680d = r1;	 Catch:{ all -> 0x009b }
    L_0x006f:
        r1 = r6.f679c;	 Catch:{ all -> 0x009b }
        r4 = r6.f680d;	 Catch:{ all -> 0x009b }
        r1.toArray(r4);	 Catch:{ all -> 0x009b }
        r1 = r6.f679c;	 Catch:{ all -> 0x009b }
        r1.clear();	 Catch:{ all -> 0x009b }
        r1 = r6.f691o;	 Catch:{ all -> 0x009b }
        r1 = r1.m538j();	 Catch:{ all -> 0x009b }
        r4 = r6.f701z;	 Catch:{ all -> 0x009b }
        r1.removeCallbacks(r4);	 Catch:{ all -> 0x009b }
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        r6.f681e = r0;
        r1 = r2;
    L_0x008a:
        if (r1 >= r3) goto L_0x009e;
    L_0x008c:
        r4 = r6.f680d;
        r4 = r4[r1];
        r4.run();
        r4 = r6.f680d;
        r5 = 0;
        r4[r1] = r5;
        r1 = r1 + 1;
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r6.f681e = r2;
        r1 = r0;
        goto L_0x0027;
    L_0x00a2:
        if (r4 != 0) goto L_0x00a9;
    L_0x00a4:
        r6.f698w = r2;
        r6.m953d();
    L_0x00a9:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.s.e():boolean");
    }

    void m960f() {
        if (this.f689m != null) {
            for (int i = 0; i < this.f689m.size(); i++) {
                ((C0201a) this.f689m.get(i)).m898a();
            }
        }
    }

    void m946b(C0196h c0196h) {
        if (this.f685i == null) {
            this.f685i = new ArrayList();
        }
        this.f685i.add(c0196h);
        m960f();
    }

    boolean m938a(Handler handler, String str, int i, int i2) {
        if (this.f685i == null) {
            return false;
        }
        int size;
        C0196h c0196h;
        if (str == null && i < 0 && (i2 & 1) == 0) {
            size = this.f685i.size() - 1;
            if (size < 0) {
                return false;
            }
            c0196h = (C0196h) this.f685i.remove(size);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            c0196h.m854a(sparseArray, sparseArray2);
            c0196h.m847a(true, null, sparseArray, sparseArray2);
            m960f();
        } else {
            int size2;
            size = -1;
            if (str != null || i >= 0) {
                size2 = this.f685i.size() - 1;
                while (size2 >= 0) {
                    c0196h = (C0196h) this.f685i.get(size2);
                    if ((str != null && str.equals(c0196h.m861c())) || (i >= 0 && i == c0196h.f650p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        c0196h = (C0196h) this.f685i.get(size2);
                        if ((str == null || !str.equals(c0196h.m861c())) && (i < 0 || i != c0196h.f650p)) {
                            break;
                        }
                        size2--;
                    }
                }
                size = size2;
            }
            if (size == this.f685i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (size2 = this.f685i.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f685i.remove(size2));
            }
            int size3 = arrayList.size() - 1;
            SparseArray sparseArray3 = new SparseArray();
            SparseArray sparseArray4 = new SparseArray();
            for (size2 = 0; size2 <= size3; size2++) {
                ((C0196h) arrayList.get(size2)).m854a(sparseArray3, sparseArray4);
            }
            C0194b c0194b = null;
            int i3 = 0;
            while (i3 <= size3) {
                boolean z;
                if (f676a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i3));
                }
                c0196h = (C0196h) arrayList.get(i3);
                if (i3 == size3) {
                    z = true;
                } else {
                    z = false;
                }
                i3++;
                c0194b = c0196h.m847a(z, c0194b, sparseArray3, sparseArray4);
            }
            m960f();
        }
        return true;
    }

    ArrayList<Fragment> m961g() {
        ArrayList<Fragment> arrayList = null;
        if (this.f682f != null) {
            for (int i = 0; i < this.f682f.size(); i++) {
                Fragment fragment = (Fragment) this.f682f.get(i);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (f676a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
            }
        }
        return arrayList;
    }

    void m956e(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.f700y == null) {
                this.f700y = new SparseArray();
            } else {
                this.f700y.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.f700y);
            if (this.f700y.size() > 0) {
                fragment.mSavedViewState = this.f700y;
                this.f700y = null;
            }
        }
    }

    Bundle m959f(Fragment fragment) {
        Bundle bundle;
        if (this.f699x == null) {
            this.f699x = new Bundle();
        }
        fragment.performSaveInstanceState(this.f699x);
        if (this.f699x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f699x;
            this.f699x = null;
        }
        if (fragment.mView != null) {
            m956e(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    Parcelable m962h() {
        BackStackState[] backStackStateArr = null;
        m958e();
        if (f677b) {
            this.f695t = true;
        }
        if (this.f682f == null || this.f682f.size() <= 0) {
            return null;
        }
        int size = this.f682f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            Fragment fragment = (Fragment) this.f682f.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    m910a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState <= 0 || fragmentState.f463j != null) {
                    fragmentState.f463j = fragment.mSavedFragmentState;
                } else {
                    fragmentState.f463j = m959f(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            m910a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.f463j == null) {
                            fragmentState.f463j = new Bundle();
                        }
                        m929a(fragmentState.f463j, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.f463j.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                }
                if (f676a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f463j);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            FragmentManagerState fragmentManagerState;
            if (this.f683g != null) {
                i = this.f683g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((Fragment) this.f683g.get(i2)).mIndex;
                        if (iArr[i2] < 0) {
                            m910a(new IllegalStateException("Failure saving state: active " + this.f683g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f676a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f683g.get(i2));
                        }
                    }
                    if (this.f685i != null) {
                        i = this.f685i.size();
                        if (i > 0) {
                            backStackStateArr = new BackStackState[i];
                            for (i2 = 0; i2 < i; i2++) {
                                backStackStateArr[i2] = new BackStackState((C0196h) this.f685i.get(i2));
                                if (f676a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f685i.get(i2));
                                }
                            }
                        }
                    }
                    fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.f451a = fragmentStateArr;
                    fragmentManagerState.f452b = iArr;
                    fragmentManagerState.f453c = backStackStateArr;
                    return fragmentManagerState;
                }
            }
            iArr = null;
            if (this.f685i != null) {
                i = this.f685i.size();
                if (i > 0) {
                    backStackStateArr = new BackStackState[i];
                    for (i2 = 0; i2 < i; i2++) {
                        backStackStateArr[i2] = new BackStackState((C0196h) this.f685i.get(i2));
                        if (f676a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f685i.get(i2));
                        }
                    }
                }
            }
            fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f451a = fragmentStateArr;
            fragmentManagerState.f452b = iArr;
            fragmentManagerState.f453c = backStackStateArr;
            return fragmentManagerState;
        } else if (!f676a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m930a(Parcelable parcelable, List<Fragment> list) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f451a != null) {
                int i;
                Fragment fragment;
                int i2;
                if (list != null) {
                    for (i = 0; i < list.size(); i++) {
                        fragment = (Fragment) list.get(i);
                        if (f676a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f451a[fragment.mIndex];
                        fragmentState.f464k = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.f463j != null) {
                            fragmentState.f463j.setClassLoader(this.f691o.m537i().getClassLoader());
                            fragment.mSavedViewState = fragmentState.f463j.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.f463j;
                        }
                    }
                }
                this.f682f = new ArrayList(fragmentManagerState.f451a.length);
                if (this.f684h != null) {
                    this.f684h.clear();
                }
                for (i2 = 0; i2 < fragmentManagerState.f451a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f451a[i2];
                    if (fragmentState2 != null) {
                        Fragment a = fragmentState2.m564a(this.f691o, this.f693q);
                        if (f676a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a);
                        }
                        this.f682f.add(a);
                        fragmentState2.f464k = null;
                    } else {
                        this.f682f.add(null);
                        if (this.f684h == null) {
                            this.f684h = new ArrayList();
                        }
                        if (f676a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f684h.add(Integer.valueOf(i2));
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        fragment = (Fragment) list.get(i3);
                        if (fragment.mTargetIndex >= 0) {
                            if (fragment.mTargetIndex < this.f682f.size()) {
                                fragment.mTarget = (Fragment) this.f682f.get(fragment.mTargetIndex);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment + " target no longer exists: " + fragment.mTargetIndex);
                                fragment.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.f452b != null) {
                    this.f683g = new ArrayList(fragmentManagerState.f452b.length);
                    for (i = 0; i < fragmentManagerState.f452b.length; i++) {
                        fragment = (Fragment) this.f682f.get(fragmentManagerState.f452b[i]);
                        if (fragment == null) {
                            m910a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f452b[i]));
                        }
                        fragment.mAdded = true;
                        if (f676a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + fragment);
                        }
                        if (this.f683g.contains(fragment)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f683g.add(fragment);
                    }
                } else {
                    this.f683g = null;
                }
                if (fragmentManagerState.f453c != null) {
                    this.f685i = new ArrayList(fragmentManagerState.f453c.length);
                    for (i2 = 0; i2 < fragmentManagerState.f453c.length; i2++) {
                        C0196h a2 = fragmentManagerState.f453c[i2].m511a(this);
                        if (f676a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a2.f650p + "): " + a2);
                            a2.m856a("  ", new PrintWriter(new C0273d("FragmentManager")), false);
                        }
                        this.f685i.add(a2);
                        if (a2.f650p >= 0) {
                            m926a(a2.f650p, a2);
                        }
                    }
                    return;
                }
                this.f685i = null;
            }
        }
    }

    public void m935a(C0111q c0111q, C0107o c0107o, Fragment fragment) {
        if (this.f691o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f691o = c0111q;
        this.f692p = c0107o;
        this.f693q = fragment;
    }

    public void m963i() {
        this.f695t = false;
    }

    public void m964j() {
        this.f695t = false;
        m927a(1, false);
    }

    public void m965k() {
        this.f695t = false;
        m927a(2, false);
    }

    public void m966l() {
        this.f695t = false;
        m927a(4, false);
    }

    public void m967m() {
        this.f695t = false;
        m927a(5, false);
    }

    public void m968n() {
        m927a(4, false);
    }

    public void m969o() {
        this.f695t = true;
        m927a(3, false);
    }

    public void m970p() {
        m927a(2, false);
    }

    public void m971q() {
        m927a(1, false);
    }

    public void m972r() {
        this.f696u = true;
        m958e();
        m927a(0, false);
        this.f691o = null;
        this.f692p = null;
        this.f693q = null;
    }

    public void m928a(Configuration configuration) {
        if (this.f683g != null) {
            for (int i = 0; i < this.f683g.size(); i++) {
                Fragment fragment = (Fragment) this.f683g.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }

    public void m973s() {
        if (this.f683g != null) {
            for (int i = 0; i < this.f683g.size(); i++) {
                Fragment fragment = (Fragment) this.f683g.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    public boolean m940a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        Fragment fragment;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f683g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f683g.size()) {
                fragment = (Fragment) this.f683g.get(i2);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f686j != null) {
            while (i < this.f686j.size()) {
                fragment = (Fragment) this.f686j.get(i);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.f686j = arrayList;
        return z;
    }

    public boolean m939a(Menu menu) {
        if (this.f683g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f683g.size(); i++) {
            Fragment fragment = (Fragment) this.f683g.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m941a(MenuItem menuItem) {
        if (this.f683g == null) {
            return false;
        }
        for (int i = 0; i < this.f683g.size(); i++) {
            Fragment fragment = (Fragment) this.f683g.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean m949b(MenuItem menuItem) {
        if (this.f683g == null) {
            return false;
        }
        for (int i = 0; i < this.f683g.size(); i++) {
            Fragment fragment = (Fragment) this.f683g.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m947b(Menu menu) {
        if (this.f683g != null) {
            for (int i = 0; i < this.f683g.size(); i++) {
                Fragment fragment = (Fragment) this.f683g.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public static int m915c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m913b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    public View mo151a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String string;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0209b.f671a);
        if (attributeValue == null) {
            string = obtainStyledAttributes.getString(0);
        } else {
            string = attributeValue;
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.f691o.m537i(), string)) {
            return null;
        }
        int id;
        if (view != null) {
            id = view.getId();
        } else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? mo148a(resourceId) : null;
        if (a == null && string2 != null) {
            a = mo149a(string2);
        }
        if (a == null && id != -1) {
            a = mo148a(id);
        }
        if (f676a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a);
        }
        if (a == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.f691o;
            instantiate.onInflate(this.f691o.m537i(), attributeSet, instantiate.mSavedFragmentState);
            m934a(instantiate, true);
            fragment = instantiate;
        } else if (a.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            a.mInLayout = true;
            a.mHost = this.f691o;
            if (!a.mRetaining) {
                a.onInflate(this.f691o.m537i(), attributeSet, a.mSavedFragmentState);
            }
            fragment = a;
        }
        if (this.f690n >= 1 || !fragment.mFromLayout) {
            m944b(fragment);
        } else {
            m933a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    C0210m m974t() {
        return this;
    }
}
