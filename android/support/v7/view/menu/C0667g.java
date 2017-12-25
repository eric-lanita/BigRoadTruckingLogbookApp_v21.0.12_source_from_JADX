package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.app.C0586c;
import android.support.v7.app.C0586c.C0584a;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.view.menu.C0660l.C0607a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class C0667g implements OnClickListener, OnDismissListener, OnKeyListener, C0607a {
    C0665e f1717a;
    private C0666f f1718b;
    private C0586c f1719c;
    private C0607a f1720d;

    public C0667g(C0666f c0666f) {
        this.f1718b = c0666f;
    }

    public void m3190a(IBinder iBinder) {
        C0666f c0666f = this.f1718b;
        C0584a c0584a = new C0584a(c0666f.m3175e());
        this.f1717a = new C0665e(c0584a.m2658a(), C0560h.abc_list_menu_item_layout);
        this.f1717a.m3130a((C0607a) this);
        this.f1718b.m3155a(this.f1717a);
        c0584a.m2667a(this.f1717a.m3127a(), (OnClickListener) this);
        View o = c0666f.m3185o();
        if (o != null) {
            c0584a.m2665a(o);
        } else {
            c0584a.m2664a(c0666f.m3184n()).m2668a(c0666f.m3183m());
        }
        c0584a.m2663a((OnKeyListener) this);
        this.f1719c = c0584a.m2677b();
        this.f1719c.setOnDismissListener(this);
        LayoutParams attributes = this.f1719c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1719c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1719c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f1719c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1718b.m3159a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1718b.performShortcut(i, keyEvent, 0);
    }

    public void m3189a() {
        if (this.f1719c != null) {
            this.f1719c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1717a.mo542a(this.f1718b, true);
    }

    public void mo471a(C0666f c0666f, boolean z) {
        if (z || c0666f == this.f1718b) {
            m3189a();
        }
        if (this.f1720d != null) {
            this.f1720d.mo471a(c0666f, z);
        }
    }

    public boolean a_(C0666f c0666f) {
        if (this.f1720d != null) {
            return this.f1720d.a_(c0666f);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1718b.m3161a((C0669h) this.f1717a.m3127a().getItem(i), 0);
    }
}
