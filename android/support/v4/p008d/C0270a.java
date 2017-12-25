package android.support.v4.p008d;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C0270a<K, V> extends C0269h<K, V> implements Map<K, V> {
    C0267g<K, V> f797a;

    class C02681 extends C0267g<K, V> {
        final /* synthetic */ C0270a f789a;

        C02681(C0270a c0270a) {
            this.f789a = c0270a;
        }

        protected int mo169a() {
            return this.f789a.h;
        }

        protected Object mo171a(int i, int i2) {
            return this.f789a.g[(i << 1) + i2];
        }

        protected int mo170a(Object obj) {
            return this.f789a.m1143a(obj);
        }

        protected int mo175b(Object obj) {
            return this.f789a.m1148b(obj);
        }

        protected Map<K, V> mo176b() {
            return this.f789a;
        }

        protected void mo174a(K k, V v) {
            this.f789a.put(k, v);
        }

        protected V mo172a(int i, V v) {
            return this.f789a.m1145a(i, (Object) v);
        }

        protected void mo173a(int i) {
            this.f789a.m1151d(i);
        }

        protected void mo177c() {
            this.f789a.clear();
        }
    }

    public C0270a(int i) {
        super(i);
    }

    private C0267g<K, V> m1152b() {
        if (this.f797a == null) {
            this.f797a = new C02681(this);
        }
        return this.f797a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1146a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m1153a(Collection<?> collection) {
        return C0267g.m1116c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1152b().m1128d();
    }

    public Set<K> keySet() {
        return m1152b().m1129e();
    }

    public Collection<V> values() {
        return m1152b().m1130f();
    }
}
