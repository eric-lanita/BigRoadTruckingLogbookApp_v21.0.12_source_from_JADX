package android.support.v4.p002a.p003a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.p002a.p003a.C0096j.C0094a;

class C0098k extends C0096j {

    private static class C0097a extends C0094a {
        C0097a(C0094a c0094a, Resources resources) {
            super(c0094a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0098k(this, resources);
        }
    }

    C0098k(Drawable drawable) {
        super(drawable);
    }

    C0098k(C0094a c0094a, Resources resources) {
        super(c0094a, resources);
    }

    C0094a mo73b() {
        return new C0097a(this.b, null);
    }

    protected Drawable mo72a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }
}
