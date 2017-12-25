package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.bigroad.shared.C1129n;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0901j;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.ttb.android.C2224p;
import com.bigroad.ttb.android.C2476z.C2475a;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.fragment.UnassignedDrivingClaimer;
import com.bigroad.ttb.protocol.TTProtocol.EventChangeListEntry;
import com.bigroad.ttb.protocol.TTProtocol.EventChangeType;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class DailyLogGraphView extends View {
    private static final String[] f8391a = new String[]{"M", AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "N", AppEventsConstants.EVENT_PARAM_VALUE_YES, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    private final Path f8392A;
    private final Path f8393B;
    private final RectF f8394C;
    private final Path f8395D;
    private final Path f8396E;
    private final Path f8397F;
    private final Path f8398G;
    private final Path f8399H;
    private final RectF f8400I;
    private Calendar f8401J;
    private C0956v f8402K;
    private C0901j f8403L;
    private String[] f8404M;
    private String f8405N;
    private int f8406O;
    private Long f8407P;
    private int f8408Q;
    private boolean f8409R;
    private boolean f8410S;
    private List<C0890f> f8411T;
    private C2050b f8412U;
    private List<C1168m> f8413V;
    private boolean f8414W;
    private UnassignedDrivingClaimer aa;
    private Set<C3642c> ab;
    private float f8415b;
    private Paint f8416c;
    private Paint f8417d;
    private Paint f8418e;
    private Paint f8419f;
    private Paint f8420g;
    private Paint f8421h;
    private Paint f8422i;
    private Paint f8423j;
    private Paint f8424k;
    private Paint f8425l;
    private float f8426m;
    private float f8427n;
    private float[] f8428o;
    private float f8429p;
    private float f8430q;
    private float f8431r;
    private float f8432s;
    private float f8433t;
    private float f8434u;
    private float f8435v;
    private float f8436w;
    private Matrix f8437x;
    private Matrix f8438y;
    private Matrix f8439z;

    public interface C2050b {
        void mo1210a();

        void mo1211a(long j);
    }

    public class C2413a {
        final /* synthetic */ DailyLogGraphView f8384a;
        private DutyStatus f8385b;
        private int f8386c;
        private int f8387d;
        private boolean f8388e;
        private boolean f8389f;
        private boolean f8390g;

        public C2413a(DailyLogGraphView dailyLogGraphView, C2413a c2413a) {
            this.f8384a = dailyLogGraphView;
            this.f8385b = c2413a.m11832e();
            this.f8386c = c2413a.m11831d();
            this.f8387d = c2413a.m11830c();
            this.f8388e = c2413a.m11829b();
            this.f8389f = c2413a.m11833f();
            this.f8390g = c2413a.m11834g();
        }

        public C2413a(DailyLogGraphView dailyLogGraphView, DutyStatus dutyStatus, int i, int i2, boolean z, boolean z2, boolean z3) {
            this.f8384a = dailyLogGraphView;
            this.f8385b = dutyStatus;
            this.f8386c = i;
            this.f8387d = i2;
            this.f8388e = z;
            this.f8389f = z2;
            this.f8390g = z3;
        }

        public boolean m11827a() {
            return this.f8387d >= this.f8386c;
        }

        public boolean m11829b() {
            return this.f8388e;
        }

        public int m11830c() {
            return this.f8387d;
        }

        public int m11831d() {
            return this.f8386c;
        }

        public void m11826a(int i) {
            this.f8386c = i;
        }

        public void m11828b(int i) {
            this.f8387d = i;
        }

        public DutyStatus m11832e() {
            return this.f8385b;
        }

        public boolean m11833f() {
            return this.f8389f;
        }

        public boolean m11834g() {
            return this.f8390g;
        }
    }

    public DailyLogGraphView(Context context) {
        super(context);
        this.f8392A = new Path();
        this.f8393B = new Path();
        this.f8394C = new RectF();
        this.f8395D = new Path();
        this.f8396E = new Path();
        this.f8397F = new Path();
        this.f8398G = new Path();
        this.f8399H = new Path();
        this.f8400I = new RectF();
        this.f8406O = -1;
        this.f8408Q = -16777216;
        m11839a(context);
    }

    public DailyLogGraphView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dailyLogGraphStyle);
    }

    public DailyLogGraphView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8392A = new Path();
        this.f8393B = new Path();
        this.f8394C = new RectF();
        this.f8395D = new Path();
        this.f8396E = new Path();
        this.f8397F = new Path();
        this.f8398G = new Path();
        this.f8399H = new Path();
        this.f8400I = new RectF();
        this.f8406O = -1;
        this.f8408Q = -16777216;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.DailyLogGraphView, i, R.style.DailyLogGraphStyle);
        this.f8409R = obtainStyledAttributes.getBoolean(0, false);
        this.f8408Q = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        m11839a(context);
    }

    private void m11839a(Context context) {
        setLayerType(1, null);
        this.f8410S = false;
        this.f8411T = Collections.emptyList();
        this.f8413V = Collections.emptyList();
        this.ab = Collections.emptySet();
        if (isInEditMode()) {
            this.f8403L = C0901j.m4568a().m4564a(new C0956v("Canada/Eastern", true, false, false, false, 0, 0, 0, 0)).m4567a();
        } else {
            this.f8403L = C0901j.m4568a().m4564a(OurApplication.m6285g().m12228r()).m4567a();
        }
        m11847d();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f8415b = 10.0f * displayMetrics.scaledDensity;
        this.f8426m = 3.0f * displayMetrics.density;
        this.f8427n = displayMetrics.density * 5.0f;
        this.f8416c = new Paint();
        this.f8416c.setAntiAlias(true);
        this.f8416c.setTypeface(Typeface.DEFAULT_BOLD);
        this.f8416c.setColor(this.f8408Q);
        this.f8417d = new Paint();
        this.f8417d.setAntiAlias(false);
        this.f8417d.setStrokeWidth(1.0f);
        this.f8417d.setStrokeCap(Cap.SQUARE);
        this.f8417d.setStrokeJoin(Join.MITER);
        this.f8417d.setColor(this.f8408Q);
        this.f8418e = new Paint();
        this.f8418e.setAntiAlias(true);
        this.f8418e.setStyle(Style.STROKE);
        this.f8418e.setStrokeWidth(4.0f);
        this.f8418e.setStrokeCap(Cap.BUTT);
        this.f8418e.setStrokeJoin(Join.MITER);
        this.f8418e.setColor(-16729293);
        this.f8419f = new Paint();
        this.f8419f.setAntiAlias(true);
        this.f8419f.setStyle(Style.STROKE);
        this.f8419f.setStrokeWidth(4.0f);
        this.f8419f.setStrokeCap(Cap.ROUND);
        this.f8419f.setStrokeJoin(Join.MITER);
        this.f8419f.setColor(-16729293);
        this.f8419f.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.75f));
        this.f8424k = new Paint();
        this.f8424k.setAntiAlias(true);
        this.f8424k.setStyle(Style.STROKE);
        this.f8424k.setStrokeWidth(4.0f);
        this.f8424k.setStrokeCap(Cap.BUTT);
        this.f8424k.setStrokeJoin(Join.MITER);
        this.f8424k.setColor(-28107);
        this.f8420g = new Paint();
        this.f8420g.setAntiAlias(true);
        this.f8420g.setStyle(Style.FILL);
        this.f8420g.setColor(-4198913);
        this.f8421h = new Paint();
        this.f8421h.setAntiAlias(true);
        this.f8421h.setStyle(Style.STROKE);
        this.f8421h.setStrokeWidth(8.0f);
        this.f8421h.setStrokeCap(Cap.BUTT);
        this.f8421h.setColor(context.getResources().getColor(R.color.driveTimeViolation));
        this.f8422i = new Paint();
        this.f8422i.setAntiAlias(true);
        this.f8422i.setStyle(Style.STROKE);
        this.f8422i.setStrokeWidth(4.0f);
        this.f8422i.setStrokeCap(Cap.BUTT);
        this.f8422i.setStrokeJoin(Join.MITER);
        this.f8422i.setColor(-10037627);
        this.f8423j = new Paint();
        this.f8423j.setAntiAlias(true);
        this.f8423j.setStyle(Style.FILL);
        this.f8423j.setColor(-1597181482);
        this.f8425l = new Paint();
        this.f8425l.setAntiAlias(true);
        this.f8425l.setStyle(Style.STROKE);
        this.f8425l.setStrokeWidth(4.0f);
        this.f8425l.setStrokeCap(Cap.BUTT);
        this.f8425l.setStrokeJoin(Join.MITER);
        this.f8425l.setColor(-26849);
        this.f8437x = new Matrix();
        this.f8438y = new Matrix();
    }

    protected void onMeasure(int i, int i2) {
        float f = 0.0f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 0) {
            throw new IllegalArgumentException("Unspecified width is not supported.");
        }
        float f2;
        this.f8416c.setTextSize(Math.max(this.f8415b, ((float) size) * 0.0149f));
        this.f8430q = this.f8416c.ascent();
        this.f8428o = m11844a(f8391a);
        this.f8429p = (float) ((int) Math.ceil((double) (((-this.f8430q) + this.f8416c.descent()) + this.f8426m)));
        this.f8432s = this.f8416c.measureText("TOT");
        this.f8431r = Math.max(this.f8432s, this.f8416c.measureText("23:59"));
        this.f8433t = m11835a(this.f8416c);
        float paddingTop = (this.f8429p + ((float) getPaddingTop())) + ((float) getPaddingBottom());
        this.f8434u = Math.max(0.0f, ((float) size) - ((((this.f8433t + this.f8431r) + (this.f8427n * 2.0f)) + ((float) getPaddingLeft())) + ((float) getPaddingRight()))) / ((float) f8391a.length);
        if (getResources().getConfiguration().orientation == 2) {
            this.f8435v = Math.max(this.f8434u / 2.0f, this.f8429p);
        } else {
            this.f8435v = this.f8434u;
        }
        if (!this.f8403L.m4573c() || this.f8414W) {
            f2 = 0.0f;
        } else {
            f2 = this.f8435v / 2.0f;
        }
        this.f8436w = f2;
        this.f8437x.reset();
        this.f8437x.setScale(this.f8434u / BitmapDescriptorFactory.HUE_YELLOW, this.f8435v);
        this.f8437x.postTranslate(getGridHorizontalOffset(), ((float) getPaddingTop()) + this.f8429p);
        this.f8438y.set(this.f8437x);
        this.f8438y.postTranslate(0.0f, this.f8435v / 2.0f);
        f2 = ((this.f8409R ? this.f8435v - this.f8416c.descent() : 0.0f) + (this.f8436w + (this.f8435v * ((float) this.f8403L.m4571a(this.f8414W).size())))) + paddingTop;
        if (!this.ab.isEmpty()) {
            f = 7.0f;
        }
        setMeasuredDimension(size, (int) Math.ceil((double) (f2 + f)));
    }

    private Matrix getCorrectionsPathTrans() {
        if (this.f8439z == null) {
            this.f8439z = new Matrix();
            this.f8439z.setScale(this.f8434u / BitmapDescriptorFactory.HUE_YELLOW, 1.0f);
            this.f8439z.postTranslate(getGridHorizontalOffset(), 0.0f);
        }
        return this.f8439z;
    }

    private float m11835a(Paint paint) {
        float f = 0.0f;
        for (DutyStatus dutyStatus : DutyStatus.values()) {
            if (C1129n.m5708a(dutyStatus)) {
                f = Math.max(f, paint.measureText(C2224p.m10958a(getContext(), dutyStatus)));
            }
        }
        return f;
    }

    private float[] m11844a(String[] strArr) {
        float[] fArr = new float[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            fArr[i] = this.f8416c.measureText(strArr[i]);
        }
        return fArr;
    }

    private boolean m11843a(C3642c c3642c) {
        if (c3642c == null || this.ab.isEmpty()) {
            return false;
        }
        return this.ab.contains(c3642c);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f8392A.reset();
        this.f8393B.reset();
        this.f8398G.reset();
        this.f8394C.setEmpty();
        this.f8395D.reset();
        this.f8396E.reset();
        this.f8397F.reset();
        this.f8399H.reset();
        if (!this.f8411T.isEmpty()) {
            C0890f a;
            C2413a c2413a;
            C2413a c2413a2;
            float gridHorizontalOffset = getGridHorizontalOffset();
            float length = gridHorizontalOffset + (((float) f8391a.length) * this.f8434u);
            if (this.f8407P != null) {
                a = C0890f.m4500a(this.f8407P.longValue(), this.f8411T);
            } else {
                a = null;
            }
            List<C2413a> arrayList = new ArrayList();
            for (C0890f c0890f : this.f8411T) {
                c2413a = new C2413a(this, c0890f.mo702m(), c0890f.m4503a(this.f8401J), c0890f.m4506b(this.f8401J), m11842a(c0890f), a == c0890f, m11843a(C3642c.m19078a(c0890f.mo719s())));
                if (arrayList.isEmpty()) {
                    arrayList.add(c2413a);
                } else if (c2413a.m11829b()) {
                    c2413a2 = (C2413a) arrayList.get(arrayList.size() - 1);
                    if (c2413a.m11830c() >= c2413a2.m11830c()) {
                        c2413a.m11826a(c2413a2.m11830c());
                        arrayList.add(c2413a);
                    }
                } else {
                    c2413a2 = (C2413a) arrayList.remove(arrayList.size() - 1);
                    C2413a c2413a3 = new C2413a(this, c2413a2);
                    c2413a2.m11828b(c2413a.m11831d());
                    c2413a3.m11826a(c2413a.m11830c());
                    if (c2413a2.m11827a()) {
                        arrayList.add(c2413a2);
                    }
                    arrayList.add(c2413a);
                    if (c2413a3.m11827a()) {
                        arrayList.add(c2413a3);
                    }
                }
            }
            int a2 = this.f8403L.m4569a(DutyStatus.OFF_DUTY);
            c2413a2 = null;
            for (C2413a c2413a4 : arrayList) {
                int a3;
                DutyStatus dutyStatus;
                Object obj;
                DutyStatus e = c2413a4.m11832e();
                if (!c2413a4.m11829b() && e.m4397e()) {
                    a3 = this.f8403L.m4569a(DutyStatus.DRIVING);
                    this.f8398G.moveTo((float) c2413a4.m11831d(), (float) a3);
                    this.f8398G.lineTo((float) c2413a4.m11830c(), (float) a3);
                }
                if (e == DutyStatus.OFF_DUTY_WAITING && !this.f8403L.m4572b()) {
                    e = DutyStatus.OFF_DUTY;
                }
                if (e != DutyStatus.OFF_DUTY_DRIVING || (this.f8403L.m4573c() && !this.f8414W)) {
                    dutyStatus = e;
                    obj = null;
                } else {
                    dutyStatus = DutyStatus.OFF_DUTY;
                    obj = 1;
                }
                if (dutyStatus == DutyStatus.ELD_YARD_MOVE) {
                    dutyStatus = DutyStatus.ON_DUTY_NOT_DRIVING;
                    obj = 1;
                }
                int c = c2413a4.m11830c();
                if (dutyStatus == DutyStatus.OFF_DUTY_DRIVING) {
                    this.f8400I.set((float) c2413a4.m11831d(), (float) a2, (float) c, ((float) this.f8403L.m4569a(dutyStatus)) + 0.5f);
                    this.f8438y.mapRect(this.f8400I);
                    m11840a(this.f8400I, gridHorizontalOffset, length);
                    if (!c2413a4.m11833f()) {
                        this.f8397F.addRect(this.f8400I, Direction.CW);
                    }
                    this.f8396E.moveTo(this.f8400I.left, this.f8400I.bottom);
                    this.f8396E.lineTo(this.f8400I.right, this.f8400I.bottom);
                    dutyStatus = DutyStatus.OFF_DUTY;
                    obj = 1;
                }
                a3 = this.f8403L.m4569a(dutyStatus);
                if (c2413a2 == null) {
                    this.f8392A.moveTo((float) c2413a4.m11831d(), (float) a3);
                } else {
                    this.f8392A.lineTo((float) c2413a2.m11830c(), (float) a3);
                }
                if (obj != null) {
                    this.f8393B.moveTo((float) c2413a4.m11831d(), (float) a3);
                    this.f8393B.lineTo((float) c, (float) a3);
                    this.f8392A.moveTo((float) c, (float) a3);
                } else {
                    this.f8392A.lineTo((float) c, (float) a3);
                }
                if (c2413a4.m11834g()) {
                    float measuredHeight = (((float) (getMeasuredHeight() - getPaddingBottom())) - 7.0f) + 2.0f;
                    this.f8399H.moveTo((float) c2413a4.m11831d(), measuredHeight);
                    this.f8399H.lineTo((float) c2413a4.m11830c(), measuredHeight);
                }
                c2413a2 = c2413a4;
            }
            this.f8392A.transform(this.f8438y);
            this.f8393B.transform(this.f8438y);
            this.f8398G.transform(this.f8438y);
            if (!this.f8399H.isEmpty()) {
                this.f8399H.transform(getCorrectionsPathTrans());
            }
            if (a != null) {
                RectF rectF = this.f8400I;
                float a4 = (float) a.m4503a(this.f8401J);
                float b = (float) a.m4506b(this.f8401J);
                float size = (float) this.f8403L.m4571a(this.f8414W).size();
                float f = (!this.f8403L.m4573c() || this.f8414W) ? 0.0f : 0.5f;
                rectF.set(a4, 0.0f, b, f + size);
                this.f8437x.mapRect(this.f8394C, this.f8400I);
                m11840a(this.f8394C, gridHorizontalOffset, length);
            }
            for (C1168m c1168m : this.f8413V) {
                int a5 = this.f8403L.m4569a(DutyStatus.DRIVING);
                this.f8400I.set((float) m11836a(c1168m.m5940a().mo697f()), (float) a5, (float) m11836a(c1168m.m5940a().mo698g()), (float) a5);
                this.f8438y.mapRect(this.f8400I);
                m11840a(this.f8400I, gridHorizontalOffset, length);
                this.f8395D.moveTo(this.f8400I.left, this.f8400I.top);
                this.f8395D.lineTo(this.f8400I.right, this.f8400I.top);
            }
        }
    }

    private float getGridHorizontalOffset() {
        return (((float) getPaddingLeft()) + this.f8433t) + this.f8427n;
    }

    private int m11836a(long j) {
        return C0890f.m4497a(this.f8401J, aq.m4214a(j));
    }

    private void m11840a(RectF rectF, float f, float f2) {
        if (rectF.width() < 4.0f) {
            rectF.left -= 2.0f;
            rectF.right += 2.0f;
            if (rectF.left < f) {
                rectF.left = f;
                rectF.right = rectF.left + (2.0f * 2.0f);
            }
            if (rectF.right > f2) {
                rectF.right = f2;
                rectF.left = rectF.right - (2.0f * 2.0f);
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f8394C, this.f8420g);
        canvas.drawPath(this.f8399H, this.f8425l);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f8403L.m4571a(this.f8414W).size();
        float f = (((float) paddingLeft) + this.f8433t) + this.f8427n;
        float f2 = ((float) paddingTop) + this.f8429p;
        float length = f + (((float) f8391a.length) * this.f8434u);
        float f3 = f2 - this.f8426m;
        for (int i = 0; i <= f8391a.length; i++) {
            float round = (float) Math.round((((float) i) * this.f8434u) + f);
            canvas.drawLine(round, f3, round, f2, this.f8417d);
        }
        canvas.drawLine(f, f2, length, f2, this.f8417d);
        float f4 = f + (this.f8434u / 2.0f);
        float f5 = f + (this.f8434u / 4.0f);
        float f6 = f4 + (this.f8434u / 4.0f);
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            float f7 = f2 + (this.f8435v * ((float) i2));
            float f8 = f7 + this.f8435v;
            if (i2 + 1 == size) {
                f7 += this.f8436w;
                f8 += this.f8436w;
            }
            for (i3 = 0; i3 <= f8391a.length; i3++) {
                float round2 = (float) Math.round((((float) i3) * this.f8434u) + f);
                canvas.drawLine(round2, f7, round2, f8, this.f8417d);
            }
            canvas.drawLine(f, f8, length, f8, this.f8417d);
            for (i3 = 0; i3 < f8391a.length; i3++) {
                float f9;
                float f10;
                float round3 = (float) Math.round((((float) i3) * this.f8434u) + f4);
                float round4 = (float) Math.round((((float) i3) * this.f8434u) + f5);
                round2 = (float) Math.round((((float) i3) * this.f8434u) + f6);
                if (i2 > (size / 2) - 1) {
                    f9 = f8 - (this.f8435v * 0.66f);
                    round = f8 - (this.f8435v * 0.33f);
                    f10 = f8;
                } else {
                    f9 = f7 + (this.f8435v * 0.66f);
                    round = (this.f8435v * 0.33f) + f7;
                    f10 = f7;
                }
                canvas.drawLine(round3, f10, round3, f9, this.f8417d);
                canvas.drawLine(round4, f10, round4, round, this.f8417d);
                canvas.drawLine(round2, f10, round2, round, this.f8417d);
            }
        }
        f3 = ((float) paddingTop) - this.f8430q;
        for (i3 = 0; i3 < f8391a.length; i3++) {
            round = ((((float) i3) * this.f8434u) + f) - (this.f8428o[i3] / 2.0f);
            canvas.drawText(f8391a[i3], round, f3, this.f8416c);
        }
        for (int i4 = 0; i4 < size; i4++) {
            float f11 = ((((float) i4) * this.f8435v) + f2) + ((this.f8435v - this.f8430q) / 2.0f);
            if (i4 + 1 == size) {
                f11 += this.f8436w;
            }
            canvas.drawText(C2224p.m10958a(getContext(), this.f8403L.m4570a(i4)), (float) paddingLeft, f11, this.f8416c);
        }
        f4 = length + this.f8427n;
        Canvas canvas2 = canvas;
        canvas2.drawText("TOT", (this.f8427n + length) + ((this.f8431r - this.f8432s) / 2.0f), f3, this.f8416c);
        for (i3 = 0; i3 < this.f8404M.length; i3++) {
            String str = this.f8404M[i3];
            round4 = (this.f8431r + f4) - this.f8416c.measureText(str);
            round = ((((float) i3) * this.f8435v) + f2) + ((this.f8435v - this.f8430q) / 2.0f);
            if (i3 + 1 == this.f8404M.length) {
                round += this.f8436w;
            }
            canvas.drawText(str, round4, round, this.f8416c);
        }
        if (this.f8409R && !am.m4188a(this.f8405N)) {
            f11 = (this.f8431r + f4) - this.f8416c.measureText(this.f8405N);
            round = (((((float) this.f8404M.length) * this.f8435v) + f2) + ((this.f8435v - this.f8430q) / 2.0f)) + this.f8436w;
            canvas.drawText(this.f8405N, f11, round, this.f8416c);
        }
        canvas.drawPath(this.f8397F, this.f8423j);
        canvas.drawPath(this.f8396E, this.f8422i);
        canvas.drawPath(this.f8392A, this.f8418e);
        canvas.drawPath(this.f8393B, this.f8419f);
        canvas.drawPath(this.f8395D, this.f8421h);
        canvas.drawPath(this.f8398G, this.f8424k);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8412U == null) {
            return super.onTouchEvent(motionEvent);
        }
        int findPointerIndex;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f8406O = motionEvent.getPointerId(0);
                m11838a(motionEvent.getX(), motionEvent.getY());
                break;
            case 2:
                if (this.f8406O != -1) {
                    findPointerIndex = motionEvent.findPointerIndex(this.f8406O);
                    m11838a(motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex));
                    break;
                }
                break;
            case 6:
                if (this.f8406O != -1) {
                    findPointerIndex = motionEvent.findPointerIndex(this.f8406O);
                    if (findPointerIndex == motionEvent.getActionIndex()) {
                        m11838a(motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex));
                        this.f8406O = -1;
                        break;
                    }
                }
                break;
        }
        return true;
    }

    private void m11838a(float f, float f2) {
        if (this.f8410S) {
            if (!this.f8411T.isEmpty()) {
                Matrix matrix = new Matrix();
                this.f8437x.invert(matrix);
                float[] fArr = new float[2];
                matrix.mapPoints(fArr, new float[]{f, f2});
                int i = (int) fArr[0];
                int i2 = (int) fArr[1];
                if (i2 >= 0 && i2 < this.f8403L.m4571a(this.f8414W).size()) {
                    C0890f c0890f;
                    C0890f c0890f2 = null;
                    for (C0890f c0890f3 : this.f8411T) {
                        if (i < c0890f3.m4503a(this.f8401J) || i >= c0890f3.m4506b(this.f8401J) || (c0890f2 != null && (!m11842a(c0890f2) || m11842a(c0890f3)))) {
                            c0890f3 = c0890f2;
                        } else if (!m11842a(c0890f3)) {
                            break;
                        }
                        c0890f2 = c0890f3;
                    }
                    c0890f3 = c0890f2;
                    if (c0890f3 != null) {
                        setSelection(Long.valueOf(c0890f3.m4522q()));
                        if (this.f8412U != null) {
                            this.f8412U.mo1211a(c0890f3.m4522q());
                            return;
                        }
                        return;
                    }
                }
            }
            m11848a();
            if (this.f8412U != null) {
                this.f8412U.mo1210a();
            }
        }
    }

    private void m11845b() {
        C0956v c0956v = this.f8402K;
        if (c0956v == null) {
            c0956v = OurApplication.m6285g().m12228r();
        }
        this.f8403L = C0901j.m4568a().m4564a(c0956v).m4565a(this.f8411T).m4567a();
    }

    public void setHosSettings(C0956v c0956v) {
        this.f8402K = c0956v;
        m11846c();
    }

    public void setEventData(List<C0890f> list) {
        m11849a((List) list, null);
    }

    public void m11849a(List<C0890f> list, List<C1168m> list2) {
        m11850a((List) list, (List) list2, null);
    }

    public void m11850a(List<C0890f> list, List<C1168m> list2, UnassignedDrivingClaimer unassignedDrivingClaimer) {
        m11841a(list, list2, null, unassignedDrivingClaimer);
    }

    public void m11852b(List<C0890f> list, List<EventChangeListEntry> list2) {
        m11841a(list, null, list2, null);
    }

    private void m11841a(List<C0890f> list, List<C1168m> list2, List<EventChangeListEntry> list3, UnassignedDrivingClaimer unassignedDrivingClaimer) {
        this.aa = unassignedDrivingClaimer;
        this.f8411T = list;
        if (this.f8411T == null) {
            this.f8411T = Collections.emptyList();
        }
        this.f8413V = list2;
        if (this.f8413V == null) {
            this.f8413V = Collections.emptyList();
        }
        this.ab = m11837a((List) list3);
        m11846c();
    }

    private Set<C3642c> m11837a(List<EventChangeListEntry> list) {
        Set<C3642c> emptySet = Collections.emptySet();
        if (list == null || list.isEmpty()) {
            return emptySet;
        }
        Set<C3642c> hashSet = new HashSet();
        for (EventChangeListEntry eventChangeListEntry : list) {
            if (eventChangeListEntry.getType() != EventChangeType.UNKNOWN_EVENT_CHANGE) {
                hashSet.add(eventChangeListEntry.getEvent().getEventId());
            }
        }
        return hashSet;
    }

    private void m11846c() {
        if (this.f8411T.isEmpty()) {
            this.f8401J = null;
        } else {
            TimeZone b;
            int a = DailyLogUtils.m4283a(((C0890f) this.f8411T.get(0)).m4508c());
            if (this.f8402K == null) {
                b = OurApplication.m6285g().m12228r().m4868b();
            } else {
                b = this.f8402K.m4868b();
            }
            this.f8401J = DailyLogUtils.m4298a(a, b);
            if (this.f8407P != null && C0890f.m4500a(this.f8407P.longValue(), this.f8411T) == null) {
                this.f8407P = null;
            }
        }
        m11845b();
        m11847d();
        requestLayout();
        invalidate();
    }

    public void m11851a(boolean z) {
        this.f8410S = z;
        if (!this.f8410S) {
            m11848a();
        }
    }

    public void setSelection(Long l) {
        this.f8407P = l;
        requestLayout();
        invalidate();
    }

    public void m11848a() {
        if (this.f8407P != null) {
            this.f8407P = null;
            requestLayout();
            invalidate();
        }
    }

    public void setOnSelectionListener(C2050b c2050b) {
        this.f8412U = c2050b;
    }

    private void m11847d() {
        int size = this.f8403L.m4571a(this.f8414W).size();
        if (this.f8404M == null || this.f8404M.length != size) {
            this.f8404M = new String[size];
        }
        long j = 0;
        for (int i = 0; i < size; i++) {
            DutyStatus a = this.f8403L.m4570a(i);
            long a2 = C0890f.m4499a(this.f8411T, a);
            if (a == DutyStatus.OFF_DUTY) {
                a2 += C0890f.m4499a(this.f8411T, DutyStatus.OFF_DUTY_DRIVING);
            } else if (a == DutyStatus.ON_DUTY_NOT_DRIVING) {
                a2 += C0890f.m4499a(this.f8411T, DutyStatus.ELD_YARD_MOVE);
            }
            this.f8404M[i] = aq.m4232d(a2);
            j += a2;
        }
        this.f8405N = aq.m4232d(j);
    }

    public void setInspection(boolean z) {
        this.f8414W = z;
        m11846c();
    }

    private boolean m11842a(C0890f c0890f) {
        Long f = OurApplication.m6292n().m11020f();
        return f == null || c0890f.m4505a(f.longValue()) || this.aa == null || this.aa.m10415b(c0890f);
    }
}
