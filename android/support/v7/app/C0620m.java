package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.C0569a.C0567b;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.widget.ag;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

class C0620m extends C0569a {
    private ag f1484a;
    private Callback f1485b;
    private boolean f1486c;
    private boolean f1487d;
    private ArrayList<C0567b> f1488e;
    private final Runnable f1489f;

    class C06171 implements Runnable {
        final /* synthetic */ C0620m f1480a;

        public void run() {
            this.f1480a.m2881i();
        }
    }

    private final class C0618a implements C0607a {
        final /* synthetic */ C0620m f1481a;
        private boolean f1482b;

        private C0618a(C0620m c0620m) {
            this.f1481a = c0620m;
        }

        public boolean a_(C0666f c0666f) {
            if (this.f1481a.f1485b == null) {
                return false;
            }
            this.f1481a.f1485b.onMenuOpened(108, c0666f);
            return true;
        }

        public void mo471a(C0666f c0666f, boolean z) {
            if (!this.f1482b) {
                this.f1482b = true;
                this.f1481a.f1484a.mo659n();
                if (this.f1481a.f1485b != null) {
                    this.f1481a.f1485b.onPanelClosed(108, c0666f);
                }
                this.f1482b = false;
            }
        }
    }

    private final class C0619b implements C0591a {
        final /* synthetic */ C0620m f1483a;

        private C0619b(C0620m c0620m) {
            this.f1483a = c0620m;
        }

        public boolean mo449a(C0666f c0666f, MenuItem menuItem) {
            return false;
        }

        public void mo445a(C0666f c0666f) {
            if (this.f1483a.f1485b == null) {
                return;
            }
            if (this.f1483a.f1484a.mo654i()) {
                this.f1483a.f1485b.onPanelClosed(108, c0666f);
            } else if (this.f1483a.f1485b.onPreparePanel(0, null, c0666f)) {
                this.f1483a.f1485b.onMenuOpened(108, c0666f);
            }
        }
    }

    void m2881i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.m2863j();
        r2 = r1 instanceof android.support.v7.view.menu.C0666f;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (android.support.v7.view.menu.C0666f) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.m3177g();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.f1485b;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.f1485b;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.m3178h();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.m3178h();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.m.i():void");
    }

    public void mo483b(boolean z) {
    }

    public void mo478a(float f) {
        android.support.v4.view.ag.m1804e(this.f1484a.mo635a(), f);
    }

    public Context mo485c() {
        return this.f1484a.mo644b();
    }

    public void mo486d(boolean z) {
    }

    public void mo487e(boolean z) {
    }

    public void mo479a(Configuration configuration) {
        super.mo479a(configuration);
    }

    public void mo480a(CharSequence charSequence) {
        this.f1484a.mo642a(charSequence);
    }

    public boolean mo491g() {
        ViewGroup a = this.f1484a.mo635a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m2866a(int i, int i2) {
        this.f1484a.mo647c((this.f1484a.mo660o() & (i2 ^ -1)) | (i & i2));
    }

    public void mo481a(boolean z) {
        m2866a(z ? 4 : 0, 4);
    }

    public int mo477a() {
        return this.f1484a.mo660o();
    }

    public boolean mo484b() {
        return this.f1484a.mo662q() == 0;
    }

    public boolean mo488e() {
        this.f1484a.mo635a().removeCallbacks(this.f1489f);
        android.support.v4.view.ag.m1787a(this.f1484a.mo635a(), this.f1489f);
        return true;
    }

    public boolean mo490f() {
        if (!this.f1484a.mo648c()) {
            return false;
        }
        this.f1484a.mo649d();
        return true;
    }

    public boolean mo482a(int i, KeyEvent keyEvent) {
        Menu j = m2863j();
        if (j != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            j.setQwertyMode(z);
            j.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    void mo492h() {
        this.f1484a.mo635a().removeCallbacks(this.f1489f);
    }

    public void mo489f(boolean z) {
        if (z != this.f1487d) {
            this.f1487d = z;
            int size = this.f1488e.size();
            for (int i = 0; i < size; i++) {
                ((C0567b) this.f1488e.get(i)).m2586a(z);
            }
        }
    }

    private Menu m2863j() {
        if (!this.f1486c) {
            this.f1484a.mo638a(new C0618a(), new C0619b());
            this.f1486c = true;
        }
        return this.f1484a.mo663r();
    }
}
