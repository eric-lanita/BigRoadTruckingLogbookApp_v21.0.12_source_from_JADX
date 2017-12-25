package android.support.v7.widget;

import android.graphics.Outline;

class C0738c extends C0737b {
    public C0738c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1782d) {
            if (this.a.f1781c != null) {
                this.a.f1781c.getOutline(outline);
            }
        } else if (this.a.f1779a != null) {
            this.a.f1779a.getOutline(outline);
        }
    }
}
