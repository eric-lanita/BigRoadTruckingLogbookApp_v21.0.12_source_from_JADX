package android.support.constraint;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.C0027c.C0026a;
import android.support.constraint.C0032f.C0031b;
import android.support.constraint.ConstraintLayout.C0022a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class C0025b {
    private static final int[] f216a = new int[]{0, 4, 8};
    private static SparseIntArray f217c = new SparseIntArray();
    private HashMap<Integer, C0024a> f218b = new HashMap();

    private static class C0024a {
        public int f164A;
        public int f165B;
        public int f166C;
        public int f167D;
        public int f168E;
        public int f169F;
        public int f170G;
        public int f171H;
        public int f172I;
        public int f173J;
        public int f174K;
        public int f175L;
        public int f176M;
        public int f177N;
        public int f178O;
        public int f179P;
        public float f180Q;
        public float f181R;
        public int f182S;
        public int f183T;
        public float f184U;
        public boolean f185V;
        public float f186W;
        public float f187X;
        public float f188Y;
        public float f189Z;
        boolean f190a;
        public float aa;
        public float ab;
        public float ac;
        public float ad;
        public float ae;
        public float af;
        public float ag;
        public boolean ah;
        public boolean ai;
        public int aj;
        public int ak;
        public int al;
        public int am;
        public int an;
        public int ao;
        public int ap;
        public int aq;
        public int[] ar;
        public int f191b;
        public int f192c;
        int f193d;
        public int f194e;
        public int f195f;
        public float f196g;
        public int f197h;
        public int f198i;
        public int f199j;
        public int f200k;
        public int f201l;
        public int f202m;
        public int f203n;
        public int f204o;
        public int f205p;
        public int f206q;
        public int f207r;
        public int f208s;
        public int f209t;
        public float f210u;
        public float f211v;
        public String f212w;
        public int f213x;
        public int f214y;
        public float f215z;

        private C0024a() {
            this.f190a = false;
            this.f194e = -1;
            this.f195f = -1;
            this.f196g = GroundOverlayOptions.NO_DIMENSION;
            this.f197h = -1;
            this.f198i = -1;
            this.f199j = -1;
            this.f200k = -1;
            this.f201l = -1;
            this.f202m = -1;
            this.f203n = -1;
            this.f204o = -1;
            this.f205p = -1;
            this.f206q = -1;
            this.f207r = -1;
            this.f208s = -1;
            this.f209t = -1;
            this.f210u = 0.5f;
            this.f211v = 0.5f;
            this.f212w = null;
            this.f213x = -1;
            this.f214y = 0;
            this.f215z = 0.0f;
            this.f164A = -1;
            this.f165B = -1;
            this.f166C = -1;
            this.f167D = -1;
            this.f168E = -1;
            this.f169F = -1;
            this.f170G = -1;
            this.f171H = -1;
            this.f172I = -1;
            this.f173J = 0;
            this.f174K = -1;
            this.f175L = -1;
            this.f176M = -1;
            this.f177N = -1;
            this.f178O = -1;
            this.f179P = -1;
            this.f180Q = 0.0f;
            this.f181R = 0.0f;
            this.f182S = 0;
            this.f183T = 0;
            this.f184U = 1.0f;
            this.f185V = false;
            this.f186W = 0.0f;
            this.f187X = 0.0f;
            this.f188Y = 0.0f;
            this.f189Z = 0.0f;
            this.aa = 1.0f;
            this.ab = 1.0f;
            this.ac = 0.0f;
            this.ad = 0.0f;
            this.ae = 0.0f;
            this.af = 0.0f;
            this.ag = 0.0f;
            this.ah = false;
            this.ai = false;
            this.aj = -1;
            this.ak = -1;
            this.al = -1;
            this.am = -1;
            this.an = -1;
            this.ao = -1;
            this.ap = -1;
            this.aq = -1;
        }

        public /* synthetic */ Object clone() {
            return m104a();
        }

        public C0024a m104a() {
            C0024a c0024a = new C0024a();
            c0024a.f190a = this.f190a;
            c0024a.f191b = this.f191b;
            c0024a.f192c = this.f192c;
            c0024a.f194e = this.f194e;
            c0024a.f195f = this.f195f;
            c0024a.f196g = this.f196g;
            c0024a.f197h = this.f197h;
            c0024a.f198i = this.f198i;
            c0024a.f199j = this.f199j;
            c0024a.f200k = this.f200k;
            c0024a.f201l = this.f201l;
            c0024a.f202m = this.f202m;
            c0024a.f203n = this.f203n;
            c0024a.f204o = this.f204o;
            c0024a.f205p = this.f205p;
            c0024a.f206q = this.f206q;
            c0024a.f207r = this.f207r;
            c0024a.f208s = this.f208s;
            c0024a.f209t = this.f209t;
            c0024a.f210u = this.f210u;
            c0024a.f211v = this.f211v;
            c0024a.f212w = this.f212w;
            c0024a.f164A = this.f164A;
            c0024a.f165B = this.f165B;
            c0024a.f210u = this.f210u;
            c0024a.f210u = this.f210u;
            c0024a.f210u = this.f210u;
            c0024a.f210u = this.f210u;
            c0024a.f210u = this.f210u;
            c0024a.f166C = this.f166C;
            c0024a.f167D = this.f167D;
            c0024a.f168E = this.f168E;
            c0024a.f169F = this.f169F;
            c0024a.f170G = this.f170G;
            c0024a.f171H = this.f171H;
            c0024a.f172I = this.f172I;
            c0024a.f173J = this.f173J;
            c0024a.f174K = this.f174K;
            c0024a.f175L = this.f175L;
            c0024a.f176M = this.f176M;
            c0024a.f177N = this.f177N;
            c0024a.f178O = this.f178O;
            c0024a.f179P = this.f179P;
            c0024a.f180Q = this.f180Q;
            c0024a.f181R = this.f181R;
            c0024a.f182S = this.f182S;
            c0024a.f183T = this.f183T;
            c0024a.f184U = this.f184U;
            c0024a.f185V = this.f185V;
            c0024a.f186W = this.f186W;
            c0024a.f187X = this.f187X;
            c0024a.f188Y = this.f188Y;
            c0024a.f189Z = this.f189Z;
            c0024a.aa = this.aa;
            c0024a.ab = this.ab;
            c0024a.ac = this.ac;
            c0024a.ad = this.ad;
            c0024a.ae = this.ae;
            c0024a.af = this.af;
            c0024a.ag = this.ag;
            c0024a.ah = this.ah;
            c0024a.ai = this.ai;
            c0024a.aj = this.aj;
            c0024a.ak = this.ak;
            c0024a.al = this.al;
            c0024a.am = this.am;
            c0024a.an = this.an;
            c0024a.ao = this.ao;
            c0024a.ap = this.ap;
            c0024a.aq = this.aq;
            if (this.ar != null) {
                c0024a.ar = Arrays.copyOf(this.ar, this.ar.length);
            }
            c0024a.f213x = this.f213x;
            c0024a.f214y = this.f214y;
            c0024a.f215z = this.f215z;
            return c0024a;
        }

        private void m100a(C0021a c0021a, int i, C0026a c0026a) {
            m99a(i, c0026a);
            if (c0021a instanceof Barrier) {
                this.aq = 1;
                Barrier barrier = (Barrier) c0021a;
                this.ap = barrier.getType();
                this.ar = barrier.getReferencedIds();
            }
        }

        private void m99a(int i, C0026a c0026a) {
            m98a(i, (C0022a) c0026a);
            this.f184U = c0026a.an;
            this.f187X = c0026a.aq;
            this.f188Y = c0026a.ar;
            this.f189Z = c0026a.as;
            this.aa = c0026a.at;
            this.ab = c0026a.au;
            this.ac = c0026a.av;
            this.ad = c0026a.aw;
            this.ae = c0026a.ax;
            this.af = c0026a.ay;
            this.ag = c0026a.az;
            this.f186W = c0026a.ap;
            this.f185V = c0026a.ao;
        }

        private void m98a(int i, C0022a c0022a) {
            this.f193d = i;
            this.f197h = c0022a.f127d;
            this.f198i = c0022a.f128e;
            this.f199j = c0022a.f129f;
            this.f200k = c0022a.f130g;
            this.f201l = c0022a.f131h;
            this.f202m = c0022a.f132i;
            this.f203n = c0022a.f133j;
            this.f204o = c0022a.f134k;
            this.f205p = c0022a.f135l;
            this.f206q = c0022a.f139p;
            this.f207r = c0022a.f140q;
            this.f208s = c0022a.f141r;
            this.f209t = c0022a.f142s;
            this.f210u = c0022a.f149z;
            this.f211v = c0022a.f98A;
            this.f212w = c0022a.f99B;
            this.f213x = c0022a.f136m;
            this.f214y = c0022a.f137n;
            this.f215z = c0022a.f138o;
            this.f164A = c0022a.f114Q;
            this.f165B = c0022a.f115R;
            this.f166C = c0022a.f116S;
            this.f196g = c0022a.f126c;
            this.f194e = c0022a.f124a;
            this.f195f = c0022a.f125b;
            this.f191b = c0022a.width;
            this.f192c = c0022a.height;
            this.f167D = c0022a.leftMargin;
            this.f168E = c0022a.rightMargin;
            this.f169F = c0022a.topMargin;
            this.f170G = c0022a.bottomMargin;
            this.f180Q = c0022a.f103F;
            this.f181R = c0022a.f102E;
            this.f183T = c0022a.f105H;
            this.f182S = c0022a.f104G;
            this.ah = c0022a.f117T;
            this.ai = c0022a.f118U;
            this.aj = c0022a.f106I;
            this.ak = c0022a.f107J;
            this.ah = c0022a.f117T;
            this.al = c0022a.f110M;
            this.am = c0022a.f111N;
            this.an = c0022a.f108K;
            this.ao = c0022a.f109L;
            if (VERSION.SDK_INT >= 17) {
                this.f171H = c0022a.getMarginEnd();
                this.f172I = c0022a.getMarginStart();
            }
        }

        public void m105a(C0022a c0022a) {
            c0022a.f127d = this.f197h;
            c0022a.f128e = this.f198i;
            c0022a.f129f = this.f199j;
            c0022a.f130g = this.f200k;
            c0022a.f131h = this.f201l;
            c0022a.f132i = this.f202m;
            c0022a.f133j = this.f203n;
            c0022a.f134k = this.f204o;
            c0022a.f135l = this.f205p;
            c0022a.f139p = this.f206q;
            c0022a.f140q = this.f207r;
            c0022a.f141r = this.f208s;
            c0022a.f142s = this.f209t;
            c0022a.leftMargin = this.f167D;
            c0022a.rightMargin = this.f168E;
            c0022a.topMargin = this.f169F;
            c0022a.bottomMargin = this.f170G;
            c0022a.f147x = this.f179P;
            c0022a.f148y = this.f178O;
            c0022a.f149z = this.f210u;
            c0022a.f98A = this.f211v;
            c0022a.f136m = this.f213x;
            c0022a.f137n = this.f214y;
            c0022a.f138o = this.f215z;
            c0022a.f99B = this.f212w;
            c0022a.f114Q = this.f164A;
            c0022a.f115R = this.f165B;
            c0022a.f103F = this.f180Q;
            c0022a.f102E = this.f181R;
            c0022a.f105H = this.f183T;
            c0022a.f104G = this.f182S;
            c0022a.f117T = this.ah;
            c0022a.f118U = this.ai;
            c0022a.f106I = this.aj;
            c0022a.f107J = this.ak;
            c0022a.f110M = this.al;
            c0022a.f111N = this.am;
            c0022a.f108K = this.an;
            c0022a.f109L = this.ao;
            c0022a.f116S = this.f166C;
            c0022a.f126c = this.f196g;
            c0022a.f124a = this.f194e;
            c0022a.f125b = this.f195f;
            c0022a.width = this.f191b;
            c0022a.height = this.f192c;
            if (VERSION.SDK_INT >= 17) {
                c0022a.setMarginStart(this.f172I);
                c0022a.setMarginEnd(this.f171H);
            }
            c0022a.m81a();
        }
    }

    static {
        f217c.append(C0031b.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f217c.append(C0031b.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f217c.append(C0031b.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f217c.append(C0031b.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f217c.append(C0031b.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f217c.append(C0031b.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f217c.append(C0031b.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f217c.append(C0031b.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f217c.append(C0031b.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f217c.append(C0031b.ConstraintSet_layout_editor_absoluteX, 6);
        f217c.append(C0031b.ConstraintSet_layout_editor_absoluteY, 7);
        f217c.append(C0031b.ConstraintSet_layout_constraintGuide_begin, 17);
        f217c.append(C0031b.ConstraintSet_layout_constraintGuide_end, 18);
        f217c.append(C0031b.ConstraintSet_layout_constraintGuide_percent, 19);
        f217c.append(C0031b.ConstraintSet_android_orientation, 27);
        f217c.append(C0031b.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f217c.append(C0031b.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f217c.append(C0031b.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f217c.append(C0031b.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f217c.append(C0031b.ConstraintSet_layout_goneMarginLeft, 13);
        f217c.append(C0031b.ConstraintSet_layout_goneMarginTop, 16);
        f217c.append(C0031b.ConstraintSet_layout_goneMarginRight, 14);
        f217c.append(C0031b.ConstraintSet_layout_goneMarginBottom, 11);
        f217c.append(C0031b.ConstraintSet_layout_goneMarginStart, 15);
        f217c.append(C0031b.ConstraintSet_layout_goneMarginEnd, 12);
        f217c.append(C0031b.ConstraintSet_layout_constraintVertical_weight, 40);
        f217c.append(C0031b.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f217c.append(C0031b.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f217c.append(C0031b.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f217c.append(C0031b.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f217c.append(C0031b.ConstraintSet_layout_constraintVertical_bias, 37);
        f217c.append(C0031b.ConstraintSet_layout_constraintDimensionRatio, 5);
        f217c.append(C0031b.ConstraintSet_layout_constraintLeft_creator, 64);
        f217c.append(C0031b.ConstraintSet_layout_constraintTop_creator, 64);
        f217c.append(C0031b.ConstraintSet_layout_constraintRight_creator, 64);
        f217c.append(C0031b.ConstraintSet_layout_constraintBottom_creator, 64);
        f217c.append(C0031b.ConstraintSet_layout_constraintBaseline_creator, 64);
        f217c.append(C0031b.ConstraintSet_android_layout_marginLeft, 24);
        f217c.append(C0031b.ConstraintSet_android_layout_marginRight, 28);
        f217c.append(C0031b.ConstraintSet_android_layout_marginStart, 31);
        f217c.append(C0031b.ConstraintSet_android_layout_marginEnd, 8);
        f217c.append(C0031b.ConstraintSet_android_layout_marginTop, 34);
        f217c.append(C0031b.ConstraintSet_android_layout_marginBottom, 2);
        f217c.append(C0031b.ConstraintSet_android_layout_width, 23);
        f217c.append(C0031b.ConstraintSet_android_layout_height, 21);
        f217c.append(C0031b.ConstraintSet_android_visibility, 22);
        f217c.append(C0031b.ConstraintSet_android_alpha, 43);
        f217c.append(C0031b.ConstraintSet_android_elevation, 44);
        f217c.append(C0031b.ConstraintSet_android_rotationX, 45);
        f217c.append(C0031b.ConstraintSet_android_rotationY, 46);
        f217c.append(C0031b.ConstraintSet_android_rotation, 60);
        f217c.append(C0031b.ConstraintSet_android_scaleX, 47);
        f217c.append(C0031b.ConstraintSet_android_scaleY, 48);
        f217c.append(C0031b.ConstraintSet_android_transformPivotX, 49);
        f217c.append(C0031b.ConstraintSet_android_transformPivotY, 50);
        f217c.append(C0031b.ConstraintSet_android_translationX, 51);
        f217c.append(C0031b.ConstraintSet_android_translationY, 52);
        f217c.append(C0031b.ConstraintSet_android_translationZ, 53);
        f217c.append(C0031b.ConstraintSet_layout_constraintWidth_default, 54);
        f217c.append(C0031b.ConstraintSet_layout_constraintHeight_default, 55);
        f217c.append(C0031b.ConstraintSet_layout_constraintWidth_max, 56);
        f217c.append(C0031b.ConstraintSet_layout_constraintHeight_max, 57);
        f217c.append(C0031b.ConstraintSet_layout_constraintWidth_min, 58);
        f217c.append(C0031b.ConstraintSet_layout_constraintHeight_min, 59);
        f217c.append(C0031b.ConstraintSet_layout_constraintCircle, 61);
        f217c.append(C0031b.ConstraintSet_layout_constraintCircleRadius, 62);
        f217c.append(C0031b.ConstraintSet_layout_constraintCircleAngle, 63);
        f217c.append(C0031b.ConstraintSet_android_id, 38);
    }

    public void m113a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f218b.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            C0022a c0022a = (C0022a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f218b.containsKey(Integer.valueOf(id))) {
                this.f218b.put(Integer.valueOf(id), new C0024a());
            }
            C0024a c0024a = (C0024a) this.f218b.get(Integer.valueOf(id));
            c0024a.m98a(id, c0022a);
            c0024a.f173J = childAt.getVisibility();
            if (VERSION.SDK_INT >= 17) {
                c0024a.f184U = childAt.getAlpha();
                c0024a.f187X = childAt.getRotation();
                c0024a.f188Y = childAt.getRotationX();
                c0024a.f189Z = childAt.getRotationY();
                c0024a.aa = childAt.getScaleX();
                c0024a.ab = childAt.getScaleY();
                c0024a.ac = childAt.getPivotX();
                c0024a.ad = childAt.getPivotY();
                c0024a.ae = childAt.getTranslationX();
                c0024a.af = childAt.getTranslationY();
                if (VERSION.SDK_INT >= 21) {
                    c0024a.ag = childAt.getTranslationZ();
                    if (c0024a.f185V) {
                        c0024a.f186W = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void m114a(C0027c c0027c) {
        int childCount = c0027c.getChildCount();
        this.f218b.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = c0027c.getChildAt(i);
            C0026a c0026a = (C0026a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!this.f218b.containsKey(Integer.valueOf(id))) {
                this.f218b.put(Integer.valueOf(id), new C0024a());
            }
            C0024a c0024a = (C0024a) this.f218b.get(Integer.valueOf(id));
            if (childAt instanceof C0021a) {
                c0024a.m100a((C0021a) childAt, id, c0026a);
            }
            c0024a.m99a(id, c0026a);
        }
    }

    public void m115b(ConstraintLayout constraintLayout) {
        m116c(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    void m116c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f218b.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (this.f218b.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                C0024a c0024a = (C0024a) this.f218b.get(Integer.valueOf(id));
                if (c0024a.aq != -1) {
                    switch (c0024a.aq) {
                        case 1:
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setReferencedIds(c0024a.ar);
                            barrier.setType(c0024a.ap);
                            c0024a.m105a(constraintLayout.m88a());
                            break;
                    }
                }
                C0022a c0022a = (C0022a) childAt.getLayoutParams();
                c0024a.m105a(c0022a);
                childAt.setLayoutParams(c0022a);
                childAt.setVisibility(c0024a.f173J);
                if (VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(c0024a.f184U);
                    childAt.setRotation(c0024a.f187X);
                    childAt.setRotationX(c0024a.f188Y);
                    childAt.setRotationY(c0024a.f189Z);
                    childAt.setScaleX(c0024a.aa);
                    childAt.setScaleY(c0024a.ab);
                    childAt.setPivotX(c0024a.ac);
                    childAt.setPivotY(c0024a.ad);
                    childAt.setTranslationX(c0024a.ae);
                    childAt.setTranslationY(c0024a.af);
                    if (VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(c0024a.ag);
                        if (c0024a.f185V) {
                            childAt.setElevation(c0024a.f186W);
                        }
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0024a c0024a2 = (C0024a) this.f218b.get(num);
            if (c0024a2.aq != -1) {
                switch (c0024a2.aq) {
                    case 1:
                        View barrier2 = new Barrier(constraintLayout.getContext());
                        barrier2.setId(num.intValue());
                        barrier2.setReferencedIds(c0024a2.ar);
                        barrier2.setType(c0024a2.ap);
                        LayoutParams a = constraintLayout.m88a();
                        c0024a2.m105a(a);
                        constraintLayout.addView(barrier2, a);
                        break;
                }
            }
            if (c0024a2.f190a) {
                barrier2 = new C0028d(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                LayoutParams a2 = constraintLayout.m88a();
                c0024a2.m105a(a2);
                constraintLayout.addView(barrier2, a2);
            }
        }
    }

    public void m111a(int i, int i2, int i3, int i4) {
        if (!this.f218b.containsKey(Integer.valueOf(i))) {
            this.f218b.put(Integer.valueOf(i), new C0024a());
        }
        C0024a c0024a = (C0024a) this.f218b.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    c0024a.f197h = i3;
                    c0024a.f198i = -1;
                    return;
                } else if (i4 == 2) {
                    c0024a.f198i = i3;
                    c0024a.f197h = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + m108a(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    c0024a.f199j = i3;
                    c0024a.f200k = -1;
                    return;
                } else if (i4 == 2) {
                    c0024a.f200k = i3;
                    c0024a.f199j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m108a(i4) + " undefined");
                }
            case 3:
                if (i4 == 3) {
                    c0024a.f201l = i3;
                    c0024a.f202m = -1;
                    c0024a.f205p = -1;
                    return;
                } else if (i4 == 4) {
                    c0024a.f202m = i3;
                    c0024a.f201l = -1;
                    c0024a.f205p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m108a(i4) + " undefined");
                }
            case 4:
                if (i4 == 4) {
                    c0024a.f204o = i3;
                    c0024a.f203n = -1;
                    c0024a.f205p = -1;
                    return;
                } else if (i4 == 3) {
                    c0024a.f203n = i3;
                    c0024a.f204o = -1;
                    c0024a.f205p = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m108a(i4) + " undefined");
                }
            case 5:
                if (i4 == 5) {
                    c0024a.f205p = i3;
                    c0024a.f204o = -1;
                    c0024a.f203n = -1;
                    c0024a.f201l = -1;
                    c0024a.f202m = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + m108a(i4) + " undefined");
            case 6:
                if (i4 == 6) {
                    c0024a.f207r = i3;
                    c0024a.f206q = -1;
                    return;
                } else if (i4 == 7) {
                    c0024a.f206q = i3;
                    c0024a.f207r = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m108a(i4) + " undefined");
                }
            case 7:
                if (i4 == 7) {
                    c0024a.f209t = i3;
                    c0024a.f208s = -1;
                    return;
                } else if (i4 == 6) {
                    c0024a.f208s = i3;
                    c0024a.f209t = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + m108a(i4) + " undefined");
                }
            default:
                throw new IllegalArgumentException(m108a(i2) + " to " + m108a(i4) + " unknown");
        }
    }

    public void m110a(int i, int i2) {
        if (this.f218b.containsKey(Integer.valueOf(i))) {
            C0024a c0024a = (C0024a) this.f218b.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    c0024a.f198i = -1;
                    c0024a.f197h = -1;
                    c0024a.f167D = -1;
                    c0024a.f174K = -1;
                    return;
                case 2:
                    c0024a.f200k = -1;
                    c0024a.f199j = -1;
                    c0024a.f168E = -1;
                    c0024a.f176M = -1;
                    return;
                case 3:
                    c0024a.f202m = -1;
                    c0024a.f201l = -1;
                    c0024a.f169F = -1;
                    c0024a.f175L = -1;
                    return;
                case 4:
                    c0024a.f203n = -1;
                    c0024a.f204o = -1;
                    c0024a.f170G = -1;
                    c0024a.f177N = -1;
                    return;
                case 5:
                    c0024a.f205p = -1;
                    return;
                case 6:
                    c0024a.f206q = -1;
                    c0024a.f207r = -1;
                    c0024a.f172I = -1;
                    c0024a.f179P = -1;
                    return;
                case 7:
                    c0024a.f208s = -1;
                    c0024a.f209t = -1;
                    c0024a.f171H = -1;
                    c0024a.f178O = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    private String m108a(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void m112a(Context context, int i) {
        XmlPullParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                switch (eventType) {
                    case 0:
                        xml.getName();
                        break;
                    case 2:
                        String name = xml.getName();
                        C0024a a = m107a(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            a.f190a = true;
                        }
                        this.f218b.put(Integer.valueOf(a.f193d), a);
                        break;
                    default:
                        break;
                }
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static int m106a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    private C0024a m107a(Context context, AttributeSet attributeSet) {
        C0024a c0024a = new C0024a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0031b.ConstraintSet);
        m109a(c0024a, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return c0024a;
    }

    private void m109a(C0024a c0024a, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (f217c.get(index)) {
                case 1:
                    c0024a.f205p = C0025b.m106a(typedArray, index, c0024a.f205p);
                    continue;
                case 2:
                    c0024a.f170G = typedArray.getDimensionPixelSize(index, c0024a.f170G);
                    continue;
                case 3:
                    c0024a.f204o = C0025b.m106a(typedArray, index, c0024a.f204o);
                    continue;
                case 4:
                    c0024a.f203n = C0025b.m106a(typedArray, index, c0024a.f203n);
                    continue;
                case 5:
                    c0024a.f212w = typedArray.getString(index);
                    continue;
                case 6:
                    c0024a.f164A = typedArray.getDimensionPixelOffset(index, c0024a.f164A);
                    continue;
                case 7:
                    c0024a.f165B = typedArray.getDimensionPixelOffset(index, c0024a.f165B);
                    continue;
                case 8:
                    c0024a.f171H = typedArray.getDimensionPixelSize(index, c0024a.f171H);
                    continue;
                case 9:
                    c0024a.f203n = C0025b.m106a(typedArray, index, c0024a.f209t);
                    continue;
                case 10:
                    c0024a.f208s = C0025b.m106a(typedArray, index, c0024a.f208s);
                    continue;
                case 11:
                    c0024a.f177N = typedArray.getDimensionPixelSize(index, c0024a.f177N);
                    continue;
                case 12:
                    c0024a.f178O = typedArray.getDimensionPixelSize(index, c0024a.f178O);
                    continue;
                case 13:
                    c0024a.f174K = typedArray.getDimensionPixelSize(index, c0024a.f174K);
                    continue;
                case 14:
                    c0024a.f176M = typedArray.getDimensionPixelSize(index, c0024a.f176M);
                    continue;
                case 15:
                    c0024a.f179P = typedArray.getDimensionPixelSize(index, c0024a.f179P);
                    continue;
                case 16:
                    c0024a.f175L = typedArray.getDimensionPixelSize(index, c0024a.f175L);
                    continue;
                case 17:
                    c0024a.f194e = typedArray.getDimensionPixelOffset(index, c0024a.f194e);
                    continue;
                case 18:
                    c0024a.f195f = typedArray.getDimensionPixelOffset(index, c0024a.f195f);
                    continue;
                case 19:
                    c0024a.f196g = typedArray.getFloat(index, c0024a.f196g);
                    continue;
                case 20:
                    c0024a.f210u = typedArray.getFloat(index, c0024a.f210u);
                    continue;
                case 21:
                    c0024a.f192c = typedArray.getLayoutDimension(index, c0024a.f192c);
                    continue;
                case 22:
                    c0024a.f173J = typedArray.getInt(index, c0024a.f173J);
                    c0024a.f173J = f216a[c0024a.f173J];
                    continue;
                case 23:
                    c0024a.f191b = typedArray.getLayoutDimension(index, c0024a.f191b);
                    continue;
                case 24:
                    c0024a.f167D = typedArray.getDimensionPixelSize(index, c0024a.f167D);
                    continue;
                case 25:
                    c0024a.f197h = C0025b.m106a(typedArray, index, c0024a.f197h);
                    continue;
                case 26:
                    c0024a.f198i = C0025b.m106a(typedArray, index, c0024a.f198i);
                    continue;
                case 27:
                    c0024a.f166C = typedArray.getInt(index, c0024a.f166C);
                    continue;
                case 28:
                    c0024a.f168E = typedArray.getDimensionPixelSize(index, c0024a.f168E);
                    continue;
                case 29:
                    c0024a.f199j = C0025b.m106a(typedArray, index, c0024a.f199j);
                    continue;
                case 30:
                    c0024a.f200k = C0025b.m106a(typedArray, index, c0024a.f200k);
                    continue;
                case 31:
                    c0024a.f172I = typedArray.getDimensionPixelSize(index, c0024a.f172I);
                    continue;
                case 32:
                    c0024a.f206q = C0025b.m106a(typedArray, index, c0024a.f206q);
                    continue;
                case 33:
                    c0024a.f207r = C0025b.m106a(typedArray, index, c0024a.f207r);
                    continue;
                case 34:
                    c0024a.f169F = typedArray.getDimensionPixelSize(index, c0024a.f169F);
                    continue;
                case 35:
                    c0024a.f202m = C0025b.m106a(typedArray, index, c0024a.f202m);
                    continue;
                case 36:
                    c0024a.f201l = C0025b.m106a(typedArray, index, c0024a.f201l);
                    continue;
                case 37:
                    c0024a.f211v = typedArray.getFloat(index, c0024a.f211v);
                    continue;
                case 38:
                    c0024a.f193d = typedArray.getResourceId(index, c0024a.f193d);
                    continue;
                case 39:
                    c0024a.f181R = typedArray.getFloat(index, c0024a.f181R);
                    continue;
                case 40:
                    c0024a.f180Q = typedArray.getFloat(index, c0024a.f180Q);
                    continue;
                case 41:
                    c0024a.f182S = typedArray.getInt(index, c0024a.f182S);
                    continue;
                case 42:
                    c0024a.f183T = typedArray.getInt(index, c0024a.f183T);
                    continue;
                case 43:
                    c0024a.f184U = typedArray.getFloat(index, c0024a.f184U);
                    continue;
                case 44:
                    c0024a.f185V = true;
                    c0024a.f186W = typedArray.getDimension(index, c0024a.f186W);
                    continue;
                case 45:
                    break;
                case 46:
                    c0024a.f189Z = typedArray.getFloat(index, c0024a.f189Z);
                    continue;
                case 47:
                    c0024a.aa = typedArray.getFloat(index, c0024a.aa);
                    continue;
                case 48:
                    c0024a.ab = typedArray.getFloat(index, c0024a.ab);
                    continue;
                case 49:
                    c0024a.ac = typedArray.getFloat(index, c0024a.ac);
                    continue;
                case 50:
                    c0024a.ad = typedArray.getFloat(index, c0024a.ad);
                    continue;
                case 51:
                    c0024a.ae = typedArray.getDimension(index, c0024a.ae);
                    continue;
                case 52:
                    c0024a.af = typedArray.getDimension(index, c0024a.af);
                    continue;
                case 53:
                    c0024a.ag = typedArray.getDimension(index, c0024a.ag);
                    continue;
                case 60:
                    c0024a.f187X = typedArray.getFloat(index, c0024a.f187X);
                    break;
                case 61:
                    c0024a.f213x = C0025b.m106a(typedArray, index, c0024a.f213x);
                    continue;
                case 62:
                    c0024a.f214y = typedArray.getDimensionPixelSize(index, c0024a.f214y);
                    continue;
                case 63:
                    c0024a.f215z = typedArray.getFloat(index, c0024a.f215z);
                    continue;
                case 64:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f217c.get(index));
                    continue;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f217c.get(index));
                    continue;
            }
            c0024a.f188Y = typedArray.getFloat(index, c0024a.f188Y);
        }
    }
}
