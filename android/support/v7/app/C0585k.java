package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.view.C0628b;
import android.support.v7.view.C0628b.C0610a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class C0585k extends Dialog implements C0565d {
    private C0587e f1379a;

    public C0585k(Context context, int i) {
        super(context, C0585k.m2681a(context, i));
        m2684b().mo444a(null);
        m2684b().mo439h();
    }

    protected void onCreate(Bundle bundle) {
        m2684b().mo460g();
        super.onCreate(bundle);
        m2684b().mo444a(bundle);
    }

    public void setContentView(int i) {
        m2684b().mo451b(i);
    }

    public void setContentView(View view) {
        m2684b().mo446a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m2684b().mo447a(view, layoutParams);
    }

    public View findViewById(int i) {
        return m2684b().mo441a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m2684b().mo435a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m2684b().mo435a(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m2684b().mo453b(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        m2684b().mo456c();
    }

    public boolean m2686c(int i) {
        return m2684b().mo457c(i);
    }

    public void invalidateOptionsMenu() {
        m2684b().mo459e();
    }

    public C0587e m2684b() {
        if (this.f1379a == null) {
            this.f1379a = C0587e.m2696a((Dialog) this, (C0565d) this);
        }
        return this.f1379a;
    }

    private static int m2681a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0553a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public void mo412a(C0628b c0628b) {
    }

    public void mo413b(C0628b c0628b) {
    }

    public C0628b mo411a(C0610a c0610a) {
        return null;
    }
}
