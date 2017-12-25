package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class C0737b extends Drawable {
    final ActionBarContainer f2214a;

    public C0737b(ActionBarContainer actionBarContainer) {
        this.f2214a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2214a.f1782d) {
            if (this.f2214a.f1779a != null) {
                this.f2214a.f1779a.draw(canvas);
            }
            if (this.f2214a.f1780b != null && this.f2214a.f1783e) {
                this.f2214a.f1780b.draw(canvas);
            }
        } else if (this.f2214a.f1781c != null) {
            this.f2214a.f1781c.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
