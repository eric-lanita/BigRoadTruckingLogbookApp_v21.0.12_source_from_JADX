package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.ap.C0713a;

class ae extends ac {

    class C07151 implements C0713a {
        final /* synthetic */ ae f2028a;

        C07151(ae aeVar) {
            this.f2028a = aeVar;
        }

        public void mo621a(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    ae() {
    }

    public void mo609a() {
        ap.f2106c = new C07151(this);
    }
}
