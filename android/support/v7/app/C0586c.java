package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.C0583b.C0580a;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class C0586c extends C0585k implements DialogInterface {
    private C0583b f1380a;

    public static class C0584a {
        private final C0580a f1377a;
        private int f1378b;

        public C0584a(Context context) {
            this(context, C0586c.m2687a(context, 0));
        }

        public C0584a(Context context, int i) {
            this.f1377a = new C0580a(new ContextThemeWrapper(context, C0586c.m2687a(context, i)));
            this.f1378b = i;
        }

        public Context m2658a() {
            return this.f1377a.f1310a;
        }

        public C0584a m2659a(int i) {
            this.f1377a.f1315f = this.f1377a.f1310a.getText(i);
            return this;
        }

        public C0584a m2668a(CharSequence charSequence) {
            this.f1377a.f1315f = charSequence;
            return this;
        }

        public C0584a m2665a(View view) {
            this.f1377a.f1316g = view;
            return this;
        }

        public C0584a m2672b(int i) {
            this.f1377a.f1317h = this.f1377a.f1310a.getText(i);
            return this;
        }

        public C0584a m2675b(CharSequence charSequence) {
            this.f1377a.f1317h = charSequence;
            return this;
        }

        public C0584a m2678c(int i) {
            this.f1377a.f1312c = i;
            return this;
        }

        public C0584a m2664a(Drawable drawable) {
            this.f1377a.f1313d = drawable;
            return this;
        }

        public C0584a m2661a(int i, OnClickListener onClickListener) {
            this.f1377a.f1318i = this.f1377a.f1310a.getText(i);
            this.f1377a.f1319j = onClickListener;
            return this;
        }

        public C0584a m2669a(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1377a.f1318i = charSequence;
            this.f1377a.f1319j = onClickListener;
            return this;
        }

        public C0584a m2673b(int i, OnClickListener onClickListener) {
            this.f1377a.f1320k = this.f1377a.f1310a.getText(i);
            this.f1377a.f1321l = onClickListener;
            return this;
        }

        public C0584a m2676b(CharSequence charSequence, OnClickListener onClickListener) {
            this.f1377a.f1320k = charSequence;
            this.f1377a.f1321l = onClickListener;
            return this;
        }

        public C0584a m2679c(int i, OnClickListener onClickListener) {
            this.f1377a.f1322m = this.f1377a.f1310a.getText(i);
            this.f1377a.f1323n = onClickListener;
            return this;
        }

        public C0584a m2670a(boolean z) {
            this.f1377a.f1324o = z;
            return this;
        }

        public C0584a m2662a(OnCancelListener onCancelListener) {
            this.f1377a.f1325p = onCancelListener;
            return this;
        }

        public C0584a m2663a(OnKeyListener onKeyListener) {
            this.f1377a.f1327r = onKeyListener;
            return this;
        }

        public C0584a m2671a(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f1377a.f1328s = charSequenceArr;
            this.f1377a.f1330u = onClickListener;
            return this;
        }

        public C0584a m2667a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f1377a.f1329t = listAdapter;
            this.f1377a.f1330u = onClickListener;
            return this;
        }

        public C0584a m2660a(int i, int i2, OnClickListener onClickListener) {
            this.f1377a.f1328s = this.f1377a.f1310a.getResources().getTextArray(i);
            this.f1377a.f1330u = onClickListener;
            this.f1377a.f1302F = i2;
            this.f1377a.f1301E = true;
            return this;
        }

        public C0584a m2666a(ListAdapter listAdapter, int i, OnClickListener onClickListener) {
            this.f1377a.f1329t = listAdapter;
            this.f1377a.f1330u = onClickListener;
            this.f1377a.f1302F = i;
            this.f1377a.f1301E = true;
            return this;
        }

        public C0584a m2674b(View view) {
            this.f1377a.f1332w = view;
            this.f1377a.f1331v = 0;
            this.f1377a.f1298B = false;
            return this;
        }

        public C0586c m2677b() {
            C0586c c0586c = new C0586c(this.f1377a.f1310a, this.f1378b, false);
            this.f1377a.m2614a(c0586c.f1380a);
            c0586c.setCancelable(this.f1377a.f1324o);
            if (this.f1377a.f1324o) {
                c0586c.setCanceledOnTouchOutside(true);
            }
            c0586c.setOnCancelListener(this.f1377a.f1325p);
            c0586c.setOnDismissListener(this.f1377a.f1326q);
            if (this.f1377a.f1327r != null) {
                c0586c.setOnKeyListener(this.f1377a.f1327r);
            }
            return c0586c;
        }

        public C0586c m2680c() {
            C0586c b = m2677b();
            b.show();
            return b;
        }
    }

    protected C0586c(Context context) {
        this(context, C0586c.m2687a(context, 0), true);
    }

    C0586c(Context context, int i, boolean z) {
        super(context, C0586c.m2687a(context, i));
        this.f1380a = new C0583b(getContext(), this, getWindow());
    }

    static int m2687a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0553a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button m2689a(int i) {
        return this.f1380a.m2657d(i);
    }

    public ListView m2690a() {
        return this.f1380a.m2650b();
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1380a.m2648a(charSequence);
    }

    public void m2693a(CharSequence charSequence) {
        this.f1380a.m2653b(charSequence);
    }

    public void m2692a(View view) {
        this.f1380a.m2656c(view);
    }

    public void m2691a(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.f1380a.m2645a(i, charSequence, onClickListener, null);
    }

    public void m2694b(int i) {
        this.f1380a.m2651b(i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1380a.m2643a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1380a.m2649a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1380a.m2654b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
