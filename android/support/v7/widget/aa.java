package android.support.v7.widget;

import android.content.Context;
import android.view.View;

class aa implements ad {
    aa() {
    }

    public void mo612a(ab abVar, Context context, int i, float f, float f2, float f3) {
        abVar.mo601a(new ao(i, f));
        View d = abVar.mo605d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        mo614b(abVar, f3);
    }

    public void mo610a(ab abVar, float f) {
        m3527i(abVar).m3659a(f);
    }

    public void mo609a() {
    }

    public void mo614b(ab abVar, float f) {
        m3527i(abVar).m3660a(f, abVar.mo602a(), abVar.mo603b());
        m3539f(abVar);
    }

    public float mo608a(ab abVar) {
        return m3527i(abVar).m3658a();
    }

    public float mo613b(ab abVar) {
        return mo617d(abVar) * 2.0f;
    }

    public float mo615c(ab abVar) {
        return mo617d(abVar) * 2.0f;
    }

    public float mo617d(ab abVar) {
        return m3527i(abVar).m3662b();
    }

    public void mo616c(ab abVar, float f) {
        abVar.mo605d().setElevation(f);
    }

    public float mo618e(ab abVar) {
        return abVar.mo605d().getElevation();
    }

    public void m3539f(ab abVar) {
        if (abVar.mo602a()) {
            float a = mo608a(abVar);
            float d = mo617d(abVar);
            int ceil = (int) Math.ceil((double) ap.m3665b(a, d, abVar.mo603b()));
            int ceil2 = (int) Math.ceil((double) ap.m3663a(a, d, abVar.mo603b()));
            abVar.mo600a(ceil, ceil2, ceil, ceil2);
            return;
        }
        abVar.mo600a(0, 0, 0, 0);
    }

    public void mo619g(ab abVar) {
        mo614b(abVar, mo608a(abVar));
    }

    public void mo620h(ab abVar) {
        mo614b(abVar, mo608a(abVar));
    }

    public void mo611a(ab abVar, int i) {
        m3527i(abVar).m3661a(i);
    }

    private ao m3527i(ab abVar) {
        return (ao) abVar.mo604c();
    }
}
