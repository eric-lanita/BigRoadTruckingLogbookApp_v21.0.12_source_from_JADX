package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p008d.C0270a;
import android.support.v4.view.ag;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.C0642d;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.C0654z;
import android.support.v7.widget.C0699f;
import android.support.v7.widget.C0756h;
import android.support.v7.widget.C0757i;
import android.support.v7.widget.C0758j;
import android.support.v7.widget.C0766m;
import android.support.v7.widget.C0767n;
import android.support.v7.widget.C0769p;
import android.support.v7.widget.C0773s;
import android.support.v7.widget.C0774t;
import android.support.v7.widget.C0775u;
import android.support.v7.widget.C0783w;
import android.support.v7.widget.av;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.analytics.ecommerce.Promotion;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

class C0616l {
    private static final Class<?>[] f1475a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] f1476b = new int[]{16843375};
    private static final String[] f1477c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> f1478d = new C0270a();
    private final Object[] f1479e = new Object[2];

    private static class C0615a implements OnClickListener {
        private final View f1471a;
        private final String f1472b;
        private Method f1473c;
        private Context f1474d;

        public C0615a(View view, String str) {
            this.f1471a = view;
            this.f1472b = str;
        }

        public void onClick(View view) {
            if (this.f1473c == null) {
                m2852a(this.f1471a.getContext(), this.f1472b);
            }
            try {
                this.f1473c.invoke(this.f1474d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        private void m2852a(Context context, String str) {
            Context context2 = context;
            while (context2 != null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.f1472b, new Class[]{View.class});
                        if (method != null) {
                            this.f1473c = method;
                            this.f1474d = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context2 instanceof ContextWrapper) {
                    context2 = ((ContextWrapper) context2).getBaseContext();
                } else {
                    context2 = null;
                }
            }
            int id = this.f1471a.getId();
            throw new IllegalStateException("Could not find method " + this.f1472b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f1471a.getClass() + (id == -1 ? "" : " with id '" + this.f1471a.getContext().getResources().getResourceEntryName(id) + "'"));
        }
    }

    C0616l() {
    }

    public final View m2857a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View view2;
        if (!z || view == null) {
            context2 = context;
        } else {
            context2 = view.getContext();
        }
        if (z2 || z3) {
            context2 = C0616l.m2853a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = av.m3729a(context2);
        }
        View view3 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                view3 = new C0654z(context2, attributeSet);
                break;
            case 1:
                view3 = new AppCompatImageView(context2, attributeSet);
                break;
            case 2:
                view3 = new C0756h(context2, attributeSet);
                break;
            case 3:
                view3 = new C0766m(context2, attributeSet);
                break;
            case 4:
                view3 = new C0783w(context2, attributeSet);
                break;
            case 5:
                view3 = new C0767n(context2, attributeSet);
                break;
            case 6:
                view3 = new C0757i(context2, attributeSet);
                break;
            case 7:
                view3 = new C0773s(context2, attributeSet);
                break;
            case 8:
                view3 = new C0758j(context2, attributeSet);
                break;
            case 9:
                view3 = new C0699f(context2, attributeSet);
                break;
            case 10:
                view3 = new C0769p(context2, attributeSet);
                break;
            case 11:
                view3 = new C0774t(context2, attributeSet);
                break;
            case 12:
                view3 = new C0775u(context2, attributeSet);
                break;
        }
        if (view3 != null || context == context2) {
            view2 = view3;
        } else {
            view2 = m2854a(context2, str, attributeSet);
        }
        if (view2 != null) {
            m2856a(view2, attributeSet);
        }
        return view2;
    }

    private View m2854a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals(Promotion.ACTION_VIEW)) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f1479e[0] = context;
            this.f1479e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f1477c) {
                    a = m2855a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f1479e[0] = null;
                this.f1479e[1] = null;
                return null;
            }
            a = m2855a(context, str, null);
            this.f1479e[0] = null;
            this.f1479e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f1479e[0] = null;
            this.f1479e[1] = null;
        }
    }

    private void m2856a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || ag.m1823w(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1476b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0615a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View m2855a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f1478d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1475a);
                f1478d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1479e);
    }

    private static Context m2853a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(C0563k.View_android_theme, 0);
        } else {
            resourceId = 0;
        }
        if (z2 && r0 == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0563k.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
            return context;
        }
        if ((context instanceof C0642d) && ((C0642d) context).m2993a() == i) {
            return context;
        }
        return new C0642d(context, i);
    }
}
