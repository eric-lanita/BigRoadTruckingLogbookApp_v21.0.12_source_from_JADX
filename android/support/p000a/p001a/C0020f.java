package android.support.p000a.p001a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p000a.p001a.C0010c.C0009b;
import android.support.v4.content.p007a.C0249a;
import android.support.v4.p002a.p003a.C0085a;
import android.support.v4.p008d.C0270a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class C0020f extends C0005e {
    static final Mode f79b = Mode.SRC_IN;
    private C0018f f80c;
    private PorterDuffColorFilter f81d;
    private ColorFilter f82e;
    private boolean f83f;
    private boolean f84g;
    private ConstantState f85h;
    private final float[] f86i;
    private final Matrix f87j;
    private final Rect f88k;

    private static class C0013d {
        protected C0009b[] f21m = null;
        String f22n;
        int f23o;

        public C0013d(C0013d c0013d) {
            this.f22n = c0013d.f22n;
            this.f23o = c0013d.f23o;
            this.f21m = C0010c.m16a(c0013d.f21m);
        }

        public void m24a(Path path) {
            path.reset();
            if (this.f21m != null) {
                C0009b.m10a(this.f21m, path);
            }
        }

        public String m26b() {
            return this.f22n;
        }

        public boolean mo25a() {
            return false;
        }
    }

    private static class C0014a extends C0013d {
        public C0014a(C0014a c0014a) {
            super(c0014a);
        }

        public void m28a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0011d.m22a(xmlPullParser, "pathData")) {
                TypedArray b = C0005e.m0b(resources, theme, attributeSet, C0000a.f3d);
                m27a(b);
                b.recycle();
            }
        }

        private void m27a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = C0010c.m15a(string);
            }
        }

        public boolean mo25a() {
            return true;
        }
    }

    private static class C0015b extends C0013d {
        int f24a = 0;
        float f25b = 0.0f;
        int f26c = 0;
        float f27d = 1.0f;
        int f28e;
        float f29f = 1.0f;
        float f30g = 0.0f;
        float f31h = 1.0f;
        float f32i = 0.0f;
        Cap f33j = Cap.BUTT;
        Join f34k = Join.MITER;
        float f35l = 4.0f;
        private int[] f36p;

        public C0015b(C0015b c0015b) {
            super(c0015b);
            this.f36p = c0015b.f36p;
            this.f24a = c0015b.f24a;
            this.f25b = c0015b.f25b;
            this.f27d = c0015b.f27d;
            this.f26c = c0015b.f26c;
            this.f28e = c0015b.f28e;
            this.f29f = c0015b.f29f;
            this.f30g = c0015b.f30g;
            this.f31h = c0015b.f31h;
            this.f32i = c0015b.f32i;
            this.f33j = c0015b.f33j;
            this.f34k = c0015b.f34k;
            this.f35l = c0015b.f35l;
        }

        private Cap m30a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m31a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        public void m33a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0005e.m0b(resources, theme, attributeSet, C0000a.f2c);
            m32a(b, xmlPullParser);
            b.recycle();
        }

        private void m32a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f36p = null;
            if (C0011d.m22a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0010c.m15a(string);
                }
                this.f26c = C0011d.m23b(typedArray, xmlPullParser, "fillColor", 1, this.f26c);
                this.f29f = C0011d.m19a(typedArray, xmlPullParser, "fillAlpha", 12, this.f29f);
                this.f33j = m30a(C0011d.m20a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f33j);
                this.f34k = m31a(C0011d.m20a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f34k);
                this.f35l = C0011d.m19a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f35l);
                this.f24a = C0011d.m23b(typedArray, xmlPullParser, "strokeColor", 3, this.f24a);
                this.f27d = C0011d.m19a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f27d);
                this.f25b = C0011d.m19a(typedArray, xmlPullParser, "strokeWidth", 4, this.f25b);
                this.f31h = C0011d.m19a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f31h);
                this.f32i = C0011d.m19a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f32i);
                this.f30g = C0011d.m19a(typedArray, xmlPullParser, "trimPathStart", 5, this.f30g);
            }
        }
    }

    private static class C0016c {
        final ArrayList<Object> f37a = new ArrayList();
        private final Matrix f38b = new Matrix();
        private float f39c = 0.0f;
        private float f40d = 0.0f;
        private float f41e = 0.0f;
        private float f42f = 1.0f;
        private float f43g = 1.0f;
        private float f44h = 0.0f;
        private float f45i = 0.0f;
        private final Matrix f46j = new Matrix();
        private int f47k;
        private int[] f48l;
        private String f49m = null;

        public C0016c(C0016c c0016c, C0270a<String, Object> c0270a) {
            this.f39c = c0016c.f39c;
            this.f40d = c0016c.f40d;
            this.f41e = c0016c.f41e;
            this.f42f = c0016c.f42f;
            this.f43g = c0016c.f43g;
            this.f44h = c0016c.f44h;
            this.f45i = c0016c.f45i;
            this.f48l = c0016c.f48l;
            this.f49m = c0016c.f49m;
            this.f47k = c0016c.f47k;
            if (this.f49m != null) {
                c0270a.put(this.f49m, this);
            }
            this.f46j.set(c0016c.f46j);
            ArrayList arrayList = c0016c.f37a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0016c) {
                    this.f37a.add(new C0016c((C0016c) obj, c0270a));
                } else {
                    C0013d c0015b;
                    if (obj instanceof C0015b) {
                        c0015b = new C0015b((C0015b) obj);
                    } else if (obj instanceof C0014a) {
                        c0015b = new C0014a((C0014a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f37a.add(c0015b);
                    if (c0015b.f22n != null) {
                        c0270a.put(c0015b.f22n, c0015b);
                    }
                }
            }
        }

        public String m39a() {
            return this.f49m;
        }

        public void m40a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0005e.m0b(resources, theme, attributeSet, C0000a.f1b);
            m35a(b, xmlPullParser);
            b.recycle();
        }

        private void m35a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f48l = null;
            this.f39c = C0011d.m19a(typedArray, xmlPullParser, "rotation", 5, this.f39c);
            this.f40d = typedArray.getFloat(1, this.f40d);
            this.f41e = typedArray.getFloat(2, this.f41e);
            this.f42f = C0011d.m19a(typedArray, xmlPullParser, "scaleX", 3, this.f42f);
            this.f43g = C0011d.m19a(typedArray, xmlPullParser, "scaleY", 4, this.f43g);
            this.f44h = C0011d.m19a(typedArray, xmlPullParser, "translateX", 6, this.f44h);
            this.f45i = C0011d.m19a(typedArray, xmlPullParser, "translateY", 7, this.f45i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f49m = string;
            }
            m37b();
        }

        private void m37b() {
            this.f46j.reset();
            this.f46j.postTranslate(-this.f40d, -this.f41e);
            this.f46j.postScale(this.f42f, this.f43g);
            this.f46j.postRotate(this.f39c, 0.0f, 0.0f);
            this.f46j.postTranslate(this.f44h + this.f40d, this.f45i + this.f41e);
        }
    }

    private static class C0017e {
        private static final Matrix f50j = new Matrix();
        float f51a;
        float f52b;
        float f53c;
        float f54d;
        int f55e;
        String f56f;
        final C0270a<String, Object> f57g;
        private final Path f58h;
        private final Path f59i;
        private final Matrix f60k;
        private Paint f61l;
        private Paint f62m;
        private PathMeasure f63n;
        private int f64o;
        private final C0016c f65p;

        public C0017e() {
            this.f60k = new Matrix();
            this.f51a = 0.0f;
            this.f52b = 0.0f;
            this.f53c = 0.0f;
            this.f54d = 0.0f;
            this.f55e = 255;
            this.f56f = null;
            this.f57g = new C0270a();
            this.f65p = new C0016c();
            this.f58h = new Path();
            this.f59i = new Path();
        }

        public void m52a(int i) {
            this.f55e = i;
        }

        public int m50a() {
            return this.f55e;
        }

        public void m51a(float f) {
            m52a((int) (255.0f * f));
        }

        public float m54b() {
            return ((float) m50a()) / 255.0f;
        }

        public C0017e(C0017e c0017e) {
            this.f60k = new Matrix();
            this.f51a = 0.0f;
            this.f52b = 0.0f;
            this.f53c = 0.0f;
            this.f54d = 0.0f;
            this.f55e = 255;
            this.f56f = null;
            this.f57g = new C0270a();
            this.f65p = new C0016c(c0017e.f65p, this.f57g);
            this.f58h = new Path(c0017e.f58h);
            this.f59i = new Path(c0017e.f59i);
            this.f51a = c0017e.f51a;
            this.f52b = c0017e.f52b;
            this.f53c = c0017e.f53c;
            this.f54d = c0017e.f54d;
            this.f64o = c0017e.f64o;
            this.f55e = c0017e.f55e;
            this.f56f = c0017e.f56f;
            if (c0017e.f56f != null) {
                this.f57g.put(c0017e.f56f, this);
            }
        }

        private void m45a(C0016c c0016c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0016c.f38b.set(matrix);
            c0016c.f38b.preConcat(c0016c.f46j);
            for (int i3 = 0; i3 < c0016c.f37a.size(); i3++) {
                Object obj = c0016c.f37a.get(i3);
                if (obj instanceof C0016c) {
                    m45a((C0016c) obj, c0016c.f38b, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0013d) {
                    m46a(c0016c, (C0013d) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        public void m53a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m45a(this.f65p, f50j, canvas, i, i2, colorFilter);
        }

        private void m46a(C0016c c0016c, C0013d c0013d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f53c;
            float f2 = ((float) i2) / this.f54d;
            float min = Math.min(f, f2);
            Matrix b = c0016c.f38b;
            this.f60k.set(b);
            this.f60k.postScale(f, f2);
            f = m42a(b);
            if (f != 0.0f) {
                c0013d.m24a(this.f58h);
                Path path = this.f58h;
                this.f59i.reset();
                if (c0013d.mo25a()) {
                    this.f59i.addPath(path, this.f60k);
                    canvas.clipPath(this.f59i, Op.REPLACE);
                    return;
                }
                Paint paint;
                C0015b c0015b = (C0015b) c0013d;
                if (!(c0015b.f30g == 0.0f && c0015b.f31h == 1.0f)) {
                    float f3 = (c0015b.f30g + c0015b.f32i) % 1.0f;
                    float f4 = (c0015b.f31h + c0015b.f32i) % 1.0f;
                    if (this.f63n == null) {
                        this.f63n = new PathMeasure();
                    }
                    this.f63n.setPath(this.f58h, false);
                    float length = this.f63n.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.f63n.getSegment(f3, length, path, true);
                        this.f63n.getSegment(0.0f, f4, path, true);
                    } else {
                        this.f63n.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f59i.addPath(path, this.f60k);
                if (c0015b.f26c != 0) {
                    if (this.f62m == null) {
                        this.f62m = new Paint();
                        this.f62m.setStyle(Style.FILL);
                        this.f62m.setAntiAlias(true);
                    }
                    paint = this.f62m;
                    paint.setColor(C0020f.m69b(c0015b.f26c, c0015b.f29f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f59i, paint);
                }
                if (c0015b.f24a != 0) {
                    if (this.f61l == null) {
                        this.f61l = new Paint();
                        this.f61l.setStyle(Style.STROKE);
                        this.f61l.setAntiAlias(true);
                    }
                    paint = this.f61l;
                    if (c0015b.f34k != null) {
                        paint.setStrokeJoin(c0015b.f34k);
                    }
                    if (c0015b.f33j != null) {
                        paint.setStrokeCap(c0015b.f33j);
                    }
                    paint.setStrokeMiter(c0015b.f35l);
                    paint.setColor(C0020f.m69b(c0015b.f24a, c0015b.f27d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * c0015b.f25b);
                    canvas.drawPath(this.f59i, paint);
                }
            }
        }

        private static float m41a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m42a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0017e.m41a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            if (hypot > 0.0f) {
                return Math.abs(a) / hypot;
            }
            return 0.0f;
        }
    }

    private static class C0018f extends ConstantState {
        int f66a;
        C0017e f67b;
        ColorStateList f68c;
        Mode f69d;
        boolean f70e;
        Bitmap f71f;
        ColorStateList f72g;
        Mode f73h;
        int f74i;
        boolean f75j;
        boolean f76k;
        Paint f77l;

        public C0018f(C0018f c0018f) {
            this.f68c = null;
            this.f69d = C0020f.f79b;
            if (c0018f != null) {
                this.f66a = c0018f.f66a;
                this.f67b = new C0017e(c0018f.f67b);
                if (c0018f.f67b.f62m != null) {
                    this.f67b.f62m = new Paint(c0018f.f67b.f62m);
                }
                if (c0018f.f67b.f61l != null) {
                    this.f67b.f61l = new Paint(c0018f.f67b.f61l);
                }
                this.f68c = c0018f.f68c;
                this.f69d = c0018f.f69d;
                this.f70e = c0018f.f70e;
            }
        }

        public void m57a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f71f, null, rect, m55a(colorFilter));
        }

        public boolean m58a() {
            return this.f67b.m50a() < 255;
        }

        public Paint m55a(ColorFilter colorFilter) {
            if (!m58a() && colorFilter == null) {
                return null;
            }
            if (this.f77l == null) {
                this.f77l = new Paint();
                this.f77l.setFilterBitmap(true);
            }
            this.f77l.setAlpha(this.f67b.m50a());
            this.f77l.setColorFilter(colorFilter);
            return this.f77l;
        }

        public void m56a(int i, int i2) {
            this.f71f.eraseColor(0);
            this.f67b.m53a(new Canvas(this.f71f), i, i2, null);
        }

        public void m59b(int i, int i2) {
            if (this.f71f == null || !m62c(i, i2)) {
                this.f71f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f76k = true;
            }
        }

        public boolean m62c(int i, int i2) {
            if (i == this.f71f.getWidth() && i2 == this.f71f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean m60b() {
            if (!this.f76k && this.f72g == this.f68c && this.f73h == this.f69d && this.f75j == this.f70e && this.f74i == this.f67b.m50a()) {
                return true;
            }
            return false;
        }

        public void m61c() {
            this.f72g = this.f68c;
            this.f73h = this.f69d;
            this.f74i = this.f67b.m50a();
            this.f75j = this.f70e;
            this.f76k = false;
        }

        public C0018f() {
            this.f68c = null;
            this.f69d = C0020f.f79b;
            this.f67b = new C0017e();
        }

        public Drawable newDrawable() {
            return new C0020f();
        }

        public Drawable newDrawable(Resources resources) {
            return new C0020f();
        }

        public int getChangingConfigurations() {
            return this.f66a;
        }
    }

    private static class C0019g extends ConstantState {
        private final ConstantState f78a;

        public C0019g(ConstantState constantState) {
            this.f78a = constantState;
        }

        public Drawable newDrawable() {
            Drawable c0020f = new C0020f();
            c0020f.a = (VectorDrawable) this.f78a.newDrawable();
            return c0020f;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0020f = new C0020f();
            c0020f.a = (VectorDrawable) this.f78a.newDrawable(resources);
            return c0020f;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0020f = new C0020f();
            c0020f.a = (VectorDrawable) this.f78a.newDrawable(resources, theme);
            return c0020f;
        }

        public boolean canApplyTheme() {
            return this.f78a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f78a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private C0020f() {
        this.f84g = true;
        this.f86i = new float[9];
        this.f87j = new Matrix();
        this.f88k = new Rect();
        this.f80c = new C0018f();
    }

    private C0020f(C0018f c0018f) {
        this.f84g = true;
        this.f86i = new float[9];
        this.f87j = new Matrix();
        this.f88k = new Rect();
        this.f80c = c0018f;
        this.f81d = m71a(this.f81d, c0018f.f68c, c0018f.f69d);
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.f83f && super.mutate() == this) {
            this.f80c = new C0018f(this.f80c);
            this.f83f = true;
        }
        return this;
    }

    Object m72a(String str) {
        return this.f80c.f67b.f57g.get(str);
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new C0019g(this.a.getConstantState());
        }
        this.f80c.f66a = getChangingConfigurations();
        return this.f80c;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.f88k);
        if (this.f88k.width() > 0 && this.f88k.height() > 0) {
            ColorFilter colorFilter = this.f82e == null ? this.f81d : this.f82e;
            canvas.getMatrix(this.f87j);
            this.f87j.getValues(this.f86i);
            float abs = Math.abs(this.f86i[0]);
            float abs2 = Math.abs(this.f86i[4]);
            float abs3 = Math.abs(this.f86i[1]);
            float abs4 = Math.abs(this.f86i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f88k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.f88k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f88k.left, (float) this.f88k.top);
                if (m68a()) {
                    canvas.translate((float) this.f88k.width(), 0.0f);
                    canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
                }
                this.f88k.offsetTo(0, 0);
                this.f80c.m59b(min, height);
                if (!this.f84g) {
                    this.f80c.m56a(min, height);
                } else if (!this.f80c.m60b()) {
                    this.f80c.m56a(min, height);
                    this.f80c.m61c();
                }
                this.f80c.m57a(canvas, colorFilter, this.f88k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        if (this.a != null) {
            return C0085a.m460c(this.a);
        }
        return this.f80c.f67b.m50a();
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else if (this.f80c.f67b.m50a() != i) {
            this.f80c.f67b.m52a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.f82e = colorFilter;
        invalidateSelf();
    }

    PorterDuffColorFilter m71a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0085a.m452a(this.a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0085a.m454a(this.a, colorStateList);
            return;
        }
        C0018f c0018f = this.f80c;
        if (c0018f.f68c != colorStateList) {
            c0018f.f68c = colorStateList;
            this.f81d = m71a(this.f81d, colorStateList, c0018f.f69d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0085a.m457a(this.a, mode);
            return;
        }
        C0018f c0018f = this.f80c;
        if (c0018f.f69d != mode) {
            c0018f.f69d = mode;
            this.f81d = m71a(this.f81d, c0018f.f68c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return super.isStateful() || !(this.f80c == null || this.f80c.f68c == null || !this.f80c.f68c.isStateful());
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        C0018f c0018f = this.f80c;
        if (c0018f.f68c == null || c0018f.f69d == null) {
            return false;
        }
        this.f81d = m71a(this.f81d, c0018f.f68c, c0018f.f69d);
        invalidateSelf();
        return true;
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return -3;
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return (int) this.f80c.f67b.f51a;
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return (int) this.f80c.f67b.f52b;
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            C0085a.m461d(this.a);
        }
        return false;
    }

    public static C0020f m65a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            C0020f c0020f = new C0020f();
            c0020f.a = C0249a.m1082a(resources, i, theme);
            c0020f.f85h = new C0019g(c0020f.a.getConstantState());
            return c0020f;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0020f.m66a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static C0020f m66a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0020f c0020f = new C0020f();
        c0020f.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0020f;
    }

    private static int m69b(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            C0085a.m456a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0018f c0018f = this.f80c;
        c0018f.f67b = new C0017e();
        TypedArray b = C0005e.m0b(resources, theme, attributeSet, C0000a.f0a);
        m67a(b, xmlPullParser);
        b.recycle();
        c0018f.f66a = getChangingConfigurations();
        c0018f.f76k = true;
        m70b(resources, xmlPullParser, attributeSet, theme);
        this.f81d = m71a(this.f81d, c0018f.f68c, c0018f.f69d);
    }

    private static Mode m64a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    private void m67a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0018f c0018f = this.f80c;
        C0017e c0017e = c0018f.f67b;
        c0018f.f69d = C0020f.m64a(C0011d.m20a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0018f.f68c = colorStateList;
        }
        c0018f.f70e = C0011d.m21a(typedArray, xmlPullParser, "autoMirrored", 5, c0018f.f70e);
        c0017e.f53c = C0011d.m19a(typedArray, xmlPullParser, "viewportWidth", 7, c0017e.f53c);
        c0017e.f54d = C0011d.m19a(typedArray, xmlPullParser, "viewportHeight", 8, c0017e.f54d);
        if (c0017e.f53c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0017e.f54d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0017e.f51a = typedArray.getDimension(3, c0017e.f51a);
            c0017e.f52b = typedArray.getDimension(2, c0017e.f52b);
            if (c0017e.f51a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0017e.f52b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0017e.m51a(C0011d.m19a(typedArray, xmlPullParser, "alpha", 4, c0017e.m54b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0017e.f56f = string;
                    c0017e.f57g.put(string, c0017e);
                }
            }
        }
    }

    private void m70b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0018f c0018f = this.f80c;
        C0017e c0017e = c0018f.f67b;
        Stack stack = new Stack();
        stack.push(c0017e.f65p);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0016c c0016c = (C0016c) stack.peek();
                if ("path".equals(name)) {
                    C0015b c0015b = new C0015b();
                    c0015b.m33a(resources, attributeSet, theme, xmlPullParser);
                    c0016c.f37a.add(c0015b);
                    if (c0015b.m26b() != null) {
                        c0017e.f57g.put(c0015b.m26b(), c0015b);
                    }
                    obj2 = null;
                    c0018f.f66a = c0015b.o | c0018f.f66a;
                } else if ("clip-path".equals(name)) {
                    C0014a c0014a = new C0014a();
                    c0014a.m28a(resources, attributeSet, theme, xmlPullParser);
                    c0016c.f37a.add(c0014a);
                    if (c0014a.m26b() != null) {
                        c0017e.f57g.put(c0014a.m26b(), c0014a);
                    }
                    c0018f.f66a |= c0014a.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0016c c0016c2 = new C0016c();
                        c0016c2.m40a(resources, attributeSet, theme, xmlPullParser);
                        c0016c.f37a.add(c0016c2);
                        stack.push(c0016c2);
                        if (c0016c2.m39a() != null) {
                            c0017e.f57g.put(c0016c2.m39a(), c0016c2);
                        }
                        c0018f.f66a |= c0016c2.f47k;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    void m73a(boolean z) {
        this.f84g = z;
    }

    private boolean m68a() {
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f80c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
