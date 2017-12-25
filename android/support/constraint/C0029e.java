package android.support.constraint;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.constraint.ConstraintLayout.C0022a;
import android.view.View;

public class C0029e extends View {
    private int f220a;
    private View f221b;
    private int f222c;

    public void setEmptyVisibility(int i) {
        this.f222c = i;
    }

    public int getEmptyVisibility() {
        return this.f222c;
    }

    public View getContent() {
        return this.f221b;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Align.LEFT);
            String str = "?";
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void m119a(ConstraintLayout constraintLayout) {
        if (this.f220a == -1 && !isInEditMode()) {
            setVisibility(this.f222c);
        }
        this.f221b = constraintLayout.findViewById(this.f220a);
        if (this.f221b != null) {
            ((C0022a) this.f221b.getLayoutParams()).aa = true;
            this.f221b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int i) {
        if (this.f220a != i) {
            if (this.f221b != null) {
                this.f221b.setVisibility(0);
                ((C0022a) this.f221b.getLayoutParams()).aa = false;
                this.f221b = null;
            }
            this.f220a = i;
            if (i != -1) {
                View findViewById = ((View) getParent()).findViewById(i);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
    }

    public void m120b(ConstraintLayout constraintLayout) {
        if (this.f221b != null) {
            C0022a c0022a = (C0022a) getLayoutParams();
            C0022a c0022a2 = (C0022a) this.f221b.getLayoutParams();
            c0022a2.al.m262d(0);
            c0022a.al.m269g(c0022a2.al.m268g());
            c0022a.al.m271h(c0022a2.al.m272i());
            c0022a2.al.m262d(8);
        }
    }
}
