package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p004b.p005a.C0233b;
import android.support.v4.view.C0434d.C0433b;
import android.support.v7.view.menu.C0674i.C0670a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
class C0676j extends C0674i {

    class C0675a extends C0670a implements VisibilityListener {
        C0433b f1754c;
        final /* synthetic */ C0676j f1755d;

        public C0675a(C0676j c0676j, Context context, ActionProvider actionProvider) {
            this.f1755d = c0676j;
            super(c0676j, context, actionProvider);
        }

        public View mo557a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public boolean mo559b() {
            return this.a.overridesItemVisibility();
        }

        public boolean mo560c() {
            return this.a.isVisible();
        }

        public void mo558a(C0433b c0433b) {
            VisibilityListener visibilityListener;
            this.f1754c = c0433b;
            ActionProvider actionProvider = this.a;
            if (c0433b == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1754c != null) {
                this.f1754c.mo548a(z);
            }
        }
    }

    C0676j(Context context, C0233b c0233b) {
        super(context, c0233b);
    }

    C0670a mo561a(ActionProvider actionProvider) {
        return new C0675a(this, this.a, actionProvider);
    }
}
