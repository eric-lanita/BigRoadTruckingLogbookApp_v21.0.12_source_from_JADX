package android.support.v4.p002a.p003a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p002a.p003a.C0096j.C0094a;

class C0100l extends C0096j {

    private static class C0099a extends C0094a {
        C0099a(C0094a c0094a, Resources resources) {
            super(c0094a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0100l(this, resources);
        }
    }

    C0100l(Drawable drawable) {
        super(drawable);
    }

    C0100l(C0094a c0094a, Resources resources) {
        super(c0094a, resources);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    C0094a mo73b() {
        return new C0099a(this.b, null);
    }
}
