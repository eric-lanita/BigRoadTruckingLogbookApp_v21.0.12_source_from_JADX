package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.C0588i;
import android.support.v7.view.C0628b;
import android.support.v7.view.C0628b.C0610a;
import android.support.v7.view.C0648g;
import android.support.v7.view.menu.C0666f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class C0590f extends C0587e {
    final Context f1385a;
    final Window f1386b;
    final Callback f1387c = this.f1386b.getCallback();
    final Callback f1388d;
    final C0565d f1389e;
    C0569a f1390f;
    MenuInflater f1391g;
    boolean f1392h;
    boolean f1393i;
    boolean f1394j;
    boolean f1395k;
    boolean f1396l;
    private CharSequence f1397m;
    private boolean f1398n;

    class C0589a extends C0588i {
        final /* synthetic */ C0590f f1384a;

        C0589a(C0590f c0590f, Callback callback) {
            this.f1384a = c0590f;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1384a.mo450a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.f1384a.mo448a(keyEvent.getKeyCode(), keyEvent);
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0666f)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public void onContentChanged() {
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0666f c0666f;
            if (menu instanceof C0666f) {
                c0666f = (C0666f) menu;
            } else {
                c0666f = null;
            }
            if (i == 0 && c0666f == null) {
                return false;
            }
            if (c0666f != null) {
                c0666f.m3170c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0666f == null) {
                return onPreparePanel;
            }
            c0666f.m3170c(false);
            return onPreparePanel;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f1384a.mo455b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f1384a.mo442a(i, menu);
        }
    }

    abstract C0628b mo440a(C0610a c0610a);

    abstract void mo442a(int i, Menu menu);

    abstract boolean mo448a(int i, KeyEvent keyEvent);

    abstract boolean mo450a(KeyEvent keyEvent);

    abstract void mo454b(CharSequence charSequence);

    abstract boolean mo455b(int i, Menu menu);

    abstract void mo461k();

    C0590f(Context context, Window window, C0565d c0565d) {
        this.f1385a = context;
        this.f1386b = window;
        this.f1389e = c0565d;
        if (this.f1387c instanceof C0589a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1388d = mo464a(this.f1387c);
        this.f1386b.setCallback(this.f1388d);
    }

    Callback mo464a(Callback callback) {
        return new C0589a(this, callback);
    }

    public C0569a mo434a() {
        mo461k();
        return this.f1390f;
    }

    final C0569a m2733l() {
        return this.f1390f;
    }

    public MenuInflater mo436b() {
        if (this.f1391g == null) {
            mo461k();
            this.f1391g = new C0648g(this.f1390f != null ? this.f1390f.mo485c() : this.f1385a);
        }
        return this.f1391g;
    }

    final Context m2734m() {
        Context context = null;
        C0569a a = mo434a();
        if (a != null) {
            context = a.mo485c();
        }
        if (context == null) {
            return this.f1385a;
        }
        return context;
    }

    public void mo438f() {
        this.f1398n = true;
    }

    public boolean mo466n() {
        return false;
    }

    public boolean mo439h() {
        return false;
    }

    final boolean m2736o() {
        return this.f1398n;
    }

    final Callback m2737p() {
        return this.f1386b.getCallback();
    }

    public final void mo435a(CharSequence charSequence) {
        this.f1397m = charSequence;
        mo454b(charSequence);
    }

    public void mo437c(Bundle bundle) {
    }

    final CharSequence m2738q() {
        if (this.f1387c instanceof Activity) {
            return ((Activity) this.f1387c).getTitle();
        }
        return this.f1397m;
    }
}
