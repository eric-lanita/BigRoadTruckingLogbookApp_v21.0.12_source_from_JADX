package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ap.C0713a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class ac implements ad {
    final RectF f2027a = new RectF();

    class C07141 implements C0713a {
        final /* synthetic */ ac f2026a;

        C07141(ac acVar) {
            this.f2026a = acVar;
        }

        public void mo621a(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                float f3 = f + 0.5f;
                this.f2026a.f2027a.set(-f3, -f3, f3, f3);
                int save = canvas.save();
                canvas.translate(rectF.left + f3, rectF.top + f3);
                canvas.drawArc(this.f2026a.f2027a, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2026a.f2027a, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2026a.f2027a, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(this.f2026a.f2027a, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, 1.0f + (rectF.right - f3), rectF.top + f3, paint);
                canvas.drawRect((rectF.left + f3) - 1.0f, 1.0f + (rectF.bottom - f3), 1.0f + (rectF.right - f3), rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, 1.0f + (rectF.bottom - f), paint);
        }
    }

    ac() {
    }

    public void mo609a() {
        ap.f2106c = new C07141(this);
    }

    public void mo612a(ab abVar, Context context, int i, float f, float f2, float f3) {
        Drawable a = m3544a(context, i, f, f2, f3);
        a.m3674a(abVar.mo603b());
        abVar.mo601a(a);
        m3557f(abVar);
    }

    private ap m3544a(Context context, int i, float f, float f2, float f3) {
        return new ap(context.getResources(), i, f, f2, f3);
    }

    public void m3557f(ab abVar) {
        Rect rect = new Rect();
        m3545i(abVar).m3673a(rect);
        abVar.mo599a((int) Math.ceil((double) mo613b(abVar)), (int) Math.ceil((double) mo615c(abVar)));
        abVar.mo600a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void mo619g(ab abVar) {
    }

    public void mo620h(ab abVar) {
        m3545i(abVar).m3674a(abVar.mo603b());
        m3557f(abVar);
    }

    public void mo611a(ab abVar, int i) {
        m3545i(abVar).m3672a(i);
    }

    public void mo610a(ab abVar, float f) {
        m3545i(abVar).m3670a(f);
        m3557f(abVar);
    }

    public float mo617d(ab abVar) {
        return m3545i(abVar).m3669a();
    }

    public void mo616c(ab abVar, float f) {
        m3545i(abVar).m3676b(f);
    }

    public float mo618e(ab abVar) {
        return m3545i(abVar).m3675b();
    }

    public void mo614b(ab abVar, float f) {
        m3545i(abVar).m3678c(f);
        m3557f(abVar);
    }

    public float mo608a(ab abVar) {
        return m3545i(abVar).m3677c();
    }

    public float mo613b(ab abVar) {
        return m3545i(abVar).m3679d();
    }

    public float mo615c(ab abVar) {
        return m3545i(abVar).m3680e();
    }

    private ap m3545i(ab abVar) {
        return (ap) abVar.mo604c();
    }
}
