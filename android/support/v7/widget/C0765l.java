package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p000a.p001a.C0006b;
import android.support.p000a.p001a.C0020f;
import android.support.v4.content.C0126a;
import android.support.v4.p002a.C0105a;
import android.support.v4.p002a.p003a.C0085a;
import android.support.v4.p008d.C0270a;
import android.support.v4.p008d.C0274e;
import android.support.v4.p008d.C0275f;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0557e;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class C0765l {
    private static final Mode f2292a = Mode.SRC_IN;
    private static C0765l f2293b;
    private static final C0763b f2294c = new C0763b(6);
    private static final int[] f2295d = new int[]{C0557e.abc_textfield_search_default_mtrl_alpha, C0557e.abc_textfield_default_mtrl_alpha, C0557e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] f2296e = new int[]{C0557e.abc_ic_ab_back_mtrl_am_alpha, C0557e.abc_ic_go_search_api_mtrl_alpha, C0557e.abc_ic_search_api_mtrl_alpha, C0557e.abc_ic_commit_search_api_mtrl_alpha, C0557e.abc_ic_clear_mtrl_alpha, C0557e.abc_ic_menu_share_mtrl_alpha, C0557e.abc_ic_menu_copy_mtrl_am_alpha, C0557e.abc_ic_menu_cut_mtrl_alpha, C0557e.abc_ic_menu_selectall_mtrl_alpha, C0557e.abc_ic_menu_paste_mtrl_am_alpha, C0557e.abc_ic_menu_moreoverflow_mtrl_alpha, C0557e.abc_ic_voice_search_api_mtrl_alpha};
    private static final int[] f2297f = new int[]{C0557e.abc_textfield_activated_mtrl_alpha, C0557e.abc_textfield_search_activated_mtrl_alpha, C0557e.abc_cab_background_top_mtrl_alpha, C0557e.abc_text_cursor_material};
    private static final int[] f2298g = new int[]{C0557e.abc_popup_background_mtrl_mult, C0557e.abc_cab_background_internal_bg, C0557e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] f2299h = new int[]{C0557e.abc_edit_text_material, C0557e.abc_tab_indicator_material, C0557e.abc_textfield_search_material, C0557e.abc_spinner_mtrl_am_alpha, C0557e.abc_spinner_textfield_background_material, C0557e.abc_ratingbar_full_material, C0557e.abc_switch_track_mtrl_alpha, C0557e.abc_switch_thumb_material, C0557e.abc_btn_default_mtrl_shape, C0557e.abc_btn_borderless_material};
    private static final int[] f2300i = new int[]{C0557e.abc_btn_check_material, C0557e.abc_btn_radio_material};
    private WeakHashMap<Context, SparseArray<ColorStateList>> f2301j;
    private C0270a<String, C0761c> f2302k;
    private SparseArray<String> f2303l;
    private final Object f2304m = new Object();
    private final WeakHashMap<Context, C0274e<WeakReference<ConstantState>>> f2305n = new WeakHashMap(0);
    private TypedValue f2306o;

    private interface C0761c {
        Drawable mo675a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class C0762a implements C0761c {
        private C0762a() {
        }

        public Drawable mo675a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0006b.m3a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class C0763b extends C0275f<Integer, PorterDuffColorFilter> {
        public C0763b(int i) {
            super(i);
        }

        PorterDuffColorFilter m3893a(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(C0763b.m3892b(i, mode)));
        }

        PorterDuffColorFilter m3894a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(C0763b.m3892b(i, mode)), porterDuffColorFilter);
        }

        private static int m3892b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    private static class C0764d implements C0761c {
        private C0764d() {
        }

        public Drawable mo675a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0020f.m66a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static C0765l m3902a() {
        if (f2293b == null) {
            f2293b = new C0765l();
            C0765l.m3906a(f2293b);
        }
        return f2293b;
    }

    private static void m3906a(C0765l c0765l) {
        int i = VERSION.SDK_INT;
        if (i < 23) {
            c0765l.m3907a("vector", new C0764d());
            if (i >= 11) {
                c0765l.m3907a("animated-vector", new C0762a());
            }
        }
    }

    public Drawable m3925a(Context context, int i) {
        return m3926a(context, i, false);
    }

    public Drawable m3926a(Context context, int i, boolean z) {
        Drawable d = m3915d(context, i);
        if (d == null) {
            d = m3913c(context, i);
        }
        if (d == null) {
            d = C0126a.m582a(context, i);
        }
        if (d != null) {
            d = m3900a(context, i, z, d);
        }
        if (d != null) {
            ah.m3593a(d);
        }
        return d;
    }

    private static long m3896a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable m3913c(Context context, int i) {
        if (this.f2306o == null) {
            this.f2306o = new TypedValue();
        }
        TypedValue typedValue = this.f2306o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0765l.m3896a(typedValue);
        Drawable a2 = m3901a(context, a);
        if (a2 == null) {
            if (i == C0557e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m3925a(context, C0557e.abc_cab_background_internal_bg), m3925a(context, C0557e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m3909a(context, a, a2);
            }
        }
        return a2;
    }

    private Drawable m3900a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m3928b(context, i);
        if (b != null) {
            if (ah.m3594b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0085a.m463f(drawable);
            C0085a.m454a(drawable, b);
            Mode a = m3924a(i);
            if (a == null) {
                return drawable;
            }
            C0085a.m457a(drawable, a);
            return drawable;
        } else if (i == C0557e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C0765l.m3904a(r0.findDrawableByLayerId(16908288), at.m3722a(context, C0553a.colorControlNormal), f2292a);
            C0765l.m3904a(r0.findDrawableByLayerId(16908303), at.m3722a(context, C0553a.colorControlNormal), f2292a);
            C0765l.m3904a(r0.findDrawableByLayerId(16908301), at.m3722a(context, C0553a.colorControlActivated), f2292a);
            return drawable;
        } else if (i == C0557e.abc_ratingbar_indicator_material || i == C0557e.abc_ratingbar_small_material) {
            r0 = (LayerDrawable) drawable;
            C0765l.m3904a(r0.findDrawableByLayerId(16908288), at.m3726c(context, C0553a.colorControlNormal), f2292a);
            C0765l.m3904a(r0.findDrawableByLayerId(16908303), at.m3722a(context, C0553a.colorControlActivated), f2292a);
            C0765l.m3904a(r0.findDrawableByLayerId(16908301), at.m3722a(context, C0553a.colorControlActivated), f2292a);
            return drawable;
        } else if (C0765l.m3908a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m3915d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f2302k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f2302k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f2303l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f2303l;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f2302k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r9.f2303l = r0;
    L_0x0036:
        r0 = r9.f2306o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f2306o = r0;
    L_0x0041:
        r2 = r9.f2306o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C0765l.m3896a(r2);
        r1 = r9.m3901a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f2303l;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2303l;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2302k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C0765l.C0761c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.mo675a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m3909a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m3901a(android.content.Context r5, long r6) {
        /*
        r4 = this;
        r2 = 0;
        r3 = r4.f2304m;
        monitor-enter(r3);
        r0 = r4.f2305n;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.p008d.C0274e) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.m1165a(r6);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0031;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r5.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0.m1169b(r6);	 Catch:{ all -> 0x002b }
    L_0x0031:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean m3909a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f2304m) {
            C0274e c0274e = (C0274e) this.f2305n.get(context);
            if (c0274e == null) {
                c0274e = new C0274e();
                this.f2305n.put(context, c0274e);
            }
            c0274e.m1170b(j, new WeakReference(constantState));
        }
        return true;
    }

    public final Drawable m3927a(Context context, ba baVar, int i) {
        Drawable d = m3915d(context, i);
        if (d == null) {
            d = baVar.m3802a(i);
        }
        if (d != null) {
            return m3900a(context, i, false, d);
        }
        return null;
    }

    static boolean m3908a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f2292a;
        if (C0765l.m3910a(f2295d, i)) {
            i2 = C0553a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0765l.m3910a(f2297f, i)) {
            i2 = C0553a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0765l.m3910a(f2298g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0557e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (ah.m3594b(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0765l.m3898a(at.m3722a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void m3907a(String str, C0761c c0761c) {
        if (this.f2302k == null) {
            this.f2302k = new C0270a();
        }
        this.f2302k.put(str, c0761c);
    }

    private static boolean m3910a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    final Mode m3924a(int i) {
        if (i == C0557e.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    public final ColorStateList m3928b(Context context, int i) {
        ColorStateList e = m3917e(context, i);
        if (e == null) {
            if (i == C0557e.abc_edit_text_material) {
                e = m3916e(context);
            } else if (i == C0557e.abc_switch_track_mtrl_alpha) {
                e = m3912c(context);
            } else if (i == C0557e.abc_switch_thumb_material) {
                e = m3914d(context);
            } else if (i == C0557e.abc_btn_default_mtrl_shape) {
                e = m3918f(context);
            } else if (i == C0557e.abc_btn_borderless_material) {
                e = m3920g(context);
            } else if (i == C0557e.abc_btn_colored_material) {
                e = m3921h(context);
            } else if (i == C0557e.abc_spinner_mtrl_am_alpha || i == C0557e.abc_spinner_textfield_background_material) {
                e = m3922i(context);
            } else if (C0765l.m3910a(f2296e, i)) {
                e = at.m3725b(context, C0553a.colorControlNormal);
            } else if (C0765l.m3910a(f2299h, i)) {
                e = m3897a(context);
            } else if (C0765l.m3910a(f2300i, i)) {
                e = m3911b(context);
            } else if (i == C0557e.abc_seekbar_thumb_material) {
                e = m3923j(context);
            }
            if (e != null) {
                m3903a(context, i, e);
            }
        }
        return e;
    }

    private ColorStateList m3917e(Context context, int i) {
        if (this.f2301j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f2301j.get(context);
        if (sparseArray != null) {
            return (ColorStateList) sparseArray.get(i);
        }
        return null;
    }

    private void m3903a(Context context, int i, ColorStateList colorStateList) {
        if (this.f2301j == null) {
            this.f2301j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f2301j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f2301j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private ColorStateList m3897a(Context context) {
        int a = at.m3722a(context, C0553a.colorControlNormal);
        int a2 = at.m3722a(context, C0553a.colorControlActivated);
        r2 = new int[7][];
        int[] iArr = new int[]{at.f2171a, at.m3726c(context, C0553a.colorControlNormal), at.f2172b, a2, at.f2173c, a2, at.f2174d};
        iArr[3] = a2;
        r2[4] = at.f2175e;
        iArr[4] = a2;
        r2[5] = at.f2176f;
        iArr[5] = a2;
        r2[6] = at.f2178h;
        iArr[6] = a;
        return new ColorStateList(r2, iArr);
    }

    private ColorStateList m3911b(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{at.f2171a, at.m3726c(context, C0553a.colorControlNormal), at.f2175e};
        iArr[1] = at.m3722a(context, C0553a.colorControlActivated);
        r0[2] = at.f2178h;
        iArr[2] = at.m3722a(context, C0553a.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3912c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{at.f2171a, at.m3723a(context, 16842800, 0.1f), at.f2175e};
        iArr[1] = at.m3723a(context, C0553a.colorControlActivated, 0.3f);
        r0[2] = at.f2178h;
        iArr[2] = at.m3723a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3914d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = at.m3725b(context, C0553a.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = at.f2171a;
            iArr2[0] = at.m3726c(context, C0553a.colorSwitchThumbNormal);
            iArr[1] = at.f2175e;
            iArr2[1] = at.m3722a(context, C0553a.colorControlActivated);
            iArr[2] = at.f2178h;
            iArr2[2] = at.m3722a(context, C0553a.colorSwitchThumbNormal);
        } else {
            iArr[0] = at.f2171a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = at.f2175e;
            iArr2[1] = at.m3722a(context, C0553a.colorControlActivated);
            iArr[2] = at.f2178h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList m3916e(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{at.f2171a, at.m3726c(context, C0553a.colorControlNormal), at.f2177g};
        iArr[1] = at.m3722a(context, C0553a.colorControlNormal);
        r0[2] = at.f2178h;
        iArr[2] = at.m3722a(context, C0553a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3918f(Context context) {
        return m3919f(context, at.m3722a(context, C0553a.colorButtonNormal));
    }

    private ColorStateList m3920g(Context context) {
        return m3919f(context, 0);
    }

    private ColorStateList m3921h(Context context) {
        return m3919f(context, at.m3722a(context, C0553a.colorAccent));
    }

    private ColorStateList m3919f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = at.m3722a(context, C0553a.colorControlHighlight);
        r0[0] = at.f2171a;
        r1[0] = at.m3726c(context, C0553a.colorButtonNormal);
        r0[1] = at.f2174d;
        r1[1] = C0105a.m505a(a, i);
        r0[2] = at.f2172b;
        r1[2] = C0105a.m505a(a, i);
        r0[3] = at.f2178h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m3922i(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{at.f2171a, at.m3726c(context, C0553a.colorControlNormal), at.f2177g};
        iArr[1] = at.m3722a(context, C0553a.colorControlNormal);
        r0[2] = at.f2178h;
        iArr[2] = at.m3722a(context, C0553a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList m3923j(Context context) {
        r0 = new int[2][];
        int[] iArr = new int[]{at.f2171a, at.m3726c(context, C0553a.colorControlActivated)};
        r0[1] = at.f2178h;
        iArr[1] = at.m3722a(context, C0553a.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    public static void m3905a(Drawable drawable, aw awVar, int[] iArr) {
        if (!ah.m3594b(drawable) || drawable.mutate() == drawable) {
            if (awVar.f2187d || awVar.f2186c) {
                drawable.setColorFilter(C0765l.m3899a(awVar.f2187d ? awVar.f2184a : null, awVar.f2186c ? awVar.f2185b : f2292a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static PorterDuffColorFilter m3899a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return C0765l.m3898a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static PorterDuffColorFilter m3898a(int i, Mode mode) {
        PorterDuffColorFilter a = f2294c.m3893a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f2294c.m3894a(i, mode, a);
        return a;
    }

    private static void m3904a(Drawable drawable, int i, Mode mode) {
        if (ah.m3594b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2292a;
        }
        drawable.setColorFilter(C0765l.m3898a(i, mode));
    }
}
