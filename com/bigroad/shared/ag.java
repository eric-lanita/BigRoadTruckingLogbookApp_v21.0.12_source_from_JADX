package com.bigroad.shared;

import com.google.common.collect.C3537w;
import com.google.common.collect.MultimapBuilder;
import java.util.Iterator;

public class ag<T> {
    private final C3537w<Integer, T> f2619a = m4156a();

    public interface C0837a<T> {
        void mo896a(T t);
    }

    public void m4159a(T t, int i) {
        this.f2619a.mo2614a(Integer.valueOf(i), t);
    }

    public void m4158a(T t) {
        Iterator it = this.f2619a.mo2618h().iterator();
        while (it.hasNext()) {
            if (it.next().equals(t)) {
                it.remove();
            }
        }
    }

    public void m4157a(C0837a<T> c0837a) {
        if (!this.f2619a.mo2620m()) {
            for (Object a : this.f2619a.mo2618h().toArray()) {
                c0837a.mo896a(a);
            }
        }
    }

    static <K extends Comparable<? super K>, V> C3537w<K, V> m4156a() {
        return MultimapBuilder.m18671a().m18667b().mo2706b();
    }
}
