package android.support.p000a.p001a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.p002a.p003a.C0085a;
import android.support.v4.p008d.C0270a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public class C0006b extends C0005e implements Animatable {
    private C0002a f13b;
    private Context f14c;
    private ArgbEvaluator f15d;
    private final Callback f16e;

    class C00011 implements Callback {
        final /* synthetic */ C0006b f6a;

        C00011(C0006b c0006b) {
            this.f6a = c0006b;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f6a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f6a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f6a.unscheduleSelf(runnable);
        }
    }

    private static class C0002a extends ConstantState {
        int f7a;
        C0020f f8b;
        ArrayList<Animator> f9c;
        C0270a<Animator, String> f10d;

        public C0002a(Context context, C0002a c0002a, Callback callback, Resources resources) {
            int i = 0;
            if (c0002a != null) {
                this.f7a = c0002a.f7a;
                if (c0002a.f8b != null) {
                    ConstantState constantState = c0002a.f8b.getConstantState();
                    if (resources != null) {
                        this.f8b = (C0020f) constantState.newDrawable(resources);
                    } else {
                        this.f8b = (C0020f) constantState.newDrawable();
                    }
                    this.f8b = (C0020f) this.f8b.mutate();
                    this.f8b.setCallback(callback);
                    this.f8b.setBounds(c0002a.f8b.getBounds());
                    this.f8b.m73a(false);
                }
                if (c0002a.f9c != null) {
                    int size = c0002a.f9c.size();
                    this.f9c = new ArrayList(size);
                    this.f10d = new C0270a(size);
                    while (i < size) {
                        Animator animator = (Animator) c0002a.f9c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0002a.f10d.get(animator);
                        clone.setTarget(this.f8b.m72a(str));
                        this.f9c.add(clone);
                        this.f10d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public int getChangingConfigurations() {
            return this.f7a;
        }
    }

    private static class C0003b extends ConstantState {
        private final ConstantState f11a;

        public C0003b(ConstantState constantState) {
            this.f11a = constantState;
        }

        public Drawable newDrawable() {
            C0006b c0006b = new C0006b();
            c0006b.a = this.f11a.newDrawable();
            c0006b.a.setCallback(c0006b.f16e);
            return c0006b;
        }

        public Drawable newDrawable(Resources resources) {
            C0006b c0006b = new C0006b();
            c0006b.a = this.f11a.newDrawable(resources);
            c0006b.a.setCallback(c0006b.f16e);
            return c0006b;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            C0006b c0006b = new C0006b();
            c0006b.a = this.f11a.newDrawable(resources, theme);
            c0006b.a.setCallback(c0006b.f16e);
            return c0006b;
        }

        public boolean canApplyTheme() {
            return this.f11a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f11a.getChangingConfigurations();
        }
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

    private C0006b() {
        this(null, null, null);
    }

    private C0006b(Context context) {
        this(context, null, null);
    }

    private C0006b(Context context, C0002a c0002a, Resources resources) {
        this.f15d = null;
        this.f16e = new C00011(this);
        this.f14c = context;
        if (c0002a != null) {
            this.f13b = c0002a;
        } else {
            this.f13b = new C0002a(context, c0002a, this.f16e, resources);
        }
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    public static C0006b m3a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0006b c0006b = new C0006b(context);
        c0006b.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0006b;
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new C0003b(this.a.getConstantState());
        }
        return null;
    }

    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f13b.f7a;
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.f13b.f8b.draw(canvas);
        if (m6a()) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            this.f13b.f8b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        return this.f13b.f8b.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.a != null) {
            return this.a.setLevel(i);
        }
        return this.f13b.f8b.setLevel(i);
    }

    public int getAlpha() {
        if (this.a != null) {
            return C0085a.m460c(this.a);
        }
        return this.f13b.f8b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else {
            this.f13b.f8b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.f13b.f8b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0085a.m452a(this.a, i);
        } else {
            this.f13b.f8b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0085a.m454a(this.a, colorStateList);
        } else {
            this.f13b.f8b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0085a.m457a(this.a, mode);
        } else {
            this.f13b.f8b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.f13b.f8b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return this.f13b.f8b.isStateful();
    }

    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return this.f13b.f8b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return this.f13b.f8b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return this.f13b.f8b.getIntrinsicHeight();
    }

    static TypedArray m1a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            C0085a.m456a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = C0006b.m1a(resources, theme, attributeSet, C0000a.f4e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0020f a2 = C0020f.m65a(resources, resourceId, theme);
                        a2.m73a(false);
                        a2.setCallback(this.f16e);
                        if (this.f13b.f8b != null) {
                            this.f13b.f8b.setCallback(null);
                        }
                        this.f13b.f8b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, C0000a.f5f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f14c != null) {
                            m5a(string, AnimatorInflater.loadAnimator(this.f14c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            C0085a.m455a(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            return C0085a.m461d(this.a);
        }
        return false;
    }

    private void m4a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m4a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f15d == null) {
                    this.f15d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f15d);
            }
        }
    }

    private void m5a(String str, Animator animator) {
        animator.setTarget(this.f13b.f8b.m72a(str));
        if (VERSION.SDK_INT < 21) {
            m4a(animator);
        }
        if (this.f13b.f9c == null) {
            this.f13b.f9c = new ArrayList();
            this.f13b.f10d = new C0270a();
        }
        this.f13b.f9c.add(animator);
        this.f13b.f10d.put(animator, str);
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList arrayList = this.f13b.f9c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean m6a() {
        ArrayList arrayList = this.f13b.f9c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!m6a()) {
            ArrayList arrayList = this.f13b.f9c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList arrayList = this.f13b.f9c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
