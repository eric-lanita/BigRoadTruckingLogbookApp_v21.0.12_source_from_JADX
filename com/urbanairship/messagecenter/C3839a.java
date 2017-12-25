package com.urbanairship.messagecenter;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.C0569a;
import android.support.v7.app.C0587e;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class C3839a {
    private C0587e f13705a;

    C3839a() {
    }

    static C3839a m19973a(Activity activity) {
        C3839a c3839a = new C3839a();
        c3839a.f13705a = C0587e.m2695a(activity, null);
        return c3839a;
    }

    void m19977a(Bundle bundle) {
        if (this.f13705a != null) {
            this.f13705a.mo460g();
            this.f13705a.mo444a(bundle);
        }
    }

    void m19982b(Bundle bundle) {
        this.f13705a.mo452b(bundle);
    }

    MenuInflater m19974a() {
        return this.f13705a.mo436b();
    }

    void m19975a(int i) {
        this.f13705a.mo451b(i);
    }

    void m19978a(View view) {
        this.f13705a.mo446a(view);
    }

    void m19979a(View view, LayoutParams layoutParams) {
        this.f13705a.mo447a(view, layoutParams);
    }

    void m19983b(View view, LayoutParams layoutParams) {
        this.f13705a.mo453b(view, layoutParams);
    }

    void m19976a(Configuration configuration) {
        this.f13705a.mo443a(configuration);
    }

    void m19981b() {
        this.f13705a.mo458d();
    }

    void m19984c() {
        this.f13705a.mo456c();
    }

    void m19985d() {
        this.f13705a.mo459e();
    }

    void m19980a(CharSequence charSequence) {
        this.f13705a.mo435a(charSequence);
    }

    void m19986e() {
        this.f13705a.mo438f();
    }

    C0569a m19987f() {
        return this.f13705a.mo434a();
    }
}
