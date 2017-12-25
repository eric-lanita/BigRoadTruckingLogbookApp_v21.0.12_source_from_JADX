package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.constraint.C0032f.C0031b;
import android.support.constraint.solver.widgets.C0048c;
import android.support.constraint.solver.widgets.C0050d;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    SparseArray<View> f150a = new SparseArray();
    C0048c f151b = new C0048c();
    private ArrayList<C0021a> f152c = new ArrayList(4);
    private final ArrayList<ConstraintWidget> f153d = new ArrayList(100);
    private int f154e = 0;
    private int f155f = 0;
    private int f156g = Integer.MAX_VALUE;
    private int f157h = Integer.MAX_VALUE;
    private boolean f158i = true;
    private int f159j = 2;
    private C0025b f160k = null;
    private String f161l;
    private int f162m = -1;
    private HashMap<String, Integer> f163n = new HashMap();

    public static class C0022a extends MarginLayoutParams {
        public float f98A = 0.5f;
        public String f99B = null;
        float f100C = 0.0f;
        int f101D = 1;
        public float f102E = 0.0f;
        public float f103F = 0.0f;
        public int f104G = 0;
        public int f105H = 0;
        public int f106I = 0;
        public int f107J = 0;
        public int f108K = 0;
        public int f109L = 0;
        public int f110M = 0;
        public int f111N = 0;
        public float f112O = 1.0f;
        public float f113P = 1.0f;
        public int f114Q = -1;
        public int f115R = -1;
        public int f116S = -1;
        public boolean f117T = false;
        public boolean f118U = false;
        boolean f119V = true;
        boolean f120W = true;
        boolean f121X = false;
        boolean f122Y = false;
        boolean f123Z = false;
        public int f124a = -1;
        boolean aa = false;
        int ab = -1;
        int ac = -1;
        int ad = -1;
        int ae = -1;
        int af = -1;
        int ag = -1;
        float ah = 0.5f;
        int ai;
        int aj;
        float ak;
        ConstraintWidget al = new ConstraintWidget();
        public boolean am = false;
        public int f125b = -1;
        public float f126c = GroundOverlayOptions.NO_DIMENSION;
        public int f127d = -1;
        public int f128e = -1;
        public int f129f = -1;
        public int f130g = -1;
        public int f131h = -1;
        public int f132i = -1;
        public int f133j = -1;
        public int f134k = -1;
        public int f135l = -1;
        public int f136m = -1;
        public int f137n = 0;
        public float f138o = 0.0f;
        public int f139p = -1;
        public int f140q = -1;
        public int f141r = -1;
        public int f142s = -1;
        public int f143t = -1;
        public int f144u = -1;
        public int f145v = -1;
        public int f146w = -1;
        public int f147x = -1;
        public int f148y = -1;
        public float f149z = 0.5f;

        public C0022a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0031b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0031b.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf) {
                    this.f127d = obtainStyledAttributes.getResourceId(index, this.f127d);
                    if (this.f127d == -1) {
                        this.f127d = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintLeft_toRightOf) {
                    this.f128e = obtainStyledAttributes.getResourceId(index, this.f128e);
                    if (this.f128e == -1) {
                        this.f128e = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintRight_toLeftOf) {
                    this.f129f = obtainStyledAttributes.getResourceId(index, this.f129f);
                    if (this.f129f == -1) {
                        this.f129f = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintRight_toRightOf) {
                    this.f130g = obtainStyledAttributes.getResourceId(index, this.f130g);
                    if (this.f130g == -1) {
                        this.f130g = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintTop_toTopOf) {
                    this.f131h = obtainStyledAttributes.getResourceId(index, this.f131h);
                    if (this.f131h == -1) {
                        this.f131h = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintTop_toBottomOf) {
                    this.f132i = obtainStyledAttributes.getResourceId(index, this.f132i);
                    if (this.f132i == -1) {
                        this.f132i = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintBottom_toTopOf) {
                    this.f133j = obtainStyledAttributes.getResourceId(index, this.f133j);
                    if (this.f133j == -1) {
                        this.f133j = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf) {
                    this.f134k = obtainStyledAttributes.getResourceId(index, this.f134k);
                    if (this.f134k == -1) {
                        this.f134k = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf) {
                    this.f135l = obtainStyledAttributes.getResourceId(index, this.f135l);
                    if (this.f135l == -1) {
                        this.f135l = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintCircle) {
                    this.f136m = obtainStyledAttributes.getResourceId(index, this.f136m);
                    if (this.f136m == -1) {
                        this.f136m = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintCircleRadius) {
                    this.f137n = obtainStyledAttributes.getDimensionPixelSize(index, this.f137n);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintCircleAngle) {
                    this.f138o = obtainStyledAttributes.getFloat(index, this.f138o) % 360.0f;
                    if (this.f138o < 0.0f) {
                        this.f138o = (360.0f - this.f138o) % 360.0f;
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_editor_absoluteX) {
                    this.f114Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f114Q);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_editor_absoluteY) {
                    this.f115R = obtainStyledAttributes.getDimensionPixelOffset(index, this.f115R);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintGuide_begin) {
                    this.f124a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f124a);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintGuide_end) {
                    this.f125b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f125b);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintGuide_percent) {
                    this.f126c = obtainStyledAttributes.getFloat(index, this.f126c);
                } else if (index == C0031b.ConstraintLayout_Layout_android_orientation) {
                    this.f116S = obtainStyledAttributes.getInt(index, this.f116S);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintStart_toEndOf) {
                    this.f139p = obtainStyledAttributes.getResourceId(index, this.f139p);
                    if (this.f139p == -1) {
                        this.f139p = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintStart_toStartOf) {
                    this.f140q = obtainStyledAttributes.getResourceId(index, this.f140q);
                    if (this.f140q == -1) {
                        this.f140q = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintEnd_toStartOf) {
                    this.f141r = obtainStyledAttributes.getResourceId(index, this.f141r);
                    if (this.f141r == -1) {
                        this.f141r = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintEnd_toEndOf) {
                    this.f142s = obtainStyledAttributes.getResourceId(index, this.f142s);
                    if (this.f142s == -1) {
                        this.f142s = obtainStyledAttributes.getInt(index, -1);
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_goneMarginLeft) {
                    this.f143t = obtainStyledAttributes.getDimensionPixelSize(index, this.f143t);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_goneMarginTop) {
                    this.f144u = obtainStyledAttributes.getDimensionPixelSize(index, this.f144u);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_goneMarginRight) {
                    this.f145v = obtainStyledAttributes.getDimensionPixelSize(index, this.f145v);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_goneMarginBottom) {
                    this.f146w = obtainStyledAttributes.getDimensionPixelSize(index, this.f146w);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_goneMarginStart) {
                    this.f147x = obtainStyledAttributes.getDimensionPixelSize(index, this.f147x);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_goneMarginEnd) {
                    this.f148y = obtainStyledAttributes.getDimensionPixelSize(index, this.f148y);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintHorizontal_bias) {
                    this.f149z = obtainStyledAttributes.getFloat(index, this.f149z);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintVertical_bias) {
                    this.f98A = obtainStyledAttributes.getFloat(index, this.f98A);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintDimensionRatio) {
                    this.f99B = obtainStyledAttributes.getString(index);
                    this.f100C = Float.NaN;
                    this.f101D = -1;
                    if (this.f99B != null) {
                        int length = this.f99B.length();
                        index = this.f99B.indexOf(44);
                        if (index <= 0 || index >= length - 1) {
                            index = 0;
                        } else {
                            String substring = this.f99B.substring(0, index);
                            if (substring.equalsIgnoreCase("W")) {
                                this.f101D = 0;
                            } else if (substring.equalsIgnoreCase("H")) {
                                this.f101D = 1;
                            }
                            index++;
                        }
                        int indexOf = this.f99B.indexOf(58);
                        String substring2;
                        if (indexOf < 0 || indexOf >= length - 1) {
                            substring2 = this.f99B.substring(index);
                            if (substring2.length() > 0) {
                                try {
                                    this.f100C = Float.parseFloat(substring2);
                                } catch (NumberFormatException e) {
                                }
                            }
                        } else {
                            substring2 = this.f99B.substring(index, indexOf);
                            String substring3 = this.f99B.substring(indexOf + 1);
                            if (substring2.length() > 0 && substring3.length() > 0) {
                                try {
                                    float parseFloat = Float.parseFloat(substring2);
                                    float parseFloat2 = Float.parseFloat(substring3);
                                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                        if (this.f101D == 1) {
                                            this.f100C = Math.abs(parseFloat2 / parseFloat);
                                        } else {
                                            this.f100C = Math.abs(parseFloat / parseFloat2);
                                        }
                                    }
                                } catch (NumberFormatException e2) {
                                }
                            }
                        }
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintHorizontal_weight) {
                    this.f102E = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintVertical_weight) {
                    this.f103F = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle) {
                    this.f104G = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintVertical_chainStyle) {
                    this.f105H = obtainStyledAttributes.getInt(index, 0);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constrainedWidth) {
                    this.f117T = obtainStyledAttributes.getBoolean(index, this.f117T);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constrainedHeight) {
                    this.f118U = obtainStyledAttributes.getBoolean(index, this.f118U);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintWidth_default) {
                    this.f106I = obtainStyledAttributes.getInt(index, 0);
                    System.out.println("matchConstraintDefault width: " + this.f106I);
                    if (this.f106I == 1) {
                        System.err.println("layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth\"=true\" instead.");
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintHeight_default) {
                    this.f107J = obtainStyledAttributes.getInt(index, 0);
                    if (this.f107J == 1) {
                        System.err.println("layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight\"=true\" instead.");
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintWidth_min) {
                    try {
                        this.f108K = obtainStyledAttributes.getDimensionPixelSize(index, this.f108K);
                    } catch (Exception e3) {
                        if (obtainStyledAttributes.getInt(index, this.f108K) == -2) {
                            this.f108K = -2;
                        }
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintWidth_max) {
                    try {
                        this.f110M = obtainStyledAttributes.getDimensionPixelSize(index, this.f110M);
                    } catch (Exception e4) {
                        if (obtainStyledAttributes.getInt(index, this.f110M) == -2) {
                            this.f110M = -2;
                        }
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintWidth_percent) {
                    this.f112O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f112O));
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintHeight_min) {
                    try {
                        this.f109L = obtainStyledAttributes.getDimensionPixelSize(index, this.f109L);
                    } catch (Exception e5) {
                        if (obtainStyledAttributes.getInt(index, this.f109L) == -2) {
                            this.f109L = -2;
                        }
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintHeight_max) {
                    try {
                        this.f111N = obtainStyledAttributes.getDimensionPixelSize(index, this.f111N);
                    } catch (Exception e6) {
                        if (obtainStyledAttributes.getInt(index, this.f111N) == -2) {
                            this.f111N = -2;
                        }
                    }
                } else if (index == C0031b.ConstraintLayout_Layout_layout_constraintHeight_percent) {
                    this.f113P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f113P));
                } else if (!(index == C0031b.ConstraintLayout_Layout_layout_constraintLeft_creator || index == C0031b.ConstraintLayout_Layout_layout_constraintTop_creator || index == C0031b.ConstraintLayout_Layout_layout_constraintRight_creator || index == C0031b.ConstraintLayout_Layout_layout_constraintBottom_creator || index != C0031b.ConstraintLayout_Layout_layout_constraintBaseline_creator)) {
                }
            }
            obtainStyledAttributes.recycle();
            m81a();
        }

        public void m81a() {
            this.f122Y = false;
            this.f119V = true;
            this.f120W = true;
            if (this.width == -2 && this.f117T) {
                this.f119V = false;
                this.f106I = 1;
            }
            if (this.height == -2 && this.f118U) {
                this.f120W = false;
                this.f107J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.f119V = false;
                if (this.width == 0 && this.f106I == 1) {
                    this.width = -2;
                    this.f117T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.f120W = false;
                if (this.height == 0 && this.f107J == 1) {
                    this.height = -2;
                    this.f118U = true;
                }
            }
            if (this.f126c != GroundOverlayOptions.NO_DIMENSION || this.f124a != -1 || this.f125b != -1) {
                this.f122Y = true;
                this.f119V = true;
                this.f120W = true;
                if (!(this.al instanceof C0050d)) {
                    this.al = new C0050d();
                }
                ((C0050d) this.al).m323a(this.f116S);
            }
        }

        public C0022a(int i, int i2) {
            super(i, i2);
        }

        public C0022a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        @TargetApi(17)
        public void resolveLayoutDirection(int i) {
            Object obj = null;
            Object obj2 = 1;
            int i2 = this.leftMargin;
            int i3 = this.rightMargin;
            super.resolveLayoutDirection(i);
            this.ad = -1;
            this.ae = -1;
            this.ab = -1;
            this.ac = -1;
            this.af = -1;
            this.ag = -1;
            this.af = this.f143t;
            this.ag = this.f145v;
            this.ah = this.f149z;
            this.ai = this.f124a;
            this.aj = this.f125b;
            this.ak = this.f126c;
            if ((1 == getLayoutDirection() ? 1 : null) != null) {
                if (this.f139p != -1) {
                    this.ad = this.f139p;
                    obj = 1;
                } else if (this.f140q != -1) {
                    this.ae = this.f140q;
                    int i4 = 1;
                }
                if (this.f141r != -1) {
                    this.ac = this.f141r;
                    obj = 1;
                }
                if (this.f142s != -1) {
                    this.ab = this.f142s;
                } else {
                    obj2 = obj;
                }
                if (this.f147x != -1) {
                    this.ag = this.f147x;
                }
                if (this.f148y != -1) {
                    this.af = this.f148y;
                }
                if (obj2 != null) {
                    this.ah = 1.0f - this.f149z;
                }
                if (this.f122Y) {
                    if (this.f126c != GroundOverlayOptions.NO_DIMENSION) {
                        this.ak = 1.0f - this.f126c;
                        this.ai = -1;
                        this.aj = -1;
                    } else if (this.f124a != -1) {
                        this.aj = this.f124a;
                        this.ai = -1;
                        this.ak = GroundOverlayOptions.NO_DIMENSION;
                    } else if (this.f125b != -1) {
                        this.ai = this.f125b;
                        this.aj = -1;
                        this.ak = GroundOverlayOptions.NO_DIMENSION;
                    }
                }
            } else {
                if (this.f139p != -1) {
                    this.ac = this.f139p;
                }
                if (this.f140q != -1) {
                    this.ab = this.f140q;
                }
                if (this.f141r != -1) {
                    this.ad = this.f141r;
                }
                if (this.f142s != -1) {
                    this.ae = this.f142s;
                }
                if (this.f147x != -1) {
                    this.af = this.f147x;
                }
                if (this.f148y != -1) {
                    this.ag = this.f148y;
                }
            }
            if (this.f141r == -1 && this.f142s == -1 && this.f140q == -1 && this.f139p == -1) {
                if (this.f129f != -1) {
                    this.ad = this.f129f;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                } else if (this.f130g != -1) {
                    this.ae = this.f130g;
                    if (this.rightMargin <= 0 && i3 > 0) {
                        this.rightMargin = i3;
                    }
                }
                if (this.f127d != -1) {
                    this.ab = this.f127d;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                } else if (this.f128e != -1) {
                    this.ac = this.f128e;
                    if (this.leftMargin <= 0 && i2 > 0) {
                        this.leftMargin = i2;
                    }
                }
            }
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m88a();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m89a(attributeSet);
    }

    public void m93a(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f163n == null) {
                this.f163n = new HashMap();
            }
            obj = (String) obj;
            int indexOf = obj.indexOf("/");
            if (indexOf != -1) {
                obj = obj.substring(indexOf + 1);
            }
            this.f163n.put(obj, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public Object m92a(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            if (this.f163n != null && this.f163n.containsKey(str)) {
                return this.f163n.get(str);
            }
        }
        return null;
    }

    public ConstraintLayout(Context context) {
        super(context);
        m86b(null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m86b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m86b(attributeSet);
    }

    public void setId(int i) {
        this.f150a.remove(getId());
        super.setId(i);
        this.f150a.put(getId(), this);
    }

    public void setTitle(String str) {
        this.f161l = str;
    }

    public String getTitle() {
        return this.f161l;
    }

    private void m86b(AttributeSet attributeSet) {
        this.f151b.m243a((Object) this);
        this.f150a.put(getId(), this);
        this.f160k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0031b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0031b.ConstraintLayout_Layout_android_minWidth) {
                    this.f154e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f154e);
                } else if (index == C0031b.ConstraintLayout_Layout_android_minHeight) {
                    this.f155f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f155f);
                } else if (index == C0031b.ConstraintLayout_Layout_android_maxWidth) {
                    this.f156g = obtainStyledAttributes.getDimensionPixelOffset(index, this.f156g);
                } else if (index == C0031b.ConstraintLayout_Layout_android_maxHeight) {
                    this.f157h = obtainStyledAttributes.getDimensionPixelOffset(index, this.f157h);
                } else if (index == C0031b.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f159j = obtainStyledAttributes.getInt(index, this.f159j);
                } else if (index == C0031b.ConstraintLayout_Layout_title) {
                    this.f161l = obtainStyledAttributes.getString(index);
                } else if (index == C0031b.ConstraintLayout_Layout_constraintSet) {
                    index = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.f160k = new C0025b();
                        this.f160k.m112a(getContext(), index);
                    } catch (NotFoundException e) {
                        this.f160k = null;
                    }
                    this.f162m = index;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f151b.m316a(this.f159j);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        if (VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void onViewAdded(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget a = m90a(view);
        if ((view instanceof C0028d) && !(a instanceof C0050d)) {
            C0022a c0022a = (C0022a) view.getLayoutParams();
            c0022a.al = new C0050d();
            c0022a.f122Y = true;
            ((C0050d) c0022a.al).m323a(c0022a.f116S);
        }
        if (view instanceof C0021a) {
            C0021a c0021a = (C0021a) view;
            c0021a.m75a();
            ((C0022a) view.getLayoutParams()).f123Z = true;
            if (!this.f152c.contains(c0021a)) {
                this.f152c.add(c0021a);
            }
        }
        this.f150a.put(view.getId(), view);
        this.f158i = true;
    }

    public void onViewRemoved(View view) {
        if (VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f150a.remove(view.getId());
        ConstraintWidget a = m90a(view);
        this.f151b.m308c(a);
        this.f152c.remove(view);
        this.f153d.remove(a);
        this.f158i = true;
    }

    public void setMinWidth(int i) {
        if (i != this.f154e) {
            this.f154e = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.f155f) {
            this.f155f = i;
            requestLayout();
        }
    }

    public int getMinWidth() {
        return this.f154e;
    }

    public int getMinHeight() {
        return this.f155f;
    }

    public void setMaxWidth(int i) {
        if (i != this.f156g) {
            this.f156g = i;
            requestLayout();
        }
    }

    public void setMaxHeight(int i) {
        if (i != this.f157h) {
            this.f157h = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.f156g;
    }

    public int getMaxHeight() {
        return this.f157h;
    }

    private void m84b() {
        Object obj = null;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).isLayoutRequested()) {
                obj = 1;
                break;
            }
        }
        if (obj != null) {
            this.f153d.clear();
            m87c();
        }
    }

    private void m87c() {
        View childAt;
        int i;
        View childAt2;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        if (isInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    m93a(0, resourceName, Integer.valueOf(childAt.getId()));
                    m83b(childAt.getId()).m244a(resourceName);
                } catch (NotFoundException e) {
                }
            }
        }
        if (this.f162m != -1) {
            for (i = 0; i < childCount; i++) {
                childAt2 = getChildAt(i);
                if (childAt2.getId() == this.f162m && (childAt2 instanceof C0027c)) {
                    this.f160k = ((C0027c) childAt2).getConstraintSet();
                }
            }
        }
        if (this.f160k != null) {
            this.f160k.m116c(this);
        }
        this.f151b.m303D();
        int size = this.f152c.size();
        if (size > 0) {
            for (i = 0; i < size; i++) {
                ((C0021a) this.f152c.get(i)).mo27a(this);
            }
        }
        for (i = 0; i < childCount; i++) {
            childAt2 = getChildAt(i);
            if (childAt2 instanceof C0029e) {
                ((C0029e) childAt2).m119a(this);
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            Object childAt3 = getChildAt(i3);
            ConstraintWidget a = m90a((View) childAt3);
            if (a != null) {
                C0022a c0022a = (C0022a) childAt3.getLayoutParams();
                c0022a.m81a();
                if (c0022a.am) {
                    c0022a.am = false;
                } else {
                    a.mo39a();
                }
                a.m262d(childAt3.getVisibility());
                if (c0022a.aa) {
                    a.m262d(8);
                }
                a.m243a(childAt3);
                this.f151b.m307b(a);
                if (!(c0022a.f120W && c0022a.f119V)) {
                    this.f153d.add(a);
                }
                int i4;
                float f;
                if (c0022a.f122Y) {
                    C0050d c0050d = (C0050d) a;
                    i4 = c0022a.ai;
                    size = c0022a.aj;
                    f = c0022a.ak;
                    if (VERSION.SDK_INT < 17) {
                        i4 = c0022a.f124a;
                        size = c0022a.f125b;
                        f = c0022a.f126c;
                    }
                    if (f != GroundOverlayOptions.NO_DIMENSION) {
                        c0050d.m326e(f);
                    } else if (i4 != -1) {
                        c0050d.m327p(i4);
                    } else if (size != -1) {
                        c0050d.m328q(size);
                    }
                } else if (c0022a.f127d != -1 || c0022a.f128e != -1 || c0022a.f129f != -1 || c0022a.f130g != -1 || c0022a.f140q != -1 || c0022a.f139p != -1 || c0022a.f141r != -1 || c0022a.f142s != -1 || c0022a.f131h != -1 || c0022a.f132i != -1 || c0022a.f133j != -1 || c0022a.f134k != -1 || c0022a.f135l != -1 || c0022a.f114Q != -1 || c0022a.f115R != -1 || c0022a.f136m != -1 || c0022a.width == -1 || c0022a.height == -1) {
                    float f2;
                    int i5;
                    ConstraintWidget b;
                    ConstraintWidget b2;
                    C0022a c0022a2;
                    int i6 = c0022a.ab;
                    int i7 = c0022a.ac;
                    int i8 = c0022a.ad;
                    i4 = c0022a.ae;
                    int i9 = c0022a.af;
                    size = c0022a.ag;
                    f = c0022a.ah;
                    if (VERSION.SDK_INT < 17) {
                        i6 = c0022a.f127d;
                        i7 = c0022a.f128e;
                        i8 = c0022a.f129f;
                        i4 = c0022a.f130g;
                        i9 = c0022a.f143t;
                        size = c0022a.f145v;
                        f = c0022a.f149z;
                        if (i6 == -1 && i7 == -1) {
                            if (c0022a.f140q != -1) {
                                i6 = c0022a.f140q;
                            } else if (c0022a.f139p != -1) {
                                i7 = c0022a.f139p;
                            }
                        }
                        if (i8 == -1 && i4 == -1) {
                            if (c0022a.f141r != -1) {
                                f2 = f;
                                i5 = c0022a.f141r;
                                i = i7;
                                i7 = size;
                                size = i6;
                                i6 = i4;
                            } else if (c0022a.f142s != -1) {
                                f2 = f;
                                i5 = i8;
                                i = i7;
                                i7 = size;
                                size = i6;
                                i6 = c0022a.f142s;
                            }
                            if (c0022a.f136m == -1) {
                                b = m83b(c0022a.f136m);
                                if (b != null) {
                                    a.m242a(b, c0022a.f138o, c0022a.f137n);
                                }
                            } else {
                                if (size != -1) {
                                    b2 = m83b(size);
                                    if (b2 != null) {
                                        a.m239a(Type.LEFT, b2, Type.LEFT, c0022a.leftMargin, i9);
                                    }
                                } else if (i != -1) {
                                    b2 = m83b(i);
                                    if (b2 != null) {
                                        a.m239a(Type.LEFT, b2, Type.RIGHT, c0022a.leftMargin, i9);
                                    }
                                }
                                if (i5 != -1) {
                                    b2 = m83b(i5);
                                    if (b2 != null) {
                                        a.m239a(Type.RIGHT, b2, Type.LEFT, c0022a.rightMargin, i7);
                                    }
                                } else if (i6 != -1) {
                                    b2 = m83b(i6);
                                    if (b2 != null) {
                                        a.m239a(Type.RIGHT, b2, Type.RIGHT, c0022a.rightMargin, i7);
                                    }
                                }
                                if (c0022a.f131h != -1) {
                                    b2 = m83b(c0022a.f131h);
                                    if (b2 != null) {
                                        a.m239a(Type.TOP, b2, Type.TOP, c0022a.topMargin, c0022a.f144u);
                                    }
                                } else if (c0022a.f132i != -1) {
                                    b2 = m83b(c0022a.f132i);
                                    if (b2 != null) {
                                        a.m239a(Type.TOP, b2, Type.BOTTOM, c0022a.topMargin, c0022a.f144u);
                                    }
                                }
                                if (c0022a.f133j != -1) {
                                    b2 = m83b(c0022a.f133j);
                                    if (b2 != null) {
                                        a.m239a(Type.BOTTOM, b2, Type.TOP, c0022a.bottomMargin, c0022a.f146w);
                                    }
                                } else if (c0022a.f134k != -1) {
                                    b2 = m83b(c0022a.f134k);
                                    if (b2 != null) {
                                        a.m239a(Type.BOTTOM, b2, Type.BOTTOM, c0022a.bottomMargin, c0022a.f146w);
                                    }
                                }
                                if (c0022a.f135l != -1) {
                                    childAt = (View) this.f150a.get(c0022a.f135l);
                                    b2 = m83b(c0022a.f135l);
                                    if (!(b2 == null || childAt == null || !(childAt.getLayoutParams() instanceof C0022a))) {
                                        c0022a2 = (C0022a) childAt.getLayoutParams();
                                        c0022a.f121X = true;
                                        c0022a2.f121X = true;
                                        a.mo44a(Type.BASELINE).m219a(b2.mo44a(Type.BASELINE), 0, -1, Strength.STRONG, 0, true);
                                        a.mo44a(Type.TOP).m227h();
                                        a.mo44a(Type.BOTTOM).m227h();
                                    }
                                }
                                if (f2 >= 0.0f && f2 != 0.5f) {
                                    a.m233a(f2);
                                }
                                if (c0022a.f98A >= 0.0f && c0022a.f98A != 0.5f) {
                                    a.m248b(c0022a.f98A);
                                }
                            }
                            if (isInEditMode && !(c0022a.f114Q == -1 && c0022a.f115R == -1)) {
                                a.m234a(c0022a.f114Q, c0022a.f115R);
                            }
                            if (!c0022a.f119V) {
                                a.m240a(DimensionBehaviour.FIXED);
                                a.m269g(c0022a.width);
                            } else if (c0022a.width != -1) {
                                a.m240a(DimensionBehaviour.MATCH_PARENT);
                                a.mo44a(Type.LEFT).f301d = c0022a.leftMargin;
                                a.mo44a(Type.RIGHT).f301d = c0022a.rightMargin;
                            } else {
                                a.m240a(DimensionBehaviour.MATCH_CONSTRAINT);
                                a.m269g(0);
                            }
                            if (!c0022a.f120W) {
                                a.m253b(DimensionBehaviour.FIXED);
                                a.m271h(c0022a.height);
                            } else if (c0022a.height != -1) {
                                a.m253b(DimensionBehaviour.MATCH_PARENT);
                                a.mo44a(Type.TOP).f301d = c0022a.topMargin;
                                a.mo44a(Type.BOTTOM).f301d = c0022a.bottomMargin;
                            } else {
                                a.m253b(DimensionBehaviour.MATCH_CONSTRAINT);
                                a.m271h(0);
                            }
                            if (c0022a.f99B != null) {
                                a.m254b(c0022a.f99B);
                            }
                            a.m257c(c0022a.f102E);
                            a.m261d(c0022a.f103F);
                            a.m283n(c0022a.f104G);
                            a.m285o(c0022a.f105H);
                            a.m235a(c0022a.f106I, c0022a.f108K, c0022a.f110M, c0022a.f112O);
                            a.m251b(c0022a.f107J, c0022a.f109L, c0022a.f111N, c0022a.f113P);
                        }
                    }
                    f2 = f;
                    i5 = i8;
                    i = i7;
                    i7 = size;
                    size = i6;
                    i6 = i4;
                    if (c0022a.f136m == -1) {
                        if (size != -1) {
                            b2 = m83b(size);
                            if (b2 != null) {
                                a.m239a(Type.LEFT, b2, Type.LEFT, c0022a.leftMargin, i9);
                            }
                        } else if (i != -1) {
                            b2 = m83b(i);
                            if (b2 != null) {
                                a.m239a(Type.LEFT, b2, Type.RIGHT, c0022a.leftMargin, i9);
                            }
                        }
                        if (i5 != -1) {
                            b2 = m83b(i5);
                            if (b2 != null) {
                                a.m239a(Type.RIGHT, b2, Type.LEFT, c0022a.rightMargin, i7);
                            }
                        } else if (i6 != -1) {
                            b2 = m83b(i6);
                            if (b2 != null) {
                                a.m239a(Type.RIGHT, b2, Type.RIGHT, c0022a.rightMargin, i7);
                            }
                        }
                        if (c0022a.f131h != -1) {
                            b2 = m83b(c0022a.f131h);
                            if (b2 != null) {
                                a.m239a(Type.TOP, b2, Type.TOP, c0022a.topMargin, c0022a.f144u);
                            }
                        } else if (c0022a.f132i != -1) {
                            b2 = m83b(c0022a.f132i);
                            if (b2 != null) {
                                a.m239a(Type.TOP, b2, Type.BOTTOM, c0022a.topMargin, c0022a.f144u);
                            }
                        }
                        if (c0022a.f133j != -1) {
                            b2 = m83b(c0022a.f133j);
                            if (b2 != null) {
                                a.m239a(Type.BOTTOM, b2, Type.TOP, c0022a.bottomMargin, c0022a.f146w);
                            }
                        } else if (c0022a.f134k != -1) {
                            b2 = m83b(c0022a.f134k);
                            if (b2 != null) {
                                a.m239a(Type.BOTTOM, b2, Type.BOTTOM, c0022a.bottomMargin, c0022a.f146w);
                            }
                        }
                        if (c0022a.f135l != -1) {
                            childAt = (View) this.f150a.get(c0022a.f135l);
                            b2 = m83b(c0022a.f135l);
                            c0022a2 = (C0022a) childAt.getLayoutParams();
                            c0022a.f121X = true;
                            c0022a2.f121X = true;
                            a.mo44a(Type.BASELINE).m219a(b2.mo44a(Type.BASELINE), 0, -1, Strength.STRONG, 0, true);
                            a.mo44a(Type.TOP).m227h();
                            a.mo44a(Type.BOTTOM).m227h();
                        }
                        a.m233a(f2);
                        a.m248b(c0022a.f98A);
                    } else {
                        b = m83b(c0022a.f136m);
                        if (b != null) {
                            a.m242a(b, c0022a.f138o, c0022a.f137n);
                        }
                    }
                    a.m234a(c0022a.f114Q, c0022a.f115R);
                    if (!c0022a.f119V) {
                        a.m240a(DimensionBehaviour.FIXED);
                        a.m269g(c0022a.width);
                    } else if (c0022a.width != -1) {
                        a.m240a(DimensionBehaviour.MATCH_CONSTRAINT);
                        a.m269g(0);
                    } else {
                        a.m240a(DimensionBehaviour.MATCH_PARENT);
                        a.mo44a(Type.LEFT).f301d = c0022a.leftMargin;
                        a.mo44a(Type.RIGHT).f301d = c0022a.rightMargin;
                    }
                    if (!c0022a.f120W) {
                        a.m253b(DimensionBehaviour.FIXED);
                        a.m271h(c0022a.height);
                    } else if (c0022a.height != -1) {
                        a.m253b(DimensionBehaviour.MATCH_CONSTRAINT);
                        a.m271h(0);
                    } else {
                        a.m253b(DimensionBehaviour.MATCH_PARENT);
                        a.mo44a(Type.TOP).f301d = c0022a.topMargin;
                        a.mo44a(Type.BOTTOM).f301d = c0022a.bottomMargin;
                    }
                    if (c0022a.f99B != null) {
                        a.m254b(c0022a.f99B);
                    }
                    a.m257c(c0022a.f102E);
                    a.m261d(c0022a.f103F);
                    a.m283n(c0022a.f104G);
                    a.m285o(c0022a.f105H);
                    a.m235a(c0022a.f106I, c0022a.f108K, c0022a.f110M, c0022a.f112O);
                    a.m251b(c0022a.f107J, c0022a.f109L, c0022a.f111N, c0022a.f113P);
                }
            }
        }
    }

    private final ConstraintWidget m83b(int i) {
        if (i == 0) {
            return this.f151b;
        }
        View view = (View) this.f150a.get(i);
        if (view == this) {
            return this.f151b;
        }
        return view == null ? null : ((C0022a) view.getLayoutParams()).al;
    }

    public final ConstraintWidget m90a(View view) {
        if (view == this) {
            return this.f151b;
        }
        return view == null ? null : ((C0022a) view.getLayoutParams()).al;
    }

    private void m82a(int i, int i2) {
        int childMeasureSpec;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0022a c0022a = (C0022a) childAt.getLayoutParams();
                ConstraintWidget constraintWidget = c0022a.al;
                if (!(c0022a.f122Y || c0022a.f123Z)) {
                    Object obj;
                    int measuredHeight;
                    constraintWidget.m262d(childAt.getVisibility());
                    int i4 = c0022a.width;
                    int i5 = c0022a.height;
                    if (c0022a.f119V || c0022a.f120W || ((!c0022a.f119V && c0022a.f106I == 1) || c0022a.width == -1 || (!c0022a.f120W && (c0022a.f107J == 1 || c0022a.height == -1)))) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    Object obj2 = null;
                    Object obj3 = null;
                    if (obj != null) {
                        int childMeasureSpec2;
                        if (i4 == 0 || i4 == -1) {
                            obj = 1;
                            childMeasureSpec2 = getChildMeasureSpec(i, paddingLeft, -2);
                        } else {
                            if (i4 == -2) {
                                obj2 = 1;
                            }
                            childMeasureSpec2 = getChildMeasureSpec(i, paddingLeft, i4);
                            obj = obj2;
                        }
                        if (i5 == 0 || i5 == -1) {
                            childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
                            obj3 = 1;
                        } else {
                            if (i5 == -2) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            obj3 = obj2;
                            childMeasureSpec = getChildMeasureSpec(i2, paddingTop, i5);
                        }
                        childAt.measure(childMeasureSpec2, childMeasureSpec);
                        constraintWidget.m245a(i4 == -2);
                        constraintWidget.m255b(i5 == -2);
                        i5 = childAt.getMeasuredWidth();
                        Object obj4 = obj;
                        measuredHeight = childAt.getMeasuredHeight();
                        obj2 = obj4;
                    } else {
                        measuredHeight = i5;
                        i5 = i4;
                    }
                    constraintWidget.m269g(i5);
                    constraintWidget.m271h(measuredHeight);
                    if (obj2 != null) {
                        constraintWidget.m277k(i5);
                    }
                    if (obj3 != null) {
                        constraintWidget.m279l(measuredHeight);
                    }
                    if (c0022a.f121X) {
                        int baseline = childAt.getBaseline();
                        if (baseline != -1) {
                            constraintWidget.m281m(baseline);
                        }
                    }
                }
            }
        }
        for (childMeasureSpec = 0; childMeasureSpec < childCount; childMeasureSpec++) {
            View childAt2 = getChildAt(childMeasureSpec);
            if (childAt2 instanceof C0029e) {
                ((C0029e) childAt2).m120b(this);
            }
        }
        int size = this.f152c.size();
        if (size > 0) {
            for (childMeasureSpec = 0; childMeasureSpec < size; childMeasureSpec++) {
                ((C0021a) this.f152c.get(childMeasureSpec)).m79c(this);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f151b.m265e(paddingLeft);
        this.f151b.m267f(paddingTop);
        this.f151b.m249b(this.f156g);
        this.f151b.m258c(this.f157h);
        m85b(i, i2);
        int g = this.f151b.m268g();
        int i3 = this.f151b.m272i();
        if (this.f158i) {
            this.f158i = false;
            m84b();
        }
        m82a(i, i2);
        if (getChildCount() > 0) {
            m94a("First pass");
        }
        int i4 = 0;
        int size = this.f153d.size();
        int paddingBottom = paddingTop + getPaddingBottom();
        int paddingRight = paddingLeft + getPaddingRight();
        if (size > 0) {
            ConstraintWidget constraintWidget;
            View view;
            int baseline;
            Object obj = null;
            Object obj2 = this.f151b.m293w() == DimensionBehaviour.WRAP_CONTENT ? 1 : null;
            Object obj3 = this.f151b.m294x() == DimensionBehaviour.WRAP_CONTENT ? 1 : null;
            int max = Math.max(this.f151b.m268g(), this.f154e);
            int max2 = Math.max(this.f151b.m272i(), this.f155f);
            int i5 = 0;
            while (i5 < size) {
                constraintWidget = (ConstraintWidget) this.f153d.get(i5);
                view = (View) constraintWidget.m289s();
                if (view == null) {
                    paddingLeft = i4;
                } else {
                    C0022a c0022a = (C0022a) view.getLayoutParams();
                    if (c0022a.f123Z) {
                        paddingLeft = i4;
                    } else if (c0022a.f122Y) {
                        paddingLeft = i4;
                    } else if (view.getVisibility() == 8) {
                        paddingLeft = i4;
                    } else {
                        int childMeasureSpec;
                        int childMeasureSpec2;
                        Object obj4;
                        Object obj5;
                        if (c0022a.width == -2 && c0022a.f119V) {
                            childMeasureSpec = getChildMeasureSpec(i, paddingRight, c0022a.width);
                        } else {
                            childMeasureSpec = MeasureSpec.makeMeasureSpec(constraintWidget.m268g(), 1073741824);
                        }
                        if (c0022a.height == -2 && c0022a.f120W) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingBottom, c0022a.height);
                        } else {
                            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(constraintWidget.m272i(), 1073741824);
                        }
                        view.measure(childMeasureSpec, childMeasureSpec2);
                        childMeasureSpec = view.getMeasuredWidth();
                        int measuredHeight = view.getMeasuredHeight();
                        if (childMeasureSpec != constraintWidget.m268g()) {
                            constraintWidget.m269g(childMeasureSpec);
                            if (obj2 == null || constraintWidget.m284o() <= max) {
                                childMeasureSpec = max;
                            } else {
                                childMeasureSpec = Math.max(max, constraintWidget.m284o() + constraintWidget.mo44a(Type.RIGHT).m223d());
                            }
                            obj4 = 1;
                        } else {
                            childMeasureSpec = max;
                            obj4 = obj;
                        }
                        if (measuredHeight != constraintWidget.m272i()) {
                            constraintWidget.m271h(measuredHeight);
                            if (obj3 == null || constraintWidget.m286p() <= max2) {
                                childMeasureSpec2 = max2;
                            } else {
                                childMeasureSpec2 = Math.max(max2, constraintWidget.m286p() + constraintWidget.mo44a(Type.BOTTOM).m223d());
                            }
                            obj5 = 1;
                        } else {
                            obj5 = obj4;
                            childMeasureSpec2 = max2;
                        }
                        if (c0022a.f121X) {
                            baseline = view.getBaseline();
                            if (!(baseline == -1 || baseline == constraintWidget.m288r())) {
                                constraintWidget.m281m(baseline);
                                obj5 = 1;
                            }
                        }
                        if (VERSION.SDK_INT >= 11) {
                            paddingLeft = combineMeasuredStates(i4, view.getMeasuredState());
                            max2 = childMeasureSpec2;
                            obj = obj5;
                            max = childMeasureSpec;
                        } else {
                            max2 = childMeasureSpec2;
                            obj = obj5;
                            paddingLeft = i4;
                            max = childMeasureSpec;
                        }
                    }
                }
                i5++;
                i4 = paddingLeft;
            }
            if (obj != null) {
                this.f151b.m269g(g);
                this.f151b.m271h(i3);
                m94a("2nd pass");
                Object obj6 = null;
                if (this.f151b.m268g() < max) {
                    this.f151b.m269g(max);
                    obj6 = 1;
                }
                if (this.f151b.m272i() < max2) {
                    this.f151b.m271h(max2);
                    obj6 = 1;
                }
                if (obj6 != null) {
                    m94a("3rd pass");
                }
            }
            for (baseline = 0; baseline < size; baseline++) {
                constraintWidget = (ConstraintWidget) this.f153d.get(baseline);
                view = (View) constraintWidget.m289s();
                if (!(view == null || (view.getWidth() == constraintWidget.m268g() && view.getHeight() == constraintWidget.m272i()))) {
                    view.measure(MeasureSpec.makeMeasureSpec(constraintWidget.m268g(), 1073741824), MeasureSpec.makeMeasureSpec(constraintWidget.m272i(), 1073741824));
                }
            }
        }
        paddingLeft = this.f151b.m268g() + paddingRight;
        paddingTop = this.f151b.m272i() + paddingBottom;
        if (VERSION.SDK_INT >= 11) {
            paddingTop = resolveSizeAndState(paddingTop, i2, i4 << 16) & 16777215;
            paddingLeft = Math.min(this.f156g, resolveSizeAndState(paddingLeft, i, i4) & 16777215);
            paddingTop = Math.min(this.f157h, paddingTop);
            if (this.f151b.mo37y()) {
                paddingLeft |= 16777216;
            }
            if (this.f151b.m321z()) {
                paddingTop |= 16777216;
            }
            setMeasuredDimension(paddingLeft, paddingTop);
            return;
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    private void m85b(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        getLayoutParams();
        switch (mode) {
            case Integer.MIN_VALUE:
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                break;
            case 0:
                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                size = 0;
                break;
            case 1073741824:
                size = Math.min(this.f156g, size) - paddingLeft;
                break;
            default:
                size = 0;
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                break;
            case 0:
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                size2 = 0;
                break;
            case 1073741824:
                size2 = Math.min(this.f157h, size2) - paddingTop;
                break;
            default:
                size2 = 0;
                break;
        }
        this.f151b.m273i(0);
        this.f151b.m275j(0);
        this.f151b.m240a(dimensionBehaviour);
        this.f151b.m269g(size);
        this.f151b.m253b(dimensionBehaviour2);
        this.f151b.m271h(size2);
        this.f151b.m273i((this.f154e - getPaddingLeft()) - getPaddingRight());
        this.f151b.m275j((this.f155f - getPaddingTop()) - getPaddingBottom());
    }

    protected void m94a(String str) {
        this.f151b.mo43A();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C0022a c0022a = (C0022a) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = c0022a.al;
            if ((childAt.getVisibility() != 8 || c0022a.f122Y || c0022a.f123Z || isInEditMode) && !c0022a.aa) {
                int k = constraintWidget.m276k();
                int l = constraintWidget.m278l();
                int g = k + constraintWidget.m268g();
                int i6 = l + constraintWidget.m272i();
                childAt.layout(k, l, g, i6);
                if (childAt instanceof C0029e) {
                    View content = ((C0029e) childAt).getContent();
                    if (content != null) {
                        content.setVisibility(0);
                        content.layout(k, l, g, i6);
                    }
                }
            }
        }
        i5 = this.f152c.size();
        if (i5 > 0) {
            for (int i7 = 0; i7 < i5; i7++) {
                ((C0021a) this.f152c.get(i7)).mo28b(this);
            }
        }
    }

    public void setOptimizationLevel(int i) {
        this.f151b.m316a(i);
    }

    public C0022a m89a(AttributeSet attributeSet) {
        return new C0022a(getContext(), attributeSet);
    }

    protected C0022a m88a() {
        return new C0022a(-2, -2);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0022a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0022a;
    }

    public void setConstraintSet(C0025b c0025b) {
        this.f160k = c0025b;
    }

    public View m91a(int i) {
        return (View) this.f150a.get(i);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    Object tag = childAt.getTag();
                    if (tag != null && (tag instanceof String)) {
                        String[] split = ((String) tag).split(",");
                        if (split.length == 4) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            int i2 = (int) ((((float) parseInt) / 1080.0f) * width);
                            int i3 = (int) ((((float) parseInt2) / 1920.0f) * height);
                            int parseInt3 = (int) ((((float) Integer.parseInt(split[2])) / 1080.0f) * width);
                            int parseInt4 = (int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height);
                            Paint paint = new Paint();
                            paint.setColor(-65536);
                            canvas.drawLine((float) i2, (float) i3, (float) (i2 + parseInt3), (float) i3, paint);
                            Canvas canvas2 = canvas;
                            canvas2.drawLine((float) (i2 + parseInt3), (float) i3, (float) (i2 + parseInt3), (float) (i3 + parseInt4), paint);
                            canvas2 = canvas;
                            canvas2.drawLine((float) (i2 + parseInt3), (float) (i3 + parseInt4), (float) i2, (float) (i3 + parseInt4), paint);
                            canvas.drawLine((float) i2, (float) (i3 + parseInt4), (float) i2, (float) i3, paint);
                            paint.setColor(-16711936);
                            canvas2 = canvas;
                            canvas2.drawLine((float) i2, (float) i3, (float) (i2 + parseInt3), (float) (i3 + parseInt4), paint);
                            canvas.drawLine((float) i2, (float) (i3 + parseInt4), (float) (i2 + parseInt3), (float) i3, paint);
                        }
                    }
                }
            }
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.f158i = true;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
