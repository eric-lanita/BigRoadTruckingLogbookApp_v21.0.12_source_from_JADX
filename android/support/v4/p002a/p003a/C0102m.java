package android.support.v4.p002a.p003a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p002a.p003a.C0096j.C0094a;

class C0102m extends C0100l {

    private static class C0101a extends C0094a {
        C0101a(C0094a c0094a, Resources resources) {
            super(c0094a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0102m(this, resources);
        }
    }

    C0102m(Drawable drawable) {
        super(drawable);
    }

    C0102m(C0094a c0094a, Resources resources) {
        super(c0094a, resources);
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    C0094a mo73b() {
        return new C0101a(this.b, null);
    }
}
