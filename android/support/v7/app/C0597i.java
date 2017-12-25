package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.C0595h.C0594a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0597i extends C0595h {
    private final UiModeManager f1430r;

    class C0596a extends C0594a {
        final /* synthetic */ C0597i f1429c;

        C0596a(C0597i c0597i, Callback callback) {
            this.f1429c = c0597i;
            super(c0597i, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.f1429c.mo466n()) {
                switch (i) {
                    case 0:
                        return m2811a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    C0597i(Context context, Window window, C0565d c0565d) {
        super(context, window, c0565d);
        this.f1430r = (UiModeManager) context.getSystemService("uimode");
    }

    Callback mo464a(Callback callback) {
        return new C0596a(this, callback);
    }

    int mo465d(int i) {
        if (i == 0 && this.f1430r.getNightMode() == 0) {
            return -1;
        }
        return super.mo465d(i);
    }
}
